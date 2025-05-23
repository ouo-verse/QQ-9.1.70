package com.qzone.reborn.feedpro.utils;

import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJF\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0002J.\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0002J*\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J6\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\f\u0010\u001b\u001a\u00020\t*\u0004\u0018\u00010\u0007J\f\u0010\u001c\u001a\u00020\t*\u0004\u0018\u00010\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/n;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "data", "", "Lwd/c;", "infoList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "", "commentPos", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/qzone/reborn/feedpro/utils/n$a;", "expandMap", "", "a", "totalReplies", "b", "list", "Lwd/b;", TangramHippyConstants.AD_DATA, "f", "", "g", "", "c", "e", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f54347a = new n();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedpro/utils/n$a;", "", "", "count", "", "a", "totalReplies", "g", "f", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "getComment", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "b", "I", "()I", "setExpandCount", "(I)V", "expandCount", "c", "setPageIndex", "pageIndex", "d", "setPageSize", "pageSize", "getFirstPageSize", "setFirstPageSize", "firstPageSize", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final CommonComment comment;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int expandCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int pageIndex;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int pageSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int firstPageSize;

        public a(CommonComment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            this.comment = comment;
            n nVar = n.f54347a;
            this.pageSize = nVar.e(comment);
            this.firstPageSize = nVar.d(comment);
        }

        public final void a(int count) {
            RFWLog.d("QzoneFeedProDetailCommentDataTransferUtils", RFWLog.USR, "appendExpandCount count:" + count + ",commentId:" + this.comment.getId() + ",oldCount:" + this.expandCount);
            this.expandCount = this.expandCount + count;
            this.pageIndex = this.pageIndex + 1;
        }

        /* renamed from: b, reason: from getter */
        public final int getExpandCount() {
            return this.expandCount;
        }

        /* renamed from: c, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* renamed from: d, reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        public final void e(int totalReplies) {
            if (totalReplies <= this.firstPageSize) {
                this.expandCount = totalReplies;
                return;
            }
            int i3 = this.expandCount;
            if (totalReplies == i3 + 1) {
                this.expandCount = i3 + 1;
            }
        }

        public final void f() {
            RFWLog.d("QzoneFeedProDetailCommentDataTransferUtils", RFWLog.USR, "reset pageSize:" + this.firstPageSize + ",commentId:" + this.comment.getId());
            this.expandCount = -1;
            this.pageIndex = 0;
        }

        public final void g(int totalReplies) {
            int min = Math.min(this.firstPageSize, totalReplies);
            this.expandCount = min;
            RFWLog.d("QzoneFeedProDetailCommentDataTransferUtils", RFWLog.USR, "setDefaultExpandCount count:" + min + ",commentId:" + this.comment.getId());
        }
    }

    n() {
    }

    private final int b(CommonComment comment, int totalReplies, ConcurrentHashMap<String, a> expandMap) {
        int i3;
        String id5 = comment.getId();
        if (expandMap == null || id5 == null) {
            i3 = 0;
        } else {
            a aVar = expandMap.get(id5);
            if (aVar != null && aVar.getExpandCount() != -1) {
                aVar.e(totalReplies);
            } else {
                aVar = new a(comment);
                aVar.g(totalReplies);
                expandMap.put(id5, aVar);
            }
            i3 = aVar.getExpandCount();
        }
        return Math.min(totalReplies, i3);
    }

    public final boolean c(CommonComment comment, ConcurrentHashMap<String, a> expandMap) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(expandMap, "expandMap");
        String id5 = comment.getId();
        if (id5 == null) {
            return false;
        }
        a aVar = expandMap.get(id5);
        if (aVar == null) {
            aVar = new a(comment);
            expandMap.put(id5, aVar);
        }
        int size = comment.getReplys().size();
        if (size <= aVar.getExpandCount()) {
            return false;
        }
        aVar.a(Math.min(aVar.getPageSize(), size - aVar.getExpandCount()));
        return true;
    }

    public final int d(CommonComment commonComment) {
        return com.qzone.reborn.configx.g.f53821a.b().P0();
    }

    public final int e(CommonComment commonComment) {
        return com.qzone.reborn.configx.g.f53821a.b().O0();
    }

    public final List<wd.c> g(ConcurrentHashMap<String, a> expandMap, CommonFeed data, wd.b adData) {
        List<CommonComment> comments;
        ArrayList arrayList = new ArrayList();
        if (data == null) {
            return arrayList;
        }
        CommonCellComment cellComment = data.getCellComment();
        if (cellComment != null && (comments = cellComment.getComments()) != null) {
            if (bl.b(comments)) {
                comments = null;
            }
            if (comments != null) {
                QLog.i("QzoneFeedProDetailCommentDataTransferUtils", 1, "transferCommentReplyListData() addComment size = " + comments.size());
                int i3 = 0;
                for (Object obj : comments) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    f54347a.a(data, arrayList, (CommonComment) obj, i3, expandMap);
                    i3 = i16;
                }
            }
        }
        f(arrayList, data, adData);
        return arrayList;
    }

    private final void a(CommonFeed data, List<wd.c> infoList, CommonComment comment, int commentPos, ConcurrentHashMap<String, a> expandMap) {
        List take;
        a aVar;
        if (comment == null) {
            return;
        }
        wd.c cVar = new wd.c(101, comment);
        cVar.i(data);
        cVar.j(commentPos);
        infoList.add(cVar);
        List<CommonReply> replys = comment.getReplys();
        if (bl.b(replys)) {
            replys = null;
        }
        if (replys != null) {
            int b16 = f54347a.b(comment, replys.size(), expandMap);
            take = CollectionsKt___CollectionsKt.take(replys, b16);
            int i3 = 0;
            int i16 = 0;
            for (Object obj : take) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                wd.c cVar2 = new wd.c(102, comment);
                cVar2.i(data);
                cVar2.j(commentPos);
                cVar2.l((CommonReply) obj);
                cVar2.m(i16);
                infoList.add(cVar2);
                i16 = i17;
            }
            boolean z16 = comment.getHasMoreReply() != null && Intrinsics.areEqual(comment.getHasMoreReply(), Boolean.TRUE);
            if ((replys.size() > f54347a.e(comment)) || z16) {
                wd.c cVar3 = new wd.c(103, comment);
                cVar3.i(data);
                cVar3.j(commentPos);
                cVar3.n(b16);
                if (expandMap != null && (aVar = expandMap.get(String.valueOf(comment.getId()))) != null) {
                    i3 = aVar.getPageIndex();
                }
                cVar3.k(i3);
                infoList.add(cVar3);
            }
        }
    }

    private final void f(List<wd.c> list, CommonFeed data, wd.b adData) {
        CommonCellComment cellComment;
        List<CommonComment> comments;
        Object m476constructorimpl;
        int i3;
        List<CommonComment> comments2;
        if (data == null || adData == null || (cellComment = data.getCellComment()) == null || (comments = cellComment.getComments()) == null) {
            return;
        }
        int index = adData.getIndex();
        if (index >= 0 && index <= comments.size()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                CommonCellComment cellComment2 = data.getCellComment();
                int i16 = 0;
                if (cellComment2 != null && (comments2 = cellComment2.getComments()) != null) {
                    i3 = 0;
                    for (Object obj : comments2) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        CommonComment commonComment = (CommonComment) obj;
                        if (i16 >= index) {
                            break;
                        }
                        i3 += commonComment.getReplys().size() + 1;
                        i16 = i17;
                    }
                    i16 = i3;
                }
                i3 = i16;
                list.add(i3, adData);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Result.m475boximpl(m476constructorimpl);
            return;
        }
        QLog.e("QzoneFeedProDetailCommentDataTransferUtils", 1, "targetCommentIndex invalid, return");
    }
}
