package bp1;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002\u00a8\u0006\u0010"}, d2 = {"Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "e", "", MiniAppConst.MENU_STYLE_DARK, "c", "b", "Landroid/view/Window;", "", "bits", "on", "d", "isDark", "window", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class s {
    private static final void a(boolean z16, Window window) {
        if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor()) {
            Logger.f235387a.d().i("MiscUtils", 1, "forceSetStatusBarTextTheme: " + z16);
            ImmersiveUtils.setStatusTextColorNew(z16, window, false);
        }
    }

    public static final void b(@NotNull Activity activity, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (GuildSplitViewUtils.f235370a.n(activity)) {
            return;
        }
        c(activity, z16);
    }

    public static final void c(@NotNull Activity activity, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SimpleUIUtil.adjustSimpleStatusBar((ImmersiveTitleBar2) null, activity.getWindow());
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        a(z16, window);
    }

    private static final void d(Window window, int i3, boolean z16) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z16) {
            attributes.flags = i3 | attributes.flags;
        } else {
            attributes.flags = (~i3) & attributes.flags;
        }
        window.setAttributes(attributes);
    }

    public static final void e(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window setupTransparentActivityWindow$lambda$0 = activity.getWindow();
        setupTransparentActivityWindow$lambda$0.clearFlags(67108864);
        setupTransparentActivityWindow$lambda$0.addFlags(Integer.MIN_VALUE);
        setupTransparentActivityWindow$lambda$0.getDecorView().setSystemUiVisibility(1280);
        Intrinsics.checkNotNullExpressionValue(setupTransparentActivityWindow$lambda$0, "setupTransparentActivityWindow$lambda$0");
        d(setupTransparentActivityWindow$lambda$0, 67108864, false);
        setupTransparentActivityWindow$lambda$0.setStatusBarColor(0);
    }
}
