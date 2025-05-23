package com.tencent.ecommerce.biz.commission.subsidy;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyListAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyListAdapter$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "", "Lorg/json/JSONObject;", "newProfitList", "setData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "subsidyProfitList", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCacheManager", "", "D", "Ljava/lang/String;", "pageName", "<init>", "(Ljava/lang/String;)V", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubsidyListAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: D, reason: from kotlin metadata */
    private final String pageName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<JSONObject> subsidyProfitList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private final PtsComposerCache<JSONObject, Integer> ptsComposerCacheManager = new PtsComposerCache<>(new Function1<JSONObject, Integer>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyListAdapter$ptsComposerCacheManager$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(JSONObject jSONObject) {
            return Integer.valueOf(invoke2(jSONObject));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(JSONObject jSONObject) {
            return jSONObject.hashCode();
        }
    }, new Function1<JSONObject, String>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyListAdapter$ptsComposerCacheManager$2
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(JSONObject jSONObject) {
            return jSONObject.toString();
        }
    }, null, null, 12, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyListAdapter$a;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "Lorg/json/JSONObject;", "a", "Ljava/util/List;", "oldList", "b", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<JSONObject> oldList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final List<JSONObject> newList;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends JSONObject> list, List<? extends JSONObject> list2) {
            this.oldList = list;
            this.newList = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.oldList.get(oldItemPosition), this.newList.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldList.size();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyListAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lorg/json/JSONObject;", "data", "", "l", "Lcom/tencent/pts/core/itemview/PTSItemView;", "E", "Lcom/tencent/pts/core/itemview/PTSItemView;", "ptsItemView", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCacheManager", "<init>", "(Lcom/tencent/pts/core/itemview/PTSItemView;Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final PTSItemView ptsItemView;

        /* renamed from: F, reason: from kotlin metadata */
        private final PtsComposerCache<JSONObject, Integer> ptsComposerCacheManager;

        public b(PTSItemView pTSItemView, PtsComposerCache<JSONObject, Integer> ptsComposerCache) {
            super(pTSItemView);
            this.ptsItemView = pTSItemView;
            this.ptsComposerCacheManager = ptsComposerCache;
        }

        public final void l(JSONObject data) {
            PTSComposer g16 = this.ptsComposerCacheManager.g(data);
            if (g16 != null) {
                g16.layoutToView(this.ptsItemView);
            }
        }
    }

    public ECSubsidyListAdapter(String str) {
        this.pageName = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.subsidyProfitList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        holder.l(this.subsidyProfitList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        return new b(new PTSItemView(parent.getContext()), this.ptsComposerCacheManager);
    }

    public final void setData(final List<? extends JSONObject> newProfitList) {
        PtsComposerCache.i(this.ptsComposerCacheManager, this.pageName, new Function0<List<? extends JSONObject>>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyListAdapter$setData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends JSONObject> invoke() {
                List<? extends JSONObject> list;
                list = ECSubsidyListAdapter.this.subsidyProfitList;
                return list;
            }
        }, new Function0<List<? extends JSONObject>>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyListAdapter$setData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends JSONObject> invoke() {
                return newProfitList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyListAdapter$setData$3
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
                List list;
                List list2;
                List list3;
                list = ECSubsidyListAdapter.this.subsidyProfitList;
                DiffUtil.calculateDiff(new ECSubsidyListAdapter.a(list, newProfitList)).dispatchUpdatesTo(ECSubsidyListAdapter.this);
                list2 = ECSubsidyListAdapter.this.subsidyProfitList;
                list2.clear();
                list3 = ECSubsidyListAdapter.this.subsidyProfitList;
                list3.addAll(newProfitList);
            }
        }, 8, null);
    }
}
