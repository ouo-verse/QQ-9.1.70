package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.filemanager.b;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.be;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileThumbnailGenTask implements Runnable {
    static IPatchRedirector $redirector_;
    protected String C;
    protected String D;
    protected String E;
    protected int F;
    protected boolean G;
    protected a H;
    protected Timer I;
    protected TroopFileThumbnailMgr.a J;

    /* renamed from: d, reason: collision with root package name */
    protected long f295988d;

    /* renamed from: e, reason: collision with root package name */
    protected TroopFileTransferManager.Item f295989e;

    /* renamed from: f, reason: collision with root package name */
    protected String f295990f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f295991h;

    /* renamed from: i, reason: collision with root package name */
    protected String f295992i;

    /* renamed from: m, reason: collision with root package name */
    protected String f295993m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(String str, boolean z16, int i3, TroopFileThumbnailGenTask troopFileThumbnailGenTask);
    }

    protected TroopFileThumbnailGenTask(long j3, TroopFileTransferManager.Item item, int i3, String str, a aVar, TroopFileThumbnailMgr.a aVar2) {
        String j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item, Integer.valueOf(i3), str, aVar, aVar2);
            return;
        }
        this.f295991h = true;
        this.G = false;
        this.f295988d = j3;
        this.f295989e = item;
        this.H = aVar;
        this.F = i3;
        this.f295990f = TroopFileThumbnailGenMgr.c(item.Id, i3);
        if (!TextUtils.isEmpty(this.f295989e.LocalFile)) {
            j16 = q.j(this.f295989e.LocalFile);
        } else {
            j16 = q.j(this.f295989e.FileName);
        }
        if (FileManagerUtil.getFileType(j16) == 2) {
            this.G = true;
        }
        if (!TextUtils.isEmpty(str)) {
            this.E = str;
        } else {
            this.E = this.f295989e.LocalFile;
        }
        this.J = aVar2;
    }

    private synchronized void e() {
        Timer timer = this.I;
        if (timer != null) {
            timer.cancel();
            this.I = null;
        }
    }

    private int i() {
        int i3;
        int i16 = this.F;
        if (i16 != 383 && i16 != 640) {
            if (TroopFileUtils.h(this.E, this.C, i16, i16)) {
                return 0;
            }
        } else {
            if (i16 == 640) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            try {
                if (((ICompressOperator) QRoute.api(ICompressOperator.class)).compressAIOThumbnail(this.E, this.C, true, "", i3)) {
                    return 0;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return -2;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int j() {
        try {
            try {
                BufferedOutputStream bufferedOutputStream = null;
                BufferedOutputStream bufferedOutputStream2 = null;
                Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(null, this.E);
                int i3 = 0;
                if (videoThumbnail == null) {
                    return 0;
                }
                FileUtils.deleteFile(this.C);
                try {
                    new VFSFile(this.C).createNewFile();
                    try {
                        try {
                            BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(this.C));
                            try {
                                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                                videoThumbnail.compress(compressFormat, 100, bufferedOutputStream3);
                                videoThumbnail.recycle();
                                bufferedOutputStream3.flush();
                                try {
                                    bufferedOutputStream3.close();
                                    bufferedOutputStream = compressFormat;
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    bufferedOutputStream = compressFormat;
                                }
                            } catch (FileNotFoundException e17) {
                                e = e17;
                                bufferedOutputStream2 = bufferedOutputStream3;
                                e.printStackTrace();
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                i3 = -1;
                                bufferedOutputStream = bufferedOutputStream2;
                                return i3;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedOutputStream = bufferedOutputStream3;
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e26) {
                            e = e26;
                        }
                        return i3;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (IOException unused) {
                    return -2;
                }
            } catch (OutOfMemoryError unused2) {
                return -4;
            }
        } catch (Exception unused3) {
            return -3;
        }
    }

    public static TroopFileThumbnailGenTask m(long j3, TroopFileTransferManager.Item item, int i3, String str, a aVar, TroopFileThumbnailMgr.a aVar2) {
        if (j3 == 0) {
            e.b.b("TroopFileThumbnailGenTask", e.b.f295938b, "getTask. troopuin=0");
            return null;
        }
        if (item == null) {
            e.b.b("TroopFileThumbnailGenTask", e.b.f295938b, "getTask. item=null");
            return null;
        }
        if (item.Id == null) {
            e.b.b("TroopFileThumbnailGenTask", e.b.f295938b, "getTask. item.id=null");
            return null;
        }
        if (i3 == 0) {
            e.b.b("TroopFileThumbnailGenTask", e.b.f295938b, "getTask. nThumbSize=0");
            return null;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(item.LocalFile)) {
            e.b.b("TroopFileThumbnailGenTask", e.b.f295938b, "getTask. localfilepath=null");
            return null;
        }
        return new TroopFileThumbnailGenTask(j3, item, i3, str, aVar, aVar2);
    }

    private synchronized void s(long j3) {
        e();
        BaseTimer baseTimer = new BaseTimer();
        this.I = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileThumbnailGenTask.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    TroopFileThumbnailGenTask.this.f(-6, false);
                }
            }
        }, j3);
    }

    protected void f(int i3, boolean z16) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.f295991h) {
            e.b.e("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] onGenErr but had stop. errCode:" + i3);
            return;
        }
        e();
        this.f295991h = true;
        if (!TextUtils.isEmpty(this.C)) {
            FileUtils.deleteFile(this.C);
        }
        TroopFileThumbnailMgr.n(this.f295989e, this.F);
        e.b.b("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] onGenErr  errCode:" + i3 + " passvieErr:" + z16);
        TroopFileTransferManager.Item item = this.f295989e;
        item.StatusUpdateTimeMs = 0L;
        b.h(this.f295988d, item);
        if (!z16 && (aVar = this.H) != null) {
            aVar.a(n(), false, i3, this);
        }
    }

    protected void g(boolean z16, boolean z17) {
        a aVar;
        Pair<StringBuilder, StringBuilder> pair;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (this.f295991h) {
            e.b.e("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] doSuc but had stop.");
            return;
        }
        e();
        this.f295991h = true;
        if (!z16 && !FileManagerUtil.renameFile(new VFSFile(this.C), new VFSFile(this.D))) {
            e.b.b("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] renameFile fail  mFilePath:" + this.D);
            if (FileUtils.fileExistsAndNotEmpty(this.D)) {
                f(be.a.f302128o, false);
                return;
            }
        }
        r();
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onFileDownload(this.D, null);
        e.b.c("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] onGenSuc  mFilePath:" + this.D + " bHit:" + z16 + " bPassiveEnd:" + z17);
        if (!z16) {
            this.f295989e.StatusUpdateTimeMs = 0L;
        }
        if (ZhuoXusManager.instance().isSendFileQRCodeOpen()) {
            if (this.E.equalsIgnoreCase(this.f295989e.LocalFile)) {
                try {
                    pair = JumpShareUtils.getQRCodeResult(BaseApplication.getContext(), new File(this.D));
                } catch (Throwable unused) {
                    if (QLog.isColorLevel()) {
                        QLog.i("IMG_FILE_QR", 2, "JumpShareUtils.getQRCodeResult crash");
                    }
                    pair = null;
                }
                if (pair != null) {
                    this.f295989e.strQRUrl = ((StringBuilder) pair.first).toString();
                    if (QLog.isDevelopLevel()) {
                        QLog.i("IMG_FILE_QR", 1, "TroopFIleThumbGenTask success:" + this.f295989e.strQRUrl);
                    }
                } else if (JumpShareUtils.isQRing) {
                    this.f295989e.strQRUrl = null;
                } else {
                    this.f295989e.strQRUrl = "";
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("IMG_FILE", 1, "choushane false!");
        }
        b.d(this.f295988d, this.f295989e);
        b.h(this.f295988d, this.f295989e);
        if (!z17 && (aVar = this.H) != null) {
            aVar.a(n(), true, 0, this);
        }
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (!TextUtils.isEmpty(this.f295992i) && !TextUtils.isEmpty(this.f295993m)) {
                return;
            }
            String f16 = TroopFileThumbnailMgr.f();
            this.f295992i = f16;
            this.f295993m = f16;
        }
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.F;
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.E;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f295990f;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.D;
    }

    public void p(boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        } else {
            ThreadManagerV2.post(new Runnable(z16, i3, str) { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f295994d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f295995e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f295996f;

                {
                    this.f295994d = z16;
                    this.f295995e = i3;
                    this.f295996f = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopFileThumbnailGenTask.this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopFileThumbnailGenTask troopFileThumbnailGenTask = TroopFileThumbnailGenTask.this;
                    if (troopFileThumbnailGenTask.f295991h) {
                        e.b.e("TroopFileThumbnailGenTask", e.b.f295938b, "[" + TroopFileThumbnailGenTask.this.f295990f + "] passiveEnd. but had stop");
                        return;
                    }
                    if (!this.f295994d) {
                        troopFileThumbnailGenTask.f(this.f295995e, true);
                        TroopFileThumbnailMgr.a aVar = TroopFileThumbnailGenTask.this.J;
                        if (aVar != null) {
                            aVar.a(false);
                            return;
                        }
                        return;
                    }
                    troopFileThumbnailGenTask.D = troopFileThumbnailGenTask.f295989e.getThumbnailFile(troopFileThumbnailGenTask.f295988d, troopFileThumbnailGenTask.F);
                    if (TroopFileThumbnailGenTask.this.D.equalsIgnoreCase(this.f295996f)) {
                        e.b.e("TroopFileThumbnailGenTask", e.b.f295938b, "[" + TroopFileThumbnailGenTask.this.f295990f + "] passiveSuc thumbpath is same.");
                        TroopFileThumbnailGenTask.this.g(true, true);
                    } else {
                        e.b.c("TroopFileThumbnailGenTask", e.b.f295938b, "[" + TroopFileThumbnailGenTask.this.f295990f + "] passiveSuc copy file.");
                        TroopFileThumbnailGenTask.this.C = TroopFileThumbnailGenTask.this.D + ".ttmp";
                        FileUtils.copyFile(this.f295996f, TroopFileThumbnailGenTask.this.C);
                        TroopFileThumbnailGenTask.this.g(false, true);
                    }
                    TroopFileThumbnailMgr.a aVar2 = TroopFileThumbnailGenTask.this.J;
                    if (aVar2 != null) {
                        aVar2.a(true);
                    }
                }
            }, 5, null, true);
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        e.b.c("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] passiveStart.");
        this.f295991h = false;
        s(90000L);
    }

    protected void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            TroopFileThumbnailMgr.n(this.f295989e, this.F);
            TroopFileThumbnailMgr.d(this.f295988d, this.f295989e, this.F, this.D);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.f295991h) {
            e.b.e("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] run genThumb. but had stop");
            return;
        }
        h();
        this.D = this.f295989e.getThumbnailFile(this.f295988d, this.F);
        this.C = this.D + ".ttmp";
        e.b.c("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] run genThumb. mTmpFilePath:" + this.C + " thumbPath:" + this.D);
        if (FileUtils.fileExistsAndNotEmpty(this.D)) {
            e.b.e("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] thumb had exsited");
            g(true, false);
            return;
        }
        if (!FileUtils.fileExistsAndNotEmpty(this.E)) {
            e.b.e("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] origfile is no exsit");
            f(-111, false);
            return;
        }
        FileUtils.deleteFile(this.C);
        try {
            new VFSFile(this.C).createNewFile();
            if (this.G) {
                i3 = j();
            } else {
                i3 = i();
            }
            if (i3 != 0) {
                f(i3, false);
            } else {
                g(false, false);
            }
        } catch (IOException unused) {
            f(-1, false);
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f295991h) {
            e.b.c("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] stop. but had stoped");
            return;
        }
        e.b.c("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] stop.");
        e();
        this.f295991h = true;
        TroopFileThumbnailMgr.n(this.f295989e, this.F);
        if (!TextUtils.isEmpty(this.C)) {
            FileUtils.deleteFile(this.C);
        }
        TroopFileTransferManager.Item item = this.f295989e;
        item.StatusUpdateTimeMs = 0L;
        b.h(this.f295988d, item);
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        this.f295991h = false;
        s(90000L);
        e.b.c("TroopFileThumbnailGenTask", e.b.f295938b, "[" + this.f295990f + "] start.");
        ThreadManagerV2.post(this, 5, null, true);
        return true;
    }
}
