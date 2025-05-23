package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StRichMsg;", "summary", "Ljava/util/List;", "", "hasMore", "Ljava/lang/Boolean;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/Entry;", "mapExt", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StFeedCellSummary extends j {
    public Boolean hasMore;
    public final List<Entry> mapExt;
    public final List<StRichMsg> summary;

    public StFeedCellSummary() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StFeedCellSummary(null, null, null, 7, null));
    }

    public /* synthetic */ StFeedCellSummary(List list, Boolean bool, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? new ArrayList() : list2);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.summary, new b.f(new b.d(new StRichMsg(0, null, null, null, null, null, null, null, null, 511, null)), false))), TuplesKt.to(2, new h(2, this.hasMore, new b.e.a(true))), TuplesKt.to(3, new h(3, this.mapExt, new b.f(new b.d(new Entry(null, null, null, null, 15, null)), false))));
        return mapOf;
    }

    public StFeedCellSummary(List<StRichMsg> list, Boolean bool, List<Entry> list2) {
        this.summary = list;
        this.hasMore = bool;
        this.mapExt = list2;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            List<StRichMsg> list = this.summary;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
        } else if (fieldNumber == 2) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
            this.hasMore = (Boolean) v3;
        } else {
            if (fieldNumber != 3) {
                return;
            }
            List<Entry> list2 = this.mapExt;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
        }
    }
}
