package com.tencent.mobileqq.springhb.entry.worker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/DemoteLevel;", "", "(Ljava/lang/String;I)V", "LV1", "LV2", "LV3", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class DemoteLevel {
    private static final /* synthetic */ DemoteLevel[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DemoteLevel LV1;
    public static final DemoteLevel LV2;
    public static final DemoteLevel LV3;

    private static final /* synthetic */ DemoteLevel[] $values() {
        return new DemoteLevel[]{LV1, LV2, LV3};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60658);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LV1 = new DemoteLevel("LV1", 0);
        LV2 = new DemoteLevel("LV2", 1);
        LV3 = new DemoteLevel("LV3", 2);
        $VALUES = $values();
    }

    DemoteLevel(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static DemoteLevel valueOf(String str) {
        return (DemoteLevel) Enum.valueOf(DemoteLevel.class, str);
    }

    public static DemoteLevel[] values() {
        return (DemoteLevel[]) $VALUES.clone();
    }
}
