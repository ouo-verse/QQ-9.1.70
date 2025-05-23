package cy0;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {
    public static int a(@ColorRes int i3) {
        return BaseApplication.getContext().getResources().getColor(i3);
    }

    public static Drawable b(int i3) {
        return BaseApplication.getContext().getResources().getDrawable(i3);
    }

    public static String c(@StringRes int i3) {
        return BaseApplication.getContext().getResources().getString(i3);
    }
}
