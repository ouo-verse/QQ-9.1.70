package com.tencent.mobileqq.guild.setting.guildmanage.rule.adapterdelegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.adapterdelegate.GuildSortRuleAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.t;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rz1.SortRuleItemData;
import rz1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildSortRuleAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lrz1/f;", "Lrz1/b;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildSortRuleAdapterDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;", "d", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSortRuleAdapterDelegate extends AbsListItemAdapterDelegate<SortRuleItemData, b, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final t eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R/\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/adapterdelegate/GuildSortRuleAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lrz1/f;", "data", "", "o", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "viewHolder", "E", "Lkotlin/jvm/functions/Function1;", "startDrag", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "orderNumber", "G", "ruleTitle", "Landroid/view/View;", "H", "Landroid/view/View;", "sortView", "itemView", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Function1<RecyclerView.ViewHolder, Unit> startDrag;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView orderNumber;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView ruleTitle;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final View sortView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull View itemView, @NotNull Function1<? super RecyclerView.ViewHolder, Unit> startDrag) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(startDrag, "startDrag");
            this.startDrag = startDrag;
            View findViewById = itemView.findViewById(R.id.f2146013);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.order_number)");
            TextView textView = (TextView) findViewById;
            this.orderNumber = textView;
            View findViewById2 = itemView.findViewById(R.id.f787147t);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.rule_title)");
            this.ruleTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f86944t1);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.sort_view)");
            this.sortView = findViewById3;
            textView.setTypeface(u.f234280a.a());
            findViewById3.setOnLongClickListener(new View.OnLongClickListener() { // from class: qz1.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean m3;
                    m3 = GuildSortRuleAdapterDelegate.a.m(GuildSortRuleAdapterDelegate.a.this, view);
                    return m3;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean m(a this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.startDrag.invoke(this$0);
            return true;
        }

        public final void n(@NotNull SortRuleItemData data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(data, "data");
            this.itemView.setTag(data);
            this.sortView.setTag(data);
            this.orderNumber.setText(String.valueOf(data.getOrder()));
            if (data.getRuleData().getTitle().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.ruleTitle.setText("\u6682\u672a\u8f93\u5165\u89c4\u5219");
                GuildUIUtils.f235378a.b(this.ruleTitle, R.color.qui_common_text_secondary);
            } else {
                this.ruleTitle.setText(data.getRuleData().getTitle());
                GuildUIUtils.f235378a.b(this.ruleTitle, R.color.qui_common_text_primary);
            }
        }

        public final void o(@NotNull SortRuleItemData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.itemView.setTag(data);
            this.sortView.setTag(data);
            this.orderNumber.setText(String.valueOf(data.getOrder()));
        }
    }

    public GuildSortRuleAdapterDelegate(@NotNull t eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull b item, @NotNull List<? extends b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof SortRuleItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull SortRuleItemData item, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.contains(1)) {
            holder.o(item);
        } else {
            holder.n(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f6y, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026sort_item, parent, false)");
        return new a(inflate, this.eventHandler.d());
    }
}
