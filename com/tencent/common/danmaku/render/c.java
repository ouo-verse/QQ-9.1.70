package com.tencent.common.danmaku.render;

import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static g a(View view) {
        if (view instanceof SurfaceView) {
            return new h((SurfaceView) view);
        }
        if (view instanceof TextureView) {
            return new i((TextureView) view);
        }
        return null;
    }
}
