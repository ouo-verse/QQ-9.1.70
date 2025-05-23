package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOFileVideoData extends AIOBrowserBaseData {
    public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new a();
    public String C;
    public long E;
    public String F;
    public String P;
    public int Q;
    public int R;
    public String S;
    public String T;
    public Bundle U;

    /* renamed from: d, reason: collision with root package name */
    public String f281837d;

    /* renamed from: e, reason: collision with root package name */
    public String f281838e;

    /* renamed from: f, reason: collision with root package name */
    public String f281839f;

    /* renamed from: h, reason: collision with root package name */
    public long f281840h;

    /* renamed from: i, reason: collision with root package name */
    public int f281841i;

    /* renamed from: m, reason: collision with root package name */
    public int f281842m;
    public ArrayList<String> D = null;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public String J = null;
    public boolean K = false;
    public boolean L = false;
    public boolean M = false;
    public boolean N = false;
    public int V = 0;
    public long W = 0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<RichMediaBaseData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData createFromParcel(Parcel parcel) {
            AIOFileVideoData aIOFileVideoData = new AIOFileVideoData();
            aIOFileVideoData.readFromParcel(parcel);
            return aIOFileVideoData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData[] newArray(int i3) {
            return new RichMediaBaseData[i3];
        }
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        return 103;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData, com.tencent.richmediabrowser.model.RichMediaBaseData
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.f281838e = parcel.readString();
        this.f281837d = parcel.readString();
        this.f281839f = parcel.readString();
        this.f281840h = parcel.readLong();
        this.f281841i = parcel.readInt();
        this.f281842m = parcel.readInt();
        boolean z16 = true;
        if (parcel.readInt() != 1) {
            z16 = false;
        }
        this.I = z16;
        this.P = parcel.readString();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readString();
        this.T = parcel.readString();
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
        parcel.writeString(this.f281838e);
        parcel.writeString(this.f281837d);
        parcel.writeString(this.f281839f);
        parcel.writeLong(this.f281840h);
        parcel.writeInt(this.f281841i);
        parcel.writeInt(this.f281842m);
        parcel.writeInt(this.I ? 1 : 0);
        parcel.writeString(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeString(this.S);
        parcel.writeString(this.T);
    }
}
