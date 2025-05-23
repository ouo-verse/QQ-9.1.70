package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.WireParseException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class Message implements Cloneable {
    public static final int MAXLENGTH = 65535;
    static final int TSIG_FAILED = 4;
    static final int TSIG_INTERMEDIATE = 2;
    static final int TSIG_SIGNED = 3;
    static final int TSIG_UNSIGNED = 0;
    static final int TSIG_VERIFIED = 1;
    private static final Record[] emptyRecordArray = new Record[0];
    private Header header;
    private Resolver resolver;
    private List<Record>[] sections;
    private int size;
    int tsigState;

    Message(Header header) {
        this.sections = new List[4];
        this.header = header;
    }

    public static Message newQuery(Record record) {
        Message message = new Message();
        message.header.setOpcode(0);
        message.header.setFlag(7);
        message.addRecord(record, 0);
        return message;
    }

    private static boolean sameSet(Record record, Record record2) {
        if (record.getRRsetType() == record2.getRRsetType() && record.getDClass() == record2.getDClass() && record.getName().equals(record2.getName())) {
            return true;
        }
        return false;
    }

    private int sectionToWire(DNSOutput dNSOutput, int i3, Compression compression, int i16) {
        int size = this.sections[i3].size();
        int current = dNSOutput.current();
        int i17 = 0;
        int i18 = 0;
        Record record = null;
        int i19 = 0;
        while (i17 < size) {
            Record record2 = this.sections[i3].get(i17);
            if (record != null && !sameSet(record2, record)) {
                current = dNSOutput.current();
                i18 = i19;
            }
            record2.toWire(dNSOutput, i3, compression);
            if (dNSOutput.current() > i16) {
                dNSOutput.jump(current);
                return size - i18;
            }
            i19++;
            i17++;
            record = record2;
        }
        return size - i19;
    }

    public void addRecord(Record record, int i3) {
        List<Record>[] listArr = this.sections;
        if (listArr[i3] == null) {
            listArr[i3] = new LinkedList();
        }
        this.header.incCount(i3);
        this.sections[i3].add(record);
    }

    public boolean findRRset(Name name, int i3, int i16) {
        if (this.sections[i16] == null) {
            return false;
        }
        for (int i17 = 0; i17 < this.sections[i16].size(); i17++) {
            Record record = this.sections[i16].get(i17);
            if (record.getType() == i3 && name.equals(record.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findRecord(Record record, int i3) {
        List<Record> list = this.sections[i3];
        return list != null && list.contains(record);
    }

    public Header getHeader() {
        return this.header;
    }

    public Record getQuestion() {
        List<Record> list = this.sections[0];
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public int getRcode() {
        return this.header.getRcode();
    }

    public Optional<Resolver> getResolver() {
        Optional<Resolver> ofNullable;
        ofNullable = Optional.ofNullable(this.resolver);
        return ofNullable;
    }

    public List<Record> getSection(int i3) {
        List<Record> list = this.sections[i3];
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    @Deprecated
    public Record[] getSectionArray(int i3) {
        List<Record> list = this.sections[i3];
        if (list == null) {
            return emptyRecordArray;
        }
        return (Record[]) list.toArray(new Record[0]);
    }

    public List<RRset> getSectionRRsets(int i3) {
        if (this.sections[i3] == null) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        for (Record record : getSection(i3)) {
            Name name = record.getName();
            boolean z16 = true;
            if (hashSet.contains(name)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    RRset rRset = (RRset) linkedList.get(size);
                    if (rRset.getType() == record.getRRsetType() && rRset.getDClass() == record.getDClass() && rRset.getName().equals(name)) {
                        rRset.addRR(record);
                        z16 = false;
                        break;
                    }
                    size--;
                }
            }
            if (z16) {
                linkedList.add(new RRset(record));
                hashSet.add(name);
            }
        }
        return linkedList;
    }

    public boolean isSigned() {
        int i3 = this.tsigState;
        if (i3 == 3 || i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    public boolean isVerified() {
        if (this.tsigState == 1) {
            return true;
        }
        return false;
    }

    public int numBytes() {
        return this.size;
    }

    public void removeAllRecords(int i3) {
        this.sections[i3] = null;
        this.header.setCount(i3, 0);
    }

    public boolean removeRecord(Record record, int i3) {
        List<Record> list = this.sections[i3];
        if (list != null && list.remove(record)) {
            this.header.decCount(i3);
            return true;
        }
        return false;
    }

    public String sectionToString(int i3) {
        if (i3 > 3) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sectionToString(sb5, i3);
        return sb5.toString();
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setResolver(Resolver resolver) {
        this.resolver = resolver;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.header);
        sb5.append('\n');
        if (isSigned()) {
            sb5.append(";; TSIG ");
            if (isVerified()) {
                sb5.append(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            } else {
                sb5.append(HippyReporter.RemoveEngineReason.INVALID);
            }
            sb5.append('\n');
        }
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.header.getOpcode() != 5) {
                sb5.append(";; ");
                sb5.append(Section.longString(i3));
                sb5.append(":\n");
            } else {
                sb5.append(";; ");
                sb5.append(Section.updString(i3));
                sb5.append(":\n");
            }
            sectionToString(sb5, i3);
            sb5.append("\n");
        }
        sb5.append(";; Message size: ");
        sb5.append(numBytes());
        sb5.append(" bytes");
        return sb5.toString();
    }

    void toWire(DNSOutput dNSOutput) {
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        int i3 = 0;
        while (true) {
            List<Record>[] listArr = this.sections;
            if (i3 >= listArr.length) {
                return;
            }
            List<Record> list = listArr[i3];
            if (list != null) {
                Iterator<Record> it = list.iterator();
                while (it.hasNext()) {
                    it.next().toWire(dNSOutput, i3, compression);
                }
            }
            i3++;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Message m241clone() throws CloneNotSupportedException {
        Message message = (Message) super.clone();
        message.sections = new List[this.sections.length];
        int i3 = 0;
        while (true) {
            List<Record>[] listArr = this.sections;
            if (i3 < listArr.length) {
                if (listArr[i3] != null) {
                    message.sections[i3] = new LinkedList(this.sections[i3]);
                }
                i3++;
            } else {
                message.header = this.header.m240clone();
                return message;
            }
        }
    }

    public boolean findRecord(Record record) {
        for (int i3 = 1; i3 <= 3; i3++) {
            List<Record> list = this.sections[i3];
            if (list != null && list.contains(record)) {
                return true;
            }
        }
        return false;
    }

    public Message(int i3) {
        this(new Header(i3));
    }

    private void sectionToString(StringBuilder sb5, int i3) {
        if (i3 > 3) {
            return;
        }
        for (Record record : getSection(i3)) {
            if (i3 == 0) {
                sb5.append(";;\t");
                sb5.append(record.name);
                sb5.append(", type = ");
                sb5.append(Type.string(record.type));
                sb5.append(", class = ");
                sb5.append(DClass.string(record.dclass));
            } else {
                sb5.append(record);
            }
            sb5.append("\n");
        }
    }

    public Message() {
        this(new Header());
    }

    public boolean findRRset(Name name, int i3) {
        return findRRset(name, i3, 1) || findRRset(name, i3, 2) || findRRset(name, i3, 3);
    }

    Message(DNSInput dNSInput) throws IOException {
        this(new Header(dNSInput));
        boolean z16 = this.header.getOpcode() == 5;
        boolean flag = this.header.getFlag(6);
        for (int i3 = 0; i3 < 4; i3++) {
            try {
                int count = this.header.getCount(i3);
                if (count > 0) {
                    this.sections[i3] = new ArrayList(count);
                }
                for (int i16 = 0; i16 < count; i16++) {
                    this.sections[i3].add(Record.fromWire(dNSInput, i3, z16));
                }
            } catch (WireParseException e16) {
                if (!flag) {
                    throw e16;
                }
            }
        }
        this.size = dNSInput.current();
    }

    private void toWire(DNSOutput dNSOutput, int i3) {
        if (i3 < 12) {
            return;
        }
        int current = dNSOutput.current();
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        int flagsByte = this.header.getFlagsByte();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= 4) {
                break;
            }
            if (this.sections[i16] != null) {
                int sectionToWire = sectionToWire(dNSOutput, i16, compression, i3);
                if (sectionToWire != 0 && i16 != 3) {
                    flagsByte = Header.setFlag(flagsByte, 6, true);
                    int count = this.header.getCount(i16) - sectionToWire;
                    int i18 = current + 4;
                    dNSOutput.writeU16At(count, (i16 * 2) + i18);
                    for (int i19 = i16 + 1; i19 < 3; i19++) {
                        dNSOutput.writeU16At(0, (i19 * 2) + i18);
                    }
                } else if (i16 == 3) {
                    i17 = this.header.getCount(i16) - sectionToWire;
                }
            }
            i16++;
        }
        if (flagsByte != this.header.getFlagsByte()) {
            dNSOutput.writeU16At(flagsByte, current + 2);
        }
        if (i17 != this.header.getCount(3)) {
            dNSOutput.writeU16At(i17, current + 10);
        }
    }

    public Message(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }

    public Message(ByteBuffer byteBuffer) throws IOException {
        this(new DNSInput(byteBuffer));
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }

    public byte[] toWire(int i3) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i3);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }
}
