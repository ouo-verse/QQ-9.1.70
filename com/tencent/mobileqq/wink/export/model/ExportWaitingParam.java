package com.tencent.mobileqq.wink.export.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes21.dex */
public class ExportWaitingParam implements Parcelable {
    public static final Parcelable.Creator<ExportWaitingParam> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f322840d;

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<ExportWaitingParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExportWaitingParam createFromParcel(Parcel parcel) {
            return new ExportWaitingParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExportWaitingParam[] newArray(int i3) {
            return new ExportWaitingParam[i3];
        }
    }

    public ExportWaitingParam(String str) {
        this.f322840d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f322840d);
    }

    protected ExportWaitingParam(Parcel parcel) {
        this.f322840d = parcel.readString();
    }
}
