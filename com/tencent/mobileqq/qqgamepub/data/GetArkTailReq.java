package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class GetArkTailReq extends JceStruct {
    public String appid = "";

    /* renamed from: tt, reason: collision with root package name */
    public int f264493tt = 0;
    public String qqVersion = "";
    public int sceneId = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.readString(0, false);
        this.f264493tt = jceInputStream.read(this.f264493tt, 1, false);
        this.qqVersion = jceInputStream.readString(2, false);
        this.sceneId = jceInputStream.read(this.sceneId, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.appid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.f264493tt, 1);
        String str2 = this.qqVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.sceneId, 3);
    }
}
