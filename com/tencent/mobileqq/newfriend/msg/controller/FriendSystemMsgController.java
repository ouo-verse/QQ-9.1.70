package com.tencent.mobileqq.newfriend.msg.controller;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FriendSystemMsgController {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static FriendSystemMsgController f254023f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f254024a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Long, structmsg$StructMsg> f254025b;

    /* renamed from: c, reason: collision with root package name */
    private long f254026c;

    /* renamed from: d, reason: collision with root package name */
    private long f254027d;

    /* renamed from: e, reason: collision with root package name */
    private String f254028e;

    public FriendSystemMsgController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f254024a = false;
        this.f254025b = new HashMap<>();
        this.f254026c = -1L;
        this.f254027d = -1L;
        this.f254028e = null;
    }

    public static FriendSystemMsgController e() {
        if (f254023f == null) {
            f254023f = new FriendSystemMsgController();
        }
        return f254023f;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        HashMap<Long, structmsg$StructMsg> hashMap = this.f254025b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            f254023f = null;
        }
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f254026c;
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f254027d;
    }

    public long f(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface)).longValue();
        }
        SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong("sp_oldest_friendmsg", 0L);
    }

    public structmsg$StructMsg g(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (structmsg$StructMsg) iPatchRedirector.redirect((short) 6, (Object) this, (Object) l3);
        }
        HashMap<Long, structmsg$StructMsg> hashMap = this.f254025b;
        if (hashMap != null) {
            return hashMap.get(l3);
        }
        return null;
    }

    public boolean h(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) appInterface)).booleanValue();
        }
        SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("sp_is_sysmsg_over", false);
    }

    public int i(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) appInterface)).intValue();
        }
        SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("sp_unread_friendsys_count", 0);
    }

    public boolean j(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appInterface)).booleanValue();
        }
        String str = this.f254028e;
        if (str != null && !str.equals(appInterface.getCurrentAccountUin())) {
            this.f254024a = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0).getBoolean("friend_system_msg_nomore_msg", false);
        }
        return this.f254024a;
    }

    public void k(Long l3, structmsg$StructMsg structmsg_structmsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) l3, (Object) structmsg_structmsg);
            return;
        }
        if (this.f254025b != null) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendSystemMsgController", 2, "putStructMsgToMap key=" + l3);
            }
            this.f254025b.put(l3, structmsg_structmsg);
        }
    }

    public void l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.f254026c = j3;
        }
    }

    public void m(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.f254027d = j3;
        }
    }

    public void n(boolean z16, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), appInterface);
            return;
        }
        this.f254024a = z16;
        this.f254028e = appInterface.getCurrentAccountUin();
        ThreadManagerV2.excute(new Runnable(appInterface, z16) { // from class: com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppInterface f254029d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f254030e;

            {
                this.f254029d = appInterface;
                this.f254030e = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FriendSystemMsgController.this, appInterface, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SharedPreferences sharedPreferences = this.f254029d.getApp().getSharedPreferences(this.f254029d.getCurrentAccountUin(), 0);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("friend_system_msg_nomore_msg", this.f254030e).commit();
                }
            }
        }, 128, null, false);
    }

    public void o(AppInterface appInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, appInterface, Long.valueOf(j3));
            return;
        }
        SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("sp_oldest_friendmsg", j3).commit();
        }
    }

    public void p(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, appInterface, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("sp_is_sysmsg_over", z16).commit();
        }
    }

    public void q(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInterface, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendSystemMsgController", 2, "setUnReadFriendSystemMsgNum count = " + i3, new Throwable("debug"));
        }
        SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("sp_unread_friendsys_count", i3).commit();
        }
    }
}
