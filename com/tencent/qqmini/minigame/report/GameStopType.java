package com.tencent.qqmini.minigame.report;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqmini/minigame/report/GameStopType;", "", "reportValue", "", "(Ljava/lang/String;II)V", "getReportValue", "()I", "CAPSULE_BUTTON", "BACK_PRESS", "HOME_PRESS", "RECENT_PRESS", "SCREEN_OFF", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public enum GameStopType {
    CAPSULE_BUTTON(1),
    BACK_PRESS(2),
    HOME_PRESS(3),
    RECENT_PRESS(4),
    SCREEN_OFF(5);

    private final int reportValue;

    GameStopType(int i3) {
        this.reportValue = i3;
    }

    public final int getReportValue() {
        return this.reportValue;
    }
}
