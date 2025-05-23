package com.tencent.mobileqq.filemanager.fileviewer.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J#\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH&\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH&J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/ITBSToolService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "browserFile", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "entity", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "action", "", "browserMedia", "fileList", "", "(Landroid/app/Activity;[Ljava/lang/String;)V", "saveFileToWeiYun", "path", "shareFileToFriend", "bundle", "Landroid/os/Bundle;", "uin", "uinType", "", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ITBSToolService extends QRouteApi {
    void browserFile(@NotNull Activity activity, @NotNull FileManagerEntity entity, @NotNull String action);

    void browserMedia(@NotNull Activity activity, @NotNull String[] fileList);

    void saveFileToWeiYun(@NotNull String path);

    void shareFileToFriend(@NotNull Activity activity, @NotNull Bundle bundle, @NotNull String uin, int uinType);
}
