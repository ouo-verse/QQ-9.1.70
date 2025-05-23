package com.tencent.ams.dsdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SoConfig implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SoConfig> CREATOR;
    public int engineType;
    public boolean isForceUpdate;
    public List<SoPlatform> platforms;
    public String version;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface EngineType {
        public static final int HIPPY = 2;
        public static final int MOSAIC = 1;
        public static final int UNKNOWN = -1;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17750);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new Parcelable.Creator<SoConfig>() { // from class: com.tencent.ams.dsdk.data.SoConfig.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SoConfig createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SoConfig(parcel) : (SoConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SoConfig[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SoConfig[i3] : (SoConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public SoConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "SoConfig{engineType=" + this.engineType + ", version='" + this.version + "', isForceUpdate=" + this.isForceUpdate + ", platforms=" + this.platforms + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.engineType);
        parcel.writeString(this.version);
        parcel.writeTypedList(this.platforms);
        parcel.writeByte(this.isForceUpdate ? (byte) 1 : (byte) 0);
    }

    protected SoConfig(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.engineType = parcel.readInt();
        this.version = parcel.readString();
        this.platforms = parcel.createTypedArrayList(SoPlatform.CREATOR);
        this.isForceUpdate = parcel.readByte() == 0;
    }
}
