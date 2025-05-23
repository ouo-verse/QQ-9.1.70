package com.tencent.qqnt.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/trace/BuildType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PUBLIC_RELEASE", "TEST_DEBUG", "RDM_RELEASE", "GRAY_RELEASE", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class BuildType {
    private static final /* synthetic */ BuildType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final BuildType GRAY_RELEASE;
    public static final BuildType PUBLIC_RELEASE;
    public static final BuildType RDM_RELEASE;
    public static final BuildType TEST_DEBUG;
    private final int value;

    private static final /* synthetic */ BuildType[] $values() {
        return new BuildType[]{PUBLIC_RELEASE, TEST_DEBUG, RDM_RELEASE, GRAY_RELEASE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64151);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        PUBLIC_RELEASE = new BuildType("PUBLIC_RELEASE", 0, 0);
        TEST_DEBUG = new BuildType("TEST_DEBUG", 1, 1);
        RDM_RELEASE = new BuildType("RDM_RELEASE", 2, 2);
        GRAY_RELEASE = new BuildType("GRAY_RELEASE", 3, 3);
        $VALUES = $values();
    }

    BuildType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static BuildType valueOf(String str) {
        return (BuildType) Enum.valueOf(BuildType.class, str);
    }

    public static BuildType[] values() {
        return (BuildType[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
