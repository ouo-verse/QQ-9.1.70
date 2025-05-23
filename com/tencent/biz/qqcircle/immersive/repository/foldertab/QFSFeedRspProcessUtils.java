package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QFSSuspendOpenBoxUpdateEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.event.QFSSquareSearchLoadEvent;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StUserPushBoxInfo;

/* loaded from: classes4.dex */
public class QFSFeedRspProcessUtils {
    public static List<FeedCloudMeta$StFeed> b(boolean z16, List<FeedCloudMeta$StFeed> list) {
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(i3);
            if (z16) {
                if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 7) {
                    list.remove(feedCloudMeta$StFeed);
                } else if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 9) {
                    list.remove(feedCloudMeta$StFeed);
                }
            } else if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 10) {
                list.remove(feedCloudMeta$StFeed);
                break;
            }
            i3++;
        }
        return list;
    }

    public static List<e30.b> c(List<FeedCloudMeta$StFeed> list, boolean z16) {
        List<FeedCloudMeta$StFeed> b16 = b(z16, list);
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : b16) {
            if (feedCloudMeta$StFeed.type.get() == 4) {
                String str = feedCloudMeta$StFeed.live.room.rtmpUrl.get();
                String str2 = feedCloudMeta$StFeed.live.room.flvUrl.get();
                if (!TextUtils.isEmpty(str2)) {
                    feedCloudMeta$StFeed.video.playUrl.set(str2);
                } else {
                    feedCloudMeta$StFeed.video.playUrl.set(str);
                }
                QLog.i("FeedLine_QFSFeedRspProcessUtils", 1, "getValidFeedList stFeed type=" + feedCloudMeta$StFeed.type.get() + ",rtmpUrl: " + str + ", flvUrl: " + str2);
            }
        }
        return e30.d.b(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(List list, boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSSquareSearchLoadEvent(list, z16));
    }

    public static void e(QFSTabFeedViewModel.c cVar, List<FeedCloudMeta$StDittoFeed> list) {
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed : list) {
                if (feedCloudMeta$StDittoFeed.dittoId.get() == 19) {
                    k(cVar, feedCloudMeta$StDittoFeed);
                }
            }
        }
    }

    public static void f(QFSTabFeedViewModel.c cVar, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp != null && cVar != null) {
            if (feedCloudRead$StGetFeedListRsp.extInfo.has()) {
                cVar.f86646e = feedCloudRead$StGetFeedListRsp.extInfo.get();
            }
        } else {
            QLog.e("FeedLine_QFSFeedRspProcessUtils", 1, "[parseExtInfo] rsp is " + feedCloudRead$StGetFeedListRsp + ",outputSnapshot:" + cVar);
        }
    }

    public static void g(QFSTabFeedViewModel.c cVar, final List<FeedCloudMeta$StFeed> list, final boolean z16) {
        if (list == null) {
            return;
        }
        QLog.d("FeedLine_QFSFeedRspProcessUtils", 1, "[parseFeed] feed size:" + list.size());
        if (cVar != null) {
            QLog.d("FeedLine_QFSFeedRspProcessUtils", 1, "[parseFeed] isFinish:" + cVar.f86645d + " | feedAttachInfo:" + cVar.f86644c);
        }
        QCirclePushInfoManager.e().j(list);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedRspProcessUtils.d(list, z16);
            }
        });
    }

    public static void h(QFSTabFeedViewModel.c cVar, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp != null && cVar != null) {
            cVar.f86644c = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
            return;
        }
        QLog.e("FeedLine_QFSFeedRspProcessUtils", 1, "[parseFeedAttachInfo] rsp is " + feedCloudRead$StGetFeedListRsp + ",outputSnapshot:" + cVar);
    }

    public static void i(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudRead$StGetFeedListRsp.user.get();
        QLog.d("FeedLine_QFSFeedRspProcessUtils", 1, "[parseHostUserInfo] user id:" + feedCloudMeta$StUser.f398463id + " | user comment url:" + feedCloudMeta$StUser.iconDecorate.comment_url);
        QCircleHostGlobalInfo.setStUserInfo(feedCloudRead$StGetFeedListRsp.user);
        uq3.c.d7(feedCloudRead$StGetFeedListRsp.user.icon.iconUrl.get());
        uq3.c.g7(feedCloudRead$StGetFeedListRsp.user.nick.get());
        PBBytesField pBBytesField = feedCloudRead$StGetFeedListRsp.user.qq_vip;
        if (pBBytesField != null) {
            uq3.c.k7(pBBytesField.get().toByteArray());
        }
    }

    public static void j(QFSTabFeedViewModel.c cVar, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        boolean z16 = true;
        if (feedCloudRead$StGetFeedListRsp != null && cVar != null) {
            if (feedCloudRead$StGetFeedListRsp.isFinish.get() <= 0) {
                z16 = false;
            }
            cVar.f86645d = z16;
        } else {
            QLog.e("FeedLine_QFSFeedRspProcessUtils", 1, "[parseIsFinish] rsp is " + feedCloudRead$StGetFeedListRsp + ",outputSnapshot:" + cVar);
        }
    }

    public static void k(QFSTabFeedViewModel.c cVar, FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed) {
        if (cVar == null) {
            QLog.e("FeedLine_QFSFeedRspProcessUtils", 1, "[parsePublishBannerInfo] outputSnapshot is null");
            return;
        }
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
        try {
            qQCircleDitto$StCircleDittoDataNew.mergeFrom(feedCloudMeta$StDittoFeed.dittoDataNew.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        cVar.f86647f = qQCircleDitto$StCircleDittoDataNew.picTextBanner.get();
    }

    public static void l(final QQCircleFeedBase$StUserPushBoxInfo qQCircleFeedBase$StUserPushBoxInfo) {
        if (qQCircleFeedBase$StUserPushBoxInfo == null) {
            return;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.QFSFeedRspProcessUtils.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSSuspendOpenBoxUpdateEvent(QQCircleFeedBase$StUserPushBoxInfo.this));
            }
        });
    }

    public static void m(QFSTabFeedViewModel.c cVar, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            QLog.e("FeedLine_QFSFeedRspProcessUtils", 1, "[parseRefreshAttachInfo] rsp is null");
            return;
        }
        if (feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            try {
                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.has() && cVar != null) {
                cVar.f86643b = qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.get();
            }
            if (qQCircleFeedBase$StFeedListBusiRspData.bannerData.has()) {
                e(cVar, qQCircleFeedBase$StFeedListBusiRspData.bannerData.get());
            }
            if (qQCircleFeedBase$StFeedListBusiRspData.pushBoxInfo.has()) {
                l(qQCircleFeedBase$StFeedListBusiRspData.pushBoxInfo.get());
            }
            if (cVar != null) {
                cVar.f86651j = System.currentTimeMillis();
            }
        }
    }

    public static void n(QFSTabFeedViewModel.c cVar, boolean z16) {
        if (cVar == null) {
            QLog.e("FeedLine_QFSFeedRspProcessUtils", 1, "[preProcessByLoadMore] outputSnapshot is null");
        } else if (!z16) {
            cVar.f86642a.clear();
        }
    }
}
