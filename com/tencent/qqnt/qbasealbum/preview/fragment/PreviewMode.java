package com.tencent.qqnt.qbasealbum.preview.fragment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewMode;", "", "(Ljava/lang/String;I)V", "NORMAL_MODE", "DIRECT_MODE", "SELECT_MODE", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class PreviewMode {
    private static final /* synthetic */ PreviewMode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PreviewMode DIRECT_MODE;
    public static final PreviewMode NORMAL_MODE;
    public static final PreviewMode SELECT_MODE;

    private static final /* synthetic */ PreviewMode[] $values() {
        return new PreviewMode[]{NORMAL_MODE, DIRECT_MODE, SELECT_MODE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NORMAL_MODE = new PreviewMode("NORMAL_MODE", 0);
        DIRECT_MODE = new PreviewMode("DIRECT_MODE", 1);
        SELECT_MODE = new PreviewMode("SELECT_MODE", 2);
        $VALUES = $values();
    }

    PreviewMode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PreviewMode valueOf(String str) {
        return (PreviewMode) Enum.valueOf(PreviewMode.class, str);
    }

    public static PreviewMode[] values() {
        return (PreviewMode[]) $VALUES.clone();
    }
}
