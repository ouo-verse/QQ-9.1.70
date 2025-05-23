package com.tencent.trackrecordlib.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class EventTopic {
    static IPatchRedirector $redirector_;
    public static final EventTopic EVENT_APP;
    public static final EventTopic EVENT_BASE;
    public static final EventTopic EVENT_CAL;
    public static final EventTopic EVENT_EXTERNAL_HEADER;
    public static final EventTopic EVENT_EXTERNAL_QAPM_LAG;
    public static final EventTopic EVENT_EXTERNAL_QAPM_SIGKILL;
    public static final EventTopic EVENT_EXTRA;
    public static final EventTopic EVENT_PAGE_CHANGE;
    public static final EventTopic EVENT_QAPM_PERF;
    public static final EventTopic EVENT_RDM_CRASH;
    public static final EventTopic EVENT_TAG;
    public static final EventTopic EVENT_TRACE;
    public static final EventTopic EVENT_UI_ACTION;

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ EventTopic[] f381116a;
    private int seq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11506);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        EventTopic eventTopic = new EventTopic("EVENT_BASE", 0, 1);
        EVENT_BASE = eventTopic;
        EventTopic eventTopic2 = new EventTopic("EVENT_APP", 1, 2);
        EVENT_APP = eventTopic2;
        EventTopic eventTopic3 = new EventTopic("EVENT_UI_ACTION", 2, 3);
        EVENT_UI_ACTION = eventTopic3;
        EventTopic eventTopic4 = new EventTopic("EVENT_PAGE_CHANGE", 3, 4);
        EVENT_PAGE_CHANGE = eventTopic4;
        EventTopic eventTopic5 = new EventTopic("EVENT_TAG", 4, 5);
        EVENT_TAG = eventTopic5;
        EventTopic eventTopic6 = new EventTopic("EVENT_TRACE", 5, 6);
        EVENT_TRACE = eventTopic6;
        EventTopic eventTopic7 = new EventTopic("EVENT_CAL", 6, 7);
        EVENT_CAL = eventTopic7;
        EventTopic eventTopic8 = new EventTopic("EVENT_RDM_CRASH", 7, 8);
        EVENT_RDM_CRASH = eventTopic8;
        EventTopic eventTopic9 = new EventTopic("EVENT_QAPM_PERF", 8, 9);
        EVENT_QAPM_PERF = eventTopic9;
        EventTopic eventTopic10 = new EventTopic("EVENT_EXTERNAL_HEADER", 9, 1000);
        EVENT_EXTERNAL_HEADER = eventTopic10;
        EventTopic eventTopic11 = new EventTopic("EVENT_EXTERNAL_QAPM_SIGKILL", 10, 1001);
        EVENT_EXTERNAL_QAPM_SIGKILL = eventTopic11;
        EventTopic eventTopic12 = new EventTopic("EVENT_EXTERNAL_QAPM_LAG", 11, 1002);
        EVENT_EXTERNAL_QAPM_LAG = eventTopic12;
        EventTopic eventTopic13 = new EventTopic("EVENT_EXTRA", 12, 1003);
        EVENT_EXTRA = eventTopic13;
        f381116a = new EventTopic[]{eventTopic, eventTopic2, eventTopic3, eventTopic4, eventTopic5, eventTopic6, eventTopic7, eventTopic8, eventTopic9, eventTopic10, eventTopic11, eventTopic12, eventTopic13};
    }

    EventTopic(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.seq = i16;
        }
    }

    public static EventTopic findEventTopic(int i3) {
        for (EventTopic eventTopic : values()) {
            if (eventTopic.getSeq() == i3) {
                return eventTopic;
            }
        }
        return null;
    }

    public static EventTopic valueOf(String str) {
        return (EventTopic) Enum.valueOf(EventTopic.class, str);
    }

    public static EventTopic[] values() {
        return (EventTopic[]) f381116a.clone();
    }

    public int getSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.seq;
    }

    public void setSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.seq = i3;
        }
    }
}
