package com.tencent.mobileqq.ad.api;

import android.app.Activity;
import com.tencent.mobileqq.ad.loadingad.b;
import com.tencent.mobileqq.ad.loadingad.c;
import com.tencent.mobileqq.ad.loadingad.i;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/ad/api/ILoadingAdApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "preloadAd", "Lcom/tencent/mobileqq/ad/loadingad/b;", "chooseAdEndListener", "requestAd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/ad/loadingad/c;", "info", "Lcom/tencent/mobileqq/ad/loadingad/i;", "adShowStateListener", "showAd", "", "adJson", "processSelectAdWithUncachedAd", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ILoadingAdApi extends QRouteApi {
    void preloadAd(int busiType);

    void processSelectAdWithUncachedAd(@Nullable String adJson, @NotNull b chooseAdEndListener);

    void requestAd(int busiType, @NotNull b chooseAdEndListener);

    void showAd(@Nullable Activity activity, @NotNull c info, @NotNull i adShowStateListener);
}
