package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes15.dex */
public interface NowPluginObserver {
    void onCloseLoadingView();

    void onEnterAvPlugin(Bundle bundle);

    void onEnterRoom(Bundle bundle);

    void onExitRoom(Bundle bundle);

    void onLoadingViewCreated(View view);
}
