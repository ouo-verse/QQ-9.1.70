package com.tencent.mobileqq.zootopia.profile.customer.tips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import bd3.b;
import bd3.c;
import bd3.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import id3.d;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105B\u001b\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\b\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b4\u00108B#\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b4\u0010;J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u001e\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fR$\u0010$\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010(R$\u0010.\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010*\u001a\u0004\b%\u0010+\"\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010/R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010/\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/zootopia/profile/customer/tips/BaseTipsView;", "Landroid/widget/FrameLayout;", "Lbd3/b;", "Landroid/view/View$OnClickListener;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lbd3/e;", "data", "Lbd3/c;", "callback", "", "g", "Landroid/widget/FrameLayout$LayoutParams;", "d", "i", "Landroid/view/View;", "c", "show", "j", h.F, "", "b", "a", "v", NodeProps.ON_CLICK, "k", "Lid3/d;", "helper", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/view/View;", "f", "()Landroid/view/View;", "setTipsView", "(Landroid/view/View;)V", "tipsView", "e", "Lbd3/c;", "tipsViewCallback", "Landroid/view/ViewGroup;", "containerView", "Lbd3/e;", "()Lbd3/e;", "setTipsData", "(Lbd3/e;)V", "tipsData", "Z", "inited", "destroyed", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseTipsView extends FrameLayout implements b, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View tipsView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c tipsViewCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup containerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private e tipsData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean inited;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean destroyed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/profile/customer/tips/BaseTipsView$a;", "", "Landroid/content/Context;", "context", "", "type", "Lcom/tencent/mobileqq/zootopia/profile/customer/tips/BaseTipsView;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final BaseTipsView a(Context context, int type) {
            if (context == null) {
                return null;
            }
            if (type == 0) {
                return new RequestPermissionTipsView(context);
            }
            if (type != 3) {
                return null;
            }
            return new RequestPermissionFSTipsView(context);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseTipsView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        if (this.inited && !this.destroyed) {
            if (getParent() == null) {
                QLog.w("BaseTipsView", 1, "dismiss, parent is null");
                return;
            }
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
            QLog.w("BaseTipsView", 1, "dismiss");
            c cVar = this.tipsViewCallback;
            if (cVar != null) {
                cVar.onDismiss();
            }
            h();
            this.tipsViewCallback = null;
            this.containerView = null;
            this.destroyed = true;
            return;
        }
        QLog.w("BaseTipsView", 1, "dismiss, not inited");
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public FrameLayout.LayoutParams d() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: from getter */
    public final e getTipsData() {
        return this.tipsData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f, reason: from getter */
    public final View getTipsView() {
        return this.tipsView;
    }

    public void g(ViewGroup container, e data, c callback) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.inited || this.destroyed) {
            return;
        }
        this.inited = true;
        this.containerView = container;
        this.tipsData = data;
        this.tipsViewCallback = callback;
        View c16 = c();
        this.tipsView = c16;
        addView(c16, d());
        i();
        c cVar = this.tipsViewCallback;
        if (cVar != null) {
            cVar.a();
        }
    }

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k(View v3);

    @Override // android.view.View.OnClickListener
    public final void onClick(View v3) {
        c cVar = this.tipsViewCallback;
        boolean z16 = false;
        if (cVar != null && cVar.onViewClick(v3)) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (Intrinsics.areEqual(v3, this) && b()) {
            a();
        } else {
            k(v3);
        }
    }

    @Override // bd3.b
    public final void show() {
        if (this.inited && !this.destroyed) {
            if (getParent() != null) {
                QLog.w("BaseTipsView", 1, "has parent");
                return;
            }
            ViewGroup viewGroup = this.containerView;
            if (viewGroup != null) {
                QLog.w("BaseTipsView", 1, "addView");
                viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
            }
            c cVar = this.tipsViewCallback;
            if (cVar != null) {
                cVar.onShow();
            }
            j();
            return;
        }
        QLog.w("BaseTipsView", 1, "not inited");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTipsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundColor(Integer.MIN_VALUE);
        setOnClickListener(this);
    }

    public final void l(d helper, View view) {
        if (helper == null || view == null) {
            return;
        }
        helper.c("clck", view, new LinkedHashMap());
    }

    public final void m(d helper, View view) {
        if (helper == null || view == null) {
            return;
        }
        helper.c("imp", view, new LinkedHashMap());
    }
}
