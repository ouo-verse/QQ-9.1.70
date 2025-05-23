package com.tencent.mobileqq.app;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class SharedExtProcessor extends com.tencent.mobileqq.config.l<ConfigData> {
    static IPatchRedirector $redirector_ = null;
    public static final int CONFIG_ID = 808;
    public static final String TAG = "mmkvConfigProcessor";

    public SharedExtProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ConfigData> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ConfigData.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReqFailed:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 808;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    public ConfigData migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? new ConfigData() : (ConfigData) iPatchRedirector.redirect((short) 8, (Object) this, i3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.config.l
    public ConfigData onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConfigData) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (aiVarArr == null || aiVarArr.length <= 0) {
            return null;
        }
        com.tencent.mobileqq.config.ai aiVar = aiVarArr[0];
        ConfigData configData = new ConfigData(aiVar.f202267a, aiVar.f202268b);
        configData.parse("onParsed");
        return configData;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(ConfigData configData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configData);
        } else if (configData != null) {
            configData.parse("onUpdate");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public static class ConfigData {
        static IPatchRedirector $redirector_;
        public String content;
        public int taskId;

        public ConfigData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.content = "";
                this.taskId = -1;
            }
        }

        public void parse(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            try {
                if (TextUtils.isEmpty(this.content)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(SharedExtProcessor.TAG, 2, String.format("ConfigData#parse from:%s %s", str, toString()));
                }
                JSONObject jSONObject = new JSONObject(this.content);
                if (jSONObject.has("sp_mmkv_backup") && jSONObject.has("sp_mmkv_enable")) {
                    jSONObject.optString("sp_mmkv_backup");
                    jSONObject.optString("sp_mmkv_enable");
                }
                if (jSONObject.has("sp_mmkv_store_count")) {
                    Integer.parseInt(jSONObject.optString("sp_mmkv_store_count"));
                }
                if (jSONObject.has("sp_mmkv_report")) {
                    jSONObject.optString("sp_mmkv_report");
                }
            } catch (JSONException e16) {
                QLog.e(SharedExtProcessor.TAG, 1, e16, new Object[0]);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return String.format("[ConfigData]taskId=%s content=%s", Integer.valueOf(this.taskId), this.content);
        }

        public ConfigData(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                this.taskId = i3;
                this.content = str;
            }
        }
    }
}
