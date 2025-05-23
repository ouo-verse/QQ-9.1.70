package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProArkArg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class an implements de {

    /* renamed from: a, reason: collision with root package name */
    private GProArkArg f265683a;

    public an(GProArkArg gProArkArg) {
        this.f265683a = gProArkArg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.de
    public String a() {
        return this.f265683a.getMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.de
    public String b() {
        return this.f265683a.getVer();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof an)) {
            return false;
        }
        return this.f265683a.equals(((an) obj).f265683a);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.de
    public String getApp() {
        return this.f265683a.getApp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.de
    public String getConfig() {
        return this.f265683a.getConfig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.de
    public String getDesc() {
        return this.f265683a.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.de
    public String getPrompt() {
        return this.f265683a.getPrompt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.de
    public String getView() {
        return this.f265683a.getView();
    }

    public int hashCode() {
        return this.f265683a.hashCode();
    }
}
