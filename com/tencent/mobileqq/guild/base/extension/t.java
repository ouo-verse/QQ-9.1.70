package com.tencent.mobileqq.guild.base.extension;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnyRes;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001aF\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0000\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u0001\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u000f\u001a\n\u0010\u0011\u001a\u00020\u000f*\u00020\u0000\"#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u001a\u001a\u00020\r*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0019\"\u001f\u0010\u001d\u001a\u00020\r\"\b\b\u0000\u0010\u001b*\u00020\u0000*\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019\"\u0015\u0010 \u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2 = {"Landroid/view/View;", "", "leftMargin", "rightMargin", "topMargin", "bottomMargin", "width", "height", "", "f", "Landroid/graphics/Bitmap;", tl.h.F, "resId", "", "e", "", "i", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Runnable;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "getRunnableMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "runnableMap", "(Landroid/view/View;)Ljava/lang/String;", "layoutDesc", "T", "b", "scrollableDesc", "c", "(Landroid/view/View;)I", "visibleHeight", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, Runnable> f214744a = new ConcurrentHashMap<>();

    @NotNull
    public static final String a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return "[\u23b4" + view.getTop() + ",\u23b5" + view.getBottom() + "][\u2194" + view.getMeasuredWidth() + ", \u2195" + view.getMeasuredHeight() + ']';
    }

    @NotNull
    public static final <T extends View> String b(@NotNull T t16) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        String str = "\u2193(" + i(t16.canScrollVertically(-1)) + ") \u2191(" + i(t16.canScrollVertically(1)) + ") \u2192(" + i(t16.canScrollHorizontally(-1)) + ") \u2190(" + i(t16.canScrollHorizontally(1)) + ')';
        if (t16 instanceof RecyclerView) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('[');
            RecyclerView recyclerView = (RecyclerView) t16;
            sb5.append(recyclerView.computeHorizontalScrollOffset());
            sb5.append(',');
            sb5.append(recyclerView.computeVerticalScrollOffset());
            sb5.append("] ");
            sb5.append(str);
            return sb5.toString();
        }
        return '[' + t16.getScrollX() + ',' + t16.getScrollY() + "] " + str;
    }

    public static final int c(@NotNull View view) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    public static final boolean d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets == null || !rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String e(@NotNull View view, @AnyRes int i3) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(view.getResources().getResourceEntryName(view.getId()));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = "unknown(" + view.getId() + ')';
        }
        return (String) m476constructorimpl;
    }

    public static final void f(@NotNull View view, int i3, int i16, int i17, int i18, int i19, int i26) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (i3 != -1) {
            marginLayoutParams.leftMargin = i3;
        }
        if (i16 != -1) {
            marginLayoutParams.rightMargin = i16;
        }
        if (i17 != -1) {
            marginLayoutParams.topMargin = i17;
        }
        if (i18 != -1) {
            marginLayoutParams.bottomMargin = i18;
        }
        if (i19 != -10) {
            marginLayoutParams.width = i19;
        }
        if (i26 != -10) {
            marginLayoutParams.height = i26;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static /* synthetic */ void g(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, Object obj) {
        if ((i27 & 1) != 0) {
            i3 = -1;
        }
        if ((i27 & 2) != 0) {
            i16 = -1;
        }
        if ((i27 & 4) != 0) {
            i17 = -1;
        }
        if ((i27 & 8) != 0) {
            i18 = -1;
        }
        if ((i27 & 16) != 0) {
            i19 = -10;
        }
        if ((i27 & 32) != 0) {
            i26 = -10;
        }
        f(view, i3, i16, i17, i18, i19, i26);
    }

    @NotNull
    public static final Bitmap h(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    public static final int i(boolean z16) {
        return z16 ? 1 : 0;
    }
}
