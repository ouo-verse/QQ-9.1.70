package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetShuoshuoListRsp;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "ext", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ClientFeed;", "feeds", "Ljava/util/List;", "", "attachInfo", "Ljava/lang/String;", "", "hasMore", "Z", "shuoshuoTimerUnpublishedCount", "I", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "sealOffMemory", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;Ljava/util/List;Ljava/lang/String;ZILcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GetShuoshuoListRsp extends j {
    public String attachInfo;
    public StCommonExt ext;
    public final List<ClientFeed> feeds;
    public boolean hasMore;
    public SealOffMemory sealOffMemory;
    public int shuoshuoTimerUnpublishedCount;

    public GetShuoshuoListRsp() {
        this(null, null, null, false, 0, null, 63, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new GetShuoshuoListRsp(null, null, null, false, 0, null, 63, null));
    }

    public /* synthetic */ GetShuoshuoListRsp(StCommonExt stCommonExt, List list, String str, boolean z16, int i3, SealOffMemory sealOffMemory, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : stCommonExt, (i16 & 2) != 0 ? new ArrayList() : list, (i16 & 4) != 0 ? "" : str, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) != 0 ? null : sealOffMemory);
    }

    public GetShuoshuoListRsp(StCommonExt stCommonExt, List<ClientFeed> list, String str, boolean z16, int i3, SealOffMemory sealOffMemory) {
        this.ext = stCommonExt;
        this.feeds = list;
        this.attachInfo = str;
        this.hasMore = z16;
        this.shuoshuoTimerUnpublishedCount = i3;
        this.sealOffMemory = sealOffMemory;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.ext, new b.d(new StCommonExt(null, null, null, null, 15, null)))), TuplesKt.to(2, new h(2, this.feeds, new b.f(new b.d(new ClientFeed(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0)), false))), TuplesKt.to(3, new h(3, this.attachInfo, new b.e.g(false))), TuplesKt.to(4, new h(4, Boolean.valueOf(this.hasMore), new b.e.a(false))), TuplesKt.to(5, new h(5, Integer.valueOf(this.shuoshuoTimerUnpublishedCount), new b.e.h(false))), TuplesKt.to(6, new h(6, this.sealOffMemory, new b.d(new SealOffMemory(0, null, 0, null, null, 0, null, 127, null)))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt");
                this.ext = (StCommonExt) v3;
                return;
            case 2:
                List<ClientFeed> list = this.feeds;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ClientFeed>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.attachInfo = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.hasMore = ((Boolean) v3).booleanValue();
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.shuoshuoTimerUnpublishedCount = ((Integer) v3).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SealOffMemory");
                this.sealOffMemory = (SealOffMemory) v3;
                return;
            default:
                return;
        }
    }
}
