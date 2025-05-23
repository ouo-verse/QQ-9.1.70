package com.gyf.immersionbar;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class ImmersionDelegate implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private ImmersionBar f36005d;

    /* renamed from: e, reason: collision with root package name */
    private c f36006e;

    /* renamed from: f, reason: collision with root package name */
    private int f36007f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmersionDelegate(Object obj) {
        if (obj instanceof Activity) {
            if (this.f36005d == null) {
                this.f36005d = new ImmersionBar((Activity) obj);
                return;
            }
            return;
        }
        if (obj instanceof Fragment) {
            if (this.f36005d == null) {
                if (obj instanceof DialogFragment) {
                    this.f36005d = new ImmersionBar((DialogFragment) obj);
                    return;
                } else {
                    this.f36005d = new ImmersionBar((Fragment) obj);
                    return;
                }
            }
            return;
        }
        if ((obj instanceof android.app.Fragment) && this.f36005d == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.f36005d = new ImmersionBar((android.app.DialogFragment) obj);
            } else {
                this.f36005d = new ImmersionBar((android.app.Fragment) obj);
            }
        }
    }

    private void a(Configuration configuration) {
        ImmersionBar immersionBar = this.f36005d;
        if (immersionBar != null && immersionBar.L()) {
            this.f36005d.u().getClass();
        }
    }

    public ImmersionBar e() {
        return this.f36005d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Configuration configuration) {
        a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Configuration configuration) {
        ImmersionBar immersionBar = this.f36005d;
        if (immersionBar != null) {
            immersionBar.Q(configuration);
            a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f36006e = null;
        ImmersionBar immersionBar = this.f36005d;
        if (immersionBar != null) {
            immersionBar.R();
            this.f36005d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        ImmersionBar immersionBar = this.f36005d;
        if (immersionBar != null) {
            immersionBar.S();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ImmersionBar immersionBar = this.f36005d;
        if (immersionBar != null && immersionBar.s() != null) {
            Activity s16 = this.f36005d.s();
            a aVar = new a(s16);
            this.f36006e.g(aVar.j());
            this.f36006e.b(aVar.l());
            this.f36006e.c(aVar.d());
            this.f36006e.d(aVar.g());
            this.f36006e.a(aVar.a());
            boolean hasNotchScreen = NotchUtils.hasNotchScreen(s16);
            this.f36006e.f(hasNotchScreen);
            if (hasNotchScreen && this.f36007f == 0) {
                int notchHeight = NotchUtils.getNotchHeight(s16);
                this.f36007f = notchHeight;
                this.f36006e.e(notchHeight);
            }
            throw null;
        }
    }
}
