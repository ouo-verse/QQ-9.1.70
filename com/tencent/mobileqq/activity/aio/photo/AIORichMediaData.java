package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class AIORichMediaData implements Parcelable {
    public static final Parcelable.Creator<AIORichMediaData> CREATOR = new a();
    public boolean D;
    public boolean E;

    /* renamed from: d, reason: collision with root package name */
    public long f179628d;

    /* renamed from: f, reason: collision with root package name */
    public long f179630f;

    /* renamed from: h, reason: collision with root package name */
    public long f179631h;

    /* renamed from: i, reason: collision with root package name */
    public long f179632i;

    /* renamed from: e, reason: collision with root package name */
    public int f179629e = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f179633m = 0;
    public boolean C = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<AIORichMediaData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AIORichMediaData createFromParcel(Parcel parcel) {
            try {
                AIORichMediaData c16 = AIORichMediaData.c(parcel.readString());
                c16.e(parcel);
                return c16;
            } catch (ClassNotFoundException e16) {
                throw new RuntimeException(e16);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AIORichMediaData[] newArray(int i3) {
            return new AIORichMediaData[i3];
        }
    }

    static AIORichMediaData c(String str) throws ClassNotFoundException {
        if (AIOImageData.class.getSimpleName().equals(str)) {
            return new AIOImageData();
        }
        if (AIOShortVideoData.class.getSimpleName().equals(str)) {
            return new AIOShortVideoData();
        }
        if (AIOFilePicData.class.getSimpleName().equals(str)) {
            return new AIOFilePicData();
        }
        if (AIOFileVideoData.class.getSimpleName().equals(str)) {
            return new AIOFileVideoData();
        }
        if (AIOLightVideoData.class.getSimpleName().equals(str)) {
            return new AIOLightVideoData();
        }
        throw new ClassNotFoundException();
    }

    public abstract File a(int i3);

    public abstract String b(int i3);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(Parcel parcel) {
        boolean z16;
        boolean z17;
        this.f179628d = parcel.readLong();
        this.f179629e = parcel.readInt();
        this.f179630f = parcel.readLong();
        this.f179631h = parcel.readLong();
        this.f179632i = parcel.readLong();
        this.f179633m = parcel.readInt();
        boolean z18 = false;
        if (parcel.readInt() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.C = z16;
        if (parcel.readInt() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.D = z17;
        if (parcel.readInt() == 1) {
            z18 = true;
        }
        this.E = z18;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(getClass().getSimpleName());
        parcel.writeLong(this.f179628d);
        parcel.writeInt(this.f179629e);
        parcel.writeLong(this.f179630f);
        parcel.writeLong(this.f179631h);
        parcel.writeLong(this.f179632i);
        parcel.writeInt(this.f179633m);
        parcel.writeInt(this.C ? 1 : 0);
        parcel.writeInt(this.D ? 1 : 0);
        parcel.writeInt(this.E ? 1 : 0);
    }
}
