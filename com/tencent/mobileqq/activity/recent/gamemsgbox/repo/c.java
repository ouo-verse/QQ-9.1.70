package com.tencent.mobileqq.activity.recent.gamemsgbox.repo;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
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
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, GameUserInfo> f185561a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, gd1.a> f185562b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, GameBasicInfo> f185563c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f185561a = Collections.synchronizedMap(new HashMap());
        this.f185562b = Collections.synchronizedMap(new HashMap());
        this.f185563c = Collections.synchronizedMap(new HashMap());
    }

    private void f(EntityManager entityManager) {
        if (entityManager == null) {
            return;
        }
        try {
            List<? extends Entity> query = entityManager.query(GameBasicInfo.class);
            if (query != null && query.size() != 0) {
                for (Entity entity : query) {
                    if (entity instanceof GameBasicInfo) {
                        GameBasicInfo gameBasicInfo = (GameBasicInfo) entity;
                        if (!TextUtils.isEmpty(gameBasicInfo.mAppId)) {
                            this.f185563c.put(gameBasicInfo.mAppId, gameBasicInfo);
                        }
                    }
                }
                QLog.i("GameMsgUserInfoRepository", 1, "gameConfig.size:" + this.f185563c.size());
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgUserInfoRepository", 1, th5.getMessage());
        }
    }

    private void g() {
        synchronized (this.f185561a) {
            for (GameUserInfo gameUserInfo : this.f185561a.values()) {
                GameBasicInfo gameBasicInfo = this.f185563c.get(gameUserInfo.mAppId);
                if (gameBasicInfo == null) {
                    return;
                }
                this.f185562b.put(gameUserInfo.mRoleId, gd1.a.b(gameBasicInfo, gameUserInfo));
            }
        }
    }

    private void h(EntityManager entityManager) {
        if (entityManager == null) {
            return;
        }
        try {
            List<? extends Entity> query = entityManager.query(GameUserInfo.class);
            if (query != null && query.size() != 0) {
                for (Entity entity : query) {
                    if (entity instanceof GameUserInfo) {
                        GameUserInfo gameUserInfo = (GameUserInfo) entity;
                        if (!TextUtils.isEmpty(gameUserInfo.mRoleId)) {
                            b(gameUserInfo);
                        }
                    }
                }
                QLog.i("GameMsgUserInfoRepository", 1, "ursInfo.size:" + this.f185561a.size());
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgUserInfoRepository", 1, th5.getMessage());
        }
    }

    public void a(gd1.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else if (aVar != null && !TextUtils.isEmpty(aVar.f401937a)) {
            this.f185562b.put(aVar.f401937a, aVar);
        }
    }

    public void b(GameUserInfo gameUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gameUserInfo);
        } else if (gameUserInfo != null && !TextUtils.isEmpty(gameUserInfo.mRoleId)) {
            this.f185561a.put(gameUserInfo.mRoleId, gameUserInfo);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f185562b.clear();
        this.f185561a.clear();
        this.f185563c.clear();
    }

    public gd1.a d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (gd1.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f185562b.get(str);
    }

    public void e(EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) entityManager);
            return;
        }
        h(entityManager);
        f(entityManager);
        g();
    }
}
