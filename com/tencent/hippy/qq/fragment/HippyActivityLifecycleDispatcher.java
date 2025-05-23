package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001J\u0006\u0010\t\u001a\u00020\u0007J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J,\u0010\u0011\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0018\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0001`\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleDispatcher;", "Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleListener;", "()V", "mActivityLifecycleListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addActivityLifecycleListener", "", "listener", "clearAllListener", "onActivityCreated", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onNewIntent", "intent", "removeActivityLifecycleListener", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippyActivityLifecycleDispatcher implements HippyActivityLifecycleListener {

    @NotNull
    private final ArrayList<HippyActivityLifecycleListener> mActivityLifecycleListeners = new ArrayList<>();

    public final synchronized void addActivityLifecycleListener(@NotNull HippyActivityLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mActivityLifecycleListeners.add(listener);
    }

    public final synchronized void clearAllListener() {
        this.mActivityLifecycleListeners.clear();
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivityCreated(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivityDestroyed(@Nullable Activity activity) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroyed(activity);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivityPaused(@Nullable Activity activity) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityPaused(activity);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivityResult(@Nullable Activity activity, int requestCode, int resultCode, @Nullable Intent data) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(activity, requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivityResumed(@Nullable Activity activity) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityResumed(activity);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivitySaveInstanceState(@Nullable Activity activity, @Nullable Bundle outState) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivitySaveInstanceState(activity, outState);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivityStarted(@Nullable Activity activity) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityStarted(activity);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onActivityStopped(@Nullable Activity activity) {
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityStopped(activity);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public synchronized void onNewIntent(@NotNull Activity activity, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<HippyActivityLifecycleListener> it = this.mActivityLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onNewIntent(activity, intent);
        }
    }

    public final synchronized void removeActivityLifecycleListener(@NotNull HippyActivityLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mActivityLifecycleListeners.remove(listener);
    }
}
