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
public class DefaultEventListener implements IEventListener {
    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityCreate(Activity activity) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityPause(Activity activity) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityResume(Activity activity) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onFragmentDestroyView(FragmentCompat fragmentCompat) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onFragmentPause(FragmentCompat fragmentCompat) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onFragmentResume(FragmentCompat fragmentCompat) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onRecyclerViewScrollPosition(RecyclerView recyclerView) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onSetAndroidXRVAdapter(androidx.recyclerview.widget.RecyclerView recyclerView) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onSetRecyclerViewAdapter(RecyclerView recyclerView) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onSetViewPagerAdapter(ViewPager viewPager) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onChildViewAdded(View view, View view2) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onChildViewRemoved(View view, View view2) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDialogClick(DialogInterface dialogInterface, int i3) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDialogHide(Activity activity, Dialog dialog) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDialogShow(Activity activity, Dialog dialog) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onListScrollStateChanged(AbsListView absListView, int i3) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onViewClick(View view, DTConstants.ClickEventSource clickEventSource) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onViewLongClick(View view, DTConstants.ClickEventSource clickEventSource) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onViewReused(ViewGroup viewGroup, View view, long j3) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onEditorAction(TextView textView, int i3, KeyEvent keyEvent, int i16) {
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDispatchTouchEvent(Object obj, Window window, MotionEvent motionEvent, boolean z16, boolean z17) {
    }
}
