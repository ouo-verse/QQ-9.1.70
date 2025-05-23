package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class av {
    public static void a(ViewGroup viewGroup, View... viewArr) {
        int i3;
        int i16;
        if (viewArr != null && viewArr.length != 0) {
            if (!QQTheme.isNowSimpleUI()) {
                if (QLog.isColorLevel()) {
                    QLog.d("SimpleUIFixHelper", 2, "updateBottomBarIconPaddingForSimple no simple");
                    return;
                }
                return;
            }
            int i17 = 0;
            for (View view : viewArr) {
                if (view != null && view.getVisibility() == 0) {
                    i17++;
                }
            }
            int dip2px = ViewUtils.dip2px(48.0f);
            int screenWidth = (ViewUtils.getScreenWidth() - (i17 * dip2px)) / (viewArr.length + 1);
            int i18 = screenWidth / 2;
            int length = viewArr.length - 1;
            if (viewGroup != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                layoutParams.height = dip2px;
                viewGroup.setLayoutParams(layoutParams);
            }
            for (int i19 = length; i19 >= 0; i19--) {
                View view2 = viewArr[i19];
                if (view2 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                    if (i19 == 0) {
                        i3 = screenWidth;
                    } else {
                        i3 = i18;
                    }
                    marginLayoutParams.leftMargin = i3;
                    if (i19 == length) {
                        i16 = screenWidth;
                    } else {
                        i16 = i18;
                    }
                    marginLayoutParams.rightMargin = i16;
                    marginLayoutParams.width = dip2px;
                    marginLayoutParams.height = dip2px;
                    if (marginLayoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) marginLayoutParams).weight = 0.0f;
                    }
                    viewArr[i19].setLayoutParams(marginLayoutParams);
                    View view3 = viewArr[i19];
                    if (view3 instanceof ImageView) {
                        ((ImageView) view3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    }
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SimpleUIFixHelper", 2, "updateBottomBarIconPaddingForSimple no views");
        }
    }
}
