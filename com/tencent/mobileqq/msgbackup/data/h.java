package com.tencent.mobileqq.msgbackup.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f251142a;

    /* renamed from: b, reason: collision with root package name */
    public int f251143b;

    /* renamed from: c, reason: collision with root package name */
    public String f251144c;

    /* renamed from: d, reason: collision with root package name */
    public long f251145d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f251146e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f251147f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f251148g;

    /* renamed from: h, reason: collision with root package name */
    public volatile AtomicBoolean f251149h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f251150i;

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentHashMap<Long, i> f251151j;

    /* renamed from: k, reason: collision with root package name */
    private final ConcurrentHashMap<Long, i> f251152k;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251149h = new AtomicBoolean();
        this.f251151j = com.tencent.mobileqq.msgbackup.util.b.a();
        this.f251152k = com.tencent.mobileqq.msgbackup.util.b.a();
    }

    public synchronized ConcurrentHashMap<Long, i> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f251152k;
    }

    public synchronized ConcurrentHashMap<Long, i> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f251151j;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f251142a + "_" + this.f251143b;
    }
}
