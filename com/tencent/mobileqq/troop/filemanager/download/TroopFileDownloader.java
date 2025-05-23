package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController;
import com.tencent.mobileqq.troop.filemanager.download.a;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileDownloader implements b, a.InterfaceC8691a, TroopFileTransferRetryController.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f295897a;

    /* renamed from: b, reason: collision with root package name */
    protected final long f295898b;

    /* renamed from: c, reason: collision with root package name */
    protected String f295899c;

    /* renamed from: d, reason: collision with root package name */
    protected String f295900d;

    /* renamed from: e, reason: collision with root package name */
    protected int f295901e;

    /* renamed from: f, reason: collision with root package name */
    protected int f295902f;

    /* renamed from: g, reason: collision with root package name */
    protected String f295903g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f295904h;

    /* renamed from: i, reason: collision with root package name */
    protected String f295905i;

    /* renamed from: j, reason: collision with root package name */
    protected long f295906j;

    /* renamed from: k, reason: collision with root package name */
    protected long f295907k;

    /* renamed from: l, reason: collision with root package name */
    protected final TroopFileTransferRetryController f295908l;

    /* renamed from: m, reason: collision with root package name */
    protected FileOutputStream f295909m;

    /* renamed from: n, reason: collision with root package name */
    protected c f295910n;

    /* renamed from: o, reason: collision with root package name */
    protected a f295911o;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f295912p;

    /* renamed from: q, reason: collision with root package name */
    protected long f295913q;

    /* renamed from: r, reason: collision with root package name */
    protected long f295914r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f295915s;

    /* JADX INFO: Access modifiers changed from: protected */
    public TroopFileDownloader(QQAppInterface qQAppInterface, long j3, String str, long j16, List<String> list, String str2, String str3, boolean z16, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, Long.valueOf(j3), str, Long.valueOf(j16), list, str2, str3, Boolean.valueOf(z16), str4);
            return;
        }
        this.f295897a = 0L;
        this.f295904h = true;
        this.f295907k = 0L;
        this.f295909m = null;
        this.f295912p = true;
        this.f295913q = 0L;
        this.f295914r = 0L;
        this.f295915s = false;
        this.f295898b = j3;
        this.f295906j = j16;
        this.f295905i = str;
        TroopFileTransferRetryController troopFileTransferRetryController = new TroopFileTransferRetryController(qQAppInterface, list, str2, j3, z16, this);
        this.f295908l = troopFileTransferRetryController;
        String c16 = troopFileTransferRetryController.c();
        this.f295899c = c16;
        e.a i3 = com.tencent.mobileqq.troop.filemanager.e.i(c16);
        if (i3 != null) {
            this.f295900d = i3.f295934a;
            this.f295901e = i3.f295935b;
            this.f295902f = i3.f295936c;
        }
        this.f295903g = str3;
        a aVar = new a(j3, 1, 0, j16, z16, str4);
        this.f295911o = aVar;
        aVar.d(this);
    }

    private void A() {
        if (this.f295904h) {
            return;
        }
        e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] reDownload mstrUrl:" + this.f295899c);
        v();
        c cVar = this.f295910n;
        if (cVar != null) {
            cVar.e();
        }
        this.f295907k = FileManagerUtil.getFileSizes(this.f295905i);
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            t(true, 9004, "no net work", "");
        } else {
            w();
        }
    }

    private boolean o(String str) {
        if (str.indexOf("-29120") <= 0 && str.indexOf("-502") <= 0 && str.indexOf("HTTP_PROXY_AUTH") <= 0 && str.indexOf("-21122") <= 0 && str.indexOf("-28123") <= 0 && str.indexOf("-25081") <= 0 && str.indexOf("-28126") <= 0) {
            return false;
        }
        return true;
    }

    private boolean p(String str) {
        if (str.indexOf("-6101") <= 0 && str.indexOf("-7003") <= 0 && str.indexOf("-403") <= 0 && str.indexOf("-9006") <= 0 && str.indexOf("-9004") <= 0 && str.indexOf("-9017") <= 0 && str.indexOf("-29150") <= 0 && str.indexOf("-28137") <= 0) {
            return false;
        }
        return true;
    }

    private boolean q(String str) {
        if (!TextUtils.isEmpty(str) && (str.equals("-441") || str.equals("-443") || str.equals("-447") || str.equals("-29224") || str.equals("-31717"))) {
            return true;
        }
        return false;
    }

    public static b x(QQAppInterface qQAppInterface, long j3, String str, long j16, List<String> list, String str2, String str3, boolean z16, String str4) {
        String str5;
        if (str == null) {
            str5 = "strSavePath is null";
        } else if (str.length() == 0) {
            str5 = "strSavePath is empty";
        } else if (list == null) {
            str5 = "lstUrl is null";
        } else if (list.size() == 0) {
            str5 = "lstUrl is empty";
        } else if (str2 == null) {
            str5 = "urlParams is null";
        } else if (str2.length() == 0) {
            str5 = "urlParams is empty";
        } else {
            str5 = "";
        }
        if (!TextUtils.isEmpty(str5)) {
            e.b.b("TroopFileDownloader", e.b.f295938b, "getFileDownloader " + str5);
            return null;
        }
        return new TroopFileDownloader(qQAppInterface, j3, str, j16, list, str2, str3, z16, str4);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.a
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        return 100L;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.a
    public void b(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (this.f295904h) {
            e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] onRetry but stoped");
            return;
        }
        if (!this.f295899c.equalsIgnoreCase(str)) {
            e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] onRetry urlChanged");
            z16 = true;
        } else {
            z16 = false;
        }
        this.f295899c = str;
        if (z16) {
            e.a i3 = com.tencent.mobileqq.troop.filemanager.e.i(str);
            if (i3 != null) {
                this.f295900d = i3.f295934a;
                this.f295901e = i3.f295935b;
                this.f295902f = i3.f295936c;
            }
            this.f295910n.d(this.f295899c);
        }
        A();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.a.InterfaceC8691a
    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            if (this.f295904h) {
                return;
            }
            t(true, AppConstants.RichMediaErrorCode.ERROIR_HTTP_CODE_REDIRECT, "net redirect", "");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.a.InterfaceC8691a
    public void d(HttpMsg httpMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) httpMsg);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public void download() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f295904h = false;
        this.f295897a = System.currentTimeMillis();
        e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] download url:" + this.f295899c);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloader.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopFileDownloader troopFileDownloader = TroopFileDownloader.this;
                if (troopFileDownloader.f295904h) {
                    e.b.e("TroopFileDownloader", e.b.f295938b, "[" + TroopFileDownloader.this.f295898b + "] download. had stoped");
                    return;
                }
                if (troopFileDownloader.s()) {
                    return;
                }
                if (!TroopFileDownloader.this.z()) {
                    TroopFileDownloader.this.t(true, -5001, "file open exception", "");
                } else if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    TroopFileDownloader.this.t(true, 9004, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, "");
                } else {
                    TroopFileDownloader.this.w();
                }
            }
        }, 8, null, false);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f295908l.d();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] cancelTask");
        this.f295904h = true;
        r();
        n();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.a.InterfaceC8691a
    public void g(HttpMsg httpMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) httpMsg);
            return;
        }
        httpMsg.setRequestProperty("User-Agent", "TroopFile");
        if (!TextUtils.isEmpty(this.f295903g)) {
            httpMsg.setRequestProperty("Cookie", "FTN5K=" + this.f295903g);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public int getProxyType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.f295902f;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.f295899c;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.a.InterfaceC8691a
    public void h(int i3, String str, String str2, HttpMsg httpMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, str2, httpMsg);
            return;
        }
        if (this.f295904h) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (str.indexOf("-29602") > 0) {
            t(true, -29602, str, str2);
            return;
        }
        String y16 = y(httpMsg, HttpMsg.USERRETURNCODE);
        if (y16 != null && q(y16)) {
            t(true, -5003, str, str2);
            return;
        }
        if (p(str)) {
            t(true, 9042, str, str2);
            return;
        }
        if ("content zero".equalsIgnoreCase(str) && str2 != null && str2.indexOf("-31713") > 0) {
            t(true, 9042, str, str2);
            return;
        }
        if (str.contains("SSLPeerUnverifiedException")) {
            t(true, i3, str, str2);
            return;
        }
        boolean o16 = o(str);
        if (o16) {
            i3 = 9042;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            t(true, 9004, str, str2);
            return;
        }
        this.f295915s = false;
        e.b.b("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] onErr errCode:" + i3 + " errMsg:" + str + " rspHeader:" + str2);
        if (this.f295908l.f(this.f295899c, i3, o16)) {
            t(false, i3, str, str2);
        } else {
            t(true, i3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f295908l.a();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.a.InterfaceC8691a
    public void j(byte[] bArr, long j3, String str) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, bArr, Long.valueOf(j3), str);
            return;
        }
        if (this.f295904h) {
            return;
        }
        if (this.f295906j == 0 && j3 != 0) {
            e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] onData getted filesize=" + j3);
            this.f295906j = j3;
        }
        if (bArr != null && bArr.length != 0) {
            try {
                this.f295909m.write(bArr);
                long length = bArr.length;
                this.f295907k += length;
                this.f295914r += length;
                if (!this.f295915s) {
                    this.f295915s = true;
                    this.f295908l.e(this.f295899c);
                }
                long j16 = this.f295907k;
                long j17 = this.f295906j;
                if (j16 == j17) {
                    u();
                    return;
                }
                if (j16 > j17) {
                    t(true, -5001, "transfersize > filesize", str);
                    return;
                }
                if (this.f295912p) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j18 = this.f295913q;
                    if ((j18 == 0 || currentTimeMillis - j18 >= 1000) && (cVar = this.f295910n) != null) {
                        cVar.onDownloadProgress(this.f295907k, this.f295906j);
                    }
                }
            } catch (Exception e16) {
                e16.getMessage().contains("ENOSPC");
                t(true, 9301, "write exception", str);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.f295900d;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public void l(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) cVar);
        } else {
            this.f295910n = cVar;
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.b
    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.f295901e;
    }

    protected void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f295911o.a();
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.a.InterfaceC8691a
    public void onEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    protected void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        FileOutputStream fileOutputStream = this.f295909m;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e16) {
                e.b.b("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] closeOutputStream excp");
                e16.printStackTrace();
            }
            this.f295909m = null;
        }
    }

    protected boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!Common.w()) {
            t(true, 9039, "no sdcard", null);
            return true;
        }
        File file = new File(this.f295905i);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException unused) {
                t(true, -5000, "create new file excption", null);
                return true;
            }
        }
        long fileSizes = FileManagerUtil.getFileSizes(this.f295905i);
        this.f295907k = fileSizes;
        long j3 = this.f295906j;
        if (j3 == 0) {
            e.b.e("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] checkexcpover fileSize=0");
            return false;
        }
        if (fileSizes > j3) {
            new File(this.f295905i).delete();
            this.f295907k = 0L;
        } else {
            if (fileSizes == j3) {
                e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] checkexcpover tmpfilesize=filesize");
                u();
                return true;
            }
            if (lc1.b.a().getDefalutStorgeFreeSpace() < j3 - fileSizes) {
                t(true, 9040, "no enugh space", null);
                return true;
            }
        }
        return false;
    }

    protected void t(boolean z16, int i3, String str, String str2) {
        long j3;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
            return;
        }
        if (z16) {
            this.f295904h = true;
            r();
            n();
            j3 = System.currentTimeMillis();
        } else {
            j3 = 0;
        }
        int i16 = e.b.f295938b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        sb5.append(this.f295898b);
        sb5.append("] onErr errCode:");
        sb5.append(i3);
        sb5.append(" bFinished:");
        sb5.append(z16);
        sb5.append(" errMsg:");
        sb5.append(str);
        sb5.append(" rspHeader:");
        sb5.append(str2);
        sb5.append(" cost:");
        if (z16) {
            obj = Long.valueOf(j3 - this.f295897a);
        } else {
            obj = "";
        }
        sb5.append(obj);
        e.b.b("TroopFileDownloader", i16, sb5.toString());
        c cVar = this.f295910n;
        if (cVar != null) {
            cVar.f(z16, this.f295907k, i3, str, str2, new Bundle());
        }
    }

    protected void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        this.f295904h = true;
        r();
        n();
        long currentTimeMillis = System.currentTimeMillis();
        e.b.c("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] onSuc. cost:" + (currentTimeMillis - this.f295897a));
        c cVar = this.f295910n;
        if (cVar != null) {
            cVar.onDownloadSuccess(this.f295905i);
        }
    }

    protected void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        FileOutputStream fileOutputStream = this.f295909m;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e16) {
                e.b.b("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] flushOutputStream excp");
                e16.printStackTrace();
            }
        }
        this.f295914r = 0L;
    }

    protected void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            n();
            this.f295911o.c(this.f295899c, this.f295907k);
        }
    }

    protected String y(HttpMsg httpMsg, String str) {
        HttpURLConnection httpURLConnection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) httpMsg, (Object) str);
        }
        if (httpMsg != null && (httpURLConnection = httpMsg.mConn) != null) {
            return httpURLConnection.getHeaderField(str);
        }
        return null;
    }

    protected boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        r();
        try {
            this.f295909m = new FileOutputStream(this.f295905i, true);
            return true;
        } catch (FileNotFoundException e16) {
            e.b.b("TroopFileDownloader", e.b.f295938b, "[" + this.f295898b + "] openOutputStream excp");
            this.f295909m = null;
            e16.printStackTrace();
            return false;
        }
    }
}
