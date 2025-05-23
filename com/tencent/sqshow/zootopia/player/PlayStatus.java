package com.tencent.sqshow.zootopia.player;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/PlayStatus;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NOT_PREPARE", "PREPARING", "PREPARED", "PLAY_STATUS_PLAYING", "PLAY_STATUS_STOP", "PLAY_STATUS_COMPLETE", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public enum PlayStatus {
    NOT_PREPARE(0),
    PREPARING(1),
    PREPARED(2),
    PLAY_STATUS_PLAYING(3),
    PLAY_STATUS_STOP(4),
    PLAY_STATUS_COMPLETE(5);

    private final int value;

    PlayStatus(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
