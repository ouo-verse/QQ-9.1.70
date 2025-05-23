package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPDrmCryptoSchemeType {
    public static final int DRM_CRYPTO_SCHEME_TYPE_CBC1 = 2;
    public static final int DRM_CRYPTO_SCHEME_TYPE_CBCS = 8;
    public static final int DRM_CRYPTO_SCHEME_TYPE_CENC = 1;
    public static final int DRM_CRYPTO_SCHEME_TYPE_CENS = 4;
}
