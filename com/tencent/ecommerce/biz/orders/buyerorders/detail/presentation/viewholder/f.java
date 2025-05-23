package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/f;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "", "curPosition", "", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "u", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "ticketInfoTv", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "ticketInfoIcon", "Landroidx/viewpager2/widget/ViewPager2;", "G", "Landroidx/viewpager2/widget/ViewPager2;", "ticketListView", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/i;", "H", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/i;", "adapter", "", "I", "Z", "isDraggingPage", "Landroid/view/View;", "J", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "K", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "nativeListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;)V", "L", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.TicketInfoData> {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView ticketInfoTv;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView ticketInfoIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewPager2 ticketListView;

    /* renamed from: H, reason: from kotlin metadata */
    private final i adapter;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isDraggingPage;

    /* renamed from: J, reason: from kotlin metadata */
    public final View rootView;

    /* renamed from: K, reason: from kotlin metadata */
    private final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a nativeListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f.TicketInfoData f103365e;

        b(f.TicketInfoData ticketInfoData) {
            this.f103365e = ticketInfoData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f.this.nativeListener.o(this.f103365e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/f$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "o0", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        private final boolean o0(int position) {
            if (position >= 9) {
                return true;
            }
            return false;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            f.this.isDraggingPage = state == 1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            TicketDetail detail;
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            if (o0(position) && f.this.isDraggingPage && positionOffsetPixels == 0 && (detail = f.this.adapter.getDetail()) != null) {
                f.this.nativeListener.o(new f.TicketInfoData(f.this.adapter.getDataList(), detail));
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            f.p(f.this).setText(f.this.t(position));
        }
    }

    public f(View view, com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar) {
        super(view);
        this.rootView = view;
        this.nativeListener = aVar;
        this.adapter = new i();
    }

    public static final /* synthetic */ TextView p(f fVar) {
        TextView textView = fVar.ticketInfoTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ticketInfoTv");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t(int curPosition) {
        int size = this.adapter.getDataList().size();
        if (size > 1) {
            return '\u7b2c' + (curPosition + 1) + "\u5f20/\u5171" + size + '\u5f20';
        }
        return "";
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        View view = this.rootView;
        this.ticketInfoTv = (TextView) view.findViewById(R.id.oen);
        this.ticketInfoIcon = (ImageView) view.findViewById(R.id.f163052o20);
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.oc_);
        this.ticketListView = viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ticketListView");
        }
        viewPager2.setAdapter(this.adapter);
        ViewPager2 viewPager22 = this.ticketListView;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ticketListView");
        }
        viewPager22.setOffscreenPageLimit(1);
        ViewPager2 viewPager23 = this.ticketListView;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ticketListView");
        }
        View childAt = viewPager23.getChildAt(0);
        if (childAt != null) {
            RecyclerView recyclerView = (RecyclerView) childAt;
            recyclerView.setPadding(com.tencent.ecommerce.biz.util.e.c(32.0f), 0, com.tencent.ecommerce.biz.util.e.c(32.0f), 0);
            recyclerView.setClipToPadding(false);
            ViewPager2 viewPager24 = this.ticketListView;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ticketListView");
            }
            viewPager24.registerOnPageChangeCallback(new c());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void l(f.TicketInfoData data) {
        this.rootView.setOnClickListener(new b(data));
        this.adapter.l0(data.a(), data.detail);
        TextView textView = this.ticketInfoTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ticketInfoTv");
        }
        ViewPager2 viewPager2 = this.ticketListView;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ticketListView");
        }
        textView.setText(t(viewPager2.getCurrentItem()));
    }
}
