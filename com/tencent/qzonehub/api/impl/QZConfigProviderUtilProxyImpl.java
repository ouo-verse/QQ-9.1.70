package com.tencent.qzonehub.api.impl;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZConfigProviderUtilProxy;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* loaded from: classes34.dex */
public class QZConfigProviderUtilProxyImpl implements IQZConfigProviderUtilProxy {
    private static final String TAG = "QZConfigProviderUtil";
    private static final Set<String> miniAppHighPrioritySecondaryKeys;
    private static final Set<String> qqcircleHighPrioritySecondaryKeys;

    static {
        HashSet hashSet = new HashSet();
        miniAppHighPrioritySecondaryKeys = hashSet;
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_SHOW_RED_DOT.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_SHOW_MSG_RED_DOT.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION_RED_DOT.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_TRIGGER_FULL_SCREEN_HEIGHT.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_GET_PSKEY_DOMAIN.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_SYSTEM_PERMISSION_CONFIG.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_MINI_APP_MSF_TIMEOUT_VALUE.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_USE_HTTPS_SEND_REQUEST.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_MINI_GAME_NEWSDK_ENABLE.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_ECSHOP_NUM_MSG_ENABLE.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_MINI_APP_NEWSDK_ENABLE.toLowerCase());
        hashSet.add(QzoneConfig.MINI_SDK_PRELAUNCH_ENABLE.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_MINI_APP_DEX_CONFIG.toLowerCase());
        hashSet.add(QzoneConfig.MINI_SDK_PRELAUNCH_ALL_ENABLE.toLowerCase());
        hashSet.add(QzoneConfig.MINI_SDK_PRELAUNCH_ALL_DELAY_TIME.toLowerCase());
        hashSet.add(QzoneConfig.SECONDARY_KEY_MINI_APP_TRIGGER_REFRESH_MIN_DISTANCE.toLowerCase());
        hashSet.add(QzoneConfig.MINI_APP_ARK_SCENE_WHITE_LIST.toLowerCase());
        qqcircleHighPrioritySecondaryKeys = new HashSet();
    }

    private static void deleteConfig() {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, null, null);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "deleteConfig error" + e16.getMessage(), e16);
            }
        }
    }

    private static void deleteCookie() {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.w3, null, null);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "deleteCookie error " + e16.getMessage(), e16);
            }
        }
    }

    private static void deleteIspCheckTime() {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.C3, null, null);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "deleteIspCheckTime error" + e16.getMessage(), e16);
            }
        }
    }

    private static void deleteIspConfig() {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.B3, null, null);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "deleteIspConfig error " + e16.getMessage(), e16);
            }
        }
    }

    private static boolean insertNavigatorConfigItem(ContentValues[] contentValuesArr) {
        try {
            BaseApplication.getContext().getContentResolver().bulkInsert(com.tencent.common.config.provider.d.D3, contentValuesArr);
            return true;
        } catch (SQLException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "insertNavigatorConfigItem error:" + e16.getMessage(), e16);
            }
            return false;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "insertNavigatorConfigItem error:" + e17.getMessage(), e17);
            }
            return false;
        }
    }

    private static boolean insertUpdateIspConfigItem(String str, String str2) {
        if (str == null || TextUtils.getTrimmedLength(str) <= 0 || str2 == null || TextUtils.getTrimmedLength(str2) <= 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("value", str2);
        try {
            try {
                BaseApplication.getContext().getContentResolver().insert(com.tencent.common.config.provider.d.B3, contentValues);
                contentValues.clear();
                return true;
            } catch (SQLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "insertUpdateIspConfigItem error:" + e16.getMessage(), e16);
                }
                contentValues.clear();
                return false;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "insertUpdateIspConfigItem error:" + e17.getMessage(), e17);
                }
                contentValues.clear();
                return false;
            }
        } catch (Throwable th5) {
            contentValues.clear();
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isConfigValid(String str) {
        int i3;
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, new String[]{"count(*)"}, "main_key=? ", new String[]{str}, null);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "isConfigValid " + str + " error:" + e16.getMessage(), e16);
                }
                if (cursor != null) {
                    cursor.close();
                }
                i3 = 0;
            }
            if (cursor != null && cursor.getCount() != 0) {
                cursor.moveToFirst();
                i3 = cursor.getInt(0);
                if (cursor != null) {
                    cursor.close();
                }
                return i3 <= 0;
            }
            i3 = 0;
            if (cursor != null) {
            }
            if (i3 <= 0) {
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    private boolean saveConfig(Map<String, byte[]> map, String str) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        Set<String> keySet = map.keySet();
        QZLog.i(TAG, 1, "saveConfig mainkey count:", Integer.valueOf(keySet.size()));
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            try {
                String next = it.next();
                byte[] bArr = map.get(next);
                if (next != null && bArr != null && bArr.length > 0) {
                    QZLog.i(TAG, 1, "saveConfig mainKey:", next);
                    QzoneConfig.getInstance().deleteConfigs(next);
                    UniAttribute uniAttribute = new UniAttribute();
                    uniAttribute.setEncodeName("utf-8");
                    uniAttribute.decode(bArr);
                    for (String str2 : uniAttribute.getKeySet()) {
                        String str3 = (String) uniAttribute.get(str2);
                        if (str2 != null) {
                            next = next.toLowerCase();
                            String lowerCase = str2.toLowerCase();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("main_key", next);
                            contentValues.put("second_key", lowerCase);
                            contentValues.put("value", str3);
                            QzoneConfig.getInstance().updateOneConfig(next, lowerCase, str3, false);
                            arrayList.add(contentValues);
                            saveMiniAppConfig(next, lowerCase, str3);
                            saveHighPriorityConfig(next, lowerCase, str3);
                        }
                    }
                    try {
                        py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, "main_key=?", new String[]{next});
                        if (QLog.isColorLevel()) {
                            QZLog.i(TAG, 4, "deleteConfig: ", next);
                        }
                    } catch (Exception e16) {
                        QZLog.e(TAG, 1, e16, "deleteConfig error:");
                    }
                }
            } finally {
                arrayList.clear();
            }
        }
        try {
            BaseApplication.getContext().getContentResolver().bulkInsert(com.tencent.common.config.provider.d.v3, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
            return true;
        } catch (SQLException e17) {
            QZLog.e(TAG, 1, e17, "saveConfig error:");
            return false;
        } catch (Exception e18) {
            QZLog.e(TAG, 1, e18, "saveConfig error:");
            return false;
        }
    }

    private static void saveMiniAppConfig(String str, String str2, String str3) {
        if ("qqminiapp".equals(str) && "miniappshowfullscreen".equals(str2)) {
            try {
                int intValue = Integer.valueOf(str3).intValue();
                SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
                String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                sharedPreferences.edit().putInt(account + "_miniappshowfullscreen", intValue).apply();
                QZLog.d(TAG, 1, "[saveConfig miniapp], full screen config, key: " + str2 + ", value: " + str3 + ", uin = " + account);
                return;
            } catch (Exception unused) {
                QZLog.e(TAG, 1, "[saveConfig miniapp], full screen config exception. key: " + str2 + ", value: " + str3);
                return;
            }
        }
        if ("qqminiapp".equals(str) && QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_SETTING.equals(str2)) {
            try {
                int intValue2 = Integer.valueOf(str3).intValue();
                SharedPreferences sharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
                String account2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                sharedPreferences2.edit().putInt(account2 + "_" + QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_SETTING, intValue2).apply();
                QZLog.d(TAG, 1, "[saveConfig miniapp], setting config, key: " + str2 + ", value: " + str3 + ", uin = " + account2);
                return;
            } catch (Exception unused2) {
                QZLog.e(TAG, 1, "[saveConfig miniapp], setting config exception. key: " + str2 + ", value: " + str3);
                return;
            }
        }
        if ("qqminiapp".equals(str) && QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_CLOSE.equals(str2)) {
            try {
                int intValue3 = Integer.valueOf(str3).intValue();
                SharedPreferences sharedPreferences3 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
                String account3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                sharedPreferences3.edit().putInt(account3 + "_" + QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_CLOSE, intValue3).apply();
                QZLog.d(TAG, 1, "[saveConfig miniapp], close config, key: " + str2 + ", value: " + str3 + ", uin = " + account3);
                return;
            } catch (Exception unused3) {
                QZLog.e(TAG, 1, "[saveConfig miniapp], close config exception. key: " + str2 + ", value: " + str3);
                return;
            }
        }
        if ("qqminiapp".equals(str) && QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SEARCH.equals(str2)) {
            try {
                int intValue4 = Integer.valueOf(str3).intValue();
                SharedPreferences sharedPreferences4 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
                String account4 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                sharedPreferences4.edit().putInt(account4 + "_" + QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SEARCH, intValue4).apply();
                QZLog.d(TAG, 1, "[saveConfig miniapp], search config, key: " + str2 + ", value: " + str3 + ", uin = " + account4);
                return;
            } catch (Exception unused4) {
                QZLog.e(TAG, 1, "[saveConfig miniapp], search config exception. key: " + str2 + ", value: " + str3);
                return;
            }
        }
        if ("qqminiapp".equals(str) && QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_TITLE.equals(str2)) {
            try {
                SharedPreferences sharedPreferences5 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
                String account5 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                sharedPreferences5.edit().putString(account5 + "_" + QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_TITLE, str3).apply();
                QZLog.d(TAG, 1, "saveConfig miniapp, search config, key: " + str2 + ", value: " + str3 + ", uin = " + account5);
                return;
            } catch (Exception unused5) {
                QZLog.e(TAG, 1, "saveConfig miniapp, search config exception. key: " + str2 + ", value: " + str3);
                return;
            }
        }
        if ("qqminiapp".equals(str) && miniAppHighPrioritySecondaryKeys.contains(str2)) {
            try {
                SharedPreferences sharedPreferences6 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
                String account6 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                sharedPreferences6.edit().putString(account6 + "_" + str2, str3).apply();
                QZLog.d(TAG, 1, "saveConfig miniapp high priority config, key: " + str2 + ", value: " + str3 + ", uin = " + account6);
                if (QzoneConfig.SECONDARY_MINI_APP_DEX_CONFIG.equals(str2)) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).onDexConfigUpdate(str3);
                }
            } catch (Exception unused6) {
                QZLog.e(TAG, 1, "saveConfig miniapp high priority config exception. key: " + str2 + ", value: " + str3);
            }
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public void cleanAll() {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.A3, null, null);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "database clear error" + e16.getMessage(), e16);
            }
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public ContentValues convertNavigatorConfig(String str, entrance_cfg entrance_cfgVar) {
        int i3;
        if (!TextUtils.isEmpty(str) && entrance_cfgVar != null && (i3 = entrance_cfgVar.iEntranceId) >= 0 && i3 <= 999) {
            String replace = str.replace(" ", "");
            QZLog.e(TAG, 2, "********* insertNavigatorConfigItem ******** rsp return navigator item id:", Integer.valueOf(entrance_cfgVar.iEntranceId), " item name: ", entrance_cfgVar.sEntranceName, " item icon: ", entrance_cfgVar.sEntranceIcon, " item action: ", entrance_cfgVar.sEntranceAction, " item qbossicon: ", entrance_cfgVar.sQbossEntranceIcon);
            if (!TextUtils.isEmpty(replace) && !TextUtils.isEmpty(entrance_cfgVar.sEntranceName)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("uin", replace + ContainerUtils.FIELD_DELIMITER + entrance_cfgVar.iEntranceId);
                contentValues.put("entraceid", Integer.valueOf(entrance_cfgVar.iEntranceId));
                contentValues.put("entracename", entrance_cfgVar.sEntranceName);
                contentValues.put("entraceicon", entrance_cfgVar.sEntranceIcon);
                contentValues.put("entraceaction", entrance_cfgVar.sEntranceAction);
                contentValues.put("isDefault", Integer.valueOf(entrance_cfgVar.isDefualt));
                contentValues.put("tabid", Integer.valueOf(entrance_cfgVar.tabid));
                contentValues.put("qbossentraceicon", entrance_cfgVar.sQbossEntranceIcon);
                contentValues.put("qbosstraceinfo", entrance_cfgVar.sQbossTraceInfo);
                contentValues.put("iscannotshowteenagermode", Integer.valueOf(entrance_cfgVar.isCanNotShowOnTeenagerMod));
                return contentValues;
            }
        }
        return null;
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public void deleteLastUpdateLog() {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.f99596z3, null, null);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "deleteLastUpdateLog error " + e16.getMessage(), e16);
            }
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public String getHighPriorityConfig(String str, String str2, String str3) {
        String str4 = null;
        try {
            str4 = getHighPriorityConfigSharedPreferences().getString(getHighPriorityConfigSPKey(str, str2), str3);
            if (str4 != null) {
                str4 = str4.trim();
            }
            QZLog.d(TAG, 1, "getHighPriorityConfig. , secondKey: " + str2 + ", result: " + str4);
        } catch (Exception e16) {
            QZLog.e(TAG, 1, "getHighPriorityConfig exception. secondKey: " + str2, e16);
        }
        return str4;
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public String getHighPriorityConfigSPKey(String str, String str2) {
        return BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + str + str2;
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public SharedPreferences getHighPriorityConfigSharedPreferences() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        if (r1 != null) goto L9;
     */
    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getLastUpdate() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.f99596z3, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    str = cursor.getString(cursor.getColumnIndex("updatelog"));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getLastUpdate error" + e16.getMessage(), e16);
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public boolean loadAllConfigs(Map<String, ConcurrentHashMap<String, String>> map) throws Exception {
        boolean z16;
        Cursor cursor = null;
        try {
            try {
                map.clear();
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string != null && string2 != null) {
                            String string3 = cursor.getString(2);
                            ConcurrentHashMap<String, String> concurrentHashMap = map.get(string);
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap<>();
                                map.put(string, concurrentHashMap);
                            }
                            concurrentHashMap.put(string2, string3);
                        }
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, e16, "loadAllConfigs error:");
                        }
                    }
                }
                return z16;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e17, "loadAllConfigs error:");
                }
                if (cursor == null) {
                    return false;
                }
                try {
                    cursor.close();
                    return false;
                } catch (Exception e18) {
                    if (!QLog.isColorLevel()) {
                        return false;
                    }
                    QLog.e(TAG, 2, e18, "loadAllConfigs error:");
                    return false;
                }
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e19, "loadAllConfigs error:");
                    }
                }
            }
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (r3.moveToFirst() != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        r1.put(new java.lang.String(r3.getString(r3.getColumnIndex("key")).getBytes(), "utf-8"), new java.lang.String(r3.getString(r3.getColumnIndex("value")).getBytes(), "utf-8"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
    
        if (r3.moveToNext() != false) goto L35;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x008b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:26:0x008b */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> loadIspConfigs() {
        Cursor cursor;
        Cursor cursor2;
        HashMap hashMap = new HashMap();
        Cursor cursor3 = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.B3, null, null, null, null);
                if (cursor != null) {
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "loadConfig error:" + e.getMessage(), e);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            } catch (Exception e17) {
                e = e17;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            cursor3 = cursor2;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public boolean recUpdateSource(String str) {
        if (str == null || TextUtils.getTrimmedLength(str) <= 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("updatelog", str);
        try {
            BaseApplication.getContext().getContentResolver().insert(com.tencent.common.config.provider.d.f99596z3, contentValues);
            return true;
        } catch (SQLException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "recUpdateSource error:" + e16.getMessage(), e16);
            }
            return false;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "recUpdateSource error:" + e17.getMessage(), e17);
            }
            return false;
        } finally {
            contentValues.clear();
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public void saveConfigCookie(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cookie", str == null ? "" : str);
        QLog.i("ConfigProvider", 1, "saveConfigCookie cookie" + str);
        try {
            Uri insert = BaseApplication.getContext().getContentResolver().insert(com.tencent.common.config.provider.d.w3, contentValues);
            if (insert != null) {
                QLog.i(TAG, 1, insert.toString() + " saveConfigCookie done.");
            } else {
                QLog.e(TAG, 1, "saveConfigCookie error!");
            }
        } catch (SQLException e16) {
            QLog.e(TAG, 1, "saveConfigCookie error:" + e16.getMessage(), e16);
        } catch (Exception e17) {
            QLog.e(TAG, 1, "saveConfigCookie error:" + e17.getMessage(), e17);
        }
        contentValues.clear();
    }

    public void saveHighPriorityConfig(String str, String str2, String str3) {
        if ("qqcircle".equals(str)) {
            try {
                if (qqcircleHighPrioritySecondaryKeys.contains(str2)) {
                    getHighPriorityConfigSharedPreferences().edit().putString(getHighPriorityConfigSPKey(str, str2), str3).apply();
                    QZLog.d(TAG, 1, "saveHighPriorityConfig.  secondKey: " + str2 + ", value: " + str3);
                }
            } catch (Exception e16) {
                QZLog.e(TAG, 1, "saveHighPriorityConfig. exception. secondKey: " + str2 + ", value: " + str3, e16);
            }
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public void saveIspCheckTime(long j3) {
        if (j3 <= 0) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("check_time", Long.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveIspCheckTime time:" + j3);
        }
        try {
            BaseApplication.getContext().getContentResolver().insert(com.tencent.common.config.provider.d.C3, contentValues);
        } catch (SQLException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "saveIspCheckTime error :" + e16.getMessage(), e16);
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "saveIspCheckTime error :" + e17.getMessage(), e17);
            }
        }
        contentValues.clear();
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public void updateConfigAndCookie(Map<String, byte[]> map, String str, String str2, AppRuntime appRuntime) {
        boolean saveConfig = saveConfig(map, str2);
        if (!isConfigValid("PhotoUpload") || !isConfigValid("PhotoSvrList")) {
            saveConfigCookie("");
        } else if (saveConfig) {
            saveConfigCookie(str);
        }
        recUpdateSource(str2);
        if (appRuntime != null) {
            try {
                if (!(appRuntime instanceof QQAppInterface) || appRuntime.getLongAccountUin() == 0) {
                    return;
                }
                String config = QzoneConfig.getInstance().getConfig("QZoneSetting", "Qzone_clearCacheVersion", "");
                if (TextUtils.isEmpty(config) || LocalMultiProcConfig.getString4Uin("Qzone_clearCacheVersion", "", appRuntime.getLongAccountUin()).equals(config)) {
                    return;
                }
                QZoneHelper.clearCache(appRuntime, true);
                LocalMultiProcConfig.putString4Uin("Qzone_clearCacheVersion", config, appRuntime.getLongAccountUin());
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.getMessage());
            }
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public String getConfigCookie() {
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.w3, null, null, null, null);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getConfigCookie cookie" + e16.getMessage(), e16);
                }
                if (cursor == null) {
                    return "";
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                String str = new String(cursor.getString(cursor.getColumnIndex("cookie")).getBytes(), "utf-8");
                cursor.close();
                return str;
            }
            if (cursor == null) {
                return "";
            }
            cursor.close();
            return "";
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public long getLastCheckTime() {
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.C3, null, null, null, null);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getLastCheckTime:" + e16.getMessage(), e16);
                }
                if (cursor == null) {
                    return 0L;
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                long j3 = cursor.getLong(cursor.getColumnIndex("check_time"));
                cursor.close();
                return j3;
            }
            if (cursor == null) {
                return 0L;
            }
            cursor.close();
            return 0L;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    private static int deleteOneIspConfig(String str) {
        if (str != null && TextUtils.getTrimmedLength(str) > 0) {
            try {
                return py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.B3, "key=?", new String[]{str});
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "deleteOneIspConfig error:" + e16.getMessage());
                }
            }
        }
        return 0;
    }

    private static int deleteOneMainConfig(String str, String str2) {
        if (str != null && TextUtils.getTrimmedLength(str) > 0 && str2 != null && TextUtils.getTrimmedLength(str2) > 0) {
            try {
                return py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, "main_key=? and second_key=? ", new String[]{str, str2});
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, "deleteOneConfig error:");
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0049, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x007a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        if (r9 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0047, code lost:
    
        if (r9 != null) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getOneIspConfig(String str) {
        Throwable th5;
        Cursor cursor;
        String str2 = null;
        if (str == 0 || TextUtils.getTrimmedLength(str) <= 0) {
            return null;
        }
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.B3, null, "key=?", new String[]{str}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = new String(cursor.getString(cursor.getColumnIndex("value")).getBytes(), "utf-8");
                        }
                    } catch (Exception e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "getOneIspConfig error:" + e.getMessage(), e);
                        }
                    }
                }
            } catch (Exception e17) {
                e = e17;
                cursor = null;
            } catch (Throwable th6) {
                th5 = th6;
                str = 0;
                if (str != 0) {
                }
                throw th5;
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (str != 0) {
                str.close();
            }
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getOneConfig(String str, String str2) {
        Cursor cursor;
        String str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        Cursor cursor2 = null;
        if (str == null || TextUtils.getTrimmedLength(str) <= 0 || str2 == null || TextUtils.getTrimmedLength(str2) <= 0) {
            return null;
        }
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.v3, null, "main_key=? and second_key=?", new String[]{str, str2}, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                str3 = cursor.getString(cursor.getColumnIndex("value"));
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, e, "getOneConfig error:");
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return str3;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            } catch (Throwable th6) {
                th = th6;
                if (cursor2 != null) {
                }
                throw th;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e19) {
            e19.printStackTrace();
        }
        return str3;
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public void saveIspConfig(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            insertUpdateIspConfigItem(str, map.get(str));
        }
    }

    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    public void saveNavigatorBar(String str, ArrayList<entrance_cfg> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<entrance_cfg> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentValues convertNavigatorConfig = convertNavigatorConfig(str, it.next());
            if (convertNavigatorConfig != null) {
                arrayList2.add(convertNavigatorConfig);
            }
        }
        insertNavigatorConfigItem((ContentValues[]) arrayList2.toArray(new ContentValues[0]));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static entrance_cfg getOneNavigatorConfig(String str, int i3) {
        Cursor cursor;
        entrance_cfg entrance_cfgVar = null;
        entrance_cfgVar = null;
        entrance_cfgVar = null;
        entrance_cfgVar = null;
        entrance_cfgVar = null;
        Cursor cursor2 = null;
        if (str == null || TextUtils.getTrimmedLength(str) <= 0 || i3 < 0 || i3 > 999) {
            return null;
        }
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.D3, null, "uin=?", new String[]{str.replace(" ", "") + ContainerUtils.FIELD_DELIMITER + String.valueOf(i3)}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            entrance_cfgVar = new entrance_cfg(cursor.getInt(cursor.getColumnIndex("entraceid")), new String(cursor.getString(cursor.getColumnIndex("entracename")).getBytes(), "utf-8"), new String(cursor.getString(cursor.getColumnIndex("entraceicon")).getBytes(), "utf-8"), new String(cursor.getString(cursor.getColumnIndex("entraceaction")).getBytes(), "utf-8"), cursor.getInt(cursor.getColumnIndex("isDefault")), cursor.getInt(cursor.getColumnIndex("tabid")), new String(cursor.getString(cursor.getColumnIndex("qbossentraceicon")).getBytes(), "utf-8"), new String(cursor.getString(cursor.getColumnIndex("qbosstraceinfo")).getBytes(), "utf-8"), 0, null, cursor.getInt(cursor.getColumnIndex("iscannotshowteenagermode")), 0);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "getOneNavigatorConfig error:" + e.getMessage());
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return entrance_cfgVar;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                Throwable th6 = th;
                if (cursor2 == null) {
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return entrance_cfgVar;
        } catch (Throwable th7) {
            th = th7;
            cursor2 = null;
            Throwable th62 = th;
            if (cursor2 == null) {
                try {
                    cursor2.close();
                    throw th62;
                } catch (Exception e19) {
                    e19.printStackTrace();
                    throw th62;
                }
            }
            throw th62;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
    
        if (r4.moveToFirst() != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        r20.add(new NS_UNDEAL_COUNT.entrance_cfg(r4.getInt(r4.getColumnIndex("entraceid")), new java.lang.String(r4.getString(r4.getColumnIndex("entracename")).getBytes(), "utf-8"), new java.lang.String(r4.getString(r4.getColumnIndex("entraceicon")).getBytes(), "utf-8"), new java.lang.String(r4.getString(r4.getColumnIndex("entraceaction")).getBytes(), "utf-8"), r4.getInt(r4.getColumnIndex("isDefault")), r4.getInt(r4.getColumnIndex("tabid")), new java.lang.String(r4.getString(r4.getColumnIndex("qbossentraceicon")).getBytes(), "utf-8"), new java.lang.String(r4.getString(r4.getColumnIndex("qbosstraceinfo")).getBytes(), "utf-8"), 0, null, r4.getInt(r4.getColumnIndex("iscannotshowteenagermode")), 0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00f5, code lost:
    
        if (r4.moveToNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0126, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0123, code lost:
    
        if (r4 != null) goto L17;
     */
    @Override // com.tencent.qzonehub.api.IQZConfigProviderUtilProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean getNavigatorConfigs(String str, ArrayList<entrance_cfg> arrayList) {
        if (str == null || TextUtils.getTrimmedLength(str) <= 0 || arrayList == null) {
            return false;
        }
        arrayList.clear();
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.D3, null, "uin like '%" + str.replace(" ", "") + "&%'", null, null);
                if (cursor != null) {
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getNavigatorConfigs error:" + e16.getMessage(), e16);
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
