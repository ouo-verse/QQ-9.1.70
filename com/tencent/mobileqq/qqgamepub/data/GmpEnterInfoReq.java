package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class GmpEnterInfoReq extends JceStruct {
    public long appid;

    /* renamed from: tt, reason: collision with root package name */
    public int f264494tt;
    public int version;

    public GmpEnterInfoReq() {
        this.appid = 0L;
        this.f264494tt = 0;
        this.version = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.f264494tt = jceInputStream.read(this.f264494tt, 1, false);
        this.version = jceInputStream.read(this.version, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.f264494tt, 1);
        jceOutputStream.write(this.version, 2);
    }

    public GmpEnterInfoReq(long j3, int i3, int i16) {
        this.appid = j3;
        this.f264494tt = i3;
        this.version = i16;
    }
}
