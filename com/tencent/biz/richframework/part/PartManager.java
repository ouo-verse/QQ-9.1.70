package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class PartManager implements PartLifecycleCallbacks {
    private ViewGroup mParentView;
    protected IPartHost mPartHost;
    protected View mRootView;
    protected final Map<String, Part> mParts = new LinkedHashMap();
    protected final List<PartManager> mObservers = new ArrayList();
    protected final Map<Integer, List<Part>> mLazyParts = new LinkedHashMap();
    protected final Map<Integer, View> mStubView = new ConcurrentHashMap();

    public PartManager(IPartHost iPartHost, View view) {
        this.mPartHost = iPartHost;
        this.mRootView = view;
    }

    @UiThread
    private void addLazyInitPart(int i3, Part part) {
        List<Part> list = this.mLazyParts.get(Integer.valueOf(i3));
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(part);
        this.mLazyParts.put(Integer.valueOf(i3), list);
    }

    private void logPartLifecycle(String str, String str2, long j3) {
        if (RFWLog.isColorLevel()) {
            RFWLog.i("PartLifeCycleTime:" + str, RFWLog.CLR, str2 + j3);
        }
        IPartHost iPartHost = this.mPartHost;
        if (iPartHost != null) {
            iPartHost.onPartTimeCostReport(str, str2, j3);
        }
    }

    private void notifyOtherObservePartManager(String str, Object obj) {
        if (this.mObservers.size() > 0) {
            Iterator<PartManager> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().broadcastMessage(str, obj);
            }
        }
    }

    @Deprecated
    public void beforeFinish() {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.beforeFinish();
            }
        }
    }

    public void broadcastMessage(String str, Object obj) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.handleBroadcastMessage(str, obj);
            }
        }
        notifyOtherObservePartManager(str, obj);
    }

    @Deprecated
    public void finish() {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.finish();
            }
        }
    }

    public Object getMessageFromPart(String str, Object obj) {
        Object message;
        for (Part part : this.mParts.values()) {
            if (part != null && (message = part.getMessage(str, obj)) != null) {
                return message;
            }
        }
        return null;
    }

    public Part getPart(String str) {
        return this.mParts.get(str);
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.onActivityResult(i3, i16, intent);
            }
        }
    }

    public boolean onBackEvent() {
        for (Part part : this.mParts.values()) {
            if (part != null && part.onBackEvent()) {
                return true;
            }
        }
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.onConfigurationChanged(configuration);
            }
        }
    }

    public void onNewIntent(Intent intent) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.onNewIntent(intent);
            }
        }
    }

    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                long currentTimeMillis = System.currentTimeMillis();
                part.setParentView(this.mParentView);
                part.setRootView(this.mRootView);
                part.onPartCreate(activity, bundle);
                logPartLifecycle(part.getLogTag(), "onActivityCreated:", System.currentTimeMillis() - currentTimeMillis);
                if (part.getInitRelyViewStubId() != 0) {
                    addLazyInitPart(part.getInitRelyViewStubId(), part);
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    part.onInitView(this.mRootView);
                    logPartLifecycle(part.getLogTag(), "onInitView:", System.currentTimeMillis() - currentTimeMillis2);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    part.onPartDestroy(activity);
                    logPartLifecycle(part.getLogTag(), "onActivityDestroyed:", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th5) {
                    RFWLog.fatal("PartManager", RFWLog.USR, th5);
                }
            }
        }
        this.mParts.clear();
        this.mPartHost = null;
    }

    public void onPartPause(@NonNull Activity activity) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    part.onPartPause(activity);
                    logPartLifecycle(part.getLogTag(), "onActivityPaused:", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th5) {
                    RFWLog.fatal("PartManager", RFWLog.USR, th5);
                }
            }
        }
    }

    public void onPartResume(@NonNull Activity activity) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    part.onPartResume(activity);
                    logPartLifecycle(part.getLogTag(), "onActivityResumed:", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th5) {
                    RFWLog.fatal("PartManager", RFWLog.USR, th5);
                }
            }
        }
    }

    public void onPartSaveInstanceState(@NonNull Activity activity, Bundle bundle) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    part.onPartSaveInstanceState(activity, bundle);
                    logPartLifecycle(part.getLogTag(), "onActivitySaveInstanceState:", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th5) {
                    RFWLog.fatal("PartManager", RFWLog.USR, th5);
                }
            }
        }
    }

    public void onPartStart(@NonNull Activity activity) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    part.onPartStart(activity);
                    logPartLifecycle(part.getLogTag(), "onActivityStarted:", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th5) {
                    RFWLog.fatal("PartManager", RFWLog.USR, th5);
                }
            }
        }
    }

    public void onPartStop(@NonNull Activity activity) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    part.onPartStop(activity);
                    logPartLifecycle(part.getLogTag(), "onActivityStopped:", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th5) {
                    RFWLog.fatal("PartManager", RFWLog.USR, th5);
                }
            }
        }
    }

    @Deprecated
    public void onWindowFocusChanged(boolean z16) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.onWindowFocusChanged(z16);
            }
        }
    }

    public void registerPart(List<Part> list) {
        if (list == null) {
            return;
        }
        for (Part part : list) {
            if (part.isPartEnable()) {
                part.setEnvironment(this.mPartHost, this.mRootView, this);
                String name = part.getClass().getName();
                if (this.mParts.containsKey(name)) {
                    String str = "you can not register same class part:" + name;
                    RFWLog.e("PartManager", RFWLog.USR, str);
                    if (RFWApplication.isDebug()) {
                        throw new RuntimeException(str);
                    }
                }
                this.mParts.put(name, part);
            }
        }
    }

    @Deprecated
    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    public void setPartManagerObservers(PartManager partManager) {
        this.mObservers.add(partManager);
    }

    public void setRootView(View view) {
        this.mRootView = view;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z16) {
        for (Part part : this.mParts.values()) {
            if (part != null) {
                part.setUserVisibleHint(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean startInit(Part part) {
        int initRelyViewStubId = part.getInitRelyViewStubId();
        if (this.mStubView.get(Integer.valueOf(initRelyViewStubId)) != null) {
            RFWLog.d("PartManager", RFWLog.USR, " alReady init Part");
            return true;
        }
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(initRelyViewStubId);
        if (viewStub != null) {
            this.mStubView.put(Integer.valueOf(initRelyViewStubId), viewStub.inflate());
            part.onInitView(this.mRootView);
            for (Part part2 : this.mLazyParts.get(Integer.valueOf(initRelyViewStubId))) {
                if (part2 != part) {
                    part2.onInitView(this.mRootView);
                }
            }
            return true;
        }
        RFWLog.e("PartManager", RFWLog.USR, " viewStub init null");
        throw new RuntimeException("can't find viewStub:" + initRelyViewStubId + " define in part:" + part.getClass());
    }
}
