package com.tencent.mobileqq.zplan.room.impl.trtc;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.trtc.TRTCCloudDef;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \n2\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\n\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\r\u001a\u00020\u000b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bJ\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u0018\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/a;", "", "", "sdkAppId", "", "userSig", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "d", "Lkotlin/Pair;", "params", "e", "Lcom/tencent/trtc/TRTCCloudDef$TRTCSwitchRoomConfig;", "f", "g", "toString", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "selfUserId", "b", "roomId", "Z", h.F, "()Z", "isAnchor", "I", "()I", "roomType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.room.impl.trtc.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanTRTCRoomParam {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String selfUserId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAnchor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int roomType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/a$a;", "", "Lhk3/a;", "getDataApi", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/a;", "a", "", HippyControllerProps.STRING, "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.room.impl.trtc.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanTRTCRoomParam a(hk3.a getDataApi) {
            Intrinsics.checkNotNullParameter(getDataApi, "getDataApi");
            String finalTRTCUserId = getDataApi.getSelfUserInfo().f413323b;
            String b16 = getDataApi.b();
            Intrinsics.checkNotNullExpressionValue(finalTRTCUserId, "finalTRTCUserId");
            return new ZPlanTRTCRoomParam(finalTRTCUserId, b16, getDataApi.a(), 0, 8, null);
        }

        Companion() {
        }

        public final int b(String string) {
            if (string == null) {
                return 0;
            }
            try {
                return Integer.parseInt(string);
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public ZPlanTRTCRoomParam(String selfUserId, String str, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(selfUserId, "selfUserId");
        this.selfUserId = selfUserId;
        this.roomId = str;
        this.isAnchor = z16;
        this.roomType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: b, reason: from getter */
    public final int getRoomType() {
        return this.roomType;
    }

    /* renamed from: c, reason: from getter */
    public final String getSelfUserId() {
        return this.selfUserId;
    }

    public final TRTCCloudDef.TRTCParams d(int sdkAppId, String userSig) {
        Intrinsics.checkNotNullParameter(userSig, "userSig");
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.sdkAppId = sdkAppId;
        tRTCParams.userId = this.selfUserId;
        tRTCParams.strRoomId = this.roomId;
        tRTCParams.userSig = userSig;
        tRTCParams.role = this.isAnchor ? 20 : 21;
        return tRTCParams;
    }

    public final TRTCCloudDef.TRTCParams e(Pair<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.sdkAppId = INSTANCE.b(params.getFirst());
        tRTCParams.userId = this.selfUserId;
        tRTCParams.strRoomId = this.roomId;
        tRTCParams.userSig = params.getSecond();
        tRTCParams.role = this.isAnchor ? 20 : 21;
        return tRTCParams;
    }

    public final TRTCCloudDef.TRTCSwitchRoomConfig f(String userSig) {
        Intrinsics.checkNotNullParameter(userSig, "userSig");
        TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig = new TRTCCloudDef.TRTCSwitchRoomConfig();
        tRTCSwitchRoomConfig.strRoomId = this.roomId;
        tRTCSwitchRoomConfig.userSig = userSig;
        return tRTCSwitchRoomConfig;
    }

    public final TRTCCloudDef.TRTCSwitchRoomConfig g(Pair<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig = new TRTCCloudDef.TRTCSwitchRoomConfig();
        tRTCSwitchRoomConfig.strRoomId = this.roomId;
        tRTCSwitchRoomConfig.userSig = params.getSecond();
        return tRTCSwitchRoomConfig;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsAnchor() {
        return this.isAnchor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.selfUserId.hashCode() * 31;
        String str = this.roomId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z16 = this.isAnchor;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode2 + i3) * 31) + this.roomType;
    }

    public String toString() {
        return "ZPlanTRTCRoomParam(selfUserId=" + this.selfUserId + ", roomId=" + this.roomId + ", isAnchor=" + this.isAnchor + ", roomType=" + this.roomType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanTRTCRoomParam)) {
            return false;
        }
        ZPlanTRTCRoomParam zPlanTRTCRoomParam = (ZPlanTRTCRoomParam) other;
        return Intrinsics.areEqual(this.selfUserId, zPlanTRTCRoomParam.selfUserId) && Intrinsics.areEqual(this.roomId, zPlanTRTCRoomParam.roomId) && this.isAnchor == zPlanTRTCRoomParam.isAnchor && this.roomType == zPlanTRTCRoomParam.roomType;
    }

    public /* synthetic */ ZPlanTRTCRoomParam(String str, String str2, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? true : z16, (i16 & 8) != 0 ? 3 : i3);
    }
}
