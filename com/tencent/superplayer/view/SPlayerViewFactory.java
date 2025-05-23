package com.tencent.superplayer.view;

import android.content.Context;

/* loaded from: classes26.dex */
public class SPlayerViewFactory {
    public static ISPlayerViewBase createPlayView(Context context, boolean z16) {
        if (z16) {
            return new SPlayerTextureView(context);
        }
        return new SPlayerSurfaceView(context);
    }
}
