package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.filemanager.c;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.be;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import ef0.m;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import qb1.g;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileDownloadWorker implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f295873a;

    /* renamed from: b, reason: collision with root package name */
    protected TroopFileTransferManager.Item f295874b;

    /* renamed from: c, reason: collision with root package name */
    protected String f295875c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f295876d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.filemanager.download.b f295877e;

    /* renamed from: f, reason: collision with root package name */
    protected b f295878f;

    /* renamed from: g, reason: collision with root package name */
    protected String f295879g;

    /* renamed from: h, reason: collision with root package name */
    protected String f295880h;

    /* renamed from: i, reason: collision with root package name */
    protected String f295881i;

    /* renamed from: j, reason: collision with root package name */
    protected String f295882j;

    /* renamed from: k, reason: collision with root package name */
    protected Bundle f295883k;

    /* renamed from: l, reason: collision with root package name */
    protected g f295884l;

    /* renamed from: m, reason: collision with root package name */
    protected int f295885m;

    /* renamed from: n, reason: collision with root package name */
    protected c.a f295886n;

    /* renamed from: o, reason: collision with root package name */
    protected long f295887o;

    /* renamed from: p, reason: collision with root package name */
    protected long f295888p;

    /* renamed from: q, reason: collision with root package name */
    protected long f295889q;

    /* renamed from: r, reason: collision with root package name */
    protected long f295890r;

    /* renamed from: s, reason: collision with root package name */
    protected long f295891s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f295892t;

    /* renamed from: u, reason: collision with root package name */
    protected int f295893u;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f295894v;

    /* renamed from: w, reason: collision with root package name */
    m f295895w;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends m {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileDownloadWorker.this);
            }
        }

        @Override // ef0.m
        public void c(boolean z16, int i3, oidb_0x6d6$DownloadFileRspBody oidb_0x6d6_downloadfilerspbody, Bundle bundle) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), oidb_0x6d6_downloadfilerspbody, bundle);
                return;
            }
            TroopFileDownloadWorker.this.f295891s = com.tencent.mobileqq.service.message.e.K0();
            if (bundle.getLong("troopUin") != TroopFileDownloadWorker.this.f295873a || (string = bundle.getString("itemKey")) == null || !UUID.fromString(string).equals(TroopFileDownloadWorker.this.p()) || TroopFileDownloadWorker.this.f295876d) {
                return;
            }
            int i16 = bundle.getInt("thumbNail");
            boolean z17 = bundle.getBoolean("isPreview", false);
            if (i16 == 0 && !z17) {
                if (oidb_0x6d6_downloadfilerspbody != null && z16) {
                    int i17 = oidb_0x6d6_downloadfilerspbody.int32_ret_code.get();
                    e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileDownloadWorker.this.f295875c + "] onReqDownloadResult isSuccess:true  errCode:" + i3 + " retCode:" + i17);
                    if (i17 < 0) {
                        if (i17 != -302 && i17 != -301) {
                            if (i17 != -107) {
                                if (i17 != -103) {
                                    if (i17 != -102) {
                                        if (i17 != -134 && i17 != -133 && i17 != -132) {
                                            TroopFileDownloadWorker troopFileDownloadWorker = TroopFileDownloadWorker.this;
                                            c.a aVar = troopFileDownloadWorker.f295886n;
                                            aVar.f295762k = 1;
                                            aVar.f295763l = i17;
                                            troopFileDownloadWorker.f295892t = true;
                                            troopFileDownloadWorker.h(true, be.a.f302116c, i17, 1);
                                            return;
                                        }
                                    }
                                }
                            }
                            TroopFileDownloadWorker troopFileDownloadWorker2 = TroopFileDownloadWorker.this;
                            c.a aVar2 = troopFileDownloadWorker2.f295886n;
                            aVar2.f295762k = 1;
                            aVar2.f295763l = i17;
                            troopFileDownloadWorker2.f295892t = true;
                            troopFileDownloadWorker2.h(true, be.a.f302116c, i17, 101);
                            return;
                        }
                        TroopFileDownloadWorker troopFileDownloadWorker3 = TroopFileDownloadWorker.this;
                        com.tencent.mobileqq.troop.filemanager.b.c(troopFileDownloadWorker3.f295873a, troopFileDownloadWorker3.f295874b, 301);
                        TroopFileDownloadWorker troopFileDownloadWorker4 = TroopFileDownloadWorker.this;
                        String str = troopFileDownloadWorker4.f295874b.TmpFile;
                        if (str != null) {
                            troopFileDownloadWorker4.B(str);
                        }
                        TroopFileDownloadWorker troopFileDownloadWorker5 = TroopFileDownloadWorker.this;
                        troopFileDownloadWorker5.f295874b.deleteThumbnailFile(troopFileDownloadWorker5.f295873a, 128);
                        TroopFileDownloadWorker troopFileDownloadWorker6 = TroopFileDownloadWorker.this;
                        troopFileDownloadWorker6.f295874b.deleteThumbnailFile(troopFileDownloadWorker6.f295873a, 640);
                        TroopFileDownloadWorker troopFileDownloadWorker7 = TroopFileDownloadWorker.this;
                        c.a aVar3 = troopFileDownloadWorker7.f295886n;
                        aVar3.f295762k = 1;
                        aVar3.f295763l = i17;
                        troopFileDownloadWorker7.f295892t = true;
                        troopFileDownloadWorker7.g(true, be.a.f302116c, i17);
                        return;
                    }
                    TroopFileDownloadWorker.this.f295874b.cookieValue = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_cookie_val.get().toByteArray());
                    TroopFileTransferManager.Item item = TroopFileDownloadWorker.this.f295874b;
                    String str2 = item.cookieValue;
                    if (str2 != null) {
                        item.cookieValue = str2.toLowerCase();
                    }
                    TroopFileDownloadWorker.this.f295874b.DownloadIp = oidb_0x6d6_downloadfilerspbody.str_download_ip.get();
                    TroopFileDownloadWorker.this.f295874b.DownloadDNS = oidb_0x6d6_downloadfilerspbody.str_download_dns.get().toStringUtf8();
                    TroopFileDownloadWorker.this.f295874b.DownloadUrl = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_download_url.get().toByteArray());
                    TroopFileDownloadWorker.this.f295874b.Md5 = oidb_0x6d6_downloadfilerspbody.bytes_md5.get().toByteArray();
                    TroopFileDownloadWorker.this.f295874b.NameForSave = oidb_0x6d6_downloadfilerspbody.str_save_file_name.get();
                    if (TextUtils.isEmpty(TroopFileDownloadWorker.this.f295874b.DownloadIp)) {
                        e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileDownloadWorker.this.f295875c + "] onReqDownloadResult DownloadIp is null");
                        be.b("gfile", "ipnull", "", "", "", "");
                    }
                    if (i17 != -133 && i17 != -132) {
                        if (i17 == -134) {
                            TroopFileDownloadWorker troopFileDownloadWorker8 = TroopFileDownloadWorker.this;
                            c.a aVar4 = troopFileDownloadWorker8.f295886n;
                            aVar4.f295762k = 1;
                            aVar4.f295763l = i17;
                            troopFileDownloadWorker8.f295892t = true;
                            troopFileDownloadWorker8.h(true, be.a.f302116c, i17, 302);
                            return;
                        }
                    } else {
                        TroopFileDownloadWorker troopFileDownloadWorker9 = TroopFileDownloadWorker.this;
                        long j3 = troopFileDownloadWorker9.f295873a;
                        TroopFileTransferManager.Item item2 = troopFileDownloadWorker9.f295874b;
                        com.tencent.mobileqq.troop.filemanager.b.f(j3, item2, item2.Status, 309);
                    }
                    e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileDownloadWorker.this.f295875c + "] onReqDownloadResult DownloadIp:" + TroopFileDownloadWorker.this.f295874b.DownloadIp + " DownloadDNS:" + TroopFileDownloadWorker.this.f295874b.DownloadDNS + " NameForSave:" + TroopFileDownloadWorker.this.f295874b.NameForSave + " DownloadUrl:" + TroopFileDownloadWorker.this.f295874b.DownloadUrl + " cookieValue:" + TroopFileDownloadWorker.this.f295874b.cookieValue);
                    TroopFileDownloadWorker.this.E();
                    return;
                }
                e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileDownloadWorker.this.f295875c + "] onReqDownloadResult isSuccess:false  errCode:" + i3);
                TroopFileDownloadWorker troopFileDownloadWorker10 = TroopFileDownloadWorker.this;
                c.a aVar5 = troopFileDownloadWorker10.f295886n;
                aVar5.f295762k = 1;
                aVar5.f295763l = i3;
                troopFileDownloadWorker10.h(true, be.a.f302115b, be.a.A, 103);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(UUID uuid, boolean z16, int i3, TroopFileDownloadWorker troopFileDownloadWorker);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TroopFileDownloadWorker(long j3, TroopFileTransferManager.Item item, Bundle bundle, b bVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item, bundle, bVar);
            return;
        }
        this.f295876d = true;
        this.f295885m = 0;
        this.f295886n = new c.a();
        this.f295887o = 0L;
        this.f295888p = 0L;
        this.f295889q = 0L;
        this.f295890r = 0L;
        this.f295891s = 0L;
        this.f295892t = false;
        this.f295893u = 0;
        this.f295894v = false;
        this.f295895w = new a();
        this.f295873a = j3;
        this.f295874b = item;
        this.f295878f = bVar;
        UUID uuid = item.Id;
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = "";
        }
        this.f295875c = str;
        this.f295883k = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str) {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (str != null && str.startsWith(sDKPrivatePath)) {
            new File(str).delete();
            return;
        }
        QLog.e("TroopFileDownloadWorker", 1, "delete file not private: " + str);
    }

    public static synchronized String m() {
        String format;
        synchronized (TroopFileDownloadWorker.class) {
            try {
                LockMethodProxy.sleep(1L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            format = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(System.currentTimeMillis()));
        }
        return format;
    }

    protected void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        this.f295886n.a();
        this.f295887o = 0L;
        this.f295888p = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f295885m = i3;
        }
    }

    public boolean D() {
        boolean z16;
        n A;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.f295874b.FilePath)) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] start filepath is null");
            return false;
        }
        this.f295876d = false;
        this.f295886n.f295759h = System.currentTimeMillis();
        this.f295890r = 0L;
        this.f295891s = 0L;
        this.f295894v = false;
        Bundle bundle = this.f295883k;
        if (bundle != null) {
            z16 = bundle.getBoolean("_wifi2mobile_resume_", false);
            if (z16) {
                TroopFileTransferManager.Item item = this.f295874b;
                if (item.W2MPause == 2) {
                    item.W2MPause = 0;
                }
            }
        } else {
            z16 = false;
        }
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] start filename:" + this.f295874b.FileName + " filePath:" + this.f295874b.FilePath + " bResueFromW2MPause:" + z16);
        this.f295874b.Pausing = 0;
        TroopFileManager h16 = com.tencent.mobileqq.troop.filemanager.e.h(this.f295873a);
        if (h16 != null && (A = h16.A(this.f295874b.FilePath)) != null) {
            this.f295886n.f295770s = A.f294923i;
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] no network");
            this.f295876d = true;
            C(4);
            c.a aVar = this.f295886n;
            aVar.f295762k = 9;
            aVar.f295763l = 901;
            w();
            this.f295886n.a();
            com.tencent.mobileqq.troop.filemanager.b.f(this.f295873a, this.f295874b, 10, 106);
            be.d(be.a.f302115b, be.a.f302124k);
            return false;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloadWorker.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopFileDownloadWorker troopFileDownloadWorker = TroopFileDownloadWorker.this;
                if (troopFileDownloadWorker.f295876d) {
                    e.b.e("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileDownloadWorker.this.f295875c + "] start. had stoped");
                    return;
                }
                troopFileDownloadWorker.l();
                String md5 = MD5.toMD5(TroopFileDownloadWorker.this.f295874b.FilePath);
                TroopFileDownloadWorker.this.f295881i = TroopFileDownloadWorker.this.f295880h + md5;
                String str = TroopFileDownloadWorker.this.f295880h + HexUtil.bytes2HexStr(TroopFileDownloadWorker.this.f295874b.FilePath.getBytes()) + ".tmp";
                if (q.m(str) > 0) {
                    e.b.e("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileDownloadWorker.this.f295875c + "] start. use oldVerTmpPath to resume.");
                    TroopFileDownloadWorker.this.f295881i = str;
                }
                TroopFileDownloadWorker troopFileDownloadWorker2 = TroopFileDownloadWorker.this;
                troopFileDownloadWorker2.f295874b.TmpFile = troopFileDownloadWorker2.f295881i;
                troopFileDownloadWorker2.z();
            }
        }, 8, null, false);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    protected void E() {
        String str;
        ?? r16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
        if (b16 == null) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] startDownload app=null");
            c.a aVar = this.f295886n;
            aVar.f295762k = 9;
            aVar.f295763l = 902;
            h(true, be.a.f302115b, be.a.f302136w, 1);
            return;
        }
        com.tencent.mobileqq.troop.filemanager.download.b bVar = this.f295877e;
        if (bVar != null) {
            bVar.f();
            this.f295877e = null;
        }
        String str2 = "/ftn_handler/" + this.f295874b.DownloadUrl + "/?fname=" + HexUtil.string2HexString(this.f295874b.FilePath);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f295874b.DownloadIp);
        boolean z16 = false;
        if (!TextUtils.isEmpty(this.f295874b.DownloadDNS)) {
            if (com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(b16, 3)) {
                QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295875c + "] [IPv6-File] download troopfile. is config enable IPv6. domain[" + this.f295874b.DownloadDNS + "]");
                d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(b16, new d.a(this.f295874b.DownloadDNS, 0), 3);
                if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("TroopFileDownloadWorker", 1, "[" + this.f295875c + "] [IPv6-File] download troopfile. debugIsDisableIPv4OnDoubleStack");
                        arrayList.clear();
                    }
                    com.tencent.mobileqq.filemanager.core.d.a(iPlistForV6Domain.f207644b, arrayList, true, false);
                    this.f295893u = 2;
                    if (iPlistForV6Domain.f207643a == 1) {
                        this.f295893u = 3;
                    }
                    QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295875c + "] [IPv6-File] download troopfile. use IPv6. iplist:" + arrayList.toString());
                } else {
                    QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295875c + "] [IPv6-File] download troopfile. use IPv4");
                    arrayList.add(this.f295874b.DownloadDNS);
                    this.f295893u = 1;
                }
            } else {
                arrayList.add(this.f295874b.DownloadDNS);
                this.f295893u = 1;
            }
        } else {
            this.f295893u = 1;
        }
        this.f295887o = System.currentTimeMillis();
        this.f295886n.f295756e = q.m(this.f295881i);
        long a16 = com.tencent.mobileqq.troop.filemanager.e.a();
        if (TroopFileUtils.u(b16) && !TextUtils.isEmpty(this.f295874b.DownloadDNS)) {
            str = this.f295874b.DownloadDNS;
            z16 = true;
        } else {
            str = null;
        }
        this.f295894v = z16;
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] startDownload. nSessionId:" + a16 + " firstIP=" + this.f295874b.DownloadIp + " urlParams:" + str2 + " mTmpFilePath:" + this.f295881i + " bUseHttps:" + z16 + " httpsDomain:" + str);
        if (t()) {
            this.f295877e = o(b16, a16, this.f295881i, str2, z16, str);
            r16 = 1;
            i3 = 9;
        } else {
            String str3 = this.f295881i;
            TroopFileTransferManager.Item item = this.f295874b;
            r16 = 1;
            i3 = 9;
            this.f295877e = TroopFileDownloader.x(b16, a16, str3, item.ProgressTotal, arrayList, str2, item.cookieValue, z16, str);
        }
        com.tencent.mobileqq.troop.filemanager.download.b bVar2 = this.f295877e;
        if (bVar2 == null) {
            c.a aVar2 = this.f295886n;
            aVar2.f295762k = i3;
            aVar2.f295763l = 903;
            h(r16, be.a.f302115b, be.a.f302136w, r16);
            return;
        }
        bVar2.l(this);
        this.f295877e.download();
        C(2);
    }

    public void F(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (this.f295876d && this.f295885m != 5) {
            e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] stop. but had stoped. mStatus:" + this.f295885m);
            return;
        }
        this.f295876d = true;
        int i16 = 8;
        k(8, 0);
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] stop. mStatus:" + this.f295885m);
        com.tencent.mobileqq.troop.filemanager.download.b bVar = this.f295877e;
        if (bVar != null) {
            bVar.f();
            this.f295877e = null;
        }
        if (this.f295884l != null) {
            com.tencent.biz.troop.file.a.a(com.tencent.mobileqq.troop.filemanager.e.b(), this.f295884l);
            this.f295884l = null;
        }
        TroopFileTransferManager.Item item = this.f295874b;
        item.Pausing = 1;
        int i17 = 9;
        if (i3 == 1) {
            item.W2MPause = 2;
        } else {
            if (i3 == 2) {
                item.Pausing = -1;
                i16 = 12;
            } else if (i3 == 3) {
                item.Pausing = -1;
                i17 = 10;
            }
            com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, item, i17);
            C(0);
            this.f295886n.f295762k = i16;
            w();
            A();
        }
        i16 = 11;
        com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, item, i17);
        C(0);
        this.f295886n.f295762k = i16;
        w();
        A();
    }

    protected final void c(t tVar, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, tVar, str, str2, str3);
            return;
        }
        QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
        if (b16 == null) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] addFMEntity fail app=null ");
            return;
        }
        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar);
        newEntityByTroopFileInfo.isReaded = true;
        String valueOf = String.valueOf(tVar.f294971e);
        newEntityByTroopFileInfo.peerUin = valueOf;
        newEntityByTroopFileInfo.peerNick = ac.l0(b16, valueOf);
        newEntityByTroopFileInfo.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        newEntityByTroopFileInfo.setCloudType(3);
        newEntityByTroopFileInfo.bSend = false;
        newEntityByTroopFileInfo.status = 1;
        newEntityByTroopFileInfo.fProgress = 1.0f;
        newEntityByTroopFileInfo.TroopUin = this.f295873a;
        newEntityByTroopFileInfo.strFileMd5 = str;
        newEntityByTroopFileInfo.strFileSHA = str2;
        newEntityByTroopFileInfo.strFileSha3 = str3;
        int i3 = newEntityByTroopFileInfo.nFileType;
        if (i3 == 0 || i3 == 2) {
            if (TextUtils.isEmpty(str3)) {
                newEntityByTroopFileInfo.strFileSha3 = vb1.a.b(FileManagerUtil.getSha3(tVar.f294978l));
            }
            if (newEntityByTroopFileInfo.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT && TextUtils.isEmpty(newEntityByTroopFileInfo.strFileSHA)) {
                newEntityByTroopFileInfo.strFileSHA = vb1.a.b(FileManagerUtil.getSHA(tVar.f294978l));
            }
        }
        newEntityByTroopFileInfo.str10Md5 = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(tVar.f294978l));
        try {
            newEntityByTroopFileInfo.localModifyTime = new File(tVar.f294978l).lastModified();
        } catch (Exception unused) {
        }
        b16.getFileManagerDataCenter().t(newEntityByTroopFileInfo);
        newEntityByTroopFileInfo.status = 1;
        b16.getFileManagerDataCenter().f0(newEntityByTroopFileInfo);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] onChangeUrl:" + str);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] onRetryDownload");
        com.tencent.mobileqq.troop.filemanager.download.b bVar = this.f295877e;
        if (bVar != null) {
            this.f295874b.retryTimes = bVar.i();
        }
        this.f295887o = System.currentTimeMillis();
        c.a aVar = this.f295886n;
        aVar.f295756e = this.f295874b.ProgressValue;
        aVar.f295764m = 0;
        aVar.f295765n = 0;
        aVar.f295762k = -1;
        aVar.f295763l = 0;
        aVar.f295768q = "";
        aVar.f295769r = "";
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void f(boolean z16, long j3, int i3, String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        int i17 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), str, str2, bundle);
            return;
        }
        if (this.f295876d) {
            return;
        }
        int f16 = com.tencent.mobileqq.troop.filemanager.e.f(str);
        if (f16 == 0) {
            f16 = com.tencent.mobileqq.troop.filemanager.e.g(str2);
        }
        int e16 = com.tencent.mobileqq.troop.filemanager.e.e(str);
        if (!z16) {
            int q16 = q(i3, bundle);
            int r16 = r(i3, e16, bundle);
            if (i3 != 9050) {
                i17 = q16;
            }
            k(i17, r16);
            c.a aVar = this.f295886n;
            aVar.f295764m = e16;
            aVar.f295765n = f16;
            v();
            c.a aVar2 = this.f295886n;
            aVar2.f295764m = 0;
            aVar2.f295765n = 0;
            aVar2.f295762k = 0;
            aVar2.f295763l = 0;
            return;
        }
        i("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] onHasErr. download fail. errCode:" + i3 + " transferedSize:" + j3);
        int q17 = q(i3, bundle);
        int r17 = r(i3, e16, bundle);
        int i18 = be.a.f302117d;
        int i19 = 106;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            i18 = be.a.f302115b;
            i3 = be.a.f302124k;
            i16 = q17;
        } else {
            if (i3 == -5000) {
                i18 = be.a.f302115b;
                i3 = be.a.f302121h;
                r17 = TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK;
                i19 = 303;
            } else if (i3 == -5001) {
                i18 = be.a.f302115b;
                i3 = be.a.f302120g;
                r17 = TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES;
                i19 = 304;
            } else if (i3 == 9039) {
                i18 = be.a.f302115b;
                i3 = be.a.f302127n;
                r17 = 710;
                i19 = 308;
            } else if (i3 == 9004) {
                i18 = be.a.f302115b;
                i3 = be.a.f302124k;
            } else if (i3 == 9301) {
                i18 = be.a.f302115b;
                i3 = be.a.f302122i;
                r17 = 705;
                i19 = 306;
            } else if (i3 == -5001) {
                i18 = be.a.f302115b;
                i3 = be.a.f302130q;
                r17 = 704;
                i19 = 305;
            } else {
                if (this.f295877e.e()) {
                    i3 = be.a.f302129p;
                    i19 = 105;
                    i16 = 4;
                } else {
                    i16 = q17;
                    if (f16 != 0) {
                        i3 = f16;
                    }
                    i19 = 1;
                }
                k(i16, r17);
                c.a aVar3 = this.f295886n;
                aVar3.f295764m = e16;
                aVar3.f295765n = f16;
                h(true, i18, i3, i19);
            }
            i16 = 7;
            k(i16, r17);
            c.a aVar32 = this.f295886n;
            aVar32.f295764m = e16;
            aVar32.f295765n = f16;
            h(true, i18, i3, i19);
        }
        r17 = 306;
        k(i16, r17);
        c.a aVar322 = this.f295886n;
        aVar322.f295764m = e16;
        aVar322.f295765n = f16;
        h(true, i18, i3, i19);
    }

    protected void g(boolean z16, int i3, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f295876d = true;
        this.f295884l = null;
        C(4);
        TroopFileTransferManager.Item item = this.f295874b;
        item.ErrorCode = 0;
        com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, item, 12);
        w();
        A();
        if (z16) {
            if (!TextUtils.isEmpty(this.f295874b.DownloadIp)) {
                str = this.f295874b.DownloadIp;
            } else {
                str = "";
            }
            be.e(i3, i16, str);
        }
        this.f295874b.retryTimes = 0;
        e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] onFileInvailDel  nReportResultCode:" + i3 + " nReportSecResultCode:" + i16);
        b bVar = this.f295878f;
        if (bVar != null) {
            bVar.a(p(), false, i16, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(boolean z16, int i3, int i16, int i17) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f295876d = true;
        this.f295884l = null;
        C(4);
        com.tencent.mobileqq.troop.filemanager.b.f(this.f295873a, this.f295874b, 10, i17);
        w();
        A();
        if (z16) {
            if (!TextUtils.isEmpty(this.f295874b.DownloadIp)) {
                str = this.f295874b.DownloadIp;
            } else {
                str = "";
            }
            be.e(i3, i16, str);
        }
        this.f295874b.retryTimes = 0;
        e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] onDownloadErr  nReportResultCode:" + i3 + " nReportSecResultCode:" + i16 + " troopFileError:" + i17);
        b bVar = this.f295878f;
        if (bVar != null) {
            bVar.a(p(), false, i16, this);
        }
    }

    public void i(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, str, Integer.valueOf(i3), str2);
        } else {
            e.b.b(str, i3, str2);
        }
    }

    protected void j() {
        QQAppInterface b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        long length = new File(this.f295881i).length();
        if (length == 0) {
            QLog.i("TroopFileDownloadWorkerfile_debug", 1, "vfs file get length error. use normal try again.");
            try {
                length = new File(this.f295881i).length();
            } catch (Exception e16) {
                QLog.i("TroopFileDownloadWorkerfile_debug", 1, "normal file get length exception: " + e16.getMessage());
            }
            QLog.i("TroopFileDownloadWorkerfile_debug", 1, "normal file get length[" + length + "]");
        }
        TroopFileTransferManager.Item item = this.f295874b;
        long j3 = item.ProgressTotal;
        if (j3 != 0 && length != j3) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "]  file size check fail. filesize:" + this.f295874b.ProgressTotal + " transSize:" + length);
            k(7, 704);
            h(true, be.a.f302115b, be.a.f302130q, 305);
            B(this.f295881i);
            this.f295874b.ProgressValue = 0L;
            return;
        }
        if (item.FileName.length() > 85) {
            int lastIndexOf = this.f295874b.FileName.lastIndexOf(46);
            if (lastIndexOf < 0) {
                lastIndexOf = 0;
            }
            int length2 = this.f295874b.FileName.length() - 85;
            if (lastIndexOf == 0) {
                TroopFileTransferManager.Item item2 = this.f295874b;
                item2.FileName = item2.FileName.substring(0, 85);
            } else if (lastIndexOf > length2) {
                this.f295874b.FileName = this.f295874b.FileName.substring(0, lastIndexOf - length2) + this.f295874b.FileName.substring(lastIndexOf);
            }
        }
        TroopFileTransferManager.Item item3 = this.f295874b;
        String str = item3.FileName;
        if (!TextUtils.isEmpty(item3.NameForSave)) {
            TroopFileTransferManager.Item item4 = this.f295874b;
            if (item4.SafeCheckRes == 2) {
                str = item4.NameForSave;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = m();
        }
        String file = new File(this.f295879g + str).getAbsoluteFile().toString();
        this.f295882j = file;
        if (FileUtils.fileExists(file)) {
            this.f295882j = FileManagerUtil.recreateFilePath(this.f295882j);
        }
        boolean renameFile = FileManagerUtil.renameFile(new File(this.f295881i), new File(this.f295882j));
        if (!renameFile) {
            renameFile = FileManagerUtil.renameFile(new File(this.f295881i), new File(this.f295882j));
            QLog.e("TroopFileDownloadWorker", 1, "rename with vfs error, normalResult[" + renameFile + "]");
        }
        if (!renameFile) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] renameFile fail  mFilePath:" + this.f295882j);
            k(7, 706);
            h(true, be.a.f302115b, be.a.f302128o, 307);
            return;
        }
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] onDownlaodSuc  mFilePath:" + this.f295882j);
        TroopFileTransferManager.Item item5 = this.f295874b;
        String str2 = this.f295882j;
        item5.LocalFile = str2;
        try {
            new ProcessBuilder("chmod", "777", str2).redirectErrorStream(true).start();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        int fileType = FileManagerUtil.getFileType(q.j(this.f295874b.FileName));
        if ((fileType == 2 || fileType == 0) && !q.p(this.f295874b.getThumbnailFile(this.f295873a, 383))) {
            this.f295874b.genThumb_Middle_OnGettedLargeOrOrigPic = true;
        }
        this.f295876d = true;
        this.f295884l = null;
        C(3);
        com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, this.f295874b, 11);
        c(this.f295874b.getInfo(this.f295873a), com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.f295874b.Md5), com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.f295874b.Sha), this.f295874b.Sha3);
        if (5 == FileManagerUtil.getFileType(this.f295874b.FileName) && (b16 = com.tencent.mobileqq.troop.filemanager.e.b()) != null) {
            b16.getFileManagerEngine().Q().k(this.f295873a, this.f295874b);
        }
        k(0, 0);
        y();
        if (!t()) {
            x();
        }
        A();
        be.d(be.a.f302114a, 0);
        this.f295874b.retryTimes = 0;
        b bVar = this.f295878f;
        if (bVar != null) {
            bVar.a(p(), true, 0, this);
        }
    }

    protected void k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.troop.filemanager.download.b bVar = this.f295877e;
        if (bVar != null) {
            this.f295886n.f295752a = bVar.getUrl();
            this.f295886n.f295753b = this.f295877e.k();
            this.f295886n.f295754c = this.f295877e.m();
            this.f295886n.f295755d = this.f295877e.getProxyType();
        }
        c.a aVar = this.f295886n;
        aVar.f295762k = i3;
        aVar.f295763l = i16;
        aVar.f295757f = this.f295888p;
        if (this.f295887o != 0) {
            aVar.f295758g = System.currentTimeMillis() - this.f295887o;
            if (this.f295888p > 0) {
                c.a aVar2 = this.f295886n;
                if (aVar2.f295758g > 0) {
                    aVar2.f295760i = ((float) r7) / (((float) r3) / 1000.0f);
                    return;
                }
            }
            this.f295886n.f295760i = 0L;
        }
    }

    protected boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f295879g) && !TextUtils.isEmpty(this.f295880h)) {
            return false;
        }
        this.f295879g = AppConstants.SDCARD_FILE_SAVE_PATH;
        File file = new File(this.f295879g);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f295880h = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
        File file2 = new File(this.f295880h);
        if (file2.exists()) {
            return true;
        }
        return true | file2.mkdirs();
    }

    protected int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        com.tencent.mobileqq.troop.filemanager.download.b bVar = this.f295877e;
        if (bVar == null) {
            return 0;
        }
        return QFileUtils.Q(bVar.getUrl());
    }

    protected com.tencent.mobileqq.troop.filemanager.download.b o(QQAppInterface qQAppInterface, long j3, String str, String str2, boolean z16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.troop.filemanager.download.b) iPatchRedirector.redirect((short) 11, this, qQAppInterface, Long.valueOf(j3), str, str2, Boolean.valueOf(z16), str3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void onDownloadProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.f295876d) {
            return;
        }
        TroopFileTransferManager.Item item = this.f295874b;
        long j17 = item.ProgressValue;
        if (j3 > j17) {
            this.f295888p += j3 - j17;
        } else {
            this.f295888p = j3;
        }
        item.ProgressValue = j3;
        long currentTimeMillis = System.currentTimeMillis();
        long j18 = this.f295889q;
        if (j18 == 0 || currentTimeMillis - j18 >= 1500) {
            this.f295889q = currentTimeMillis;
            com.tencent.mobileqq.troop.filemanager.b.h(this.f295873a, this.f295874b);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void onDownloadSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (this.f295876d) {
            return;
        }
        long j3 = this.f295874b.ProgressTotal;
        long j16 = this.f295886n.f295756e;
        if (j3 >= j16) {
            this.f295888p = j3 - j16;
        }
        j();
    }

    public UUID p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UUID) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f295874b.Id;
    }

    protected int q(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) bundle)).intValue();
        }
        return 3;
    }

    protected int r(int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), bundle)).intValue();
        }
        return com.tencent.mobileqq.troop.filemanager.c.a(i3, i16);
    }

    public long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f295873a;
    }

    protected boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, this.f295874b, 8);
            C(5);
        }
    }

    protected final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (t()) {
            this.f295886n.f295771t = 1;
        } else {
            this.f295886n.f295771t = 0;
        }
        c.a aVar = this.f295886n;
        aVar.f295772u = this.f295893u;
        aVar.f295773v = n();
        c.a aVar2 = this.f295886n;
        aVar2.f295774w = this.f295894v ? 1 : 0;
        com.tencent.mobileqq.troop.filemanager.c.b(this.f295873a, this.f295874b, "actGroupFileDownDetail", aVar2);
    }

    protected void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (t()) {
            this.f295886n.f295771t = 1;
        } else {
            this.f295886n.f295771t = 0;
        }
        c.a aVar = this.f295886n;
        aVar.f295772u = this.f295893u;
        aVar.f295773v = n();
        c.a aVar2 = this.f295886n;
        aVar2.f295774w = this.f295894v ? 1 : 0;
        com.tencent.mobileqq.troop.filemanager.c.b(this.f295873a, this.f295874b, "actGroupFileDown", aVar2);
    }

    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (t()) {
            this.f295886n.f295771t = 1;
        } else {
            this.f295886n.f295771t = 0;
        }
        c.a aVar = this.f295886n;
        aVar.f295772u = this.f295893u;
        aVar.f295773v = n();
        c.a aVar2 = this.f295886n;
        aVar2.f295774w = this.f295894v ? 1 : 0;
        com.tencent.mobileqq.troop.filemanager.c.c(this.f295873a, this.f295874b, aVar2, "actGroupFileDownDetail");
    }

    protected void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (t()) {
            this.f295886n.f295771t = 1;
        } else {
            this.f295886n.f295771t = 0;
        }
        c.a aVar = this.f295886n;
        aVar.f295772u = this.f295893u;
        aVar.f295773v = n();
        c.a aVar2 = this.f295886n;
        aVar2.f295774w = this.f295894v ? 1 : 0;
        com.tencent.mobileqq.troop.filemanager.c.c(this.f295873a, this.f295874b, aVar2, "actGroupFileDown");
    }

    protected void z() {
        n A;
        n A2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f295892t = false;
        com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, this.f295874b, 8);
        QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
        if (b16 == null) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] reqDownload app=null");
            c.a aVar = this.f295886n;
            aVar.f295762k = 9;
            aVar.f295763l = 902;
            h(true, be.a.f302115b, be.a.f302136w, 1);
            return;
        }
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] reqDownload");
        TroopFileManager h16 = com.tencent.mobileqq.troop.filemanager.e.h(this.f295873a);
        if (h16 != null && (A = h16.A(this.f295874b.FilePath)) != null && (A2 = h16.A(A.f294929o)) != null) {
            A.f294930p = 8;
            A2.l(A);
        }
        this.f295884l = com.tencent.biz.troop.file.a.q(b16, this.f295873a, this.f295874b, 0, false, false, this.f295895w);
        C(1);
        this.f295890r = com.tencent.mobileqq.service.message.e.K0();
        be.c();
    }
}
