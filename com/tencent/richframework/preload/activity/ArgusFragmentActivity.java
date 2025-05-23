package com.tencent.richframework.preload.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.layoutinflater.LayoutInflaterCompat;
import com.tencent.biz.richframework.layoutinflater.RFWMainThreadLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RFWSubThreadLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RedirectAndAndroidNFactory2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/richframework/preload/activity/ArgusFragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "currentLayoutInflater", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "Landroid/view/LayoutInflater;", "currentResource", "Landroid/content/res/Resources;", "delegateLayoutInflater", "preloadCompatFactory2Enable", "", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "getLayoutInflater", "getResources", "getSystemService", "", "name", "", "getWrapperLayoutInflater", "defaultInflater", "isCloneInflaterInSubThread", "isDelegateResourceEnabled", "isDelegatedInflateEnabled", "preloadCompatFactory2Enabled", "argus-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class ArgusFragmentActivity extends FragmentActivity {
    private HashMap _$_findViewCache;
    private final RFWThreadLocal<LayoutInflater> currentLayoutInflater = new RFWThreadLocal<>();
    private final RFWThreadLocal<Resources> currentResource = new RFWThreadLocal<>();
    private LayoutInflater delegateLayoutInflater;
    private boolean preloadCompatFactory2Enable;

    public ArgusFragmentActivity() {
        boolean z16 = true;
        if (RFWApplication.isPublicVersion() && !RFWConfig.getConfigValue("USE_PRELOAD_COMPACT_FACTORY2", true)) {
            z16 = false;
        }
        this.preloadCompatFactory2Enable = z16;
    }

    private final LayoutInflater getWrapperLayoutInflater(LayoutInflater defaultInflater) {
        LayoutInflater layoutInflater;
        if (getMOpenLayoutInflaterDelegate() && Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            layoutInflater = this.delegateLayoutInflater;
            if (layoutInflater == null) {
                RFWMainThreadLayoutInflater from = RFWMainThreadLayoutInflater.INSTANCE.from(defaultInflater, ArgusPreloadManager.INSTANCE.getLayoutPreLoader());
                this.delegateLayoutInflater = from;
                return from;
            }
        } else if (isCloneInflaterInSubThread() && (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            layoutInflater = this.currentLayoutInflater.get();
            if (layoutInflater == null) {
                RFWSubThreadLayoutInflater from2 = RFWSubThreadLayoutInflater.INSTANCE.from(defaultInflater);
                if (getPreloadCompatFactory2Enable()) {
                    LayoutInflaterCompat.INSTANCE.setForceMainAndFallbackFactory2(from2, new RedirectAndAndroidNFactory2(), true);
                }
                this.currentLayoutInflater.set(from2);
                return from2;
            }
        } else {
            return defaultInflater;
        }
        return layoutInflater;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i3) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i3));
        if (view == null) {
            View findViewById = findViewById(i3);
            this._$_findViewCache.put(Integer.valueOf(i3), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(@Nullable Context newBase) {
        if (getBaseContext() != null && ActivityPreloadConfig.INSTANCE.getResetBaseContextBeforeAttachBaseEnabled()) {
            BaseActivityResPreloadTask.INSTANCE.setActivityFakeResource(this, null);
        }
        super.attachBaseContext(newBase);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        if (isDelegateResourceEnabled()) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                Resources resources = super.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
                return resources;
            }
            Resources resource = this.currentResource.get();
            if (resource == null) {
                Resources resources2 = super.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "super.getResources()");
                Configuration configuration = new Configuration(resources2.getConfiguration());
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                configuration.setLocale(new Locale(String.valueOf(currentThread.getId())));
                Context createConfigurationContext = createConfigurationContext(configuration);
                Intrinsics.checkNotNullExpressionValue(createConfigurationContext, "createConfigurationContext(configuration)");
                resource = createConfigurationContext.getResources();
                this.currentResource.set(resource);
            }
            Intrinsics.checkNotNullExpressionValue(resource, "resource");
            return resource;
        }
        Resources resources3 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources3, "super.getResources()");
        return resources3;
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

    public boolean isCloneInflaterInSubThread() {
        return true;
    }

    public boolean isDelegateResourceEnabled() {
        return false;
    }

    /* renamed from: isDelegatedInflateEnabled */
    public boolean getMOpenLayoutInflaterDelegate() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* renamed from: preloadCompatFactory2Enabled, reason: from getter */
    public boolean getPreloadCompatFactory2Enable() {
        return this.preloadCompatFactory2Enable;
    }
}
