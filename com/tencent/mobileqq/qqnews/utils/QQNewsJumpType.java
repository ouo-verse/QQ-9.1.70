package com.tencent.mobileqq.qqnews.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqnews/utils/QQNewsJumpType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "DEFAULT", "DETAIL_PAGE", "qqnews-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQNewsJumpType {
    private static final /* synthetic */ QQNewsJumpType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QQNewsJumpType DEFAULT;
    public static final QQNewsJumpType DETAIL_PAGE;
    private final int value;

    private static final /* synthetic */ QQNewsJumpType[] $values() {
        return new QQNewsJumpType[]{DEFAULT, DETAIL_PAGE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20901);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        DEFAULT = new QQNewsJumpType("DEFAULT", 0, 0);
        DETAIL_PAGE = new QQNewsJumpType("DETAIL_PAGE", 1, 1);
        $VALUES = $values();
    }

    QQNewsJumpType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static QQNewsJumpType valueOf(String str) {
        return (QQNewsJumpType) Enum.valueOf(QQNewsJumpType.class, str);
    }

    public static QQNewsJumpType[] values() {
        return (QQNewsJumpType[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
