package com.tencent.mobileqq.vas.updatesystem.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes20.dex */
public class VasUpdateParcelableParams implements Parcelable {
    public static final Parcelable.Creator<VasUpdateParcelableParams> CREATOR = new a();
    public long mBid;
    public int mErrorCode;
    public String mErrorMessage;
    public String mFrom;
    public int mHttpCode;
    public boolean mIsLoading;
    public boolean mIsSuccess;
    public long mProgress;
    public long mProgressMax;
    public int mProgressRate;
    public String mScid;

    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<VasUpdateParcelableParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VasUpdateParcelableParams createFromParcel(Parcel parcel) {
            VasUpdateParcelableParams vasUpdateParcelableParams = new VasUpdateParcelableParams();
            vasUpdateParcelableParams.readFromParcel(parcel);
            return vasUpdateParcelableParams;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VasUpdateParcelableParams[] newArray(int i3) {
            return new VasUpdateParcelableParams[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFromParcel(Parcel parcel) {
        boolean z16;
        boolean z17 = false;
        if (parcel.readInt() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsSuccess = z16;
        if (parcel.readInt() == 1) {
            z17 = true;
        }
        this.mIsLoading = z17;
        this.mFrom = parcel.readString();
        this.mBid = parcel.readLong();
        this.mScid = parcel.readString();
        this.mErrorCode = parcel.readInt();
        this.mHttpCode = parcel.readInt();
        this.mProgress = parcel.readLong();
        this.mProgressMax = parcel.readLong();
        this.mProgressRate = parcel.readInt();
        this.mErrorMessage = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mIsSuccess ? 1 : 0);
        parcel.writeInt(this.mIsLoading ? 1 : 0);
        parcel.writeString(this.mFrom);
        parcel.writeLong(this.mBid);
        parcel.writeString(this.mScid);
        parcel.writeInt(this.mErrorCode);
        parcel.writeInt(this.mHttpCode);
        parcel.writeLong(this.mProgress);
        parcel.writeLong(this.mProgressMax);
        parcel.writeInt(this.mProgressRate);
        parcel.writeString(this.mErrorMessage);
    }
}
