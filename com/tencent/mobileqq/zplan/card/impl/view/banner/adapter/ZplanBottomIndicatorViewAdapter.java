package com.tencent.mobileqq.zplan.card.impl.view.banner.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.f;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pv4.q;
import pv4.u;
import sf3.ZplanBannerIndicatorBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000234B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\u0004\b0\u00101J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002R\u00020\u0000H\u0002J\u0014\u0010\t\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002R\u00020\u0000H\u0002J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0014\u0010\u0011\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002R\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017RT\u0010%\u001a4\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$RT\u0010)\u001a4\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter$a;", "holder", "", "isSelected", "", "k0", "t0", "s0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "position", "l0", "p0", "getItemCount", "o0", "", "Lsf3/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "getClickListener", "()Lkotlin/jvm/functions/Function2;", "q0", "(Lkotlin/jvm/functions/Function2;)V", "clickListener", "D", "getRenderListener", "r0", "renderListener", "Landroid/animation/AnimatorSet;", "E", "Lkotlin/Lazy;", "j0", "()Landroid/animation/AnimatorSet;", "animatorSet", "<init>", "(Ljava/util/List;)V", UserInfo.SEX_FEMALE, "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanBottomIndicatorViewAdapter extends RecyclerView.Adapter<a> {
    private static final int G = ViewUtils.dpToPx(34.0f);
    private static final int H = ViewUtils.dpToPx(38.0f);
    private static final int I = (ViewUtils.getScreenWidth() - ViewUtils.dpToPx(28.0f)) / 5;

    /* renamed from: C, reason: from kotlin metadata */
    private Function2<? super Integer, ? super View, Unit> clickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private Function2<? super Integer, ? super View, Unit> renderListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy animatorSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ZplanBannerIndicatorBean> data;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "bgview", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "ironView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView bgview;

        /* renamed from: F, reason: from kotlin metadata */
        private final ZPlanMediaView ironView;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView titleView;
        final /* synthetic */ ZplanBottomIndicatorViewAdapter H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ZplanBottomIndicatorViewAdapter zplanBottomIndicatorViewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = zplanBottomIndicatorViewAdapter;
            View findViewById = itemView.findViewById(R.id.r68);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.zplan_iv_bg)");
            this.bgview = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.r6e);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.zplan_iv_iron)");
            this.ironView = (ZPlanMediaView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.r9b);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.zplan_tv_title)");
            this.titleView = (TextView) findViewById3;
        }

        public final TextView getTitleView() {
            return this.titleView;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getBgview() {
            return this.bgview;
        }

        /* renamed from: m, reason: from getter */
        public final ZPlanMediaView getIronView() {
            return this.ironView;
        }
    }

    public ZplanBottomIndicatorViewAdapter(List<ZplanBannerIndicatorBean> data) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AnimatorSet>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.ZplanBottomIndicatorViewAdapter$animatorSet$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AnimatorSet invoke() {
                return new AnimatorSet();
            }
        });
        this.animatorSet = lazy;
    }

    private final AnimatorSet j0() {
        return (AnimatorSet) this.animatorSet.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(ZplanBottomIndicatorViewAdapter this$0, int i3, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<? super Integer, ? super View, Unit> function2 = this$0.clickListener;
        if (function2 != null) {
            Integer valueOf = Integer.valueOf(i3);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function2.invoke(valueOf, it);
        }
    }

    private final void s0(a holder) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.cancel();
        holder.getBgview().setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(holder.getBgview(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ZPlanMediaView ironView = holder.getIronView();
        int i3 = H;
        int i16 = G;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ironView, BasicAnimation.KeyPath.SCALE_X, 1.0f, i3 / i16);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(holder.getIronView(), BasicAnimation.KeyPath.SCALE_Y, 1.0f, i3 / i16);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new c(animatorSet));
        ofFloat.setDuration(300L);
        ofFloat2.setDuration(300L);
        ofFloat3.setDuration(300L);
        animatorSet.start();
    }

    private final void t0(a holder) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.cancel();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(holder.getBgview(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ZPlanMediaView ironView = holder.getIronView();
        int i3 = H;
        int i16 = G;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ironView, BasicAnimation.KeyPath.SCALE_X, i3 / i16, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(holder.getIronView(), BasicAnimation.KeyPath.SCALE_Y, i3 / i16, 1.0f);
        animatorSet.addListener(new d(holder, animatorSet));
        ofFloat.setDuration(300L);
        ofFloat2.setDuration(300L);
        ofFloat3.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int position) {
        g gVar;
        u uVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ZplanBannerIndicatorBean zplanBannerIndicatorBean = this.data.get(position);
        k0(holder, zplanBannerIndicatorBean.getIsItemSelected());
        q littleModule = zplanBannerIndicatorBean.getLittleModule();
        if (littleModule != null && (uVar = littleModule.f427655c) != null) {
            m84.b.h(holder.getTitleView(), uVar);
        }
        holder.getIronView().setRadius(9);
        q littleModule2 = zplanBannerIndicatorBean.getLittleModule();
        if (littleModule2 != null && (gVar = littleModule2.f427653a) != null) {
            holder.getIronView().setDefaultDrawable(new ColorDrawable(com.tencent.sqshow.zootopia.utils.q.a(R.color.f8426x)));
            holder.getIronView().e(gVar);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanBottomIndicatorViewAdapter.m0(ZplanBottomIndicatorViewAdapter.this, position, view);
            }
        });
        Function2<? super Integer, ? super View, Unit> function2 = this.renderListener;
        if (function2 != null) {
            Integer valueOf = Integer.valueOf(position);
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            function2.invoke(valueOf, view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dam, parent, false);
        itemView.setLayoutParams(new ConstraintLayout.LayoutParams(I, -2));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(this, itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        j0().removeAllListeners();
        j0().cancel();
    }

    public final void q0(Function2<? super Integer, ? super View, Unit> function2) {
        this.clickListener = function2;
    }

    public final void r0(Function2<? super Integer, ? super View, Unit> function2) {
        this.renderListener = function2;
    }

    private final void k0(a holder, boolean isSelected) {
        if (isSelected) {
            s0(holder);
        } else {
            t0(holder);
        }
    }

    public final void o0(int position) {
        if (position >= 0 && position < this.data.size()) {
            this.data.get(position).c(true);
            notifyItemChanged(position);
            int size = this.data.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (position != i3 && this.data.get(i3).getIsItemSelected()) {
                    this.data.get(i3).c(false);
                    notifyItemChanged(i3);
                    return;
                }
            }
            return;
        }
        QLog.e("IndicatorAdapter", 1, "onItemSelected: but param is invalid " + position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f332147d;

        c(AnimatorSet animatorSet) {
            this.f332147d = animatorSet;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f332147d.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter$d", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f332148d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f332149e;

        d(a aVar, AnimatorSet animatorSet) {
            this.f332148d = aVar;
            this.f332149e = animatorSet;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f332148d.getBgview().setVisibility(8);
            this.f332149e.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }
}
