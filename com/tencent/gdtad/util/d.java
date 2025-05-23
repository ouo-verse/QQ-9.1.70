package com.tencent.gdtad.util;

import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/gdtad/util/d;", "", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "", "e", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "", "f", "Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;", "d", "b", "i", tl.h.F, "g", "currentEntity", "c", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "mManagerEntity", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f109551a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static FileManagerEntity mManagerEntity;

    d() {
    }

    private final FileManagerEntity b(DownloadInfo info) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        Long genSessionId = FileManagerUtil.genSessionId();
        Intrinsics.checkNotNullExpressionValue(genSessionId, "genSessionId()");
        fileManagerEntity.nSessionId = genSessionId.longValue();
        fileManagerEntity.bSend = false;
        fileManagerEntity.peerUin = "";
        fileManagerEntity.peerType = 5;
        fileManagerEntity.cloudType = 14;
        fileManagerEntity.nOpType = 55;
        fileManagerEntity.nFileType = 5;
        fileManagerEntity.fileSize = info.f341187f0;
        fileManagerEntity.strFilePath = info.L;
        fileManagerEntity.strServerPath = "";
        fileManagerEntity.yybApkIconUrl = info.Y;
        fileManagerEntity.fileName = info.f341191i;
        fileManagerEntity.yybApkName = info.f341189h;
        fileManagerEntity.Uuid = com.tencent.securitysdk.utils.c.b(info.f341186f + "ANDROIDQQ.FEED.ADVERTISE");
        fileManagerEntity.strFileMd5 = info.f341185e0;
        fileManagerEntity.strSrcName = info.f341184e;
        fileManagerEntity.strFavId = info.C;
        fileManagerEntity.selfUin = info.f341186f;
        fileManagerEntity.lastTime = NetConnInfoCenter.getServerTime();
        return fileManagerEntity;
    }

    private final FileManagerDataCenter d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            return ((QQAppInterface) peekAppRuntime).getFileManagerDataCenter();
        }
        return null;
    }

    private final boolean e(DownloadInfo info) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (TextUtils.isEmpty(info.C)) {
            return false;
        }
        String referURL = info.C;
        Intrinsics.checkNotNullExpressionValue(referURL, "referURL");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(referURL, "ANDROIDQQ.FEED.ADVERTISE", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(referURL, "YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE", false, 2, null);
            if (!startsWith$default2) {
                return false;
            }
        }
        return true;
    }

    private final void f(FileManagerEntity entity) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && entity != null) {
            ((QQAppInterface) peekAppRuntime).getFileManagerNotifyCenter().c(-1L, entity.nSessionId, "", 5, 10, null, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(FileManagerEntity it, AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.bDelInFM = true;
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        qQAppInterface.getFileManagerProxy().o(mManagerEntity, true);
        qQAppInterface.getFileManagerProxy().Y(it.nSessionId);
    }

    @NotNull
    public final DownloadInfo c(@NotNull FileManagerEntity currentEntity) {
        Intrinsics.checkNotNullParameter(currentEntity, "currentEntity");
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.X = true;
        downloadInfo.L = currentEntity.strFilePath;
        downloadInfo.f341191i = currentEntity.fileName;
        downloadInfo.f341186f = currentEntity.selfUin;
        downloadInfo.f341184e = currentEntity.strSrcName;
        downloadInfo.f341185e0 = currentEntity.strFileMd5;
        downloadInfo.S = 5;
        downloadInfo.f341189h = currentEntity.yybApkName;
        downloadInfo.C = currentEntity.strFavId;
        return downloadInfo;
    }

    public final void g(@Nullable FileManagerEntity entity) {
        if (entity != null && !TextUtils.isEmpty(entity.strSrcName)) {
            DownloadInfo c16 = c(entity);
            c16.S = 3;
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).actionByDownloadInfo(c16);
        }
    }

    public final void h(@Nullable FileManagerEntity entity) {
        int i3;
        if (entity == null) {
            return;
        }
        DownloadInfo c16 = c(entity);
        if (com.tencent.mobileqq.filemanager.util.l.b(c16.L)) {
            i3 = 5;
        } else {
            i3 = 2;
        }
        c16.S = i3;
        c16.M = AdDownloadConstants.DOWNLOAD_SOURCE_AD;
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).actionByDownloadInfo(c16);
        f(entity);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r2) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(@Nullable DownloadInfo info) {
        String str;
        if (info != null && e(info)) {
            FileManagerDataCenter d16 = d();
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof QQAppInterface)) {
                return;
            }
            String b16 = com.tencent.securitysdk.utils.c.b(info.f341186f + "ANDROIDQQ.FEED.ADVERTISE");
            FileManagerEntity fileManagerEntity = mManagerEntity;
            if (fileManagerEntity != null) {
                if (fileManagerEntity != null) {
                    str = fileManagerEntity.Uuid;
                } else {
                    str = null;
                }
            }
            FileManagerEntity K = ((QQAppInterface) peekAppRuntime).getFileManagerProxy().K(b16);
            if (K == null) {
                if (d16 != null) {
                    K = d16.j(b16, 5);
                } else {
                    K = null;
                }
            }
            if (K == null && info.f() == 1) {
                K = b(info);
                if (d16 != null) {
                    d16.u(K);
                }
            }
            if (K != null) {
                mManagerEntity = K;
            }
            final FileManagerEntity fileManagerEntity2 = mManagerEntity;
            if (fileManagerEntity2 != null) {
                fileManagerEntity2.fProgress = info.Q / 100.0f;
                fileManagerEntity2.fileSize = (int) info.f341180b0;
                fileManagerEntity2.strQRUrl = info.f341186f;
                fileManagerEntity2.strFilePath = info.L;
                fileManagerEntity2.lastTime = NetConnInfoCenter.getServerTime();
                if (info.f() == 30) {
                    ah.C(fileManagerEntity2.nSessionId, -1, "AdDownloadFileUtil download failed");
                    fileManagerEntity2.status = 0;
                    if (d16 != null) {
                        d16.u(fileManagerEntity2);
                    }
                }
                if (info.f() == 3) {
                    fileManagerEntity2.status = 3;
                    if (d16 != null) {
                        d16.u(fileManagerEntity2);
                    }
                }
                if (info.f() == 2) {
                    fileManagerEntity2.status = 2;
                    if (d16 != null) {
                        d16.f0(fileManagerEntity2);
                    }
                }
                if (info.f() == 4) {
                    fileManagerEntity2.status = 1;
                    if (d16 != null) {
                        d16.f0(mManagerEntity);
                    }
                }
                if (info.f() == 6) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.util.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.j(FileManagerEntity.this, peekAppRuntime);
                        }
                    }, 16, null, false);
                }
                ((QQAppInterface) peekAppRuntime).getFileManagerNotifyCenter().c(-1L, fileManagerEntity2.nSessionId, "", 5, 11, null, 0, null);
            }
        }
    }
}
