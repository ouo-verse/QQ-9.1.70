package com.tencent.sqshow.zootopia.recommend.main.dress.util;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/util/ZPlanDressFeedsActionEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "zplanFeedsId", "", "actionType", "", "localFakePraiseNum", "localFakeHasPraised", "", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Boolean;)V", "getActionType", "()I", "getLocalFakeHasPraised", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocalFakePraiseNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getZplanFeedsId", "()Ljava/lang/String;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanDressFeedsActionEvent extends SimpleBaseEvent {
    private final int actionType;
    private final Boolean localFakeHasPraised;
    private final Integer localFakePraiseNum;
    private final String zplanFeedsId;

    public /* synthetic */ ZPlanDressFeedsActionEvent(String str, int i3, Integer num, Boolean bool, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? null : num, (i16 & 8) != 0 ? null : bool);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final Boolean getLocalFakeHasPraised() {
        return this.localFakeHasPraised;
    }

    public final Integer getLocalFakePraiseNum() {
        return this.localFakePraiseNum;
    }

    public final String getZplanFeedsId() {
        return this.zplanFeedsId;
    }

    public ZPlanDressFeedsActionEvent(String zplanFeedsId, int i3, Integer num, Boolean bool) {
        Intrinsics.checkNotNullParameter(zplanFeedsId, "zplanFeedsId");
        this.zplanFeedsId = zplanFeedsId;
        this.actionType = i3;
        this.localFakePraiseNum = num;
        this.localFakeHasPraised = bool;
    }
}
