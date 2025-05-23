package com.tencent.hippy.qq.api.impl;

import android.os.Bundle;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.update.HippyPredownloadManager;
import com.tencent.hippy.qq.update.HippyTabConfigManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyUpdateImpl implements IHippyUpdate {
    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public boolean checkUpdateJsBundleInterval(String str) {
        return HippyUpdateManager.getInstance().checkUpdateJsBundleInterval(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public void commonUpdateJsBundle(String str, String str2, IUpdateListener iUpdateListener) {
        Bundle bundle = new Bundle();
        bundle.putString("reportFrom", str2);
        HippyUpdateManager.getInstance().updateJsBundle(str, ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, bundle, iUpdateListener);
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public HippyConfig getHippyConfig() {
        return HippyPredownloadManager.getInstance().getHippyConfig();
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public File getTabConfigFile(String str, String str2) {
        return HippyTabConfigManager.getTabFile(str, str2);
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public boolean isGameCenterPreloadByTab() {
        HippyConfig hippyConfig = HippyPredownloadManager.getInstance().getHippyConfig();
        if (!hippyConfig.isGameCenterPreloadHippy() && !hippyConfig.isGameCenterPredrawHippy()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public void removeJsBundleUpdateListener(String str, IUpdateListener iUpdateListener) {
        HippyUpdateManager.getInstance().removeJsBundleUpdateListener(str, iUpdateListener);
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public void reportHippy(JSONObject jSONObject) {
        HippyUnissoHandler hippyUnissoHandler = HippyUnissoHandler.getInstance();
        if (hippyUnissoHandler != null) {
            hippyUnissoHandler.reportHippy(jSONObject);
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public void requestHippyConfig(int i3) {
        HippyPredownloadManager.getInstance().requestHippyConfig(i3);
        if (i3 == 1) {
            ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).fetchEncryptedUinFromSvrV2();
            ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).startTimer();
            ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).updateWidgetData(1);
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyUpdate
    public void updateJsBundle(String str, boolean z16, int i3, Bundle bundle, IUpdateListener iUpdateListener) {
        HippyUpdateManager.getInstance().updateJsBundle(str, z16, i3, bundle, iUpdateListener);
    }
}
