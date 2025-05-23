package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantDownloadLogInfo implements Parcelable {
    public static final Parcelable.Creator<TMAssistantDownloadLogInfo> CREATOR = new a();
    public String logLevel;
    public String logMsg;
    public String logTag;
    public String logThrowableMsg;
    public long logTime;

    public TMAssistantDownloadLogInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String str = this.logLevel;
        if (str != null) {
            parcel.writeString(str);
        } else {
            parcel.writeString("");
        }
        parcel.writeLong(this.logTime);
        String str2 = this.logTag;
        if (str2 != null) {
            parcel.writeString(str2);
        } else {
            parcel.writeString("");
        }
        String str3 = this.logMsg;
        if (str3 != null) {
            parcel.writeString(str3);
        } else {
            parcel.writeString("");
        }
        String str4 = this.logThrowableMsg;
        if (str4 != null) {
            parcel.writeString(str4);
        } else {
            parcel.writeString("");
        }
    }

    public TMAssistantDownloadLogInfo(String str, long j3, String str2, String str3, String str4) {
        this.logLevel = str;
        this.logTime = j3;
        this.logTag = str2;
        this.logMsg = str3;
        this.logThrowableMsg = str4;
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<TMAssistantDownloadLogInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TMAssistantDownloadLogInfo createFromParcel(Parcel parcel) {
            return new TMAssistantDownloadLogInfo(parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TMAssistantDownloadLogInfo[] newArray(int i3) {
            return new TMAssistantDownloadLogInfo[i3];
        }
    }
}
