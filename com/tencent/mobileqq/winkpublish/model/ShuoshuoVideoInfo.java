package com.tencent.mobileqq.winkpublish.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.smartparcelable.NeedParcel;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ShuoshuoVideoInfo implements com.tencent.smartparcelable.a, Parcelable {
    public static final Parcelable.Creator<ShuoshuoVideoInfo> CREATOR = new a();
    public static final int VIDEO_ISNEW_COVER = 106;
    public static final int VIDEO_ISNEW_RECORD = 1;
    public static final int VIDEO_ISNEW_TOPIC = 104;
    public static final int VIDEO_ISNEW_TRIM = 102;
    public static final int VIDEO_TYPE_QZONE_ALBUM_VIDEO = 2;
    public static final int VIDEO_TYPE_RECORD = 0;
    public static final int VIDEO_TYPE_TRIM = 1;

    @NeedParcel
    public String fakeVid;

    @NeedParcel
    public ArrayList<String> mCombineOriginPath;

    @NeedParcel
    public int mCoverHeight;

    @NeedParcel
    public String mCoverUrl;

    @NeedParcel
    public int mCoverWidth;

    @NeedParcel
    public String mDesc;

    @NeedParcel
    public String mDescription;

    @NeedParcel
    public long mDuration;

    @NeedParcel
    public long mEndTime;

    @NeedParcel
    public double mEstimateSize;

    @NeedParcel
    public Bundle mExtras;

    @NeedParcel
    public int mFlag;

    @NeedParcel
    public boolean mHasCompressed;

    @NeedParcel
    public int mIsClientCompressed;
    public boolean mIsFakeFeed;

    @NeedParcel
    public int mIsNew;

    @NeedParcel
    public int mIsOriginalVideo;

    @NeedParcel
    public boolean mIsUploadOrigin;

    @NeedParcel
    public boolean mNeedProcess;

    @NeedParcel
    public long mShootTime;

    @NeedParcel
    public long mSize;

    @NeedParcel
    public long mStartTime;

    @NeedParcel
    public String mTakenTime;

    @NeedParcel
    public String mTitle;

    @NeedParcel
    public long mTotalDuration;

    @NeedParcel
    public String mVideoComposeSourceInfo;

    @NeedParcel
    public int mVideoHeight;

    @NeedParcel
    public String mVideoPath;

    @NeedParcel
    public int mVideoType;

    @NeedParcel
    public int mVideoWidth;

    @NeedParcel
    public String md5;

    @NeedParcel
    public boolean needDeleteLocal;

    @NeedParcel
    public String perfKey;

    @NeedParcel
    public int rotation;

    @NeedParcel
    public String topicId;

    @NeedParcel
    public boolean topicSyncQzone;
    public int videoFrom;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<ShuoshuoVideoInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShuoshuoVideoInfo createFromParcel(Parcel parcel) {
            return new ShuoshuoVideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShuoshuoVideoInfo[] newArray(int i3) {
            return new ShuoshuoVideoInfo[i3];
        }
    }

    public ShuoshuoVideoInfo() {
        this.videoFrom = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        this.videoFrom = parcel.readInt();
        this.mVideoPath = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDesc = parcel.readString();
        this.mFlag = parcel.readInt();
        this.mDuration = parcel.readLong();
        this.mSize = parcel.readLong();
        this.mCoverUrl = parcel.readString();
        this.mIsNew = parcel.readInt();
        this.mVideoWidth = parcel.readInt();
        this.mVideoHeight = parcel.readInt();
        this.mIsClientCompressed = parcel.readInt();
        this.mIsOriginalVideo = parcel.readInt();
        this.mVideoType = parcel.readInt();
        boolean z27 = true;
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mNeedProcess = z16;
        this.mStartTime = parcel.readLong();
        this.mEndTime = parcel.readLong();
        if (parcel.readByte() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mIsUploadOrigin = z17;
        if (parcel.readByte() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.mHasCompressed = z18;
        if (parcel.readByte() != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.mIsFakeFeed = z19;
        this.mEstimateSize = parcel.readDouble();
        this.mTotalDuration = parcel.readLong();
        this.mExtras = parcel.readBundle(getClass().getClassLoader());
        this.mTakenTime = parcel.readString();
        this.mShootTime = parcel.readLong();
        this.mDescription = parcel.readString();
        this.topicId = parcel.readString();
        if (parcel.readByte() != 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        this.topicSyncQzone = z26;
        if (parcel.readByte() == 0) {
            z27 = false;
        }
        this.needDeleteLocal = z27;
        this.fakeVid = parcel.readString();
        this.perfKey = parcel.readString();
        this.mCombineOriginPath = parcel.createStringArrayList();
        this.md5 = parcel.readString();
        this.rotation = parcel.readInt();
        this.mCoverWidth = parcel.readInt();
        this.mCoverHeight = parcel.readInt();
        this.mVideoComposeSourceInfo = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.videoFrom);
        parcel.writeString(this.mVideoPath);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDesc);
        parcel.writeInt(this.mFlag);
        parcel.writeLong(this.mDuration);
        parcel.writeLong(this.mSize);
        parcel.writeString(this.mCoverUrl);
        parcel.writeInt(this.mIsNew);
        parcel.writeInt(this.mVideoWidth);
        parcel.writeInt(this.mVideoHeight);
        parcel.writeInt(this.mIsClientCompressed);
        parcel.writeInt(this.mIsOriginalVideo);
        parcel.writeInt(this.mVideoType);
        parcel.writeByte(this.mNeedProcess ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.mStartTime);
        parcel.writeLong(this.mEndTime);
        parcel.writeByte(this.mIsUploadOrigin ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mHasCompressed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsFakeFeed ? (byte) 1 : (byte) 0);
        parcel.writeDouble(this.mEstimateSize);
        parcel.writeLong(this.mTotalDuration);
        parcel.writeBundle(this.mExtras);
        parcel.writeString(this.mTakenTime);
        parcel.writeLong(this.mShootTime);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.topicId);
        parcel.writeByte(this.topicSyncQzone ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needDeleteLocal ? (byte) 1 : (byte) 0);
        parcel.writeString(this.fakeVid);
        parcel.writeString(this.perfKey);
        parcel.writeStringList(this.mCombineOriginPath);
        parcel.writeString(this.md5);
        parcel.writeInt(this.rotation);
        parcel.writeInt(this.mCoverWidth);
        parcel.writeInt(this.mCoverHeight);
        parcel.writeString(this.mVideoComposeSourceInfo);
    }

    protected ShuoshuoVideoInfo(Parcel parcel) {
        this.videoFrom = parcel.readInt();
        this.mVideoPath = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDesc = parcel.readString();
        this.mFlag = parcel.readInt();
        this.mDuration = parcel.readLong();
        this.mSize = parcel.readLong();
        this.mCoverUrl = parcel.readString();
        this.mIsNew = parcel.readInt();
        this.mVideoWidth = parcel.readInt();
        this.mVideoHeight = parcel.readInt();
        this.mIsClientCompressed = parcel.readInt();
        this.mIsOriginalVideo = parcel.readInt();
        this.mVideoType = parcel.readInt();
        this.mNeedProcess = parcel.readByte() != 0;
        this.mStartTime = parcel.readLong();
        this.mEndTime = parcel.readLong();
        this.mIsUploadOrigin = parcel.readByte() != 0;
        this.mHasCompressed = parcel.readByte() != 0;
        this.mIsFakeFeed = parcel.readByte() != 0;
        this.mEstimateSize = parcel.readDouble();
        this.mTotalDuration = parcel.readLong();
        this.mExtras = parcel.readBundle(getClass().getClassLoader());
        this.mTakenTime = parcel.readString();
        this.mShootTime = parcel.readLong();
        this.mDescription = parcel.readString();
        this.topicId = parcel.readString();
        this.topicSyncQzone = parcel.readByte() != 0;
        this.needDeleteLocal = parcel.readByte() != 0;
        this.fakeVid = parcel.readString();
        this.perfKey = parcel.readString();
        this.mCombineOriginPath = parcel.createStringArrayList();
        this.md5 = parcel.readString();
        this.rotation = parcel.readInt();
        this.mCoverWidth = parcel.readInt();
        this.mCoverHeight = parcel.readInt();
        this.mVideoComposeSourceInfo = parcel.readString();
    }
}
