package com.qq.taf;

import com.qq.jce.wup.WupHexUtil;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class RequestPacket extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, String> cache_context;
    static byte[] cache_sBuffer;
    public byte cPacketType;
    public Map<String, String> context;
    public int iMessageType;
    public int iRequestId;
    public int iTimeout;
    public short iVersion;
    public byte[] sBuffer;
    public String sFuncName;
    public String sServantName;
    public Map<String, String> status;

    public RequestPacket() {
        this.iVersion = (short) 0;
        this.cPacketType = (byte) 0;
        this.iMessageType = 0;
        this.iRequestId = 0;
        this.sServantName = null;
        this.sFuncName = null;
        this.iTimeout = 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.iVersion, "iVersion");
        jceDisplayer.display(this.cPacketType, "cPacketType");
        jceDisplayer.display(this.iMessageType, "iMessageType");
        jceDisplayer.display(this.iRequestId, "iRequestId");
        jceDisplayer.display(this.sServantName, "sServantName");
        jceDisplayer.display(this.sFuncName, "sFuncName");
        jceDisplayer.display(this.sBuffer, "sBuffer");
        jceDisplayer.display(this.iTimeout, "iTimeout");
        jceDisplayer.display((Map) this.context, "context");
        jceDisplayer.display((Map) this.status, "status");
    }

    public boolean equals(Object obj) {
        RequestPacket requestPacket = (RequestPacket) obj;
        if (JceUtil.equals(1, (int) requestPacket.iVersion) && JceUtil.equals(1, (int) requestPacket.cPacketType) && JceUtil.equals(1, requestPacket.iMessageType) && JceUtil.equals(1, requestPacket.iRequestId) && JceUtil.equals((Object) 1, (Object) requestPacket.sServantName) && JceUtil.equals((Object) 1, (Object) requestPacket.sFuncName) && JceUtil.equals((Object) 1, (Object) requestPacket.sBuffer) && JceUtil.equals(1, requestPacket.iTimeout) && JceUtil.equals((Object) 1, (Object) requestPacket.context) && JceUtil.equals((Object) 1, (Object) requestPacket.status)) {
            return true;
        }
        return false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        try {
            this.iVersion = jceInputStream.read(this.iVersion, 1, true);
            this.cPacketType = jceInputStream.read(this.cPacketType, 2, true);
            this.iMessageType = jceInputStream.read(this.iMessageType, 3, true);
            this.iRequestId = jceInputStream.read(this.iRequestId, 4, true);
            this.sServantName = jceInputStream.readString(5, true);
            this.sFuncName = jceInputStream.readString(6, true);
            if (cache_sBuffer == null) {
                cache_sBuffer = new byte[]{0};
            }
            this.sBuffer = jceInputStream.read(cache_sBuffer, 7, true);
            this.iTimeout = jceInputStream.read(this.iTimeout, 8, true);
            if (cache_context == null) {
                HashMap hashMap = new HashMap();
                cache_context = hashMap;
                hashMap.put("", "");
            }
            this.context = (Map) jceInputStream.read((JceInputStream) cache_context, 9, true);
            if (cache_context == null) {
                HashMap hashMap2 = new HashMap();
                cache_context = hashMap2;
                hashMap2.put("", "");
            }
            this.status = (Map) jceInputStream.read((JceInputStream) cache_context, 10, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            System.out.println("RequestPacket decode error " + WupHexUtil.bytes2HexStr(this.sBuffer));
            throw new RuntimeException(e16);
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iVersion, 1);
        jceOutputStream.write(this.cPacketType, 2);
        jceOutputStream.write(this.iMessageType, 3);
        jceOutputStream.write(this.iRequestId, 4);
        jceOutputStream.write(this.sServantName, 5);
        jceOutputStream.write(this.sFuncName, 6);
        jceOutputStream.write(this.sBuffer, 7);
        jceOutputStream.write(this.iTimeout, 8);
        jceOutputStream.write((Map) this.context, 9);
        jceOutputStream.write((Map) this.status, 10);
    }

    public RequestPacket(short s16, byte b16, int i3, int i16, String str, String str2, byte[] bArr, int i17, Map<String, String> map, Map<String, String> map2) {
        this.iVersion = s16;
        this.cPacketType = b16;
        this.iMessageType = i3;
        this.iRequestId = i16;
        this.sServantName = str;
        this.sFuncName = str2;
        this.sBuffer = bArr;
        this.iTimeout = i17;
        this.context = map;
        this.status = map2;
    }
}
