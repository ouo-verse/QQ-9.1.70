package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantDownloadTaskInfo implements Parcelable {
    public static final Parcelable.Creator<TMAssistantDownloadTaskInfo> CREATOR = new a();
    public String mContentType;
    public long mReceiveDataLen;
    public String mSavePath;
    public int mState;
    public long mTotalDataLen;
    public String mUrl;
    public long mAppId = 0;
    public String mTaskPackageName = "";
    public String mTaskVersionCode = "";
    public String mIconUrl = "";
    public String mAppName = "";
    public long mStartTime = 0;
    public long mEndTime = 0;
    public String mVia = "";
    public String mChannelid = "";
    public int showNotification = 0;
    public boolean isAutoInstallBySDK = false;

    public TMAssistantDownloadTaskInfo(String str, String str2, int i3, long j3, long j16, String str3) {
        this.mUrl = str;
        this.mSavePath = str2;
        this.mState = i3;
        this.mReceiveDataLen = j3;
        this.mTotalDataLen = j16;
        this.mContentType = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String str = this.mUrl;
        if (str != null) {
            parcel.writeString(str);
        } else {
            parcel.writeString("");
        }
        String str2 = this.mSavePath;
        if (str2 != null) {
            parcel.writeString(str2);
        } else {
            parcel.writeString("");
        }
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mReceiveDataLen);
        parcel.writeLong(this.mTotalDataLen);
        parcel.writeString(this.mContentType);
        parcel.writeLong(this.mAppId);
        String str3 = this.mTaskPackageName;
        if (str3 != null) {
            parcel.writeString(str3);
        } else {
            parcel.writeString("");
        }
        String str4 = this.mTaskVersionCode;
        if (str4 != null) {
            parcel.writeString(str4);
        } else {
            parcel.writeString("");
        }
        String str5 = this.mIconUrl;
        if (str5 != null) {
            parcel.writeString(str5);
        } else {
            parcel.writeString("");
        }
        String str6 = this.mAppName;
        if (str6 != null) {
            parcel.writeString(str6);
        } else {
            parcel.writeString("");
        }
        parcel.writeLong(this.mStartTime);
        parcel.writeLong(this.mEndTime);
        String str7 = this.mVia;
        if (str7 != null) {
            parcel.writeString(str7);
        } else {
            parcel.writeString("");
        }
        String str8 = this.mChannelid;
        if (str8 != null) {
            parcel.writeString(str8);
        } else {
            parcel.writeString("");
        }
        parcel.writeInt(this.showNotification);
        parcel.writeByte(this.isAutoInstallBySDK ? (byte) 1 : (byte) 0);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<TMAssistantDownloadTaskInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TMAssistantDownloadTaskInfo createFromParcel(Parcel parcel) {
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
            tMAssistantDownloadTaskInfo.mAppId = parcel.readLong();
            tMAssistantDownloadTaskInfo.mTaskPackageName = parcel.readString();
            tMAssistantDownloadTaskInfo.mTaskVersionCode = parcel.readString();
            tMAssistantDownloadTaskInfo.mIconUrl = parcel.readString();
            tMAssistantDownloadTaskInfo.mAppName = parcel.readString();
            tMAssistantDownloadTaskInfo.mStartTime = parcel.readLong();
            tMAssistantDownloadTaskInfo.mEndTime = parcel.readLong();
            tMAssistantDownloadTaskInfo.mVia = parcel.readString();
            tMAssistantDownloadTaskInfo.mChannelid = parcel.readString();
            tMAssistantDownloadTaskInfo.showNotification = parcel.readInt();
            tMAssistantDownloadTaskInfo.isAutoInstallBySDK = parcel.readByte() != 0;
            return tMAssistantDownloadTaskInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TMAssistantDownloadTaskInfo[] newArray(int i3) {
            return new TMAssistantDownloadTaskInfo[i3];
        }
    }
}
