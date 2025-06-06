package com.tencent.state.square.media;

import android.view.Surface;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/media/IMediaDecoder;", "", "error", "", "code", "", "e", "", "execute", "isRenderDirectly", "", "initialize", "info", "Lcom/tencent/state/square/media/VideoInfo;", "controller", "Lcom/tencent/state/square/media/IMediaDecoder$Controller;", "release", "reset", "start", "surface", "Landroid/view/Surface;", "stop", "from", "Lcom/tencent/state/square/media/StopFrom;", "Controller", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMediaDecoder {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/media/IMediaDecoder$Controller;", "", "checkPauseState", "", "isExecuting", "", "stopWhenComplete", "square_media_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface Controller {
        void checkPauseState();

        boolean isExecuting();

        void stopWhenComplete();
    }

    void error(int code, Throwable e16);

    void execute(boolean isRenderDirectly);

    boolean initialize(VideoInfo info, Controller controller);

    void release();

    void reset();

    void start(VideoInfo info, Surface surface);

    void stop(StopFrom from);
}
