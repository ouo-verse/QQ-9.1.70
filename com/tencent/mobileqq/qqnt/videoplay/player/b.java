package com.tencent.mobileqq.qqnt.videoplay.player;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0016\u001a\u00020\u0004H&J\b\u0010\u0017\u001a\u00020\u0004H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/b;", "", "Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;", "state", "", "a", "", "position", "b", "onDownloadComplete", "downSize", "d", "onVideoPrepared", "onBufferStart", "onBufferEnd", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "exInfo", "c", "onFirstFrameRendered", "onSurfaceDestroy", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {
    void a(@NotNull PlayState state);

    void b(long position);

    void c(int module, int errorType, int errorCode, @Nullable String exInfo);

    void d(long downSize);

    void onBufferEnd();

    void onBufferStart();

    void onDownloadComplete();

    void onFirstFrameRendered();

    void onSurfaceDestroy();

    void onVideoPrepared();
}
