package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOVideoData extends AIOBrowserBaseData {
    public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new a();
    public int C;
    public int D;
    public long E;
    public int G;
    public long K;
    public boolean L;
    public String M;
    public String N;
    public int P;
    public int Q;
    public long R;

    /* renamed from: f, reason: collision with root package name */
    public int f281845f;

    /* renamed from: h, reason: collision with root package name */
    public int f281846h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f281847i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f281848m;

    /* renamed from: d, reason: collision with root package name */
    public String f281843d = AIOBrowserBaseData.MEDIA_FILE_NONE;

    /* renamed from: e, reason: collision with root package name */
    public String f281844e = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String F = "";
    public String H = null;
    public boolean I = false;
    public boolean J = false;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<RichMediaBaseData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData createFromParcel(Parcel parcel) {
            AIOVideoData aIOVideoData = new AIOVideoData();
            aIOVideoData.readFromParcel(parcel);
            return aIOVideoData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData[] newArray(int i3) {
            return new RichMediaBaseData[i3];
        }
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        return 101;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData, com.tencent.richmediabrowser.model.RichMediaBaseData
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f281843d = parcel.readString();
        this.f281844e = parcel.readString();
        this.f281845f = parcel.readInt();
        this.f281846h = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readLong();
        this.F = parcel.readString();
        this.G = parcel.readInt();
        this.M = parcel.readString();
        this.N = parcel.readString();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData, com.tencent.richmediabrowser.model.RichMediaBaseData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f281843d);
        parcel.writeString(this.f281844e);
        parcel.writeInt(this.f281845f);
        parcel.writeInt(this.f281846h);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeLong(this.E);
        parcel.writeString(this.F);
        parcel.writeInt(this.G);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
    }
}
