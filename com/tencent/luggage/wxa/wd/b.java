package com.tencent.luggage.wxa.wd;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.luggage.wxa.tk.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.p;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.wd.d {

    /* renamed from: c, reason: collision with root package name */
    public int f144175c;

    /* renamed from: d, reason: collision with root package name */
    public String f144176d;

    /* renamed from: e, reason: collision with root package name */
    public int f144177e;

    /* renamed from: f, reason: collision with root package name */
    public String f144178f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f144179g;

    /* renamed from: h, reason: collision with root package name */
    public int f144180h;

    /* renamed from: i, reason: collision with root package name */
    public String f144181i;

    /* renamed from: j, reason: collision with root package name */
    public Object f144182j;

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap f144173k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public static final h f144174l = new h();
    public static final Parcelable.Creator<b> CREATOR = new C6880b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f144183a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f144184b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.wd.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6879a implements Consumer {
            public C6879a() {
            }

            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(e eVar) {
                if (eVar != null) {
                    eVar.a(a.this.f144184b);
                }
            }
        }

        public a(String str, Object obj) {
            this.f144183a = str;
            this.f144184b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.f144174l.a((Object) this.f144183a, (Consumer) new C6879a());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wd.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6880b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
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

    public /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b();
        f144173k.put(str, bVar);
        bVar.f144175c = 1;
        bVar.f144176d = str;
        bVar.b();
    }

    public static void c(String str) {
        b bVar;
        if (TextUtils.isEmpty(str) || (bVar = (b) f144173k.remove(str)) == null) {
            return;
        }
        f144174l.b(str);
        bVar.f144175c = 2;
        bVar.f144176d = str;
        bVar.f144179g = null;
        if (z.l()) {
            try {
                bVar.c();
            } catch (SecurityException e16) {
                w.b("MicroMsg.MMToClientEvent", "unregisterToMM(%s) get exception:%s", str, e16);
            }
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        synchronized (this) {
            this.f144175c = 5;
            this.f144181i = parcelable.getClass().getName();
            this.f144182j = parcelable;
            a();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void g() {
        int i3 = this.f144175c;
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
        int i3 = this.f144175c;
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
        if (this.f144179g == null) {
            return;
        }
        c cVar = new c();
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f144177e));
        hashMap.put("data", this.f144178f);
        cVar.setContext(this.f144179g).setData(hashMap).dispatch();
    }

    public final void k() {
        Object obj;
        String str = this.f144176d;
        if (str != null && (obj = this.f144182j) != null) {
            com.tencent.luggage.wxa.zp.h.f146825d.b(new a(str, obj), "MicroMsg.MMToClientEvent");
        }
    }

    public final void l() {
        d dVar = new d();
        HashMap hashMap = new HashMap();
        hashMap.put("count", Integer.valueOf(this.f144180h));
        hashMap.put("data", this.f144178f);
        dVar.setContext(this.f144179g).setData(hashMap).dispatch();
    }

    public final void m() {
        com.tencent.luggage.wxa.wd.c.a(this);
    }

    public final void n() {
        com.tencent.luggage.wxa.wd.c.b(this);
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f144175c);
        parcel.writeString(this.f144176d);
        parcel.writeInt(this.f144177e);
        parcel.writeString(this.f144178f);
        parcel.writeInt(this.f144180h);
        parcel.writeString(this.f144181i);
        parcel.writeParcelable((Parcelable) this.f144182j, i3);
    }

    b() {
    }

    b(Parcel parcel) {
        a(parcel);
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || f144173k.get(str) == null) ? false : true;
    }

    public static void b(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar == null) {
            return;
        }
        c(dVar.getAppId());
    }

    public static void b(String str, e eVar) {
        if (eVar != null) {
            f144174l.c(str, eVar);
        }
    }

    public static void a(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar == null) {
            return;
        }
        b bVar = new b();
        f144173k.put(dVar.getAppId(), bVar);
        bVar.f144175c = 1;
        bVar.f144176d = dVar.getAppId();
        bVar.f144179g = dVar;
        bVar.b();
    }

    public static void a(String str, e eVar) {
        if (eVar != null) {
            f144174l.b(str, eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0045  */
    @Override // com.tencent.luggage.wxa.wd.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Parcel parcel) {
        Class<?> cls;
        String readString;
        this.f144175c = parcel.readInt();
        this.f144176d = parcel.readString();
        this.f144177e = parcel.readInt();
        this.f144178f = parcel.readString();
        this.f144180h = parcel.readInt();
        try {
            readString = parcel.readString();
            this.f144181i = readString;
        } catch (ClassNotFoundException e16) {
            w.g("MicroMsg.MMToClientEvent", "unparcel custom data e %s", e16);
        }
        if (!w0.c(readString)) {
            cls = Class.forName(this.f144181i);
            if (cls != null) {
                parcel.readParcelable(null);
                return;
            } else {
                this.f144182j = parcel.readParcelable(cls.getClassLoader());
                return;
            }
        }
        cls = null;
        if (cls != null) {
        }
    }
}
