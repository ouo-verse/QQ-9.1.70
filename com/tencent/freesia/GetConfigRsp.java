package com.tencent.freesia;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GetConfigRsp implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<GetConfigRsp> CREATOR;
    public final String mConfigSnapshot;
    public final ArrayList<Config> mConfigs;
    public final RespControlInfo mControlInfo;
    public final ArrayList<String> mDebugMsgs;
    public final boolean mEnableConfigSnapshot;
    public final byte[] mExtInfo;
    public final RespPageInfo mPageInfo;
    public final int mResourceReportDenominator;
    public final SnapshotResult mSnapshotResult;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10973);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new Parcelable.Creator<GetConfigRsp>() { // from class: com.tencent.freesia.GetConfigRsp.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GetConfigRsp createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new GetConfigRsp(parcel) : (GetConfigRsp) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GetConfigRsp[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new GetConfigRsp[i3] : (GetConfigRsp[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public GetConfigRsp(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mExtInfo = parcel.createByteArray();
        ArrayList<Config> arrayList = new ArrayList<>();
        this.mConfigs = arrayList;
        parcel.readList(arrayList, GetConfigRsp.class.getClassLoader());
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.mDebugMsgs = arrayList2;
        parcel.readList(arrayList2, GetConfigRsp.class.getClassLoader());
        this.mControlInfo = new RespControlInfo(parcel);
        this.mPageInfo = new RespPageInfo(parcel);
        this.mEnableConfigSnapshot = parcel.readByte() != 0;
        this.mConfigSnapshot = parcel.readString();
        this.mResourceReportDenominator = parcel.readInt();
        this.mSnapshotResult = SnapshotResult.values()[parcel.readInt()];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 0;
    }

    @NonNull
    public String getConfigSnapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mConfigSnapshot;
    }

    @NonNull
    public ArrayList<Config> getConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mConfigs;
    }

    @NonNull
    public RespControlInfo getControlInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RespControlInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mControlInfo;
    }

    @NonNull
    public ArrayList<String> getDebugMsgs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mDebugMsgs;
    }

    public boolean getEnableConfigSnapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mEnableConfigSnapshot;
    }

    @NonNull
    public byte[] getExtInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mExtInfo;
    }

    @NonNull
    public RespPageInfo getPageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RespPageInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mPageInfo;
    }

    public int getResourceReportDenominator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mResourceReportDenominator;
    }

    @NonNull
    public SnapshotResult getSnapshotResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SnapshotResult) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mSnapshotResult;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "GetConfigRsp{mExtInfo=" + this.mExtInfo + ",mConfigs=" + this.mConfigs + ",mDebugMsgs=" + this.mDebugMsgs + ",mControlInfo=" + this.mControlInfo + ",mPageInfo=" + this.mPageInfo + ",mEnableConfigSnapshot=" + this.mEnableConfigSnapshot + ",mConfigSnapshot=" + this.mConfigSnapshot + ",mResourceReportDenominator=" + this.mResourceReportDenominator + ",mSnapshotResult=" + this.mSnapshotResult + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeByteArray(this.mExtInfo);
        parcel.writeList(this.mConfigs);
        parcel.writeList(this.mDebugMsgs);
        this.mControlInfo.writeToParcel(parcel, i3);
        this.mPageInfo.writeToParcel(parcel, i3);
        parcel.writeByte(this.mEnableConfigSnapshot ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mConfigSnapshot);
        parcel.writeInt(this.mResourceReportDenominator);
        parcel.writeInt(this.mSnapshotResult.ordinal());
    }

    public GetConfigRsp(@NonNull byte[] bArr, @NonNull ArrayList<Config> arrayList, @NonNull ArrayList<String> arrayList2, @NonNull RespControlInfo respControlInfo, @NonNull RespPageInfo respPageInfo, boolean z16, @NonNull String str, int i3, @NonNull SnapshotResult snapshotResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, arrayList, arrayList2, respControlInfo, respPageInfo, Boolean.valueOf(z16), str, Integer.valueOf(i3), snapshotResult);
            return;
        }
        this.mExtInfo = bArr;
        this.mConfigs = arrayList;
        this.mDebugMsgs = arrayList2;
        this.mControlInfo = respControlInfo;
        this.mPageInfo = respPageInfo;
        this.mEnableConfigSnapshot = z16;
        this.mConfigSnapshot = str;
        this.mResourceReportDenominator = i3;
        this.mSnapshotResult = snapshotResult;
    }
}
