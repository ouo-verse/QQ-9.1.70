package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.ecommerce.base.list.ISuspendStateListAdapter;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001CB\u0017\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010?\u001a\u00020\u0005\u00a2\u0006\u0004\b@\u0010AJ\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J!\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001aj\b\u0012\u0004\u0012\u00020\u0005`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!Ru\u00100\u001aU\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050(\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\n\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/a;", "Lcom/tencent/ecommerce/base/list/ISuspendStateListAdapter;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", "", "Lorg/json/JSONObject;", "p0", "", "dataList", "", "setData", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "l0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "_data", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashSet;", "reportedOrderIds", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "D", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "_ptsComposerCache", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "eventType", "itemJSONObject", "", "dataMap", "E", "Lkotlin/jvm/functions/Function3;", "k0", "()Lkotlin/jvm/functions/Function3;", "o0", "(Lkotlin/jvm/functions/Function3;)V", "ptsClickListener", "Lkotlin/Function1;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "getPtsCardExposureListener", "()Lkotlin/jvm/functions/Function1;", "n0", "(Lkotlin/jvm/functions/Function1;)V", "ptsCardExposureListener", "Landroid/content/Context;", "G", "Landroid/content/Context;", "context", "H", "Ljava/lang/String;", "ptsPageName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "I", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderListAdapter extends RecyclerView.Adapter<a> implements ISuspendStateListAdapter<ECOrderListItem> {

    /* renamed from: E, reason: from kotlin metadata */
    private Function3<? super String, ? super JSONObject, ? super Map<String, String>, Unit> ptsClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private Function1<? super ECOrderListItem, Unit> ptsCardExposureListener;

    /* renamed from: G, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: H, reason: from kotlin metadata */
    private final String ptsPageName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<ECOrderListItem> _data = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private final HashSet<String> reportedOrderIds = new HashSet<>();

    /* renamed from: D, reason: from kotlin metadata */
    private PtsComposerCache<ECOrderListItem, String> _ptsComposerCache = new PtsComposerCache<>(new Function1<ECOrderListItem, String>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListAdapter$_ptsComposerCache$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(ECOrderListItem eCOrderListItem) {
            return eCOrderListItem.getPtsJSONObject().toString();
        }
    }, new Function1<ECOrderListItem, String>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListAdapter$_ptsComposerCache$2
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(ECOrderListItem eCOrderListItem) {
            return eCOrderListItem.getPtsJSONObject().toString();
        }
    }, null, null, 12, null);

    public ECOrderListAdapter(Context context, String str) {
        this.context = context;
        this.ptsPageName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject p0(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this._data.size();
    }

    public final Function3<String, JSONObject, Map<String, String>, Unit> k0() {
        return this.ptsClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        PTSComposer g16 = this._ptsComposerCache.g(this._data.get(position));
        if (g16 != null) {
            g16.layoutToView(holder.ptsItemView, new b());
        }
        String optString = this._data.get(position).getPtsJSONObject().optString("order_id");
        if (this.reportedOrderIds.contains(optString)) {
            return;
        }
        Function1<? super ECOrderListItem, Unit> function1 = this.ptsCardExposureListener;
        if (function1 != null) {
            function1.invoke(this._data.get(position));
        }
        this.reportedOrderIds.add(optString);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(new PTSItemView(parent.getContext()));
    }

    public final void n0(Function1<? super ECOrderListItem, Unit> function1) {
        this.ptsCardExposureListener = function1;
    }

    public final void o0(Function3<? super String, ? super JSONObject, ? super Map<String, String>, Unit> function3) {
        this.ptsClickListener = function3;
    }

    @Override // com.tencent.ecommerce.base.list.ISuspendStateListAdapter
    public Object setData(final List<? extends ECOrderListItem> list, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        PtsComposerCache.i(this._ptsComposerCache, this.ptsPageName, new Function0<List<? extends ECOrderListItem>>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListAdapter$setData$$inlined$suspendCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECOrderListItem> invoke() {
                List<? extends ECOrderListItem> list2;
                list2 = ECOrderListAdapter.this._data;
                return list2;
            }
        }, new Function0<List<? extends ECOrderListItem>>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListAdapter$setData$$inlined$suspendCoroutine$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECOrderListItem> invoke() {
                return list;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListAdapter$setData$$inlined$suspendCoroutine$lambda$3
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
                List list2;
                List list3;
                list2 = this._data;
                list2.clear();
                list3 = this._data;
                list3.addAll(list);
                this.notifyDataSetChanged();
                Continuation.this.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        }, 8, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListAdapter$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {
        b() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            JSONObject jSONObject;
            String str;
            Function3<String, JSONObject, Map<String, String>, Unit> k06;
            String jsonData;
            if (ptsComposer == null || (jsonData = ptsComposer.getJsonData()) == null || (jSONObject = ECOrderListAdapter.this.p0(jsonData)) == null) {
                jSONObject = new JSONObject();
            }
            cg0.a.b("ECOrderListAdapter", "onTapEventTriggered no eventType, dataMap=" + dataMap + ", jsonObject=" + jSONObject);
            if (dataMap == null || (str = dataMap.get("eventType")) == null || (k06 = ECOrderListAdapter.this.k0()) == null) {
                return;
            }
            k06.invoke(str, jSONObject, dataMap);
        }
    }
}
