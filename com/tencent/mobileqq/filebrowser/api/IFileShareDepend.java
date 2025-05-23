package com.tencent.mobileqq.filebrowser.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J+\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u0002H\u000eH&\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/api/IFileShareDepend;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createQRCodeOrLink", "", "context", "Landroid/content/Context;", "fileInfo", "Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;", "localPath", "", "isQRCode", "", "forwardToMyComputer", "", "T", "forwardIntent", "Landroid/content/Intent;", "path", "callback", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Object;)I", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileShareDepend extends QRouteApi {
    void createQRCodeOrLink(@NotNull Context context, @Nullable ForwardFileInfo fileInfo, @NotNull String localPath, boolean isQRCode);

    <T> int forwardToMyComputer(@NotNull Intent forwardIntent, @NotNull String path, T callback);
}
