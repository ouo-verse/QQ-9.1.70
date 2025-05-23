package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.detail.event.GuildDoCommentEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.y;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/b;", "Lcom/tencent/biz/richframework/part/Part;", "", "args", "", "B9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$r;", "msg", "A9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", QCircleScheme.AttrDetail.FEED_INFO, "", "finalContent", "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "x9", "extData", "z9", "action", "handleBroadcastMessage", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "d", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "getInitBean", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "setInitBean", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;)V", "initBean", "", "e", "Z", "isFromList", "()Z", "setFromList", "(Z)V", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;Z)V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFeedDetailInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFromList;

    public /* synthetic */ b(GuildFeedDetailInitBean guildFeedDetailInitBean, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildFeedDetailInitBean, (i3 & 2) != 0 ? false : z16);
    }

    private final void A9(a.TryToSendInputContentMessage msg2) {
        boolean isBlank;
        boolean z16;
        a.CommentMainFeedData z95 = z9(msg2.getExtData());
        if (z95 == null) {
            QLog.e("FeedWebDetailAndFeedListSendPart", 1, "handleCommentFeed feedDetailMainData is null");
            yl1.n.z(0, R.string.f143860n8);
            return;
        }
        String content = msg2.getContent();
        if (content == null) {
            content = "";
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(content);
        if (isBlank) {
            ArrayList<LocalMediaInfo> d16 = msg2.d();
            if (d16 != null && !d16.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                yl1.n.z(0, R.string.f143820n4);
                return;
            }
        }
        bl.c().b(x9(msg2, z95, content), true);
        y.b(com.tencent.mobileqq.guild.ipc.methods.i.class, null, z95.getGuildId(), "postComment");
    }

    private final void B9(Object args) {
        if (!(args instanceof a.TryToSendInputContentMessage)) {
            QLog.e("FeedWebDetailAndFeedListSendPart", 1, "handleSendMessage args error!");
            return;
        }
        a.TryToSendInputContentMessage tryToSendInputContentMessage = (a.TryToSendInputContentMessage) args;
        QLog.i("FeedWebDetailAndFeedListSendPart", 1, "handleTryToSendInputContentMessage " + tryToSendInputContentMessage.getInputArgs().getInputFunctionType());
        A9(tryToSendInputContentMessage);
        if (tryToSendInputContentMessage.getNeedClearInput()) {
            broadcastMessage("message_clear_input", null);
        }
    }

    private final GuildDoCommentEvent x9(a.TryToSendInputContentMessage msg2, a.CommentMainFeedData feedInfo, String finalContent) {
        boolean z16;
        String str;
        String str2;
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        GProStReply reply;
        GProStUser gProStUser;
        GProStComment comment;
        GProStUser gProStUser2;
        GProStReply reply2;
        GProStComment comment2;
        GProStComment comment3;
        ArrayList<LocalMediaInfo> d16 = msg2.d();
        if (d16 == null) {
            d16 = new ArrayList<>();
        }
        ArrayList<LocalMediaInfo> arrayList = d16;
        Boolean originalPic = msg2.getOriginalPic();
        boolean z17 = false;
        if (originalPic != null) {
            z16 = originalPic.booleanValue();
        } else {
            z16 = false;
        }
        ReplyCommentArgs replyCommentArgs = msg2.getInputArgs().getReplyCommentArgs();
        if (msg2.getInputArgs().getInputFunctionType() == InputFunctionType.FUNCTION_TYPE_COMMENT_FEED) {
            z17 = true;
        }
        boolean z18 = z17;
        long time = new Date().getTime() / 1000;
        String feedId = feedInfo.getFeedId();
        long createTime = feedInfo.getCreateTime();
        String guildId = feedInfo.getGuildId();
        String channelId = feedInfo.getChannelId();
        String posterId = feedInfo.getPosterId();
        if (replyCommentArgs != null && (comment3 = replyCommentArgs.getComment()) != null) {
            str = comment3.idd;
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (replyCommentArgs != null && (comment2 = replyCommentArgs.getComment()) != null) {
            j3 = comment2.createTime;
        } else {
            j3 = 0;
        }
        long j16 = j3;
        if (replyCommentArgs != null && (reply2 = replyCommentArgs.getReply()) != null) {
            str3 = reply2.idd;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        if (replyCommentArgs != null && (comment = replyCommentArgs.getComment()) != null && (gProStUser2 = comment.postUser) != null) {
            str5 = gProStUser2.idd;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        if (replyCommentArgs != null && (reply = replyCommentArgs.getReply()) != null && (gProStUser = reply.postUser) != null) {
            str7 = gProStUser.idd;
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str8 = "";
        } else {
            str8 = str7;
        }
        return new GuildDoCommentEvent(finalContent, time, feedId, createTime, guildId, channelId, posterId, arrayList, z18, str2, j16, str4, str6, str8, z16, this.initBean.getBusinessType(), com.tencent.mobileqq.guild.feed.nativepublish.utils.k.c(2, this.initBean), this.isFromList);
    }

    private final a.CommentMainFeedData z9(Object extData) {
        a.OnCommentMainFeedDataResult onCommentMainFeedDataResult;
        Object broadcastGetMessage = broadcastGetMessage("message_get_comment_feed_data", extData);
        if (broadcastGetMessage instanceof a.OnCommentMainFeedDataResult) {
            onCommentMainFeedDataResult = (a.OnCommentMainFeedDataResult) broadcastGetMessage;
        } else {
            onCommentMainFeedDataResult = null;
        }
        if (onCommentMainFeedDataResult == null) {
            return null;
        }
        return onCommentMainFeedDataResult.getMainFeedData();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_try_to_send_input_content")) {
            B9(args);
        }
    }

    public b(@NotNull GuildFeedDetailInitBean initBean, boolean z16) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        this.isFromList = z16;
    }
}
