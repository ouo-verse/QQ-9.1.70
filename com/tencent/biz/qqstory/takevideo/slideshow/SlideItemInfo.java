package com.tencent.biz.qqstory.takevideo.slideshow;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SlideItemInfo implements Parcelable {
    public static final Parcelable.Creator<SlideItemInfo> CREATOR = new a();
    public long C;
    public long D;
    public long E;
    public String F;
    public String G;
    public boolean H;
    public int I;
    public int J;
    public int K;
    public int L;
    public String M;
    public boolean N;
    public boolean P;

    /* renamed from: d, reason: collision with root package name */
    public LocalMediaInfo f94287d;

    /* renamed from: e, reason: collision with root package name */
    public int f94288e;

    /* renamed from: f, reason: collision with root package name */
    public String f94289f;

    /* renamed from: h, reason: collision with root package name */
    public int f94290h;

    /* renamed from: i, reason: collision with root package name */
    public String f94291i;

    /* renamed from: m, reason: collision with root package name */
    public URL f94292m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<SlideItemInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SlideItemInfo createFromParcel(Parcel parcel) {
            return new SlideItemInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SlideItemInfo[] newArray(int i3) {
            return new SlideItemInfo[i3];
        }
    }

    public SlideItemInfo(LocalMediaInfo localMediaInfo) {
        this.f94288e = -1;
        this.D = 0L;
        this.E = 0L;
        this.M = "LinearBlur";
        this.N = false;
        this.P = false;
        try {
            this.f94287d = localMediaInfo;
            this.f94291i = localMediaInfo.path;
            this.f94290h = QAlbumUtil.getMediaType(localMediaInfo);
            if (!TextUtils.isEmpty(localMediaInfo.mTransId)) {
                this.M = localMediaInfo.mTransId;
            }
            if (!TextUtils.isEmpty(localMediaInfo.mTextStr)) {
                this.f94289f = localMediaInfo.mTextStr;
            }
            this.f94288e = localMediaInfo.mTextId;
            int i3 = this.f94290h;
            if (i3 == 0) {
                this.f94292m = QAlbumUtil.generateAlbumThumbURL(localMediaInfo);
                this.C = 2000L;
                this.E = 2000L;
            } else {
                if (i3 != 1) {
                    return;
                }
                if (localMediaInfo.isSystemMeidaStore) {
                    this.f94292m = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "VIDEO");
                } else {
                    this.f94292m = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "APP_VIDEO");
                }
                long j3 = localMediaInfo.mDuration;
                this.C = j3;
                if (this.E == 0) {
                    this.E = j3;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public long a() {
        if (this.D <= 0) {
            this.D = 0L;
        }
        long j3 = this.E;
        if (j3 <= 0 || j3 >= this.C) {
            this.E = this.C;
        }
        long j16 = this.E;
        long j17 = this.D;
        if (j16 <= j17) {
            return this.C;
        }
        return j16 - j17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SlideItemInfo) {
            return TextUtils.equals(this.f94291i, ((SlideItemInfo) obj).f94291i);
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f94287d, i3);
        parcel.writeInt(this.f94288e);
        parcel.writeString(this.f94289f);
        parcel.writeInt(this.f94290h);
        parcel.writeString(this.f94291i);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeByte(this.H ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeString(this.M);
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.P ? (byte) 1 : (byte) 0);
    }

    protected SlideItemInfo(Parcel parcel) {
        this.f94288e = -1;
        this.D = 0L;
        this.E = 0L;
        this.M = "LinearBlur";
        this.N = false;
        this.P = false;
        this.f94287d = (LocalMediaInfo) parcel.readParcelable(LocalMediaInfo.class.getClassLoader());
        this.f94288e = parcel.readInt();
        this.f94289f = parcel.readString();
        this.f94290h = parcel.readInt();
        this.f94291i = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readByte() != 0;
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readString();
        this.N = parcel.readByte() != 0;
        this.P = parcel.readByte() != 0;
    }
}
