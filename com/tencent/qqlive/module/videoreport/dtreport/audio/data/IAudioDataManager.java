package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioInfoChangeListener;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IAudioDataManager {
    void bindAudioInfo(Object obj, AudioEntity audioEntity);

    AudioEntity getAudioInfo(Object obj);

    void registerListener(IAudioInfoChangeListener iAudioInfoChangeListener);

    void unregisterListener(IAudioInfoChangeListener iAudioInfoChangeListener);

    void updateAudioInfo(Object obj, @NonNull AudioEntity audioEntity, @Nullable Map<String, Object> map);
}
