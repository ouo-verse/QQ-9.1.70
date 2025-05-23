package com.tencent.mobileqq.filemanager.fileviewer.api.impl;

import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IFlashTransferDTReportApi;
import com.tencent.mobileqq.filemanager.util.FileDTReporter;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/impl/FlashTransferDTReportApiImpl;", "Lcom/tencent/mobileqq/filemanager/fileviewer/api/IFlashTransferDTReportApi;", "()V", "reportFileBrowse", "", "target", "", "entity", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "isEnter", "", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class FlashTransferDTReportApiImpl implements IFlashTransferDTReportApi {
    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IFlashTransferDTReportApi
    public void reportFileBrowse(@NotNull Object target, @NotNull FileManagerEntity entity, boolean isEnter) {
        int i3;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (entity.nOpType != 58) {
            return;
        }
        boolean p16 = q.p(entity.strFilePath);
        QLog.d("FlashTransferDTReportApiImpl", 2, "reportFileBrowse. , filename: " + entity.fileName + ", isEnter: " + isEnter + ", nFileType: " + entity.nFileType + ", fileSize: " + entity.fileSize + ", isFileExists: " + p16 + ", strFilePath: " + entity.strFilePath);
        HashMap hashMap = new HashMap();
        String str = entity.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "entity.fileName");
        hashMap.put("file_name", str);
        hashMap.put("file_type", Integer.valueOf(entity.nFileType));
        hashMap.put("file_size", Long.valueOf(entity.fileSize));
        if (p16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        hashMap.put("file_status", Integer.valueOf(i3));
        hashMap.put("aio_type", 0);
        hashMap.put("viewer_type", 1);
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 7);
        hashMap.put("source_appid", Integer.valueOf(!p16 ? 1 : 0));
        if (isEnter) {
            FileDTReporter.b(target, new FileDTReporter.a(), hashMap);
        } else {
            FileDTReporter.c(target, hashMap);
        }
    }
}
