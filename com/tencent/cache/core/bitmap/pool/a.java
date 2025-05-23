package com.tencent.cache.core.bitmap.pool;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f98679a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[Bitmap.Config.values().length];
        f98679a = iArr;
        iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
        iArr[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        iArr[Bitmap.Config.ALPHA_8.ordinal()] = 4;
    }
}
