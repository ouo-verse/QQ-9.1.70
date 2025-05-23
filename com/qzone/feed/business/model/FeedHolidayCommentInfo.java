package com.qzone.feed.business.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00122\u00020\u0001:\u0003\u0013\u0014\u0015B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/feed/business/model/FeedHolidayCommentInfo;", "Ljava/io/Serializable;", "Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$UserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$UserInfo;", "getUserInfo", "()Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$UserInfo;", "setUserInfo", "(Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$UserInfo;)V", "Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$CommentRes;", "commentRes", "Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$CommentRes;", "getCommentRes", "()Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$CommentRes;", "setCommentRes", "(Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$CommentRes;)V", "<init>", "()V", "Companion", "CommentRes", "a", "UserInfo", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class FeedHolidayCommentInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "FeedFirstCommentInfo";

    @SerializedName("comment_res")
    private CommentRes commentRes;

    @SerializedName("user_info")
    private UserInfo userInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$CommentRes;", "Ljava/io/Serializable;", "()V", "commentInfo", "Ljava/util/ArrayList;", "Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$CommentRes$CommentInfo;", "Lkotlin/collections/ArrayList;", "getCommentInfo", "()Ljava/util/ArrayList;", "setCommentInfo", "(Ljava/util/ArrayList;)V", "inputHit", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "getInputHit", "()Lcom/qzone/feed/business/model/FeedResourceInfo;", "setInputHit", "(Lcom/qzone/feed/business/model/FeedResourceInfo;)V", "notFriend", "getNotFriend", "setNotFriend", "CommentInfo", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class CommentRes implements Serializable {

        @SerializedName("comment_info")
        private ArrayList<CommentInfo> commentInfo;

        @SerializedName("input_hit")
        private FeedResourceInfo inputHit;

        @SerializedName("not_friend")
        private FeedResourceInfo notFriend;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$CommentRes$CommentInfo;", "Ljava/io/Serializable;", "()V", WSAutoShowCommentParams.KEY_COMMENT_ID, "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "resInfo", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "getResInfo", "()Lcom/qzone/feed/business/model/FeedResourceInfo;", "setResInfo", "(Lcom/qzone/feed/business/model/FeedResourceInfo;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes39.dex */
        public static final class CommentInfo implements Serializable {

            @SerializedName("comment_id")
            private String commentId;

            @SerializedName(IPreloadServiceProxy.KEY_RESINFO)
            private FeedResourceInfo resInfo;

            public final String getCommentId() {
                return this.commentId;
            }

            public final FeedResourceInfo getResInfo() {
                return this.resInfo;
            }

            public final void setCommentId(String str) {
                this.commentId = str;
            }

            public final void setResInfo(FeedResourceInfo feedResourceInfo) {
                this.resInfo = feedResourceInfo;
            }
        }

        public final ArrayList<CommentInfo> getCommentInfo() {
            return this.commentInfo;
        }

        public final FeedResourceInfo getInputHit() {
            return this.inputHit;
        }

        public final FeedResourceInfo getNotFriend() {
            return this.notFriend;
        }

        public final void setCommentInfo(ArrayList<CommentInfo> arrayList) {
            this.commentInfo = arrayList;
        }

        public final void setInputHit(FeedResourceInfo feedResourceInfo) {
            this.inputHit = feedResourceInfo;
        }

        public final void setNotFriend(FeedResourceInfo feedResourceInfo) {
            this.notFriend = feedResourceInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$UserInfo;", "Ljava/io/Serializable;", "()V", "resInfos", "Ljava/util/ArrayList;", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "Lkotlin/collections/ArrayList;", "getResInfos", "()Ljava/util/ArrayList;", "setResInfos", "(Ljava/util/ArrayList;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class UserInfo implements Serializable {

        @SerializedName("res_infos")
        private ArrayList<FeedResourceInfo> resInfos;

        public final ArrayList<FeedResourceInfo> getResInfos() {
            return this.resInfos;
        }

        public final void setResInfos(ArrayList<FeedResourceInfo> arrayList) {
            this.resInfos = arrayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007R\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/feed/business/model/FeedHolidayCommentInfo$a;", "", "", "", "extendInfo", "Lcom/qzone/feed/business/model/FeedHolidayCommentInfo;", "b", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.feed.business.model.FeedHolidayCommentInfo$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FeedHolidayCommentInfo b(Map<String, String> extendInfo) {
            FeedHolidayCommentInfo feedHolidayCommentInfo = new FeedHolidayCommentInfo();
            if (extendInfo != null && !extendInfo.isEmpty()) {
                try {
                    String str = extendInfo.get("user_info");
                    if (!TextUtils.isEmpty(str)) {
                        feedHolidayCommentInfo.setUserInfo((UserInfo) new Gson().fromJson(str, UserInfo.class));
                    }
                    String str2 = extendInfo.get("comment_res");
                    if (!TextUtils.isEmpty(str2)) {
                        feedHolidayCommentInfo.setCommentRes((CommentRes) new Gson().fromJson(str2, CommentRes.class));
                    }
                } catch (Throwable th5) {
                    QLog.e(FeedHolidayCommentInfo.TAG, 1, "parse error:" + th5);
                }
            }
            return feedHolidayCommentInfo;
        }

        Companion() {
        }

        @JvmStatic
        public final FeedHolidayCommentInfo a(BusinessFeedData feedData) {
            CellFeedCommInfo feedCommInfoV2 = feedData != null ? feedData.getFeedCommInfoV2() : null;
            return (feedCommInfoV2 != null ? feedCommInfoV2.extendInfo : null) == null ? new FeedHolidayCommentInfo() : b(feedCommInfoV2.extendInfo);
        }
    }

    @JvmStatic
    public static final FeedHolidayCommentInfo createCommentInfo(BusinessFeedData businessFeedData) {
        return INSTANCE.a(businessFeedData);
    }

    public final CommentRes getCommentRes() {
        return this.commentRes;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final void setCommentRes(CommentRes commentRes) {
        this.commentRes = commentRes;
    }

    public final void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
