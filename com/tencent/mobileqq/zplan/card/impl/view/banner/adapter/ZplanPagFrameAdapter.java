package com.tencent.mobileqq.zplan.card.impl.view.banner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView;
import com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanBaseDownloadButtonItemView;
import com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanLinkedBannerPagItemView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import pv4.s;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bm\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020\u0006\u00126\u0010/\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t0'\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%RR\u0010/\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b\"\u0010,\"\u0004\b-\u0010.Ri\u00107\u001aI\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b2\u00106R?\u0010>\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b9\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanPagFrameAdapter;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "", com.tencent.luggage.wxa.c8.c.G, "view", "", "b", "a", "", "Lpv4/s;", "Ljava/util/List;", "getMData", "()Ljava/util/List;", "mData", "Loa4/a;", "Loa4/a;", "getMMapResViewModel", "()Loa4/a;", "mMapResViewModel", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSourceCurrent", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "e", "I", "getMaxItemCount", "()I", "maxItemCount", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "setButtonClickListener", "(Lkotlin/jvm/functions/Function2;)V", "buttonClickListener", "Lkotlin/Function3;", "data", "g", "Lkotlin/jvm/functions/Function3;", "getOnClickListener", "()Lkotlin/jvm/functions/Function3;", "(Lkotlin/jvm/functions/Function3;)V", "onClickListener", "Lkotlin/Function1;", h.F, "Lkotlin/jvm/functions/Function1;", "getPagDelayReadyListener", "()Lkotlin/jvm/functions/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "pagDelayReadyListener", "<init>", "(Ljava/util/List;Loa4/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ILkotlin/jvm/functions/Function2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanPagFrameAdapter extends ZplanPagFrameView.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<s> mData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mMapResViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int maxItemCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2<? super View, ? super Integer, Unit> buttonClickListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Function3<? super Integer, ? super s, ? super View, Unit> onClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Integer, Unit> pagDelayReadyListener;

    public ZplanPagFrameAdapter(List<s> mData, oa4.a mMapResViewModel, LifecycleOwner lifecycleOwner, ZootopiaSource sourceCurrent, int i3, Function2<? super View, ? super Integer, Unit> buttonClickListener) {
        Intrinsics.checkNotNullParameter(mData, "mData");
        Intrinsics.checkNotNullParameter(mMapResViewModel, "mMapResViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(buttonClickListener, "buttonClickListener");
        this.mData = mData;
        this.mMapResViewModel = mMapResViewModel;
        this.lifecycleOwner = lifecycleOwner;
        this.sourceCurrent = sourceCurrent;
        this.maxItemCount = i3;
        this.buttonClickListener = buttonClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZplanPagFrameAdapter this$0, int i3, s data, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Function3<? super Integer, ? super s, ? super View, Unit> function3 = this$0.onClickListener;
        if (function3 != null) {
            Integer valueOf = Integer.valueOf(i3);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function3.invoke(valueOf, data, it);
        }
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.d
    public int a() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mData.size(), this.maxItemCount);
        return coerceAtMost;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.d
    public View c(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ZplanLinkedBannerPagItemView(context, this.lifecycleOwner, this.mMapResViewModel);
    }

    public final Function2<View, Integer, Unit> e() {
        return this.buttonClickListener;
    }

    public final void g(Function3<? super Integer, ? super s, ? super View, Unit> function3) {
        this.onClickListener = function3;
    }

    public final void h(Function1<? super Integer, Unit> function1) {
        this.pagDelayReadyListener = function1;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.d
    public void b(final int pos, final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ZplanLinkedBannerPagItemView zplanLinkedBannerPagItemView = view instanceof ZplanLinkedBannerPagItemView ? (ZplanLinkedBannerPagItemView) view : null;
        if (zplanLinkedBannerPagItemView != null) {
            QLog.d("PagFrameAdapter", 1, "bind data " + pos + " " + zplanLinkedBannerPagItemView.getBindPos() + " " + zplanLinkedBannerPagItemView.r());
            if (pos == zplanLinkedBannerPagItemView.getBindPos() && zplanLinkedBannerPagItemView.r()) {
                return;
            }
            zplanLinkedBannerPagItemView.setBindPos(pos);
            final s sVar = this.mData.get(pos);
            ZplanBaseDownloadButtonItemView.f(zplanLinkedBannerPagItemView, sVar, this.sourceCurrent, this.lifecycleOwner, null, null, 0, false, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.ZplanPagFrameAdapter$onBinderView$1$1
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
                    ZplanPagFrameAdapter.this.e().invoke(view, Integer.valueOf(pos));
                }
            }, 248, null);
            zplanLinkedBannerPagItemView.t(sVar, this.pagDelayReadyListener);
            aa.e(zplanLinkedBannerPagItemView, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZplanPagFrameAdapter.f(ZplanPagFrameAdapter.this, pos, sVar, view2);
                }
            }, 1000L);
        }
    }
}
