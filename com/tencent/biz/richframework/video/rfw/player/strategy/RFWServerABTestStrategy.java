package com.tencent.biz.richframework.video.rfw.player.strategy;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import common.config.service.QzoneConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWServerABTestStrategy {
    private static volatile RFWServerABTestStrategy sInstance;
    private QzoneConfig.QzoneConfigChangeListener mConfigChangeListener;
    private String mPrePrintReportVal = "";

    RFWServerABTestStrategy() {
        init();
    }

    private void doAdd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            QQVideoPlaySDKManager.addSuperGlobalReportData(str, str2);
        } else {
            QQVideoPlaySDKManager.addSuperGlobalReportData(str, "");
        }
    }

    public static RFWServerABTestStrategy g() {
        if (sInstance == null) {
            synchronized (RFWServerABTestStrategy.class) {
                if (sInstance == null) {
                    sInstance = new RFWServerABTestStrategy();
                }
            }
        }
        return sInstance;
    }

    private void init() {
        if (this.mConfigChangeListener == null) {
            this.mConfigChangeListener = new QzoneConfig.QzoneConfigChangeListener() { // from class: com.tencent.biz.richframework.video.rfw.player.strategy.RFWServerABTestStrategy.1
                @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
                public void onConfigChange() {
                    RFWLog.d("QFSServerABTestStrategy", RFWLog.USR, "onConfigChange");
                    RFWServerABTestStrategy.this.addNameToSuperPlayer();
                }
            };
            QzoneConfig.getInstance().addListener(this.mConfigChangeListener);
            addNameToSuperPlayer();
        }
    }

    public synchronized void addNameToSuperPlayer() {
        doAdd("param_bucket3", uq3.c.o4());
        doAdd("param_bucket4", uq3.c.p4());
        doAdd("param_bucket5", uq3.c.q4());
    }

    public synchronized String addToQFSPlayerReport(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            jSONObject.put(ICustomDataEditor.STRING_PARAM_1, uq3.c.o4());
            jSONObject.put(ICustomDataEditor.STRING_PARAM_2, uq3.c.p4());
            jSONObject.put(ICustomDataEditor.STRING_PARAM_3, uq3.c.q4());
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.equals(this.mPrePrintReportVal, jSONObject2)) {
                RFWLog.d("QFSServerABTestStrategy", RFWLog.USR, "addToQFSPlayerReport reslut:" + jSONObject2);
                this.mPrePrintReportVal = jSONObject2;
            }
            return jSONObject2;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return jSONObject.toString();
        }
    }
}
