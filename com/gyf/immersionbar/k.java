package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.gyf.immersionbar.g;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
final class k extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<m> f36046a;

    /* renamed from: b, reason: collision with root package name */
    private Application f36047b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f36048c;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final k f36049a = new k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a() {
        return b.f36049a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Application application) {
        Uri uriFor;
        Uri uri;
        this.f36047b = application;
        if (application != null && application.getContentResolver() != null && !this.f36048c) {
            Uri uri2 = null;
            if (!OSUtils.isHuaWei() && !OSUtils.isEMUI()) {
                if (!OSUtils.isXiaoMi() && !OSUtils.isMIUI()) {
                    if (!OSUtils.isVivo() && !OSUtils.isFuntouchOrOriginOs()) {
                        if (!OSUtils.isOppo() && !OSUtils.isColorOs()) {
                            if (OSUtils.isSamsung()) {
                                if (Settings.Global.getInt(this.f36047b.getContentResolver(), "navigationbar_hide_bar_enabled", -1) == -1) {
                                    uriFor = Settings.Global.getUriFor("navigation_bar_gesture_while_hidden");
                                    uri2 = Settings.Global.getUriFor("navigation_bar_gesture_detail_type");
                                    uri = Settings.Global.getUriFor("navigation_bar_gesture_hint");
                                } else {
                                    uriFor = Settings.Global.getUriFor("navigationbar_hide_bar_enabled");
                                }
                            } else {
                                uriFor = Settings.Secure.getUriFor("navigation_mode");
                            }
                        } else {
                            uriFor = Settings.Secure.getUriFor("hide_navigationbar_enable");
                        }
                    } else {
                        uriFor = Settings.Secure.getUriFor("navigation_gesture_on");
                    }
                } else {
                    uriFor = Settings.Global.getUriFor("force_fsg_nav_bar");
                    uri = null;
                    uri2 = Settings.Global.getUriFor("hide_gesture_line");
                }
                if (uriFor != null) {
                    this.f36047b.getContentResolver().registerContentObserver(uriFor, true, this);
                    this.f36048c = true;
                }
                if (uri2 != null) {
                    this.f36047b.getContentResolver().registerContentObserver(uri2, true, this);
                }
                if (uri == null) {
                    this.f36047b.getContentResolver().registerContentObserver(uri, true, this);
                    return;
                }
                return;
            }
            if (!OSUtils.isEMUI3_x()) {
                uriFor = Settings.Global.getUriFor("navigationbar_is_min");
            } else {
                uriFor = Settings.System.getUriFor("navigationbar_is_min");
            }
            uri = null;
            if (uriFor != null) {
            }
            if (uri2 != null) {
            }
            if (uri == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(m mVar) {
        ArrayList<m> arrayList;
        if (mVar != null && (arrayList = this.f36046a) != null) {
            arrayList.remove(mVar);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z16) {
        super.onChange(z16);
        ArrayList<m> arrayList = this.f36046a;
        if (arrayList != null && !arrayList.isEmpty()) {
            g.a a16 = g.a(this.f36047b);
            boolean z17 = true;
            if (a16.f36043a && (!a16.f36044b || com.gyf.immersionbar.a.f(this.f36047b) <= 0)) {
                z17 = false;
            }
            Iterator<m> it = this.f36046a.iterator();
            while (it.hasNext()) {
                it.next().a(z17, a16.f36045c);
            }
        }
    }

    k() {
        super(new Handler(Looper.getMainLooper()));
        this.f36048c = false;
    }
}
