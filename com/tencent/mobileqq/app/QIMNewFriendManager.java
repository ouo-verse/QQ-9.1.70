package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QIMNewFriendManager implements Manager {
    static IPatchRedirector $redirector_;
    private AtomicBoolean C;
    private WeakReference<a> D;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f194954d;

    /* renamed from: e, reason: collision with root package name */
    EntityManager f194955e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f194956f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<QIMNotifyAddFriend> f194957h;

    /* renamed from: i, reason: collision with root package name */
    private Object f194958i;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f194959m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a();
    }

    public QIMNewFriendManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194957h = new ArrayList<>();
        this.f194958i = new Object();
        this.f194959m = new AtomicBoolean(false);
        this.C = new AtomicBoolean(false);
        this.f194954d = qQAppInterface;
        this.f194955e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        this.f194956f = new Handler(Looper.getMainLooper());
        ThreadManagerV2.postImmediately(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.app.QIMNewFriendManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f194960d;

            {
                this.f194960d = qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QIMNewFriendManager.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((FlashChatManager) this.f194960d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).w();
                }
            }
        }, null, true);
    }

    public void a(QIMNotifyAddFriend qIMNotifyAddFriend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qIMNotifyAddFriend);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMNewFriendManager", 2, "addNewNotifyFromQIM " + qIMNotifyAddFriend.toString());
        }
        if (!this.f194959m.get()) {
            d();
        }
        synchronized (this.f194958i) {
            if (this.f194957h.contains(qIMNotifyAddFriend)) {
                if (QLog.isColorLevel()) {
                    QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM already has data !");
                }
                return;
            }
            this.f194957h.add(qIMNotifyAddFriend);
            this.f194955e.persistOrReplace(qIMNotifyAddFriend);
            ((INewFriendService) this.f194954d.getRuntimeService(INewFriendService.class)).reloadNewFriendMsg();
            if (this.f194954d.isLogin()) {
                ((IAppBadgeService) this.f194954d.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            }
            FlashChatManager flashChatManager = (FlashChatManager) this.f194954d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
            if (flashChatManager.f() && flashChatManager.g()) {
                WeakReference<a> weakReference = this.D;
                if (weakReference != null) {
                    a aVar = weakReference.get();
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM|mListener is null ");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM | popUp enable close " + qIMNotifyAddFriend.uin);
            }
        }
    }

    public void b(QIMNotifyAddFriend qIMNotifyAddFriend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qIMNotifyAddFriend);
            return;
        }
        if (qIMNotifyAddFriend == null) {
            return;
        }
        synchronized (this.f194958i) {
            Iterator<QIMNotifyAddFriend> it = this.f194957h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().uin == qIMNotifyAddFriend.uin) {
                    it.remove();
                    break;
                }
            }
            this.f194954d.getEntityManagerFactory().createEntityManager().remove(qIMNotifyAddFriend);
        }
    }

    public ArrayList<com.tencent.mobileqq.newfriend.msg.r> c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        FlashChatManager flashChatManager = (FlashChatManager) this.f194954d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        ArrayList<com.tencent.mobileqq.newfriend.msg.r> arrayList = new ArrayList<>();
        if (!this.f194959m.get()) {
            d();
        }
        if (flashChatManager.f()) {
            synchronized (this.f194958i) {
                if (this.f194957h.size() > 0) {
                    Iterator<QIMNotifyAddFriend> it = this.f194957h.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new com.tencent.mobileqq.newfriend.msg.r(it.next()));
                    }
                    this.C.set(true);
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMNewFriendManager", 2, "getQIMNotifyAddFriendsMsg | list size = " + arrayList.size() + z16);
                    }
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("QIMNewFriendManager", 2, "getQIMNotifyAddFriendsMsg qim notify has close");
        }
        return arrayList;
    }

    public ArrayList<QIMNotifyAddFriend> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (this.f194958i) {
            ArrayList arrayList = (ArrayList) this.f194955e.query(QIMNotifyAddFriend.class);
            if (arrayList != null && arrayList.size() > 0) {
                this.f194957h.addAll(arrayList);
            }
        }
        this.f194959m.set(true);
        return this.f194957h;
    }

    public String e(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16));
        }
        String y16 = com.tencent.mobileqq.utils.ac.y(this.f194954d, String.valueOf(j16));
        if (TextUtils.isEmpty(y16)) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMNewFriendManager", 2, "getQQInfoFromQQUin|uinStr is null " + j16);
                return null;
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMNewFriendManager", 2, "getQQInfoFromQQUin|nickName " + y16);
        }
        return "QQ\u597d\u53cb\uff1a" + y16;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.C.get()) {
            synchronized (this.f194958i) {
                EntityTransaction transaction = this.f194955e.getTransaction();
                try {
                    try {
                        transaction.begin();
                        Iterator<QIMNotifyAddFriend> it = this.f194957h.iterator();
                        while (it.hasNext()) {
                            QIMNotifyAddFriend next = it.next();
                            if (!next.hasRead) {
                                next.hasRead = true;
                                h(next);
                            }
                        }
                        transaction.commit();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMNewFriendManager", 2, "markQIMNotifyAddFriendsReaded", e16);
                        }
                    }
                } finally {
                    transaction.end();
                }
            }
        }
    }

    public void g(List<QIMNotifyAddFriend> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
            return;
        }
        synchronized (this.f194958i) {
            EntityTransaction transaction = this.f194955e.getTransaction();
            try {
                try {
                    transaction.begin();
                    for (QIMNotifyAddFriend qIMNotifyAddFriend : list) {
                        Iterator<QIMNotifyAddFriend> it = this.f194957h.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                QIMNotifyAddFriend next = it.next();
                                if (qIMNotifyAddFriend.uin == next.uin) {
                                    next.hasRead = true;
                                    h(next);
                                    break;
                                }
                            }
                        }
                    }
                    transaction.commit();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMNewFriendManager", 2, "markQIMNotifyAddFriendsReaded", e16);
                    }
                }
            } finally {
                transaction.end();
            }
        }
        ((INewFriendService) this.f194954d.getRuntimeService(INewFriendService.class)).reloadNewFriendMsg();
    }

    protected boolean h(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) entity)).booleanValue();
        }
        if (this.f194955e.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f194955e.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f194955e.update(entity);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMNewFriendManager", 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.D = null;
        }
    }
}
