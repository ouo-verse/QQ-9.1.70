package com.tencent.mobileqq.ark.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.core.ArkAppCGI;
import com.tencent.mobileqq.ark.p;
import com.tencent.mobileqq.ark.q;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements p {

    /* renamed from: a, reason: collision with root package name */
    private final ArkAppCenter f199331a;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends ArkAppCGI.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f199332a;

        a(q qVar) {
            this.f199332a = qVar;
        }

        @Override // com.tencent.mobileqq.ark.core.ArkAppCGI.c
        public void a(boolean z16, String str, String str2, Object obj) {
            this.f199332a.a(z16, str, str2, obj);
        }
    }

    public d(ArkAppCenter arkAppCenter) {
        this.f199331a = arkAppCenter;
    }

    @Override // com.tencent.mobileqq.ark.p
    public boolean a(String str, int i3, int i16, BusinessObserver businessObserver) {
        AppInterface c16 = c();
        if (c16 != null) {
            return ((ArkAppHandler) c16.getBusinessHandler(ArkAppHandler.class.getName())).G2(str, i3, i16, businessObserver);
        }
        throw new RuntimeException("no app interface");
    }

    @Override // com.tencent.mobileqq.ark.p
    public void b(String str, Object obj, q qVar) {
        this.f199331a.i(str, obj, new a(qVar));
    }

    AppInterface c() {
        AppRuntime h16 = this.f199331a.h();
        if (h16 instanceof AppInterface) {
            return (AppInterface) h16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ark.p
    public boolean sendAppMsg(String str, String str2, int i3, int i16, BusinessObserver businessObserver) {
        AppInterface c16 = c();
        if (c16 != null) {
            return ((ArkAppHandler) c16.getBusinessHandler(ArkAppHandler.class.getName())).H2(str, str2, i3, i16, businessObserver);
        }
        throw new RuntimeException("no app interface");
    }
}
