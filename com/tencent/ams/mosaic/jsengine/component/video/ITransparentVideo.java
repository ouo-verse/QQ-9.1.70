package com.tencent.ams.mosaic.jsengine.component.video;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ITransparentVideo extends Component {
    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void pause();

    void seekTo(int i3);

    void setFormatType(int i3);

    void setLoop(boolean z16);

    void setPlayListener(JSFunction jSFunction);

    void setScaleType(String str);

    void setVideoParams(String str);

    void setVolume(int i3);

    void start();

    void stop();
}
