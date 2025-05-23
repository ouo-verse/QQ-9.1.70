package com.tencent.mobileqq.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends com.tencent.mobileqq.troop.navigatebar.c implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f247244d;

    /* renamed from: e, reason: collision with root package name */
    protected LruCache<String, String> f247245e;

    /* renamed from: f, reason: collision with root package name */
    protected ConcurrentHashMap<Long, TroopFeedsDataManager> f247246f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f247247h;

    /* renamed from: i, reason: collision with root package name */
    protected ConcurrentHashMap<String, com.tencent.mobileqq.troop.data.c> f247248i;

    public d(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f247247h = false;
        this.f247248i = new ConcurrentHashMap<>();
        this.f247244d = qQAppInterface;
        if (this.f247245e == null) {
            synchronized (this) {
                if (this.f247245e == null) {
                    this.f247245e = new LruCache<>(10);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.c
    public com.tencent.mobileqq.troop.data.c a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.data.c) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return this.f247248i.get(str);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.c
    public com.tencent.mobileqq.troop.data.c b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.troop.data.c) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return this.f247248i.remove(str);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.c
    public com.tencent.mobileqq.troop.data.c c(String str, com.tencent.mobileqq.troop.data.c cVar) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.troop.data.c) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) cVar);
        }
        com.tencent.mobileqq.troop.data.c cVar2 = this.f247248i.get(str);
        if (cVar != null && cVar.h()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update__:" + str + " " + cVar.f() + " " + cVar.h() + " " + cVar.g());
            }
            if (cVar2 == null) {
                cVar2 = new com.tencent.mobileqq.troop.data.c(cVar);
                this.f247248i.put(str, cVar2);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: put:" + str);
                }
            } else {
                cVar2.i(cVar);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update:" + str);
                }
            }
            return cVar2;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[updateMsgInfo] msgInfo:");
            if (cVar == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(cVar.h());
            }
            sb5.append(valueOf);
            QLog.i("TroopInfoManager_At_Me_DISC", 2, sb5.toString());
        }
        return cVar2;
    }

    public byte[] d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        String str2 = this.f247245e.get(str);
        if (str2 == null) {
            return null;
        }
        try {
            return PluginBaseInfoHelper.Base64Helper.decode(str2, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public TroopFeedsDataManager e(Long l3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (TroopFeedsDataManager) iPatchRedirector.redirect((short) 1, this, l3, Boolean.valueOf(z16));
        }
        if (this.f247246f == null) {
            this.f247246f = new ConcurrentHashMap<>();
        }
        TroopFeedsDataManager troopFeedsDataManager = this.f247246f.get(l3);
        if (troopFeedsDataManager == null && z16) {
            TroopFeedsDataManager troopFeedsDataManager2 = new TroopFeedsDataManager(this.f247244d, l3);
            this.f247246f.put(l3, troopFeedsDataManager2);
            return troopFeedsDataManager2;
        }
        return troopFeedsDataManager;
    }

    public void f(Context context, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2, Boolean.valueOf(z16));
            return;
        }
        this.f247247h = z16;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + "_" + str;
        }
        edit.putBoolean(str2, z16);
        edit.apply();
    }

    public void g(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) bArr);
        } else {
            if (bArr == null) {
                return;
            }
            this.f247245e.put(str, PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2));
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ConcurrentHashMap<Long, TroopFeedsDataManager> concurrentHashMap = this.f247246f;
        if (concurrentHashMap != null) {
            for (TroopFeedsDataManager troopFeedsDataManager : concurrentHashMap.values()) {
                if (troopFeedsDataManager != null) {
                    troopFeedsDataManager.deleteObservers();
                }
            }
            this.f247246f.clear();
        }
    }
}
