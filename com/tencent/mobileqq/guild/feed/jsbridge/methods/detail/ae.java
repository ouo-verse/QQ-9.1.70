package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/ae;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "Lnj1/a;", "p", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ae extends c {
    private final nj1.a p() {
        boolean z16;
        long parseLong;
        int d16 = d("maxTextLength");
        boolean b16 = b("isReply");
        String commentId = g("commentID");
        String g16 = g("commentCreatedTime");
        Intrinsics.checkNotNullExpressionValue(g16, "argString(COMMENT_CREATED_TIME)");
        if (g16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            parseLong = 0;
        } else {
            String g17 = g("commentCreatedTime");
            Intrinsics.checkNotNullExpressionValue(g17, "argString(COMMENT_CREATED_TIME)");
            parseLong = Long.parseLong(g17);
        }
        long j3 = parseLong;
        String replyTargetId = g("replyTargetID");
        String commentPosterId = g("commentPosterID");
        String replyTargetUserId = g("replyTargetUserID");
        int e16 = e("activeType", 0);
        int e17 = e("clickRegion", 0);
        String placeHolder = g("placeholder");
        QLog.i("TopicCommentMethod", 4, "parseArg maxLength=" + d16 + " isReply=" + b16 + " commentId=" + commentId + " createTime=" + j3 + " replyTargetId=" + replyTargetId + " commentPosterId=" + commentPosterId + " replyTargetUserId=" + replyTargetUserId + " activeType=" + e16 + " clickRegion=" + e17 + " placeHolder=" + placeHolder);
        Intrinsics.checkNotNullExpressionValue(commentId, "commentId");
        Intrinsics.checkNotNullExpressionValue(replyTargetId, "replyTargetId");
        Intrinsics.checkNotNullExpressionValue(commentPosterId, "commentPosterId");
        Intrinsics.checkNotNullExpressionValue(replyTargetUserId, "replyTargetUserId");
        Intrinsics.checkNotNullExpressionValue(placeHolder, "placeHolder");
        return new nj1.a(d16, b16, commentId, j3, replyTargetId, commentPosterId, replyTargetUserId, e16, e17, placeHolder, false, null, 3072, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "TopicComment";
    }

    @Override // ok1.a
    protected boolean o(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("TopicCommentMethod", 4, "onInvoke pkgName=" + pkgName + " method=" + method);
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.showInputPop(p());
        return true;
    }
}
