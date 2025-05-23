package com.tencent.mobileqq.minispecial.kuikly.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minikuikly.MiniKuiklyBaseFragment;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import f92.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniKuiklyApiImpl implements IMiniKuiklyApi {
    private static final String TAG = "MiniKuiklyApiImpl";
    private String sharePicUrl;
    private String shareQuery;
    private String shareText;

    private String parseUrl(String str) {
        try {
            return new JSONObject(str).optString("url");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseUrl: failed, params=" + str, e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public boolean checkAndParseMcKuiklyConfig(Object obj) {
        if (!(obj instanceof MiniAppInfo)) {
            return true;
        }
        String str = ((MiniAppInfo) obj).appId;
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101793");
        return (aVar == null || !aVar.a().containsKey(str) || aVar.a().get(str) == null) ? false : true;
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public Map<String, Object> getKuiklyPageData(QBaseActivity qBaseActivity) {
        QBaseFragment miniKuiklyBaseFragment = getMiniKuiklyBaseFragment(qBaseActivity);
        if (miniKuiklyBaseFragment instanceof MiniKuiklyBaseFragment) {
            return ((MiniKuiklyBaseFragment) miniKuiklyBaseFragment).rh();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public g92.a getKuiklyUIProxy(Activity activity) {
        return new e92.a(activity);
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public QBaseFragment getMiniKuiklyBaseFragment(QBaseActivity qBaseActivity) {
        if (qBaseActivity instanceof GameActivity1) {
            return (QBaseFragment) ((GameActivity1) qBaseActivity).getSupportFragmentManager().findFragmentById(R.id.ckj);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public Map<String, String> getShareParams() {
        if (TextUtils.isEmpty(this.shareText) || TextUtils.isEmpty(this.sharePicUrl)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ThirdPartyMiniPageProxy.KEY_SHARE_TEXT, this.shareText);
        hashMap.put(ThirdPartyMiniPageProxy.KEY_SHARE_PIC_URL, this.sharePicUrl);
        if (!TextUtils.isEmpty(this.shareQuery)) {
            hashMap.put(ThirdPartyMiniPageProxy.KEY_SHARE_QUERY, this.shareQuery);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public boolean isLaunchByMiniApp(Context context) {
        if (context instanceof GameActivity1) {
            return ((GameActivity1) context).isMiniKuiklyEngine();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public boolean isMiniKuikly(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str2, false);
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public void openUrl(Context context, String str) {
        if (context instanceof GameActivity1) {
            GameActivity1 gameActivity1 = (GameActivity1) context;
            if (gameActivity1.isMiniKuiklyEngine()) {
                String parseUrl = parseUrl(str);
                if (TextUtils.isEmpty(parseUrl)) {
                    QLog.e(TAG, 1, "openUrl: parseUrl null. params=" + str);
                    return;
                }
                gameActivity1.openUrl(parseUrl);
            }
        }
    }

    @Override // com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi
    public void setShareParams(String str, String str2, String str3) {
        this.shareText = str;
        this.sharePicUrl = str2;
        this.shareQuery = str3;
    }
}
