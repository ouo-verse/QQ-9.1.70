package b71;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    public static boolean a(Context context) {
        int i3;
        int i16;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getRealSize(new Point());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        try {
            Field declaredField = Class.forName("android.view.Display").getDeclaredField("mDisplayInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(windowManager.getDefaultDisplay());
            Class<?> cls = Class.forName("android.view.DisplayInfo");
            Field declaredField2 = cls.getDeclaredField("logicalWidth");
            Field declaredField3 = cls.getDeclaredField("logicalHeight");
            declaredField2.setAccessible(true);
            declaredField3.setAccessible(true);
            i3 = declaredField2.getInt(obj);
            i16 = declaredField3.getInt(obj);
        } catch (Exception unused) {
            i3 = displayMetrics.widthPixels;
            i16 = displayMetrics.heightPixels;
        }
        double sqrt = Math.sqrt(Math.pow(i3 / displayMetrics.xdpi, 2.0d) + Math.pow(i16 / displayMetrics.ydpi, 2.0d));
        QLog.i("PadUtils", 1, "width is " + i3 + " height is " + i16 + " screenInches is " + sqrt);
        if (sqrt > 8.5d) {
            return true;
        }
        return false;
    }
}
