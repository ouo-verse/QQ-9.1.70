package com.tencent.tmassistantsdk;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantCallYYBTaskInfo implements Parcelable {
    public static final Parcelable.Creator<TMAssistantCallYYBTaskInfo> CREATOR = new a();
    public String mContentType;
    public long mReceiveDataLen;
    public String mSavePath;
    public int mState;
    public long mTotalDataLen;
    public String mUrl;

    public TMAssistantCallYYBTaskInfo(String str, String str2, int i3, long j3, long j16, String str3) {
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
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<TMAssistantCallYYBTaskInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TMAssistantCallYYBTaskInfo createFromParcel(Parcel parcel) {
            return new TMAssistantCallYYBTaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TMAssistantCallYYBTaskInfo[] newArray(int i3) {
            return new TMAssistantCallYYBTaskInfo[i3];
        }
    }
}
