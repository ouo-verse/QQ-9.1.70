package com.tencent.qzonehub.api;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentValues;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZConfigProviderUtilProxy extends QRouteApi {
    void cleanAll();

    ContentValues convertNavigatorConfig(String str, entrance_cfg entrance_cfgVar);

    void deleteLastUpdateLog();

    String getConfigCookie();

    String getHighPriorityConfig(String str, String str2, String str3);

    String getHighPriorityConfigSPKey(String str, String str2);

    SharedPreferences getHighPriorityConfigSharedPreferences();

    long getLastCheckTime();

    String getLastUpdate();

    boolean getNavigatorConfigs(String str, ArrayList<entrance_cfg> arrayList);

    String getOneConfig(String str, String str2);

    boolean loadAllConfigs(Map<String, ConcurrentHashMap<String, String>> map) throws Exception;

    Map<String, String> loadIspConfigs();

    boolean recUpdateSource(String str);

    void saveConfigCookie(String str);

    void saveIspCheckTime(long j3);

    void saveIspConfig(Map<String, String> map);

    void saveNavigatorBar(String str, ArrayList<entrance_cfg> arrayList);

    void updateConfigAndCookie(Map<String, byte[]> map, String str, String str2, AppRuntime appRuntime);
}
