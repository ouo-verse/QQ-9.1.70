package com.tencent.luggage.wxa.sb;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hn.ma;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements Parcelable {
    public final boolean C;
    public boolean D;
    public final String E;
    public final boolean F;
    public boolean G;
    public int H;

    /* renamed from: a, reason: collision with root package name */
    public final String f140254a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140255b;

    /* renamed from: c, reason: collision with root package name */
    public final String f140256c;

    /* renamed from: d, reason: collision with root package name */
    public final int f140257d;

    /* renamed from: e, reason: collision with root package name */
    public int f140258e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f140259f;

    /* renamed from: g, reason: collision with root package name */
    public int f140260g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f140261h;

    /* renamed from: i, reason: collision with root package name */
    public long f140262i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f140263j;

    /* renamed from: k, reason: collision with root package name */
    public final String f140264k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f140265l;

    /* renamed from: m, reason: collision with root package name */
    public final int f140266m;
    public static final b I = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new d(source);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(String str, String str2, int i3, int i16, ArrayList arrayList, int i17, boolean z16, String str3, String str4, boolean z17, int i18, boolean z18, boolean z19, String str5, boolean z26, boolean z27, int i19) {
        this.f140255b = str;
        this.f140256c = str2;
        this.f140257d = i3;
        this.f140258e = i16;
        this.f140259f = arrayList;
        this.f140260g = i17;
        this.f140261h = z16;
        this.f140262i = 0L;
        this.f140254a = str3;
        this.f140263j = false;
        this.f140264k = str4;
        this.f140266m = i18;
        this.f140265l = z17;
        this.C = z18;
        this.D = z19;
        this.E = str5;
        this.F = z26;
        this.G = z27;
        this.H = i19;
    }

    public final void a(int i3) {
        this.f140260g = i3;
    }

    public final int b() {
        return this.H;
    }

    public final int c() {
        return this.f140258e;
    }

    public final ArrayList d() {
        return this.f140259f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f140260g;
    }

    public final String f() {
        return this.f140256c;
    }

    public final int g() {
        return this.f140257d;
    }

    public final int h() {
        return this.f140266m;
    }

    public final String i() {
        return this.f140255b;
    }

    public final String j() {
        return this.f140264k;
    }

    public final boolean k() {
        return this.D;
    }

    public final boolean l() {
        return this.G;
    }

    public final boolean m() {
        return this.C;
    }

    public final boolean n() {
        return this.f140265l;
    }

    public final boolean o() {
        return this.F;
    }

    public final boolean p() {
        return this.f140261h;
    }

    public String toString() {
        return "SubscribeMsgTmpItem(title='" + this.f140255b + "', templateId='" + this.f140256c + "', templateType=" + this.f140257d + ", chooseStatus=" + this.f140258e + ", settingStatus=" + this.f140260g + ", settingStatus=" + this.f140260g + ", CREATOR=" + CREATOR + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f140255b);
        dest.writeString(this.f140256c);
        dest.writeInt(this.f140257d);
        dest.writeInt(this.f140258e);
        dest.writeInt(this.f140259f.size());
        Iterator it = this.f140259f.iterator();
        while (it.hasNext()) {
            dest.writeSerializable((Pair) it.next());
        }
        dest.writeInt(this.f140260g);
        dest.writeByte(this.f140261h ? (byte) 1 : (byte) 0);
        dest.writeLong(this.f140262i);
        dest.writeString(this.f140254a);
        dest.writeByte(this.f140263j ? (byte) 1 : (byte) 0);
        dest.writeString(this.f140264k);
        dest.writeInt(this.f140266m);
        dest.writeInt(this.f140265l ? 1 : 0);
        dest.writeInt(this.C ? 1 : 0);
        dest.writeInt(this.D ? 1 : 0);
        dest.writeString(this.E);
        dest.writeInt(this.F ? 1 : 0);
        dest.writeInt(this.G ? 1 : 0);
        dest.writeInt(this.H);
    }

    public final String a() {
        return this.E;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d(ma item, ArrayList keyWordList) {
        this(r3, r4, r5, r6, keyWordList, r8, r1, r11, r12, r13, r14, r17, r15, r9 == null ? "" : r9, item.f128190s == 1, item.f128191t == 1, item.f128193v);
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(keyWordList, "keyWordList");
        String str = item.f128178g;
        String str2 = str == null ? "" : str;
        String str3 = item.f128175d;
        String str4 = str3 == null ? "" : str3;
        int i3 = item.f128176e;
        int i16 = item.f128177f;
        int i17 = item.f128180i;
        boolean z16 = item.f128182k == 1;
        String str5 = item.f128184m;
        str5 = str5 == null ? "" : str5;
        String str6 = item.f128185n;
        str6 = str6 == null ? "" : str6;
        boolean z17 = item.f128183l == 1;
        int i18 = item.f128186o;
        boolean z18 = item.f128188q == 1;
        boolean z19 = item.f128187p == 1;
        String str7 = item.f128189r;
    }

    public d(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.f140255b = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.f140256c = readString2 == null ? "" : readString2;
        this.f140257d = parcel.readInt();
        this.f140258e = parcel.readInt();
        int readInt = parcel.readInt();
        this.f140259f = new ArrayList(readInt);
        while (readInt != 0) {
            try {
                ArrayList arrayList = this.f140259f;
                Serializable readSerializable = parcel.readSerializable();
                Intrinsics.checkNotNull(readSerializable, "null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
                arrayList.add((Pair) readSerializable);
                readInt--;
            } catch (InvalidClassException unused) {
            }
        }
        this.f140260g = parcel.readInt();
        this.f140261h = parcel.readByte() != 0;
        this.f140262i = parcel.readLong();
        String readString3 = parcel.readString();
        this.f140254a = readString3 == null ? "" : readString3;
        this.f140263j = parcel.readByte() != 0;
        String readString4 = parcel.readString();
        this.f140264k = readString4 == null ? "" : readString4;
        this.f140266m = parcel.readInt();
        this.f140265l = parcel.readInt() == 1;
        this.C = parcel.readInt() == 1;
        this.D = parcel.readInt() == 1;
        String readString5 = parcel.readString();
        this.E = readString5 != null ? readString5 : "";
        this.F = parcel.readInt() == 1;
        this.G = parcel.readInt() == 1;
        this.H = parcel.readInt();
    }
}
