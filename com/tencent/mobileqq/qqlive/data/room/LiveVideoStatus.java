package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes17.dex */
public final class LiveVideoStatus {
    private static final /* synthetic */ LiveVideoStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LiveVideoStatus Pause;
    public static final LiveVideoStatus Restart;
    public static final LiveVideoStatus Resume;
    public static final LiveVideoStatus Start;
    public static final LiveVideoStatus Stop;
    public static final LiveVideoStatus Stuck;
    public static final LiveVideoStatus Unknown;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LiveVideoStatus liveVideoStatus = new LiveVideoStatus("Unknown", 0);
        Unknown = liveVideoStatus;
        LiveVideoStatus liveVideoStatus2 = new LiveVideoStatus("Start", 1);
        Start = liveVideoStatus2;
        LiveVideoStatus liveVideoStatus3 = new LiveVideoStatus("Stop", 2);
        Stop = liveVideoStatus3;
        LiveVideoStatus liveVideoStatus4 = new LiveVideoStatus("Pause", 3);
        Pause = liveVideoStatus4;
        LiveVideoStatus liveVideoStatus5 = new LiveVideoStatus("Stuck", 4);
        Stuck = liveVideoStatus5;
        LiveVideoStatus liveVideoStatus6 = new LiveVideoStatus("Restart", 5);
        Restart = liveVideoStatus6;
        LiveVideoStatus liveVideoStatus7 = new LiveVideoStatus("Resume", 6);
        Resume = liveVideoStatus7;
        $VALUES = new LiveVideoStatus[]{liveVideoStatus, liveVideoStatus2, liveVideoStatus3, liveVideoStatus4, liveVideoStatus5, liveVideoStatus6, liveVideoStatus7};
    }

    LiveVideoStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static LiveVideoStatus valueOf(String str) {
        return (LiveVideoStatus) Enum.valueOf(LiveVideoStatus.class, str);
    }

    public static LiveVideoStatus[] values() {
        return (LiveVideoStatus[]) $VALUES.clone();
    }
}
