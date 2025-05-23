package ol2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0007J&\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002\u00a8\u0006\u0011"}, d2 = {"Lol2/a;", "", "", "c", "Landroid/view/View;", "view", "", "systemDp", "onlyText", "", "d", "", "a", "sp", "b", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f423096a = new a();

    a() {
    }

    private final float a() {
        return FontSettingManager.systemMetrics.density;
    }

    private final float b(int sp5) {
        return (a() * sp5) + 0.5f;
    }

    @JvmStatic
    public static final boolean c() {
        return SimpleUIUtil.isNowElderMode();
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@Nullable View view, int systemDp, boolean onlyText) {
        float coerceAtLeast;
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        int roundToInt5;
        int roundToInt6;
        if (view == null) {
            return;
        }
        if (onlyText && !(view instanceof TextView)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            roundToInt = MathKt__MathJVMKt.roundToInt(layoutParams.width * 1.25f);
            layoutParams.width = roundToInt;
            roundToInt2 = MathKt__MathJVMKt.roundToInt(layoutParams.height * 1.25f);
            layoutParams.height = roundToInt2;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            roundToInt3 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.leftMargin * 1.25f);
            marginLayoutParams.leftMargin = roundToInt3;
            roundToInt4 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.rightMargin * 1.25f);
            marginLayoutParams.rightMargin = roundToInt4;
            roundToInt5 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.topMargin * 1.25f);
            marginLayoutParams.topMargin = roundToInt5;
            roundToInt6 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.bottomMargin * 1.25f);
            marginLayoutParams.bottomMargin = roundToInt6;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f423096a.b(systemDp), textView.getTextSize() * 1.25f);
            textView.setTextSize(0, coerceAtLeast);
        }
    }
}
