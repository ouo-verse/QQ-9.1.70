package com.tencent.mobileqq.qwallet.consecutivescroller;

import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.ScrollingView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static Method f277138a;

    /* renamed from: b, reason: collision with root package name */
    static Method f277139b;

    /* renamed from: c, reason: collision with root package name */
    static Method f277140c;

    /* renamed from: d, reason: collision with root package name */
    private static final Rect f277141d = new Rect();

    private static void a(List<View> list, View view, int i3, int i16) {
        if (n(view, i3, i16)) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i17 = 0; i17 < childCount; i17++) {
                    a(list, viewGroup.getChildAt(i17), i3, i16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view) {
        if (view != null && (c(view, 1) || c(view, -1))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(View view, int i3) {
        int i16;
        if (view.getVisibility() == 8) {
            return false;
        }
        if (view instanceof AbsListView) {
            return ((AbsListView) view).canScrollList(i3);
        }
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if ((recyclerView.canScrollHorizontally(1) || recyclerView.canScrollHorizontally(-1)) && !recyclerView.canScrollVertically(i3)) {
                return false;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (layoutManager != null && adapter != null && adapter.getItemCount() > 0) {
                if (i3 > 0) {
                    i16 = adapter.getItemCount() - 1;
                } else {
                    i16 = 0;
                }
                if (layoutManager.findViewByPosition(i16) == null) {
                    return true;
                }
                int childCount = recyclerView.getChildCount();
                if (i3 > 0) {
                    for (int i17 = childCount - 1; i17 >= 0; i17--) {
                        View childAt = recyclerView.getChildAt(i17);
                        Rect rect = f277141d;
                        recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                        if (rect.bottom > recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                            return true;
                        }
                    }
                    return false;
                }
                for (int i18 = 0; i18 < childCount; i18++) {
                    View childAt2 = recyclerView.getChildAt(i18);
                    Rect rect2 = f277141d;
                    recyclerView.getDecoratedBoundsWithMargins(childAt2, rect2);
                    if (rect2.top < recyclerView.getPaddingTop()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return view.canScrollVertically(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int d(View view) {
        if (view instanceof ScrollingView) {
            return ((ScrollingView) view).computeVerticalScrollExtent();
        }
        try {
            if (f277140c == null) {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
                f277140c = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f277140c.invoke(view, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return view.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static int e(View view) {
        if (view instanceof ScrollingView) {
            return ((ScrollingView) view).computeVerticalScrollOffset();
        }
        try {
            if (f277138a == null) {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
                f277138a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f277138a.invoke(view, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return view.getScrollY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static int f(View view) {
        if (view instanceof ScrollingView) {
            return ((ScrollingView) view).computeVerticalScrollRange();
        }
        try {
            if (f277139b == null) {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
                f277139b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f277139b.invoke(view, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return view.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(View view, MotionEvent motionEvent, int i3) {
        float x16;
        if (Build.VERSION.SDK_INT >= 29) {
            x16 = motionEvent.getRawX(i3);
        } else {
            view.getLocationOnScreen(new int[2]);
            x16 = r0[0] + motionEvent.getX(i3);
        }
        return (int) x16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(View view, MotionEvent motionEvent, int i3) {
        float y16;
        if (Build.VERSION.SDK_INT >= 29) {
            y16 = motionEvent.getRawY(i3);
        } else {
            view.getLocationOnScreen(new int[2]);
            y16 = r0[1] + motionEvent.getY(i3);
        }
        return (int) y16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(View view) {
        if (c(view, 1)) {
            return Math.max((f(view) - e(view)) - d(view), 1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(View view) {
        if (c(view, -1)) {
            return Math.min(-e(view), -1);
        }
        return 0;
    }

    static List<View> k(View view, int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, view, i3, i16);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(View view) {
        while ((view.getParent() instanceof ViewGroup) && !(view.getParent() instanceof ConsecutiveScrollerLayout)) {
            view = (View) view.getParent();
        }
        return view.getParent() instanceof ConsecutiveScrollerLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(View view, int i3, int i16) {
        for (View view2 : k(view, i3, i16)) {
            if (view2.canScrollHorizontally(1) || view2.canScrollHorizontally(-1)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n(View view, int i3, int i16) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i17 = iArr[0];
        int i18 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i17;
        int measuredHeight = view.getMeasuredHeight() + i18;
        if (i3 < i17 || i3 > measuredWidth || i16 < i18 || i16 > measuredHeight) {
            return false;
        }
        return true;
    }
}
