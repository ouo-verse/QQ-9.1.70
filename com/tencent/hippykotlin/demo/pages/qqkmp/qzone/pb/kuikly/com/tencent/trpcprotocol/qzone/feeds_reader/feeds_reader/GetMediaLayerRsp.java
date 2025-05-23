package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMediaLayerRsp;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "album", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "mediaList", "Ljava/util/List;", "curIndex", "I", "", "attachInfo", "Ljava/lang/String;", "", "prevHasMore", "Z", "nextHasMore", "total", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "ext", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;Ljava/util/List;ILjava/lang/String;ZZILcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GetMediaLayerRsp extends j {
    public static final int $stable = 8;
    public AlbumInfo album;
    public String attachInfo;
    public int curIndex;
    public StCommonExt ext;
    public final List<StMedia> mediaList;
    public boolean nextHasMore;
    public boolean prevHasMore;
    public int total;

    public GetMediaLayerRsp() {
        this(null, null, 0, null, false, false, 0, null, 255, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new GetMediaLayerRsp(null, null, 0, null, false, false, 0, null, 255, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo");
                this.album = (AlbumInfo) v3;
                return;
            case 2:
                List<StMedia> list = this.mediaList;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.curIndex = ((Integer) v3).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.attachInfo = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.prevHasMore = ((Boolean) v3).booleanValue();
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.nextHasMore = ((Boolean) v3).booleanValue();
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.total = ((Integer) v3).intValue();
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt");
                this.ext = (StCommonExt) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ GetMediaLayerRsp(AlbumInfo albumInfo, List list, int i3, String str, boolean z16, boolean z17, int i16, StCommonExt stCommonExt, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : albumInfo, (i17 & 2) != 0 ? new ArrayList() : list, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? "" : str, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? false : z17, (i17 & 64) == 0 ? i16 : 0, (i17 & 128) == 0 ? stCommonExt : null);
    }

    public GetMediaLayerRsp(AlbumInfo albumInfo, List<StMedia> list, int i3, String str, boolean z16, boolean z17, int i16, StCommonExt stCommonExt) {
        this.album = albumInfo;
        this.mediaList = list;
        this.curIndex = i3;
        this.attachInfo = str;
        this.prevHasMore = z16;
        this.nextHasMore = z17;
        this.total = i16;
        this.ext = stCommonExt;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.album, new b.d(new AlbumInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null)))), TuplesKt.to(2, new h(2, this.mediaList, new b.f(new b.d(new StMedia(null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null)), false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.curIndex), new b.e.h(false))), TuplesKt.to(4, new h(4, this.attachInfo, new b.e.g(false))), TuplesKt.to(5, new h(5, Boolean.valueOf(this.prevHasMore), new b.e.a(false))), TuplesKt.to(6, new h(6, Boolean.valueOf(this.nextHasMore), new b.e.a(false))), TuplesKt.to(7, new h(7, Integer.valueOf(this.total), new b.e.h(false))), TuplesKt.to(8, new h(8, this.ext, new b.d(new StCommonExt(null, null, null, null, 15, null)))));
        return mapOf;
    }
}
