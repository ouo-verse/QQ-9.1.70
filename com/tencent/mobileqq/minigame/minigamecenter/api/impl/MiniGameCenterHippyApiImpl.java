package com.tencent.mobileqq.minigame.minigamecenter.api.impl;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi;
import com.tencent.mobileqq.minigame.minigamecenter.api.impl.MiniGameCenterHippyApiImpl;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterApiProvider;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.minigame.minigamecenter.utils.MiniGameCenterHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameCenterHippyApiImpl implements IMiniGameCenterHippyApi {
    private static final String REPORT_MINI_APP_REFER = "";
    private static final int REPORT_MINI_APP_SOURCE = 0;
    private static final int REPORT_MINI_APP_VERSION_TYPE = 3;
    private static final String REPORT_MINI_APP_VIA = "activity";
    private static final String TAG = "MiniGameCenterApiImpl";
    private static final String UNITED_CONFIG_ID = "100504";

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public boolean canPreloadHippy() {
        return true;
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public HippyAPIProvider createHippyProvider() {
        return new MiniGameCenterApiProvider();
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public Class<? extends QPublicBaseFragment> getMiniGameCenterHippyClass() {
        return MiniGameCenterHippyFragment.class;
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public boolean hasNewMessage() {
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public boolean isMiniGameCenterModule(String str) {
        return TextUtils.equals(str, HippyQQConstants.ModuleName.QQ_MINI_GAME_CENTER);
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public boolean isUseHippy() {
        return true;
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public void reportMiniAppOpen(String str, MiniAppCmdInterface miniAppCmdInterface) {
        String str2;
        int i3 = 0;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(UNITED_CONFIG_ID, new byte[0]);
        if (loadRawConfig != null && loadRawConfig.length > 0) {
            String str3 = new String(loadRawConfig, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str3)) {
                QLog.i(TAG, 1, "reportMiniAppOpen config string is empty");
                callbackReportMiniAppOpen(miniAppCmdInterface, -1, "Parsing whitelist failed");
                return;
            }
            String[] split = str3.split(",");
            if (split != null && split.length > 0) {
                while (i3 < split.length && ((str2 = split[i3]) == null || !str.equals(str2.trim()))) {
                    i3++;
                }
                if (i3 >= split.length) {
                    QLog.i(TAG, 1, "reportMiniAppOpen appId isn't in whitelist");
                    callbackReportMiniAppOpen(miniAppCmdInterface, -1, "appId isn't in whitelist");
                    return;
                } else {
                    final SoftReference softReference = new SoftReference(miniAppCmdInterface);
                    MiniAppCmdUtil.getInstance().useUserApp(str, 3, 0, "", "activity", null, new MiniAppCmdInterface() { // from class: b92.a
                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                        public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                            MiniGameCenterHippyApiImpl.this.lambda$reportMiniAppOpen$0(softReference, z16, jSONObject);
                        }
                    });
                    return;
                }
            }
            QLog.i(TAG, 1, "reportMiniAppOpen appIdArray is empty");
            callbackReportMiniAppOpen(miniAppCmdInterface, -1, "whitelist is empty");
            return;
        }
        QLog.i(TAG, 1, "reportMiniAppOpen configBytes is empty");
        callbackReportMiniAppOpen(miniAppCmdInterface, -1, "can't get whitelist");
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public void setAppInfoBuffer(String str) {
        MiniGameCenterHelper.setAppInfoBuffer(str);
    }

    @Override // com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi
    public void setAppInfoTraceInfo(String str) {
        MiniGameCenterHelper.setAppInfoTraceInfo(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportMiniAppOpen$0(SoftReference softReference, boolean z16, JSONObject jSONObject) {
        if (z16) {
            callbackReportMiniAppOpen((MiniAppCmdInterface) softReference.get(), 0, "success");
        } else {
            callbackReportMiniAppOpen((MiniAppCmdInterface) softReference.get(), -1, "report failed");
        }
    }

    private void callbackReportMiniAppOpen(MiniAppCmdInterface miniAppCmdInterface, int i3, String str) {
        if (miniAppCmdInterface == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(QzoneIPCModule.RESULT_CODE, i3);
            jSONObject.put("resultMessage", str);
            miniAppCmdInterface.onCmdListener(i3 == 0, jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "callbackReportMiniAppOpen error:", e16);
        }
    }
}
