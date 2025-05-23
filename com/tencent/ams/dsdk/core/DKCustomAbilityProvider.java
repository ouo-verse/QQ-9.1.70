package com.tencent.ams.dsdk.core;

import android.content.Context;
import com.tencent.ams.dsdk.download.DKDownloadManager;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.dsdk.view.video.glvideo.DKGLVideoPlayer;
import com.tencent.ams.dsdk.view.webview.DKWebView;

/* loaded from: classes3.dex */
public interface DKCustomAbilityProvider {
    DKGLVideoPlayer getDKGLVideoPlayer(Context context);

    DKVideoPlayer getDKVideoPlayer(Context context);

    DKWebView getDKWebView(Context context);

    DKDownloadManager getDownloadManager(Context context);
}
