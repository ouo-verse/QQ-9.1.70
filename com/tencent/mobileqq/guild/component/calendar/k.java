package com.tencent.mobileqq.guild.component.calendar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.calendar.d;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/k;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "Landroid/view/View;", "selectionViews", "Landroid/graphics/Canvas;", "c", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDraw", "Lcom/tencent/mobileqq/guild/component/calendar/k$a;", "d", "Lcom/tencent/mobileqq/guild/component/calendar/k$a;", "provider", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "paint", "<init>", "(Lcom/tencent/mobileqq/guild/component/calendar/k$a;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class k extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a provider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/k$a;", "", "Ljava/util/Calendar;", "date", "", "a", "b", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        boolean a(@NotNull Calendar date);

        boolean b(@NotNull Calendar date);
    }

    public k(@NotNull a provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        this.paint = paint;
    }

    private final void a(List<? extends View> selectionViews, Canvas c16) {
        Object first;
        Object last;
        if (selectionViews.isEmpty()) {
            return;
        }
        for (View view : selectionViews) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) view;
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_button_text_secondary_default));
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) selectionViews);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) first;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) selectionViews);
        Intrinsics.checkNotNull(last, "null cannot be cast to non-null type android.widget.TextView");
        c16.drawRoundRect(textView2.getLeft(), textView2.getTop(), ((TextView) last).getRight(), textView2.getBottom(), textView2.getHeight() / 2.0f, textView2.getHeight() / 2.0f, this.paint);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        b bVar;
        float f16;
        Object last;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(c16, parent, state);
        this.paint.setColor(parent.getResources().getColor(R.color.qui_button_bg_secondary_default));
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter instanceof b) {
            bVar = (b) adapter;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        List<d> currentList = bVar.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        int save = c16.save();
        try {
            ArrayList arrayList = new ArrayList();
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View child = parent.getChildAt(i3);
                int childAdapterPosition = parent.getChildAdapterPosition(child);
                if (childAdapterPosition != -1) {
                    d dVar = currentList.get(childAdapterPosition);
                    if (dVar instanceof d.CalendarDay) {
                        if (this.provider.b(dVar.a())) {
                            f16 = 1.0f;
                        } else {
                            f16 = 0.3f;
                        }
                        child.setAlpha(f16);
                        if (!this.provider.a(dVar.a())) {
                            Intrinsics.checkNotNull(child, "null cannot be cast to non-null type android.widget.TextView");
                            ((TextView) child).setTextColor(((TextView) child).getResources().getColorStateList(R.color.qui_common_text_primary));
                        } else {
                            if (!arrayList.isEmpty()) {
                                int top = child.getTop();
                                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                                if (top > ((View) last).getTop()) {
                                    a(arrayList, c16);
                                    arrayList.clear();
                                }
                            }
                            Intrinsics.checkNotNullExpressionValue(child, "child");
                            arrayList.add(child);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                a(arrayList, c16);
            }
        } finally {
            c16.restoreToCount(save);
        }
    }
}
