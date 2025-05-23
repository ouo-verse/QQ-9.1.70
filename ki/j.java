package ki;

import android.os.Handler;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.base.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunReplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.StComment;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StReply;
import com.tencent.richframework.thread.RFWThreadManager;
import ki.j;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J:\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006J0\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006J6\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006J8\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006\u00a8\u0006\u0018"}, d2 = {"Lki/j;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Lcom/qzone/reborn/base/n$a;", "dataCallback", "", "actionType", "", "i", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "l", "", "isBatch", "e", "g", "f", tl.h.F, "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f412482b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f412483c = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lki/j$a;", "", "", "PHOTO_SCENE", "I", "b", "()I", "BATCH_SCENE", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ki.j$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return j.f412483c;
        }

        public final int b() {
            return j.f412482b;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"ki/j$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceDoQunReplyCallback;", "", "seq", "result", "", "errMs", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "ext", "Lcom/tencent/qqnt/kernel/nativeinterface/StReply;", "reply", "", "onDoQunReply", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IAlbumServiceDoQunReplyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<Reply> f412484a;

        b(n.a<Reply> aVar) {
            this.f412484a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, StReply stReply, StCommonExt stCommonExt, n.a dataCallback, String errMs) {
            Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
            Intrinsics.checkNotNullParameter(errMs, "$errMs");
            if (i3 == 0) {
                dataCallback.onSuccess(stReply != null ? yh.b.M(stReply, stCommonExt) : null, i3, errMs, true);
            } else {
                dataCallback.onFailure(i3, errMs);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunReplyCallback
        public void onDoQunReply(int seq, final int result, final String errMs, final StCommonExt ext, final StReply reply) {
            Intrinsics.checkNotNullParameter(errMs, "errMs");
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final n.a<Reply> aVar = this.f412484a;
            uIHandler.post(new Runnable() { // from class: ki.k
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.b(result, reply, ext, aVar, errMs);
                }
            });
        }
    }

    private final void i(BusinessFeedData businessFeedData, Comment comment, final n.a<Comment> dataCallback, int actionType) {
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        CellGroupAlbumInfo cellGroupAlbumInfo = businessFeedData.cellGroupAlbumInfo;
        String str = cellGroupAlbumInfo != null ? cellGroupAlbumInfo.groupId : null;
        if (feedCommInfo == null || comment == null) {
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        Pair<StFeed, StComment> a16 = xh.c.f448000a.a(businessFeedData, str, comment, actionType);
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.W(new StCommonExt(), str, actionType, a16.getFirst(), a16.getSecond(), new IAlbumServiceDoQunCommentCallback() { // from class: ki.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDoQunCommentCallback
                public final void onDoQunComment(int i3, int i16, String str2, StCommonExt stCommonExt, StComment stComment) {
                    j.j(n.a.this, i3, i16, str2, stCommonExt, stComment);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final n.a dataCallback, final int i3, final int i16, final String str, final StCommonExt stCommonExt, final StComment stComment) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.i
            @Override // java.lang.Runnable
            public final void run() {
                j.k(i3, i16, stComment, stCommonExt, dataCallback, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, int i16, StComment stComment, StCommonExt stCommonExt, n.a dataCallback, String errMs) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        QLog.e("GroupAlbumFeedCommentRepo", 1, "doQunComment seq: " + i3 + " | resultCode: " + i16);
        if (i16 == 0) {
            Intrinsics.checkNotNullExpressionValue(errMs, "errMs");
            dataCallback.onSuccess(yh.b.H(stComment, stCommonExt), i16, errMs, true);
        } else {
            dataCallback.onFailure(i16, errMs);
        }
    }

    private final void l(BusinessFeedData businessFeedData, Comment comment, Reply reply, n.a<Reply> dataCallback, int actionType) {
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        String groupId = businessFeedData.cellGroupAlbumInfo.groupId;
        if (feedCommInfo == null || comment == null) {
            return;
        }
        if (groupId == null || groupId.length() == 0) {
            return;
        }
        xh.c cVar = xh.c.f448000a;
        Intrinsics.checkNotNullExpressionValue(groupId, "groupId");
        Triple<StFeed, StComment, StReply> d16 = cVar.d(businessFeedData, groupId, comment, reply, actionType);
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.f0(new StCommonExt(), groupId, actionType, d16.getFirst(), d16.getSecond(), d16.getThird(), new b(dataCallback));
        }
    }

    public final void e(boolean isBatch, BusinessFeedData businessFeedData, Comment comment, n.a<Comment> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        i(businessFeedData, comment, dataCallback, isBatch ? 1 : 2);
    }

    public final void f(boolean isBatch, BusinessFeedData businessFeedData, Comment comment, Reply reply, n.a<Reply> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        l(businessFeedData, comment, reply, dataCallback, isBatch ? 1 : 2);
    }

    public final void g(boolean isBatch, BusinessFeedData businessFeedData, Comment comment, n.a<Comment> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        i(businessFeedData, comment, dataCallback, isBatch ? 3 : 4);
    }

    public final void h(boolean isBatch, BusinessFeedData businessFeedData, Comment comment, Reply reply, n.a<Reply> dataCallback) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        l(businessFeedData, comment, reply, dataCallback, isBatch ? 3 : 4);
    }
}
