package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.qzone.reborn.util.k;
import com.qzone.report.QZonePerfReporter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.g;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.contentbox.IFeedViewHolderInterface;
import com.tencent.qzonehub.api.events.QZoneFrameInitCheckEvents;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.api.QzoneFragmentImpl;
import cooperation.qzone.util.QZLog;
import ho.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Servlet;
import mqq.app.ServletContainer;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

/* loaded from: classes34.dex */
public class QZoneApiProxyImpl implements IQZoneApiProxy {
    private static Method ENV_CHANGE_METHOD = null;
    private static final String ENV_CHANGE_METHOD_NAME = "onAccountChange";
    private static volatile Class<?> ENV_CLASS = null;
    private static final String ENV_CLASS_NAME = "com.qzone.app.QZoneRunInQQEnv";
    private static final String ENV_INIT_METHOD_NAME = "init";
    private static final String FEED_ALERT_SERVICE_CLASS_NAME = "com.qzone.app.QZoneFeedAlertService";
    private static final String FEED_ALERT_SERVICE_GETUNREAD_METHOD_NAME = "getSingleUnreadCount";
    private static final String FEED_ALERT_SERVICE_INSTANCE_METHOD_NAME = "getInstance";
    private static final String MSG_FEED_HOLDER_CLASS_NAME = "com.qzone.feed.ui.activity.QZoneMsgFeedViewHolder";
    private static final String QZONE_CONFIG_KEY_MSG_PAGE_TITLE = "msg_page_title";
    private static final String QZONE_CONFIG_KEY_SHOW_SUB_FEEDS = "show_sub_feeds";
    private static final AtomicReference<SharedPreferences> QZONE_SP = new AtomicReference<>();
    private static final String QZONE_SP_NAME = "qzone_api_proxy_sp_name";
    public static final String SCHOOL_LIST_CLASS_NAME = "com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView";
    private static final String SERVLET_CLASS_NAME = "com.qzone.common.servlet.QZoneServlet";
    private static final String TAG = "QZoneApiProxyImpl";
    private static volatile boolean sIsEnvInit = false;
    private static volatile boolean sIsInit = false;
    private static volatile WeakReference<AppRuntime> sLastRuntimeRef;
    private static volatile Constructor<?> sSchoolExtendListConstructor;

