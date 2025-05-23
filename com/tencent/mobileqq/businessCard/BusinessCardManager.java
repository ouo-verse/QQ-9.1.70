package com.tencent.mobileqq.businessCard;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.profile.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BusinessCardManager implements Manager {
    static IPatchRedirector $redirector_;
    protected ArrayList<i> C;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f200774d;

    /* renamed from: e, reason: collision with root package name */
    SharedPreferences f200775e;

    /* renamed from: f, reason: collision with root package name */
    protected ConcurrentHashMap<String, BusinessCard> f200776f;

    /* renamed from: h, reason: collision with root package name */
    protected ConcurrentHashMap<String, BusinessCard> f200777h;

    /* renamed from: i, reason: collision with root package name */
    EntityManager f200778i;

    /* renamed from: m, reason: collision with root package name */
    TransFileControllerImpl f200779m;

    public BusinessCardManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f200779m = null;
        this.C = new ArrayList<>(0);
        this.f200774d = qQAppInterface;
        this.f200778i = qQAppInterface.getEntityManagerFactory().createEntityManager();
        this.f200776f = new ConcurrentHashMap<>();
        this.f200777h = new ConcurrentHashMap<>();
        this.f200775e = qQAppInterface.getApp().getSharedPreferences("pref_business_card" + qQAppInterface.getAccount(), 0);
        o();
    }

    private boolean a(BusinessCard businessCard) {
        String str;
        if (businessCard == null || (str = businessCard.cardId) == null || str.length() == 0) {
            return false;
        }
        businessCard.setStatus(1000);
        this.f200778i.persistOrReplace(businessCard);
        if (businessCard.getStatus() != 1001) {
            return false;
        }
        return true;
    }

    private void e(BusinessCard businessCard) {
        if (businessCard != null) {
            this.f200778i.remove(businessCard);
        }
    }

    private void w(BusinessCard businessCard) {
        if (businessCard != null) {
            this.f200778i.update(businessCard);
        }
    }

    public void b(BusinessCard businessCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) businessCard);
        } else {
            if (businessCard == null) {
                return;
            }
            if (this.f200776f.containsKey(businessCard.cardId)) {
                this.f200776f.remove(businessCard.cardId);
            }
            this.f200776f.put(businessCard.cardId, businessCard);
        }
    }

    public void c(BusinessCard businessCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) businessCard);
            return;
        }
        if (businessCard == null) {
            return;
        }
        if (this.f200776f.containsKey(businessCard.cardId)) {
            this.f200776f.remove(businessCard.cardId);
            w(businessCard);
        } else {
            a(businessCard);
        }
        this.f200776f.put(businessCard.cardId, businessCard);
    }

    public void d(String str, BusinessCard businessCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) businessCard);
        } else if (businessCard != null && !TextUtils.isEmpty(str)) {
            if (this.f200777h.containsKey(str)) {
                this.f200777h.remove(str);
            }
            this.f200777h.put(str, businessCard);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f200776f.clear();
            this.f200778i.drop(BusinessCard.class);
        }
    }

    public BusinessCard g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (BusinessCard) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        BusinessCard businessCard = new BusinessCard();
        BusinessCard businessCard2 = (BusinessCard) DBMethodProxy.find(this.f200778i, (Class<? extends Entity>) BusinessCard.class, str);
        if (businessCard2 != null) {
            return businessCard2;
        }
        return businessCard;
    }

    List<BusinessCard> h() {
        List query = this.f200778i.query(BusinessCard.class);
        if (query != null && QLog.isColorLevel()) {
            QLog.d("BusinessCard_Manager", 2, "getBusinessCardListFromDB= " + query.size());
        }
        return query;
    }

    public BusinessCard i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BusinessCard) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return this.f200776f.get(str);
    }

    public boolean j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, i3)).booleanValue();
        }
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    z16 = this.f200775e.getBoolean("key_need_show_guide", true);
                }
            } else {
                z16 = this.f200775e.getBoolean("key_need_req_card", false);
            }
        } else {
            z16 = this.f200775e.getBoolean("key_show_open_card", false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Manager", 2, "getCardSetting|type=" + i3 + ", result=" + z16);
        }
        return z16;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        int i3 = this.f200775e.getInt("key_server_seq", -1);
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Manager", 2, "getLocalSeq | seq = " + i3);
        }
        return i3;
    }

    public BusinessCard l() {
        BusinessCard businessCard;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BusinessCard) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!this.f200776f.isEmpty()) {
            Iterator<Map.Entry<String, BusinessCard>> it = this.f200776f.entrySet().iterator();
            while (it.hasNext()) {
                businessCard = it.next().getValue();
                if (businessCard.cardType == 1) {
                    break;
                }
            }
        }
        businessCard = null;
        if (businessCard == null && QLog.isColorLevel()) {
            QLog.w("BusinessCard_Manager", 2, "getMyBusinessCard return null");
        }
        return businessCard;
    }

    public BusinessCard m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BusinessCard) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        return this.f200777h.get(str);
    }

    public ArrayList<i> n() {
        ArrayList<i> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (this.C) {
            arrayList = (ArrayList) this.C.clone();
        }
        return arrayList;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.businessCard.BusinessCardManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BusinessCardManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    List<BusinessCard> h16 = BusinessCardManager.this.h();
                    if (h16 != null) {
                        i3 = h16.size();
                    } else {
                        i3 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("BusinessCard_Manager", 2, "Init cache from DB,count=" + i3);
                    }
                    BusinessCardManager.this.f200776f.clear();
                    if (i3 > 0) {
                        for (BusinessCard businessCard : h16) {
                            BusinessCardManager.this.f200776f.put(businessCard.cardId, businessCard);
                        }
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.f200776f.clear();
        this.f200777h.clear();
        this.f200778i.close();
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else if (this.f200776f.containsKey(str)) {
            e(this.f200776f.get(str));
            this.f200776f.remove(str);
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else if (this.f200777h.containsKey(str)) {
            this.f200777h.remove(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:14:0x0038->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(List<BusinessCard> list, boolean z16) {
        boolean z17;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, list, Boolean.valueOf(z16));
            return;
        }
        if (list != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (z16) {
                    this.f200778i.drop(BusinessCard.class.getSimpleName());
                }
                for (BusinessCard businessCard : list) {
                    if (businessCard != null && (str2 = businessCard.cardId) != null && str2.length() != 0) {
                        businessCard.setStatus(1000);
                        arrayList.add(new PersistOrReplaceTransaction(businessCard));
                        if (businessCard.getStatus() == 1001) {
                            z17 = true;
                            if (z17) {
                                if (businessCard == null) {
                                    str = "";
                                } else {
                                    str = businessCard.cardId;
                                }
                                throw new Exception("saveCardList exception : comicId = " + str);
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                }
                this.f200778i.doMultiDBOperateByTransaction(arrayList);
            } catch (Exception e16) {
                QLog.d("BusinessCard_Manager", 2, "saveComicHistoryList exception :" + e16.toString());
                e16.printStackTrace();
            }
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        if (i3 != -1) {
            this.f200775e.edit().putInt("key_server_seq", i3).commit();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Manager", 2, "saveServerSeq | seq = " + i3);
        }
    }

    public void t(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Manager", 2, "setCardSetting|type=" + i3 + ", flag=" + z16);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f200775e.edit().putBoolean("key_need_show_guide", z16).commit();
                    return;
                }
                return;
            }
            this.f200775e.edit().putBoolean("key_need_req_card", z16).commit();
            return;
        }
        this.f200775e.edit().putBoolean("key_show_open_card", z16).commit();
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        this.f200775e.edit().putBoolean("key_red_point", z16).commit();
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Manager", 2, "setRedPointClicked | clicked = " + z16);
        }
    }

    public void v(ArrayList<i> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        } else if (arrayList != null) {
            synchronized (this.C) {
                this.C.clear();
                this.C.addAll(arrayList);
            }
        }
    }
}
