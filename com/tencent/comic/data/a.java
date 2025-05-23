package com.tencent.comic.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f99287a;

    /* renamed from: b, reason: collision with root package name */
    public long f99288b;

    /* renamed from: c, reason: collision with root package name */
    public long f99289c;

    /* renamed from: d, reason: collision with root package name */
    public long f99290d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99287a = false;
        this.f99288b = 0L;
        this.f99289c = 0L;
        this.f99290d = 0L;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ComicCancelRedPointPopIntercetorParams{mHasRedDot=" + this.f99287a + ", mVisibleTime=" + this.f99288b + ", mInteractiveTime=" + this.f99289c + ", mLastTouchTime=" + this.f99290d + '}';
    }
}
