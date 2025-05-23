package com.tencent.mobileqq.guild.home.schedule.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.schedule.ScheduleEntryListAdapter;
import com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEntryDelegate;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleInfoItem;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mobileqq.guild.home.schedule.view.GuildScheduleCardView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002'(B)\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0004\b$\u0010%J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleEntryDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "", "position", "", "l", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;", "Lkotlin/jvm/functions/Function1;", "getAction", "()Lkotlin/jvm/functions/Function1;", "action", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "e", "Lkotlin/jvm/functions/Function0;", "getProvideJumpGuildParam", "()Lkotlin/jvm/functions/Function0;", "provideJumpGuildParam", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", h.F, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ScheduleEntryDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends d>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<ScheduleInfoItem, Unit> action;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<JumpGuildParam> provideJumpGuildParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleEntryDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "l", "E", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;", "setItem", "(Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;)V", "Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView;", "getCardView", "()Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView;", "cardView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private ScheduleInfoItem item;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final GuildScheduleCardView cardView;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleEntryDelegate$b$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEntryDelegate$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final View b(ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.f7e, parent, false);
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ViewGroup parent) {
            super(INSTANCE.b(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            View findViewById = this.itemView.findViewById(R.id.f79854_w);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.schedule_card_view)");
            this.cardView = (GuildScheduleCardView) findViewById;
        }

        public final void l(@NotNull ScheduleInfoItem item, @NotNull JumpGuildParam jumpGuildParam) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
            this.item = item;
            GuildScheduleCardView.j(this.cardView, 0, jumpGuildParam, item.getInfo(), null, 8, null);
        }

        @Nullable
        /* renamed from: m, reason: from getter */
        public final ScheduleInfoItem getItem() {
            return this.item;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduleEntryDelegate(@NotNull Function1<? super ScheduleInfoItem, Unit> action, @NotNull Function0<? extends JumpGuildParam> provideJumpGuildParam) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(provideJumpGuildParam, "provideJumpGuildParam");
        this.action = action;
        this.provideJumpGuildParam = provideJumpGuildParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b this_apply, ScheduleEntryDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScheduleInfoItem item = this_apply.getItem();
        if (item != null && !o.c("fastClickGuard")) {
            this$0.action.invoke(item);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        final b bVar = new b(parent);
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.delegates.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduleEntryDelegate.n(ScheduleEntryDelegate.b.this, this, view);
            }
        });
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends d> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return items.get(position) instanceof ScheduleInfoItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends d> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        RecyclerView.Adapter adapter;
        ScheduleEntryListAdapter scheduleEntryListAdapter;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof b) {
            d dVar = items.get(position);
            Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.schedule.models.ScheduleInfoItem");
            ScheduleInfoItem scheduleInfoItem = (ScheduleInfoItem) dVar;
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                Logger.a d16 = logger.d();
                RecyclerView recyclerView = this.recyclerView;
                String str = null;
                if (recyclerView != null) {
                    adapter = recyclerView.getAdapter();
                } else {
                    adapter = null;
                }
                if (adapter instanceof ScheduleEntryListAdapter) {
                    scheduleEntryListAdapter = (ScheduleEntryListAdapter) adapter;
                } else {
                    scheduleEntryListAdapter = null;
                }
                if (scheduleEntryListAdapter != null) {
                    str = scheduleEntryListAdapter.getChannelId();
                }
                d16.d("ScheduleEntryDelegate", 1, " channelId = " + str + ", " + scheduleInfoItem);
            }
            ((b) holder).l(scheduleInfoItem, this.provideJumpGuildParam.invoke());
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
