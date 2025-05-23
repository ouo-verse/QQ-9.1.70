package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
final class e extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ImmersionCallback> f36033a;

    /* renamed from: b, reason: collision with root package name */
    private Application f36034b;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f36035c;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f36036a = new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        return b.f36036a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImmersionCallback immersionCallback) {
        if (immersionCallback == null) {
            return;
        }
        if (this.f36033a == null) {
            this.f36033a = new ArrayList<>();
        }
        if (!this.f36033a.contains(immersionCallback)) {
            this.f36033a.add(immersionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Application application) {
        Uri uriFor;
        this.f36034b = application;
        if (application != null && application.getContentResolver() != null && !this.f36035c.booleanValue() && (uriFor = Settings.System.getUriFor("navigationbar_is_min")) != null) {
            this.f36034b.getContentResolver().registerContentObserver(uriFor, true, this);
            this.f36035c = Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImmersionCallback immersionCallback) {
        ArrayList<ImmersionCallback> arrayList;
        if (immersionCallback != null && (arrayList = this.f36033a) != null) {
            arrayList.remove(immersionCallback);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z16) {
        ArrayList<ImmersionCallback> arrayList;
        boolean z17;
        super.onChange(z16);
        Application application = this.f36034b;
        if (application != null && application.getContentResolver() != null && (arrayList = this.f36033a) != null && !arrayList.isEmpty()) {
            int i3 = Settings.System.getInt(this.f36034b.getContentResolver(), "navigationbar_is_min", 0);
            NavigationBarType navigationBarType = NavigationBarType.CLASSIC;
            if (i3 == 1) {
                navigationBarType = NavigationBarType.GESTURES;
            }
            Iterator<ImmersionCallback> it = this.f36033a.iterator();
            while (it.hasNext()) {
                ImmersionCallback next = it.next();
                if (i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                next.a(z17, navigationBarType);
            }
        }
    }

    e() {
        super(new Handler(Looper.getMainLooper()));
        this.f36035c = Boolean.FALSE;
    }
}
