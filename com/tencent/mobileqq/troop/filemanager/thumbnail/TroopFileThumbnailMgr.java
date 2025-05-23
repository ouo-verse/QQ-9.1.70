package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.b;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileThumbnailMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static TroopFileThumbnailMgr f295997c;

    /* renamed from: a, reason: collision with root package name */
    private TroopFileThumbnailGenMgr f295998a;

    /* renamed from: b, reason: collision with root package name */
    private TroopFileThumbnailFetchMgr f295999b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr$4, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ UUID f296006d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f296007e;
        final /* synthetic */ TroopFileThumbnailMgr this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.f295998a.k(this.f296006d, this.f296007e);
                this.this$0.f295999b.j(this.f296006d, this.f296007e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean z16);
    }

    TroopFileThumbnailMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f295998a = new TroopFileThumbnailGenMgr();
            this.f295999b = new TroopFileThumbnailFetchMgr();
        }
    }

    public static final boolean d(long j3, TroopFileTransferManager.Item item, int i3, String str) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z17 = true;
        if (i3 == 128) {
            if (FileUtils.fileExistsAndNotEmpty(str)) {
                boolean z18 = !item.HasThumbnailFile_Small;
                item.HasThumbnailFile_Small = true;
                if (!str.equalsIgnoreCase(item.smallThumbFile)) {
                    z16 = true;
                } else {
                    z16 = z18;
                }
                item.smallThumbFile = str;
                item.ThumbnailFileTimeMS_Small = 0L;
            }
            z17 = false;
        } else if (i3 == 640) {
            if (FileUtils.fileExistsAndNotEmpty(str)) {
                boolean z19 = !item.HasThumbnailFile_Large;
                item.HasThumbnailFile_Large = true;
                if (!str.equalsIgnoreCase(item.largeThumbnailFile)) {
                    z16 = true;
                } else {
                    z16 = z19;
                }
                item.largeThumbnailFile = str;
                item.ThumbnailFileTimeMS_Large = 0L;
            }
            z17 = false;
        } else {
            if (i3 == 383 && FileUtils.fileExistsAndNotEmpty(str)) {
                boolean z26 = !item.HasThumbnailFile_Middle;
                item.HasThumbnailFile_Middle = true;
                if (!str.equalsIgnoreCase(item.middleThumbnailFile)) {
                    z26 = true;
                }
                item.middleThumbnailFile = str;
                item.ThumbnailFileTimeMS_Middle = 0L;
                item.ThumbnailDownloading_Middle_Fail = false;
                z16 = z26;
            }
            z17 = false;
        }
        if (z16) {
            b.d(j3, item);
        }
        return z17;
    }

    public static final boolean e(long j3, TroopFileTransferManager.Item item, int i3) {
        if (j3 == 0 || item == null || !d(j3, item, i3, item.getThumbnailFile(j3, i3))) {
            return false;
        }
        return true;
    }

    public static final String f() {
        String str = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
        VFSFile vFSFile = new VFSFile(str);
        if (!vFSFile.exists()) {
            vFSFile.mkdirs();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(long j3, TroopFileTransferManager.Item item, int i3) {
        boolean z16;
        String thumbnailFile = item.getThumbnailFile(j3, 640);
        String str = item.LocalFile;
        if (str != null) {
            VFSFile vFSFile = new VFSFile(str);
            if (vFSFile.exists()) {
                if (item.origLastModifyTime != 0) {
                    if (item.origLastModifyTime != vFSFile.lastModified() && TextUtils.isEmpty(item.FilePath) && this.f295999b.b(j3, item, i3) == 0) {
                        z16 = true;
                        if (z16) {
                            this.f295998a.b(j3, item, i3, null, null);
                            return;
                        }
                        return;
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        }
        if (i3 == 383 && q.f(thumbnailFile)) {
            this.f295998a.b(j3, item, i3, thumbnailFile, null);
        } else {
            this.f295999b.b(j3, item, i3);
        }
    }

    public static synchronized TroopFileThumbnailMgr j() {
        TroopFileThumbnailMgr troopFileThumbnailMgr;
        synchronized (TroopFileThumbnailMgr.class) {
            if (f295997c == null) {
                f295997c = new TroopFileThumbnailMgr();
            }
            troopFileThumbnailMgr = f295997c;
        }
        return troopFileThumbnailMgr;
    }

    public static final void m(TroopFileTransferManager.Item item, int i3) {
        String str;
        if (item == null) {
            return;
        }
        if (i3 == 128) {
            item.ThumbnailDownloading_Small = true;
            item.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
        } else if (i3 == 640) {
            item.ThumbnailDownloading_Large = true;
            item.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
        } else if (i3 == 383) {
            item.ThumbnailDownloading_Middle = true;
            item.ThumbnailFileTimeMS_Middle = SystemClock.uptimeMillis();
        }
        StringBuilder sb5 = new StringBuilder();
        UUID uuid = item.Id;
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append("_");
        sb5.append(i3);
        String sb6 = sb5.toString();
        e.b.c("TroopFileThumbnailMgr", e.b.f295938b, "[" + sb6 + "] setGettingStatus. ");
    }

    public static final void n(TroopFileTransferManager.Item item, int i3) {
        String str;
        if (item == null) {
            return;
        }
        if (i3 == 128) {
            item.ThumbnailDownloading_Small = false;
        } else if (i3 == 640) {
            item.ThumbnailDownloading_Large = false;
        } else if (i3 == 383) {
            item.ThumbnailDownloading_Middle = false;
        }
        StringBuilder sb5 = new StringBuilder();
        UUID uuid = item.Id;
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append("_");
        sb5.append(i3);
        String sb6 = sb5.toString();
        e.b.c("TroopFileThumbnailMgr", e.b.f295938b, "[" + sb6 + "] setStopGetStatus. ");
    }

    public void g(long j3, TroopFileTransferManager.Item item, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), item, Integer.valueOf(i3), aVar);
        } else {
            TroopFileTransferMgr.N0(new Runnable(j3, item, i3, aVar) { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f296008d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TroopFileTransferManager.Item f296009e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f296010f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ a f296011h;

                {
                    this.f296008d = j3;
                    this.f296009e = item;
                    this.f296010f = i3;
                    this.f296011h = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopFileThumbnailMgr.this, Long.valueOf(j3), item, Integer.valueOf(i3), aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TroopFileThumbnailMgr.this.f295998a.b(this.f296008d, this.f296009e, this.f296010f, null, this.f296011h) != 0) {
                        this.f296011h.a(false);
                    }
                }
            }, true);
        }
    }

    public void h(long j3, TroopFileTransferManager.Item item, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), item, Integer.valueOf(i3));
            return;
        }
        if (j3 == 0 || item == null || item.Id == null || i3 == 0) {
            return;
        }
        if (!item.canFetchThumbnailFile(i3)) {
            if (i3 == 383 && item.genThumb_Middle_OnGettedLargeOrOrigPic) {
                item.genThumb_Middle_OnGettedLargeOrOrigPic = false;
                TroopFileTransferMgr.N0(new Runnable(item, j3, i3) { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TroopFileTransferManager.Item f296000d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ long f296001e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f296002f;

                    {
                        this.f296000d = item;
                        this.f296001e = j3;
                        this.f296002f = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopFileThumbnailMgr.this, item, Long.valueOf(j3), Integer.valueOf(i3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        String thumbnailFile = this.f296000d.getThumbnailFile(this.f296001e, 640);
                        if (q.f(thumbnailFile)) {
                            TroopFileThumbnailMgr.this.f295998a.b(this.f296001e, this.f296000d, this.f296002f, thumbnailFile, null);
                            return;
                        }
                        String str = this.f296000d.LocalFile;
                        if (str != null && new VFSFile(str).exists()) {
                            TroopFileThumbnailMgr.this.f295998a.b(this.f296001e, this.f296000d, this.f296002f, null, null);
                        }
                    }
                }, false);
                return;
            }
            return;
        }
        if (e(j3, item, i3)) {
            item.StatusUpdateTimeMs = 0L;
            b.h(j3, item);
        } else {
            TroopFileTransferMgr.N0(new Runnable(j3, item, i3) { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f296003d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TroopFileTransferManager.Item f296004e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f296005f;

                {
                    this.f296003d = j3;
                    this.f296004e = item;
                    this.f296005f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopFileThumbnailMgr.this, Long.valueOf(j3), item, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopFileThumbnailMgr.this.i(this.f296003d, this.f296004e, this.f296005f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, false);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        e.b.c("TroopFileThumbnailMgr", e.b.f295938b, "init");
        this.f295998a.e();
        this.f295999b.e();
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            e.b.c("TroopFileThumbnailMgr", e.b.f295938b, "release");
            TroopFileTransferMgr.N0(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileThumbnailMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopFileThumbnailMgr.this.f295998a.h();
                        TroopFileThumbnailMgr.this.f295999b.g();
                    }
                }
            }, true);
        }
    }
}
