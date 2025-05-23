package com.tencent.qqlive.tvkplayer.context;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDebugTrackingEventReporter {
    private final WeakReference<ITVKMediaPlayer> mPlayerManagerWeakReference;
    private final WeakReference<ITVKReportEventListener> mReportEventListenerWeakReference;

    public TVKDebugTrackingEventReporter(@NonNull ITVKMediaPlayer iTVKMediaPlayer, @NonNull ITVKReportEventListener iTVKReportEventListener) {
        this.mPlayerManagerWeakReference = new WeakReference<>(iTVKMediaPlayer);
        this.mReportEventListenerWeakReference = new WeakReference<>(iTVKReportEventListener);
    }

    public void sendEvent(ITVKReportEventListener.ReportEvent reportEvent, ITVKReportEventListener.ReportEventParams reportEventParams) {
        ITVKReportEventListener iTVKReportEventListener = this.mReportEventListenerWeakReference.get();
        if (iTVKReportEventListener != null) {
            iTVKReportEventListener.onReportEvent(this.mPlayerManagerWeakReference.get(), reportEvent, reportEventParams);
        }
    }
}
