package ff1;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\u0013\b\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lff1/a;", "Lff1/b;", "Landroid/view/View;", "view", "", "Landroid/animation/Animator;", "a", "(Landroid/view/View;)[Landroid/animation/Animator;", "", UserInfo.SEX_FEMALE, "mFrom", "<init>", "(F)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float mFrom;

    @JvmOverloads
    public a(float f16) {
        this.mFrom = f16;
    }

    @Override // ff1.b
    @NotNull
    public Animator[] a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, c.f123400v, this.mFrom, 1.0f);
        animator.setDuration(300L);
        animator.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return new Animator[]{animator};
    }

    public /* synthetic */ a(float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16);
    }
}
