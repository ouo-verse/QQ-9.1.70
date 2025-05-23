package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static int a(EventData eventData) {
        IPatchRedirector iPatchRedirector = EventData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) eventData)).intValue();
        }
        return eventData.getTotalAttributeCount() - eventData.getAttributes().size();
    }

    public static EventData b(long j3, String str, Attributes attributes) {
        IPatchRedirector iPatchRedirector = EventData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (EventData) iPatchRedirector.redirect((short) 1, Long.valueOf(j3), str, attributes);
        }
        return ImmutableEventData.create(j3, str, attributes);
    }

    public static EventData c(long j3, String str, Attributes attributes, int i3) {
        IPatchRedirector iPatchRedirector = EventData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EventData) iPatchRedirector.redirect((short) 2, Long.valueOf(j3), str, attributes, Integer.valueOf(i3));
        }
        return ImmutableEventData.create(j3, str, attributes, i3);
    }
}
