package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppReportShareUtil {
    public static final int DEST_TYPE_C2C = 0;
    public static final int DEST_TYPE_GROUP = 2;
    public static final int DEST_TYPE_TROOP = 1;
    public static final int SHARE_SCENE_DETAIL = 0;
    public static final int SHARE_SCENE_FIRST_PAGE = 1;
    public static final int SHARE_SCENE_OTHER_PAGE = 2;
    public static final int SHARE_TYPE_ARK = 0;
    public static final int SHARE_TYPE_ARK_TEMPLATE = 2;
    public static final int SHARE_TYPE_QZONE = 1;
    public static final int SHARE_TYPE_WECHAT = 3;
    public static final int SHARE_TYPE_WECHAT_ZONE = 4;
    private static final String TAG = "MiniAppReportShareUtil";
    private static MiniAppReportShareUtil mInstance;

    MiniAppReportShareUtil() {
    }

    public static MiniAppReportShareUtil getInstance() {
        if (mInstance == null) {
            mInstance = new MiniAppReportShareUtil();
        }
        return mInstance;
    }

    public void reportShare(final String str, final int i3, int i16, int i17, final int i18, final String str2) {
        int i19;
        final long currentTimeMillis = System.currentTimeMillis();
        if (i16 == 10) {
            i19 = 0;
        } else {
            i19 = 1;
        }
        final int i26 = i19;
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportShare(null, currentTimeMillis, str, i3, i26, 0, i18, str2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.utils.MiniAppReportShareUtil.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                QMLog.d(MiniAppReportShareUtil.TAG, "report share success: " + z16 + "  reportTime:" + currentTimeMillis + "  appid:" + str + "  appType:" + i3 + "  shareScene:" + i26 + "  shareType:0  destType:" + i18 + "  destId:" + str2);
            }
        });
    }
}
