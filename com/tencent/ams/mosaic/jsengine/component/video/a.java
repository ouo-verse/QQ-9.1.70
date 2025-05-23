package com.tencent.ams.mosaic.jsengine.component.video;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.component.video.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0694a {
        void onBackClick(@NonNull a aVar);

        void onFullScreenClick(@NonNull a aVar);

        void onMuteClick(@NonNull a aVar);

        void onPlayClick(@NonNull a aVar);

        void onProgressSeeking(int i3);

        void onStartProgressSeek(@NonNull a aVar);

        void onStopProgressSeek(@NonNull a aVar, int i3);
    }

    @NonNull
    View getView();

    void onVideoSizeChanged(int i3, int i16);

    void setControllerViewListener(InterfaceC0694a interfaceC0694a);

    void setCurrentTime(int i3);

    void setFullScreen(boolean z16, boolean z17);

    void setMute(boolean z16);

    void setPaused(boolean z16);

    void setTotalTime(int i3);

    void setVisibility(int i3);
}
