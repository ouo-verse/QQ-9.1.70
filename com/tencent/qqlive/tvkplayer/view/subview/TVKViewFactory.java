package com.tencent.qqlive.tvkplayer.view.subview;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKViewFactory {
    public static TVKAttachableView createAttachableView(Context context) {
        return new TVKAttachableView(context);
    }

    public static ITVKDisplayView createDisplayView(Context context, boolean z16, boolean z17, boolean z18) {
        if (z16) {
            return new TVKTextureView(context);
        }
        return new TVKSurfaceView(context, z17, z18);
    }
}
