package com.tencent.mobileqq.qwallet.pay.recommend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.ad.AdEvent;
import com.tencent.mobileqq.qwallet.ad.BaseGdtAdView;
import com.tencent.mobileqq.qwallet.pay.AdPositionEnum;
import com.tencent.mobileqq.qwallet.pay.recommend.b;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqwallet.Mall$CardInfo;
import tencent.im.qqwallet.PaySuccessAd$QpayAd;
import tencent.im.qqwallet.PaySuccessAd$RecommendAds;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B1\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/PaySuccessRecommendAdRecyclerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "Ltencent/im/qqwallet/PaySuccessAd$RecommendAds;", "recommendAds", "", "z0", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "rootRecyclerView", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "e", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "getAdEventCallback", "()Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "setAdEventCallback", "(Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;)V", "adEventCallback", "Lcom/tencent/mobileqq/qwallet/pay/recommend/PaySuccessRecommendAdRecyclerView$a;", "f", "Lcom/tencent/mobileqq/qwallet/pay/recommend/PaySuccessRecommendAdRecyclerView$a;", "adAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PaySuccessRecommendAdRecyclerView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView rootRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseGdtAdView.a adEventCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a adAdapter;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/PaySuccessRecommendAdRecyclerView$a;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "data", "", "dataList", "Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "i0", "", "layoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "j0", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "Ltencent/im/qqwallet/PaySuccessAd$RecommendAds;", "recommendAdPb", "", "k0", "position", "getItemViewType", "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "hostFragment", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends ListAdapter<b, RecyclerView.ViewHolder> {

        @NotNull
        private static final C8478a D = new C8478a();

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private QWalletBaseFragment hostFragment;

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/pay/recommend/PaySuccessRecommendAdRecyclerView$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b;", "oldItem", "newItem", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.pay.recommend.PaySuccessRecommendAdRecyclerView$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static final class C8478a extends DiffUtil.ItemCallback<b> {
            C8478a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull b oldItem, @NotNull b newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull b oldItem, @NotNull b newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if (oldItem == newItem) {
                    return true;
                }
                return false;
            }
        }

        public a() {
            super(D);
        }

        private final AdPositionEnum i0(Object data, List<? extends Object> dataList) {
            Object first;
            Object last;
            if (dataList.size() != 1) {
                first = CollectionsKt___CollectionsKt.first(dataList);
                if (!Intrinsics.areEqual(first, data)) {
                    last = CollectionsKt___CollectionsKt.last(dataList);
                    if (Intrinsics.areEqual(last, data)) {
                        return AdPositionEnum.Bottom;
                    }
                    return AdPositionEnum.Middle;
                }
                return AdPositionEnum.Top;
            }
            return AdPositionEnum.Single;
        }

        private final View j0(@LayoutRes int layoutId, ViewGroup parent) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026(layoutId, parent, false)");
            return inflate;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            b item = getItem(position);
            if ((item instanceof b.OpAd) || !(item instanceof b.Card)) {
                return 0;
            }
            return 1;
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public final void k0(@NotNull QWalletBaseFragment fragment, @NotNull PaySuccessAd$RecommendAds recommendAdPb) {
            String str;
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(recommendAdPb, "recommendAdPb");
            this.hostFragment = fragment;
            ArrayList arrayList = new ArrayList();
            List<PaySuccessAd$QpayAd> list = recommendAdPb.qpay_ads.get();
            Intrinsics.checkNotNullExpressionValue(list, "recommendAdPb.qpay_ads.get()");
            Iterator<T> it = list.iterator();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                String str2 = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                PaySuccessAd$QpayAd qpayAd = (PaySuccessAd$QpayAd) next;
                if (i16 == 0) {
                    str2 = recommendAdPb.title1.get();
                }
                Intrinsics.checkNotNullExpressionValue(qpayAd, "qpayAd");
                List<? extends Object> list2 = recommendAdPb.qpay_ads.get();
                Intrinsics.checkNotNullExpressionValue(list2, "recommendAdPb.qpay_ads.get()");
                arrayList.add(new b.OpAd(qpayAd, str2, i0(qpayAd, list2)));
                i16 = i17;
            }
            List<Mall$CardInfo> list3 = recommendAdPb.qcards.get();
            Intrinsics.checkNotNullExpressionValue(list3, "recommendAdPb.qcards.get()");
            for (Object obj : list3) {
                int i18 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Mall$CardInfo qcards = (Mall$CardInfo) obj;
                if (i3 == 0) {
                    str = recommendAdPb.title2.get();
                } else {
                    str = null;
                }
                Intrinsics.checkNotNullExpressionValue(qcards, "qcards");
                List<? extends Object> list4 = recommendAdPb.qcards.get();
                Intrinsics.checkNotNullExpressionValue(list4, "recommendAdPb.qcards.get()");
                arrayList.add(new b.Card(qcards, str, i0(qcards, list4)));
                i3 = i18;
            }
            QLog.i("PaySuccessRecommendAdAdapter", 1, "dataList=" + arrayList);
            submitList(arrayList);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            b item = getItem(position);
            if ((holder instanceof g) && (item instanceof b.OpAd)) {
                ((g) holder).J(this.hostFragment, (b.OpAd) item);
            } else if ((holder instanceof e) && (item instanceof b.Card)) {
                ((e) holder).H(this.hostFragment, (b.Card) item);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (viewType != 0) {
                if (viewType != 1) {
                    return new g(j0(R.layout.hjv, parent));
                }
                return new e(j0(R.layout.hjv, parent));
            }
            return new g(j0(R.layout.hjv, parent));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessRecommendAdRecyclerView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setAdEventCallback(@Nullable BaseGdtAdView.a aVar) {
        this.adEventCallback = aVar;
    }

    public final boolean z0(@NotNull QWalletBaseFragment fragment, @Nullable PaySuccessAd$RecommendAds recommendAds) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (recommendAds != null) {
            this.adAdapter.k0(fragment, recommendAds);
        }
        BaseGdtAdView.a aVar = this.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.RENDERED);
            return true;
        }
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessRecommendAdRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessRecommendAdRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PaySuccessRecommendAdRecyclerView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessRecommendAdRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a();
        this.adAdapter = aVar;
        View.inflate(context, R.layout.hjw, this);
        View findViewById = findViewById(R.id.f228804x);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(aVar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<RecyclerVie\u2026ter = adAdapter\n        }");
        this.rootRecyclerView = recyclerView;
    }
}
