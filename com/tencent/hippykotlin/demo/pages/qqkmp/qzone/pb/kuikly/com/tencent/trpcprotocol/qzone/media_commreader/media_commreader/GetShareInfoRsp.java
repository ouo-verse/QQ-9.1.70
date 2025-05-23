package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StShare;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u000f0\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetShareInfoRsp;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StShare;", "share", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StShare;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/ShareButton;", "button", "Ljava/util/List;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "album", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "medias", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StShare;Ljava/util/List;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GetShareInfoRsp extends j {
    public AlbumInfo album;
    public final List<Integer> button;
    public final List<StMedia> medias;
    public StShare share;

    public GetShareInfoRsp() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new GetShareInfoRsp(null, null, null, null, 15, null));
    }

    public /* synthetic */ GetShareInfoRsp(StShare stShare, List list, AlbumInfo albumInfo, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : stShare, (i3 & 2) != 0 ? new ArrayList() : list, (i3 & 4) != 0 ? null : albumInfo, (i3 & 8) != 0 ? new ArrayList() : list2);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.share, new b.d(new StShare(null, null, null, null, null, null, 63, null)))), TuplesKt.to(2, new h(2, this.button, new b.f(new b.a(false), false))), TuplesKt.to(3, new h(3, this.album, new b.d(new AlbumInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null)))), TuplesKt.to(4, new h(4, this.medias, new b.f(new b.d(new StMedia(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null)), false))));
        return mapOf;
    }

    public GetShareInfoRsp(StShare stShare, List<Integer> list, AlbumInfo albumInfo, List<StMedia> list2) {
        this.share = stShare;
        this.button = list;
        this.album = albumInfo;
        this.medias = list2;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StShare");
            this.share = (StShare) v3;
            return;
        }
        if (fieldNumber == 2) {
            List<Integer> list = this.button;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.Media_commreaderKt.ShareButton }>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
        } else if (fieldNumber == 3) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo");
            this.album = (AlbumInfo) v3;
        } else {
            if (fieldNumber != 4) {
                return;
            }
            List<StMedia> list2 = this.medias;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
        }
    }
}
