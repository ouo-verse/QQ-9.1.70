package com.tencent.luggage.wxa.b4;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qbar.QbarNative;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends QbarNative.QBarPoint implements Parcelable {

    @NotNull
    public static final a CREATOR = new a(null);

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

    public c() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.point_cnt);
        parcel.writeFloat(this.f342416x0);
        parcel.writeFloat(this.f342417x1);
        parcel.writeFloat(this.f342418x2);
        parcel.writeFloat(this.f342419x3);
        parcel.writeFloat(this.f342420y0);
        parcel.writeFloat(this.f342421y1);
        parcel.writeFloat(this.f342422y2);
        parcel.writeFloat(this.f342423y3);
    }

    public c(QbarNative.QBarPoint qBarPoint) {
        if (qBarPoint == null) {
            return;
        }
        this.point_cnt = qBarPoint.point_cnt;
        this.f342416x0 = qBarPoint.f342416x0;
        this.f342417x1 = qBarPoint.f342417x1;
        this.f342418x2 = qBarPoint.f342418x2;
        this.f342419x3 = qBarPoint.f342419x3;
        this.f342420y0 = qBarPoint.f342420y0;
        this.f342421y1 = qBarPoint.f342421y1;
        this.f342422y2 = qBarPoint.f342422y2;
        this.f342423y3 = qBarPoint.f342423y3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.point_cnt = parcel.readInt();
        this.f342416x0 = parcel.readFloat();
        this.f342417x1 = parcel.readFloat();
        this.f342418x2 = parcel.readFloat();
        this.f342419x3 = parcel.readFloat();
        this.f342420y0 = parcel.readFloat();
        this.f342421y1 = parcel.readFloat();
        this.f342422y2 = parcel.readFloat();
        this.f342423y3 = parcel.readFloat();
    }
}
