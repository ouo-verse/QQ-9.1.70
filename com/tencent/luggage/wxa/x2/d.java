package com.tencent.luggage.wxa.x2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class d extends com.tencent.luggage.wxa.r5.a {
    public final boolean Y0;
    public static final b Z0 = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Parcel parcel) {
        super(parcel);
        boolean z16;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (parcel.readInt() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.Y0 = z16;
    }

    public final boolean v() {
        return this.Y0;
    }

    @Override // com.tencent.luggage.wxa.r5.a, com.tencent.luggage.wxa.j4.d, com.tencent.luggage.wxa.fd.i, android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, i3);
        dest.writeInt(this.Y0 ? 1 : 0);
    }
}
