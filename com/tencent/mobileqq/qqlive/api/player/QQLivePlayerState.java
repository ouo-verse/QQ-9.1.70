package com.tencent.mobileqq.qqlive.api.player;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "IDLE", "PREPARING", "PREPARED", "STARTED", "STOPPED", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLivePlayerState {
    private static final /* synthetic */ QQLivePlayerState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QQLivePlayerState IDLE;
    public static final QQLivePlayerState PREPARED;
    public static final QQLivePlayerState PREPARING;
    public static final QQLivePlayerState STARTED;
    public static final QQLivePlayerState STOPPED;
    private final int state;

    private static final /* synthetic */ QQLivePlayerState[] $values() {
        return new QQLivePlayerState[]{IDLE, PREPARING, PREPARED, STARTED, STOPPED};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        IDLE = new QQLivePlayerState("IDLE", 0, 0);
        PREPARING = new QQLivePlayerState("PREPARING", 1, 2);
        PREPARED = new QQLivePlayerState("PREPARED", 2, 3);
        STARTED = new QQLivePlayerState("STARTED", 3, 4);
        STOPPED = new QQLivePlayerState("STOPPED", 4, 6);
        $VALUES = $values();
    }

    QQLivePlayerState(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.state = i16;
        }
    }

    public static QQLivePlayerState valueOf(String str) {
        return (QQLivePlayerState) Enum.valueOf(QQLivePlayerState.class, str);
    }

    public static QQLivePlayerState[] values() {
        return (QQLivePlayerState[]) $VALUES.clone();
    }

    public final int getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.state;
    }
}
