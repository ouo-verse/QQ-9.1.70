package com.tencent.mobileqq.qqlive.room.gamedownloader.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/ActionId;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "START_OR_RESUME_DOWNLOAD", "PAUSE_DOWNLOAD", "INSTALL_GAME", "OPEN_GAME", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ActionId {
    private static final /* synthetic */ ActionId[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ActionId INSTALL_GAME;
    public static final ActionId OPEN_GAME;
    public static final ActionId PAUSE_DOWNLOAD;
    public static final ActionId START_OR_RESUME_DOWNLOAD;
    private final int value;

    private static final /* synthetic */ ActionId[] $values() {
        return new ActionId[]{START_OR_RESUME_DOWNLOAD, PAUSE_DOWNLOAD, INSTALL_GAME, OPEN_GAME};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28816);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        START_OR_RESUME_DOWNLOAD = new ActionId("START_OR_RESUME_DOWNLOAD", 0, 1000);
        PAUSE_DOWNLOAD = new ActionId("PAUSE_DOWNLOAD", 1, 1001);
        INSTALL_GAME = new ActionId("INSTALL_GAME", 2, 1002);
        OPEN_GAME = new ActionId("OPEN_GAME", 3, 1003);
        $VALUES = $values();
    }

    ActionId(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static ActionId valueOf(String str) {
        return (ActionId) Enum.valueOf(ActionId.class, str);
    }

    public static ActionId[] values() {
        return (ActionId[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
