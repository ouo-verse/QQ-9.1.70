package com.tencent.mobileqq.zplan.card.impl.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaMidListCard;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.ZootopiaRecycleView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import pu4.g;
import pv4.s;
import pv4.u;
import t74.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0004/0\u000f1B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010+\u001a\u00020\n\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0018\u00010\u0016R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "", "f", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/widget/ZootopiaRecycleView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/widget/ZootopiaRecycleView;", "recycleView", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard$c;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard$c;", "midCardAdapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "T", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/tencent/sqshow/zootopia/card/report/a;", "U", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "V", "I", "cardPos", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "W", "a", "b", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaMidListCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private ZootopiaRecycleView recycleView;

    /* renamed from: S, reason: from kotlin metadata */
    private c midCardAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayoutManager layoutManager;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.card.report.a reportHelper;

    /* renamed from: V, reason: from kotlin metadata */
    private int cardPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Paint paint = new Paint();

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas c16, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onDrawOver(c16, parent, state);
            int a16 = i.a(2.25f);
            int a17 = i.a(117.0f);
            int a18 = i.a(30.0f);
            int a19 = i.a(0.0f);
            float width = (parent.getWidth() / 2) - (a17 / 2);
            float height = (parent.getHeight() - a19) - a16;
            this.paint.setAntiAlias(true);
            this.paint.setColor(Color.parseColor("#FFe0e0e0"));
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            this.paint.setStrokeWidth(a16);
            int computeHorizontalScrollExtent = parent.computeHorizontalScrollExtent();
            int computeHorizontalScrollRange = parent.computeHorizontalScrollRange();
            int computeHorizontalScrollOffset = parent.computeHorizontalScrollOffset();
            float f16 = computeHorizontalScrollRange - computeHorizontalScrollExtent;
            if (f16 > 0.0f) {
                c16.drawLine(width, height, width + a17, height, this.paint);
                float f17 = (a17 - a18) * (computeHorizontalScrollOffset / f16);
                this.paint.setColor(Color.parseColor("#FF0179ff"));
                c16.drawLine(width + f17, height, width + a18 + f17, height, this.paint);
                return;
            }
            this.paint.setColor(Color.parseColor("#FF327BF9"));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard$d;", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "Lcom/tencent/sqshow/zootopia/data/c;", "data", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/data/c;", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class c extends RecyclerView.Adapter<d> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private ZootopiaCardData data;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            List<s> c16;
            ZootopiaCardData zootopiaCardData = this.data;
            if (zootopiaCardData == null || (c16 = zootopiaCardData.c()) == null) {
                return 0;
            }
            return c16.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.m(this.data, position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.d8m, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026list_item, parent, false)");
            return new d(ZootopiaMidListCard.this, inflate);
        }

        public final void k0(ZootopiaCardData data) {
            this.data = data;
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaMidListCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.reportHelper = new com.tencent.sqshow.zootopia.card.report.a();
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
        c cVar = this.midCardAdapter;
        if (cVar != null) {
            cVar.k0(dataInfo);
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        View view = LayoutInflater.from(context).inflate(R.layout.d8l, viewParent, true);
        ZootopiaRecycleView zootopiaRecycleView = (ZootopiaRecycleView) view.findViewById(R.id.qgo);
        this.recycleView = zootopiaRecycleView;
        if (zootopiaRecycleView != null) {
            zootopiaRecycleView.addItemDecoration(new b());
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.layoutManager = linearLayoutManager;
        ZootopiaRecycleView zootopiaRecycleView2 = this.recycleView;
        if (zootopiaRecycleView2 != null) {
            zootopiaRecycleView2.setLayoutManager(linearLayoutManager);
        }
        c cVar = new c();
        this.midCardAdapter = cVar;
        ZootopiaRecycleView zootopiaRecycleView3 = this.recycleView;
        if (zootopiaRecycleView3 != null) {
            zootopiaRecycleView3.setAdapter(cVar);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZootopiaMidListCard";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/data/c;", "moduleDetail", "", com.tencent.luggage.wxa.c8.c.G, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "getMediaView", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setMediaView", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "mediaView", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaMidListCard;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView textView;

        /* renamed from: F, reason: from kotlin metadata */
        private ZPlanMediaView mediaView;
        final /* synthetic */ ZootopiaMidListCard G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ZootopiaMidListCard zootopiaMidListCard, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.G = zootopiaMidListCard;
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) this.itemView.findViewById(R.id.q8i);
            this.mediaView = zPlanMediaView;
            if (zPlanMediaView != null) {
                zPlanMediaView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            this.textView = (TextView) this.itemView.findViewById(R.id.qqa);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void n(s detail, d this$0, ZootopiaMidListCard this$1, Ref.ObjectRef dataItem, View view) {
            Intrinsics.checkNotNullParameter(detail, "$detail");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(dataItem, "$dataItem");
            if (!TextUtils.isEmpty(detail.f427682c)) {
                QLog.i("MidBannerPageItemView", 1, "click - " + detail.f427683d + " - " + detail.f427682c);
                ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                Context context = this$0.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                String str = detail.f427682c;
                Intrinsics.checkNotNullExpressionValue(str, "detail.jumpUrl");
                iSchemeApi.launchScheme(context, str);
            } else {
                QQToast.makeText(this$0.itemView.getContext(), "\u8df3\u8f6c\u53c2\u6570\u4e3a\u7a7a", 0).show();
                QLog.e("MidBannerPageItemView", 1, "click launchScheme but url is empty");
            }
            com.tencent.sqshow.zootopia.card.report.a aVar = this$1.reportHelper;
            View view2 = this$0.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "this.itemView");
            aVar.a(view2, this$1.cardPos, this$0.getAdapterPosition(), a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, detail.f427681b, null, 2, null), (ZootopiaCardData) dataItem.element, detail, (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void m(ZootopiaCardData moduleDetail, int pos) {
            List<s> c16;
            final s sVar;
            if (moduleDetail == 0 || (c16 = moduleDetail.c()) == null || c16.size() <= pos) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = moduleDetail;
            List<s> c17 = moduleDetail.c();
            if (c17 != null && (sVar = c17.get(pos)) != null) {
                final ZootopiaMidListCard zootopiaMidListCard = this.G;
                com.tencent.sqshow.zootopia.card.report.a aVar = zootopiaMidListCard.reportHelper;
                View view = this.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "this.itemView");
                aVar.c(view, zootopiaMidListCard.cardPos, getAdapterPosition(), a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, sVar.f427681b, null, 2, null), (ZootopiaCardData) objectRef.element, sVar, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
                ZPlanMediaView zPlanMediaView = this.mediaView;
                if (zPlanMediaView != null) {
                    g gVar = sVar.f427681b;
                    Intrinsics.checkNotNullExpressionValue(gVar, "detail.material");
                    zPlanMediaView.e(gVar);
                }
                TextView textView = this.textView;
                if (textView != null) {
                    m mVar = m.f435564a;
                    AssetManager assets = BaseApplication.context.getAssets();
                    Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
                    textView.setTypeface(mVar.f(assets));
                }
                u uVar = sVar.f427680a;
                if (uVar != null && !TextUtils.isEmpty(uVar.f427702a)) {
                    TextView textView2 = this.textView;
                    if (textView2 != null) {
                        textView2.setText(sVar.f427680a.f427702a);
                    }
                } else {
                    TextView textView3 = this.textView;
                    if (textView3 != null) {
                        textView3.setText("");
                    }
                }
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                aa.f(itemView, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ZootopiaMidListCard.d.n(s.this, this, zootopiaMidListCard, objectRef, view2);
                    }
                }, 500L, "ZootopiaMidListCard");
            }
            ZPlanMediaView zPlanMediaView2 = this.mediaView;
            if (zPlanMediaView2 != null) {
                zPlanMediaView2.setRadius(10);
            }
            ZPlanMediaView zPlanMediaView3 = this.mediaView;
            if (zPlanMediaView3 != null) {
                zPlanMediaView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }
}
