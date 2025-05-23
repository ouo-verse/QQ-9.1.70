package com.tencent.qqnt.aio.holder.template;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001b\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/holder/template/TemplateLayout;", "Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout;", "Lcom/tencent/qqnt/aio/holder/template/d;", "listener", "", "setOnInterceptTouchListener", "Lcom/tencent/qqnt/aio/holder/template/c;", "setOnAccessibilityActionListener", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "", "action", "Landroid/os/Bundle;", "arguments", "performAccessibilityAction", "J", "Lcom/tencent/qqnt/aio/holder/template/d;", "mInterceptTouchListener", "K", "Lcom/tencent/qqnt/aio/holder/template/c;", "mAccessibilityActionListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TemplateLayout extends ChatItemAnimLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private d mInterceptTouchListener;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private c mAccessibilityActionListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        d dVar = this.mInterceptTouchListener;
        if (dVar != null) {
            Intrinsics.checkNotNull(dVar);
            return dVar.onInterceptTouchEvent(ev5);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        d dVar = this.mInterceptTouchListener;
        if (dVar != null) {
            Intrinsics.checkNotNull(dVar);
            z16 = dVar.onTouchEvent(event);
        } else {
            z16 = false;
        }
        if (!z16) {
            try {
                return super.onTouchEvent(event);
            } catch (Exception e16) {
                QLog.i("TemplateLayout", 1, "[onTouchEvent]: " + e16);
                return z16;
            }
        }
        return z16;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, @Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, action, (Object) arguments)).booleanValue();
        }
        c cVar = this.mAccessibilityActionListener;
        if (cVar != null) {
            cVar.a(action, arguments);
        }
        return super.performAccessibilityAction(action, arguments);
    }

    public final void setOnAccessibilityActionListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            this.mAccessibilityActionListener = listener;
        }
    }

    public final void setOnInterceptTouchListener(@NotNull d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mInterceptTouchListener = listener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
