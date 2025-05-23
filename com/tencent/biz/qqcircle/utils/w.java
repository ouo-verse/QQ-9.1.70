package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.qqvideo.data.QCircleFeedOperateFakeSyncExternalInfo;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedOperateFakeSyncExternalEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StUser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J0\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0007J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0007J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0007J:\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0002H\u0007J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/w;", "", "", "feedId", AppConstants.Key.KEY_QZONE_UGCKEY, "", "isLike", "", "i", WSAutoShowCommentParams.KEY_COMMENT_ID, tl.h.F, WSAutoShowCommentParams.KEY_REPLY_ID, "j", "clientKey", "f", "fakeCommentId", "content", "c", "e", "fakeReplyId", "Lfeedcloud/FeedCloudMeta$StUser;", "stUser", "d", "g", "b", "Lcom/tencent/mobileqq/qcircle/api/qqvideo/event/QCircleFeedOperateFakeSyncExternalEvent;", "event", "k", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f92788a = new w();

    w() {
    }

    private final boolean b() {
        return true;
    }

    @JvmStatic
    public static final void c(@NotNull String feedId, @NotNull String ugcKey, @NotNull String fakeCommentId, @NotNull String content) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        Intrinsics.checkNotNullParameter(fakeCommentId, "fakeCommentId");
        Intrinsics.checkNotNullParameter(content, "content");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchAddCommentEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(4);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setCommentId(fakeCommentId);
        qCircleFeedOperateFakeSyncExternalInfo.setContent(content);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    @JvmStatic
    public static final void d(@NotNull String feedId, @NotNull String ugcKey, @NotNull String commentId, @NotNull String fakeReplyId, @Nullable FeedCloudMeta$StUser stUser, @NotNull String content) {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(fakeReplyId, "fakeReplyId");
        Intrinsics.checkNotNullParameter(content, "content");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchAddReplyEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(6);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setCommentId(commentId);
        qCircleFeedOperateFakeSyncExternalInfo.setReplyId(fakeReplyId);
        qCircleFeedOperateFakeSyncExternalInfo.setContent(content);
        String str2 = null;
        if (stUser != null && (pBStringField2 = stUser.f398463id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        qCircleFeedOperateFakeSyncExternalInfo.setTargetUin(str);
        if (stUser != null && (pBStringField = stUser.nick) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null) {
            str3 = str2;
        }
        qCircleFeedOperateFakeSyncExternalInfo.setTargetNick(str3);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    @JvmStatic
    public static final void e(@NotNull String feedId, @NotNull String ugcKey, @NotNull String commentId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchDeleteCommentEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(5);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setCommentId(commentId);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    @JvmStatic
    public static final void f(@NotNull String feedId, @NotNull String ugcKey, @NotNull String clientKey) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchDeleteFeedEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(8);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setClientKey(clientKey);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    @JvmStatic
    public static final void g(@NotNull String feedId, @NotNull String ugcKey, @NotNull String commentId, @NotNull String replyId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchDeleteReplyEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(7);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setCommentId(commentId);
        qCircleFeedOperateFakeSyncExternalInfo.setReplyId(replyId);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    @JvmStatic
    public static final void h(@NotNull String feedId, @NotNull String ugcKey, @NotNull String commentId, boolean isLike) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchLikeCommentEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(2);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setCommentId(commentId);
        qCircleFeedOperateFakeSyncExternalInfo.setLike(isLike);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    @JvmStatic
    public static final void i(@NotNull String feedId, @NotNull String ugcKey, boolean isLike) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchLikeFeedEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(1);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setLike(isLike);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    @JvmStatic
    public static final void j(@NotNull String feedId, @NotNull String ugcKey, @NotNull String commentId, @NotNull String replyId, boolean isLike) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        w wVar = f92788a;
        if (!wVar.b()) {
            QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchLikeReplyEvent] can not dispatch sync event");
            return;
        }
        QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo = new QCircleFeedOperateFakeSyncExternalInfo();
        qCircleFeedOperateFakeSyncExternalInfo.setEventType(3);
        qCircleFeedOperateFakeSyncExternalInfo.setFeedId(feedId);
        qCircleFeedOperateFakeSyncExternalInfo.setUgcKey(ugcKey);
        qCircleFeedOperateFakeSyncExternalInfo.setCommentId(commentId);
        qCircleFeedOperateFakeSyncExternalInfo.setReplyId(replyId);
        qCircleFeedOperateFakeSyncExternalInfo.setLike(isLike);
        wVar.k(new QCircleFeedOperateFakeSyncExternalEvent(qCircleFeedOperateFakeSyncExternalInfo));
    }

    private final void k(final QCircleFeedOperateFakeSyncExternalEvent event) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.v
            @Override // java.lang.Runnable
            public final void run() {
                w.l(QCircleFeedOperateFakeSyncExternalEvent.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QCircleFeedOperateFakeSyncExternalEvent event) {
        Intrinsics.checkNotNullParameter(event, "$event");
        QLog.d("QCircleFeedOperateSyncExternalUtil", 1, "[dispatchSyncExternalEvent] " + event.getOperateSyncInfo());
        SimpleEventBus.getInstance().dispatchEvent(event);
    }
}
