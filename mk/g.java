package mk;

import android.os.Build;
import android.view.View;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lmk/g;", "", "Landroid/view/View;", "view", "", "color", "", "elevation", "", "isNightTheme", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f416876a = new g();

    g() {
    }

    public final void a(View view, int color, float elevation, boolean isNightTheme) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isNightTheme || !QQTheme.isNowThemeIsNightForQzone()) {
            if (Build.VERSION.SDK_INT >= 28) {
                view.setOutlineAmbientShadowColor(color);
                view.setOutlineSpotShadowColor(color);
            }
            view.setElevation(elevation);
        }
    }
}
