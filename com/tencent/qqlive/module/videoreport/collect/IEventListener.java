package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IEventListener {
    void onActivityConfigurationChanged(Activity activity, Configuration configuration);

    void onActivityCreate(Activity activity);

    void onActivityDestroyed(Activity activity);

    void onActivityPause(Activity activity);

    void onActivityResume(Activity activity);

    void onActivityStarted(Activity activity);

    void onActivityStopped(Activity activity);

    void onChildViewAdded(View view, View view2);

    void onChildViewRemoved(View view, View view2);

    void onDialogClick(DialogInterface dialogInterface, int i3);

    void onDialogHide(Activity activity, Dialog dialog);

    void onDialogShow(Activity activity, Dialog dialog);

    void onDispatchTouchEvent(Object obj, Window window, MotionEvent motionEvent, boolean z16, boolean z17);

    void onEditorAction(TextView textView, int i3, KeyEvent keyEvent, int i16);

    void onFragmentDestroyView(FragmentCompat fragmentCompat);

    void onFragmentPause(FragmentCompat fragmentCompat);

    void onFragmentResume(FragmentCompat fragmentCompat);

    void onListScrollStateChanged(AbsListView absListView, int i3);

    void onRecyclerViewScrollPosition(RecyclerView recyclerView);

    void onSetAndroidXRVAdapter(androidx.recyclerview.widget.RecyclerView recyclerView);

    void onSetRecyclerViewAdapter(RecyclerView recyclerView);

    void onSetViewPagerAdapter(ViewPager viewPager);

    void onViewClick(View view, DTConstants.ClickEventSource clickEventSource);

    void onViewLongClick(View view, DTConstants.ClickEventSource clickEventSource);

    void onViewReused(ViewGroup viewGroup, View view, long j3);
}
