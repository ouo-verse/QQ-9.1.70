package je0;

import android.content.Context;
import android.graphics.Color;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static boolean a(Context context) {
        return b(context.getColor(R.color.qui_common_bg_bottom_standard));
    }

    private static boolean b(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        if (((int) (fArr[2] * 100.0f)) <= 50) {
            return true;
        }
        return false;
    }
}
