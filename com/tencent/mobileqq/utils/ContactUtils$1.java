package com.tencent.mobileqq.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes20.dex */
class ContactUtils$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppInterface f306923d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f306924e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f306925f;

    @Override // java.lang.Runnable
    public void run() {
        final String g06 = ac.g0(this.f306923d, this.f306924e, this.f306925f);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.ContactUtils$1.1
            @Override // java.lang.Runnable
            public void run() {
                ContactUtils$1.this.getClass();
                throw null;
            }
        });
    }
}
