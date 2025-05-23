package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardGroupData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 V2\u00020\u0001:\u0002WXB/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010\u001d\u001a\u00020\f\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010!\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0014\u0010#\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010%\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\u0014\u0010'\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001aR$\u0010.\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00102\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010B\u001a\b\u0018\u00010;R\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010O\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bL\u0010\u001c\"\u0004\bM\u0010N\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "", "H", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/LifecycleOwner;", UserInfo.SEX_FEMALE, "()Landroidx/lifecycle/LifecycleOwner;", "owner", ExifInterface.LATITUDE_SOUTH, "I", "getItemViewType", "()I", "itemViewType", "T", "normalBannerLeftMargin", "U", "normalBannerRightPadding", "V", "normalBannerItemMargin", "W", "indicatorHeight", "a0", "indicatorMarginTop", "b0", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "c0", "getIndicatorView", "setIndicatorView", "indicatorView", "Landroidx/viewpager2/widget/ViewPager2;", "d0", "Landroidx/viewpager2/widget/ViewPager2;", "G", "()Landroidx/viewpager2/widget/ViewPager2;", "setViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "viewPager", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard$b;", "e0", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard$b;", "getBannerAdapter", "()Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard$b;", "setBannerAdapter", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard$b;)V", "bannerAdapter", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "f0", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "E", "()Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "setIndicator", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;)V", "indicator", "g0", "D", "setCardPos", "(I)V", "cardPos", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "h0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaNormalBannerCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: S, reason: from kotlin metadata */
    private final int itemViewType;

    /* renamed from: T, reason: from kotlin metadata */
    private final int normalBannerLeftMargin;

    /* renamed from: U, reason: from kotlin metadata */
    private final int normalBannerRightPadding;

    /* renamed from: V, reason: from kotlin metadata */
    private final int normalBannerItemMargin;

    /* renamed from: W, reason: from kotlin metadata */
    private final int indicatorHeight;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int indicatorMarginTop;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View indicatorView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private b bannerAdapter;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int cardPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/data/c;", "getDataInfo", "()Lcom/tencent/sqshow/zootopia/data/c;", "setDataInfo", "(Lcom/tencent/sqshow/zootopia/data/c;)V", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private ZootopiaCardData dataInfo;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard$b$a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a extends RecyclerView.ViewHolder {
            a(View view) {
                super(view);
            }
        }

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            List<s> c16;
            ZootopiaCardData zootopiaCardData = this.dataInfo;
            if (zootopiaCardData == null || (c16 = zootopiaCardData.c()) == null) {
                return 0;
            }
            return c16.size();
        }

        public final void i0(ZootopiaCardData dataInfo) {
            Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
            this.dataInfo = dataInfo;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            KeyEvent.Callback callback = holder.itemView;
            com.tencent.mobileqq.zplan.card.impl.view.banner.b bVar = callback instanceof com.tencent.mobileqq.zplan.card.impl.view.banner.b ? (com.tencent.mobileqq.zplan.card.impl.view.banner.b) callback : null;
            if (bVar != null) {
                bVar.a(ZootopiaNormalBannerCard.this.getOwner(), ZootopiaNormalBannerCard.this.p(), ZootopiaNormalBannerCard.this.r(), this.dataInfo, holder.getAdapterPosition(), ZootopiaNormalBannerCard.this.getCardPos());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ZootopiaCardGroupData groupData;
            ZootopiaCardGroupData groupData2;
            ZootopiaCardGroupData groupData3;
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = ZootopiaNormalBannerCard.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Integer num = 0;
            num = 0;
            LeftBannerPageItemView leftBannerPageItemView = new LeftBannerPageItemView(context, num, 2, num);
            ZootopiaCardData zootopiaCardData = this.dataInfo;
            if (!TextUtils.isEmpty((zootopiaCardData == null || (groupData3 = zootopiaCardData.getGroupData()) == null) ? null : groupData3.getBgColor())) {
                try {
                    ZootopiaCardData zootopiaCardData2 = this.dataInfo;
                    num = Integer.valueOf(Color.parseColor((zootopiaCardData2 == null || (groupData2 = zootopiaCardData2.getGroupData()) == null) ? null : groupData2.getBgColor()));
                } catch (Exception unused) {
                    ZootopiaNormalBannerCard zootopiaNormalBannerCard = ZootopiaNormalBannerCard.this;
                    ZootopiaCardData zootopiaCardData3 = this.dataInfo;
                    zootopiaNormalBannerCard.x("parseColor error - " + ((zootopiaCardData3 == null || (groupData = zootopiaCardData3.getGroupData()) == null) ? null : groupData.getBgColor()), false);
                }
            }
            leftBannerPageItemView.b(ZootopiaNormalBannerCard.this.getViewPager(), num);
            return new a(leftBannerPageItemView.getView());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaNormalBannerCard$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator = ZootopiaNormalBannerCard.this.getIndicator();
            if (indicator != null) {
                indicator.onPageScrollStateChanged(state);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator = ZootopiaNormalBannerCard.this.getIndicator();
            if (indicator != null) {
                indicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator = ZootopiaNormalBannerCard.this.getIndicator();
            if (indicator != null) {
                indicator.c(position, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaNormalBannerCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.owner = owner;
        this.itemViewType = i3;
        int b16 = com.tencent.sqshow.zootopia.utils.i.b(15);
        this.normalBannerLeftMargin = b16;
        this.normalBannerRightPadding = b16 + com.tencent.sqshow.zootopia.utils.i.b(5);
        this.normalBannerItemMargin = com.tencent.sqshow.zootopia.utils.i.b(5);
        this.indicatorHeight = com.tencent.sqshow.zootopia.utils.i.b(7);
        this.indicatorMarginTop = com.tencent.sqshow.zootopia.utils.i.b(8);
    }

    private final void H() {
        int c16 = (int) ((((u.INSTANCE.c(getContext()) - this.normalBannerLeftMargin) - this.normalBannerRightPadding) / 400.0f) * 98.0f);
        int i3 = this.indicatorHeight + c16 + this.indicatorMarginTop;
        View view = this.contentView;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = i3;
        }
        ViewPager2 viewPager2 = this.viewPager;
        ViewGroup.LayoutParams layoutParams2 = viewPager2 != null ? viewPager2.getLayoutParams() : null;
        if (layoutParams2 != null) {
            layoutParams2.height = c16;
        }
        View view2 = this.indicatorView;
        Object layoutParams3 = view2 != null ? view2.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 == null) {
            return;
        }
        layoutParams4.topMargin = c16 + this.indicatorMarginTop;
    }

    /* renamed from: D, reason: from getter */
    public final int getCardPos() {
        return this.cardPos;
    }

    /* renamed from: E, reason: from getter */
    public final com.tencent.sqshow.zootopia.portal.home.banner.indicator.a getIndicator() {
        return this.indicator;
    }

    /* renamed from: F, reason: from getter */
    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    /* renamed from: G, reason: from getter */
    public final ViewPager2 getViewPager() {
        return this.viewPager;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard, l84.a
    public void c() {
        y("startPlayWhenHighlight, selfPos = " + getSelfPos(), true);
    }

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        y(getSelfItemType() + " - bindItemInfo, position=" + position + ", totalCount=" + totalCount, true);
        this.cardPos = position;
        H();
        b bVar = this.bannerAdapter;
        if (bVar != null) {
            bVar.i0(dataInfo);
        }
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = this.indicator;
        if (aVar != null) {
            List<s> c16 = dataInfo.c();
            aVar.a(c16 != null ? c16.size() : 0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.b helper;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        View view = LayoutInflater.from(context).inflate(R.layout.d8g, viewParent, true);
        this.contentView = view;
        this.viewPager = (ViewPager2) view.findViewById(R.id.qye);
        View findViewById = view.findViewById(R.id.q1u);
        this.indicatorView = findViewById;
        this.indicator = findViewById instanceof com.tencent.sqshow.zootopia.portal.home.banner.indicator.a ? (com.tencent.sqshow.zootopia.portal.home.banner.indicator.a) findViewById : null;
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.setPageTransformer(new MarginPageTransformer(this.normalBannerItemMargin));
            viewPager2.setOffscreenPageLimit(2);
            viewPager2.setClipToPadding(false);
            viewPager2.registerOnPageChangeCallback(new c());
        }
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = this.indicator;
        if (aVar != null && (helper = aVar.getHelper()) != null) {
            helper.y(Color.parseColor("#ff5e5e5e"));
            helper.w(Color.parseColor("#555e5e5e"));
            helper.x(com.tencent.sqshow.zootopia.utils.i.b(4));
            helper.A(com.tencent.sqshow.zootopia.utils.i.b(6));
        }
        ViewPager2 viewPager22 = this.viewPager;
        View childAt = viewPager22 != null ? viewPager22.getChildAt(0) : null;
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.setClipToPadding(false);
            ViewPager2 viewPager23 = this.viewPager;
            ViewGroup.LayoutParams layoutParams = viewPager23 != null ? viewPager23.getLayoutParams() : null;
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = this.normalBannerLeftMargin;
            }
            recyclerView.setPadding(0, 0, this.normalBannerRightPadding, 0);
            ViewPager2 viewPager24 = this.viewPager;
            if (viewPager24 != null) {
                viewPager24.setLayoutParams(viewPager24 != null ? viewPager24.getLayoutParams() : null);
            }
        }
        b bVar = new b();
        this.bannerAdapter = bVar;
        ViewPager2 viewPager25 = this.viewPager;
        if (viewPager25 != null) {
            viewPager25.setAdapter(bVar);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    public final void setBannerAdapter(b bVar) {
        this.bannerAdapter = bVar;
    }

    public final void setCardPos(int i3) {
        this.cardPos = i3;
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    public final void setIndicator(com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar) {
        this.indicator = aVar;
    }

    public final void setIndicatorView(View view) {
        this.indicatorView = view;
    }

    public final void setViewPager(ViewPager2 viewPager2) {
        this.viewPager = viewPager2;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZootopiaNormalBannerCard_";
    }
}
