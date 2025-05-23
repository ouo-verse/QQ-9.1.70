package eq0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Leq0/f;", "Leq0/c;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "g", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends c {
    @Override // eq0.c, eq0.g
    @NotNull
    public View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(context).inflate(R.layout.efd, parent, false);
        x((ConstraintLayout) view);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // eq0.c, eq0.g
    public void f(@Nullable View view) {
        FrameLayout frameLayout;
        if (view != null) {
            v(view);
            ViewGroup viewGroup = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
            if (viewGroup != null && (frameLayout = (FrameLayout) viewGroup.findViewById(R.id.zfr)) != null) {
                frameLayout.addView(view);
            }
        }
    }

    @Override // eq0.c, eq0.g
    public void g(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            w(view);
            ViewGroup viewGroup = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
            if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.zfv)) != null) {
                linearLayout.addView(view);
            }
        }
    }
}
