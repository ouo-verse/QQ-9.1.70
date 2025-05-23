package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f125846a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f125845b = new a(null);

    @NotNull
    public static final Parcelable.Creator<m> CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new m(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m[] newArray(int i3) {
            return new m[i3];
        }
    }

    public m() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("chatToolMode", this.f125846a);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof m) && Intrinsics.areEqual(this.f125846a, ((m) obj).f125846a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f125846a.hashCode();
    }

    public String toString() {
        return "AppBrandLaunchModeParams(chatToolMode=" + this.f125846a + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f125846a);
    }

    public m(String chatToolMode) {
        Intrinsics.checkNotNullParameter(chatToolMode, "chatToolMode");
        this.f125846a = chatToolMode;
    }

    public /* synthetic */ m(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
