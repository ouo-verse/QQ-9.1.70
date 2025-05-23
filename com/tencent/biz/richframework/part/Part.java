package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.interfaces.IPartHost;

/* loaded from: classes5.dex */
public abstract class Part implements PartLifecycleCallbacks {
    private Activity mActivity;
    private volatile Handler mMainHandler;

    @Deprecated
    protected ViewGroup mParentView;
    private IPartHost mPartHost;
    private PartManager mPartManager;
    private View mRootView;

    private boolean isActivityFinish() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public Object broadcastGetMessage(String str, Object obj) {
        return this.mPartManager.getMessageFromPart(str, obj);
    }

    public void broadcastMessage(String str, Object obj) {
        this.mPartManager.broadcastMessage(str, obj);
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public Context getContext() {
        Context hostContext;
        IPartHost iPartHost = this.mPartHost;
        if (iPartHost != null && (hostContext = iPartHost.getHostContext()) != null) {
            return hostContext;
        }
        return this.mActivity;
    }

    @Deprecated
    public Fragment getHostFragment() {
        Object obj = this.mPartHost;
        if (obj instanceof Fragment) {
            return (Fragment) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getInitRelyViewStubId() {
        return 0;
    }

    public String getLogTag() {
        return getClass().getName();
    }

    public Handler getMainHandler() {
        if (this.mMainHandler == null) {
            synchronized (Part.class) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.mMainHandler;
    }

    public Object getMessage(String str, Object obj) {
        return null;
    }

    public IPartHost getPartHost() {
        return this.mPartHost;
    }

    @Deprecated
    public PartManager getPartManager() {
        return this.mPartManager;
    }

    public View getRootView() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        return getPartManager().mRootView;
    }

    public <T extends ViewModel> T getViewModel(Class<T> cls) {
        return (T) getViewModel(null, cls);
    }

    public Object getViewTagData() {
        View view;
        IPartHost iPartHost = this.mPartHost;
        if (iPartHost == null) {
            if (!RFWApplication.isDebug()) {
                return null;
            }
            throw new RuntimeException("getViewTagData but fragment is null");
        }
        Object viewTagData = iPartHost.getViewTagData();
        if (viewTagData == null && (view = this.mRootView) != null) {
            return view.getTag(TagData.TAG_DATA_ID);
        }
        return viewTagData;
    }

    public boolean isPartEnable() {
        return true;
    }

    public boolean onBackEvent() {
        return false;
    }

    public void onInitView(View view) {
        RFWLog.d(getLogTag(), RFWLog.USR, getLogTag() + "->onInitView");
    }

    public /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        b.a(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.PartLifecycleCallbacks
    @CallSuper
    public void onPartDestroy(Activity activity) {
        getMainHandler().removeCallbacksAndMessages(null);
    }

    public /* synthetic */ void onPartPause(Activity activity) {
        b.c(this, activity);
    }

    public /* synthetic */ void onPartResume(Activity activity) {
        b.d(this, activity);
    }

    public /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        b.e(this, activity, bundle);
    }

    public /* synthetic */ void onPartStart(Activity activity) {
        b.f(this, activity);
    }

    public /* synthetic */ void onPartStop(Activity activity) {
        b.g(this, activity);
    }

    public boolean runOnActivityUiThread(Runnable runnable) {
        return runOnActivityUiThread(runnable, 0L);
    }

    public void setEnvironment(IPartHost iPartHost, View view, PartManager partManager) {
        if (iPartHost != null) {
            this.mActivity = iPartHost.getHostActivity();
            this.mPartHost = iPartHost;
        }
        this.mPartManager = partManager;
        this.mRootView = view;
    }

    public void setHostActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Deprecated
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    public void setRootView(View view) {
        this.mRootView = view;
    }

    @UiThread
    public final boolean startInit() {
        return this.mPartManager.startInit(this);
    }

    public void updateViewTagData(View view, Object obj) {
        if (view != null && obj != null) {
            view.setTag(TagData.TAG_DATA_ID, obj);
        }
    }

    public <T extends ViewModel> T getViewModel(String str, Class<T> cls) {
        IPartHost iPartHost = this.mPartHost;
        if (iPartHost != null) {
            return (T) getViewModel(iPartHost, str, cls);
        }
        return null;
    }

    public boolean runOnActivityUiThread(Runnable runnable, long j3) {
        if (isActivityFinish()) {
            return false;
        }
        getMainHandler().postDelayed(runnable, j3);
        return true;
    }

    public <T extends ViewModel> T getViewModel(IPartHost iPartHost, String str, Class<T> cls) {
        IPartHost iPartHost2 = this.mPartHost;
        if (iPartHost2 != null) {
            return (T) iPartHost2.getViewModel(iPartHost, str, cls);
        }
        return null;
    }

    @Deprecated
    public void beforeFinish() {
    }

    @Deprecated
    public void finish() {
    }

    @Deprecated
    public void onUserLeaveHint() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public void initAfterInflation(View view) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    @Deprecated
    public void onNewIntent(Intent intent) {
    }

    @Deprecated
    public void onWindowFocusChanged(boolean z16) {
    }

    @Deprecated
    public void setUserVisibleHint(boolean z16) {
    }

    public void handleBroadcastMessage(String str, Object obj) {
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
