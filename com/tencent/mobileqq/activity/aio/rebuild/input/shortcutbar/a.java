package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private c f179852a;

    public a(c cVar) {
        this.f179852a = cVar;
    }

    public com.tencent.aio.api.runtime.a a() {
        return this.f179852a.a();
    }

    public int b() {
        return this.f179852a.e();
    }

    public Activity c() {
        return this.f179852a.getActivity();
    }

    public AppRuntime d() {
        return this.f179852a.getAppRuntime();
    }

    public Context e() {
        return this.f179852a.getContext();
    }

    public String f() {
        com.tencent.aio.api.runtime.a a16 = this.f179852a.a();
        if (a16 == null) {
            return "";
        }
        return a16.g().r().c().j();
    }

    public SessionInfo g() {
        return this.f179852a.getSessionInfo();
    }

    public boolean h() {
        return this.f179852a.b();
    }

    public void i() {
        this.f179852a.g();
    }

    public void j() {
        this.f179852a.c();
    }
}
