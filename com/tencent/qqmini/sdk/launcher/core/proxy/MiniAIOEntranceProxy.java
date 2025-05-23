package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: classes23.dex */
public abstract class MiniAIOEntranceProxy extends RelativeLayout {
    public MiniAIOEntranceProxy(Context context) {
        super(context);
    }

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setMiniAIOStyle(String str);
}
