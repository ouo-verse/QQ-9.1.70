package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class ResponsePacket {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 64;
    private static final int SECTION_ADDRESS = 1;
    private static final int SECTION_QUESTION = 0;
    private int flags;
    private String host;

    /* renamed from: in, reason: collision with root package name */
    private DNSInput f99902in;
    private int reqId;
    private int[] counts = new int[4];
    private long expireTime = 0;
    private byte[] label = new byte[64];
    private StringBuilder nameBuilder = new StringBuilder();
    private ArrayList[] sections = new ArrayList[4];

    public ResponsePacket(DNSInput dNSInput, String str) throws WireParseException, UnknownHostException, Exception {
        this.host = "";
        this.f99902in = dNSInput;
        this.host = str;
        initHeader();
        check(this.flags);
        parseAnswer();
    }

    private void check(int i3) throws UnknownHostException, Exception {
        String binaryString = Integer.toBinaryString(i3);
        if (binaryString.length() >= 4) {
            String substring = binaryString.substring(binaryString.length() - 4);
            if (!substring.equals("0011")) {
                if (substring.equals("0000")) {
                    return;
                }
                throw new Exception("exception cause [RCODE - " + substring + "][HOST - " + this.host + "]");
            }
            throw new UnknownHostException("Unable to resolve host \"" + this.host + "\": No address associated with hostname");
        }
        throw new Exception("exception cause [FBS - " + binaryString + "]");
    }

    private void initHeader() throws WireParseException {
        this.reqId = this.f99902in.readU16();
        this.flags = this.f99902in.readU16();
        int i3 = 0;
        while (true) {
            int[] iArr = this.counts;
            if (i3 < iArr.length) {
                iArr[i3] = this.f99902in.readU16();
                i3++;
            } else {
                return;
            }
        }
    }

    private void parseAnswer() throws WireParseException {
        for (int i3 = 0; i3 < 2; i3++) {
            try {
                int i16 = this.counts[i3];
                if (i16 > 0) {
                    this.sections[i3] = new ArrayList(i16);
                }
                for (int i17 = 0; i17 < i16; i17++) {
                    AnswerRecord answerRecord = new AnswerRecord();
                    if (i3 == 0) {
                        answerRecord.domain = retrieveName();
                        answerRecord.type = this.f99902in.readU16();
                        answerRecord.qclass = this.f99902in.readU16();
                        this.sections[i3].add(answerRecord);
                    } else {
                        retrieveName();
                        answerRecord.domain = this.host;
                        answerRecord.type = this.f99902in.readU16();
                        answerRecord.qclass = this.f99902in.readU16();
                        answerRecord.ttl = this.f99902in.readU32();
                        DNSInput dNSInput = this.f99902in;
                        dNSInput.setActive(dNSInput.readU16());
                        answerRecord.f99901ip = this.f99902in.readByteArray();
                        if (answerRecord.type == 1) {
                            setExpireTime(answerRecord.ttl);
                            this.sections[i3].add(answerRecord);
                        }
                    }
                }
            } catch (WireParseException e16) {
                throw e16;
            }
        }
    }

    private String retrieveName() throws WireParseException {
        if (this.nameBuilder.length() > 0) {
            StringBuilder sb5 = this.nameBuilder;
            sb5.delete(0, sb5.length());
        }
        boolean z16 = false;
        boolean z17 = false;
        while (!z16) {
            int readU8 = this.f99902in.readU8();
            int i3 = readU8 & 192;
            if (i3 != 0) {
                if (i3 == 192) {
                    int readU82 = this.f99902in.readU8() + ((readU8 & (-193)) << 8);
                    if (readU82 < this.f99902in.current() - 2) {
                        if (!z17) {
                            this.f99902in.save();
                            z17 = true;
                        }
                        this.f99902in.jump(readU82);
                    } else {
                        throw new WireParseException("bad compression");
                    }
                } else {
                    throw new WireParseException("bad label type");
                }
            } else if (readU8 == 0) {
                z16 = true;
            } else {
                this.f99902in.readByteArray(this.label, 0, readU8);
                this.nameBuilder.append(ByteBase.byteString(this.label, readU8));
                this.nameBuilder.append(".");
            }
        }
        if (z17) {
            this.f99902in.restore();
        }
        if (this.nameBuilder.length() > 0) {
            StringBuilder sb6 = this.nameBuilder;
            sb6.deleteCharAt(sb6.length() - 1);
        }
        return this.nameBuilder.toString();
    }

    private void setExpireTime(long j3) {
        if (this.expireTime == 0 && j3 > 0) {
            this.expireTime = System.currentTimeMillis() + (j3 * 1000);
        }
    }

    public ArrayList<AnswerRecord> getAnswers() {
        return this.sections[1];
    }

    public InetAddress[] getByAddress() {
        ArrayList arrayList = this.sections[1];
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < this.sections[1].size(); i3++) {
                AnswerRecord answerRecord = (AnswerRecord) this.sections[1].get(i3);
                try {
                    InetAddress byAddress = InetAddress.getByAddress(answerRecord.domain, answerRecord.f99901ip);
                    if (byAddress != null && byAddress.getHostName() != null && !byAddress.getHostName().equals(byAddress.getHostAddress())) {
                        arrayList2.add(byAddress);
                    }
                } catch (UnknownHostException e16) {
                    QDLog.e("ResponsePacket", "getByAddress>>>", e16);
                }
            }
            return (InetAddress[]) arrayList2.toArray(new InetAddress[arrayList2.size()]);
        }
        return null;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public int getReqId() {
        return this.reqId;
    }
}
