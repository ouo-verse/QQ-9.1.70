package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResultCallback;", "", "scoreResultCallback", "", "result", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScoreResult;", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface ScoreResultCallback {
    void scoreResultCallback(@Nullable IScoreResult result, float timeStamp);
}
