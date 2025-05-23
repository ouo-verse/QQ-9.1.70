package gs;

import android.graphics.Color;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f403257a = {"#000000", "#FFFFFF", "#DF382C", "#F09A37", "#83D754", "#3478F6", "#7ED5F8", "#F7E368", "#E8519C"};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f403258b = {R.drawable.fhp, R.drawable.fhn, R.drawable.fhq, R.drawable.fho, R.drawable.fht, R.drawable.fhs, R.drawable.fhw, R.drawable.fhr, R.drawable.fhu};

    public static int b(boolean z16) {
        String str;
        if (z16) {
            str = f403257a[2];
        } else {
            str = f403257a[1];
        }
        return Color.parseColor(str);
    }
}
