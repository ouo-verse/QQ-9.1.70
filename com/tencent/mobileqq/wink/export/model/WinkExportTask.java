package com.tencent.mobileqq.wink.export.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.wink.model.WinkExportParams;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkExportTask implements Parcelable {
    public static final Parcelable.Creator<WinkExportTask> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f322847d;

    /* renamed from: e, reason: collision with root package name */
    public String f322848e;

    /* renamed from: f, reason: collision with root package name */
    public WinkExportParams f322849f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f322850h;

    /* renamed from: i, reason: collision with root package name */
    public int f322851i;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<WinkExportTask> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkExportTask createFromParcel(Parcel parcel) {
            return new WinkExportTask(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkExportTask[] newArray(int i3) {
            return new WinkExportTask[i3];
        }
    }

    public WinkExportTask() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f322847d);
        parcel.writeString(this.f322848e);
        parcel.writeParcelable(this.f322849f, i3);
        parcel.writeByte(this.f322850h ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f322851i);
    }

    public WinkExportTask(String str, String str2, WinkExportParams winkExportParams, boolean z16, int i3) {
        this.f322847d = str;
        this.f322848e = str2;
        this.f322849f = winkExportParams;
        this.f322850h = z16;
        this.f322851i = i3;
    }

    protected WinkExportTask(Parcel parcel) {
        this.f322847d = parcel.readString();
        this.f322848e = parcel.readString();
        this.f322849f = (WinkExportParams) parcel.readParcelable(WinkExportParams.class.getClassLoader());
        this.f322850h = parcel.readByte() != 0;
        this.f322851i = parcel.readInt();
    }
}
