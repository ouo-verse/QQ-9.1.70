package com.qzone.feed.business.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.qzone.feed.business.model.FeedHolidayCommentInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/feed/business/model/FeedHolidayCommentEvent;", "Ljava/io/Serializable;", "", "playRid", "Ljava/lang/String;", "getPlayRid", "()Ljava/lang/String;", "setPlayRid", "(Ljava/lang/String;)V", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "nickNameResInfo", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "getNickNameResInfo", "()Lcom/qzone/feed/business/model/FeedResourceInfo;", "setNickNameResInfo", "(Lcom/qzone/feed/business/model/FeedResourceInfo;)V", "tipsInfo", "getTipsInfo", "setTipsInfo", "<init>", "()V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class FeedHolidayCommentEvent implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "FeedFirstCommentEvent";

    @SerializedName("nickname_res_info")
    private FeedResourceInfo nickNameResInfo;

    @SerializedName("play_rid")
    private String playRid;

    @SerializedName("tips_info")
    private FeedResourceInfo tipsInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0007J\u001e\u0010\u000b\u001a\u00020\n2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/feed/business/model/FeedHolidayCommentEvent$a;", "", "", WSAutoShowCommentParams.KEY_COMMENT_ID, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "extendInfo", "", "b", "Lcom/qzone/feed/business/model/FeedHolidayCommentEvent;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.feed.business.model.FeedHolidayCommentEvent$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FeedHolidayCommentEvent a(Map<String, String> extendInfo) {
            FeedHolidayCommentEvent feedHolidayCommentEvent = new FeedHolidayCommentEvent();
            if (extendInfo == null || extendInfo.isEmpty()) {
                return feedHolidayCommentEvent;
            }
            String str = extendInfo.get("event_info");
            if (TextUtils.isEmpty(str)) {
                return feedHolidayCommentEvent;
            }
            try {
                Object fromJson = new Gson().fromJson(str, (Class<Object>) FeedHolidayCommentEvent.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(contentJ\u2026CommentEvent::class.java)");
                return (FeedHolidayCommentEvent) fromJson;
            } catch (Throwable th5) {
                QLog.e(FeedHolidayCommentEvent.TAG, 1, "parse error:" + th5);
                return feedHolidayCommentEvent;
            }
        }

        @JvmStatic
        public final void b(String commentId, BusinessFeedData feedData, Map<String, String> extendInfo) {
            FeedHolidayCommentInfo.CommentRes commentRes;
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
            Map<String, String> map = cellFeedCommInfo != null ? cellFeedCommInfo.extendInfo : null;
            if (map == null || map.isEmpty() || extendInfo == null || extendInfo.isEmpty()) {
                return;
            }
            FeedHolidayCommentEvent a16 = a(extendInfo);
            FeedHolidayCommentInfo a17 = FeedHolidayCommentInfo.INSTANCE.a(feedData);
            if (a17.getCommentRes() == null) {
                a17.setCommentRes(new FeedHolidayCommentInfo.CommentRes());
            }
            FeedHolidayCommentInfo.CommentRes commentRes2 = a17.getCommentRes();
            if ((commentRes2 != null ? commentRes2.getCommentInfo() : null) == null) {
                FeedHolidayCommentInfo.CommentRes.CommentInfo commentInfo = new FeedHolidayCommentInfo.CommentRes.CommentInfo();
                commentInfo.setCommentId(commentId);
                commentInfo.setResInfo(a16.getNickNameResInfo());
                FeedHolidayCommentInfo.CommentRes commentRes3 = a17.getCommentRes();
                if (commentRes3 != null) {
                    commentRes3.setCommentInfo(new ArrayList<>());
                }
                FeedHolidayCommentInfo.CommentRes commentRes4 = a17.getCommentRes();
                ArrayList<FeedHolidayCommentInfo.CommentRes.CommentInfo> commentInfo2 = commentRes4 != null ? commentRes4.getCommentInfo() : null;
                Intrinsics.checkNotNull(commentInfo2);
                commentInfo2.add(commentInfo);
            }
            FeedHolidayCommentInfo.CommentRes commentRes5 = a17.getCommentRes();
            if ((commentRes5 != null ? commentRes5.getNotFriend() : null) == null && (commentRes = a17.getCommentRes()) != null) {
                commentRes.setNotFriend(a16.getTipsInfo());
            }
            FeedHolidayCommentInfo.CommentRes commentRes6 = a17.getCommentRes();
            if (commentRes6 != null) {
                FeedResourceInfo feedResourceInfo = new FeedResourceInfo();
                feedResourceInfo.setText("");
                commentRes6.setInputHit(feedResourceInfo);
            }
            try {
                map.put("comment_res", new Gson().toJson(a17.getCommentRes()));
            } catch (Throwable th5) {
                QLog.e(FeedHolidayCommentEvent.TAG, 1, "convert error:" + th5);
            }
            QLog.i(FeedHolidayCommentEvent.TAG, 1, "[updateFeedCommExtendInfo] success:" + map);
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final FeedHolidayCommentEvent parseMapData(Map<String, String> map) {
        return INSTANCE.a(map);
    }

    @JvmStatic
    public static final void updateFeedCommExtendInfo(String str, BusinessFeedData businessFeedData, Map<String, String> map) {
        INSTANCE.b(str, businessFeedData, map);
    }

    public final FeedResourceInfo getNickNameResInfo() {
        return this.nickNameResInfo;
    }

    public final String getPlayRid() {
        return this.playRid;
    }

    public final FeedResourceInfo getTipsInfo() {
        return this.tipsInfo;
    }

    public final void setNickNameResInfo(FeedResourceInfo feedResourceInfo) {
        this.nickNameResInfo = feedResourceInfo;
    }

    public final void setPlayRid(String str) {
        this.playRid = str;
    }

    public final void setTipsInfo(FeedResourceInfo feedResourceInfo) {
        this.tipsInfo = feedResourceInfo;
    }
}
