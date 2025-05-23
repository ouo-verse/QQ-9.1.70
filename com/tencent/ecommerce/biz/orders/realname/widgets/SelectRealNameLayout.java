package com.tencent.ecommerce.biz.orders.realname.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.list.IStateListAdapter;
import com.tencent.ecommerce.base.list.UIStateKt;
import com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ&\u0010\b\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aRF\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RF\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010+\u001a\u0004\b\n\u0010-\"\u0004\b9\u0010/R0\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u001f\u001a\u0004\b<\u0010!\"\u0004\b=\u0010#\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout;", "Landroid/widget/LinearLayout;", "Lcom/tencent/ecommerce/base/list/h;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "", "uiState", "selectedUser", "", "e", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "f", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "refreshLayout", "Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$SelectRealNameAdapter;", h.F, "Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$SelectRealNameAdapter;", "adapter", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "addNewAccountView", "Lkotlin/Function1;", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "getOnAccountClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnAccountClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onAccountClickListener", BdhLogUtil.LogTag.Tag_Conn, "getOnAccountDeleteListener", "setOnAccountDeleteListener", "onAccountDeleteListener", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "c", "()Lkotlin/jvm/functions/Function0;", "setOnNewAccountListener", "(Lkotlin/jvm/functions/Function0;)V", "onNewAccountListener", "E", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setLoadMoreToken", "(Ljava/lang/String;)V", "loadMoreToken", UserInfo.SEX_FEMALE, "setOnRetryListener", "onRetryListener", "G", "b", "setOnLoadMoreListener", "onLoadMoreListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "SelectRealNameAdapter", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SelectRealNameLayout extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private Function1<? super RealNameAccount, Unit> onAccountDeleteListener;

    /* renamed from: D, reason: from kotlin metadata */
    private Function0<Unit> onNewAccountListener;

    /* renamed from: E, reason: from kotlin metadata */
    private String loadMoreToken;

    /* renamed from: F, reason: from kotlin metadata */
    private Function0<Unit> onRetryListener;

    /* renamed from: G, reason: from kotlin metadata */
    private Function1<? super String, Unit> onLoadMoreListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ECommercePullRefreshView refreshLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final SelectRealNameAdapter adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView addNewAccountView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<? super RealNameAccount, Unit> onAccountClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u0000 )2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002*+B\u0007\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$SelectRealNameAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$SelectRealNameAdapter$RealNameViewHolder;", "Lcom/tencent/ecommerce/base/list/IStateListAdapter;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "account", "", "o0", "", "dataList", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "k0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "selectedId", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "Lkotlin/Function1;", "D", "Lkotlin/jvm/functions/Function1;", "i0", "()Lkotlin/jvm/functions/Function1;", "m0", "(Lkotlin/jvm/functions/Function1;)V", "onItemClicked", "E", "j0", "n0", "onItemDeleted", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "RealNameViewHolder", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class SelectRealNameAdapter extends RecyclerView.Adapter<RealNameViewHolder> implements IStateListAdapter<RealNameAccount> {

        /* renamed from: D, reason: from kotlin metadata */
        private Function1<? super RealNameAccount, Unit> onItemClicked;

        /* renamed from: E, reason: from kotlin metadata */
        private Function1<? super RealNameAccount, Unit> onItemDeleted;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private String selectedId = "";

        /* renamed from: C, reason: from kotlin metadata */
        private final List<RealNameAccount> dataList = new ArrayList();

        /* compiled from: P */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$SelectRealNameAdapter$RealNameViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isSelected", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "account", "", "l", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "checkImage", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "nameView", "G", "idView", "H", "deleteView", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$SelectRealNameAdapter;Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public final class RealNameViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            private final ImageView checkImage;

            /* renamed from: F, reason: from kotlin metadata */
            private final TextView nameView;

            /* renamed from: G, reason: from kotlin metadata */
            private final TextView idView;

            /* renamed from: H, reason: from kotlin metadata */
            private final TextView deleteView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements View.OnClickListener {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RealNameAccount f103767e;

                a(RealNameAccount realNameAccount) {
                    this.f103767e = realNameAccount;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    Function1<RealNameAccount, Unit> i06 = SelectRealNameAdapter.this.i0();
                    if (i06 != null) {
                        i06.invoke(this.f103767e);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            public RealNameViewHolder(View view) {
                super(view);
                this.checkImage = (ImageView) view.findViewById(R.id.o1b);
                this.nameView = (TextView) view.findViewById(R.id.odw);
                this.idView = (TextView) view.findViewById(R.id.odn);
                this.deleteView = (TextView) view.findViewById(R.id.odi);
            }

            private final String m(String str) {
                CharSequence replaceRange;
                if (str.length() < 14) {
                    return str;
                }
                replaceRange = StringsKt__StringsKt.replaceRange((CharSequence) str, new IntRange(6, 13), (CharSequence) "********");
                return replaceRange.toString();
            }

            public final void l(boolean isSelected, RealNameAccount account) {
                this.itemView.setOnClickListener(new a(account));
                this.checkImage.setVisibility(isSelected ? 0 : 4);
                this.nameView.setText(account.name);
                this.idView.setText(this.itemView.getContext().getString(R.string.wqo) + m(account.identityNumber));
                this.deleteView.setOnClickListener(new SelectRealNameLayout$SelectRealNameAdapter$RealNameViewHolder$bindView$2(this, account));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataList.size();
        }

        public final Function1<RealNameAccount, Unit> i0() {
            return this.onItemClicked;
        }

        public final Function1<RealNameAccount, Unit> j0() {
            return this.onItemDeleted;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(RealNameViewHolder holder, int position) {
            RealNameAccount realNameAccount = this.dataList.get(position);
            holder.l(Intrinsics.areEqual(realNameAccount.id, this.selectedId), realNameAccount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public RealNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RealNameViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cpu, parent, false));
        }

        public final void m0(Function1<? super RealNameAccount, Unit> function1) {
            this.onItemClicked = function1;
        }

        public final void n0(Function1<? super RealNameAccount, Unit> function1) {
            this.onItemDeleted = function1;
        }

        public final void o0(RealNameAccount account) {
            cg0.a.b("SelectRealNameAdapter", "select account: " + account.id);
            this.selectedId = account.id;
        }

        @Override // com.tencent.ecommerce.base.list.IStateListAdapter
        public void setData(List<? extends RealNameAccount> dataList) {
            this.dataList.clear();
            this.dataList.addAll(dataList);
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$3$1", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "", "tag", "", "onRefreshBegin", "onLoadMoreBegin", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements ECommercePullRefreshView.OnRefreshStateListener {
        a() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onLoadMoreBegin() {
            Function1<String, Unit> b16 = SelectRealNameLayout.this.b();
            if (b16 != null) {
                b16.invoke(SelectRealNameLayout.this.getLoadMoreToken());
            }
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshBegin(int tag) {
            Function0<Unit> d16 = SelectRealNameLayout.this.d();
            if (d16 != null) {
                d16.invoke();
            }
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshFinished(boolean z16, int i3) {
            ECommercePullRefreshView.OnRefreshStateListener.a.a(this, z16, i3);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout$4$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function0<Unit> c16 = SelectRealNameLayout.this.c();
            if (c16 != null) {
                c16.invoke();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SelectRealNameLayout(Context context) {
        super(context);
        SelectRealNameAdapter selectRealNameAdapter = new SelectRealNameAdapter();
        this.adapter = selectRealNameAdapter;
        this.loadMoreToken = "";
        LayoutInflater.from(context).inflate(R.layout.ctu, (ViewGroup) this, true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.o8n);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        recyclerView.setAdapter(selectRealNameAdapter);
        Unit unit = Unit.INSTANCE;
        this.recycleView = recyclerView;
        ECStateCenterView eCStateCenterView = (ECStateCenterView) findViewById(R.id.f163103ob2);
        eCStateCenterView.setRetryListener(this.onRetryListener);
        this.stateView = eCStateCenterView;
        ECommercePullRefreshView eCommercePullRefreshView = (ECommercePullRefreshView) findViewById(R.id.o8p);
        eCommercePullRefreshView.setHideFooterIfNoMore(true);
        eCommercePullRefreshView.setOnRefreshStateListener(new a());
        this.refreshLayout = eCommercePullRefreshView;
        TextView textView = (TextView) findViewById(R.id.od5);
        textView.setOnClickListener(new b());
        this.addNewAccountView = textView;
    }

    /* renamed from: a, reason: from getter */
    public final String getLoadMoreToken() {
        return this.loadMoreToken;
    }

    public final Function1<String, Unit> b() {
        return this.onLoadMoreListener;
    }

    public final Function0<Unit> c() {
        return this.onNewAccountListener;
    }

    public final Function0<Unit> d() {
        return this.onRetryListener;
    }

    public final void e(com.tencent.ecommerce.base.list.h<RealNameAccount, String> uiState, RealNameAccount selectedUser) {
        String b16 = uiState.b();
        if (b16 != null) {
            this.loadMoreToken = b16;
        }
        if (selectedUser != null) {
            this.adapter.o0(selectedUser);
        }
        UIStateKt.f(uiState, this.stateView, null, null, 6, null);
        UIStateKt.d(uiState, this.refreshLayout, false, 2, null);
        UIStateKt.b(uiState, this.adapter);
    }

    public final void setLoadMoreToken(String str) {
        this.loadMoreToken = str;
    }

    public final void setOnAccountClickListener(Function1<? super RealNameAccount, Unit> function1) {
        this.onAccountClickListener = function1;
        this.adapter.m0(function1);
    }

    public final void setOnAccountDeleteListener(Function1<? super RealNameAccount, Unit> function1) {
        this.onAccountDeleteListener = function1;
        this.adapter.n0(function1);
    }

    public final void setOnLoadMoreListener(Function1<? super String, Unit> function1) {
        this.onLoadMoreListener = function1;
    }

    public final void setOnNewAccountListener(Function0<Unit> function0) {
        this.onNewAccountListener = function0;
    }

    public final void setOnRetryListener(Function0<Unit> function0) {
        this.onRetryListener = function0;
    }
}
