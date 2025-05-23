package com.tencent.tavcut.core.render.audio.wave;

import androidx.annotation.WorkerThread;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH'J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH'\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/IWaveDataCaptureListener;", "", "onCaptureError", "", "errCode", "", "errMsg", "", "onWaveFormDataCapture", "data", "", "", "onWaveFormDataCaptureFinished", "allData", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IWaveDataCaptureListener {
    @WorkerThread
    void onCaptureError(int errCode, @NotNull String errMsg);

    @WorkerThread
    void onWaveFormDataCapture(@NotNull List<Float> data);

    @WorkerThread
    void onWaveFormDataCaptureFinished(@NotNull List<Float> allData);
}
