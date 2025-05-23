package com.tencent.cache.api.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final /* synthetic */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f98639a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13507);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[Bitmap.Config.values().length];
        f98639a = iArr;
        iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
        iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
        iArr[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        iArr[Bitmap.Config.ARGB_8888.ordinal()] = 4;
    }
}
