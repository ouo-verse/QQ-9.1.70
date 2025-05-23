package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class TuxEnvironment {
    private static final /* synthetic */ TuxEnvironment[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TuxEnvironment DEVELOP;
    public static final TuxEnvironment PRE_RELEASE;
    public static final TuxEnvironment RELEASE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tuxmetersdk.export.config.TuxEnvironment$1, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tuxmetersdk$export$config$TuxEnvironment;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7499);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TuxEnvironment.values().length];
            $SwitchMap$com$tencent$tuxmetersdk$export$config$TuxEnvironment = iArr;
            try {
                iArr[TuxEnvironment.DEVELOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tuxmetersdk$export$config$TuxEnvironment[TuxEnvironment.PRE_RELEASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TuxEnvironment tuxEnvironment = new TuxEnvironment("RELEASE", 0);
        RELEASE = tuxEnvironment;
        TuxEnvironment tuxEnvironment2 = new TuxEnvironment("DEVELOP", 1);
        DEVELOP = tuxEnvironment2;
        TuxEnvironment tuxEnvironment3 = new TuxEnvironment("PRE_RELEASE", 2);
        PRE_RELEASE = tuxEnvironment3;
        $VALUES = new TuxEnvironment[]{tuxEnvironment, tuxEnvironment2, tuxEnvironment3};
    }

    TuxEnvironment(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TuxEnvironment deepCopy(TuxEnvironment tuxEnvironment) {
        if (tuxEnvironment == null) {
            return RELEASE;
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$tuxmetersdk$export$config$TuxEnvironment[tuxEnvironment.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return RELEASE;
            }
            return PRE_RELEASE;
        }
        return DEVELOP;
    }

    public static String toStorageName(TuxEnvironment tuxEnvironment) {
        return deepCopy(tuxEnvironment).name().toLowerCase();
    }

    public static TuxEnvironment valueOf(String str) {
        return (TuxEnvironment) Enum.valueOf(TuxEnvironment.class, str);
    }

    public static TuxEnvironment[] values() {
        return (TuxEnvironment[]) $VALUES.clone();
    }
}
