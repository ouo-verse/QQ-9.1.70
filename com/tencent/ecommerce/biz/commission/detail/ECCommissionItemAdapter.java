package com.tencent.ecommerce.biz.commission.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B!\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010#\u001a\u00020\u0011\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\nR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "getItemViewType", "", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "billList", "", UinConfigManager.KEY_ADS, "l0", "destroy", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCacheManager", "Landroid/content/Context;", "D", "Landroid/content/Context;", "context", "E", "Ljava/lang/String;", "pageName", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "listener", "<init>", "(Landroid/content/Context;Lcom/tencent/pts/core/lite/IPTSLiteEventListener;Ljava/lang/String;)V", UserInfo.SEX_FEMALE, "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionItemAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final PtsComposerCache<ECBill, String> ptsComposerCacheManager;

    /* renamed from: D, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: E, reason: from kotlin metadata */
    private final String pageName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ECBill> data = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u0082\u0001\u0002\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "data", "", "l", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "a", "b", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a$a;", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class a extends RecyclerView.ViewHolder {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a$a;", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a;", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "data", "", "l", "Lcom/tencent/pts/core/itemview/PTSItemView;", "E", "Lcom/tencent/pts/core/itemview/PTSItemView;", "ptsItemView", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCacheManager", "<init>", "(Lcom/tencent/pts/core/itemview/PTSItemView;Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1047a extends a {

            /* renamed from: E, reason: from kotlin metadata */
            private final PTSItemView ptsItemView;

            /* renamed from: F, reason: from kotlin metadata */
            private final PtsComposerCache<ECBill, String> ptsComposerCacheManager;

            @Override // com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter.a
            public void l(ECBill data) {
                PTSComposer g16 = this.ptsComposerCacheManager.g(data);
                if (g16 != null) {
                    g16.layoutToView(this.ptsItemView);
                }
            }

            public C1047a(PTSItemView pTSItemView, PtsComposerCache<ECBill, String> ptsComposerCache) {
                super(pTSItemView, null);
                this.ptsItemView = pTSItemView;
                this.ptsComposerCacheManager = ptsComposerCache;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a$b;", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter$a;", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "data", "", "l", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b extends a {

            /* renamed from: E, reason: from kotlin metadata */
            private final TextView textView;

            @Override // com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter.a
            public void l(ECBill data) {
                this.textView.setText(data.getData());
            }

            public b(View view) {
                super(view, null);
                this.textView = (TextView) view.findViewById(R.id.o0q);
            }
        }

        a(View view) {
            super(view);
        }

        public abstract void l(ECBill data);

        public /* synthetic */ a(View view, DefaultConstructorMarker defaultConstructorMarker) {
            this(view);
        }
    }

    public ECCommissionItemAdapter(Context context, final IPTSLiteEventListener iPTSLiteEventListener, String str) {
        this.context = context;
        this.pageName = str;
        this.ptsComposerCacheManager = new PtsComposerCache<>(new Function1<ECBill, String>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$ptsComposerCacheManager$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ECBill eCBill) {
                return eCBill.id;
            }
        }, new Function1<ECBill, String>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$ptsComposerCacheManager$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ECBill eCBill) {
                return eCBill.getData();
            }
        }, new Function1<String, IPTSLiteEventListener>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$ptsComposerCacheManager$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IPTSLiteEventListener invoke(String str2) {
                return IPTSLiteEventListener.this;
            }
        }, null, 8, null);
    }

    public final void destroy() {
        PtsComposerCache.i(this.ptsComposerCacheManager, this.pageName, new Function0<List<? extends ECBill>>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$destroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECBill> invoke() {
                List list;
                list = ECCommissionItemAdapter.this.data;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!Intrinsics.areEqual(((ECBill) obj).id, "-1")) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }, new Function0<List<? extends ECBill>>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$destroy$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECBill> invoke() {
                List<? extends ECBill> emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$destroy$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, 8, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return Intrinsics.areEqual(this.data.get(position).id, "-1") ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        holder.l(this.data.get(position));
    }

    public final void l0(final List<ECBill> billList, final String notice) {
        PtsComposerCache.i(this.ptsComposerCacheManager, this.pageName, new Function0<List<? extends ECBill>>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$setData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECBill> invoke() {
                List list;
                list = ECCommissionItemAdapter.this.data;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!Intrinsics.areEqual(((ECBill) obj).id, "-1")) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }, new Function0<List<? extends ECBill>>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$setData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECBill> invoke() {
                return billList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter$setData$3
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
                List mutableList;
                List list;
                List list2;
                List list3;
                if (!(notice.length() == 0)) {
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) billList);
                    mutableList.add(0, new ECBill("-1", notice));
                } else {
                    mutableList = billList;
                }
                list = ECCommissionItemAdapter.this.data;
                DiffUtil.calculateDiff(new b(list, mutableList)).dispatchUpdatesTo(ECCommissionItemAdapter.this);
                list2 = ECCommissionItemAdapter.this.data;
                list2.clear();
                list3 = ECCommissionItemAdapter.this.data;
                list3.addAll(mutableList);
            }
        }, 8, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new a.b(LayoutInflater.from(this.context).inflate(R.layout.cpe, parent, false));
        }
        return new a.C1047a(new PTSItemView(this.context), this.ptsComposerCacheManager);
    }
}
