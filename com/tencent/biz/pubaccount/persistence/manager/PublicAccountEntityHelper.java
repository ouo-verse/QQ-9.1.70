package com.tencent.biz.pubaccount.persistence.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.manager.Manager;

/* loaded from: classes4.dex */
public class PublicAccountEntityHelper implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f79859d;

    /* renamed from: e, reason: collision with root package name */
    private PublicAccountEntityManagerFactory f79860e;

    /* renamed from: f, reason: collision with root package name */
    private EntityManager f79861f;

    public PublicAccountEntityHelper(QQAppInterface qQAppInterface) {
        this.f79859d = qQAppInterface;
        PublicAccountEntityManagerFactory a16 = a(qQAppInterface);
        this.f79860e = a16;
        this.f79861f = a16.createEntityManager();
    }

    private PublicAccountEntityManagerFactory a(QQAppInterface qQAppInterface) {
        String account = qQAppInterface.getAccount();
        if (account != null) {
            PublicAccountEntityManagerFactory publicAccountEntityManagerFactory = this.f79860e;
            if (publicAccountEntityManagerFactory != null) {
                return publicAccountEntityManagerFactory;
            }
            synchronized (this) {
                if (this.f79860e == null) {
                    final PublicAccountEntityManagerFactory publicAccountEntityManagerFactory2 = new PublicAccountEntityManagerFactory(account);
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                publicAccountEntityManagerFactory2.verifyAuthentication();
                            } catch (Exception unused) {
                            }
                        }
                    }, 8, null, false);
                    this.f79860e = publicAccountEntityManagerFactory2;
                }
            }
            return this.f79860e;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        EntityManager entityManager = this.f79861f;
        if (entityManager != null) {
            entityManager.close();
        }
        PublicAccountEntityManagerFactory publicAccountEntityManagerFactory = this.f79860e;
        if (publicAccountEntityManagerFactory != null) {
            publicAccountEntityManagerFactory.close();
        }
        this.f79859d = null;
    }
}
