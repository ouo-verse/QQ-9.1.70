package com.tencent.comic.api.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.data.d;
import com.tencent.comic.data.e;
import com.tencent.comic.data.f;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQDcReporterImpl implements IQQDcReporter {
    private static final String FILE_SYSTEM_INFO_ = "fileSystemInfo_";
    private static final String IMEI_INTERFACE_BIZ_ID = "7aa880";
    private static final String KEY_SYSTEM_IMEI = "systemImei";
    public static final String QQ_DEVICE_INFO_COMIC = "2240ca";
    private static final String TAG = "VipComicReportUtils";
    private static String imei = "";
    private static String qimei = "";
    public static String res = "";
    private static Field stringBuilderValueField = null;
    private static String systemImei = "";
    private static Boolean needGetField = Boolean.TRUE;
    private static ThreadLocal<char[]> stringBuilderCharBuffer = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements o.c {
        b() {
        }

        @Override // com.tencent.mobileqq.statistics.o.c
        public void a(String str, String str2) {
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(QQDcReporterImpl.qimei)) {
                QQDcReporterImpl.qimei = str2;
            }
            if (QLog.isColorLevel()) {
                QLog.i(QQDcReporterImpl.TAG, 1, "getQimei onQimeiDispatch qimei:" + QQDcReporterImpl.qimei);
            }
            com.tencent.comic.utils.a.b().getSharedPreferences(QQDcReporterImpl.FILE_SYSTEM_INFO_, 4).edit().putString("qimei_new", QQDcReporterImpl.qimei).commit();
        }
    }

    private static String getNetType() {
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType < 0 || netWorkType >= AppConstants.NET_TYPE_NAME.length) {
            netWorkType = 0;
        }
        return AppConstants.NET_TYPE_NAME[netWorkType];
    }

    private static String getSystemImei(Context context) {
        try {
            QLog.d(TAG, 1, "get system imei from QQDeviceInfo");
            systemImei = QQDeviceInfo.getIMEI(IMEI_INTERFACE_BIZ_ID);
        } catch (SecurityException unused) {
            systemImei = "";
        } catch (Throwable unused2) {
            systemImei = "";
        }
        return systemImei;
    }

    private static String getSystemImeiFromSP() {
        AppRuntime a16 = com.tencent.comic.utils.a.a();
        if (a16 == null) {
            return "";
        }
        return com.tencent.comic.utils.a.b().getSharedPreferences(FILE_SYSTEM_INFO_ + a16.getAccount(), 4).getString(KEY_SYSTEM_IMEI, "");
    }

    private static void initQimeiAsync() {
        o.d(new b());
    }

    private static List<String> mergeParams(String str, List<String> list) {
        d dVar;
        if ("3025".equals(str)) {
            dVar = f.f99355l.a();
            dVar.d("is_new", 22, "302598765432001");
        } else {
            dVar = f.f99355l;
        }
        return dVar.c(list);
    }

    public static StringBuilder obtainStringBuilder() {
        StringBuilder sb5 = new StringBuilder();
        try {
            if (needGetField.booleanValue()) {
                Field declaredField = StringBuilder.class.getSuperclass().getDeclaredField("value");
                stringBuilderValueField = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    needGetField = Boolean.FALSE;
                }
            }
            Field field = stringBuilderValueField;
            if (field != null) {
                field.set(sb5, stringBuilderCharBuffer.get());
            }
        } catch (Exception unused) {
        }
        return sb5;
    }

    private void reportDCEvent(AppInterface appInterface, String str, List<String> list) {
        if (appInterface instanceof BaseQQAppInterface) {
            reportDCEvent((BaseQQAppInterface) appInterface, "dc00145", list);
        } else {
            reportDCEvent((BaseQQAppInterface) null, "dc00145", list);
        }
    }

    private static void saveSystemImei(String str) {
        AppRuntime a16 = com.tencent.comic.utils.a.a();
        if (a16 != null) {
            com.tencent.comic.utils.a.b().getSharedPreferences(FILE_SYSTEM_INFO_ + a16.getAccount(), 4).edit().putString(KEY_SYSTEM_IMEI, str).apply();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "save system imei success ");
            }
        }
    }

    private static void updateRes(Context context) {
        if (TextUtils.isEmpty(res)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            res = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        }
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public String getColdStartImei(Context context) {
        if (!StringUtil.isEmpty(systemImei)) {
            return systemImei;
        }
        if (Build.VERSION.SDK_INT <= 28 && com.tencent.comic.utils.a.b().checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0) {
            return getSystemImei(context);
        }
        return getQimei();
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    @Deprecated
    public String getImei(Context context) {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(imei)) {
            try {
                imei = QQDeviceInfo.getIMEI(QQ_DEVICE_INFO_COMIC);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "telephonyManager.getDeviceId encounter error", th5);
            }
            if (TextUtils.isEmpty(imei)) {
                imei = getQimei();
            }
            if (imei == null) {
                QLog.e(TAG, 1, "getImei finally encounter error and return empty");
                imei = "";
            }
        }
        return imei;
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public String getQimei() {
        if (TextUtils.isEmpty(qimei)) {
            try {
                String string = com.tencent.comic.utils.a.b().getSharedPreferences(FILE_SYSTEM_INFO_, 4).getString("qimei_new", "");
                qimei = string;
                if (TextUtils.isEmpty(string)) {
                    initQimeiAsync();
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getQimei error", th5);
            }
        }
        return qimei;
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportDC00145(AppInterface appInterface, String str, String str2, String str3, String str4, String... strArr) {
        if (appInterface == null) {
            return;
        }
        reportDC00145(appInterface, appInterface.getCurrentAccountUin(), appInterface.getApplicationContext(), str, str2, str3, str4, strArr);
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportDC00145_2(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String... strArr) {
        if (appInterface == null) {
            return;
        }
        reportDC00145_2(appInterface, appInterface.getCurrentAccountUin(), appInterface.getApplicationContext(), str, str2, str3, str4, str5, strArr);
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportDC00145_3(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String... strArr) {
        if (appInterface == null || appInterface.getApplicationContext() == null || appInterface.getCurrentAccountUin() == null) {
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        Context applicationContext = appInterface.getApplicationContext();
        String netType = getNetType();
        updateRes(applicationContext);
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", ""};
        for (int i3 = 0; i3 < 10 && i3 < strArr.length; i3++) {
            strArr2[i3] = strArr[i3];
        }
        strArr2[5] = getQimei();
        if (TextUtils.isEmpty(strArr2[7]) && !TextUtils.isEmpty(f.f99353j)) {
            strArr2[7] = f.f99353j;
        }
        String str11 = TextUtils.isEmpty(f.f99345b) ? "" : f.f99345b;
        List asList = Arrays.asList("1", currentAccountUin, getQimei(), "", "android", ThemeReporter.FROM_DIY, Build.VERSION.RELEASE, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PAUSE_FEEDBACK_ID, "8001001", "", "", str11, str9, "", "", str, str5, "", str2, str3, str4, "", "", AppSetting.f99551k, "", "", str10, "", "", "android", netType, res, "", strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], str7, str8, str6, "", "");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("dc DC00145_3 detail : ");
            sb5.append("uin:" + currentAccountUin + ",imei:" + getQimei() + ",domain:android,domain_id:201,biz_id:8001,biz_subid:8001001,obj_ownerid:" + str11 + ",objPos:" + str9 + ",pageId:" + str + ",operObjType:" + str2 + ",operObjId:" + str3 + ",retId:" + str4 + ",sesId:" + str10 + ",ext1: ,ext2:" + strArr2[0] + ",ext3:" + strArr2[1] + ",ext4:" + strArr2[2] + ",ext5:" + strArr2[3] + ",ext6:" + strArr2[4] + ",ext7:" + strArr2[5] + ",ext8:" + strArr2[6] + ",ext9:" + strArr2[7] + ",ext10:" + strArr2[8] + ",land_page_id:" + str7 + ",detailpage_from:" + str8 + ",algo_id:" + str6);
            QLog.d(TAG, 2, sb5.toString());
        }
        reportDCEvent(appInterface, "dc00145", mergeParams(str, asList));
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportDC01327(AppInterface appInterface, e eVar) {
        if (appInterface == null) {
            QLog.e(TAG, 2, "reportDC01327 error cause app == null");
            return;
        }
        Context applicationContext = appInterface.getApplicationContext();
        if (applicationContext == null) {
            QLog.e(TAG, 2, "reportDC01327 error cause context == null");
            return;
        }
        String netType = getNetType();
        updateRes(applicationContext);
        String[] e16 = eVar.e();
        e16[6] = ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).getQimei();
        reportDCEvent((BaseQQAppInterface) null, "dc01327", Arrays.asList("", "android", ThemeReporter.FROM_DIY, Build.VERSION.RELEASE, "", AppSetting.f99551k, "android", netType, res, eVar.a(), eVar.b(), eVar.l(), "", eVar.k(), eVar.j(), "", eVar.q(), e16[1], e16[2], e16[3], e16[4], e16[5], e16[6], e16[7], e16[8], "", "", f.f99354k, eVar.p(), "", eVar.d(), eVar.i(), eVar.r(), eVar.s(), eVar.f(), eVar.c(), eVar.g(), eVar.m(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", e16[0], e16[9], eVar.h(), "", "", eVar.o(), eVar.n()));
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "report dc01327: mod=" + f.f99354k);
        }
    }

    public void reportDC01767(AppInterface appInterface, String str, Context context, String str2, String str3, String str4, String str5, String... strArr) {
        if (str == null || context == null) {
            return;
        }
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType < 0 || netWorkType >= AppConstants.NET_TYPE_NAME.length) {
            netWorkType = 0;
        }
        String str6 = AppConstants.NET_TYPE_NAME[netWorkType];
        if (TextUtils.isEmpty(res)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            res = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        }
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", ""};
        for (int i3 = 0; i3 < 10 && i3 < strArr.length; i3++) {
            strArr2[i3] = strArr[i3];
        }
        reportDCEvent(appInterface instanceof BaseQQAppInterface ? (BaseQQAppInterface) appInterface : null, "dc01767", Arrays.asList("1", str, getQimei(), "", "android", ThemeReporter.FROM_DIY, Build.VERSION.RELEASE, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PAUSE_FEEDBACK_ID, "8001001", "", "", "", "", "", "", str2, "", "", str3, str4, str5, "", "", AppSetting.f99551k, "", "", "", "", "", "android", str6, res, "", strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], strArr2[9]));
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportDCSqliteProfile(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, String... strArr) {
        String[] strArr2 = new String[10];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(10, strArr.length));
        for (int i3 = 0; i3 < 10; i3++) {
            if (strArr2[i3] == null) {
                strArr2[i3] = "";
            }
        }
        reportDCEvent(appInterface instanceof BaseQQAppInterface ? (BaseQQAppInterface) appInterface : null, "b_sng_qqvip_sqlite_profile_report|sqlite_profile_monitor_report", Arrays.asList("1", String.valueOf(System.currentTimeMillis() / 1000), "ANDROID", Build.VERSION.RELEASE, str, AppSetting.f99551k, str2, str3, str4, str5, str6, strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], strArr2[9]));
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportTechReport2021(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_sng_qq_comic|qqcomic_tech_report_2021", str, true);
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportVasStatus(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, String str5) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        sb5.append(str2);
        sb5.append("|");
        if (TextUtils.isEmpty(str3)) {
            str3 = "0";
        }
        sb5.append(str3);
        sb5.append("|");
        sb5.append(i3);
        sb5.append("|");
        sb5.append(i16);
        sb5.append("|");
        sb5.append(i17);
        sb5.append("|");
        sb5.append(i18);
        sb5.append("|");
        sb5.append(str4);
        sb5.append("|");
        sb5.append(str5);
        DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", sb5.toString(), true);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends ThreadLocal<char[]> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    private void reportDC00145_2(AppInterface appInterface, String str, Context context, String str2, String str3, String str4, String str5, String str6, String... strArr) {
        if (str == null || context == null) {
            return;
        }
        String netType = getNetType();
        updateRes(context);
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", ""};
        for (int i3 = 0; i3 < 10 && i3 < strArr.length; i3++) {
            strArr2[i3] = strArr[i3];
        }
        strArr2[5] = getQimei();
        reportDCEvent(appInterface instanceof BaseQQAppInterface ? (BaseQQAppInterface) appInterface : null, "dc00145", Arrays.asList("1", str, getQimei(), "", "android", ThemeReporter.FROM_DIY, Build.VERSION.RELEASE, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PAUSE_FEEDBACK_ID, "8001001", "", "", "", f.f99348e, "", "", str2, f.f99344a, str3, str4, str5, str6, "", "", AppSetting.f99551k, "", "", "", "", "", "android", netType, res, "", strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], "", f.f99349f, "", "", ""));
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportDC00145(AppInterface appInterface, String str, Context context, String str2, String str3, String str4, String str5, String... strArr) {
        if (str == null || context == null) {
            return;
        }
        String netType = getNetType();
        updateRes(context);
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", ""};
        for (int i3 = 0; i3 < 10 && i3 < strArr.length; i3++) {
            strArr2[i3] = strArr[i3];
        }
        strArr2[5] = getQimei();
        reportDCEvent(appInterface instanceof BaseQQAppInterface ? (BaseQQAppInterface) appInterface : null, "dc00145", Arrays.asList("1", str, getQimei(), "", "android", ThemeReporter.FROM_DIY, Build.VERSION.RELEASE, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PAUSE_FEEDBACK_ID, "8001001", "", "", "", f.f99348e, "", "", str2, f.f99344a, "", str3, str4, str5, "", "", AppSetting.f99551k, "", "", "", "", "", "android", netType, res, "", strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], "", f.f99349f, "", "", ""));
    }

    @Override // com.tencent.comic.api.IQQDcReporter
    public void reportDCEvent(BaseQQAppInterface baseQQAppInterface, String str, List<String> list) {
        if (list != null && list.size() > 0) {
            StringBuilder obtainStringBuilder = obtainStringBuilder();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                obtainStringBuilder.append(list.get(i3));
                if (i3 < size - 1) {
                    obtainStringBuilder.append("|");
                }
            }
            String sb5 = obtainStringBuilder.toString();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "dcId=" + str + ";detail=" + sb5);
            }
            DcReportUtil.b(baseQQAppInterface, str, sb5);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "params is null, dcId=" + str + ";detail=");
        }
    }
}
