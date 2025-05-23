package ic4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.utils.h;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pu4.j;
import pu4.l;
import pu4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000289B\u0017\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020$\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\u0014\u0010\u0010\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R'\u00100\u001a\u0012\u0012\u0004\u0012\u00020\b0*j\b\u0012\u0004\u0012\u00020\b`+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006:"}, d2 = {"Lic4/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lic4/d$b;", "viewHolder", "", "position", "", "l0", "Lcom/tencent/sqshow/zootopia/data/g;", "feedData", "", "", "o0", "", "newData", "s0", "addData", "k0", "id", "t0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "u0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "r0", "getItemViewType", "vh", "q0", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "getUserCenterPage", "()Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "userCenterPage", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "p0", "()Ljava/util/ArrayList;", "mData", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "E", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;)V", UserInfo.SEX_FEMALE, "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage;

    /* renamed from: D, reason: from kotlin metadata */
    private final ArrayList<ZootopiaDetailFeedsCardData> mData;

    /* renamed from: E, reason: from kotlin metadata */
    private final ZplanViewReportHelper mReporter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lic4/d$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "E", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setMediaView", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "mediaView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setIconView", "(Landroid/widget/ImageView;)V", "iconView", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "o", "()Landroid/widget/RelativeLayout;", "setPrivateLayout", "(Landroid/widget/RelativeLayout;)V", "privateLayout", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private ZPlanMediaView mediaView;

        /* renamed from: F, reason: from kotlin metadata */
        private ImageView iconView;

        /* renamed from: G, reason: from kotlin metadata */
        private RelativeLayout privateLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            ((RoundRelativeLayout) itemView).f316195e = i.b(10);
            this.mediaView = (ZPlanMediaView) itemView.findViewById(R.id.qw6);
            this.iconView = (ImageView) itemView.findViewById(R.id.qw5);
            this.privateLayout = (RelativeLayout) itemView.findViewById(R.id.qw7);
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getIconView() {
            return this.iconView;
        }

        /* renamed from: m, reason: from getter */
        public final ZPlanMediaView getMediaView() {
            return this.mediaView;
        }

        /* renamed from: o, reason: from getter */
        public final RelativeLayout getPrivateLayout() {
            return this.privateLayout;
        }
    }

    public d(Context context, com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userCenterPage, "userCenterPage");
        this.context = context;
        this.userCenterPage = userCenterPage;
        this.mData = new ArrayList<>();
        this.mReporter = new ZplanViewReportHelper();
    }

    private final void l0(final b viewHolder, int position) {
        ZPlanMediaView mediaView;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = this.mData.get(position);
        Intrinsics.checkNotNullExpressionValue(zootopiaDetailFeedsCardData, "mData[position]");
        final ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData2 = zootopiaDetailFeedsCardData;
        viewHolder.itemView.setTag(Integer.valueOf(position));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ic4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.m0(d.this, viewHolder, zootopiaDetailFeedsCardData2, view);
            }
        });
        viewHolder.itemView.post(new Runnable() { // from class: ic4.c
            @Override // java.lang.Runnable
            public final void run() {
                d.n0(d.this, viewHolder, zootopiaDetailFeedsCardData2);
            }
        });
        ZootopiaDetailFeedsCardData.Companion companion = ZootopiaDetailFeedsCardData.INSTANCE;
        g c16 = companion.c(zootopiaDetailFeedsCardData2);
        if (c16 != null && (mediaView = viewHolder.getMediaView()) != null) {
            mediaView.J(c16);
        }
        boolean j3 = companion.j(c16);
        ImageView iconView = viewHolder.getIconView();
        if (iconView != null) {
            iconView.setVisibility(j3 ? 0 : 8);
        }
        boolean z16 = companion.e(zootopiaDetailFeedsCardData2) == 2;
        RelativeLayout privateLayout = viewHolder.getPrivateLayout();
        if (privateLayout == null) {
            return;
        }
        privateLayout.setVisibility(z16 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(d this$0, b viewHolder, ZootopiaDetailFeedsCardData feedData, View view) {
        l lVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        if (h.a()) {
            return;
        }
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
        zplanViewReportHelper.e(view2, "em_zplan_outfit_moment", this$0.o0(feedData));
        QRouteApi api = QRoute.api(ISchemeApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISchemeApi::class.java)");
        ISchemeApi iSchemeApi = (ISchemeApi) api;
        ZootopiaSource g16 = ZootopiaSource.INSTANCE.g();
        n outfitWorksInfo = feedData.getOutfitWorksInfo();
        String str = (outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null) ? null : lVar.f427476a;
        if (str == null) {
            str = "";
        }
        iSchemeApi.launchScheme(this$0.context, iSchemeApi.buildDressDetailScheme(g16, str, this$0.userCenterPage.getMCurrentUin(), "usercenter"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(d this$0, b viewHolder, ZootopiaDetailFeedsCardData feedData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        zplanViewReportHelper.g(view, "em_zplan_outfit_moment", (r16 & 4) != 0 ? null : this$0.o0(feedData), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final Map<String, String> o0(ZootopiaDetailFeedsCardData feedData) {
        l lVar;
        String num;
        l lVar2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_tab_id", "0");
        String string = this.context.getString(R.string.f169844xx2);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026lan_user_center_tab_wear)");
        linkedHashMap.put("zplan_tab_name", string);
        n outfitWorksInfo = feedData.getOutfitWorksInfo();
        String str = (outfitWorksInfo == null || (lVar2 = outfitWorksInfo.f427499b) == null) ? null : lVar2.f427476a;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("zplan_content_id", str);
        n outfitWorksInfo2 = feedData.getOutfitWorksInfo();
        if (outfitWorksInfo2 != null && (lVar = outfitWorksInfo2.f427499b) != null && (num = Integer.valueOf(lVar.f427491p).toString()) != null) {
            str2 = num;
        }
        linkedHashMap.put("zplan_content_type", str2);
        return linkedHashMap;
    }

    public final void addData(List<ZootopiaDetailFeedsCardData> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.mData.addAll(newData);
        notifyItemInserted(this.mData.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mData.get(position) instanceof ZootopiaDetailFeedsCardData ? 1 : -1;
    }

    public final void k0(ZootopiaDetailFeedsCardData feedData) {
        Object obj;
        l lVar;
        l lVar2;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Iterator<T> it = this.mData.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            n outfitWorksInfo = ((ZootopiaDetailFeedsCardData) next).getOutfitWorksInfo();
            String str = (outfitWorksInfo == null || (lVar2 = outfitWorksInfo.f427499b) == null) ? null : lVar2.f427476a;
            n outfitWorksInfo2 = feedData.getOutfitWorksInfo();
            if (outfitWorksInfo2 != null && (lVar = outfitWorksInfo2.f427499b) != null) {
                obj = lVar.f427476a;
            }
            if (Intrinsics.areEqual(str, obj)) {
                obj = next;
                break;
            }
        }
        if (((ZootopiaDetailFeedsCardData) obj) != null) {
            return;
        }
        this.mData.add(0, feedData);
        notifyItemRangeChanged(0, this.mData.size());
    }

    public final ArrayList<ZootopiaDetailFeedsCardData> p0() {
        return this.mData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b vh5, int position) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        l0(vh5, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(this.context).inflate(R.layout.dha, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(itemView);
    }

    public final void s0(List<ZootopiaDetailFeedsCardData> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.mData.clear();
        this.mData.addAll(newData);
        notifyItemRangeChanged(0, this.mData.size());
    }

    public final void t0(String id5) {
        l lVar;
        Intrinsics.checkNotNullParameter(id5, "id");
        int i3 = 0;
        if (id5.length() == 0) {
            return;
        }
        Iterator<ZootopiaDetailFeedsCardData> it = this.mData.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            n outfitWorksInfo = it.next().getOutfitWorksInfo();
            if (Intrinsics.areEqual((outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null) ? null : lVar.f427476a, id5)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            this.mData.remove(i3);
            notifyItemRemoved(i3);
            notifyItemRangeChanged(i3, getNUM_BACKGOURND_ICON() - i3);
        }
    }

    public final void u0(String id5, int showType) {
        l lVar;
        Intrinsics.checkNotNullParameter(id5, "id");
        int i3 = 0;
        if (id5.length() == 0) {
            return;
        }
        Iterator<ZootopiaDetailFeedsCardData> it = this.mData.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            n outfitWorksInfo = it.next().getOutfitWorksInfo();
            if (Intrinsics.areEqual((outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null) ? null : lVar.f427476a, id5)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = this.mData.get(i3);
            Intrinsics.checkNotNullExpressionValue(zootopiaDetailFeedsCardData, "mData[index]");
            n outfitWorksInfo2 = zootopiaDetailFeedsCardData.getOutfitWorksInfo();
            j jVar = outfitWorksInfo2 != null ? outfitWorksInfo2.f427498a : null;
            if (jVar != null) {
                jVar.f427466e = showType;
            }
            notifyItemChanged(i3);
        }
    }
}
