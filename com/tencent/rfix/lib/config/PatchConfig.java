package com.tencent.rfix.lib.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.AbsStorableInfo;

@Keep
/* loaded from: classes25.dex */
public class PatchConfig extends AbsStorableInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_CONFIG_ID = "key_config_id";
    private static final String KEY_PATCH_MD5 = "key_patch_md5";
    private static final String KEY_PATCH_PROCESS = "key_patch_process";
    private static final String KEY_PATCH_URL = "key_patch_url";
    private static final String RFIX_PATCH_CONFIG = "rfix_patch_config";
    private static final String TAG = "RFix.PatchConfig";
    public int configId;
    public String patchMD5;
    public String patchProcess;
    public String patchUrl;

    public PatchConfig(Context context, boolean z16) {
        super(context, RFIX_PATCH_CONFIG, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
        }
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.configId != 0 && !TextUtils.isEmpty(this.patchUrl) && !TextUtils.isEmpty(this.patchMD5)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void loadStoreInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.loadStoreInfo();
        this.configId = this.storage.getInt(KEY_CONFIG_ID, 0);
        this.patchUrl = this.storage.getString(KEY_PATCH_URL, null);
        this.patchMD5 = this.storage.getString(KEY_PATCH_MD5, null);
        this.patchProcess = this.storage.getString(KEY_PATCH_PROCESS, null);
        RFixLog.i(TAG, "loadStoreInfo " + this);
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void saveStoreInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.storage.putInt(KEY_CONFIG_ID, this.configId);
        this.storage.putString(KEY_PATCH_URL, this.patchUrl);
        this.storage.putString(KEY_PATCH_MD5, this.patchMD5);
        this.storage.putString(KEY_PATCH_PROCESS, this.patchProcess);
        super.saveStoreInfo();
        RFixLog.i(TAG, "saveStoreInfo " + this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "PatchConfig{configId=" + this.configId + ", patchUrl='" + this.patchUrl + "', patchMD5='" + this.patchMD5 + "', patchProcess='" + this.patchProcess + "'}";
    }
}
