package com.qq.jce.wup;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class UniPacket extends UniAttribute {
    public static final int UniPacketHeadSize = 4;
    static HashMap<String, HashMap<String, byte[]>> cache__tempdata;
    static HashMap<String, byte[]> newCache__tempdata;
    protected RequestPacket _package;
    private int oldRespIret;

    public UniPacket() {
        RequestPacket requestPacket = new RequestPacket();
        this._package = requestPacket;
        this.oldRespIret = 0;
        requestPacket.iVersion = (short) 2;
    }

    private void parseBufferV2() {
        JceInputStream jceInputStream = new JceInputStream(this._package.sBuffer);
        jceInputStream.setServerEncoding(this.encodeName);
        if (cache__tempdata == null) {
            cache__tempdata = new HashMap<>();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put("", new byte[0]);
            cache__tempdata.put("", hashMap);
        }
        this._data = jceInputStream.readMap(cache__tempdata, 0, false);
        this.cachedClassName = new HashMap<>();
    }

    private void parseBufferV3() {
        JceInputStream jceInputStream = new JceInputStream(this._package.sBuffer);
        jceInputStream.setServerEncoding(this.encodeName);
        if (newCache__tempdata == null) {
            HashMap<String, byte[]> hashMap = new HashMap<>();
            newCache__tempdata = hashMap;
            hashMap.put("", new byte[0]);
        }
        this._newData = jceInputStream.readMap(newCache__tempdata, 0, false);
    }

    public byte[] createOldRespEncode() {
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.encodeName);
        jceOutputStream.write((Map) this._data, 0);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        JceOutputStream jceOutputStream2 = new JceOutputStream(0);
        jceOutputStream2.setServerEncoding(this.encodeName);
        jceOutputStream2.write(this._package.iVersion, 1);
        jceOutputStream2.write(this._package.cPacketType, 2);
        jceOutputStream2.write(this._package.iRequestId, 3);
        jceOutputStream2.write(this._package.iMessageType, 4);
        jceOutputStream2.write(this.oldRespIret, 5);
        jceOutputStream2.write(jceBufArray, 6);
        jceOutputStream2.write((Map) this._package.status, 7);
        return JceUtil.getJceBufArray(jceOutputStream2.getByteBuffer());
    }

    public UniPacket createResponse() {
        UniPacket uniPacket = new UniPacket();
        uniPacket.setRequestId(getRequestId());
        uniPacket.setServantName(getServantName());
        uniPacket.setFuncName(getFuncName());
        uniPacket.setEncodeName(this.encodeName);
        uniPacket._package.iVersion = this._package.iVersion;
        return uniPacket;
    }

    @Override // com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public void decode(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr, 4);
                jceInputStream.setServerEncoding(this.encodeName);
                this._package.readFrom(jceInputStream);
                if (this._package.iVersion == 3) {
                    parseBufferV3();
                    return;
                } else {
                    this._newData = null;
                    parseBufferV2();
                    return;
                }
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    @Override // com.qq.jce.wup.UniAttribute
    public void decodeVersion2(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr, 4);
                jceInputStream.setServerEncoding(this.encodeName);
                this._package.readFrom(jceInputStream);
                parseBufferV2();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    @Override // com.qq.jce.wup.UniAttribute
    public void decodeVersion3(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr, 4);
                jceInputStream.setServerEncoding(this.encodeName);
                this._package.readFrom(jceInputStream);
                parseBufferV3();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public void display(StringBuilder sb5, int i3) {
        this._package.display(sb5, i3);
    }

    @Override // com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public byte[] encode() {
        RequestPacket requestPacket = this._package;
        if (requestPacket.iVersion == 2) {
            String str = requestPacket.sServantName;
            if (str != null && !str.equals("")) {
                String str2 = this._package.sFuncName;
                if (str2 == null || str2.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (requestPacket.sServantName == null) {
                requestPacket.sServantName = "";
            }
            if (requestPacket.sFuncName == null) {
                requestPacket.sFuncName = "";
            }
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.encodeName);
        short s16 = this._package.iVersion;
        if (s16 != 2 && s16 != 1) {
            jceOutputStream.write((Map) this._newData, 0);
        } else {
            jceOutputStream.write((Map) this._data, 0);
        }
        this._package.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        JceOutputStream jceOutputStream2 = new JceOutputStream(0);
        jceOutputStream2.setServerEncoding(this.encodeName);
        this._package.writeTo(jceOutputStream2);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream2.getByteBuffer());
        int length = jceBufArray.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(jceBufArray).flip();
        return allocate.array();
    }

    public String getFuncName() {
        return this._package.sFuncName;
    }

    public int getOldRespIret() {
        return this.oldRespIret;
    }

    public int getPackageVersion() {
        return this._package.iVersion;
    }

    public int getRequestId() {
        return this._package.iRequestId;
    }

    public String getServantName() {
        return this._package.sServantName;
    }

    @Override // com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public <T> void put(String str, T t16) {
        if (!str.startsWith(".")) {
            super.put(str, t16);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this._package.readFrom(jceInputStream);
    }

    public void setFuncName(String str) {
        this._package.sFuncName = str;
    }

    public void setOldRespIret(int i3) {
        this.oldRespIret = i3;
    }

    public void setRequestId(int i3) {
        this._package.iRequestId = i3;
    }

    public void setServantName(String str) {
        this._package.sServantName = str;
    }

    @Override // com.qq.jce.wup.UniAttribute
    public void useVersion3() {
        super.useVersion3();
        this._package.iVersion = (short) 3;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        this._package.writeTo(jceOutputStream);
    }

    public UniPacket(boolean z16) {
        RequestPacket requestPacket = new RequestPacket();
        this._package = requestPacket;
        this.oldRespIret = 0;
        if (z16) {
            useVersion3();
        } else {
            requestPacket.iVersion = (short) 2;
        }
    }
}
