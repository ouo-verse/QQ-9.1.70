package com.tencent.mobileqq.videoplatform.api;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.videoplatform.view.QQVideoPlayView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VideoViewFactory {
    static IPatchRedirector $redirector_;

    public VideoViewFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IBaseVideoView createBaseVideoView(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        return new BaseVideoView(context, j3, videoPlayParam, imageView, null);
    }

    public static IBaseVideoView createBaseVideoViewFS(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        return new BaseVideoView(context, j3, videoPlayParam, imageView, null, true);
    }

    public static IBaseVideoView createCropBubbleView(Context context, long j3, VideoPlayParam videoPlayParam, boolean z16) {
        return new CropBubbleVideoView(context, j3, videoPlayParam, z16);
    }

    public static IBaseVideoView createQQVideoPlayView(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        return new QQVideoPlayView(context, j3, videoPlayParam, imageView);
    }
}
