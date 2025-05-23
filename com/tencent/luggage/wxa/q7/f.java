package com.tencent.luggage.wxa.q7;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final WxaExtendApiJSBridge.ErrMsg f137958a;

    /* renamed from: b, reason: collision with root package name */
    public final String f137959b;

    /* renamed from: c, reason: collision with root package name */
    public final String f137960c;

    /* renamed from: d, reason: collision with root package name */
    public final String f137961d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new f(d.f137947a.create(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public f(WxaExtendApiJSBridge.ErrMsg errMsg, String str, String str2, String str3) {
        this.f137958a = errMsg;
        this.f137959b = str;
        this.f137960c = str2;
        this.f137961d = str3;
    }

    public final WxaExtendApiJSBridge.ErrMsg a() {
        return this.f137958a;
    }

    public final String b() {
        return this.f137959b;
    }

    public final String c() {
        return this.f137960c;
    }

    public final String d() {
        return this.f137961d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f137958a == fVar.f137958a && Intrinsics.areEqual(this.f137959b, fVar.f137959b) && Intrinsics.areEqual(this.f137960c, fVar.f137960c) && Intrinsics.areEqual(this.f137961d, fVar.f137961d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        WxaExtendApiJSBridge.ErrMsg errMsg = this.f137958a;
        int i3 = 0;
        if (errMsg == null) {
            hashCode = 0;
        } else {
            hashCode = errMsg.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.f137959b;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.f137960c;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.f137961d;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i18 + i3;
    }

    public String toString() {
        return "ParcelizedCallbackData(errMsg=" + this.f137958a + ", errDescription=" + this.f137959b + ", data=" + this.f137960c + ", callbackKey=" + this.f137961d + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        d.f137947a.write(this.f137958a, out, i3);
        out.writeString(this.f137959b);
        out.writeString(this.f137960c);
        out.writeString(this.f137961d);
    }
}
