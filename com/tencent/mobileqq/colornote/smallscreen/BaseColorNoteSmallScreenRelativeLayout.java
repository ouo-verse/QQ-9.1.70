package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseColorNoteSmallScreenRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected static boolean f201555d = false;

    public BaseColorNoteSmallScreenRelativeLayout(Context context) {
        this(context, null);
    }

    public static boolean d() {
        return f201555d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context, int[] iArr) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        Rect bounds2;
        if (context != null && iArr != null && iArr.length == 2) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
                if (Build.VERSION.SDK_INT >= 30) {
                    currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                    bounds = currentWindowMetrics.getBounds();
                    iArr[0] = bounds.width();
                    bounds2 = currentWindowMetrics.getBounds();
                    iArr[1] = bounds2.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Exception e16) {
                QLog.e("BaseColorNoteSmallScreenRelativeLayout", 1, "getScreenDimens exception", e16);
            }
            if (iArr[0] <= 0 || iArr[1] <= 0) {
                QLog.e("BaseColorNoteSmallScreenRelativeLayout", 1, "getScreenDimens:[" + iArr[0] + "," + iArr[1] + "] use default");
                iArr[0] = ViewUtils.getScreenWidth();
                iArr[1] = ViewUtils.getScreenHeight();
            }
        }
    }

    public abstract boolean b();

    public abstract Point c();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract boolean k();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void o(List<ColorNote> list);

    public abstract void p();

    public abstract void q();

    public abstract void setCurPosition(Point point);

    public abstract void setCustomNightMode(boolean z16);

    public abstract void setFloatListener(da1.a aVar);

    public abstract void setShouldMaxRootView(boolean z16);

    public abstract void setUpcomingController(p pVar);

    public BaseColorNoteSmallScreenRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseColorNoteSmallScreenRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
