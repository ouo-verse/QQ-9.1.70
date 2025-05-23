package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsResourceLoader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "inflate", "Landroid/view/View;", "resid", "", "faultTolerant", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoFeedsResourceLoader extends QRouteApi {
    @Nullable
    View inflate(int resid, boolean faultTolerant, @Nullable ViewGroup.LayoutParams params);
}
