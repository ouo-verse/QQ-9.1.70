package com.tencent.mobileqq.guild.client.selectaccount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u001c\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002EFB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00050\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00109\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010A\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00104\u001a\u0004\b?\u00106\"\u0004\b@\u00108\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/client/selectaccount/PlainListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/client/selectaccount/PlainListAdapter$PlainListViewHolder;", "", "position", "", "o0", "", "k0", "j0", "v0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "l0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getMSelectedStr", "()Ljava/lang/String;", "t0", "(Ljava/lang/String;)V", "mSelectedStr", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/client/selectaccount/p;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "u0", "(Lkotlin/jvm/functions/Function1;)V", "onItemClick", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "getMLoadData", "()Lkotlin/jvm/functions/Function0;", "q0", "(Lkotlin/jvm/functions/Function0;)V", "mLoadData", "", "E", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", UserInfo.SEX_FEMALE, "Z", "getMLoading", "()Z", "r0", "(Z)V", "mLoading", "G", "getMIsEnd", "p0", "mIsEnd", "H", "getMNeedPage", "s0", "mNeedPage", "<init>", "()V", "I", "a", "PlainListViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class PlainListAdapter extends RecyclerView.Adapter<PlainListViewHolder> {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mLoading;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsEnd;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mNeedPage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mSelectedStr = "";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Function1<? super p, Unit> onItemClick = new Function1<p, Unit>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.PlainListAdapter$onItemClick$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull p it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(p pVar) {
            invoke2(pVar);
            return Unit.INSTANCE;
        }
    };

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Function0<Unit> mLoadData = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.PlainListAdapter$mLoadData$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<p> data = new ArrayList();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/client/selectaccount/PlainListAdapter$PlainListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "name", "", "showIcon", "", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "mName", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "l", "()Landroid/widget/ImageView;", "mIcon", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class PlainListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Lazy mName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Lazy mIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlainListViewHolder(@NotNull final View itemView) {
            super(itemView);
            Lazy lazy;
            Lazy lazy2;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.PlainListAdapter$PlainListViewHolder$mName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) itemView.findViewById(R.id.ato);
                }
            });
            this.mName = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.PlainListAdapter$PlainListViewHolder$mIcon$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    return (ImageView) itemView.findViewById(R.id.f166793ia2);
                }
            });
            this.mIcon = lazy2;
        }

        private final ImageView l() {
            return (ImageView) this.mIcon.getValue();
        }

        private final TextView m() {
            return (TextView) this.mName.getValue();
        }

        public final void n(@NotNull String name, boolean showIcon) {
            int i3;
            Intrinsics.checkNotNullParameter(name, "name");
            m().setText(name);
            ImageView l3 = l();
            if (showIcon) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            l3.setVisibility(i3);
        }
    }

    private final boolean j0(int position) {
        if (this.data.size() - position < 3) {
            return true;
        }
        return false;
    }

    private final boolean k0() {
        return !this.mIsEnd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(PlainListAdapter this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onItemClick.invoke(this$0.data.get(i3));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0(int position) {
        com.tencent.mobileqq.guild.safety.j.b("PlainListAdapter", "outer mLoading: " + this.mLoading + " | position: " + position + " | data.size: " + this.data.size() + " | isEnd: " + this.mIsEnd);
        if (this.mNeedPage && !this.mLoading && j0(position) && k0()) {
            com.tencent.mobileqq.guild.safety.j.b("PlainListAdapter", "position: " + position + " | data.size: " + this.data.size() + " | isEnd: " + this.mIsEnd);
            this.mLoading = true;
            this.mLoadData.invoke();
            com.tencent.mobileqq.guild.safety.j.b("PlainListAdapter", "data.size: " + this.data.size() + " | isEnd: " + this.mIsEnd);
        }
    }

    private final boolean v0(int position) {
        if (position == 0) {
            if (!Intrinsics.areEqual(this.mSelectedStr, this.data.get(position).getDesc()) && !Intrinsics.areEqual(this.mSelectedStr, "")) {
                return false;
            }
            return true;
        }
        return Intrinsics.areEqual(this.mSelectedStr, this.data.get(position).getDesc());
    }

    @NotNull
    public final List<p> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull PlainListViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        o0(position);
        holder.n(this.data.get(position).getDesc(), v0(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.client.selectaccount.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlainListAdapter.m0(PlainListAdapter.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public PlainListViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f8a, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new PlainListViewHolder(view);
    }

    public final void p0(boolean z16) {
        this.mIsEnd = z16;
    }

    public final void q0(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.mLoadData = function0;
    }

    public final void r0(boolean z16) {
        this.mLoading = z16;
    }

    public final void s0(boolean z16) {
        this.mNeedPage = z16;
    }

    public final void t0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSelectedStr = str;
    }

    public final void u0(@NotNull Function1<? super p, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onItemClick = function1;
    }
}
