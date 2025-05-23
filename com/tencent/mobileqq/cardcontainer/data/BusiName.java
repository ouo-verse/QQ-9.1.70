package com.tencent.mobileqq.cardcontainer.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/BusiName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "Birthday", "SelfBirthday", "Qzone", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class BusiName {
    private static final /* synthetic */ BusiName[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final BusiName Birthday;
    public static final BusiName Qzone;
    public static final BusiName SelfBirthday;

    @NotNull
    private final String value;

    private static final /* synthetic */ BusiName[] $values() {
        return new BusiName[]{Birthday, SelfBirthday, Qzone};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        Birthday = new BusiName("Birthday", 0, "birthday");
        SelfBirthday = new BusiName("SelfBirthday", 1, "self_birthday");
        Qzone = new BusiName("Qzone", 2, "qzone");
        $VALUES = $values();
    }

    BusiName(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.value = str2;
        }
    }

    public static BusiName valueOf(String str) {
        return (BusiName) Enum.valueOf(BusiName.class, str);
    }

    public static BusiName[] values() {
        return (BusiName[]) $VALUES.clone();
    }

    @NotNull
    public final String getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.value;
    }
}
