package com.tencent.mobileqq.activity.framebusiness;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.guild.api.ILocalFocusService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.guild.api.IGuildABTestApi;
import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IGuildUnreadEventApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.report.model.PushReportData;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.util.cv;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GuildInjectImpl extends com.tencent.mobileqq.activity.framebusiness.a implements IGuildConfigApi.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f182276e;

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<FrameFragment> f182277f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f182278d;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment.DragViewTouchListener f182281d;

        a(FrameFragment.DragViewTouchListener dragViewTouchListener) {
            this.f182281d = dragViewTouchListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuildInjectImpl.this, (Object) dragViewTouchListener);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport(com.tencent.mobileqq.dt.api.c.R, motionEvent);
            return this.f182281d.onTouch(view, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends FrameFragment.DragViewPunctureClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f182283d;

        b(Context context) {
            this.f182283d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuildInjectImpl.this, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                GuildInjectImpl.this.Y("initiative");
                ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).startGuildTabInitTask(0);
                ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).onGuildTabClick(view, this.f182283d);
                QLog.i("Guild.tab.GuildInjectImpl", 1, "onGuildTabClick " + this.f182283d);
                super.onClick(view);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68301);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f182276e = false;
        }
    }

    public GuildInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f182278d = false;
        }
    }

    private static void G(FrameFragment frameFragment) {
        try {
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).adjustTab(frameFragment.getBaseActivity());
        } catch (NullPointerException e16) {
            QLog.d("Guild.tab.GuildInjectImpl", 4, e16, "adjustTabSafely");
        }
    }

    private boolean H(FrameFragment frameFragment) {
        Bundle extras;
        Intent intent = frameFragment.getBaseActivity().getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.getBoolean(IGuildMainFrameApi.GOTO_CONVERSATION_TAB, false)) {
            return false;
        }
        intent.putExtra(IGuildMainFrameApi.GOTO_CONVERSATION_TAB, false);
        if (extras.getBoolean(IGuildMainFrameApi.OPEN_CONVERSATION_TAG, false)) {
            FrameFragment.d dVar = frameFragment.mTabIndicator;
            int currentTab = dVar.getCurrentTab();
            int i3 = com.tencent.mobileqq.activity.home.impl.a.f183038a;
            if (currentTab != i3) {
                dVar.setCurrentTab(i3);
            }
        }
        if (FrameHelperActivity.Gi()) {
            FrameHelperActivity.Zh();
        }
        QLog.d("Guild.tab.GuildInjectImpl", 1, "handleJumpAction to ConversationTab ", extras);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).handleConversationJump(frameFragment, extras);
        return true;
    }

    private boolean I(FrameFragment frameFragment) {
        Intent intent = frameFragment.getBaseActivity().getIntent();
        if (intent == null || !intent.getBooleanExtra("openGuildWithSplash", false)) {
            return false;
        }
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).openGuildWithSplash(frameFragment.getContext(), intent);
        QLog.d("Guild.tab.GuildInjectImpl", 1, "checkGuildStandaloneJump true");
        J(frameFragment);
        return true;
    }

    private void J(FrameFragment frameFragment) {
        Bundle extras;
        Intent intent = frameFragment.getBaseActivity().getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.getBoolean(IGuildMainFrameApi.GOTO_GUILD_TAB, false)) {
            intent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, false);
            if (!this.f182278d) {
                Y("initiative");
            }
            frameFragment.mTabIndicator.setCurrentTab(com.tencent.mobileqq.activity.home.impl.a.f183047j);
            if (FrameHelperActivity.Gi()) {
                FrameHelperActivity.Zh();
            }
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).handleJumpAction(frameFragment, extras);
            QLog.d("Guild.tab.GuildInjectImpl", 1, "handleJumpAction to GuildTab");
        }
    }

    public static boolean K(Context context) {
        String currentUin = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
        if (TabDataHelper.isTabJumpGuildSwitchOn(context, currentUin) && com.tencent.mobileqq.activity.framebusiness.controllerinject.j.b(context, currentUin)) {
            return true;
        }
        return false;
    }

    public static boolean L() {
        return f182276e;
    }

    public static boolean M(Context context) {
        return ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName().equals(TabDataHelper.getTabCurrentManualTag(context, BaseApplicationImpl.getApplication().getRuntime().getCurrentUin()));
    }

    public static boolean N() {
        return true;
    }

    private void O(FrameFragment frameFragment) {
        boolean z16;
        String currentUin = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
        String name = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName();
        boolean K = K(frameFragment.getContext());
        if (com.tencent.mobileqq.activity.framebusiness.controllerinject.j.a() && M(frameFragment.getContext())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || K) {
            QLog.d("Guild.tab.GuildInjectImpl", 1, "setCurrentTabByTag: " + name, " manual", Boolean.valueOf(z16), " isFirstSwitchToGuild", Boolean.valueOf(K));
            if (!z16 && com.tencent.mobileqq.app.guardcallback.h.e()) {
                TabDataHelper.putGroundToggleGuildInit(frameFragment.getContext(), currentUin, true);
            }
            String str = "restart";
            if (K) {
                str = "default";
            }
            try {
                Y(str);
                ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).startGuildTabInitTask(1);
                frameFragment.mTabIndicator.setCurrentTabByTag(name);
                cv.b();
            } catch (Exception e16) {
                QLog.e("Guild.tab.GuildInjectImpl", 1, "setCurrentTabByTag: " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Q(FrameFragment frameFragment) {
        QLog.i("Guild.tab.GuildInjectImpl", 1, "onTabFrameConstruct() addFrame running delayed task");
        a0(frameFragment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(AppInterface appInterface, PushReportData pushReportData) {
        ((com.tencent.mobileqq.guild.report.g) appInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportHandlerName())).L0(pushReportData);
    }

    private void T(FrameFragment frameFragment, int i3) {
        ((ILocalFocusService) ((AppInterface) frameFragment.app).getRuntimeService(ILocalFocusService.class, "")).setActiveTab(((IGuildTempApi) QRoute.api(IGuildTempApi.class)).convActiveTab(i3));
    }

    private void U(com.tencent.mobileqq.activity.home.impl.d dVar, final FrameFragment frameFragment, TabFrameControllerImpl tabFrameControllerImpl) {
        com.tencent.mobileqq.perf.startup.f.g("GuildInjectImpl.onTabFrameConstruct");
        boolean b06 = b0(dVar.c("GUILD"));
        if (Z("onTabFrameConstruct() addFrame", f182276e)) {
            View view = frameFragment.mTabViewMap.get("GUILD");
            if (view == null) {
                view = ((ITabFrameController) QRoute.api(ITabFrameController.class)).buildSingleTabIcon("GUILD", frameFragment);
            }
            tabFrameControllerImpl.addFrame(frameFragment, frameFragment.mRootView, ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass(), view);
            String str = com.tencent.mobileqq.activity.home.impl.b.f183056s;
            frameFragment.setTabNotifyIcon(str, view);
            frameFragment.setTabNotifyIcon(str + "_num", view.findViewById(R.id.khc));
            ((IGuildDelayInitializeService) frameFragment.app.getRuntimeService(IGuildDelayInitializeService.class, "all")).scheduleTask(new IGuildDelayInitializeService.InitializeTask("onTabFrameConstruct() addFrame", new Function0() { // from class: com.tencent.mobileqq.activity.framebusiness.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Q;
                    Q = GuildInjectImpl.Q(FrameFragment.this);
                    return Q;
                }
            }));
        } else if (frameFragment.getFrame(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass()) != null) {
            QLog.i("Guild.tab.GuildInjectImpl", 1, "removeFrame: " + ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
            if (TabFrameControllerImpl.isLazyLoadTabView()) {
                frameFragment.mTabViewMap.remove("GUILD");
            }
            frameFragment.mTabDragIcon.remove(com.tencent.mobileqq.activity.home.impl.a.f183047j);
            frameFragment.mTabTextView.remove(com.tencent.mobileqq.activity.home.impl.a.f183047j);
            frameFragment.removeFrame(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
        }
        if (b06) {
            G(frameFragment);
        }
        com.tencent.mobileqq.perf.startup.f.h("GuildInjectImpl.onTabFrameConstruct");
    }

    private void V(FrameFragment frameFragment) {
        Intent intent = frameFragment.getBaseActivity().getIntent();
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra(PushReportData.GUILD_NOTIFY_REPORT);
        intent.removeExtra(PushReportData.GUILD_NOTIFY_REPORT);
        AppRuntime appRuntime = frameFragment.app;
        if ((parcelableExtra instanceof PushReportData) && (appRuntime instanceof AppInterface)) {
            final AppInterface appInterface = (AppInterface) appRuntime;
            final PushReportData pushReportData = (PushReportData) parcelableExtra;
            pushReportData.setAction("click");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildInjectImpl.R(AppInterface.this, pushReportData);
                }
            }, 128, null, false);
            Y("qq_push");
        }
    }

    private void W(FrameFragment frameFragment, int i3, be beVar, int i16) {
        TianshuRedTouch redBadge;
        boolean z16;
        if (frameFragment != null && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183056s)) != null) {
            String tabNameFromTabIndex = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getTabNameFromTabIndex(i16);
            if (tabNameFromTabIndex != null) {
                z16 = tabNameFromTabIndex.equals(com.tencent.mobileqq.activity.home.impl.b.G);
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.activity.home.impl.b.j(redBadge, com.tencent.mobileqq.activity.home.impl.b.g(101), com.tencent.mobileqq.activity.home.impl.b.f(redBadge.O()), Boolean.valueOf(z16));
        }
    }

    private void X(ImmersiveTitleBar2 immersiveTitleBar2, Window window) {
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            ImmersiveUtils.setStatusTextColorNew(false, window);
        } else {
            SimpleUIUtil.adjustSimpleStatusBar(immersiveTitleBar2, window);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str) {
        com.tencent.mobileqq.guild.report.b.g(str, "Guild.tab.GuildInjectImpl");
        this.f182278d = true;
    }

    private static boolean Z(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.tab.GuildInjectImpl", 2, "will handle by ", str, " ? ", Boolean.valueOf(z16));
        }
        return z16;
    }

    private static void a0(FrameFragment frameFragment) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeakReference.this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                FrameFragment frameFragment2 = (FrameFragment) WeakReference.this.get();
                if (frameFragment2 == null) {
                    QLog.e("Guild.tab.GuildInjectImpl", 1, "updateGuildRedDotAsync() fragment is null, won't update red dot anymore");
                    return false;
                }
                com.tencent.mobileqq.perf.startup.f.g("updateGuildRedDotAsync.execute");
                UnreadInfo.a guildTabUnreadCountSafely = ((IGuildDelayInitializeService) frameFragment2.app.getRuntimeService(IGuildDelayInitializeService.class, "")).getGuildTabUnreadCountSafely();
                ((IGuildUnreadEventApi) QRoute.api(IGuildUnreadEventApi.class)).notifyEvent();
                if (guildTabUnreadCountSafely.getCount() <= 0) {
                    frameFragment2.updateMain(48, 16, 0);
                } else {
                    ((IGuildABTestApi) QRoute.api(IGuildABTestApi.class)).setGuildTabGrayRedPointShowTime(System.currentTimeMillis(), "updateGuildRedDotAsync");
                    if (guildTabUnreadCountSafely.getIsStrongUnread()) {
                        frameFragment2.updateMain(48, 16, Integer.valueOf(guildTabUnreadCountSafely.getCount()));
                    } else {
                        frameFragment2.updateMain(48, 18, Boolean.TRUE);
                    }
                }
                com.tencent.mobileqq.perf.startup.f.h("updateGuildRedDotAsync.execute");
                return false;
            }
        });
    }

    private static boolean b0(boolean z16) {
        if (z16 == f182276e) {
            return false;
        }
        f182276e = z16;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public static void c0(@NonNull FrameFragment frameFragment) {
        View view;
        final TextView textView;
        final String guildTabName = ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getGuildTabName();
        QLog.i("Guild.tab.GuildInjectImpl", 1, "updateTabText: " + guildTabName);
        if (frameFragment.mTabTextView == null || frameFragment.getActivity() == null || frameFragment.getActivity().isFinishing() || (view = frameFragment.mTabViewMap.get("GUILD")) == null || (textView = (TextView) view.findViewById(R.id.kbi)) == null || TextUtils.equals(textView.getText().toString(), guildTabName)) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.c
            @Override // java.lang.Runnable
            public final void run() {
                textView.setText(guildTabName);
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
        frameInfoByClazz.w(com.tencent.mobileqq.activity.home.impl.a.f183047j);
        QLog.d("Guild.tab.GuildInjectImpl", 1, "doOnUpdateFrameInfo className: " + frameInfoByClazz.k().getName() + " tabIndex: " + frameInfoByClazz.l());
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) frameFragment);
            return;
        }
        if (!frameFragment.mIsFirst) {
            V(frameFragment);
        }
        if (I(frameFragment) || H(frameFragment) || !Z("doOnResumeAfter()", f182276e)) {
            return;
        }
        c0(frameFragment);
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).onSplashActivityResume();
        if (f182276e) {
            O(frameFragment);
        }
        J(frameFragment);
        W(frameFragment, 0, null, -1);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void b(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, tabFrameControllerImpl, frameFragment, dVar);
        } else {
            U(dVar, frameFragment, tabFrameControllerImpl);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void c(FrameFragment frameFragment) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameFragment);
            return;
        }
        be frame = frameFragment.getFrame(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
        ViewGroup viewGroup = frameFragment.mTabWidget;
        if (viewGroup != null) {
            i3 = viewGroup.getHeight();
        } else {
            i3 = -1;
        }
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).onPostThemeChanged(frame, i3);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void e(Context context, HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, (Object) hashMap);
        } else if (hashMap != null && hashMap.get("GUILD") != null) {
            hashMap.get("GUILD").setOnClickListener(new b(context));
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void f(TianshuRedTouch tianshuRedTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        TianshuRedTouch redBadge;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, tianshuRedTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else {
            if (i3 != 48 || (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183056s)) == null) {
                return;
            }
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedBadge(frameFragment, 48, redBadge, redTypeInfo);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi.a
    @WorkerThread
    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        final FrameFragment frameFragment = f182277f.get();
        if (frameFragment != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildInjectImpl.c0(FrameFragment.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "GUILD";
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public boolean h(com.tencent.mobileqq.activity.home.impl.d dVar, FrameFragment frameFragment) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) dVar, (Object) frameFragment)).booleanValue();
        }
        boolean c16 = dVar.c("GUILD");
        if (L() != c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder b16 = dVar.b();
        b16.append("toShowGuild: ");
        b16.append(c16);
        b16.append(" ");
        b16.append("isGuildTabChange: ");
        b16.append(z16);
        b16.append(" ");
        c0(frameFragment);
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void i(RedTouch redTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, redTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
            return;
        }
        if (i3 == 48) {
            StringBuilder sb5 = new StringBuilder();
            String str = com.tencent.mobileqq.activity.home.impl.b.f183056s;
            sb5.append(str);
            sb5.append("_num");
            QUIBadge qUIBadge = (QUIBadge) frameFragment.getTabNotifyIcon(sb5.toString());
            if (qUIBadge != null && frameFragment.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183047j) {
                qUIBadge.setOnModeChangeListener(frameFragment.mDragHost);
                qUIBadge.setDragGroup(str);
                qUIBadge.setDragType(2);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void k(HashMap<String, View> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, hashMap, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            W(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerInit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        super.onFragmentDrawerInit(z16);
        if (z16) {
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).onDrawerInit();
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void q(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void r(com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) dVar);
        } else {
            dVar.f("GUILD", ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void s(FrameFragment frameFragment, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, frameFragment, Integer.valueOf(i3), str);
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(str) { // from class: com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f182280d;

                {
                    this.f182280d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildInjectImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TabDataHelper.updateTabCurrentManualTag(BaseApplication.getContext(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), this.f182280d);
                    }
                }
            }, 500L);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            TabFrameControllerImpl.registerFrameInfo(c.b.B().H("GUILD").F(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass()).L(true).G(com.tencent.mobileqq.activity.home.impl.a.f183047j).Q(com.tencent.mobileqq.activity.home.impl.b.f183056s).w(R.drawable.qui_tab_guild_default).x(R.drawable.qui_tab_guild_default_pressed).N(R.string.f139690by).t(19).u(0).y(R.drawable.qui_tab_guild_simple).z(R.drawable.qui_tab_guild_simple_pressed).J("channel.json").I("channel_back.json").D(-1).E(-1).M(true).K(true).C(((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getGuildTabName()).P(TabDataHelper.VALUE_SETTING_GUIDE_REPORT).O(TabDataHelper.VALUE_SETTING_GUIDE_CLICK).v(R.drawable.qui_tab_guild_default_dark).R(R.drawable.skin_tab_icon_5).A());
            GuildAppReportSourceInfo.setAppStartTime(SystemClock.uptimeMillis());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void v(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameFragment, (Object) str);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabContentDescription(frameFragment, com.tencent.mobileqq.activity.home.impl.b.f183056s, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void w(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) frameFragment, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void x(FrameFragment frameFragment, FrameFragment.DragViewTouchListener dragViewTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) frameFragment, (Object) dragViewTouchListener);
            return;
        }
        View view = frameFragment.mTabViewMap.get("GUILD");
        if (view == null) {
            return;
        }
        TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) view.findViewById(R.id.j_k);
        TextView textView = (TextView) view.findViewById(R.id.kbi);
        TabDragAnimationView.G(textView);
        int i3 = com.tencent.mobileqq.activity.home.impl.a.f183047j;
        tabDragAnimationView.setOnTouchListener(new a(dragViewTouchListener));
        tabDragAnimationView.h("\u793e\u7fa4");
        frameFragment.mTabDragIcon.put(i3, tabDragAnimationView);
        frameFragment.mTabTextView.put(i3, textView);
        QLog.d("Guild.tab.GuildInjectImpl", 1, "doOnTabDragIconAddTv GuildTab=", i3 + "\uff0c mTabDragIcon=" + tabDragAnimationView);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        IGuildUnreadCntService.b bVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
            return;
        }
        W(frameFragment, i3, beVar, i16);
        StringBuilder sb5 = new StringBuilder();
        String str = com.tencent.mobileqq.activity.home.impl.b.f183056s;
        sb5.append(str);
        sb5.append("_num");
        QUIBadge qUIBadge = (QUIBadge) frameFragment.getTabNotifyIcon(sb5.toString());
        if (i16 == com.tencent.mobileqq.activity.home.impl.a.f183047j) {
            if (qUIBadge != null) {
                qUIBadge.setTag(str);
                qUIBadge.setOnModeChangeListener(frameFragment.mDragHost);
                qUIBadge.setDragType(2);
                qUIBadge.setDragGroup(str);
                TabDragAnimationView tabDragAnimationView = frameFragment.mTabDragIcon.get(com.tencent.mobileqq.activity.home.impl.a.f183047j);
                com.tencent.mobileqq.activity.recent.cur.c cVar = ((MainFragment) frameFragment).f182812t0;
                cVar.f185379d = tabDragAnimationView;
                cVar.f185380e = qUIBadge;
            }
            ViewGroup viewGroup = frameFragment.mTabWidget;
            if (viewGroup != null && viewGroup.getHeight() > 0) {
                ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).setTabHeight(frameFragment.getFrame(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass()), frameFragment.mTabWidget.getHeight());
            }
            bVar = ((MainFragment) frameFragment).f182811s0.t();
        } else {
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).adjustTab(frameFragment.getBaseActivity());
            if (qUIBadge != null) {
                qUIBadge.setOnModeChangeListener(null);
            }
            this.f182278d = false;
            bVar = null;
        }
        IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
        if (i16 == com.tencent.mobileqq.activity.home.impl.a.f183047j) {
            z16 = true;
        } else {
            z16 = false;
        }
        iGuildMainFrameApi.onTabChanged(frameFragment, z16, bVar);
        T(frameFragment, i16);
        int i17 = com.tencent.mobileqq.activity.home.impl.a.f183047j;
        if (i3 == i17 && i16 != i17) {
            if (!(frameFragment.getCurrentFrame() instanceof Conversation) || !((Conversation) frameFragment.getCurrentFrame()).isShowGuildNavigationBar()) {
                z17 = false;
            }
            if (!z17) {
                X(null, frameFragment.getQBaseActivity().getWindow());
            }
        }
        DragTextView dragTextView = (DragTextView) frameFragment.getTabNotifyIcon(str + "_icon");
        if (dragTextView != null) {
            dragTextView.setOnModeChangeListener(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void z(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, tabFrameControllerImpl, frameFragment, dVar);
            return;
        }
        super.z(tabFrameControllerImpl, frameFragment, dVar);
        QLog.i("Guild.tab.GuildInjectImpl", 1, "doFirstDrawCompleted");
        f182277f = new WeakReference<>(frameFragment);
        ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).registerGuildTabNameUpdate(this);
        c0(frameFragment);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).doFirstDrawCompleted(frameFragment.getBaseActivity());
    }
}
