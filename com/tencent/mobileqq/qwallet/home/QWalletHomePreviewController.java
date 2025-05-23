package com.tencent.mobileqq.qwallet.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.SavedStateHandle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomePreviewController;", "", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "fragment", "", "o", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "p", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "", "i", "j", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomePreviewController$EnumEnterMode;", tl.h.F, "k", "Lcom/tencent/mobileqq/qwallet/home/HomeToolbar;", "homeToolBar", "l", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "g", "e", "d", "<init>", "()V", "EnumEnterMode", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomePreviewController {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QWalletHomePreviewController f277969a = new QWalletHomePreviewController();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomePreviewController$EnumEnterMode;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "PREVIEW", "TOOL_PAGE", "NORMAL_WITH_LOADING", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum EnumEnterMode {
        NORMAL,
        PREVIEW,
        TOOL_PAGE,
        NORMAL_WITH_LOADING
    }

    QWalletHomePreviewController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View rootView, QWalletBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        QLog.i("QWalletHomeFragment-Preview", 1, "sendRealPageFinishAction");
        rootView.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(800L);
        alphaAnimation.setAnimationListener(new a(fragment));
        rootView.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QWalletBaseFragment fragment, View rootView) {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        f277969a.e(fragment, rootView);
    }

    private final void o(QWalletHomeFragment fragment) {
        WindowManager.LayoutParams attributes;
        View decorView;
        ReportDialog reportDialog = new ReportDialog(fragment.requireContext(), R.style.f174210t1);
        WindowManager.LayoutParams layoutParams = null;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            Window window = reportDialog.getWindow();
            if (window != null) {
                window.addFlags(67108864);
            }
            SystemBarCompact systemBarCompact = new SystemBarCompact((Dialog) reportDialog, true, reportDialog.getContext().getResources().getColor(17170445));
            systemBarCompact.setStatusBarDrawable(null);
            systemBarCompact.init();
        }
        Window window2 = reportDialog.getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        Window window3 = reportDialog.getWindow();
        if (window3 != null && (attributes = window3.getAttributes()) != null) {
            Intrinsics.checkNotNullExpressionValue(attributes, "attributes");
            attributes.width = -1;
            attributes.height = -1;
            layoutParams = attributes;
        }
        Window window4 = reportDialog.getWindow();
        if (window4 != null) {
            window4.setAttributes(layoutParams);
        }
        reportDialog.setCancelable(false);
        reportDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(QWalletBaseFragment fragment) {
        Intent intent;
        Context context = fragment.getContext();
        if (context == null) {
            return;
        }
        Intent intent2 = fragment.getIntent();
        if (intent2 != null) {
            intent = new Intent(intent2);
        } else {
            intent = new Intent();
        }
        u.f278200a.k(context, intent, intent.getIntExtra(IQWalletHelper.QWALLET_HOME_CHANNEL_FROM, 0));
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154548b2, R.anim.activity_finish);
        }
    }

    public final void d(@NotNull QWalletBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (h(fragment) != EnumEnterMode.TOOL_PAGE) {
            return;
        }
        QLog.i("QWalletHomeFragment-Preview", 1, "sendRealPageFinishAction");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("QWalletHomeFragment.req_finish"));
    }

    public final void e(@NotNull final QWalletBaseFragment fragment, @NotNull final View rootView) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (h(fragment) == EnumEnterMode.TOOL_PAGE && rootView.getVisibility() != 0) {
            rootView.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.w
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletHomePreviewController.f(rootView, fragment);
                }
            });
        }
    }

    public final void g(@NotNull Context context) {
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || activity.getIntent().getSerializableExtra("QWalletHomeFragment.enum_page_type") != EnumEnterMode.PREVIEW) {
            return;
        }
        QLog.i("QWalletHomeFragment-Preview", 1, "sendPreviewFinishAction");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("QWalletHomeFragment.preview_finish"));
    }

    @NotNull
    public final EnumEnterMode h(@NotNull QWalletBaseFragment fragment) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent intent = fragment.getIntent();
        EnumEnterMode enumEnterMode = null;
        if (intent != null) {
            serializable = intent.getSerializableExtra("QWalletHomeFragment.enum_page_type");
        } else {
            serializable = null;
        }
        if (serializable instanceof EnumEnterMode) {
            enumEnterMode = (EnumEnterMode) serializable;
        }
        if (enumEnterMode == null) {
            return EnumEnterMode.NORMAL_WITH_LOADING;
        }
        return enumEnterMode;
    }

    public final boolean i(@NotNull SavedStateHandle stateHandle) {
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        if (stateHandle.get("QWalletHomeFragment.enum_page_type") == EnumEnterMode.PREVIEW) {
            return true;
        }
        return false;
    }

    public final boolean j(@NotNull QWalletBaseFragment fragment) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent intent = fragment.getIntent();
        if (intent != null) {
            serializable = intent.getSerializableExtra("QWalletHomeFragment.enum_page_type");
        } else {
            serializable = null;
        }
        if (serializable == EnumEnterMode.PREVIEW) {
            return true;
        }
        return false;
    }

    public final void k(@NotNull final QWalletHomeFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!j(fragment)) {
            return;
        }
        QLog.i("QWalletHomeFragment-Preview", 1, "listenerPreviewFinish");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomePreviewController$onPreviewPageCreate$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                QLog.i("QWalletHomeFragment-Preview", 1, "onReceive ACTION_REQ_FINISH");
                QWalletHomeFragment.this.unregisterReceiver(this);
                QWalletHomeFragment.this.finish();
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("QWalletHomeFragment.req_finish");
        Unit unit = Unit.INSTANCE;
        fragment.registerReceiver(broadcastReceiver, intentFilter);
        BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomePreviewController$onPreviewPageCreate$3
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                QLog.i("QWalletHomeFragment-Preview", 1, "onReceive ACTION_PREVIEW_FINISH");
                QWalletHomePreviewController.f277969a.p(QWalletHomeFragment.this);
                QWalletHomeFragment.this.unregisterReceiver(this);
            }
        };
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("QWalletHomeFragment.preview_finish");
        fragment.registerReceiver(broadcastReceiver2, intentFilter2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void l(@NotNull QWalletHomeFragment fragment, @NotNull HomeToolbar homeToolBar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(homeToolBar, "homeToolBar");
        boolean j3 = j(fragment);
        homeToolBar.o(j3);
        if (j3 && !((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_HOME_NOT_BLOCK_CLICK, false)) {
            QLog.i("QWalletHomeFragment-Preview", 1, "show BlockClick dialog");
            o(fragment);
        }
    }

    public final void m(@NotNull final QWalletBaseFragment fragment, @NotNull final View rootView) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (h(fragment) == EnumEnterMode.TOOL_PAGE) {
            rootView.setVisibility(8);
            rootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.v
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletHomePreviewController.n(QWalletBaseFragment.this, rootView);
                }
            }, 1000L);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/home/QWalletHomePreviewController$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "onAnimationStart", "onAnimationRepeat", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QWalletBaseFragment f277970d;

        a(QWalletBaseFragment qWalletBaseFragment) {
            this.f277970d = qWalletBaseFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            QWalletHomePreviewController.f277969a.d(this.f277970d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }
}
