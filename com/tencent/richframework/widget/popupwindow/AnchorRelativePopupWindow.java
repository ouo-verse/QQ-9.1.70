package com.tencent.richframework.widget.popupwindow;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes25.dex */
public class AnchorRelativePopupWindow extends PopupWindow {
    private static final List<WeakReference<PopupWindowListener>> sPopupWindowListener = new CopyOnWriteArrayList();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface HorizontalPosition {
        public static final int ALIGN_LEFT = 3;
        public static final int ALIGN_RIGHT = 4;
        public static final int CENTER = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
    }

    /* loaded from: classes25.dex */
    public interface PopupWindowListener {
        void dismiss(PopupWindow popupWindow);

        void show(PopupWindow popupWindow);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface VerticalPosition {
        public static final int ABOVE = 1;
        public static final int ALIGN_BOTTOM = 4;
        public static final int ALIGN_TOP = 3;
        public static final int BELOW = 2;
        public static final int CENTER = 0;
    }

    public AnchorRelativePopupWindow(Context context) {
        super(context);
    }

    private void dispatchVisibilityCallback(boolean z16) {
        for (WeakReference<PopupWindowListener> weakReference : sPopupWindowListener) {
            if (weakReference != null) {
                PopupWindowListener popupWindowListener = weakReference.get();
                if (popupWindowListener == null) {
                    sPopupWindowListener.remove(weakReference);
                } else if (z16) {
                    popupWindowListener.show(this);
                } else {
                    popupWindowListener.dismiss(this);
                }
            }
        }
    }

    private static int getDropDownMeasureSpecMode(int i3) {
        if (i3 != -2) {
            return 1073741824;
        }
        return 0;
    }

    private static int getDropDownMeasureSpecSize(int i3, int i16) {
        if (i3 != -1) {
            return View.MeasureSpec.getSize(i3);
        }
        return i16;
    }

    private int getStatusBarOffsetY() {
        String configValue = RFWConfig.getConfigValue("bubble_tip_reduce_immersive_status_bar_height", "M2105K81AC");
        if (configValue != null && configValue.contains(DeviceInfoMonitor.getModel())) {
            return RFWImmersiveUtils.getStatusBarHeight();
        }
        return 0;
    }

    private static int makeDropDownMeasureSpec(int i3, int i16) {
        return View.MeasureSpec.makeMeasureSpec(getDropDownMeasureSpecSize(i3, i16), getDropDownMeasureSpecMode(i3));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        dispatchVisibilityCallback(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] measureAndGetDropDownTrans(@NonNull View view, int i3, int i16, int i17, int i18) {
        int height;
        int i19;
        int width;
        int i26;
        setClippingEnabled(true);
        View contentView = getContentView();
        Rect rect = new Rect();
        contentView.getWindowVisibleDisplayFrame(rect);
        contentView.measure(makeDropDownMeasureSpec(getWidth(), rect.width()), makeDropDownMeasureSpec(getHeight(), rect.height()));
        int measuredWidth = contentView.getMeasuredWidth();
        int measuredHeight = contentView.getMeasuredHeight();
        view.getLocationInWindow(new int[2]);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        i19 = 0;
                        if (i16 != 0) {
                            if (i16 != 1) {
                                if (i16 != 2) {
                                    if (i16 != 4) {
                                        i26 = 0;
                                        return new int[]{i26 + i17, i19 + i18};
                                    }
                                    measuredWidth -= view.getWidth();
                                } else {
                                    width = view.getWidth();
                                }
                            }
                            i26 = 0 - measuredWidth;
                            return new int[]{i26 + i17, i19 + i18};
                        }
                        width = (view.getWidth() / 2) - (measuredWidth / 2);
                        i26 = width + 0;
                        return new int[]{i26 + i17, i19 + i18};
                    }
                } else {
                    height = view.getHeight();
                }
            } else {
                measuredHeight += view.getHeight();
            }
            i19 = 0 - measuredHeight;
            if (i16 != 0) {
            }
            i26 = width + 0;
            return new int[]{i26 + i17, i19 + i18};
        }
        height = (view.getHeight() / 2) + (measuredHeight / 2);
        i19 = 0 - height;
        if (i16 != 0) {
        }
        i26 = width + 0;
        return new int[]{i26 + i17, i19 + i18};
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16, int i17) {
        super.showAsDropDown(view, i3, i16, i17);
        dispatchVisibilityCallback(true);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        super.showAtLocation(view, i3, i16, i17);
        dispatchVisibilityCallback(true);
    }

    public void showOnAnchor(@NonNull View view, int i3, int i16) {
        showAsDropDown(view, i3, i16 - getStatusBarOffsetY(), 0);
    }
}
