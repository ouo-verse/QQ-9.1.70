package com.tencent.luggage.wxa.rf;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f139619a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f139620b = true;

    /* renamed from: c, reason: collision with root package name */
    public static e.c f139621c = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e.c {
        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onCreate() {
            w.d("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
            super.onCreate();
            b.a(b.f139619a, 21, null);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
            super.onDestroy();
            b.a(b.f139619a, 24, null);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
            super.onPause(dVar);
            b.a(b.f139619a, 23, null);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            w.d("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
            super.onResume();
            b.a(b.f139619a, 22, null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rf.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6685b extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<C6685b> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public int f139622c;

        /* renamed from: d, reason: collision with root package name */
        public String f139623d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f139624e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.rf.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6685b createFromParcel(Parcel parcel) {
                return new C6685b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6685b[] newArray(int i3) {
                return new C6685b[i3];
            }
        }

        public /* synthetic */ C6685b(String str, int i3, Bundle bundle, a aVar) {
            this(str, i3, bundle);
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            super.a(parcel);
            this.f139622c = parcel.readInt();
            this.f139623d = parcel.readString();
            this.f139624e = parcel.readBundle();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            super.g();
            f();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            w.d("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
            com.tencent.luggage.wxa.sf.b.f140347n.a(this.f139622c, this.f139623d, this.f139624e);
            a();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f139622c);
            parcel.writeString(this.f139623d);
            parcel.writeBundle(this.f139624e);
        }

        C6685b(String str, int i3, Bundle bundle) {
            this.f139622c = i3;
            this.f139623d = str;
            this.f139624e = bundle;
        }

        public C6685b(Parcel parcel) {
            a(parcel);
        }
    }

    public static void b(String str) {
        if (str != null) {
            com.tencent.luggage.wxa.ic.e.b(str, f139621c);
        }
    }

    public static void a(String str) {
        String str2 = f139619a;
        if (str2 != null && f139621c != null) {
            w.d("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", str2);
            com.tencent.luggage.wxa.ic.e.b(f139619a, f139621c);
        }
        f139619a = str;
        com.tencent.luggage.wxa.ic.e.a(str, f139621c);
    }

    public static boolean b() {
        boolean z16;
        synchronized (b.class) {
            z16 = f139620b;
        }
        return z16;
    }

    public static void a(boolean z16) {
        synchronized (b.class) {
            f139620b = z16;
        }
    }

    public static void a(String str, int i3, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        w.d("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", str, Integer.valueOf(i3));
        new C6685b(str, i3, bundle, null).b();
    }
}
