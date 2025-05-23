package com.tencent.guild.aio.input.at.trooptag.dialogui.delegate;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagGroupAdapterDelegate;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cp0.HashTagGroupData;
import cp0.a;
import cp0.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\u0014J.\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagGroupAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcp0/f;", "Lcp0/a;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagGroupAdapterDelegate$b;", "holder", "", "isCollapse", "", "v", HippyTKDListViewAdapter.X, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "groupData", "", "payloads", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "u", "Lip0/a;", "d", "Lip0/a;", "groupCallback", "<init>", "(Lip0/a;)V", "e", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class HashTagGroupAdapterDelegate extends AbsListItemAdapterDelegate<HashTagGroupData, a, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ip0.a groupCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagGroupAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/LinearLayout;", "subTitleContainer", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "groupContainer", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "groupSubTitle", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "H", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "l", "()Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "collapseIcon", "I", "p", "groupTitle", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout subTitleContainer;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout groupContainer;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView groupSubTitle;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final RFWRoundImageView collapseIcon;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView groupTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.vum);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(co\u2026roup_sub_title_container)");
            this.subTitleContainer = (LinearLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.vuo);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(co\u2026id.group_title_container)");
            this.groupContainer = (LinearLayout) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.vul);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(co\u2026api.R.id.group_sub_title)");
            this.groupSubTitle = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.vto);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(co\u2026d.api.R.id.group_fold_iv)");
            this.collapseIcon = (RFWRoundImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f101905wg);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(co\u2026i.R.id.troop_group_title)");
            this.groupTitle = (TextView) findViewById5;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final RFWRoundImageView getCollapseIcon() {
            return this.collapseIcon;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final LinearLayout getGroupContainer() {
            return this.groupContainer;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getGroupSubTitle() {
            return this.groupSubTitle;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getGroupTitle() {
            return this.groupTitle;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final LinearLayout getSubTitleContainer() {
            return this.subTitleContainer;
        }
    }

    public HashTagGroupAdapterDelegate(@NotNull ip0.a groupCallback) {
        Intrinsics.checkNotNullParameter(groupCallback, "groupCallback");
        this.groupCallback = groupCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(HashTagGroupAdapterDelegate this$0, HashTagGroupData groupData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupData, "$groupData");
        this$0.groupCallback.z(groupData.getType());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(final b holder, final boolean isCollapse) {
        x(holder, isCollapse);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: hp0.c
            @Override // java.lang.Runnable
            public final void run() {
                HashTagGroupAdapterDelegate.w(HashTagGroupAdapterDelegate.b.this, this, isCollapse);
            }
        }, 125L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(b holder, HashTagGroupAdapterDelegate this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = holder.getCollapseIcon().getTag();
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            return;
        }
        this$0.x(holder, z16);
    }

    private final void x(b holder, boolean isCollapse) {
        float f16;
        holder.getCollapseIcon().setImageResource(R.drawable.guild_troop_panel_ic_arrow_expanding);
        RFWRoundImageView collapseIcon = holder.getCollapseIcon();
        if (isCollapse) {
            f16 = -90.0f;
        } else {
            f16 = 0.0f;
        }
        collapseIcon.setRotation(f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof HashTagGroupData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final HashTagGroupData groupData, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(groupData, "groupData");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (QLog.isDebugVersion()) {
            QLog.d("GFT_HashTagGroupAdapterDelegate", 4, "onBindViewHolder payLoads:", payloads);
        }
        holder.itemView.setTag(R.id.wht, groupData);
        holder.getGroupTitle().setText(groupData.getGroupName());
        if (!TextUtils.isEmpty(groupData.getSubGroupName())) {
            holder.getSubTitleContainer().setVisibility(0);
            holder.getGroupSubTitle().setText(groupData.getSubGroupName());
        } else {
            holder.getSubTitleContainer().setVisibility(8);
        }
        List<Integer> a16 = c.f391513a.a(payloads);
        if (!a16.contains(2) && !a16.contains(3)) {
            x(holder, groupData.getIsCollapse());
        } else {
            v(holder, groupData.getIsCollapse());
        }
        QUIListItemBackgroundType b16 = this.groupCallback.b(groupData);
        LinearLayout groupContainer = holder.getGroupContainer();
        Context context = holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.getContext()");
        groupContainer.setBackground(b16.getBackground(context, 1000));
        holder.getGroupContainer().setOnClickListener(new View.OnClickListener() { // from class: hp0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HashTagGroupAdapterDelegate.t(HashTagGroupAdapterDelegate.this, groupData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull HashTagGroupData item, @NotNull b holder, @NotNull List<Object> payloads, int position) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.m(item, holder, payloads, position);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            if (position == 0) {
                marginLayoutParams.topMargin = ViewUtils.dpToPx(5.0f);
            } else {
                marginLayoutParams.topMargin = ViewUtils.dpToPx(16.0f);
            }
            holder.itemView.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.et5, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026roup_item, parent, false)");
        return new b(inflate);
    }
}
