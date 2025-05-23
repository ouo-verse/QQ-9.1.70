package com.tencent.vas.update.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.vas.update.util.CommonUtil;

/* loaded from: classes27.dex */
public class BusinessUpdateParams implements Parcelable {
    public static final Parcelable.Creator<BusinessUpdateParams> CREATOR = new a();
    public long mBid;
    public String mFrom;
    public String mItemId;
    public String mScid;

    /* loaded from: classes27.dex */
    class a implements Parcelable.Creator<BusinessUpdateParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusinessUpdateParams createFromParcel(Parcel parcel) {
            return new BusinessUpdateParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BusinessUpdateParams[] newArray(int i3) {
            return new BusinessUpdateParams[i3];
        }
    }

    public BusinessUpdateParams(long j3, String str, String str2) {
        this.mBid = j3;
        this.mScid = str;
        this.mFrom = str2;
        this.mItemId = CommonUtil.sComposeItemId(j3, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.mItemId = parcel.readString();
        this.mBid = parcel.readLong();
        this.mScid = parcel.readString();
        this.mFrom = parcel.readString();
    }

    @NonNull
    public String toString() {
        return "BusinessUpdateParams mItemId = " + this.mItemId + "\uff0cmBid = " + this.mBid + "\uff0cmScid = " + this.mScid + "\uff0cmFrom = " + this.mFrom;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mItemId);
        parcel.writeLong(this.mBid);
        parcel.writeString(this.mScid);
        parcel.writeString(this.mFrom);
    }

    protected BusinessUpdateParams(Parcel parcel) {
        this.mItemId = parcel.readString();
        this.mBid = parcel.readLong();
        this.mScid = parcel.readString();
        this.mFrom = parcel.readString();
    }
}
