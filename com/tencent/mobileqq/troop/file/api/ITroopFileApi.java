package com.tencent.mobileqq.troop.file.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u0002H&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H&J\b\u0010\u0017\u001a\u00020\u0002H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/file/api/ITroopFileApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "shouldReport", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "requestCode", "", "openTroopFileMainPage", "openTroopFileUploadPage", "openTroopFileSearchByTypePage", "canUseMsgForwardOnTroopFile", "fixWeiYunForwardFileSwitch", "", "fileInfo", "genMediaDownloadDepend", "", "troopUin", "entity", "genMediaShareDepend", "useNewBrowserOpenMediaFile", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopFileApi extends QRouteApi {
    boolean canUseMsgForwardOnTroopFile();

    boolean fixWeiYunForwardFileSwitch();

    @NotNull
    Object genMediaDownloadDepend(@NotNull Object fileInfo);

    @NotNull
    Object genMediaShareDepend(long troopUin, @NotNull Object fileInfo, @NotNull Object entity);

    void openTroopFileMainPage(@NotNull Activity activity, @NotNull Intent intent, int requestCode);

    void openTroopFileSearchByTypePage(@NotNull Activity activity, @NotNull Intent intent);

    void openTroopFileUploadPage(@NotNull Activity activity, @NotNull Intent intent);

    boolean shouldReport();

    boolean useNewBrowserOpenMediaFile();
}
