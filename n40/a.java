package n40;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.qqlive.utils.QQLiveFolderScreenUtil;
import com.tencent.qqlive.common.screen.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001a\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u00a8\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "Landroid/view/View;", "view", "", "b", "Landroid/widget/FrameLayout$LayoutParams;", "oldLp", "a", "", "c", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {
    @NotNull
    public static final FrameLayout.LayoutParams a(@NotNull Context context, @Nullable FrameLayout.LayoutParams layoutParams) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        if (ScreenUtils.getScreenWidth(context) < DisplayUtil.dip2px(context, 390.0f)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!c(context) && !ScreenUtils.maybePadInPortrait(context) && !z16) {
            return layoutParams;
        }
        layoutParams.width = DisplayUtil.dip2px(context, 390.0f);
        layoutParams.height = DisplayUtil.dip2px(context, 844.0f);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public static final void b(@NotNull Context context, @NotNull View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        if (c(context)) {
            float screenHeight = (ScreenUtils.getScreenHeight(context) * 0.4620853f) / DisplayUtil.dip2px(context, 390.0f);
            view.setScaleX(screenHeight);
            view.setScaleY(screenHeight);
        } else {
            if (ScreenUtils.maybePadInPortrait(context)) {
                view.setScaleX(1.5f);
                view.setScaleY(1.5f);
                return;
            }
            float screenWidth = ScreenUtils.getScreenWidth(context) / DisplayUtil.dip2px(context, 390.0f);
            if (screenWidth < 1.0f) {
                view.setScaleX(screenWidth);
                view.setScaleY(screenWidth);
            } else {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }
        }
    }

    private static final boolean c(Context context) {
        return QQLiveFolderScreenUtil.isFolderScreenOpenMode(context);
    }
}
