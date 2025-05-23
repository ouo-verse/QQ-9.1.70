package com.tencent.state.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.square.detail.MainScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/event/ChatAddUinToSquare;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "uin", "", "relationType", "", "mainScene", "Lcom/tencent/state/square/detail/MainScene;", "locateTo", "", "(Ljava/lang/String;ILcom/tencent/state/square/detail/MainScene;Z)V", "getLocateTo", "()Z", "getMainScene", "()Lcom/tencent/state/square/detail/MainScene;", "getRelationType", "()I", "getUin", "()Ljava/lang/String;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class ChatAddUinToSquare extends SimpleBaseEvent {
    private final boolean locateTo;
    private final MainScene mainScene;
    private final int relationType;
    private final String uin;

    public ChatAddUinToSquare(String uin, int i3, MainScene mainScene, boolean z16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(mainScene, "mainScene");
        this.uin = uin;
        this.relationType = i3;
        this.mainScene = mainScene;
        this.locateTo = z16;
    }

    public final boolean getLocateTo() {
        return this.locateTo;
    }

    public final MainScene getMainScene() {
        return this.mainScene;
    }

    public final int getRelationType() {
        return this.relationType;
    }

    public final String getUin() {
        return this.uin;
    }
}
