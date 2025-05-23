package com.tencent.mobileqq.wink.export.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

/* loaded from: classes21.dex */
public class ExportCompletedParam implements Parcelable {
    public static final Parcelable.Creator<ExportCompletedParam> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f322834d;

    /* renamed from: e, reason: collision with root package name */
    public LocalMediaInfo f322835e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f322836f;

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<ExportCompletedParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExportCompletedParam createFromParcel(Parcel parcel) {
            return new ExportCompletedParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExportCompletedParam[] newArray(int i3) {
            return new ExportCompletedParam[i3];
        }
    }

    public ExportCompletedParam(String str, LocalMediaInfo localMediaInfo, boolean z16) {
        this.f322834d = str;
        this.f322835e = localMediaInfo;
        this.f322836f = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f322834d);
        parcel.writeParcelable(this.f322835e, i3);
        parcel.writeByte(this.f322836f ? (byte) 1 : (byte) 0);
    }

    protected ExportCompletedParam(Parcel parcel) {
        this.f322834d = parcel.readString();
        this.f322835e = (LocalMediaInfo) parcel.readParcelable(LocalMediaInfo.class.getClassLoader());
        this.f322836f = parcel.readByte() != 0;
    }
}
