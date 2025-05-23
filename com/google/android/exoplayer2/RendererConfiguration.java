package com.google.android.exoplayer2;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class RendererConfiguration {
    public static final RendererConfiguration DEFAULT = new RendererConfiguration(0);
    public final int tunnelingAudioSessionId;

    public RendererConfiguration(int i3) {
        this.tunnelingAudioSessionId = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RendererConfiguration.class == obj.getClass() && this.tunnelingAudioSessionId == ((RendererConfiguration) obj).tunnelingAudioSessionId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.tunnelingAudioSessionId;
    }
}
