package com.tencent.luggage.wxa.i3;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.ui.WxaAppLibNotSupportTipsUI;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r extends o {

    @NotNull
    public static final Parcelable.Creator<r> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f129352c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new r(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r[] newArray(int i3) {
            return new r[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String appId) {
        super(1);
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f129352c = appId;
    }

    @Override // com.tencent.luggage.wxa.i3.o
    public void a(Activity activity, com.tencent.luggage.wxa.wj.c windowAndroid) {
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        WxaAppLibNotSupportTipsUI.INSTANCE.a(activity, this.f129352c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f129352c);
    }
}
