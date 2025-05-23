package com.tencent.libra.extension.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    final long[][] f118742d;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<GifViewSavedState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState[] newArray(int i3) {
            return new GifViewSavedState[i3];
        }
    }

    /* synthetic */ GifViewSavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable, int i3) {
        if (this.f118742d[i3] != null && (drawable instanceof GifDrawable)) {
            ((GifDrawable) drawable).p(r3.C.A(r4, r3.f118727m));
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f118742d.length);
        for (long[] jArr : this.f118742d) {
            parcel.writeLongArray(jArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f118742d = new long[drawableArr.length];
        for (int i3 = 0; i3 < drawableArr.length; i3++) {
            Drawable drawable = drawableArr[i3];
            if (drawable instanceof GifDrawable) {
                this.f118742d[i3] = ((GifDrawable) drawable).C.p();
            } else {
                this.f118742d[i3] = null;
            }
        }
    }

    GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f118742d = new long[parcel.readInt()];
        int i3 = 0;
        while (true) {
            long[][] jArr = this.f118742d;
            if (i3 >= jArr.length) {
                return;
            }
            jArr[i3] = parcel.createLongArray();
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f118742d = r2;
        long[][] jArr2 = {jArr};
    }
}
