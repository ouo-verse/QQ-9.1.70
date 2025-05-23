package com.tencent.mobileqq.troop.api.config;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ag {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f293963a;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f293964b;

    /* renamed from: c, reason: collision with root package name */
    private static final ArrayList<o> f293965c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45322);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293963a = new Object();
        f293964b = new AtomicBoolean(false);
        f293965c = new ArrayList<>();
    }

    public static void a() {
        synchronized (f293963a) {
            if (f293964b.get()) {
                return;
            }
            ArrayList<Class<? extends o>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238010c;
            if (arrayList != null) {
                Iterator<Class<? extends o>> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        f293965c.add(it.next().newInstance());
                    } catch (Throwable th5) {
                        QLog.e("TroopMngHandlerProcessorConfig", 1, "Init Fail,", th5);
                    }
                }
            }
            f293964b.set(true);
        }
    }

    public static void b(@NonNull AppInterface appInterface, String str) {
        synchronized (f293963a) {
            Iterator<o> it = f293965c.iterator();
            while (it.hasNext()) {
                it.next().a(appInterface, str);
            }
        }
    }

    public static void c(@NonNull AppInterface appInterface, String str) {
        synchronized (f293963a) {
            Iterator<o> it = f293965c.iterator();
            while (it.hasNext()) {
                it.next().b(appInterface, str);
            }
        }
    }

    public static void d(@NonNull AppInterface appInterface, String str) {
        synchronized (f293963a) {
            Iterator<o> it = f293965c.iterator();
            while (it.hasNext()) {
                it.next().c(appInterface, str);
            }
        }
    }

    public static void e(@NonNull AppInterface appInterface, String str) {
        synchronized (f293963a) {
            Iterator<o> it = f293965c.iterator();
            while (it.hasNext()) {
                it.next().d(appInterface, str);
            }
        }
    }

    public static void f(@NonNull AppInterface appInterface, String str) {
        synchronized (f293963a) {
            Iterator<o> it = f293965c.iterator();
            while (it.hasNext()) {
                it.next().e(appInterface, str);
            }
        }
    }

    public static void g(String str, int i3, Parcelable parcelable) {
        synchronized (f293963a) {
            Iterator<o> it = f293965c.iterator();
            while (it.hasNext()) {
                it.next().f(str, i3, parcelable);
            }
        }
    }

    public static void h(@NonNull AppInterface appInterface, String str) {
        synchronized (f293963a) {
            Iterator<o> it = f293965c.iterator();
            while (it.hasNext()) {
                it.next().g(appInterface, str);
            }
        }
    }
}
