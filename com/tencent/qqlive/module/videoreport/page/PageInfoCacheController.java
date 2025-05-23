package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes22.dex */
public class PageInfoCacheController {
    private static final String TAG = "page." + PageInfoCacheController.class.getSimpleName();
    private WeakHashMap<Context, Set<View>> mAttachedPageStore = new WeakHashMap<>();
    private Set<View> mUnattachedPageStore = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    private void addToAttachedPageStore(View view, Context context) {
        Set<View> set = this.mAttachedPageStore.get(context);
        if (set == null) {
            set = Collections.newSetFromMap(new WeakHashMap());
            this.mAttachedPageStore.put(context, set);
        }
        set.add(view);
    }

    private void addToUnattachedStore(View view) {
        this.mUnattachedPageStore.add(view);
    }

    private Context getRefContext(Object obj, View view) {
        if (((obj instanceof View) && !ViewCompatUtils.isAttachedToWindow((View) obj)) || view == null) {
            return null;
        }
        return view.getRootView().getContext();
    }

    private View getRefView(Object obj) {
        if (obj instanceof View) {
            return (View) obj;
        }
        if (obj instanceof Activity) {
            return ((Activity) obj).getWindow().getDecorView();
        }
        if (obj instanceof Dialog) {
            Dialog dialog = (Dialog) obj;
            if (dialog.getWindow() != null) {
                return dialog.getWindow().getDecorView();
            }
            return null;
        }
        return null;
    }

    private void tryTransferToAttachedStore() {
        Iterator<View> it = this.mUnattachedPageStore.iterator();
        while (it.hasNext()) {
            View next = it.next();
            Context refContext = getRefContext(next, next);
            if (refContext != null) {
                addToAttachedPageStore(next, refContext);
                it.remove();
            }
        }
    }

    public void appendPageStore(Object obj) {
        if (obj == null) {
            return;
        }
        View refView = getRefView(obj);
        Context refContext = getRefContext(obj, refView);
        if (refContext == null) {
            addToUnattachedStore((View) obj);
        } else {
            addToAttachedPageStore(refView, refContext);
        }
    }

    public Set<View> getPageStore(@NonNull Context context) {
        tryTransferToAttachedStore();
        return this.mAttachedPageStore.get(context);
    }
}
