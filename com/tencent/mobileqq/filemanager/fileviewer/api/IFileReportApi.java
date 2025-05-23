package com.tencent.mobileqq.filemanager.fileviewer.api;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/IFileReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportFile", "", "appRuntime", "Lmqq/app/AppRuntime;", "entity", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "peerUin", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileReportApi extends QRouteApi {
    void reportFile(@Nullable AppRuntime appRuntime, @Nullable FileManagerEntity entity, @Nullable String peerUin, @Nullable Activity activity);
}
