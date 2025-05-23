package com.tencent.mobileqq.wink.export.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;

/* loaded from: classes21.dex */
public class ExportErrorParam implements Parcelable {
    public static final Parcelable.Creator<ExportErrorParam> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f322837d;

    /* renamed from: e, reason: collision with root package name */
    public ExportErrorCode f322838e;

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<ExportErrorParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExportErrorParam createFromParcel(Parcel parcel) {
            return new ExportErrorParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExportErrorParam[] newArray(int i3) {
            return new ExportErrorParam[i3];
        }
    }

    public ExportErrorParam(String str, ExportErrorCode exportErrorCode) {
        this.f322837d = str;
        this.f322838e = exportErrorCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f322837d);
        parcel.writeParcelable(this.f322838e, i3);
    }

    protected ExportErrorParam(Parcel parcel) {
        this.f322837d = parcel.readString();
        this.f322838e = (ExportErrorCode) parcel.readParcelable(ExportErrorCode.class.getClassLoader());
    }
}
