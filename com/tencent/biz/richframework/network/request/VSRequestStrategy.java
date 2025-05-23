package com.tencent.biz.richframework.network.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSRequestStrategy {
    private static final String KEY_CONFIG_ARRAY = "config_array";
    private static final String KEY_UPDATE_TIMESTAMP = "update_timestamp";
    public static final String TAG = "VSRequestStrategy";
    private volatile long mCurrentTimeStamp = 0;
    private ConcurrentHashMap<String, VSRequestStrategyBean> mConfigMap = new ConcurrentHashMap<>();

    private void initStrategyBean(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("config_array");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            VSRequestStrategyBean vSRequestStrategyBean = new VSRequestStrategyBean(jSONArray.getJSONObject(i3));
            this.mConfigMap.put(vSRequestStrategyBean.getCmd(), vSRequestStrategyBean);
        }
    }

    public boolean forbiddenCache(BaseRequest baseRequest) {
        VSRequestStrategyBean vSRequestStrategyBean;
        ConcurrentHashMap<String, VSRequestStrategyBean> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null && baseRequest != null && (vSRequestStrategyBean = concurrentHashMap.get(baseRequest.getCmdName())) != null) {
            return vSRequestStrategyBean.forbiddenCache();
        }
        return false;
    }

    public int getErrorCode(BaseRequest baseRequest) {
        VSRequestStrategyBean vSRequestStrategyBean;
        ConcurrentHashMap<String, VSRequestStrategyBean> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null && baseRequest != null && (vSRequestStrategyBean = concurrentHashMap.get(baseRequest.getCmdName())) != null) {
            return vSRequestStrategyBean.getErrorCode();
        }
        return 0;
    }

    public String getErrorMsg(BaseRequest baseRequest) {
        VSRequestStrategyBean vSRequestStrategyBean;
        ConcurrentHashMap<String, VSRequestStrategyBean> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null && baseRequest != null && (vSRequestStrategyBean = concurrentHashMap.get(baseRequest.getCmdName())) != null) {
            return vSRequestStrategyBean.getErrorMsg();
        }
        return "";
    }

    public boolean isForbiddenRequest(BaseRequest baseRequest) {
        VSRequestStrategyBean vSRequestStrategyBean;
        ConcurrentHashMap<String, VSRequestStrategyBean> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null && baseRequest != null && (vSRequestStrategyBean = concurrentHashMap.get(baseRequest.getCmdName())) != null) {
            return vSRequestStrategyBean.isForbiddenRequest();
        }
        return false;
    }

    public void updateConfigByTimeStamp(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong(KEY_UPDATE_TIMESTAMP, 0L);
            if (optLong > this.mCurrentTimeStamp) {
                this.mCurrentTimeStamp = optLong;
                initStrategyBean(jSONObject);
            }
        } catch (Exception e16) {
            RFWLog.fatal(TAG, RFWLog.USR, e16);
        }
    }
}
