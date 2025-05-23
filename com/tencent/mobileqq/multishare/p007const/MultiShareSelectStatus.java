package com.tencent.mobileqq.multishare.p007const;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/multishare/const/MultiShareSelectStatus;", "", "(Ljava/lang/String;I)V", "UNSELECTED", "SELECTING", "SELECTED", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MultiShareSelectStatus {
    private static final /* synthetic */ MultiShareSelectStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MultiShareSelectStatus SELECTED;
    public static final MultiShareSelectStatus SELECTING;
    public static final MultiShareSelectStatus UNSELECTED;

    private static final /* synthetic */ MultiShareSelectStatus[] $values() {
        return new MultiShareSelectStatus[]{UNSELECTED, SELECTING, SELECTED};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39798);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        UNSELECTED = new MultiShareSelectStatus("UNSELECTED", 0);
        SELECTING = new MultiShareSelectStatus("SELECTING", 1);
        SELECTED = new MultiShareSelectStatus("SELECTED", 2);
        $VALUES = $values();
    }

    MultiShareSelectStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MultiShareSelectStatus valueOf(String str) {
        return (MultiShareSelectStatus) Enum.valueOf(MultiShareSelectStatus.class, str);
    }

    public static MultiShareSelectStatus[] values() {
        return (MultiShareSelectStatus[]) $VALUES.clone();
    }
}
