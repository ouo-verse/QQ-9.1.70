package com.tencent.mobileqq.guild.component.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.tencent.mobileqq.guild.component.calendar.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001'BL\u0012+\b\u0002\u0010\u001a\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b\u00a2\u0006\u0004\b$\u0010%J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016RE\u0010\u001a\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/b;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/guild/component/calendar/d;", "Lcom/tencent/mobileqq/guild/component/calendar/i;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "j0", "getItemViewType", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/tencent/mobileqq/guild/component/calendar/d$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "getOnPickDate", "()Lkotlin/jvm/functions/Function2;", "m0", "(Lkotlin/jvm/functions/Function2;)V", "onPickDate", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/component/calendar/d$b;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "getOnReachMonth", "()Lkotlin/jvm/functions/Function1;", "setOnReachMonth", "(Lkotlin/jvm/functions/Function1;)V", "onReachMonth", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "D", "b", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends ListAdapter<d, i<d>> {

    @NotNull
    private static final a E = new a();

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<? super d.CalendarMonth, Unit> onReachMonth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super View, ? super d.CalendarDay, Unit> onPickDate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/component/calendar/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/component/calendar/d;", "p0", "p1", "", "b", "a", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends DiffUtil.ItemCallback<d> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull d p06, @NotNull d p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull d p06, @NotNull d p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (p06.getType() == p16.getType() && p06.getId() == p16.getId()) {
                return true;
            }
            return false;
        }
    }

    public b() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(b this$0, d item, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<? super View, ? super d.CalendarDay, Unit> function2 = this$0.onPickDate;
        if (function2 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Intrinsics.checkNotNullExpressionValue(item, "item");
            function2.invoke(it, item);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        d dVar = getCurrentList().get(position);
        if (dVar instanceof d.CalendarDay) {
            return 0;
        }
        if (dVar instanceof d.CalendarMonth) {
            return 1;
        }
        if (dVar instanceof d.PlaceHolder) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull i<d> holder, int position) {
        Function1<? super d.CalendarMonth, Unit> function1;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final d item = getCurrentList().get(position);
        if (item instanceof d.CalendarDay) {
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.component.calendar.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.k0(b.this, item, view);
                }
            });
        } else if ((item instanceof d.CalendarMonth) && (function1 = this.onReachMonth) != null) {
            function1.invoke(item);
        }
        Intrinsics.checkNotNullExpressionValue(item, "item");
        holder.l(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public i<d> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1) {
                if (viewType == 2) {
                    return new g(parent);
                }
                throw new IllegalArgumentException("unknown view type");
            }
            return new f(parent);
        }
        return new c(parent);
    }

    public final void m0(@Nullable Function2<? super View, ? super d.CalendarDay, Unit> function2) {
        this.onPickDate = function2;
    }

    public /* synthetic */ b(Function2 function2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function2, (i3 & 2) != 0 ? null : function1);
    }

    public b(@Nullable Function2<? super View, ? super d.CalendarDay, Unit> function2, @Nullable Function1<? super d.CalendarMonth, Unit> function1) {
        super(E);
        this.onPickDate = function2;
        this.onReachMonth = function1;
    }
}
