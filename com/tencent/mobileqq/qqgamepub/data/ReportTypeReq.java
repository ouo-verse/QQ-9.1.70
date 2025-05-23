package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class ReportTypeReq extends JceStruct {
    public String appid = "";

    /* renamed from: tt, reason: collision with root package name */
    public int f264495tt = 0;
    public int type = 0;
    public int subType = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.readString(0, false);
        this.f264495tt = jceInputStream.read(this.f264495tt, 1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        this.subType = jceInputStream.read(this.subType, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.appid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.f264495tt, 1);
        jceOutputStream.write(this.type, 2);
        jceOutputStream.write(this.subType, 3);
    }
}
