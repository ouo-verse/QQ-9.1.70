package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media;

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
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/webapp_qun_media/DeleteMediasRsp;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "", "feedIds", "Ljava/util/List;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class DeleteMediasRsp extends j {
    public static final int $stable = 8;
    public final List<String> feedIds;

    public DeleteMediasRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new DeleteMediasRsp(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ DeleteMediasRsp(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new h(1, this.feedIds, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public DeleteMediasRsp(List<String> list) {
        this.feedIds = list;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            List<String> list = this.feedIds;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
        }
    }
}
