package l32;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.icgame.framework.exception.ViewIdErrorException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J2\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0013"}, d2 = {"Ll32/e;", "", "Landroid/view/ViewGroup$LayoutParams;", "param", "Landroid/view/ViewGroup;", "findView", "Landroid/view/View;", "view", "", "b", "Landroid/content/Context;", "context", "parentView", "injectView", "", "targetViewId", "a", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f413777a = new e();

    e() {
    }

    private final void b(ViewGroup.LayoutParams param, ViewGroup findView, View view) {
        ViewParent viewParent;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && Intrinsics.areEqual(view.getParent(), findView)) {
            j32.b.f409197a.i("ICGameViewInject", "view is added! " + view);
            return;
        }
        if (param == null) {
            findView.addView(view);
        } else {
            findView.addView(view, param);
        }
    }

    public final void a(@NotNull Context context, @NotNull ViewGroup parentView, @NotNull View injectView, int targetViewId, @Nullable ViewGroup.LayoutParams param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(injectView, "injectView");
        if (e32.a.d() == targetViewId) {
            b(param, parentView, injectView);
            return;
        }
        View findViewById = parentView.findViewById(targetViewId);
        if (findViewById != null && (findViewById instanceof ViewGroup)) {
            b(param, (ViewGroup) findViewById, injectView);
            return;
        }
        e32.c.d(new ViewIdErrorException("findView is " + findViewById + " from R.id." + context.getResources().getResourceEntryName(targetViewId)));
    }
}
