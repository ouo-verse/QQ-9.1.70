package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
class ViewActivityMap {
    private final Map<Context, WeakReference<Activity>> mViewActivityMap = new WeakHashMap();

    @Nullable
    private Activity fromContext(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return null;
            }
        }
        return null;
    }

    Activity getActivity(View view) {
        Context context;
        if (view == null || (context = view.getContext()) == null) {
            return null;
        }
        WeakReference<Activity> weakReference = this.mViewActivityMap.get(context);
        if (weakReference == null) {
            WeakReference<Activity> weakReference2 = new WeakReference<>(fromContext(context));
            this.mViewActivityMap.put(context, weakReference2);
            weakReference = weakReference2;
        }
        return weakReference.get();
    }
}