    private String checkLebaStyleUserSetting() {
        int a16;
        int lebaStyleUserSetting = ((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).getLebaStyleUserSetting();
        if (lebaStyleUserSetting != 1 && lebaStyleUserSetting != 2) {
            return null;
        }
        if (!QQTheme.isNowSimpleUI()) {
            if (lebaStyleUserSetting == 1) {
                return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C;
            }
            return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B;
        }
        if (lebaStyleUserSetting == 1) {
            return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C;
        }
        String expPostBtnMode = getExpPostBtnMode();
        boolean z16 = false;
        if (expPostBtnMode != null && (expPostBtnMode.equalsIgnoreCase(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B) || expPostBtnMode.equalsIgnoreCase(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C))) {
            z16 = true;
        }
        if (z16 || (a16 = g.a()) == 1 || a16 == 2) {
            return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B;
        }
        return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_A;
    }

    public static IFeedViewHolderInterface createMsgFeedViewHolder(Activity activity) {
        Constructor constructor;
        if (!sIsInit) {
            QZLog.w(TAG, "createMsgFeedViewHolder: not init yet");
            return null;
        }
        Class loadQZoneClass = loadQZoneClass(activity, MSG_FEED_HOLDER_CLASS_NAME);
        if (loadQZoneClass == null) {
            QZLog.w(TAG, "createMsgFeedViewHolder: failed to get class");
            return null;
        }
        try {
            constructor = loadQZoneClass.getConstructor(Activity.class);
        } catch (Throwable th5) {
            QZLog.w(TAG, "createMsgFeedViewHolder failed to get constructor", th5);
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (IFeedViewHolderInterface) constructor.newInstance(activity);
        } catch (Throwable th6) {
            QZLog.w(TAG, "createMsgFeedViewHolder failed to create instance", th6);
            return null;
        }
    }

    private static SharedPreferences getSelfSharedPreferences(Context context) {
        AtomicReference<SharedPreferences> atomicReference = QZONE_SP;
        b.a(atomicReference, null, context.getSharedPreferences(QZONE_SP_NAME, 0));
        return atomicReference.get();
    }

    public static String getSubFeedTitle(Context context) {
        String string = getSelfSharedPreferences(context).getString(QZONE_CONFIG_KEY_MSG_PAGE_TITLE, "");
        return TextUtils.isEmpty(string) ? HardCodeUtil.qqStr(R.string.hvk) : string;
    }

    private boolean isForceUsePostBtnModeC() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()) && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ZPLAN_TOGGLE_NEW_CONCISE, 1) == 1;
    }

    private boolean isQZonePluginValid(Context context, AppRuntime appRuntime) {
        int int4Uin = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, appRuntime.getLongAccountUin());
        if (int4Uin == 8) {
            QZLog.e(TAG, "creditLevel" + int4Uin);
            return false;
        }
        if (sIsInit && sIsEnvInit) {
            return true;
        }
        if (!com.tencent.mobileqq.automator.a.f199911b) {
            return initServlet(context, appRuntime) && initEnv(context, appRuntime);
        }
        if (initServlet(context, appRuntime) && initEnv(context, appRuntime)) {
            return true;
        }
        QZLog.e(TAG, "initServlet erro");
        return false;
    }

    private static <T> Class<T> loadQZoneClass(Context context, String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable th5) {
            QZLog.d(TAG, 2, "createAdapter: failed to get class by normal class loader", th5);
            return null;
        }
    }

    public static void recordRuntime(AppRuntime appRuntime) {
        sLastRuntimeRef = new WeakReference<>(appRuntime);
    }

    public static void recordSubFeedConfig(Context context, boolean z16, String str) {
        QZLog.i(TAG, "recordShowSubFeedConfig: " + z16 + " " + str);
        if (str == null) {
            str = "";
        }
        getSelfSharedPreferences(context).edit().putBoolean(QZONE_CONFIG_KEY_SHOW_SUB_FEEDS, z16).putString(QZONE_CONFIG_KEY_MSG_PAGE_TITLE, str).apply();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public Fragment createLebaFragment(Activity activity, AppRuntime appRuntime, String str) {
        Fragment fragment;
        boolean z16;
        if (!sIsInit) {
            QZLog.w(TAG, "createLebaFragment: not init yet");
            return null;
        }
        Class loadQZoneClass = loadQZoneClass(appRuntime.getApp(), str);
        if (loadQZoneClass == null) {
            QZLog.e(TAG, "clazz==null");
            return null;
        }
        try {
            fragment = (Fragment) loadQZoneClass.newInstance();
        } catch (Throwable th5) {
            QZLog.w(TAG, "createLebaFragment: failed to create instance", th5);
            fragment = null;
        }
        if (fragment == null) {
            return null;
        }
        if (fragment instanceof QzoneFragmentImpl) {
            try {
                ((QzoneFragmentImpl) fragment).attachQQContext(activity, appRuntime);
            } catch (Throwable th6) {
                QZLog.w(TAG, "createLebaFragment: failed to init instance", th6);
                z16 = false;
            }
        }
        z16 = true;
        if (z16) {
            return fragment;
        }
        return null;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean disableBssid() {
        return com.qzone.reborn.configx.g.f53821a.b().m();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean enableShowRecommend() {
        return com.qzone.reborn.albumx.qzone.local.g.f52662a.c();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void fetchAndReportTeenageFeedModeExp() {
        com.qzone.reborn.a.f52169a.h("exp_qzone_teenage_mode_feed");
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void fetchAndSaveLocalPhotoRecommendTabExperimentValue() {
        com.qzone.reborn.albumx.qzone.local.g.f52662a.d();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String generatePublishId() {
        return eo.c.f396879a.b();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String getExpContentInSimpleUI(AppRuntime appRuntime) {
        if (isShowQZoneFrameForTeenage()) {
            return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_A;
        }
        String checkLebaStyleUserSetting = checkLebaStyleUserSetting();
        if (checkLebaStyleUserSetting != null) {
            return checkLebaStyleUserSetting;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE);
        if (expEntity.isExpOnline()) {
            if (expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B) || expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C)) {
                QLog.i(TAG, 1, "getExpContentInSimpleUI from postBtnExp expValue=exp_shouq_dongtai_jianjie_B");
                return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B;
            }
        }
        int a16 = g.a();
        return a16 == 1 ? QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C : a16 == 2 ? QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B : QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_A;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String getExpPostBtnMode(AppRuntime appRuntime) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE);
        boolean isForceUsePostBtnModeC = isForceUsePostBtnModeC();
        String str = QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C;
        if (isForceUsePostBtnModeC) {
            QLog.i(TAG, 1, "getExpPostBtnMode form zplanSwitch");
        } else if (expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B)) {
            str = QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B;
        } else if (!expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C)) {
            str = QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_A;
        }
        QLog.i(TAG, 1, "getExpPostBtnMode= " + str);
        return str;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String getFirstVideoFeedCoverPath() {
        return o7.c.a();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public AppRuntime getLastRuntime() {
        if (sLastRuntimeRef == null) {
            return null;
        }
        return sLastRuntimeRef.get();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean getLocalPhotoScanAuthorizeSwitch() {
        return o7.c.b();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String getPublishId() {
        return eo.c.f396879a.c();
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String getPublisherGamePlayReportStr(ArrayList<HashMap<String, Object>> arrayList) {
        return zm.c.f452770a.f(arrayList);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public int getQZoneUnReadCount(int i3) {
        Class loadQZoneClass;
        Method method;
        Object obj;
        Method method2 = null;
        Context applicationContext = MobileQQ.sMobileQQ.waitAppRuntime(null).getApplicationContext();
        if (applicationContext == null || (loadQZoneClass = loadQZoneClass(applicationContext, FEED_ALERT_SERVICE_CLASS_NAME)) == null) {
            return -1;
        }
        try {
            method = loadQZoneClass.getMethod(FEED_ALERT_SERVICE_INSTANCE_METHOD_NAME, new Class[0]);
        } catch (Throwable th5) {
            QZLog.w(TAG, "hasQZoneUnReadRedDot: failed to get getInstance method", th5);
            method = null;
        }
        if (method == null) {
            return -1;
        }
        try {
            obj = method.invoke(null, null);
        } catch (Throwable th6) {
            QZLog.w(TAG, "hasQZoneUnReadRedDot: failed to call getInstance method", th6);
            obj = null;
        }
        if (obj == null) {
            return -1;
        }
        try {
            method2 = loadQZoneClass.getMethod(FEED_ALERT_SERVICE_GETUNREAD_METHOD_NAME, Integer.TYPE);
        } catch (Throwable th7) {
            QZLog.w(TAG, "hasQZoneUnReadRedDot: failed to get getSingleUnreadCount method", th7);
        }
        if (method2 == null) {
            return -1;
        }
        try {
            Object invoke = method2.invoke(obj, Integer.valueOf(i3));
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            return -1;
        } catch (Throwable th8) {
            QZLog.w(TAG, "hasQZoneUnReadRedDot: failed to call getSingleUnreadCount method", th8);
            return -1;
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean initEnv(Context context, AppRuntime appRuntime) {
        try {
            QZLog.e(TAG, "initEnv: start");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error: ", th5);
        }
        if (sIsEnvInit) {
            return true;
        }
        initializeEnv(context, appRuntime);
        return sIsEnvInit;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean initServlet(Context context, AppRuntime appRuntime) {
        MSFServlet mSFServlet;
        ServletContainer servletContainer;
        Map map;
        boolean z16;
        long nanoTime = System.nanoTime();
        QZLog.i(TAG, "initServlet: start , sIsInit = " + sIsInit + " , app = " + appRuntime);
        if (sIsInit) {
            return true;
        }
        Class loadQZoneClass = loadQZoneClass(context, SERVLET_CLASS_NAME);
        if (loadQZoneClass == null) {
            return false;
        }
        Map map2 = null;
        try {
            mSFServlet = (MSFServlet) loadQZoneClass.newInstance();
        } catch (Throwable th5) {
            QZLog.w(TAG, "initServlet: failed to get servlet instance", th5);
            mSFServlet = null;
        }
        if (mSFServlet == null) {
            return false;
        }
        try {
            Field declaredField = AppRuntime.class.getDeclaredField("mServletContainer");
            declaredField.setAccessible(true);
            servletContainer = (ServletContainer) declaredField.get(appRuntime);
        } catch (Throwable th6) {
            QZLog.w(TAG, "initServlet: failed to get container", th6);
            servletContainer = null;
        }
        if (servletContainer == null) {
            return false;
        }
        try {
            Field declaredField2 = ServletContainer.class.getDeclaredField("managedServlet");
            declaredField2.setAccessible(true);
            map = (Map) declaredField2.get(servletContainer);
        } catch (Throwable th7) {
            th = th7;
            map = null;
        }
        try {
            Field declaredField3 = ServletContainer.class.getDeclaredField("actionMap");
            declaredField3.setAccessible(true);
            map2 = (Map) declaredField3.get(servletContainer);
        } catch (Throwable th8) {
            th = th8;
            QZLog.w(TAG, "initServlet: failed to get container field", th);
            if (map != null) {
            }
            return false;
        }
        if (map != null || map2 == null) {
            return false;
        }
        try {
            Method declaredMethod = Servlet.class.getDeclaredMethod("init", AppRuntime.class, ServletContainer.class);
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = Servlet.class.getDeclaredMethod("onCreate", new Class[0]);
            declaredMethod2.setAccessible(true);
            declaredMethod.invoke(mSFServlet, appRuntime, servletContainer);
            declaredMethod2.invoke(mSFServlet, new Object[0]);
            z16 = true;
        } catch (Throwable th9) {
            QZLog.w(TAG, "initServlet: failed to get init method", th9);
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        synchronized (map) {
            map.put(SERVLET_CLASS_NAME, mSFServlet);
            String[] preferSSOCommands = mSFServlet.getPreferSSOCommands();
            if (preferSSOCommands != null) {
                for (String str : preferSSOCommands) {
                    Set set = (Set) map2.get(str);
                    if (set == null) {
                        set = new HashSet();
                        map2.put(str, set);
                    }
                    set.add(SERVLET_CLASS_NAME);
                }
            }
        }
        recordRuntime(appRuntime);
        QZLog.i(TAG, "initServlet: ok " + appRuntime.getCurrentUin() + " " + (System.nanoTime() - nanoTime));
        sIsInit = true;
        SimpleEventBus.getInstance().dispatchEvent(new QZoneFrameInitCheckEvents());
        return true;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean isInQZoneEnvironment() {
        return !sIsInit;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean isQZonePluginInit() {
        return sIsInit && sIsEnvInit;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean isShowQZoneFrameForTeenage() {
        return k.f59549a.g() && com.qzone.reborn.a.f52169a.b("exp_qzone_teenage_mode_feed", "_B");
    }

    boolean isShowQzoneFrameEnabled(AppRuntime appRuntime) {
        if (!QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C.equals(getExpContentInSimpleUI(appRuntime))) {
            return true;
        }
        QZLog.i(TAG, "isShowQzoneFrameEnabled, EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C, show-qzone is false");
        return false;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean isSimpleUiLebaProfileJumpExpGroup() {
        int a16 = g.a();
        QLog.i(TAG, 1, "isSimpleUiLebaProfileJumpExpGroup frameMode = " + a16);
        if (a16 == 2) {
            return true;
        }
        int b16 = g.b();
        QLog.i(TAG, 1, "isSimpleUiLebaProfileJumpExpGroup targetType = " + b16);
        if (b16 == 1) {
            return true;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_SIMPLE_UI_FEEDS_PROFILE_JUMP);
        boolean isExpOnline = expEntity.isExpOnline();
        boolean isExperiment = expEntity.isExperiment();
        QLog.i(TAG, 1, "isSimpleUiLebaProfileJumpExpGroup online= " + isExpOnline + ", isExperiment= " + isExperiment);
        return isExpOnline && isExperiment;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void launchLocalPhotoRecommendStandalonePage(Context context, Bundle bundle) {
        i.y().e(context, bundle);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void launchQZoneUploadPhotoPage(Activity activity, ArrayList<LocalMediaInfo> arrayList, String str, int i3, Bundle bundle, int i16) {
        i.y().h(activity, arrayList, str, Integer.valueOf(i3), bundle, i16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean needShowQzoneFrame(Context context, AppRuntime appRuntime) {
        if (context != null && appRuntime != null) {
            if (AppSetting.t(context)) {
                return false;
            }
            int a16 = com.tencent.mobileqq.studymode.g.a();
            if (isShowQZoneFrameForTeenage()) {
                QZLog.i(TAG, "need show qzone frame for teenage mode");
                return true;
            }
            try {
                if (((ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, "")).isFeedGoOffline()) {
                    QZLog.i(TAG, "feed go offline");
                    return false;
                }
            } catch (Throwable th5) {
                QZLog.e(TAG, "needShowQzoneFrame error", th5);
            }
            boolean z16 = a16 == 0 && ((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).getLebaStyleUserSetting() == 2;
            if (!QQTheme.isNowSimpleUI() && !z16) {
                return false;
            }
            if (isShowQzoneFrameEnabled(appRuntime)) {
                return true;
            }
            QZLog.i(TAG, "needShowQzoneFrame isShowQzoneFrameEnabled no");
            return false;
        }
        QZLog.e(TAG, "context or application is null");
        return false;
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void onAccountChange(Context context, AppRuntime appRuntime) {
        QZLog.i(TAG, "onAccountChange: " + appRuntime.getCurrentUin() + " " + sIsEnvInit + " " + sIsInit);
        if (!sIsEnvInit) {
            initEnv(context, appRuntime);
            return;
        }
        if (ENV_CLASS == null) {
            ENV_CLASS = loadQZoneClass(context, ENV_CLASS_NAME);
        }
        if (ENV_CLASS == null) {
            return;
        }
        if (ENV_CHANGE_METHOD == null) {
            try {
                ENV_CHANGE_METHOD = ENV_CLASS.getMethod(ENV_CHANGE_METHOD_NAME, QQAppInterface.class);
            } catch (Throwable th5) {
                QZLog.w(TAG, "onAccountChange: failed to get change account method", th5);
            }
        }
        Method method = ENV_CHANGE_METHOD;
        if (method == null) {
            return;
        }
        try {
            method.invoke(null, appRuntime);
        } catch (Throwable th6) {
            QZLog.w(TAG, "onAccountChange: failed to call change account method", th6);
        }
        if (sIsInit) {
            sIsInit = false;
            initServlet(context, appRuntime);
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void parseAddGamePlayRecordData(Intent intent, ArrayList<HashMap<String, Object>> arrayList) {
        zm.c.f452770a.g(intent, arrayList, true);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void reportNTUploadFileResult(int i3, String str, long j3, long j16, int i16, String str2) {
        QZonePerfReporter.n(i3, str, j3, j16, i16, str2);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void reportNTUploadMissionResult(int i3, String str, String str2, int i16, int i17) {
        QZonePerfReporter.o(i3, str, str2, i16, i17);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void requestAddFriendShowQZoneFeeds(long j3, BusinessObserver businessObserver) {
        com.tencent.mobileqq.servlet.a.requestAddFriendShowQZoneFeeds(j3, businessObserver);
    }

    private void initializeEnv(Context context, AppRuntime appRuntime) {
        Method method;
        if (context == null) {
            QLog.e(TAG, 1, "[initializeEnv] current context should not be null.");
            return;
        }
        if (appRuntime == null) {
            QLog.e(TAG, 1, "[initializeEnv] current app should not be null.");
            return;
        }
        long nanoTime = System.nanoTime();
        if (ENV_CLASS == null) {
            ENV_CLASS = loadQZoneClass(context, ENV_CLASS_NAME);
        }
        QZLog.e(TAG, "initEnv: loadQZoneClass");
        if (ENV_CLASS == null) {
            QLog.e(TAG, 1, "[initializeEnv] env class should not be null.");
            return;
        }
        boolean z16 = false;
        try {
            method = ENV_CLASS.getMethod("init", AppRuntime.class);
        } catch (Throwable th5) {
            QZLog.w(TAG, "initEnv: failed to get init env method", th5);
            method = null;
        }
        if (method == null) {
            QLog.e(TAG, 1, "[initializeEnv] ");
            return;
        }
        try {
            z16 = ((Boolean) method.invoke(null, appRuntime)).booleanValue();
        } catch (Throwable th6) {
            QZLog.w(TAG, "initEnv: failed to init", th6);
        }
        sIsEnvInit = z16;
        QZLog.e(TAG, "initEnv: end " + sIsEnvInit + " " + (System.nanoTime() - nanoTime));
        SimpleEventBus.getInstance().dispatchEvent(new QZoneFrameInitCheckEvents());
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void setQzonePageDaTongParams(Activity activity, View view) {
        com.tencent.mobileqq.leba.report.d.s(activity, view, "pg_discover_feeds_page", false, "qzone");
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public void reportDownloadResult(String str, boolean z16, HashMap<String, String> hashMap, long j3, String str2) {
        String str3;
        if (hashMap == null || (str3 = hashMap.get("downloadUrl")) == null) {
            return;
        }
        QZonePerfReporter.f59697a.l(str3, z16, str2, "", j3);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String getExpPostBtnMode() {
        return getExpPostBtnMode(MobileQQ.sMobileQQ.waitAppRuntime(null));
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean needShowAioFeedList(Activity activity, AppRuntime appRuntime) {
        if (activity == null || appRuntime == null || QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_AIO_SHOW_FEED_LIST, 1) == 0) {
            return false;
        }
        return isQZonePluginValid(activity, appRuntime);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean needShowMsgFeedList(Activity activity, AppRuntime appRuntime) {
        if (activity == null || appRuntime == null || QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_OFFICIAL_ACCOUNT, QzoneConfig.SECONDARY_KEY_OFFICIAL_ACCOUNT_CAN_SHOW_FEEDS_LIST, 0) == 0) {
            return false;
        }
        return isQZonePluginValid(activity, appRuntime);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public boolean needShowSubFeedList(Activity activity, AppRuntime appRuntime) {
        if (activity == null || appRuntime == null || QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SUB_SHOW_FEED_LIST, 1) == 0) {
            return false;
        }
        if (!getSelfSharedPreferences(activity).getBoolean(QZONE_CONFIG_KEY_SHOW_SUB_FEEDS, false)) {
            QZLog.i(TAG, "needShowSubFeedList: close by server");
        }
        return isQZonePluginValid(activity, appRuntime);
    }

    @Override // com.tencent.qzonehub.api.IQZoneApiProxy
    public String getExpContentInSimpleUI() {
        return getExpContentInSimpleUI(MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
}
