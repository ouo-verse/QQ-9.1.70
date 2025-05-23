package com.qq.e.comm.pi;

import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

@Deprecated
/* loaded from: classes3.dex */
public interface TGSPPI {
    void downloadRes(String str, boolean z16);

    void pauseDownload();

    void preload(Context context, String str, String str2, LoadAdParams loadAdParams, ICustomAdDataGenerator iCustomAdDataGenerator);

    void setPreloadListener(ADListener aDListener, int i3);
}
