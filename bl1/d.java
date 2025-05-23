package bl1;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.os.Build;
import android.view.View;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\t"}, d2 = {"Lbl1/d;", "", "Landroid/view/View;", "", "enable", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f28604a = new d();

    d() {
    }

    public final void a(@NotNull View view, boolean z16) {
        Boolean bool;
        float f16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.wfc);
        StateListAnimator stateListAnimator = null;
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.valueOf(z16))) {
            return;
        }
        view.setTag(R.id.wfc, Boolean.valueOf(z16));
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        view.setAlpha(f16);
        if (z16 && Build.VERSION.SDK_INT >= 26) {
            stateListAnimator = AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.f155134n);
        }
        view.setStateListAnimator(stateListAnimator);
    }
}
