package com.tencent.mobileqq.auto.engine.loader.net;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "mBusinessKey,mVersion")
/* loaded from: classes11.dex */
public class ASDataBaseInfo extends Entity implements Cloneable, Serializable {
    static IPatchRedirector $redirector_;
    public String mBusinessKey;
    public String mCookie;
    public boolean mIsInvalid;
    public boolean mIsReady;
    public long mManagerFileLength;
    public String mManagerFileUrl;
    public String mPluginManagerPath;
    public String mPluginZipPath;
    public String mQua;
    public long mUin;
    public int mVersion;
    public long mZipFileLength;
    public String mZipFileUrl;

    public ASDataBaseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String getBusinessKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mBusinessKey;
    }

    public String getCookie() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mCookie;
    }

    public long getManagerFileLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return this.mManagerFileLength;
    }

    public String getManagerFileUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mManagerFileUrl;
    }

    public String getPluginManagerPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mPluginManagerPath;
    }

    public String getPluginZipPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mPluginZipPath;
    }

    public String getQua() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mQua;
    }

    public long getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        return this.mUin;
    }

    public int getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mVersion;
    }

    public long getZipFileLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this)).longValue();
        }
        return this.mZipFileLength;
    }

    public String getZipFileUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mZipFileUrl;
    }

    public boolean isInvalid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.mIsInvalid;
    }

    public boolean isReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.mIsReady;
    }

    public void setBusinessKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mBusinessKey = str;
        }
    }

    public void setCookie(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.mCookie = str;
        }
    }

    public void setIsInvalid(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mIsInvalid = z16;
        }
    }

    public void setIsReady(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.mIsReady = z16;
        }
    }

    public void setManagerFileLength(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
        } else {
            this.mManagerFileLength = j3;
        }
    }

    public void setManagerFileUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.mManagerFileUrl = str;
        }
    }

    public void setPluginManagerPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.mPluginManagerPath = str;
        }
    }

    public void setPluginZipPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.mPluginZipPath = str;
        }
    }

    public void setQua(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mQua = str;
        }
    }

    public void setUin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            this.mUin = j3;
        }
    }

    public void setVersion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mVersion = i3;
        }
    }

    public void setZipFileLength(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, j3);
        } else {
            this.mZipFileLength = j3;
        }
    }

    public void setZipFileUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            this.mZipFileUrl = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("ASDataBaseInfo{");
        stringBuffer.append("mVersion=");
        stringBuffer.append(this.mVersion);
        stringBuffer.append(", mQua='");
        stringBuffer.append(this.mQua);
        stringBuffer.append('\'');
        stringBuffer.append(", mBusinessKey='");
        stringBuffer.append(this.mBusinessKey);
        stringBuffer.append('\'');
        stringBuffer.append(", mPluginZipPath='");
        stringBuffer.append(this.mPluginZipPath);
        stringBuffer.append('\'');
        stringBuffer.append(", mPluginManagerPath='");
        stringBuffer.append(this.mPluginManagerPath);
        stringBuffer.append('\'');
        stringBuffer.append(", mCookie='");
        stringBuffer.append(this.mCookie);
        stringBuffer.append('\'');
        stringBuffer.append(", mIsInvalid=");
        stringBuffer.append(this.mIsInvalid);
        stringBuffer.append(", mZipFileUrl='");
        stringBuffer.append(this.mZipFileUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mManagerFileUrl='");
        stringBuffer.append(this.mManagerFileUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mZipFileLength=");
        stringBuffer.append(this.mZipFileLength);
        stringBuffer.append(", mManagerFileLength=");
        stringBuffer.append(this.mManagerFileLength);
        stringBuffer.append(", mIsReady=");
        stringBuffer.append(this.mIsReady);
        stringBuffer.append(", mUin=");
        stringBuffer.append(this.mUin);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
