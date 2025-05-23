package com.tencent.aelight.camera.api;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEEditorManagerForQzone extends QRouteApi {
    void addListener(IAEEditorGenerateResultListener iAEEditorGenerateResultListener);

    void addUICallbackListener(IAEEditorUICallbackListener iAEEditorUICallbackListener);

    void cancelMission(String str);

    void cancelQFSMission(String str);

    boolean checkAEResVersionOKForAEBasePackage();

    void forceQFSMission(String str);

    Class getAECoverSelectFragmentClass();

    Class getAEVideoPreviewFragmentClass();

    LocalMediaInfo getMissionInfo(String str);

    void init();

    boolean isAEKitForQQInit();

    boolean isCameraResReady();

    void launchAEMutiCamera(Context context, Bundle bundle);

    void removeCallbackListener(@Nullable IAEEditorUICallbackListener iAEEditorUICallbackListener);

    void removeListener(IAEEditorGenerateResultListener iAEEditorGenerateResultListener);

    void removeUICallbackListener(IAEEditorUICallbackListener iAEEditorUICallbackListener);

    void requestGenerateVideo(String str);

    void retryMission(String str);

    void retryQFSMission(String str);

    void saveMission(String str);
}
