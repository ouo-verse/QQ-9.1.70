package com.tencent.mobileqq.confess;

import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class ConfessProxy extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQConcurrentHashMap<String, ConfessConvInfo> f202160a;

    /* renamed from: b, reason: collision with root package name */
    EntityManager f202161b;

    /* renamed from: c, reason: collision with root package name */
    private Object f202162c;

    public ConfessProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
            return;
        }
        this.f202161b = null;
        this.f202162c = new Object();
        this.f202160a = new QQConcurrentHashMap<>(Business.Conversation, "ConfessConvInfo");
    }

    public synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!this.f202160a.isEmpty()) {
            for (ConfessConvInfo confessConvInfo : this.f202160a.values()) {
                if (confessConvInfo.unreadCount > 0) {
                    confessConvInfo.unreadCount = 0;
                    i(confessConvInfo.uin, confessConvInfo.type, confessConvInfo);
                }
            }
        }
    }

    public synchronized Set<ConfessConvInfo> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        try {
            return new HashSet(this.f202160a.values());
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.confess.unread.ConfessProxy", 2, "cloneConfessConvInfoSet OOM!", e16);
            }
            return new HashSet();
        }
    }

    public synchronized long c(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        String e16 = ao.e(str, i3, i16);
        if (e16 != null && this.f202160a.containsKey(e16)) {
            return this.f202160a.get(e16).lastread;
        }
        return 0L;
    }

    public synchronized ConfessConvInfo d(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ConfessConvInfo) iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        String e16 = ao.e(str, i3, i16);
        if (e16 != null && this.f202160a.containsKey(e16)) {
            return this.f202160a.get(e16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.f202160a.clear();
        EntityManager entityManager = this.f202161b;
        if (entityManager != null && entityManager.isOpen()) {
            this.f202161b.close();
        }
    }

    public synchronized int e(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        String e16 = ao.e(str, i3, i16);
        if (e16 == null || !this.f202160a.containsKey(e16)) {
            return 0;
        }
        return this.f202160a.get(e16).unreadCount;
    }

    public synchronized void f(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        String e16 = ao.e(str, i3, i16);
        if (this.f202160a.containsKey(e16) && this.f202160a.get(e16) != null) {
            ConfessConvInfo confessConvInfo = this.f202160a.get(e16);
            h(str, i3, i16, confessConvInfo.lastread, confessConvInfo.unreadCount + i17);
        } else {
            h(str, i3, i16, 0L, i17);
        }
    }

    protected void g(String str, int i3, ConfessConvInfo confessConvInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), confessConvInfo);
        } else {
            this.proxyManager.addMsgQueue(str, i3, ConfessConvInfo.getConversationInfoTableName(), confessConvInfo, 3, null);
        }
    }

    public synchronized void h(String str, int i3, int i16, long j3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
            return;
        }
        String e16 = ao.e(str, i3, i16);
        if (this.f202160a.containsKey(e16) && this.f202160a.get(e16) != null) {
            ConfessConvInfo confessConvInfo = this.f202160a.get(e16);
            if (confessConvInfo.lastread == j3 && confessConvInfo.unreadCount == i17) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.confess.unread.ConfessProxy", 2, "insertOrUpdateUnread nochange=" + confessConvInfo.toString());
                }
            }
            confessConvInfo.lastread = j3;
            confessConvInfo.unreadCount = Math.max(0, i17);
            QLog.d("Q.confess.unread.ConfessProxy", 1, "insertOrUpdateUnread update=" + confessConvInfo.toString());
            i(str, i3, confessConvInfo);
        } else {
            ConfessConvInfo confessConvInfo2 = new ConfessConvInfo(str, i3, i16, j3, Math.max(0, i17));
            QLog.d("Q.confess.unread.ConfessProxy", 1, "insertOrUpdateUnread insert=" + confessConvInfo2.toString());
            this.f202160a.put(e16, confessConvInfo2);
            g(str, i3, confessConvInfo2);
        }
    }

    protected void i(String str, int i3, ConfessConvInfo confessConvInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), confessConvInfo);
        } else {
            this.proxyManager.addMsgQueue(str, i3, ConfessConvInfo.getConversationInfoTableName(), confessConvInfo, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
