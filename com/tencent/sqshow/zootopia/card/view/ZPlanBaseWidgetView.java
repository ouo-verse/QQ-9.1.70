package com.tencent.sqshow.zootopia.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B!\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\nH&J\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0010\u0010\fJ\b\u0010\u0011\u001a\u00020\u0007H&J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\u0012\u0010\u000eJ\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u0018\u001a\u00028\u00008\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/ZPlanBaseWidgetView;", "V", "T", "Landroid/widget/FrameLayout;", "", "isDebugOnly", "c", "", "d", "data", "", "setData", "(Ljava/lang/Object;)V", "b", "()Ljava/lang/Object;", "g", "a", "i", "f", "logMsg", h.F, "Ljava/lang/Object;", "e", "setBinding", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class ZPlanBaseWidgetView<V, T> extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private V binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private T data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = b();
        g();
    }

    private final String d() {
        return "ZPlanBaseWidgetView_" + i();
    }

    public abstract void a(T data);

    public abstract V b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final V e() {
        return this.binding;
    }

    public final T f() {
        return this.data;
    }

    public abstract void g();

    public final void h(String logMsg, boolean isDebugOnly) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        if (c(isDebugOnly)) {
            QLog.i(d(), 1, logMsg);
        }
    }

    public abstract String i();

    public final void setData(T data) {
        this.data = data;
        a(data);
    }

    private final boolean c(boolean isDebugOnly) {
        return !isDebugOnly || QLog.isColorLevel();
    }
}
