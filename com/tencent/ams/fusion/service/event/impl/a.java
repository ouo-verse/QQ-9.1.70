package com.tencent.ams.fusion.service.event.impl;

import android.os.Looper;
import com.tencent.ams.fusion.a.f;
import com.tencent.ams.fusion.service.event.Subscriber;
import com.tencent.ams.fusion.service.event.ThreadMode;
import com.tencent.ams.fusion.service.event.c;
import com.tencent.ams.fusion.service.event.d;
import com.tencent.ams.fusion.service.event.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final lt.a f70274a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<e>> f70275b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, List<d>> f70276c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f70277d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.service.event.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0675a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f70284a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55415);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ThreadMode.values().length];
            f70284a = iArr;
            try {
                iArr[ThreadMode.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70284a[ThreadMode.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70275b = new HashMap();
        this.f70276c = new ConcurrentHashMap();
        this.f70277d = new HashMap();
        this.f70274a = com.tencent.ams.fusion.service.b.b().g();
    }

    private void d(e eVar, Object obj) {
        d b16 = eVar.b();
        int i3 = C0675a.f70284a[b16.b().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                f.g("DefaultEventServiceUnknown thread mode: " + b16.b());
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f70274a.a(new Runnable(eVar, obj) { // from class: com.tencent.ams.fusion.service.event.impl.a.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ e f70281d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Object f70282e;

                    {
                        this.f70281d = eVar;
                        this.f70282e = obj;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, a.this, eVar, obj);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            a.this.h(this.f70281d, this.f70282e);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return;
            } else {
                h(eVar, obj);
                return;
            }
        }
        this.f70274a.c(new Runnable(eVar, obj) { // from class: com.tencent.ams.fusion.service.event.impl.a.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f70278d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Object f70279e;

            {
                this.f70278d = eVar;
                this.f70279e = obj;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, eVar, obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    a.this.h(this.f70278d, this.f70279e);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private void f(Object obj, d dVar) {
        Class<?> c16 = dVar.c();
        e eVar = new e(obj, dVar);
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f70275b.get(c16);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f70275b.put(c16, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(eVar)) {
            f.g("DefaultEventServiceSubscriber " + obj.getClass() + " already registered to event " + c16);
            return;
        }
        copyOnWriteArrayList.add(eVar);
        List<Class<?>> list = this.f70277d.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f70277d.put(obj, list);
        }
        list.add(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(e eVar, Object obj) {
        try {
            if (eVar.c()) {
                eVar.b().a().invoke(eVar.a(), obj);
            }
        } catch (Throwable th5) {
            f.d("DefaultEventServiceinvoke error,", th5);
        }
    }

    private boolean i(Object obj) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        boolean z16;
        Class<?> cls = obj.getClass();
        synchronized (this) {
            copyOnWriteArrayList = this.f70275b.get(cls);
        }
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Iterator<e> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                d(it.next(), obj);
            }
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.event.c
    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        try {
            if (this.f70276c.get(cls) == null) {
                List<d> g16 = g(obj);
                this.f70276c.put(cls, g16);
                synchronized (this) {
                    Iterator<d> it = g16.iterator();
                    while (it.hasNext()) {
                        f(obj, it.next());
                    }
                }
                return;
            }
            f.l("DefaultEventService", "Class '" + cls + "' has been registered, don't register again.");
        } catch (com.tencent.ams.fusion.service.event.b e16) {
            throw e16;
        } catch (Throwable unused) {
        }
    }

    public List<d> g(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Method method : obj.getClass().getMethods()) {
            Subscriber subscriber = (Subscriber) method.getAnnotation(Subscriber.class);
            if (subscriber != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    arrayList.add(new d(method, subscriber.threadMode(), parameterTypes[0]));
                } else {
                    throw new com.tencent.ams.fusion.service.event.b("@Subscribe method '" + method.getName() + "' must have exactly 1 parameter but has " + parameterTypes.length);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.ams.fusion.service.event.c
    public void a(com.tencent.ams.fusion.service.event.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            i(aVar);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
    }
}
