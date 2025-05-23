package com.tencent.mobileqq.gesturelock.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.IGesturePWDNavigationApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0016B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gesturelock/impl/GesturePWDNavigationApiImpl;", "Lcom/tencent/mobileqq/gesturelock/IGesturePWDNavigationApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "asyncUnregisterReceiver", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreated", "onResume", DKHippyEvent.EVENT_STOP, "onDestroyed", "Landroid/content/BroadcastReceiver;", "mScreenReceiver", "Landroid/content/BroadcastReceiver;", "", "mCanLock", "Z", "<init>", "()V", "Companion", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GesturePWDNavigationApiImpl implements IGesturePWDNavigationApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String GESTURE_PWD_UNLOCK_SWITCH = "102041";

    @NotNull
    public static final String TAG = "GesturePWDNavigationApiImpl";
    private boolean mCanLock;

    @Nullable
    private BroadcastReceiver mScreenReceiver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/gesturelock/impl/GesturePWDNavigationApiImpl$a;", "", "", "GESTURE_PWD_UNLOCK_SWITCH", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gesturelock.impl.GesturePWDNavigationApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gesturelock/impl/GesturePWDNavigationApiImpl$b;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private static final class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), IECScreenReceiver.ACTION_SCREEN_OFF)) {
                GesturePWDUtils.setAppForground(context, false);
            } else if (Intrinsics.areEqual(intent.getAction(), IECScreenReceiver.ACTION_SCREEN_ON)) {
                GesturePWDUtils.setAppForground(context, BaseGesturePWDUtil.isAppOnForegroundByTasks(context, 0));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GesturePWDNavigationApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCanLock = true;
        }
    }

    private final void asyncUnregisterReceiver(final Activity activity) {
        if (this.mScreenReceiver != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gesturelock.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    GesturePWDNavigationApiImpl.asyncUnregisterReceiver$lambda$1(GesturePWDNavigationApiImpl.this, activity);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncUnregisterReceiver$lambda$1(GesturePWDNavigationApiImpl this$0, Activity activity) {
        BroadcastReceiver broadcastReceiver;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            broadcastReceiver = this$0.mScreenReceiver;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onDestroyed error: " + e16);
        }
        if (broadcastReceiver == null) {
            return;
        }
        activity.unregisterReceiver(broadcastReceiver);
        this$0.mScreenReceiver = null;
    }

    @Override // com.tencent.mobileqq.gesturelock.IGesturePWDNavigationApi
    public void onCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.mCanLock = extras.getBoolean(PeakConstants.ALLOW_LOCK, true);
        }
        if (this.mScreenReceiver == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                b bVar = new b();
                this.mScreenReceiver = bVar;
                activity.registerReceiver(bVar, intentFilter);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "registerReceiver error", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.gesturelock.IGesturePWDNavigationApi
    public void onDestroyed(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(GESTURE_PWD_UNLOCK_SWITCH, false);
        QLog.d(TAG, 1, "onDestroyed switch status: " + isSwitchOn);
        if (isSwitchOn) {
            asyncUnregisterReceiver(activity);
            return;
        }
        BroadcastReceiver broadcastReceiver = this.mScreenReceiver;
        if (broadcastReceiver != null) {
            try {
                activity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onDestroyed error: " + e16);
            }
            this.mScreenReceiver = null;
        }
    }

    @Override // com.tencent.mobileqq.gesturelock.IGesturePWDNavigationApi
    public void onResume(@NotNull Activity activity) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d(TAG, 1, "onResume ");
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        boolean jumpLock = BaseGesturePWDUtil.getJumpLock(activity, account);
        if (account != null) {
            if (account.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && jumpLock && !BaseGesturePWDUtil.getAppForground(activity) && this.mCanLock) {
                QLog.d(TAG, 1, "needShowGesturePWD");
                GesturePWDUnlockActivity.sGesturePWDUnlockShowing = true;
                Intent intent = new Intent(activity, (Class<?>) GesturePWDUnlockActivity.class);
                intent.addFlags(604045312);
                intent.putExtra("key_gesture_showgesture_valid", false);
                activity.startActivityForResult(intent, 12289);
            }
        }
        GesturePWDUtils.setAppForground(activity, true);
    }

    @Override // com.tencent.mobileqq.gesturelock.IGesturePWDNavigationApi
    public void onStop(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean isAppOnForegroundByTasks = BaseGesturePWDUtil.isAppOnForegroundByTasks(activity, 0);
        QLog.d(TAG, 1, "onStop foreground staus: " + isAppOnForegroundByTasks);
        if (!isAppOnForegroundByTasks) {
            GesturePWDUtils.setAppForground(activity, false);
        }
    }
}
