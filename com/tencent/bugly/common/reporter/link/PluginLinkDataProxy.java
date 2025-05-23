package com.tencent.bugly.common.reporter.link;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q04.a;

/* loaded from: classes5.dex */
public class PluginLinkDataProxy implements PluginLinkData {
    private static final String TAG = "RMonitor_link";
    private static volatile PluginLinkDataProxy instance;
    private final HashMap<String, ArrayList<String>> config;
    private final PluginLinkData impl = new PluginLinkDataImpl();

    PluginLinkDataProxy() {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        this.config = hashMap;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("looper.looper_stack");
        hashMap.put("anr.basic_info", arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("looper.looper_stack");
        arrayList2.add("memory.activity_leak");
        arrayList2.add("memory.fd_leak");
        arrayList2.add("memory.big_bitmap");
        arrayList2.add("memory.fd_leak_ceil");
        arrayList2.add("memory.native_memory");
        arrayList2.add("memory.java_memory_ceiling_hprof");
        hashMap.put("crash.basic_info", arrayList2);
    }

    private void dump(JSONObject jSONObject, long j3) {
        String str;
        String str2;
        try {
            String pluginFullNameFromParam = ReportDataBuilder.getPluginFullNameFromParam(jSONObject, ".");
            long elapsedRealtime = SystemClock.elapsedRealtime() - j3;
            String optString = jSONObject.optString(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID);
            String processLaunchId = TraceGenerator.getProcessLaunchId();
            String optString2 = jSONObject.optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY);
            boolean equals = TextUtils.equals(optString, processLaunchId);
            Logger logger = Logger.f365497g;
            String[] strArr = new String[2];
            strArr[0] = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("try collect link data for ");
            sb5.append(pluginFullNameFromParam);
            sb5.append("[");
            sb5.append(optString2);
            sb5.append("]");
            if (equals) {
                str = " from current launch";
            } else {
                str = " from last launch";
            }
            sb5.append(str);
            sb5.append(" cost ");
            sb5.append(elapsedRealtime);
            sb5.append(" ms");
            strArr[1] = sb5.toString();
            logger.d(strArr);
            JSONArray linkage = getLinkage(jSONObject);
            String[] strArr2 = new String[2];
            strArr2[0] = TAG;
            if (linkage == null) {
                str2 = "linkages is null";
            } else {
                str2 = "linkages is " + linkage.toString();
            }
            strArr2[1] = str2;
            logger.d(strArr2);
        } catch (Throwable unused) {
        }
    }

    public static PluginLinkDataProxy getInstance() {
        if (instance == null) {
            synchronized (PluginLinkDataProxy.class) {
                if (instance == null) {
                    instance = new PluginLinkDataProxy();
                }
            }
        }
        return instance;
    }

    private JSONArray getLinkage(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(ReportDataBuilder.KEY_ATTRIBUTES);
        if (optJSONObject == null) {
            return null;
        }
        return optJSONObject.optJSONArray(ReportDataBuilder.KEY_LINKAGE);
    }

    private JSONObject makeLastExceptionData(@NotNull LinkData linkData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_BASE_TYPE, linkData.baseType);
        jSONObject.put("sub_type", linkData.subType);
        jSONObject.put(ReportDataBuilder.KEY_CLIENT_IDENTIFY, linkData.clientIdentify);
        jSONObject.put("event_time", linkData.eventTime);
        jSONObject.put(ReportDataBuilder.KEY_EVENT_TIME_IN_MS, linkData.eventTimeInMS);
        jSONObject.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, linkData.processLaunchID);
        return jSONObject;
    }

    public void collectPluginLinkData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ArrayList<String> arrayList = this.config.get(ReportDataBuilder.getPluginFullNameFromParam(jSONObject, "."));
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        long elapsedRealtime = Logger.verbos ? SystemClock.elapsedRealtime() : 0L;
        if (getLinkage(jSONObject) == null) {
            collectPluginLinkData(jSONObject, arrayList);
        }
        LinkData fromJson = LinkData.fromJson(jSONObject);
        if (fromJson != null && ("crash".equals(fromJson.baseType) || QZoneAppCtrlUploadFileLogic.ANR_LOG_DIRECTORY.equals(fromJson.baseType))) {
            saveLastExceptionDataToCache(fromJson);
        }
        if (Logger.verbos) {
            dump(jSONObject, elapsedRealtime);
        }
    }

    public JSONObject getLastExceptionDataFromCache() {
        JSONObject jSONObject = null;
        try {
            SharedPreferences b16 = a.b();
            if (b16 != null) {
                String string = b16.getString(SPKey.KEY_LAST_ANR_OR_CRASH_DATA, "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject = new JSONObject(string);
                }
            }
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, "get last exception data from cache fail for " + th5.toString());
        }
        Logger.f365497g.d(TAG, "get last exception data from cache " + jSONObject);
        return jSONObject;
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public LinkDataDBCacheMng getLinkDataDBCacheMng() {
        return this.impl.getLinkDataDBCacheMng();
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public LinkData getRecentLinkDataFromCurrentLaunch(String str, String str2, long j3) {
        try {
            return this.impl.getRecentLinkDataFromCurrentLaunch(str, str2, j3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean isInitDBCache() {
        if (this.impl.getLinkDataDBCacheMng() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public void recordPluginLinkData(JSONObject jSONObject) {
        try {
            if (Logger.verbos) {
                String pluginFullNameFromParam = ReportDataBuilder.getPluginFullNameFromParam(jSONObject, ".");
                Logger.f365497g.v(TAG, "record link data of " + pluginFullNameFromParam);
            }
            this.impl.recordPluginLinkData(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void saveLastExceptionDataToCache(LinkData linkData) {
        String str = "";
        if (linkData != null) {
            try {
                JSONObject lastExceptionDataFromCache = getLastExceptionDataFromCache();
                if (lastExceptionDataFromCache == null || linkData.eventTimeInMS > lastExceptionDataFromCache.optLong(ReportDataBuilder.KEY_EVENT_TIME_IN_MS)) {
                    lastExceptionDataFromCache = makeLastExceptionData(linkData);
                }
                str = lastExceptionDataFromCache.toString();
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, "save last exception data to cache fail for " + th5.toString());
            }
        }
        SharedPreferences.Editor a16 = a.a();
        a16.putString(SPKey.KEY_LAST_ANR_OR_CRASH_DATA, str);
        a16.commit();
        Logger.f365497g.d(TAG, "save last exception data to cache " + str);
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public void setLinkDataDBCacheMng(LinkDataDBCacheMng linkDataDBCacheMng) {
        this.impl.setLinkDataDBCacheMng(linkDataDBCacheMng);
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public void collectPluginLinkData(JSONObject jSONObject, List<String> list) {
        try {
            this.impl.collectPluginLinkData(jSONObject, list);
        } catch (Throwable unused) {
        }
    }
}
