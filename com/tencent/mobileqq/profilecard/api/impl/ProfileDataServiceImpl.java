package com.tencent.mobileqq.profilecard.api.impl;

import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class ProfileDataServiceImpl implements IProfileDataService {
    static IPatchRedirector $redirector_ = null;
    private static final Object PROFILE_CARD_CACHE_LOCK;
    private static final int PROFILE_CARD_CACHE_SIZE = 20;
    private static final String TAG = "ProfileDataServiceImpl";
    private AppRuntime appRuntime;
    private EntityManager entityManager;
    private MQLruCache<String, Card> profileCardCache;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            PROFILE_CARD_CACHE_LOCK = new Object();
        }
    }

    public ProfileDataServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean updateEntity(Entity entity) {
        if (this.entityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.entityManager.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.entityManager.update(entity);
            }
        }
        QLog.e(TAG, 1, "updateEntity fail! entity manager closed.");
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileDataService
    public ContactCard getContactCardByMobileNo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ContactCard) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
        }
        ContactCard contactCard = (ContactCard) DBMethodProxy.find(this.entityManager, (Class<? extends Entity>) ContactCard.class, str);
        if (contactCard == null && z16) {
            ContactCard contactCard2 = new ContactCard();
            contactCard2.mobileNo = str;
            this.entityManager.persist(contactCard2);
            return contactCard2;
        }
        return contactCard;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileDataService
    public Card getProfileCard(String str, boolean z16) {
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Card) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (PROFILE_CARD_CACHE_LOCK) {
                card = this.profileCardCache.get(str);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, String.format("getProfileCard from cache. uin=%s card=%s", str, card));
            }
        } else {
            card = null;
        }
        if (card == null) {
            card = (Card) DBMethodProxy.find(this.entityManager, (Class<? extends Entity>) Card.class, str);
            if (card != null && !TextUtils.isEmpty(str)) {
                synchronized (PROFILE_CARD_CACHE_LOCK) {
                    this.profileCardCache.put((MQLruCache<String, Card>) str, (String) card);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, String.format("getProfileCard from db. uin=%s card=%s", str, card));
            }
        }
        if (card == null && z16) {
            card = new Card();
            card.uin = str;
            card.shGender = (short) -1;
            this.entityManager.persist(card);
            if (!TextUtils.isEmpty(str)) {
                synchronized (PROFILE_CARD_CACHE_LOCK) {
                    this.profileCardCache.put((MQLruCache<String, Card>) str, (String) card);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, String.format("getProfileCard from new. uin=%s card=%s", str, card));
            }
        }
        return card;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileDataService
    public Card getProfileCardFromCache(String str) {
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Card) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (PROFILE_CARD_CACHE_LOCK) {
                card = this.profileCardCache.get(str);
            }
            return card;
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
        this.appRuntime = appRuntime;
        this.entityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        this.profileCardCache = new MQLruCache<>(20);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileDataService
    public boolean saveContactCard(ContactCard contactCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) contactCard)).booleanValue();
        }
        return updateEntity(contactCard);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileDataService
    public boolean saveProfileCard(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) card)).booleanValue();
        }
        return updateEntity(card);
    }
}
