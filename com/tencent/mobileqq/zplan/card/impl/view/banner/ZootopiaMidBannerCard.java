package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import cooperation.qzone.QZoneTopGestureLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\u00020\u0001:\u0002XYB/\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010+\u001a\u00020\u0015\u00a2\u0006\u0004\bU\u0010VJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u0004\u0018\u00010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u0010;\u001a\b\u0018\u000104R\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010B\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b(\u0010?\"\u0004\b@\u0010AR\"\u0010G\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010(\u001a\u0004\bD\u0010*\"\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bH\u0010(R\u0018\u0010L\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010(R\u0016\u0010P\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010(\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "", "dx", "dy", "", "N", "Landroid/view/MotionEvent;", "event", "", "L", "isIntercept", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "G", "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/LifecycleOwner;", "J", "()Landroidx/lifecycle/LifecycleOwner;", "owner", ExifInterface.LATITUDE_SOUTH, "I", "getItemViewType", "()I", "itemViewType", "Landroidx/viewpager2/widget/ViewPager2;", "T", "Landroidx/viewpager2/widget/ViewPager2;", "K", "()Landroidx/viewpager2/widget/ViewPager2;", "setViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "viewPager", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard$b;", "U", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard$b;", "getBannerAdapter", "()Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard$b;", "setBannerAdapter", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard$b;)V", "bannerAdapter", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "V", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "()Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "setIndicator", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;)V", "indicator", "W", "H", "setCardPos", "(I)V", "cardPos", "a0", "scaledTouchSlop", "b0", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "c0", "downX", "d0", "downY", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "e0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaMidBannerCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: S, reason: from kotlin metadata */
    private final int itemViewType;

    /* renamed from: T, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: U, reason: from kotlin metadata */
    private b bannerAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator;

    /* renamed from: W, reason: from kotlin metadata */
    private int cardPos;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int scaledTouchSlop;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int downX;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int downY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/data/c;", "getDataInfo", "()Lcom/tencent/sqshow/zootopia/data/c;", "setDataInfo", "(Lcom/tencent/sqshow/zootopia/data/c;)V", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private ZootopiaCardData dataInfo;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard$b$a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
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
                bVar.a(ZootopiaMidBannerCard.this.getOwner(), ZootopiaMidBannerCard.this.p(), ZootopiaMidBannerCard.this.r(), this.dataInfo, holder.getAdapterPosition(), ZootopiaMidBannerCard.this.getCardPos());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = ZootopiaMidBannerCard.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            MidBannerPageItemView midBannerPageItemView = new MidBannerPageItemView(context, null, 2, null);
            midBannerPageItemView.b(ZootopiaMidBannerCard.this.getViewPager(), null);
            return new a(midBannerPageItemView.getView());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/ZootopiaMidBannerCard$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator = ZootopiaMidBannerCard.this.getIndicator();
            if (indicator != null) {
                indicator.onPageScrollStateChanged(state);
            }
            if (state == 0) {
                ZootopiaMidBannerCard.this.F(false);
                TopGestureLayout G = ZootopiaMidBannerCard.this.G();
                if (G != null) {
                    G.setIsInterceptChildEventWhenScroll(true);
                }
                QZoneTopGestureLayout.shouldInterceptEvent(true);
                TopGestureLayout G2 = ZootopiaMidBannerCard.this.G();
                if (G2 != null) {
                    G2.setInterceptScrollLRFlag(true);
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator = ZootopiaMidBannerCard.this.getIndicator();
            if (indicator != null) {
                indicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator = ZootopiaMidBannerCard.this.getIndicator();
            if (indicator != null) {
                indicator.c(position, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaMidBannerCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.owner = owner;
        this.itemViewType = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(boolean isIntercept) {
        TopGestureLayout G = G();
        if (G != null) {
            G.requestDisallowInterceptTouchEvent(isIntercept);
        }
    }

    private final void L(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        int action = event.getAction();
        if (action != 0) {
            if (action == 2 && N(Math.abs(rawX - this.downX), Math.abs(rawY - this.downY))) {
                F(true);
                return;
            }
            return;
        }
        this.downX = rawX;
        this.downY = rawY;
        TopGestureLayout G = G();
        if (G != null) {
            G.setIsInterceptChildEventWhenScroll(false);
        }
        TopGestureLayout G2 = G();
        if (G2 != null) {
            G2.setInterceptScrollLRFlag(false);
        }
        QZoneTopGestureLayout.shouldInterceptEvent(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(View page, float f16) {
        Intrinsics.checkNotNullParameter(page, "page");
        page.setTranslationX(com.tencent.sqshow.zootopia.utils.i.b(-18) * f16);
    }

    private final boolean N(float dx5, float dy5) {
        int i3 = this.scaledTouchSlop;
        return (dx5 > ((float) i3) || dy5 > ((float) i3)) && dx5 > ((float) i3) && dy5 / dx5 < 0.6f;
    }

    public final TopGestureLayout G() {
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        KeyEvent.Callback callback = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            callback = viewGroup.getChildAt(i3);
            boolean z16 = callback instanceof DragFrameLayout;
            if (z16) {
                DragFrameLayout dragFrameLayout = z16 ? (DragFrameLayout) callback : null;
                callback = dragFrameLayout != null ? dragFrameLayout.getChildAt(0) : null;
            }
            if (callback instanceof TopGestureLayout) {
                break;
            }
        }
        TopGestureLayout topGestureLayout2 = callback instanceof TopGestureLayout ? (TopGestureLayout) callback : null;
        this.topGestureLayout = topGestureLayout2;
        return topGestureLayout2;
    }

    /* renamed from: H, reason: from getter */
    public final int getCardPos() {
        return this.cardPos;
    }

    /* renamed from: I, reason: from getter */
    public final com.tencent.sqshow.zootopia.portal.home.banner.indicator.a getIndicator() {
        return this.indicator;
    }

    /* renamed from: J, reason: from getter */
    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    /* renamed from: K, reason: from getter */
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        L(ev5);
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        L(ev5);
        return super.onTouchEvent(ev5);
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        View view = LayoutInflater.from(context).inflate(R.layout.d8j, viewParent, true);
        this.viewPager = (ViewPager2) view.findViewById(R.id.qye);
        KeyEvent.Callback findViewById = view.findViewById(R.id.q1u);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.indicateView)");
        this.indicator = findViewById instanceof com.tencent.sqshow.zootopia.portal.home.banner.indicator.a ? (com.tencent.sqshow.zootopia.portal.home.banner.indicator.a) findViewById : null;
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(2);
            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.c
                @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
                public final void transformPage(View view2, float f16) {
                    ZootopiaMidBannerCard.M(view2, f16);
                }
            });
            viewPager2.registerOnPageChangeCallback(new c());
        }
        ViewPager2 viewPager22 = this.viewPager;
        KeyEvent.Callback childAt = viewPager22 != null ? viewPager22.getChildAt(0) : null;
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.setClipToPadding(false);
            recyclerView.setClipChildren(false);
            recyclerView.setPadding(com.tencent.sqshow.zootopia.utils.i.b(30), 0, com.tencent.sqshow.zootopia.utils.i.b(30), 0);
        }
        b bVar = new b();
        this.bannerAdapter = bVar;
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 != null) {
            viewPager23.setAdapter(bVar);
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

    public final void setIndicator(com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar) {
        this.indicator = aVar;
    }

    public final void setViewPager(ViewPager2 viewPager2) {
        this.viewPager = viewPager2;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZootopiaMidBannerCard";
    }
}
