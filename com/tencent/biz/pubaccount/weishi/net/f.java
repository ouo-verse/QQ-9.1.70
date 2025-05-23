package com.tencent.biz.pubaccount.weishi.net;

import com.qq.jce.wup.UniAttribute;
import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends UniAttribute {

    /* renamed from: c, reason: collision with root package name */
    static HashMap<String, byte[]> f80965c;

    /* renamed from: d, reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f80966d;

    /* renamed from: a, reason: collision with root package name */
    protected RequestPacket f80967a;

    /* renamed from: b, reason: collision with root package name */
    private int f80968b;

    public f() {
        RequestPacket requestPacket = new RequestPacket();
        this.f80967a = requestPacket;
        this.f80968b = 0;
        requestPacket.iVersion = (short) 2;
    }

    private void parseBufferV2() {
        JceInputStream jceInputStream = new JceInputStream(this.f80967a.sBuffer);
        jceInputStream.setServerEncoding(this.encodeName);
        if (f80966d == null) {
            f80966d = new HashMap<>();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put("", new byte[0]);
            f80966d.put("", hashMap);
        }
        this._data = jceInputStream.readMap(f80966d, 0, false);
        this.cachedClassName = new HashMap<>();
    }

    private void parseBufferV3() {
        JceInputStream jceInputStream = new JceInputStream(this.f80967a.sBuffer);
        jceInputStream.setServerEncoding(this.encodeName);
        if (f80965c == null) {
            HashMap<String, byte[]> hashMap = new HashMap<>();
            f80965c = hashMap;
            hashMap.put("", new byte[0]);
        }
        this._newData = jceInputStream.readMap(f80965c, 0, false);
    }

    public void a(int i3) {
        this.f80967a.iTimeout = i3;
    }

    @Override // com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public void decode(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr, 4);
                jceInputStream.setServerEncoding(this.encodeName);
                this.f80967a.readFrom(jceInputStream);
                if (this.f80967a.iVersion == 3) {
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
                this.f80967a.readFrom(jceInputStream);
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
                this.f80967a.readFrom(jceInputStream);
                parseBufferV3();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    @Override // com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public byte[] encode() {
        RequestPacket requestPacket = this.f80967a;
        if (requestPacket.iVersion == 2) {
            String str = requestPacket.sServantName;
            if (str != null && !str.equals("")) {
                String str2 = this.f80967a.sFuncName;
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
        short s16 = this.f80967a.iVersion;
        if (s16 != 2 && s16 != 1) {
            jceOutputStream.write((Map) this._newData, 0);
        } else {
            jceOutputStream.write((Map) this._data, 0);
        }
        this.f80967a.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        JceOutputStream jceOutputStream2 = new JceOutputStream(0);
        jceOutputStream2.setServerEncoding(this.encodeName);
        this.f80967a.writeTo(jceOutputStream2);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream2.getByteBuffer());
        int length = jceBufArray.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(jceBufArray).flip();
        return allocate.array();
    }

    @Override // com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public <T> void put(String str, T t16) {
        if (!str.startsWith(".")) {
            super.put(str, t16);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public void setFuncName(String str) {
        this.f80967a.sFuncName = str;
    }

    public void setRequestId(int i3) {
        this.f80967a.iRequestId = i3;
    }

    public void setServantName(String str) {
        this.f80967a.sServantName = str;
    }

    @Override // com.qq.jce.wup.UniAttribute
    public void useVersion3() {
        super.useVersion3();
        this.f80967a.iVersion = (short) 3;
    }
}
