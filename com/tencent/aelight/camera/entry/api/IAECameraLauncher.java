package com.tencent.aelight.camera.entry.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAECameraLauncher extends QRouteApi {
    boolean isCameraResReady();

    boolean isCameraResReady(IAEMultiDownloadCallBack iAEMultiDownloadCallBack);

    boolean isCameraResReady(String str);

    boolean isFlashCameraResReady();

    boolean isFlashCameraResReady(String str, boolean z16);

    void launchAECameraUnit(Activity activity, int i3, Bundle bundle);

    void launchAEMultiCamera(Context context, @Nullable Bundle bundle);

    void launchMagicStudioResultFragment(FragmentActivity fragmentActivity, @Nullable Bundle bundle);

    void winkLaunchAECameraFragment(FragmentActivity fragmentActivity, @Nullable Bundle bundle);

    void winkLaunchAECameraFragmentForAIGCHB(FragmentActivity fragmentActivity, @Nullable Bundle bundle);

    void winkLaunchAECameraFragmentForMagicStudio(FragmentActivity fragmentActivity, @Nullable Bundle bundle);

    void winkLaunchAIGCImgCreateFragment(FragmentActivity fragmentActivity, @Nullable Bundle bundle);

    Fragment winkLaunchAIGCLogicFragment(FragmentActivity fragmentActivity);

    void winkLaunchAIGCMultiSelectFragment(FragmentActivity fragmentActivity, @Nullable Bundle bundle);

    void winkLaunchAIGCSettingFragment(FragmentActivity fragmentActivity, String str);
}
