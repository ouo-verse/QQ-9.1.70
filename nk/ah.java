package nk;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.base.n;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004J6\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012J$\u0010\u0015\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lnk/ah;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "realComment", "fakeComment", "", "U1", "comment", "W1", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "X1", "", "getLogTag", "P1", "S1", "Lkotlin/Function0;", "onSuccess", "Q1", "T1", "Lbk/g;", "i", "Lbk/g;", "getMCommentRepo", "()Lbk/g;", "setMCommentRepo", "(Lbk/g;)V", "mCommentRepo", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ah extends com.qzone.reborn.base.n {

    /* renamed from: m */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: from kotlin metadata */
    private bk.g mCommentRepo = new bk.g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lnk/ah$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nk.ah$a */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/ah$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "realComment", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<Comment> {

        /* renamed from: b */
        final /* synthetic */ BusinessFeedData f420274b;

        /* renamed from: c */
        final /* synthetic */ Comment f420275c;

        b(BusinessFeedData businessFeedData, Comment comment) {
            this.f420274b = businessFeedData;
            this.f420275c = comment;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a */
        public void onSuccess(Comment realComment, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ah.this.U1(this.f420274b, realComment, this.f420275c);
            com.qzone.reborn.util.o.f59556a.c(R.string.jkq, 2);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/ah$c", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements n.a<Reply> {

        /* renamed from: a */
        final /* synthetic */ Function0<Unit> f420276a;

        c(Function0<Unit> function0) {
            this.f420276a = function0;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a */
        public void onSuccess(Reply t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Function0<Unit> function0 = this.f420276a;
            if (function0 != null) {
                function0.invoke();
            } else {
                com.qzone.reborn.util.o.f59556a.c(R.string.wbg, 2);
            }
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/ah$d", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements n.a<Comment> {

        /* renamed from: b */
        final /* synthetic */ BusinessFeedData f420278b;

        /* renamed from: c */
        final /* synthetic */ Comment f420279c;

        d(BusinessFeedData businessFeedData, Comment comment) {
            this.f420278b = businessFeedData;
            this.f420279c = comment;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a */
        public void onSuccess(Comment t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            com.qzone.reborn.util.o.f59556a.c(R.string.jmm, 2);
            ah.this.W1(this.f420278b, this.f420279c);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/ah$e", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e implements n.a<Reply> {

        /* renamed from: b */
        final /* synthetic */ BusinessFeedData f420281b;

        /* renamed from: c */
        final /* synthetic */ Comment f420282c;

        /* renamed from: d */
        final /* synthetic */ Reply f420283d;

        e(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
            this.f420281b = businessFeedData;
            this.f420282c = comment;
            this.f420283d = reply;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a */
        public void onSuccess(Reply t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            com.qzone.reborn.util.o.f59556a.c(R.string.jmm, 2);
            ah.this.X1(this.f420281b, this.f420282c, this.f420283d);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    public final void P1(BusinessFeedData businessFeedData, Comment fakeComment) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(fakeComment, "fakeComment");
        this.mCommentRepo.b(this.contextHashCode, businessFeedData, fakeComment, new b(businessFeedData, fakeComment));
    }

    public final void S1(BusinessFeedData businessFeedData, Comment comment) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        this.mCommentRepo.d(this.contextHashCode, businessFeedData, comment, new d(businessFeedData, comment));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateCommentViewModel";
    }

    public final void U1(BusinessFeedData businessFeedData, Comment realComment, Comment fakeComment) {
        CellCommentInfo commentInfo;
        ArrayList<Comment> arrayList = (businessFeedData == null || (commentInfo = businessFeedData.getCommentInfo()) == null) ? null : commentInfo.commments;
        if (arrayList == null || arrayList.isEmpty() || realComment == null || fakeComment == null) {
            return;
        }
        ArrayList<Comment> arrayList2 = new ArrayList<>();
        for (Comment comment : arrayList) {
            if (comment.isFake && Intrinsics.areEqual(comment.clientKey, fakeComment.clientKey)) {
                arrayList2.add(realComment);
            } else {
                arrayList2.add(comment);
            }
        }
        CellCommentInfo commentInfo2 = businessFeedData.getCommentInfo();
        if (commentInfo2 != null) {
            commentInfo2.commments = arrayList2;
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessFeedData), businessFeedData.getCommentInfo()), true);
    }

    public final void W1(BusinessFeedData businessFeedData, Comment comment) {
        if (comment == null) {
            return;
        }
        CellCommentInfo commentInfo = businessFeedData.getCommentInfo();
        ArrayList<Comment> arrayList = new ArrayList<>();
        ArrayList<Comment> arrayList2 = commentInfo.commments;
        if (arrayList2 != null) {
            for (Comment comment2 : arrayList2) {
                if (!Intrinsics.areEqual(comment.commentid, comment2.commentid)) {
                    arrayList.add(comment2);
                }
            }
        }
        commentInfo.commments = arrayList;
        commentInfo.commentNum--;
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessFeedData), commentInfo), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void R1(ah ahVar, BusinessFeedData businessFeedData, Comment comment, Reply reply, Function0 function0, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        ahVar.Q1(businessFeedData, comment, reply, function0);
    }

    public final void X1(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        CellCommentInfo commentInfo;
        ArrayList<Comment> arrayList;
        Object obj;
        if (reply == null || comment == null || (arrayList = (commentInfo = businessFeedData.getCommentInfo()).commments) == null) {
            return;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((Comment) obj).commentid, comment.commentid)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Comment comment2 = (Comment) obj;
        if (comment2 == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<Reply> list = comment2.replies;
        if (list != null) {
            for (Reply reply2 : list) {
                if (!Intrinsics.areEqual(reply.replyId, reply2.replyId)) {
                    arrayList2.add(reply2);
                }
            }
        }
        comment2.replies = arrayList2;
        comment2.replyNum--;
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessFeedData), commentInfo), true);
    }

    public final void Q1(BusinessFeedData businessFeedData, Comment comment, Reply reply, Function0<Unit> onSuccess) {
        if (businessFeedData == null || comment == null || reply == null) {
            return;
        }
        this.mCommentRepo.c(this.contextHashCode, businessFeedData, comment, reply, new c(onSuccess));
    }

    public final void T1(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        if (businessFeedData == null || comment == null || reply == null) {
            return;
        }
        this.mCommentRepo.e(this.contextHashCode, businessFeedData, comment, reply, new e(businessFeedData, comment, reply));
    }
}
