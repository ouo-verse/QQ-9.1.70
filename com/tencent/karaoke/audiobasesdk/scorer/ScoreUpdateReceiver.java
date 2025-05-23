package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreUpdateReceiver;", "", "updateScoreResult", "", "nativeHandle", "", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "stcIndex", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface ScoreUpdateReceiver {
    void updateScoreResult(long nativeHandle, boolean seek, float timeStamp, int stcIndex);
}
