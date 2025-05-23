package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure;

import android.text.TextUtils;
import com.tencent.tvideo.protocol.pb.AdEmptyInfo;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private String f303944b;

    /* renamed from: a, reason: collision with root package name */
    private int f303943a = 0;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<WeakReference<Object>> f303945c = new LinkedList<>();

    public a(AdOrderItem adOrderItem) {
        a(adOrderItem);
    }

    private void b(Object obj) {
        if (obj == null) {
            return;
        }
        Iterator<WeakReference<Object>> it = this.f303945c.iterator();
        while (it.hasNext()) {
            WeakReference<Object> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                Object obj2 = next.get();
                if (obj2 == null) {
                    it.remove();
                } else if (obj2 == obj) {
                    return;
                }
            }
        }
        this.f303945c.add(new WeakReference<>(obj));
    }

    public static a c(Object obj) {
        if (obj instanceof AdOrderItem) {
            return new a((AdOrderItem) obj);
        }
        if (obj instanceof AdEmptyInfo) {
            return new a((AdEmptyInfo) obj);
        }
        return null;
    }

    public static String f(Object obj) {
        if (obj instanceof AdOrderItem) {
            return ((AdOrderItem) obj).order_id;
        }
        if (obj instanceof AdEmptyInfo) {
            return "EmptyOrder";
        }
        return null;
    }

    public static String g(Object obj) {
        if (obj instanceof AdEmptyInfo) {
            return ((AdEmptyInfo) obj).unique_id;
        }
        if (obj instanceof AdOrderItem) {
            return ((AdOrderItem) obj).unique_id;
        }
        return null;
    }

    public static boolean l(Object obj) {
        if (!(obj instanceof AdOrderItem) && !(obj instanceof AdEmptyInfo)) {
            return false;
        }
        return true;
    }

    public static boolean m(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void a(Object obj) {
        if (!l(obj)) {
            return;
        }
        if (!m(this.f303944b)) {
            if (this.f303945c.isEmpty()) {
                b(obj);
                this.f303943a = obj.hashCode();
                this.f303944b = g(obj);
                return;
            }
            return;
        }
        String g16 = g(obj);
        if (!this.f303944b.equals(g16)) {
            n.b("ExposureOrder", "addAdOrder error, unique_id:" + this.f303944b + "-" + g16);
            return;
        }
        b(obj);
    }

    public boolean d(Object obj) {
        if (this.f303945c.isEmpty()) {
            return false;
        }
        Iterator<WeakReference<Object>> it = this.f303945c.iterator();
        while (it.hasNext()) {
            Object obj2 = it.next().get();
            if (obj2 != null) {
                if (m(this.f303944b)) {
                    return obj2.equals(obj);
                }
                if (obj2 != obj) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public Object e() {
        Object obj;
        if (this.f303945c.isEmpty()) {
            return null;
        }
        Iterator<WeakReference<Object>> it = this.f303945c.iterator();
        while (it.hasNext()) {
            WeakReference<Object> next = it.next();
            if (next != null && (obj = next.get()) != null) {
                return obj;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String i3 = aVar.i();
        if (m(this.f303944b) && m(i3)) {
            return i3.equals(this.f303944b);
        }
        if (m(this.f303944b) || m(i3) || e() != aVar.e()) {
            return false;
        }
        return true;
    }

    public String h() {
        return f(e());
    }

    public int hashCode() {
        return this.f303943a;
    }

    public String i() {
        return this.f303944b;
    }

    public boolean j() {
        if (e() instanceof AdEmptyInfo) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (e() != null) {
            return true;
        }
        return false;
    }

    public a(AdEmptyInfo adEmptyInfo) {
        a(adEmptyInfo);
    }
}
