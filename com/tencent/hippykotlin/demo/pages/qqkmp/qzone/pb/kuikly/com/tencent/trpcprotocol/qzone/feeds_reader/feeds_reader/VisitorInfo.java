package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/VisitorInfo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "visitorCnt", "I", "todayVisitorCnt", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "todayVisitors", "Ljava/util/List;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(IILjava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class VisitorInfo extends j {
    public static final int $stable = 8;
    public int todayVisitorCnt;
    public final List<StUser> todayVisitors;
    public int visitorCnt;

    public VisitorInfo() {
        this(0, 0, null, 7, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new VisitorInfo(0, 0, null, 7, null));
    }

    public /* synthetic */ VisitorInfo(int i3, int i16, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? new ArrayList() : list);
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
            this.visitorCnt = ((Integer) v3).intValue();
        } else if (fieldNumber == 2) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
            this.todayVisitorCnt = ((Integer) v3).intValue();
        } else {
            if (fieldNumber != 3) {
                return;
            }
            List<StUser> list = this.todayVisitors;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
        }
    }

    public VisitorInfo(int i3, int i16, List<StUser> list) {
        this.visitorCnt = i3;
        this.todayVisitorCnt = i16;
        this.todayVisitors = list;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        Boolean bool = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.visitorCnt), new b.e.h(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.todayVisitorCnt), new b.e.h(false))), TuplesKt.to(3, new h(3, this.todayVisitors, new b.f(new b.d(new StUser(null, null, null, null, bool, bool, null, null, null, null, null, null, null, null, null, null, 65535, null)), false))));
        return mapOf;
    }
}
