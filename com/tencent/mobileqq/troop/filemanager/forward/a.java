package com.tencent.mobileqq.troop.filemanager.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import ef0.l;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f295943a;

    /* renamed from: b, reason: collision with root package name */
    protected TroopFileTransferManager.Item f295944b;

    /* renamed from: c, reason: collision with root package name */
    protected String f295945c;

    /* renamed from: d, reason: collision with root package name */
    protected int f295946d;

    /* renamed from: e, reason: collision with root package name */
    private TroopFileTransferManager.c f295947e;

    /* renamed from: f, reason: collision with root package name */
    l f295948f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.forward.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8692a extends l {
        static IPatchRedirector $redirector_;

        C8692a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // ef0.l
        public void c(boolean z16, int i3, int i16, String str, String str2, String str3, Bundle bundle) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, bundle);
                return;
            }
            if (bundle.getLong("troopUin") != a.this.f295943a || (string = bundle.getString("itemKey")) == null || !UUID.fromString(string).equals(a.this.d())) {
                return;
            }
            a aVar = a.this;
            if (aVar.f295944b.BusId == 25) {
                aVar.f(z16, i3, i16, str, str2, str3);
                if (a.this.f295947e != null) {
                    a.this.f295947e.onResult(i3);
                }
            }
        }
    }

    protected a(long j3, TroopFileTransferManager.Item item, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item, Integer.valueOf(i3));
            return;
        }
        this.f295948f = new C8692a();
        this.f295943a = j3;
        this.f295944b = item;
        UUID uuid = item.Id;
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = "";
        }
        this.f295945c = str;
        this.f295946d = i3;
    }

    public static a e(long j3, TroopFileTransferManager.Item item) {
        if (j3 == 0) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "getTroop2WeiyunForwarder. troopuin=0");
            return null;
        }
        if (item == null) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "getTroop2WeiyunForwarder. item=null");
            return null;
        }
        if (item.Id == null) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "getTroop2WeiyunForwarder. item.id=null");
            return null;
        }
        if (item.ForwardTroopuin == 0) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "getTroop2WeiyunForwarder. ForwardTroopuin=0");
            return null;
        }
        if (item.BusId != 25) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "getTroop2WeiyunForwarder. BusId err:" + item.BusId);
            return null;
        }
        if (TextUtils.isEmpty(item.ForwardPath)) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "get2WeiyunForwarder. ForwardPath=null");
            return null;
        }
        return new a(j3, item, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(boolean z16, int i3, int i16, String str, String str2, String str3) {
        if (!z16) {
            ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(-1);
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "[" + this.f295945c + "] onTroop2weiyunResult isSuccess:false ");
            com.tencent.mobileqq.troop.filemanager.b.g(this.f295943a, this.f295944b, 5, new TroopFileError.b(this.f295944b.FileName, this.f295943a, 5, 601));
            return;
        }
        e.b.c("TroopFileFromTroopForwarder", e.b.f295938b, "[" + this.f295945c + "] onTroop2weiyunResult retCode:" + i3 + " sClientWording:" + str3);
        ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3);
        if (i3 != 0) {
            int i17 = 702;
            if (i3 != -20001 && i3 != -20000) {
                if (i3 != -6101) {
                    if (i3 != -403) {
                        if (i3 != -30) {
                            if (i3 != -25 && i3 != -22) {
                                if (i3 != -3) {
                                    if (i3 != 1053) {
                                        i17 = (i3 == 1054 && !TextUtils.isEmpty(str3)) ? 704 : 601;
                                    }
                                } else {
                                    i17 = 202;
                                }
                            } else {
                                i17 = 701;
                            }
                        } else {
                            i17 = 705;
                        }
                    }
                } else {
                    i17 = 703;
                }
            }
            com.tencent.mobileqq.troop.filemanager.b.g(this.f295943a, this.f295944b, 5, new TroopFileError.b(this.f295944b.FileName, this.f295943a, 5, i17, str3));
            return;
        }
        com.tencent.mobileqq.troop.filemanager.b.g(this.f295943a, this.f295944b, 5, new TroopFileError.b(this.f295944b.FileName, this.f295943a, 5, 602));
    }

    private int h() {
        QQAppInterface b16 = e.b();
        if (b16 == null) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "[" + this.f295945c + "] troop2weiyun app=null");
            return -1;
        }
        e.b.c("TroopFileFromTroopForwarder", e.b.f295938b, "[" + this.f295945c + "] troop2weiyun. BusId:" + this.f295944b.BusId + " ForwardBusId:" + this.f295944b.ForwardBusId + " ForwardPath:" + this.f295944b.ForwardPath);
        com.tencent.biz.troop.file.a.p(b16, true, this.f295943a, this.f295944b, b16.getLongAccountUin(), 0L, this.f295948f);
        return 0;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (1 == this.f295946d) {
            return h();
        }
        return -1;
    }

    public UUID d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UUID) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f295944b.Id;
    }

    public void g(TroopFileTransferManager.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.f295947e = cVar;
        }
    }
}
