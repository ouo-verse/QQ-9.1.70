package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class FrameworkMediaCrypto implements ExoMediaCrypto {
    private final boolean forceAllowInsecureDecoderComponents;
    private final MediaCrypto mediaCrypto;

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto) {
        this(mediaCrypto, false);
    }

    public MediaCrypto getWrappedMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaCrypto
    public boolean requiresSecureDecoderComponent(String str) {
        if (!this.forceAllowInsecureDecoderComponents && this.mediaCrypto.requiresSecureDecoderComponent(str)) {
            return true;
        }
        return false;
    }

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto, boolean z16) {
        this.mediaCrypto = (MediaCrypto) Assertions.checkNotNull(mediaCrypto);
        this.forceAllowInsecureDecoderComponents = z16;
    }
}
