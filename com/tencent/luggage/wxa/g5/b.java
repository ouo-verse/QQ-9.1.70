package com.tencent.luggage.wxa.g5;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hn.mb;
import com.tencent.luggage.wxa.hn.nb;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable {

    @NotNull
    public static final a CREATOR = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f126429a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f126430b;

    /* renamed from: c, reason: collision with root package name */
    public int f126431c;

    /* renamed from: d, reason: collision with root package name */
    public int f126432d;

    /* renamed from: e, reason: collision with root package name */
    public String f126433e;

    /* renamed from: f, reason: collision with root package name */
    public String f126434f;

    /* renamed from: g, reason: collision with root package name */
    public String f126435g;

    /* renamed from: h, reason: collision with root package name */
    public String f126436h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

    public b(Parcel in5) {
        Intrinsics.checkNotNullParameter(in5, "in");
        this.f126429a = new ArrayList();
        ArrayList arrayList = new ArrayList();
        in5.readTypedList(arrayList, C6229b.CREATOR);
        this.f126429a = arrayList;
        this.f126430b = in5.readByte() != 0;
        this.f126431c = in5.readInt();
        this.f126432d = in5.readInt();
        this.f126433e = in5.readString();
        this.f126434f = in5.readString();
        this.f126435g = in5.readString();
        this.f126436h = in5.readString();
    }

    public final int a() {
        return this.f126431c;
    }

    public final ArrayList b() {
        return this.f126429a;
    }

    public final String c() {
        return this.f126435g;
    }

    public final int d() {
        return this.f126432d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f126436h;
    }

    public final boolean f() {
        return this.f126430b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeTypedList(this.f126429a);
        dest.writeByte(this.f126430b ? (byte) 1 : (byte) 0);
        dest.writeInt(this.f126431c);
        dest.writeInt(this.f126432d);
        dest.writeString(this.f126433e);
        dest.writeString(this.f126434f);
        dest.writeString(this.f126435g);
        dest.writeString(this.f126436h);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g5.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6229b implements Parcelable {

        @NotNull
        public static final a CREATOR = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public int f126437a;

        /* renamed from: b, reason: collision with root package name */
        public String f126438b;

        /* renamed from: c, reason: collision with root package name */
        public String f126439c;

        /* renamed from: d, reason: collision with root package name */
        public String f126440d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.g5.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6229b createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new C6229b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6229b[] newArray(int i3) {
                return new C6229b[i3];
            }
        }

        public C6229b(Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            this.f126438b = "";
            this.f126439c = "";
            this.f126437a = in5.readInt();
            String readString = in5.readString();
            this.f126438b = readString == null ? "" : readString;
            String readString2 = in5.readString();
            this.f126439c = readString2 == null ? "" : readString2;
            String readString3 = in5.readString();
            this.f126440d = readString3 != null ? readString3 : "";
        }

        public final String a() {
            return this.f126439c;
        }

        public final String b() {
            return this.f126440d;
        }

        public final int c() {
            return this.f126437a;
        }

        public final String d() {
            return this.f126438b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.f126437a);
            dest.writeString(this.f126438b);
            dest.writeString(this.f126439c);
            dest.writeString(this.f126440d);
        }

        public C6229b(nb item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.f126438b = "";
            this.f126439c = "";
            this.f126437a = item.f128290d;
            String str = item.f128291e;
            Intrinsics.checkNotNullExpressionValue(str, "item.nickname");
            this.f126438b = str;
            String str2 = item.f128292f;
            Intrinsics.checkNotNullExpressionValue(str2, "item.avatarurl");
            this.f126439c = str2;
            this.f126440d = item.f128293g;
        }
    }

    public b(mb avatar_info) {
        Intrinsics.checkNotNullParameter(avatar_info, "avatar_info");
        this.f126429a = new ArrayList();
        Iterator it = avatar_info.f128194d.iterator();
        while (it.hasNext()) {
            nb item = (nb) it.next();
            ArrayList arrayList = this.f126429a;
            Intrinsics.checkNotNullExpressionValue(item, "item");
            arrayList.add(new C6229b(item));
        }
        this.f126430b = avatar_info.f128195e;
        this.f126431c = avatar_info.f128196f;
        this.f126432d = avatar_info.f128197g;
        this.f126433e = avatar_info.f128198h;
        this.f126434f = avatar_info.f128199i;
        this.f126435g = avatar_info.f128200j;
        this.f126436h = avatar_info.f128201k;
    }
}
