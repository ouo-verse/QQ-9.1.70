package com.tencent.mobileqq.springhb.entry.worker;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.ak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.module.m;
import com.tencent.mobileqq.springhb.module.ConversationHongBaoV2;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010]\u001a\u00020\\\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010=\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b%\u0010;\u001a\u0004\b/\u0010<R\u0017\u0010B\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010H\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR$\u0010N\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010J\u001a\u0004\bD\u0010K\"\u0004\bL\u0010MR\u0011\u0010Q\u001a\u00020O8F\u00a2\u0006\u0006\u001a\u0004\b5\u0010PR\u0011\u0010U\u001a\u00020R8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010X\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010Z\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bY\u0010WR\u0014\u0010[\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010W\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/d;", "Lcom/tencent/mobileqq/springhb/module/g;", "", "onBackPressed", "", "onCreate", "c", "d", "onResume", "onBeforeAccountChanged", "onAccountChanged", "onPostThemeChanged", "b", "a", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "r0", "Lcom/tencent/mobileqq/activity/home/ak;", "Lcom/tencent/mobileqq/activity/home/ak;", "i", "()Lcom/tencent/mobileqq/activity/home/ak;", "conversationApi", "Lcom/tencent/mobileqq/springhb/entry/worker/e;", "Lcom/tencent/mobileqq/springhb/entry/worker/e;", "l", "()Lcom/tencent/mobileqq/springhb/entry/worker/e;", "lifeCycleMonitor", "Lcom/tencent/mobileqq/springhb/module/ConversationHongBaoV2;", "Lcom/tencent/mobileqq/springhb/module/ConversationHongBaoV2;", "k", "()Lcom/tencent/mobileqq/springhb/module/ConversationHongBaoV2;", "hongBaoCtrlV2", "Lcom/tencent/mobileqq/springhb/entry/module/b;", "Lcom/tencent/mobileqq/springhb/entry/module/b;", tl.h.F, "()Lcom/tencent/mobileqq/springhb/entry/module/b;", "breathLightModule", "Lcom/tencent/mobileqq/springhb/entry/module/m;", "e", "Lcom/tencent/mobileqq/springhb/entry/module/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/springhb/entry/module/m;", "tabBannerModule", "Lcom/tencent/mobileqq/springhb/entry/module/c;", "f", "Lcom/tencent/mobileqq/springhb/entry/module/c;", "p", "()Lcom/tencent/mobileqq/springhb/entry/module/c;", "pendantModule", "Lcom/tencent/mobileqq/springhb/entry/worker/h;", "g", "Lcom/tencent/mobileqq/springhb/entry/worker/h;", "r", "()Lcom/tencent/mobileqq/springhb/entry/worker/h;", "taskExecutor", "Lcom/tencent/mobileqq/springhb/entry/worker/c;", "Lcom/tencent/mobileqq/springhb/entry/worker/c;", "()Lcom/tencent/mobileqq/springhb/entry/worker/c;", "activityExecutor", "Lcom/tencent/mobileqq/springhb/entry/worker/f;", "Lcom/tencent/mobileqq/springhb/entry/worker/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/springhb/entry/worker/f;", "mainActivityExecutor", "Lcom/tencent/mobileqq/springhb/network/a;", "j", "Lcom/tencent/mobileqq/springhb/network/a;", "o", "()Lcom/tencent/mobileqq/springhb/network/a;", "observer", "Lcom/tencent/mobileqq/springhb/entry/model/BaseActivityData;", "Lcom/tencent/mobileqq/springhb/entry/model/BaseActivityData;", "()Lcom/tencent/mobileqq/springhb/entry/model/BaseActivityData;", "u", "(Lcom/tencent/mobileqq/springhb/entry/model/BaseActivityData;)V", "curActivityData", "Lcom/tencent/mobileqq/app/QQAppInterface;", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/springhb/entry/SpringFestivalEntryManager;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/springhb/entry/SpringFestivalEntryManager;", "manager", "t", "()Z", "isStudyOrElderMode", ReportConstant.COSTREPORT_PREFIX, "isAllowLandscape", "isShowingTabBanner", "Lcom/tencent/mobileqq/activity/home/Conversation;", "conversation", "<init>", "(Lcom/tencent/mobileqq/activity/home/Conversation;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d implements com.tencent.mobileqq.springhb.module.g {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ak conversationApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e lifeCycleMonitor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConversationHongBaoV2 hongBaoCtrlV2;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.module.b breathLightModule;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m tabBannerModule;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.module.c pendantModule;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h taskExecutor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c activityExecutor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mainActivityExecutor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.network.a observer;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseActivityData curActivityData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.worker.d$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60670);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
            return;
        }
        this.conversationApi = new ak(conversation);
        this.lifeCycleMonitor = new e(this);
        this.hongBaoCtrlV2 = new ConversationHongBaoV2(this, conversation);
        this.breathLightModule = new com.tencent.mobileqq.springhb.entry.module.b(this);
        this.tabBannerModule = new m(this);
        this.pendantModule = new com.tencent.mobileqq.springhb.entry.module.c(this);
        this.taskExecutor = new h(this);
        this.activityExecutor = new c(this);
        this.mainActivityExecutor = new f(this);
        this.observer = new com.tencent.mobileqq.springhb.network.a(this);
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            this.hongBaoCtrlV2.w0();
            this.lifeCycleMonitor.i();
        }
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            this.hongBaoCtrlV2.x0();
            this.lifeCycleMonitor.j();
        }
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        this.lifeCycleMonitor.p();
        n().k0();
        this.taskExecutor.o(false);
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        ConversationHongBaoV2 conversationHongBaoV2 = this.hongBaoCtrlV2;
        int i3 = conversationHongBaoV2.f289415m;
        if (i3 != -1 && i3 != 1) {
            conversationHongBaoV2.f289408h.H1 = true;
            conversationHongBaoV2.H = true;
            conversationHongBaoV2.H = true;
        }
        conversationHongBaoV2.D0();
        this.lifeCycleMonitor.m();
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.tabBannerModule.x();
    }

    @NotNull
    public final c f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.activityExecutor;
    }

    @NotNull
    public final QQAppInterface g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.conversationApi.b();
    }

    @NotNull
    public final com.tencent.mobileqq.springhb.entry.module.b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.springhb.entry.module.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.breathLightModule;
    }

    @NotNull
    public final ak i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ak) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.conversationApi;
    }

    @Nullable
    public final BaseActivityData j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (BaseActivityData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.curActivityData;
    }

    @NotNull
    public final ConversationHongBaoV2 k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConversationHongBaoV2) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.hongBaoCtrlV2;
    }

    @NotNull
    public final e l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.lifeCycleMonitor;
    }

    @NotNull
    public final f m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (f) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mainActivityExecutor;
    }

    @NotNull
    public final SpringFestivalEntryManager n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SpringFestivalEntryManager) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        Manager manager = g().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager");
        return (SpringFestivalEntryManager) manager;
    }

    @NotNull
    public final com.tencent.mobileqq.springhb.network.a o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.springhb.network.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.observer;
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.lifeCycleMonitor.g();
        }
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public boolean onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onBeforeAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.hongBaoCtrlV2.u0();
        }
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            n().t0(this.activityExecutor);
            g().registObserver(this.observer);
        }
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        n().t0(null);
        this.activityExecutor.p();
        this.breathLightModule.o();
        this.tabBannerModule.z();
        g().unRegistObserver(this.observer);
        this.observer.f();
        this.taskExecutor.n();
        this.lifeCycleMonitor.h();
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onLogout(@NotNull Constants.LogoutReason reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) reason);
        } else {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.hongBaoCtrlV2.z0(reason);
        }
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            this.hongBaoCtrlV2.A0();
            this.lifeCycleMonitor.k();
        }
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (!b.f289157a.d()) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateMiniAppList(100);
        }
        n().k0();
        this.taskExecutor.o(false);
        this.hongBaoCtrlV2.B0();
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            this.hongBaoCtrlV2.C0();
            this.lifeCycleMonitor.m();
        }
    }

    @NotNull
    public final com.tencent.mobileqq.springhb.entry.module.c p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.springhb.entry.module.c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.pendantModule;
    }

    @NotNull
    public final m q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (m) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.tabBannerModule;
    }

    @NotNull
    public final h r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (h) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.taskExecutor;
    }

    @Override // com.tencent.mobileqq.springhb.module.g
    public void r0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            this.lifeCycleMonitor.l();
        }
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return AppSetting.o(null);
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (!StudyModeManager.t() && !SimpleUIUtil.isNowElderMode()) {
            return false;
        }
        return true;
    }

    public final void u(@Nullable BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) baseActivityData);
        } else {
            this.curActivityData = baseActivityData;
        }
    }
}
