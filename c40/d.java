package c40;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleTagChallenge;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagChallenge;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {
    public static boolean a(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        QCircleTagChallenge qCircleTagChallenge;
        if (qCircleTagChallengeInfo != null && (qCircleTagChallenge = qCircleTagChallengeInfo.mTagChallenge) != null && !TextUtils.isEmpty(qCircleTagChallenge.title)) {
            return true;
        }
        return false;
    }

    public static int b(List<e30.b> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).g() != null && feedCloudMeta$StFeed.f398449id.get().equals(list.get(i3).g().f398449id.get())) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static QCircleTagChallengeInfo c(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            return d(bVar.g());
        }
        QLog.w("QFSTagChallengeUtils", 1, "[hasTagChallengeInfo] feedBlockData == null.");
        return null;
    }

    public static QCircleTagChallengeInfo d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StTagChallenge feedCloudMeta$StTagChallenge;
        List<FeedCloudMeta$StTagInfo> f16 = f(feedCloudMeta$StFeed);
        if (f16 == null || f16.size() == 0) {
            return null;
        }
        for (FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo : f16) {
            if (feedCloudMeta$StTagInfo != null && (feedCloudMeta$StTagChallenge = feedCloudMeta$StTagInfo.tagChallengeData) != null && !TextUtils.isEmpty(feedCloudMeta$StTagChallenge.title.get()) && feedCloudMeta$StTagInfo.tagChallengeData.tagChallengeRank.get() > 0) {
                QLog.d("QFSTagChallengeUtils", 1, "[hasTagChallengeInfo] stTagInfo.tagChallengeData.title: ", feedCloudMeta$StTagInfo.tagChallengeData.title.get(), ", stTagInfo.tagChallengeData.subTitle: ", feedCloudMeta$StTagInfo.tagChallengeData.subTitle.get());
                return e(feedCloudMeta$StTagInfo);
            }
        }
        return null;
    }

    public static QCircleTagChallengeInfo e(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        QCircleTagChallengeInfo qCircleTagChallengeInfo = new QCircleTagChallengeInfo();
        FeedCloudMeta$StTagChallenge feedCloudMeta$StTagChallenge = feedCloudMeta$StTagInfo.tagChallengeData.get();
        qCircleTagChallengeInfo.mTagId = feedCloudMeta$StTagInfo.tagId.get();
        QCircleTagChallenge qCircleTagChallenge = new QCircleTagChallenge();
        qCircleTagChallenge.title = feedCloudMeta$StTagChallenge.title.get();
        qCircleTagChallenge.subTitle = feedCloudMeta$StTagChallenge.subTitle.get();
        qCircleTagChallenge.tagChallengeRank = feedCloudMeta$StTagChallenge.tagChallengeRank.get();
        qCircleTagChallengeInfo.mTagChallenge = qCircleTagChallenge;
        return qCircleTagChallengeInfo;
    }

    public static List<FeedCloudMeta$StTagInfo> f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBRepeatMessageField<FeedCloudMeta$StTagInfo> pBRepeatMessageField;
        if (feedCloudMeta$StFeed != null && (pBRepeatMessageField = feedCloudMeta$StFeed.tagInfos) != null && pBRepeatMessageField.get() != null && feedCloudMeta$StFeed.tagInfos.get().size() != 0) {
            return feedCloudMeta$StFeed.tagInfos.get();
        }
        QLog.d("QFSTagChallengeUtils", 1, "[hasTagChallengeInfo] have't TagChallengeInfo.");
        return null;
    }

    public static boolean g(e30.b bVar) {
        if (bVar != null && h(bVar.g())) {
            return true;
        }
        return false;
    }

    public static boolean h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (d(feedCloudMeta$StFeed) != null) {
            return true;
        }
        return false;
    }

    public static void i(Context context, String str) {
        com.tencent.biz.qqcircle.launcher.c.g(context, "mqqapi://qcircle/openqqpublish?target=1&tag=" + str);
    }
}
