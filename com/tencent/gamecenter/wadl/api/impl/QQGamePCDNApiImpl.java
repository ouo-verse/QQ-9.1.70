package com.tencent.gamecenter.wadl.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGamePCDNApi;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlPCDNSoManager;
import com.tencent.gamecenter.wadl.sdk.downloader.pcdn.PCDNInitParam;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/impl/QQGamePCDNApiImpl;", "Lcom/tencent/gamecenter/wadl/api/IQQGamePCDNApi;", "", "checkAndLoadSoAsync", "", "checkAndLoadSoSync", "isPCDNSwitchOpen", "isPCDNSOReady", "", "appId", "Lorg/json/JSONObject;", "getPCDNThreadConfig", "getPCDNConfig", "getPcdnBufferDirPath", "getPcdnLogPath", "Lcom/tencent/gamecenter/wadl/sdk/downloader/pcdn/PCDNInitParam;", "getPCDNInitParams", "<init>", "()V", "Companion", "a", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class QQGamePCDNApiImpl implements IQQGamePCDNApi {
    private static final int PCDN_UI_APPID = 20006;

    @NotNull
    private static final String TAG = "QQGamePCDNApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndLoadSoAsync$lambda$0(QQGamePCDNApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isPCDNSwitchOpen()) {
            QLog.w(TAG, 1, "isPCDNSwitchOpen, pcdn switch close");
        } else {
            WadlPCDNSoManager.getInstance().checkAndLoadSoAsync();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    public void checkAndLoadSoAsync() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                QQGamePCDNApiImpl.checkAndLoadSoAsync$lambda$0(QQGamePCDNApiImpl.this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    public boolean checkAndLoadSoSync() {
        return WadlPCDNSoManager.getInstance().checkAndLoadSoSync();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    @Nullable
    public JSONObject getPCDNConfig() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF, "");
        QLog.w(TAG, 1, "getPCDNConfig downloaderConfStr=" + loadAsString);
        if (!TextUtils.isEmpty(loadAsString)) {
            try {
                return new JSONObject(loadAsString).optJSONObject("pcdn");
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "optChangeThreadRate exception", th5);
            }
        }
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    @NotNull
    public PCDNInitParam getPCDNInitParams() {
        PCDNInitParam pCDNInitParam = new PCDNInitParam();
        pCDNInitParam.pcdnBufferDirPath = getPcdnBufferDirPath();
        pCDNInitParam.pcdnLogDirPath = getPcdnLogPath();
        JSONObject pCDNConfig = getPCDNConfig();
        if (pCDNConfig != null) {
            pCDNInitParam.autoDestroyGap = pCDNConfig.optLong("autoDestroyGap", MiniBoxNoticeInfo.MIN_5);
            boolean z16 = false;
            if (pCDNConfig.optInt("isEnablePCDNP2P", 0) == 1) {
                z16 = true;
            }
            pCDNInitParam.isEnablePCDNP2P = z16;
            pCDNInitParam.uiAppId = pCDNConfig.optInt("uiAppId", 20006);
            pCDNInitParam.pcdnReceiveOverTime = pCDNConfig.optLong("pcdnReceiveOverTime", 10000L);
        }
        return pCDNInitParam;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    @Nullable
    public JSONObject getPCDNThreadConfig(@Nullable String appId) {
        boolean z16;
        JSONObject pCDNConfig;
        JSONObject optJSONObject;
        if (!isPCDNSwitchOpen()) {
            return null;
        }
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (pCDNConfig = getPCDNConfig()) == null || (optJSONObject = pCDNConfig.optJSONObject("thread_conf")) == null) {
            return null;
        }
        return optJSONObject.optJSONObject(appId);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    @NotNull
    public String getPcdnBufferDirPath() {
        return MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/wadl/pcdn/buffers";
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    @NotNull
    public String getPcdnLogPath() {
        return MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/wadl/pcdn/logs";
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    public boolean isPCDNSOReady() {
        return WadlPCDNSoManager.getInstance().isPCDNSOReady();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGamePCDNApi
    public boolean isPCDNSwitchOpen() {
        JSONObject pCDNConfig = getPCDNConfig();
        if (pCDNConfig == null || pCDNConfig.optInt("pcdnSwitch", 0) != 1) {
            return false;
        }
        return true;
    }
}
