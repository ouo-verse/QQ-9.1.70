package com.tencent.mobileqq.uftransfer.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "sessionKey")
/* loaded from: classes19.dex */
public class UploadInfoEntity extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int EXT_TYPE_C2C = 2;
    public static final int EXT_TYPE_TROOP = 1;
    public static final String TABLE_NAME = "upload_info";
    public static final String UNIQUE_KEY_CAUSE = "sessionKey=?";
    public String extRspJsonData;
    public int extRspType;
    public String fileId;
    public String hostListStr;
    public String httpsDomain;

    @unique
    public String sessionKey;
    public String strCheckSum;
    public String strSha;
    public String urlParams;
    public boolean useHttps;
    public boolean useIpV6;

    public UploadInfoEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TABLE_NAME;
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.sessionKey) && this.extRspType != 0 && !TextUtils.isEmpty(this.extRspJsonData) && !"{}".equals(this.extRspJsonData)) {
            return true;
        }
        return false;
    }

    public boolean isValidC2CCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (isValid() && this.extRspType == 2) {
            return true;
        }
        return false;
    }

    public boolean isValidTroopCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (isValid() && this.extRspType == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "UploadInfoEntity{sessionKey='" + this.sessionKey + "', fileId='" + this.fileId + "', extRspType=" + this.extRspType + ", useHttps=" + this.useHttps + ", httpsDomain='" + this.httpsDomain + "', hostList=" + this.hostListStr + ", urlParams='" + this.urlParams + "', useIpV6=" + this.useIpV6 + ", strCheckSum='" + this.strCheckSum + "', strSha='" + this.strSha + "', extRspJsonData='" + this.extRspJsonData + "'}";
    }
}
