package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class RespondCustomSig extends JceStruct {
    static ArrayList<CustomSigContent> cache_SigList;
    static byte[] cache_reserved;
    public ArrayList<CustomSigContent> SigList;
    public byte[] reserved;
    public long ulCustumFlag;
    public long ulSType;

    public RespondCustomSig() {
        this.ulCustumFlag = 0L;
        this.ulSType = 0L;
        this.SigList = null;
        this.reserved = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ulCustumFlag = jceInputStream.read(this.ulCustumFlag, 0, true);
        this.ulSType = jceInputStream.read(this.ulSType, 1, true);
        if (cache_SigList == null) {
            cache_SigList = new ArrayList<>();
            cache_SigList.add(new CustomSigContent());
        }
        this.SigList = (ArrayList) jceInputStream.read((JceInputStream) cache_SigList, 2, true);
        if (cache_reserved == null) {
            cache_reserved = r0;
            byte[] bArr = {0};
        }
        this.reserved = jceInputStream.read(cache_reserved, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ulCustumFlag, 0);
        jceOutputStream.write(this.ulSType, 1);
        jceOutputStream.write((Collection) this.SigList, 2);
        jceOutputStream.write(this.reserved, 3);
    }

    public RespondCustomSig(long j3, long j16, ArrayList<CustomSigContent> arrayList, byte[] bArr) {
        this.ulCustumFlag = j3;
        this.ulSType = j16;
        this.SigList = arrayList;
        this.reserved = bArr;
    }
}
