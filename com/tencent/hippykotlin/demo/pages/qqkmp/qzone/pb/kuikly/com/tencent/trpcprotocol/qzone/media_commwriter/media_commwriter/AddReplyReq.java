package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/AddReplyReq;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "albumId", "Ljava/lang/String;", "mediaId", "", "batchId", "Ljava/lang/Long;", WSAutoShowCommentParams.KEY_COMMENT_ID, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StRichMsg;", "content", "Ljava/util/List;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/OperationCommentType;", "commentType", "Ljava/lang/Integer;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "albumOwner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "momentTime", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Ljava/lang/Integer;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class AddReplyReq extends j {
    public String albumId;
    public StUser albumOwner;
    public Long batchId;
    public String commentId;
    public Integer commentType;
    public final List<StRichMsg> content;
    public String mediaId;
    public Integer momentTime;

    public AddReplyReq() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new AddReplyReq(null, null, null, null, null, null, null, null, 255, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.albumId = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.mediaId = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.batchId = (Long) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.commentId = (String) v3;
                return;
            case 5:
                List<StRichMsg> list = this.content;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.Media_commwriterKt.OperationCommentType }");
                this.commentType = (Integer) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.albumOwner = (StUser) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.momentTime = (Integer) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ AddReplyReq(String str, String str2, Long l3, String str3, List list, Integer num, StUser stUser, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? new ArrayList() : list, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? null : stUser, (i3 & 128) == 0 ? num2 : null);
    }

    public AddReplyReq(String str, String str2, Long l3, String str3, List<StRichMsg> list, Integer num, StUser stUser, Integer num2) {
        this.albumId = str;
        this.mediaId = str2;
        this.batchId = l3;
        this.commentId = str3;
        this.content = list;
        this.commentType = num;
        this.albumOwner = stUser;
        this.momentTime = num2;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.albumId, new b.e.g(true))), TuplesKt.to(2, new h(2, this.mediaId, new b.e.g(true))), TuplesKt.to(3, new h(3, this.batchId, new b.e.f(true))), TuplesKt.to(4, new h(4, this.commentId, new b.e.g(true))), TuplesKt.to(5, new h(5, this.content, new b.f(new b.d(new StRichMsg(0, null, null, null, null, null, null, null, null, 511, null)), false))), TuplesKt.to(6, new h(6, this.commentType, new b.a(false))), TuplesKt.to(7, new h(7, this.albumOwner, new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(8, new h(8, this.momentTime, new b.e.h(true))));
        return mapOf;
    }
}
