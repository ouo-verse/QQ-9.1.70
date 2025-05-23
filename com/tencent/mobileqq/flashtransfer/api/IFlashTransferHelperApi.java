package com.tencent.mobileqq.flashtransfer.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H&J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH&J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/api/IFlashTransferHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getForwardOptionClass", "Ljava/lang/Class;", "sendFlashTransferMsgToFriend", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "fileSetId", "", "fileSetName", "requestCode", "", "shareFileSetLinkTextToWeChat", "shareLink", "title", "uploaderName", "shareFlashTransferMsg", "qqfile-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFlashTransferHelperApi extends QRouteApi {
    @NotNull
    Class<?> getForwardOptionClass();

    void sendFlashTransferMsgToFriend(@NotNull Activity activity, @NotNull String fileSetId, @NotNull String fileSetName, int requestCode);

    void shareFileSetLinkTextToWeChat(@NotNull String shareLink, @NotNull String title, @NotNull String uploaderName);

    void shareFlashTransferMsg(@NotNull Activity activity, @NotNull String fileSetId, @NotNull String title, @NotNull String uploaderName);
}
