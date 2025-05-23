package com.tencent.mobileqq.guild.home.schedule.delegates.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.home.schedule.delegates.datepicker.DayItemDelegate;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
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
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u001d2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001e\u001fB\u001b\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/datepicker/DayItemDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "Lcom/tencent/mobileqq/guild/home/schedule/delegates/datepicker/DayItemDelegate$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function1;", "", "d", "Lkotlin/jvm/functions/Function1;", "getOnPickDate", "()Lkotlin/jvm/functions/Function1;", "onPickDate", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DayItemDelegate extends AbsListItemAdapterDelegate<a.CalendarDay, a, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Long, Unit> onPickDate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/datepicker/DayItemDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "", "state", "p", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "textView", UserInfo.SEX_FEMALE, "I", "getState", "()I", "setState", "(I)V", "G", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", "setItem", "(Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    @SuppressLint({"ClickableViewAccessibility"})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: F, reason: from kotlin metadata */
        private int state;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private a.CalendarDay item;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/datepicker/DayItemDelegate$b$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.delegates.datepicker.DayItemDelegate$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final View a(@NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ett, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026endar_day, parent, false)");
                return inflate;
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ViewGroup parent) {
            super(INSTANCE.a(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            View findViewById = this.itemView.findViewById(R.id.jfo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.textView)");
            this.textView = (TextView) findViewById;
        }

        public final void l(@NotNull a.CalendarDay item) {
            Intrinsics.checkNotNullParameter(item, "item");
            Logger.f235387a.d().i("Guild.sch.DayItemDelegate", 1, "bindItem " + item + " " + CalendarExKt.b(item.a()));
            this.item = item;
            p(item.getState());
            this.textView.setText(String.valueOf(item.getDay()));
        }

        @Nullable
        /* renamed from: m, reason: from getter */
        public final a.CalendarDay getItem() {
            return this.item;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }

        public final void p(int state) {
            this.state = state;
            if ((state & 3) == 3) {
                TextView textView = this.textView;
                textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_button_text_primary_default));
                this.textView.setBackgroundResource(R.drawable.guild_background_round_button_bg_primary);
                return;
            }
            if ((state & 1) == 1) {
                TextView textView2 = this.textView;
                textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.qui_button_bg_primary_default));
            } else {
                TextView textView3 = this.textView;
                textView3.setTextColor(textView3.getContext().getResources().getColor(R.color.qui_common_text_primary));
            }
            if ((state & 4) == 4) {
                this.textView.setBackgroundResource(R.drawable.guild_background_round_transparent_with_button_bg_primary_default_p50_stroke);
            } else if ((state & 8) == 8) {
                this.textView.setBackgroundResource(R.drawable.guild_background_round_transparent_with_tertiary_stroke);
            } else {
                this.textView.setBackground(null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DayItemDelegate(@NotNull Function1<? super Long, Unit> onPickDate) {
        Intrinsics.checkNotNullParameter(onPickDate, "onPickDate");
        this.onPickDate = onPickDate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(b this_apply, DayItemDelegate this$0, View view) {
        Long l3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            a.CalendarDay item = this_apply.getItem();
            if (item != null) {
                l3 = Long.valueOf(item.getTimeMs());
            } else {
                l3 = null;
            }
            if (l3 != null) {
                Logger.f235387a.d().i("Guild.sch.DayItemDelegate", 1, "onClick: " + this_apply.getItem());
                this$0.onPickDate.invoke(l3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof a.CalendarDay;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull a.CalendarDay item, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.l(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        final b bVar = new b(parent);
        bVar.getTextView().setOnClickListener(new View.OnClickListener() { // from class: xo1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DayItemDelegate.s(DayItemDelegate.b.this, this, view);
            }
        });
        return bVar;
    }
}
