package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DebugSwitch;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.IGuideChangeSecretPhoneApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.loginregister.IAccountBindingApi;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rfw.common.api.IRFWCommonConfigService;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aw;
import com.tencent.mobileqq.troop.utils.bf;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.dc;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsFreControlHelper;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ThirdPart extends d {
    static IPatchRedirector $redirector_;
    public static long G;
    private final com.tencent.mobileqq.qdispatchqueue.h C;
    private a D;
    private final Runnable E;
    private Runnable F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (action != null) {
                if (action.equals("android.intent.action.TIME_SET") || action.equals("android.intent.action.DATE_CHANGED")) {
                    ((IChatsFreControlHelper) QRoute.api(IChatsFreControlHelper.class)).notifyRefreshAll(17);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68479);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            G = -1L;
        }
    }

    public ThirdPart(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.C = com.tencent.mobileqq.qdispatchqueue.d.a("ThirdPart");
        this.D = null;
        this.E = new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.s
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPart.this.xa();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Aa() {
        if (G == -1 && SplashActivity.sIsNormalRouteEnter) {
            G = SystemClock.elapsedRealtime();
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(G);
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba() {
        if (ha()) {
            return;
        }
        Context context = getContext();
        if (this.D == null && context != null) {
            this.D = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            getContext().registerReceiver(this.D, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ca() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.E);
    }

    private void Ea() {
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.v
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPart.za();
            }
        });
    }

    private void Fa() {
        if (this.F == null) {
            this.F = new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.ThirdPart.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThirdPart.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    MqqHandler mqqHandler;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    int l3 = com.tencent.mobileqq.statistics.n.l();
                    try {
                        mqqHandler = ThirdPart.this.ca();
                    } catch (Exception e16) {
                        QLog.i("ThirdPart", 1, "getQQHandler", e16);
                        mqqHandler = null;
                    }
                    if (l3 >= 0 && mqqHandler != null) {
                        mqqHandler.removeMessages(Conversation.MSG_TRIGGER_QZONE_REPORT);
                        mqqHandler.sendEmptyMessageDelayed(Conversation.MSG_TRIGGER_QZONE_REPORT, l3 * 1000);
                    }
                }
            };
        }
        ThreadManagerV2.excute(this.F, 32, null, true);
    }

    private void Ga() {
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.u
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPart.Aa();
            }
        });
    }

    private void Ha() {
        com.tencent.mobileqq.vipgift.b bVar;
        com.tencent.mobileqq.vipgift.a d16;
        if ((X9() instanceof QQAppInterface) && (bVar = (com.tencent.mobileqq.vipgift.b) ((QQAppInterface) X9()).getManager(QQManagerFactory.VIP_GIF_MANAGER)) != null && (d16 = bVar.d()) != null) {
            ra(bVar, d16);
            if (Da(bVar, d16)) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                if (baseActivity instanceof SplashActivity) {
                    ((SplashActivity) baseActivity).showGifAnnimate();
                }
            }
        }
    }

    private void Ia() {
        try {
            IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) X9().getRuntimeService(IFeatureRuntimeService.class, "all");
            com.tencent.mobileqq.theme.a.c(iFeatureRuntimeService.isFeatureSwitchEnable("navigationbar_color_init"));
            com.tencent.imcore.message.j.d(iFeatureRuntimeService.isFeatureSwitchEnable("c2c_message_report_8898"));
            com.tencent.mobileqq.msgbackup.util.f.G(iFeatureRuntimeService.isFeatureSwitchEnable("msg_back_transport_thread_890"));
            com.tencent.imcore.message.report.a.k(iFeatureRuntimeService.isFeatureSwitchEnable("message_report_890"));
        } catch (Exception e16) {
            QLog.e("ThirdPart", 1, "refreshSwitch", e16);
        }
    }

    private void Ja() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.w
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPart.this.Ba();
            }
        });
    }

    private void Ka(QQAppInterface qQAppInterface) {
        Bundle extras;
        Activity activity = getActivity();
        if (activity != null && (activity instanceof SplashActivity) && (extras = ((SplashActivity) activity).getIntent().getExtras()) != null && extras.getBoolean(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, false)) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: La, reason: merged with bridge method [inline-methods] */
    public void xa() {
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        Activity activity = getActivity();
        if (!(activity instanceof QBaseActivity)) {
            return;
        }
        dc.A((QQAppInterface) X9, (QBaseActivity) activity);
    }

    private void Ma() {
        Context context = getContext();
        a aVar = this.D;
        if (aVar != null && context != null) {
            context.unregisterReceiver(aVar);
            this.D = null;
        }
    }

    private void Na() {
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        boolean z16 = false;
        boolean isSwitchOn = iUnitedConfigManager.isSwitchOn("bug_rv_anr_122755377", false);
        QLog.d("ThirdPart", 1, "[updateRVSwitchConfig] isSwitch=" + isSwitchOn);
        DebugSwitch.sIsBreakOpReorderANR = isSwitchOn;
        if (!isSwitchOn) {
            return;
        }
        String loadAsString = iUnitedConfigManager.loadAsString("bug_rv_anr_122755377", "");
        if (TextUtils.isEmpty(loadAsString)) {
            QLog.d("ThirdPart", 1, "[updateRVSwitchConfig] configJson is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            DebugSwitch.sLoopCount = jSONObject.optInt("cnt", 200);
            if (jSONObject.optInt("printSwitch", 0) == 1) {
                z16 = true;
            }
            DebugSwitch.sIsPrintOpReorderInfo = z16;
            DebugSwitch.sOpCount = jSONObject.optInt("opCnt", 200);
        } catch (JSONException e16) {
            QLog.w("ThirdPart", 1, "[updateRVSwitchConfig] e: ", e16);
        }
        QLog.d("ThirdPart", 1, "[updateRVSwitchConfig] configJson=" + loadAsString + ", loopCnt=" + DebugSwitch.sLoopCount + ", isPrintInfo=" + DebugSwitch.sIsPrintOpReorderInfo);
    }

    private void ta() {
        FrameHelperActivity ba5 = ba();
        AppRuntime X9 = X9();
        if (X9 == null) {
            return;
        }
        boolean e16 = ((MedalWallMng) X9.getManager(QQManagerFactory.MEDAL_WALL_MNG)).e((BaseActivity) getActivity(), ba5.gi(), 1, null);
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "MSG_CHECK_MEDAL_GUIDE ret: %s", Boolean.valueOf(e16)));
        }
    }

    private void ua(int i3, Intent intent) {
        String stringExtra;
        if (-1 == i3 && intent != null && (stringExtra = intent.getStringExtra("roomId")) != null) {
            TroopUtils.e(getActivity(), stringExtra, true);
            ReportController.o(X9(), "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
        }
    }

    private void va() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.ThirdPart.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThirdPart.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime X9 = ThirdPart.this.X9();
                if (X9 != null && !com.tencent.mobileqq.phonecontact.util.e.a()) {
                    boolean checkAndUploadContact = ((IPhoneContactService) X9.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true);
                    if (QLog.isColorLevel()) {
                        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING : " + checkAndUploadContact);
                    }
                }
            }
        }, 16, null, true);
    }

    private void wa(int i3) {
        int i16;
        if (i3 == -1) {
            Activity activity = getActivity();
            if (activity instanceof QBaseActivity) {
                i16 = ((QBaseActivity) activity).getTitleBarHeight();
            } else {
                i16 = 0;
            }
            QQToast.makeText(getActivity(), 2, HardCodeUtil.qqStr(R.string.i98), 0).show(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void za() {
        if (G > 0) {
            G = 0L;
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(G);
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(G);
        }
    }

    public boolean Da(com.tencent.mobileqq.vipgift.b bVar, com.tencent.mobileqq.vipgift.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar, (Object) aVar)).booleanValue();
        }
        if (aVar != null && bVar != null) {
            if (aVar.f313121f == 3) {
                bVar.j(4L, aVar.f313118c);
            }
            AppRuntime X9 = X9();
            if (!(X9 instanceof QQAppInterface)) {
                return false;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) X9;
            if (aVar.f313121f == 2 && qQAppInterface.mAutomator.H2() && la()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        MqqHandler ca5 = ca();
        if (ca5 != null) {
            ca5.sendEmptyMessage(1054);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void J9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime X9 = X9();
        if ((X9 instanceof QQAppInterface) && PrivacyPolicyHelper.needShowPrivacyPolicyUpdateDlg()) {
            PrivacyPolicyHelper.showPrivacyPolicyUpdateDlg(getActivity(), X9.getCurrentAccountUin());
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void O9(@NonNull RecyclerView recyclerView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) recyclerView, i3);
        } else if (i3 == 0) {
            ApngImage.playByTag(2);
        } else {
            ApngImage.pauseByTag(2);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void Q9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) X9;
        ServiceAccountFolderManager d16 = ServiceAccountFolderManager.d();
        if (d16 != null) {
            d16.i(qQAppInterface);
        }
        TroopBarAssistantManager n3 = TroopBarAssistantManager.n();
        if (n3 != null) {
            n3.u(qQAppInterface);
        }
        aw.h(qQAppInterface);
        bf bfVar = (bf) X9.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
        if (bfVar != null) {
            bfVar.e(qQAppInterface);
        } else if (QLog.isColorLevel()) {
            QLog.d("ThirdPart", 2, "troopTipsMsgMgr == null");
        }
        EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) X9.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (ecShopAssistantManager != null) {
            ecShopAssistantManager.n();
        }
        com.tencent.mobileqq.app.hiddenchat.a.c(qQAppInterface).d();
        com.tencent.mobileqq.qqexpand.manager.d dVar = (com.tencent.mobileqq.qqexpand.manager.d) X9.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (dVar != null) {
            dVar.e();
        }
        if (!com.tencent.biz.qqcircle.richframework.preload.coldbootV2.i.a()) {
            QLog.d("ThirdPart", 1, "init qfs eevee");
            com.tencent.mobileqq.activity.qcircle.utils.c.d().onSend(4, null, null);
            ((IRFWCommonConfigService) QRoute.api(IRFWCommonConfigService.class)).onSend(3);
        }
        ba().oi();
        Ja();
        Na();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime X9 = X9();
        Activity activity = getActivity();
        if ((X9 instanceof QQAppInterface) && activity != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) X9;
            if (!ga()) {
                ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(X9().getCurrentAccountUin(), (byte) 2);
            }
            Ka(qQAppInterface);
            ((com.tencent.mobileqq.studymode.l) X9.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).z((BaseActivity) activity);
            com.tencent.mobileqq.studymode.r.g(X9);
            ((IGuideChangeSecretPhoneApi) QRoute.api(IGuideChangeSecretPhoneApi.class)).showGuideDialog(X9, activity);
            if (dc.p(activity.getApplicationContext())) {
                getPartRootView().setListener(new ConversationContainer.a() { // from class: com.tencent.mobileqq.activity.home.chats.biz.t
                    @Override // com.tencent.mobileqq.ui.ConversationContainer.a
                    public final void a() {
                        ThirdPart.this.Ca();
                    }
                });
                long j3 = dc.j();
                if (j3 >= 0) {
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.E);
                    ThreadManagerV2.getUIHandlerV2().postDelayed(this.E, j3 * 1000);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ThirdPart";
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1054) {
            ta();
            return true;
        }
        if (i3 == 1073) {
            ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).preloadWebProcessAsync(1);
            return true;
        }
        if (i3 == 1134061) {
            if (ia()) {
                ca().sendEmptyMessageDelayed(Conversation.MSG_QZONE_REPORT, com.tencent.mobileqq.statistics.n.f290053d * 1000);
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) appRuntime);
            return;
        }
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 1300) {
            if (i3 != 9001) {
                if (i3 != 9010) {
                    if (i3 == 9999) {
                        va();
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.activity.recent.l.F(intent, ba());
                return;
            }
            wa(i16);
            return;
        }
        ua(i16, intent);
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) logoutReason);
            return;
        }
        com.tencent.mobileqq.activity.recent.g.c().a();
        MqqHandler ca5 = ca();
        if (ca5 != null) {
            ca5.removeMessages(1073);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        Ma();
        TroopBarAssistantManager.h();
        com.tencent.mobileqq.activity.recent.o.c().i();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.E);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        Ea();
        ApngImage.pauseByTag(2);
        com.tencent.mobileqq.activity.recent.o.c().g();
        PublicAccountEventReport.f();
        com.tencent.mobileqq.activity.recent.msgbox.g.f185696a = false;
        com.tencent.mobileqq.statistics.n.f290061l = false;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        Ha();
        Ga();
        com.tencent.mobileqq.activity.recent.o.c().h();
        com.tencent.mobileqq.ark.n.c().f();
        ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).setHasPreloadWebProcessor(false);
        Activity activity2 = getActivity();
        if (activity2 instanceof QBaseActivity) {
            ((IAccountBindingApi) QRoute.api(IAccountBindingApi.class)).bindWechatIfNeed((QBaseActivity) activity2, true);
        }
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        RecentPubAccHelper.k((QQAppInterface) X9);
        Fa();
        ApngImage.playByTag(2);
    }

    public void ra(com.tencent.mobileqq.vipgift.b bVar, com.tencent.mobileqq.vipgift.a aVar) {
        Automator automator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bVar, (Object) aVar);
            return;
        }
        AppRuntime X9 = X9();
        if ((X9 instanceof QQAppInterface) && (automator = ((QQAppInterface) X9).mAutomator) != null && automator.H2() && aVar != null && aVar.f313121f == 0) {
            long j3 = aVar.f313118c;
            if (j3 != 0) {
                bVar.b(j3);
            }
        }
    }

    public void sa(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else if (!z16 && !z17) {
            Ia();
        }
    }
}
