package com.tencent.ad.tangram.views;

import android.view.View;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdViewStatus {
    public static final int CREATED = 0;
    public static final int DESTROYED = 3;
    public static final int PAUSED = 2;
    public static final int RESUMED = 1;
    private WeakReference<Listener> listener;
    private float percentageResume;
    private int statusForActivity;
    private WeakReference<View> view;
    public boolean visible;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface Listener {
        void onViewPause();

        void onViewResume();
    }

    public AdViewStatus(WeakReference<View> weakReference, WeakReference<Listener> weakReference2) {
        this(weakReference, weakReference2, 0.0f);
    }

    private void notifyStatusChanged(boolean z16) {
        Listener listener;
        boolean z17;
        WeakReference<Listener> weakReference = this.listener;
        if (weakReference != null) {
            listener = weakReference.get();
        } else {
            listener = null;
        }
        if (listener != null && z16 != (z17 = this.visible)) {
            if (z17) {
                listener.onViewResume();
            } else {
                listener.onViewPause();
            }
        }
    }

    public void onActivityDestroy() {
        this.statusForActivity = 3;
        onLocationChanged();
    }

    public void onActivityPaused() {
        this.statusForActivity = 2;
        onLocationChanged();
    }

    public void onActivityResumed() {
        this.statusForActivity = 1;
        WeakReference<View> weakReference = this.view;
        if (weakReference != null && weakReference.get() != null) {
            this.view.get().postDelayed(new Runnable() { // from class: com.tencent.ad.tangram.views.AdViewStatus.1
                @Override // java.lang.Runnable
                public void run() {
                    AdViewStatus.this.onLocationChanged();
                }
            }, 500L);
        }
    }

    public void onLocationChanged() {
        boolean z16 = this.visible;
        int i3 = this.statusForActivity;
        boolean z17 = false;
        if (i3 == 0) {
            this.visible = false;
        } else if (i3 == 3) {
            this.visible = false;
        } else if (i3 == 1) {
            WeakReference<View> weakReference = this.view;
            if (weakReference != null && weakReference.get() != null) {
                if (AdUIUtils.getPercentageOfGlobalVisibleRect(this.view.get()) > this.percentageResume) {
                    z17 = true;
                }
                this.visible = z17;
            } else {
                this.visible = false;
            }
        } else if (i3 == 2) {
            this.visible = false;
        }
        notifyStatusChanged(z16);
    }

    public AdViewStatus(WeakReference<View> weakReference, WeakReference<Listener> weakReference2, float f16) {
        this.view = weakReference;
        this.listener = weakReference2;
        this.percentageResume = f16;
        this.statusForActivity = 0;
        this.visible = false;
    }
}
