package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class RequestCustomSig extends JceStruct {
    static Map<String, String> cache_customSigPara;
    static byte[] cache_reserved;
    public Map<String, String> customSigPara;
    public long nlTestFlag;
    public byte[] reserved;
    public long ulCustumFlag;
    public long ulSType;

    public RequestCustomSig() {
        this.ulCustumFlag = 0L;
        this.ulSType = 0L;
        this.reserved = null;
        this.customSigPara = null;
        this.nlTestFlag = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ulCustumFlag = jceInputStream.read(this.ulCustumFlag, 0, true);
        this.ulSType = jceInputStream.read(this.ulSType, 1, true);
        if (cache_reserved == null) {
            cache_reserved = r0;
            byte[] bArr = {0};
        }
        this.reserved = jceInputStream.read(cache_reserved, 2, true);
        if (cache_customSigPara == null) {
            HashMap hashMap = new HashMap();
            cache_customSigPara = hashMap;
            hashMap.put("", "");
        }
        this.customSigPara = (Map) jceInputStream.read((JceInputStream) cache_customSigPara, 3, false);
        this.nlTestFlag = jceInputStream.read(this.nlTestFlag, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ulCustumFlag, 0);
        jceOutputStream.write(this.ulSType, 1);
        jceOutputStream.write(this.reserved, 2);
        Map<String, String> map = this.customSigPara;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.nlTestFlag, 4);
    }

    public RequestCustomSig(long j3, long j16, byte[] bArr, Map<String, String> map, long j17) {
        this.ulCustumFlag = j3;
        this.ulSType = j16;
        this.reserved = bArr;
        this.customSigPara = map;
        this.nlTestFlag = j17;
    }
}
