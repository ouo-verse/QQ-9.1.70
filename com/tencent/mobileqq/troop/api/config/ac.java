package com.tencent.mobileqq.troop.api.config;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f293951a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f293952b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<j> f293953c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293951a = new AtomicBoolean(false);
        f293952b = new Object();
        f293953c = new ArrayList<>();
    }

    public static void a() {
        synchronized (f293952b) {
            if (f293951a.get()) {
                return;
            }
            ArrayList<Class<? extends j>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238008a;
            if (arrayList != null) {
                Iterator<Class<? extends j>> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        f293953c.add(it.next().newInstance());
                    } catch (Throwable th5) {
                        QLog.e("TroopListHandlerProcessorConfig", 1, "Init Fail,", th5);
                    }
                }
            }
            f293951a.set(true);
        }
    }

    public static void b(@NonNull AppInterface appInterface) {
        synchronized (f293952b) {
            Iterator<j> it = f293953c.iterator();
            while (it.hasNext()) {
                it.next().a(appInterface);
            }
        }
    }

    public static void c(@NonNull AppInterface appInterface) {
        synchronized (f293952b) {
            Iterator<j> it = f293953c.iterator();
            while (it.hasNext()) {
                it.next().b(appInterface);
            }
        }
    }

    public static void d(@NonNull AppInterface appInterface, @NonNull List<TroopInfo> list) {
        synchronized (f293952b) {
            Iterator<j> it = f293953c.iterator();
            while (it.hasNext()) {
                it.next().c(appInterface, list);
            }
        }
    }
}
