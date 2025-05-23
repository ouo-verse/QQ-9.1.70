package c40;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static int a(List<e30.b> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (TextUtils.equals(list.get(i3).g().f398449id.get(), feedCloudMeta$StFeed.f398449id.get())) {
                    QLog.i("QFSAlbumUtils", 1, "[checkFeedInDataList] return position = " + i3 + " , feedId = " + feedCloudMeta$StFeed.f398449id.get());
                    return i3;
                }
            }
            QLog.i("QFSAlbumUtils", 1, "[checkFeedInDataList] return default position = 0");
            return 0;
        }
        QLog.e("QFSAlbumUtils", 1, "[checkFeedInDataList] return unusual position = -1 UIStateData dataList is null");
        return -1;
    }

    public static List<b40.a> b(List<e30.b> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (e30.b bVar : list) {
            if (bVar != null && bVar.g() != null && bVar.g().album_infos != null && bVar.g().album_infos.size() != 0) {
                FeedCloudMeta$StFeed g16 = bVar.g();
                b40.a aVar = new b40.a(g16.album_infos.get().get(0));
                aVar.o(g16);
                if (feedCloudMeta$StFeed != null) {
                    aVar.p(g16.f398449id.get().equals(feedCloudMeta$StFeed.f398449id.get()));
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static long c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum;
        if (!f(feedCloudMeta$StFeed) || (feedCloudMeta$FeedAlbum = feedCloudMeta$StFeed.album_infos.get(0).album.get()) == null) {
            return 0L;
        }
        return feedCloudMeta$FeedAlbum.f398441id.get();
    }

    public static long d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return 0L;
        }
        if (QCirclePushInfoManager.e().f(feedCloudMeta$StFeed.f398449id.get()) == null) {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QFSAlbumUtils", 1, "[getPushCount] error: ", e16);
            }
            FeedCloudMeta$StPushList feedCloudMeta$StPushList = qQCircleFeedBase$StFeedBusiReqData.pushList;
            if (feedCloudMeta$StPushList == null || feedCloudMeta$StPushList.get().totalClickCount == null) {
                return 0L;
            }
            long j3 = qQCircleFeedBase$StFeedBusiReqData.pushList.get().totalClickCount.get();
            QCirclePushInfoManager.e().p(feedCloudMeta$StFeed.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList.get());
            return j3;
        }
        return r2.totalClickCount.get();
    }

    public static String e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return r.f(d(feedCloudMeta$StFeed));
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudMeta$FeedAlbumInfo> list;
        if (feedCloudMeta$StFeed == null || (list = feedCloudMeta$StFeed.album_infos.get()) == null || list.size() == 0) {
            return false;
        }
        return true;
    }
}
