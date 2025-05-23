package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends BaseCacheManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195278d;

    public a(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195278d = qQAppInterface;
        }
    }

    @Override // com.tencent.mobileqq.app.asyncdb.BaseCacheManager
    protected BaseCache createCacheByName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseCache) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (i3 != 3) {
            return null;
        }
        return ((IPicFactory) QRoute.api(IPicFactory.class)).getCache(this.f195278d, this.dbDelayManager);
    }
}
