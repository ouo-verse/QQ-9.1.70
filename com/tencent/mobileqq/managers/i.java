package com.tencent.mobileqq.managers;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.utils.ad;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotificationController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i implements Observer, Manager {
    static IPatchRedirector $redirector_;
    private static CopyOnWriteArrayList<RecentBaseData> C;
    private static ConcurrentHashMap<String, Integer> D;
    private static byte[] E;
    public static volatile boolean F;
    public static boolean G;
    public static boolean H;
    public static boolean I;
    public static boolean J;
    public static long K;
    public static int L;
    public static boolean M;
    public static boolean N;

    /* renamed from: f, reason: collision with root package name */
    public static long f243725f;

    /* renamed from: h, reason: collision with root package name */
    public static long f243726h;

    /* renamed from: i, reason: collision with root package name */
    public static int f243727i;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f243728m;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.mobileqq.qcall.f f243729d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f243730e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f243725f = 0L;
        f243726h = 0L;
        f243727i = 0;
        f243728m = false;
        C = new CopyOnWriteArrayList<>();
        D = new ConcurrentHashMap<>();
        E = new byte[0];
        F = false;
        G = false;
        H = false;
        I = false;
        J = false;
        K = -1L;
        L = 0;
        M = true;
        N = false;
    }

    public i(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243729d = null;
        this.f243730e = qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + m.b());
        }
        if (this.f243729d == null) {
            this.f243729d = (com.tencent.mobileqq.qcall.f) this.f243730e.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        }
    }

    public static boolean b() {
        H = ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.lock_screen.name());
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + H);
        }
        return H;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        C.clear();
        D.clear();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "mDataList clear");
        }
    }

    public int c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "getNotifyIDForUin mNotifyIdList.size = " + D.size());
        }
        int i3 = -1;
        if (D.containsKey(str)) {
            Integer num = D.get(str);
            if (num != null) {
                i3 = num.intValue();
            }
            D.remove(str);
        }
        return i3;
    }

    public CopyOnWriteArrayList<RecentBaseData> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return C;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = K;
        if (j3 > 0 && currentTimeMillis - j3 < 5000) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "isNeedStart false ,less than 5sec");
                return false;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x011a, code lost:
    
        if (r0.equals("com.tencent.av.ui.AVActivity") != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(AppInterface appInterface, String str, int i3, boolean z16, int i16) {
        boolean z17;
        ComponentName componentName;
        ComponentName componentName2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appInterface, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
            return;
        }
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "startQQLs but  app is null ,return");
                return;
            }
            return;
        }
        if (!appInterface.isLogin()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "startQQLs but is not login ,return");
                return;
            }
            return;
        }
        if (!((NotificationController) appInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).shouldNotify(str, i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "startQQLs but is Notification not permitted ,return");
                return;
            }
            return;
        }
        if (m.b().equalsIgnoreCase("HUAWEI-HUAWEI T8833")) {
            return;
        }
        boolean e16 = e();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, String.format("needStartQQLS frienduin[%s], uitype[%s], isFromMisscall[%s], isStartTime[%s]", str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(e16)));
        }
        if (e16) {
            if (!z16) {
                List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) BaseApplicationImpl.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
                if (runningTasks != null && runningTasks.size() > 0) {
                    ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
                    componentName = runningTaskInfo.topActivity;
                    if (componentName != null) {
                        try {
                            componentName2 = runningTaskInfo.topActivity;
                            String className = componentName2.getClassName();
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSActivity", 2, "locking activity:" + className);
                            }
                            if (!className.equals("com.tencent.av.ui.VideoInviteLock") && !className.equals("com.tencent.av.gaudio.GaInviteLockActivity")) {
                            }
                            z17 = true;
                        } catch (Exception unused) {
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLSalive:" + F);
                        }
                        if (i3 != 1) {
                            G = true;
                        } else {
                            G = false;
                        }
                        if (z17) {
                            return;
                        }
                    }
                }
                z17 = false;
                if (QLog.isColorLevel()) {
                }
                if (i3 != 1) {
                }
                if (z17) {
                }
            }
            if (!ad.h(BaseApplicationImpl.getApplication()) && (!F || z16)) {
                if (i(appInterface, str, i3, z16, i16, true) && Build.VERSION.SDK_INT <= 28) {
                    Intent intent = new Intent(appInterface.getApp(), (Class<?>) QQLSActivity.class);
                    intent.addFlags(67108864);
                    intent.addFlags(268435456);
                    intent.addFlags(262144);
                    intent.putExtra("notifyId", i16);
                    intent.putExtra("uitype", i3);
                    intent.putExtra("frienduin", str);
                    appInterface.getApp().startActivity(intent);
                    I = true;
                    L++;
                    if (QLog.isColorLevel()) {
                        QLog.d("qqls", 2, "need report  LS report needReport=" + M + "hasReport=" + N + "startTimes=" + L);
                    }
                    if (!N && L > 2) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("param_hasshowedLs", M + "");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(appInterface.getCurrentAccountUin(), StatisticCollector.QQLS_REPORT_TAG, true, 0L, 0L, hashMap, "");
                        if (QLog.isColorLevel()) {
                            QLog.d("qqls", 2, "need report  LS report needReport=" + M);
                        }
                        N = true;
                    }
                } else if (QLog.isDevelopLevel()) {
                    QLog.d("QQLSActivity", 4, String.format("needStartQQLS updateLSRencentUser fail...", new Object[0]));
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QQLSActivity", 4, String.format("needStartQQLS end...", new Object[0]));
            }
        }
    }

    public void g(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, messageRecord, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            com.tencent.util.j.b(qQAppInterface, messageRecord);
            f(qQAppInterface, messageRecord.frienduin, messageRecord.istroop, z16, i3);
        }
    }

    public void h(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        synchronized (E) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "removeUnreadMsg mDataList= " + C.size());
            }
            Iterator<RecentBaseData> it = C.iterator();
            while (it.hasNext()) {
                RecentBaseData next = it.next();
                int R = this.f243730e.getConversationFacade().R(next.getRecentUserUin(), next.getRecentUserType());
                int t16 = this.f243729d.t(next.getRecentUserUin(), next.getRecentUserType());
                String recentUserUin = next.getRecentUserUin();
                String str2 = AppConstants.LBS_HELLO_UIN;
                if (recentUserUin.equals(str2)) {
                    R = this.f243730e.getConversationFacade().R(str2, next.getRecentUserType());
                } else if (next.getRecentUserUin().equals(AppConstants.RECOMMEND_CONTACT_UIN)) {
                    R = ((INewFriendService) this.f243730e.getRuntimeService(INewFriendService.class)).getAllUnreadMessageCount();
                } else {
                    String recentUserUin2 = next.getRecentUserUin();
                    String str3 = AppConstants.DATE_UIN;
                    if (recentUserUin2.equals(str3)) {
                        R = this.f243730e.getConversationFacade().R(str3, next.getRecentUserType());
                    } else if (next.getRecentUserUin().equals(str) && i3 == next.getRecentUserType()) {
                        C.remove(next);
                        D.remove(next.getRecentUserUin() + next.getRecentUserType());
                    }
                }
                if (R == 0 && t16 == 0) {
                    C.remove(next);
                    D.remove(next.getRecentUserUin() + next.getRecentUserType());
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + C.size());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x037f A[Catch: all -> 0x0838, TryCatch #1 {, blocks: (B:14:0x0051, B:16:0x0057, B:17:0x0092, B:19:0x00a5, B:21:0x00ab, B:22:0x00ad, B:24:0x00b5, B:26:0x00bd, B:29:0x00c7, B:31:0x00cd, B:32:0x00fc, B:34:0x0102, B:37:0x010a, B:39:0x0112, B:40:0x0133, B:42:0x0135, B:43:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x0162, B:51:0x016a, B:55:0x01de, B:57:0x01e4, B:60:0x01f7, B:75:0x0239, B:77:0x0247, B:79:0x024a, B:80:0x0250, B:82:0x0256, B:84:0x026a, B:87:0x0278, B:89:0x0284, B:90:0x0346, B:92:0x034e, B:94:0x0354, B:99:0x03de, B:122:0x0373, B:125:0x040f, B:126:0x0414, B:105:0x037b, B:107:0x037f, B:108:0x038d, B:110:0x0393, B:113:0x03c1, B:127:0x0299, B:129:0x02a5, B:131:0x02ad, B:132:0x02c2, B:133:0x02d3, B:135:0x02df, B:136:0x02f3, B:138:0x02ff, B:140:0x0309, B:142:0x0314, B:144:0x0320, B:146:0x032a, B:147:0x032f, B:157:0x042a, B:159:0x0434, B:163:0x05a3, B:165:0x05b5, B:167:0x05c1, B:168:0x05ce, B:169:0x05d4, B:171:0x05da, B:173:0x05f2, B:176:0x0604, B:188:0x0627, B:190:0x0635, B:193:0x063f, B:194:0x0662, B:196:0x066e, B:199:0x067c, B:200:0x069f, B:202:0x06ab, B:205:0x06b9, B:206:0x06dc, B:208:0x06e8, B:211:0x06f6, B:212:0x0718, B:215:0x0724, B:218:0x0732, B:177:0x0753, B:179:0x075b, B:180:0x07bf, B:182:0x07c5, B:183:0x07e3, B:226:0x0781, B:228:0x0789, B:230:0x078f, B:231:0x0798, B:233:0x079f, B:234:0x044f, B:236:0x0459, B:238:0x0461, B:239:0x0475, B:240:0x04b1, B:242:0x04be, B:244:0x04d2, B:252:0x04f9, B:254:0x0503, B:258:0x051e, B:260:0x0529, B:264:0x053c, B:271:0x0557, B:273:0x0562, B:274:0x0571, B:276:0x0577, B:278:0x0588, B:280:0x058c, B:281:0x0172, B:283:0x0178, B:286:0x0182, B:287:0x0188, B:289:0x018e, B:293:0x0199, B:295:0x019f, B:299:0x01aa, B:301:0x01b4, B:303:0x01bc, B:305:0x01c4, B:311:0x01cd, B:314:0x01d5, B:327:0x07ef, B:329:0x07f1, B:330:0x07fe, B:332:0x0804, B:335:0x0814, B:340:0x0836, B:104:0x0366), top: B:13:0x0051, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0393 A[Catch: all -> 0x0838, TryCatch #1 {, blocks: (B:14:0x0051, B:16:0x0057, B:17:0x0092, B:19:0x00a5, B:21:0x00ab, B:22:0x00ad, B:24:0x00b5, B:26:0x00bd, B:29:0x00c7, B:31:0x00cd, B:32:0x00fc, B:34:0x0102, B:37:0x010a, B:39:0x0112, B:40:0x0133, B:42:0x0135, B:43:0x0148, B:45:0x0150, B:47:0x0158, B:49:0x0162, B:51:0x016a, B:55:0x01de, B:57:0x01e4, B:60:0x01f7, B:75:0x0239, B:77:0x0247, B:79:0x024a, B:80:0x0250, B:82:0x0256, B:84:0x026a, B:87:0x0278, B:89:0x0284, B:90:0x0346, B:92:0x034e, B:94:0x0354, B:99:0x03de, B:122:0x0373, B:125:0x040f, B:126:0x0414, B:105:0x037b, B:107:0x037f, B:108:0x038d, B:110:0x0393, B:113:0x03c1, B:127:0x0299, B:129:0x02a5, B:131:0x02ad, B:132:0x02c2, B:133:0x02d3, B:135:0x02df, B:136:0x02f3, B:138:0x02ff, B:140:0x0309, B:142:0x0314, B:144:0x0320, B:146:0x032a, B:147:0x032f, B:157:0x042a, B:159:0x0434, B:163:0x05a3, B:165:0x05b5, B:167:0x05c1, B:168:0x05ce, B:169:0x05d4, B:171:0x05da, B:173:0x05f2, B:176:0x0604, B:188:0x0627, B:190:0x0635, B:193:0x063f, B:194:0x0662, B:196:0x066e, B:199:0x067c, B:200:0x069f, B:202:0x06ab, B:205:0x06b9, B:206:0x06dc, B:208:0x06e8, B:211:0x06f6, B:212:0x0718, B:215:0x0724, B:218:0x0732, B:177:0x0753, B:179:0x075b, B:180:0x07bf, B:182:0x07c5, B:183:0x07e3, B:226:0x0781, B:228:0x0789, B:230:0x078f, B:231:0x0798, B:233:0x079f, B:234:0x044f, B:236:0x0459, B:238:0x0461, B:239:0x0475, B:240:0x04b1, B:242:0x04be, B:244:0x04d2, B:252:0x04f9, B:254:0x0503, B:258:0x051e, B:260:0x0529, B:264:0x053c, B:271:0x0557, B:273:0x0562, B:274:0x0571, B:276:0x0577, B:278:0x0588, B:280:0x058c, B:281:0x0172, B:283:0x0178, B:286:0x0182, B:287:0x0188, B:289:0x018e, B:293:0x0199, B:295:0x019f, B:299:0x01aa, B:301:0x01b4, B:303:0x01bc, B:305:0x01c4, B:311:0x01cd, B:314:0x01d5, B:327:0x07ef, B:329:0x07f1, B:330:0x07fe, B:332:0x0804, B:335:0x0814, B:340:0x0836, B:104:0x0366), top: B:13:0x0051, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x038c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(AppInterface appInterface, String str, int i3, boolean z16, int i16, boolean z17) {
        RecentBaseData recentBaseData;
        RecentUser recentUser;
        int i17;
        boolean z18;
        int unreadCount;
        RecentBaseData recentMatchChatListItem;
        boolean z19;
        int unreadCount2;
        int unreadCount3;
        boolean f16;
        RuntimeException runtimeException;
        int t16;
        String str2 = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, appInterface, str2, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17))).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (E) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "updateLSRencentUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!, thread[" + Thread.currentThread().getId() + "], uin[" + str2 + "], uinType[" + i3 + "], isFromMisscall[" + z16);
            }
            MessageRecord lastMsgForMsgTab = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab(str2, i3);
            if (i3 == 1001 && !com.tencent.mobileqq.dating.i.j(lastMsgForMsgTab)) {
                str2 = AppConstants.NEARBY_LBS_HELLO_UIN;
            }
            if (!AppConstants.LOCK_SCREEN_DATE_UIN.equals(str2) && !AppConstants.LOCK_SCREEN_LBS_HELLO_UIN.equals(str2) && !AppConstants.NEARBY_LBS_HELLO_UIN.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + C.size() + "threadId =" + Thread.currentThread().getId());
                }
                if (!FriendsStatusUtil.k(str2, appInterface) && !com.tencent.mobileqq.app.nthiddenchat.b.h(str2, i3, appInterface)) {
                    if (TextUtils.equals(str2, AppConstants.TROOP_SUSPICIOUS_MSG_UIN)) {
                        QLog.e("QQLSActivity", 1, "\u5df2\u8fc7\u6ee4\u7fa4\u901a\u77e5\u88ab\u8fc7\u6ee4: " + QLog.getStackTraceString(new Throwable()));
                        return false;
                    }
                    Iterator<RecentUser> it = ((QQAppInterface) appInterface).getProxyManager().m().getRecentList(true, false).iterator();
                    while (true) {
                        recentBaseData = null;
                        if (it.hasNext() && (recentUser = it.next()) != null && !TextUtils.isEmpty(recentUser.uin)) {
                            if (!str2.equals(recentUser.uin) || recentUser.getType() != i3) {
                                if (recentUser.getType() == i3 && AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(recentUser.uin)) {
                                    recentUser = new RecentUser(str2, i3);
                                    break;
                                }
                                if ((recentUser.getType() == i3 && AppConstants.LBS_HELLO_UIN.equals(recentUser.uin)) || ((recentUser.getType() == i3 && AppConstants.DATE_UIN.equals(recentUser.uin)) || ((AppConstants.RECOMMEND_CONTACT_UIN.equals(recentUser.uin) && (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(str2) || AppConstants.MAYKNOW_RECOMMEND_UIN.equals(str2) || AppConstants.FRIEND_ANNIVER_UIN.equals(str2))) || (recentUser.getType() == 1032 && ao.c(i3) == 1032)))) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("updateLSRencentUser curUser is not null: ");
                        sb5.append(recentUser != null);
                        sb5.append("threadId =");
                        sb5.append(Thread.currentThread().getId());
                        QLog.d("QQLSActivity", 2, sb5.toString());
                    }
                    if (recentUser == null && i3 != 1012 && i3 != 7432 && i3 != 9653 && i3 != 1030 && i3 != 1035 && i3 != 1041 && i3 != 1042 && i3 != 1044 && i3 != 1045 && ((com.tencent.mobileqq.qcall.f) appInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)).t(str2, i3) == 0) {
                        return false;
                    }
                    Iterator<RecentBaseData> it5 = C.iterator();
                    while (it5.hasNext()) {
                        RecentBaseData next = it5.next();
                        if (!TextUtils.equals(next.getRecentUserUin(), AppConstants.LOCK_SCREEN_DATE_UIN) && !TextUtils.equals(next.getRecentUserUin(), AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)) {
                            String recentUserUin = next.getRecentUserUin();
                            String str3 = AppConstants.LBS_HELLO_UIN;
                            if (TextUtils.equals(recentUserUin, str3)) {
                                unreadCount3 = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str3, next.getRecentUserType());
                            } else if (TextUtils.equals(next.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN)) {
                                String str4 = AppConstants.FRIEND_SYSTEM_MSG_UIN;
                                if (str2.equals(str4)) {
                                    unreadCount3 = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str4, next.getRecentUserType());
                                } else {
                                    unreadCount3 = ((INewFriendService) appInterface.getRuntimeService(INewFriendService.class, "")).getAllUnreadMessageCount();
                                }
                            } else {
                                String recentUserUin2 = next.getRecentUserUin();
                                String str5 = AppConstants.DATE_UIN;
                                if (TextUtils.equals(recentUserUin2, str5)) {
                                    unreadCount3 = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str5, next.getRecentUserType());
                                } else if (TextUtils.equals(next.getRecentUserUin(), AppConstants.VOTE_UIN)) {
                                    com.tencent.mobileqq.dating.d dVar = (com.tencent.mobileqq.dating.d) appInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                                    if (dVar != null) {
                                        unreadCount3 = dVar.b().d();
                                    }
                                    unreadCount3 = 0;
                                } else if (TextUtils.equals(next.getRecentUserUin(), AppConstants.PULL_ACTIVE_PUSH_UIN)) {
                                    h hVar = (h) appInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                                    if (hVar != null) {
                                        unreadCount3 = hVar.b();
                                    }
                                    unreadCount3 = 0;
                                } else {
                                    unreadCount3 = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(next.getRecentUserUin(), next.getRecentUserType());
                                }
                            }
                            if (next.getRecentUserType() == 3000 || next.getRecentUserType() == 0 || next.getRecentUserType() == 8) {
                                try {
                                    next.update((QQAppInterface) appInterface, BaseApplication.getContext());
                                } finally {
                                    if (!f16) {
                                    }
                                    com.tencent.mobileqq.qcall.f fVar = this.f243729d;
                                    if (fVar == null) {
                                    }
                                    if (!QLog.isColorLevel()) {
                                    }
                                    if (t16 > 0) {
                                    }
                                }
                                com.tencent.mobileqq.qcall.f fVar2 = this.f243729d;
                                t16 = fVar2 == null ? fVar2.t(next.getRecentUserUin(), next.getRecentUserType()) : 0;
                                if (!QLog.isColorLevel()) {
                                    Object[] objArr = new Object[4];
                                    objArr[0] = Integer.valueOf(t16);
                                    objArr[1] = next.getRecentUserUin();
                                    objArr[2] = Integer.valueOf(next.getRecentUserType());
                                    objArr[3] = Boolean.valueOf(this.f243729d != null);
                                    QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", objArr));
                                }
                                if (t16 > 0) {
                                }
                            }
                            if (unreadCount3 == 0) {
                                C.remove(next);
                                D.remove(next.getRecentUserUin() + next.getRecentUserType());
                            }
                        }
                    }
                    if (recentUser != null) {
                        String str6 = recentUser.uin;
                        String str7 = AppConstants.LBS_HELLO_UIN;
                        if (str6.equals(str7)) {
                            unreadCount2 = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str7, recentUser.getType());
                        } else if (recentUser.uin.equals(AppConstants.RECOMMEND_CONTACT_UIN)) {
                            String str8 = AppConstants.FRIEND_SYSTEM_MSG_UIN;
                            if (str2.equals(str8)) {
                                unreadCount2 = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str8, recentUser.getType());
                            } else {
                                int allUnreadMessageCount = ((INewFriendService) appInterface.getRuntimeService(INewFriendService.class, "")).getAllUnreadMessageCount();
                                z18 = true;
                                i17 = 2;
                                ReportController.o(appInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
                                recentMatchChatListItem = null;
                                unreadCount = allUnreadMessageCount;
                            }
                        } else {
                            i17 = 2;
                            z18 = true;
                            String str9 = recentUser.uin;
                            String str10 = AppConstants.DATE_UIN;
                            unreadCount = str9.equals(str10) ? ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str10, recentUser.getType()) : ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(recentUser.uin, recentUser.getType());
                            recentMatchChatListItem = recentBaseData;
                        }
                        unreadCount = unreadCount2;
                        i17 = 2;
                        recentMatchChatListItem = null;
                        z18 = true;
                    } else {
                        i17 = 2;
                        z18 = true;
                        if (i3 != 1044 && i3 != 1045) {
                            if (i3 == 1012) {
                                com.tencent.mobileqq.dating.d dVar2 = (com.tencent.mobileqq.dating.d) appInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                                if (dVar2 != null) {
                                    int d16 = dVar2.b().d();
                                    recentBaseData = dVar2.b().c();
                                    unreadCount = d16;
                                } else {
                                    unreadCount = 0;
                                }
                            } else {
                                if (i3 == 1030) {
                                    int i18 = QQManagerFactory.CAMPUS_NOTICE_MANAGER;
                                    if (((QQAppInterface) appInterface).isCreateManager(i18)) {
                                        com.tencent.mobileqq.campuscircle.d dVar3 = (com.tencent.mobileqq.campuscircle.d) appInterface.getManager(i18);
                                        unreadCount = dVar3.c();
                                        recentBaseData = dVar3.b();
                                    }
                                } else if (i3 == 9653) {
                                    h hVar2 = (h) appInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                                    unreadCount = hVar2.b();
                                    recentMatchChatListItem = hVar2.f243723f;
                                } else if (i3 == 1035 || i3 == 1041 || i3 == 1042) {
                                    int i19 = QQManagerFactory.PUSH_NOTICE_MANAGER;
                                    if (((QQAppInterface) appInterface).isCreateManager(i19)) {
                                        recentMatchChatListItem = ((PushNoticeManager) appInterface.getManager(i19)).d();
                                        unreadCount = 1;
                                    }
                                }
                                recentMatchChatListItem = null;
                                unreadCount = 0;
                            }
                            recentMatchChatListItem = recentBaseData;
                        }
                        if (!StudyModeManager.t()) {
                            unreadCount = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str2, i3);
                            if (lastMsgForMsgTab != null && lastMsgForMsgTab.senderuin != null) {
                                recentMatchChatListItem = new RecentMatchChatListItem(lastMsgForMsgTab);
                                recentMatchChatListItem.update((BaseQQAppInterface) appInterface, BaseApplication.getContext());
                            }
                            recentMatchChatListItem = recentBaseData;
                        }
                        recentMatchChatListItem = null;
                        unreadCount = 0;
                    }
                    if (unreadCount > 0 && recentMatchChatListItem != null) {
                        if (((INewFriendApi) QRoute.api(INewFriendApi.class)).shouldMergeNewFriendContact(appInterface, recentMatchChatListItem.getRecentUserUin()) && AppConstants.ACTIVATE_FRIENDS_UIN.equals(recentMatchChatListItem.getRecentUserUin())) {
                            recentMatchChatListItem.mTitleName = appInterface.getApp().getString(R.string.f170011cu);
                        }
                        Iterator<RecentBaseData> it6 = C.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                break;
                            }
                            RecentBaseData next2 = it6.next();
                            if (((INewFriendApi) QRoute.api(INewFriendApi.class)).shouldMergeNewFriendContact(appInterface, next2.getRecentUserUin()) && ((INewFriendApi) QRoute.api(INewFriendApi.class)).shouldMergeNewFriendContact(appInterface, recentMatchChatListItem.getRecentUserUin())) {
                                C.remove(next2);
                                D.remove(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType());
                                break;
                            }
                            if (TextUtils.equals(next2.getRecentUserUin(), recentMatchChatListItem.getRecentUserUin()) && next2.getRecentUserType() == recentMatchChatListItem.getRecentUserType()) {
                                C.remove(next2);
                                D.remove(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType());
                                break;
                            }
                            if (TextUtils.equals(recentMatchChatListItem.getRecentUserUin(), AppConstants.LBS_HELLO_UIN) && TextUtils.equals(next2.getRecentUserUin(), recentMatchChatListItem.getRecentUserUin())) {
                                C.remove(next2);
                                D.remove(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType());
                                break;
                            }
                            if (TextUtils.equals(recentMatchChatListItem.getRecentUserUin(), AppConstants.SCHEDULE_NOTIFY_UIN) && TextUtils.equals(next2.getRecentUserUin(), recentMatchChatListItem.getRecentUserUin())) {
                                C.remove(next2);
                                D.remove(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType());
                                break;
                            }
                            if (TextUtils.equals(recentMatchChatListItem.getRecentUserUin(), AppConstants.DATE_UIN) && TextUtils.equals(next2.getRecentUserUin(), recentMatchChatListItem.getRecentUserUin())) {
                                C.remove(next2);
                                D.remove(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType());
                                break;
                            }
                            if (TextUtils.equals(recentMatchChatListItem.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN) && TextUtils.equals(next2.getRecentUserUin(), recentMatchChatListItem.getRecentUserUin())) {
                                C.remove(next2);
                                D.remove(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType());
                                break;
                            }
                        }
                        z19 = false;
                        C.add(0, recentMatchChatListItem);
                        if (z17) {
                            D.put(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType(), Integer.valueOf(i16));
                        }
                    } else {
                        z19 = false;
                        if (z16 && recentMatchChatListItem != null && !C.contains(recentMatchChatListItem)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSActivity", i17, "QQLSRecentManager.updateLSRencentUser from misscall");
                            }
                            C.add(0, recentMatchChatListItem);
                            if (z17) {
                                D.put(recentMatchChatListItem.getRecentUserUin() + recentMatchChatListItem.getRecentUserType(), Integer.valueOf(i16));
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", i17, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + C.size());
                    }
                    return C.size() > 0 ? z18 : z19;
                }
                return false;
            }
            new RecentUser(str2, i3);
            Iterator<RecentBaseData> it7 = C.iterator();
            while (it7.hasNext()) {
                RecentBaseData next3 = it7.next();
                if (TextUtils.equals(next3.getRecentUserUin(), str2)) {
                    C.remove(next3);
                    D.remove(next3.getRecentUserUin() + next3.getRecentUserType());
                }
            }
            return true;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (this.f243729d != null) {
            this.f243729d = null;
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj != null && (obj instanceof com.tencent.mobileqq.newfriend.msg.i)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
            }
            if (!QQUtils.k(this.f243730e.getApp())) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
                    return;
                }
                return;
            }
            int allUnreadMessageCount = ((INewFriendService) this.f243730e.getRuntimeService(INewFriendService.class)).getAllUnreadMessageCount();
            com.tencent.mobileqq.newfriend.msg.i iVar = (com.tencent.mobileqq.newfriend.msg.i) obj;
            if (!TextUtils.isEmpty(iVar.a(this.f243730e)) && iVar.f254036b != 0) {
                if (allUnreadMessageCount != 0 && !J) {
                    Boolean valueOf = Boolean.valueOf(SettingCloneUtil.readValue((Context) this.f243730e.getApp(), this.f243730e.getAccount(), this.f243730e.getApp().getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true));
                    Boolean valueOf2 = Boolean.valueOf(SettingCloneUtil.readValue((Context) this.f243730e.getApp(), this.f243730e.getAccount(), this.f243730e.getApp().getString(R.string.f173079h50), AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, true));
                    if (valueOf.booleanValue() && valueOf2.booleanValue()) {
                        QQAppInterface qQAppInterface = this.f243730e;
                        String str = AppConstants.RECOMMEND_CONTACT_UIN;
                        f(qQAppInterface, str, 4000, false, d.a(str, 4000, null));
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + J);
                }
            }
        }
    }
}
