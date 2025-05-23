package com.tencent.mobileqq.servlet;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.push.MiniAppControlInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecommon.processor.QZoneSwitchProcessor;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc010001DataBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneEnvApi;
import com.tencent.qzonehub.api.IQZonePushApi;
import com.tencent.qzonehub.api.IQzoneMixApi;
import com.tencent.qzonehub.api.IQzoneReq;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.push.MsgNotification;
import cooperation.qzone.push.QzNotificationStruct;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends MSFServlet implements WebEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f286465d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile HashMap<Integer, com.tencent.mobileqq.servlet.model.a> f286466e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile List<QzNotificationStruct> f286467f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f286465d = new String[]{BaseConstants.CMD_MSF_NOTIFYRESP, "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone"};
            f286466e = new HashMap<>();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(int i3) {
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        if (qQAppInterface == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("resultcode", String.valueOf(i3));
        hashMap.put("time", String.valueOf(System.currentTimeMillis()));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getAccount(), StatisticCollector.CALL_QZONE_PUSH, true, 0L, 0L, hashMap, (String) null, true);
    }

    private boolean c(QQAppInterface qQAppInterface, int i3) {
        if (i3 == 10000 || i3 == 10) {
            return false;
        }
        if (8 == i3 || 4 == i3 || 366 == i3 || i3 == 2) {
            return true;
        }
        if ((i3 != 1 && i3 != 300) || QZoneSwitchProcessor.a(qQAppInterface.getAccount()) <= 0) {
            return false;
        }
        return true;
    }

    private boolean d(com.tencent.mobileqq.servlet.model.a aVar) {
        Map<String, String> map;
        boolean z16;
        String str;
        boolean z17;
        if (aVar != null && (map = aVar.f286488b) != null) {
            int parseInt = Integer.parseInt(map.get("pushtype"));
            QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
            if (parseInt == 301) {
                if (f286467f != null && f286467f.size() > 0 && (str = aVar.f286488b.get("live_roomid")) != null) {
                    QzNotificationStruct qzNotificationStruct = f286467f.get(f286467f.size() - 1);
                    if (qzNotificationStruct != null && str.equals(qzNotificationStruct.roomId)) {
                        f286467f.remove(qzNotificationStruct);
                        if (f286467f.size() == 0) {
                            try {
                                QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                                if (qQNotificationManager != null) {
                                    qQNotificationManager.cancel("CliNotifyPush.clearLivePush", 242);
                                }
                            } catch (Exception unused) {
                                QLog.e("CliNotifyPush", 1, "NotificationManager cancel exception");
                            }
                        } else {
                            QzNotificationStruct qzNotificationStruct2 = f286467f.get(f286467f.size() - 1);
                            if (qzNotificationStruct2 != null) {
                                z17 = true;
                                MsgNotification.getInstance().showQZoneMsgNotification(qQAppInterface, 0, null, qzNotificationStruct2.notifyText, null, null, qzNotificationStruct2.showMsgContent, qzNotificationStruct2.pushType, qzNotificationStruct2.actionUrl, qzNotificationStruct2.pushstatkey, false, false, -1, "", "");
                            } else {
                                z17 = true;
                            }
                            z16 = z17;
                        }
                    } else {
                        z16 = true;
                        if (f286467f.size() > 1) {
                            for (int i3 = 0; i3 < f286467f.size() - 1; i3++) {
                                QzNotificationStruct qzNotificationStruct3 = f286467f.get(i3);
                                if (qzNotificationStruct3 != null && str.equals(qzNotificationStruct3.roomId)) {
                                    f286467f.remove(qzNotificationStruct3);
                                }
                            }
                        }
                    }
                    v(aVar, qQAppInterface, 16L);
                    return z16;
                }
                z16 = true;
                v(aVar, qQAppInterface, 16L);
                return z16;
            }
        }
        return false;
    }

    private void e(Map<String, String> map, String str) {
        if (map != null && !map.isEmpty()) {
            try {
                MiniAppControlInfo miniAppControlInfo = new MiniAppControlInfo();
                miniAppControlInfo.cmd = map.get("key_ctrl_cmd");
                miniAppControlInfo.data.putAll(map);
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).processControlInfo(str, miniAppControlInfo);
            } catch (Exception e16) {
                QLog.e("CliNotifyPush", 1, "decodeMiniAppCtrlPush failed:", e16);
            }
        }
    }

    private void f(Map<String, String> map, String str) {
        if (map != null && !map.isEmpty()) {
            try {
                ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).execCtrlCommand(str, Integer.parseInt(map.get("key_ctrl_cmd")), map);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void h(Map<String, String> map, String str) {
        if (map != null && !map.isEmpty()) {
            try {
                QLog.e("CliNotifyPush", 1, "decodeQzoneSilentPush");
                ((IQZonePushApi) QRoute.api(IQZonePushApi.class)).handleSilentPush(str, map);
            } catch (Exception e16) {
                QLog.e("CliNotifyPush", 1, e16, new Object[0]);
            }
        }
    }

    private void i(com.tencent.mobileqq.servlet.model.a aVar) {
        Map<String, String> map;
        QLog.e("CliNotifyPush", 1, "dispathQzonePushMsg()");
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        if (qQAppInterface != null && aVar != null && (map = aVar.f286488b) != null) {
            if (map != null && map.get("utime") != null && LocalMultiProcConfig.getInt4Uin("qzone_preget_passive_open", 0, qQAppInterface.getLongAccountUin()) == 1) {
                if (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", qQAppInterface.getLongAccountUin()).equals(aVar.f286488b.get("utime"))) {
                    aVar.f286491e = true;
                    f286466e.put(Integer.valueOf(RemoteHandleManager.getInstance().getSender().pregetPassiveFeeds(qQAppInterface.getLongAccountUin())), aVar);
                }
            }
            w(aVar);
        }
    }

    private void j(QQAppInterface qQAppInterface, com.tencent.mobileqq.servlet.model.a aVar) {
        String str;
        int i3;
        if (qQAppInterface != null && aVar != null && aVar.f286488b != null) {
            QLog.i("CliNotifyPush", 1, "handleQQCirclePush " + qQAppInterface.isBackgroundPause + ", " + qQAppInterface.isBackgroundStop);
            if (qQAppInterface.isBackgroundPause && qQAppInterface.isBackgroundStop) {
                IRedTouchServer iRedTouchServer = (IRedTouchServer) qQAppInterface.getRuntimeService(IRedTouchServer.class, "");
                QLog.i("CliNotifyPush", 1, "handleQQCirclePush sendRedpointReq");
                iRedTouchServer.sendRedpointReq(true, false, 10);
            }
            Intent intent = new Intent();
            intent.setAction("action_receive_message_push");
            BaseApplication.getContext().sendBroadcast(intent);
            QLog.e("CliNotifyPush", 1, "showQQCirclePush()");
            if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext())) {
                v(aVar, qQAppInterface, 512L);
                return;
            }
            String str2 = aVar.f286488b.get("conent");
            String str3 = aVar.f286488b.get("pushstatkey");
            String str4 = aVar.f286488b.get("shcemaUrlAnd");
            String str5 = aVar.f286488b.get("title");
            String str6 = aVar.f286488b.get("fake_push");
            String str7 = aVar.f286488b.get("icon_type");
            String str8 = aVar.f286488b.get("icon_url");
            String str9 = aVar.f286488b.get(QCircleDaTongConstant.ElementParamKey.XSJ_LOCK_PUSH_ID);
            String str10 = aVar.f286488b.get("xsj_report_info");
            if (!TextUtils.isEmpty(str10)) {
                str = new String(PluginBaseInfoHelper.Base64Helper.decode(str10, 0));
            } else {
                str = str10;
            }
            try {
                i3 = Integer.parseInt(aVar.f286488b.get("VideoCirclePushMergeType"));
            } catch (Exception e16) {
                QLog.e("CliNotifyPush", 1, e16, new Object[0]);
                i3 = 0;
            }
            if (qQAppInterface.isBackgroundPause) {
                MsgNotification.getInstance().showQZoneMsgNotification(qQAppInterface, 1, str5, str2, str7, str8, qQAppInterface.isShowMsgContent(), 366, str4, str3, true, "1".equals(str6), i3, str9, str);
                v(aVar, qQAppInterface, 4L);
                QLog.e("CliNotifyPush", 1, "show push: XXX");
            } else {
                MsgNotification.getInstance().updateUnreadcount(366, i3);
                v(aVar, qQAppInterface, 32L);
            }
        }
    }

    public static boolean k(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null) {
            return false;
        }
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        } catch (Exception unused2) {
            return false;
        }
        if (packageInfo == null) {
            return false;
        }
        return true;
    }

    public static long m(QQAppInterface qQAppInterface) {
        return n(qQAppInterface, 0);
    }

    public static long n(QQAppInterface qQAppInterface, int i3) {
        if (qQAppInterface == null) {
            return 0L;
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0);
        String account = qQAppInterface.getAccount();
        if (account == null || account.length() <= 0) {
            return 0L;
        }
        return sharedPreferences.getLong(account + ":" + i3, 0L);
    }

    private void o(SingleMsg singleMsg) {
        QLog.e("CliNotifyPush", 1, "handle eeveepush");
        if (singleMsg == null) {
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportDc010001(new QCircleLpReportDc010001DataBuilder().setActionType(500).setSubActionType(10).setThrActionType(2).setScene(1000));
            return;
        }
        QLog.d("CliNotifyPush", 1, "processEeveePush");
        String str = singleMsg.data.get("eevee_ext_info");
        String str2 = singleMsg.data.get("eevee_push_data");
        String str3 = singleMsg.data.get("pushstatkey");
        String str4 = singleMsg.data.get("pushscene");
        if (!TextUtils.isEmpty(str4)) {
            try {
                if (Integer.parseInt(str4) == 1001) {
                    ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportDc010001(new QCircleLpReportDc010001DataBuilder().setActionType(500).setSubActionType(10).setThrActionType(1).setEeveeMsgId(str3).setScene(1001));
                    com.tencent.mobileqq.activity.qcircle.utils.c.d().onSend(1001, str2, str3);
                    return;
                }
            } catch (Exception e16) {
                QLog.e("CliNotifyPush", 1, e16, new Object[0]);
            }
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportDc010001(new QCircleLpReportDc010001DataBuilder().setActionType(500).setSubActionType(10).setThrActionType(1).setEeveeMsgId(str3).setScene(1000));
        com.tencent.mobileqq.activity.qcircle.utils.c.d().onSend(1000, str, str3);
    }

    private void p(Map<String, String> map) {
        Intent intent = new Intent("com.qzone.live.MicLogic.processMicMsg");
        if (map != null && (map instanceof HashMap)) {
            intent.putExtra("mic_msg", (HashMap) map);
        }
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    private void q(QQAppInterface qQAppInterface, Map<String, String> map) {
        if (map == null) {
            QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, data is null.");
            return;
        }
        try {
            String str = map.get("maappid");
            int intValue = Integer.valueOf(map.get("reddotcount")).intValue();
            if (!TextUtils.isEmpty(str) && intValue > 0) {
                MiniAppRedDotEntity miniAppRedDotEntity = new MiniAppRedDotEntity(str, 0, intValue);
                AppletsHandler appletsHandler = (AppletsHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
                if (appletsHandler != null) {
                    appletsHandler.notifyUI(9, true, miniAppRedDotEntity);
                }
            }
        } catch (Throwable th5) {
            QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, exception: " + th5.toString());
        }
    }

    private void r(com.tencent.mobileqq.servlet.model.a aVar) {
        if (aVar == null) {
            return;
        }
        QLog.e("CliNotifyPush", 1, "recv Qzone Push: Feed\u5b9e\u65f6\u66f4\u65b0Push");
        Intent intent = new Intent("com.qzone.push_feed_update");
        byte[] bArr = aVar.f286494h;
        if (bArr != null && bArr.length > 0) {
            intent.putExtra("update_feeds_buffer", bArr);
        } else {
            Map<String, String> map = aVar.f286488b;
            if (map != null && (map instanceof HashMap)) {
                intent.putExtra("update_feeds", (HashMap) map);
            }
        }
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    private void s(int i3) {
        QLog.e("CliNotifyPush", 1, "report resultCode:" + i3);
        a(i3);
        QZoneHelper.preloadQZoneForHaboReport((QQAppInterface) getAppRuntime(), "qzonenewservice.callqzonev2", i3, "CliNotifyPush", 1, System.currentTimeMillis());
    }

    public static void t(QQAppInterface qQAppInterface, int i3, long j3) {
        if (qQAppInterface != null) {
            SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
            String account = qQAppInterface.getAccount();
            if (account != null && account.length() > 0) {
                edit.putLong(account + ":" + i3, j3);
            }
            edit.commit();
        }
    }

    public static void u(QQAppInterface qQAppInterface, long j3) {
        t(qQAppInterface, 0, j3);
    }

    public static void v(com.tencent.mobileqq.servlet.model.a aVar, QQAppInterface qQAppInterface, long j3) {
        long j16;
        long j17;
        Map<String, String> map;
        if (aVar == null) {
            return;
        }
        if (qQAppInterface != null) {
            j16 = Long.parseLong(qQAppInterface.getAccount());
        } else {
            j16 = 0;
        }
        if (aVar.f286487a != 0 && j16 != 0) {
            if (aVar.f286492f) {
                j17 = j3 | 1;
            } else {
                j17 = j3 & (-2);
            }
            j3 = j17;
            String str = aVar.f286493g;
            if ((TextUtils.isEmpty(str) || str.equals("0")) && (map = aVar.f286488b) != null) {
                str = map.get("pushstatkey");
            }
            ((IQzoneReq) QRoute.api(IQzoneReq.class)).sentPushAckServlet(aVar.f286487a, j16, str, j3);
        }
        QLog.e("CliNotifyPush", 1, "sentQzoneMsfPushAck: localTimeStamp=" + aVar.f286487a + " uin=" + LogUtil.getSafePrintUin(String.valueOf(j16)) + " flag=" + j3);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:35|(1:37)|38|(20:40|41|42|43|(1:45)|46|47|48|49|(1:51)(1:114)|(1:53)(1:113)|54|55|56|57|(1:59)(1:110)|60|(2:62|(2:64|65))(1:109)|66|(2:68|69)(2:70|(2:72|73)(2:74|(2:84|(2:86|87)(1:(7:89|(1:91)|92|(1:106)(1:96)|(3:98|(1:100)(1:104)|101)(1:105)|102|103)(2:107|108)))(2:82|83))))(1:120)|119|47|48|49|(0)(0)|(0)(0)|54|55|56|57|(0)(0)|60|(0)(0)|66|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x022a, code lost:
    
        r13 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0184, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0293  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w(com.tencent.mobileqq.servlet.model.a aVar) {
        String str;
        String str2;
        int i3;
        int i16;
        String str3;
        String str4;
        int i17;
        boolean z16;
        String str5;
        int i18;
        String str6;
        boolean z17;
        String str7;
        String str8;
        int i19;
        QLog.e("CliNotifyPush", 1, "showPush()");
        if (aVar != null && aVar.f286488b != null) {
            if (aVar.f286491e && (i19 = aVar.f286490d) == 0) {
                aVar.f286490d = i19 + 1;
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
            int parseInt = Integer.parseInt(aVar.f286488b.get("pushtype"));
            QLog.e("CliNotifyPush", 1, "pushType:" + parseInt);
            if (parseInt == 10) {
                h(aVar.f286488b, qQAppInterface.getAccount());
                v(aVar, qQAppInterface, 16L);
                return;
            }
            if (parseInt == 10000) {
                f(aVar.f286488b, qQAppInterface.getAccount());
                v(aVar, qQAppInterface, 16L);
                return;
            }
            if (parseInt == 10100) {
                e(aVar.f286488b, qQAppInterface.getAccount());
                v(aVar, qQAppInterface, 16L);
                return;
            }
            if (parseInt == 350) {
                v(aVar, qQAppInterface, 16L);
                r(aVar);
                return;
            }
            if (d(aVar)) {
                return;
            }
            if (parseInt == 100) {
                v(aVar, qQAppInterface, 16L);
                return;
            }
            String str9 = aVar.f286488b.get("conent");
            String str10 = aVar.f286488b.get("pushstatkey");
            String str11 = aVar.f286488b.get("shcemaUrlAnd");
            String str12 = aVar.f286488b.get("title");
            String str13 = aVar.f286488b.get("fake_push");
            String str14 = aVar.f286488b.get("icon_type");
            String str15 = aVar.f286488b.get("icon_url");
            if (QLog.isColorLevel()) {
                QLog.d("CliNotifyPush", 2, "showPush: invoked. ", " iconType: ", str14, " title: ", str12, " message: ", str9);
            }
            long j3 = aVar.f286489c;
            if (aVar.f286488b.get("count") != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("showPush receive push time:");
                str = str14;
                str2 = str15;
                sb5.append(aVar.f286487a);
                sb5.append(",unreadCount=");
                sb5.append(1);
                sb5.append(",uin=");
                sb5.append(j3);
                sb5.append(",type=");
                sb5.append(parseInt);
                QLog.i("CliNotifyPush", 1, sb5.toString());
                try {
                    int parseInt2 = Integer.parseInt(aVar.f286488b.get("count"));
                    if (parseInt2 < 1) {
                        parseInt2 = 1;
                    }
                    i3 = parseInt2;
                } catch (Exception unused) {
                }
                i16 = Integer.parseInt(aVar.f286488b.get("CtrlFlag"));
                String str16 = str;
                if (QLog.isColorLevel()) {
                    str3 = "CliNotifyPush";
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("qzone redtypeinfo:receive push time:");
                    str4 = str9;
                    sb6.append(aVar.f286487a);
                    sb6.append("=unreadCount=");
                    sb6.append(i3);
                    sb6.append("=uin=");
                    sb6.append(j3);
                    sb6.append("=type=");
                    sb6.append(parseInt);
                    sb6.append("=CtrlFlag=");
                    i16 = i16;
                    sb6.append(i16);
                    i17 = 1;
                    QLog.i(str3, 1, sb6.toString());
                } else {
                    str3 = "CliNotifyPush";
                    QLog.i(str3, 2, "qzone redtypeinfo:receive push time:" + aVar.f286487a + "=unreadCount=" + i3 + "=uin=" + j3 + "=type=" + parseInt + "=CtrlFlag=" + i16 + "=message=" + str9);
                    str4 = str9;
                    i17 = 1;
                }
                if (i16 != i17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                x(aVar, z16);
                int i26 = Integer.parseInt(aVar.f286488b.get("show_level"));
                QZonePushReporter.QZonePushEventValueBuilder pushContent = new QZonePushReporter.QZonePushEventValueBuilder().setPushChannel("1").setPushType(parseInt + "").setPushContent(str10);
                if (qQAppInterface.isBackgroundPause) {
                    str5 = "1";
                } else {
                    str5 = "2";
                }
                QZonePushReporter.reportPushEvent(pushContent.setDisplayType(str5).setEventCodeType1(QZonePushReporter.EVENT_CODE_TYPE1_PUSH).setEventCodeType2(QZonePushReporter.EVENT_CODE_TYPE2_PUSH_ARRIVE));
                if (qQAppInterface.isBackgroundPause) {
                    i18 = 1;
                    if (!b(i26, 1)) {
                        v(aVar, qQAppInterface, 32L);
                        return;
                    }
                } else {
                    i18 = 1;
                }
                if (c(qQAppInterface, parseInt)) {
                    v(aVar, qQAppInterface, 16L);
                    return;
                }
                if (i16 == i18) {
                    QLog.e(str3, i18, "not show push, existDL = " + i16);
                    v(aVar, qQAppInterface, 128L);
                    return;
                }
                if (!QQUtils.k(qQAppInterface.getApp()) && !qQAppInterface.isBackgroundPause && l() && !b(i26, 0)) {
                    v(aVar, qQAppInterface, 64L);
                    return;
                }
                if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext())) {
                    v(aVar, qQAppInterface, 512L);
                    return;
                }
                if (str4 != null) {
                    boolean isShowMsgContent = qQAppInterface.isShowMsgContent();
                    if (!isShowMsgContent) {
                        str4 = qQAppInterface.getApp().getApplicationContext().getString(R.string.gm7) + i3 + qQAppInterface.getApp().getApplicationContext().getString(R.string.gm8);
                    }
                    Map<String, String> map = aVar.f286488b;
                    if (map == null || map.get("daemonShow") == null) {
                        str6 = "1";
                        z17 = true;
                    } else {
                        str6 = "1";
                        z17 = str6.equals(aVar.f286488b.get("daemonShow"));
                    }
                    if (z17) {
                        str7 = str3;
                        String str17 = str6;
                        MsgNotification.getInstance().showQZoneMsgNotification(qQAppInterface, 1, str12, str4, str16, str2, isShowMsgContent, parseInt, str11, str10, true, str6.equals(str13), -1, "", "");
                        v(aVar, qQAppInterface, 4L);
                        QZonePushReporter.QZonePushEventValueBuilder pushType = new QZonePushReporter.QZonePushEventValueBuilder().setPushChannel(str17).setPushType(parseInt + "");
                        if (qQAppInterface.isBackgroundPause) {
                            str8 = "2";
                        } else {
                            str8 = str17;
                        }
                        QZonePushReporter.reportPushEvent(pushType.setDisplayType(str8).setPushContent(str10).setEventCodeType1(QZonePushReporter.EVENT_CODE_TYPE1_PUSH).setEventCodeType2(QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE));
                    } else {
                        str7 = str3;
                    }
                    QLog.e(str7, 1, "show push: XXX");
                    return;
                }
                v(aVar, qQAppInterface, 256L);
                return;
            }
            str = str14;
            str2 = str15;
            i3 = 1;
            i16 = Integer.parseInt(aVar.f286488b.get("CtrlFlag"));
            String str162 = str;
            if (QLog.isColorLevel()) {
            }
            if (i16 != i17) {
            }
            x(aVar, z16);
            int i262 = Integer.parseInt(aVar.f286488b.get("show_level"));
            QZonePushReporter.QZonePushEventValueBuilder pushContent2 = new QZonePushReporter.QZonePushEventValueBuilder().setPushChannel("1").setPushType(parseInt + "").setPushContent(str10);
            if (qQAppInterface.isBackgroundPause) {
            }
            QZonePushReporter.reportPushEvent(pushContent2.setDisplayType(str5).setEventCodeType1(QZonePushReporter.EVENT_CODE_TYPE1_PUSH).setEventCodeType2(QZonePushReporter.EVENT_CODE_TYPE2_PUSH_ARRIVE));
            if (qQAppInterface.isBackgroundPause) {
            }
            if (c(qQAppInterface, parseInt)) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0109 A[Catch: Exception -> 0x0164, TryCatch #2 {Exception -> 0x0164, blocks: (B:36:0x00f8, B:38:0x0109, B:39:0x011d, B:41:0x0123), top: B:35:0x00f8, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void x(com.tencent.mobileqq.servlet.model.a aVar, boolean z16) {
        int i3;
        int i16;
        ArrayList<QZoneCountUserInfo> arrayList;
        byte[] inflateByte;
        String str;
        String str2;
        PassiveFeedsPush passiveFeedsPush;
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin;
        if (aVar != null && aVar.f286488b != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
            if (qQAppInterface == null) {
                QLog.e("CliNotifyPush", 1, "showRedTouch failed app=null");
                return;
            }
            QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
            if (qZoneManagerImp == null) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(aVar.f286488b.get("pushtype"));
                QLog.i("CliNotifyPush", 1, "showRedTouch type:" + parseInt + ",uin:" + aVar.f286489c + ",isBackground_Pause:" + qQAppInterface.isBackgroundPause);
                if (parseInt == 1 || parseInt == 300 || parseInt == 302) {
                    String str3 = aVar.f286488b.get("conent");
                    int parseInt2 = Integer.parseInt(aVar.f286488b.get("count"));
                    long j3 = aVar.f286489c;
                    try {
                        if (aVar.f286488b.containsKey("opuin_qzoneVipLevel")) {
                            try {
                                i16 = Integer.parseInt(aVar.f286488b.get("opuin_qzoneVipLevel"));
                                i3 = 1;
                            } catch (Exception unused) {
                                i3 = 1;
                                QLog.i("CliNotifyPush", 2, "parse vip level error");
                                i16 = 0;
                                arrayList = new ArrayList<>();
                                QZoneCountUserInfo qZoneCountUserInfo = new QZoneCountUserInfo();
                                qZoneCountUserInfo.uin = j3;
                                qZoneCountUserInfo.iYellowLevel = i16;
                                qZoneCountUserInfo.iYellowType = i3;
                                inflateByte = JceUtils.inflateByte(aVar.f286494h);
                                aVar.f286494h = inflateByte;
                                if (inflateByte == null) {
                                }
                                str = str3;
                                arrayList.add(qZoneCountUserInfo);
                                String str4 = aVar.f286488b.get("shcemaUrlAnd");
                                str2 = aVar.f286488b.get("psv_tab_textlist");
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                if (parseInt != 302) {
                                }
                                qZoneManagerImp.w(1, parseInt2, arrayList, str, z16, true, "");
                                return;
                            }
                        } else {
                            i16 = 0;
                            i3 = 0;
                        }
                    } catch (Exception unused2) {
                        i3 = 0;
                    }
                    arrayList = new ArrayList<>();
                    QZoneCountUserInfo qZoneCountUserInfo2 = new QZoneCountUserInfo();
                    qZoneCountUserInfo2.uin = j3;
                    qZoneCountUserInfo2.iYellowLevel = i16;
                    qZoneCountUserInfo2.iYellowType = i3;
                    inflateByte = JceUtils.inflateByte(aVar.f286494h);
                    aVar.f286494h = inflateByte;
                    if (inflateByte == null && (passiveFeedsPush = (PassiveFeedsPush) JceUtils.decodeWup(PassiveFeedsPush.class, inflateByte)) != null && (qzmallCustomBubbleSkin = passiveFeedsPush.stBubbleSkin) != null) {
                        str = str3;
                        if (qzmallCustomBubbleSkin.lUin == j3) {
                            qZoneCountUserInfo2.pushData = passiveFeedsPush;
                        }
                    } else {
                        str = str3;
                    }
                    arrayList.add(qZoneCountUserInfo2);
                    String str42 = aVar.f286488b.get("shcemaUrlAnd");
                    try {
                        str2 = aVar.f286488b.get("psv_tab_textlist");
                        if (!TextUtils.isEmpty(str2)) {
                            JSONObject jSONObject = new JSONObject(str2);
                            jSONObject.getJSONObject("psv_tab_list");
                            JSONArray jSONArray = jSONObject.getJSONObject("psv_tab_list").getJSONArray("text_data");
                            for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i17);
                                long j16 = jSONObject2.getLong("uin");
                                String string = jSONObject2.getString("nk");
                                feed_info feed_infoVar = new feed_info(0L, 0L, 0L, jSONObject2.getString("text"));
                                QZoneCountUserInfo qZoneCountUserInfo3 = new QZoneCountUserInfo();
                                qZoneCountUserInfo3.nickName = string;
                                qZoneCountUserInfo3.uin = j16;
                                ArrayList<feed_info> arrayList2 = new ArrayList<>();
                                arrayList2.add(feed_infoVar);
                                qZoneCountUserInfo3.vec_feedInfos = arrayList2;
                                arrayList.add(qZoneCountUserInfo3);
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e("CliNotifyPush", 1, "psv_tab_textlist failed" + e16);
                    }
                    if (parseInt != 302 && !TextUtils.isEmpty(str42)) {
                        qZoneManagerImp.w(1, parseInt2, arrayList, str, z16, true, str42);
                        return;
                    } else {
                        qZoneManagerImp.w(1, parseInt2, arrayList, str, z16, true, "");
                        return;
                    }
                }
                return;
            } catch (Exception unused3) {
                QLog.e("CliNotifyPush", 1, "showRedTouch failed");
                return;
            }
        }
        QLog.e("CliNotifyPush", 1, "showRedTouch failed sm=null");
    }

    public boolean b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (((1 << i16) & i3) != 0) {
            z16 = true;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("CliNotifyPush", 2, "checkForegroundShowEnabled showLevel: " + i3 + ",result: " + z16);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<Integer, com.tencent.mobileqq.servlet.model.a> g(FromServiceMsg fromServiceMsg) {
        Iterator<SingleMsg> it;
        long j3;
        long j16;
        QQAppInterface qQAppInterface;
        int i3;
        PushInfo pushInfo;
        int i16;
        PushInfo pushInfo2;
        String str;
        PushInfo pushInfo3;
        PushInfo pushInfo4;
        QQAppInterface qQAppInterface2;
        int i17;
        com.tencent.mobileqq.servlet.model.a aVar;
        long j17;
        PushInfo pushInfo5;
        long j18;
        String str2;
        d dVar = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) dVar, (Object) fromServiceMsg);
        }
        int i18 = 1;
        QLog.e("CliNotifyPush", 1, "decodeQzonePushMsgs()");
        QQAppInterface qQAppInterface3 = (QQAppInterface) getAppRuntime();
        if (qQAppInterface3 == null) {
            return null;
        }
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        int i19 = 4;
        int i26 = 0;
        System.arraycopy(wupBuffer, 4, wupBuffer, 0, wupBuffer.length - 4);
        PushInfo pushInfo6 = new PushInfo();
        JceInputStream jceInputStream = new JceInputStream(wupBuffer);
        jceInputStream.setServerEncoding("utf-8");
        pushInfo6.readFrom(jceInputStream);
        ArrayList<SingleMsg> arrayList = pushInfo6.vecMsg;
        HashMap hashMap = new HashMap();
        long m3 = m(qQAppInterface3);
        Iterator<SingleMsg> it5 = arrayList.iterator();
        long j19 = m3;
        while (it5.hasNext()) {
            SingleMsg next = it5.next();
            if (next == null) {
                it = it5;
                j3 = m3;
                j16 = j19;
                qQAppInterface = qQAppInterface3;
                i3 = i18;
                pushInfo = pushInfo6;
            } else {
                if (next.data.containsKey("pushtype")) {
                    i16 = Integer.parseInt(next.data.get("pushtype"));
                } else if (next.data.containsKey("type")) {
                    i16 = Integer.parseInt(next.data.get("type"));
                } else {
                    i16 = i26;
                }
                if (i16 != i18 && i16 != 2 && i16 != i19 && i16 != 301 && i16 != 8 && i16 != 300 && i16 != 10000 && i16 != 10100 && i16 != 302 && i16 != 350 && i16 != 100 && i16 != 366 && i16 != 10) {
                    if (i16 == 7066) {
                        dVar.p(next.data);
                    } else if (i16 == 200) {
                        dVar.q(qQAppInterface3, next.data);
                    } else if (i16 == 699) {
                        dVar.o(next);
                    } else {
                        v(new com.tencent.mobileqq.servlet.model.a(next.addTime, next.data, next.opUin, pushInfo6.Mark), qQAppInterface3, 256L);
                    }
                    it = it5;
                    j3 = m3;
                    pushInfo4 = pushInfo6;
                    qQAppInterface2 = qQAppInterface3;
                    i17 = i18;
                    j17 = j19;
                } else {
                    long n3 = n(qQAppInterface3, i16);
                    it = it5;
                    j3 = m3;
                    if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUSH_DEDUPLICATION, i18) == i18) {
                        pushInfo2 = pushInfo6;
                        if (next.addTime > n3) {
                            str = " newTimeStap:";
                            PushInfo pushInfo7 = pushInfo2;
                            if (!hashMap.containsKey(Integer.valueOf(i16))) {
                                com.tencent.mobileqq.servlet.model.a aVar2 = (com.tencent.mobileqq.servlet.model.a) hashMap.get(Integer.valueOf(i16));
                                if (aVar2 != null) {
                                    j16 = j19;
                                    long j26 = aVar2.f286487a;
                                    j18 = n3;
                                    str2 = str;
                                    long j27 = next.addTime;
                                    if (j26 < j27 && aVar2.f286488b != null) {
                                        qQAppInterface2 = qQAppInterface3;
                                        aVar = new com.tencent.mobileqq.servlet.model.a(j27, next.data, next.opUin, pushInfo7.Mark, next.extBuffer);
                                        if (i16 != 366) {
                                            hashMap.put(Integer.valueOf(i16), aVar);
                                        }
                                        QLog.e("CliNotifyPush", 1, "PushDeduplication: msg localTimeStap:" + next.addTime + " sm newTimeStap:" + aVar2.f286487a + " msg:" + aVar2.f286488b.get("conent"));
                                        v(aVar2, qQAppInterface2, 8L);
                                        pushInfo4 = pushInfo7;
                                        i17 = 1;
                                    } else {
                                        qQAppInterface = qQAppInterface3;
                                        pushInfo5 = pushInfo7;
                                    }
                                } else {
                                    pushInfo5 = pushInfo7;
                                    j18 = n3;
                                    j16 = j19;
                                    qQAppInterface = qQAppInterface3;
                                    str2 = str;
                                }
                                i3 = 1;
                                QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + j18 + str2 + next.addTime + " msg:" + next.data.get("conent"));
                                pushInfo = pushInfo5;
                                v(new com.tencent.mobileqq.servlet.model.a(next.addTime, next.data, next.opUin, pushInfo.Mark), qQAppInterface, 8L);
                            } else {
                                pushInfo4 = pushInfo7;
                                j16 = j19;
                                qQAppInterface2 = qQAppInterface3;
                                i17 = 1;
                                aVar = new com.tencent.mobileqq.servlet.model.a(next.addTime, next.data, next.opUin, pushInfo4.Mark, next.extBuffer);
                                if (i16 != 366) {
                                    hashMap.put(Integer.valueOf(i16), aVar);
                                }
                            }
                            t(qQAppInterface2, i16, next.addTime);
                            j17 = next.addTime;
                            if (j16 >= j17) {
                                j17 = j16;
                            }
                            if (i16 != 366) {
                                dVar = this;
                                dVar.j(qQAppInterface2, aVar);
                            } else {
                                dVar = this;
                            }
                        } else {
                            QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + n3 + " newTimeStap:" + next.addTime + " msg:" + next.data.get("conent"));
                            long j28 = next.addTime;
                            Map<String, String> map = next.data;
                            long j29 = next.opUin;
                            pushInfo3 = pushInfo2;
                            v(new com.tencent.mobileqq.servlet.model.a(j28, map, j29, pushInfo3.Mark), qQAppInterface3, 8L);
                            dVar.s(2014);
                            j16 = j19;
                            pushInfo = pushInfo3;
                            qQAppInterface = qQAppInterface3;
                            i3 = 1;
                        }
                    } else {
                        pushInfo2 = pushInfo6;
                        str = " newTimeStap:";
                        if (next.addTime < n3) {
                            QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + n3 + str + next.addTime + " msg:" + next.data.get("conent"));
                            long j36 = next.addTime;
                            Map<String, String> map2 = next.data;
                            long j37 = next.opUin;
                            pushInfo3 = pushInfo2;
                            v(new com.tencent.mobileqq.servlet.model.a(j36, map2, j37, pushInfo3.Mark), qQAppInterface3, 8L);
                            dVar.s(2014);
                            j16 = j19;
                            pushInfo = pushInfo3;
                            qQAppInterface = qQAppInterface3;
                            i3 = 1;
                        }
                        PushInfo pushInfo72 = pushInfo2;
                        if (!hashMap.containsKey(Integer.valueOf(i16))) {
                        }
                        t(qQAppInterface2, i16, next.addTime);
                        j17 = next.addTime;
                        if (j16 >= j17) {
                        }
                        if (i16 != 366) {
                        }
                    }
                }
                pushInfo6 = pushInfo4;
                m3 = j3;
                i19 = 4;
                i26 = 0;
                long j38 = j17;
                i18 = i17;
                qQAppInterface3 = qQAppInterface2;
                it5 = it;
                j19 = j38;
            }
            dVar = this;
            i18 = i3;
            pushInfo6 = pushInfo;
            qQAppInterface3 = qQAppInterface;
            it5 = it;
            m3 = j3;
            j19 = j16;
            i19 = 4;
            i26 = 0;
        }
        long j39 = j19;
        QQAppInterface qQAppInterface4 = qQAppInterface3;
        if (m3 < j39) {
            u(qQAppInterface4, j39);
        }
        return hashMap;
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f286465d;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return ((IQZoneEnvApi) QRoute.api(IQZoneEnvApi.class)).isInQZoneEnv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onCreate();
            RemoteHandleManager.getInstance().addWebEventListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.Servlet
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            RemoteHandleManager.getInstance().removeWebEventListener(this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
        }
        if (fromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush") && fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
            }
            byte[] bArr = (byte[]) fromServiceMsg.attributes.get(BaseConstants.EXTRA_PUSHMSG);
            SvcMsgPush svcMsgPush = new SvcMsgPush();
            svcMsgPush.readFrom(new JceInputStream(bArr));
            ((MessageHandler) ((QQAppInterface) getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).onReceive(new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd()), fromServiceMsg, svcMsgPush);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone") && fromServiceMsg.isSuccess()) {
            QLog.e("CliNotifyPush", 1, "get qzone push begin");
            Map<Integer, com.tencent.mobileqq.servlet.model.a> g16 = g(fromServiceMsg);
            if (g16 != null) {
                Iterator<com.tencent.mobileqq.servlet.model.a> it = g16.values().iterator();
                while (it.hasNext()) {
                    i(it.next());
                }
                return;
            }
            return;
        }
        QLog.e("CliNotifyPush", 1, "get qzone push error");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) packet);
        }
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        if (str.equals(RemoteHandleConst.CMD_PRE_GET_PASSIVE_FEEDS) && bundle != null && bundle.containsKey("data")) {
            Bundle bundle2 = bundle.getBundle("data");
            int i3 = bundle2.getInt(RemoteHandleConst.PARAM_PRE_GET_SEQID);
            Long valueOf = Long.valueOf(bundle2.getLong(RemoteHandleConst.PARAM_PRE_GET_UNDEALCOUNT, -1L));
            if (f286466e.get(Integer.valueOf(i3)) != null) {
                com.tencent.mobileqq.servlet.model.a aVar = f286466e.get(Integer.valueOf(i3));
                if (valueOf.longValue() != -1) {
                    aVar.f286488b.put("count", valueOf + "");
                }
                QLog.e("CliNotifyPush", 1, "onWebEvent showPush count:" + valueOf);
                w(f286466e.get(Integer.valueOf(i3)));
            }
        }
    }
}
