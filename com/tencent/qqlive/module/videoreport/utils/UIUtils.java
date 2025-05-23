package com.tencent.qqlive.module.videoreport.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.page.DialogListUtil;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class UIUtils {
    private static final String TAG = "UIUtils";
    private static final Rect TEMP_RECT = new Rect();

    public static Activity findAttachedActivity(View view) {
        if (!ViewCompatUtils.isAttachedToWindow(view)) {
            return null;
        }
        Object boundContainer = ViewContainerBinder.getInstance().getBoundContainer(view.getRootView());
        if (boundContainer instanceof Activity) {
            return (Activity) boundContainer;
        }
        if (!(boundContainer instanceof Dialog)) {
            return null;
        }
        return DialogListUtil.getDialogActivity((Dialog) boundContainer);
    }

    public static String getActivityInfo(Activity activity) {
        if (activity == null) {
            return "null";
        }
        return activity.getClass().getSimpleName();
    }

    public static View getDecorView(Activity activity) {
        if (activity == null) {
            return null;
        }
        return getDecorView(activity.getWindow());
    }

    public static AreaInfo getExposureAreaInfo(View view) {
        long j3;
        double d16;
        if (view == null) {
            return null;
        }
        long width = view.getWidth() * view.getHeight();
        double d17 = 0.0d;
        if (view.isShown()) {
            if (view.getGlobalVisibleRect(TEMP_RECT)) {
                long width2 = r0.width() * r0.height();
                if (width != 0) {
                    d17 = (width2 * 1.0d) / width;
                }
                d16 = d17;
                j3 = width2;
                return new AreaInfo(width, j3, d16);
            }
        }
        j3 = 0;
        d16 = 0.0d;
        return new AreaInfo(width, j3, d16);
    }

    public static Object getListOnHierarchyChangeListener(AbsListView absListView) {
        if (absListView == null) {
            return null;
        }
        return ReflectUtils.getField(ViewGroup.class, "mOnHierarchyChangeListener", absListView);
    }

    public static Object getListScrollListener(AbsListView absListView) {
        if (absListView == null) {
            return null;
        }
        return ReflectUtils.getField(AbsListView.class, "mOnScrollListener", absListView);
    }

    public static Set<View> getParentViews(View view) {
        HashSet hashSet = new HashSet();
        if (view == null) {
            return hashSet;
        }
        while (view.getParent() instanceof ViewGroup) {
            view = (ViewGroup) view.getParent();
            hashSet.add(view);
        }
        return hashSet;
    }

    public static double getViewExposureRate(View view) {
        boolean z16;
        if (view == null) {
            return 0.0d;
        }
        if (view.isShown() && view.getGlobalVisibleRect(TEMP_RECT)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0.0d;
        }
        Rect rect = TEMP_RECT;
        return ((rect.width() * rect.height()) * 1.0d) / (view.getWidth() * view.getHeight());
    }

    public static String getViewInfo(View view) {
        if (view == null) {
            return "null";
        }
        int id5 = view.getId();
        String str = "0";
        if (id5 != -1) {
            try {
                Context context = ReportUtils.getContext();
                if (context != null) {
                    str = context.getResources().getResourceName(id5);
                }
            } catch (Resources.NotFoundException e16) {
                Log.e(TAG, "NotFoundException " + e16);
            }
        }
        return view.getClass().getSimpleName() + ":" + str;
    }

    public static View getDecorView(Window window) {
        if (window == null) {
            return null;
        }
        return window.getDecorView();
    }

    public static View getDecorView(Fragment fragment) {
        return getDecorView(fragment.getActivity());
    }

    public static View getDecorView(android.support.v4.app.Fragment fragment) {
        return getDecorView((Activity) fragment.getActivity());
    }

    public static View getDecorView(Dialog dialog) {
        if (dialog == null) {
            return null;
        }
        return getDecorView(dialog.getWindow());
    }

    public static View getDecorView(View view) {
        if (ViewCompatUtils.isAttachedToWindow(view)) {
            return view.getRootView();
        }
        return null;
    }
}
