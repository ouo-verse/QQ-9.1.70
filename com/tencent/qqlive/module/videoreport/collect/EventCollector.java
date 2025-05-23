package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.notifier.ActivityConfigurationChangedNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.AndroidXRVSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.KeyBoardEditorActionNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ListScrollNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewScrollPositionNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewClickNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewLongClickNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewPagerSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewReuseNotifier;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver;
import com.tencent.qqlive.module.videoreport.page.DialogListUtil;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EventCollector implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "hook." + EventCollector.class.getSimpleName();
    private Field mLayoutManagerRecyclerViewField;
    private EventNotifyManager mNotifyManager;
    private Field mOwnerRecyclerViewField;
    private final TouchEventLimiter touchEventLimiter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static EventCollector sInstance = new EventCollector();

        InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class WeakRunnable implements Runnable {
        private final WeakReference<Object> weakObj;

        WeakRunnable(Object obj) {
            this.weakObj = new WeakReference<>(obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.weakObj.get();
            if (obj instanceof RecyclerView) {
                RecyclerViewSetAdapterNotifier recyclerViewSetAdapterNotifier = (RecyclerViewSetAdapterNotifier) ReusablePool.obtain(RecyclerViewSetAdapterNotifier.class);
                recyclerViewSetAdapterNotifier.init((RecyclerView) obj);
                EventCollector.this.mNotifyManager.addEventNotifier(obj, recyclerViewSetAdapterNotifier);
            }
        }
    }

    private ViewGroup getAndroidXViewHolderOwnerView(RecyclerView.ViewHolder viewHolder) {
        if (this.mOwnerRecyclerViewField == null) {
            try {
                this.mOwnerRecyclerViewField = RecyclerView.ViewHolder.class.getDeclaredField("mOwnerRecyclerView");
            } catch (NoSuchFieldException unused) {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.e(TAG, "find no mOwnerRecyclerView field");
                }
            }
        }
        Field field = this.mOwnerRecyclerViewField;
        if (field != null) {
            field.setAccessible(true);
            try {
                return (ViewGroup) this.mOwnerRecyclerViewField.get(viewHolder);
            } catch (IllegalAccessException | IllegalArgumentException unused2) {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.e(TAG, "find no mOwnerRecyclerView field");
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    public static EventCollector getInstance() {
        return InstanceHolder.sInstance;
    }

    private android.support.v7.widget.RecyclerView getRecyclerView(RecyclerView.LayoutManager layoutManager) {
        if (this.mLayoutManagerRecyclerViewField == null) {
            try {
                this.mLayoutManagerRecyclerViewField = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
            } catch (NoSuchFieldException unused) {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.e(TAG, "find no mRecyclerView field");
                }
            }
        }
        Field field = this.mLayoutManagerRecyclerViewField;
        if (field != null) {
            field.setAccessible(true);
            try {
                return (android.support.v7.widget.RecyclerView) this.mLayoutManagerRecyclerViewField.get(layoutManager);
            } catch (IllegalAccessException | IllegalArgumentException unused2) {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.e(TAG, "find no mRecyclerView field");
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    private ViewGroup getViewHolderOwnerView(RecyclerView.ViewHolder viewHolder) {
        if (this.mOwnerRecyclerViewField == null) {
            try {
                this.mOwnerRecyclerViewField = RecyclerView.ViewHolder.class.getDeclaredField("mOwnerRecyclerView");
            } catch (NoSuchFieldException unused) {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.e(TAG, "find no mOwnerRecyclerView field");
                }
            }
        }
        Field field = this.mOwnerRecyclerViewField;
        if (field != null) {
            field.setAccessible(true);
            try {
                return (ViewGroup) this.mOwnerRecyclerViewField.get(viewHolder);
            } catch (IllegalAccessException | IllegalArgumentException unused2) {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.e(TAG, "find no mOwnerRecyclerView field");
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    private void notifyDispatchTouchEvent(Object obj, Window window, MotionEvent motionEvent, boolean z16, boolean z17) {
        long hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        long action = (hashCode << 3) | motionEvent.getAction();
        if (this.touchEventLimiter.allow(action)) {
            this.mNotifyManager.addTouchEventNotifierImmediately(action | (z17 ? 1L : 0L), obj, window, motionEvent, z16, z17);
        }
    }

    private void notifyViewClick(View view, DTConstants.ClickEventSource clickEventSource) {
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        ViewClickNotifier viewClickNotifier = (ViewClickNotifier) ReusablePool.obtain(ViewClickNotifier.class);
        viewClickNotifier.init(view, clickEventSource);
        this.mNotifyManager.addEventNotifierImmediately(view, viewClickNotifier, clickEventSource + "");
    }

    private void notifyViewLongClick(View view, DTConstants.ClickEventSource clickEventSource) {
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        ViewLongClickNotifier viewLongClickNotifier = (ViewLongClickNotifier) ReusablePool.obtain(ViewLongClickNotifier.class);
        viewLongClickNotifier.init(view, clickEventSource);
        this.mNotifyManager.addEventNotifierImmediately(view, viewLongClickNotifier, clickEventSource + "");
    }

    private void onRecyclerViewItemReuse(RecyclerView.ViewHolder viewHolder, long j3) {
        if (!VideoReportInner.getInstance().isDataCollectEnable() || !LazyInitObserver.getInstance().mayProceedOnMain(null)) {
            return;
        }
        ViewReuseNotifier viewReuseNotifier = (ViewReuseNotifier) ReusablePool.obtain(ViewReuseNotifier.class);
        viewReuseNotifier.init(getViewHolderOwnerView(viewHolder), viewHolder.itemView, j3);
        this.mNotifyManager.addEventNotifier(viewHolder.itemView, viewReuseNotifier);
    }

    private void onRecyclerViewScroll(RecyclerView.LayoutManager layoutManager) {
        android.support.v7.widget.RecyclerView recyclerView;
        if (VideoReportInner.getInstance().isDataCollectEnable() && (recyclerView = getRecyclerView(layoutManager)) != null) {
            RecyclerViewScrollPositionNotifier recyclerViewScrollPositionNotifier = (RecyclerViewScrollPositionNotifier) ReusablePool.obtain(RecyclerViewScrollPositionNotifier.class);
            recyclerViewScrollPositionNotifier.init(recyclerView);
            this.mNotifyManager.addEventNotifier(recyclerView, recyclerViewScrollPositionNotifier);
        }
    }

    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onActivityConfigurationChanged: activity=" + activity.getClass().getName());
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        ActivityConfigurationChangedNotifier activityConfigurationChangedNotifier = (ActivityConfigurationChangedNotifier) ReusablePool.obtain(ActivityConfigurationChangedNotifier.class);
        activityConfigurationChangedNotifier.init(activity, configuration);
        this.mNotifyManager.addEventNotifier(activity, activityConfigurationChangedNotifier);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onActivityCreated: activity=" + activity.getClass().getName());
        }
        Log.d(DTConfigConstants.LAZY_INIT_TAG, "act created");
        this.mNotifyManager.onActivityCreate(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onActivityDestroyed: activity=" + activity.getClass().getName());
        }
        this.mNotifyManager.onActivityDestroyed(activity);
    }

    public void onActivityDispatchTouchEvent(Activity activity, MotionEvent motionEvent, boolean z16, boolean z17) {
        notifyDispatchTouchEvent(activity, activity.getWindow(), motionEvent, z16, z17);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onActivityPause: activity = " + activity.getClass().getName());
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        this.mNotifyManager.onActivityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onActivityResumed: activity = " + activity.getClass().getName());
        }
        Log.d(DTConfigConstants.LAZY_INIT_TAG, "act resumed");
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        this.mNotifyManager.onActivityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onActivitySaveInstanceState: activity=" + activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onActivityStarted: activity = " + activity.getClass().getName());
        }
        Log.d(DTConfigConstants.LAZY_INIT_TAG, "act started");
        this.mNotifyManager.onActivityStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onActivityStopped: activity=" + activity.getClass().getName());
        }
        this.mNotifyManager.onActivityStopped(activity);
    }

    public void onAndroidXRVItemReuse(RecyclerView.ViewHolder viewHolder, long j3) {
        if (!VideoReportInner.getInstance().isDataCollectEnable() || !LazyInitObserver.getInstance().mayProceedOnMain(null)) {
            return;
        }
        ViewGroup androidXViewHolderOwnerView = getAndroidXViewHolderOwnerView(viewHolder);
        if (!ReportHelper.androidXRVExposureEnabled(androidXViewHolderOwnerView)) {
            if (VideoReport.isDebugMode()) {
                Log.d(TAG, "view:" + androidXViewHolderOwnerView + "exposure disabled");
                return;
            }
            return;
        }
        ViewReuseNotifier viewReuseNotifier = (ViewReuseNotifier) ReusablePool.obtain(ViewReuseNotifier.class);
        viewReuseNotifier.init(androidXViewHolderOwnerView, viewHolder.itemView, j3);
        this.mNotifyManager.addEventNotifier(viewHolder.itemView, viewReuseNotifier);
    }

    public void onChildViewAdded(View view, View view2) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onChildViewAdded, view = " + UIUtils.getViewInfo(view2));
        }
        if (VideoReportInner.getInstance().isDataCollectEnable() && (view instanceof AbsListView)) {
            this.mNotifyManager.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onChildViewAdded, view = " + UIUtils.getViewInfo(view2));
        }
        if (VideoReportInner.getInstance().isDataCollectEnable() && (view instanceof AbsListView)) {
            this.mNotifyManager.onChildViewRemoved(view, view2);
        }
    }

    public void onCompoundButtonChecked(CompoundButton compoundButton, boolean z16) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onCompoundButtonChecked, view = " + UIUtils.getViewInfo(compoundButton) + ", isChecked = " + z16);
        }
        notifyViewClick(compoundButton, DTConstants.ClickEventSource.METHOND_AFTER);
    }

    public void onCompoundButtonCheckedBefore(CompoundButton compoundButton, boolean z16) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onCompoundButtonCheckedBefore, view = " + UIUtils.getViewInfo(compoundButton) + ", isChecked = " + z16);
        }
        notifyViewClick(compoundButton, DTConstants.ClickEventSource.METHOND_BEFORE);
    }

    public void onDialogClicked(DialogInterface dialogInterface, int i3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onDialogClicked, dialog = " + BaseUtils.getClassSimpleName(dialogInterface) + ", which = " + i3);
        }
        VideoReportInner.getInstance().isDataCollectEnable();
    }

    public void onDialogDispatchTouchEvent(Dialog dialog, MotionEvent motionEvent, boolean z16, boolean z17) {
        notifyDispatchTouchEvent(dialog, dialog.getWindow(), motionEvent, z16, z17);
    }

    public void onDialogFocusChanged(Dialog dialog, boolean z16) {
        Activity dialogActivity = DialogListUtil.getDialogActivity(dialog);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onDialogFocusChanged: dialog = " + dialog.getClass().getName() + ", hasFocus = " + z16 + ", activity = " + UIUtils.getActivityInfo(dialogActivity));
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable() || dialogActivity == null) {
            return;
        }
        if (z16) {
            DialogListUtil.onDialogResume(dialog);
            this.mNotifyManager.onDialogShow(dialogActivity, dialog);
        } else {
            this.mNotifyManager.onDialogHide(dialogActivity, dialog);
        }
    }

    public void onDialogStop(Dialog dialog) {
        Activity dialogActivity = DialogListUtil.getDialogActivity(dialog);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onDialogStop: dialog = " + dialog.getClass().getName() + ", activity = " + UIUtils.getActivityInfo(dialogActivity));
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        DialogListUtil.onDialogStop(dialog);
        this.mNotifyManager.onDialogHide(dialogActivity, dialog);
    }

    public void onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onEditorAction, v = " + UIUtils.getViewInfo(textView) + " actionId = " + i3);
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        KeyBoardEditorActionNotifier keyBoardEditorActionNotifier = (KeyBoardEditorActionNotifier) ReusablePool.obtain(KeyBoardEditorActionNotifier.class);
        keyBoardEditorActionNotifier.init(textView, i3, keyEvent, 1);
        this.mNotifyManager.addEventNotifier(textView, keyBoardEditorActionNotifier);
    }

    public void onFragmentDestroyView(FragmentCompat fragmentCompat) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onFragmentDestroyView: fragment = " + fragmentCompat.getClass().getName() + fragmentCompat.hashCode());
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        this.mNotifyManager.onFragmentDestroyView(fragmentCompat);
    }

    public void onFragmentPaused(FragmentCompat fragmentCompat) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onFragmentPaused: fragment = " + fragmentCompat.getClass().getName() + fragmentCompat.hashCode());
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        this.mNotifyManager.onFragmentPaused(fragmentCompat);
    }

    public void onFragmentResumed(FragmentCompat fragmentCompat) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onFragmentResumed: fragment = " + fragmentCompat.getClass().getName() + fragmentCompat.hashCode());
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        this.mNotifyManager.onFragmentResumed(fragmentCompat);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onItemClick, parent = " + BaseUtils.getClassSimpleName(adapterView) + ", view = " + UIUtils.getViewInfo(view) + ", position = " + i3);
        }
        notifyViewClick(view, DTConstants.ClickEventSource.METHOND_AFTER);
    }

    public void onItemClickBefore(AdapterView<?> adapterView, View view, int i3, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onItemClickBefore, view = " + UIUtils.getViewInfo(view));
        }
        notifyViewClick(view, DTConstants.ClickEventSource.METHOND_BEFORE);
    }

    public void onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onItemLongClick, parent = " + BaseUtils.getClassSimpleName(adapterView) + ", view = " + UIUtils.getViewInfo(view) + ", position = " + i3);
        }
        notifyViewLongClick(view, DTConstants.ClickEventSource.METHOND_AFTER);
    }

    public void onItemLongClickBefore(AdapterView<?> adapterView, View view, int i3, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onItemLongClickBefore, parent = " + BaseUtils.getClassSimpleName(adapterView) + ", view = " + UIUtils.getViewInfo(view) + ", position = " + i3);
        }
        notifyViewLongClick(view, DTConstants.ClickEventSource.METHOND_BEFORE);
    }

    public void onListGetView(int i3, View view, ViewGroup viewGroup, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onListGetView, parent = " + UIUtils.getViewInfo(viewGroup) + ", convertView = " + UIUtils.getViewInfo(view) + ", position = " + i3);
        }
        if (VideoReportInner.getInstance().isDataCollectEnable() && view != null && LazyInitObserver.getInstance().mayProceedOnMain(null)) {
            Object extendParam = DataRWProxy.getExtendParam(viewGroup, DTConstants.DTExtendMapKey.LISTVIEW_SCROLL_STATE);
            if ((extendParam instanceof Integer) && ((Integer) extendParam).intValue() != 0) {
                return;
            }
            ViewReuseNotifier viewReuseNotifier = (ViewReuseNotifier) ReusablePool.obtain(ViewReuseNotifier.class);
            viewReuseNotifier.init(viewGroup, view, j3);
            this.mNotifyManager.addEventNotifier(view, viewReuseNotifier);
        }
    }

    public void onListScrollStateChanged(AbsListView absListView, int i3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onListScrollStateChanged, view = " + UIUtils.getViewInfo(absListView) + ", scrollState = " + i3);
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        Object extendParam = DataRWProxy.getExtendParam(absListView, DTConstants.DTExtendMapKey.LISTVIEW_SCROLL_STATE);
        if ((extendParam instanceof Integer) && ((Integer) extendParam).intValue() == i3) {
            return;
        }
        DataRWProxy.putExtendParam(absListView, DTConstants.DTExtendMapKey.LISTVIEW_SCROLL_STATE, Integer.valueOf(i3));
        ListScrollNotifier listScrollNotifier = (ListScrollNotifier) ReusablePool.obtain(ListScrollNotifier.class);
        listScrollNotifier.init(absListView, i3);
        this.mNotifyManager.addEventNotifier(absListView, listScrollNotifier);
    }

    public void onRadioGroupChecked(RadioGroup radioGroup, int i3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onRadioGroupChecked, view = " + UIUtils.getViewInfo(radioGroup) + ", checkedId = " + i3);
        }
        notifyViewClick(radioGroup, DTConstants.ClickEventSource.METHOND_AFTER);
    }

    public void onRadioGroupCheckedBefore(RadioGroup radioGroup, int i3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onRadioGroupCheckedBefore, view = " + UIUtils.getViewInfo(radioGroup) + ", checkedId = " + i3);
        }
        notifyViewClick(radioGroup, DTConstants.ClickEventSource.METHOND_BEFORE);
    }

    public void onRecyclerBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onRecyclerBindViewHolder, holder = " + BaseUtils.getClassSimpleName(viewHolder) + ", position = " + i3);
        }
        onRecyclerViewItemReuse(viewHolder, j3);
    }

    public void onRecyclerViewScrollToPosition(RecyclerView.LayoutManager layoutManager) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onRecyclerViewScrollToPosition");
        }
        onRecyclerViewScroll(layoutManager);
    }

    public void onRecyclerViewScrollToPositionWithOffset(RecyclerView.LayoutManager layoutManager) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onRecyclerViewScrollToPositionWithOffset");
        }
        onRecyclerViewScroll(layoutManager);
    }

    public void onSetRecyclerViewAdapter(android.support.v7.widget.RecyclerView recyclerView) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onSetRecyclerViewAdapter, recyclerView = " + UIUtils.getViewInfo(recyclerView));
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        ThreadUtils.runOnUiThread(new WeakRunnable(recyclerView));
    }

    public void onSetViewPagerAdapter(final ViewPager viewPager) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onSetViewPagerAdapter, viewPager = " + UIUtils.getViewInfo(viewPager));
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.collect.EventCollector.1
            @Override // java.lang.Runnable
            public void run() {
                ViewPagerSetAdapterNotifier viewPagerSetAdapterNotifier = (ViewPagerSetAdapterNotifier) ReusablePool.obtain(ViewPagerSetAdapterNotifier.class);
                viewPagerSetAdapterNotifier.init(viewPager);
                EventCollector.this.mNotifyManager.addEventNotifier(viewPager, viewPagerSetAdapterNotifier);
            }
        });
    }

    public void onSetXRVAdapter(androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onSetAndroidXRVAdapter, recyclerView = " + UIUtils.getViewInfo(recyclerView));
        }
        if (!VideoReportInner.getInstance().isDataCollectEnable()) {
            return;
        }
        if (!ReportHelper.androidXRVExposureEnabled(recyclerView)) {
            if (VideoReport.isDebugMode()) {
                Log.d(TAG, "view:" + recyclerView + " exposure disabled");
                return;
            }
            return;
        }
        AndroidXRVSetAdapterNotifier androidXRVSetAdapterNotifier = (AndroidXRVSetAdapterNotifier) ReusablePool.obtain(AndroidXRVSetAdapterNotifier.class);
        androidXRVSetAdapterNotifier.init(recyclerView);
        this.mNotifyManager.addEventNotifier(recyclerView, androidXRVSetAdapterNotifier);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onStopTrackingTouch, view = " + UIUtils.getViewInfo(seekBar));
        }
        notifyViewClick(seekBar, DTConstants.ClickEventSource.METHOND_AFTER);
    }

    public void onStopTrackingTouchBefore(SeekBar seekBar) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onStopTrackingTouchBefore, view = " + UIUtils.getViewInfo(seekBar));
        }
        notifyViewClick(seekBar, DTConstants.ClickEventSource.METHOND_BEFORE);
    }

    public void onViewClicked(View view) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onViewClicked, view = " + UIUtils.getViewInfo(view));
        }
        notifyViewClick(view, DTConstants.ClickEventSource.METHOND_AFTER);
    }

    public void onViewClickedBefore(View view) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onViewClickedBefore, view = " + UIUtils.getViewInfo(view));
        }
        notifyViewClick(view, DTConstants.ClickEventSource.METHOND_BEFORE);
    }

    public void onViewLongClicked(View view) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onViewLongClicked, view = " + UIUtils.getViewInfo(view));
        }
        notifyViewLongClick(view, DTConstants.ClickEventSource.METHOND_AFTER);
    }

    public void onViewLongClickedBefore(View view) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onViewLongClickedBefore, view = " + UIUtils.getViewInfo(view));
        }
        notifyViewLongClick(view, DTConstants.ClickEventSource.METHOND_BEFORE);
    }

    public void registerEventListener(IEventListener iEventListener) {
        this.mNotifyManager.registerEventListener(iEventListener);
    }

    public void unregisterEventListener(IEventListener iEventListener) {
        this.mNotifyManager.unregisterEventListener(iEventListener);
    }

    EventCollector() {
        this.touchEventLimiter = new TouchEventLimiter();
        this.mNotifyManager = new EventNotifyManager();
    }

    public void onRecyclerBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List<Object> list, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onRecyclerBindViewHolder2, holder = " + BaseUtils.getClassSimpleName(viewHolder) + ", position = " + i3);
        }
        onRecyclerViewItemReuse(viewHolder, j3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
