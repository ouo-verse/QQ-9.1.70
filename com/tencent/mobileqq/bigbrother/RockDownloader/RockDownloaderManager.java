package com.tencent.mobileqq.bigbrother.RockDownloader;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RockDownloaderManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f200359d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ RockDownloaderManager this$0;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager$2$a */
        /* loaded from: classes11.dex */
        class a extends com.tencent.mobileqq.bigbrother.RockDownloader.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                }
            }

            @Override // com.tencent.mobileqq.bigbrother.RockDownloader.a
            public void a(RockDownloadInfo rockDownloadInfo, String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, rockDownloadInfo, str, Integer.valueOf(i3));
                } else if (QLog.isColorLevel()) {
                    QLog.d("RockDownloaderManager", 2, "onFail: RockDownloadInfo=", rockDownloadInfo, " errorMsg=", str, " errorCode=", Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.mobileqq.bigbrother.RockDownloader.a
            public void b(ArrayList<RockDownloadInfo> arrayList) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                    return;
                }
                Iterator<RockDownloadInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    RockDownloadInfo next = it.next();
                    if (QLog.isColorLevel()) {
                        QLog.d("RockDownloaderManager", 2, "onSuccess:", next);
                    }
                    boolean a16 = b.a(next);
                    if (QLog.isColorLevel()) {
                        QLog.d("RockDownloaderManager", 2, "install success=", Boolean.valueOf(a16));
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b.b(new RockDownloadInfo("biz_src_kandian", INowUtil.Now_PKG_NAME), new a());
            }
        }
    }

    public RockDownloaderManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f200359d = qQAppInterface;
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RockDownloaderManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            RockDownloaderManager.this.b();
                            return;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("RockDownloaderManager", 2, "autoCleanOverdueFile exception, ", e16);
                                return;
                            }
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        VFSFile[] listFiles;
        long currentTimeMillis = System.currentTimeMillis();
        List<? extends Entity> query = RockDownloader.c().query(RockDownloadInfo.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                RockDownloadInfo rockDownloadInfo = (RockDownloadInfo) it.next();
                if (rockDownloadInfo.endTime + JoinTimeType.SEVEN_DAY < currentTimeMillis / 1000) {
                    VFSFile vFSFile = new VFSFile(rockDownloadInfo.localPath);
                    if (vFSFile.exists()) {
                        vFSFile.delete();
                    }
                    RockDownloader.c().remove(rockDownloadInfo);
                    if (QLog.isColorLevel()) {
                        QLog.d("RockDownloaderManager", 2, "remove info because has overdue", rockDownloadInfo);
                    }
                } else {
                    try {
                        int parseInt = Integer.parseInt(PackageUtil.getAppsVerionCodeBatch(this.f200359d.getApp(), rockDownloadInfo.getPackageName()));
                        int i3 = rockDownloadInfo.realVersionCode;
                        if (i3 > 0 && parseInt >= i3) {
                            VFSFile vFSFile2 = new VFSFile(rockDownloadInfo.localPath);
                            if (vFSFile2.exists()) {
                                vFSFile2.delete();
                            }
                            RockDownloader.c().remove(rockDownloadInfo);
                            if (QLog.isColorLevel()) {
                                QLog.d("RockDownloaderManager", 2, "remove info because has install", rockDownloadInfo);
                            }
                        }
                    } catch (NumberFormatException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("RockDownloaderManager", 2, "get install info error", rockDownloadInfo, " error=", e16.getMessage());
                        }
                    }
                }
            }
        }
        VFSFile vFSFile3 = new VFSFile(RockDownloader.b());
        if (vFSFile3.exists() && (listFiles = vFSFile3.listFiles()) != null && listFiles.length > 0) {
            for (VFSFile vFSFile4 : listFiles) {
                if (vFSFile4.lastModified() + 604800000 < currentTimeMillis) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RockDownloaderManager", 2, "remove file", vFSFile4.getAbsolutePath());
                    }
                    vFSFile4.delete();
                }
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f200359d = null;
        }
    }
}
