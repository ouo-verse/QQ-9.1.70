package com.tencent.hippy.qq.api;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.gamecenter.preload.IPreloadRequestManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyInterpolator {
    private final HashMap<Integer, OpenHippyInfo> mOpenHippyInfos = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnPreRequestListener {
        void onGetPreRequestData(String str);
    }

    public JSONObject getBusinessData() {
        return null;
    }

    public HashMap<String, Long> getPerformanceData() {
        return null;
    }

    public String getPreRequestData(int i3, String str) {
        OpenHippyInfo openHippyInfo = this.mOpenHippyInfos.get(Integer.valueOf(i3));
        return openHippyInfo != null ? ((IPreloadRequestManager) QRoute.api(IPreloadRequestManager.class)).getPreloadRequest(i3, openHippyInfo.bundleName, str, openHippyInfo.url) : "";
    }

    public ISSRBundleRequester getSSRBundleRequester() {
        return null;
    }

    public String getSsrBundleUrl(OpenHippyInfo openHippyInfo, HippyQQPreloadEngine hippyQQPreloadEngine) {
        if (openHippyInfo != null) {
            return openHippyInfo.ssrBundleUrl;
        }
        return "";
    }

    public String getUrl(OpenHippyInfo openHippyInfo, HippyQQPreloadEngine hippyQQPreloadEngine) {
        if (openHippyInfo != null) {
            return openHippyInfo.url;
        }
        return "";
    }

    public boolean hasNewMessage() {
        return false;
    }

    public boolean isCanPreload() {
        return true;
    }

    public void onHippyDestroy(OpenHippyInfo openHippyInfo) {
        this.mOpenHippyInfos.remove(Integer.valueOf(openHippyInfo.openId));
        ((IPreloadRequestManager) QRoute.api(IPreloadRequestManager.class)).onHippyDestroy(openHippyInfo.openId, openHippyInfo.bundleName);
    }

    public void onOpenHippyStart(OpenHippyInfo openHippyInfo) {
        this.mOpenHippyInfos.put(Integer.valueOf(openHippyInfo.openId), openHippyInfo);
        ((IPreloadRequestManager) QRoute.api(IPreloadRequestManager.class)).onOpenHippyStart(openHippyInfo.openId, openHippyInfo.bundleName, openHippyInfo.url);
    }

    public void getPreRequestData(int i3, String str, final OnPreRequestListener onPreRequestListener) {
        OpenHippyInfo openHippyInfo = this.mOpenHippyInfos.get(Integer.valueOf(i3));
        if (openHippyInfo != null) {
            ((IPreloadRequestManager) QRoute.api(IPreloadRequestManager.class)).getPreloadRequestAsync(i3, openHippyInfo.bundleName, str, openHippyInfo.url, new pd1.a() { // from class: com.tencent.hippy.qq.api.a
                @Override // pd1.a
                public final void a(int i16, String str2, String str3) {
                    HippyInterpolator.OnPreRequestListener.this.onGetPreRequestData(str3);
                }
            });
        }
    }
}
