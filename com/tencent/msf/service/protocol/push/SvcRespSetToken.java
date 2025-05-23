package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SvcRespSetToken extends JceStruct {
    static ArrayList<Integer> cache_vTokenID = new ArrayList<>();
    static byte[] cache_vVoipCookie;
    public byte cReplyCode;
    public long lUin;
    public String strResult;
    public ArrayList<Integer> vTokenID;
    public byte[] vVoipCookie;

    static {
        cache_vTokenID.add(0);
        cache_vVoipCookie = r1;
        byte[] bArr = {0};
    }

    public SvcRespSetToken() {
        this.lUin = 0L;
        this.vTokenID = null;
        this.cReplyCode = (byte) 0;
        this.strResult = "";
        this.vVoipCookie = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.vTokenID = (ArrayList) jceInputStream.read((JceInputStream) cache_vTokenID, 1, true);
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 2, true);
        this.strResult = jceInputStream.readString(3, true);
        this.vVoipCookie = jceInputStream.read(cache_vVoipCookie, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write((Collection) this.vTokenID, 1);
        jceOutputStream.write(this.cReplyCode, 2);
        jceOutputStream.write(this.strResult, 3);
        byte[] bArr = this.vVoipCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
    }

    public SvcRespSetToken(long j3, ArrayList<Integer> arrayList, byte b16, String str, byte[] bArr) {
        this.lUin = j3;
        this.vTokenID = arrayList;
        this.cReplyCode = b16;
        this.strResult = str;
        this.vVoipCookie = bArr;
    }
}
