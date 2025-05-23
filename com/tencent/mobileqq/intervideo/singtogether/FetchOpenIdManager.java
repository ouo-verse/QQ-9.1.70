package com.tencent.mobileqq.intervideo.singtogether;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FetchOpenIdManager implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f238433d;

    /* renamed from: f, reason: collision with root package name */
    private int f238435f = -1;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.intervideo.singtogether.a f238437i = new a();

    /* renamed from: m, reason: collision with root package name */
    private ar f238438m = new b();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Long, HashMap<Long, String>> f238434e = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private List<OpenIdItem> f238436h = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.intervideo.singtogether.a {
        a() {
        }

        @Override // com.tencent.mobileqq.intervideo.singtogether.a
        public void a(boolean z16, int i3, long j3, String str, String str2) {
            super.a(z16, i3, j3, str, str2);
            if (z16) {
                FetchOpenIdManager.this.j(i3, j3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends ar {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            QLog.i("FetchOpenIdManager", 1, "onUpdateDelFriend isSuccess: " + z16 + " object: " + obj);
            if (z16 && obj != null) {
                long longValue = ((Long) obj).longValue();
                Object[] array = FetchOpenIdManager.this.f238434e.keySet().toArray();
                for (int length = array.length - 1; length >= 0; length--) {
                    FetchOpenIdManager.this.i(((Long) array[length]).longValue(), longValue);
                }
            }
        }
    }

    public FetchOpenIdManager(QQAppInterface qQAppInterface) {
        this.f238433d = qQAppInterface;
        this.f238433d.registObserver(this.f238437i);
        this.f238433d.addObserver(this.f238438m);
        f(qQAppInterface);
    }

    private synchronized void f(final QQAppInterface qQAppInterface) {
        if (this.f238435f == -1) {
            this.f238435f = 0;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager.1
                @Override // java.lang.Runnable
                public void run() {
                    EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                    List<? extends Entity> query = createEntityManager.query(OpenIdItem.class, false, null, null, null, null, null, null);
                    if (query != null && query.size() > 0) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            OpenIdItem openIdItem = (OpenIdItem) it.next();
                            FetchOpenIdManager.this.g(openIdItem.appId, openIdItem.uin, openIdItem.openId);
                            FetchOpenIdManager.this.h(openIdItem, false);
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("FetchOpenIdManager", 2, "initOpenIdFromDB size is 0");
                    }
                    FetchOpenIdManager.this.f238435f = 1;
                    createEntityManager.close();
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(long j3, long j16, String str) {
        HashMap<Long, String> hashMap = this.f238434e.get(Long.valueOf(j3));
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f238434e.put(Long.valueOf(j3), hashMap);
        }
        hashMap.put(Long.valueOf(j16), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized OpenIdItem h(OpenIdItem openIdItem, boolean z16) {
        for (OpenIdItem openIdItem2 : this.f238436h) {
            if (openIdItem2.uin == openIdItem.uin && openIdItem2.appId == openIdItem.appId) {
                if (z16) {
                    openIdItem2.openId = openIdItem.openId;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FetchOpenIdManager", 2, " exist uin=" + openIdItem2.uin + " appid=" + openIdItem2.appId + " openId=" + openIdItem2.openId + " needUpdate=" + z16);
                }
                return openIdItem2;
            }
        }
        this.f238436h.add(openIdItem);
        return openIdItem;
    }

    public synchronized String e(long j3, long j16, boolean z16) {
        HashMap<Long, String> hashMap = this.f238434e.get(Long.valueOf(j16));
        String str = "";
        if (hashMap != null) {
            str = hashMap.get(Long.valueOf(j3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdManager", 2, " getOpenId openId=" + str + " uin=" + j3 + " state= " + this.f238435f);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (this.f238435f == 0) {
            return str;
        }
        if (z16) {
            com.tencent.mobileqq.intervideo.singtogether.b.a(j3, j16, this.f238433d);
        }
        return str;
    }

    public synchronized boolean i(long j3, long j16) {
        HashMap<Long, String> hashMap = this.f238434e.get(Long.valueOf(j3));
        boolean z16 = false;
        if (hashMap != null && !TextUtils.isEmpty(hashMap.remove(Long.valueOf(j16)))) {
            z16 = true;
        }
        for (OpenIdItem openIdItem : this.f238436h) {
            if (openIdItem.uin == j16 && openIdItem.appId == j3) {
                if (QLog.isColorLevel()) {
                    QLog.d("FetchOpenIdManager", 2, " exist uin=" + openIdItem.uin + " appid=" + openIdItem.appId + " openId=" + openIdItem.openId);
                }
                this.f238436h.remove(openIdItem);
                EntityManager createEntityManager = this.f238433d.getEntityManagerFactory().createEntityManager();
                createEntityManager.remove(openIdItem);
                createEntityManager.close();
                return z16;
            }
        }
        return z16;
    }

    public synchronized void j(long j3, long j16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdManager", 2, " saveOpenIdEntry appId=" + j3 + " uin=" + j16 + " openId" + str);
        }
        HashMap<Long, String> hashMap = this.f238434e.get(Long.valueOf(j3));
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f238434e.put(Long.valueOf(j3), hashMap);
        }
        EntityManager createEntityManager = this.f238433d.getEntityManagerFactory().createEntityManager();
        hashMap.put(Long.valueOf(j16), str);
        OpenIdItem openIdItem = new OpenIdItem();
        openIdItem.appId = j3;
        openIdItem.openId = str;
        openIdItem.uin = j16;
        OpenIdItem h16 = h(openIdItem, true);
        if (h16.getStatus() == 1000) {
            createEntityManager.persist(h16);
        } else {
            createEntityManager.update(h16);
        }
        createEntityManager.close();
    }

    @Override // mqq.manager.Manager
    public synchronized void onDestroy() {
        this.f238434e.clear();
        this.f238436h.clear();
        this.f238433d.unRegistObserver(this.f238437i);
        this.f238433d.removeObserver(this.f238438m);
        this.f238435f = -1;
    }
}
