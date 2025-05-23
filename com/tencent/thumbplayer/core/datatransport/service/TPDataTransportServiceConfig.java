package com.tencent.thumbplayer.core.datatransport.service;

import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportConfigUtil;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPDataTransportServiceConfig {
    private static final String CONFIG_ENABLE_MAIN_PROCESS_TEMPORARY = "tp_enable_main_process_temporary";
    private static final String CONFIG_MAX_SERVICE_DISCONNECTED_COUNT = "tp_max_service_disconnected_count";
    private static final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportServiceConfig");
    private static int mMaxServiceDisConnectedCount = -1;
    private static boolean mEnableMainProcessTemporary = false;
    private static boolean mNeedUpdateMaxServiceDisConnectedCount = true;
    private static boolean mNeedUpdateEnableMainProcessTemporary = true;

    public static boolean enableMainProcessTemporary() {
        if (mNeedUpdateEnableMainProcessTemporary) {
            mEnableMainProcessTemporary = TPDataTransportConfigUtil.getBooleanConfig(CONFIG_ENABLE_MAIN_PROCESS_TEMPORARY, mEnableMainProcessTemporary);
            mNeedUpdateEnableMainProcessTemporary = false;
        }
        return mEnableMainProcessTemporary;
    }

    public static int getMaxServiceDisconnectedCount() {
        if (mNeedUpdateMaxServiceDisConnectedCount) {
            mMaxServiceDisConnectedCount = TPDataTransportConfigUtil.getIntConfig(CONFIG_MAX_SERVICE_DISCONNECTED_COUNT, mMaxServiceDisConnectedCount);
            mNeedUpdateMaxServiceDisConnectedCount = false;
        }
        return mMaxServiceDisConnectedCount;
    }

    public static void parseNativeConfig(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int jSONIntValue = TPDLProxyUtils.getJSONIntValue(jSONObject, CONFIG_MAX_SERVICE_DISCONNECTED_COUNT, mMaxServiceDisConnectedCount);
            mMaxServiceDisConnectedCount = jSONIntValue;
            TPDataTransportConfigUtil.putIntConfig(CONFIG_MAX_SERVICE_DISCONNECTED_COUNT, jSONIntValue);
            boolean jSONBooleanValue = TPDLProxyUtils.getJSONBooleanValue(jSONObject, CONFIG_ENABLE_MAIN_PROCESS_TEMPORARY, mEnableMainProcessTemporary);
            mEnableMainProcessTemporary = jSONBooleanValue;
            TPDataTransportConfigUtil.putBooleanConfig(CONFIG_ENABLE_MAIN_PROCESS_TEMPORARY, jSONBooleanValue);
            mNeedUpdateMaxServiceDisConnectedCount = true;
            mNeedUpdateEnableMainProcessTemporary = true;
            mLogger.i("parse native config, save to sp, max service disconnected count: " + mMaxServiceDisConnectedCount + ", enable main process temporary: " + mEnableMainProcessTemporary);
        } catch (Throwable th5) {
            mLogger.e("parseNativeConfig failed, error:" + th5);
        }
    }
}
