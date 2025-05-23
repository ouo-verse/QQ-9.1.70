package com.tencent.ams.dsdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TemplateInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<TemplateInfo> CREATOR;
    private int mDownloadType;
    private boolean mForceUpdate;
    private String mMd5;
    private String mMinModuleVersion;
    private String mTemplateId;
    private String mUrl;
    private String mVersion;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            CREATOR = new Parcelable.Creator<TemplateInfo>() { // from class: com.tencent.ams.dsdk.data.TemplateInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public TemplateInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new TemplateInfo(parcel) : (TemplateInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public TemplateInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new TemplateInfo[i3] : (TemplateInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public TemplateInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mDownloadType = 0;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TemplateInfo templateInfo = (TemplateInfo) obj;
        if (this.mForceUpdate == templateInfo.mForceUpdate && (((str = this.mTemplateId) == templateInfo.mTemplateId || (!TextUtils.isEmpty(str) && this.mTemplateId.equals(templateInfo.mTemplateId))) && ((str2 = this.mUrl) == templateInfo.mUrl || (!TextUtils.isEmpty(str2) && this.mUrl.equals(templateInfo.mUrl))))) {
            String str3 = this.mMd5;
            if (str3 == templateInfo.mMd5) {
                return true;
            }
            if (!TextUtils.isEmpty(str3) && this.mMd5.equals(templateInfo.mMd5)) {
                return true;
            }
        }
        return false;
    }

    public int getDownloadType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mDownloadType;
    }

    public String getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mMd5;
    }

    public String getMinModuleVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mMinModuleVersion;
    }

    public String getTemplateId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mTemplateId;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mUrl;
    }

    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mVersion;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return Objects.hash(this.mTemplateId, this.mUrl, this.mMd5, Boolean.valueOf(this.mForceUpdate));
    }

    public boolean isForceUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.mForceUpdate;
    }

    public void setDownloadType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mDownloadType = i3;
        }
    }

    public void setForceUpdate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.mForceUpdate = z16;
        }
    }

    public void setMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.mMd5 = str;
        }
    }

    public void setMinModuleVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.mMinModuleVersion = str;
        }
    }

    public void setTemplateId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mTemplateId = str;
        }
    }

    public void setUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mUrl = str;
        }
    }

    public void setVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.mVersion = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "TemplateInfo{templateId='" + this.mTemplateId + "', url='" + this.mUrl + "', md5='" + this.mMd5 + "', minModuleVersion='" + this.mMinModuleVersion + "', downloadType='" + this.mDownloadType + "', version='" + this.mVersion + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.mTemplateId);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mMd5);
        parcel.writeByte(this.mForceUpdate ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mMinModuleVersion);
        parcel.writeString(this.mVersion);
    }

    protected TemplateInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.mDownloadType = 0;
        this.mTemplateId = parcel.readString();
        this.mUrl = parcel.readString();
        this.mMd5 = parcel.readString();
        this.mForceUpdate = parcel.readByte() == 1;
        this.mMinModuleVersion = parcel.readString();
        this.mVersion = parcel.readString();
    }
}
