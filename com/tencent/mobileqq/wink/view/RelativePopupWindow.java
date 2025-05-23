package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.widget.PopupWindowCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes21.dex */
public class RelativePopupWindow extends PopupWindow {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes21.dex */
    public @interface HorizontalPosition {
        public static final int ALIGN_LEFT = 3;
        public static final int ALIGN_RIGHT = 4;
        public static final int CENTER = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes21.dex */
    public @interface VerticalPosition {
        public static final int ABOVE = 1;
        public static final int ALIGN_BOTTOM = 4;
        public static final int ALIGN_TOP = 3;
        public static final int BELOW = 2;
        public static final int CENTER = 0;
    }

    public RelativePopupWindow(Context context) {
        super(context);
    }

    private static int a(int i3) {
        if (i3 != -2) {
            return 1073741824;
        }
        return 0;
    }

    private static int b(int i3, int i16) {
        if (i3 != -1) {
            return View.MeasureSpec.getSize(i3);
        }
        return i16;
    }

    private static int c(int i3, int i16) {
        return View.MeasureSpec.makeMeasureSpec(b(i3, i16), a(i3));
    }

    public void d(@NonNull View view, int i3, int i16, int i17, int i18) {
        e(view, i3, i16, i17, i18, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(@NonNull View view, int i3, int i16, int i17, int i18, boolean z16) {
        int height;
        int width;
        setClippingEnabled(z16);
        View contentView = getContentView();
        Rect rect = new Rect();
        contentView.getWindowVisibleDisplayFrame(rect);
        int width2 = rect.width();
        int height2 = rect.height();
        contentView.measure(c(getWidth(), width2), c(getHeight(), height2));
        int measuredWidth = contentView.getMeasuredWidth();
        int measuredHeight = contentView.getMeasuredHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int height3 = iArr[1] + view.getHeight();
        if (!z16) {
            i17 += iArr[0];
            i18 += height3;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        i18 -= measuredHeight;
                    }
                    if (i16 == 0) {
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 == 4) {
                                    measuredWidth -= view.getWidth();
                                }
                                if (!z16) {
                                    int i19 = i18 + height3;
                                    if (i19 < 0) {
                                        i18 = -height3;
                                    } else if (i19 + measuredHeight > height2) {
                                        i18 = (height2 - height3) - measuredHeight;
                                    }
                                    PopupWindowCompat.showAsDropDown(this, view, i17, i18, 0);
                                    return;
                                }
                                showAtLocation(view, 0, i17, i18);
                                return;
                            }
                            width = view.getWidth();
                        }
                        i17 -= measuredWidth;
                        if (!z16) {
                        }
                    } else {
                        width = (view.getWidth() / 2) - (measuredWidth / 2);
                    }
                    i17 += width;
                    if (!z16) {
                    }
                } else {
                    height = view.getHeight();
                }
            } else {
                height = view.getHeight() + measuredHeight;
            }
        } else {
            height = (view.getHeight() / 2) + (measuredHeight / 2);
        }
        i18 -= height;
        if (i16 == 0) {
        }
        i17 += width;
        if (!z16) {
        }
    }

    public RelativePopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RelativePopupWindow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public RelativePopupWindow() {
    }
}
