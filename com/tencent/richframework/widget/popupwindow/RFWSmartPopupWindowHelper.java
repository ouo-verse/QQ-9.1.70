package com.tencent.richframework.widget.popupwindow;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;

/* loaded from: classes25.dex */
public class RFWSmartPopupWindowHelper {
    private static final int[] mTmpDrawingLocation = new int[2];
    private static final int[] mTmpScreenLocation = new int[2];
    private static final int[] mTmpAppLocation = new int[2];

    public static void findRealTransition(View view, int i3, int i16, int i17, int i18, int[] iArr) {
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        int[] iArr2 = mTmpAppLocation;
        View appRootView = getAppRootView(view);
        appRootView.getLocationOnScreen(iArr2);
        int[] iArr3 = mTmpScreenLocation;
        view.getLocationOnScreen(iArr3);
        int[] iArr4 = mTmpDrawingLocation;
        iArr4[0] = iArr3[0] - iArr2[0];
        iArr4[1] = iArr3[1] - iArr2[1];
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = iArr4[0] + i17;
        layoutParams.y = iArr4[1] + height + i18;
        Rect rect = new Rect();
        appRootView.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = i3;
        layoutParams.height = i16;
        tryFitVertical(layoutParams, i18, i16, height, iArr4[1], iArr3[1], rect.top, rect.bottom);
        tryFitHorizontal(layoutParams, i3, iArr4[0], iArr3[0], rect.left, rect.right);
        iArr[0] = layoutParams.x - iArr4[0];
        iArr[1] = (layoutParams.y - iArr4[1]) - height;
    }

    private static View getAppRootView(View view) {
        return view.getRootView();
    }

    private static void positionInDisplayHorizontal(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19) {
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

    private static void positionInDisplayVertical(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19) {
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

    private static void tryFitHorizontal(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19) {
        int i26 = layoutParams.x + (i17 - i16);
        int i27 = i19 - i26;
        if (i26 >= i18 && i3 <= i27) {
            return;
        }
        positionInDisplayHorizontal(layoutParams, i3, i16, i17, i18, i19);
    }

    private static void tryFitVertical(@NonNull WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        int i28 = layoutParams.y + (i19 - i18);
        int i29 = i27 - i28;
        if (i28 >= i26 && i16 <= i29) {
            return;
        }
        if (i16 <= (i28 - i17) - i26) {
            layoutParams.y = (i18 - i16) + i3;
        } else {
            positionInDisplayVertical(layoutParams, i16, i18, i19, i26, i27);
        }
    }
}
