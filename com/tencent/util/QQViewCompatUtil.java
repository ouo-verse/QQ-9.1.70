package com.tencent.util;

import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQViewCompatUtil {
    static IPatchRedirector $redirector_;

    public QQViewCompatUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void refelctViewGroupOffsetChildrenTopAndBottom(ViewGroup viewGroup, int i3) {
        ReflectionUtil.invokeMethodWithArgs(viewGroup, "android.view.ViewGroup", "offsetChildrenTopAndBottom", new Class[]{Integer.TYPE}, Integer.valueOf(i3));
    }

    public static boolean refelctViewIncludeForAccessibility(View view) {
        return ((Boolean) ReflectionUtil.invokeMethodWithArgs(view, "android.view.View", "includeForAccessibility", null, null)).booleanValue();
    }

    public static void refelctViewInitializeScrollbars(View view, TypedArray typedArray) {
        ReflectionUtil.invokeMethodWithArgs(view, "android.view.View", "initializeScrollbars", new Class[]{TypedArray.class}, typedArray);
    }
}
