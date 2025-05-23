package com.tencent.superplayer.seamless.ipc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public IBinder f373957d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<BinderWrapper> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BinderWrapper createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel.readStrongBinder());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BinderWrapper[] newArray(int i3) {
            return new BinderWrapper[i3];
        }
    }

    public BinderWrapper(IBinder iBinder) {
        this.f373957d = iBinder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStrongBinder(this.f373957d);
    }
}
