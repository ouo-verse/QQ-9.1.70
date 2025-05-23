package com.tencent.mobileqq.filemanager.fileviewer.api;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/IFlashTransferDTReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportFileBrowse", "", "target", "", "entity", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "isEnter", "", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFlashTransferDTReportApi extends QRouteApi {
    void reportFileBrowse(@NotNull Object target, @NotNull FileManagerEntity entity, boolean isEnter);
}
