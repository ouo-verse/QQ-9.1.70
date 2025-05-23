package com.tencent.mobileqq.minigame.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.minigame.api.IArkShareForMiniBoxApi;
import com.tencent.mobileqq.minigame.api.OnShareListenerForMiniBox;
import com.tencent.mobileqq.minigame.api.OnSharePrepareListener;
import com.tencent.mobileqq.minigame.api.ShareAppInfo;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ArkShareForMiniBoxApiImpl implements IArkShareForMiniBoxApi {
    private static final String TAG = "MiniGameShareApiImpl";

    @Override // com.tencent.mobileqq.minigame.api.IArkShareForMiniBoxApi
    public void getShareMiniAppInfo(final String str, final Function1<? super ShareAppInfo, Unit> function1) {
        final String str2;
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null) {
            for (Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig> entry : miniGameVAInterceptConfig.getInterceptConfigMap().entrySet()) {
                if (TextUtils.equals(str, entry.getValue().getGameAppPkgName())) {
                    str2 = entry.getKey();
                    break;
                }
            }
        }
        str2 = "";
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "getShareMiniAppInfo vaInterceptConfig == null pkgName:" + str);
            return;
        }
        d92.h.b(str2, "", "", new d92.a() { // from class: com.tencent.mobileqq.minigame.api.impl.ArkShareForMiniBoxApiImpl.2
            @Override // d92.a
            public void onFail(int i3, String str3) {
                QLog.d(ArkShareForMiniBoxApiImpl.TAG, 1, "getShareMiniAppInfo onFail errorCode:" + i3 + " errorMsg:" + str3);
            }

            @Override // d92.a
            public void onSuccess(MiniAppInfo miniAppInfo) {
                if (miniAppInfo != null) {
                    ShareAppInfo shareAppInfo = new ShareAppInfo();
                    shareAppInfo.miniGameAppId = str2;
                    shareAppInfo.iconUrl = miniAppInfo.iconUrl;
                    shareAppInfo.reportType = miniAppInfo.getReportType();
                    shareAppInfo.versionType = miniAppInfo.verType;
                    shareAppInfo.versionId = miniAppInfo.versionId;
                    shareAppInfo.pkgName = str;
                    function1.invoke(shareAppInfo);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.api.IArkShareForMiniBoxApi
    public void prepareArkModel(MiniArkShareModel miniArkShareModel, final OnSharePrepareListener onSharePrepareListener) {
        ShareQQArkHelper.m(BaseApplication.getContext(), miniArkShareModel, new OnShareListenerForMiniBox() { // from class: com.tencent.mobileqq.minigame.api.impl.ArkShareForMiniBoxApiImpl.1
            @Override // com.tencent.mobileqq.minigame.api.OnShareListenerForMiniBox
            public void onSharePrepared(MiniArkShareModel miniArkShareModel2, JSONObject jSONObject, int i3) {
                onSharePrepareListener.onSharePrepared(miniArkShareModel2, jSONObject, i3);
            }

            @Override // com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener
            public void onShared(boolean z16, boolean z17) {
                QLog.i(ArkShareForMiniBoxApiImpl.TAG, 2, "startShare onShared:" + z17);
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.api.IArkShareForMiniBoxApi
    public void shareQQArk(Activity activity, MiniArkShareModel miniArkShareModel, JSONObject jSONObject, int i3) {
        if (ShareQQArkHelper.k(activity)) {
            return;
        }
        ShareQQArkHelper.l(activity, miniArkShareModel, jSONObject, i3);
    }
}
