package com.tencent.ad.tangram.views.feedback;

import android.content.Context;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdFeedback {
    private static final String TAG = "AdWXCanvas";
    private static volatile AdFeedback sInstance;
    private WeakReference<AdFeedbackAdapter> mAdapter;

    AdFeedback() {
    }

    private AdFeedbackAdapter getAdapter() {
        WeakReference<AdFeedbackAdapter> weakReference = this.mAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdFeedback getInstance() {
        if (sInstance == null) {
            synchronized (AdFeedback.class) {
                if (sInstance == null) {
                    sInstance = new AdFeedback();
                }
            }
        }
        return sInstance;
    }

    public Integer getBackgroundColor(Context context) {
        AdFeedbackAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getBackgroundColor(context));
        }
        return null;
    }

    public Integer getButtonTextColor(Context context) {
        AdFeedbackAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getButtonTextColor(context));
        }
        return null;
    }

    public Integer getCancelButtonBackgroundColor(Context context) {
        AdFeedbackAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getCancelButtonBackgroundColor(context));
        }
        return null;
    }

    public Integer getCancelButtonTextColor(Context context) {
        AdFeedbackAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getCancelButtonTextColor(context));
        }
        return null;
    }

    public Integer getDividerColor(Context context) {
        AdFeedbackAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getDividerColor(context));
        }
        return null;
    }

    public Integer getIconColorFilter(Context context) {
        AdFeedbackAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getIconColorFilter(context));
        }
        return null;
    }

    public Integer getMainDividerColor(Context context) {
        AdFeedbackAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getMainDividerColor(context));
        }
        return null;
    }

    public void setAdapter(WeakReference<AdFeedbackAdapter> weakReference) {
        this.mAdapter = weakReference;
    }
}
