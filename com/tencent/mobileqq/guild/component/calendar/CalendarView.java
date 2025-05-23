package com.tencent.mobileqq.guild.component.calendar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.component.calendar.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u000289B\u001d\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b5\u00106J(\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002J1\u0010!\u001a\u00020\b2)\u0010 \u001a%\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001aR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/CalendarView;", "Landroidx/recyclerview/widget/RecyclerView;", "Ljava/util/Calendar;", "start", "", "reverse", "Lkotlin/ranges/IntRange;", DownloaderConstant.KEY_RANGE, "", "O", "dayInMonth", "", "Lcom/tencent/mobileqq/guild/component/calendar/d;", "L", "day", "Lkotlin/Pair;", "G", "Lcom/tencent/mobileqq/guild/component/calendar/d$b;", "calendarMonth", "M", "H", "I", "date", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "today", "K", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/tencent/mobileqq/guild/component/calendar/d$a;", "onPickDate", "setOnPickDate", "f", "Z", "getInfinite", "()Z", "setInfinite", "(Z)V", "infinite", tl.h.F, "getShowMonth", "setShowMonth", "showMonth", "Lcom/tencent/mobileqq/guild/component/calendar/b;", "i", "Lcom/tencent/mobileqq/guild/component/calendar/b;", "adapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class CalendarView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean infinite;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean showMonth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.component.calendar.b adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/CalendarView$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "getItemWidth", "()I", "itemWidth", "<init>", "(I)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int itemWidth;

        public b(int i3) {
            this.itemWidth = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int roundToInt;
            int roundToInt2;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            int spanIndex = ((GridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            if (((GridLayoutManager.LayoutParams) layoutParams2).getSpanSize() == 1) {
                float measuredWidth = (((parent.getMeasuredWidth() - parent.getPaddingLeft()) - parent.getPaddingRight()) - (this.itemWidth * 7)) / 6.0f;
                roundToInt = MathKt__MathJVMKt.roundToInt((spanIndex * measuredWidth) / 7);
                outRect.left = roundToInt;
                roundToInt2 = MathKt__MathJVMKt.roundToInt(measuredWidth - (((spanIndex + 1) * measuredWidth) / 7.0f));
                outRect.right = roundToInt2;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/component/calendar/CalendarView$c", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {
        c() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            d dVar = CalendarView.this.adapter.getCurrentList().get(position);
            if (dVar instanceof d.CalendarDay) {
                return 1;
            }
            if (dVar instanceof d.CalendarMonth) {
                return 7;
            }
            if (dVar instanceof d.PlaceHolder) {
                return ((d.PlaceHolder) dVar).getSpanSize();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CalendarView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(CalendarView this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateItemDecorations();
    }

    private final Pair<Calendar, Calendar> G(Calendar day) {
        Object clone = day.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        calendar.setFirstDayOfWeek(1);
        calendar.set(day.get(1), day.get(2), 1);
        Object clone2 = calendar.clone();
        Intrinsics.checkNotNull(clone2, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone2;
        calendar2.set(5, calendar2.getActualMaximum(5));
        return TuplesKt.to(calendar, calendar2);
    }

    private final void H() {
        setAdapter(this.adapter);
    }

    private final void I() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 7);
        gridLayoutManager.setSpanSizeLookup(new c());
        setLayoutManager(gridLayoutManager);
    }

    private final List<d> L(Calendar dayInMonth) {
        Object clone = dayInMonth.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        ArrayList arrayList = new ArrayList();
        Pair<Calendar, Calendar> G = G(calendar);
        Calendar component1 = G.component1();
        Calendar component2 = G.component2();
        d.PlaceHolder.Companion companion = d.PlaceHolder.INSTANCE;
        d.PlaceHolder a16 = companion.a(component1);
        d.PlaceHolder a17 = companion.a(component2);
        if (this.showMonth) {
            arrayList.add(d.CalendarMonth.INSTANCE.a(component1));
        }
        if (a16 != null) {
            arrayList.add(a16);
        }
        int i3 = component1.get(5);
        int i16 = component2.get(5);
        if (i3 <= i16) {
            while (true) {
                calendar.set(5, i3);
                arrayList.add(d.CalendarDay.INSTANCE.a(calendar));
                if (i3 == i16) {
                    break;
                }
                i3++;
            }
        }
        if (a17 != null) {
            arrayList.add(a17);
        }
        return arrayList;
    }

    private final void M(d.CalendarMonth calendarMonth) {
        Object firstOrNull;
        d dVar;
        if (!this.infinite) {
            return;
        }
        List<d> currentList = this.adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) currentList);
        if (Intrinsics.areEqual(calendarMonth, firstOrNull)) {
            O(calendarMonth.a(), true, new IntRange(-3, -1));
            return;
        }
        List<d> currentList2 = this.adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList2, "adapter.currentList");
        ListIterator<d> listIterator = currentList2.listIterator(currentList2.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                dVar = listIterator.previous();
                if (dVar instanceof d.CalendarMonth) {
                    break;
                }
            } else {
                dVar = null;
                break;
            }
        }
        if (Intrinsics.areEqual(calendarMonth, dVar)) {
            P(this, calendarMonth.a(), false, new IntRange(1, 3), 2, null);
        }
    }

    private final void O(Calendar start, boolean reverse, IntRange range) {
        List mutableListOf;
        Object obj;
        List<d> currentList = this.adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "this.adapter.currentList");
        Object[] array = currentList.toArray(new d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        d[] dVarArr = (d[]) array;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(dVarArr, dVarArr.length));
        Calendar today = null;
        if (start != null) {
            obj = start.clone();
        } else {
            obj = null;
        }
        if (obj instanceof Calendar) {
            today = (Calendar) obj;
        }
        if (today == null) {
            today = Calendar.getInstance();
        }
        today.add(2, range.getFirst());
        ArrayList arrayList = new ArrayList();
        int first = range.getFirst();
        int last = range.getLast();
        if (first <= last) {
            while (true) {
                Intrinsics.checkNotNullExpressionValue(today, "today");
                arrayList.addAll(L(today));
                today.add(2, 1);
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        if (!reverse) {
            mutableListOf.addAll(arrayList);
        } else {
            mutableListOf.addAll(0, arrayList);
        }
        this.adapter.submitList(mutableListOf);
    }

    static /* synthetic */ void P(CalendarView calendarView, Calendar calendar, boolean z16, IntRange intRange, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            calendar = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            intRange = new IntRange(-12, 12);
        }
        calendarView.O(calendar, z16, intRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(d.CalendarMonth date) {
        M(date);
    }

    public final void K(@NotNull Calendar today) {
        Intrinsics.checkNotNullParameter(today, "today");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(L(today));
        this.adapter.submitList(arrayList);
    }

    public final void setInfinite(boolean z16) {
        this.infinite = z16;
    }

    public final void setOnPickDate(@Nullable Function2<? super View, ? super d.CalendarDay, Unit> onPickDate) {
        this.adapter.m0(onPickDate);
    }

    public final void setShowMonth(boolean z16) {
        this.showMonth = z16;
    }

    public /* synthetic */ CalendarView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CalendarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.adapter = new com.tencent.mobileqq.guild.component.calendar.b(null, new CalendarView$adapter$1(this), 1, 0 == true ? 1 : 0);
        int c16 = kotlin.g.c(this, 16.0f);
        setPadding(c16, 0, c16, 0);
        setItemAnimator(null);
        H();
        I();
        addItemDecoration(new b(kotlin.g.c(this, 40.0f)));
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.component.calendar.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                CalendarView.D(CalendarView.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }
}
