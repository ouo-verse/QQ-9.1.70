package com.tencent.intervideo.nowproxy;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes7.dex */
public interface NowPluginObserver {
    void onCloseLoadingView();

    void onEnterAvPlugin(Bundle bundle);

    void onEnterRoom(Bundle bundle);

    void onExitRoom(Bundle bundle);

    void onLoadingViewCreated(View view);
}
