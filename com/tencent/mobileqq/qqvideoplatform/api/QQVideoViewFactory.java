package com.tencent.mobileqq.qqvideoplatform.api;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoViewFactory;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQVideoViewFactory {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            QQVideoPlaySDKManager.initQQImp();
        }
    }

    public QQVideoViewFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IBaseVideoView createBaseVideoView(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        return VideoViewFactory.createBaseVideoView(context, j3, videoPlayParam, imageView);
    }

    public static IBaseVideoView createBaseVideoViewFS(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        return VideoViewFactory.createBaseVideoViewFS(context, j3, videoPlayParam, imageView);
    }

    public static IBaseVideoView createCropBubbleView(Context context, long j3, VideoPlayParam videoPlayParam, boolean z16) {
        return VideoViewFactory.createCropBubbleView(context, j3, videoPlayParam, z16);
    }

    public static IBaseVideoView createQQVideoPlayView(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        return VideoViewFactory.createQQVideoPlayView(context, j3, videoPlayParam, imageView);
    }
}
