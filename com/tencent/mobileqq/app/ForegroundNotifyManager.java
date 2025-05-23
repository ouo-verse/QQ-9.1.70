package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.dataline.activities.LiteActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.guild.jump.model.extras.GuildManageNoticePushMsg;
import com.tencent.mobileqq.guild.message.notify.api.IGuildNotify;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.notification.TransparentNotificationFragment;
import com.tencent.mobileqq.notification.msg.MsgPushNotificationReceiver;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ForegroundNotifyManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f194637d;

    /* renamed from: e, reason: collision with root package name */
    private final String[] f194638e;

    /* renamed from: f, reason: collision with root package name */
    private final QQAppInterface f194639f;

    /* renamed from: h, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f194640h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69687);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            x();
        }
    }

    public ForegroundNotifyManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194639f = qQAppInterface;
        this.f194637d = new int[]{0, 1, 10014, 10022, 9002};
        this.f194638e = new String[]{AppConstants.ACTIVATE_FRIENDS_UIN};
    }

    private boolean A(@NonNull Message message, boolean z16) {
        if (message.istroop == 10014) {
            return ((IGuildNotify) this.f194639f.getRuntimeService(IGuildNotify.class)).shieldNotifyMainBackground(message, z16);
        }
        return z16;
    }

    public static ForegroundNotifyManager b(QQAppInterface qQAppInterface) {
        return (ForegroundNotifyManager) qQAppInterface.getManager(QQManagerFactory.FOREGROUND_NOTIFY_MANAGER);
    }

    private static SplashAIOFragment d() {
        FragmentActivity fragmentActivity;
        Activity e16 = e();
        if ((e16 instanceof SplashActivity) && 2 == SplashActivity.currentFragment) {
            fragmentActivity = (SplashActivity) e16;
        } else if (e16 instanceof ChatActivity) {
            fragmentActivity = (ChatActivity) e16;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return null;
        }
        Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(SplashAIOFragment.class.getName());
        if (!(findFragmentByTag instanceof SplashAIOFragment)) {
            QLog.w("ForegroundNotifyManager", 1, "[getCurrentAIOFragment] fragment is not SplashAIOFragment, " + findFragmentByTag);
            return null;
        }
        return (SplashAIOFragment) findFragmentByTag;
    }

    private static Activity e() {
        Activity f16;
        Activity f17;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_foreground_top_activity_first_9030", true);
        if (isSwitchOn && (f17 = f()) != null) {
            return f17;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        if (!isSwitchOn && (f16 = f()) != null) {
            return f16;
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            return baseActivity;
        }
        BaseActivity2 baseActivity2 = BaseActivity2.J;
        if (baseActivity2 != null) {
            return baseActivity2;
        }
        QLog.i("ForegroundNotifyManager", 1, "[getTopActivity] top activity is null");
        return null;
    }

    private static Activity f() {
        List<WeakReference<Activity>> resumedActivity = Foreground.getResumedActivity();
        if (resumedActivity.isEmpty()) {
            return null;
        }
        return resumedActivity.get(resumedActivity.size() - 1).get();
    }

    private static boolean h(Activity activity) {
        com.tencent.mobileqq.pad.k kVar;
        if (!(activity instanceof SplashActivity) || (kVar = ((SplashActivity) activity).getqFragmentStackManager()) == null) {
            return false;
        }
        return kVar.i();
    }

    private boolean i() {
        return ABTestController.getInstance().getExpEntity("exp_msg_push_public_v2").isExperiment();
    }

    public static boolean k() {
        boolean z16;
        boolean z17;
        if (RFWLifecycleHelper.getInstance().getTopActivity() instanceof QQGalleryActivity) {
            return false;
        }
        Activity e16 = e();
        boolean t16 = AppSetting.t(e16);
        if ((e16 instanceof SplashActivity) && 2 == SplashActivity.currentFragment) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (t16) {
            if (z16 && !h(e16)) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        boolean z18 = e16 instanceof ChatActivity;
        boolean z19 = e16 instanceof LiteActivity;
        if (e16 != null) {
            z17 = com.tencent.qqnt.aio.activity.delegatevb.a.INSTANCE.b(e16.hashCode());
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ForegroundNotifyManager", 2, "[isAio]: splashAIO= " + z16 + " chatAIO= " + z18 + " splitViewMode:" + t16 + " dataLineAIO= " + z19 + " aioDrawerOpen= " + z17);
        }
        if (((!z16 && !z18) || z17) && !z19) {
            return false;
        }
        return true;
    }

    public static boolean l(int i3, String str) {
        SplashAIOFragment d16;
        if ((RFWLifecycleHelper.getInstance().getTopActivity() instanceof QQGalleryActivity) || TextUtils.isEmpty(str) || (d16 = d()) == null) {
            return false;
        }
        AIOContact aIOContact = d16.getAIOContact();
        if (i3 != aIOContact.e() || !str.equals(aIOContact.j())) {
            return false;
        }
        return true;
    }

    private boolean m() {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity instanceof PublicFragmentActivity) {
            boolean equals = TextUtils.equals(((PublicFragmentActivity) baseActivity).getIntent().getStringExtra("public_fragment_class"), FilterMsgBoxFragment.class.getName());
            QLog.d("ForegroundNotifyManager", 1, "isFilterBox() " + equals);
            return equals;
        }
        return false;
    }

    private boolean o(Object obj) {
        boolean z16;
        if (!(obj instanceof Bundle)) {
            return false;
        }
        Bundle bundle = (Bundle) obj;
        boolean z17 = bundle.getBoolean("is_guest_notice", false);
        if (((GuildManageNoticePushMsg) bundle.getParcelable("GUILD_MANAGE_NOTICE_PUSH")) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z17 && !z16) {
            return false;
        }
        return true;
    }

    private boolean q() {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity instanceof PublicFragmentActivity) {
            boolean equals = TextUtils.equals(((PublicFragmentActivity) baseActivity).getIntent().getStringExtra("public_fragment_class"), TempMsgBoxFragment.class.getName());
            QLog.d("ForegroundNotifyManager", 1, "isMsgBox() " + equals);
            return equals;
        }
        return false;
    }

    private boolean s() {
        boolean z16;
        boolean z17 = false;
        if (RFWLifecycleHelper.getInstance().getTopActivity() instanceof QQGalleryActivity) {
            if (QLog.isColorLevel()) {
                QLog.i("ForegroundNotifyManager", 2, "[isSplashActivityMsgTab] top activity is QQGalleryActivity");
            }
            return false;
        }
        Activity e16 = e();
        if (e16 instanceof SplashActivity) {
            SplashActivity splashActivity = (SplashActivity) e16;
            if (FrameHelperActivity.Gi()) {
                if (QLog.isColorLevel()) {
                    QLog.i("ForegroundNotifyManager", 2, "[isSplashActivityMsgTab] isDrawerFrameOpenOrMoving");
                }
                return false;
            }
            int currentTab = splashActivity.getCurrentTab();
            if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183038a && !GuildSlideCoordinator.s()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i() || ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_drawer_support_push_908", true)) {
                SplitViewState a16 = com.tencent.mobileqq.pad.e.a();
                if (QLog.isColorLevel()) {
                    QLog.i("ForegroundNotifyManager", 2, "[isSplashActivitySplit]: splitViewState is " + a16);
                }
                if (a16 == SplitViewState.STATE_FLAT ? !(!z16 || splashActivity.getqFragmentStackManager().i()) : !(!z16 || 1 != SplashActivity.currentFragment)) {
                    z17 = true;
                }
                z16 = z17;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ForegroundNotifyManager", 2, "[isSplashActivityMsgTab] isMsgTag=" + z16 + ", currentTab=" + currentTab + " currentFragment= " + SplashActivity.currentFragment);
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ForegroundNotifyManager", 2, "[isSplashActivityMsgTab] top activity is not SplashActivity, top activity is " + e16);
        }
        return false;
    }

    private boolean u(String str) {
        for (String str2 : this.f194638e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static void x() {
        if (BaseApplicationImpl.getApplication() == null) {
            return;
        }
        QLog.d("ForegroundNotifyManager", 1, "registerPushReceiverOnce");
        BaseApplicationImpl.getApplication().registerReceiver(new MsgPushNotificationReceiver(), new IntentFilter("com.tencent.mobileqq.ACTION_MSG_PUSH"));
    }

    public static void y() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.ForegroundNotifyManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ABTestController.getInstance().getExpEntity("exp_msg_push_public_v2").reportExpExposure();
                }
            }
        }, 16, null, true);
    }

    private boolean z(@NonNull Message message) {
        if (message.istroop == 10014) {
            if (!k() && !((IGuildNotify) this.f194639f.getRuntimeService(IGuildNotify.class)).shieldNotifyMainForeground(message)) {
                return false;
            }
            return true;
        }
        if (i()) {
            if (!j(message) && !s()) {
                return false;
            }
            return true;
        }
        if (!k() && !s()) {
            return false;
        }
        return true;
    }

    public boolean B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (!Friends.isValidUin(str) && !u(str)) {
            return false;
        }
        return true;
    }

    public boolean C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        for (int i16 : this.f194637d) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        String currentUin = this.f194639f.getCurrentUin();
        boolean readValue = SettingCloneUtil.readValue((Context) this.f194639f.getApp(), currentUin, (String) null, AppConstants.TOP_MSG_NOTIFICATION_KEY, true);
        if (QLog.isColorLevel()) {
            QLog.i("ForegroundNotifyManager", 1, "top msg notification uin:" + currentUin + " enabled: " + readValue);
        }
        return readValue;
    }

    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, i3)).intValue();
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (C(i3)) {
            return 3;
        }
        return 4;
    }

    public Intent c(int i3, String str, String str2, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Intent) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Long.valueOf(j3));
        }
        Intent intent = new Intent("com.tencent.mobileqq.ACTION_MSG_PUSH");
        intent.setPackage(this.f194639f.getApp().getPackageName());
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra(AppConstants.Key.MSG_UNISEQ, j3);
        intent.putExtra("uinname", str2);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, i16);
        intent.putExtra(MiniChatConstants.KEY_MINI_FROM, 2);
        intent.putExtra("is_broadcast_notification", true);
        return intent;
    }

    public Intent g(int i3, String str, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Intent) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16));
        }
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra("uinname", str2);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, i16);
        intent.putExtra(MiniChatConstants.KEY_MINI_FROM, 2);
        intent.setClass(this.f194639f.getApp(), PublicTransFragmentActivity.class);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("public_fragment_class", TransparentNotificationFragment.class.getName());
        return intent;
    }

    public boolean j(@NonNull Message message) {
        Activity e16;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        if (!k() || (e16 = e()) == null || (intent = e16.getIntent()) == null) {
            return false;
        }
        String str = message.frienduin;
        String stringExtra = intent.getStringExtra("key_peerId");
        String valueOf = String.valueOf(intent.getLongExtra("key_peerUin", 0L));
        if (QLog.isColorLevel()) {
            QLog.i("ForegroundNotifyManager", 2, "[isCurrentAIOMsg]: aioUid is " + stringExtra + " aioUin is " + valueOf + " messageUin is " + str);
        }
        if (!valueOf.equals("0")) {
            return valueOf.equals(str);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        if (!((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(stringExtra).equals(str) && !TextUtils.equals(stringExtra, str)) {
            return false;
        }
        return true;
    }

    public boolean n(Message message) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.istroop;
        String str = message.frienduin;
        boolean D = D();
        boolean C = C(i3);
        if (!o(message.extObj) && !B(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        try {
            z17 = !r(message);
        } catch (Throwable th5) {
            QLog.e("ForegroundNotifyManager", 1, "isForegroundPushEnabled: failed. ", th5);
            z17 = false;
        }
        boolean z19 = !v();
        boolean z26 = !FriendsStatusUtil.c(this.f194639f.getApp());
        if (D && C && z16 && z17 && z19 && z26) {
            z18 = true;
        } else {
            z18 = false;
        }
        QLog.d("ForegroundNotifyManager", 1, "[isForegroundPushEnabled]", " shouldShowPush: ", Boolean.valueOf(z18), " switchEnabled: ", Boolean.valueOf(D), " supportedUinType: ", Boolean.valueOf(C), " noNeedShield: ", Boolean.valueOf(z17), " entranceShown: ", Boolean.valueOf(z19), " canDisturb: ", Boolean.valueOf(z26), " supportedUin: ", Boolean.valueOf(z16));
        return z18;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!MiniChatActivity.M2() && !SplashAIOFragment.INSTANCE.a()) {
            return false;
        }
        return true;
    }

    public boolean r(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.f194639f;
        if (!qQAppInterface.isBackgroundStop && !qQAppInterface.isBackgroundPause) {
            if (e() == null) {
                QLog.i("ForegroundNotifyManager", 1, "[isNeedShieldPushUi] top activity is null");
                return true;
            }
            boolean z17 = z(message);
            if (!z17 && !p() && !q() && !m()) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.d("ForegroundNotifyManager", 1, "[isNeedShieldPushUi] main process foreground ", " mainProcessNeedShield: ", Boolean.valueOf(z16), " shieldByBusiness: ", Boolean.valueOf(z17));
            return z16;
        }
        boolean t16 = b(qQAppInterface).t();
        QLog.d("ForegroundNotifyManager", 1, "[isNeedShieldPushUi] main process background ", " subProcessBackgroundStop: ", Boolean.valueOf(t16));
        return A(message, t16);
    }

    public boolean t() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            QLog.d("ForegroundNotifyManager", 1, "isSubProcessBackgroundStop: GuardManager is null");
            return false;
        }
        String foregroundProcess = guardManager.getForegroundProcess();
        if (foregroundProcess != null && !MobileQQ.PACKAGE_NAME.equals(foregroundProcess)) {
            z16 = false;
        } else {
            z16 = true;
        }
        Map<String, String> realForegroundProcessMap = GuardManager.sInstance.realForegroundProcessMap();
        if (z16) {
            Iterator<Map.Entry<String, String>> it = realForegroundProcessMap.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                QLog.d("ForegroundNotifyManager", 1, "[process] isSubProcessBackgroundStop: invoked. ", " process: ", key);
                if (!key.equals(MobileQQ.PACKAGE_NAME)) {
                    return false;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForegroundNotifyManager", 2, "[process] isSubProcessBackgroundStop: invoked. ", " foregroundProcess: ", foregroundProcess, " isSubProcessBackgroundStop: ", Boolean.valueOf(z16));
        }
        return z16;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f194640h = null;
        }
    }
}
