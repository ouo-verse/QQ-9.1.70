package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOrigin;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;", "cellCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellUserInfo;", "cellUserInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellUserInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellTitle;", "cellTitle", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellTitle;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;", "cellSummary", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;", "cellMedia", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/OriginFeedInfo;", "originFeedInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/OriginFeedInfo;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellUserInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellTitle;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/OriginFeedInfo;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StCellOrigin extends j {
    public StFeedCellCommon cellCommon;
    public StFeedCellMedia cellMedia;
    public StFeedCellSummary cellSummary;
    public StFeedCellTitle cellTitle;
    public StFeedCellUserInfo cellUserInfo;
    public OriginFeedInfo originFeedInfo;

    public StCellOrigin() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StCellOrigin(null, null, null, null, null, null, 63, null));
    }

    public /* synthetic */ StCellOrigin(StFeedCellCommon stFeedCellCommon, StFeedCellUserInfo stFeedCellUserInfo, StFeedCellTitle stFeedCellTitle, StFeedCellSummary stFeedCellSummary, StFeedCellMedia stFeedCellMedia, OriginFeedInfo originFeedInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : stFeedCellCommon, (i3 & 2) != 0 ? null : stFeedCellUserInfo, (i3 & 4) != 0 ? null : stFeedCellTitle, (i3 & 8) != 0 ? null : stFeedCellSummary, (i3 & 16) != 0 ? null : stFeedCellMedia, (i3 & 32) != 0 ? null : originFeedInfo);
    }

    public StCellOrigin(StFeedCellCommon stFeedCellCommon, StFeedCellUserInfo stFeedCellUserInfo, StFeedCellTitle stFeedCellTitle, StFeedCellSummary stFeedCellSummary, StFeedCellMedia stFeedCellMedia, OriginFeedInfo originFeedInfo) {
        this.cellCommon = stFeedCellCommon;
        this.cellUserInfo = stFeedCellUserInfo;
        this.cellTitle = stFeedCellTitle;
        this.cellSummary = stFeedCellSummary;
        this.cellMedia = stFeedCellMedia;
        this.originFeedInfo = originFeedInfo;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        Integer num = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.cellCommon, new b.d(new StFeedCellCommon(null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, num, null, null, null, null, 2097151, null)))), TuplesKt.to(2, new h(2, this.cellUserInfo, new b.d(new StFeedCellUserInfo(null, 1, null)))), TuplesKt.to(3, new h(3, this.cellTitle, new b.d(new StFeedCellTitle(null, null, 3, null)))), TuplesKt.to(4, new h(4, this.cellSummary, new b.d(new StFeedCellSummary(null, null, null, 7, null)))), TuplesKt.to(5, new h(5, this.cellMedia, new b.d(new StFeedCellMedia(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, num, 0 == true ? 1 : 0, 255, 0 == true ? 1 : 0)))), TuplesKt.to(6, new h(6, this.originFeedInfo, new b.d(new OriginFeedInfo(null, 1, null)))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellCommon");
                this.cellCommon = (StFeedCellCommon) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellUserInfo");
                this.cellUserInfo = (StFeedCellUserInfo) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellTitle");
                this.cellTitle = (StFeedCellTitle) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellSummary");
                this.cellSummary = (StFeedCellSummary) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellMedia");
                this.cellMedia = (StFeedCellMedia) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.OriginFeedInfo");
                this.originFeedInfo = (OriginFeedInfo) v3;
                return;
            default:
                return;
        }
    }
}
