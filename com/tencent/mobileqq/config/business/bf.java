package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bf implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, bg> f202604d = new HashMap<>();

    public bf() {
        bg bgVar = new bg();
        bgVar.g(true);
        bgVar.f(ITeamWorkUtils.TROOP_FORM_MIMI_ENTRY);
        this.f202604d.put(ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING, bgVar);
    }

    @NonNull
    public static bf b(String str) {
        String str2;
        if (str != null && !str.isEmpty()) {
            QLog.d("TencentDocsPushBean", 2, str);
            bf bfVar = new bf();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("MiniCodeConfigAioMsg")) {
                    str2 = "MiniCodeConfigAioArkH5";
                } else {
                    str2 = "MiniCodeConfigAioArkH5";
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_MSG, bg.e((JSONObject) jSONObject.get("MiniCodeConfigAioMsg")));
                }
                if (jSONObject.has("MiniCodeConfigAioEdit")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_EDIT, bg.e((JSONObject) jSONObject.get("MiniCodeConfigAioEdit")));
                }
                if (jSONObject.has("MiniCodeConfigBottomEdit")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_BOTTOM_EDIT, bg.e((JSONObject) jSONObject.get("MiniCodeConfigBottomEdit")));
                }
                if (jSONObject.has("MiniCodeConfigMyFile")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MY_FILE, bg.e((JSONObject) jSONObject.get("MiniCodeConfigMyFile")));
                } else if (jSONObject.has("MiniCodeConfigTroopFile")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_TROOP_FILE, bg.e((JSONObject) jSONObject.get("MiniCodeConfigTroopFile")));
                } else if (jSONObject.has("MiniCodeConfigGrayBar")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_GRAY_BAR, bg.e((JSONObject) jSONObject.get("MiniCodeConfigGrayBar")));
                }
                if (jSONObject.has("MiniCodeConfigMenuEdit")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MENU_EDIT, bg.e((JSONObject) jSONObject.get("MiniCodeConfigMenuEdit")));
                }
                if (jSONObject.has("MiniCodeConfigDownloadEdit")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_DOWNLOAD_EDIT, bg.e((JSONObject) jSONObject.get("MiniCodeConfigDownloadEdit")));
                }
                if (jSONObject.has(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_ONLINE_PREVIEW)) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_ONLINE_PREVIEW, bg.e((JSONObject) jSONObject.get(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_ONLINE_PREVIEW)));
                }
                if (jSONObject.has("MiniCodeConfigTemplateList")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_TEMPLATELIST, bg.e((JSONObject) jSONObject.get("MiniCodeConfigTemplateList")));
                }
                if (jSONObject.has("MiniCodeConfigOcrSave")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_OCR_SAVE, bg.e((JSONObject) jSONObject.get("MiniCodeConfigOcrSave")));
                }
                if (jSONObject.has("MiniCodeConfigUrl2Doc")) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_URL_2_DOC, bg.e((JSONObject) jSONObject.get("MiniCodeConfigUrl2Doc")));
                }
                String str3 = str2;
                if (jSONObject.has(str3)) {
                    bfVar.f202604d.put(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_ARK_H5, bg.e((JSONObject) jSONObject.get(str3)));
                }
            } catch (Exception e16) {
                QLog.e("TencentDocsPushBean", 1, e16.getLocalizedMessage(), e16);
            }
            return bfVar;
        }
        QLog.e("TencentDocsPushBean", 1, "content is empty, return");
        return new bf();
    }

    public HashMap<String, bg> a() {
        return this.f202604d;
    }
}
