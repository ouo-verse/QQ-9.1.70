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
public class h0 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f125797a;

    /* renamed from: b, reason: collision with root package name */
    public ResultReceiver f125798b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f125796c = new a(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<h0> CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fd.h0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public enum EnumC6209a {
            STATUS_CHANGED,
            HEIGHT_CHANGED,
            OPEN,
            CLOSE,
            RElEASE,
            RESUME,
            PAUSE
        }

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
        public h0 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new h0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h0[] newArray(int i3) {
            return new h0[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends ResultReceiver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i3, Bundle bundle) {
            int i16;
            y yVar;
            if (bundle != null) {
                bundle.setClassLoader(y.CREATOR.getClass().getClassLoader());
            }
            int i17 = -1;
            if (bundle != null) {
                i16 = bundle.getInt("action", -1);
            } else {
                i16 = -1;
            }
            if (i16 == a.EnumC6209a.STATUS_CHANGED.ordinal()) {
                if (bundle != null) {
                    i17 = bundle.getInt("status", -1);
                }
                if (i17 != 0) {
                    if (i17 == 1) {
                        h0.this.a();
                        return;
                    }
                    return;
                }
                h0.this.b();
                return;
            }
            if (i16 == a.EnumC6209a.HEIGHT_CHANGED.ordinal()) {
                if (bundle != null && (yVar = (y) bundle.getParcelable("height_info")) != null) {
                    h0.this.a(yVar);
                    return;
                }
                return;
            }
            boolean z16 = false;
            if (i16 == a.EnumC6209a.OPEN.ordinal()) {
                h0 h0Var = h0.this;
                if (bundle != null) {
                    z16 = bundle.getBoolean("isAnimationBegin", false);
                }
                h0Var.b(z16);
                return;
            }
            if (i16 == a.EnumC6209a.CLOSE.ordinal()) {
                h0 h0Var2 = h0.this;
                if (bundle != null) {
                    z16 = bundle.getBoolean("isAnimationBegin", false);
                }
                h0Var2.a(z16);
                return;
            }
            if (i16 == a.EnumC6209a.RElEASE.ordinal()) {
                h0.this.e();
            } else if (i16 == a.EnumC6209a.RESUME.ordinal()) {
                h0.this.d();
            } else if (i16 == a.EnumC6209a.PAUSE.ordinal()) {
                h0.this.c();
            }
        }
    }

    public h0(boolean z16) {
        this.f125797a = z16;
        this.f125798b = new c(new Handler(Looper.getMainLooper()));
    }

    public void a() {
    }

    public void b() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e() {
        this.f125798b = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ResultReceiver resultReceiver = this.f125798b;
        if (resultReceiver != null) {
            resultReceiver.writeToParcel(parcel, i3);
        }
        parcel.writeInt(this.f125797a ? 1 : 0);
    }

    public void a(boolean z16) {
    }

    public void b(boolean z16) {
    }

    public /* synthetic */ h0(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public void a(y info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h0(Parcel parcel) {
        this(false, 1, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f125798b = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        this.f125797a = parcel.readInt() == 1;
    }

    public void c() {
    }

    public void d() {
    }
}
