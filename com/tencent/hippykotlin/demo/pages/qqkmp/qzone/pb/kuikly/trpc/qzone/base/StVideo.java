package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.app.AppConstants;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StVideo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "id", "Ljava/lang/String;", "url", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "cover", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "width", "Ljava/lang/Integer;", "height", "", QFSEdgeItem.KEY_VIDEO_TIME, "Ljava/lang/Long;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPicSpecUrlEntry;", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Ljava/util/List;", "size", "", "hasRaw", "Ljava/lang/Boolean;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StVideo extends j {
    public static final int $stable = 8;
    public StImage cover;
    public Boolean hasRaw;
    public Integer height;
    public String id;
    public Long size;
    public String url;
    public Long videoTime;
    public final List<StPicSpecUrlEntry> videoUrl;
    public Integer width;

    public StVideo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StVideo(null, null, null, null, null, null, null, null, null, 511, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.id = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.url = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage");
                this.cover = (StImage) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.width = (Integer) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.height = (Integer) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.videoTime = (Long) v3;
                return;
            case 7:
                List<StPicSpecUrlEntry> list = this.videoUrl;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicSpecUrlEntry>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.size = (Long) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.hasRaw = (Boolean) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StVideo(String str, String str2, StImage stImage, Integer num, Integer num2, Long l3, List list, Long l16, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : stImage, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : num2, (i3 & 32) != 0 ? null : l3, (i3 & 64) != 0 ? new ArrayList() : list, (i3 & 128) != 0 ? null : l16, (i3 & 256) == 0 ? bool : null);
    }

    public StVideo(String str, String str2, StImage stImage, Integer num, Integer num2, Long l3, List<StPicSpecUrlEntry> list, Long l16, Boolean bool) {
        this.id = str;
        this.url = str2;
        this.cover = stImage;
        this.width = num;
        this.height = num2;
        this.videoTime = l3;
        this.videoUrl = list;
        this.size = l16;
        this.hasRaw = bool;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.id, new b.e.g(true))), TuplesKt.to(2, new h(2, this.url, new b.e.g(true))), TuplesKt.to(3, new h(3, this.cover, new b.d(new StImage(null, null, null, null, null, null, null, null, 255, null)))), TuplesKt.to(4, new h(4, this.width, new b.e.C0168e(true))), TuplesKt.to(5, new h(5, this.height, new b.e.C0168e(true))), TuplesKt.to(6, new h(6, this.videoTime, new b.e.i(true))), TuplesKt.to(7, new h(7, this.videoUrl, new b.f(new b.d(new StPicSpecUrlEntry(null, null, 3, null)), false))), TuplesKt.to(8, new h(8, this.size, new b.e.i(true))), TuplesKt.to(9, new h(9, this.hasRaw, new b.e.a(true))));
        return mapOf;
    }
}
