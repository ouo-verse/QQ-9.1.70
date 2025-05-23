package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl;
import com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListPaginationRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes17.dex */
class GProSdkWrapperImpl$2$1 implements Runnable {
    final /* synthetic */ GProSdkWrapperImpl.f C;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f268737d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ArrayList f268738e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ArrayList f268739f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ ArrayList f268740h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f268741i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ byte[] f268742m;

    @Override // java.lang.Runnable
    public void run() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        if (this.f268737d == 0) {
            arrayList = com.tencent.mobileqq.qqguildsdk.util.g.K0(this.f268738e);
            arrayList2 = com.tencent.mobileqq.qqguildsdk.util.g.K0(this.f268739f);
            arrayList3 = com.tencent.mobileqq.qqguildsdk.util.g.K0(this.f268740h);
        }
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getUserList", "Access DB first and then Svr", this.f268737d, this.f268741i, "aList \uff1a" + arrayList.size() + ", nList \uff1a" + arrayList2.size() + ", rList \uff1a" + arrayList3.size(), this.C.f269553a);
        GProUserListPaginationRequest.c.c(this.C.f269554b, this.f268742m);
        this.C.getClass();
        String str = this.C.f269554b;
        throw null;
    }
}
