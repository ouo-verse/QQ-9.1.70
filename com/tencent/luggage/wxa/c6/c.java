package com.tencent.luggage.wxa.c6;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.c6.b;
import com.tencent.luggage.wxa.n3.v;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.o3.j;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static com.tencent.luggage.wxa.xn.b f123346d;

    /* renamed from: a, reason: collision with root package name */
    public static final c f123343a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final C6099c f123344b = new C6099c();

    /* renamed from: c, reason: collision with root package name */
    public static com.tencent.luggage.wxa.w4.a f123345c = new a();

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f123347e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public static final LinkedList f123348f = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.w4.a {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6098a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.c6.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6098a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return new a();
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a[] newArray(int i3) {
                return new a[i3];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return -324425987;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f123349a;

        public b(String[] sqlitecreate) {
            Intrinsics.checkNotNullParameter(sqlitecreate, "sqlitecreate");
            this.f123349a = sqlitecreate;
        }

        public final String[] a() {
            return this.f123349a;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(b.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.luggage.storage.WxaUserIsolatedDB.StorageCreateSpecs");
            if (Arrays.equals(this.f123349a, ((b) obj).f123349a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f123349a);
        }

        public String toString() {
            return "StorageCreateSpecs(sqlitecreate=" + Arrays.toString(this.f123349a) + ')';
        }
    }

    public final synchronized void b(com.tencent.luggage.wxa.w4.a aVar) {
        boolean z16 = !Intrinsics.areEqual(f123345c, aVar);
        f123345c = aVar;
        if (z16) {
            c();
        }
    }

    public final void c() {
        if (b()) {
            f123347e.clear();
            com.tencent.luggage.wxa.xn.b bVar = f123346d;
            if (bVar != null) {
                bVar.close();
            }
            f123346d = null;
            File databasePath = z.c().getDatabasePath(a(f123345c));
            com.tencent.luggage.wxa.c6.a aVar = new com.tencent.luggage.wxa.c6.a(SQLiteDatabase.D(databasePath, null));
            f123346d = aVar;
            Intrinsics.checkNotNull(aVar);
            w.d("Luggage.WxaUserIsolatedDB", "reInitializeOrCloseDB init with userId:" + f123345c + ", dbPath:" + databasePath);
            for (Pair pair : f123348f) {
                b.s sVar = (b.s) pair.component1();
                for (String str : ((b) pair.component2()).a()) {
                    aVar.a((String) null, str);
                }
                Object storage = sVar.a(aVar);
                HashMap hashMap = f123347e;
                Class<?> cls = storage.getClass();
                Intrinsics.checkNotNullExpressionValue(storage, "storage");
                hashMap.put(cls, storage);
            }
            return;
        }
        w.d("Luggage.WxaUserIsolatedDB", "reInitializeOrCloseDB close db");
        f123347e.clear();
        com.tencent.luggage.wxa.xn.b bVar2 = f123346d;
        if (bVar2 != null) {
            bVar2.close();
        }
        f123346d = null;
    }

    public final void a() {
        j a16;
        l lVar = l.f136139a;
        if (lVar.c() && (a16 = lVar.a()) != null && a16.h() != 0) {
            b(new v(a16.h()));
        }
        lVar.b(f123344b);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c6.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6099c implements e.a {
        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a(j jVar) {
            j a16 = l.f136139a.a();
            Intrinsics.checkNotNull(a16);
            v vVar = new v(a16.h());
            w.d("Luggage.WxaUserIsolatedDB", "onAccountLogin with uin:" + vVar);
            c.f123343a.b(vVar);
        }

        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a() {
            w.d("Luggage.WxaUserIsolatedDB", "onAccountLogout");
            c.f123343a.b(new a());
        }
    }

    public final boolean b() {
        return !(f123345c instanceof a);
    }

    public final Object a(Class clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!b()) {
            w.f("Luggage.WxaUserIsolatedDB", "getStorage with clazz:" + clazz + ", account not ready");
            return null;
        }
        Object obj = f123347e.get(clazz);
        if (obj != null) {
            return obj;
        }
        return null;
    }

    public final void a(b.s creator, String[] sqlcreate) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(sqlcreate, "sqlcreate");
        f123348f.add(TuplesKt.to(creator, new b(sqlcreate)));
    }

    public final String a(com.tencent.luggage.wxa.w4.a aVar) {
        return "wxa_" + aVar.hashCode() + "_user.db";
    }
}
