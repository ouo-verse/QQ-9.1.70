package com.tencent.mobileqq.troop.api.config;

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
public class ai {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f293968a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f293969b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<q> f293970c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293968a = new AtomicBoolean(false);
        f293969b = new Object();
        f293970c = new ArrayList<>();
    }

    public static void a() {
        synchronized (f293969b) {
            if (f293968a.get()) {
                return;
            }
            ArrayList<Class<? extends q>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238009b;
            if (arrayList != null) {
                Iterator<Class<? extends q>> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        f293970c.add(it.next().newInstance());
                    } catch (Throwable th5) {
                        QLog.e("TroopPushHandlerProcessorConfig", 1, "Init Fail,", th5);
                    }
                }
            }
            f293968a.set(true);
        }
    }

    public static void b(@NonNull AppInterface appInterface, String str, int i3, int i16) {
        Iterator<q> it = f293970c.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, str, i3, i16);
        }
    }
}
