package com.tencent.mobileqq.gamecenter.ui;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t*\u0001A\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010D\u001a\u00020\u0011\u0012\u0006\u00100\u001a\u00020\u0019\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\"\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#H\u0016J\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000bJ \u0010)\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\"\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u00100\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/ui/GameCenterKuiklyFloatDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Lsl0/b;", "", "N", ExifInterface.LATITUDE_SOUTH, "", "P", "X", "", "", "", "O", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, BdhLogUtil.LogTag.Tag_Req, "", "movedX", "movedY", "Landroid/view/View;", "view", "Y", "layoutResID", "setContentView", "Lcom/tencent/mobileqq/gamecenter/ui/aa;", "info", "W", "showErrorView", "hideErrorView", "showLoadingView", "hideLoadingView", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "U", "from", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f", "upX", "upY", "e", "d", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/gamecenter/ui/aa;", "data", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "D", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "iqqKuiklyRenderView", "E", "Z", "isSplashActivity", "Ljava/util/concurrent/atomic/AtomicBoolean;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroy", "G", "I", "containerWidth", "H", "containerHeight", "com/tencent/mobileqq/gamecenter/ui/GameCenterKuiklyFloatDialog$aioDestroyReceiver$1", "Lcom/tencent/mobileqq/gamecenter/ui/GameCenterKuiklyFloatDialog$aioDestroyReceiver$1;", "aioDestroyReceiver", "theme", "<init>", "(Landroid/app/Activity;ILcom/tencent/mobileqq/gamecenter/ui/aa;)V", "J", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameCenterKuiklyFloatDialog extends ReportDialog implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, sl0.b {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final aa data;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g iqqKuiklyRenderView;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isSplashActivity;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isDestroy;

    /* renamed from: G, reason: from kotlin metadata */
    private int containerWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private int containerHeight;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GameCenterKuiklyFloatDialog$aioDestroyReceiver$1 aioDestroyReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/ui/GameCenterKuiklyFloatDialog$a;", "", "", "b", "()I", "screenWidth", "a", "screenHeight", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.ui.GameCenterKuiklyFloatDialog$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            if (MobileQQ.sMobileQQ.getResources().getConfiguration().orientation == 2) {
                return MobileQQ.sMobileQQ.getResources().getDisplayMetrics().widthPixels;
            }
            return MobileQQ.sMobileQQ.getResources().getDisplayMetrics().heightPixels;
        }

        public final int b() {
            if (MobileQQ.sMobileQQ.getResources().getConfiguration().orientation == 2) {
                return MobileQQ.sMobileQQ.getResources().getDisplayMetrics().heightPixels;
            }
            return MobileQQ.sMobileQQ.getResources().getDisplayMetrics().widthPixels;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/gamecenter/ui/GameCenterKuiklyFloatDialog$b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (QLog.isColorLevel()) {
                QLog.i("GameCenterKuiklyFloatDialog", 2, "[onActivityCreated] activity\uff1a" + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Application application;
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (QLog.isColorLevel()) {
                QLog.i("GameCenterKuiklyFloatDialog", 2, "[onActivityDestroyed] activity\uff1a" + activity);
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    activity.unregisterActivityLifecycleCallbacks(this);
                } else {
                    Context applicationContext = activity.getApplicationContext();
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                    } else {
                        application = null;
                    }
                    if (application != null) {
                        application.unregisterActivityLifecycleCallbacks(this);
                    }
                }
                GameCenterKuiklyFloatDialog.this.Q("onActivityDestroyed");
            } catch (Throwable th5) {
                QLog.e("GameCenterKuiklyFloatDialog", 1, th5, new Object[0]);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.mobileqq.gamecenter.ui.GameCenterKuiklyFloatDialog$aioDestroyReceiver$1] */
    public GameCenterKuiklyFloatDialog(@NotNull Activity activity, int i3, @NotNull aa data) {
        super(activity, i3);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isDestroy = new AtomicBoolean(false);
        R(activity);
        this.isSplashActivity = ((ITempApi) QRoute.api(ITempApi.class)).isSplashActivity(activity);
        this.containerWidth = -1;
        this.containerHeight = -1;
        this.aioDestroyReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.gamecenter.ui.GameCenterKuiklyFloatDialog$aioDestroyReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                GameCenterKuiklyFloatDialog.this.U();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f165218li0);
        if (this.data.f()) {
            frameLayout.setClickable(true);
            frameLayout.setOnTouchListener(new sl0.a(this));
        }
        W(this.data);
        IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
        frameLayout.addView((View) createKuiklyRenderView, new FrameLayout.LayoutParams(-1, -1));
        String packageName = this.data.getPackageName();
        Map<String, Object> O = O();
        O.put("gc_container_width", Integer.valueOf(this.containerWidth));
        O.put("gc_container_height", Integer.valueOf(this.containerHeight));
        Unit unit = Unit.INSTANCE;
        createKuiklyRenderView.b(packageName, O, null);
        createKuiklyRenderView.onResume();
        Intrinsics.checkNotNull(createKuiklyRenderView, "null cannot be cast to non-null type android.view.View");
        ((View) createKuiklyRenderView).setTag(this);
        S();
        this.iqqKuiklyRenderView = createKuiklyRenderView;
    }

    private final Map<String, Object> O() {
        Map<String, Object> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(this.data.d());
        return mutableMap;
    }

    private final boolean P() {
        if (!this.data.g() && this.isSplashActivity) {
            return true;
        }
        return false;
    }

    private final void R(Activity activity) {
        Application application;
        b bVar = new b();
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(bVar);
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        } else {
            application = null;
        }
        if (application != null) {
            application.registerActivityLifecycleCallbacks(bVar);
        }
    }

    private final void S() {
        try {
            if (P()) {
                MobileQQ.sMobileQQ.registerReceiver(this.aioDestroyReceiver, new IntentFilter("action_qgame_aio_on_destroy"));
            }
        } catch (Throwable th5) {
            QLog.e("GameCenterKuiklyFloatDialog", 1, th5, new Object[0]);
        }
    }

    private final void X() {
        try {
            if (P()) {
                MobileQQ.sMobileQQ.unregisterReceiver(this.aioDestroyReceiver);
            }
        } catch (Throwable th5) {
            QLog.e("GameCenterKuiklyFloatDialog", 1, th5, new Object[0]);
        }
    }

    private final void Y(int movedX, int movedY, View view) {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            int i3 = attributes.x + movedX;
            attributes.x = i3;
            attributes.y += movedY;
            if (i3 < 0) {
                attributes.x = 0;
            }
            int i16 = attributes.x;
            Companion companion = INSTANCE;
            if (i16 > companion.b() - view.getWidth()) {
                attributes.x = companion.b() - view.getWidth();
            }
            if (attributes.y < 0) {
                attributes.y = 0;
            }
            if (attributes.y > companion.a() - view.getHeight()) {
                attributes.y = companion.a() - view.getHeight();
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
    }

    public final void Q(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        try {
            if (!this.isDestroy.getAndSet(true)) {
                QLog.i("GameCenterKuiklyFloatDialog", 2, "doOnDestroy:" + from);
                ((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).removeRecordKey(this.data.getRecordKey());
                com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.iqqKuiklyRenderView;
                if (gVar != null) {
                    gVar.onDetach();
                }
                X();
            }
        } catch (Throwable th5) {
            QLog.e("GameCenterKuiklyFloatDialog", 1, th5, new Object[0]);
        }
    }

    public final void U() {
        try {
            if (isShowing()) {
                dismiss();
            }
            Q("safeDismiss");
        } catch (Throwable th5) {
            QLog.e("GameCenterKuiklyFloatDialog", 1, th5, new Object[0]);
        }
    }

    public final void W(@NotNull aa info) {
        Window window;
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(info, "info");
        Companion companion = INSTANCE;
        Rect b16 = info.b(companion.b(), companion.a());
        if (b16 != null && (window = getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.flags = 8;
            attributes.x = b16.left;
            attributes.y = b16.top;
            attributes.width = b16.width();
            int height = b16.height();
            attributes.height = height;
            attributes.gravity = 51;
            this.containerWidth = attributes.width;
            this.containerHeight = height;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
            QLog.i("GameCenterKuiklyFloatDialog", 2, "[setFloatWindowRectangle] screenWidth:" + companion.b() + ",screenHeight:" + companion.a() + ",width:" + attributes.width + ",height:" + attributes.height + ",x:" + attributes.x + ",y:" + attributes.y);
        }
    }

    @Override // sl0.b
    public void d(int upX, int upY, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // sl0.b
    public void e(int upX, int upY, @Nullable View view) {
        QLog.i("GameCenterKuiklyFloatDialog", 2, "[onClick] upX:" + upX + ",upY:" + upY);
    }

    @Override // sl0.b
    public void f(int movedX, int movedY, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Y(movedX, movedY, view);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("GameCenterKuiklyFloatDialog", 1, "[onPageLoadComplete]");
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        try {
            N();
        } catch (Throwable th5) {
            QLog.e("GameCenterKuiklyFloatDialog", 1, th5, new Object[0]);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        U();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
    }
}
