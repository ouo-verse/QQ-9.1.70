package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class MiniAppConfProcessor extends com.tencent.mobileqq.config.l<MiniAppConfBean> {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f202451a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f202452b = -1;

    public static String a() {
        String str = QzoneConfig.DEFAULT_MINI_APP_FULL_SCREEN_TITLE;
        try {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            str = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(account + "_" + QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_TITLE, QzoneConfig.DEFAULT_MINI_APP_FULL_SCREEN_TITLE);
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppConfProcessor", 2, "[DesktopDataManager]. desktopTitleConfig title: " + str + "\uff0cuin: " + account);
            }
        } catch (Exception unused) {
            QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. desktopTitleConfig Exception");
        }
        return str;
    }

    public static String b() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_APPLETS_NICKNAME, QzoneConfig.DEFAULT_APPLETS_NICKNAME);
    }

    public static String c() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_APPLETS_UIN, QzoneConfig.DEFAULT_APPLETS_UIN);
    }

    public static int d() {
        if (f202452b == -1) {
            f202452b = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappfullscreenminedatamaxnum", 50);
            QLog.d("MiniAppConfProcessor", 1, "[MiniAppUserAppInfoListManager].maxtopnum = " + f202452b);
        }
        return f202452b;
    }

    private static SharedPreferences e() {
        final SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "mobileQQ", "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.MiniAppConfProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "mobileQQ", "common_mmkv_configurations");
                        fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
                    } catch (Exception unused) {
                        QLog.e("MiniAppConfProcessor", 2, "[Migrate Error]. ");
                    }
                }
            }, 64, null, true);
            return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        }
        return fromSpAdapter;
    }

    public static int f(String str, int i3) {
        try {
            str = str.toLowerCase();
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            i3 = Integer.parseInt(e().getString(account + "_" + str, String.valueOf(i3)));
        } catch (Exception e16) {
            QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, error!", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, secondaryKey: " + str + ", Value = " + i3);
        }
        return i3;
    }

    public static String g(String str, String str2) {
        try {
            str = str.toLowerCase();
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            str2 = e().getString(account + "_" + str, str2);
        } catch (Exception e16) {
            QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, error!", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, secondaryKey: " + str + ", Value = " + str2);
        }
        return str2;
    }

    public static boolean h() {
        if (f(QzoneConfig.SECONDARY_KEY_MINI_APP_SHOW_MSG_RED_DOT, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean i() {
        if (f(QzoneConfig.SECONDARY_KEY_MINI_APP_SHOW_RED_DOT, 0) != 1) {
            return false;
        }
        return true;
    }

    public static MiniAppConfBean j() {
        return (MiniAppConfBean) com.tencent.mobileqq.config.am.s().x(425);
    }

    public static boolean l() {
        return !o();
    }

    public static boolean m() {
        if (f202451a == -1) {
            try {
                String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                f202451a = e().getInt(account + "_miniappshowfullscreen", 1);
            } catch (Exception unused) {
                f202451a = 1;
                QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowMiniAppFullScreen Exception");
            }
            QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager].needShowMiniAppFullScreen, showFullScreen = " + f202451a);
        }
        if (f202451a == 1) {
            return true;
        }
        return false;
    }

    public static boolean n() {
        if (f(QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_NOTIFICATION, 1) == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o() {
        int i3;
        String account;
        try {
            account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            i3 = e().getInt(account + "_" + QzoneConfig.SECONDARY_KEY_MINI_APP_FULL_SCREEN_SHOW_SETTING, 0);
        } catch (Exception unused) {
            i3 = 0;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppConfProcessor", 2, "[DesktopDataManager]. needShowSettingButton settingValue: " + i3 + "\uff0cuin: " + account);
            }
        } catch (Exception unused2) {
            QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowSettingButton Exception.");
            QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager].needShowSettingButton, settingValue = " + i3);
            if (i3 != 1) {
            }
        }
        QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager].needShowSettingButton, settingValue = " + i3);
        if (i3 != 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<MiniAppConfBean> clazz() {
        return MiniAppConfBean.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public MiniAppConfBean migrateOldOrDefaultContent(int i3) {
        return new MiniAppConfBean();
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public MiniAppConfBean onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            new MiniAppConfBean();
            return MiniAppConfBean.f(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onUpdate(MiniAppConfBean miniAppConfBean) {
        BusinessHandler businessHandler;
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppConfProcessor", 2, "onUpdate " + miniAppConfBean.toString());
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof QQAppInterface) && (businessHandler = ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.MINI_APP_ENTRY_HANDLER)) != null) {
            businessHandler.notifyUI(0, true, null);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 425;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
