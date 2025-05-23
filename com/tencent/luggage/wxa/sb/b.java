package com.tencent.luggage.wxa.sb;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ub.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable {

    /* renamed from: e, reason: collision with root package name */
    public static final int f140225e = 0;

    /* renamed from: j, reason: collision with root package name */
    public static final int f140230j = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f140231a;

    /* renamed from: b, reason: collision with root package name */
    public int f140232b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f140233c;

    /* renamed from: d, reason: collision with root package name */
    public static final C6711b f140224d = new C6711b(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f140226f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final int f140227g = 2;

    /* renamed from: h, reason: collision with root package name */
    public static final int f140228h = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final int f140229i = 1;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sb.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6711b {
        public C6711b() {
        }

        public /* synthetic */ C6711b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f140230j;
        }

        public final int b() {
            return b.f140229i;
        }

        public final int c() {
            return b.f140227g;
        }

        public final int d() {
            return b.f140226f;
        }

        public final int e() {
            return b.f140228h;
        }

        public final b a(int i3, List itemsShowOnDialog, boolean z16) {
            int d16;
            Intrinsics.checkNotNullParameter(itemsShowOnDialog, "itemsShowOnDialog");
            b bVar = new b();
            bVar.a(z16 ? b() : a());
            if (i3 == 1) {
                d16 = d();
            } else if (i3 != 3) {
                d16 = c();
            } else {
                d16 = e();
            }
            bVar.b(d16);
            Iterator it = itemsShowOnDialog.iterator();
            while (it.hasNext()) {
                d.j jVar = (d.j) it.next();
                ArrayList g16 = bVar.g();
                c cVar = new c();
                cVar.a(jVar.c());
                cVar.a(jVar.a() ? c.f140234e.a() : c.f140234e.b());
                if (jVar instanceof d.m) {
                    cVar.a(((d.m) jVar).e());
                } else if (jVar instanceof d.l) {
                    cVar.b(((d.l) jVar).e());
                }
                g16.add(cVar);
            }
            return bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Parcelable {

        /* renamed from: g, reason: collision with root package name */
        public static final int f140236g = 0;

        /* renamed from: a, reason: collision with root package name */
        public String f140237a;

        /* renamed from: b, reason: collision with root package name */
        public int f140238b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f140239c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f140240d;

        /* renamed from: e, reason: collision with root package name */
        public static final C6712b f140234e = new C6712b(null);

        /* renamed from: f, reason: collision with root package name */
        public static final int f140235f = 1;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.sb.b$c$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6712b {
            public C6712b() {
            }

            public /* synthetic */ C6712b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.f140235f;
            }

            public final int b() {
                return c.f140236g;
            }
        }

        public c() {
            this.f140237a = "";
        }

        public final int c() {
            return this.f140238b;
        }

        public final boolean d() {
            return this.f140240d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f140237a;
        }

        public final boolean f() {
            return this.f140239c;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f140237a);
            parcel.writeInt(this.f140238b);
            parcel.writeInt(this.f140239c ? 1 : 0);
            parcel.writeInt(this.f140240d ? 1 : 0);
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f140237a = str;
        }

        public final void b(boolean z16) {
            this.f140240d = z16;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            this.f140237a = readString == null ? "" : readString;
            this.f140238b = parcel.readInt();
            this.f140239c = parcel.readInt() == 1;
            this.f140240d = parcel.readInt() == 0;
        }

        public final void a(int i3) {
            this.f140238b = i3;
        }

        public final void a(boolean z16) {
            this.f140239c = z16;
        }
    }

    public b() {
        this.f140231a = f140225e;
        this.f140233c = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int f() {
        return this.f140231a;
    }

    public final ArrayList g() {
        return this.f140233c;
    }

    public final int h() {
        return this.f140232b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.f140231a);
        parcel.writeInt(this.f140232b);
        parcel.writeList(this.f140233c);
    }

    public final void a(int i3) {
        this.f140232b = i3;
    }

    public final void b(int i3) {
        this.f140231a = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f140231a = parcel.readInt();
        this.f140232b = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, c.class.getClassLoader());
        this.f140233c = arrayList;
    }
}
