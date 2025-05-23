package com.tencent.tuxmeterqui.common;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView;
import com.tencent.qui.quibottomfloatingview.QUIHalfScreenFloatingView;
import com.tencent.qui.quibottomfloatingview.c;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/tuxmeterqui/common/TuxCommonPopupDialog;", "Landroid/app/Dialog;", "", "initWindow", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "dismiss", "Lcom/tencent/qui/quibottomfloatingview/QUIHalfScreenFloatingView;", "qusHalfScreenFloatingView", "Lcom/tencent/qui/quibottomfloatingview/QUIHalfScreenFloatingView;", "Landroid/widget/FrameLayout;", "mContainer", "Landroid/widget/FrameLayout;", "Landroid/widget/ScrollView;", "mScrollView", "Landroid/widget/ScrollView;", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "Lcom/tencent/qui/quibottomfloatingview/QUIBaseHalfScreenFloatingView$l;", "dismissListener", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/qui/quibottomfloatingview/QUIBaseHalfScreenFloatingView$l;)V", "Companion", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class TuxCommonPopupDialog extends ReportDialog {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TuxCommonPopupDialog";
    private FrameLayout mContainer;
    private ScrollView mScrollView;

    @NotNull
    private final QUIHalfScreenFloatingView qusHalfScreenFloatingView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/tuxmeterqui/common/TuxCommonPopupDialog$Companion;", "", "()V", "TAG", "", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TuxCommonPopupDialog(@NotNull Context context, @NotNull View view, @Nullable final QUIBaseHalfScreenFloatingView.l lVar) {
        super(context, R.style.aix);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, view, lVar);
            return;
        }
        initWindow();
        setContentView(R.layout.i1l);
        View findViewById = findViewById(R.id.f10434632);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tux_floating_half_screen)");
        QUIHalfScreenFloatingView qUIHalfScreenFloatingView = (QUIHalfScreenFloatingView) findViewById;
        this.qusHalfScreenFloatingView = qUIHalfScreenFloatingView;
        qUIHalfScreenFloatingView.setIsHeightWrapContent(true);
        qUIHalfScreenFloatingView.setIsContentDraggable(false);
        qUIHalfScreenFloatingView.setContentViewBackgroundResource(R.color.qui_common_bg_middle_light);
        qUIHalfScreenFloatingView.setQUIDragFloatController(new c(context, view) { // from class: com.tencent.tuxmeterqui.common.TuxCommonPopupDialog.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ View $view;

            {
                this.$context = context;
                this.$view = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TuxCommonPopupDialog.this, context, view);
                }
            }

            @Override // com.tencent.qui.quibottomfloatingview.b
            @NotNull
            public View createContentView() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TuxCommonPopupDialog tuxCommonPopupDialog = TuxCommonPopupDialog.this;
                FrameLayout frameLayout = new FrameLayout(TuxCommonPopupDialog.this.getContext());
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                tuxCommonPopupDialog.mContainer = frameLayout;
                TuxCommonPopupDialog tuxCommonPopupDialog2 = TuxCommonPopupDialog.this;
                ScrollView scrollView = new ScrollView(this.$context);
                View view2 = this.$view;
                scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                ViewParent parent = view2.getParent();
                if (parent != null) {
                    Intrinsics.checkNotNullExpressionValue(parent, "parent");
                    ((ViewGroup) parent).removeView(view2);
                }
                scrollView.addView(view2);
                tuxCommonPopupDialog2.mScrollView = scrollView;
                FrameLayout frameLayout2 = TuxCommonPopupDialog.this.mContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    frameLayout2 = null;
                }
                ScrollView scrollView2 = TuxCommonPopupDialog.this.mScrollView;
                if (scrollView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mScrollView");
                    scrollView2 = null;
                }
                frameLayout2.addView(scrollView2);
                FrameLayout frameLayout3 = TuxCommonPopupDialog.this.mContainer;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    return null;
                }
                return frameLayout3;
            }

            @Override // com.tencent.qui.quibottomfloatingview.c, com.tencent.qui.quibottomfloatingview.b
            public int maxHeight() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 5, (Object) this)).intValue();
                }
                return (this.$context.getResources().getDisplayMetrics().heightPixels * 4) / 5;
            }

            @Override // com.tencent.qui.quibottomfloatingview.c, com.tencent.qui.quibottomfloatingview.b
            public int minHeight() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 4, (Object) this)).intValue();
                }
                return (this.$context.getResources().getDisplayMetrics().heightPixels * 1) / 5;
            }

            @Override // com.tencent.qui.quibottomfloatingview.c, com.tencent.qui.quibottomfloatingview.b
            public int showMode() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this)).intValue();
                }
                return 1;
            }
        });
        qUIHalfScreenFloatingView.setOnDismissListener(new QUIBaseHalfScreenFloatingView.l() { // from class: com.tencent.tuxmeterqui.common.a
            @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                TuxCommonPopupDialog._init_$lambda$0(TuxCommonPopupDialog.this, lVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(TuxCommonPopupDialog this$0, QUIBaseHalfScreenFloatingView.l lVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.dismiss();
        if (lVar != null) {
            lVar.onDismiss();
        }
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(32);
        try {
            TuxUIUtils.clearCoverForStatus(window, true);
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.qusHalfScreenFloatingView.h();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
    }
}
