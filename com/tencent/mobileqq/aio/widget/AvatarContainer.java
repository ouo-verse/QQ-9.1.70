package com.tencent.mobileqq.aio.widget;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/AvatarContainer;", "Landroid/widget/RelativeLayout;", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "", "action", "Landroid/os/Bundle;", "arguments", "", "performAccessibilityAction", "Landroid/view/View;", "view", "setTraversalBeforeView", "d", "I", "ACCESSIBILITY_ACTION_DOUBLE_TAP", "e", "Landroid/view/View;", "traversalBeforeView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AvatarContainer extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int ACCESSIBILITY_ACTION_DOUBLE_TAP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View traversalBeforeView;

    public AvatarContainer(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.ACCESSIBILITY_ACTION_DOUBLE_TAP = 33554432;
        }
    }

    @Override // android.view.View
    @RequiresApi(24)
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(info);
        if (Build.VERSION.SDK_INT >= 24 && info != null) {
            info.setImportantForAccessibility(true);
            info.addAction(new AccessibilityNodeInfo.AccessibilityAction(this.ACCESSIBILITY_ACTION_DOUBLE_TAP, getContext().getResources().getString(R.string.f173172sf)));
            View view = this.traversalBeforeView;
            if (view != null) {
                info.setTraversalBefore(view);
            }
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, @Nullable Bundle arguments) {
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, action, (Object) arguments)).booleanValue();
        }
        if (action == this.ACCESSIBILITY_ACTION_DOUBLE_TAP) {
            Object tag = getTag();
            if (tag instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) tag;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null) {
                com.tencent.qqnt.aio.paiyipai.b.INSTANCE.a(this, aIOMsgItem);
            }
        }
        return super.performAccessibilityAction(action, arguments);
    }

    public final void setTraversalBeforeView(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.traversalBeforeView = view;
        }
    }
}
