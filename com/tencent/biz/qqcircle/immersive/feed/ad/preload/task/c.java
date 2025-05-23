package com.tencent.biz.qqcircle.immersive.feed.ad.preload.task;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.QFSAdBaseFeedSourcePreloadTask;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import seal.SealEdgeComputing$AdvertInfo;
import seal.SealEdgeComputing$ClientItemInfo;
import seal_recommend.AdvertRepullStrategy;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends QFSAdBaseFeedSourcePreloadTask {
    private boolean A() {
        int g16 = g();
        if (g16 < 0) {
            return false;
        }
        int E = E();
        int s16 = s();
        if (s16 == -1) {
            return false;
        }
        if (g16 == s16) {
            RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isMeetPreloadResidueNum] selected position = " + g16 + " | firstUnExportAdFeedPosition: " + s16 + ", position equality.");
            return false;
        }
        RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.DEV, "[isMeetPreloadResidueNum] firstUnExportAdFeedPosition: " + s16 + " | currentPosition: " + g16 + " | preloadResidueNum: " + E);
        if (s16 - g16 > E) {
            return false;
        }
        return true;
    }

    private boolean B() {
        long currentTimeMillis = System.currentTimeMillis() - F();
        int y16 = y();
        RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.DEV, "[isMeetPreloadUnExposedInterval] unexposedAdFeedTime: " + currentTimeMillis + " | feedAdUnExposedInterval : " + y16);
        if (currentTimeMillis >= y16) {
            return true;
        }
        return false;
    }

    private boolean C() {
        int size;
        List<e30.b> u16 = u();
        if (u16 == null) {
            size = 0;
        } else {
            size = u16.size();
        }
        RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.DEV, "[isMeetUnExposedAdCount] unexposed ad source count: " + size);
        if (size <= 0) {
            return false;
        }
        return true;
    }

    private AdvertRepullStrategy D() {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt;
        QFSTabFeedViewModel.c i3 = i();
        AdvertRepullStrategy advertRepullStrategy = null;
        if (i3 != null && (feedCloudCommon$StCommonExt = i3.f86646e) != null) {
            for (FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry : feedCloudCommon$StCommonExt.mapBytesInfo.get()) {
                if (feedCloudCommon$BytesEntry != null && TextUtils.equals(feedCloudCommon$BytesEntry.key.get(), "ad_repull_strategy")) {
                    try {
                        advertRepullStrategy = AdvertRepullStrategy.ADAPTER.decode(feedCloudCommon$BytesEntry.value.get().toByteArray());
                    } catch (Throwable th5) {
                        RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[obtainAdvertRepullStrategy] e: " + th5);
                    }
                }
            }
        }
        return advertRepullStrategy;
    }

    private int E() {
        AdvertRepullStrategy D = D();
        if (D == null) {
            return 0;
        }
        return D.ad_repull_offset;
    }

    private long F() {
        QFSTabFeedViewModel.c i3 = i();
        if (i3 == null) {
            return 0L;
        }
        return i3.f86651j;
    }

    private int y() {
        AdvertRepullStrategy D = D();
        if (D == null) {
            return 0;
        }
        return D.ad_repull_unexpose_max_time * 1000;
    }

    private boolean z() {
        AdvertRepullStrategy D = D();
        if (D != null && D.enable_ad_repull) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.QFSAdBaseFeedSourcePreloadTask
    protected boolean k(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            SealEdgeComputing$ClientItemInfo sealEdgeComputing$ClientItemInfo = new SealEdgeComputing$ClientItemInfo();
            sealEdgeComputing$ClientItemInfo.setHasFlag(true);
            FeedCloudMeta$StFeed d16 = u.d(feedCloudMeta$StFeed);
            sealEdgeComputing$ClientItemInfo.mergeFrom(feedCloudMeta$StFeed.recomInfo.clientSealData.get().toByteArray());
            SealEdgeComputing$AdvertInfo sealEdgeComputing$AdvertInfo = sealEdgeComputing$ClientItemInfo.advert_info.get();
            if (sealEdgeComputing$AdvertInfo == null) {
                RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isAdFeedAllowReload] advert info should not be null.");
                return false;
            }
            RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isAdFeedAllowReload] trace id: " + ba.d(feedCloudMeta$StFeed) + " | feed id : " + bj.g(feedCloudMeta$StFeed) + " | ad feed buff id: " + bj.g(d16) + " | advert id: " + sealEdgeComputing$AdvertInfo.advert_id.get() + " | allow_ad_repull: " + sealEdgeComputing$AdvertInfo.allow_ad_repull.get());
            if (sealEdgeComputing$AdvertInfo.allow_ad_repull.get()) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isAdFeedAllowReload] error: ", th5);
            return false;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.QFSAdBaseFeedSourcePreloadTask
    protected boolean n(QFSAdBaseFeedSourcePreloadTask.QFSAdPreloadTriggerType qFSAdPreloadTriggerType) {
        try {
            if (!z()) {
                RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isCheckPreload] not enabled feed ad preload exp.");
                return false;
            }
            if (!A()) {
                return false;
            }
            if (!B()) {
                RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isCheckPreload] un exposed ad interval not satisfied, not preload.");
                return false;
            }
            if (C()) {
                return true;
            }
            RFWLog.d("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isCheckPreload] un exposed count not satisfied, not preload.");
            return false;
        } catch (Throwable th5) {
            RFWLog.e("QASP-QFSAdFeedSourcePreloadTask", RFWLog.USR, "[isCheckPreload] ex: ", th5);
            return false;
        }
    }
}
