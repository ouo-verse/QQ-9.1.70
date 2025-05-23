package com.tencent.aelight.camera.api;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/api/IQQWinkFragmentLoader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getCaptureFragment", "Landroidx/fragment/app/Fragment;", "loadLightResource", "", "isFlashCameraResReady", "", "openMagicStudioFragment", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "openTextVideoFragment", "openWangZheReportFragment", "preloadCaptureResource", "bundle", "Landroid/os/Bundle;", "aelight-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQQWinkFragmentLoader extends QRouteApi {
    @NotNull
    Fragment getCaptureFragment();

    void loadLightResource(boolean isFlashCameraResReady);

    void openMagicStudioFragment(@NotNull Activity activity);

    void openTextVideoFragment(@NotNull Activity activity);

    void openWangZheReportFragment(@NotNull Activity activity);

    void preloadCaptureResource(@NotNull Bundle bundle);
}
