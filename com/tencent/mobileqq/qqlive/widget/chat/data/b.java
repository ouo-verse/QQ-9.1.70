package com.tencent.mobileqq.qqlive.widget.chat.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import sr4.g;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f273756a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f273757b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f273758c;

    /* renamed from: d, reason: collision with root package name */
    public String f273759d;

    /* renamed from: e, reason: collision with root package name */
    public DressUpBubble f273760e;

    /* renamed from: f, reason: collision with root package name */
    public pq4.c f273761f;

    /* renamed from: g, reason: collision with root package name */
    public List<g> f273762g;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273762g = new ArrayList();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "UserMedalInfo{uid=" + this.f273756a + ", showMedal=" + this.f273757b + ", showActivityMedal=" + this.f273758c + ", medalUrlPattern='" + this.f273759d + "', medalInfoNewList=" + this.f273762g + '}';
    }
}
