package com.tencent.richframework.preload.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.layoutinflater.LayoutInflaterCompat;
import com.tencent.biz.richframework.layoutinflater.RFWMainThreadLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RFWSubThreadLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RedirectAndAndroidNFactory2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u0018\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/richframework/preload/activity/ArgusBaseActivity;", "Landroid/app/Activity;", "()V", "currentLayoutInflater", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "Landroid/view/LayoutInflater;", "delegateLayoutInflater", "isCloneInflaterInSubThread", "", "()Z", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "getLayoutInflater", "getSystemService", "", "name", "", "getWrapperLayoutInflater", "defaultInflater", "isDelegatedInflateEnabled", "preloadCompatFactory2Enabled", "argus-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class ArgusBaseActivity extends Activity {
    private RFWThreadLocal<LayoutInflater> currentLayoutInflater;
    private LayoutInflater delegateLayoutInflater;

    private final LayoutInflater getWrapperLayoutInflater(LayoutInflater defaultInflater) {
        LayoutInflater layoutInflater;
        if (isDelegatedInflateEnabled() && Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            layoutInflater = this.delegateLayoutInflater;
            if (layoutInflater == null) {
                RFWMainThreadLayoutInflater from = RFWMainThreadLayoutInflater.INSTANCE.from(defaultInflater, ArgusPreloadManager.INSTANCE.getLayoutPreLoader());
                this.delegateLayoutInflater = from;
                return from;
            }
        } else if (isCloneInflaterInSubThread() && (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            if (this.currentLayoutInflater == null) {
                this.currentLayoutInflater = new RFWThreadLocal<>();
            }
            RFWThreadLocal<LayoutInflater> rFWThreadLocal = this.currentLayoutInflater;
            if (rFWThreadLocal == null || (layoutInflater = rFWThreadLocal.get()) == null) {
                RFWSubThreadLayoutInflater from2 = RFWSubThreadLayoutInflater.INSTANCE.from(defaultInflater);
                if (preloadCompatFactory2Enabled()) {
                    LayoutInflaterCompat.INSTANCE.setForceMainAndFallbackFactory2(from2, new RedirectAndAndroidNFactory2(), true);
                }
                RFWThreadLocal<LayoutInflater> rFWThreadLocal2 = this.currentLayoutInflater;
                if (rFWThreadLocal2 != null) {
                    rFWThreadLocal2.set(from2);
                    return from2;
                }
                return from2;
            }
        } else {
            return defaultInflater;
        }
        return layoutInflater;
    }

    private final boolean isCloneInflaterInSubThread() {
        return true;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(@Nullable Context newBase) {
        if (getBaseContext() != null && ActivityPreloadConfig.INSTANCE.getResetBaseContextBeforeAttachBaseEnabled()) {
            BaseActivityResPreloadTask.INSTANCE.setActivityFakeResource(this, null);
        }
        super.attachBaseContext(newBase);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    @NotNull
    public LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = super.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "super.getLayoutInflater()");
        return getWrapperLayoutInflater(layoutInflater);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            Object systemService = super.getSystemService("layout_inflater");
            if (systemService instanceof LayoutInflater) {
                return getWrapperLayoutInflater((LayoutInflater) systemService);
            }
        }
        if (Intrinsics.areEqual("connectivity", name)) {
            return getApplication().getSystemService("connectivity");
        }
        return super.getSystemService(name);
    }

    public boolean isDelegatedInflateEnabled() {
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public boolean preloadCompatFactory2Enabled() {
        if (!RFWApplication.isPublicVersion() || RFWConfig.getConfigValue("USE_PRELOAD_COMPACT_FACTORY2", true)) {
            return true;
        }
        return false;
    }
}
