package com.tencent.mobileqq.mini.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
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
        final long currentTimeMillis = System.currentTimeMillis();
        final int i19 = i16 == 10 ? 0 : 1;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        MiniAppCmdUtil.getInstance().reportShare(null, currentTimeMillis, str, i3, i19, 0, i18, str2, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil.1
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                QLog.d(MiniAppReportShareUtil.TAG, 1, "report share success: " + z16 + "  reportTime:" + currentTimeMillis + "  appid:" + str + "  appType:" + i3 + "  shareScene:" + i19 + "  shareType:0  destType:" + i18 + "  destId:" + str2);
            }
        });
    }
}
