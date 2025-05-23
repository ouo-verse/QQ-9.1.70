package com.tencent.mobileqq.search.base.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.util.y;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchConfigManager extends SearchConfig {
    public static String configSwitch = null;
    public static String curUin = "";

    private static void c() {
        StringBuilder sb5 = new StringBuilder("checkBaseBits ");
        int i3 = SearchConfig.contactSearchPinyinBaseBit;
        if (i3 <= 0 || i3 >= 64) {
            sb5.append(",contactSearchPinyinBaseBit invalid=");
            sb5.append(SearchConfig.contactSearchPinyinBaseBit);
            SearchConfig.contactSearchPinyinBaseBit = 58;
        }
        int i16 = SearchConfig.contactSearchRecentBaseBit;
        if (i16 <= 0 || i16 >= 64) {
            sb5.append(",contactSearchRecentBaseBit invalid=");
            sb5.append(SearchConfig.contactSearchRecentBaseBit);
            SearchConfig.contactSearchRecentBaseBit = 48;
        }
        int i17 = SearchConfig.contactSearchIndexBaseBit;
        if (i17 <= 0 || i17 >= 64) {
            sb5.append(",contactSearchIndexBaseBit invalid=");
            sb5.append(SearchConfig.contactSearchIndexBaseBit);
            SearchConfig.contactSearchIndexBaseBit = 40;
        }
        int i18 = SearchConfig.contactSearchTypeBaseBit;
        if (i18 <= 0 || i18 >= 64) {
            sb5.append(",contactSearchTypeBaseBit invalid=");
            sb5.append(SearchConfig.contactSearchTypeBaseBit);
            SearchConfig.contactSearchTypeBaseBit = 32;
        }
        int i19 = SearchConfig.contactSearchFieldBaseBit;
        if (i19 <= 0 || i19 >= 64) {
            sb5.append(",contactSearchFieldBaseBit invalid=");
            sb5.append(SearchConfig.contactSearchFieldBaseBit);
            SearchConfig.contactSearchFieldBaseBit = 24;
        }
        boolean z16 = false;
        int[] iArr = {SearchConfig.contactSearchPinyinBaseBit, SearchConfig.contactSearchRecentBaseBit, SearchConfig.contactSearchIndexBaseBit, SearchConfig.contactSearchTypeBaseBit, SearchConfig.contactSearchFieldBaseBit, 64};
        Arrays.sort(iArr);
        int i26 = 1;
        while (true) {
            if (i26 < 6) {
                if (iArr[i26] - iArr[i26 - 1] < 6) {
                    break;
                } else {
                    i26++;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            sb5.append(",value is invalid : interval < 6 : contactSearchPinyinBaseBit=" + SearchConfig.contactSearchPinyinBaseBit + ";contactSearchRecentBaseBit=" + SearchConfig.contactSearchRecentBaseBit + ";contactSearchIndexBaseBit=" + SearchConfig.contactSearchIndexBaseBit + ";contactSearchTypeBaseBit=" + SearchConfig.contactSearchTypeBaseBit + ";contactSearchFieldBaseBit=" + SearchConfig.contactSearchFieldBaseBit);
            SearchConfig.contactSearchPinyinBaseBit = 58;
            SearchConfig.contactSearchRecentBaseBit = 48;
            SearchConfig.contactSearchIndexBaseBit = 40;
            SearchConfig.contactSearchTypeBaseBit = 32;
            SearchConfig.contactSearchFieldBaseBit = 24;
        }
        QLog.i("search_manager_configSearchConfigManager", 1, sb5.toString());
    }

    public static synchronized void d(AppInterface appInterface) {
        synchronized (SearchConfigManager.class) {
            try {
                String currentUin = appInterface.getCurrentUin();
                if (!TextUtils.isEmpty(currentUin) && !currentUin.equals(curUin)) {
                    StringBuilder sb5 = new StringBuilder("loadSearchConfig ");
                    curUin = currentUin;
                    SearchConfig.isConfigLoaded = true;
                    SearchConfig.voiceSearchSwitch = 0;
                    SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(currentUin + "_sp_search_config", 0);
                    configSwitch = sharedPreferences.getString("configSwitch", "");
                    sb5.append(",configSwitch=");
                    sb5.append(configSwitch);
                    if (!"on".equals(configSwitch)) {
                        SearchConfig.b();
                        j.k();
                        QLog.i("search_manager_configSearchConfigManager", 1, sb5.toString());
                        return;
                    }
                    Map<String, ?> all = sharedPreferences.getAll();
                    if (all != null) {
                        for (String str : all.keySet()) {
                            try {
                                Field field = SearchConfigManager.class.getField(str);
                                String str2 = (String) all.get(str);
                                if (str2 != null) {
                                    if (field.getType() == String.class) {
                                        field.set(null, str2);
                                    } else if (field.getType() == Integer.TYPE) {
                                        field.set(null, Integer.valueOf(Integer.parseInt(str2)));
                                    } else if (field.getType() == Long.TYPE) {
                                        long parseLong = Long.parseLong(str2);
                                        if (parseLong > 0 && parseLong < 256) {
                                            field.set(null, Long.valueOf(Long.parseLong(str2)));
                                        } else {
                                            sb5.append(",value is invalid : " + str + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                                        }
                                    }
                                }
                            } catch (Error e16) {
                                QLog.i("search_manager_configSearchConfigManager", 1, "loadSearchConfig", e16);
                            } catch (IllegalAccessException e17) {
                                QLog.i("search_manager_configSearchConfigManager", 1, "loadSearchConfig", e17);
                            } catch (NoSuchFieldException e18) {
                                QLog.i("search_manager_configSearchConfigManager", 1, "loadSearchConfig", e18);
                            } catch (NumberFormatException e19) {
                                QLog.i("search_manager_configSearchConfigManager", 1, "loadSearchConfig", e19);
                            } catch (Exception e26) {
                                QLog.i("search_manager_configSearchConfigManager", 1, "loadSearchConfig", e26);
                            }
                        }
                    }
                    c();
                    if (y.b()) {
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_PEOPLE, Integer.valueOf(SearchConfig.engineOrderPeople + 100));
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_PUBLIC_ACCOUNT, Integer.valueOf(SearchConfig.engineOrderPublicAccount + 100));
                        SearchConfig.searchEngineOrder.put("file", Integer.valueOf(SearchConfig.engineOrderFile + 100));
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_NET_SEARCH, Integer.valueOf(SearchConfig.engineOrderNetSearch + 100));
                        SearchConfig.searchEngineOrder.put("function", Integer.valueOf(SearchConfig.engineOrderFunction + 100));
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_FTS_MESSAGE_NT, Integer.valueOf(SearchConfig.engineOrderMessage));
                        SearchConfig.searchEngineOrder.put("favorite", Integer.valueOf(SearchConfig.engineOrderFavorite));
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_MINIPROGRAM, 100);
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_CREATE_DISCUSSION, 100);
                    } else {
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_PEOPLE, Integer.valueOf(SearchConfig.engineOrderPeople));
                        SearchConfig.searchEngineOrder.put("message", Integer.valueOf(SearchConfig.engineOrderMessage));
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_FTS_MESSAGE_NT, Integer.valueOf(SearchConfig.engineOrderMessage));
                        SearchConfig.searchEngineOrder.put("fts_message", Integer.valueOf(SearchConfig.engineOrderMessage));
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_PUBLIC_ACCOUNT, Integer.valueOf(SearchConfig.engineOrderPublicAccount));
                        SearchConfig.searchEngineOrder.put("favorite", Integer.valueOf(SearchConfig.engineOrderFavorite));
                        SearchConfig.searchEngineOrder.put("file", Integer.valueOf(SearchConfig.engineOrderFile));
                        SearchConfig.searchEngineOrder.put(SearchConfig.ENGINE_NET_SEARCH, Integer.valueOf(SearchConfig.engineOrderNetSearch));
                        SearchConfig.searchEngineOrder.put("feature", Integer.valueOf(SearchConfig.engineOrderFeature));
                        SearchConfig.searchEngineOrder.put("function", Integer.valueOf(SearchConfig.engineOrderFunction));
                    }
                    j.k();
                    SearchConfig.troopMemberUpdateConfigs = SearchConfig.a(SearchConfig.troopMemberUpdateConfigStr);
                }
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).setGlobalSearchConfNeedSeparate();
            } catch (Error e27) {
                QLog.i("search_manager_configSearchConfigManager", 1, "loadSearchConfig", e27);
            } catch (Exception e28) {
                QLog.i("search_manager_configSearchConfigManager", 1, "loadSearchConfig", e28);
            }
        }
    }

    public static void e(String str, String str2) {
        QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getSharedPreferences(str + "_sp_search_config", 0).edit();
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("configSwitch");
            configSwitch = string;
            if (!"on".equals(string)) {
                edit.putString("configSwitch", DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                edit.commit();
                return;
            }
            if (jSONObject.has("mStructMsgPicSwitch")) {
                int i3 = jSONObject.getInt("mStructMsgPicSwitch");
                QLog.i("search_manager_configSearchConfigManager", 1, "jsonObject.has mStructMsgPicSwitch " + i3);
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).setStructMsgPicPreDelegateSwitch(i3);
            }
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                try {
                    edit.putString(str3, (String) jSONObject.get(str3));
                } catch (Error e16) {
                    QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", e16);
                } catch (JSONException e17) {
                    QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", e17);
                } catch (Exception e18) {
                    QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", e18);
                }
            }
            edit.commit();
            curUin = "";
        } catch (Error e19) {
            QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", e19);
        } catch (JSONException e26) {
            QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", e26);
        } catch (Exception e27) {
            QLog.i("search_manager_configSearchConfigManager", 1, "parseSearchConfig", e27);
        }
    }
}
