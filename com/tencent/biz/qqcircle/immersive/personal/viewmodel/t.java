package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t extends BaseViewModel {
    private final v C = new v();

    /* renamed from: i, reason: collision with root package name */
    private String f89175i;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f89176m;

    public String L1() {
        return this.f89175i;
    }

    public byte[] M1() {
        return this.f89176m;
    }

    public w N1() {
        return this.C.getValue();
    }

    public v O1() {
        return this.C;
    }

    public void P1(String str) {
        this.f89175i = str;
    }

    public void Q1(byte[] bArr) {
        this.f89176m = bArr;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSPersonalInfoViewModel";
    }
}
