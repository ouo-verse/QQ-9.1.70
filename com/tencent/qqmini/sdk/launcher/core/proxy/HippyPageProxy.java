package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.widget.ImageView;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import java.util.HashMap;

/* loaded from: classes23.dex */
public interface HippyPageProxy {
    public static final int FROM_GAMEBOX = 2;
    public static final int FROM_GAMETASK = 1;

    void closeHippyPage();

    void downloadJSBundle(String str, int i3);

    void openHippyPage(IMiniAppContext iMiniAppContext, String str, String str2, int i3, HashMap<String, String> hashMap);

    void setRoundDrawable(ImageView imageView, String str);
}
