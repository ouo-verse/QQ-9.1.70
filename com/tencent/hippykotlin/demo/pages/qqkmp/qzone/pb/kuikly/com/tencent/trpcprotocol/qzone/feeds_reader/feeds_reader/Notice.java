package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.d;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\f\b\u0002\u0010\u000f\u001a\u00060\u0005j\u0002`\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u001b0\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u001a\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00060\u0005j\u0002`\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u001b0\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010\u001dR \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002000/8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Notice;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "noticeId", "Ljava/lang/String;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/NoticeType;", "noticeType", "I", "", WadlProxyConsts.CREATE_TIME, "J", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/NoticePattonInfo;", "noticePatton", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/NoticePattonInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeed;", "feed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeed;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/NoticeOperationMask;", "opMask", "Ljava/util/List;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "opUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/PattonAction;", "action", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/PattonAction;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "ext", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StComment;", "feedComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StReply;", "feedReply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StReply;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StRichMsg;", "noticeMessage", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;IJLcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/NoticePattonInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeed;Ljava/util/List;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/PattonAction;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StComment;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StReply;Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class Notice extends j {
    public PattonAction action;
    public long createTime;
    public StCommonExt ext;
    public StFeed feed;
    public StComment feedComment;
    public StReply feedReply;
    public String noticeId;
    public final List<StRichMsg> noticeMessage;
    public NoticePattonInfo noticePatton;
    public int noticeType;
    public final List<Integer> opMask;
    public StUser opUser;

    public Notice() {
        this(null, 0, 0L, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new Notice(null, 0, 0L, null, null, null, null, null, null, null, null, null, 4095, null));
    }

    public /* synthetic */ Notice(String str, int i3, long j3, NoticePattonInfo noticePattonInfo, StFeed stFeed, List list, StUser stUser, PattonAction pattonAction, StCommonExt stCommonExt, StComment stComment, StReply stReply, List list2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? d.c.f30317b.b().getValue() : i3, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? null : noticePattonInfo, (i16 & 16) != 0 ? null : stFeed, (i16 & 32) != 0 ? new ArrayList() : list, (i16 & 64) != 0 ? null : stUser, (i16 & 128) != 0 ? null : pattonAction, (i16 & 256) != 0 ? null : stCommonExt, (i16 & 512) != 0 ? null : stComment, (i16 & 1024) == 0 ? stReply : null, (i16 & 2048) != 0 ? new ArrayList() : list2);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.noticeId, new b.e.g(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.noticeType), new b.a(false))), TuplesKt.to(3, new h(3, Long.valueOf(this.createTime), new b.e.i(false))), TuplesKt.to(4, new h(4, this.noticePatton, new b.d(new NoticePattonInfo(0, null, null, 7, null)))), TuplesKt.to(5, new h(5, this.feed, new b.d(new StFeed(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null)))), TuplesKt.to(6, new h(6, this.opMask, new b.f(new b.a(false), true))), TuplesKt.to(7, new h(7, this.opUser, new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(8, new h(8, this.action, new b.d(new PattonAction(0, null, 3, null)))), TuplesKt.to(9, new h(9, this.ext, new b.d(new StCommonExt(null, null, null, null, 15, null)))), TuplesKt.to(10, new h(10, this.feedComment, new b.d(new StComment(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null)))), TuplesKt.to(11, new h(11, this.feedReply, new b.d(new StReply(null, null, null, null, null, null, null, null, 255, null)))), TuplesKt.to(12, new h(12, this.noticeMessage, new b.f(new b.d(new StRichMsg(0, null, null, null, null, null, null, null, null, 511, null)), false))));
        return mapOf;
    }

    public Notice(String str, int i3, long j3, NoticePattonInfo noticePattonInfo, StFeed stFeed, List<Integer> list, StUser stUser, PattonAction pattonAction, StCommonExt stCommonExt, StComment stComment, StReply stReply, List<StRichMsg> list2) {
        this.noticeId = str;
        this.noticeType = i3;
        this.createTime = j3;
        this.noticePatton = noticePattonInfo;
        this.feed = stFeed;
        this.opMask = list;
        this.opUser = stUser;
        this.action = pattonAction;
        this.ext = stCommonExt;
        this.feedComment = stComment;
        this.feedReply = stReply;
        this.noticeMessage = list2;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.noticeId = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.Feeds_readerKt.NoticeType }");
                this.noticeType = ((Integer) v3).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.createTime = ((Long) v3).longValue();
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.NoticePattonInfo");
                this.noticePatton = (NoticePattonInfo) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeed");
                this.feed = (StFeed) v3;
                return;
            case 6:
                List<Integer> list = this.opMask;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.Feeds_readerKt.NoticeOperationMask }>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.opUser = (StUser) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.PattonAction");
                this.action = (PattonAction) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt");
                this.ext = (StCommonExt) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment");
                this.feedComment = (StComment) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply");
                this.feedReply = (StReply) v3;
                return;
            case 12:
                List<StRichMsg> list2 = this.noticeMessage;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
                return;
            default:
                return;
        }
    }
}
