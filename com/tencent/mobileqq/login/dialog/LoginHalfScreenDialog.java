package com.tencent.mobileqq.login.dialog;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001c\b&\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0014J\u0006\u0010\u0012\u001a\u00020\u0002R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/login/dialog/LoginHalfScreenDialog;", "Landroid/app/Dialog;", "", "initWindow", "X", "Landroid/view/View;", "W", "", HippyTKDListViewAdapter.X, "y", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", DKHippyEvent.EVENT_STOP, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "D", "Lkotlin/Lazy;", ExifInterface.LATITUDE_SOUTH, "()Landroid/view/View;", "headerView", "com/tencent/mobileqq/login/dialog/LoginHalfScreenDialog$b", "E", "Lcom/tencent/mobileqq/login/dialog/LoginHalfScreenDialog$b;", "mOrientationEventListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class LoginHalfScreenDialog extends ReportDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy headerView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b mOrientationEventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/dialog/LoginHalfScreenDialog$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/dialog/LoginHalfScreenDialog$b", "Landroid/view/OrientationEventListener;", "", "orientation", "", "onOrientationChanged", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends OrientationEventListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginHalfScreenDialog f242074a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, LoginHalfScreenDialog loginHalfScreenDialog) {
            super(context);
            this.f242074a = loginHalfScreenDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) loginHalfScreenDialog);
            }
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int orientation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f242074a.X();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, orientation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/login/dialog/LoginHalfScreenDialog$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginHalfScreenDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
            }
            return LoginHalfScreenDialog.this.P(x16, y16);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
            }
            return LoginHalfScreenDialog.this.Q(x16, y16);
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57419d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return LoginHalfScreenDialog.this.W();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginHalfScreenDialog(@NotNull final Context context) {
        super(context, R.style.MenuDialogStyle);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUSHalfScreenDefaultHeaderView>(context) { // from class: com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog$headerView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUSHalfScreenDefaultHeaderView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new QUSHalfScreenDefaultHeaderView(this.$context) : (QUSHalfScreenDefaultHeaderView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.headerView = lazy;
            this.mOrientationEventListener = new b(context, this);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final View S() {
        return (View) this.headerView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(LoginHalfScreenDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.dismiss();
        } catch (Exception e16) {
            QLog.e("LoginHalfScreenDialog", 1, "error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (z.b(getContext())) {
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.floatingView;
            if (qUSHalfScreenFloatingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            } else {
                qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
            }
            z.w(qUSHalfScreenFloatingView);
            return;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.floatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView3;
        }
        z.A(qUSHalfScreenFloatingView);
    }

    private final void initWindow() {
        View view;
        WindowManager.LayoutParams layoutParams;
        Integer num;
        Window window = getWindow();
        View view2 = null;
        if (window != null) {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                ImmersiveUtils.clearCoverForStatus(window, true);
                ImmersiveUtils.setStatusTextColor(!ThemeUtil.isNowThemeIsNight(null, false, null), window);
            } else {
                window.addFlags(1024);
                window.addFlags(Integer.MIN_VALUE);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Window window2 = getWindow();
            if (window2 != null) {
                view = window2.getDecorView();
            } else {
                view = null;
            }
            Window window3 = getWindow();
            if (window3 != null) {
                layoutParams = window3.getAttributes();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
            Window window4 = getWindow();
            if (window4 != null) {
                window4.setAttributes(layoutParams);
            }
            if (view != null) {
                num = Integer.valueOf(view.getSystemUiVisibility());
            } else {
                num = null;
            }
            if (num != null) {
                Integer valueOf = Integer.valueOf(num.intValue() | 1024);
                Window window5 = getWindow();
                if (window5 != null) {
                    view2 = window5.getDecorView();
                }
                if (view2 != null) {
                    view2.setSystemUiVisibility(valueOf.intValue());
                }
            }
        }
    }

    public boolean P(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 3, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
    }

    public boolean Q(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
    }

    public final void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.floatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
    }

    @NotNull
    public abstract View W();

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e3i);
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.floatingView = qUSHalfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setContentDescription(getContext().getResources().getString(R.string.f200324rt));
        initWindow();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.floatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.floatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setHeaderView(S());
        ViewParent parent = S().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        viewGroup.setBackgroundColor(0);
        ViewParent parent2 = viewGroup.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent2).setBackgroundResource(R.drawable.jc9);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.floatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView5 = null;
        }
        qUSHalfScreenFloatingView5.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.login.dialog.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                LoginHalfScreenDialog.U(LoginHalfScreenDialog.this);
            }
        });
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView6 = this.floatingView;
        if (qUSHalfScreenFloatingView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView6 = null;
        }
        qUSHalfScreenFloatingView6.setIsHeightWrapContent(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView7 = this.floatingView;
        if (qUSHalfScreenFloatingView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView7;
        }
        qUSHalfScreenFloatingView2.setContentDescription(getContext().getResources().getString(R.string.f200324rt));
        Window window = getWindow();
        if (window != null) {
            window.setNavigationBarColor(getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        X();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onStart();
            this.mOrientationEventListener.enable();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStop();
            this.mOrientationEventListener.disable();
        }
    }
}
