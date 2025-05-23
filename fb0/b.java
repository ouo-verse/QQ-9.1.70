package fb0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static void a(List<FeedCloudMeta$StFeed> list, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (list != null && feedCloudRead$StGetFeedListRsp != null) {
            List<FeedCloudCommon$Entry> list2 = feedCloudRead$StGetFeedListRsp.extInfo.mapInfo.get();
            if (!feedCloudRead$StGetFeedListRsp.extInfo.has()) {
                feedCloudRead$StGetFeedListRsp.extInfo.setHasFlag(true);
            }
            String str = "";
            for (int i3 = 0; i3 < list2.size(); i3++) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = list2.get(i3);
                if (TextUtils.equals(feedCloudCommon$Entry.key.get(), EeveeRedpointUtil.EEVEE_TRACE_ID)) {
                    str = feedCloudCommon$Entry.value.get();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (int i16 = 0; i16 < list.size(); i16++) {
                e(list.get(i16).debugInfo.debugMap, EeveeRedpointUtil.EEVEE_TRACE_ID, str);
            }
        }
    }

    public static void b(@NonNull List<FeedCloudMeta$StFeed> list, String str) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            e(list.get(i3).debugInfo.debugMap, "KEY_VIDEO_PLAY_SOURCE_TYPE", str);
        }
    }

    public static String c(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField, String str, String str2) {
        if (pBRepeatMessageField == null) {
            return str2;
        }
        for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = pBRepeatMessageField.get(i3);
            if (feedCloudCommon$Entry != null && TextUtils.equals(feedCloudCommon$Entry.key.get(), str)) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return str2;
    }

    public static String d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (feedCloudMeta$StFeed == null) {
            return str;
        }
        return c(feedCloudMeta$StFeed.debugInfo.debugMap, "KEY_VIDEO_PLAY_SOURCE_TYPE", str);
    }

    public static void e(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField, String str, String str2) {
        FeedCloudCommon$Entry feedCloudCommon$Entry;
        if (pBRepeatMessageField == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < pBRepeatMessageField.size()) {
                feedCloudCommon$Entry = pBRepeatMessageField.get(i3);
                if (TextUtils.equals(feedCloudCommon$Entry.key.get(), str)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                feedCloudCommon$Entry = null;
                break;
            }
        }
        if (feedCloudCommon$Entry == null) {
            feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(str);
            pBRepeatMessageField.add(feedCloudCommon$Entry);
        }
        feedCloudCommon$Entry.value.set(str2);
    }
}
