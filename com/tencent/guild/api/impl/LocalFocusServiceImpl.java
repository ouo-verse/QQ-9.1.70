package com.tencent.guild.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.guild.api.ILocalFocusService;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.t;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import cr0.GuildActiveInfo;
import java.lang.ref.WeakReference;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0002DEB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0012H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00100R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00100R\u0016\u0010=\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00102R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/guild/api/impl/LocalFocusServiceImpl;", "Lcom/tencent/guild/api/ILocalFocusService;", "Lhr0/b;", "", "registerKernelListener", "unRegisterKernelListener", "", "tag", "onFocusSessionChange", "onFocusOnGuildChange", "Lcom/tencent/qqnt/kernel/api/w;", "getMsgService", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "getWrapperSession", "checkGProStart", "Lcom/tencent/guild/api/ILocalFocusService$b;", "focusSession", "handleFocusSession", "", WSPublicAccReport.SOP_NAME_FOCUS, "handleFocusOnGuild", "", "activeStatus", "handleSwitchForeground", "Lmqq/app/AppRuntime;", "app", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "reportAfterQQLogin", "reportAfterQQLoginBg", "reportAfterNTInit", "Lcr0/a;", "guildActiveInfo", "setActiveGuild", "channelActiveInfo", "setActiveChannel", "activeTab", "setActiveTab", "isAppOnForeground", "onAppForegroundChange", "appRuntime", "Lmqq/app/AppRuntime;", "Lcom/tencent/guild/api/impl/a;", "channelActiveStrategy", "Lcom/tencent/guild/api/impl/a;", "Lcom/tencent/guild/api/impl/b;", "guildActiveStrategy", "Lcom/tencent/guild/api/impl/b;", "I", "activeTabTemp", "Z", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/lang/Object;", "Landroid/os/Handler;", "commonHandler", "Landroid/os/Handler;", "Lhr0/c;", "guardManagerDelegate", "Lhr0/c;", "lastActiveStatus", "isDestroy", "Lcom/tencent/guild/api/impl/LocalFocusServiceImpl$WeakBroadcastReceiver;", "kernelInitCompleteListener", "Lcom/tencent/guild/api/impl/LocalFocusServiceImpl$WeakBroadcastReceiver;", "<init>", "()V", "Companion", "a", "WeakBroadcastReceiver", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class LocalFocusServiceImpl implements ILocalFocusService, hr0.b {
    public static final int BG_LOGIN_DELAY = 5000;

    @NotNull
    public static final String TAG = "LocalFocusServiceImpl";

    @Nullable
    private AppRuntime appRuntime;

    @Nullable
    private hr0.c guardManagerDelegate;
    private boolean isDestroy;
    private int lastActiveStatus;

    @NotNull
    private a channelActiveStrategy = new a();

    @NotNull
    private b guildActiveStrategy = new b();
    private int activeTab = 2;
    private volatile int activeTabTemp = 2;
    private boolean isAppOnForeground = true;

    @NotNull
    private Object lock = new Object();

    @NotNull
    private final Handler commonHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

    @NotNull
    private final WeakBroadcastReceiver kernelInitCompleteListener = new WeakBroadcastReceiver(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/api/impl/LocalFocusServiceImpl$WeakBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "p0", "Landroid/content/Intent;", "p1", "", "onReceive", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/guild/api/impl/LocalFocusServiceImpl;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "localFocusRef", "localFocusService", "<init>", "(Lcom/tencent/guild/api/impl/LocalFocusServiceImpl;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class WeakBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<LocalFocusServiceImpl> localFocusRef;

        public WeakBroadcastReceiver(@NotNull LocalFocusServiceImpl localFocusService) {
            Intrinsics.checkNotNullParameter(localFocusService, "localFocusService");
            this.localFocusRef = new WeakReference<>(localFocusService);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context p06, @Nullable Intent p16) {
            LocalFocusServiceImpl localFocusServiceImpl = this.localFocusRef.get();
            if (localFocusServiceImpl != null) {
                localFocusServiceImpl.reportAfterNTInit();
            }
        }
    }

    private final void checkGProStart() {
        AppRuntime appRuntime;
        try {
            if (getWrapperSession() != null && (appRuntime = this.appRuntime) != null) {
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "checkGProStart e:" + e16);
        }
    }

    private final w getMsgService() {
        IKernelService iKernelService;
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getMsgService();
        }
        return null;
    }

    private final IQQNTWrapperSession getWrapperSession() {
        IKernelService iKernelService;
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getWrapperSession();
        }
        return null;
    }

    private final void handleFocusOnGuild(final boolean focus) {
        this.commonHandler.post(new Runnable() { // from class: com.tencent.guild.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                LocalFocusServiceImpl.handleFocusOnGuild$lambda$14(focus);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleFocusOnGuild$lambda$14(boolean z16) {
        t d16;
        if (((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isGuildUser() && (d16 = com.tencent.qqnt.msg.f.d()) != null) {
            d16.setFocusOnGuild(z16);
        }
    }

    private final void handleFocusSession(final ILocalFocusService.b focusSession) {
        this.commonHandler.post(new Runnable() { // from class: com.tencent.guild.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                LocalFocusServiceImpl.handleFocusSession$lambda$13(LocalFocusServiceImpl.this, focusSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleFocusSession$lambda$13(LocalFocusServiceImpl this$0, ILocalFocusService.b focusSession) {
        IGProSession iGProSession;
        uh2.c gProGuildMsgService;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(focusSession, "$focusSession");
        this$0.handleSwitchForeground(focusSession.getActiveStatus());
        if (!((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isGuildUser()) {
            return;
        }
        this$0.checkGProStart();
        AppRuntime appRuntime = this$0.appRuntime;
        if (appRuntime != null && (iGProSession = (IGProSession) appRuntime.getRuntimeService(IGProSession.class, "")) != null && (gProGuildMsgService = iGProSession.getGProGuildMsgService()) != null) {
            gProGuildMsgService.setFocusSession(focusSession.getConstant(), focusSession.getMsgTabFocus(), focusSession.getActiveStatus());
        }
    }

    private final void handleSwitchForeground(int activeStatus) {
        IQQNTWrapperSession wrapperSession;
        if (this.lastActiveStatus == activeStatus) {
            return;
        }
        this.lastActiveStatus = activeStatus;
        if (activeStatus != 1) {
            if (activeStatus == 2 && (wrapperSession = getWrapperSession()) != null) {
                wrapperSession.switchToBackGround();
            }
        } else {
            IQQNTWrapperSession wrapperSession2 = getWrapperSession();
            if (wrapperSession2 != null) {
                wrapperSession2.switchToFront();
            }
        }
        QLog.i(TAG, 1, "handleSwitchForeground activeStatus:" + activeStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFocusOnGuildChange(String tag) {
        boolean z16;
        synchronized (this.lock) {
            boolean z17 = false;
            if (this.activeTab == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            handleFocusOnGuild(z16);
            if (this.activeTab == 1) {
                z17 = true;
            }
            QLog.i(TAG, 1, tag + " onFocusOnGuildChange: " + z17);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFocusSessionChange(String tag) {
        boolean z16;
        synchronized (this.lock) {
            GProContact gProContact = new GProContact(4, this.channelActiveStrategy.b(), this.guildActiveStrategy.b());
            int i3 = 2;
            if (this.activeTab == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.isAppOnForeground) {
                i3 = 1;
            }
            QLog.i(TAG, 1, tag + " peer: " + gProContact + " msgTabFocus: " + z16 + " activeStatus: " + i3);
            handleFocusSession(new ILocalFocusService.b(gProContact, z16, i3));
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void registerKernelListener() {
        this.commonHandler.post(new Runnable() { // from class: com.tencent.guild.api.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                LocalFocusServiceImpl.registerKernelListener$lambda$1(LocalFocusServiceImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerKernelListener$lambda$1(LocalFocusServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.action.ON_KERNEL_INIT_COMPLETE");
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                context.registerReceiver(this$0.kernelInitCompleteListener, intentFilter);
            }
            QLog.i(TAG, 1, "register KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i(TAG, 1, "registerReceiver", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportAfterQQLogin$lambda$3(final LocalFocusServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.activeTabTemp = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentActiveTab();
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.guild.api.impl.LocalFocusServiceImpl$reportAfterQQLogin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                boolean z16;
                hr0.c cVar;
                hr0.c cVar2;
                int i3;
                b bVar;
                int i16;
                obj = LocalFocusServiceImpl.this.lock;
                LocalFocusServiceImpl localFocusServiceImpl = LocalFocusServiceImpl.this;
                synchronized (obj) {
                    z16 = localFocusServiceImpl.isDestroy;
                    if (!z16) {
                        cVar = localFocusServiceImpl.guardManagerDelegate;
                        if (cVar == null) {
                            localFocusServiceImpl.guardManagerDelegate = ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).createGuardManagerDelegate(localFocusServiceImpl);
                            cVar2 = localFocusServiceImpl.guardManagerDelegate;
                            Intrinsics.checkNotNull(cVar2);
                            cVar2.onCreate();
                            localFocusServiceImpl.isAppOnForeground = ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isApplicationForeground();
                            i3 = localFocusServiceImpl.activeTabTemp;
                            localFocusServiceImpl.activeTab = i3;
                            bVar = localFocusServiceImpl.guildActiveStrategy;
                            i16 = localFocusServiceImpl.activeTab;
                            bVar.f(i16);
                        }
                        Unit unit = Unit.INSTANCE;
                        LocalFocusServiceImpl.this.onFocusSessionChange("reportAfterQQLogin");
                        LocalFocusServiceImpl.this.onFocusOnGuildChange("reportAfterQQLogin");
                        return;
                    }
                    QLog.e(LocalFocusServiceImpl.TAG, 1, "reportAfterQQLogin isDestroy == true");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportAfterQQLoginBg$lambda$4(LocalFocusServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "reportAfterQQLogin start");
        this$0.reportAfterQQLogin();
    }

    private final void unRegisterKernelListener() {
        this.commonHandler.post(new Runnable() { // from class: com.tencent.guild.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                LocalFocusServiceImpl.unRegisterKernelListener$lambda$2(LocalFocusServiceImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unRegisterKernelListener$lambda$2(LocalFocusServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                context.unregisterReceiver(this$0.kernelInitCompleteListener);
            }
            QLog.i(TAG, 1, "unRegister KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i(TAG, 1, "unRegisterKernelListener", e16);
        }
    }

    @Override // hr0.b
    public void onAppForegroundChange(boolean isAppOnForeground) {
        boolean z16;
        synchronized (this.lock) {
            if (this.isAppOnForeground != isAppOnForeground) {
                this.isAppOnForeground = isAppOnForeground;
                z16 = true;
            } else {
                z16 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z16) {
            QLog.i(TAG, 1, "setAppForeground: " + this.isAppOnForeground);
            onFocusSessionChange("setAppForeground");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime app) {
        this.appRuntime = app;
        registerKernelListener();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        synchronized (this.lock) {
            hr0.c cVar = this.guardManagerDelegate;
            if (cVar != null) {
                cVar.onDestroy();
            }
            this.guardManagerDelegate = null;
            this.isDestroy = true;
            Unit unit = Unit.INSTANCE;
        }
        unRegisterKernelListener();
    }

    @Override // com.tencent.guild.api.ILocalFocusService
    public void reportAfterNTInit() {
        boolean z16;
        synchronized (this.lock) {
            if (this.guardManagerDelegate != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (z16) {
            QLog.i(TAG, 1, "reportAfterNTInit");
            onFocusSessionChange("reportAfterNTInit");
            onFocusOnGuildChange("reportAfterNTInit");
        }
    }

    @Override // com.tencent.guild.api.ILocalFocusService
    public void reportAfterQQLogin() {
        this.commonHandler.post(new Runnable() { // from class: com.tencent.guild.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                LocalFocusServiceImpl.reportAfterQQLogin$lambda$3(LocalFocusServiceImpl.this);
            }
        });
    }

    @Override // com.tencent.guild.api.ILocalFocusService
    public void reportAfterQQLoginBg() {
        QLog.i(TAG, 1, "reportAfterQQLoginBg");
        C11736d.b(5000, new Runnable() { // from class: com.tencent.guild.api.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                LocalFocusServiceImpl.reportAfterQQLoginBg$lambda$4(LocalFocusServiceImpl.this);
            }
        });
    }

    @Override // com.tencent.guild.api.ILocalFocusService
    public void setActiveChannel(@NotNull GuildActiveInfo channelActiveInfo) {
        boolean e16;
        Intrinsics.checkNotNullParameter(channelActiveInfo, "channelActiveInfo");
        synchronized (this.lock) {
            e16 = this.channelActiveStrategy.e(channelActiveInfo);
            Unit unit = Unit.INSTANCE;
        }
        if (e16) {
            onFocusSessionChange("setActiveChannel");
            if (channelActiveInfo.getBActive() && !channelActiveInfo.d()) {
                t d16 = com.tencent.qqnt.msg.f.d();
                if (d16 != null) {
                    d16.onScenesChangeForSilenceMode(3);
                }
                QLog.i(TAG, 1, "onScenesChangeForSilenceMode: 3");
            }
        }
    }

    @Override // com.tencent.guild.api.ILocalFocusService
    public void setActiveGuild(@NotNull GuildActiveInfo guildActiveInfo) {
        boolean e16;
        Intrinsics.checkNotNullParameter(guildActiveInfo, "guildActiveInfo");
        synchronized (this.lock) {
            e16 = this.guildActiveStrategy.e(guildActiveInfo);
            Unit unit = Unit.INSTANCE;
        }
        if (e16) {
            onFocusSessionChange("setActiveGuild");
            if (guildActiveInfo.getBActive() && !guildActiveInfo.d()) {
                t d16 = com.tencent.qqnt.msg.f.d();
                if (d16 != null) {
                    d16.onScenesChangeForSilenceMode(2);
                }
                QLog.i(TAG, 1, "onScenesChangeForSilenceMode: 2");
            }
        }
    }

    @Override // com.tencent.guild.api.ILocalFocusService
    public void setActiveTab(int activeTab) {
        boolean z16;
        synchronized (this.lock) {
            if (this.activeTab != activeTab) {
                this.activeTab = activeTab;
                this.guildActiveStrategy.f(activeTab);
                this.activeTabTemp = activeTab;
                z16 = true;
            } else {
                z16 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z16) {
            QLog.i(TAG, 1, "setActiveTab: " + this.activeTab);
            onFocusOnGuildChange("setActiveTab");
            onFocusSessionChange("setActiveTab");
            if (activeTab == 1) {
                t d16 = com.tencent.qqnt.msg.f.d();
                if (d16 != null) {
                    d16.onScenesChangeForSilenceMode(1);
                }
                QLog.i(TAG, 1, "onScenesChangeForSilenceMode: 1");
            }
        }
    }
}
