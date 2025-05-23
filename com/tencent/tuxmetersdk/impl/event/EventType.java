package com.tencent.tuxmetersdk.impl.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class EventType {
    private static final /* synthetic */ EventType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final EventType NORMAL;
    public static final EventType REALTIME;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11150);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EventType eventType = new EventType(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0);
        NORMAL = eventType;
        EventType eventType2 = new EventType("REALTIME", 1);
        REALTIME = eventType2;
        $VALUES = new EventType[]{eventType, eventType2};
    }

    EventType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static EventType valueOf(String str) {
        return (EventType) Enum.valueOf(EventType.class, str);
    }

    public static EventType[] values() {
        return (EventType[]) $VALUES.clone();
    }
}
