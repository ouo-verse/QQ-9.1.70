package com.tencent.mobileqq.zplan.card.impl.view.banner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanBaseDownloadButtonItemView;
import com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanLinkedBannerNativeItemView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 ?2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002@ABu\u0012\u0006\u0010:\u001a\u000209\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020;\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020\u0006\u00126\u00100\u001a2\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\r0&\u00a2\u0006\u0004\b=\u0010>J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u000e\u001a\u00020\r2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010$RG\u00100\u001a2\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\r0&8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/Ri\u00108\u001aI\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\r\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanLinkedBannerAdapter;", "Lqa4/b;", "Lpv4/s;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanLinkedBannerAdapter$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "t0", "holder", "data", "position", "size", "", "r0", "l0", "Loa4/a;", "H", "Loa4/a;", "getMMapResViewModel", "()Loa4/a;", "mMapResViewModel", "Landroidx/lifecycle/LifecycleOwner;", "I", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "J", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSourceCurrent", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "K", "getMaxItemCount", "()I", "maxItemCount", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", com.tencent.luggage.wxa.c8.c.G, "L", "Lkotlin/jvm/functions/Function2;", "q0", "()Lkotlin/jvm/functions/Function2;", "buttonClickListener", "Lkotlin/Function3;", "M", "Lkotlin/jvm/functions/Function3;", "getOnClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnClickListener", "(Lkotlin/jvm/functions/Function3;)V", "onClickListener", "Landroid/content/Context;", "context", "", "mData", "<init>", "(Landroid/content/Context;Ljava/util/List;Loa4/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ILkotlin/jvm/functions/Function2;)V", "N", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanLinkedBannerAdapter extends qa4.b<s, a> {

    /* renamed from: H, reason: from kotlin metadata */
    private final oa4.a mMapResViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: J, reason: from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: K, reason: from kotlin metadata */
    private final int maxItemCount;

    /* renamed from: L, reason: from kotlin metadata */
    private final Function2<View, Integer, Unit> buttonClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    private Function3<? super Integer, ? super s, ? super View, Unit> onClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanLinkedBannerAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanLinkedBannerAdapter;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class a extends RecyclerView.ViewHolder {
        final /* synthetic */ ZplanLinkedBannerAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ZplanLinkedBannerAdapter zplanLinkedBannerAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = zplanLinkedBannerAdapter;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZplanLinkedBannerAdapter(Context context, List<s> mData, oa4.a mMapResViewModel, LifecycleOwner lifecycleOwner, ZootopiaSource sourceCurrent, int i3, Function2<? super View, ? super Integer, Unit> buttonClickListener) {
        super(context, mData);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mData, "mData");
        Intrinsics.checkNotNullParameter(mMapResViewModel, "mMapResViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(buttonClickListener, "buttonClickListener");
        this.mMapResViewModel = mMapResViewModel;
        this.lifecycleOwner = lifecycleOwner;
        this.sourceCurrent = sourceCurrent;
        this.maxItemCount = i3;
        this.buttonClickListener = buttonClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ZplanLinkedBannerAdapter this$0, int i3, s data, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Function3<? super Integer, ? super s, ? super View, Unit> function3 = this$0.onClickListener;
        if (function3 != null) {
            Integer valueOf = Integer.valueOf(i3);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function3.invoke(valueOf, data, it);
        }
    }

    @Override // qa4.b
    public int l0() {
        return Math.min(this.maxItemCount, k0().size());
    }

    public final Function2<View, Integer, Unit> q0() {
        return this.buttonClickListener;
    }

    @Override // qa4.c
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public a u(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        ZplanLinkedBannerNativeItemView zplanLinkedBannerNativeItemView = new ZplanLinkedBannerNativeItemView(context, this.lifecycleOwner, this.mMapResViewModel);
        zplanLinkedBannerNativeItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new a(this, zplanLinkedBannerNativeItemView);
    }

    @Override // qa4.c
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void d0(final a holder, final s data, final int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        View view = holder.itemView;
        ZplanLinkedBannerNativeItemView zplanLinkedBannerNativeItemView = view instanceof ZplanLinkedBannerNativeItemView ? (ZplanLinkedBannerNativeItemView) view : null;
        if (zplanLinkedBannerNativeItemView != null) {
            ZplanBaseDownloadButtonItemView.f(zplanLinkedBannerNativeItemView, data, this.sourceCurrent, this.lifecycleOwner, null, null, 0, false, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.ZplanLinkedBannerAdapter$onBindView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function2<View, Integer, Unit> q06 = ZplanLinkedBannerAdapter.this.q0();
                    View view2 = holder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
                    q06.invoke(view2, Integer.valueOf(position));
                }
            }, 248, null);
            zplanLinkedBannerNativeItemView.t(data);
            zplanLinkedBannerNativeItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZplanLinkedBannerAdapter.s0(ZplanLinkedBannerAdapter.this, position, data, view2);
                }
            });
            zplanLinkedBannerNativeItemView.setTag(Integer.valueOf(position));
        }
    }
}
