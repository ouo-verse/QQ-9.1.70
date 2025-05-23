package com.tencent.state.square.media.decoder;

import com.tencent.state.square.media.IMediaDecoder;
import com.tencent.state.square.media.ISquareDecoder;
import com.tencent.state.square.media.SpeedController;
import com.tencent.state.square.media.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/media/decoder/BaseMediaDecoder;", "Lcom/tencent/state/square/media/IMediaDecoder;", "()V", "isLoopDecode", "", "()Z", "setLoopDecode", "(Z)V", "listener", "Lcom/tencent/state/square/media/ISquareDecoder$Listener;", "getListener", "()Lcom/tencent/state/square/media/ISquareDecoder$Listener;", "setListener", "(Lcom/tencent/state/square/media/ISquareDecoder$Listener;)V", "logPrefix", "", "getLogPrefix", "()Ljava/lang/String;", "setLogPrefix", "(Ljava/lang/String;)V", "loopCount", "", "getLoopCount", "()I", "setLoopCount", "(I)V", "speeder", "Lcom/tencent/state/square/media/SpeedController;", "getSpeeder", "()Lcom/tencent/state/square/media/SpeedController;", "initialize", "info", "Lcom/tencent/state/square/media/VideoInfo;", "controller", "Lcom/tencent/state/square/media/IMediaDecoder$Controller;", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class BaseMediaDecoder implements IMediaDecoder {
    private volatile boolean isLoopDecode;
    private ISquareDecoder.Listener listener;
    private String logPrefix = "";
    private int loopCount = 1;
    private final SpeedController speeder = new SpeedController();

    public final ISquareDecoder.Listener getListener() {
        return this.listener;
    }

    public final String getLogPrefix() {
        return this.logPrefix;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SpeedController getSpeeder() {
        return this.speeder;
    }

    @Override // com.tencent.state.square.media.IMediaDecoder
    public boolean initialize(VideoInfo info, IMediaDecoder.Controller controller) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.speeder.reset();
        this.speeder.setFixedPlaybackRate(info.getFrameRate());
        return true;
    }

    /* renamed from: isLoopDecode, reason: from getter */
    public final boolean getIsLoopDecode() {
        return this.isLoopDecode;
    }

    public final void setListener(ISquareDecoder.Listener listener) {
        this.listener = listener;
    }

    public final void setLogPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logPrefix = str;
    }

    public final void setLoopCount(int i3) {
        this.loopCount = i3;
    }

    public final void setLoopDecode(boolean z16) {
        this.isLoopDecode = z16;
    }
}
