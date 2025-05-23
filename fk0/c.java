package fk0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f399705b;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Fragment> f399706a;

    public c(Application application) {
        b.d(application);
        e();
    }

    private boolean e() {
        f();
        return true;
    }

    private static void f() {
        if (f399705b) {
            return;
        }
        f399705b = true;
        a.b("div", lk0.b.class);
        a.b("text", lk0.d.class);
    }

    public Activity a() {
        WeakReference<Fragment> weakReference = this.f399706a;
        if (weakReference != null) {
            return weakReference.get().getActivity();
        }
        return null;
    }

    public Context b() {
        return null;
    }

    public String c() {
        return "";
    }

    public String d() {
        return "";
    }
}
