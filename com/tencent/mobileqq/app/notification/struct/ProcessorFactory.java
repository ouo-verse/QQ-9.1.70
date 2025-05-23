package com.tencent.mobileqq.app.notification.struct;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.processor.business.g;
import com.tencent.mobileqq.app.notification.processor.business.h;
import com.tencent.mobileqq.app.notification.processor.business.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public final class ProcessorFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final List<Integer> f196402a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Class<? extends c>> f196403b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f196402a = new ArrayList<Integer>() { // from class: com.tencent.mobileqq.app.notification.struct.ProcessorFactory.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    add(1009);
                    add(1001);
                    add(10002);
                    add(10004);
                    add(1003);
                    add(1004);
                    add(1005);
                    add(1020);
                    add(1000);
                    add(1023);
                    add(1024);
                    add(1025);
                    add(10007);
                    add(10008);
                    add(10010);
                }
            };
            f196403b = new HashMap<Integer, Class<? extends c>>() { // from class: com.tencent.mobileqq.app.notification.struct.ProcessorFactory.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    if (ProcessorFactory.f196402a != null) {
                        ProcessorFactory.f196402a.isEmpty();
                    }
                    Iterator it = ProcessorFactory.f196402a.iterator();
                    while (it.hasNext()) {
                        put((Integer) it.next(), com.tencent.mobileqq.app.notification.processor.basemessage.a.class);
                    }
                    put(10014, com.tencent.mobileqq.guild.temp.api.d.c());
                    put(7000, h.class);
                    put(6000, com.tencent.mobileqq.app.notification.processor.business.d.class);
                    put(1010, com.tencent.mobileqq.app.notification.processor.business.e.class);
                    put(1001, com.tencent.mobileqq.app.notification.processor.business.e.class);
                    put(10002, com.tencent.mobileqq.app.notification.processor.business.e.class);
                    put(1032, com.tencent.mobileqq.app.notification.processor.business.c.class);
                    put(1044, com.tencent.mobileqq.app.notification.processor.business.f.class);
                    put(1045, com.tencent.mobileqq.app.notification.processor.business.f.class);
                    put(1008, g.class);
                    put(9002, com.tencent.mobileqq.app.notification.processor.business.a.class);
                    put(10007, i.class);
                }
            };
        }
    }

    @Nullable
    public static c b(QQAppInterface qQAppInterface, int i3, e eVar) {
        Class<? extends c> cls = f196403b.get(Integer.valueOf(i3));
        if (cls == null) {
            cls = com.tencent.mobileqq.app.notification.processor.business.b.class;
        }
        try {
            Constructor<? extends c> declaredConstructor = cls.getDeclaredConstructor(QQAppInterface.class, e.class);
            declaredConstructor.setAccessible(true);
            c newInstance = declaredConstructor.newInstance(qQAppInterface, eVar);
            QLog.d("[NotificationRebuild] ProcessorFactory", 1, "[processor] create: invoked. ", " processor: ", newInstance);
            return newInstance;
        } catch (Throwable th5) {
            return d(th5);
        }
    }

    public static boolean c(int i3) {
        boolean contains = f196402a.contains(Integer.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 3000 || i3 == 10014 || contains) {
            return true;
        }
        return false;
    }

    private static c d(Throwable th5) {
        QLog.e("[NotificationRebuild] ProcessorFactory", 1, "nullProcessorWithException: failed. ", th5);
        return null;
    }
}
