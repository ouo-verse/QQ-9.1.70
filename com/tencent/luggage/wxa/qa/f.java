package com.tencent.luggage.wxa.qa;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.ka.w;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f138553a = new WeakHashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f138554a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f138555b;

        public a(boolean z16, i iVar) {
            this.f138554a = z16;
            this.f138555b = iVar;
            if (!z16) {
                synchronized (f.f138553a) {
                    f.f138553a.put(iVar, new WeakReference(this));
                }
            }
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public void a(C6639f c6639f) {
            i iVar = this.f138555b;
            if (iVar != null) {
                if (c6639f == null) {
                    com.tencent.luggage.wxa.ta.c.e("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!", new Object[0]);
                    this.f138555b.a(null);
                } else {
                    iVar.a(c6639f.a());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements com.tencent.luggage.wxa.ka.f {
        b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.ka.f
        public void a(C6639f c6639f, i iVar) {
            Object a16 = c6639f.a();
            String b16 = c6639f.b();
            if (b16 != null && b16.length() != 0) {
                com.tencent.luggage.wxa.ka.f fVar = (com.tencent.luggage.wxa.ka.f) w.a(b16, com.tencent.luggage.wxa.ka.f.class);
                if (fVar == null) {
                    com.tencent.luggage.wxa.ta.c.e("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", b16);
                    return;
                } else {
                    fVar.a(a16, new d(iVar));
                    return;
                }
            }
            com.tencent.luggage.wxa.ta.c.b("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.", new Object[0]);
        }
    }

    /* compiled from: P */
    @com.tencent.luggage.wxa.na.a
    /* loaded from: classes8.dex */
    public static class c extends b implements com.tencent.luggage.wxa.ka.e<C6639f, C6639f> {
        c() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d implements i, com.tencent.luggage.wxa.pa.a {

        /* renamed from: a, reason: collision with root package name */
        public i f138556a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.luggage.wxa.pa.a f138557b;

        public d(i iVar) {
            this.f138556a = iVar;
            if (iVar instanceof com.tencent.luggage.wxa.pa.a) {
                this.f138557b = (com.tencent.luggage.wxa.pa.a) iVar;
            }
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public void a(Object obj) {
            i iVar = this.f138556a;
            if (iVar != null) {
                iVar.a(new C6639f(null, obj));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e implements r {
        e() {
        }

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C6639f invoke(C6639f c6639f) {
            Object a16 = c6639f.a();
            String b16 = c6639f.b();
            if (b16 != null && b16.length() != 0) {
                r rVar = (r) w.a(b16, r.class);
                if (rVar == null) {
                    com.tencent.luggage.wxa.ta.c.e("IPC.XIPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", b16);
                    return new C6639f(null, null);
                }
                return new C6639f(null, rVar.invoke(a16));
            }
            com.tencent.luggage.wxa.ta.c.b("IPC.XIPCInvoker", "proxy SyncInvoke failed, class is null or nil.", new Object[0]);
            return new C6639f(null, null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qa.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6639f implements Parcelable {
        public static final Parcelable.Creator<C6639f> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f138558a;

        /* renamed from: b, reason: collision with root package name */
        public Object f138559b;

        public /* synthetic */ C6639f(a aVar) {
            this();
        }

        public void a(Parcel parcel) {
            this.f138558a = parcel.readString();
            if (parcel.readInt() == 1) {
                this.f138559b = com.tencent.luggage.wxa.qa.c.a(parcel.readString(), parcel);
            }
        }

        public String b() {
            return this.f138558a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            com.tencent.luggage.wxa.qa.a a16;
            parcel.writeString(this.f138558a);
            Object obj = this.f138559b;
            if (obj != null && (a16 = com.tencent.luggage.wxa.qa.c.a(obj)) != null) {
                parcel.writeInt(1);
                parcel.writeString(a16.getName());
                a16.a(this.f138559b, parcel);
                return;
            }
            parcel.writeInt(0);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.qa.f$f$a */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6639f createFromParcel(Parcel parcel) {
                C6639f c6639f = new C6639f(null);
                c6639f.a(parcel);
                return c6639f;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6639f[] newArray(int i3) {
                return new C6639f[i3];
            }
        }

        public C6639f() {
        }

        public C6639f(String str, Object obj) {
            this.f138558a = str;
            this.f138559b = obj;
        }

        public Object a() {
            return this.f138559b;
        }
    }

    public static void a(String str, Object obj, Class cls, i iVar) {
        boolean z16;
        try {
            z16 = com.tencent.luggage.wxa.ta.a.a(cls, com.tencent.luggage.wxa.na.a.class);
        } catch (Exception unused) {
            z16 = false;
        }
        boolean z17 = z16 || iVar == null;
        o.a(str, new C6639f(cls.getName(), obj), z17 ? c.class : b.class, iVar == null ? null : new a(z17, iVar));
    }

    public static Object a(String str, Object obj, Class cls) {
        C6639f c6639f = (C6639f) o.a(str, new C6639f(cls.getName(), obj), e.class);
        if (c6639f == null) {
            com.tencent.luggage.wxa.ta.c.e("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
            return null;
        }
        return c6639f.a();
    }
}
