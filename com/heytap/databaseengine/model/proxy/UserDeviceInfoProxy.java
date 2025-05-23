package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.heytap.databaseengine.model.SportHealthData;

@Keep
/* loaded from: classes2.dex */
public class UserDeviceInfoProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<UserDeviceInfoProxy> CREATOR = new Parcelable.Creator<UserDeviceInfoProxy>() { // from class: com.heytap.databaseengine.model.proxy.UserDeviceInfoProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserDeviceInfoProxy createFromParcel(Parcel parcel) {
            return new UserDeviceInfoProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserDeviceInfoProxy[] newArray(int i3) {
            return new UserDeviceInfoProxy[i3];
        }
    };
    private int connectionState;
    private String deviceName;
    private int deviceType;
    private String manufacturer;
    private String model;
    private int subDeviceType;

    public UserDeviceInfoProxy() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getSubDeviceType() {
        return this.subDeviceType;
    }

    public void setConnectionState(int i3) {
        this.connectionState = i3;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(int i3) {
        this.deviceType = i3;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setSubDeviceType(int i3) {
        this.subDeviceType = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "UserDeviceInfoProxy:\ndeviceName = " + getDeviceName() + "\ndeviceType = " + getDeviceType() + "\nsubDeviceType = " + getSubDeviceType() + "\nmodel = " + getModel() + "\nmanufacturer = " + getManufacturer() + "\nconnectionState = " + getConnectionState() + '\n';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.deviceType);
        parcel.writeInt(this.subDeviceType);
        parcel.writeString(this.model);
        parcel.writeString(this.manufacturer);
        parcel.writeInt(this.connectionState);
    }

    protected UserDeviceInfoProxy(Parcel parcel) {
        this.deviceName = parcel.readString();
        this.deviceType = parcel.readInt();
        this.subDeviceType = parcel.readInt();
        this.model = parcel.readString();
        this.manufacturer = parcel.readString();
        this.connectionState = parcel.readInt();
    }
}
