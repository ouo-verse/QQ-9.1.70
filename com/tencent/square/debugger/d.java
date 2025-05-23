package com.tencent.square.debugger;

import com.tencent.state.square.media.ISquarePlayer;
import com.tencent.state.square.media.StopFrom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/square/debugger/d;", "Lcom/tencent/state/square/media/ISquarePlayer$Listener;", "", "onVideoStart", "onVideoFirstFrame", "onVideoResume", "onVideoPause", "onVideoLoopStart", "onVideoLoop", "Lcom/tencent/state/square/media/StopFrom;", "from", "onVideoStop", "onVideoDestroy", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class d implements ISquarePlayer.Listener {
    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoStop(StopFrom from) {
        Intrinsics.checkNotNullParameter(from, "from");
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoDestroy() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoFirstFrame() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoLoop() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoLoopStart() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoPause() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoResume() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoStart() {
    }
}
