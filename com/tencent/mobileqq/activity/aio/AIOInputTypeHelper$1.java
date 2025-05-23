package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.QQAppInterface;

/* compiled from: P */
/* loaded from: classes10.dex */
class AIOInputTypeHelper$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ QQAppInterface f178002d;

    @Override // java.lang.Runnable
    public void run() {
        b.a(this.f178002d).edit().putBoolean("ptt_guide_have_show", false).commit();
    }
}
