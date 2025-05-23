package com.tencent.qqlive.module.videoreport.dtreport.audio.api;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IAudioInfoChangeListener {
    void onAudioInfoChangedEnd(Object obj, @NonNull AudioEntity audioEntity, Map<String, Object> map);

    void onAudioInfoChangedStart(Object obj, @NonNull AudioEntity audioEntity, Map<String, Object> map);
}
