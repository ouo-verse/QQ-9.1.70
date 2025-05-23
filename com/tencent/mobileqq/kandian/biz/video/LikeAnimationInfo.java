package com.tencent.mobileqq.kandian.biz.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LikeAnimationInfo implements Parcelable {
    public static final Parcelable.Creator<LikeAnimationInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String[] f239511d;

    /* renamed from: e, reason: collision with root package name */
    public int f239512e;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<LikeAnimationInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LikeAnimationInfo createFromParcel(Parcel parcel) {
            return new LikeAnimationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LikeAnimationInfo[] newArray(int i3) {
            return new LikeAnimationInfo[i3];
        }
    }

    protected LikeAnimationInfo(Parcel parcel) {
        this.f239511d = parcel.createStringArray();
        this.f239512e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LikeAnimationInfo{icons=" + Arrays.toString(this.f239511d) + ", nextReqInterval=" + this.f239512e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringArray(this.f239511d);
        parcel.writeInt(this.f239512e);
    }

    public LikeAnimationInfo() {
    }
}
