package com.tencent.mobileqq.statustitle.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0004B\u0013\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001d\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016B%\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0018J\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/statustitle/widget/TitleAreaLeftLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "", "a", "Landroid/view/View;", "headLayout", "", "setHeadLayout", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "progress", "J", "d", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TitleAreaLeftLayout extends RelativeLayout implements IGuildLayoutApi.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View headLayout;

    public TitleAreaLeftLayout(Context context) {
        super(context);
    }

    public final int a() {
        View view = this.headLayout;
        if (view == null) {
            return 0;
        }
        Intrinsics.checkNotNull(view);
        return view.getWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GuildSlideCoordinator.k(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GuildSlideCoordinator.v(this);
    }

    public final void setHeadLayout(View headLayout) {
        Intrinsics.checkNotNullParameter(headLayout, "headLayout");
        this.headLayout = headLayout;
    }

    public TitleAreaLeftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TitleAreaLeftLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.d
    public void J(float progress) {
        float f16 = progress / 100.0f;
        setTranslationX((-(a() + getWidth())) * f16);
        setAlpha(1 - f16);
    }
}
