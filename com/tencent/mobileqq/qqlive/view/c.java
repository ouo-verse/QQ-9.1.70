package com.tencent.mobileqq.qqlive.view;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    @SuppressLint({"ObsoleteSdkInt"})
    public static a a(Context context, boolean z16, boolean z17, boolean z18) {
        if (z16) {
            return new TPTextureView(context);
        }
        return new TPSurfaceView(context, z17, z18);
    }
}
