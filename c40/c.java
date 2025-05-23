package c40;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.manager.i;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {
    public static List<FeedCloudMeta$StComment> a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        ArrayList arrayList = new ArrayList();
        if (!QFSCommentHelper.L().b0()) {
            return arrayList;
        }
        List<FeedCloudMeta$StComment> list = feedCloudMeta$StFeed.vecComment.get();
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
                if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 32) && !TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
                    arrayList.add(feedCloudMeta$StComment);
                }
            }
            return arrayList;
        }
        QLog.d("QFSFeedHotCommentUtil", 1, "hasHotComments, comments null ");
        return arrayList;
    }

    public static boolean b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudMeta$StComment> list;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedHotCommentUtil", 1, "hasHotComments, feed null ");
            return false;
        }
        if (i.a("qfs_feed_comment_show") && uq3.c.g5() && (list = feedCloudMeta$StFeed.vecComment.get()) != null && !list.isEmpty()) {
            for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
                if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4) && !TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!QFSCommentHelper.L().b0()) {
            return false;
        }
        return !a(feedCloudMeta$StFeed).isEmpty();
    }
}
