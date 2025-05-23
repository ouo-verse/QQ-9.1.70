package com.tencent.mobileqq.guild.quicksearch.calendar.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.quicksearch.calendar.delegate.FeedSearchDayItemDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001d\u001eB\u001b\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/delegate/FeedSearchDayItemDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "Lcom/tencent/mobileqq/guild/quicksearch/calendar/delegate/FeedSearchDayItemDelegate$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "getOnPickDate", "()Lkotlin/jvm/functions/Function1;", "onPickDate", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FeedSearchDayItemDelegate extends AbsListItemAdapterDelegate<a.CalendarDay, a, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<a.CalendarDay, Unit> onPickDate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B#\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/delegate/FeedSearchDayItemDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "E", "Lkotlin/jvm/functions/Function1;", "getOnPickDate", "()Lkotlin/jvm/functions/Function1;", "onPickDate", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "textView", "G", "todayView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Function1<a.CalendarDay, Unit> onPickDate;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView todayView;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/delegate/FeedSearchDayItemDelegate$b$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.quicksearch.calendar.delegate.FeedSearchDayItemDelegate$b$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final View a(@NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.eh9, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026_day_item, parent, false)");
                return inflate;
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull ViewGroup parent, @NotNull Function1<? super a.CalendarDay, Unit> onPickDate) {
            super(INSTANCE.a(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(onPickDate, "onPickDate");
            this.onPickDate = onPickDate;
            View findViewById = this.itemView.findViewById(R.id.w18);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.guild_calendar_day_text)");
            this.textView = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.w1_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026uild_calendar_today_text)");
            this.todayView = (TextView) findViewById2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, a.CalendarDay item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onPickDate.invoke(item);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final a.CalendarDay item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.textView.setText(String.valueOf(item.getDay()));
            TextView textView = this.todayView;
            boolean z16 = true;
            int i3 = 0;
            if ((item.getState() & 1) != 1) {
                z16 = false;
            }
            if (!z16) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            this.textView.setBackground(null);
            if ((item.getState() & 4) == 4) {
                TextView textView2 = this.textView;
                textView2.setTextColor(textView2.getResources().getColorStateList(R.color.qui_common_text_primary));
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: gw1.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedSearchDayItemDelegate.b.n(FeedSearchDayItemDelegate.b.this, item, view);
                    }
                });
            } else {
                TextView textView3 = this.textView;
                textView3.setTextColor(textView3.getResources().getColorStateList(R.color.qui_common_text_tertiary));
                this.itemView.setOnClickListener(null);
            }
            if ((item.getState() & 2) == 2) {
                this.textView.setBackgroundResource(R.drawable.guild_share_to_wx_guild_home_join_button);
                TextView textView4 = this.textView;
                textView4.setTextColor(textView4.getResources().getColorStateList(R.color.qui_common_text_allwhite_primary));
                this.todayView.setTextColor(this.textView.getResources().getColorStateList(R.color.qui_common_feedback_normal));
                return;
            }
            this.todayView.setTextColor(this.textView.getResources().getColorStateList(R.color.qui_common_text_tertiary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedSearchDayItemDelegate(@NotNull Function1<? super a.CalendarDay, Unit> onPickDate) {
        Intrinsics.checkNotNullParameter(onPickDate, "onPickDate");
        this.onPickDate = onPickDate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof a.CalendarDay;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull a.CalendarDay item, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.m(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(parent, this.onPickDate);
    }
}
