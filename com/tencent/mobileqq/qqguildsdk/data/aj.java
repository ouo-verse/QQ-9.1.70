package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProArchiveArkData;

/* compiled from: P */
/* loaded from: classes17.dex */
public class aj implements xh2.c {

    /* renamed from: a, reason: collision with root package name */
    private final GProArchiveArkData f265677a;

    /* renamed from: b, reason: collision with root package name */
    private final an f265678b;

    public aj(GProArchiveArkData gProArchiveArkData) {
        this.f265677a = gProArchiveArkData;
        this.f265678b = new an(gProArchiveArkData.getArkArgs());
    }

    @Override // xh2.c
    public de a() {
        return this.f265678b;
    }

    @Override // xh2.c
    public int getClientId() {
        return this.f265677a.getClientId();
    }

    @Override // xh2.c
    public String getIcon() {
        return this.f265677a.getIcon();
    }

    @Override // xh2.c
    public String getName() {
        return this.f265677a.getName();
    }

    public String toString() {
        return "GProGuildArchiveArkData{m_sData=" + this.f265677a + '}';
    }
}
