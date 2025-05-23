package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00100\u000f\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumPageInfo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "albumNum", "Ljava/lang/Integer;", "photoNum", "videoNum", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumPageOpMask;", "masks", "Ljava/util/List;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/ToolBox;", "tools", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class AlbumPageInfo extends j {
    public static final int $stable = 8;
    public Integer albumNum;
    public final List<Integer> masks;
    public Integer photoNum;
    public final List<ToolBox> tools;
    public Integer videoNum;

    public AlbumPageInfo() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new AlbumPageInfo(null, null, null, null, null, 31, null));
    }

    public /* synthetic */ AlbumPageInfo(Integer num, Integer num2, Integer num3, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) == 0 ? num3 : null, (i3 & 8) != 0 ? new ArrayList() : list, (i3 & 16) != 0 ? new ArrayList() : list2);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.albumNum, new b.e.C0168e(true))), TuplesKt.to(2, new h(2, this.photoNum, new b.e.C0168e(true))), TuplesKt.to(3, new h(3, this.videoNum, new b.e.C0168e(true))), TuplesKt.to(4, new h(4, this.masks, new b.f(new b.a(false), false))), TuplesKt.to(5, new h(5, this.tools, new b.f(new b.d(new ToolBox(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)), false))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
            this.albumNum = (Integer) v3;
            return;
        }
        if (fieldNumber == 2) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
            this.photoNum = (Integer) v3;
            return;
        }
        if (fieldNumber == 3) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
            this.videoNum = (Integer) v3;
        } else if (fieldNumber == 4) {
            List<Integer> list = this.masks;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.Media_commreaderKt.AlbumPageOpMask }>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
        } else {
            if (fieldNumber != 5) {
                return;
            }
            List<ToolBox> list2 = this.tools;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.ToolBox>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
        }
    }

    public AlbumPageInfo(Integer num, Integer num2, Integer num3, List<Integer> list, List<ToolBox> list2) {
        this.albumNum = num;
        this.photoNum = num2;
        this.videoNum = num3;
        this.masks = list;
        this.tools = list2;
    }
}
