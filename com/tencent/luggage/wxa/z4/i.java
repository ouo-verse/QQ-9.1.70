package com.tencent.luggage.wxa.z4;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum i implements Parcelable {
    WASERVICE,
    WAGAME,
    NIL;


    /* renamed from: b, reason: collision with root package name */
    public static final i f146316b = null;

    /* renamed from: a, reason: collision with root package name */
    public static final a f146315a = new a(null);

    @NotNull
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator() { // from class: com.tencent.luggage.wxa.z4.i.b
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return i.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i[] newArray(int i3) {
            return new i[i3];
        }
    };

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return i.f146316b;
        }

        public final i a(boolean z16) {
            if (z16) {
                return i.WAGAME;
            }
            return i.WASERVICE;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(name());
    }
}
