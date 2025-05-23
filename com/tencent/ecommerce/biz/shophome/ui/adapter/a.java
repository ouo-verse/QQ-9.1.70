package com.tencent.ecommerce.biz.shophome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
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
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001+B\u000f\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\b)\u0010*J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bH\u0016R&\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0011j\b\u0012\u0004\u0012\u00020\u0004`\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R?\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR?\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a$a;", "", "", "newHistoryDataList", "", "setData", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "position", "k0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "historyItemList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "content", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "i0", "()Lkotlin/jvm/functions/Function1;", "m0", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "D", "j0", "n0", "onItemDelClickListener", "Landroid/content/Context;", "E", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends RecyclerView.Adapter<C1091a> {

    /* renamed from: C, reason: from kotlin metadata */
    private Function1<? super String, Unit> onItemClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private Function1<? super String, Unit> onItemDelClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<String> historyItemList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "historyItem", "", "bindData", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "historyText", "Landroid/widget/RelativeLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/RelativeLayout;", "deleteButton", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a;Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.ui.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public final class C1091a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView historyText;

        /* renamed from: F, reason: from kotlin metadata */
        private final RelativeLayout deleteButton;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.shophome.ui.adapter.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class ViewOnClickListenerC1092a implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f104271e;

            ViewOnClickListenerC1092a(String str) {
                this.f104271e = str;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Function1<String, Unit> i06 = a.this.i0();
                if (i06 != null) {
                    i06.invoke(this.f104271e);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.shophome.ui.adapter.a$a$b */
        /* loaded from: classes31.dex */
        public static final class b implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f104273e;

            b(String str) {
                this.f104273e = str;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Function1<String, Unit> j06 = a.this.j0();
                if (j06 != null) {
                    j06.invoke(this.f104273e);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public C1091a(View view) {
            super(view);
            this.historyText = (TextView) view.findViewById(R.id.o_2);
            this.deleteButton = (RelativeLayout) view.findViewById(R.id.o1g);
        }

        public final void bindData(String historyItem) {
            this.historyText.setText(historyItem);
            this.historyText.setOnClickListener(new ViewOnClickListenerC1092a(historyItem));
            this.deleteButton.setOnClickListener(new b(historyItem));
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.historyItemList.size();
    }

    public final Function1<String, Unit> i0() {
        return this.onItemClickListener;
    }

    public final Function1<String, Unit> j0() {
        return this.onItemDelClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C1091a holder, int position) {
        holder.bindData(this.historyItemList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C1091a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new C1091a(LayoutInflater.from(this.context).inflate(R.layout.cuf, parent, false));
    }

    public final void m0(Function1<? super String, Unit> function1) {
        this.onItemClickListener = function1;
    }

    public final void n0(Function1<? super String, Unit> function1) {
        this.onItemDelClickListener = function1;
    }

    public final void setData(List<String> newHistoryDataList) {
        DiffUtil.calculateDiff(new d(newHistoryDataList, new ArrayList(this.historyItemList))).dispatchUpdatesTo(this);
        this.historyItemList.clear();
        this.historyItemList.addAll(newHistoryDataList);
    }
}
