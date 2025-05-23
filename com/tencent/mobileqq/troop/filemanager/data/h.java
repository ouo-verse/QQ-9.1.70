package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f295848a;

    /* renamed from: b, reason: collision with root package name */
    String f295849b;

    /* renamed from: c, reason: collision with root package name */
    Context f295850c;

    public h(QQAppInterface qQAppInterface, Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, str);
            return;
        }
        this.f295848a = qQAppInterface;
        this.f295850c = context;
        this.f295849b = str;
    }

    private String c(String str) {
        TroopInfo k3;
        TroopManager troopManager = (TroopManager) this.f295848a.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(str)) != null) {
            return k3.troopcode;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(SharedPreferences sharedPreferences, String str, boolean z16, List list) {
        QLog.e("RefreshMemberList", 4, "onUpdateTroopGetMemberList - success");
        sharedPreferences.edit().putLong("key_last_update_time" + str, System.currentTimeMillis()).commit();
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void e(boolean z16, LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), lifecycleOwner);
            return;
        }
        QLog.e("RefreshMemberList", 4, "Prepare refreshMemberListFromServer");
        if (TextUtils.isEmpty(this.f295849b)) {
            return;
        }
        final String c16 = c(this.f295849b);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        final SharedPreferences sharedPreferences = this.f295850c.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME, 4);
        long j3 = sharedPreferences.getLong("key_last_update_time" + c16, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (!z16 && j3 != 0 && (j3 <= 0 || currentTimeMillis - j3 <= MiniBoxNoticeInfo.MIN_5)) {
            QLog.e("RefreshMemberList", 4, "< 5min, Will not refresh.");
            return;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(this.f295849b, lifecycleOwner, true, "TroopMemberListRefresher", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troop.filemanager.data.g
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                h.d(sharedPreferences, c16, z17, list);
            }
        });
        if (j3 == 0) {
            QLog.e("RefreshMemberList", 4, "Not refresh now, will refresh.");
        } else {
            QLog.e("RefreshMemberList", 4, "> 5min, will refresh.");
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
