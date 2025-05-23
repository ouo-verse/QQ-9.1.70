package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.ZplanBottomIndicatorViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import pv4.q;
import pv4.s;
import sf3.ZplanBannerIndicatorBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$B\u001b\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b#\u0010'B#\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010(\u001a\u00020\u0005\u00a2\u0006\u0004\b#\u0010)J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J>\u0010\u0012\u001a\u00020\t26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\u000bJ>\u0010\u0014\u001a\u00020\t26\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\u000bJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerBottomIndicatorView;", "Landroid/widget/FrameLayout;", "", "Lpv4/s;", "list", "", "maxItemCount", "Lsf3/a;", "b", "", "setData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "onItemClick", "setOnClickListener", "renderListener", "setOnRenderListener", "position", "c", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Lkotlin/Lazy;", "a", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter;", "e", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanBottomIndicatorViewAdapter;", "indicatorViewAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanBannerBottomIndicatorView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZplanBottomIndicatorViewAdapter indicatorViewAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBannerBottomIndicatorView(Context context) {
        super(context, null, 0);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanBannerBottomIndicatorView$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return new RecyclerView(ZplanBannerBottomIndicatorView.this.getContext());
            }
        });
        this.recyclerView = lazy;
    }

    private final RecyclerView a() {
        return (RecyclerView) this.recyclerView.getValue();
    }

    private final List<ZplanBannerIndicatorBean> b(List<s> list, int maxItemCount) {
        IntRange indices;
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        indices = CollectionsKt__CollectionsKt.getIndices(list);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            q littleMod = list.get(nextInt).f427686g;
            if (littleMod != null) {
                Intrinsics.checkNotNullExpressionValue(littleMod, "littleMod");
                arrayList.add(new ZplanBannerIndicatorBean(littleMod, nextInt == 0));
                if (arrayList.size() >= maxItemCount) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public final void c(int position) {
        ZplanBottomIndicatorViewAdapter zplanBottomIndicatorViewAdapter = this.indicatorViewAdapter;
        if (zplanBottomIndicatorViewAdapter != null) {
            zplanBottomIndicatorViewAdapter.o0(position);
        }
        a().smoothScrollToPosition(position);
    }

    public final void setData(List<s> list, int maxItemCount) {
        List<ZplanBannerIndicatorBean> b16 = b(list, maxItemCount);
        this.indicatorViewAdapter = new ZplanBottomIndicatorViewAdapter(b16);
        QLog.i("IndicatorView", 4, "set data :" + b16.size());
        RecyclerView a16 = a();
        a16.setLayoutManager(new LinearLayoutManager(a16.getContext(), 0, false));
        a16.setAdapter(this.indicatorViewAdapter);
        a16.setLayoutAnimation(null);
        removeAllViews();
        addView(a());
    }

    public final void setOnClickListener(Function2<? super Integer, ? super View, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        ZplanBottomIndicatorViewAdapter zplanBottomIndicatorViewAdapter = this.indicatorViewAdapter;
        if (zplanBottomIndicatorViewAdapter == null) {
            return;
        }
        zplanBottomIndicatorViewAdapter.q0(onItemClick);
    }

    public final void setOnRenderListener(Function2<? super Integer, ? super View, Unit> renderListener) {
        Intrinsics.checkNotNullParameter(renderListener, "renderListener");
        ZplanBottomIndicatorViewAdapter zplanBottomIndicatorViewAdapter = this.indicatorViewAdapter;
        if (zplanBottomIndicatorViewAdapter == null) {
            return;
        }
        zplanBottomIndicatorViewAdapter.r0(renderListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBannerBottomIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanBannerBottomIndicatorView$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return new RecyclerView(ZplanBannerBottomIndicatorView.this.getContext());
            }
        });
        this.recyclerView = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBannerBottomIndicatorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanBannerBottomIndicatorView$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return new RecyclerView(ZplanBannerBottomIndicatorView.this.getContext());
            }
        });
        this.recyclerView = lazy;
    }
}
