package com.tencent.ad.tangram.dialog;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

@AdKeep
/* loaded from: classes3.dex */
public final class AdProgressDialog {
    private static volatile AdProgressDialog sInstance;
    private WeakReference<AdProgressDialogAdapter> adapter;

    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public String message;
        public int yOffset = 0;
        public boolean cancelable = false;
    }

    AdProgressDialog() {
    }

    @Nullable
    private AdProgressDialogAdapter getAdapter() {
        WeakReference<AdProgressDialogAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdProgressDialog getInstance() {
        if (sInstance == null) {
            synchronized (AdProgressDialog.class) {
                if (sInstance == null) {
                    sInstance = new AdProgressDialog();
                }
            }
        }
        return sInstance;
    }

    public void dismiss() {
        AdProgressDialogAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.dismiss();
        }
    }

    public boolean isShowing(Context context) {
        Boolean bool;
        AdProgressDialogAdapter adapter = getAdapter();
        if (adapter != null) {
            bool = Boolean.valueOf(adapter.isShowing(context));
        } else {
            bool = null;
        }
        return bool.booleanValue();
    }

    public void setAdapter(WeakReference<AdProgressDialogAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public void show(Context context, Params params) {
        AdProgressDialogAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.show(context, params);
        }
    }
}
