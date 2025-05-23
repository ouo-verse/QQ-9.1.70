package com.tencent.trackrecordlib.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trackrecordlib.core.RecordManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f381149a;

    /* renamed from: b, reason: collision with root package name */
    private static String f381150b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            f381149a = Class.forName("android.view.WindowManagerGlobal");
            f381150b = "sDefaultWindowManager";
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(View view) {
        try {
            return view.getResources().getResourceName(view.getId());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(View view) {
        try {
            return view.getContentDescription().toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(View view) {
        if (!(view instanceof TextView)) {
            return "";
        }
        try {
            return ((TextView) view).getText().toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(View view) {
        ViewParent parent;
        int i3;
        if (view != null) {
            try {
                parent = view.getParent();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "unknown";
            }
        } else {
            parent = null;
        }
        if (!(parent instanceof ViewGroup)) {
            return "unknown";
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup.getChildCount() < 10) {
            i3 = viewGroup.indexOfChild(view);
        } else {
            i3 = -1;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("view_type", viewGroup.getClass().getName());
        jSONObject.put("view_tag", a(viewGroup));
        jSONObject.put("view_text", c(viewGroup));
        jSONObject.put("view_desc", b(viewGroup));
        jSONObject.put("index", i3);
        return jSONObject.toString();
    }

    public static String e(View view) {
        return view.getWidth() + "\u00d7" + view.getHeight();
    }

    public static String f(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0] + "," + iArr[1] + "," + (iArr[0] + view.getWidth()) + "," + (iArr[1] + view.getHeight());
    }

    public static boolean g(View view) {
        if (view == null) {
            return false;
        }
        String name = view.getClass().getName();
        if (!name.equals("com.android.internal.policy.impl.PhoneWindow$DecorView") && !name.equals("com.android.internal.policy.impl.MultiPhoneWindow$MultiPhoneDecorView") && !name.equals("com.android.internal.policy.PhoneWindow$DecorView") && !name.equals("com.android.internal.policy.DecorView")) {
            return false;
        }
        return true;
    }

    public static boolean h(View view) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view == null) {
            return false;
        }
        float height = view.getHeight();
        View i3 = i(view);
        view.getLocationOnScreen(iArr);
        if (i3 == null) {
            iArr2[1] = 0;
        } else {
            i3.getLocationOnScreen(iArr2);
        }
        float f16 = height / 2.0f;
        if (iArr[1] + f16 > j(view) || iArr[1] + f16 < iArr2[1]) {
            return false;
        }
        return true;
    }

    private static View i(View view) {
        if (!(view instanceof AbsListView) && !(view instanceof ScrollView) && !(view instanceof WebView)) {
            try {
                return i((View) view.getParent());
            } catch (Throwable unused) {
                return null;
            }
        }
        return view;
    }

    private static float j(View view) {
        int[] iArr = new int[2];
        View i3 = i(view);
        if (i3 == null) {
            return g.a(RecordManager.getInstance().f381004a);
        }
        i3.getLocationOnScreen(iArr);
        return iArr[1] + i3.getHeight();
    }

    public static ArrayList<View> a() {
        View[] b16 = b();
        ArrayList<View> arrayList = new ArrayList<>();
        View[] a16 = a(b16);
        if (b16 != null && b16.length > 0) {
            View b17 = b(b16);
            if (b17 != null) {
                arrayList.add(b17);
            }
            try {
                a(arrayList, (ViewGroup) b17);
            } catch (Throwable unused) {
            }
        }
        if (a16 != null) {
            for (View view : a16) {
                if (view != null) {
                    arrayList.add(view);
                }
                try {
                    a(arrayList, (ViewGroup) view);
                } catch (Throwable unused2) {
                }
            }
        }
        return arrayList;
    }

    private static View[] b() {
        try {
            Field declaredField = f381149a.getDeclaredField("mViews");
            Field declaredField2 = f381149a.getDeclaredField(f381150b);
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            return (View[]) ((ArrayList) declaredField.get(declaredField2.get(null))).toArray(new View[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private static View c(View[] viewArr) {
        View view = null;
        long j3 = 0;
        for (View view2 : viewArr) {
            if (view2 != null && view2.isShown() && view2.hasWindowFocus() && view2.getDrawingTime() > j3) {
                j3 = view2.getDrawingTime();
                view = view2;
            }
        }
        return view;
    }

    private static View b(View[] viewArr) {
        if (viewArr == null) {
            return null;
        }
        View[] viewArr2 = new View[viewArr.length];
        int i3 = 0;
        for (View view : viewArr) {
            if (g(view)) {
                viewArr2[i3] = view;
                i3++;
            }
        }
        return c(viewArr2);
    }

    private static View[] a(View[] viewArr) {
        if (viewArr == null) {
            return null;
        }
        View[] viewArr2 = new View[viewArr.length];
        int i3 = 0;
        for (View view : viewArr) {
            if (!g(view)) {
                viewArr2[i3] = view;
                i3++;
            }
        }
        return viewArr2;
    }

    private static void a(ArrayList<View> arrayList, ViewGroup viewGroup) {
        if (viewGroup != null) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null) {
                    arrayList.add(childAt);
                }
                if (childAt instanceof ViewGroup) {
                    a(arrayList, (ViewGroup) childAt);
                }
            }
        }
    }
}
