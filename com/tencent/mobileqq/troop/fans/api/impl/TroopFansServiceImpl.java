package com.tencent.mobileqq.troop.fans.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.fans.api.ITroopFansService;
import com.tencent.mobileqq.troop.fans.data.a;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public class TroopFansServiceImpl implements ITroopFansService {
    static IPatchRedirector $redirector_;
    AppRuntime app;
    protected ConcurrentHashMap<String, a.C8682a> mTroopIdolInfoCache;

    public TroopFansServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.fans.api.ITroopFansService
    public a.C8682a getTroopIdolInfoDate(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a.C8682a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            return this.mTroopIdolInfoCache.get(str);
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = appRuntime;
        if (this.mTroopIdolInfoCache == null) {
            synchronized (this) {
                if (this.mTroopIdolInfoCache == null) {
                    this.mTroopIdolInfoCache = new ConcurrentHashMap<>();
                }
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.fans.api.ITroopFansService
    public void setTroopIdolInfoDate(String str, a.C8682a c8682a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) c8682a);
        } else if (c8682a != null && !TextUtils.isEmpty(str)) {
            this.mTroopIdolInfoCache.put(str, c8682a);
        }
    }
}
