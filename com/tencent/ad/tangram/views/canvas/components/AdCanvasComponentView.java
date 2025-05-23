package com.tencent.ad.tangram.views.canvas.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public abstract class AdCanvasComponentView extends FrameLayout implements AdViewStatus.Listener {
    private static final String TAG = "GdtCanvasComponentView";
    protected WeakReference<AdCanvasViewListener> canvasViewListener;

    @Nullable
    protected AdTimeStatistics loadTimeStatistics;

    @Nullable
    protected AdViewStatus status;

    public AdCanvasComponentView(@NonNull Context context) {
        super(context);
        this.loadTimeStatistics = new AdTimeStatistics();
    }

    private void notifyLoaded(boolean z16) {
        AdCanvasViewListener adCanvasViewListener;
        AdTimeStatistics adTimeStatistics;
        WeakReference<AdCanvasViewListener> weakReference = this.canvasViewListener;
        if (weakReference != null) {
            adCanvasViewListener = weakReference.get();
        } else {
            adCanvasViewListener = null;
        }
        if (adCanvasViewListener != null && (adTimeStatistics = this.loadTimeStatistics) != null) {
            long time = adTimeStatistics.getTime();
            if (time < 0) {
                return;
            }
            adCanvasViewListener.onLoaded(getData(), time, z16);
            return;
        }
        AdLog.e(TAG, "notifyLoaded error");
    }

    public boolean back() {
        return false;
    }

    @Nullable
    public AdCanvasData getCanvasData() {
        AdCanvasViewListener adCanvasViewListener;
        WeakReference<AdCanvasViewListener> weakReference = this.canvasViewListener;
        if (weakReference != null) {
            adCanvasViewListener = weakReference.get();
        } else {
            adCanvasViewListener = null;
        }
        if (adCanvasViewListener == null) {
            return null;
        }
        return adCanvasViewListener.getData();
    }

    @Nullable
    public abstract AdCanvasComponentData getData();

    @Nullable
    public abstract AdViewStatus getStatus();

    public void onActivityDestroy() {
        if (getStatus() != null) {
            getStatus().onActivityDestroy();
        }
    }

    public void onActivityPause() {
        if (getStatus() != null) {
            getStatus().onActivityPaused();
        }
    }

    public void onActivityResume() {
        if (getStatus() != null) {
            getStatus().onActivityResumed();
        }
    }

    public void onLocationChanged() {
        if (getStatus() != null) {
            getStatus().onLocationChanged();
        }
    }

    @Override // com.tencent.ad.tangram.views.AdViewStatus.Listener
    public void onViewPause() {
        if (getData() == null) {
            return;
        }
        AdLog.i(TAG, getData().f61339id + ": onViewPause");
    }

    @Override // com.tencent.ad.tangram.views.AdViewStatus.Listener
    public void onViewResume() {
        if (getData() == null) {
            return;
        }
        AdLog.i(TAG, getData().f61339id + ": onViewResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoad() {
        AdTimeStatistics adTimeStatistics = this.loadTimeStatistics;
        if (adTimeStatistics != null) {
            adTimeStatistics.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoad(boolean z16) {
        AdTimeStatistics adTimeStatistics = this.loadTimeStatistics;
        if (adTimeStatistics != null) {
            adTimeStatistics.stop();
        }
        notifyLoaded(z16);
        this.loadTimeStatistics = null;
    }

    public AdCanvasComponentView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadTimeStatistics = new AdTimeStatistics();
    }

    public AdCanvasComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference) {
        super(context);
        this.loadTimeStatistics = new AdTimeStatistics();
        this.canvasViewListener = weakReference;
    }
}
