package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y implements Parcelable {

    @NotNull
    public static final a CREATOR = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f126069a;

    /* renamed from: b, reason: collision with root package name */
    public final int f126070b;

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
        public y createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new y(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public y[] newArray(int i3) {
            return new y[i3];
        }
    }

    public y(int i3, int i16) {
        this.f126069a = i3;
        this.f126070b = i16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "HeightInfo(currentHeight=" + this.f126069a + ", initialHeight=" + this.f126070b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.f126069a);
        parcel.writeInt(this.f126070b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
