package com.tencent.mobileqq.activity.recent.gamemsgbox.repo;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, GameSwitchConfig> f185560a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185560a = Collections.synchronizedMap(new HashMap());
        }
    }

    public void a(String str, GameSwitchConfig gameSwitchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) gameSwitchConfig);
        } else if (!TextUtils.isEmpty(str) && gameSwitchConfig != null) {
            if (this.f185560a.containsKey(str)) {
                this.f185560a.remove(str);
            }
            this.f185560a.put(str, gameSwitchConfig);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f185560a.clear();
        }
    }

    public GameSwitchConfig c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GameSwitchConfig) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f185560a.get(str);
    }

    public void d(EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) entityManager);
            return;
        }
        if (entityManager == null) {
            return;
        }
        try {
            List<? extends Entity> query = entityManager.query(GameSwitchConfig.class);
            if (query != null && query.size() != 0) {
                for (Entity entity : query) {
                    if (entity instanceof GameSwitchConfig) {
                        GameSwitchConfig gameSwitchConfig = (GameSwitchConfig) entity;
                        if (!TextUtils.isEmpty(gameSwitchConfig.mAppId)) {
                            this.f185560a.put(gameSwitchConfig.mAppId, gameSwitchConfig);
                        }
                    }
                }
                QLog.i("GameMsgSessionInfoManager", 1, "gameSwitchConfig.size:" + this.f185560a.size());
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgSessionInfoManager", 1, th5.getMessage());
        }
    }
}
