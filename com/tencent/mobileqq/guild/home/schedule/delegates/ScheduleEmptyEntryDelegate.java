package com.tencent.mobileqq.guild.home.schedule.delegates;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.i;
import com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEmptyEntryDelegate;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleEmptyPlaceholderItem;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.widget.GuildEmptyAndActionView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001bB\u001d\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014R%\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00110\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleEmptyEntryDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", "", "l", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleEmptyPlaceholderItem;", "Lkotlin/jvm/functions/Function1;", "j", "()Lkotlin/jvm/functions/Function1;", "action", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ScheduleEmptyEntryDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends d>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<ScheduleEmptyPlaceholderItem, Unit> action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0001'B%\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleEmptyEntryDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleEmptyPlaceholderItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkotlin/Function1;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "getAction", "()Lkotlin/jvm/functions/Function1;", "action", "Lcom/tencent/mobileqq/guild/widget/GuildEmptyAndActionView;", "G", "Lcom/tencent/mobileqq/guild/widget/GuildEmptyAndActionView;", "adminEmptyView", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "userEmptyView", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "timeIcon", "J", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleEmptyPlaceholderItem;", "o", "()Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleEmptyPlaceholderItem;", "setItem", "(Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleEmptyPlaceholderItem;)V", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ViewGroup parent;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Function1<ScheduleEmptyPlaceholderItem, Unit> action;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final GuildEmptyAndActionView adminEmptyView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout userEmptyView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final ImageView timeIcon;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private ScheduleEmptyPlaceholderItem item;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleEmptyEntryDelegate$a$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEmptyEntryDelegate$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final View b(ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.f7m, parent, false);
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull ViewGroup parent, @NotNull Function1<? super ScheduleEmptyPlaceholderItem, Unit> action) {
            super(INSTANCE.b(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(action, "action");
            this.parent = parent;
            this.action = action;
            View findViewById = this.itemView.findViewById(R.id.uu5);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.empty_action_view)");
            GuildEmptyAndActionView guildEmptyAndActionView = (GuildEmptyAndActionView) findViewById;
            this.adminEmptyView = guildEmptyAndActionView;
            guildEmptyAndActionView.setTips("\u6682\u65e0\u65e5\u7a0b\u6d3b\u52a8");
            guildEmptyAndActionView.setActionTv("\u521b\u5efa\u65e5\u7a0b");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            Drawable w3 = GuildUIUtils.w(context, R.drawable.guild_icon_create_schedule, Integer.valueOf(R.color.qui_button_text_secondary_default));
            Intrinsics.checkNotNull(w3);
            guildEmptyAndActionView.setActionIcon(w3);
            guildEmptyAndActionView.setActionListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.delegates.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScheduleEmptyEntryDelegate.a.m(ScheduleEmptyEntryDelegate.a.this, view);
                }
            });
            View findViewById2 = this.itemView.findViewById(R.id.uue);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.empty_non_action_view)");
            LinearLayout linearLayout = (LinearLayout) findViewById2;
            this.userEmptyView = linearLayout;
            View findViewById3 = linearLayout.findViewById(R.id.f97275jy);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "userEmptyView.findViewById(R.id.time_icon)");
            this.timeIcon = (ImageView) findViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.action.invoke(this$0.item);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(@NotNull ScheduleEmptyPlaceholderItem item) {
            int i3;
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
            GuildEmptyAndActionView guildEmptyAndActionView = this.adminEmptyView;
            int i16 = 0;
            if (item.getIsAdmin()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            guildEmptyAndActionView.setVisibility(i3);
            LinearLayout linearLayout = this.userEmptyView;
            if (!(!item.getIsAdmin())) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
            i.a(this.timeIcon, R.drawable.guild_schedule_time_icon, Integer.valueOf(R.color.qui_common_text_secondary_light));
            if (item.getIsAdmin()) {
                bt.d(this.adminEmptyView, "em_sgrp_empty_create_event", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
            }
        }

        @Nullable
        /* renamed from: o, reason: from getter */
        public final ScheduleEmptyPlaceholderItem getItem() {
            return this.item;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduleEmptyEntryDelegate(@NotNull Function1<? super ScheduleEmptyPlaceholderItem, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new a(parent, new Function1<ScheduleEmptyPlaceholderItem, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEmptyEntryDelegate$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScheduleEmptyPlaceholderItem scheduleEmptyPlaceholderItem) {
                invoke2(scheduleEmptyPlaceholderItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ScheduleEmptyPlaceholderItem scheduleEmptyPlaceholderItem) {
                ScheduleEmptyEntryDelegate.this.j().invoke(scheduleEmptyPlaceholderItem);
            }
        });
    }

    @NotNull
    public final Function1<ScheduleEmptyPlaceholderItem, Unit> j() {
        return this.action;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends d> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return items.get(position) instanceof ScheduleEmptyPlaceholderItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends d> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof a) {
            d dVar = items.get(position);
            Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.schedule.models.ScheduleEmptyPlaceholderItem");
            ((a) holder).n((ScheduleEmptyPlaceholderItem) dVar);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
