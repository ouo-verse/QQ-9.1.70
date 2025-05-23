package cooperation.ilive.manager;

import MQQ.QqLiveMsg;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import m05.a;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class IliveDbManager {
    private static final String PREFS_KEY_HAS_MIGRATE = "prefs_key_has_migrate";
    private static final String TAG = "IliveFileDbManager";

    private static SharedPreferences createVasMmkvSharedPreferences(String str) {
        return QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, str, QMMKVFile.FILE_QQLIVE);
    }

    public static String getCurrentUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "getCurrentUin = " + peekAppRuntime.getAccount());
            }
            return peekAppRuntime.getAccount();
        }
        return null;
    }

    public static String getILiveEnterInfo(int i3) {
        String str;
        migrateToMmkvIfNeed(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        SharedPreferences createVasMmkvSharedPreferences = createVasMmkvSharedPreferences(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        if (i3 != 1) {
            if (i3 != 2) {
                str = "";
            } else {
                str = ILiveDbManagerApi.KEY_SHOP_PIC_URL;
            }
        } else {
            str = ILiveDbManagerApi.KEY_SHOP_TITLE;
        }
        String string = createVasMmkvSharedPreferences.getString(str, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "get sp key:" + str + " value = " + string);
        }
        return string;
    }

    public static String getIliveDrawerData(String str) {
        migrateToMmkvIfNeed(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        SharedPreferences createVasMmkvSharedPreferences = createVasMmkvSharedPreferences(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        String str2 = str + "_" + getCurrentUin();
        String string = createVasMmkvSharedPreferences.getString(str2, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "getIliveDrawerData sp key:" + str2 + " value = " + string);
        }
        return string;
    }

    public static int getIliveSwitch(int i3) {
        String str;
        migrateToMmkvIfNeed(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        SharedPreferences createVasMmkvSharedPreferences = createVasMmkvSharedPreferences(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        if (i3 != 1) {
            if (i3 != 2) {
                str = "";
            } else {
                str = ILiveDbManagerApi.KEY_IS_SHOW_SHOP;
            }
        } else {
            str = ILiveDbManagerApi.KEY_IS_QQ_LIVE_PGC;
        }
        String str2 = str + "_" + getCurrentUin();
        int i16 = createVasMmkvSharedPreferences.getInt(str2, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "get sp key:" + str2 + " value = " + i16);
        }
        return i16;
    }

    private static boolean hasMigrate(String str) {
        return createVasMmkvSharedPreferences(str).getBoolean(PREFS_KEY_HAS_MIGRATE, false);
    }

    private static void migrateToMmkvIfNeed(String str) {
        if (!hasMigrate(str)) {
            QMMKV.migrateToSpAdapter(MobileQQ.sMobileQQ, str, QMMKVFile.FILE_QQLIVE);
            setHasMigrate(str);
        }
    }

    public static boolean saveIliveConfigBean(int i3, a aVar) {
        String str;
        if (aVar == null) {
            return false;
        }
        migrateToMmkvIfNeed(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        SharedPreferences createVasMmkvSharedPreferences = createVasMmkvSharedPreferences(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        if (i3 != 1) {
            if (i3 != 2) {
                str = "";
            } else {
                str = ILiveDbManagerApi.KEY_PLUGIN_LAST_USE_DATA;
            }
        } else {
            str = ILiveDbManagerApi.KEY_PLUGIN_NEW_DATA;
        }
        String a16 = a.a(aVar);
        boolean commit = createVasMmkvSharedPreferences.edit().putString(str, a16).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "saveIliveConfigBean set sp key:" + str + " json value = " + a16);
        }
        return commit;
    }

    public static void saveIliveData(int i3, QqLiveMsg qqLiveMsg) {
        QLog.i(TAG, 1, "saveIliveData isQQLivePgc = " + i3 + " qqLiveMsg = " + qqLiveMsg);
        saveIliveSwitch(1, i3);
        if (qqLiveMsg != null && !TextUtils.isEmpty(qqLiveMsg.anchorUrl) && !TextUtils.isEmpty(qqLiveMsg.viewerUrl)) {
            saveIliveSwitch(2, qqLiveMsg.isShopEntrance);
            saveIlivePluginConfig(qqLiveMsg);
        }
        if (qqLiveMsg != null) {
            saveIliveDrawerData(ILiveDbManagerApi.KEY_DRAWER_PLUS_TEXT, qqLiveMsg.plus_text);
            saveIliveDrawerData(ILiveDbManagerApi.KEY_DRAWER_SHOP_JUMP_SCHEME, qqLiveMsg.recomm_room_schema);
            saveIliveDrawerShoppingInfo(qqLiveMsg);
        }
    }

    public static boolean saveIliveDrawerData(String str, String str2) {
        migrateToMmkvIfNeed(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        SharedPreferences createVasMmkvSharedPreferences = createVasMmkvSharedPreferences(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        String str3 = str + "_" + getCurrentUin();
        boolean commit = createVasMmkvSharedPreferences.edit().putString(str3, str2).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "saveIliveDrawerData sp key:" + str3 + " value = " + str2);
        }
        return commit;
    }

    public static boolean saveIliveDrawerShoppingInfo(QqLiveMsg qqLiveMsg) {
        String str;
        migrateToMmkvIfNeed(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        SharedPreferences.Editor edit = createVasMmkvSharedPreferences(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC).edit();
        String str2 = "";
        if (TextUtils.isEmpty(qqLiveMsg.ShopText)) {
            str = "";
        } else {
            str = qqLiveMsg.ShopText;
        }
        edit.putString(ILiveDbManagerApi.KEY_SHOP_TITLE, str);
        if (!TextUtils.isEmpty(qqLiveMsg.ShopPicUrl)) {
            str2 = qqLiveMsg.ShopPicUrl;
        }
        edit.putString(ILiveDbManagerApi.KEY_SHOP_PIC_URL, str2);
        boolean commit = edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "set sp key:shop_drawer_enter value = " + qqLiveMsg.ShopText + "  " + qqLiveMsg.ShopPicUrl);
        }
        return commit;
    }

    public static void saveIlivePluginConfig(QqLiveMsg qqLiveMsg) {
        boolean z16;
        if (qqLiveMsg == null) {
            return;
        }
        a aVar = new a();
        if (getIliveSwitch(1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.f415949a = z16;
        aVar.f415952d = qqLiveMsg.anchorUrl;
        aVar.f415953e = qqLiveMsg.anchorUrlMd5;
        aVar.f415950b = qqLiveMsg.viewerUrl;
        aVar.f415951c = qqLiveMsg.viewerUrlMd5;
        QLog.e(TAG, 1, "saveIlivePluginConfig anchorMd5 = " + aVar.f415953e + " mWatchPluginMd5 = " + aVar.f415951c);
        saveIliveConfigBean(1, aVar);
    }

    public static boolean saveIliveSwitch(int i3, int i16) {
        String str;
        migrateToMmkvIfNeed(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        SharedPreferences createVasMmkvSharedPreferences = createVasMmkvSharedPreferences(ILiveDbManagerApi.SP_TABLE_QQ_LIVE_PGC);
        if (i3 != 1) {
            if (i3 != 2) {
                str = "";
            } else {
                str = ILiveDbManagerApi.KEY_IS_SHOW_SHOP;
            }
        } else {
            str = ILiveDbManagerApi.KEY_IS_QQ_LIVE_PGC;
        }
        String str2 = str + "_" + getCurrentUin();
        boolean commit = createVasMmkvSharedPreferences.edit().putInt(str2, i16).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "set sp key:" + str2 + " value = " + i16);
        }
        return commit;
    }

    private static void setHasMigrate(String str) {
        createVasMmkvSharedPreferences(str).edit().putBoolean(PREFS_KEY_HAS_MIGRATE, true).apply();
    }
}
