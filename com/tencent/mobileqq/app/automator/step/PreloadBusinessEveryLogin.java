package com.tencent.mobileqq.app.automator.step;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.control.MicroStep;
import com.tencent.mobileqq.startup.control.a;
import com.tencent.mobileqq.startup.task.ch;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.report.LogManager;
import com.tencent.qqnt.aio.api.IGroupTabService;
import com.tencent.qqnt.contact.friends.NTFriendMigrationManager;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/PreloadBusinessEveryLogin;", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/Automator;", "Lcom/tencent/mobileqq/startup/control/a;", tl.h.F, "g", "Lorg/json/JSONObject;", "qlogColorConfig", "", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "doStep", "Lcom/tencent/mobileqq/startup/control/MicroStep;", "d", "Lcom/tencent/mobileqq/startup/control/MicroStep;", "microStep", "<init>", "()V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PreloadBusinessEveryLogin extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MicroStep microStep;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/PreloadBusinessEveryLogin$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54032);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PreloadBusinessEveryLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.microStep = new MicroStep();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(JSONObject qlogColorConfig) {
        if (qlogColorConfig.optInt("is_active_expiration") == 1) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            long optLong = qlogColorConfig.optLong("expiration_milliseconds");
            long decodeLong = from.decodeLong("qlog_gray_version_color_log_expired_record_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (decodeLong == 0) {
                from.encodeLong("qlog_gray_version_color_log_expired_record_time", currentTimeMillis);
                QLog.i("AutoMonitor", 1, "handleQlogColorExpired, record time\u3002currentTimeMillis=" + currentTimeMillis);
                return;
            }
            boolean decodeBool = from.decodeBool("qlog_gray_version_color_log_expired_had_set", false);
            QLog.i("AutoMonitor", 1, "handleQlogColorExpired, qlogUsrHadSet=" + decodeBool);
            if (!decodeBool && currentTimeMillis - (decodeLong + optLong) >= 0) {
                NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_MANUAL_SET_LOG_LEVEL);
                newIntent.putExtra("opType", LogManager.OP_DEL_LOGLEVEL);
                newIntent.putExtra("manualLogLevel", 1);
                if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
                    MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
                    from.encodeBool("qlog_gray_version_color_log_expired_had_set", true);
                    QLog.i("AutoMonitor", 1, "handleQlogColorExpired set log level is USR!");
                }
            }
        }
    }

    private final com.tencent.mobileqq.startup.control.a g() {
        return this.microStep.d(MicroStep.BusinessTag.MsfSDK, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$result$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.sendRegisterPush();
                    MsfServiceSdk.get().registerProxyDone();
                }
            }
        }).c(this.microStep.d(MicroStep.BusinessTag.BasicConversation, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MqqHandler handler = ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getHandler(Conversation.class);
                if (handler != null) {
                    handler.obtainMessage(Conversation.MSG_AFTER_SYNC_MSG).sendToTarget();
                }
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.BasicTroop, PreloadBusinessEveryLogin$initMicroStep$2.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.TABInit, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ch.Companion companion = ch.INSTANCE;
                companion.d();
                if (1 == MobileQQ.sProcessId) {
                    companion.f();
                    IRuntimeService runtimeService = ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getRuntimeService(IGroupTabService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "mAutomator.app.getRuntim\u2026nt.MAIN\n                )");
                    IGroupTabService iGroupTabService = (IGroupTabService) runtimeService;
                    if (QLog.isColorLevel()) {
                        QLog.d("GroupTab", 2, "service=" + iGroupTabService + " onLogin");
                    }
                    iGroupTabService.onLogin();
                }
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.Hippy, PreloadBusinessEveryLogin$initMicroStep$4.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.BasicCrash, PreloadBusinessEveryLogin$initMicroStep$5.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.BasicMessage, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getMsgHandler().l5();
                    ThirdPushManager.getInstance().registerThirdPartyPush();
                }
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.RelationInitExtensionInfo, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Manager manager = ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getManager(QQManagerFactory.FRIENDS_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
                ((FriendsManager) manager).V();
                com.tencent.mobileqq.mutualmark.nt.f.f252196a.t();
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.BasicProxyInit, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getProxyManager().start();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.BasicColorNoteInit, PreloadBusinessEveryLogin$initMicroStep$9.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.NTMsgMigration, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$10
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    NTMsgMigrationManager.INSTANCE.a().N();
                    NTFriendMigrationManager.f355770b.a().d(((Automator) PreloadBusinessEveryLogin.this.mAutomator).E);
                }
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.BasicAccountPhone, PreloadBusinessEveryLogin$initMicroStep$11.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.GuildTabSpec, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$12
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IRuntimeService runtimeService = ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getRuntimeService(IGuildDelayInitializeService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "mAutomator.app.getRuntim\u2026ava, ProcessConstant.ALL)");
                ((IGuildDelayInitializeService) runtimeService).checkSessionInitComplete();
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.PskeyPreload, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$13
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IRuntimeService runtimeService = ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getRuntimeService(IPskeyManager.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "mAutomator.app.getRuntim\u2026onstant.ALL\n            )");
                ((IPskeyManager) runtimeService).updateAllPskeyAndUskey();
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.MsfTicketRefresh, PreloadBusinessEveryLogin$initMicroStep$14.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.BasicSplashRecord, PreloadBusinessEveryLogin$initMicroStep$15.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.GdtAd, PreloadBusinessEveryLogin$initMicroStep$16.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.SafeO3SDK, PreloadBusinessEveryLogin$initMicroStep$17.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.PreReflection, PreloadBusinessEveryLogin$initMicroStep$18.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.PreCreateRuntimeService, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$19
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getRuntimeService(IPreDownloadController.class, "");
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.YYB, PreloadBusinessEveryLogin$initMicroStep$20.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.RuntimeConfigLoad, PreloadBusinessEveryLogin$initMicroStep$21.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.QLogGrayVersionColorExpired, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$22
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("AutoMonitor", 2, "trigger QLogGrayVersionColorExpired.");
                if (AppSetting.isGrayVersion()) {
                    try {
                        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qlog_gray_version_color_log_expired", "");
                        QLog.i("AutoMonitor", 1, "qlogGrayVersionColorExpiredConfig=" + loadAsString);
                        if (TextUtils.isEmpty(loadAsString)) {
                            return;
                        }
                        PreloadBusinessEveryLogin.this.c(new JSONObject(loadAsString));
                        return;
                    } catch (Throwable th5) {
                        QLog.e("AutoMonitor", 1, "QLogGrayVersionColorExpired", th5);
                        return;
                    }
                }
                QLog.i("AutoMonitor", 1, "not gray version\uff0creset time 0L");
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                from.encodeLong("qlog_gray_version_color_log_expired_record_time", 0L);
                from.encodeBool("qlog_gray_version_color_log_expired_had_set", false);
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.NotificationConfigReport, PreloadBusinessEveryLogin$initMicroStep$23.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.AvatarNotifySyncEnd, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin$initMicroStep$24
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessEveryLogin.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("AutoMonitor", 2, "avatar notifySyncEnd");
                IRuntimeService runtimeService = ((Automator) PreloadBusinessEveryLogin.this.mAutomator).E.getRuntimeService(IQQAvatarHandlerService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "mAutomator.app.getRuntim\u2026nstant.MAIN\n            )");
                ((IQQAvatarHandlerService) runtimeService).notifySyncQQHead();
            }
        })).c(this.microStep.d(MicroStep.BusinessTag.AddShortCut, PreloadBusinessEveryLogin$initMicroStep$25.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.WVMainProc, PreloadBusinessEveryLogin$initMicroStep$26.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.PYMK, PreloadBusinessEveryLogin$initMicroStep$27.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.StudyMode, PreloadBusinessEveryLogin$initMicroStep$28.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.FlashTransferServiceInit, PreloadBusinessEveryLogin$initMicroStep$29.INSTANCE)).c(this.microStep.d(MicroStep.BusinessTag.QavInit, PreloadBusinessEveryLogin$initMicroStep$30.INSTANCE));
    }

    private final com.tencent.mobileqq.startup.control.a h() {
        return new a.c(23).b(71).b(70).b(67).b(69).b(19).b(9).b(72).b(73).b(42).b(75);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        String f16 = g().f();
        QLog.i("AutoMonitor", 1, "PreloadBusiness, every login micro step: " + f16);
        com.tencent.mobileqq.app.automator.h.a((Automator) this.mAutomator, f16).run();
        String f17 = h().f();
        QLog.i("AutoMonitor", 1, "PreloadBusiness, every login step: " + f17);
        com.tencent.mobileqq.app.automator.h.a((Automator) this.mAutomator, f17).run();
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.microStep.b();
        }
    }
}
