package com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.widget.ZootopiaRecycleView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.json.JSONObject;
import pv4.s;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0003FGHB/\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010C\u001a\u00020\b\u00a2\u0006\u0004\bD\u0010EJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J>\u0010!\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fJV\u0010&\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001e\u001a\u00020\u001d2\"\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020#`$J2\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001e\u001a\u00020\u001dR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00106\u001a\b\u0018\u000103R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u0010<\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\r\u001a\u0004\b8\u00109\"\u0004\b:\u0010;\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "J", "", "L", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "I", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "position", "totalCount", "f", "itemView", "itemPos", "Lpv4/s;", "itemData", "parentCardData", "", "elementType", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "E", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extParams", UserInfo.SEX_FEMALE, "holder", "G", "Lcom/tencent/sqshow/zootopia/card/report/a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Lcom/tencent/sqshow/zootopia/widget/ZootopiaRecycleView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/sqshow/zootopia/widget/ZootopiaRecycleView;", "recycleView", "T", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$c;", "U", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$c;", "horizonAdapter", "V", "K", "()I", "setCardPos", "(I)V", "cardPos", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class ZPlanBaseHorizontalScrollCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.card.report.a reportHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private ZootopiaRecycleView recycleView;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayoutManager layoutManager;

    /* renamed from: U, reason: from kotlin metadata */
    private c horizonAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private int cardPos;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00070\u00070\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "p0", "", "", "getDynamicParams", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "a", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "getV", "()Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "v", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "b", "Lmqq/util/WeakReference;", "getHolder", "()Lmqq/util/WeakReference;", "holder", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final a v;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<a> holder;

        public b(a v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            this.v = v3;
            this.holder = new WeakReference<>(v3);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String p06) {
            HashMap<String, Object> m3;
            a aVar = this.holder.get();
            return (aVar == null || (m3 = aVar.m()) == null) ? new HashMap() : m3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "Lcom/tencent/sqshow/zootopia/data/c;", "data", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/data/c;", "parentCardData", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class c extends RecyclerView.Adapter<a> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private ZootopiaCardData parentCardData;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            List<s> c16;
            ZootopiaCardData zootopiaCardData = this.parentCardData;
            if (zootopiaCardData == null || (c16 = zootopiaCardData.c()) == null) {
                return 0;
            }
            return c16.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            List<s> c16;
            List<s> c17;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (position >= 0) {
                ZootopiaCardData zootopiaCardData = this.parentCardData;
                if (position < ((zootopiaCardData == null || (c17 = zootopiaCardData.c()) == null) ? 0 : c17.size())) {
                    ZootopiaCardData zootopiaCardData2 = this.parentCardData;
                    s sVar = (zootopiaCardData2 == null || (c16 = zootopiaCardData2.c()) == null) ? null : c16.get(position);
                    holder.l(position, sVar, this.parentCardData);
                    String f16 = com.tencent.sqshow.zootopia.card.report.a.INSTANCE.f(sVar != null ? sVar.f427681b : null, holder.o());
                    ZPlanBaseHorizontalScrollCard zPlanBaseHorizontalScrollCard = ZPlanBaseHorizontalScrollCard.this;
                    View view = holder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                    zPlanBaseHorizontalScrollCard.E(view, position, sVar, this.parentCardData, f16, new b(holder));
                    if (holder.q()) {
                        ZPlanBaseHorizontalScrollCard.this.y("auto bind itemClickListener " + position, false);
                        ZPlanBaseHorizontalScrollCard.this.G(holder, position, sVar, this.parentCardData, f16);
                        holder.r(position);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(ZPlanBaseHorizontalScrollCard.this.L(), parent, false);
            ZPlanBaseHorizontalScrollCard zPlanBaseHorizontalScrollCard = ZPlanBaseHorizontalScrollCard.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return zPlanBaseHorizontalScrollCard.I(view);
        }

        public final void k0(ZootopiaCardData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.parentCardData = data;
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseHorizontalScrollCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.reportHelper = new com.tencent.sqshow.zootopia.card.report.a();
    }

    public final void G(final a holder, final int itemPos, final s itemData, final ZootopiaCardData parentCardData, final String elementType) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        final View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        View s16 = holder.s();
        if (s16 == null) {
            s16 = view;
        }
        if (itemData == null || parentCardData == null) {
            return;
        }
        aa.f(s16, new View.OnClickListener() { // from class: uf3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanBaseHorizontalScrollCard.H(ZPlanBaseHorizontalScrollCard.this, view, itemPos, itemData, parentCardData, elementType, holder, view2);
            }
        }, 500L, "ZPlanBaseHorizontalScrollCard");
    }

    public abstract a I(View view);

    public abstract void J(RecyclerView recyclerView, LinearLayoutManager layoutManager);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: from getter */
    public final int getCardPos() {
        return this.cardPos;
    }

    public abstract int L();

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        y(getSelfItemType() + " - bindItemInfo, position=" + position + ", totalCount=" + totalCount, true);
        this.cardPos = position;
        c cVar = this.horizonAdapter;
        if (cVar != null) {
            cVar.k0(dataInfo);
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        View view = LayoutInflater.from(context).inflate(R.layout.dcz, viewParent, true);
        this.recycleView = (ZootopiaRecycleView) view.findViewById(R.id.qgo);
        this.layoutManager = new LinearLayoutManager(context, 0, false);
        ZootopiaRecycleView zootopiaRecycleView = this.recycleView;
        if (zootopiaRecycleView != null) {
            Intrinsics.checkNotNull(zootopiaRecycleView);
            LinearLayoutManager linearLayoutManager = this.layoutManager;
            Intrinsics.checkNotNull(linearLayoutManager);
            J(zootopiaRecycleView, linearLayoutManager);
        }
        ZootopiaRecycleView zootopiaRecycleView2 = this.recycleView;
        if (zootopiaRecycleView2 != null) {
            zootopiaRecycleView2.setLayoutManager(this.layoutManager);
        }
        c cVar = new c();
        this.horizonAdapter = cVar;
        ZootopiaRecycleView zootopiaRecycleView3 = this.recycleView;
        if (zootopiaRecycleView3 != null) {
            zootopiaRecycleView3.setAdapter(cVar);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    public final void E(View itemView, int itemPos, s itemData, ZootopiaCardData parentCardData, String elementType, IDynamicParams dynamicParams) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        if (itemData == null || parentCardData == null) {
            return;
        }
        this.reportHelper.c(itemView, this.cardPos, itemPos, elementType, parentCardData, itemData, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : dynamicParams, (r24 & 512) != 0);
    }

    public final void F(View itemView, int itemPos, s itemData, ZootopiaCardData parentCardData, String elementType, HashMap<String, Object> extParams) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        Intrinsics.checkNotNullParameter(extParams, "extParams");
        if (itemData == null || parentCardData == null) {
            return;
        }
        this.reportHelper.a(itemView, this.cardPos, itemPos, elementType, parentCardData, itemData, (r20 & 64) != 0 ? new HashMap() : extParams, (r20 & 128) != 0 ? "em_zplan_element" : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ZPlanBaseHorizontalScrollCard this$0, View itemView, int i3, s sVar, ZootopiaCardData zootopiaCardData, String elementType, a holder, View view) {
        JSONObject c16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(elementType, "$elementType");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.F(itemView, i3, sVar, zootopiaCardData, elementType, holder.m());
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        String str = pageInfo != null ? pageInfo.pageId : null;
        if (str == null) {
            str = "pg_zplan_paradise";
        }
        c16 = com.tencent.sqshow.zootopia.card.report.a.INSTANCE.c(this$0.cardPos, i3, elementType, zootopiaCardData, sVar, (r17 & 32) != 0 ? "pg_zplan_paradise" : str, (r17 & 64) != 0 ? "em_zplan_element" : null);
        String str2 = sVar.f427682c;
        ZootopiaBaseCard.w(this$0, str2 != null ? CommonExKt.c(str2, "ReportData", c16) : null, false, 2, null);
        holder.r(i3);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J$\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0006H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemRootView", "", "p", "", "itemPos", "Lpv4/s;", "itemData", "Lcom/tencent/sqshow/zootopia/data/c;", "parentCardData", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "position", "r", "view", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static abstract class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            p(itemView);
        }

        public abstract void l(int itemPos, s itemData, ZootopiaCardData parentCardData);

        public HashMap<String, Object> m() {
            return new HashMap<>();
        }

        public String o() {
            return "1";
        }

        public abstract void p(View itemRootView);

        public boolean q() {
            return true;
        }

        public View s() {
            return null;
        }

        public void r(int position) {
        }
    }
}
