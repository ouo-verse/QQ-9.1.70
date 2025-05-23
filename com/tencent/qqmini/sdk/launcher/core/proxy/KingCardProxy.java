package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

/* loaded from: classes23.dex */
public interface KingCardProxy {
    ImageView getCapsuleButtonMoreView(Context context);

    boolean showKingCardTips(IMiniAppContext iMiniAppContext, ImageView imageView);
}
