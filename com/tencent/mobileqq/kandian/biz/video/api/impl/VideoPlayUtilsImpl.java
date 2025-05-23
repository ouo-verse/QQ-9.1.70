package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.base.video.a;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.net.URL;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoPlayUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayUtils;", "()V", "calculateVideoPartSize", "", "timeSec", "", "duration", "fileSize", "getThumbUrl", "Ljava/net/URL;", "thumbPath", "", "makeErrorText", "model", "what", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VideoPlayUtilsImpl implements IVideoPlayUtils {
    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils
    public long calculateVideoPartSize(int timeSec, int duration, int fileSize) {
        return a.a(timeSec, duration, fileSize);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils
    public URL getThumbUrl(String thumbPath) {
        return ShortVideoUtils.getThumbUrl(thumbPath);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils
    public String makeErrorText(int model, int what) {
        return a.d(model, what);
    }
}
