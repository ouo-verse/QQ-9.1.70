package com.tencent.luggage.wxa.sb;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hn.c6;
import com.tencent.luggage.wxa.hn.ma;
import com.tencent.luggage.wxa.hn.oa;
import com.tencent.luggage.wxa.hn.pa;
import com.tencent.luggage.wxa.hn.ra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements Parcelable {
    public final com.tencent.luggage.wxa.sb.a C;
    public final String D;
    public final String E;
    public final int F;
    public final String G;
    public final boolean H;
    public final String I;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f140241a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140242b;

    /* renamed from: c, reason: collision with root package name */
    public final String f140243c;

    /* renamed from: d, reason: collision with root package name */
    public final int f140244d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f140245e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f140246f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f140247g;

    /* renamed from: h, reason: collision with root package name */
    public final e f140248h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f140249i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f140250j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f140251k;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f140252l;

    /* renamed from: m, reason: collision with root package name */
    public final int f140253m;
    public static final b J = new b(null);

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
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a(oa response) {
            boolean z16;
            String str;
            String str2;
            boolean z17;
            boolean z18;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            boolean z19;
            boolean z26;
            boolean z27;
            byte[] bArr;
            int i3;
            String str25;
            String str26;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            Intrinsics.checkNotNullParameter(response, "response");
            ArrayList arrayList = new ArrayList();
            LinkedList<ma> linkedList = response.f128347e;
            Intrinsics.checkNotNullExpressionValue(linkedList, "response.InfoList");
            for (ma it : linkedList) {
                ArrayList arrayList2 = new ArrayList();
                LinkedList<c6> linkedList2 = it.f128179h;
                Intrinsics.checkNotNullExpressionValue(linkedList2, "it.KeyWordList");
                for (c6 c6Var : linkedList2) {
                    arrayList2.add(new Pair(c6Var.f127387d, c6Var.f127388e));
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new d(it, arrayList2));
            }
            if (response.f128352j == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            String str32 = response.f128350h;
            if (str32 == null) {
                str = "";
            } else {
                str = str32;
            }
            String str33 = response.f128349g;
            if (str33 == null) {
                str2 = "";
            } else {
                str2 = str33;
            }
            int i16 = response.f128353k;
            if (response.f128351i == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (response.f128364v == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            ra raVar = response.f128348f;
            String str34 = null;
            if (raVar != null) {
                str3 = raVar.f128600d;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            if (raVar != null) {
                str5 = raVar.f128601e;
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str6 = "";
            } else {
                str6 = str5;
            }
            if (raVar != null) {
                str7 = raVar.f128602f;
            } else {
                str7 = null;
            }
            if (str7 == null) {
                str8 = "";
            } else {
                str8 = str7;
            }
            if (raVar != null) {
                str9 = raVar.f128603g;
            } else {
                str9 = null;
            }
            if (str9 == null) {
                str10 = "";
            } else {
                str10 = str9;
            }
            if (raVar != null) {
                str11 = raVar.f128604h;
            } else {
                str11 = null;
            }
            if (str11 == null) {
                str12 = "";
            } else {
                str12 = str11;
            }
            if (raVar != null) {
                str13 = raVar.f128605i;
            } else {
                str13 = null;
            }
            if (str13 == null) {
                str14 = "";
            } else {
                str14 = str13;
            }
            if (raVar != null) {
                str15 = raVar.f128606j;
            } else {
                str15 = null;
            }
            if (str15 == null) {
                str16 = "";
            } else {
                str16 = str15;
            }
            if (raVar != null) {
                str17 = raVar.f128607k;
            } else {
                str17 = null;
            }
            if (str17 == null) {
                str18 = "";
            } else {
                str18 = str17;
            }
            if (raVar != null) {
                str19 = raVar.f128608l;
            } else {
                str19 = null;
            }
            if (str19 == null) {
                str20 = "";
            } else {
                str20 = str19;
            }
            if (raVar != null) {
                str21 = raVar.f128609m;
            } else {
                str21 = null;
            }
            if (str21 == null) {
                str22 = "";
            } else {
                str22 = str21;
            }
            if (raVar != null) {
                str23 = raVar.f128610n;
            } else {
                str23 = null;
            }
            if (str23 == null) {
                str24 = "";
            } else {
                str24 = str23;
            }
            e eVar = new e(str4, str6, str8, str10, str12, str14, str16, str18, str20, str22, str24);
            if (response.f128354l == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (response.f128355m == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (response.f128366x == 1) {
                z27 = true;
            } else {
                z27 = false;
            }
            com.tencent.luggage.wxa.fn.c cVar = response.f128356n;
            if (cVar != null) {
                bArr = cVar.c();
            } else {
                bArr = null;
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            byte[] bArr2 = bArr;
            int i17 = response.f128362t;
            pa paVar = response.f128363u;
            if (paVar != null) {
                i3 = paVar.f128427d;
            } else {
                i3 = -1;
            }
            if (paVar != null) {
                str25 = "";
                str26 = paVar.f128428e;
            } else {
                str25 = "";
                str26 = null;
            }
            if (str26 == null) {
                str26 = str25;
            }
            if (paVar != null) {
                str34 = paVar.f128429f;
            }
            if (str34 == null) {
                str27 = str25;
            } else {
                str27 = str34;
            }
            com.tencent.luggage.wxa.sb.a aVar = new com.tencent.luggage.wxa.sb.a(i3, str26, str27);
            String str35 = response.f128360r;
            if (str35 == null) {
                str28 = str25;
            } else {
                str28 = str35;
            }
            String str36 = response.f128361s;
            if (str36 == null) {
                str29 = str25;
            } else {
                str29 = str36;
            }
            int i18 = response.f128357o;
            String str37 = response.f128358p;
            if (str37 == null) {
                str30 = str25;
            } else {
                str30 = str37;
            }
            boolean z28 = response.f128359q;
            String str38 = response.f128365w;
            if (str38 == null) {
                str31 = str25;
            } else {
                str31 = str38;
            }
            return new c(z16, str, str2, i16, arrayList, z17, z18, eVar, z19, z26, z27, bArr2, i17, aVar, str28, str29, i18, str30, z28, str31);
        }
    }

    public c(boolean z16, String appIconUrl, String appName, int i3, ArrayList subscribeMsgItems, boolean z17, boolean z18, e eVar, boolean z19, boolean z26, boolean z27, byte[] buffer, int i16, com.tencent.luggage.wxa.sb.a aVar, String str, String str2, int i17, String wxaErrorMessage, boolean z28, String extData) {
        Intrinsics.checkNotNullParameter(appIconUrl, "appIconUrl");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(subscribeMsgItems, "subscribeMsgItems");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(wxaErrorMessage, "wxaErrorMessage");
        Intrinsics.checkNotNullParameter(extData, "extData");
        this.f140241a = z16;
        this.f140242b = appIconUrl;
        this.f140243c = appName;
        this.f140244d = i3;
        this.f140245e = subscribeMsgItems;
        this.f140246f = z17;
        this.f140247g = z18;
        this.f140248h = eVar;
        this.f140249i = z19;
        this.f140250j = z26;
        this.f140251k = z27;
        this.f140252l = buffer;
        this.f140253m = i16;
        this.C = aVar;
        this.D = str;
        this.E = str2;
        this.F = i17;
        this.G = wxaErrorMessage;
        this.H = z28;
        this.I = extData;
    }

    public final boolean a() {
        return this.f140241a;
    }

    public final String b() {
        return this.f140242b;
    }

    public final String c() {
        return this.f140243c;
    }

    public final byte[] d() {
        return this.f140252l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.D;
    }

    public final boolean f() {
        return this.f140250j;
    }

    public final int g() {
        return this.f140253m;
    }

    public final String h() {
        return this.E;
    }

    public final ArrayList i() {
        return this.f140245e;
    }

    public final e j() {
        return this.f140248h;
    }

    public final int k() {
        return this.F;
    }

    public final String l() {
        return this.G;
    }

    public final boolean m() {
        return this.H;
    }

    public final boolean n() {
        return this.f140249i;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SubscribeMsgRequestResult(alwaysChosenStatus=");
        sb5.append(this.f140241a);
        sb5.append(", appIconUrl='");
        sb5.append(this.f140242b);
        sb5.append("', appName='");
        sb5.append(this.f140243c);
        sb5.append("', cacheMaxSize=");
        sb5.append(this.f140244d);
        sb5.append(", subscribeMsgItems=");
        sb5.append(this.f140245e);
        sb5.append(", notShowAlways=");
        sb5.append(this.f140246f);
        sb5.append(", notShowReject=");
        sb5.append(this.f140247g);
        sb5.append(", wordingInfo=");
        sb5.append(this.f140248h);
        sb5.append(", isOpened=");
        sb5.append(this.f140249i);
        sb5.append(", showEntry=");
        sb5.append(this.f140250j);
        sb5.append(", buffer=");
        String arrays = Arrays.toString(this.f140252l);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb5.append(arrays);
        sb5.append(", showStyle=");
        sb5.append(this.f140253m);
        sb5.append(", showInfo=");
        sb5.append(this.C);
        sb5.append(", mainDescription=");
        sb5.append(this.D);
        sb5.append(", subDescription=");
        sb5.append(this.E);
        sb5.append(", wxaErrorCode=");
        sb5.append(this.F);
        sb5.append(", wxaErrorMessage='");
        sb5.append(this.G);
        sb5.append("', wxaUserCancel=");
        sb5.append(this.H);
        sb5.append(", extData='");
        sb5.append(this.I);
        sb5.append("')");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.f140241a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f140242b);
        parcel.writeString(this.f140243c);
        parcel.writeInt(this.f140244d);
        parcel.writeParcelable(this.f140248h, i3);
        parcel.writeList(this.f140245e);
        parcel.writeByte(this.f140246f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f140249i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f140250j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f140251k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f140252l.length);
        parcel.writeByteArray(this.f140252l);
        parcel.writeInt(this.f140253m);
        parcel.writeParcelable(this.C, i3);
        String str = this.D;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        String str3 = this.E;
        if (str3 != null) {
            str2 = str3;
        }
        parcel.writeString(str2);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeByte(this.H ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f140247g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.I);
    }

    public c(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f140241a = parcel.readByte() != 0;
        String readString = parcel.readString();
        this.f140242b = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.f140243c = readString2 == null ? "" : readString2;
        this.f140244d = parcel.readInt();
        this.f140248h = (e) parcel.readParcelable(e.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, d.class.getClassLoader());
        this.f140245e = arrayList;
        this.f140246f = parcel.readByte() != 0;
        this.f140249i = parcel.readByte() != 0;
        this.f140250j = parcel.readByte() != 0;
        this.f140251k = parcel.readByte() != 0;
        byte[] bArr = new byte[parcel.readInt()];
        this.f140252l = bArr;
        parcel.readByteArray(bArr);
        this.f140253m = parcel.readInt();
        this.C = (com.tencent.luggage.wxa.sb.a) parcel.readParcelable(com.tencent.luggage.wxa.sb.a.class.getClassLoader());
        String readString3 = parcel.readString();
        this.D = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.E = readString4 == null ? "" : readString4;
        this.F = parcel.readInt();
        String readString5 = parcel.readString();
        this.G = readString5 == null ? "" : readString5;
        this.H = parcel.readByte() != 0;
        this.f140247g = parcel.readByte() != 0;
        String readString6 = parcel.readString();
        this.I = readString6 != null ? readString6 : "";
    }
}
