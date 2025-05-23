package mw1;

import android.content.res.ColorStateList;
import android.view.View;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lmw1/d;", "Lmw1/c;", "Landroid/view/View;", "view", "Lmw1/b;", "helper", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final d f417709d = new d();

    d() {
    }

    @Override // mw1.c
    public void a(@NotNull View view, @NotNull b helper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (!(view instanceof ShadowFrameLayout)) {
            return;
        }
        ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) view;
        ColorStateList b16 = shadowFrameLayout.b();
        if (b16 != null) {
            ColorStateList b17 = helper.b(b16);
            if (!Intrinsics.areEqual(b17, b16)) {
                shadowFrameLayout.setShadowColor(b17);
            }
        }
        ColorStateList a16 = shadowFrameLayout.a();
        if (a16 != null) {
            ColorStateList b18 = helper.b(a16);
            if (!Intrinsics.areEqual(b18, a16)) {
                shadowFrameLayout.setFillColor(b18);
            }
        }
    }
}
