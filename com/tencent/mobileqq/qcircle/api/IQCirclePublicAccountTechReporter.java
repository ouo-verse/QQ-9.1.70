package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J@\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountTechReporter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onCoverExposure", "", "onEnterPage", "enterFeedId", "", "isOnFetchMsgStage", "", "hasRedDot", "needChangeUrl", "coverCacheStatusCode", "", "needForceRefresh", "isFromStagger", "onFeedExposure", "onPageInit", "onReceiveMsg", "feedId", "isNowOnline", "isPreloadEnabled", "isOfflinePreloadEnabled", "playUrlTimestamp", "", "needExchangeUrlWhenReceiveMsg", "onVideoPlayerOpen", "onVideoPlayerPrepared", "hitDownloaded", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQCirclePublicAccountTechReporter extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onEnterPage$default(IQCirclePublicAccountTechReporter iQCirclePublicAccountTechReporter, String str, boolean z16, boolean z17, boolean z18, int i3, boolean z19, boolean z26, int i16, Object obj) {
            boolean z27;
            boolean z28;
            boolean z29;
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    z27 = false;
                } else {
                    z27 = z16;
                }
                if ((i16 & 4) != 0) {
                    z28 = false;
                } else {
                    z28 = z17;
                }
                if ((i16 & 32) != 0) {
                    z29 = false;
                } else {
                    z29 = z19;
                }
                iQCirclePublicAccountTechReporter.onEnterPage(str, z27, z28, z18, i3, z29, z26);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEnterPage");
        }
    }

    void onCoverExposure();

    void onEnterPage(@NotNull String enterFeedId, boolean isOnFetchMsgStage, boolean hasRedDot, boolean needChangeUrl, int coverCacheStatusCode, boolean needForceRefresh, boolean isFromStagger);

    void onFeedExposure();

    void onPageInit();

    void onReceiveMsg(@NotNull String feedId, boolean isNowOnline, boolean isOnFetchMsgStage, boolean isPreloadEnabled, boolean isOfflinePreloadEnabled, long playUrlTimestamp, boolean needExchangeUrlWhenReceiveMsg);

    void onVideoPlayerOpen(@NotNull String feedId);

    void onVideoPlayerPrepared(@NotNull String feedId, boolean hitDownloaded);
}
