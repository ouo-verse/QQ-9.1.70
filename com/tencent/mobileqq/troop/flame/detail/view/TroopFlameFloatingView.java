package com.tencent.mobileqq.troop.flame.detail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000e\u0010\u0010B#\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameFloatingView;", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView;", "", "B", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "contentView", "y", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopFlameFloatingView extends QUSBaseHalfScreenFloatingView {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFlameFloatingView(@NotNull Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    protected void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.P = linearLayout;
        Intrinsics.checkNotNull(linearLayout, "null cannot be cast to non-null type android.widget.LinearLayout");
        linearLayout.setOrientation(1);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    protected void C(@Nullable AttributeSet attrs, int defStyleAttr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) attrs, defStyleAttr);
            return;
        }
        int u16 = u(36);
        this.N = new FrameLayout(getContext());
        g(attrs, defStyleAttr, new FrameLayout.LayoutParams(-1, u16));
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    @NotNull
    public View y(@NotNull View contentView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) contentView);
        }
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        return contentView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFlameFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFlameFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
