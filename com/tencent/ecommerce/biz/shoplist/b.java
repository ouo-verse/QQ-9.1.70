package com.tencent.ecommerce.biz.shoplist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.base.list.ISuspendStateListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001$B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\t\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005J!\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00020\u00072\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/shoplist/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/shoplist/b$a;", "Lcom/tencent/ecommerce/base/list/ISuspendStateListAdapter;", "Lcom/tencent/ecommerce/biz/shoplist/a;", "Lkotlin/Function1;", "", "", "listener", "l0", "", "dataList", "setData", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "_data", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onShopItemClickListener", "Landroid/content/Context;", "D", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends RecyclerView.Adapter<a> implements ISuspendStateListAdapter<ECPromoteShopItem> {

    /* renamed from: C, reason: from kotlin metadata */
    private Function1<? super String, Unit> onShopItemClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    public final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<ECPromoteShopItem> _data = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/shoplist/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/biz/shoplist/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "nameTv", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/ecommerce/biz/shoplist/b;Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView nameTv;

        /* renamed from: F, reason: from kotlin metadata */
        public final View view;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.shoplist.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class ViewOnClickListenerC1098a implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ECPromoteShopItem f104441e;

            ViewOnClickListenerC1098a(ECPromoteShopItem eCPromoteShopItem) {
                this.f104441e = eCPromoteShopItem;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Function1 function1 = b.this.onShopItemClickListener;
                if (function1 != null) {
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(View view) {
            super(view);
            this.view = view;
            this.nameTv = (TextView) view.findViewById(R.id.oad);
        }

        public final void l(ECPromoteShopItem item) {
            this.nameTv.setText(item.name);
            this.view.setOnClickListener(new ViewOnClickListenerC1098a(item));
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this._data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        holder.l(this._data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(LayoutInflater.from(this.context).inflate(R.layout.cta, parent, false));
    }

    public final void l0(Function1<? super String, Unit> listener) {
        this.onShopItemClickListener = listener;
    }

    @Override // com.tencent.ecommerce.base.list.ISuspendStateListAdapter
    public Object setData(List<? extends ECPromoteShopItem> list, Continuation<? super Unit> continuation) {
        this._data.clear();
        this._data.addAll(list);
        notifyDataSetChanged();
        return Unit.INSTANCE;
    }
}
