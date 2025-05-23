package com.tencent.qqnt.aio.predownload.api.impl;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService;
import com.tencent.qqnt.aio.predownload.api.impl.AIOPreDownloadServiceImpl;
import com.tencent.qqnt.aio.predownload.video.ShortVideoPreDownloaderWithSdkSupport;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001 \u0018\u0000 %2\u00020\u0001:\u0002&'B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0016\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/predownload/api/impl/AIOPreDownloadServiceImpl;", "Lcom/tencent/qqnt/aio/predownload/api/IAIOPreDownloadService;", "", "registerPreDownloader", "registerMsgReceiveListener", "registerScreenStateReceiver", "registerForegroundCallback", "unRegisterForegroundCallback", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", "onNetworkConnected", "onGetOfflineMessageFinish", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "onMsgReceive", "", "isScreenOn", "onScreenStateChange", "onProcessForeground", "onProcessBackground", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkv3/a;", "mPreDownloaderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/content/BroadcastReceiver;", "mScreenBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mIsScreenOn", "Z", "com/tencent/qqnt/aio/predownload/api/impl/AIOPreDownloadServiceImpl$b", "mForegroundCallback", "Lcom/tencent/qqnt/aio/predownload/api/impl/AIOPreDownloadServiceImpl$b;", "<init>", "()V", "Companion", "a", "ScreenBroadcastReceiver", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOPreDownloadServiceImpl implements IAIOPreDownloadService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "[NT][AIO_PRE_DOWNLOAD]PicVideoPreDownloadService";

    @NotNull
    private final b mForegroundCallback;
    private boolean mIsScreenOn;

    @NotNull
    private final CopyOnWriteArrayList<kv3.a> mPreDownloaderList;

    @Nullable
    private BroadcastReceiver mScreenBroadcastReceiver;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/api/impl/AIOPreDownloadServiceImpl$ScreenBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "b", "", "c", "onReceive", "<init>", "(Lcom/tencent/qqnt/aio/predownload/api/impl/AIOPreDownloadServiceImpl;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class ScreenBroadcastReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        public ScreenBroadcastReceiver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPreDownloadServiceImpl.this);
            }
        }

        private final void b(Context context, Intent intent) {
            String action = intent.getAction();
            boolean z16 = AIOPreDownloadServiceImpl.this.mIsScreenOn;
            if (Intrinsics.areEqual(IECScreenReceiver.ACTION_SCREEN_ON, action)) {
                z16 = !c(context);
            } else if (Intrinsics.areEqual(IECScreenReceiver.ACTION_SCREEN_OFF, action)) {
                z16 = false;
            } else if (Intrinsics.areEqual("android.intent.action.USER_PRESENT", action)) {
                z16 = true;
            }
            if (z16 == AIOPreDownloadServiceImpl.this.mIsScreenOn) {
                return;
            }
            AIOPreDownloadServiceImpl.this.onScreenStateChange(z16);
        }

        private final boolean c(Context context) {
            Object systemService = context.getSystemService("keyguard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            return ((KeyguardManager) systemService).inKeyguardRestrictedInputMode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ScreenBroadcastReceiver this$0, Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(intent, "$intent");
            this$0.b(context, intent);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull final Context context, @NotNull final Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPreDownloadServiceImpl.ScreenBroadcastReceiver.d(AIOPreDownloadServiceImpl.ScreenBroadcastReceiver.this, context, intent);
                }
            }, 16, null, true);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/api/impl/AIOPreDownloadServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.predownload.api.impl.AIOPreDownloadServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/qqnt/aio/predownload/api/impl/AIOPreDownloadServiceImpl$b", "Lmqq/app/QActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements QActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPreDownloadServiceImpl.this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) outState);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                AIOPreDownloadServiceImpl.this.onProcessBackground();
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                AIOPreDownloadServiceImpl.this.onProcessForeground();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65577);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOPreDownloadServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mPreDownloaderList = new CopyOnWriteArrayList<>();
        this.mIsScreenOn = true;
        this.mForegroundCallback = new b();
    }

    private final void registerForegroundCallback() {
        Foreground.addActivityLifeCallback(this.mForegroundCallback);
    }

    private final void registerMsgReceiveListener() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.o(), new AIOPreDownloadServiceImpl$registerMsgReceiveListener$1(this, null)), Dispatchers.getIO()), CoroutineScopeKt.MainScope());
    }

    private final void registerPreDownloader() {
        this.mPreDownloaderList.add(new ShortVideoPreDownloaderWithSdkSupport());
        this.mPreDownloaderList.add(new com.tencent.qqnt.aio.predownload.pic.a());
        this.mPreDownloaderList.add(new com.tencent.qqnt.aio.predownload.emoticon.a());
    }

    private final void registerScreenStateReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        ScreenBroadcastReceiver screenBroadcastReceiver = new ScreenBroadcastReceiver();
        this.mScreenBroadcastReceiver = screenBroadcastReceiver;
        BaseApplication.context.registerReceiver(screenBroadcastReceiver, intentFilter);
    }

    private final void unRegisterForegroundCallback() {
        Foreground.removeActivityLifeCallback(this.mForegroundCallback);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreate");
        }
        registerPreDownloader();
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onCreate(appRuntime);
        }
        registerMsgReceiveListener();
        registerScreenStateReceiver();
        registerForegroundCallback();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        try {
            BroadcastReceiver broadcastReceiver = this.mScreenBroadcastReceiver;
            if (broadcastReceiver != null) {
                BaseApplication.context.unregisterReceiver(broadcastReceiver);
                this.mScreenBroadcastReceiver = null;
            }
        } catch (IllegalArgumentException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "exception: " + e16.getMessage());
            }
        }
        unRegisterForegroundCallback();
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mPreDownloaderList.clear();
    }

    @Override // com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService
    public void onGetOfflineMessageFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onGetOfflineMessageFinish();
        }
    }

    @Override // com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService
    public void onMsgReceive(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onMsgReceive(msgList);
        }
    }

    @Override // com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService
    public void onNetworkConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onNetworkConnected();
        }
    }

    @Override // com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService
    public void onProcessBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "onProcessBackground");
        }
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onProcessBackground();
        }
    }

    @Override // com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService
    public void onProcessForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "onProcessForeground");
        }
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onProcessForeground();
        }
    }

    @Override // com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService
    public void onScreenStateChange(boolean isScreenOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isScreenOn);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "onScreenStateChange isScreenOn:" + isScreenOn + ",lastScreenOnState:" + this.mIsScreenOn);
        }
        this.mIsScreenOn = isScreenOn;
        Iterator<kv3.a> it = this.mPreDownloaderList.iterator();
        while (it.hasNext()) {
            it.next().onScreenStateChange(isScreenOn);
        }
    }
}
