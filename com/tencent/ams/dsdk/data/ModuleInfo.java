package com.tencent.ams.dsdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ModuleInfo implements Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<ModuleInfo> CREATOR;
    private static final String TAG = "ModuleInfo";
    private static final long serialVersionUID = 1019745655600408577L;
    private List<String> dependencies;
    private int encryptType;
    private JSONObject extra;
    private int fileType;
    private boolean forceUpdate;

    /* renamed from: id, reason: collision with root package name */
    private String f70114id;
    private String md5;
    private String name;
    private String url;
    private String version;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface EncryptType {
        public static final int COMPILED = 2;
        public static final int DES_ENCRYPT = 1;
        public static final int NO_ENCRYPT = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface FileType {
        public static final int BUSINESS = 2;
        public static final int VENDOR = 1;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17730);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            CREATOR = new Parcelable.Creator<ModuleInfo>() { // from class: com.tencent.ams.dsdk.data.ModuleInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ModuleInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ModuleInfo(parcel) : (ModuleInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ModuleInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ModuleInfo[i3] : (ModuleInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public ModuleInfo(String str, String str2, boolean z16, String str3, int i3, String str4, String str5, int i16, JSONObject jSONObject, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3), str4, str5, Integer.valueOf(i16), jSONObject, list);
            return;
        }
        this.f70114id = str;
        this.version = str2;
        this.forceUpdate = z16;
        this.name = str3;
        this.fileType = i3;
        this.url = str4;
        this.md5 = str5;
        this.encryptType = i16;
        this.extra = jSONObject;
        this.dependencies = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ModuleInfo moduleInfo = (ModuleInfo) obj;
        if (this.forceUpdate == moduleInfo.forceUpdate && this.fileType == moduleInfo.fileType && Objects.equals(this.f70114id, moduleInfo.f70114id) && Objects.equals(this.version, moduleInfo.version) && Objects.equals(this.name, moduleInfo.name) && Objects.equals(this.url, moduleInfo.url) && Objects.equals(this.md5, moduleInfo.md5) && Objects.equals(this.extra, moduleInfo.extra)) {
            return true;
        }
        return false;
    }

    public List<String> getDependencies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.dependencies;
    }

    public int getEncryptType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.encryptType;
    }

    public JSONObject getExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (JSONObject) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.extra;
    }

    public int getFileType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.fileType;
    }

    public String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f70114id;
    }

    public String getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.md5;
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.name;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.url;
    }

    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.version;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return Objects.hash(this.f70114id, this.version, Boolean.valueOf(this.forceUpdate), this.name, Integer.valueOf(this.fileType), this.url, this.md5, this.extra);
    }

    public boolean isBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (this.fileType == 2) {
            return true;
        }
        return false;
    }

    public boolean isForceUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.forceUpdate;
    }

    public boolean isVendor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (this.fileType == 1) {
            return true;
        }
        return false;
    }

    public void setEncryptType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.encryptType = i3;
        }
    }

    public void setExtra(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) jSONObject);
        } else {
            this.extra = jSONObject;
        }
    }

    public void setFileType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.fileType = i3;
        }
    }

    public void setForceUpdate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.forceUpdate = z16;
        }
    }

    public void setId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f70114id = str;
        }
    }

    public void setMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.md5 = str;
        }
    }

    public void setName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.name = str;
        }
    }

    public void setUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.url = str;
        }
    }

    public void setVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.version = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "ModuleInfo{id='" + this.f70114id + "', version='" + this.version + "', forceUpdate=" + this.forceUpdate + ", name='" + this.name + "', fileType=" + this.fileType + ", url='" + this.url + "', md5='" + this.md5 + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f70114id);
        parcel.writeString(this.version);
        parcel.writeByte(this.forceUpdate ? (byte) 1 : (byte) 0);
        parcel.writeString(this.name);
        parcel.writeInt(this.fileType);
        parcel.writeString(this.url);
        parcel.writeString(this.md5);
        parcel.writeInt(this.encryptType);
        JSONObject jSONObject2 = this.extra;
        if (jSONObject2 == null) {
            jSONObject = null;
        } else {
            jSONObject = jSONObject2.toString();
        }
        parcel.writeString(jSONObject);
        parcel.writeStringList(this.dependencies);
    }

    protected ModuleInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f70114id = parcel.readString();
        this.version = parcel.readString();
        this.forceUpdate = parcel.readByte() != 0;
        this.name = parcel.readString();
        this.fileType = parcel.readInt();
        this.url = parcel.readString();
        this.md5 = parcel.readString();
        this.encryptType = parcel.readInt();
        String readString = parcel.readString();
        if (!TextUtils.isEmpty(readString)) {
            try {
                this.extra = new JSONObject(readString);
            } catch (Throwable th5) {
                DLog.e(TAG, "str to json error.", th5);
            }
        }
        ArrayList arrayList = new ArrayList();
        this.dependencies = arrayList;
        parcel.readStringList(arrayList);
    }
}
