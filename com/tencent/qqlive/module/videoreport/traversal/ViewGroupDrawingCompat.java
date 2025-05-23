package com.tencent.qqlive.module.videoreport.traversal;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewGroupDrawingCompat {
    private static final String TAG = "ViewGroupDrawingCompat";
    private static final HashSet<String> sBlackList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class MethodHolder {
        private static Method sGetChildDrawingOrderMethod;
        private static Method sIsOrderEnableMethod;

        static {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                sGetChildDrawingOrderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = ViewGroup.class.getDeclaredMethod("isChildrenDrawingOrderEnabled", new Class[0]);
                sIsOrderEnableMethod = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (Throwable unused) {
                Log.e(ViewGroupDrawingCompat.TAG, "error happened in method reflection");
            }
        }

        MethodHolder() {
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        sBlackList = hashSet;
        hashSet.add("android.view.ViewGroup");
        hashSet.add("com.android.internal.policy.DecorView");
        hashSet.add("android.widget.LinearLayout");
        hashSet.add("android.widget.RelativeLayout");
        hashSet.add("android.widget.FrameLayout");
        hashSet.add("android.widget.GridLayout");
        hashSet.add("android.widget.HorizontalScrollView");
        hashSet.add("android.widget.TabHost");
        hashSet.add("android.widget.GridView");
        hashSet.add("android.widget.ListView");
        hashSet.add("android.widget.ScrollView");
        hashSet.add("android.support.constraint.ConstraintLayout");
    }

    static /* synthetic */ boolean access$000() {
        return initReflection();
    }

    private static void dumpDebugInfo(ViewGroup viewGroup, View[] viewArr) {
        if (!VideoReportInner.getInstance().isDebugMode()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(viewGroup.toString());
        sb5.append("\n");
        sb5.append("Default Drawing order:\n");
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            sb5.append("index:");
            sb5.append(childCount);
            sb5.append(" ");
            sb5.append(viewGroup.getChildAt(childCount));
            sb5.append("\n");
        }
        sb5.append("reordered Drawing order:\n");
        for (int length = viewArr.length - 1; length >= 0; length--) {
            sb5.append("index:");
            sb5.append(length);
            sb5.append(" ");
            sb5.append(viewArr[length]);
            sb5.append("\n");
        }
        Log.v(TAG, sb5.toString());
    }

    private static View[] getChildByCustomOrder(ViewGroup viewGroup) throws IllegalAccessException, InvocationTargetException {
        if (!initReflectionIfNeed(viewGroup)) {
            return getDefaultChildren();
        }
        int childCount = viewGroup.getChildCount();
        View[] viewArr = new View[viewGroup.getChildCount()];
        for (int i3 = 0; i3 < childCount; i3++) {
            viewArr[((Integer) MethodHolder.sGetChildDrawingOrderMethod.invoke(viewGroup, Integer.valueOf(childCount), Integer.valueOf(i3))).intValue()] = viewGroup.getChildAt(i3);
        }
        dumpDebugInfo(viewGroup, viewArr);
        return viewArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View[] getChildrenByDrawingOrder(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        try {
            return getChildByCustomOrder(viewGroup);
        } catch (Throwable unused) {
            return getDefaultChildren();
        }
    }

    private static View[] getDefaultChildren() {
        return null;
    }

    private static boolean initReflection() {
        if (MethodHolder.sIsOrderEnableMethod != null && MethodHolder.sGetChildDrawingOrderMethod != null) {
            return true;
        }
        return false;
    }

    private static boolean initReflectionIfNeed(ViewGroup viewGroup) throws InvocationTargetException, IllegalAccessException {
        if (viewGroup == null || viewGroup.getChildCount() <= 1) {
            return false;
        }
        if (sBlackList.contains(viewGroup.getClass().getName()) || !initReflection() || !((Boolean) MethodHolder.sIsOrderEnableMethod.invoke(viewGroup, new Object[0])).booleanValue()) {
            return false;
        }
        return true;
    }

    public static void preload() {
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.traversal.ViewGroupDrawingCompat.1
            @Override // java.lang.Runnable
            public void run() {
                Log.v(ViewGroupDrawingCompat.TAG, "preload success:" + ViewGroupDrawingCompat.access$000());
            }
        });
    }
}
