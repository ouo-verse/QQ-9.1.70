package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFileManagerDepend;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/filemanager/api/impl/FileManagerDependImpl;", "Lcom/tencent/mobileqq/filemanager/api/IFileManagerDepend;", "()V", "updateC2CVideoPlayStatus", "", "entity", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "status", "", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class FileManagerDependImpl implements IFileManagerDepend {
    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerDepend
    public void updateC2CVideoPlayStatus(FileManagerEntity entity, int status) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        qQAppInterface.getNTFileManageBridger().M0(entity, status);
    }
}
