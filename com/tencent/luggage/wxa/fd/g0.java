package com.tencent.luggage.wxa.fd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g0 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public ResultReceiver f125720a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f125719b = new c(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<g0> CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        EXPOSE,
        CLICK_CLOSE
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g0 createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new g0(source);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g0[] newArray(int i3) {
            return new g0[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends ResultReceiver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i3, Bundle bundle) {
            int i16 = -1;
            if (bundle != null) {
                i16 = bundle.getInt("action", -1);
            }
            if (i16 == a.EXPOSE.ordinal()) {
                g0.this.b();
            } else if (i16 == a.CLICK_CLOSE.ordinal()) {
                g0.this.a();
            }
        }
    }

    public g0() {
        this.f125720a = new d(new Handler(Looper.getMainLooper()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ResultReceiver resultReceiver = this.f125720a;
        if (resultReceiver != null) {
            resultReceiver.writeToParcel(dest, i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g0(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f125720a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
    }

    public void a() {
    }

    public void b() {
    }
}
