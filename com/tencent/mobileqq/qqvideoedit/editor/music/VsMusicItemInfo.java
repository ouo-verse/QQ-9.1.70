package com.tencent.mobileqq.qqvideoedit.editor.music;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VsMusicItemInfo extends MusicItemInfo {
    public static final Parcelable.Creator<VsMusicItemInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f275795d;

    /* renamed from: e, reason: collision with root package name */
    public String f275796e;

    /* renamed from: f, reason: collision with root package name */
    public int f275797f;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<VsMusicItemInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VsMusicItemInfo createFromParcel(Parcel parcel) {
            return new VsMusicItemInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VsMusicItemInfo[] newArray(int i3) {
            return new VsMusicItemInfo[i3];
        }
    }

    protected VsMusicItemInfo(Parcel parcel) {
        super(parcel);
        this.f275797f = 1;
        this.f275796e = parcel.readString();
        this.f275795d = parcel.readString();
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f275796e);
        parcel.writeString(this.f275795d);
    }

    public VsMusicItemInfo() {
        this.f275797f = 1;
    }
}
