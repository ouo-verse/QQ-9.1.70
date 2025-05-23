package com.tencent.state.square.data;

import com.tencent.tmdownloader.a;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/data/PlayState;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", a.CONNTECTSTATE_INIT, "PLAYING", "PLAY", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum PlayState {
    INIT(0),
    PLAYING(1),
    PLAY(2);

    private final int type;

    PlayState(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }
}
