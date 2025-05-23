package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SosoLbsInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SosoLbsInfo> CREATOR;
    public SosoAttribute mAttr;
    public ArrayList<SosoCell> mCells;
    public SosoLocation mLocation;
    public long mSource;
    public String mVersion;
    public ArrayList<SosoWifi> mWifis;
    public String provider;
    public byte[] rawData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new Parcelable.Creator<SosoLbsInfo>() { // from class: com.tencent.mobileqq.soso.location.data.SosoLbsInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoLbsInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SosoLbsInfo(parcel) : (SosoLbsInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoLbsInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SosoLbsInfo[i3] : (SosoLbsInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public SosoLbsInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCells = new ArrayList<>();
            this.mWifis = new ArrayList<>();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeByteArray(this.rawData);
        parcel.writeString(this.mVersion);
        parcel.writeLong(this.mSource);
        parcel.writeParcelable(this.mAttr, i3);
        parcel.writeParcelable(this.mLocation, i3);
        parcel.writeString(this.provider);
        parcel.writeTypedList(this.mCells);
        parcel.writeTypedList(this.mWifis);
    }

    protected SosoLbsInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mCells = new ArrayList<>();
        this.mWifis = new ArrayList<>();
        this.rawData = parcel.createByteArray();
        this.mVersion = parcel.readString();
        this.mSource = parcel.readLong();
        this.mAttr = (SosoAttribute) parcel.readParcelable(SosoAttribute.class.getClassLoader());
        this.mLocation = (SosoLocation) parcel.readParcelable(SosoLocation.class.getClassLoader());
        this.provider = parcel.readString();
        this.mCells = parcel.createTypedArrayList(SosoCell.CREATOR);
        this.mWifis = parcel.createTypedArrayList(SosoWifi.CREATOR);
    }
}
