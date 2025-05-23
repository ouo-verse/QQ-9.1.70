package com.tencent.mobileqq.mini.tissue;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TissueWnsConfig {
    public static final String LOG_TAG = "TissueWnsConfig";

    public static BaseLibInfo getBaseLibInfo() {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_TISSUE_BASELIB_URL, QzoneConfig.DEFAULT_TISSUE_BASELIB_URL);
        QLog.i(LOG_TAG, 1, "getBaseLibInfo " + config);
        if (TextUtils.isEmpty(config)) {
            return null;
        }
        try {
            return BaseLibInfo.fromJSON(new JSONObject(config));
        } catch (Exception e16) {
            QLog.e(LOG_TAG, 1, "getWnsGameBaseLibInfo failed", e16);
            return null;
        }
    }

    public static BaseLibInfo getQFlutterSoInfo() {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_QFLUTTER_URL, QzoneConfig.DEFAULT_QFLUTTER_URL);
        QLog.i(LOG_TAG, 1, "getQFlutterSoInfo " + config);
        if (TextUtils.isEmpty(config)) {
            return null;
        }
        try {
            return BaseLibInfo.fromJSON(new JSONObject(config));
        } catch (Exception e16) {
            QLog.e(LOG_TAG, 1, "getWnsQFlutterSoUrl failed", e16);
            return null;
        }
    }
}
