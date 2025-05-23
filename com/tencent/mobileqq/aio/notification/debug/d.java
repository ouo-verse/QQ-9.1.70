package com.tencent.mobileqq.aio.notification.debug;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/debug/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState;", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "debugContainer", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "debugLiveSendBtn", h.F, "debugTodoSendBtn", "i", "debugApplicationSendBtn", "<init>", "(Landroid/widget/FrameLayout;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends com.tencent.aio.base.mvvm.a<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout debugContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Button debugLiveSendBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Button debugTodoSendBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Button debugApplicationSendBtn;

    public d(@NotNull FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) container);
        } else {
            this.container = container;
        }
    }

    private final void e1() {
        LinearLayout linearLayout = new LinearLayout(this.container.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.rightMargin = (int) l.a(30.0f);
        layoutParams.bottomMargin = (int) l.a(100.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        this.debugContainer = linearLayout;
        Button button = new Button(this.container.getContext());
        button.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        button.setText("\u53d1\u9001\u4e00\u6761\u5b9e\u65f6\u6d3b\u52a8");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.debug.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f1(view);
            }
        });
        this.debugLiveSendBtn = button;
        Button button2 = new Button(this.container.getContext());
        button2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        button2.setText("\u53d1\u9001\u4e00\u6761\u5f85\u529e\u901a\u77e5");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g1(view);
            }
        });
        this.debugTodoSendBtn = button2;
        Button button3 = new Button(this.container.getContext());
        button3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        button3.setText("\u53d1\u9001\u4e00\u6761\u5e94\u7528\u901a\u77e5");
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.debug.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.h1(view);
            }
        });
        this.debugApplicationSendBtn = button3;
        LinearLayout linearLayout2 = this.debugContainer;
        Button button4 = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugContainer");
            linearLayout2 = null;
        }
        Button button5 = this.debugLiveSendBtn;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugLiveSendBtn");
            button5 = null;
        }
        linearLayout2.addView(button5);
        LinearLayout linearLayout3 = this.debugContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugContainer");
            linearLayout3 = null;
        }
        Button button6 = this.debugTodoSendBtn;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugTodoSendBtn");
            button6 = null;
        }
        linearLayout3.addView(button6);
        LinearLayout linearLayout4 = this.debugContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugContainer");
            linearLayout4 = null;
        }
        Button button7 = this.debugApplicationSendBtn;
        if (button7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugApplicationSendBtn");
        } else {
            button4 = button7;
        }
        linearLayout4.addView(button4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        AIODebugNotificationProvider.f192877d.b(AIONotificationBusiId.DEBUG_LIVE);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        AIODebugNotificationProvider.f192877d.b(AIONotificationBusiId.DEBUG_TODO);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        AIODebugNotificationProvider.f192877d.b(AIONotificationBusiId.DEBUG_APPLICATION);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        e1();
        LinearLayout linearLayout = this.debugContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugContainer");
            return null;
        }
        return linearLayout;
    }
}
