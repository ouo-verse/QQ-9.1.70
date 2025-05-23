package be3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import be3.l;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.zplan.aigc.data.OutfitItemInfo;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000589:;<Bo\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u001b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0 \u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%0$\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u00100\u001a\u00020-\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020-0\u0017\u00a2\u0006\u0004\b5\u00106J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0014\u0010\u0016\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020-0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u0019R\u0014\u00104\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b3\u00103\u00a8\u0006="}, d2 = {"Lbe3/l;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "partUrl", "", "position", "Landroid/widget/ImageView;", "partImg", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "getItemViewType", "getItemCount", "", "Lcom/tencent/mobileqq/zplan/aigc/data/k;", "newDataList", "setData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Lkotlin/Function1;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onMakeSameStyleClick", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "onTryOnClick", "", "", "E", "Ljava/util/Map;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "Lzd3/a;", UserInfo.SEX_FEMALE, "Lzd3/a;", "dtReporter", "", "G", "Z", "isMasterMode", "H", "urlDrawableLoadStatus", "I", "PRICE_COIN_TYPE_SILVER", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/util/Map;Lzd3/a;ZLjava/util/List;)V", "J", "a", "b", "c", "d", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class l extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Function1<Long, Unit> onMakeSameStyleClick;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function0<Unit> onTryOnClick;

    /* renamed from: E, reason: from kotlin metadata */
    private final Map<String, Object> pageParams;

    /* renamed from: F, reason: from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isMasterMode;

    /* renamed from: H, reason: from kotlin metadata */
    private List<Boolean> urlDrawableLoadStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private final int PRICE_COIN_TYPE_SILVER;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<OutfitItemInfo> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lbe3/l$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aigc/data/k;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "partImg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getPartTitle", "()Landroid/widget/TextView;", "partTitle", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "getBottomActionRegion", "()Landroid/widget/LinearLayout;", "bottomActionRegion", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/l;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView partImg;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView partTitle;

        /* renamed from: H, reason: from kotlin metadata */
        private final LinearLayout bottomActionRegion;
        final /* synthetic */ l I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, View itemView, zd3.a aVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = lVar;
            this.dtReporter = aVar;
            View findViewById = itemView.findViewById(R.id.qbx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.part_igv)");
            this.partImg = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.qbz);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.part_title)");
            this.partTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.qbu);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026t_bottom_region_activity)");
            this.bottomActionRegion = (LinearLayout) findViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(l this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onTryOnClick.invoke();
        }

        public void m(OutfitItemInfo data, int position) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.I.n0(data.getIcon(), position, this.partImg);
            this.partTitle.setText(data.getName());
            QLog.i("SuitOutfitPartAdapter", 1, "suit outfit isMasterMode = " + this.I.isMasterMode);
            if (this.I.isMasterMode) {
                this.bottomActionRegion.setVisibility(8);
            } else {
                this.bottomActionRegion.setVisibility(0);
            }
            View view = this.itemView;
            final l lVar = this.I;
            view.setOnClickListener(new View.OnClickListener() { // from class: be3.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    l.a.n(l.this, view2);
                }
            });
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getPartImg() {
            return this.partImg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001a\u00a8\u0006)"}, d2 = {"Lbe3/l$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aigc/data/k;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "partImg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getPartTitle", "()Landroid/widget/TextView;", "partTitle", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "getBottomActionRegion", "()Landroid/widget/LinearLayout;", "bottomActionRegion", "I", "getViewType", "viewType", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/l;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView partImg;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView partTitle;

        /* renamed from: H, reason: from kotlin metadata */
        private final LinearLayout bottomActionRegion;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView viewType;
        final /* synthetic */ l J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar, View itemView, zd3.a aVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.J = lVar;
            this.dtReporter = aVar;
            View findViewById = itemView.findViewById(R.id.qbx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.part_igv)");
            this.partImg = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.qbz);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.part_title)");
            this.partTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.qbu);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026t_bottom_region_activity)");
            this.bottomActionRegion = (LinearLayout) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.pws);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.get_by_activity)");
            this.viewType = (TextView) findViewById4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(l this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onTryOnClick.invoke();
        }

        public void m(OutfitItemInfo data, int position) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.viewType.setText("\u5df2\u62e5\u6709");
            this.J.n0(data.getIcon(), position, this.partImg);
            this.partTitle.setText(data.getName());
            QLog.i("SuitOutfitPartAdapter", 1, "suit outfit isMasterMode = " + this.J.isMasterMode);
            if (this.J.isMasterMode) {
                this.bottomActionRegion.setVisibility(8);
            } else {
                this.bottomActionRegion.setVisibility(0);
            }
            View view = this.itemView;
            final l lVar = this.J;
            view.setOnClickListener(new View.OnClickListener() { // from class: be3.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    l.c.n(l.this, view2);
                }
            });
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getPartImg() {
            return this.partImg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u0017\u0010'\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014R\u0017\u0010*\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010\u001a\u00a8\u0006/"}, d2 = {"Lbe3/l$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aigc/data/k;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "partImg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getPartTitle", "()Landroid/widget/TextView;", "partTitle", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "getBottomActionRegion", "()Landroid/widget/LinearLayout;", "bottomActionRegion", "I", "getGoldCoinImage", "goldCoinImage", "J", "getSilverCoinImage", "silverCoinImage", "K", "getPrice", "price", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/l;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView partImg;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView partTitle;

        /* renamed from: H, reason: from kotlin metadata */
        private final LinearLayout bottomActionRegion;

        /* renamed from: I, reason: from kotlin metadata */
        private final ImageView goldCoinImage;

        /* renamed from: J, reason: from kotlin metadata */
        private final ImageView silverCoinImage;

        /* renamed from: K, reason: from kotlin metadata */
        private final TextView price;
        final /* synthetic */ l L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l lVar, View itemView, zd3.a aVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.L = lVar;
            this.dtReporter = aVar;
            View findViewById = itemView.findViewById(R.id.qbx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.part_igv)");
            this.partImg = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.qbz);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.part_title)");
            this.partTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.qbv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026part_bottom_region_price)");
            this.bottomActionRegion = (LinearLayout) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.qdq);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.price_icon_gold)");
            this.goldCoinImage = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.qdr);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.price_icon_silver)");
            this.silverCoinImage = (ImageView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.qby);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.part_price)");
            this.price = (TextView) findViewById6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(l this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onTryOnClick.invoke();
        }

        public void m(OutfitItemInfo data, int position) {
            Integer priceType;
            Integer gold;
            Integer silver;
            Intrinsics.checkNotNullParameter(data, "data");
            this.L.n0(data.getIcon(), position, this.partImg);
            this.partTitle.setText(data.getName());
            if (this.L.isMasterMode) {
                this.bottomActionRegion.setVisibility(8);
            } else {
                this.bottomActionRegion.setVisibility(0);
            }
            Integer priceType2 = data.getPriceType();
            if ((priceType2 == null || priceType2.intValue() != 2) && ((priceType = data.getPriceType()) == null || priceType.intValue() != 3)) {
                if (data.getGold() != null && (gold = data.getGold()) != null && gold.intValue() == 0) {
                    this.silverCoinImage.setVisibility(8);
                    this.goldCoinImage.setVisibility(8);
                    this.price.setVisibility(8);
                } else {
                    this.goldCoinImage.setVisibility(0);
                    this.silverCoinImage.setVisibility(8);
                    TextView textView = this.price;
                    Integer gold2 = data.getGold();
                    textView.setText(gold2 != null ? gold2.toString() : null);
                }
            } else if (data.getSilver() != null && (silver = data.getSilver()) != null && silver.intValue() == 0) {
                this.silverCoinImage.setVisibility(8);
                this.goldCoinImage.setVisibility(8);
                this.price.setVisibility(8);
            } else {
                this.silverCoinImage.setVisibility(0);
                this.goldCoinImage.setVisibility(8);
                TextView textView2 = this.price;
                Integer silver2 = data.getSilver();
                textView2.setText(silver2 != null ? silver2.toString() : null);
            }
            View view = this.itemView;
            final l lVar = this.L;
            view.setOnClickListener(new View.OnClickListener() { // from class: be3.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    l.d.n(l.this, view2);
                }
            });
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getPartImg() {
            return this.partImg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lbe3/l$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aigc/data/k;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "partImg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getPartTitle", "()Landroid/widget/TextView;", "partTitle", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "getSameStyleButton", "()Landroid/widget/LinearLayout;", "sameStyleButton", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/l;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView partImg;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView partTitle;

        /* renamed from: H, reason: from kotlin metadata */
        private final LinearLayout sameStyleButton;
        final /* synthetic */ l I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(l lVar, View itemView, zd3.a aVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = lVar;
            this.dtReporter = aVar;
            View findViewById = itemView.findViewById(R.id.qbx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.part_igv)");
            this.partImg = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.qbz);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.part_title)");
            this.partTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.qbw);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026bottom_region_same_style)");
            this.sameStyleButton = (LinearLayout) findViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(OutfitItemInfo data, l this$0, e this$1, View view) {
            String str;
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (data.getDesc() != null) {
                if (!(data.getDesc().length() == 0)) {
                    this$0.onMakeSameStyleClick.invoke(Long.valueOf(data.getUgcId()));
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (this$0.isMasterMode) {
                        str = "pg_zplan_contribute";
                    } else {
                        str = "pg_zplan_feed_detail";
                    }
                    linkedHashMap.put("dt_pgid", str);
                    zd3.a aVar = this$1.dtReporter;
                    if (aVar != null) {
                        View itemView = this$1.itemView;
                        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                        aVar.t(itemView, "em_zplan_samestyle", linkedHashMap);
                        return;
                    }
                    return;
                }
            }
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iSchemeApi.launchScheme(context, "mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=18&pageData=%7B%22subPageId%22%3A2%7D");
        }

        public void m(final OutfitItemInfo data, int position) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.I.n0(data.getIcon(), position, this.partImg);
            this.partTitle.setText(data.getName());
            View view = this.itemView;
            final l lVar = this.I;
            view.setOnClickListener(new View.OnClickListener() { // from class: be3.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    l.e.n(OutfitItemInfo.this, lVar, this, view2);
                }
            });
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getPartImg() {
            return this.partImg;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(List<OutfitItemInfo> dataList, Function1<? super Long, Unit> onMakeSameStyleClick, Function0<Unit> onTryOnClick, Map<String, Object> pageParams, zd3.a aVar, boolean z16, List<Boolean> urlDrawableLoadStatus) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(onMakeSameStyleClick, "onMakeSameStyleClick");
        Intrinsics.checkNotNullParameter(onTryOnClick, "onTryOnClick");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        Intrinsics.checkNotNullParameter(urlDrawableLoadStatus, "urlDrawableLoadStatus");
        this.dataList = dataList;
        this.onMakeSameStyleClick = onMakeSameStyleClick;
        this.onTryOnClick = onTryOnClick;
        this.pageParams = pageParams;
        this.dtReporter = aVar;
        this.isMasterMode = z16;
        this.urlDrawableLoadStatus = urlDrawableLoadStatus;
        this.PRICE_COIN_TYPE_SILVER = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(String partUrl, int position, ImageView partImg) {
        com.tencent.mobileqq.zplan.aigc.utils.a aVar = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a;
        if (!aVar.g(partUrl)) {
            QLog.e("SuitOutfitPartAdapter", 1, "url: " + partUrl + " is invalid!!!");
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(partUrl, aVar.d());
        if (drawable.getStatus() == 1) {
            QLog.i("SuitOutfitPartAdapter", 1, "drawable status is success! url: " + partUrl);
            if (position < 5) {
                this.urlDrawableLoadStatus.set(position, Boolean.TRUE);
            }
        }
        drawable.setURLDrawableListener(new f(partUrl, position, this));
        partImg.setImageDrawable(drawable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int type = this.dataList.get(position).getType();
        if (type == 1) {
            return 1;
        }
        if (type != 2) {
            return type != 3 ? 4 : 3;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            ((e) holder).m(this.dataList.get(position), position);
            return;
        }
        if (itemViewType == 2) {
            ((d) holder).m(this.dataList.get(position), position);
        } else if (itemViewType == 3) {
            ((c) holder).m(this.dataList.get(position), position);
        } else {
            if (itemViewType != 4) {
                return;
            }
            ((a) holder).m(this.dataList.get(position), position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dg8, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new e(this, view, this.dtReporter);
        }
        if (viewType == 2) {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dg7, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new d(this, view2, this.dtReporter);
        }
        if (viewType == 3) {
            View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dg6, parent, false);
            Intrinsics.checkNotNullExpressionValue(view3, "view");
            return new c(this, view3, this.dtReporter);
        }
        if (viewType == 4) {
            View view4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dg6, parent, false);
            Intrinsics.checkNotNullExpressionValue(view4, "view");
            return new a(this, view4, this.dtReporter);
        }
        throw new IllegalArgumentException("Invalid view type");
    }

    public final void setData(List<OutfitItemInfo> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.dataList.clear();
        this.dataList.addAll(newDataList);
        notifyDataSetChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"be3/l$f", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "drawable", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class f implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f28332d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f28333e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f28334f;

        f(String str, int i3, l lVar) {
            this.f28332d = str;
            this.f28333e = i3;
            this.f28334f = lVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            QLog.i("SuitOutfitPartAdapter", 1, "drawable load success! url: " + this.f28332d);
            if (this.f28333e < 5) {
                this.f28334f.urlDrawableLoadStatus.set(this.f28333e, Boolean.TRUE);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }
}
