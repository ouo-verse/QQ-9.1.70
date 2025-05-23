package com.tencent.hippy.qq.interpolators;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GameCenterInterpolator extends HippyInterpolator {
    public static final String PRELOAD_TAG = "__ssr-bundle__";
    private static final String TAG = "GameCenterInterpolator";

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public String getSsrBundleUrl(OpenHippyInfo openHippyInfo, HippyQQPreloadEngine hippyQQPreloadEngine) {
        String ssrBundleUrl = super.getSsrBundleUrl(openHippyInfo, hippyQQPreloadEngine);
        if (openHippyInfo != null && TabPreloadItem.TAB_NAME_DYNAMIC.equals(openHippyInfo.from) && hippyQQPreloadEngine != null && !TextUtils.isEmpty(ssrBundleUrl)) {
            if (hippyQQPreloadEngine.isPredraw()) {
                ssrBundleUrl = "";
            }
            QLog.i(TAG, 2, "[getSsrBundleUrl] " + ssrBundleUrl + ",isPreDraw:" + hippyQQPreloadEngine.isPredraw());
        }
        return ssrBundleUrl;
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public String getUrl(OpenHippyInfo openHippyInfo, HippyQQPreloadEngine hippyQQPreloadEngine) {
        String url = super.getUrl(openHippyInfo, hippyQQPreloadEngine);
        if (openHippyInfo != null && TabPreloadItem.TAB_NAME_DYNAMIC.equals(openHippyInfo.from) && hippyQQPreloadEngine != null && !TextUtils.isEmpty(url)) {
            if (!hippyQQPreloadEngine.isPredraw() && hippyQQPreloadEngine.isPreloaded()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(url);
                String str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                if (url.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str = ContainerUtils.FIELD_DELIMITER;
                }
                sb5.append(str);
                sb5.append(PRELOAD_TAG);
                url = sb5.toString();
            }
            QLog.i(TAG, 2, "[getUrl] " + url + ",isPreloaded:" + hippyQQPreloadEngine.isPreloaded() + ",isPreDraw:" + hippyQQPreloadEngine.isPredraw());
        }
        return url;
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean hasNewMessage() {
        AppInterface appInterface;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        if (MobileQQ.sProcessId != 1 || (appInterface = HippyUtils.getAppInterface()) == null || (appInfoByPath = ((IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID)) == null || !appInfoByPath.iNewFlag.has() || appInfoByPath.iNewFlag.get() != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).isGameCenterPreloadByTab();
    }
}
