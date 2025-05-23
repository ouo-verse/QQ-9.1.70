package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class z implements Manager {
    static IPatchRedirector $redirector_;
    private static final ArrayList<Long> C;

    /* renamed from: d, reason: collision with root package name */
    protected String f302236d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f302237e;

    /* renamed from: f, reason: collision with root package name */
    protected TroopManager f302238f;

    /* renamed from: h, reason: collision with root package name */
    protected HashMap<String, Long> f302239h;

    /* renamed from: i, reason: collision with root package name */
    protected SharedPreferences f302240i;

    /* renamed from: m, reason: collision with root package name */
    protected LruCache<String, Bundle> f302241m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            C = new ArrayList<>();
        }
    }

    public z(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f302236d = "";
        this.f302239h = new HashMap<>();
        this.f302241m = new LruCache<>(10);
        this.f302237e = qQAppInterface;
        this.f302238f = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        this.f302240i = this.f302237e.getApp().getSharedPreferences(this.f302237e.getCurrentAccountUin() + "_troop_bind_pb", 0);
    }

    @Deprecated
    public static boolean g(MessageRecord messageRecord) {
        if (messageRecord != null && messageRecord.msgtype == -3006) {
            return true;
        }
        return false;
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        synchronized (this.f302240i) {
            try {
                String str2 = str + "_unread_pbmsg_cnt";
                SharedPreferences.Editor edit = this.f302240i.edit();
                edit.remove(str2);
                edit.commit();
                if (QLog.isColorLevel()) {
                    QLog.d("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + str2);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + e16.toString());
                }
            }
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        synchronized (this.f302240i) {
            try {
                String str2 = str + "_" + this.f302237e.getCurrentAccountUin() + "_temp_follow_state";
                SharedPreferences.Editor edit = this.f302240i.edit();
                edit.remove(str2);
                edit.commit();
                if (QLog.isColorLevel()) {
                    QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + str2);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + e16.toString());
                }
            }
        }
    }

    public Bundle c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Bundle) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        return this.f302241m.get(str);
    }

    public synchronized String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f302236d;
    }

    public synchronized boolean e(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.equals(this.f302236d)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopBindPublicAccountMgr", 2, "isInTroopAIO:" + str + "," + z16);
        }
        return z16;
    }

    public boolean f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || this.f302238f.k(str) != null) {
            return false;
        }
        return true;
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        synchronized (this.f302240i) {
            try {
                SharedPreferences.Editor edit = this.f302240i.edit();
                String str2 = str + "_btm_pbmsg_seq";
                edit.remove(str2);
                edit.commit();
                this.f302239h.remove(str);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + str2);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + e16.toString());
                }
            }
        }
    }

    public void i(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) bundle);
        } else {
            this.f302241m.put(str, bundle);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            C.clear();
        }
    }
}
