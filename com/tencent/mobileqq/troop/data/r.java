package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class r extends com.tencent.mobileqq.filemanager.core.f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    QQAppInterface f294953b;

    /* renamed from: c, reason: collision with root package name */
    t f294954c;

    /* renamed from: d, reason: collision with root package name */
    long f294955d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.app.c f294956e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends com.tencent.mobileqq.app.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.c
        public void a(Object obj) {
            Bundle bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            TroopFileTransferManager.e eVar = (TroopFileTransferManager.e) obj;
            String str = eVar.f301962d;
            if (!NetworkUtil.isNetworkAvailable(r.this.f294953b.getApp())) {
                str = r.this.f294953b.getApp().getString(R.string.b_o);
            }
            if (str == null || str.length() < 1) {
                str = r.this.f294953b.getApp().getString(R.string.c5o);
            }
            String str2 = str;
            if (((IFMConfig) QRoute.api(IFMConfig.class)).getUserHarCodeIp()) {
                eVar.f301960b = "183.61.37.13";
                eVar.f301961c = "443";
            }
            if (TroopFileUtils.u(r.this.f294953b) && !TextUtils.isEmpty(eVar.f301966h)) {
                short s16 = eVar.f301967i;
                if (s16 == 0) {
                    s16 = 443;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("ishttps", true);
                bundle2.putString("httpsdomain", eVar.f301966h);
                bundle2.putShort("httpsport", s16);
                bundle = bundle2;
            } else {
                bundle = null;
            }
            com.tencent.mobileqq.filemanager.core.b bVar = r.this.f207649a;
            if (bVar != null) {
                bVar.a(eVar.f301959a, eVar.f301960b, eVar.f301961c, eVar.f301964f, str2, eVar.f301963e, null, eVar.f301965g, bundle);
            }
            super.a(obj);
        }
    }

    public r(QQAppInterface qQAppInterface, long j3, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, Long.valueOf(j3), tVar);
            return;
        }
        this.f294956e = null;
        this.f294953b = qQAppInterface;
        this.f294954c = tVar;
        this.f294955d = j3;
        e();
    }

    private void e() {
        a aVar = new a();
        this.f294956e = aVar;
        this.f294953b.addObserver(aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.app.c cVar = this.f294956e;
        if (cVar != null) {
            this.f294953b.removeObserver(cVar);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f294953b, this.f294955d);
        if (O == null) {
            return false;
        }
        t tVar = this.f294954c;
        UUID uuid = tVar.f294967a;
        if (uuid != null) {
            O.B(uuid);
            return true;
        }
        O.A(tVar.f294985s, tVar.f294987u, tVar.f294988v);
        return true;
    }
}
