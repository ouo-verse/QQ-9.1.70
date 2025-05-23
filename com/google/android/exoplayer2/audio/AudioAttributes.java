package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AudioAttributes {
    public static final AudioAttributes DEFAULT = new Builder().build();
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int usage;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private int contentType = 0;
        private int flags = 0;
        private int usage = 1;

        public AudioAttributes build() {
            return new AudioAttributes(this.contentType, this.flags, this.usage);
        }

        public Builder setContentType(int i3) {
            this.contentType = i3;
            return this;
        }

        public Builder setFlags(int i3) {
            this.flags = i3;
            return this;
        }

        public Builder setUsage(int i3) {
            this.usage = i3;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public android.media.AudioAttributes getAudioAttributesV21() {
        if (this.audioAttributesV21 == null) {
            this.audioAttributesV21 = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage).build();
        }
        return this.audioAttributesV21;
    }

    public int hashCode() {
        return ((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage;
    }

    AudioAttributes(int i3, int i16, int i17) {
        this.contentType = i3;
        this.flags = i16;
        this.usage = i17;
    }
}
