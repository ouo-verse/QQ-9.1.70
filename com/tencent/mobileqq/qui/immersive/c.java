package com.tencent.mobileqq.qui.immersive;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.v4.view.ScrollingView;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import com.tencent.mobileqq.qui.immersive.color.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final float f276883h;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Window> f276884d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<View> f276885e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f276886f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f276883h = com.tencent.mobileqq.immersive.a.j();
        }
    }

    public c(Window window, WeakReference<View> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) window, (Object) weakReference);
        } else {
            this.f276884d = new WeakReference<>(window);
            this.f276885e = weakReference;
        }
    }

    private static void b(List<View> list, View view, Rect rect, int i3, int i16, int i17, int i18, boolean z16) {
        Rect h16 = h(view, i17, i18);
        boolean i19 = i(view);
        if (h16.contains(i3, i16)) {
            list.add(view);
            if (n(view, z16, i19)) {
                list.addAll(o((ViewGroup) view, i3, i16, (int) (i17 + view.getX()), (int) (i18 + view.getY()), z16));
                return;
            }
            return;
        }
        if (!i19 && com.tencent.mobileqq.immersive.a.i().booleanValue() && n(view, z16, i19)) {
            list.addAll(o((ViewGroup) view, i3, i16, (int) (i17 + view.getX()), (int) (i18 + view.getY()), z16));
        }
    }

    public static double c(int i3) {
        double alpha = Color.alpha(i3) / 255.0d;
        return ((Color.red(i3) / 255.0d) * 0.2126d * alpha) + ((Color.green(i3) / 255.0d) * 0.7152d * alpha) + ((Color.blue(i3) / 255.0d) * 0.0722d * alpha);
    }

    public static int d(int i3, int i16) {
        float red = Color.red(i3);
        float green = Color.green(i3);
        float blue = Color.blue(i3);
        float alpha = Color.alpha(i3);
        float red2 = Color.red(i16);
        float green2 = Color.green(i16);
        float blue2 = Color.blue(i16);
        float f16 = alpha / 255.0f;
        float alpha2 = (1.0f - f16) * Color.alpha(i16);
        float f17 = alpha2 / 255.0f;
        return Color.argb((int) (alpha + alpha2), (int) ((red * f16) + (red2 * f17)), (int) ((green * f16) + (green2 * f17)), (int) ((blue * f16) + (blue2 * f17)));
    }

    public static Pair<Boolean, Integer> f(List<View> list, IColorFetcher.Area area, List<WeakReference<View>> list2) {
        ArrayList arrayList = new ArrayList();
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            View view = list.get(size);
            IColorFetcher b16 = f.b(view);
            if (b16 != null) {
                Pair<Boolean, Integer> color = b16.getColor(view, area);
                if (((Boolean) color.first).booleanValue() && ((Integer) color.second).intValue() != 0) {
                    e("in index:" + size + " use colorFetcher:" + b16 + " color:" + Integer.toHexString(((Integer) color.second).intValue()));
                    if (Color.alpha(((Integer) color.second).intValue()) != 0) {
                        arrayList.add((Integer) color.second);
                        list2.add(new WeakReference<>(view));
                    }
                    if (Color.alpha(((Integer) color.second).intValue()) == 255) {
                        e("find color:" + color.second + " alpha is 255, stop find");
                        break;
                    }
                } else {
                    e("in index:" + size + " handle error: colorFetcher:" + b16 + " result:" + color);
                }
            } else if (view.getBackground() != null) {
                e("no colorFetcher can handle background");
            }
            size--;
        }
        if (arrayList.size() == 0) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        int intValue = ((Integer) arrayList.get(0)).intValue();
        for (int i3 = 1; i3 < arrayList.size(); i3++) {
            intValue = d(intValue, ((Integer) arrayList.get(i3)).intValue());
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(intValue));
    }

    private static Fragment g(PagerAdapter pagerAdapter, int i3) {
        if ((pagerAdapter instanceof FragmentPagerAdapter) && i3 < pagerAdapter.getF373114d()) {
            return ((FragmentPagerAdapter) pagerAdapter).getItem(i3);
        }
        return null;
    }

    public static Rect h(View view, int i3, int i16) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top += i16;
        rect.bottom += i16;
        rect.left += i3;
        rect.right += i3;
        return rect;
    }

    private static boolean i(View view) {
        if ((view instanceof ViewGroup) && ((ViewGroup) view).getClipToPadding()) {
            return true;
        }
        return false;
    }

    private static boolean j(View view) {
        boolean z16;
        if (!(view instanceof ScrollView) && !(view instanceof android.widget.ScrollView) && !(view instanceof RecyclerView) && !(view instanceof AbsListView)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return view instanceof ScrollingView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void m(final String str, final String str2) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qui.immersive.b
            @Override // java.lang.Runnable
            public final void run() {
                QLog.d(str, 1, str2);
            }
        });
    }

    public static boolean n(View view, boolean z16, boolean z17) {
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        if (z16 && j(view)) {
            return view.getParent() instanceof ViewPager2;
        }
        if ((view.getWidth() <= 0 || view.getHeight() <= 0) && !z17) {
            return false;
        }
        return true;
    }

    public static List<View> o(ViewGroup viewGroup, int i3, int i16, int i17, int i18, boolean z16) {
        View view;
        Rect rect = new Rect();
        int childCount = viewGroup.getChildCount();
        ArrayList arrayList = new ArrayList();
        if (viewGroup instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) viewGroup;
            Fragment g16 = g(viewPager.getAdapter(), viewPager.getCurrentItem());
            if (g16 != null && (view = g16.getView()) != null) {
                b(arrayList, view, rect, i3, i16, (int) (i17 - view.getX()), (int) (i18 - view.getY()), z16);
            }
        } else {
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt = viewGroup.getChildAt(i19);
                if (childAt.getVisibility() == 0 && childAt.getAlpha() != 0.0f) {
                    b(arrayList, childAt, rect, i3, i16, i17, i18, z16);
                }
            }
        }
        return arrayList;
    }

    public boolean k(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
        }
        if (view != null && view.getWidth() > 0 && view.getHeight() > 0 && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    protected static void e(String str) {
    }
}
