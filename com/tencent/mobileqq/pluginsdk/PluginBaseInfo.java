package com.tencent.mobileqq.pluginsdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes16.dex */
public class PluginBaseInfo implements Cloneable, Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<PluginBaseInfo> CREATOR;
    public static final int INSTALL_TYPE_DEAMON = 0;
    public static final int INSTALL_TYPE_NOTICE = 1;
    public static final int STATE_CANCEL = -1;
    public static final int STATE_DOWNLOADED = 2;
    public static final int STATE_DOWNLOADING = 1;
    public static final int STATE_ERROR = -2;
    public static final int STATE_INSTALLED = 4;
    public static final int STATE_INSTALLING = 3;
    public static final int STATE_NODOWNLOAD = 0;
    public static final int STATE_WAITING_INST_OR_DOWN = 5;
    public static final int SUB_TYPE_DYNAMIC_FEATURE_PLUGIN = 2;
    public static final int SUB_TYPE_QQ_PLUGIN = 0;
    public static final int SUB_TYPE_SHADOW_PLUGIN = 1;
    public static final int TYPE_APP = 2;
    public static final int TYPE_COUNT = 3;
    public static final int TYPE_PART = 0;
    public static final int TYPE_PLUGIN = 1;
    public static final int UPDATE_TYPE_FORCE = 1;
    public static final int UPDATE_TYPE_OPTIONAL = 0;
    public long costApk;
    public long costDex2Oat;
    public long costDownload;
    public long costLib;
    public long downloadDuration;
    public int installCode;
    public long mCurVersion;
    public float mDownloadProgress;
    public String mFingerPrint;
    public int mForceUrl;
    public String mID;
    public int mInstallType;
    public String mInstalledPath;
    public long mLength;
    public String mMD5;
    public String mName;
    public String mPackageName;
    public String mPatchDescription;
    public String[] mProcesses;
    public int mState;
    public int mSubType;
    public int mType;
    public String mURL;
    public int mUpdateType;
    public String mVersion;
    public int startDownloadNetType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new Parcelable.Creator<PluginBaseInfo>() { // from class: com.tencent.mobileqq.pluginsdk.PluginBaseInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PluginBaseInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new PluginBaseInfo(parcel) : (PluginBaseInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PluginBaseInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new PluginBaseInfo[i3] : (PluginBaseInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public PluginBaseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mProcesses = new String[0];
        this.mID = "";
        this.mName = "";
        this.mVersion = "";
        this.mURL = "";
        this.mMD5 = "";
        this.mLength = 0L;
        this.mCurVersion = 0L;
        this.mPackageName = "";
        this.mUpdateType = 1;
        this.mInstallType = 0;
        this.mFingerPrint = "";
        this.installCode = 0;
        this.downloadDuration = 0L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "" + this.mID + ", " + this.mPackageName + ", " + super.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeStringArray(this.mProcesses);
        parcel.writeString(this.mID);
        parcel.writeString(this.mName);
        parcel.writeString(this.mVersion);
        parcel.writeString(this.mURL);
        parcel.writeString(this.mMD5);
        parcel.writeLong(this.mLength);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mSubType);
        parcel.writeLong(this.mCurVersion);
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mInstalledPath);
        parcel.writeInt(this.mUpdateType);
        parcel.writeInt(this.mInstallType);
        parcel.writeInt(this.mState);
        parcel.writeFloat(this.mDownloadProgress);
        parcel.writeInt(this.mForceUrl);
        parcel.writeString(this.mFingerPrint);
        parcel.writeInt(this.startDownloadNetType);
        parcel.writeInt(this.installCode);
        parcel.writeLong(this.downloadDuration);
        parcel.writeLong(this.costDex2Oat);
        parcel.writeLong(this.costApk);
        parcel.writeLong(this.costLib);
        parcel.writeLong(this.costDownload);
        parcel.writeString(this.mPatchDescription);
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PluginBaseInfo mo210clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PluginBaseInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            return (PluginBaseInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    protected PluginBaseInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel);
            return;
        }
        this.mProcesses = new String[0];
        this.mID = "";
        this.mName = "";
        this.mVersion = "";
        this.mURL = "";
        this.mMD5 = "";
        this.mLength = 0L;
        this.mCurVersion = 0L;
        this.mPackageName = "";
        this.mUpdateType = 1;
        this.mInstallType = 0;
        this.mFingerPrint = "";
        this.installCode = 0;
        this.downloadDuration = 0L;
        this.mProcesses = parcel.createStringArray();
        this.mID = parcel.readString();
        this.mName = parcel.readString();
        this.mVersion = parcel.readString();
        this.mURL = parcel.readString();
        this.mMD5 = parcel.readString();
        this.mLength = parcel.readLong();
        this.mType = parcel.readInt();
        this.mSubType = parcel.readInt();
        this.mCurVersion = parcel.readLong();
        this.mPackageName = parcel.readString();
        this.mInstalledPath = parcel.readString();
        this.mUpdateType = parcel.readInt();
        this.mInstallType = parcel.readInt();
        this.mState = parcel.readInt();
        this.mDownloadProgress = parcel.readFloat();
        this.mForceUrl = parcel.readInt();
        this.mFingerPrint = parcel.readString();
        this.startDownloadNetType = parcel.readInt();
        this.installCode = parcel.readInt();
        this.downloadDuration = parcel.readLong();
        this.costDex2Oat = parcel.readLong();
        this.costApk = parcel.readLong();
        this.costLib = parcel.readLong();
        this.costDownload = parcel.readLong();
        this.mPatchDescription = parcel.readString();
    }
}
