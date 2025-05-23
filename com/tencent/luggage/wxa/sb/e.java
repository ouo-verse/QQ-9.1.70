package com.tencent.luggage.wxa.sb;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f140268a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140269b;

    /* renamed from: c, reason: collision with root package name */
    public final String f140270c;

    /* renamed from: d, reason: collision with root package name */
    public final String f140271d;

    /* renamed from: e, reason: collision with root package name */
    public final String f140272e;

    /* renamed from: f, reason: collision with root package name */
    public final String f140273f;

    /* renamed from: g, reason: collision with root package name */
    public final String f140274g;

    /* renamed from: h, reason: collision with root package name */
    public final String f140275h;

    /* renamed from: i, reason: collision with root package name */
    public final String f140276i;

    /* renamed from: j, reason: collision with root package name */
    public final String f140277j;

    /* renamed from: k, reason: collision with root package name */
    public final String f140278k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f140267l = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
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

    public e(String PopupTitle, String PopupAllow, String PopupCancel, String PopupBottom, String ExampleTitle, String AlwaysReject, String PopupDesc, String SendWording, String MultiRemind, String WxaMultiRemind, String SendBelowMsg) {
        Intrinsics.checkNotNullParameter(PopupTitle, "PopupTitle");
        Intrinsics.checkNotNullParameter(PopupAllow, "PopupAllow");
        Intrinsics.checkNotNullParameter(PopupCancel, "PopupCancel");
        Intrinsics.checkNotNullParameter(PopupBottom, "PopupBottom");
        Intrinsics.checkNotNullParameter(ExampleTitle, "ExampleTitle");
        Intrinsics.checkNotNullParameter(AlwaysReject, "AlwaysReject");
        Intrinsics.checkNotNullParameter(PopupDesc, "PopupDesc");
        Intrinsics.checkNotNullParameter(SendWording, "SendWording");
        Intrinsics.checkNotNullParameter(MultiRemind, "MultiRemind");
        Intrinsics.checkNotNullParameter(WxaMultiRemind, "WxaMultiRemind");
        Intrinsics.checkNotNullParameter(SendBelowMsg, "SendBelowMsg");
        this.f140268a = PopupTitle;
        this.f140269b = PopupAllow;
        this.f140270c = PopupCancel;
        this.f140271d = PopupBottom;
        this.f140272e = ExampleTitle;
        this.f140273f = AlwaysReject;
        this.f140274g = PopupDesc;
        this.f140275h = SendWording;
        this.f140276i = MultiRemind;
        this.f140277j = WxaMultiRemind;
        this.f140278k = SendBelowMsg;
    }

    public final String a() {
        return this.f140272e;
    }

    public final String b() {
        return this.f140269b;
    }

    public final String c() {
        return this.f140271d;
    }

    public final String d() {
        return this.f140270c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f140268a;
    }

    public String toString() {
        return "WordingInfo(PopupTitle='" + this.f140268a + "', PopupAllow='" + this.f140269b + "', PopupCancel='" + this.f140270c + "', PopupBottom='" + this.f140271d + "', ExampleTitle='" + this.f140272e + "', AlwaysReject='" + this.f140273f + "', PopupDesc='" + this.f140274g + "', SendWording='" + this.f140275h + "', MultiRemind='" + this.f140276i + "', WxaMultiRemind='" + this.f140277j + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f140268a);
        parcel.writeString(this.f140269b);
        parcel.writeString(this.f140270c);
        parcel.writeString(this.f140271d);
        parcel.writeString(this.f140272e);
        parcel.writeString(this.f140273f);
        parcel.writeString(this.f140274g);
        parcel.writeString(this.f140275h);
        parcel.writeString(this.f140276i);
        parcel.writeString(this.f140277j);
        parcel.writeString(this.f140278k);
    }

    public e(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.f140268a = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.f140269b = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.f140270c = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.f140271d = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.f140272e = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.f140273f = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.f140274g = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        this.f140275h = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        this.f140276i = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        this.f140277j = readString10 == null ? "" : readString10;
        String readString11 = parcel.readString();
        this.f140278k = readString11 != null ? readString11 : "";
    }
}
