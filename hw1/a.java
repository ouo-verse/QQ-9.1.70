package hw1;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lhw1/a;", "", "Landroid/widget/LinearLayout;", "weekdaysIndicator", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f406504a = new a();

    a() {
    }

    public final void a(@NotNull LinearLayout weekdaysIndicator) {
        IntRange until;
        IntProgression step;
        Intrinsics.checkNotNullParameter(weekdaysIndicator, "weekdaysIndicator");
        List<String> f16 = CalendarEx.f214714a.f();
        until = RangesKt___RangesKt.until(0, weekdaysIndicator.getChildCount());
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return;
        }
        while (true) {
            View childAt = weekdaysIndicator.getChildAt(first);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) childAt).setText(f16.get((((first / 2) + 0) % 7) + 1));
            if (first != last) {
                first += step2;
            } else {
                return;
            }
        }
    }
}
