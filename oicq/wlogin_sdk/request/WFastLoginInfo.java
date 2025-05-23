package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WFastLoginInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<WFastLoginInfo> CREATOR = new Parcelable.Creator<WFastLoginInfo>() { // from class: oicq.wlogin_sdk.request.WFastLoginInfo.1
        @Override // android.os.Parcelable.Creator
        public WFastLoginInfo createFromParcel(Parcel parcel) {
            return new WFastLoginInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WFastLoginInfo[] newArray(int i3) {
            return new WFastLoginInfo[i3];
        }
    };
    private static final long serialVersionUID = 1;
    public byte[] _outA1;
    public String adUrl;
    public String iconUrl;
    public String profileUrl;
    public String userJson;

    public WFastLoginInfo() {
        this.iconUrl = "";
        this.adUrl = "";
        this.profileUrl = "";
        this.userJson = "";
        this._outA1 = new byte[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void get_clone(WFastLoginInfo wFastLoginInfo) {
        if (wFastLoginInfo != null) {
            byte[] bArr = wFastLoginInfo._outA1;
            if (bArr != null) {
                this._outA1 = (byte[]) bArr.clone();
            } else {
                this._outA1 = new byte[0];
            }
            this.iconUrl = wFastLoginInfo.iconUrl;
            this.adUrl = wFastLoginInfo.adUrl;
            this.profileUrl = wFastLoginInfo.profileUrl;
        }
    }

    public void readFromParcel(Parcel parcel) {
        this._outA1 = parcel.createByteArray();
        this.iconUrl = parcel.readString();
        this.adUrl = parcel.readString();
        this.profileUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByteArray(this._outA1);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.adUrl);
        parcel.writeString(this.profileUrl);
    }

    WFastLoginInfo(Parcel parcel) {
        this._outA1 = new byte[0];
        this.iconUrl = "";
        this.adUrl = "";
        this.profileUrl = "";
        this.userJson = "";
        readFromParcel(parcel);
    }

    public WFastLoginInfo(byte[] bArr) {
        this._outA1 = new byte[0];
        this.iconUrl = "";
        this.adUrl = "";
        this.profileUrl = "";
        this.userJson = "";
        if (bArr != null) {
            this._outA1 = (byte[]) bArr.clone();
        } else {
            this._outA1 = new byte[0];
        }
    }
}
