package com.tencent.mobileqq.zplan.room.impl.constant;

import com.tencent.mobileqq.vas.banner.c;
import iv4.e;
import iv4.f;
import iv4.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lv4.b;
import lv4.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\tB-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\t\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/constant/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "roomId", "Liv4/f;", "b", "Liv4/f;", "()Liv4/f;", "roomDetail", "Liv4/l;", "Liv4/l;", "d", "()Liv4/l;", "speakerInfoList", "", "J", "()J", "maxActionId", "<init>", "(Ljava/lang/String;Liv4/f;Liv4/l;J)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.room.impl.constant.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanRoomInitData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final f roomDetail;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final l speakerInfoList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long maxActionId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/constant/a$a;", "", "Llv4/b;", "joinRsp", "Lcom/tencent/mobileqq/zplan/room/impl/constant/a;", "a", "Llv4/h;", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.room.impl.constant.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanRoomInitData a(b joinRsp) {
            iv4.b bVar;
            Intrinsics.checkNotNullParameter(joinRsp, "joinRsp");
            String str = null;
            if (joinRsp.f415637a == null) {
                return null;
            }
            f fVar = joinRsp.f415637a;
            e eVar = fVar.f408821a;
            if (eVar != null && (bVar = eVar.f408820a) != null) {
                str = bVar.f408810a;
            }
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(fVar, "joinRsp.roomDetail");
            return new ZPlanRoomInitData(str, fVar, joinRsp.f415638b, 0L, 8, null);
        }

        public final ZPlanRoomInitData b(h joinRsp) {
            iv4.b bVar;
            Intrinsics.checkNotNullParameter(joinRsp, "joinRsp");
            String str = null;
            if (joinRsp.f415649a == null) {
                return null;
            }
            f fVar = joinRsp.f415649a;
            e eVar = fVar.f408821a;
            if (eVar != null && (bVar = eVar.f408820a) != null) {
                str = bVar.f408810a;
            }
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(fVar, "joinRsp.roomDetail");
            return new ZPlanRoomInitData(str, fVar, joinRsp.f415650b, joinRsp.f415651c);
        }

        Companion() {
        }
    }

    public ZPlanRoomInitData(String roomId, f roomDetail, l lVar, long j3) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
        this.roomId = roomId;
        this.roomDetail = roomDetail;
        this.speakerInfoList = lVar;
        this.maxActionId = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getMaxActionId() {
        return this.maxActionId;
    }

    /* renamed from: b, reason: from getter */
    public final f getRoomDetail() {
        return this.roomDetail;
    }

    /* renamed from: c, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: d, reason: from getter */
    public final l getSpeakerInfoList() {
        return this.speakerInfoList;
    }

    public int hashCode() {
        int hashCode = ((this.roomId.hashCode() * 31) + this.roomDetail.hashCode()) * 31;
        l lVar = this.speakerInfoList;
        return ((hashCode + (lVar == null ? 0 : lVar.hashCode())) * 31) + c.a(this.maxActionId);
    }

    public String toString() {
        return "ZPlanRoomInitData(roomId=" + this.roomId + ", roomDetail=" + this.roomDetail + ", speakerInfoList=" + this.speakerInfoList + ", maxActionId=" + this.maxActionId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanRoomInitData)) {
            return false;
        }
        ZPlanRoomInitData zPlanRoomInitData = (ZPlanRoomInitData) other;
        return Intrinsics.areEqual(this.roomId, zPlanRoomInitData.roomId) && Intrinsics.areEqual(this.roomDetail, zPlanRoomInitData.roomDetail) && Intrinsics.areEqual(this.speakerInfoList, zPlanRoomInitData.speakerInfoList) && this.maxActionId == zPlanRoomInitData.maxActionId;
    }

    public /* synthetic */ ZPlanRoomInitData(String str, f fVar, l lVar, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fVar, (i3 & 4) != 0 ? null : lVar, (i3 & 8) != 0 ? 0L : j3);
    }
}
