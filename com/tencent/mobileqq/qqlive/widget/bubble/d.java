package com.tencent.mobileqq.qqlive.widget.bubble;

import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\nR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/bubble/d;", "", "Landroid/view/View;", "customView", h.F, "anchor", "g", "", "intervalMs", "j", "", "d", "Lcom/tencent/mobileqq/qqlive/widget/bubble/d$a;", "callback", "k", "l", "Landroid/widget/PopupWindow;", "a", "Landroid/widget/PopupWindow;", "popupWindow", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "anchorView", "c", "Lcom/tencent/mobileqq/qqlive/widget/bubble/d$a;", "statusCallback", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "dismissRunnable", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> anchorView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a statusCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable dismissRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/bubble/d$a;", "", "", "onDismiss", "onShow", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        void onClick(@Nullable View v3);

        void onDismiss();

        void onShow();
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        PopupWindow popupWindow = new PopupWindow(-2, -2);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.qqlive.widget.bubble.a
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                d.f(d.this);
            }
        });
        this.popupWindow = popupWindow;
        this.dismissRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.bubble.b
            @Override // java.lang.Runnable
            public final void run() {
                d.e(d.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.statusCallback;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.statusCallback;
        if (aVar != null) {
            aVar.onClick(view);
        }
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.dismissRunnable);
    }

    @NotNull
    public final d g(@NotNull View anchor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) anchor);
        }
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this.anchorView = new WeakReference<>(anchor);
        return this;
    }

    @NotNull
    public final d h(@NotNull View customView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) customView);
        }
        Intrinsics.checkNotNullParameter(customView, "customView");
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            customView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.bubble.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.i(d.this, view);
                }
            });
            popupWindow.setContentView(customView);
        }
        return this;
    }

    @NotNull
    public final d j(long intervalMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, intervalMs);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.dismissRunnable, intervalMs);
        return this;
    }

    @NotNull
    public final d k(@Nullable a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
        }
        this.statusCallback = callback;
        return this;
    }

    public final void l() {
        View view;
        PopupWindow popupWindow;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        a aVar = this.statusCallback;
        if (aVar != null) {
            aVar.onShow();
        }
        WeakReference<View> weakReference = this.anchorView;
        if (weakReference != null && (view = weakReference.get()) != null && (popupWindow = this.popupWindow) != null) {
            popupWindow.showAtLocation(view, 17, 0, 0);
        }
    }
}
