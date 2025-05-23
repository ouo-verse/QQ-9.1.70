package com.tencent.mobileqq.campuscircle;

import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements EIPCResultCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static a f201026d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a c() {
        if (f201026d == null) {
            synchronized (a.class) {
                if (f201026d == null) {
                    f201026d = new a();
                }
            }
        }
        return f201026d;
    }

    public synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_allPeopleVote");
        }
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CampusCircleIpcServer_Model", "action_allpeoplevote_clearredpoint", new Bundle());
    }

    public synchronized void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_confess");
        }
        Bundle bundle = new Bundle();
        bundle.putString("from", "web");
        bundle.putString("tag", str);
        QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_clear_red_point", bundle, this);
    }

    public synchronized Bundle d() {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcClient", 2, "getRedPoint");
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CampusCircleIpcServer_Model", "action_get_red_point", new Bundle());
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            return bundle;
        }
        return null;
    }

    public synchronized Bundle e() {
        Bundle bundle;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bundle) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcClient", 2, "getRedPoint_allPeopleVote");
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CampusCircleIpcServer_Model", "action_allpeoplevote_getredpoint", new Bundle());
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getRedPoint_allPeopleVote result!=null ");
            boolean z17 = true;
            if (callServer != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" result.suc ");
            if (callServer == null || !callServer.isSuccess()) {
                z17 = false;
            }
            sb5.append(z17);
            QLog.i("CampusCircleIpcClient", 4, sb5.toString());
        }
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            return bundle;
        }
        return null;
    }

    public synchronized Object[] f(String str) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Object[]) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcClient", 2, "getTroopMembers " + str);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("troopUin", str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CampusCircleIpcServer_Model", "action_confess_get_troop_members", bundle2);
        if (callServer != null && callServer.code == 0 && (bundle = callServer.data) != null) {
            try {
                List list = (List) bundle.getSerializable("troopUin");
                boolean z16 = callServer.data.getBoolean("isAdmin", false);
                boolean z17 = callServer.data.getBoolean("enableMemInvite", false);
                if (QLog.isColorLevel()) {
                    QLog.i("CampusCircleIpcClient", 2, String.format("getTroopMembers troopUin:%s isAdmin:%s enableInvite:%s", str, Boolean.valueOf(z16), Boolean.valueOf(z17)));
                }
                return new Object[]{Boolean.valueOf(z16), Boolean.valueOf(z17), list};
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("CampusCircleIpcClient", 2, "getTroopMembers err", e16);
                }
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("CampusCircleIpcClient", 2, "getTroopMembers err");
        }
        return null;
    }

    public synchronized Object[] g() {
        boolean z16;
        boolean z17;
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Object[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CampusCircleIpcServer_Model", "action_confess_is_in_troop_aio", new Bundle());
        if (callServer != null && callServer.code == 0 && (bundle = callServer.data) != null) {
            z16 = bundle.getBoolean("isInTroopAIO", false);
            if (QLog.isColorLevel()) {
                QLog.i("CampusCircleIpcClient", 2, "isInTroopAIO isInAIO " + z16);
            }
            z17 = true;
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("CampusCircleIpcClient", 2, "isInTroopAIO err");
            }
            z16 = false;
            z17 = false;
        }
        return new Object[]{Boolean.valueOf(z17), Boolean.valueOf(z16)};
    }

    public synchronized void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcClient", 2, "reportMedalRedPoint");
        }
        Bundle bundle = new Bundle();
        bundle.putString("from", "web");
        QIPCClientHelper.getInstance().callServer("CampusCircleIpcServer_Model", "action_report_medal_red_point", bundle, this);
    }

    public synchronized void i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCircleIpcClient", 2, "reportRedPoint, seq=" + j3);
        }
        if (j3 < 0) {
            QLog.d("CampusCircleIpcClient", 1, "reportRedPoint, seq < 0");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("seq", j3);
        QIPCClientHelper.getInstance().callServer("CampusCircleIpcServer_Model", "action_report_red_point", bundle, this);
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("nSwitchValue", i3);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CampusCircleIpcServer_Model", "action_confess_update_switch", bundle);
        if (QLog.isColorLevel()) {
            QLog.i("CampusCircleIpcClient", 2, "updateConfessSwitch nSwitchValue: " + i3);
        }
    }

    @Override // eipc.EIPCResultCallback
    public void onCallback(EIPCResult eIPCResult) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) eIPCResult);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onCallback, result=");
            sb5.append(eIPCResult);
            sb5.append(", data=");
            if (eIPCResult == null) {
                obj = "null";
            } else {
                obj = eIPCResult.data;
            }
            sb5.append(obj);
            QLog.d("CampusCircleIpcClient", 2, sb5.toString());
        }
    }
}
