package com.tencent.open.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/open/widget/QUSFloatingViewDialog;", "Landroid/app/Dialog;", "", "initWindow", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "P", "()Landroid/view/View;", "headerView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "qusHalfScreenFloatingView", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/qus/e;", "adapter", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/widget/qus/e;)V", "E", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QUSFloatingViewDialog extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy headerView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final QUSHalfScreenFloatingView qusHalfScreenFloatingView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUSFloatingViewDialog(@NotNull Context context, @NotNull e adapter) {
        super(context, R.style.MenuDialogStyle);
        Lazy lazy;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.open.widget.QUSFloatingViewDialog$headerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout relativeLayout = new RelativeLayout(QUSFloatingViewDialog.this.getContext());
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(relativeLayout.getContext());
                imageView.setImageDrawable(ContextCompat.getDrawable(relativeLayout.getContext(), R.drawable.ui_halfscreen_header_drag_icon));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                relativeLayout.addView(imageView, layoutParams);
                return relativeLayout;
            }
        });
        this.headerView = lazy;
        initWindow();
        setContentView(R.layout.e3i);
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.qusHalfScreenFloatingView = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setHeaderView(P());
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setQUSDragFloatController(adapter);
            qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.open.widget.c
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    QUSFloatingViewDialog.O(QUSFloatingViewDialog.this);
                }
            });
            qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        }
        ViewParent parent = P().getParent();
        if (parent != null) {
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(0);
            }
            ViewParent parent2 = parent.getParent();
            ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup2 != null) {
                viewGroup2.setBackgroundResource(R.drawable.f162032l82);
            }
            Window window = getWindow();
            if (window != null) {
                window.setNavigationBarColor(context.getColor(R.color.qui_common_bg_bottom_standard));
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setLayout(-1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(QUSFloatingViewDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final View P() {
        return (View) this.headerView.getValue();
    }

    private final void initWindow() {
        View view;
        WindowManager.LayoutParams layoutParams;
        Integer num;
        Window window = getWindow();
        if (window != null) {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                ImmersiveUtils.clearCoverForStatus(window, true);
                ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), window);
            } else {
                window.addFlags(1024);
                window.addFlags(Integer.MIN_VALUE);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Window window2 = getWindow();
            View view2 = null;
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
}
