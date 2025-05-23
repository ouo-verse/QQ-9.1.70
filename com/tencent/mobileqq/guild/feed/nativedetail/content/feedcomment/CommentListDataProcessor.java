package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNextPageRepliesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import hl1.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import jl1.CommentCommonInfo;
import jl1.b;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import ll1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 $2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u0006J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u0002J\u0014\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160!J\u0006\u0010$\u001a\u00020\u0002J\u0014\u0010%\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160!J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0010J \u0010*\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\fJ \u0010,\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020\fJ\u0016\u0010/\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-J\u0016\u00100\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010.\u001a\u00020-J\u000e\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0016J\u001e\u00106\u001a\u00020\f2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u000eJ\u000e\u00108\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0004J\u000e\u00109\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0010J\u0006\u0010:\u001a\u00020\fJ\u000e\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0004J\u0016\u0010?\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010>\u001a\u00020=J\u0016\u0010A\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0006J\u0016\u0010B\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010C\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0010J\u001c\u0010D\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010E\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010F\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010G\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00160H8\u0006\u00a2\u0006\f\n\u0004\b#\u0010I\u001a\u0004\bJ\u0010KR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00160H8\u0006\u00a2\u0006\f\n\u0004\b<\u0010I\u001a\u0004\bM\u0010KR\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020=0H8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010I\u001a\u0004\bO\u0010KR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020'0H8\u0006\u00a2\u0006\f\n\u0004\b \u0010I\u001a\u0004\bQ\u0010K\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/CommentListDataProcessor;", "", "", "E", "Ljl1/b;", "commentItemData", "", "expandCount", "k", "groupPosition", h.F, "hostItemPosition", "", "c", "", "idd", "Ljl1/h;", "o", "l", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetNextPageRepliesRsp;", "rsp", "L", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "stComment", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "replyItemData", DomainData.DOMAIN_NAME, "position", "y", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "d", "", "list", "a", "e", "M", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "netReplyInfo", "isSuccess", "J", "netCommentInfo", "G", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;", "likeInfo", "H", "K", "commentInfo", BdhLogUtil.LogTag.Tag_Conn, "hostCommentIdd", "replyItem", "targetReplyId", "D", "itemData", "f", "g", UserInfo.SEX_FEMALE, "topCommentData", "b", "Lhl1/g;", "contentData", "I", "maxExpandCount", "i", "j", "t", "r", ReportConstant.COSTREPORT_PREFIX, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "stCommentList", "B", "topStCommentList", "w", "flatCommentList", "getLocalInsertReplyList", "localInsertReplyList", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CommentListDataProcessor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GProStComment> stCommentList = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GProStComment> topStCommentList = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> flatCommentList = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GProStReply> localInsertReplyList = new CopyOnWriteArrayList();

    private final void E() {
        int itemGroupPosition;
        List<g> list = this.flatCommentList;
        ArrayList<b> arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof b) {
                arrayList.add(obj);
            }
        }
        for (b bVar : arrayList) {
            CommentCommonInfo commonInfo = bVar.getCommonInfo();
            Iterator<GProStComment> it = this.stCommentList.iterator();
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(bVar.getCommentData(), it.next())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            Integer valueOf = Integer.valueOf(i3);
            if (valueOf.intValue() >= 0) {
                z16 = true;
            }
            if (!Boolean.valueOf(z16).booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                itemGroupPosition = valueOf.intValue();
            } else {
                itemGroupPosition = bVar.getCommonInfo().getItemGroupPosition();
            }
            commonInfo.g(itemGroupPosition);
        }
    }

    private final void L(GProGetNextPageRepliesRsp rsp, b commentItemData) {
        int collectionSizeOrDefault;
        List<GProStReply> list = this.localInsertReplyList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((GProStReply) it.next()).idd);
        }
        ArrayList<GProStReply> arrayList2 = rsp.replies;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.replies");
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (!arrayList.contains(((GProStReply) obj).idd)) {
                arrayList3.add(obj);
            }
        }
        commentItemData.getCommentData().attachInfo = rsp.attachInfo;
        commentItemData.getCommentData().replyCount = rsp.totalReplyCount;
        commentItemData.getCommentData().vecReplyList.addAll(arrayList3);
        commentItemData.getCommentData().nextPageReply = rsp.hasMore;
        commentItemData.h(new CommentCommonInfo(rsp.totalReplyCount, commentItemData.getCommentData().vecReplyList.size(), commentItemData.getCommentData().vecReplyList.size(), commentItemData.getCommonInfo().getItemGroupPosition(), rsp.hasMore));
    }

    private final boolean c(int hostItemPosition) {
        if (hostItemPosition >= 0 && hostItemPosition <= this.flatCommentList.size() && (this.flatCommentList.get(hostItemPosition) instanceof b)) {
            return true;
        }
        QLog.e("CommentListDataProcessor", 1, "checkHostPosValid error, hostPos:" + hostItemPosition + ", listSize:" + this.flatCommentList.size());
        return false;
    }

    private final void h(final int groupPosition) {
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.flatCommentList, (Function1) new Function1<g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.CommentListDataProcessor$deleteReplyList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it instanceof jl1.h) && ((jl1.h) it).getCommonInfo().getItemGroupPosition() == groupPosition);
            }
        });
    }

    private final void k(b commentItemData, int expandCount) {
        List<GProStReply> replyList;
        int collectionSizeOrDefault;
        Object obj;
        int i3;
        if (expandCount == -1) {
            replyList = commentItemData.getCommentData().vecReplyList;
        } else {
            replyList = commentItemData.getCommentData().vecReplyList.subList(0, expandCount);
        }
        commentItemData.getCommonInfo().f(replyList.size());
        ArrayList<jl1.h> f16 = commentItemData.f();
        Intrinsics.checkNotNullExpressionValue(replyList, "replyList");
        List<GProStReply> list = replyList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (GProStReply stReply : list) {
            Intrinsics.checkNotNullExpressionValue(stReply, "stReply");
            int indexOf = commentItemData.getCommentData().vecReplyList.indexOf(stReply);
            CommentCommonInfo commonInfo = commentItemData.getCommonInfo();
            Iterator<T> it = f16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((jl1.h) obj).getReplyData(), stReply)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            jl1.h hVar = (jl1.h) obj;
            if (hVar != null) {
                i3 = hVar.getSendStatus();
            } else {
                i3 = 0;
            }
            arrayList.add(new jl1.h(stReply, indexOf, commonInfo, i3));
        }
        commentItemData.f().clear();
        commentItemData.f().addAll(arrayList);
        List<g> list2 = this.flatCommentList;
        list2.addAll(list2.indexOf(commentItemData) + 1, arrayList);
    }

    private final b l(String idd) {
        int m3 = m(idd);
        if (m3 == -1) {
            return null;
        }
        g gVar = this.flatCommentList.get(m3);
        Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.data.CommentItemData");
        return (b) gVar;
    }

    private final b n(jl1.h replyItemData) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.flatCommentList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                g gVar = (g) obj;
                if ((gVar instanceof b) && Intrinsics.areEqual(replyItemData.getCommonInfo(), ((b) gVar).getCommonInfo())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (!(obj instanceof b)) {
            return null;
        }
        return (b) obj;
    }

    private final jl1.h o(String idd) {
        int p16 = p(idd);
        if (p16 == -1) {
            return null;
        }
        g gVar = this.flatCommentList.get(p16);
        Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.data.ReplyItemData");
        return (jl1.h) gVar;
    }

    private final int q(String idd, GProStComment stComment) {
        Iterator<GProStReply> it = stComment.vecReplyList.iterator();
        while (it.hasNext()) {
            GProStReply next = it.next();
            if (Intrinsics.areEqual(next.idd, idd)) {
                return stComment.vecReplyList.indexOf(next);
            }
        }
        return -1;
    }

    @NotNull
    public final List<GProStComment> A() {
        return this.stCommentList;
    }

    @NotNull
    public final List<GProStComment> B() {
        return this.topStCommentList;
    }

    public final void C(@NotNull GProStComment commentInfo) {
        Object firstOrNull;
        int i3;
        int size;
        boolean z16;
        Intrinsics.checkNotNullParameter(commentInfo, "commentInfo");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.stCommentList);
        GProStComment gProStComment = (GProStComment) firstOrNull;
        boolean z17 = false;
        if (gProStComment != null && gProStComment.isTop) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        this.stCommentList.add(i3, commentInfo);
        Iterator<g> it = this.flatCommentList.iterator();
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                g next = it.next();
                if ((next instanceof b) && !((b) next).getCommentData().isTop) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        Integer valueOf = Integer.valueOf(i16);
        if (valueOf.intValue() >= 0) {
            z17 = true;
        }
        if (!z17) {
            valueOf = null;
        }
        if (valueOf != null) {
            size = valueOf.intValue();
        } else {
            size = this.flatCommentList.size();
        }
        this.flatCommentList.add(size, new b(commentInfo, 1, new CommentCommonInfo(0, 0, 0, i3, false), null, 0L, 24, null));
        E();
        Logger.f235387a.d().i("CommentListDataProcessor", 1, "insertSendingCommentItem, sendingComment: " + i3);
    }

    public final boolean D(@NotNull String hostCommentIdd, @NotNull GProStReply replyItem, @NotNull String targetReplyId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(hostCommentIdd, "hostCommentIdd");
        Intrinsics.checkNotNullParameter(replyItem, "replyItem");
        Intrinsics.checkNotNullParameter(targetReplyId, "targetReplyId");
        QLog.d("CommentListDataProcessor", 1, "insertSendingReplyItem hostCommentIdd=" + hostCommentIdd + ", targetReplyId=" + targetReplyId);
        b l3 = l(hostCommentIdd);
        if (l3 == null) {
            return false;
        }
        QLog.d("CommentListDataProcessor", 1, "insertSendingReplyItem hostPosition=" + this.flatCommentList.indexOf(l3));
        b f16 = a.f(l3);
        f16.h(new CommentCommonInfo(l3.getCommonInfo().getTotalReplyCount() + 1, l3.getCommonInfo().getLocalReplyListCount() + 1, l3.getCommonInfo().getExpandReplyListCount() + 1, l3.getCommonInfo().getItemGroupPosition(), l3.getCommonInfo().getNextPageReply()));
        f16.getCommentData().replyCount++;
        List<g> list = this.flatCommentList;
        list.set(list.indexOf(l3), f16);
        int q16 = q(targetReplyId, f16.getCommentData()) + 1;
        f16.getCommentData().vecReplyList.add(q16, replyItem);
        f16.f().add(q16, new jl1.h(replyItem, q16, f16.getCommonInfo(), 1));
        List<g> list2 = this.flatCommentList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            g gVar = (g) obj;
            if ((gVar instanceof jl1.h) && ((jl1.h) gVar).getCommonInfo().getItemGroupPosition() == f16.getCommonInfo().getItemGroupPosition()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        QLog.d("CommentListDataProcessor", 1, "insertPos = " + q16 + ", preFlatReplySize = " + size);
        h(f16.getCommonInfo().getItemGroupPosition());
        k(f16, size + 1);
        return true;
    }

    public final boolean F() {
        Object firstOrNull;
        Object firstOrNull2;
        final b bVar;
        Object firstOrNull3;
        boolean z16;
        int size;
        boolean z17;
        Object first;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.topStCommentList);
        GProStComment gProStComment = (GProStComment) firstOrNull;
        if (gProStComment != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.flatCommentList);
            Integer num = null;
            if (firstOrNull2 instanceof b) {
                bVar = (b) firstOrNull2;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return false;
            }
            if (Intrinsics.areEqual(bVar.getCommentData(), gProStComment)) {
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.stCommentList);
                if (!Intrinsics.areEqual(firstOrNull3, gProStComment)) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.stCommentList);
                    QLog.i("CommentListDataProcessor", 1, "removeTopComment error2, data:" + first + ", unTop:" + gProStComment);
                    return false;
                }
                this.topStCommentList.clear();
                this.stCommentList.remove(0);
                CollectionsKt__MutableCollectionsKt.removeAll((List) this.flatCommentList, (Function1) new Function1<g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.CommentListDataProcessor$removeTopComment$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull g it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it, b.this) || ((it instanceof jl1.h) && ((jl1.h) it).getCommonInfo().getItemGroupPosition() == b.this.getCommonInfo().getItemGroupPosition()));
                    }
                });
                E();
                int indexOf = this.stCommentList.indexOf(gProStComment);
                int i3 = -1;
                if (indexOf == -1) {
                    QLog.i("CommentListDataProcessor", 1, "removeTopComment error3, data:" + this.stCommentList);
                    return false;
                }
                List<g> list = this.flatCommentList;
                ListIterator<g> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    g previous = listIterator.previous();
                    if ((previous instanceof b) && ((b) previous).getCommonInfo().getItemGroupPosition() == indexOf + 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        i3 = listIterator.nextIndex();
                        break;
                    }
                }
                Integer valueOf = Integer.valueOf(i3);
                if (valueOf.intValue() >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    num = valueOf;
                }
                if (num != null) {
                    size = num.intValue();
                } else {
                    size = this.flatCommentList.size();
                }
                gProStComment.isTop = false;
                b bVar2 = new b(gProStComment, 0, new CommentCommonInfo(gProStComment.replyCount, gProStComment.vecReplyList.size(), 0, indexOf, gProStComment.nextPageReply), null, Random.INSTANCE.nextLong(), 10, null);
                this.flatCommentList.add(size, bVar2);
                if (bVar2.getCommentData().vecReplyList.size() > 0) {
                    k(bVar2, 1);
                }
                E();
                return true;
            }
            QLog.i("CommentListDataProcessor", 1, "removeTopComment error1, data:" + bVar.getCommentData() + ", unTop:" + gProStComment);
            return false;
        }
        return false;
    }

    public final boolean G(@NotNull String idd, @Nullable GProStComment netCommentInfo, boolean isSuccess) {
        String str;
        long j3;
        Intrinsics.checkNotNullParameter(idd, "idd");
        b l3 = l(idd);
        if (l3 == null) {
            return false;
        }
        if (isSuccess) {
            GProStComment commentData = l3.getCommentData();
            if (netCommentInfo != null) {
                str = netCommentInfo.idd;
            } else {
                str = null;
            }
            commentData.idd = str;
            GProStComment commentData2 = l3.getCommentData();
            long j16 = 0;
            if (netCommentInfo != null) {
                j3 = netCommentInfo.createTime;
            } else {
                j3 = 0;
            }
            commentData2.createTime = j3;
            GProStComment commentData3 = l3.getCommentData();
            if (netCommentInfo != null) {
                j16 = netCommentInfo.sequence;
            }
            commentData3.sequence = j16;
            l3.i(0);
            return true;
        }
        l3.i(2);
        return true;
    }

    public final void H(@NotNull b commentItemData, @NotNull GProStLike likeInfo) {
        Intrinsics.checkNotNullParameter(commentItemData, "commentItemData");
        Intrinsics.checkNotNullParameter(likeInfo, "likeInfo");
        if (Intrinsics.areEqual(commentItemData.getCommentData().idd, likeInfo.idd)) {
            commentItemData.getCommentData().likeInfo = likeInfo;
            return;
        }
        QLog.e("CommentListDataProcessor", 1, "updateCommentItemPreferStatus error, itemIdd:" + commentItemData.getCommentData().idd + ", likeInfoIdd:" + likeInfo.idd);
    }

    public final boolean I(@NotNull GProGetNextPageRepliesRsp rsp, @NotNull g contentData) {
        int i3;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        boolean z16 = contentData instanceof b;
        if (z16) {
            i3 = this.flatCommentList.indexOf(contentData);
        } else {
            if (contentData instanceof jl1.h) {
                b n3 = n((jl1.h) contentData);
                if (!(n3 instanceof g)) {
                    n3 = null;
                }
                if (n3 != null) {
                    i3 = this.flatCommentList.indexOf(n3);
                }
            }
            i3 = -1;
        }
        if (!c(i3)) {
            return false;
        }
        g gVar = this.flatCommentList.get(i3);
        Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.data.CommentItemData");
        b bVar = (b) gVar;
        if (z16) {
            this.flatCommentList.set(i3, a.f(bVar));
            g gVar2 = this.flatCommentList.get(i3);
            Intrinsics.checkNotNull(gVar2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.data.CommentItemData");
            bVar = (b) gVar2;
        }
        L(rsp, bVar);
        h(bVar.getCommonInfo().getItemGroupPosition());
        k(bVar, -1);
        return true;
    }

    public final boolean J(@NotNull String idd, @Nullable GProStReply netReplyInfo, boolean isSuccess) {
        String str;
        long j3;
        Intrinsics.checkNotNullParameter(idd, "idd");
        jl1.h o16 = o(idd);
        if (o16 == null) {
            return false;
        }
        if (isSuccess) {
            GProStReply replyData = o16.getReplyData();
            String str2 = null;
            if (netReplyInfo != null) {
                str = netReplyInfo.idd;
            } else {
                str = null;
            }
            replyData.idd = str;
            GProStLike gProStLike = o16.getReplyData().likeInfo;
            if (netReplyInfo != null) {
                str2 = netReplyInfo.idd;
            }
            gProStLike.idd = str2;
            GProStReply replyData2 = o16.getReplyData();
            if (netReplyInfo != null) {
                j3 = netReplyInfo.createTime;
            } else {
                j3 = 0;
            }
            replyData2.createTime = j3;
            o16.h(0);
            this.localInsertReplyList.add(o16.getReplyData());
            return true;
        }
        o16.h(2);
        return true;
    }

    public final void K(@NotNull jl1.h replyItemData, @NotNull GProStLike likeInfo) {
        Intrinsics.checkNotNullParameter(replyItemData, "replyItemData");
        Intrinsics.checkNotNullParameter(likeInfo, "likeInfo");
        if (Intrinsics.areEqual(replyItemData.getReplyData().idd, likeInfo.idd)) {
            replyItemData.getReplyData().likeInfo = likeInfo;
            return;
        }
        QLog.e("CommentListDataProcessor", 1, "updateCommentItemPreferStatus error, itemIdd:" + replyItemData.getReplyData().idd + ", likeInfoIdd:" + likeInfo.idd);
    }

    public final void M(@NotNull List<GProStComment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.topStCommentList.addAll(list);
    }

    public final void a(@NotNull List<GProStComment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.stCommentList.addAll(list);
    }

    public final boolean b(@NotNull final b topCommentData) {
        List listOf;
        Intrinsics.checkNotNullParameter(topCommentData, "topCommentData");
        if (!c(this.flatCommentList.indexOf(topCommentData))) {
            return false;
        }
        F();
        GProStComment commentData = topCommentData.getCommentData();
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.flatCommentList, (Function1) new Function1<g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.CommentListDataProcessor$addTopComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it, b.this) || ((it instanceof jl1.h) && ((jl1.h) it).getCommonInfo().getItemGroupPosition() == b.this.getCommonInfo().getItemGroupPosition()));
            }
        });
        List<GProStComment> list = this.topStCommentList;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(commentData);
        list.addAll(listOf);
        this.stCommentList.add(0, commentData);
        commentData.isTop = true;
        b bVar = new b(commentData, 0, new CommentCommonInfo(commentData.replyCount, commentData.vecReplyList.size(), 0, 0, commentData.nextPageReply), null, Random.INSTANCE.nextLong(), 10, null);
        this.flatCommentList.add(0, bVar);
        if (bVar.getCommentData().vecReplyList.size() > 0) {
            k(bVar, 1);
        }
        E();
        return true;
    }

    public final void d() {
        this.stCommentList.clear();
    }

    public final void e() {
        this.topStCommentList.clear();
    }

    public final boolean f(@NotNull final b itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (c(this.flatCommentList.indexOf(itemData))) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.topStCommentList, (Function1) new Function1<GProStComment, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.CommentListDataProcessor$deleteCommentItem$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull GProStComment it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it, b.this.getCommentData()));
                }
            });
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.stCommentList, (Function1) new Function1<GProStComment, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.CommentListDataProcessor$deleteCommentItem$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull GProStComment it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it, b.this.getCommentData()));
                }
            });
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.flatCommentList, (Function1) new Function1<g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.CommentListDataProcessor$deleteCommentItem$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull g it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it, b.this) || ((it instanceof jl1.h) && ((jl1.h) it).getCommonInfo().getItemGroupPosition() == b.this.getCommonInfo().getItemGroupPosition()));
                }
            });
            E();
            return true;
        }
        return false;
    }

    public final boolean g(@NotNull jl1.h itemData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        b n3 = n(itemData);
        int i3 = 0;
        if (n3 == null) {
            return false;
        }
        b f16 = a.f(n3);
        f16.h(new CommentCommonInfo(n3.getCommonInfo().getTotalReplyCount() - 1, n3.getCommonInfo().getLocalReplyListCount() - 1, n3.getCommonInfo().getExpandReplyListCount() - 1, n3.getCommonInfo().getItemGroupPosition(), n3.getCommonInfo().getNextPageReply()));
        f16.getCommentData().replyCount--;
        f16.getCommentData().vecReplyList.remove(itemData.getReplyData());
        List<g> list = this.flatCommentList;
        list.set(list.indexOf(n3), f16);
        List<g> list2 = this.flatCommentList;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            int i16 = 0;
            for (g gVar : list2) {
                if ((gVar instanceof jl1.h) && ((jl1.h) gVar).getCommonInfo().getItemGroupPosition() == n3.getCommonInfo().getItemGroupPosition()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (i16 = i16 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
            i3 = i16;
        }
        QLog.d("CommentListDataProcessor", 1, "after update, preFlatReplySize = " + i3);
        h(n3.getCommonInfo().getItemGroupPosition());
        int i17 = i3 - 1;
        if (i17 >= 1) {
            k(f16, i17);
        }
        return true;
    }

    public final boolean i(@NotNull b commentItemData, int maxExpandCount) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(commentItemData, "commentItemData");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(commentItemData.getCommentData().vecReplyList.size(), maxExpandCount);
        b f16 = a.f(commentItemData);
        f16.h(new CommentCommonInfo(commentItemData.getCommonInfo().getTotalReplyCount(), commentItemData.getCommonInfo().getLocalReplyListCount(), coerceAtMost, commentItemData.getCommonInfo().getItemGroupPosition(), commentItemData.getCommonInfo().getNextPageReply()));
        int indexOf = this.flatCommentList.indexOf(commentItemData);
        if (indexOf != -1) {
            this.flatCommentList.set(indexOf, f16);
        }
        h(f16.getCommonInfo().getItemGroupPosition());
        k(f16, coerceAtMost);
        return true;
    }

    public final boolean j(@NotNull jl1.h replyItemData, int maxExpandCount) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(replyItemData, "replyItemData");
        b n3 = n(replyItemData);
        if (n3 != null) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(maxExpandCount + replyItemData.getReplyListPosition() + 1, n3.getCommentData().vecReplyList.size());
            n3.h(new CommentCommonInfo(n3.getCommonInfo().getTotalReplyCount(), n3.getCommonInfo().getLocalReplyListCount(), coerceAtMost, n3.getCommonInfo().getItemGroupPosition(), n3.getCommonInfo().getNextPageReply()));
            h(replyItemData.getCommonInfo().getItemGroupPosition());
            k(n3, coerceAtMost);
            return true;
        }
        return false;
    }

    public final int m(@NotNull String idd) {
        Intrinsics.checkNotNullParameter(idd, "idd");
        for (g gVar : this.flatCommentList) {
            if ((gVar instanceof b) && Intrinsics.areEqual(((b) gVar).getCommentData().idd, idd)) {
                return this.flatCommentList.indexOf(gVar);
            }
        }
        return -1;
    }

    public final int p(@NotNull String idd) {
        Intrinsics.checkNotNullParameter(idd, "idd");
        for (g gVar : this.flatCommentList) {
            if ((gVar instanceof jl1.h) && Intrinsics.areEqual(((jl1.h) gVar).getReplyData().idd, idd)) {
                return this.flatCommentList.indexOf(gVar);
            }
        }
        return -1;
    }

    public final void r(@NotNull List<GProStComment> list, int maxExpandCount) {
        Intrinsics.checkNotNullParameter(list, "list");
        QLog.d("CommentListDataProcessor", 1, "flatLoadMoreCommentList, data size = " + list.size());
        int size = this.stCommentList.size() - list.size();
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GProStComment gProStComment = (GProStComment) obj;
            if (gProStComment.isTop) {
                QLog.i("CommentListDataProcessor", 1, "flatLoadMoreCommentList, skip top item");
            } else {
                b bVar = new b(gProStComment, 0, new CommentCommonInfo(gProStComment.replyCount, gProStComment.vecReplyList.size(), 0, size + i3, gProStComment.nextPageReply), null, 0L, 26, null);
                this.flatCommentList.add(bVar);
                if (bVar.getCommentData().vecReplyList.size() > 0) {
                    k(bVar, maxExpandCount);
                    i3 = i16;
                }
            }
            i3 = i16;
        }
        QLog.d("CommentListDataProcessor", 1, "after flat, data size = " + this.stCommentList.size());
    }

    public final void s(int maxExpandCount) {
        int coerceAtMost;
        QLog.d("CommentListDataProcessor", 1, "start flat, data size = " + this.stCommentList.size());
        this.flatCommentList.clear();
        int i3 = 0;
        for (Object obj : this.stCommentList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GProStComment gProStComment = (GProStComment) obj;
            if (i3 != 0 && gProStComment.isTop) {
                QLog.i("CommentListDataProcessor", 1, "flatLocalCommentList, skip top item");
            } else {
                b bVar = new b(gProStComment, 0, new CommentCommonInfo(gProStComment.replyCount, gProStComment.vecReplyList.size(), 0, i3, gProStComment.nextPageReply), null, 0L, 26, null);
                this.flatCommentList.add(bVar);
                if (bVar.getCommentData().vecReplyList.size() > 0) {
                    Logger.f235387a.d().d("CommentListDataProcessor", 1, "showReplyListNum:" + gProStComment.showReplyListNum);
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(Math.max(maxExpandCount, gProStComment.showReplyListNum), gProStComment.vecReplyList.size());
                    k(bVar, coerceAtMost);
                    i3 = i16;
                }
            }
            i3 = i16;
        }
        QLog.d("CommentListDataProcessor", 1, "after flat, data size = " + this.stCommentList.size());
    }

    public final boolean t(@NotNull jl1.h replyItemData) {
        Intrinsics.checkNotNullParameter(replyItemData, "replyItemData");
        b n3 = n(replyItemData);
        if (n3 == null) {
            return false;
        }
        n3.h(new CommentCommonInfo(n3.getCommonInfo().getTotalReplyCount(), n3.getCommonInfo().getLocalReplyListCount(), 1, n3.getCommonInfo().getItemGroupPosition(), n3.getCommonInfo().getNextPageReply()));
        h(replyItemData.getCommonInfo().getItemGroupPosition());
        k(n3, 1);
        return true;
    }

    @Nullable
    public final b u(int position) {
        if (position >= this.flatCommentList.size() || !(this.flatCommentList.get(position) instanceof b)) {
            return null;
        }
        g gVar = this.flatCommentList.get(position);
        Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.data.CommentItemData");
        return (b) gVar;
    }

    public final int v(@NotNull String idd) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(idd, "idd");
        Iterator<T> it = this.flatCommentList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                g gVar = (g) obj;
                if ((gVar instanceof b) && Intrinsics.areEqual(((b) gVar).getCommentData().idd, idd)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        g gVar2 = (g) obj;
        if (gVar2 == null) {
            return -1;
        }
        return this.flatCommentList.indexOf(gVar2);
    }

    @NotNull
    public final List<g> w() {
        return this.flatCommentList;
    }

    public final int x(@NotNull jl1.h replyItemData) {
        Intrinsics.checkNotNullParameter(replyItemData, "replyItemData");
        return this.stCommentList.get(replyItemData.getCommonInfo().getItemGroupPosition()).vecReplyList.size();
    }

    @Nullable
    public final jl1.h y(int position) {
        if (position >= this.flatCommentList.size() || !(this.flatCommentList.get(position) instanceof jl1.h)) {
            return null;
        }
        g gVar = this.flatCommentList.get(position);
        Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.data.ReplyItemData");
        return (jl1.h) gVar;
    }

    public final int z(@NotNull String idd) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(idd, "idd");
        Iterator<T> it = this.flatCommentList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                g gVar = (g) obj;
                if ((gVar instanceof jl1.h) && Intrinsics.areEqual(((jl1.h) gVar).getReplyData().idd, idd)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        g gVar2 = (g) obj;
        if (gVar2 == null) {
            return -1;
        }
        return this.flatCommentList.indexOf(gVar2);
    }
}
