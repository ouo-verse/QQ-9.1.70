package com.tencent.qqmusic.mediaplayer.audiofx;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IAudioListenerBuilder {
    @Nullable
    IAudioListener createAudioEffect(@NonNull Bundle bundle);

    @Nullable
    Bundle getConfiguration(int i3, @Nullable Bundle bundle);

    @NonNull
    String getId();

    void init(Context context);

    boolean isEnabled();

    void release();

    void setConfiguration(int i3, Bundle bundle);

    boolean setEnabled(boolean z16);

    void setListener(OnBuilderStateChangedListener onBuilderStateChangedListener);
}
