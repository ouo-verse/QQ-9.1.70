package ol2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.tencent.mobileqq.app.FontSettingManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u000e"}, d2 = {"Lol2/b;", "", "Landroid/view/View;", "view", "", "onlyText", "", h.F, "", "systemDp", "e", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f423097a = new b();

    b() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull View view, int systemDp, boolean onlyText) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ViewGroup) {
            f(view, 0, false, 6, null);
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                a(it.next(), systemDp, onlyText);
            }
            return;
        }
        e(view, systemDp, onlyText);
    }

    public static /* synthetic */ void b(View view, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 18;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        a(view, i3, z16);
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(@Nullable View view) {
        f(view, 0, false, 6, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@Nullable View view, int i3) {
        f(view, i3, false, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@Nullable View view, int systemDp, boolean onlyText) {
        boolean z16;
        if (view == null) {
            return;
        }
        if (FontSettingManager.getFontLevel() == 16.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            h(view, onlyText);
        }
        if (a.c()) {
            a.d(view, systemDp, onlyText);
        }
    }

    public static /* synthetic */ void f(View view, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 18;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        e(view, i3, z16);
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@Nullable View view) {
        i(view, false, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void h(@Nullable View view, boolean onlyText) {
        boolean z16;
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
        float f16 = view.getContext().getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density;
        boolean z17 = true;
        if (f16 == 1.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (f16 != 0.0f) {
                z17 = false;
            }
            if (!z17) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    roundToInt = MathKt__MathJVMKt.roundToInt(layoutParams.width / f16);
                    layoutParams.width = roundToInt;
                    roundToInt2 = MathKt__MathJVMKt.roundToInt(layoutParams.height / f16);
                    layoutParams.height = roundToInt2;
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    roundToInt3 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.leftMargin / f16);
                    marginLayoutParams.leftMargin = roundToInt3;
                    roundToInt4 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.rightMargin / f16);
                    marginLayoutParams.rightMargin = roundToInt4;
                    roundToInt5 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.topMargin / f16);
                    marginLayoutParams.topMargin = roundToInt5;
                    roundToInt6 = MathKt__MathJVMKt.roundToInt(marginLayoutParams.bottomMargin / f16);
                    marginLayoutParams.bottomMargin = roundToInt6;
                }
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    textView.setTextSize(0, textView.getTextSize() / f16);
                }
            }
        }
    }

    public static /* synthetic */ void i(View view, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        h(view, z16);
    }
}
