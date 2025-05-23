package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.filemanager.thumbnail.a;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.be;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ef0.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.java_websocket.WebSocketImpl;
import qb1.g;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileThumbnailFetchWorker implements a.InterfaceC8693a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f295963a;

    /* renamed from: b, reason: collision with root package name */
    protected TroopFileTransferManager.Item f295964b;

    /* renamed from: c, reason: collision with root package name */
    protected String f295965c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f295966d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.filemanager.thumbnail.a f295967e;

    /* renamed from: f, reason: collision with root package name */
    protected b f295968f;

    /* renamed from: g, reason: collision with root package name */
    protected String f295969g;

    /* renamed from: h, reason: collision with root package name */
    protected String f295970h;

    /* renamed from: i, reason: collision with root package name */
    protected String f295971i;

    /* renamed from: j, reason: collision with root package name */
    protected String f295972j;

    /* renamed from: k, reason: collision with root package name */
    protected int f295973k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f295974l;

    /* renamed from: m, reason: collision with root package name */
    protected g f295975m;

    /* renamed from: n, reason: collision with root package name */
    protected Timer f295976n;

    /* renamed from: o, reason: collision with root package name */
    protected int f295977o;

    /* renamed from: p, reason: collision with root package name */
    m f295978p;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker$3, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass3 extends TimerTask {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TroopFileThumbnailFetchWorker this$0;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends m {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileThumbnailFetchWorker.this);
            }
        }

        @Override // ef0.m
        public void c(boolean z16, int i3, oidb_0x6d6$DownloadFileRspBody oidb_0x6d6_downloadfilerspbody, Bundle bundle) {
            String string;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), oidb_0x6d6_downloadfilerspbody, bundle);
                return;
            }
            if (bundle.getLong("troopUin") != TroopFileThumbnailFetchWorker.this.f295963a || (string = bundle.getString("itemKey")) == null || !UUID.fromString(string).equals(TroopFileThumbnailFetchWorker.this.i()) || TroopFileThumbnailFetchWorker.this.f295966d) {
                return;
            }
            int i17 = bundle.getInt("thumbNail");
            boolean z17 = bundle.getBoolean("isPreview", false);
            if (i17 != 0 && !z17 && i17 == TroopFileThumbnailFetchWorker.this.f295973k) {
                if (oidb_0x6d6_downloadfilerspbody != null && z16) {
                    int i18 = oidb_0x6d6_downloadfilerspbody.int32_ret_code.get();
                    e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] onReqFetchResult isSuccess:true  errCode:" + i3 + " retCode:" + i18);
                    if (i18 < 0) {
                        if (i18 != -103 && i18 != -302 && i18 != -301) {
                            TroopFileThumbnailFetchWorker.this.c(i18);
                        } else {
                            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] onReqFetchResult  file is not exsit. retCode:" + i18);
                            TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker = TroopFileThumbnailFetchWorker.this;
                            troopFileThumbnailFetchWorker.f295966d = true;
                            troopFileThumbnailFetchWorker.o(4);
                            TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker2 = TroopFileThumbnailFetchWorker.this;
                            TroopFileTransferManager.Item item = troopFileThumbnailFetchWorker2.f295964b;
                            item.ErrorCode = 0;
                            com.tencent.mobileqq.troop.filemanager.b.e(troopFileThumbnailFetchWorker2.f295963a, item, 12);
                            TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker3 = TroopFileThumbnailFetchWorker.this;
                            b bVar = troopFileThumbnailFetchWorker3.f295968f;
                            if (bVar != null) {
                                bVar.a(troopFileThumbnailFetchWorker3.j(), false, i18, TroopFileThumbnailFetchWorker.this);
                            }
                        }
                    }
                    TroopFileThumbnailFetchWorker.this.f295964b.cookieValue = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_cookie_val.get().toByteArray());
                    TroopFileTransferManager.Item item2 = TroopFileThumbnailFetchWorker.this.f295964b;
                    String str2 = item2.cookieValue;
                    if (str2 != null) {
                        item2.cookieValue = str2.toLowerCase();
                    }
                    TroopFileThumbnailFetchWorker.this.f295964b.DownloadIp = oidb_0x6d6_downloadfilerspbody.str_download_ip.get();
                    TroopFileThumbnailFetchWorker.this.f295964b.DownloadDNS = oidb_0x6d6_downloadfilerspbody.str_download_dns.get().toStringUtf8();
                    TroopFileThumbnailFetchWorker.this.f295964b.DownloadUrl = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_download_url.get().toByteArray());
                    TroopFileThumbnailFetchWorker.this.f295964b.Md5 = oidb_0x6d6_downloadfilerspbody.bytes_md5.get().toByteArray();
                    TroopFileThumbnailFetchWorker.this.f295964b.NameForSave = oidb_0x6d6_downloadfilerspbody.str_save_file_name.get();
                    if (TextUtils.isEmpty(TroopFileThumbnailFetchWorker.this.f295964b.DownloadIp)) {
                        e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] onReqFetchResult DownloadIp is null");
                        be.b("gfile", "ipnull", "", "", "", "");
                    }
                    int i19 = oidb_0x6d6_downloadfilerspbody.uint32_preview_port.get();
                    e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] onReqFetchResult DownloadIp:" + TroopFileThumbnailFetchWorker.this.f295964b.DownloadIp + " DownloadDNS:" + TroopFileThumbnailFetchWorker.this.f295964b.DownloadDNS + " videoPort:" + i19 + " DownloadUrl:" + TroopFileThumbnailFetchWorker.this.f295964b.DownloadUrl + " cookieValue:" + TroopFileThumbnailFetchWorker.this.f295964b.cookieValue);
                    if (oidb_0x6d6_downloadfilerspbody.uint32_preview_port_https.has()) {
                        i16 = oidb_0x6d6_downloadfilerspbody.uint32_preview_port_https.get();
                    }
                    if (oidb_0x6d6_downloadfilerspbody.str_download_dns_https.has()) {
                        str = oidb_0x6d6_downloadfilerspbody.str_download_dns_https.get();
                    } else {
                        str = null;
                    }
                    TroopFileThumbnailFetchWorker.this.q(i19, str, i16);
                    return;
                }
                e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] onReqFetchResult isSuccess:false  errCode:" + i3);
                TroopFileThumbnailFetchWorker.this.c(be.a.A);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(String str, boolean z16, int i3, TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker);
    }

    protected TroopFileThumbnailFetchWorker(long j3, TroopFileTransferManager.Item item, int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item, Integer.valueOf(i3), bVar);
            return;
        }
        this.f295966d = true;
        this.f295974l = false;
        this.f295977o = 0;
        this.f295978p = new a();
        this.f295963a = j3;
        this.f295964b = item;
        this.f295968f = bVar;
        this.f295973k = i3;
        this.f295965c = TroopFileThumbnailFetchMgr.c(item.Id, i3);
        if (FileManagerUtil.getFileType(q.j(this.f295964b.FileName)) == 2) {
            this.f295974l = true;
        }
    }

    private synchronized void b() {
        Timer timer = this.f295976n;
        if (timer != null) {
            timer.cancel();
            this.f295976n = null;
        }
    }

    public static TroopFileThumbnailFetchWorker k(long j3, TroopFileTransferManager.Item item, int i3, b bVar) {
        if (j3 == 0) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "getWoker. troopuin=0");
            return null;
        }
        if (item == null) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "getWoker. item=null");
            return null;
        }
        if (item.Id == null) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "getWoker. item.id=null");
            return null;
        }
        if (i3 == 0) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "getWoker. nThumbSize=0");
            return null;
        }
        return new TroopFileThumbnailFetchWorker(j3, item, i3, bVar);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.thumbnail.a.InterfaceC8693a
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        TroopFileTransferManager.Item item = this.f295964b;
        if (item.duration == 0 && i3 != 0) {
            item.duration = i3;
            this.f295967e.E(true);
        }
    }

    protected void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        this.f295966d = true;
        this.f295975m = null;
        b();
        if (!TextUtils.isEmpty(this.f295971i)) {
            File file = new File(this.f295971i);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (file.exists() && this.f295971i.startsWith(sDKPrivatePath)) {
                FileUtils.deleteFile(this.f295971i);
            }
        }
        o(4);
        m();
        e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] onFetchErr  errCode:" + i3);
        TroopFileTransferManager.Item item = this.f295964b;
        item.StatusUpdateTimeMs = 0L;
        if (i3 == be.a.f302138y) {
            item.thumbInvalidCode = 1;
        } else if (i3 == be.a.f302129p) {
            item.thumbInvalidCode = 2;
        } else {
            item.thumbInvalidCode = 0;
        }
        com.tencent.mobileqq.troop.filemanager.b.h(this.f295963a, item);
        b bVar = this.f295968f;
        if (bVar != null) {
            bVar.a(j(), false, i3, this);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void f(boolean z16, long j3, int i3, String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), str, str2, bundle);
            return;
        }
        if (this.f295966d || !z16) {
            return;
        }
        e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] onHasErr. fetch fail. errCode:" + i3 + " transferedSize:" + j3);
        if (i3 == -5000) {
            i3 = be.a.f302121h;
        } else if (i3 == -5001) {
            i3 = be.a.f302120g;
        } else if (i3 == 9039) {
            i3 = be.a.f302127n;
        } else if (i3 == 9004) {
            i3 = be.a.f302124k;
        } else if (i3 == 9301) {
            i3 = be.a.f302122i;
        } else if (i3 == -5001) {
            i3 = be.a.f302130q;
        } else if (this.f295967e.e()) {
            i3 = be.a.f302129p;
        } else if (i3 == -5003) {
            i3 = be.a.f302138y;
        }
        c(i3);
    }

    protected void g(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        this.f295966d = true;
        this.f295975m = null;
        b();
        if (!z16) {
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str = this.f295971i;
            if (str != null && !str.startsWith(sDKPrivatePath)) {
                e.b.b("TroopFileDownloadWorker", e.b.f295938b, "not private mTmpFilePath:" + this.f295971i);
            }
            if (!FileManagerUtil.renameFile(new VFSFile(this.f295971i), new VFSFile(this.f295972j))) {
                e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] renameFile fail  mFilePath:" + this.f295972j);
                if (FileUtils.fileExistsAndNotEmpty(this.f295972j)) {
                    c(be.a.f302128o);
                    return;
                }
            }
        }
        o(3);
        n();
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onFileDownload(this.f295972j, null);
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] onFetchSuc  mFilePath:" + this.f295972j);
        if (!z16) {
            this.f295964b.StatusUpdateTimeMs = 0L;
        }
        if (this.f295973k == 640 && !q.p(this.f295964b.getThumbnailFile(this.f295963a, 383))) {
            this.f295964b.genThumb_Middle_OnGettedLargeOrOrigPic = true;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        FilePicURLDrawlableHelper.m(this.f295972j, options);
        int i16 = options.outWidth;
        if (i16 > 0 && (i3 = options.outHeight) > 0) {
            TroopFileTransferManager.Item item = this.f295964b;
            item.width = i16;
            item.height = i3;
        }
        com.tencent.mobileqq.troop.filemanager.b.d(this.f295963a, this.f295964b);
        com.tencent.mobileqq.troop.filemanager.b.h(this.f295963a, this.f295964b);
        b bVar = this.f295968f;
        if (bVar != null) {
            bVar.a(j(), true, 0, this);
        }
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            if (!TextUtils.isEmpty(this.f295969g) && !TextUtils.isEmpty(this.f295970h)) {
                return;
            }
            String f16 = TroopFileThumbnailMgr.f();
            this.f295969g = f16;
            this.f295970h = f16;
        }
    }

    public UUID i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UUID) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f295964b.Id;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f295965c;
    }

    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QQAppInterface b16 = e.b();
        if (b16 == null) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] reqFetch app=null");
            c(be.a.f302136w);
            return;
        }
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] reqFetch");
        this.f295975m = com.tencent.biz.troop.file.a.q(b16, this.f295963a, this.f295964b, this.f295973k, false, false, this.f295978p);
        o(1);
    }

    protected void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        TroopFileThumbnailMgr.n(this.f295964b, this.f295973k);
        if (this.f295973k == 383) {
            this.f295964b.ThumbnailDownloading_Middle_Fail = true;
        }
    }

    protected void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        TroopFileThumbnailMgr.n(this.f295964b, this.f295973k);
        boolean d16 = TroopFileThumbnailMgr.d(this.f295963a, this.f295964b, this.f295973k, this.f295972j);
        if (this.f295973k == 383) {
            this.f295964b.ThumbnailDownloading_Middle_Fail = !d16;
        }
    }

    protected void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f295977o = i3;
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void onDownloadProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.c
    public void onDownloadSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            if (this.f295966d) {
                return;
            }
            g(false);
        }
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] start fetch thumb. filename:" + this.f295964b.FileName + " filePath:" + this.f295964b.FilePath);
        this.f295966d = false;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileThumbnailFetchWorker.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker = TroopFileThumbnailFetchWorker.this;
                if (troopFileThumbnailFetchWorker.f295966d) {
                    e.b.e("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] start. had stoped");
                    return;
                }
                troopFileThumbnailFetchWorker.h();
                TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker2 = TroopFileThumbnailFetchWorker.this;
                troopFileThumbnailFetchWorker2.f295972j = troopFileThumbnailFetchWorker2.f295964b.getThumbnailFile(troopFileThumbnailFetchWorker2.f295963a, troopFileThumbnailFetchWorker2.f295973k);
                TroopFileThumbnailFetchWorker.this.f295971i = TroopFileThumbnailFetchWorker.this.f295972j + ".ttmp";
                if (FileUtils.fileExistsAndNotEmpty(TroopFileThumbnailFetchWorker.this.f295972j)) {
                    e.b.e("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] thumb had exsited");
                    TroopFileThumbnailFetchWorker.this.g(true);
                    return;
                }
                if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                    e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] no network");
                    TroopFileThumbnailFetchWorker.this.c(be.a.f302124k);
                    return;
                }
                if (TextUtils.isEmpty(TroopFileThumbnailFetchWorker.this.f295964b.FilePath)) {
                    e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + TroopFileThumbnailFetchWorker.this.f295965c + "] filepath is null");
                    TroopFileThumbnailFetchWorker.this.c(be.a.f302136w);
                    return;
                }
                TroopFileThumbnailFetchWorker.this.l();
            }
        }, 8, null, false);
        return true;
    }

    protected void q(int i3, String str, int i16) {
        boolean z16;
        String str2;
        String str3;
        String str4;
        boolean z17;
        int i17;
        boolean z18;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        QQAppInterface b16 = e.b();
        if (b16 == null) {
            e.b.b("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] startFetch app=null");
            c(be.a.f302136w);
            return;
        }
        File file = new File(this.f295971i);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (file.exists() && this.f295971i.startsWith(sDKPrivatePath)) {
            FileUtils.deleteFile(this.f295971i);
        }
        String str6 = "/ftn_handler/" + this.f295964b.DownloadUrl + "/?fname=" + this.f295964b.FilePath + "&pictype=cut&size=" + this.f295973k + "*" + this.f295973k;
        ArrayList arrayList = new ArrayList();
        if (this.f295974l) {
            int i18 = WebSocketImpl.DEFAULT_WSS_PORT;
            if (i3 <= 0) {
                i17 = 443;
            } else {
                i17 = i3;
            }
            if (TroopFileUtils.w(b16) && !TextUtils.isEmpty(str)) {
                str5 = str;
                z18 = true;
            } else {
                z18 = false;
                str5 = null;
            }
            if (z18) {
                if (i16 > 0) {
                    i18 = i16;
                }
            } else {
                i18 = i17;
            }
            String str7 = "/ftn_video_pic/rkey=" + this.f295964b.DownloadUrl + "&filetype=17&size=" + this.f295973k + "*" + this.f295973k + ContainerUtils.FIELD_DELIMITER;
            arrayList.add(this.f295964b.DownloadIp + ":" + i18);
            if (!TextUtils.isEmpty(this.f295964b.DownloadDNS)) {
                if (d.c().isConfigEnableIPV6(b16, 3)) {
                    QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopVideo thumb. is config enable IPv6. domain[" + this.f295964b.DownloadDNS + "]");
                    d.c iPlistForV6Domain = d.c().getIPlistForV6Domain(b16, new d.a(this.f295964b.DownloadDNS, i18), 3);
                    if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                        if (d.b()) {
                            QLog.d("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopVideo thumb. debugIsDisableIPv4OnDoubleStack");
                            arrayList.clear();
                        }
                        d.a(iPlistForV6Domain.f207644b, arrayList, false, false);
                        QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopVideo thumb. use IPv6. iplist:" + arrayList.toString());
                    } else {
                        QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopVideo thumb. use IPv4:");
                        arrayList.add(this.f295964b.DownloadDNS + ":" + i18);
                    }
                } else {
                    arrayList.add(this.f295964b.DownloadDNS + ":" + i18);
                }
            }
            str3 = str5;
            boolean z19 = z18;
            str4 = str7;
            z17 = z19;
        } else {
            if (TroopFileUtils.w(b16) && !TextUtils.isEmpty(this.f295964b.DownloadDNS)) {
                str2 = this.f295964b.DownloadDNS;
                z16 = true;
            } else {
                z16 = false;
                str2 = null;
            }
            arrayList.add(this.f295964b.DownloadIp);
            if (!TextUtils.isEmpty(this.f295964b.DownloadDNS)) {
                if (d.c().isConfigEnableIPV6(b16, 3)) {
                    QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopImage thumb. is config enable IPv6. domain[" + this.f295964b.DownloadDNS + "]");
                    d.c iPlistForV6Domain2 = d.c().getIPlistForV6Domain(b16, new d.a(this.f295964b.DownloadDNS, 0), 3);
                    if (iPlistForV6Domain2 != null && !iPlistForV6Domain2.a()) {
                        if (d.b()) {
                            QLog.d("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopImage thumb. debugIsDisableIPv4OnDoubleStack");
                            arrayList.clear();
                        }
                        d.a(iPlistForV6Domain2.f207644b, arrayList, true, false);
                        QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopImage thumb. use IPv6. iplist:" + arrayList.toString());
                    } else {
                        QLog.i("TroopFileDownloadWorker", 1, "[" + this.f295965c + "] [IPv6-File] download troopImage thumb. use IPv4");
                        arrayList.add(this.f295964b.DownloadDNS);
                    }
                } else {
                    arrayList.add(this.f295964b.DownloadDNS);
                }
            }
            str3 = str2;
            str4 = str6;
            z17 = z16;
        }
        long a16 = e.a();
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] startFetch. nSessionId:" + a16 + " firstIP=" + this.f295964b.DownloadIp + " urlParams:" + str4 + " mTmpFilePath:" + this.f295971i + " bUseHttps:" + z17 + " httpsDomain:" + str3);
        com.tencent.mobileqq.troop.filemanager.thumbnail.a aVar = this.f295967e;
        if (aVar != null) {
            aVar.f();
            this.f295967e = null;
        }
        com.tencent.mobileqq.troop.filemanager.thumbnail.a C = com.tencent.mobileqq.troop.filemanager.thumbnail.a.C(b16, a16, this.f295971i, 0L, arrayList, str4, this.f295964b.cookieValue, this.f295974l, z17, str3);
        this.f295967e = C;
        if (C == null) {
            c(be.a.f302136w);
            return;
        }
        C.l(this);
        this.f295967e.D();
        this.f295967e.B(false);
        if (this.f295964b.duration != 0) {
            this.f295967e.E(true);
        }
        this.f295967e.download();
        o(2);
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f295966d) {
            e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] stop. but had stoped. mStatus:" + this.f295977o);
            return;
        }
        this.f295966d = true;
        e.b.c("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] stop fetch. mStatus:" + this.f295977o);
        if (this.f295977o == 2) {
            com.tencent.mobileqq.troop.filemanager.thumbnail.a aVar = this.f295967e;
            if (aVar != null) {
                aVar.f();
                this.f295967e = null;
            } else {
                e.b.e("TroopFileDownloadWorker", e.b.f295938b, "[" + this.f295965c + "] stop downloader=null");
            }
        }
        b();
        if (this.f295975m != null) {
            com.tencent.biz.troop.file.a.a(e.b(), this.f295975m);
            this.f295975m = null;
        }
        m();
        if (!TextUtils.isEmpty(this.f295971i)) {
            File file = new File(this.f295971i);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (file.exists() && this.f295971i.startsWith(sDKPrivatePath)) {
                FileUtils.deleteFile(this.f295971i);
            }
        }
        TroopFileTransferManager.Item item = this.f295964b;
        item.StatusUpdateTimeMs = 0L;
        com.tencent.mobileqq.troop.filemanager.b.h(this.f295963a, item);
        o(0);
    }
}
