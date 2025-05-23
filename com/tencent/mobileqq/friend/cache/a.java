package com.tencent.mobileqq.friend.cache;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import vc1.d;
import vc1.e;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a<K, V extends Entity> implements c<K, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, vc1.c> f211585a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, d> f211586b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, e> f211587c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f211585a = new HashMap();
        this.f211586b = new HashMap();
        this.f211587c = new HashMap();
    }
}
