package com.tencent.mobileqq.wifiphoto.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.richmedia.FilePreviewLayerFragment;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wifiphoto.api.IExportFileApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/api/impl/ExportFileApiImpl;", "Lcom/tencent/mobileqq/wifiphoto/api/IExportFileApi;", "()V", "browserFile", "", "context", "Landroid/content/Context;", "entity", "", "path", "", "createFileManagerEntityByPath", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "insertFileToFM", "queryFileEntityByPath", "updateFileEntity", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class ExportFileApiImpl implements IExportFileApi {
    static IPatchRedirector $redirector_;

    public ExportFileApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final FileManagerEntity createFileManagerEntityByPath(QQAppInterface app, String path) {
        FileManagerEntity k16 = ah.k1(new FileInfo(path));
        k16.setCloudType(16);
        k16.srvTime = NetConnInfoCenter.getServerTimeMillis();
        k16.msgSeq = ah.P();
        k16.msgUid = ah.Q();
        k16.isReaded = true;
        k16.peerUid = app.getCurrentAccountUin();
        k16.peerType = 0;
        k16.status = 1;
        k16.nOpType = 57;
        k16.bSend = false;
        Intrinsics.checkNotNullExpressionValue(k16, "newEntityByLocalFileInfo\u2026  bSend = false\n        }");
        return k16;
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileApi
    public void browserFile(@NotNull Context context, @NotNull Object entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, entity);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (entity instanceof FileManagerEntity) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            if (qQAppInterface == null) {
                return;
            }
            FileManagerEntity fileManagerEntity = (FileManagerEntity) entity;
            int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
            if (fileType != 0 && fileType != 2) {
                ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, fileManagerEntity), new com.tencent.mobileqq.filemanager.openbrowser.c().d(8).e(5));
                return;
            }
            com.tencent.mobileqq.filemanager.openbrowser.e eVar = new com.tencent.mobileqq.filemanager.openbrowser.e(qQAppInterface, fileManagerEntity);
            ArrayList arrayList = new ArrayList();
            RFWLayerItemMediaInfo d16 = mb1.a.f416517a.d(fileManagerEntity);
            if (d16 == null) {
                QLog.d("", 1, "browserFile itemMediaInfo is null!");
                return;
            }
            arrayList.add(d16);
            com.tencent.mobileqq.richmedia.e eVar2 = com.tencent.mobileqq.richmedia.e.f281568a;
            String name = com.tencent.mobileqq.richmedia.depend.f.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "IShareActionDepend::class.java.name");
            eVar2.g(name, eVar);
            String name2 = com.tencent.mobileqq.richmedia.depend.d.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "IRichMediaDownloadDepend::class.java.name");
            eVar2.g(name2, eVar);
            eVar2.j(arrayList);
            eVar2.i(0);
            RFWLayerLaunchUtil.jumpToGallery$default(new ImageView(context), arrayList, 0, QQGalleryActivity.class, FilePreviewLayerFragment.class, new Bundle(), 0, 64, null);
        }
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileApi
    @Nullable
    public Object insertFileToFM(@NotNull String path) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return null;
        }
        FileManagerEntity createFileManagerEntityByPath = createFileManagerEntityByPath(qQAppInterface, path);
        qQAppInterface.getFileManagerDataCenter().t(createFileManagerEntityByPath);
        qQAppInterface.getFileManagerDataCenter().f0(createFileManagerEntityByPath);
        return createFileManagerEntityByPath;
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileApi
    @Nullable
    public Object queryFileEntityByPath(@NotNull String path) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return null;
        }
        return qQAppInterface.getFileManagerDataCenter().K(path);
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileApi
    public void updateFileEntity(@NotNull Object entity) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        FileManagerEntity fileManagerEntity = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        if (entity instanceof FileManagerEntity) {
            fileManagerEntity = (FileManagerEntity) entity;
        }
        qQAppInterface.getFileManagerDataCenter().f0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileApi
    public void browserFile(@NotNull Context context, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        browserFile(context, createFileManagerEntityByPath(qQAppInterface, path));
    }
}
