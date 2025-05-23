package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.t;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneActivityToFragmentProxy;
import com.tencent.qzonehub.api.IQZonePageApi;
import com.tencent.qzonehub.api.IQzonePatchApi;
import com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import ho.i;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes34.dex */
public class QzonePluginProxyActivityProxyImpl implements IQzonePluginProxyActivityProxy {
    public static final String QZONE_EXTRA_KEY_PLUGIN_ISLOADING = "QZoneExtra.Plugin.isloading";
    static final String QZONE_PLGUIN_APK = "qzone_plugin.apk";
    public static final String QZONE_PLUGIN_ACTIVITY_NAME = "qzone_plugin_activity_name";
    static final String QZONE_PLUGIN_NAME = "QZone";
    private static final String TAG = "QzonePluginProxyActivityProxyImpl";

    private static void checkActivityAnimation(Context context, Intent intent, boolean z16) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (intent != null && intent.getBooleanExtra(PeakConstants.EXTRA_IS_FROM_P2V_EDIT, false)) {
                activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            }
            if (z16) {
                activity.overridePendingTransition(R.anim.f154740cc, R.anim.f154740cc);
            }
        }
    }

    private static Intent checkConvertToFragment(Context context, String str, Intent intent) {
        if (TextUtils.isEmpty(str)) {
            return intent;
        }
        if (((IQZoneActivityToFragmentProxy) QRoute.api(IQZoneActivityToFragmentProxy.class)).isConvertToFragment(str)) {
            return ((IQZoneActivityToFragmentProxy) QRoute.api(IQZoneActivityToFragmentProxy.class)).convertIntent(context, intent, str);
        }
        intent.setComponent(new ComponentName(context, str));
        return intent;
    }

    private static Intent checkRedirect(Context context, String str, Intent intent) {
        return TextUtils.isEmpty(str) ? intent : ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).checkIntentRedirect(context, str, intent);
    }

    private void checkStartupSuceess() {
        boolean z16 = false;
        if (!isQzoneExist()) {
            BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
            long longAccountUin = (baseApplicationImpl == null || baseApplicationImpl.getRuntime() == null) ? 0L : BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin();
            int int4Uin = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, longAccountUin);
            if (int4Uin == 8) {
                QLog.w(TAG, 1, "\u7a7a\u95f4\u88ab\u5c01\uff0ccreditLevel:" + int4Uin + ",msg:" + LocalMultiProcConfig.getString4Uin("creditmessage", "", longAccountUin));
                return;
            }
            QLog.w(TAG, 1, "qzone\u8fdb\u7a0b\u53ef\u80fd\u542f\u52a8\u5931\u8d25");
            int i3 = LocalMultiProcConfig.getInt(QzonePluginProxyActivity.QZONE_START_UP_FAILED_COUNT_KEY, 0) + 1;
            if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_STARTUP_FAILED_TOAST_SHOW_LIMIT, 1) < i3) {
                QQToast.makeText(BaseApplicationImpl.sApplication, 4, QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_STARTUP_FAILED_MSG, HardCodeUtil.qqStr(R.string.s4u)), 1).show();
                LocalMultiProcConfig.putInt(QzonePluginProxyActivity.QZONE_START_UP_FAILED_COUNT_KEY, 0);
                QLog.w(TAG, 1, "qzone\u8fdb\u7a0b\u53ef\u80fd\u542f\u52a8\u5931\u8d25\u5f39\u51fatoast\u63d0\u793a\u7528\u6237\u5378\u8f7d\u91cd\u65b0\u5b89\u88c5");
                z16 = true;
            } else {
                LocalMultiProcConfig.putInt(QzonePluginProxyActivity.QZONE_START_UP_FAILED_COUNT_KEY, i3);
            }
            ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(new QZoneStartupFailException("qzone\u8fdb\u7a0b\u542f\u52a8\u5931\u8d25"), "qzone\u8fdb\u7a0b\u542f\u52a8\u5931\u8d25,failCount:" + i3 + ",showToast:" + z16);
            QLog.w(TAG, 1, "qzone\u8fdb\u7a0b\u542f\u52a8\u5931\u8d25,failCount:" + i3 + ",showToast:" + z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "qzone\u8fdb\u7a0b\u542f\u52a8\u6210\u529f");
        }
        LocalMultiProcConfig.putInt(QzonePluginProxyActivity.QZONE_START_UP_FAILED_COUNT_KEY, 0);
    }

    static String getActivityNameToIntent(Intent intent) {
        return intent.getStringExtra("qzone_plugin_activity_name");
    }

    private static boolean handleRedirectLaunchPage(String str, Context context, Intent intent, int i3) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        str.hashCode();
        if (!str.equals(QZoneHelper.UPLOAD_PHOTO)) {
            return false;
        }
        if (lc.b.d()) {
            QLog.i(TAG, 1, "handleRedirectLaunchPage  redirect launch new uploadAlbumPage");
            QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0);
            qZAlbumxUploadAlbumInitBean.setRequestCode(i3);
            i.x().l(context, qZAlbumxUploadAlbumInitBean, intent);
        } else {
            i.w().h(context, new QZonePublishMoodInitBean(System.currentTimeMillis()), intent);
        }
        return true;
    }

    public static boolean isQzoneExist() {
        List<ActivityManager.RunningAppProcessInfo> list;
        try {
            list = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isQzoneExist e = " + e16);
            list = null;
        }
        if (list != null && list.size() > 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
            while (it.hasNext()) {
                if ("com.tencent.mobileqq:qzone".equals(it.next().processName)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "QzoneProcess is exist");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static void openActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16, com.tencent.mobileqq.hitrate.b bVar, boolean z17) {
        Context context2;
        if (QZoneHelper.comboqzProtectEnable && (context instanceof SplashActivity)) {
            QZoneHelper.forwardH5QZone(intent.getStringExtra("sid"), context);
            return;
        }
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardActivity(context)) {
            t.a().h(str);
        }
        String activityNameToIntent = getActivityNameToIntent(intent);
        QLog.w(TAG, 1, "QZoneHelper openActivityForResult, context: " + context + ", activityName: " + activityNameToIntent);
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        if (context instanceof BasePluginActivity) {
            context2 = ((BasePluginActivity) context).getOutActivity();
            QLog.w("QzonePluginProxyActivity", 1, HardCodeUtil.qqStr(R.string.s4w) + activityNameToIntent + ",context:" + context);
            if (context2 != null && (context2 instanceof PluginTab)) {
                context2 = ((PluginTab) context2).getOutActivity();
            }
        } else {
            context2 = context;
        }
        if (context2 != null && !(context2 instanceof BasePluginActivity)) {
            if (TextUtils.isEmpty(intent.getStringExtra("uin"))) {
                intent.putExtra("uin", str);
                intent.putExtra("qzone_uin", str);
            }
            QLog.d(TAG, 1, "openActivityForResult  | activityName = " + activityNameToIntent + " | realActivity = " + context2);
            if (handleRedirectLaunchPage(activityNameToIntent, context2, intent, i3)) {
                return;
            }
            if (!TextUtils.isEmpty(activityNameToIntent)) {
                intent = checkRedirect(context2, activityNameToIntent, checkConvertToFragment(context2, activityNameToIntent, intent));
            } else {
                QLog.w(TAG, 1, "QZoneHelper open activity warning: activity name is empty");
            }
            startActivityForResultCompat(context2, intent, i3);
            checkActivityAnimation(context2, intent, z17);
            return;
        }
        QLog.e("QzonePluginProxyActivity", 1, "activity \u53c2\u6570\u9519\u8bef\uff0c\u5c1d\u8bd5\u8fdb\u884c\u517c\u5bb9\u5931\u8d25");
        ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(new IllegalArgumentException(HardCodeUtil.qqStr(R.string.s4l) + activityNameToIntent + ",context:" + context), HardCodeUtil.qqStr(R.string.s4c));
    }

    private static void startActivityForResultCompat(Context context, Intent intent, int i3) {
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "startActivity use application context: " + Log.getStackTraceString(new Throwable()));
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy
    public ClassLoader getPhotoPlusClassLoader(Context context) throws Exception {
        return PluginStatic.getOrCreateClassLoader(context, "Photoplus.apk");
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy
    public String getPluginID() {
        return QZONE_PLGUIN_APK;
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy
    public ClassLoader getQzoneLiveClassLoader(Context context) throws Exception {
        ClassLoader orCreateClassLoader;
        String loadQZoneLivePluginId = ((IQzonePatchApi) QRoute.api(IQzonePatchApi.class)).getLoadQZoneLivePluginId();
        if (loadQZoneLivePluginId.equals(IQzonePatchApi.LIVE_PLUGIN_ID)) {
            orCreateClassLoader = PluginStatic.getOrCreateClassLoader(context, loadQZoneLivePluginId);
        } else {
            orCreateClassLoader = loadQZoneLivePluginId.equals("qzone_live_video_plugin.apk") ? PluginStatic.getOrCreateClassLoader(context, "qzone_live_video_plugin.apk") : null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("patch", 2, "getQzoneLiveClassLoader classsloader: " + orCreateClassLoader);
        }
        return orCreateClassLoader;
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy
    public ClassLoader getQzoneVerticalVideoClassLoader(Context context) throws Exception {
        ClassLoader orCreateClassLoader = PluginStatic.getOrCreateClassLoader(context, IQzonePatchApi.VERTICAL_VIDEO_LAYER_PLUGIN_ID);
        if (QLog.isColorLevel()) {
            QLog.i("patch", 2, "getQzoneVerticalVideoClassLoader classsloader: " + orCreateClassLoader);
        }
        return orCreateClassLoader;
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy
    public ClassLoader getQzoneWeishiFeedsClassLoader(Context context) throws Exception {
        ClassLoader orCreateClassLoader = PluginStatic.getOrCreateClassLoader(context, IQzonePatchApi.WEISHI_FEEDS_PLUGIN_ID);
        if (QLog.isColorLevel()) {
            QLog.i("patch", 2, "getQzoneWeishiFeedsClassLoader classsloader: " + orCreateClassLoader);
        }
        return orCreateClassLoader;
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy
    public void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16, com.tencent.mobileqq.hitrate.b bVar, boolean z17) {
        openActivityForResult(context, str, intent, i3, onDismissListener, z16, bVar, z17);
    }

    private static void openActivityForResult(Activity activity, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16, com.tencent.mobileqq.hitrate.b bVar) {
        openActivityForResult(activity, str, intent, i3, onDismissListener, z16, bVar, false);
    }
}
