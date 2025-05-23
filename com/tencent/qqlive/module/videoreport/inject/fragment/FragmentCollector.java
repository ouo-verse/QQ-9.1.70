package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Fragment;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FragmentCollector {
    private static final String TAG = "hook." + FragmentCollector.class.getSimpleName();

    public static FragmentCompat fragmentToFragmentCompat(Fragment fragment) {
        FragmentCompat fragmentCompat = new FragmentCompat();
        fragmentCompat.setActivity(fragment.getActivity());
        fragmentCompat.setView(fragment.getView());
        return fragmentCompat;
    }

    public static void onDestroyView(Fragment fragment) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onDestroyView: fragment = " + fragment.getClass().getName());
        }
        EventCollector.getInstance().onFragmentDestroyView(fragmentToFragmentCompat(fragment));
    }

    public static void onFragmentViewCreated(Fragment fragment, View view) {
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onFragmentViewCreated: fragment = " + fragment.getClass().getName() + ", view = " + UIUtils.getViewInfo(view));
        }
        ViewContainerBinder.getInstance().bind(view, fragment);
    }

    public static void onHiddenChanged(Fragment fragment, boolean z16) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onHiddenChanged: fragment = " + fragment.getClass().getName() + ", hidden = " + z16);
        }
        if (z16) {
            EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(fragment));
        } else {
            EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(fragment));
        }
    }

    public static void onPause(Fragment fragment) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onPause: fragment = " + fragment.getClass().getName());
        }
        EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(fragment));
    }

    public static void onResume(Fragment fragment) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onResume: fragment = " + fragment.getClass().getName());
        }
        EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(fragment));
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z16) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "setUserVisibleHint: fragment = " + fragment.getClass().getName() + ", isVisible = " + z16);
        }
        if (z16) {
            EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(fragment));
        } else {
            EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(fragment));
        }
    }
}
