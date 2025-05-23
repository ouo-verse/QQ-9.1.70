package com.tencent.tavkit.composition.audio;

import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVAudioConfigurationSegment {

    @NonNull
    public final TAVAudioConfiguration audioConfiguration;

    @NonNull
    public final CMTimeRange compositionTimeRange;

    public TAVAudioConfigurationSegment(@NonNull CMTimeRange cMTimeRange, @NonNull TAVAudioConfiguration tAVAudioConfiguration) {
        this.audioConfiguration = tAVAudioConfiguration;
        this.compositionTimeRange = cMTimeRange;
    }

    public String toString() {
        return "TAVAudioConfigurationSegment{compositionTimeRange=" + this.compositionTimeRange.toSimpleString() + ", audioConfiguration=" + this.audioConfiguration + '}';
    }
}
