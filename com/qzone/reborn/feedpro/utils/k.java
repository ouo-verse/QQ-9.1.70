package com.qzone.reborn.feedpro.utils;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.comment.bean.CommentReplyParam;
import com.qzone.reborn.feedpro.bean.QzoneFeedProClickedComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0007B\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\"\u0010#J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010J\"\u0010\u0018\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0010R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010 \u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/k;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "reply", "", "a", "", "b", "Lde/a;", "commentIoc", "", "d", "dtPageId", "e", "", "showQuickComment", "f", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;", "clickedComment", "position", "c", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "mFragment", "Lde/a;", "mCommentIoc", "Ljava/lang/String;", "mDtPageId", "I", "mShowQuickComment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Fragment mFragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private de.a mCommentIoc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mDtPageId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mShowQuickComment;

    public k(Fragment fragment) {
        this.mFragment = fragment;
    }

    private final String a(CommonComment comment, CommonReply reply) {
        if (reply != null) {
            String a16 = com.qzone.util.l.a(R.string.jy6);
            CommonUser user = reply.getUser();
            return a16 + (user != null ? user.getNick() : null) + ":";
        }
        String a17 = com.qzone.util.l.a(R.string.f171637jy1);
        CommonUser user2 = comment.getUser();
        return a17 + (user2 != null ? user2.getNick() : null) + ":";
    }

    public final void d(de.a commentIoc) {
        Intrinsics.checkNotNullParameter(commentIoc, "commentIoc");
        this.mCommentIoc = commentIoc;
    }

    public final void e(String dtPageId) {
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        this.mDtPageId = dtPageId;
    }

    public final void f(int showQuickComment) {
        this.mShowQuickComment = showQuickComment;
    }

    public final void c(CommonFeed feedData, QzoneFeedProClickedComment clickedComment, int position) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        if (feedData == null || this.mFragment == null) {
            return;
        }
        String str5 = "";
        if (clickedComment == null) {
            i3 = -1;
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
        } else {
            CommonComment comment = clickedComment.getComment();
            CommonReply reply = clickedComment.getReply();
            str3 = null;
            if ((comment != null ? comment.getUser() : null) == null) {
                QLog.d("QzoneFeedProCommentClickProcess", 1, "onCommentClick error, comment is null");
                return;
            }
            if (b(comment, reply)) {
                de.a aVar = this.mCommentIoc;
                if (aVar != null) {
                    aVar.g7(feedData, clickedComment, position);
                    return;
                }
                return;
            }
            String a16 = a(comment, reply);
            str4 = comment.getId();
            CommonUser user = comment.getUser();
            str2 = user != null ? user.getUin() : null;
            if (reply == null) {
                str3 = "";
            } else {
                str5 = reply.getId();
                CommonUser user2 = reply.getUser();
                if (user2 != null) {
                    str3 = user2.getUin();
                }
            }
            i3 = 1208;
            String str6 = str5;
            str5 = a16;
            str = str6;
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = com.qzone.util.l.a(R.string.glb);
        }
        if (i3 == -1) {
            i3 = 1207;
        }
        ho.i.c().f(cd.c.c(feedData, str4).v(position).y(i3).g(CommonFeedExtKt.getFeedUniqueKey(feedData)).q(str5).B(this.mShowQuickComment).h(new CommentReplyParam(str4, str2, str, str3)).p(this.mDtPageId).getParams(), this.mFragment, feedData);
    }

    private final boolean b(CommonComment comment, CommonReply reply) {
        CommonUser user;
        if (reply != null) {
            CommonUser user2 = reply.getUser();
            return Intrinsics.areEqual(user2 != null ? user2.getUin() : null, LoginData.getInstance().getUinString());
        }
        if (comment != null && (user = comment.getUser()) != null) {
            r1 = user.getUin();
        }
        return Intrinsics.areEqual(r1, LoginData.getInstance().getUinString());
    }
}
