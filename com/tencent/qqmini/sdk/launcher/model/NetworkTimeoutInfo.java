package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.component.network.downloader.impl.ipc.Const;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NetworkTimeoutInfo implements Parcelable {
    public static final Parcelable.Creator<NetworkTimeoutInfo> CREATOR = new Parcelable.Creator<NetworkTimeoutInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkTimeoutInfo createFromParcel(Parcel parcel) {
            NetworkTimeoutInfo networkTimeoutInfo = new NetworkTimeoutInfo();
            networkTimeoutInfo.request = parcel.readInt();
            networkTimeoutInfo.connectSocket = parcel.readInt();
            networkTimeoutInfo.uploadFile = parcel.readInt();
            networkTimeoutInfo.downloadFile = parcel.readInt();
            return networkTimeoutInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkTimeoutInfo[] newArray(int i3) {
            return new NetworkTimeoutInfo[i3];
        }
    };
    public static final int TIME_DEFAULT_MS = 60000;
    public int request = 60000;
    public int connectSocket = 60000;
    public int uploadFile = 60000;
    public int downloadFile = 60000;

    public static NetworkTimeoutInfo parse(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        int optInt3;
        NetworkTimeoutInfo networkTimeoutInfo = new NetworkTimeoutInfo();
        int i3 = 60000;
        if (jSONObject == null) {
            optInt = 60000;
        } else {
            optInt = jSONObject.optInt(Const.BUNDLE_KEY_REQUEST, 60000);
        }
        networkTimeoutInfo.request = optInt;
        if (jSONObject == null) {
            optInt2 = 60000;
        } else {
            optInt2 = jSONObject.optInt("connectSocket", 60000);
        }
        networkTimeoutInfo.connectSocket = optInt2;
        if (jSONObject == null) {
            optInt3 = 60000;
        } else {
            optInt3 = jSONObject.optInt("uploadFile", 60000);
        }
        networkTimeoutInfo.uploadFile = optInt3;
        if (jSONObject != null) {
            i3 = jSONObject.optInt("downloadFile", 60000);
        }
        networkTimeoutInfo.downloadFile = i3;
        return networkTimeoutInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NetworkTimeoutInfo{request='" + this.request + "', connectSocket='" + this.connectSocket + "', uploadFile='" + this.uploadFile + "', downloadFile='" + this.downloadFile + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.request);
        parcel.writeInt(this.connectSocket);
        parcel.writeInt(this.uploadFile);
        parcel.writeInt(this.downloadFile);
    }
}
