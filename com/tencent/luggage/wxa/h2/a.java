package com.tencent.luggage.wxa.h2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.luggage.wxa.tk.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.p;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.wd.d {

    /* renamed from: c, reason: collision with root package name */
    public int f126835c;

    /* renamed from: d, reason: collision with root package name */
    public String f126836d;

    /* renamed from: e, reason: collision with root package name */
    public int f126837e;

    /* renamed from: f, reason: collision with root package name */
    public String f126838f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f126839g;

    /* renamed from: h, reason: collision with root package name */
    public int f126840h;

    /* renamed from: i, reason: collision with root package name */
    public String f126841i;

    /* renamed from: j, reason: collision with root package name */
    public Object f126842j;

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap f126833k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public static final h f126834l = new h();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6251a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126843a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f126844b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.h2.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6252a implements Consumer {
            public C6252a() {
            }

            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(e eVar) {
                if (eVar != null) {
                    eVar.a(RunnableC6251a.this.f126844b);
                }
            }
        }

        public RunnableC6251a(String str, Object obj) {
            this.f126843a = str;
            this.f126844b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f126834l.a((Object) this.f126843a, (Consumer) new C6252a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends p {
        private static final int CTRL_INDEX = 109;
        private static final String NAME = "onAppConfig";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends p {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(Object obj);
    }

    public /* synthetic */ a(Parcel parcel, RunnableC6251a runnableC6251a) {
        this(parcel);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = new a();
        f126833k.put(str, aVar);
        aVar.f126835c = 1;
        aVar.f126836d = str;
        aVar.b();
    }

    public void a(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        synchronized (this) {
            this.f126835c = 5;
            this.f126841i = parcelable.getClass().getName();
            this.f126842j = parcelable;
            a();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void g() {
        int i3 = this.f126835c;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 5) {
                    k();
                    return;
                }
                return;
            }
            l();
            return;
        }
        j();
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void h() {
        int i3 = this.f126835c;
        if (i3 != 1) {
            if (i3 == 2) {
                n();
                return;
            }
            return;
        }
        m();
    }

    public final void j() {
        if (this.f126839g == null) {
            return;
        }
        c cVar = new c();
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f126837e));
        hashMap.put("data", this.f126838f);
        cVar.setContext(this.f126839g).setData(hashMap).dispatch();
    }

    public final void k() {
        Object obj;
        String str = this.f126836d;
        if (str != null && (obj = this.f126842j) != null) {
            com.tencent.luggage.wxa.zp.h.f146825d.b(new RunnableC6251a(str, obj), "MicroMsg.WMPFToClientEvent");
        }
    }

    public final void l() {
        d dVar = new d();
        HashMap hashMap = new HashMap();
        hashMap.put("count", Integer.valueOf(this.f126840h));
        hashMap.put("data", this.f126838f);
        dVar.setContext(this.f126839g).setData(hashMap).dispatch();
    }

    public final void m() {
        com.tencent.luggage.wxa.h2.b.a(this);
    }

    public final void n() {
        com.tencent.luggage.wxa.h2.b.b(this);
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f126835c);
        parcel.writeString(this.f126836d);
        parcel.writeInt(this.f126837e);
        parcel.writeString(this.f126838f);
        parcel.writeInt(this.f126840h);
        if (!w0.c(this.f126841i) && this.f126842j != null) {
            parcel.writeString(this.f126841i);
            parcel.writeParcelable((Parcelable) this.f126842j, i3);
        }
    }

    a() {
    }

    a(Parcel parcel) {
        a(parcel);
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || f126833k.get(str) == null) ? false : true;
    }

    public static void b(com.tencent.luggage.wxa.xd.d dVar) {
        a aVar;
        if (dVar == null || (aVar = (a) f126833k.remove(dVar.getAppId())) == null) {
            return;
        }
        f126834l.b(dVar.getAppId());
        aVar.f126835c = 2;
        aVar.f126836d = dVar.getAppId();
        aVar.f126839g = null;
        aVar.c();
    }

    public static void a(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar == null) {
            return;
        }
        a aVar = new a();
        f126833k.put(dVar.getAppId(), aVar);
        aVar.f126835c = 1;
        aVar.f126836d = dVar.getAppId();
        aVar.f126839g = dVar;
        aVar.b();
    }

    public static void b(String str, e eVar) {
        if (eVar != null) {
            f126834l.c(str, eVar);
        }
    }

    public static void a(String str, e eVar) {
        if (eVar != null) {
            f126834l.b(str, eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void a(Parcel parcel) {
        this.f126835c = parcel.readInt();
        this.f126836d = parcel.readString();
        this.f126837e = parcel.readInt();
        this.f126838f = parcel.readString();
        this.f126840h = parcel.readInt();
        try {
            String readString = parcel.readString();
            this.f126841i = readString;
            if (w0.c(readString)) {
                return;
            }
            this.f126842j = parcel.readParcelable(Class.forName(this.f126841i).getClassLoader());
        } catch (Exception e16) {
            w.g("MicroMsg.WMPFToClientEvent", "unparcel custom data e %s", e16);
        }
    }
}
