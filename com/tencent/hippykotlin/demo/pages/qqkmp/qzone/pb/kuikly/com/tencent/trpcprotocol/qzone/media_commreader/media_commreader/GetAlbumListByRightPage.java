package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetAlbumListByRightPage;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "album", "Ljava/util/List;", "", "attachInfo", "Ljava/lang/String;", "", "hasMore", "Ljava/lang/Boolean;", "", WidgetCacheConstellationData.NUM, "Ljava/lang/Long;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GetAlbumListByRightPage extends j {
    public static final int $stable = 8;
    public final List<AlbumInfo> album;
    public String attachInfo;
    public Boolean hasMore;
    public Long num;

    public GetAlbumListByRightPage() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new GetAlbumListByRightPage(null, null, null, null, 15, null));
    }

    public /* synthetic */ GetAlbumListByRightPage(List list, String str, Boolean bool, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : l3);
    }

    public GetAlbumListByRightPage(List<AlbumInfo> list, String str, Boolean bool, Long l3) {
        this.album = list;
        this.attachInfo = str;
        this.hasMore = bool;
        this.num = l3;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        Long l3 = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.album, new b.f(new b.d(new AlbumInfo(null, null, null, null, null, l3, l3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null)), false))), TuplesKt.to(2, new h(2, this.attachInfo, new b.e.g(true))), TuplesKt.to(3, new h(3, this.hasMore, new b.e.a(true))), TuplesKt.to(4, new h(4, this.num, new b.e.i(true))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            List<AlbumInfo> list = this.album;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
        } else if (fieldNumber == 2) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
            this.attachInfo = (String) v3;
        } else if (fieldNumber == 3) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
            this.hasMore = (Boolean) v3;
        } else {
            if (fieldNumber != 4) {
                return;
            }
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
            this.num = (Long) v3;
        }
    }
}
