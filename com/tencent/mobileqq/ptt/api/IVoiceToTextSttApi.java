package com.tencent.mobileqq.ptt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.ttpic.videoshelf.data.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/ptt/api/IVoiceToTextSttApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "sessionId", "", "setRecorderSessionId", "pcmForVadPath", Constants.AUDIO_FILE_PATH, "Ltd2/a;", "listener", "onRecorderStart", "onRecorderEnd", "cancelAllRequest", "qq-ptt-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IVoiceToTextSttApi extends QRouteApi {
    void cancelAllRequest();

    void onRecorderEnd();

    void onRecorderStart(@NotNull String pcmForVadPath, @NotNull String audioFilePath, @Nullable a listener);

    void setRecorderSessionId(@NotNull String sessionId);
}
