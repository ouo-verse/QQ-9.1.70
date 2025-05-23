package com.tencent.aelight.camera.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.Nullable;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEBaseReportParam extends QRouteApi {
    void clearLatestPostMd5();

    boolean getGifMode();

    String getIntentUidKey();

    void resetEditInfo();

    void setContentType(long j3);

    void setEditHasCut(boolean z16);

    void setEditHasGraffiti(boolean z16);

    void setEditMusicId(String str);

    void setEditSpeedChanged(boolean z16);

    void setEditStickerIds(String str);

    void setEditTextIds(String str);

    void setEntry(int i3, String str);

    void setExperimentID(String str);

    void setFilterId(String str);

    void setNetWork();

    void setOprationTime();

    void setShootTime();

    void setUin(@Nullable String str);

    void setVideoDuration(long j3);
}
