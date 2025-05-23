package com.tencent.mobileqq.chat;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.quickupdate.RingUpdateBusiness;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.Pair;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MessageNotificationSettingManager implements Manager {
    static IPatchRedirector $redirector_;
    private static final boolean D;
    private static final boolean E;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private final FriendsManager f201222d;

    /* renamed from: e, reason: collision with root package name */
    private final TroopManager f201223e;

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f201224f;

    /* renamed from: h, reason: collision with root package name */
    private c f201225h;

    /* renamed from: i, reason: collision with root package name */
    private Map<Integer, String> f201226i;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f201227m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class RingUpdateListener implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<MessageNotificationSettingManager> f201230a;

        /* renamed from: b, reason: collision with root package name */
        final int f201231b;

        public RingUpdateListener(MessageNotificationSettingManager messageNotificationSettingManager, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageNotificationSettingManager, i3);
            } else {
                this.f201230a = new WeakReference<>(messageNotificationSettingManager);
                this.f201231b = i3;
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            } else if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "onLoadFail:  ringId: ", Integer.valueOf(this.f201231b));
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "onLoadSuccess:  ringId: ", Integer.valueOf(this.f201231b));
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingUpdateListener.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RingUpdateListener.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MessageNotificationSettingManager messageNotificationSettingManager = RingUpdateListener.this.f201230a.get();
                    if (messageNotificationSettingManager != null && messageNotificationSettingManager.f201225h != null) {
                        messageNotificationSettingManager.f201225h.r8(RingUpdateListener.this.f201231b);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f201232a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f201233b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f201234c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f201235d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IOtherInfoService f201236e;

        a(String str, String str2, int i3, boolean z16, IOtherInfoService iOtherInfoService) {
            this.f201232a = str;
            this.f201233b = str2;
            this.f201234c = i3;
            this.f201235d = z16;
            this.f201236e = iOtherInfoService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageNotificationSettingManager.this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), iOtherInfoService);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b16 = eVar.b();
            if (eVar.a() == 0 && b16 != null && b16.size() > 0) {
                aVar = b16.get(0);
            } else {
                aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a();
                aVar.t(this.f201232a);
                aVar.u(String.valueOf(this.f201233b));
            }
            int i3 = this.f201234c;
            if (i3 == 1) {
                aVar.q0(!this.f201235d ? 1 : 0);
            } else if (i3 == 3) {
                aVar.s0(!this.f201235d ? 1 : 0);
            } else if (i3 == 2) {
                aVar.r0(!this.f201235d ? 1 : 0);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "saveExtensionInfo: invoked. ", " uin: ", this.f201233b, " type: ", Integer.valueOf(this.f201234c), " enable: ", Boolean.valueOf(this.f201235d));
            }
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar2 = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(this.f201232a, this.f201233b);
            aVar2.m();
            aVar2.q0(aVar.G());
            aVar2.s0(aVar.N());
            aVar2.r0(aVar.M());
            this.f201236e.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar2)), "MessageNotificationSettingManager", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f201238a;

        /* renamed from: b, reason: collision with root package name */
        private final Thread f201239b;

        /* renamed from: c, reason: collision with root package name */
        private Runnable f201240c;

        public b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f201240c = null;
            this.f201238a = str;
            this.f201239b = Thread.currentThread();
        }

        private String b(StackTraceElement[] stackTraceElementArr) {
            if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 0; i3 < stackTraceElementArr.length; i3++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i3];
                    sb5.append(String.format("%s.%s(%s:%d)", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())));
                    if (i3 < stackTraceElementArr.length - 1) {
                        sb5.append("|");
                    }
                }
                return sb5.toString();
            }
            return "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            try {
                String b16 = b(this.f201239b.getStackTrace());
                QLog.e("MessageNotificationSettingManager", 1, "[PlayRingIdMonitor] play ring id timeout, stack=" + b16);
                f(b16);
            } catch (Exception e16) {
                QLog.e("MessageNotificationSettingManager", 1, "[PlayRingIdMonitor] onPlayStart, exception=" + e16);
            }
        }

        private void f(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", this.f201238a);
            hashMap.put("stack", str);
            QQBeaconReport.report("", "notification_play_ring_timeout", hashMap);
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (this.f201240c != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MessageNotificationSettingManager", 2, "[PlayRingIdMonitor] onPlayEnd, remove delay task");
                }
                ThreadManagerV2.removeJob(this.f201240c, 16);
                this.f201240c = null;
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f201240c = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.chat.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessageNotificationSettingManager.b.this.c();
                    }
                }, 16, null, false, 5000L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void r8(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            D = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_play_default_special_care_ring_9015", true);
            E = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("9160_notification_monitor_play_ring_138960127", false);
        }
    }

    public MessageNotificationSettingManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f201226i = new HashMap();
        this.f201227m = null;
        this.C = VasNormalToggle.BUG_111890879.isEnable(true);
        this.f201224f = qQAppInterface;
        this.f201222d = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.f201223e = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        this.f201226i = new HashMap<Integer, String>() { // from class: com.tencent.mobileqq.chat.MessageNotificationSettingManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageNotificationSettingManager.this);
                    return;
                }
                put(Integer.valueOf(R.raw.f169478ac), HardCodeUtil.qqStr(R.string.o2z));
                put(Integer.valueOf(R.raw.f169398k), HardCodeUtil.qqStr(R.string.f172179o31));
                put(Integer.valueOf(R.raw.f169448ab), HardCodeUtil.qqStr(R.string.o2w));
                put(Integer.valueOf(R.raw.f169334j), HardCodeUtil.qqStr(R.string.o2x));
                put(Integer.valueOf(AppSetting.P), HardCodeUtil.qqStr(R.string.f172178o30));
                put(Integer.valueOf(AppSetting.Q), HardCodeUtil.qqStr(R.string.f172182o34));
            }
        };
    }

    private boolean B(String str, int i3) {
        boolean A = A(str);
        if (i3 == 1 && A) {
            return true;
        }
        return false;
    }

    private boolean C(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        return B(messageRecord.senderuin, messageRecord.istroop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(String str) {
        b bVar;
        try {
            if (!E) {
                bVar = new b(this.f201224f.getCurrentUin());
                bVar.e();
            } else {
                bVar = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            AudioUtil.w(str, false, r());
            if (bVar != null) {
                bVar.d();
            }
            QLog.d("MessageNotificationSettingManager", 1, "doWavMediaPlay, costTime: " + (System.currentTimeMillis() - currentTimeMillis) + ", wavPath: " + str);
        } catch (Throwable th5) {
            QLog.w("MessageNotificationSettingManager", 1, "[doWavMediaPlay] error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(int i3) {
        b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (!E) {
            bVar = new b(this.f201224f.getCurrentUin());
            bVar.e();
        } else {
            bVar = null;
        }
        AudioUtil.o(i3, false, r());
        if (bVar != null) {
            bVar.d();
        }
        QLog.d("MessageNotificationSettingManager", 1, "playRingId, costTime: " + (System.currentTimeMillis() - currentTimeMillis) + ", targetId: " + i3);
    }

    private boolean G(TroopInfo troopInfo) {
        if (troopInfo == null) {
            return true;
        }
        return !TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 1024);
    }

    private boolean H(TroopInfo troopInfo) {
        if (troopInfo == null) {
            return true;
        }
        return !TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 2048);
    }

    private boolean I(TroopInfo troopInfo) {
        if (troopInfo == null) {
            return true;
        }
        return !TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 4096);
    }

    public static boolean J(MessageRecord messageRecord) {
        boolean z16;
        if (messageRecord == null) {
            return false;
        }
        int i3 = messageRecord.istroop;
        if (i3 != 1 && i3 != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 || !com.tencent.qqnt.contact.friends.b.f355778a.d(messageRecord.frienduin)) {
            return false;
        }
        return true;
    }

    private void K(MessageRecord messageRecord) {
        e(messageRecord);
        String s16 = s(messageRecord);
        int a16 = com.tencent.mobileqq.notification.util.a.a(s16);
        if (a16 == 0) {
            int m3 = m(s16);
            QLog.d("MessageNotificationSettingManager", 1, "[playFriendRing] using global id, " + m3);
            N(m3);
            return;
        }
        QLog.i("MessageNotificationSettingManager", 1, "[playFriendRing] uin=" + s16 + " friendRingId=" + a16);
        N(a16);
    }

    private void N(int i3) {
        QLog.d("MessageNotificationSettingManager", 1, "playRingId: invoked. ", " id: ", Integer.valueOf(i3));
        int q16 = q();
        int i16 = AppSetting.P;
        final int i17 = R.raw.f169398k;
        if (q16 != i16 && q16 == AppSetting.Q) {
            q16 = R.raw.f169398k;
        }
        if (i3 != 0) {
            q16 = i3;
        }
        if (this.C && !y(q16)) {
            RingUpdateBusiness ringUpdateBusiness = (RingUpdateBusiness) QQVasUpdateBusiness.getBusiness(RingUpdateBusiness.class);
            if (!new File(ringUpdateBusiness.getWavPath(q16)).exists()) {
                ringUpdateBusiness.startDownload(q16);
                q16 = R.raw.f169398k;
            }
        }
        if (y(q16)) {
            if (q16 != AppSetting.Q) {
                i17 = q16;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.chat.b
                @Override // java.lang.Runnable
                public final void run() {
                    MessageNotificationSettingManager.this.E(i17);
                }
            }, 64, null, false);
            QLog.d("MessageNotificationSettingManager", 1, "playRingId, finished, targetId: " + i17);
            return;
        }
        RingUpdateBusiness ringUpdateBusiness2 = (RingUpdateBusiness) QQVasUpdateBusiness.getBusiness(RingUpdateBusiness.class);
        if (!ringUpdateBusiness2.isFileExists(q16)) {
            QLog.d("MessageNotificationSettingManager", 1, "playRingId: ring does not exists, targetId: ", Integer.valueOf(q16));
            ringUpdateBusiness2.addDownLoadListener(i3, new Runnable(ringUpdateBusiness2, q16) { // from class: com.tencent.mobileqq.chat.MessageNotificationSettingManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RingUpdateBusiness f201228d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f201229e;

                {
                    this.f201228d = ringUpdateBusiness2;
                    this.f201229e = q16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, MessageNotificationSettingManager.this, ringUpdateBusiness2, Integer.valueOf(q16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    String wavPath = this.f201228d.getWavPath(this.f201229e);
                    QLog.d("MessageNotificationSettingManager", 1, "playRingId.onCompleted: invoked. ", " wavPath: ", wavPath);
                    MessageNotificationSettingManager.this.g(wavPath);
                }
            });
            ringUpdateBusiness2.startDownload(q16);
        } else {
            String wavPath = ringUpdateBusiness2.getWavPath(q16);
            QLog.d("MessageNotificationSettingManager", 1, "playRingId: ring exists. ", " wavPath: ", wavPath);
            g(wavPath);
        }
    }

    public static byte[] Y(int i3, int i16, int i17) {
        int i18;
        int i19;
        int i26;
        if (i3 == 1) {
            i18 = 1;
        } else {
            i18 = 0;
        }
        if (i16 == 1) {
            i19 = 2;
        } else {
            i19 = 0;
        }
        if (i17 == 1) {
            i26 = 4;
        } else {
            i26 = 0;
        }
        byte[] intToBytes = PkgTools.intToBytes(i18 | i19 | i26);
        return new byte[]{intToBytes[1], intToBytes[0]};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.chat.a
            @Override // java.lang.Runnable
            public final void run() {
                MessageNotificationSettingManager.this.D(str);
            }
        }, 64, null, false);
    }

    public static MessageNotificationSettingManager l(QQAppInterface qQAppInterface) {
        return (MessageNotificationSettingManager) qQAppInterface.getManager(QQManagerFactory.MESSAGE_NOTIFICATION_SETTING_MANAGER);
    }

    private int m(String str) {
        if (D) {
            return u(str, q());
        }
        return q();
    }

    private boolean r() {
        if (this.f201227m == null) {
            this.f201227m = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("is_notify_ring_switch_open", false));
        }
        QLog.i("MessageNotificationSettingManager", 1, "getIsNotifyRingSwitchOpen " + this.f201227m);
        return this.f201227m.booleanValue();
    }

    private String s(MessageRecord messageRecord) {
        if (messageRecord.istroop == 0) {
            return messageRecord.frienduin;
        }
        return messageRecord.senderuin;
    }

    private int u(String str, int i3) {
        if (A(str)) {
            if (w() && z(str)) {
                QLog.i("MessageNotificationSettingManager", 1, "[getRingIdCheckSpCaredFriendAndGlobalSwitch] ringId set com.tencent.mobileqq.vas.api.R.raw.qvip_special_care_default_sound. targetUin is " + str);
                return R.raw.f169448ab;
            }
            return q();
        }
        return i3;
    }

    private boolean w() {
        boolean z16;
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.f201224f) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MessageNotificationSettingManager", 2, "globalSpCaredRingEnable: invoked. ", "enable: ", Boolean.valueOf(z16), new RuntimeException());
        }
        return z16;
    }

    private boolean y(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "isLocalRingId: invoked. ", " id: ", Integer.valueOf(i3), " com.tencent.mobileqq.qqui.R.raw.system: ", Integer.valueOf(R.raw.f169478ac), " R.raw.classic: ", Integer.valueOf(R.raw.f169334j));
        }
        boolean containsKey = this.f201226i.containsKey(Integer.valueOf(i3));
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "isLocalRingId: invoked. ", " isLocal: ", Boolean.valueOf(containsKey));
        }
        return containsKey;
    }

    public boolean A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return false;
        }
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(uidFromUin, "MessageNotificationSettingManager");
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f201224f.getApp().getSharedPreferences(this.f201224f.getCurrentAccountUin(), 0).edit().putBoolean("SP_KEY_RESET_GRAY_USER_RING_ID", true).apply();
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        int q16 = q();
        N(q16);
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "playGlobalRing: invoked. ", " globalRingId: ", Integer.valueOf(q16));
        }
    }

    public void M(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) messageRecord);
            return;
        }
        int q16 = q();
        int i3 = messageRecord.istroop;
        if (i3 == 0) {
            K(messageRecord);
            return;
        }
        if (i3 == 1) {
            if (C(messageRecord)) {
                K(messageRecord);
                return;
            }
            if (TroopKeywordManager.i(messageRecord)) {
                N(R.raw.f169448ab);
                return;
            }
            TroopInfo k3 = this.f201223e.k(messageRecord.frienduin);
            if (k3 == null) {
                N(q16);
            } else {
                N((int) k3.udwCmdUinRingtoneID);
            }
        }
    }

    public void O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.e("MessageNotificationSettingManager", 2, "preDownloadRing: invoked. ", "ring-id: ", Integer.valueOf(i3));
        }
        if (i3 > 0) {
            RingUpdateBusiness ringUpdateBusiness = (RingUpdateBusiness) QQVasUpdateBusiness.getBusiness(RingUpdateBusiness.class);
            if (!y(i3) && !ringUpdateBusiness.isFileExists(i3)) {
                ringUpdateBusiness.addDownLoadListener(i3, new RingUpdateListener(this, i3));
                ringUpdateBusiness.startDownload(i3);
            }
        }
    }

    public void P(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) cVar);
        } else {
            this.f201225h = null;
        }
    }

    public void Q(List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            QLog.d("MessageNotificationSettingManager", 1, "tFriendSimpleInfoList == null");
            return;
        }
        SharedPreferences sharedPreferences = this.f201224f.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList2 = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : list) {
            if (dVar != null && !TextUtils.isEmpty(dVar.getUid())) {
                arrayList.add(dVar.getUid());
            }
        }
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        Iterator<com.tencent.qqnt.ntrelation.otherinfo.bean.c> it = iOtherInfoService.getOtherSimpleInfoWithUid(arrayList, "MessageNotificationSettingManager").iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.c next = it.next();
            if (next != null && next.c() != 0) {
                int i3 = sharedPreferences.getInt(AppConstants.Preferences.SPECIAL_SOUND_TYPE + this.f201224f.getCurrentAccountUin() + next.j(), -1);
                QLog.i("MessageNotificationSettingManager", 1, "resetGrayUserRingId: invoked.  specialSoundId: " + i3 + " uin: " + next.j() + " extensionInfo.uid " + next.c());
                if (next.c() == i3) {
                    com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(next.getUid(), next.j());
                    cVar.m();
                    cVar.p(0L);
                    arrayList2.add(cVar);
                }
            }
        }
        if (arrayList2.size() > 0) {
            iOtherInfoService.accurateUpdateNTOtherSimpleInfo(arrayList2, "MessageNotificationSettingManager", (hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
        } else {
            QLog.i("MessageNotificationSettingManager", 1, "updateOtherSimpleInfoArrayList.size is empty");
        }
    }

    public void R(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "saveGlobalRingId: invoked. ", " id: ", Integer.valueOf(i3));
        }
        if (q() != i3 && i3 != 0) {
            SettingCloneUtil.writeValueForInt(this.f201224f.getApp(), this.f201224f.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, i3);
            O(i3);
        }
    }

    public void S(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
            return;
        }
        if (i3 < 0) {
            QLog.w("MessageNotificationSettingManager", 1, "[saveNotificationInfo] ringId < 0, uin=" + str + ",ringId=" + i3);
            return;
        }
        QLog.i("MessageNotificationSettingManager", 1, "[saveNotificationInfo] uin=" + str + ",ringId=" + i3);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = iOtherInfoService.getOtherSimpleInfoWithUid(uidFromUin, "MessageNotificationSettingManager");
        if (otherSimpleInfoWithUid == null) {
            otherSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(uidFromUin, str);
        }
        long j3 = i3;
        if (otherSimpleInfoWithUid.c() != j3) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(uidFromUin, str);
            cVar.m();
            cVar.p(j3);
            iOtherInfoService.accurateUpdateNTOtherSimpleInfo(cVar, "MessageNotificationSettingManager", (hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
        }
        O(i3);
    }

    public void T(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(str));
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        iOtherInfoService.getOtherInfoWithUid(uidFromUin, "MessageNotificationSettingManager", new a(uidFromUin, str, i3, z16, iOtherInfoService));
    }

    public void U(String str, int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        TroopInfo k3 = this.f201223e.k(str);
        if (k3 == null) {
            k3 = new TroopInfo(str);
            k3.troopcode = str;
        }
        if (i3 != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 == 1024) {
            k3.setCmdUinFlagEx2(z16, 1024);
        } else if (i16 == 2048) {
            k3.setCmdUinFlagEx2(z16, 2048);
        } else if (i16 == 4096) {
            k3.setCmdUinFlagEx2(z16, 4096);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "saveTroopInfo: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(k3.cmdUinFlagEx2));
        }
    }

    public void V(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) cVar);
        } else {
            this.f201225h = cVar;
        }
    }

    public void W(FormSimpleItem formSimpleItem, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) formSimpleItem, i3);
        } else {
            X(formSimpleItem, i3, null, -1);
        }
    }

    public void X(FormSimpleItem formSimpleItem, int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, formSimpleItem, Integer.valueOf(i3), str, Integer.valueOf(i16));
        } else {
            if (formSimpleItem == null) {
                return;
            }
            Pair<String, String> t16 = t(i3, str, i16);
            formSimpleItem.setRightText(t16.first);
            formSimpleItem.setContentDescription(t16.second);
        }
    }

    public void e(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) messageRecord);
            return;
        }
        String str = messageRecord.senderuin;
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "compactUpdateRingData: invoked. ", " message.senderuin: ", str);
        }
        f(str, messageRecord.istroop);
    }

    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
            return;
        }
        if (D) {
            return;
        }
        if (i3 == 0 || B(str, i3)) {
            int a16 = com.tencent.mobileqq.notification.util.a.a(str);
            boolean z16 = z(str);
            boolean w3 = w();
            if (z16 && w3 && a16 == 0) {
                int b16 = com.tencent.mobileqq.notification.util.a.b(this.f201224f, str);
                QLog.i("MessageNotificationSettingManager", 1, "[compactUpdateRingData] update ring id.  target uin is " + str + " specialSoundId: " + b16);
                if (b16 != -1) {
                    S(str, b16);
                    return;
                }
                return;
            }
            QLog.d("MessageNotificationSettingManager", 1, "[compactUpdateRingData] ignore. ", " targetUin: ", str, " friendRingId: ", Integer.valueOf(a16), " spCareFriendRingEnable: ", Boolean.valueOf(z16), " globalSpCaredRingEnable: ", Boolean.valueOf(w3));
        }
    }

    public boolean h(String str, int i3, com.tencent.qqnt.global.settings.notification.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), aVar)).booleanValue();
        }
        if (!this.f201224f.isShowMsgContent()) {
            return true;
        }
        if (!com.tencent.qqnt.contact.friends.b.f355778a.d(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "enablePreview: invoked. ", " uin: ", str);
            }
            return true;
        }
        if (i3 == 0) {
            if (aVar != null && aVar.a() != 0) {
                return false;
            }
            return true;
        }
        if (i3 == 1) {
            TroopInfo n3 = this.f201223e.n(str);
            if (n3 == null) {
                return true;
            }
            return G(n3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "enablePreview: invoked. ", " uinType: ", Integer.valueOf(i3));
        }
        return true;
    }

    public boolean i(boolean z16, String str, int i3, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), aVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSound: invoked. ", " globalSwitch: ", Boolean.valueOf(z16), " uin: ", str, " uinType: ", Integer.valueOf(i3));
        }
        if (!z16) {
            return false;
        }
        if (!com.tencent.qqnt.contact.friends.b.f355778a.d(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSound: invoked. ", " uin: ", str);
            }
            return true;
        }
        if (i3 == 0) {
            if (aVar == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSound: invoked. ", " friendOtherInfo.messageEnableSoundNew: ", Integer.valueOf(aVar.M()));
            }
            if (aVar.M() != 0) {
                return false;
            }
            return true;
        }
        if (i3 == 1) {
            TroopInfo n3 = this.f201223e.n(str);
            if (n3 == null) {
                return true;
            }
            return H(n3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSound: invoked. ", " uinType: ", Integer.valueOf(i3));
        }
        return true;
    }

    public boolean j(String str, int i3, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), aVar)).booleanValue();
        }
        if (!com.tencent.qqnt.contact.friends.b.f355778a.d(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " uin: ", str);
            }
            return false;
        }
        if (i3 == 0) {
            if (aVar == null) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " messageEnableSoundNew: ", Integer.valueOf(aVar.M()));
            }
            if (aVar.M() == 0) {
                return true;
            }
            return false;
        }
        if (i3 == 1) {
            TroopInfo k3 = this.f201223e.k(str);
            if (k3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " troopInfo: ", k3);
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " messageEnableSound: ", Boolean.valueOf(H(k3)));
            }
            return H(k3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " uinType: ", Integer.valueOf(i3));
        }
        return false;
    }

    public boolean k(boolean z16, String str, int i3, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), aVar)).booleanValue();
        }
        if (!z16) {
            return false;
        }
        if (!com.tencent.qqnt.contact.friends.b.f355778a.d(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "enableSeparateVibrate: invoked. ", " uin: ", str);
            }
            return true;
        }
        if (i3 == 0) {
            if (aVar != null && aVar.N() != 0) {
                return false;
            }
            return true;
        }
        if (i3 == 1) {
            TroopInfo n3 = this.f201223e.n(str);
            if (n3 == null) {
                return true;
            }
            return I(n3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "enableSeparateVibrate: invoked. ", " uinType: ", Integer.valueOf(i3));
        }
        return true;
    }

    public String n(String str, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) message);
        }
        if (h(message.frienduin, message.istroop, null)) {
            return str;
        }
        return this.f201224f.getApp().getString(R.string.notification_title);
    }

    public Bitmap o(Bitmap bitmap, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bitmap, (Object) message);
        }
        if (!h(message.frienduin, message.istroop, null)) {
            return null;
        }
        return bitmap;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public String p(String str, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) message);
        }
        if (h(message.frienduin, message.istroop, null)) {
            return str;
        }
        return HardCodeUtil.qqStr(R.string.f172180o32) + message.counter + HardCodeUtil.qqStr(R.string.f172181o33);
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int readValueForInt = SettingCloneUtil.readValueForInt(this.f201224f.getApp(), this.f201224f.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, SoundAndVibrateActivity.H0);
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "getGlobalRingId: invoked. ", " soundRid: ", Integer.valueOf(readValueForInt));
        }
        return readValueForInt;
    }

    public Pair<String, String> t(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Pair) iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
        String v3 = v(i3, str, i16);
        return new Pair<>(v3, BaseApplication.context.getString(R.string.im6) + v3);
    }

    public String v(int i3, String str, int i16) {
        int i17;
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
        BaseApplication baseApplication = BaseApplication.context;
        String name2 = ((RingUpdateBusiness) QQVasUpdateBusiness.getBusiness(RingUpdateBusiness.class)).getName(i3);
        if (y(i3)) {
            name2 = this.f201226i.get(Integer.valueOf(i3));
            QLog.i("MessageNotificationSettingManager", 1, "[getRingName] uin=" + str + ", ringId=" + i3 + ", ringName=" + name2);
        } else if (i3 == 0) {
            int q16 = q();
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "setRingFormSimpleItem: invoked. from sp key:QQSETTING_NOTIFY_SOUNDTYPE_KEY ", " globalRingId: ", Integer.valueOf(q16));
            }
            if (i16 == 0) {
                i17 = u(str, q16);
            } else {
                i17 = q16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingManager", 2, "setRingFormSimpleItem: invoked. getRingIdCheckSpCaredFriendAndGlobalSwitch:: ", " targetRingId: ", Integer.valueOf(i17));
            }
            if (y(i17)) {
                name = this.f201226i.get(Integer.valueOf(i17));
            } else {
                name = ((RingUpdateBusiness) QQVasUpdateBusiness.getBusiness(RingUpdateBusiness.class)).getName(i17);
                if (TextUtils.isEmpty(name)) {
                    O(i17);
                }
            }
            QLog.i("MessageNotificationSettingManager", 1, "[getRingName] ring id is 0, uin=" + str + ", ringId=" + i3 + ", globalRingId=" + q16 + ", targetRingId=" + i17 + ", ringName=" + name);
            name2 = name;
        } else if (TextUtils.isEmpty(name2)) {
            QLog.i("MessageNotificationSettingManager", 1, "[getRingName] ring name is empty, uin=" + str + ", ringId=" + i3 + ", ringName=" + name2);
            O(i3);
        }
        if (TextUtils.isEmpty(name2)) {
            return "";
        }
        return name2;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.f201224f.getApp().getSharedPreferences(this.f201224f.getCurrentAccountUin(), 0).getBoolean("SP_KEY_RESET_GRAY_USER_RING_ID", false);
    }

    public boolean z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        String friendUidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(str);
        if (TextUtils.isEmpty(friendUidFromUin)) {
            return false;
        }
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(friendUidFromUin, "MessageNotificationSettingManager");
        boolean specialCareGlobalSwitch = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(friendUidFromUin, "MessageNotificationSettingManager");
        if (otherSimpleInfoWithUid == null || !specialCareGlobalSwitch) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, "isSpCareFriendRingEnable: invoked. ", " info: ", otherSimpleInfoWithUid, " info.globalSwitch: ", Boolean.TRUE, " info.specialRingSwitch: ", Integer.valueOf(otherSimpleInfoWithUid.e()));
        }
        if (otherSimpleInfoWithUid.e() != 1) {
            return false;
        }
        return true;
    }
}
