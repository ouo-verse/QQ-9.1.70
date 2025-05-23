package com.tencent.mobileqq.model;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends com.tencent.mobileqq.troop.navigatebar.c implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final String f247241d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f247242e;

    /* renamed from: f, reason: collision with root package name */
    protected ConcurrentHashMap<String, com.tencent.mobileqq.troop.data.c> f247243f;

    public b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f247241d = "GuildInfoManager";
        this.f247243f = new ConcurrentHashMap<>();
        this.f247242e = qQAppInterface;
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.c
    public com.tencent.mobileqq.troop.data.c a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.data.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this.f247243f.get(str);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.c
    public com.tencent.mobileqq.troop.data.c b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.troop.data.c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return this.f247243f.remove(str);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.c
    public com.tencent.mobileqq.troop.data.c c(String str, com.tencent.mobileqq.troop.data.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.troop.data.c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) cVar);
        }
        com.tencent.mobileqq.troop.data.c cVar2 = this.f247243f.get(str);
        if (cVar != null && cVar.h()) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildInfoManager", 2, "messageInfoMap: update__:" + str + " " + cVar.f() + " " + cVar.h() + " " + cVar.g());
            }
            if (cVar2 == null) {
                com.tencent.mobileqq.troop.data.c cVar3 = new com.tencent.mobileqq.troop.data.c(cVar);
                this.f247243f.put(str, cVar3);
                if (QLog.isColorLevel()) {
                    QLog.d("GuildInfoManager", 2, "messageInfoMap: put:" + str);
                }
                return cVar3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GuildInfoManager", 2, "messageInfoMap: update:" + str);
            }
            this.f247243f.put(str, cVar);
            return cVar;
        }
        return cVar2;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
