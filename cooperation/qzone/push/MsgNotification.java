package cooperation.qzone.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.message.newmsg.a;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.IQCircleNotificationReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.NotificationClickReceiver;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.util.BadgeUtils;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleNativeSessionGenerator;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Collections;
import mqq.app.AppRuntime;
import wy2.d;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MsgNotification {
    public static final String QCIRCLE_UNREADCOUND = "qzone_unreadcount";
    public static final int RING_TYPE_MSG_SOUND = 1;
    public static final int RING_TYPE_NO_SOUND = 0;
    public static final int RING_TYPE_SYSTEM_SOUND = 2;
    public static final String TAG = "MsgNotification";
    private static final String UNITED_USE_ACTIVITY_JUMP = "101530";
    private static MsgNotification manager;

    MsgNotification() {
    }

    public static void cleanQCirclePush() {
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COM);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCIE_LIKE);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_SECRET);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_PUSH);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN);
        }
        clearQCircleUnreadCount();
    }

    public static void clearQCircleUnreadCount() {
        LocalMultiProcConfig.putInt("qzone_unreadcount3000532", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000533", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000534", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000535", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000536", 0);
    }

    public static Intent getClickIntent(Context context) {
        if (useActivityJump()) {
            Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse("mqqapi://qzone/qzone_push"));
            intent.addFlags(268435456);
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setClass(context, NotificationClickReceiver.class);
        return intent2;
    }

    public static MsgNotification getInstance() {
        if (manager == null) {
            manager = new MsgNotification();
        }
        return manager;
    }

    private Intent getMyFeedIntent() {
        Intent passiveIntent = ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getPassiveIntent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("FromNotification", true);
        passiveIntent.putExtras(bundle);
        passiveIntent.addFlags(67108864);
        passiveIntent.putExtra(ISchemeApi.KEY_IOS_SRC_TYPE, "app");
        passiveIntent.putExtra("isFromQQ", "true");
        passiveIntent.putExtra("page", "tab_remind");
        passiveIntent.putExtra("version", "1");
        return passiveIntent;
    }

    public static PendingIntent getPendingIntent(Context context, int i3, Intent intent) {
        if (useActivityJump()) {
            return PendingIntent.getActivity(context, i3, intent, 201326592);
        }
        return PendingIntent.getBroadcast(context, i3, intent, 201326592);
    }

    private Intent getQZoneDetailIntent(Context context, String str) {
        return ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZoneDetailIntent(context, str);
    }

    private String getTitle(String str, int i3) {
        String string;
        if (TextUtils.isEmpty(str)) {
            str = BaseApplication.getContext().getString(R.string.wn7);
        }
        if (i3 == 0) {
            return str;
        }
        int unreadCount = getUnreadCount(i3);
        if (unreadCount <= 1) {
            return str;
        }
        if (i3 == 3000532) {
            string = BaseApplication.getContext().getString(R.string.f237247gj);
        } else if (i3 == 3000533) {
            string = BaseApplication.getContext().getString(R.string.f237257gk);
        } else if (i3 == 3000534) {
            string = BaseApplication.getContext().getString(R.string.f237267gl);
        } else if (i3 == 3000535) {
            string = BaseApplication.getContext().getString(R.string.f237277gm);
        } else {
            return str;
        }
        return str + "(" + BaseApplication.getContext().getString(R.string.f171027bt3) + unreadCount + BaseApplication.getContext().getString(R.string.hqp) + string + ")";
    }

    private Intent getTranslucentActivity(QQAppInterface qQAppInterface, String str) {
        Intent intent = new Intent();
        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY);
        intent.setAction(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
        intent.putExtra("cmd", "Schema");
        intent.putExtra(QZoneDTLoginReporter.SCHEMA, str);
        return intent;
    }

    private int getUnreadCount(int i3) {
        int i16 = LocalMultiProcConfig.getInt("qzone_unreadcount" + i3, 0) + 1;
        LocalMultiProcConfig.putInt("qzone_unreadcount" + i3, i16);
        return i16;
    }

    private Intent getUserHomeIntent(QQAppInterface qQAppInterface, String str) {
        return ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZoneDetailIntent(qQAppInterface.getApplicationContext(), str);
    }

    private Intent getVipReminderIntent(QQAppInterface qQAppInterface) {
        Intent qzoneFriendFeedActivity = QZoneHelper.getQzoneFriendFeedActivity(qQAppInterface.getApp());
        qzoneFriendFeedActivity.putExtra("qzone_uin", qQAppInterface.getAccount());
        Bundle bundle = new Bundle();
        bundle.putBoolean("FromNotification", true);
        qzoneFriendFeedActivity.putExtras(bundle);
        qzoneFriendFeedActivity.addFlags(67108864);
        qzoneFriendFeedActivity.putExtra("vipReminderFlag", true);
        return qzoneFriendFeedActivity;
    }

    public static boolean handle(Context context, Intent intent) {
        if (intent.getParcelableExtra("realIntent") != null) {
            new NotificationClickReceiver().onReceive(context, intent);
            return true;
        }
        return false;
    }

    private boolean isGetFeedAlertAfterPushValuable() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MOMENT_PUSH_GET_UNDEALCOUNT_SWITCH, 1) == 1) {
            return true;
        }
        return false;
    }

    private void playSound(int i3, QQAppInterface qQAppInterface) {
        if (qQAppInterface != null && i3 != 0) {
            try {
                qQAppInterface.vibratorAndAudio();
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pushArriveReport(QQAppInterface qQAppInterface, String str, String str2, boolean z16) {
        String str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (TextUtils.isEmpty(parse.getQueryParameter("from"))) {
                if (parse.getPathSegments().size() > 0) {
                    str3 = parse.getPathSegments().get(0);
                }
            } else {
                str3 = parse.getQueryParameter("from");
            }
            if (!z16) {
                LpReportInfo_dc00420.report(10, 0, str3, str2, 1);
            } else {
                LpReportInfo_dc00420.report(2, 0, str3, str2, 1);
            }
            if (!QLog.isColorLevel()) {
                QLog.d("pushReport", 2, "EXPOSE: uin: " + qQAppInterface.getAccount() + " schema: " + str + " pushstatkey: " + str2 + " fake:" + z16);
                return;
            }
            return;
        }
        str3 = "";
        if (!z16) {
        }
        if (!QLog.isColorLevel()) {
        }
    }

    private int pushTypeConvertToNotifyId(int i3, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        if (i3 != 300) {
                            if (i3 != 366) {
                                return 0;
                            }
                            if (i16 != 1) {
                                if (i16 != 2) {
                                    if (i16 != 3) {
                                        if (i16 != 4) {
                                            return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN;
                                        }
                                        return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_PUSH;
                                    }
                                    return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_SECRET;
                                }
                                return NotificationUtil.Constants.NOTIFY_ID_QCIRCIE_LIKE;
                            }
                            return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COM;
                        }
                    } else {
                        return 243;
                    }
                } else {
                    return 242;
                }
            } else {
                return 244;
            }
        }
        return 241;
    }

    private static boolean useActivityJump() {
        if (Build.VERSION.SDK_INT >= 31 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(UNITED_USE_ACTIVITY_JUMP, true)) {
            return true;
        }
        return false;
    }

    private Intent wrapPluginIntent(QQAppInterface qQAppInterface, Intent intent) {
        Intent intent2 = new Intent(qQAppInterface.getApp(), (Class<?>) TranslucentActivity.class);
        intent2.addFlags(268435456);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        return intent2;
    }

    public void showNewLocalPhotoNotification(Context context, String str, String str2, String str3) {
        Bitmap bitmap;
        Notification buildNotification;
        Intent intent = new Intent();
        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY);
        intent.setAction(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
        intent.putExtra("cmd", "Schema");
        intent.putExtra(QZoneDTLoginReporter.SCHEMA, str3);
        Intent intent2 = new Intent(context, (Class<?>) TranslucentActivity.class);
        intent2.addFlags(268435456);
        intent2.putExtras(intent);
        intent2.putExtra(QQNotificationManager.PARAM_NOTIFYID, 245);
        PendingIntent activity = PendingIntent.getActivity(context, 245, intent2, 201326592);
        try {
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.f162289ga1);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Exception:" + e16.toString());
            }
            bitmap = null;
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            try {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_width);
                int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_height);
                if (dimensionPixelSize != bitmap2.getWidth() || dimensionPixelSize2 != bitmap2.getHeight()) {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap2, dimensionPixelSize, dimensionPixelSize2, false);
                }
            } catch (Throwable th5) {
                try {
                    bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.g98);
                    QLog.e(TAG, 1, "use small icon ,exp:", th5);
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "Exception:" + e17.toString());
                    }
                }
            }
        }
        if (!d.f446755e) {
            buildNotification = QZoneNotificationAdapter.getInstance().newNotificationForMz(activity, context, bitmap2, str, str2, R.drawable.fuc);
        } else if ("oppo".equalsIgnoreCase(ah.D())) {
            buildNotification = QZoneNotificationAdapter.getInstance().newNotificationForOppo(activity, context, bitmap2, str, str2, R.drawable.fuc);
        } else {
            buildNotification = QZoneNotificationAdapter.getInstance().buildNotification(activity, context, bitmap2, str, str2, R.drawable.fuc);
        }
        BadgeUtils.p(context, 0, buildNotification);
        try {
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            if (qQNotificationManager != null) {
                qQNotificationManager.notify("MsgNotification.showQZoneMsgNotification", 245, buildNotification);
            }
        } catch (Exception e18) {
            QLog.e(TAG, 1, "MsgNotification.showQZoneMsgNotification notify exception ", e18);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:192:0x023c, code lost:
    
        if (r5 <= 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0440 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x048f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0330  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showQZoneMsgNotification(QQAppInterface qQAppInterface, int i3, String str, String str2, String str3, String str4, boolean z16, int i16, String str5, String str6, boolean z17, boolean z18, int i17, String str7, String str8) {
        String str9;
        AppRuntime.Status status;
        String str10;
        Intent wrapPluginIntent;
        int i18;
        String str11;
        int i19;
        int i26;
        String string;
        String str12;
        int i27;
        String str13;
        Bitmap bitmap;
        Bitmap bitmap2;
        int i28;
        Notification buildNotification;
        boolean z19;
        Intent wrapPluginIntent2;
        char c16;
        boolean z26;
        Uri parse;
        String queryParameter;
        Intent wrapPluginIntent3;
        String str14 = str5;
        if (qQAppInterface == null) {
            return;
        }
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) qQAppInterface.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
        if (onlineStatus != AppRuntime.Status.dnd) {
            playSound(i3, qQAppInterface);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showQZoneMsgNotification, dnd shield sound");
        }
        if (FriendsStatusUtil.c(qQAppInterface.getApp())) {
            return;
        }
        playSound(i3, qQAppInterface);
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        int i29 = 1;
        if (i16 != 1) {
            if (i16 == 2) {
                str9 = TAG;
                status = onlineStatus;
                str10 = "Exception:";
                wrapPluginIntent = getQZoneDetailIntent(qQAppInterface.getApplicationContext(), str14);
            } else if (i16 == 4) {
                try {
                    wrapPluginIntent = getTranslucentActivity(qQAppInterface, str14);
                    try {
                        wrapPluginIntent2 = wrapPluginIntent(qQAppInterface, wrapPluginIntent);
                        if (z17) {
                            try {
                                QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
                                reportInfo.actionType = String.valueOf(322);
                                c16 = 2;
                                try {
                                    reportInfo.subactionType = String.valueOf(2);
                                    reportInfo.reserves = String.valueOf(6);
                                    z26 = true;
                                    QZoneClickReport.report(qQAppInterface.getAccount(), reportInfo, true);
                                } catch (Exception e16) {
                                    e = e16;
                                    str9 = TAG;
                                    status = onlineStatus;
                                    str10 = "Exception:";
                                    wrapPluginIntent = wrapPluginIntent2;
                                    QLog.e(str9, 2, "QZONE_PUSH_TYPE_LIVE error", e);
                                    i18 = i17;
                                    str11 = "";
                                    i29 = 1;
                                    int pushTypeConvertToNotifyId = pushTypeConvertToNotifyId(i16, i18);
                                    Intent clickIntent = getClickIntent(qQAppInterface.getApp());
                                    clickIntent.putExtra("realIntent", wrapPluginIntent);
                                    clickIntent.putExtra("hostuin", qQAppInterface.getAccount());
                                    clickIntent.putExtra("pushschema", str14);
                                    clickIntent.putExtra("pushstatkey", str6);
                                    clickIntent.putExtra("pushType", i16);
                                    clickIntent.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId);
                                    PendingIntent pendingIntent = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId, clickIntent);
                                    if (i16 == 366) {
                                    }
                                    if (i16 == i19) {
                                    }
                                    i28 = R.drawable.fuc;
                                    if (d.f446755e) {
                                    }
                                    if (i16 != 1) {
                                    }
                                    Intent intent = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                                    intent.setPackage(BaseApplication.getContext().getPackageName());
                                    intent.putExtra("pushstatkey", str6);
                                    intent.putExtra("mergenum", i29);
                                    intent.putExtra("pushtype", i16);
                                    buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId, intent, 201326592);
                                    BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                                    if (status != AppRuntime.Status.dnd) {
                                    }
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str9 = TAG;
                                status = onlineStatus;
                                str10 = "Exception:";
                                wrapPluginIntent = wrapPluginIntent2;
                                QLog.e(str9, 2, "QZONE_PUSH_TYPE_LIVE error", e);
                                i18 = i17;
                                str11 = "";
                                i29 = 1;
                                int pushTypeConvertToNotifyId2 = pushTypeConvertToNotifyId(i16, i18);
                                Intent clickIntent2 = getClickIntent(qQAppInterface.getApp());
                                clickIntent2.putExtra("realIntent", wrapPluginIntent);
                                clickIntent2.putExtra("hostuin", qQAppInterface.getAccount());
                                clickIntent2.putExtra("pushschema", str14);
                                clickIntent2.putExtra("pushstatkey", str6);
                                clickIntent2.putExtra("pushType", i16);
                                clickIntent2.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId2);
                                PendingIntent pendingIntent2 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId2, clickIntent2);
                                if (i16 == 366) {
                                }
                                if (i16 == i19) {
                                }
                                i28 = R.drawable.fuc;
                                if (d.f446755e) {
                                }
                                if (i16 != 1) {
                                }
                                Intent intent2 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                                intent2.setPackage(BaseApplication.getContext().getPackageName());
                                intent2.putExtra("pushstatkey", str6);
                                intent2.putExtra("mergenum", i29);
                                intent2.putExtra("pushtype", i16);
                                buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId2, intent2, 201326592);
                                BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                                if (status != AppRuntime.Status.dnd) {
                                }
                            }
                        } else {
                            z26 = true;
                            c16 = 2;
                        }
                        parse = Uri.parse(str5);
                        queryParameter = parse.getQueryParameter("room");
                        str9 = TAG;
                        status = onlineStatus;
                        str10 = "Exception:";
                    } catch (Exception e18) {
                        e = e18;
                        str9 = TAG;
                        status = onlineStatus;
                        str10 = "Exception:";
                    }
                } catch (Exception e19) {
                    e = e19;
                    str9 = TAG;
                    status = onlineStatus;
                    str10 = "Exception:";
                    wrapPluginIntent = null;
                }
                try {
                    QzNotificationStruct qzNotificationStruct = new QzNotificationStruct(queryParameter, str2, z16, i16, str5, str6);
                    if (com.tencent.mobileqq.servlet.d.f286467f == null) {
                        com.tencent.mobileqq.servlet.d.f286467f = Collections.synchronizedList(new ArrayList());
                    }
                    if (z17) {
                        com.tencent.mobileqq.servlet.d.f286467f.add(qzNotificationStruct);
                        try {
                            LpReportInfo_dc01245.report(Long.parseLong(parse.getQueryParameter("uin")), Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount()), 11, 0);
                        } catch (Exception e26) {
                            QLog.e(str9, 1, e26.getStackTrace());
                        }
                    }
                    i18 = i17;
                    wrapPluginIntent = wrapPluginIntent2;
                } catch (Exception e27) {
                    e = e27;
                    wrapPluginIntent = wrapPluginIntent2;
                    QLog.e(str9, 2, "QZONE_PUSH_TYPE_LIVE error", e);
                    i18 = i17;
                    str11 = "";
                    i29 = 1;
                    int pushTypeConvertToNotifyId22 = pushTypeConvertToNotifyId(i16, i18);
                    Intent clickIntent22 = getClickIntent(qQAppInterface.getApp());
                    clickIntent22.putExtra("realIntent", wrapPluginIntent);
                    clickIntent22.putExtra("hostuin", qQAppInterface.getAccount());
                    clickIntent22.putExtra("pushschema", str14);
                    clickIntent22.putExtra("pushstatkey", str6);
                    clickIntent22.putExtra("pushType", i16);
                    clickIntent22.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId22);
                    PendingIntent pendingIntent22 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId22, clickIntent22);
                    if (i16 == 366) {
                    }
                    if (i16 == i19) {
                    }
                    i28 = R.drawable.fuc;
                    if (d.f446755e) {
                    }
                    if (i16 != 1) {
                    }
                    Intent intent22 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                    intent22.setPackage(BaseApplication.getContext().getPackageName());
                    intent22.putExtra("pushstatkey", str6);
                    intent22.putExtra("mergenum", i29);
                    intent22.putExtra("pushtype", i16);
                    buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId22, intent22, 201326592);
                    BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                    if (status != AppRuntime.Status.dnd) {
                    }
                }
                str11 = "";
                i29 = 1;
                int pushTypeConvertToNotifyId222 = pushTypeConvertToNotifyId(i16, i18);
                Intent clickIntent222 = getClickIntent(qQAppInterface.getApp());
                clickIntent222.putExtra("realIntent", wrapPluginIntent);
                clickIntent222.putExtra("hostuin", qQAppInterface.getAccount());
                clickIntent222.putExtra("pushschema", str14);
                clickIntent222.putExtra("pushstatkey", str6);
                clickIntent222.putExtra("pushType", i16);
                clickIntent222.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId222);
                PendingIntent pendingIntent222 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId222, clickIntent222);
                if (i16 == 366) {
                }
                if (i16 == i19) {
                }
                i28 = R.drawable.fuc;
                if (d.f446755e) {
                }
                if (i16 != 1) {
                }
                Intent intent222 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                intent222.setPackage(BaseApplication.getContext().getPackageName());
                intent222.putExtra("pushstatkey", str6);
                intent222.putExtra("mergenum", i29);
                intent222.putExtra("pushtype", i16);
                buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId222, intent222, 201326592);
                BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                if (status != AppRuntime.Status.dnd) {
                }
            } else {
                if (i16 == 8) {
                    if (str14 != null && str14.startsWith("mqzonev2://arouse/openhomepage")) {
                        try {
                            wrapPluginIntent = getUserHomeIntent(qQAppInterface, Uri.parse(str5).getQueryParameter("uin"));
                            try {
                                wrapPluginIntent3 = wrapPluginIntent(qQAppInterface, wrapPluginIntent);
                            } catch (Exception e28) {
                                e = e28;
                                QLog.e(TAG, 2, "QZONE_PUSH_TYPE_SCHEMA error", e);
                                str9 = TAG;
                                status = onlineStatus;
                                str10 = "Exception:";
                                str11 = "";
                                i29 = 1;
                                i18 = i17;
                                int pushTypeConvertToNotifyId2222 = pushTypeConvertToNotifyId(i16, i18);
                                Intent clickIntent2222 = getClickIntent(qQAppInterface.getApp());
                                clickIntent2222.putExtra("realIntent", wrapPluginIntent);
                                clickIntent2222.putExtra("hostuin", qQAppInterface.getAccount());
                                clickIntent2222.putExtra("pushschema", str14);
                                clickIntent2222.putExtra("pushstatkey", str6);
                                clickIntent2222.putExtra("pushType", i16);
                                clickIntent2222.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId2222);
                                PendingIntent pendingIntent2222 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId2222, clickIntent2222);
                                if (i16 == 366) {
                                }
                                if (i16 == i19) {
                                }
                                i28 = R.drawable.fuc;
                                if (d.f446755e) {
                                }
                                if (i16 != 1) {
                                }
                                Intent intent2222 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                                intent2222.setPackage(BaseApplication.getContext().getPackageName());
                                intent2222.putExtra("pushstatkey", str6);
                                intent2222.putExtra("mergenum", i29);
                                intent2222.putExtra("pushtype", i16);
                                buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId2222, intent2222, 201326592);
                                BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                                if (status != AppRuntime.Status.dnd) {
                                }
                            }
                        } catch (Exception e29) {
                            e = e29;
                            wrapPluginIntent = null;
                        }
                    } else {
                        if (isGetFeedAlertAfterPushValuable()) {
                            QZoneNotifyServlet.m(4);
                        }
                        wrapPluginIntent3 = wrapPluginIntent(qQAppInterface, getTranslucentActivity(qQAppInterface, str14));
                    }
                    wrapPluginIntent = wrapPluginIntent3;
                    str9 = TAG;
                    status = onlineStatus;
                    str10 = "Exception:";
                    str11 = "";
                    i29 = 1;
                } else if (i16 != 300) {
                    if (i16 != 366) {
                        str9 = TAG;
                        status = onlineStatus;
                        str10 = "Exception:";
                        str11 = "";
                        wrapPluginIntent = null;
                    } else {
                        String generateShortSession = QCircleNativeSessionGenerator.generateShortSession();
                        String str15 = str14 + ContainerUtils.FIELD_DELIMITER + QCircleSchemeAttr.BaseKey.XSJ_SHORT_SESSION_ID + ContainerUtils.KEY_VALUE_DELIMITER + generateShortSession;
                        QLog.e(TAG, 1, "showQZoneMsgNotification, actionUrl=" + str15);
                        Intent intent3 = new Intent();
                        intent3.putExtra("type", 2);
                        intent3.putExtra("push_id", str7);
                        intent3.putExtra(ServiceConst.PARA_SESSION_ID, generateShortSession);
                        intent3.putExtra(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, str8);
                        str14 = str15;
                        wrapPluginIntent = intent3;
                        str9 = TAG;
                        status = onlineStatus;
                        str10 = "Exception:";
                        i29 = 1;
                        i18 = i17;
                        str11 = generateShortSession;
                        int pushTypeConvertToNotifyId22222 = pushTypeConvertToNotifyId(i16, i18);
                        Intent clickIntent22222 = getClickIntent(qQAppInterface.getApp());
                        clickIntent22222.putExtra("realIntent", wrapPluginIntent);
                        clickIntent22222.putExtra("hostuin", qQAppInterface.getAccount());
                        clickIntent22222.putExtra("pushschema", str14);
                        clickIntent22222.putExtra("pushstatkey", str6);
                        clickIntent22222.putExtra("pushType", i16);
                        clickIntent22222.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId22222);
                        PendingIntent pendingIntent22222 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId22222, clickIntent22222);
                        if (i16 == 366) {
                            str12 = getTitle(str, pushTypeConvertToNotifyId22222);
                            i26 = 2;
                            i19 = 8;
                        } else {
                            i19 = 8;
                            if (TextUtils.isEmpty(str) || i16 != 8) {
                                if (z16) {
                                    i26 = 2;
                                    if (i16 != 2 && i16 != 8 && i16 != 4) {
                                        string = BaseApplication.getContext().getString(R.string.h56) + "(" + BaseApplication.getContext().getString(R.string.f171027bt3) + i29 + BaseApplication.getContext().getString(R.string.hqp) + BaseApplication.getContext().getString(R.string.iai) + ")";
                                    } else {
                                        string = BaseApplication.getContext().getString(R.string.h56);
                                    }
                                } else {
                                    i26 = 2;
                                    string = BaseApplication.getContext().getString(R.string.h56);
                                }
                                str12 = string;
                            } else {
                                str12 = str;
                                i26 = 2;
                            }
                        }
                        if (i16 == i19) {
                            a d16 = a.d(qQAppInterface);
                            i27 = i26;
                            bitmap2 = d16.j(str3, str4) ? d16.c(str3, str4, null) : null;
                        } else {
                            i27 = i26;
                            if (i16 == 366) {
                                Bitmap g16 = j.g(qQAppInterface.getApp().getResources(), R.drawable.f162072os2);
                                a d17 = a.d(qQAppInterface);
                                if (d17.j(str3, str4)) {
                                    g16 = d17.c(str3, str4, g16);
                                }
                                bitmap2 = g16;
                                i28 = R.drawable.b8g;
                                if (d.f446755e) {
                                    buildNotification = QZoneNotificationAdapter.getInstance().newNotificationForMz(pendingIntent22222, qQAppInterface.getApp(), bitmap2, str12, str2, i28);
                                } else if ("oppo".equalsIgnoreCase(ah.D())) {
                                    buildNotification = QZoneNotificationAdapter.getInstance().newNotificationForOppo(pendingIntent22222, qQAppInterface.getApp(), bitmap2, str12, str2, i28);
                                } else {
                                    buildNotification = QZoneNotificationAdapter.getInstance().buildNotification(pendingIntent22222, qQAppInterface.getApp(), bitmap2, str12, str2, i28);
                                }
                                if (i16 != 1 || i16 == i27 || i16 == 300) {
                                    Intent intent22222 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                                    intent22222.setPackage(BaseApplication.getContext().getPackageName());
                                    intent22222.putExtra("pushstatkey", str6);
                                    intent22222.putExtra("mergenum", i29);
                                    intent22222.putExtra("pushtype", i16);
                                    buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId22222, intent22222, 201326592);
                                }
                                BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                                if (status != AppRuntime.Status.dnd) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(str9, i27, "showQZoneMsgNotification, dnd shield hide notify");
                                        return;
                                    }
                                    return;
                                }
                                try {
                                } catch (Exception e36) {
                                    QLog.e(str9, 1, "MsgNotification.showQZoneMsgNotification notify exception ", e36);
                                }
                                if (z18) {
                                    pushArriveReport(qQAppInterface, str14, str6, true);
                                    return;
                                }
                                QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                                if (qQNotificationManager != null) {
                                    qQNotificationManager.notify("MsgNotification.showQZoneMsgNotification", pushTypeConvertToNotifyId22222, buildNotification);
                                }
                                QZoneHelper.preloadQzone(qQAppInterface, getClass().getSimpleName());
                                GuardManager guardManager = GuardManager.sInstance;
                                if (guardManager != null) {
                                    z19 = false;
                                    guardManager.onEvent(0, null);
                                } else {
                                    z19 = false;
                                }
                                if (z17) {
                                    pushArriveReport(qQAppInterface, str14, str6, z19);
                                }
                                if (i16 == 366) {
                                    ((IQCircleNotificationReporter) QRoute.api(IQCircleNotificationReporter.class)).reportExposure(str7, str11, str8);
                                    return;
                                }
                                return;
                            }
                            try {
                                bitmap = BitmapFactory.decodeResource(qQAppInterface.getApp().getResources(), R.drawable.f162289ga1);
                                str13 = str10;
                            } catch (OutOfMemoryError e37) {
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    str13 = str10;
                                    sb5.append(str13);
                                    sb5.append(e37.toString());
                                    QLog.e(str9, i27, sb5.toString());
                                } else {
                                    str13 = str10;
                                }
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                try {
                                    int dimensionPixelSize = qQAppInterface.getApp().getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_width);
                                    int dimensionPixelSize2 = qQAppInterface.getApp().getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_height);
                                    if (dimensionPixelSize != bitmap.getWidth() || dimensionPixelSize2 != bitmap.getHeight()) {
                                        bitmap = Bitmap.createScaledBitmap(bitmap, dimensionPixelSize, dimensionPixelSize2, false);
                                    }
                                } catch (Throwable th5) {
                                    try {
                                        bitmap = BitmapFactory.decodeResource(qQAppInterface.getApp().getResources(), R.drawable.g98);
                                        QLog.e(str9, 1, "use small icon ,exp:", th5);
                                    } catch (OutOfMemoryError e38) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e(str9, i27, str13 + e38.toString());
                                        }
                                    }
                                }
                            }
                            bitmap2 = bitmap;
                        }
                        i28 = R.drawable.fuc;
                        if (d.f446755e) {
                        }
                        if (i16 != 1) {
                        }
                        Intent intent222222 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                        intent222222.setPackage(BaseApplication.getContext().getPackageName());
                        intent222222.putExtra("pushstatkey", str6);
                        intent222222.putExtra("mergenum", i29);
                        intent222222.putExtra("pushtype", i16);
                        buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId22222, intent222222, 201326592);
                        BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                        if (status != AppRuntime.Status.dnd) {
                        }
                    }
                }
                i18 = i17;
                int pushTypeConvertToNotifyId222222 = pushTypeConvertToNotifyId(i16, i18);
                Intent clickIntent222222 = getClickIntent(qQAppInterface.getApp());
                clickIntent222222.putExtra("realIntent", wrapPluginIntent);
                clickIntent222222.putExtra("hostuin", qQAppInterface.getAccount());
                clickIntent222222.putExtra("pushschema", str14);
                clickIntent222222.putExtra("pushstatkey", str6);
                clickIntent222222.putExtra("pushType", i16);
                clickIntent222222.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId222222);
                PendingIntent pendingIntent222222 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId222222, clickIntent222222);
                if (i16 == 366) {
                }
                if (i16 == i19) {
                }
                i28 = R.drawable.fuc;
                if (d.f446755e) {
                }
                if (i16 != 1) {
                }
                Intent intent2222222 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                intent2222222.setPackage(BaseApplication.getContext().getPackageName());
                intent2222222.putExtra("pushstatkey", str6);
                intent2222222.putExtra("mergenum", i29);
                intent2222222.putExtra("pushtype", i16);
                buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId222222, intent2222222, 201326592);
                BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
                if (status != AppRuntime.Status.dnd) {
                }
            }
            i18 = i17;
            str11 = "";
            i29 = 1;
            int pushTypeConvertToNotifyId2222222 = pushTypeConvertToNotifyId(i16, i18);
            Intent clickIntent2222222 = getClickIntent(qQAppInterface.getApp());
            clickIntent2222222.putExtra("realIntent", wrapPluginIntent);
            clickIntent2222222.putExtra("hostuin", qQAppInterface.getAccount());
            clickIntent2222222.putExtra("pushschema", str14);
            clickIntent2222222.putExtra("pushstatkey", str6);
            clickIntent2222222.putExtra("pushType", i16);
            clickIntent2222222.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId2222222);
            PendingIntent pendingIntent2222222 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId2222222, clickIntent2222222);
            if (i16 == 366) {
            }
            if (i16 == i19) {
            }
            i28 = R.drawable.fuc;
            if (d.f446755e) {
            }
            if (i16 != 1) {
            }
            Intent intent22222222 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
            intent22222222.setPackage(BaseApplication.getContext().getPackageName());
            intent22222222.putExtra("pushstatkey", str6);
            intent22222222.putExtra("mergenum", i29);
            intent22222222.putExtra("pushtype", i16);
            buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId2222222, intent22222222, 201326592);
            BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
            if (status != AppRuntime.Status.dnd) {
            }
        }
        str9 = TAG;
        status = onlineStatus;
        str10 = "Exception:";
        Intent myFeedIntent = getMyFeedIntent();
        myFeedIntent.putExtra(QZoneHelper.Constants.KEY_LAUNCH_TIME, System.currentTimeMillis());
        myFeedIntent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_MSG_NOTIFICATION);
        myFeedIntent.putExtra(FlingConstant.FLING_ACTION_KEY, 2);
        myFeedIntent.putExtra(FlingConstant.FLING_CODE_KEY, hashCode());
        wrapPluginIntent = wrapPluginIntent(qQAppInterface, myFeedIntent);
        if (qZoneManagerImp != null) {
            i29 = qZoneManagerImp.j(1);
            qZoneManagerImp.x(1, i29);
            i18 = i17;
        } else {
            i18 = i17;
        }
        i29 = 1;
        str11 = "";
        int pushTypeConvertToNotifyId22222222 = pushTypeConvertToNotifyId(i16, i18);
        Intent clickIntent22222222 = getClickIntent(qQAppInterface.getApp());
        clickIntent22222222.putExtra("realIntent", wrapPluginIntent);
        clickIntent22222222.putExtra("hostuin", qQAppInterface.getAccount());
        clickIntent22222222.putExtra("pushschema", str14);
        clickIntent22222222.putExtra("pushstatkey", str6);
        clickIntent22222222.putExtra("pushType", i16);
        clickIntent22222222.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushTypeConvertToNotifyId22222222);
        PendingIntent pendingIntent22222222 = getPendingIntent(qQAppInterface.getApp(), pushTypeConvertToNotifyId22222222, clickIntent22222222);
        if (i16 == 366) {
        }
        if (i16 == i19) {
        }
        i28 = R.drawable.fuc;
        if (d.f446755e) {
        }
        if (i16 != 1) {
        }
        Intent intent222222222 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
        intent222222222.setPackage(BaseApplication.getContext().getPackageName());
        intent222222222.putExtra("pushstatkey", str6);
        intent222222222.putExtra("mergenum", i29);
        intent222222222.putExtra("pushtype", i16);
        buildNotification.deleteIntent = PendingIntent.getBroadcast(qQAppInterface.getApp(), pushTypeConvertToNotifyId22222222, intent222222222, 201326592);
        BadgeUtils.p(qQAppInterface.getApp(), 0, buildNotification);
        if (status != AppRuntime.Status.dnd) {
        }
    }

    public void updateUnreadcount(int i3, int i16) {
        int pushTypeConvertToNotifyId = pushTypeConvertToNotifyId(i3, i16);
        LocalMultiProcConfig.putInt("qzone_unreadcount" + pushTypeConvertToNotifyId, LocalMultiProcConfig.getInt("qzone_unreadcount" + pushTypeConvertToNotifyId, 0) + 1);
    }
}
