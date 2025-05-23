package l53;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f413861a = new int[2];

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f413862b = new int[2];

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f413863c = new int[2];

    public static void a(View view, int i3, int i16, int i17, int i18, int[] iArr) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int height = view.getHeight();
        int[] iArr2 = f413863c;
        View b16 = b(view);
        b16.getLocationOnScreen(iArr2);
        int[] iArr3 = f413862b;
        view.getLocationOnScreen(iArr3);
        int[] iArr4 = f413861a;
        int i19 = iArr3[0] - iArr2[0];
        iArr4[0] = i19;
        int i26 = iArr3[1] - iArr2[1];
        iArr4[1] = i26;
        layoutParams.x = i19 + i17;
        layoutParams.y = i26 + height + i18;
        Rect rect = new Rect();
        b16.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = i3;
        layoutParams.height = i16;
        f(layoutParams, i18, i16, height, iArr4[1], iArr3[1], rect.top, rect.bottom);
        e(layoutParams, i3, iArr4[0], iArr3[0], rect.left, rect.right);
        int i27 = layoutParams.x - iArr4[0];
        iArr[0] = i27;
        int i28 = (layoutParams.y - iArr4[1]) - height;
        iArr[1] = i28;
        if (i27 != i17 || i28 != i18) {
            QLog.d("QUIBubbleTip", 1, "window moved. old: x | " + i17 + ", y | " + i18 + ". new: x | " + iArr[0] + ", y | " + iArr[1]);
        }
    }

    private static View b(View view) {
        return view.getRootView();
    }

    private static void c(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19) {
        int i26 = i17 - i16;
        int i27 = layoutParams.x + i26;
        layoutParams.x = i27;
        int i28 = i3 + i27;
        if (i28 > i19) {
            layoutParams.x = i27 - (i28 - i19);
        }
        if (layoutParams.x < i18) {
            layoutParams.x = i18;
        }
        layoutParams.x -= i26;
    }

    private static void d(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19) {
        int i26 = i17 - i16;
        int i27 = layoutParams.y + i26;
        layoutParams.y = i27;
        layoutParams.height = i3;
        int i28 = i3 + i27;
        if (i28 > i19) {
            layoutParams.y = i27 - (i28 - i19);
        }
        if (layoutParams.y < i18) {
            layoutParams.y = i18;
        }
        layoutParams.y -= i26;
    }

    private static void e(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19) {
        int i26 = layoutParams.x + (i17 - i16);
        int i27 = i19 - i26;
        if (i26 >= i18 && i3 <= i27) {
            return;
        }
        c(layoutParams, i3, i16, i17, i18, i19);
    }

    private static void f(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        int i28 = layoutParams.y + (i19 - i18);
        int i29 = i27 - i28;
        if (i28 >= i26 && i16 <= i29) {
            return;
        }
        if (i16 <= (i28 - i17) - i26) {
            layoutParams.y = (i18 - i16) + i3;
        } else {
            d(layoutParams, i16, i18, i19, i26, i27);
        }
    }
}
