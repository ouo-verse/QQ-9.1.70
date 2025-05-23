package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewContainerBinder extends DefaultEventListener {
    private final WeakHashMap<View, WeakReference<Object>> mBound;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final ViewContainerBinder INSTANCE;

        static {
            ViewContainerBinder viewContainerBinder = new ViewContainerBinder();
            INSTANCE = viewContainerBinder;
            viewContainerBinder.init();
        }

        InstanceHolder() {
        }
    }

    public static ViewContainerBinder getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        EventCollector.getInstance().registerEventListener(this);
    }

    private static int secondaryHash(int i3) {
        int i16 = i3 + ((i3 << 15) ^ (-12931));
        int i17 = i16 ^ (i16 >>> 10);
        int i18 = i17 + (i17 << 3);
        int i19 = i18 ^ (i18 >>> 6);
        int i26 = i19 + (i19 << 2) + (i19 << 14);
        return i26 ^ (i26 >>> 16);
    }

    public void bind(View view, Object obj) {
        if (view == null) {
            return;
        }
        this.mBound.put(view, new WeakReference<>(obj));
    }

    public Object getBoundContainer(View view) {
        if (view == null) {
            return null;
        }
        try {
            WeakReference<Object> weakReference = this.mBound.get(view);
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        } catch (ArrayIndexOutOfBoundsException e16) {
            int secondaryHash = secondaryHash(view.hashCode());
            throw new ArrayIndexOutOfBoundsException("hash = " + secondaryHash + ", masked = " + (Integer.MAX_VALUE & secondaryHash) + ", " + e16.getMessage());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityResume(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            bind(decorView, activity);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDialogShow(Activity activity, Dialog dialog) {
        View decorView;
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            bind(decorView, dialog);
        }
    }

    ViewContainerBinder() {
        this.mBound = new WeakHashMap<>();
    }
}
