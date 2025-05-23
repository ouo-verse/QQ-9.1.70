package com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard;
import com.tencent.mobileqq.zplan.widget.impl.reddot.ZPlanBubbleRedDotView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.taskcenter.bubble.ZPlanBubbleRedDotController;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import pu4.g;
import pv4.s;
import pv4.u;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00013B/\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00100\u001a\u00020\u000b\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZplanHorizontalScrollSmallIconCard;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard;", "", "N", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "J", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", "L", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "I", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "W", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "a0", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "itemDecoration", "Landroid/graphics/drawable/Drawable;", "b0", "Landroid/graphics/drawable/Drawable;", "iconDefaultDrawable", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanHorizontalScrollSmallIconCard extends ZPlanBaseHorizontalScrollCard {

    /* renamed from: W, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.ItemDecoration itemDecoration;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private Drawable iconDefaultDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010B\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010A\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0018\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001c\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZplanHorizontalScrollSmallIconCard$a;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "Landroid/view/View;", "itemRootView", "", "p", "", "itemPos", "Lpv4/s;", "itemData", "Lcom/tencent/sqshow/zootopia/data/c;", "parentCardData", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "position", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "getMContainerRv", "()Landroid/widget/RelativeLayout;", "setMContainerRv", "(Landroid/widget/RelativeLayout;)V", "mContainerRv", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "getMIcon", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setMIcon", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "mIcon", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "G", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "getMRedDot", "()Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "setMRedDot", "(Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;)V", "mRedDot", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "getMText", "()Landroid/widget/TextView;", "setMText", "(Landroid/widget/TextView;)V", "mText", "Lcom/tencent/mobileqq/zplan/widget/impl/reddot/ZPlanBubbleRedDotView;", "I", "Lcom/tencent/mobileqq/zplan/widget/impl/reddot/ZPlanBubbleRedDotView;", "getMIconDot", "()Lcom/tencent/mobileqq/zplan/widget/impl/reddot/ZPlanBubbleRedDotView;", "setMIconDot", "(Lcom/tencent/mobileqq/zplan/widget/impl/reddot/ZPlanBubbleRedDotView;)V", "mIconDot", "J", "getMClickRv", "setMClickRv", "mClickRv", "itemView", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZplanHorizontalScrollSmallIconCard;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class a extends ZPlanBaseHorizontalScrollCard.a {

        /* renamed from: E, reason: from kotlin metadata */
        private RelativeLayout mContainerRv;

        /* renamed from: F, reason: from kotlin metadata */
        private ZPlanMediaView mIcon;

        /* renamed from: G, reason: from kotlin metadata */
        private ZPlanRedDotView mRedDot;

        /* renamed from: H, reason: from kotlin metadata */
        private TextView mText;

        /* renamed from: I, reason: from kotlin metadata */
        private ZPlanBubbleRedDotView mIconDot;

        /* renamed from: J, reason: from kotlin metadata */
        private RelativeLayout mClickRv;
        final /* synthetic */ ZplanHorizontalScrollSmallIconCard K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ZplanHorizontalScrollSmallIconCard zplanHorizontalScrollSmallIconCard, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.K = zplanHorizontalScrollSmallIconCard;
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void l(int itemPos, s itemData, ZootopiaCardData parentCardData) {
            g gVar;
            String str;
            u uVar;
            ZPlanRedDotView zPlanRedDotView = this.mRedDot;
            if (zPlanRedDotView != null) {
                zPlanRedDotView.j();
            }
            ZPlanBubbleRedDotView zPlanBubbleRedDotView = this.mIconDot;
            if (zPlanBubbleRedDotView != null) {
                zPlanBubbleRedDotView.j();
            }
            TextView textView = this.mText;
            if (textView != null) {
                if (itemData == null || (uVar = itemData.f427683d) == null || (str = uVar.f427702a) == null) {
                    str = "";
                }
                textView.setText(str);
            }
            if (itemData != null && (gVar = itemData.f427681b) != null) {
                ZplanHorizontalScrollSmallIconCard zplanHorizontalScrollSmallIconCard = this.K;
                ZPlanMediaView zPlanMediaView = this.mIcon;
                if (zPlanMediaView != null) {
                    zPlanMediaView.setDefaultDrawable(zplanHorizontalScrollSmallIconCard.iconDefaultDrawable);
                }
                ZPlanMediaView zPlanMediaView2 = this.mIcon;
                if (zPlanMediaView2 != null) {
                    zPlanMediaView2.e(gVar);
                }
            }
            if (itemData != null) {
                int i3 = itemData.f427688i;
                QLog.d(this.K.z(), 1, "refreshWithSceneIndex, redPointIndex:" + i3 + ", itemPos:" + itemPos);
                ZPlanRedDotView zPlanRedDotView2 = this.mRedDot;
                if (zPlanRedDotView2 != null) {
                    zPlanRedDotView2.h(i3);
                }
                ZPlanBubbleRedDotView zPlanBubbleRedDotView2 = this.mIconDot;
                if (zPlanBubbleRedDotView2 != null) {
                    zPlanBubbleRedDotView2.h(i3);
                }
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public HashMap<String, Object> m() {
            HashMap<String, Object> hashMap = new HashMap<>();
            ZPlanRedDotView zPlanRedDotView = this.mRedDot;
            hashMap.put("zplan_redpoint_type", Integer.valueOf(zPlanRedDotView != null ? zPlanRedDotView.getReddotStatus() : 0));
            ZPlanBubbleRedDotView zPlanBubbleRedDotView = this.mIconDot;
            if (zPlanBubbleRedDotView != null) {
                if (!(zPlanBubbleRedDotView.getVisibility() == 0)) {
                    zPlanBubbleRedDotView = null;
                }
                if (zPlanBubbleRedDotView != null) {
                    hashMap.put("zplan_redpoint_type", Integer.valueOf(zPlanBubbleRedDotView.getReddotStatus()));
                    hashMap.put("zplan_redpoint_id", Integer.valueOf(zPlanBubbleRedDotView.getRewardType()));
                }
            }
            return hashMap;
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public String o() {
            return "2";
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void p(View itemRootView) {
            Intrinsics.checkNotNullParameter(itemRootView, "itemRootView");
            this.mContainerRv = (RelativeLayout) itemRootView.findViewById(R.id.f163342pm1);
            this.mClickRv = (RelativeLayout) itemRootView.findViewById(R.id.f163334pk3);
            this.mIcon = (ZPlanMediaView) itemRootView.findViewById(R.id.q0b);
            this.mRedDot = (ZPlanRedDotView) itemRootView.findViewById(R.id.qgv);
            this.mText = (TextView) itemRootView.findViewById(R.id.qqa);
            this.mIconDot = (ZPlanBubbleRedDotView) this.itemView.findViewById(R.id.q0n);
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void r(int position) {
            ZPlanBubbleRedDotView zPlanBubbleRedDotView = this.mIconDot;
            if (zPlanBubbleRedDotView != null && zPlanBubbleRedDotView.getVisibility() == 0 && zPlanBubbleRedDotView.r()) {
                ZPlanRedDotManager.f373437a.s(zPlanBubbleRedDotView.getRewardType());
                ZPlanBubbleRedDotController.INSTANCE.g(1);
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public View s() {
            return this.mClickRv;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZplanHorizontalScrollSmallIconCard$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f332295d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.FloatRef f332296e;

        b(int i3, Ref.FloatRef floatRef) {
            this.f332295d = i3;
            this.f332296e = floatRef;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) < this.f332295d - 1) {
                outRect.right = (int) this.f332296e.element;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanHorizontalScrollSmallIconCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.iconDefaultDrawable = q.b(R.drawable.h_m);
    }

    private final void N() {
        float dimension;
        List<s> c16;
        u.Companion companion = t74.u.INSTANCE;
        int c17 = companion.c(getContext());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i3 = 0;
        boolean e16 = u.Companion.e(companion, context, false, 2, null);
        float dimension2 = getResources().getDimension(R.dimen.f123276);
        float dimension3 = getResources().getDimension(R.dimen.f123074);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        if (e16) {
            dimension = getResources().getDimension(R.dimen.f122872);
        } else {
            dimension = getResources().getDimension(R.dimen.f122973);
        }
        floatRef.element = dimension;
        ZootopiaCardData cardData = getCardData();
        if (cardData != null && (c16 = cardData.c()) != null) {
            i3 = c16.size();
        }
        int i16 = e16 ? 7 : 5;
        if (i3 > i16) {
            float f16 = i16;
            floatRef.element = ((c17 - ((0.5f + f16) * dimension2)) - dimension3) / f16;
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            RecyclerView.ItemDecoration itemDecoration = this.itemDecoration;
            if (itemDecoration != null) {
                recyclerView.removeItemDecoration(itemDecoration);
            }
            b bVar = new b(i3, floatRef);
            this.itemDecoration = bVar;
            recyclerView.addItemDecoration(bVar);
            if (i3 > 0) {
                float f17 = (dimension2 * i3) + (floatRef.element * (i3 - 1));
                float f18 = c17;
                float f19 = 2;
                if (f17 < f18 - (dimension3 * f19)) {
                    dimension3 = (f18 - f17) / f19;
                }
                int i17 = (int) dimension3;
                recyclerView.setPadding(i17, i.b(6), i17, recyclerView.getPaddingBottom());
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public ZPlanBaseHorizontalScrollCard.a I(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new a(this, view);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public void J(RecyclerView recyclerView, LinearLayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        recyclerView.setClipChildren(false);
        ViewParent parent = recyclerView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        this.recyclerView = recyclerView;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public int L() {
        return R.layout.d8x;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard, l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        super.f(dataInfo, position, totalCount);
        N();
        setBackgroundColor(0);
    }

    public final void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZplanHorizontalScrollSmallIconCard";
    }
}
