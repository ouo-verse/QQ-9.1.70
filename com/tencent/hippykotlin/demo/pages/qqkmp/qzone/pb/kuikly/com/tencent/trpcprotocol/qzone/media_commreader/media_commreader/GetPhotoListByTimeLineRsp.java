package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.PageEndMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.mobileqq.startup.step.InitSkin;
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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetPhotoListByTimeLineRsp;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "albumInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfo;", "batchList", "Ljava/util/List;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "medias", "", "attachInfo", "Ljava/lang/String;", "", "preHasMore", "Ljava/lang/Boolean;", "nextHasMore", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PageEndMsg;", "endMsg", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PageEndMsg;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PageEndMsg;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GetPhotoListByTimeLineRsp extends j {
    public AlbumInfo albumInfo;
    public String attachInfo;
    public final List<BatchInfo> batchList;
    public PageEndMsg endMsg;
    public final List<StMedia> medias;
    public Boolean nextHasMore;
    public Boolean preHasMore;

    public GetPhotoListByTimeLineRsp() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new GetPhotoListByTimeLineRsp(null, null, null, null, null, null, null, 127, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo");
                this.albumInfo = (AlbumInfo) v3;
                return;
            case 2:
                List<BatchInfo> list = this.batchList;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 3:
                List<StMedia> list2 = this.medias;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.attachInfo = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.preHasMore = (Boolean) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.nextHasMore = (Boolean) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.PageEndMsg");
                this.endMsg = (PageEndMsg) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ GetPhotoListByTimeLineRsp(AlbumInfo albumInfo, List list, List list2, String str, Boolean bool, Boolean bool2, PageEndMsg pageEndMsg, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : albumInfo, (i3 & 2) != 0 ? new ArrayList() : list, (i3 & 4) != 0 ? new ArrayList() : list2, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : bool, (i3 & 32) != 0 ? null : bool2, (i3 & 64) != 0 ? null : pageEndMsg);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.albumInfo, new b.d(new AlbumInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null)))), TuplesKt.to(2, new h(2, this.batchList, new b.f(new b.d(new BatchInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null)), false))), TuplesKt.to(3, new h(3, this.medias, new b.f(new b.d(new StMedia(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null)), false))), TuplesKt.to(4, new h(4, this.attachInfo, new b.e.g(true))), TuplesKt.to(5, new h(5, this.preHasMore, new b.e.a(true))), TuplesKt.to(6, new h(6, this.nextHasMore, new b.e.a(true))), TuplesKt.to(7, new h(7, this.endMsg, new b.d(new PageEndMsg(null, null, null, 7, null)))));
        return mapOf;
    }

    public GetPhotoListByTimeLineRsp(AlbumInfo albumInfo, List<BatchInfo> list, List<StMedia> list2, String str, Boolean bool, Boolean bool2, PageEndMsg pageEndMsg) {
        this.albumInfo = albumInfo;
        this.batchList = list;
        this.medias = list2;
        this.attachInfo = str;
        this.preHasMore = bool;
        this.nextHasMore = bool2;
        this.endMsg = pageEndMsg;
    }
}
