package com.tencent.mobileqq.widget.tip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes20.dex */
public class AnchorRelativePopupWindow extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private static final List<WeakReference<a>> f317510a = new CopyOnWriteArrayList();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface HorizontalPosition {
        public static final int ALIGN_LEFT = 3;
        public static final int ALIGN_RIGHT = 4;
        public static final int CENTER = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface VerticalPosition {
        public static final int ABOVE = 1;
        public static final int ALIGN_BOTTOM = 4;
        public static final int ALIGN_TOP = 3;
        public static final int BELOW = 2;
        public static final int CENTER = 0;
    }

    /* loaded from: classes20.dex */
    public interface a {
        void dismiss(PopupWindow popupWindow);

        void show(PopupWindow popupWindow);
    }

    public AnchorRelativePopupWindow(Context context) {
        super(context);
    }

    private void a(boolean z16) {
        for (WeakReference<a> weakReference : f317510a) {
            if (weakReference != null) {
                a aVar = weakReference.get();
                if (aVar == null) {
                    f317510a.remove(weakReference);
                } else if (z16) {
                    aVar.show(this);
                } else {
                    aVar.dismiss(this);
                }
            }
        }
    }

    private static int b(int i3) {
        if (i3 != -2) {
            return 1073741824;
        }
        return 0;
    }

    private static int c(int i3, int i16) {
        if (i3 != -1) {
            return View.MeasureSpec.getSize(i3);
        }
        return i16;
    }

    private int d(View view) {
        if (view == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("bubble_tip_reduce_immersive_status_bar_height", "M2105K81AC").contains(DeviceInfoMonitor.getModel())) {
            return 0;
        }
        return ViewUtils.getStatusBarHeight(view.getContext());
    }

    private static int e(int i3, int i16) {
        return View.MeasureSpec.makeMeasureSpec(c(i3, i16), b(i3));
    }

    public static void g(a aVar) {
        if (aVar == null) {
            return;
        }
        for (WeakReference<a> weakReference : f317510a) {
            if (weakReference != null) {
                a aVar2 = weakReference.get();
                if (aVar2 == null) {
                    f317510a.remove(weakReference);
                } else if (aVar2 == aVar) {
                    return;
                }
            }
        }
        f317510a.add(new WeakReference<>(aVar));
    }

    public static void j(a aVar) {
        if (aVar == null) {
            return;
        }
        for (WeakReference<a> weakReference : f317510a) {
            if (weakReference != null) {
                a aVar2 = weakReference.get();
                if (aVar2 == null) {
                    f317510a.remove(weakReference);
                } else if (aVar2 == aVar) {
                    f317510a.remove(weakReference);
                }
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        a(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] f(@NonNull View view, int i3, int i16, int i17, int i18) {
        int height;
        int i19;
        int width;
        int i26;
        int i27;
        setClippingEnabled(true);
        View contentView = getContentView();
        Rect rect = new Rect();
        contentView.getWindowVisibleDisplayFrame(rect);
        int width2 = rect.width();
        int height2 = rect.height();
        contentView.measure(e(getWidth(), width2), e(getHeight(), height2));
        int measuredWidth = contentView.getMeasuredWidth();
        int measuredHeight = contentView.getMeasuredHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int height3 = iArr[1] + view.getHeight();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        i19 = 0;
                    } else {
                        i19 = 0 - measuredHeight;
                    }
                    if (i16 == 0) {
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 4) {
                                    i26 = 0;
                                    i27 = i19 + height3;
                                    if (i27 >= 0) {
                                        i19 = -height3;
                                    } else if (i27 + measuredHeight > height2) {
                                        i19 = (height2 - height3) - measuredHeight;
                                    }
                                    return new int[]{i26 + i17, i19 + i18};
                                }
                                measuredWidth -= view.getWidth();
                            } else {
                                width = view.getWidth();
                            }
                        }
                        i26 = 0 - measuredWidth;
                        i27 = i19 + height3;
                        if (i27 >= 0) {
                        }
                        return new int[]{i26 + i17, i19 + i18};
                    }
                    width = (view.getWidth() / 2) - (measuredWidth / 2);
                    i26 = width + 0;
                    i27 = i19 + height3;
                    if (i27 >= 0) {
                    }
                    return new int[]{i26 + i17, i19 + i18};
                }
                height = view.getHeight();
            } else {
                height = view.getHeight() + measuredHeight;
            }
        } else {
            height = (view.getHeight() / 2) + (measuredHeight / 2);
        }
        i19 = 0 - height;
        if (i16 == 0) {
        }
        i26 = width + 0;
        i27 = i19 + height3;
        if (i27 >= 0) {
        }
        return new int[]{i26 + i17, i19 + i18};
    }

    public void h(@NonNull View view, int i3, int i16) {
        showAsDropDown(view, i3, i16 - d(view), 0);
    }

    public void i(@NonNull View view, int i3, int i16, int i17, int i18) {
        if ((view.getContext() instanceof Activity) && !((Activity) view.getContext()).isFinishing()) {
            int[] f16 = f(view, i3, i16, i17, i18);
            h(view, f16[0], f16[1]);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16, int i17) {
        super.showAsDropDown(view, i3, i16, i17);
        a(true);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        super.showAtLocation(view, i3, i16, i17);
        a(true);
    }
}
