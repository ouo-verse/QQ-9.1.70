package com.tencent.mobileqq.guild.media.content.loading;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ss1.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0004B\u001d\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/media/content/loading/GuildMediaLoadingSkeletonContent;", "Landroid/widget/FrameLayout;", "", "d", "a", "Landroid/view/View;", "lightView", "e", "c", "b", "Landroid/view/View;", "mRootView", "Landroid/widget/GridView;", "Landroid/widget/GridView;", "mGridView", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "mLightView", h.F, "mLeftAnimLightView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaLoadingSkeletonContent extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GridView mGridView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout mLightView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mLeftAnimLightView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaLoadingSkeletonContent(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        this.mLightView.clearAnimation();
    }

    private final void d() {
        e(this.mLeftAnimLightView);
        TranslateAnimation translateAnimation = new TranslateAnimation(this.mLightView.getX() - ViewUtils.dpToPx(400.0f), x.f(getContext()).f185860a + ViewUtils.dpToPx(200.0f), this.mLightView.getY(), this.mLightView.getY());
        translateAnimation.setDuration(JoinTimeType.THIRTY_MINUTES);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        this.mLightView.startAnimation(translateAnimation);
    }

    private final void e(View lightView) {
        Resources resources = lightView.getResources();
        int color = resources.getColor(R.color.bon);
        QQGuildUIUtil.R(lightView, new int[]{color, resources.getColor(R.color.f157158bs4), color});
    }

    public final void b() {
        setVisibility(8);
        a();
    }

    public final void c() {
        setVisibility(0);
        d();
    }

    public /* synthetic */ GuildMediaLoadingSkeletonContent(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaLoadingSkeletonContent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.ey6, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026el_content_loading, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.u8c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.content_loading_grid)");
        GridView gridView = (GridView) findViewById;
        this.mGridView = gridView;
        View findViewById2 = inflate.findViewById(R.id.ysw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.loading_light)");
        this.mLightView = (RelativeLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ygt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.left_1)");
        this.mLeftAnimLightView = findViewById3;
        gridView.setSelector(new ColorDrawable(0));
        gridView.setAdapter((ListAdapter) new a(context));
    }
}
