package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes17.dex */
public final class ExitRoomType {
    private static final /* synthetic */ ExitRoomType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ExitRoomType HeartBeatKick;
    public static final ExitRoomType StopLiveKick;
    public static final ExitRoomType UserLeave;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ExitRoomType exitRoomType = new ExitRoomType("UserLeave", 0);
        UserLeave = exitRoomType;
        ExitRoomType exitRoomType2 = new ExitRoomType("HeartBeatKick", 1);
        HeartBeatKick = exitRoomType2;
        ExitRoomType exitRoomType3 = new ExitRoomType("StopLiveKick", 2);
        StopLiveKick = exitRoomType3;
        $VALUES = new ExitRoomType[]{exitRoomType, exitRoomType2, exitRoomType3};
    }

    ExitRoomType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ExitRoomType valueOf(String str) {
        return (ExitRoomType) Enum.valueOf(ExitRoomType.class, str);
    }

    public static ExitRoomType[] values() {
        return (ExitRoomType[]) $VALUES.clone();
    }
}
