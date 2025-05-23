package com.tencent.gamematrix.gmcg.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface GmCgMidasPayType {
    public static final int GmCgMidasPayTypeHookSdk = 2;
    public static final int GmCgMidasPayTypeNativeSdk = 3;
    public static final int GmCgMidasPayTypeQrCode = 0;
    public static final int GmCgMidasPayTypeShop = 1;
}
