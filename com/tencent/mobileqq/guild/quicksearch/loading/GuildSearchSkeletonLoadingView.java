package com.tencent.mobileqq.guild.quicksearch.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import jw1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b\u001d\u0010!B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010\"\u001a\u00020\b\u00a2\u0006\u0004\b\u001d\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/loading/GuildSearchSkeletonLoadingView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "c", "f", "a", "", "type", "d", "e", "b", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "mRecyclerView", "Ljw1/a;", "Ljw1/a;", "mLoadingAdapter", "Landroid/widget/RelativeLayout;", h.F, "Landroid/widget/RelativeLayout;", "mLightView", "Landroid/view/View;", "i", "Landroid/view/View;", "mLeftAnimLightView", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSearchSkeletonLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mLoadingAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mLightView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mLeftAnimLightView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSearchSkeletonLoadingView(@NotNull Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        c(context2);
    }

    private final void a() {
        RelativeLayout relativeLayout = this.mLightView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLightView");
            relativeLayout = null;
        }
        relativeLayout.clearAnimation();
    }

    private final void c(Context context) {
        this.mContext = context;
        View inflate = View.inflate(context, R.layout.f3j, this);
        View findViewById = inflate.findViewById(R.id.ysg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.loading_cards_list)");
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) findViewById;
        this.mRecyclerView = overScrollRecyclerViewWithHeaderFooter;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setFocusableInTouchMode(false);
        View findViewById2 = inflate.findViewById(R.id.ysw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.loading_light)");
        this.mLightView = (RelativeLayout) findViewById2;
        View findViewById3 = findViewById(R.id.ygt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.left_1)");
        this.mLeftAnimLightView = findViewById3;
    }

    private final void f() {
        View view = this.mLeftAnimLightView;
        RelativeLayout relativeLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
            view = null;
        }
        QQGuildUIUtil.S(view);
        RelativeLayout relativeLayout2 = this.mLightView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLightView");
            relativeLayout2 = null;
        }
        float x16 = relativeLayout2.getX() - ViewUtils.dpToPx(400.0f);
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        float dpToPx = x.f(context).f185860a + ViewUtils.dpToPx(200.0f);
        RelativeLayout relativeLayout3 = this.mLightView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLightView");
            relativeLayout3 = null;
        }
        float y16 = relativeLayout3.getY();
        RelativeLayout relativeLayout4 = this.mLightView;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLightView");
            relativeLayout4 = null;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(x16, dpToPx, y16, relativeLayout4.getY());
        translateAnimation.setDuration(JoinTimeType.THIRTY_MINUTES);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        RelativeLayout relativeLayout5 = this.mLightView;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLightView");
        } else {
            relativeLayout = relativeLayout5;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public final void b() {
        setVisibility(8);
        RelativeLayout relativeLayout = this.mLightView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLightView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        a();
    }

    public final void d(int type) {
        if (this.mLoadingAdapter == null) {
            this.mLoadingAdapter = new a();
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mRecyclerView;
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = null;
            if (overScrollRecyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                overScrollRecyclerViewWithHeaderFooter = null;
            }
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            overScrollRecyclerViewWithHeaderFooter.setLayoutManager(new LinearLayoutManager(context));
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.mRecyclerView;
            if (overScrollRecyclerViewWithHeaderFooter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            } else {
                overScrollRecyclerViewWithHeaderFooter2 = overScrollRecyclerViewWithHeaderFooter3;
            }
            overScrollRecyclerViewWithHeaderFooter2.setAdapter(this.mLoadingAdapter);
        }
        a aVar = this.mLoadingAdapter;
        if (aVar != null) {
            aVar.l0(type);
        }
    }

    public final void e() {
        setVisibility(0);
        RelativeLayout relativeLayout = this.mLightView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLightView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSearchSkeletonLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        c(context2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSearchSkeletonLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        c(context2);
    }
}
