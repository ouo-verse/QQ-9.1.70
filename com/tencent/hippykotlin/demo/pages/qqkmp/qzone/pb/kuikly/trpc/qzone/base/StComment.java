package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
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
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u00a7\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0011\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0014R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\rR \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StComment;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "id", "Ljava/lang/String;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StRichMsg;", "content", "Ljava/util/List;", "", "time", "Ljava/lang/Long;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StReply;", "replys", "replyNum", "clientKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "mediaItems", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLike;", "like", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLike;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/Entry;", "mapExt", "", "hasMoreReply", "Ljava/lang/Boolean;", "replyAttachInfo", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Ljava/util/List;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLike;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StComment extends j {
    public static final int $stable = 8;
    public String clientKey;
    public final List<StRichMsg> content;
    public Boolean hasMoreReply;
    public String id;
    public StLike like;
    public final List<Entry> mapExt;
    public final List<StMedia> mediaItems;
    public String replyAttachInfo;
    public Long replyNum;
    public final List<StReply> replys;
    public Long time;
    public StUser user;

    public StComment() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StComment(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.id = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.user = (StUser) v3;
                return;
            case 3:
                List<StRichMsg> list = this.content;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.time = (Long) v3;
                return;
            case 5:
                List<StReply> list2 = this.replys;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.replyNum = (Long) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.clientKey = (String) v3;
                return;
            case 8:
                List<StMedia> list3 = this.mediaItems;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) v3);
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLike");
                this.like = (StLike) v3;
                return;
            case 10:
                List<Entry> list4 = this.mapExt;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry>");
                CollectionsKt__MutableCollectionsKt.addAll(list4, (Sequence) v3);
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.hasMoreReply = (Boolean) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.replyAttachInfo = (String) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StComment(String str, StUser stUser, List list, Long l3, List list2, Long l16, String str2, List list3, StLike stLike, List list4, Boolean bool, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : stUser, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? null : l3, (i3 & 16) != 0 ? new ArrayList() : list2, (i3 & 32) != 0 ? null : l16, (i3 & 64) != 0 ? null : str2, (i3 & 128) != 0 ? new ArrayList() : list3, (i3 & 256) != 0 ? null : stLike, (i3 & 512) != 0 ? new ArrayList() : list4, (i3 & 1024) != 0 ? null : bool, (i3 & 2048) == 0 ? str3 : null);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.id, new b.e.g(true))), TuplesKt.to(2, new h(2, this.user, new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(3, new h(3, this.content, new b.f(new b.d(new StRichMsg(0, null, null, null, null, null, null, null, null, 511, null)), false))), TuplesKt.to(4, new h(4, this.time, new b.e.f(true))), TuplesKt.to(5, new h(5, this.replys, new b.f(new b.d(new StReply(null, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, null, null, null, 255, null)), false))), TuplesKt.to(6, new h(6, this.replyNum, new b.e.f(true))), TuplesKt.to(7, new h(7, this.clientKey, new b.e.g(true))), TuplesKt.to(8, new h(8, this.mediaItems, new b.f(new b.d(new StMedia(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null)), false))), TuplesKt.to(9, new h(9, this.like, new b.d(new StLike(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 63, null)))), TuplesKt.to(10, new h(10, this.mapExt, new b.f(new b.d(new Entry(null, null, null, null, 15, null)), false))), TuplesKt.to(11, new h(11, this.hasMoreReply, new b.e.a(true))), TuplesKt.to(12, new h(12, this.replyAttachInfo, new b.e.g(true))));
        return mapOf;
    }

    public StComment(String str, StUser stUser, List<StRichMsg> list, Long l3, List<StReply> list2, Long l16, String str2, List<StMedia> list3, StLike stLike, List<Entry> list4, Boolean bool, String str3) {
        this.id = str;
        this.user = stUser;
        this.content = list;
        this.time = l3;
        this.replys = list2;
        this.replyNum = l16;
        this.clientKey = str2;
        this.mediaItems = list3;
        this.like = stLike;
        this.mapExt = list4;
        this.hasMoreReply = bool;
        this.replyAttachInfo = str3;
    }
}
