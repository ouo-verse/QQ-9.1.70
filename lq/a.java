package lq;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    protected b f415375d;

    /* renamed from: e, reason: collision with root package name */
    protected View f415376e;

    /* renamed from: f, reason: collision with root package name */
    protected Activity f415377f;

    /* renamed from: h, reason: collision with root package name */
    private ViewStub f415378h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f415379i = false;

    @Deprecated
    public a(Activity activity, View view, b bVar) {
        this.f415377f = activity;
        this.f415376e = view;
        this.f415375d = bVar;
    }

    public <T> T d(int i3, Object... objArr) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void e();

    public void onDestroy() {
        this.f415377f = null;
        this.f415378h = null;
        this.f415376e = null;
        this.f415375d = null;
    }

    public void k(Intent intent) {
    }

    public void f() {
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void l(int i3, Object... objArr) {
    }

    public void g(int i3, int i16, Intent intent) {
    }
}
