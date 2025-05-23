package com.tencent.mobileqq.qqlive.gamedownloader;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/gamedownloader/GameDistributeDoActionEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", VirtualAppProxy.KEY_GAME_ID, "", "actionId", "", "(Ljava/lang/String;I)V", "getActionId", "()I", "getGameId", "()Ljava/lang/String;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class GameDistributeDoActionEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private final int actionId;

    @NotNull
    private final String gameId;

    public GameDistributeDoActionEvent(@NotNull String gameId, int i3) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gameId, i3);
        } else {
            this.gameId = gameId;
            this.actionId = i3;
        }
    }

    public final int getActionId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.actionId;
    }

    @NotNull
    public final String getGameId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.gameId;
    }
}
