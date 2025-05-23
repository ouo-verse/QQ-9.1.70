package com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonVideoStyle;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import cooperation.qzone.QZoneRequestEncoder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oa4.a;
import pu4.g;
import pv4.s;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB/\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithDownloadBtnCard;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "J", "", "L", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "I", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "W", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanHorizontalScrollWithDownloadBtnCard extends ZPlanBaseHorizontalScrollCard {

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithDownloadBtnCard$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = ViewUtils.dip2px(13.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanHorizontalScrollWithDownloadBtnCard(Context context, LifecycleOwner owner, a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public ZPlanBaseHorizontalScrollCard.a I(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new b(this, view);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public void J(RecyclerView recyclerView, LinearLayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        recyclerView.addItemDecoration(new c());
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public int L() {
        return R.layout.f167446dd0;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanHorizontalScrollWithDownloadBtnCard";
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0006R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u00102\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b/\u0010/\u001a\u0004\b0\u00101R\u0017\u00105\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithDownloadBtnCard$b;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "Landroid/view/View;", "itemRootView", "", "p", "", "itemPos", "Lpv4/s;", "itemData", "Lcom/tencent/sqshow/zootopia/data/c;", "parentCardData", "l", "view", "", "scale", "textSize", "u", "t", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "E", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", QZoneRequestEncoder.KEY_COVER_REQ, "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setCover", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "cover", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "title", "G", "getDesc", "setDesc", "desc", "Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "H", "Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "getDownloadBtn", "()Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "setDownloadBtn", "(Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;)V", "downloadBtn", "I", "getDefaultTitleColor", "()I", "defaultTitleColor", "J", "getDefaultDescColor", "defaultDescColor", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "K", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "getDownloadButtonBinder", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "setDownloadButtonBinder", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;)V", "downloadButtonBinder", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithDownloadBtnCard;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class b extends ZPlanBaseHorizontalScrollCard.a {

        /* renamed from: E, reason: from kotlin metadata */
        private ZPlanMediaView cover;

        /* renamed from: F, reason: from kotlin metadata */
        private TextView title;

        /* renamed from: G, reason: from kotlin metadata */
        private TextView desc;

        /* renamed from: H, reason: from kotlin metadata */
        private ZplanCommonButton downloadBtn;

        /* renamed from: I, reason: from kotlin metadata */
        private final int defaultTitleColor;

        /* renamed from: J, reason: from kotlin metadata */
        private final int defaultDescColor;

        /* renamed from: K, reason: from kotlin metadata */
        private ZootopiaDownloadButtonBinder downloadButtonBinder;
        final /* synthetic */ ZPlanHorizontalScrollWithDownloadBtnCard L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ZPlanHorizontalScrollWithDownloadBtnCard zPlanHorizontalScrollWithDownloadBtnCard, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.L = zPlanHorizontalScrollWithDownloadBtnCard;
            this.defaultTitleColor = Color.parseColor("#FFFFFF");
            this.defaultDescColor = Color.parseColor("#80302F2F");
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void p(View itemRootView) {
            float f16;
            Intrinsics.checkNotNullParameter(itemRootView, "itemRootView");
            this.cover = (ZPlanMediaView) itemRootView.findViewById(R.id.pms);
            this.title = (TextView) itemRootView.findViewById(R.id.qr6);
            this.desc = (TextView) itemRootView.findViewById(R.id.pov);
            this.downloadBtn = (ZplanCommonButton) itemRootView.findViewById(R.id.pq8);
            Context context = this.L.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.downloadButtonBinder = new ZootopiaDownloadButtonBinder(context, this.L.o(), this.L.p());
            ZPlanMediaView zPlanMediaView = this.cover;
            if (zPlanMediaView != null) {
                f16 = t() / zPlanMediaView.getLayoutParams().width;
                u(zPlanMediaView, f16, 0.0f);
            } else {
                f16 = 1.0f;
            }
            TextView textView = this.title;
            if (textView != null) {
                u(textView, f16, 11.0f);
            }
            TextView textView2 = this.desc;
            if (textView2 != null) {
                u(textView2, f16, 10.0f);
            }
        }

        public final int t() {
            return ((ba.getScreenWidth(this.L.getContext()) - (ViewUtils.dip2px(15.0f) * 2)) - (ViewUtils.dip2px(13.0f) * 3)) / 4;
        }

        public final void u(View view, float scale, float textSize) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.getLayoutParams().width = (int) (view.getLayoutParams().width * scale);
            view.getLayoutParams().height = (int) (view.getLayoutParams().height * scale);
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(textSize * scale);
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void l(int itemPos, s itemData, ZootopiaCardData parentCardData) {
            if (itemData != null) {
                ZPlanMediaView zPlanMediaView = this.cover;
                if (zPlanMediaView != null) {
                    g gVar = itemData.f427681b;
                    Intrinsics.checkNotNullExpressionValue(gVar, "itemData.material");
                    zPlanMediaView.J(gVar);
                    g gVar2 = itemData.f427681b;
                    Intrinsics.checkNotNullExpressionValue(gVar2, "itemData.material");
                    zPlanMediaView.e(gVar2);
                    zPlanMediaView.setRadius(6);
                }
                TextView textView = this.title;
                if (textView != null) {
                    l84.b.a(textView, itemData.f427683d, this.defaultTitleColor);
                }
                TextView textView2 = this.desc;
                if (textView2 != null) {
                    l84.b.a(textView2, itemData.f427680a, this.defaultDescColor);
                }
                ZplanViewReportHelper.Companion companion = ZplanViewReportHelper.INSTANCE;
                Intrinsics.checkNotNull(parentCardData);
                HashMap<String, Object> a16 = companion.a(parentCardData, this.L.getCardPos(), itemPos, "4", itemData);
                fl3.a aVar = new fl3.a(itemData.f427684e, itemData.f427682c, null, ZootopiaDownloadButtonVideoStyle.class, ZootopiaDownloadBarType.PLAY_TOGETHER_BAR, 1, this.L.r(), this.downloadButtonBinder, false, a16, 4, null);
                ZplanCommonButton zplanCommonButton = this.downloadBtn;
                if (zplanCommonButton != null) {
                    zplanCommonButton.t(aVar, this.L.o());
                }
            }
        }
    }
}
