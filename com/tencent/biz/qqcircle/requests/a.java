package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.GetStaggeredListReq;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import java.util.HashMap;
import java.util.Map;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, Pair<String, String>> f91872a;

    static {
        HashMap hashMap = new HashMap();
        f91872a = hashMap;
        hashMap.put("push", new Pair("trpc.feedcloud.feeds_maintab.maintab", "GetAllPushFeedList"));
        hashMap.put(GuildMsgItem.NICK_FRIEND, new Pair("trpc.feedcloud.feeds_maintab.maintab", "GetFriendFeedList"));
        hashMap.put("follow", new Pair("trpc.feedcloud.feeds_maintab.maintab", "GetFollowFeedList"));
        hashMap.put("comment_list", new Pair("trpc.feedcloud.comment.Reader", "GetCommentList"));
        hashMap.put("comment_reply", new Pair("trpc.feedcloud.comment.Reader", "GetReplyList"));
        hashMap.put("detail_from_qzone", new Pair("trpc.feedcloud.commreader_qzone.CommReaderQzone", "GetFeedDetailFromQzone"));
        hashMap.put("new_style_detail_feed_list", new Pair("trpc.feedcloud.commreader_flow.CommReaderFlow", "GetNewStyleDetailPageFeedList"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageBasicData", new Pair("trpc.videocircle.mainpage_profile_reader.MainpageProfileReader", "GetMainPageBasicData"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageCommData", new Pair("trpc.feedcloud.commreader.ComReaderFeeds", "GetMainPageCommData"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpageSortFeedList", new Pair("trpc.feedcloud.commreader.ComReaderFeeds", "GetMainPageCommData"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListLike", new Pair("trpc.feedcloud.commreader.ComReaderFeeds", "GetFeedListLike"));
        hashMap.put(QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST, new Pair("trpc.feedcloud.commreader.ComReaderFeeds", "GetProfilePushFeedList"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCollectionList", new Pair("trpc.feedcloud.commreader.ComReaderFeeds", "GetCollectionList"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.GetFavoritesList", new Pair("trpc.feedcloud.collectionsvr.CommFavorites", "GetFavoritesList"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommunityPage", new Pair("trpc.feedcloud.commreader.ComReaderFeeds", "GetCommunityPage"));
        hashMap.put(GetStaggeredListReq.CMD, new Pair("trpc.feedcloud.officialaccount.OfficialAccount", "GetWaterfallOfficialAccountFeeds"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountSecondaryPageFeeds", new Pair("trpc.feedcloud.officialaccount.OfficialAccount", "GetWaterfallOfficialAccountSecondaryPageFeeds"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetQQContactFriendHeadFeedList", new Pair("trpc.feedcloud.commreader_feeds.ComReader", "GetQQContactFriendHeadFeedList"));
        hashMap.put("FeedCloudSvr.trpc.feedcloud.render_feed_detail.Render.GetFeedDetailWithExtraData", new Pair("trpc.feedcloud.render_feed_detail.Render", "GetFeedDetailWithExtraData"));
    }

    public static Pair<String, String> a(String str) {
        if (!o.w1()) {
            return new Pair<>("", "");
        }
        return b(str);
    }

    public static Pair<String, String> b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, Pair<String, String>> map = f91872a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        return new Pair<>("", "");
    }

    public static Pair<String, String> c(String str) {
        if (!o.r1()) {
            return new Pair<>("", "");
        }
        return b(str);
    }

    public static Pair<String, String> d(QCircleTabInfo qCircleTabInfo) {
        if (qCircleTabInfo == null) {
            return new Pair<>("", "");
        }
        int type = qCircleTabInfo.getType();
        if (6 == type) {
            return f91872a.get("push");
        }
        if (1 == type) {
            return f91872a.get("follow");
        }
        if (9 == type) {
            return f91872a.get(GuildMsgItem.NICK_FRIEND);
        }
        return new Pair<>("", "");
    }
}
