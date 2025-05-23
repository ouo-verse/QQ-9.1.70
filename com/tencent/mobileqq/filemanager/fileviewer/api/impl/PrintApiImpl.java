package com.tencent.mobileqq.filemanager.fileviewer.api.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.fileviewer.m;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qb1.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J$\u0010\u0018\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J.\u0010\u0019\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/impl/PrintApiImpl;", "Lcom/tencent/mobileqq/filemanager/fileviewer/api/IPrintApi;", "", WadlProxyConsts.PARAM_FILENAME, "", "isGroupFile", "isSupportSysPrint", "isDisabledOnlinePrint", "isSupportOnlinePrint", "isSupportPrint", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "Lqb1/a;", "downloadController", "", "jumpSysPrintPage", "localFilePath", "", "sessionId", "setSysPrintingSessionId", "getSysPrintingSessionId", "Landroid/view/View$OnClickListener;", "getLocalFilePrintClick", "getFilePrintClick", "checkOnlinePrintSupportFileType", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class PrintApiImpl implements IPrintApi {
    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public boolean checkOnlinePrintSupportFileType(@Nullable String fileName) {
        return m.a(fileName);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    @NotNull
    public View.OnClickListener getFilePrintClick(@Nullable Activity activity, @Nullable FileManagerEntity entity, @Nullable a downloadController, boolean isDisabledOnlinePrint) {
        View.OnClickListener c16 = m.c(activity, entity, downloadController, isDisabledOnlinePrint);
        Intrinsics.checkNotNullExpressionValue(c16, "getFilePrintClick(activi\u2026r, isDisabledOnlinePrint)");
        return c16;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    @NotNull
    public View.OnClickListener getLocalFilePrintClick(@Nullable Activity activity, @Nullable FileManagerEntity entity, boolean isDisabledOnlinePrint) {
        View.OnClickListener d16 = m.d(activity, entity, isDisabledOnlinePrint);
        Intrinsics.checkNotNullExpressionValue(d16, "getLocalFilePrintClick(a\u2026y, isDisabledOnlinePrint)");
        return d16;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public long getSysPrintingSessionId() {
        return m.f();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public boolean isSupportOnlinePrint(@Nullable String fileName, boolean isDisabledOnlinePrint) {
        return m.g(fileName, isDisabledOnlinePrint);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public boolean isSupportPrint(@Nullable String fileName, boolean isDisabledOnlinePrint, boolean isGroupFile) {
        return m.h(fileName, isDisabledOnlinePrint, isGroupFile);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public boolean isSupportSysPrint(@Nullable String fileName, boolean isGroupFile) {
        return m.i(fileName, isGroupFile);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public void jumpSysPrintPage(@NotNull Activity activity, @NotNull FileManagerEntity entity, @NotNull a downloadController) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(downloadController, "downloadController");
        m.j(activity, entity, downloadController);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public void setSysPrintingSessionId(long sessionId) {
        m.l(sessionId);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi
    public void jumpSysPrintPage(@NotNull Activity activity, @NotNull String localFilePath) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        m.k(activity, localFilePath);
    }
}
