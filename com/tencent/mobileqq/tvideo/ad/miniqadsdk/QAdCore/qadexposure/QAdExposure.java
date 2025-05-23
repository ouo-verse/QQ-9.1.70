package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.tvideo.protocol.pb.AdExposureType;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import pw2.g;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdExposure {

    /* renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<View, ExposureChecker> f303917a = new WeakHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a, ExposureChecker> f303918b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final WeakHashMap<Object, a> f303919c = new WeakHashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f303920d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f303921e;

        @Override // java.lang.Runnable
        public void run() {
            QAdExposure.r(this.f303920d, this.f303921e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f303922d;

        @Override // java.lang.Runnable
        public void run() {
            QAdExposure.s(this.f303922d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure$4, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f303929d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f303930e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f303931f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f303932h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f303933i;

        @Override // java.lang.Runnable
        public void run() {
            QAdExposure.o(this.f303929d, this.f303930e, this.f303931f, this.f303932h, this.f303933i);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface ReportType {
        public static final int TYPE_CHANNEL_FEED = 3;
        public static final int TYPE_DETAIL_FEED = 4;
        public static final int TYPE_FEED = 1;
        public static final int TYPE_FOCUS = 2;
        public static final int TYPE_IMMERSIVE_FEED = 5;
        public static final int TYPE_IMMERSIVE_PENDANT = 6;
        public static final int TYPE_NORMAL = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Object f303940a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Object> f303941b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private ExposureChecker f303942c;

        a(Object obj) {
            this.f303940a = obj;
        }

        void a(Object obj) {
            Iterator<Object> it = this.f303941b.iterator();
            while (it.hasNext()) {
                if (it.next() == obj) {
                    return;
                }
            }
            this.f303941b.add(obj);
        }

        ExposureChecker b() {
            return this.f303942c;
        }

        int c() {
            return this.f303941b.size();
        }

        public boolean d(Object obj) {
            if (this.f303940a == obj) {
                return true;
            }
            return false;
        }

        void e(ExposureChecker exposureChecker) {
            this.f303942c = exposureChecker;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(Object obj);

        void b(Object obj);
    }

    public static void g(View view, AdOrderItem adOrderItem, Class cls, boolean z16, int i3, b bVar) {
        h(view, adOrderItem, cls, z16, AdExposureType.AD_EXPOSURE_TYPE_NORMAL, i3, null, bVar);
    }

    private static void h(final View view, final Object obj, final Class cls, final boolean z16, final AdExposureType adExposureType, final int i3, final Object obj2, final b bVar) {
        if (v()) {
            n(view, obj, cls, z16, adExposureType, i3, obj2, bVar);
        } else {
            g.a(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure.3
                @Override // java.lang.Runnable
                public void run() {
                    QAdExposure.n(view, obj, cls, z16, adExposureType, i3, obj2, bVar);
                }
            });
        }
    }

    public static void i(View view, Class cls) {
        j(view, cls, false, true);
    }

    private static void j(final View view, final Class cls, final boolean z16, final boolean z17) {
        if (v()) {
            p(view, cls, z16, z17);
        } else {
            g.a(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure.5
                @Override // java.lang.Runnable
                public void run() {
                    QAdExposure.p(view, cls, z16, z17);
                }
            });
        }
    }

    public static void k(View view, boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.b bVar) {
        if (v()) {
            q(view, Boolean.valueOf(z16), bVar);
        } else {
            g.a(new Runnable(view, z16, bVar) { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure.6

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f303938d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f303939e;

                @Override // java.lang.Runnable
                public void run() {
                    QAdExposure.q(this.f303938d, Boolean.valueOf(this.f303939e), null);
                }
            });
        }
    }

    private static void l() {
        Iterator<Map.Entry<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a, ExposureChecker>> it = f303918b.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a key = it.next().getKey();
            if (key == null || !key.k()) {
                it.remove();
            }
        }
    }

    @NonNull
    private static ExposureChecker m(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a aVar, boolean z16, AdExposureType adExposureType, int i3, b bVar) {
        if (i3 == 5) {
            return new c(aVar, z16, adExposureType, i3, bVar);
        }
        return new ExposureChecker(aVar, z16, adExposureType, i3, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(View view, Object obj, Class cls, boolean z16, AdExposureType adExposureType, int i3, Object obj2, b bVar) {
        Integer valueOf;
        if (view != null && obj != null) {
            if (!com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a.l(obj)) {
                n.a("QAdExposure", "bind, Order not support!");
                return;
            }
            String g16 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a.g(obj);
            if (TextUtils.isEmpty(g16)) {
                g16 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a.f(obj);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bind, view:");
            sb5.append(view.hashCode());
            sb5.append(" name:");
            sb5.append(view.getClass().getName());
            sb5.append(" unique_id:");
            sb5.append(g16);
            sb5.append(" view size:");
            WeakHashMap<View, ExposureChecker> weakHashMap = f303917a;
            sb5.append(weakHashMap.size());
            sb5.append(" order size:");
            ConcurrentHashMap<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a, ExposureChecker> concurrentHashMap = f303918b;
            sb5.append(concurrentHashMap.size());
            sb5.append(" emptyreport:");
            sb5.append(z16);
            sb5.append(" exposureType:");
            sb5.append(adExposureType);
            sb5.append(" reportType:");
            sb5.append(i3);
            sb5.append(" alias:");
            if (obj2 == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(obj2.hashCode());
            }
            sb5.append(valueOf);
            n.a("QAdExposure", sb5.toString());
            l();
            ExposureChecker exposureChecker = weakHashMap.get(view);
            if (exposureChecker != null) {
                if (!exposureChecker.J(obj) && exposureChecker != t(obj2)) {
                    exposureChecker.d0();
                } else {
                    n.a("QAdExposure", "bind, Relation exist, update");
                    exposureChecker.i(obj);
                    exposureChecker.g0(view, cls);
                    y(bVar, exposureChecker);
                    return;
                }
            }
            ExposureChecker u16 = u(obj, z16, adExposureType, i3, obj2, bVar);
            if (u16.L()) {
                n.a("QAdExposure", "bind, order report finished");
                return;
            }
            weakHashMap.put(view, u16);
            u16.g0(view, cls);
            n.a("QAdExposure", "bind finish, view:" + view.hashCode() + " ad:" + u16.F() + " view size:" + weakHashMap.size() + " order size:" + concurrentHashMap.size() + " holder size;" + f303919c.size());
            return;
        }
        n.a("QAdExposure", "bind, param is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(View view, boolean z16, boolean z17, boolean z18, boolean z19) {
        if (view == null) {
            return;
        }
        n.a("QAdExposure", "checkExposure, view:" + view.hashCode() + " name:" + view.getClass().getName() + " visible:" + z16 + " bInScroll:" + z17);
        ExposureChecker exposureChecker = f303917a.get(view);
        if (exposureChecker == null) {
            n.a("QAdExposure", "checkExposure, checker is null");
        } else {
            exposureChecker.b0(z19);
            exposureChecker.j(view, z16, z17, z18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(View view, Class cls, boolean z16, boolean z17) {
        if (view == null) {
            return;
        }
        n.a("QAdExposure", "doCheckOriginExposure, view:" + view.hashCode() + " name:" + view.getClass().getName());
        ExposureChecker exposureChecker = f303917a.get(view);
        if (exposureChecker == null) {
            n.a("QAdExposure", "doCheckOriginExposure, checker is null");
        } else {
            exposureChecker.n(view, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(View view, Boolean bool, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.b bVar) {
        if (view == null) {
            return;
        }
        n.a("QAdExposure", "checkValidExposure, view:" + view.hashCode() + " name:" + view.getClass().getName() + " visible:" + bool);
        ExposureChecker exposureChecker = f303917a.get(view);
        if (exposureChecker == null) {
            n.a("QAdExposure", "checkExposure, checker is null");
        } else {
            exposureChecker.q(view, bool, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(Object obj, Object obj2) {
        a aVar;
        if (obj != null && obj2 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doRegisterOrder, key:");
            sb5.append(obj.hashCode());
            sb5.append(" alias:");
            sb5.append(obj2.hashCode());
            sb5.append(" holder size:");
            WeakHashMap<Object, a> weakHashMap = f303919c;
            sb5.append(weakHashMap.size());
            n.a("QAdExposure", sb5.toString());
            if (weakHashMap.containsKey(obj2)) {
                n.a("QAdExposure", "doRegisterOrder, already exist");
                return;
            }
            Iterator<a> it = weakHashMap.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = it.next();
                    if (aVar.d(obj)) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar != null) {
                aVar.a(obj2);
                f303919c.put(obj2, aVar);
                n.a("QAdExposure", "doRegisterOrder, holder exist, holder order count:" + aVar.c());
                return;
            }
            a aVar2 = new a(obj);
            aVar2.a(obj2);
            f303919c.put(obj2, aVar2);
            n.a("QAdExposure", "doRegisterOrder, create new holder, holder order ount:" + aVar2.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(Object obj) {
        if (obj == null) {
            return;
        }
        n.a("QAdExposure", "doUnegisterOrder, key:" + obj.hashCode());
        Iterator<Map.Entry<Object, a>> it = f303919c.entrySet().iterator();
        a aVar = null;
        while (it.hasNext()) {
            Map.Entry<Object, a> next = it.next();
            if (next.getValue().d(obj)) {
                aVar = next.getValue();
                it.remove();
            }
        }
        if (aVar == null) {
            n.a("QAdExposure", "doUnegisterOrder, can not find holder");
            return;
        }
        w(aVar.b());
        x(aVar.b());
        n.a("QAdExposure", "doUnegisterOrder, order size:" + f303918b.size() + " view size:" + f303917a.size() + " holder size:" + f303919c.size());
    }

    private static ExposureChecker t(Object obj) {
        a aVar;
        if (obj == null || (aVar = f303919c.get(obj)) == null) {
            return null;
        }
        return aVar.b();
    }

    private static ExposureChecker u(@NonNull Object obj, boolean z16, AdExposureType adExposureType, int i3, Object obj2, b bVar) {
        a aVar;
        ExposureChecker exposureChecker;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a c16 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a.c(obj);
        ConcurrentHashMap<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a, ExposureChecker> concurrentHashMap = f303918b;
        ExposureChecker exposureChecker2 = concurrentHashMap.get(c16);
        if (exposureChecker2 != null) {
            n.a("QAdExposure", "getExistChecker,find in order map");
            exposureChecker2.i(obj);
            exposureChecker2.e0(bVar);
            return exposureChecker2;
        }
        if (obj2 != null) {
            aVar = f303919c.get(obj2);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            ExposureChecker m3 = m(c16, z16, adExposureType, i3, bVar);
            n.a("QAdExposure", "getExistChecker, single instance order, create new checker");
            concurrentHashMap.put(c16, m3);
            return m3;
        }
        n.a("QAdExposure", "getExistChecker, multi instance order");
        ExposureChecker b16 = aVar.b();
        if (b16 == null) {
            ExposureChecker m16 = m(c16, z16, adExposureType, i3, bVar);
            aVar.e(m16);
            n.a("QAdExposure", "getExistChecker, create new checker");
            exposureChecker = m16;
        } else {
            n.a("QAdExposure", "getExistChecker, checker exist");
            exposureChecker = b16;
        }
        concurrentHashMap.put(c16, exposureChecker);
        return exposureChecker;
    }

    private static boolean v() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    private static void w(ExposureChecker exposureChecker) {
        if (exposureChecker == null) {
            return;
        }
        Iterator<Map.Entry<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.a, ExposureChecker>> it = f303918b.entrySet().iterator();
        while (it.hasNext()) {
            if (exposureChecker == it.next().getValue()) {
                it.remove();
            }
        }
    }

    private static void x(ExposureChecker exposureChecker) {
        if (exposureChecker == null) {
            return;
        }
        Iterator<Map.Entry<View, ExposureChecker>> it = f303917a.entrySet().iterator();
        while (it.hasNext()) {
            if (exposureChecker == it.next().getValue()) {
                it.remove();
            }
        }
    }

    private static void y(b bVar, ExposureChecker exposureChecker) {
        exposureChecker.e0(bVar);
    }
}
