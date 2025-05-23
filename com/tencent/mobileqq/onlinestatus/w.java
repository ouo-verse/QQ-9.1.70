package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public String f256872a;

    /* renamed from: b, reason: collision with root package name */
    public String f256873b;

    /* renamed from: c, reason: collision with root package name */
    public String f256874c;

    /* renamed from: f, reason: collision with root package name */
    protected a f256877f;

    /* renamed from: g, reason: collision with root package name */
    public long f256878g;

    /* renamed from: h, reason: collision with root package name */
    protected QBaseActivity f256879h;

    /* renamed from: i, reason: collision with root package name */
    protected AppRuntime f256880i;

    /* renamed from: d, reason: collision with root package name */
    public boolean f256875d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f256876e = "";

    /* renamed from: j, reason: collision with root package name */
    protected boolean f256881j = true;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void f();
    }

    public w(long j3, a aVar, AppRuntime appRuntime, QBaseActivity qBaseActivity) {
        this.f256877f = aVar;
        this.f256879h = qBaseActivity;
        this.f256878g = j3;
        this.f256880i = appRuntime;
    }

    public boolean a() {
        return true;
    }

    public abstract void b(boolean z16);

    public abstract void d();

    public abstract void f(boolean z16, OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem);

    public void i(boolean z16, long j3) {
        this.f256881j = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void j();

    public void c() {
    }

    public void e() {
    }

    public void h() {
    }

    public void g(int i3, int i16, Intent intent) {
    }
}
