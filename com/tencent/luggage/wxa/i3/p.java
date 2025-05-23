package com.tencent.luggage.wxa.i3;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.ui.WxaAlertActivity;
import com.tencent.luggage.wxa.n3.q;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p extends o {

    @NotNull
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f129345c;

    /* renamed from: d, reason: collision with root package name */
    public final String f129346d;

    /* renamed from: e, reason: collision with root package name */
    public final int f129347e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new p(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p[] newArray(int i3) {
            return new p[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f129348a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f129349b;

        public b(Activity activity, p pVar) {
            this.f129348a = activity;
            this.f129349b = pVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.f129348a.isDestroyed() && !this.f129348a.isFinishing()) {
                new MMAlertDialog.Builder(this.f129348a).setTitle(this.f129349b.f129346d).setMsg(this.f129349b.f129345c).setPositiveBtnText(R.string.f170383z25).setCancelable(false).show();
            } else {
                WxaAlertActivity.INSTANCE.a(this.f129348a, new q.a(this.f129349b.f129346d, this.f129349b.f129345c));
            }
        }
    }

    public p(String str, String str2, int i3) {
        super(i3);
        this.f129345c = str;
        this.f129346d = str2;
        this.f129347e = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f129345c);
        out.writeString(this.f129346d);
        out.writeInt(this.f129347e);
    }

    @Override // com.tencent.luggage.wxa.i3.o
    public int a() {
        return this.f129347e;
    }

    @Override // com.tencent.luggage.wxa.i3.o
    public void a(Activity activity, com.tencent.luggage.wxa.wj.c windowAndroid) {
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        if (activity != null) {
            activity.runOnUiThread(new b(activity, this));
        } else {
            WxaAlertActivity.INSTANCE.a(null, new q.a(this.f129346d, this.f129345c));
        }
    }
}
