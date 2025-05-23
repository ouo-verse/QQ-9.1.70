package com.tencent.mobileqq.troop.troopgame;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.armap.i;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements i.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static String f300274c;

    /* renamed from: a, reason: collision with root package name */
    private i f300275a;

    /* renamed from: b, reason: collision with root package name */
    private b f300276b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements TroopGameCardConfigProcessor.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor.b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopGameCardResDownloadManager", 2, "onGetConfigFinished result:" + i3);
            }
            if (i3 == 0) {
                String c16 = TroopGameCardConfigProcessor.e().c();
                String b16 = TroopGameCardConfigProcessor.e().b();
                if (QLog.isColorLevel()) {
                    QLog.i("TroopGameCardResDownloadManager", 2, "onGetConfigFinished url:" + c16 + " md5:" + b16);
                }
                if (!TextUtils.isEmpty(c16) && !TextUtils.isEmpty(b16)) {
                    c.this.g(new C8810c(c16, b16));
                    return;
                } else {
                    c.this.f300276b.c(110);
                    return;
                }
            }
            c.this.f300276b.c(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(int i3);

        void b();

        void c(int i3);

        void d(String str);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.troopgame.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8810c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f300278a;

        /* renamed from: b, reason: collision with root package name */
        String f300279b;

        public C8810c(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f300278a = str;
                this.f300279b = str2;
            }
        }
    }

    public c(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        if (appInterface instanceof QQAppInterface) {
            this.f300275a = (i) appInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD);
        } else {
            this.f300275a = new i(appInterface);
        }
        this.f300275a.a(this);
    }

    public static String e() {
        String str;
        if (TextUtils.isEmpty(f300274c)) {
            f300274c = BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).getString("resPath", f300274c);
        }
        if (!TextUtils.isEmpty(f300274c)) {
            String str2 = f300274c;
            String str3 = File.separator;
            if (str2.endsWith(str3)) {
                str = f300274c;
            } else {
                str = f300274c + str3;
            }
            return str + "Gameicon" + str3;
        }
        return null;
    }

    private void f(int i3, String str) {
        b bVar = this.f300276b;
        if (bVar != null) {
            if (i3 == 0) {
                bVar.d(str);
            } else {
                bVar.c(i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.armap.i.b
    public void a(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResDownloadManager", 2, "onDownloadUpdate,url =   " + str + ",md5 = " + str2 + ",percent = " + i3);
        }
        b bVar = this.f300276b;
        if (bVar != null) {
            bVar.a(i3);
        }
    }

    @Override // com.tencent.mobileqq.armap.i.b
    public void b(String str, String str2, int i3, String str3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), str3, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResDownloadManager", 2, "onDownloadFinish,url =   " + str + ",md5 = " + str2 + ",errCode = " + i3 + ",path = " + str3 + ",userData = " + obj);
        }
        if (!str3.endsWith("/")) {
            str3 = str3 + File.separator;
        }
        f(i3, str3);
    }

    public void d(C8810c c8810c, b bVar) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8810c, (Object) bVar);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkResDownloadReady resUrl is ");
            if (c8810c == null) {
                str = "emptyUrl";
            } else {
                str = c8810c.f300278a;
            }
            sb5.append(str);
            sb5.append(" resMd5 is ");
            if (c8810c == null) {
                str2 = "emptyMd5";
            } else {
                str2 = c8810c.f300279b;
            }
            sb5.append(str2);
            QLog.d("TroopGameCardResDownloadManager", 2, sb5.toString());
        }
        this.f300276b = bVar;
        if (c8810c != null && !TextUtils.isEmpty(c8810c.f300278a) && !TextUtils.isEmpty(c8810c.f300279b)) {
            g(c8810c);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopGameCardResDownloadManager", 2, "need pull config");
        }
        ((TroopGameCardConfigProcessor) am.s().e(695)).d(new a());
    }

    public synchronized void g(C8810c c8810c) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) c8810c);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResDownloadManager", 2, "startDownload res...");
        }
        this.f300275a.c(c8810c.f300278a, c8810c.f300279b, ".zip", true, 6);
    }

    @Override // com.tencent.mobileqq.armap.i.b
    public void onDownloadStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardResDownloadManager", 2, "onDownloadStart()");
        }
        b bVar = this.f300276b;
        if (bVar != null) {
            bVar.b();
        }
    }
}
