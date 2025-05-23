package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class SosoLocation implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SosoLocation> CREATOR;
    public float accuracy;
    public String address;
    public double altitude;
    public String city;
    public String cityCode;
    public String district;
    public int fakeReason;
    public long locationTime;
    public double mLat02;
    public double mLat84;
    public double mLon02;
    public double mLon84;
    public String mProviderSource;
    public String mVerifyKey;
    public String name;
    public String nation;
    public List<TencentPoi> poi;
    public String province;
    public float speed;
    public String street;
    public String streetNo;
    public String town;
    public String village;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new Parcelable.Creator<SosoLocation>() { // from class: com.tencent.mobileqq.soso.location.data.SosoLocation.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoLocation createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SosoLocation(parcel) : (SosoLocation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoLocation[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SosoLocation[i3] : (SosoLocation[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public SosoLocation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public SosoLocation clone(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SosoLocation) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        SosoLocation sosoLocation = new SosoLocation();
        if (z16) {
            sosoLocation.mLat02 = this.mLat02;
            sosoLocation.mLon02 = this.mLon02;
            sosoLocation.mLat84 = this.mLat84;
            sosoLocation.mLon84 = this.mLon84;
        }
        sosoLocation.speed = this.speed;
        sosoLocation.altitude = this.altitude;
        sosoLocation.accuracy = this.accuracy;
        sosoLocation.mVerifyKey = this.mVerifyKey;
        sosoLocation.fakeReason = this.fakeReason;
        sosoLocation.locationTime = this.locationTime;
        sosoLocation.mProviderSource = this.mProviderSource;
        if (i3 == 1 || i3 == 3 || i3 == 4) {
            sosoLocation.name = this.name;
            sosoLocation.address = this.address;
        }
        if (i3 == 3 || i3 == 4) {
            sosoLocation.nation = this.nation;
            sosoLocation.province = this.province;
            sosoLocation.city = this.city;
            sosoLocation.cityCode = this.cityCode;
            sosoLocation.district = this.district;
            sosoLocation.town = this.town;
            sosoLocation.village = this.village;
            sosoLocation.street = this.street;
            sosoLocation.streetNo = this.streetNo;
        }
        if (i3 == 4) {
            LinkedList linkedList = new LinkedList();
            List<TencentPoi> list = this.poi;
            if (list != null && list.size() > 0) {
                linkedList.addAll(this.poi);
            }
            sosoLocation.poi = linkedList;
        }
        return sosoLocation;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeDouble(this.mLat02);
        parcel.writeDouble(this.mLon02);
        parcel.writeDouble(this.mLat84);
        parcel.writeDouble(this.mLon84);
        parcel.writeDouble(this.altitude);
        parcel.writeFloat(this.accuracy);
        parcel.writeInt(this.fakeReason);
        parcel.writeLong(this.locationTime);
        parcel.writeFloat(this.speed);
        parcel.writeString(this.name);
        parcel.writeString(this.address);
        parcel.writeString(this.nation);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.cityCode);
        parcel.writeString(this.district);
        parcel.writeString(this.town);
        parcel.writeString(this.village);
        parcel.writeString(this.street);
        parcel.writeString(this.streetNo);
        parcel.writeString(this.mVerifyKey);
        parcel.writeString(this.mProviderSource);
    }

    protected SosoLocation(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.mLat02 = parcel.readDouble();
        this.mLon02 = parcel.readDouble();
        this.mLat84 = parcel.readDouble();
        this.mLon84 = parcel.readDouble();
        this.altitude = parcel.readDouble();
        this.accuracy = parcel.readFloat();
        this.fakeReason = parcel.readInt();
        this.locationTime = parcel.readLong();
        this.speed = parcel.readFloat();
        this.name = parcel.readString();
        this.address = parcel.readString();
        this.nation = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.cityCode = parcel.readString();
        this.district = parcel.readString();
        this.town = parcel.readString();
        this.village = parcel.readString();
        this.street = parcel.readString();
        this.streetNo = parcel.readString();
        this.mVerifyKey = parcel.readString();
        this.mProviderSource = parcel.readString();
    }
}
