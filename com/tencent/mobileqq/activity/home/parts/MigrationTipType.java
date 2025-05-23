package com.tencent.mobileqq.activity.home.parts;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/home/parts/MigrationTipType;", "", "(Ljava/lang/String;I)V", "Progress", "ProgressWithSpeedTip", "Fail", "LowMem", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class MigrationTipType {
    private static final /* synthetic */ MigrationTipType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MigrationTipType Fail;
    public static final MigrationTipType LowMem;
    public static final MigrationTipType Progress;
    public static final MigrationTipType ProgressWithSpeedTip;

    private static final /* synthetic */ MigrationTipType[] $values() {
        return new MigrationTipType[]{Progress, ProgressWithSpeedTip, Fail, LowMem};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Progress = new MigrationTipType("Progress", 0);
        ProgressWithSpeedTip = new MigrationTipType("ProgressWithSpeedTip", 1);
        Fail = new MigrationTipType("Fail", 2);
        LowMem = new MigrationTipType("LowMem", 3);
        $VALUES = $values();
    }

    MigrationTipType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MigrationTipType valueOf(String str) {
        return (MigrationTipType) Enum.valueOf(MigrationTipType.class, str);
    }

    public static MigrationTipType[] values() {
        return (MigrationTipType[]) $VALUES.clone();
    }
}
