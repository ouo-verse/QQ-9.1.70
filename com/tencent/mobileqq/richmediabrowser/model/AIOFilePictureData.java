package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

/* loaded from: classes18.dex */
public class AIOFilePictureData extends AIOBrowserBaseData {
    public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new a();
    public int H;
    public String I;
    public String J;
    public int K;
    public int L;
    public int M;

    /* renamed from: d, reason: collision with root package name */
    public int f281831d;

    /* renamed from: e, reason: collision with root package name */
    public String f281832e = AIOBrowserBaseData.MEDIA_FILE_NONE;

    /* renamed from: f, reason: collision with root package name */
    public String f281833f = AIOBrowserBaseData.MEDIA_FILE_NONE;

    /* renamed from: h, reason: collision with root package name */
    public String f281834h = AIOBrowserBaseData.MEDIA_FILE_NONE;

    /* renamed from: i, reason: collision with root package name */
    public String f281835i = AIOBrowserBaseData.MEDIA_FILE_NONE;

    /* renamed from: m, reason: collision with root package name */
    public boolean f281836m = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public long F = 0;
    public boolean G = false;

    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<RichMediaBaseData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData createFromParcel(Parcel parcel) {
            AIOFilePictureData aIOFilePictureData = new AIOFilePictureData();
            aIOFilePictureData.readFromParcel(parcel);
            return aIOFilePictureData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData[] newArray(int i3) {
            return new RichMediaBaseData[i3];
        }
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        return 102;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData, com.tencent.richmediabrowser.model.RichMediaBaseData
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f281831d = parcel.readInt();
        this.f281832e = parcel.readString();
        this.f281833f = parcel.readString();
        this.f281834h = parcel.readString();
        this.f281835i = parcel.readString();
        this.H = parcel.readInt();
        this.E = Boolean.valueOf(parcel.readString()).booleanValue();
        String readString = parcel.readString();
        if (readString == null) {
            readString = "0";
        }
        this.F = Long.valueOf(readString).longValue();
        this.G = Boolean.valueOf(parcel.readString()).booleanValue();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public void updateProgress(int i3) {
        this.progress = i3;
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public void updateStatus(int i3) {
        this.status = i3;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData, com.tencent.richmediabrowser.model.RichMediaBaseData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f281831d);
        parcel.writeString(this.f281832e);
        parcel.writeString(this.f281833f);
        parcel.writeString(this.f281834h);
        parcel.writeString(this.f281835i);
        parcel.writeInt(this.H);
        parcel.writeString(String.valueOf(this.E));
        parcel.writeString(String.valueOf(this.F));
        parcel.writeString(String.valueOf(this.G));
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
    }
}
