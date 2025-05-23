package ow1;

import android.content.res.ColorStateList;
import android.view.View;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mw1.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Low1/b;", "Lmw1/c;", "Landroid/view/View;", "view", "Lmw1/b;", "helper", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f424214d = new b();

    b() {
    }

    @Override // mw1.c
    public void a(@NotNull View view, @NotNull mw1.b helper) {
        ColorStateList b16;
        ColorStateList b17;
        ColorStateList b18;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (!(view instanceof QUIPageTabBar)) {
            return;
        }
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) view;
        ColorStateList checkedTextColor = qUIPageTabBar.getCheckedTextColor();
        if (checkedTextColor != null && (b18 = helper.b(checkedTextColor)) != checkedTextColor) {
            qUIPageTabBar.setCheckedColor(b18);
        }
        ColorStateList uncheckedTextColor = qUIPageTabBar.getUncheckedTextColor();
        if (uncheckedTextColor != null && (b17 = helper.b(uncheckedTextColor)) != uncheckedTextColor) {
            qUIPageTabBar.setUncheckedColor(b17);
        }
        ColorStateList underlineColor = qUIPageTabBar.getUnderlineColor();
        if (underlineColor != null && (b16 = helper.b(underlineColor)) != underlineColor) {
            qUIPageTabBar.setUnderlineColor(b16);
        }
    }
}
