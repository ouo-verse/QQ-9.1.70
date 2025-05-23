package com.tencent.ecommerce.biz.productcenter.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ri0.c;
import xj0.RankGoodsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000223B'\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010/\u001a\u00020\u0003\u00a2\u0006\u0004\b0\u00101J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0007J\u0006\u0010\u001a\u001a\u00020\bR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$a;", "", "saasProductId", "", "l0", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "o0", "Ljava/util/ArrayList;", "Lxj0/a;", "Lkotlin/collections/ArrayList;", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "position", "m0", "getItemCount", "k0", "", "dataList", "setData", "i0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "productIdMap", "Landroid/content/Context;", "D", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", "E", "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", "rankType", "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;", "rankCallback", "G", "Ljava/lang/String;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;Ljava/lang/String;)V", "ECRankCallback", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRankRecycleViewAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: D, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: E, reason: from kotlin metadata */
    private final ECSalesRankRepo.SalesRankType rankType;

    /* renamed from: F, reason: from kotlin metadata */
    private final ECRankCallback rankCallback;

    /* renamed from: G, reason: from kotlin metadata */
    private final String channel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<RankGoodsInfo> dataList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private final Map<String, RankGoodsInfo> productIdMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;", "", "onAddProductToWindow", "", "goodsInfo", "Lorg/json/JSONObject;", "onItemClick", WadlProxyConsts.KEY_JUMP_URL, "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface ECRankCallback {
        void onAddProductToWindow(JSONObject goodsInfo);

        void onItemClick(String jumpUrl, JSONObject goodsInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lorg/json/JSONObject;", "goodsInfo", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxj0/a;", "rankGoodInfo", "", DomainData.DOMAIN_NAME, "Lcom/tencent/pts/core/itemview/PTSItemView;", "E", "Lcom/tencent/pts/core/itemview/PTSItemView;", "ptsItemView", "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;", "rankCallback", "<init>", "(Lcom/tencent/pts/core/itemview/PTSItemView;Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;)V", "G", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final PTSItemView ptsItemView;

        /* renamed from: F, reason: from kotlin metadata */
        private final ECRankCallback rankCallback;

        public a(PTSItemView pTSItemView, ECRankCallback eCRankCallback) {
            super(pTSItemView);
            this.ptsItemView = pTSItemView;
            this.rankCallback = eCRankCallback;
        }

        private final IPTSLiteEventListener m(JSONObject goodsInfo) {
            return new b(goodsInfo);
        }

        public final void n(RankGoodsInfo rankGoodInfo) {
            JSONObject jsonData = rankGoodInfo.getJsonData();
            if (jsonData == null) {
                jsonData = new JSONObject();
            }
            PTSComposer ptsComposer = rankGoodInfo.getPtsComposer();
            if (ptsComposer != null) {
                ptsComposer.layoutToView(this.ptsItemView, m(jsonData));
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$a$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b extends e {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ JSONObject f103924b;

            b(JSONObject jSONObject) {
                this.f103924b = jSONObject;
            }

            @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
            public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
                String str;
                if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                    return;
                }
                cg0.a.b("ECSalesRankRepo", "[onTapEventTriggered] " + str);
                int hashCode = str.hashCode();
                if (hashCode != -931150290) {
                    if (hashCode == -642207339 && str.equals("rank_cell")) {
                        if (identifier == null) {
                            cg0.a.b("ECRankViewHolder", "[initPTSEventListener] add product error with identifier == null");
                            return;
                        }
                        cg0.a.b("ECRankViewHolder", "[onTapEventTriggered] goodsInfo = " + this.f103924b);
                        a.this.rankCallback.onAddProductToWindow(this.f103924b);
                        return;
                    }
                    return;
                }
                if (str.equals("allInOneJump")) {
                    String str2 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                    if (str2 == null) {
                        str2 = "";
                    }
                    cg0.a.b("ECRankViewHolder", "[onTapEventTriggered] jumpUrl = " + str2 + ", goodsInfo = " + this.f103924b);
                    if (str2.length() == 0) {
                        return;
                    }
                    a.this.rankCallback.onItemClick(str2, this.f103924b);
                }
            }
        }
    }

    public ECRankRecycleViewAdapter(Context context, ECSalesRankRepo.SalesRankType salesRankType, ECRankCallback eCRankCallback, String str) {
        this.context = context;
        this.rankType = salesRankType;
        this.rankCallback = eCRankCallback;
        this.channel = str;
    }

    private final Integer l0(String saasProductId) {
        String str;
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            JSONObject jsonData = ((RankGoodsInfo) obj).getJsonData();
            if (jsonData == null || (str = jsonData.optString("saas_product_id")) == null) {
                str = "";
            }
            if (Intrinsics.areEqual(saasProductId, str)) {
                return Integer.valueOf(i3);
            }
            i3 = i16;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final void i0() {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.dataList);
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.productcenter.ui.adapter.ECRankRecycleViewAdapter$destroyProductComposer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PTSComposer ptsComposer = ((RankGoodsInfo) it.next()).getPtsComposer();
                    if (ptsComposer != null) {
                        ptsComposer.destroy();
                    }
                }
            }
        });
    }

    public final ArrayList<RankGoodsInfo> j0() {
        ArrayList<RankGoodsInfo> arrayList = new ArrayList<>();
        arrayList.addAll(this.dataList);
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        String str;
        RankGoodsInfo k06 = k0(position);
        if (k06 != null) {
            holder.n(k06);
            JSONObject jsonData = k06.getJsonData();
            if (jsonData == null || (str = jsonData.optString("saas_product_id")) == null) {
                str = "";
            }
            if (str.length() > 0) {
                this.productIdMap.put(str, k06);
            }
            c.f431472c.e(this.channel, k06.getJsonData(), this.rankType);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(new PTSItemView(this.context), this.rankCallback);
    }

    public final void o0(String saasProductId) {
        RankGoodsInfo rankGoodsInfo = this.productIdMap.get(saasProductId);
        if (rankGoodsInfo != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_on_sale", true);
            PTSComposer ptsComposer = rankGoodsInfo.getPtsComposer();
            if (ptsComposer != null) {
                ptsComposer.updateData(jSONObject.toString());
            }
        }
        Integer l06 = l0(saasProductId);
        if (l06 == null) {
            notifyDataSetChanged();
        } else {
            notifyItemChanged(l06.intValue());
        }
    }

    public final void setData(List<RankGoodsInfo> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public final RankGoodsInfo k0(int position) {
        if (position < 0 || position >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(position);
    }
}
