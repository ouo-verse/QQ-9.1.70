package com.tencent.mobileqq.guild.media.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.setting.channeldetails.GuildChannelDetailHeadViewNew;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u0007\u00a2\u0006\u0004\b2\u00103J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010!\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010#\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020+0/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/j;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "list", "", "r0", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew;", "guildChannelDetailHeadViewNew", "q0", "Lcom/tencent/mobileqq/guild/media/detail/b;", "handler", "n0", "", "position", "", "getItemId", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "onViewDetachedFromWindow", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "TYPE_INVALID", BdhLogUtil.LogTag.Tag_Conn, "TYPE_SETTING", "D", "TYPE_USER_ACCOUNT", "E", "TYPE_USER", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/detail/b;", "mHandler", "G", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew;", "mChannelDetailHeadViewNew", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/tencent/mobileqq/guild/media/detail/a;", "H", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mAsyncListDiffer", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mDiffCallback", "<init>", "()V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.media.detail.b mHandler;

    /* renamed from: G, reason: from kotlin metadata */
    private GuildChannelDetailHeadViewNew mChannelDetailHeadViewNew;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private AsyncListDiffer<DetailUserListUIItem> mAsyncListDiffer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int TYPE_INVALID = -1;

    /* renamed from: C, reason: from kotlin metadata */
    private final int TYPE_SETTING = 1;

    /* renamed from: D, reason: from kotlin metadata */
    private final int TYPE_USER_ACCOUNT = 2;

    /* renamed from: E, reason: from kotlin metadata */
    private final int TYPE_USER = 3;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private DiffUtil.ItemCallback<DetailUserListUIItem> mDiffCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/j$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew;", "channelDetailHeadViewNew", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(@NotNull GuildChannelDetailHeadViewNew channelDetailHeadViewNew) {
            Intrinsics.checkNotNullParameter(channelDetailHeadViewNew, "channelDetailHeadViewNew");
            View view = this.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).removeAllViews();
            if (channelDetailHeadViewNew.getParent() != null) {
                ViewParent parent = channelDetailHeadViewNew.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(channelDetailHeadViewNew);
            }
            View view2 = this.itemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view2).addView(channelDetailHeadViewNew);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/j$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "realNum", "threshold", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView titleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.z27);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.member_title)");
            this.titleView = (TextView) findViewById;
        }

        public final void l(int realNum, int threshold) {
            String str;
            if (realNum <= 0) {
                this.itemView.setVisibility(8);
                return;
            }
            if (realNum <= threshold) {
                str = String.valueOf(realNum);
            } else {
                str = threshold + Marker.ANY_NON_NULL_MARKER;
            }
            this.titleView.setText(str + "\u4eba\u5728\u8bed\u97f3");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/detail/j$c", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/media/detail/a;", "oldItem", "newItem", "", "b", "a", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends DiffUtil.ItemCallback<DetailUserListUIItem> {
        c() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull DetailUserListUIItem oldItem, @NotNull DetailUserListUIItem newItem) {
            Long l3;
            Long l16;
            String str;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getType() == newItem.getType() && oldItem.getUserInfo().f228101i == newItem.getUserInfo().f228101i && oldItem.getUserInfo().f228112t == newItem.getUserInfo().f228112t && Intrinsics.areEqual(oldItem.getUserInfo().f228095c, newItem.getUserInfo().f228095c) && Intrinsics.areEqual(oldItem.getUserInfo().f228094b, newItem.getUserInfo().f228094b) && oldItem.getUserInfo().f228103k == newItem.getUserInfo().f228103k && oldItem.getUserInfo().f228110r == newItem.getUserInfo().f228110r && oldItem.getUserInfo().f228113u == newItem.getUserInfo().f228113u && oldItem.getUserInfo().B == newItem.getUserInfo().B && Intrinsics.areEqual(oldItem.getUserInfo().f228096d, newItem.getUserInfo().f228096d) && oldItem.getUserInfo().C.getSortKey() == newItem.getUserInfo().C.getSortKey()) {
                IGProRoleManagementTag iGProRoleManagementTag = oldItem.getUserInfo().M;
                String str2 = null;
                if (iGProRoleManagementTag != null) {
                    l3 = Long.valueOf(iGProRoleManagementTag.getRoleId());
                } else {
                    l3 = null;
                }
                IGProRoleManagementTag iGProRoleManagementTag2 = newItem.getUserInfo().M;
                if (iGProRoleManagementTag2 != null) {
                    l16 = Long.valueOf(iGProRoleManagementTag2.getRoleId());
                } else {
                    l16 = null;
                }
                if (Intrinsics.areEqual(l3, l16)) {
                    IGProRoleManagementTag iGProRoleManagementTag3 = oldItem.getUserInfo().M;
                    if (iGProRoleManagementTag3 != null) {
                        str = iGProRoleManagementTag3.getTagName();
                    } else {
                        str = null;
                    }
                    IGProRoleManagementTag iGProRoleManagementTag4 = newItem.getUserInfo().M;
                    if (iGProRoleManagementTag4 != null) {
                        str2 = iGProRoleManagementTag4.getTagName();
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull DetailUserListUIItem oldItem, @NotNull DetailUserListUIItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getType() != j.this.TYPE_USER && newItem.getType() != j.this.TYPE_USER) {
                if (oldItem.getType() == newItem.getType()) {
                    return true;
                }
                return false;
            }
            return Intrinsics.areEqual(oldItem.getUserInfo().f228093a, newItem.getUserInfo().f228093a);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull DetailUserListUIItem oldItem, @NotNull DetailUserListUIItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return newItem;
        }
    }

    public j() {
        AsyncListDiffer<DetailUserListUIItem> asyncListDiffer = new AsyncListDiffer<>(this, this.mDiffCallback);
        this.mAsyncListDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(new AsyncListDiffer.ListListener() { // from class: com.tencent.mobileqq.guild.media.detail.i
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public final void onCurrentListChanged(List list, List list2) {
                j.l0(list, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(List previousList, List list) {
        Intrinsics.checkNotNullParameter(previousList, "previousList");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 1>");
        Iterator it = previousList.iterator();
        while (it.hasNext()) {
            ((DetailUserListUIItem) it.next()).getUserInfo().l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(j this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.media.detail.b bVar = this$0.mHandler;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            bVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bVar.b(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p0(j this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.media.detail.b bVar = this$0.mHandler;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            bVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return bVar.a(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mAsyncListDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        DetailUserListUIItem detailUserListUIItem = this.mAsyncListDiffer.getCurrentList().get(position);
        if (detailUserListUIItem.getType() != this.TYPE_USER) {
            return detailUserListUIItem.getType();
        }
        return Long.parseLong(detailUserListUIItem.getUserInfo().f228093a + detailUserListUIItem.getUserInfo().f228116x);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return this.TYPE_SETTING;
        }
        if (com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a.size() > 0) {
            if (position == 1) {
                return this.TYPE_USER_ACCOUNT;
            }
            return this.TYPE_USER;
        }
        return this.TYPE_INVALID;
    }

    public final void n0(@NotNull com.tencent.mobileqq.guild.media.detail.b handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.mHandler = handler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            ((b) holder).l(com.tencent.mobileqq.guild.media.core.j.c().W(), com.tencent.mobileqq.guild.media.core.j.c().X());
            return;
        }
        if (holder instanceof a) {
            a aVar = (a) holder;
            GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = this.mChannelDetailHeadViewNew;
            if (guildChannelDetailHeadViewNew == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelDetailHeadViewNew");
                guildChannelDetailHeadViewNew = null;
            }
            aVar.l(guildChannelDetailHeadViewNew);
            return;
        }
        if (holder instanceof l) {
            ((l) holder).bindData(this.mAsyncListDiffer.getCurrentList().get(position).getUserInfo());
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.detail.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.o0(j.this, view);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.media.detail.h
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean p06;
                    p06 = j.p0(j.this, view);
                    return p06;
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.TYPE_SETTING) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.eys, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026tem_title, parent, false)");
            return new a(inflate);
        }
        if (viewType == this.TYPE_USER_ACCOUNT) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.eyq, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   \u2026ail_title, parent, false)");
            return new b(inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.eyr, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context)\n   \u2026em_layout, parent, false)");
        return new l(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof l) {
            ((l) holder).resetStatusAndAnim();
        }
    }

    public final void q0(@NotNull GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew) {
        Intrinsics.checkNotNullParameter(guildChannelDetailHeadViewNew, "guildChannelDetailHeadViewNew");
        this.mChannelDetailHeadViewNew = guildChannelDetailHeadViewNew;
    }

    public final void r0(@NotNull List<? extends p> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new DetailUserListUIItem(this.TYPE_SETTING, null, 2, null));
        if (!list.isEmpty()) {
            arrayList.add(1, new DetailUserListUIItem(this.TYPE_USER_ACCOUNT, null, 2, null));
            for (p pVar : list) {
                int i3 = this.TYPE_USER;
                p c16 = pVar.c();
                Intrinsics.checkNotNullExpressionValue(c16, "it.copy()");
                arrayList.add(new DetailUserListUIItem(i3, c16));
            }
        }
        this.mAsyncListDiffer.submitList(arrayList);
    }
}
