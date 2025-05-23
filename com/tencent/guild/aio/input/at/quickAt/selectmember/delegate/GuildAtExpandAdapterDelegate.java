package com.tencent.guild.aio.input.at.quickAt.selectmember.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.GuildAtExpandItemData;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vn0.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/input/at/quickAt/selectmember/delegate/GuildAtExpandAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/data/GuildAtExpandItemData;", "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/data/a;", "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/delegate/GuildAtExpandAdapterDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/delegate/d;", "d", "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/delegate/d;", "control", "<init>", "(Lcom/tencent/guild/aio/input/at/quickAt/selectmember/delegate/d;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAtExpandAdapterDelegate extends AbsListItemAdapterDelegate<GuildAtExpandItemData, com.tencent.guild.aio.input.at.quickAt.selectmember.data.a, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d control;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/at/quickAt/selectmember/delegate/GuildAtExpandAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lvn0/v;", "E", "Lvn0/v;", "l", "()Lvn0/v;", "binding", "<init>", "(Lvn0/v;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final v binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull v binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final v getBinding() {
            return this.binding;
        }
    }

    public GuildAtExpandAdapterDelegate(@NotNull d control) {
        Intrinsics.checkNotNullParameter(control, "control");
        this.control = control;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(GuildAtExpandItemData item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        item.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.guild.aio.input.at.quickAt.selectmember.data.a item, @NotNull List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildAtExpandItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final GuildAtExpandItemData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.getBinding().f442041c.setText("\u5c55\u5f00\u5168\u90e8" + item.b() + "\uff08" + item.j() + "\uff09");
        holder.getBinding().f442041c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAtExpandAdapterDelegate.r(GuildAtExpandItemData.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        v g16 = v.g(LayoutInflater.from(this.control.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new a(g16);
    }
}
