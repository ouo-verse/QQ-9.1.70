package com.tencent.freesia;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GetConfigReq implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<GetConfigReq> CREATOR;
    public final CommonInfo mCommonInfo;
    public final String mConfigSnapshot;
    public final ControlInfo mControlInfo;
    public final DeviceInfo mDeviceInfo;
    public final Extend mExtend;
    public final FetchType mFetchType;
    public final ArrayList<GroupInfo> mGroupInfos;
    public final ReqPageInfo mPageInfo;
    public final ArrayList<ProjectInfo> mProjectInfos;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new Parcelable.Creator<GetConfigReq>() { // from class: com.tencent.freesia.GetConfigReq.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GetConfigReq createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new GetConfigReq(parcel) : (GetConfigReq) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GetConfigReq[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new GetConfigReq[i3] : (GetConfigReq[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public GetConfigReq(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        if (parcel.readByte() == 0) {
            this.mCommonInfo = null;
        } else {
            this.mCommonInfo = new CommonInfo(parcel);
        }
        ArrayList<GroupInfo> arrayList = new ArrayList<>();
        this.mGroupInfos = arrayList;
        parcel.readList(arrayList, GetConfigReq.class.getClassLoader());
        this.mDeviceInfo = new DeviceInfo(parcel);
        this.mControlInfo = new ControlInfo(parcel);
        ArrayList<ProjectInfo> arrayList2 = new ArrayList<>();
        this.mProjectInfos = arrayList2;
        parcel.readList(arrayList2, GetConfigReq.class.getClassLoader());
        if (parcel.readByte() == 0) {
            this.mPageInfo = null;
        } else {
            this.mPageInfo = new ReqPageInfo(parcel);
        }
        this.mFetchType = FetchType.values()[parcel.readInt()];
        this.mExtend = new Extend(parcel);
        this.mConfigSnapshot = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public CommonInfo getCommonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CommonInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mCommonInfo;
    }

    @NonNull
    public String getConfigSnapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mConfigSnapshot;
    }

    @NonNull
    public ControlInfo getControlInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ControlInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mControlInfo;
    }

    @NonNull
    public DeviceInfo getDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DeviceInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mDeviceInfo;
    }

    @NonNull
    public Extend getExtend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Extend) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mExtend;
    }

    @NonNull
    public FetchType getFetchType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FetchType) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mFetchType;
    }

    @NonNull
    public ArrayList<GroupInfo> getGroupInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mGroupInfos;
    }

    @Nullable
    public ReqPageInfo getPageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ReqPageInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mPageInfo;
    }

    @NonNull
    public ArrayList<ProjectInfo> getProjectInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mProjectInfos;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "GetConfigReq{mCommonInfo=" + this.mCommonInfo + ",mGroupInfos=" + this.mGroupInfos + ",mDeviceInfo=" + this.mDeviceInfo + ",mControlInfo=" + this.mControlInfo + ",mProjectInfos=" + this.mProjectInfos + ",mPageInfo=" + this.mPageInfo + ",mFetchType=" + this.mFetchType + ",mExtend=" + this.mExtend + ",mConfigSnapshot=" + this.mConfigSnapshot + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel, i3);
            return;
        }
        if (this.mCommonInfo != null) {
            parcel.writeByte((byte) 1);
            this.mCommonInfo.writeToParcel(parcel, i3);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeList(this.mGroupInfos);
        this.mDeviceInfo.writeToParcel(parcel, i3);
        this.mControlInfo.writeToParcel(parcel, i3);
        parcel.writeList(this.mProjectInfos);
        if (this.mPageInfo != null) {
            parcel.writeByte((byte) 1);
            this.mPageInfo.writeToParcel(parcel, i3);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeInt(this.mFetchType.ordinal());
        this.mExtend.writeToParcel(parcel, i3);
        parcel.writeString(this.mConfigSnapshot);
    }

    public GetConfigReq(@Nullable CommonInfo commonInfo, @NonNull ArrayList<GroupInfo> arrayList, @NonNull DeviceInfo deviceInfo, @NonNull ControlInfo controlInfo, @NonNull ArrayList<ProjectInfo> arrayList2, @Nullable ReqPageInfo reqPageInfo, @NonNull FetchType fetchType, @NonNull Extend extend, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, commonInfo, arrayList, deviceInfo, controlInfo, arrayList2, reqPageInfo, fetchType, extend, str);
            return;
        }
        this.mCommonInfo = commonInfo;
        this.mGroupInfos = arrayList;
        this.mDeviceInfo = deviceInfo;
        this.mControlInfo = controlInfo;
        this.mProjectInfos = arrayList2;
        this.mPageInfo = reqPageInfo;
        this.mFetchType = fetchType;
        this.mExtend = extend;
        this.mConfigSnapshot = str;
    }
}
