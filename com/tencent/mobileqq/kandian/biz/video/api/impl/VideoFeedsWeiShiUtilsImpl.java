package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils;
import g62.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoFeedsWeiShiUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsWeiShiUtils;", "()V", "gotoWeishiDownload", "", "context", "Landroid/content/Context;", "videoType", "", "isWeishi", "", "type", "openWeishi", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VideoFeedsWeiShiUtilsImpl implements IVideoFeedsWeiShiUtils {
    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils
    public void gotoWeishiDownload(Context context, String videoType) {
        a.f(context, videoType);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils
    public boolean isWeishi(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual("video_type_videopublic", type);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils
    public void openWeishi(Context context, String videoType) {
        a.g(context, videoType);
    }
}
