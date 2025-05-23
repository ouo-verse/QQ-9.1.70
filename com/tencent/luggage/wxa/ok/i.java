package com.tencent.luggage.wxa.ok;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u0014B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H$J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u001b\u0010\u0019\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/luggage/wxa/ok/i;", "Lcom/tencent/luggage/wxa/il/d;", "Lcom/tencent/luggage/wxa/ok/j;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "getView", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/lang/Runnable;", "action", "", Method.POST, "", "delayMillis", "postDelayed", "postOnAnimation", "postOnAnimationDelayed", "msg", "a", "G", "Lkotlin/Lazy;", "get_instanceDescription", "()Ljava/lang/String;", "_instanceDescription", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "H", "luggage-wxa-app_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public abstract class i extends com.tencent.luggage.wxa.il.d implements j {

    /* renamed from: G, reason: from kotlin metadata */
    public final Lazy _instanceDescription;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return i.this.m();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull Context context) {
        super(context, null, 2, null);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        a(true);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new b());
        this._instanceDescription = lazy;
    }

    private final String get_instanceDescription() {
        return (String) this._instanceDescription.getValue();
    }

    public final void a(String msg2) {
        w.d("Luggage.Wxa.BaseFrameLayoutLoadingSplashImpl", msg2 + " [with instance:" + get_instanceDescription() + ']');
    }

    public abstract String m();

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    @Override // android.view.View
    public boolean post(Runnable action) {
        if (action == null) {
            return false;
        }
        if (ViewCompat.isAttachedToWindow(this)) {
            return super.post(action);
        }
        c0.a(action);
        return true;
    }

    @Override // android.view.View
    public boolean postDelayed(Runnable action, long delayMillis) {
        if (action == null) {
            return false;
        }
        if (ViewCompat.isAttachedToWindow(this)) {
            return super.postDelayed(action, delayMillis);
        }
        c0.a(action, delayMillis);
        return true;
    }

    @Override // android.view.View
    public void postOnAnimation(Runnable action) {
        if (action == null) {
            return;
        }
        if (ViewCompat.isAttachedToWindow(this)) {
            super.postOnAnimation(action);
        } else {
            c0.a(action);
        }
    }

    @Override // android.view.View
    public void postOnAnimationDelayed(Runnable action, long delayMillis) {
        if (action == null) {
            return;
        }
        if (ViewCompat.isAttachedToWindow(this)) {
            super.postOnAnimationDelayed(action, delayMillis);
        } else {
            c0.a(action, delayMillis);
        }
    }

    public /* bridge */ /* synthetic */ void setAppServiceType(int i3) {
        o31.b.a(this, i3);
    }

    public /* bridge */ /* synthetic */ void setCanShowHideAnimation(boolean z16) {
        o31.b.b(this, z16);
    }

    public abstract /* synthetic */ void setProgress(int i3);

    @NotNull
    public View getView() {
        return this;
    }
}
