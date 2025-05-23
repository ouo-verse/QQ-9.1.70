package be3;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import be3.q;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B5\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0017\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lbe3/q;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemViewType", "getItemCount", "", "Lzv4/c;", "newDataList", "addData", "getData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onSuitCardClick", "Lzd3/a;", "D", "Lzd3/a;", "dtReporter", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lzd3/a;)V", "E", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class q extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Function1<zv4.c, Unit> onSuitCardClick;

    /* renamed from: D, reason: from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<zv4.c> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017\u00a8\u0006!"}, d2 = {"Lbe3/q$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lzv4/c;", "ugcStoreItem", "", "o", "", "position", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "clothIgv", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "clothDesc", "H", "price", "I", "debugTv", "Landroid/view/View;", "itemView", "<init>", "(Lbe3/q;Landroid/view/View;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private zd3.a dtReporter;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView clothIgv;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView clothDesc;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView price;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView debugTv;
        final /* synthetic */ q J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q qVar, View itemView, zd3.a aVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.J = qVar;
            this.dtReporter = aVar;
            View findViewById = itemView.findViewById(R.id.pke);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.cloth_igv)");
            this.clothIgv = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.pkd);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.cloth_desc)");
            this.clothDesc = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.pkh);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.cloth_price)");
            this.price = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.pog);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.debugTxv)");
            this.debugTv = (TextView) findViewById4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(q this$0, zv4.c ugcStoreItem, b this$1, Map pageParams, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(ugcStoreItem, "$ugcStoreItem");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(pageParams, "$pageParams");
            if (hf0.a.b("UGCCustomColorSuitAdapter" + it.getId(), 500L)) {
                return;
            }
            this$0.onSuitCardClick.invoke(ugcStoreItem);
            zd3.a aVar = this$1.dtReporter;
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.t(it, "em_zplan_mall_item", pageParams);
            }
        }

        private final void o(zv4.c ugcStoreItem) {
            if (j74.b.f409622a.c()) {
                this.debugTv.setVisibility(0);
                this.debugTv.setText(String.valueOf(ugcStoreItem.f453570b.f440275b));
            } else {
                this.debugTv.setVisibility(4);
            }
        }

        public void m(final zv4.c ugcStoreItem, int position) {
            Intrinsics.checkNotNullParameter(ugcStoreItem, "ugcStoreItem");
            String clothUrl = ugcStoreItem.f453570b.f440279f;
            com.tencent.mobileqq.zplan.aigc.utils.a aVar = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a;
            Intrinsics.checkNotNullExpressionValue(clothUrl, "clothUrl");
            if (aVar.g(clothUrl)) {
                ImageView imageView = this.clothIgv;
                Context context = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "clothIgv.context");
                imageView.setImageDrawable(URLDrawable.getDrawable(clothUrl, aVar.b(context)));
            }
            this.clothDesc.setText(ugcStoreItem.f453570b.f440277d);
            TextView textView = this.price;
            t74.m mVar = t74.m.f435564a;
            AssetManager assets = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            textView.setTypeface(mVar.b(assets));
            this.price.setText(" " + String.valueOf(ugcStoreItem.f453571c));
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_item_id", String.valueOf(ugcStoreItem.f453570b.f440275b));
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 != null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                zd3.a.y(aVar2, itemView, "em_zplan_mall_item", linkedHashMap, null, 8, null);
            }
            View view = this.itemView;
            final q qVar = this.J;
            view.setOnClickListener(new View.OnClickListener() { // from class: be3.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    q.b.n(q.this, ugcStoreItem, this, linkedHashMap, view2);
                }
            });
            o(ugcStoreItem);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(List<zv4.c> dataList, Function1<? super zv4.c, Unit> onSuitCardClick, zd3.a aVar) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(onSuitCardClick, "onSuitCardClick");
        this.dataList = dataList;
        this.onSuitCardClick = onSuitCardClick;
        this.dtReporter = aVar;
    }

    public final void addData(List<zv4.c> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        int size = this.dataList.size();
        this.dataList.addAll(newDataList);
        notifyItemRangeInserted(size, newDataList.size());
    }

    public final List<zv4.c> getData() {
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getItemViewType() == 1) {
            ((b) holder).m(this.dataList.get(position), position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        QLog.i("UGCCustomColorSuitAdapter", 1, "viewType: " + viewType);
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167466dh0, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new b(this, view, this.dtReporter);
        }
        throw new IllegalArgumentException("Invalid view type");
    }
}
