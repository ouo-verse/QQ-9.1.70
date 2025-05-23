package pm0;

import android.os.Build;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.gdtad.log.GdtLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d {
    public static void a(Window window) {
        ViewGroup viewGroup;
        if (window == null) {
            GdtLog.e("GdtMotiveHippyUtil", "[initWindow] window is null");
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.setFlags(1024, 1024);
        window.setVolumeControlStream(3);
        if (window.getDecorView() instanceof ViewGroup) {
            viewGroup = (ViewGroup) window.getDecorView();
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            GdtLog.e("GdtMotiveHippyUtil", "[initWindow] decorView is null");
        } else {
            viewGroup.setSystemUiVisibility(7942);
        }
    }
}
