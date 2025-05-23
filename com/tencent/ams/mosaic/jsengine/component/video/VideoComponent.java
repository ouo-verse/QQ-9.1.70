package com.tencent.ams.mosaic.jsengine.component.video;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface VideoComponent extends Component {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FullScreenMode {
        public static final int LANDSCAPE = 0;
        public static final int VERTICAL = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayFailReason {
        public static final int LOAD_FAILED = 3;
        public static final int NO_NETWORK = 1;
        public static final int OTHER = 4;
        public static final int PLAYER_ERROR = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScaleType {
        public static final String CENTER_CROP = "centerCrop";
        public static final String FIT_CENTER = "fitCenter";
        public static final String FIT_HEIGHT = "fitHeight";
        public static final String FIT_WIDTH = "fitWidth";
        public static final String FIT_XY = "fitXY";
    }

    int getCurrentPosition();

    int getDuration();

    boolean isFullScreen();

    boolean isPlaying();

    void pause();

    void seekTo(int i3);

    void setAutoPlay(boolean z16);

    void setControllerVisible(boolean z16);

    void setFullScreen(boolean z16);

    void setFullScreenMode(int i3);

    void setLoop(boolean z16);

    void setOutputMute(boolean z16);

    void setPlayListener(JSFunction jSFunction);

    void setPlayerEventListener(JSObject jSObject);

    void setPoster(String str);

    void setPosterData(String str);

    void setScaleType(String str);

    void setVideoParams(String str);

    void setVolume(int i3);

    void start();

    void stop();
}
