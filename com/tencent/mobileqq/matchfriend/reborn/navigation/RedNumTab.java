package com.tencent.mobileqq.matchfriend.reborn.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0000R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u0018\u0010&R\u001b\u0010+\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b\u001b\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/navigation/RedNumTab;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "target", "", "i", h.F, "Landroid/widget/FrameLayout$LayoutParams;", "g", "e", "", LayoutAttrDefine.Gravity.Gravity, "j", "", "topMargin", "l", "rightMargin", "k", WidgetCacheConstellationData.NUM, "setNum", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "setOnModeChangeListener", "c", "d", "Landroid/view/View;", "I", "f", "bottomMargin", "leftMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isApplyTo", "Landroid/widget/LinearLayout;", "D", "Lkotlin/Lazy;", "()Landroid/widget/LinearLayout;", "redBadgeContainer", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "E", "()Lcom/tencent/mobileqq/quibadge/QUIBadge;", "redBadgeView", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RedNumTab extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isApplyTo;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy redBadgeContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy redBadgeView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View target;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int gravity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int topMargin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int bottomMargin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int leftMargin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int rightMargin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedNumTab(Context ctx, View target) {
        super(ctx);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
        this.gravity = 53;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.matchfriend.reborn.navigation.RedNumTab$redBadgeContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                FrameLayout.LayoutParams e16;
                LinearLayout linearLayout = new LinearLayout(RedNumTab.this.getContext());
                RedNumTab redNumTab = RedNumTab.this;
                e16 = redNumTab.e();
                linearLayout.setLayoutParams(e16);
                linearLayout.setOrientation(0);
                redNumTab.addView(linearLayout);
                return linearLayout;
            }
        });
        this.redBadgeContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QUIBadge>() { // from class: com.tencent.mobileqq.matchfriend.reborn.navigation.RedNumTab$redBadgeView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIBadge invoke() {
                LinearLayout d16;
                QUIBadge qUIBadge = new QUIBadge(RedNumTab.this.getContext());
                RedNumTab redNumTab = RedNumTab.this;
                qUIBadge.setDragGroup("stranger_msg");
                qUIBadge.setDragType(3);
                d16 = redNumTab.d();
                d16.addView(qUIBadge);
                return qUIBadge;
            }
        });
        this.redBadgeView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout d() {
        return (LinearLayout) this.redBadgeContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout.LayoutParams e() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.gravity;
        layoutParams.leftMargin = this.leftMargin;
        layoutParams.rightMargin = this.rightMargin;
        layoutParams.topMargin = this.topMargin;
        layoutParams.bottomMargin = this.bottomMargin;
        return layoutParams;
    }

    private final FrameLayout.LayoutParams g() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    private final void h(View target) {
        target.setLayoutParams(g());
        addView(target);
    }

    private final void i(View target) {
        ViewParent parent = target.getParent();
        if (parent == null) {
            return;
        }
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            int indexOfChild = viewGroup.indexOfChild(target);
            viewGroup.removeView(target);
            setLayoutParams(target.getLayoutParams());
            viewGroup.addView(this, indexOfChild);
        }
    }

    public final RedNumTab c() {
        if (!this.isApplyTo) {
            i(this.target);
            h(this.target);
            d();
            this.isApplyTo = true;
        } else {
            d().setLayoutParams(e());
        }
        return this;
    }

    public final QUIBadge f() {
        return (QUIBadge) this.redBadgeView.getValue();
    }

    public final RedNumTab j(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public final RedNumTab k(float rightMargin) {
        this.rightMargin = (int) l.a(rightMargin);
        return this;
    }

    public final RedNumTab l(float topMargin) {
        this.topMargin = (int) l.a(topMargin);
        return this;
    }

    public final void setNum(int num) {
        f().setRedNum(num);
    }

    public final void setOnModeChangeListener(com.tencent.mobileqq.quibadge.b dragListener) {
        Intrinsics.checkNotNullParameter(dragListener, "dragListener");
        f().setOnModeChangeListener(dragListener);
    }
}
