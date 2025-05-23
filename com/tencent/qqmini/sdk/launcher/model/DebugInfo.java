package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DebugInfo implements Parcelable {
    public static final Parcelable.Creator<DebugInfo> CREATOR = new Parcelable.Creator<DebugInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.DebugInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DebugInfo createFromParcel(Parcel parcel) {
            DebugInfo debugInfo = new DebugInfo();
            debugInfo.roomId = parcel.readString();
            debugInfo.wsUrl = parcel.readString();
            return debugInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DebugInfo[] newArray(int i3) {
            return new DebugInfo[i3];
        }
    };
    public String roomId;
    public String wsUrl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DebugInfo)) {
            return false;
        }
        DebugInfo debugInfo = (DebugInfo) obj;
        return TextUtils.equals(this.roomId, debugInfo.roomId) && TextUtils.equals(this.wsUrl, debugInfo.wsUrl);
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getWsUrl() {
        return this.wsUrl;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setWsUrl(String str) {
        this.wsUrl = str;
    }

    public boolean valid() {
        if (!TextUtils.isEmpty(this.roomId) && !TextUtils.isEmpty(this.wsUrl)) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.roomId);
        parcel.writeString(this.wsUrl);
    }

    public static boolean equals(DebugInfo debugInfo, DebugInfo debugInfo2) {
        if (debugInfo == debugInfo2) {
            return true;
        }
        if (debugInfo != null) {
            return debugInfo.equals(debugInfo2);
        }
        return false;
    }
}
