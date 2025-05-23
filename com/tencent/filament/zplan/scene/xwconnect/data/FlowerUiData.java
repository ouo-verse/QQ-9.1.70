package com.tencent.filament.zplan.scene.xwconnect.data;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NotifyFlowerUi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\nBA\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\n\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "hostUin", "b", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "hostHaveFlower", "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "flowerData", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "d", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "screenCoord", "", "e", UserInfo.SEX_FEMALE, "getTweenTime", "()F", "tweenTime", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Lcom/tencent/filament/zplan/scene/xwconnect/data/b;Lcom/tencent/filament/zplan/scene/xwconnect/data/i;F)V", "f", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.e, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FlowerUiData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long hostUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean hostHaveFlower;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FlowerData flowerData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ScreenCoord screenCoord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float tweenTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/e$a;", "", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NotifyFlowerUi;", "rsp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/e;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.e$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final FlowerUiData a(@Nullable NativeDoFlowerOp$NotifyFlowerUi rsp) {
            if (rsp != null) {
                return new FlowerUiData(Long.valueOf(rsp.room_host_uin.get()), Boolean.valueOf(rsp.host_have_flower.get()), FlowerData.INSTANCE.a(rsp.flower_data), new ScreenCoord(rsp.ui_coord.f106427x.get(), rsp.ui_coord.f106428y.get()), rsp.tween_time.get());
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlowerUiData() {
        this(null, null, null, null, 0.0f, 31, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final FlowerData getFlowerData() {
        return this.flowerData;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Boolean getHostHaveFlower() {
        return this.hostHaveFlower;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Long getHostUin() {
        return this.hostUin;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final ScreenCoord getScreenCoord() {
        return this.screenCoord;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FlowerUiData) {
                FlowerUiData flowerUiData = (FlowerUiData) other;
                if (!Intrinsics.areEqual(this.hostUin, flowerUiData.hostUin) || !Intrinsics.areEqual(this.hostHaveFlower, flowerUiData.hostHaveFlower) || !Intrinsics.areEqual(this.flowerData, flowerUiData.flowerData) || !Intrinsics.areEqual(this.screenCoord, flowerUiData.screenCoord) || Float.compare(this.tweenTime, flowerUiData.tweenTime) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        Long l3 = this.hostUin;
        int i18 = 0;
        if (l3 != null) {
            i3 = l3.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        Boolean bool = this.hostHaveFlower;
        if (bool != null) {
            i16 = bool.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        FlowerData flowerData = this.flowerData;
        if (flowerData != null) {
            i17 = flowerData.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        ScreenCoord screenCoord = this.screenCoord;
        if (screenCoord != null) {
            i18 = screenCoord.hashCode();
        }
        return ((i27 + i18) * 31) + Float.floatToIntBits(this.tweenTime);
    }

    @NotNull
    public String toString() {
        return "FlowerUiData(hostUin=" + this.hostUin + ", hostHaveFlower=" + this.hostHaveFlower + ", flowerData=" + this.flowerData + ", screenCoord=" + this.screenCoord + ", tweenTime=" + this.tweenTime + ")";
    }

    public FlowerUiData(@Nullable Long l3, @Nullable Boolean bool, @Nullable FlowerData flowerData, @Nullable ScreenCoord screenCoord, float f16) {
        this.hostUin = l3;
        this.hostHaveFlower = bool;
        this.flowerData = flowerData;
        this.screenCoord = screenCoord;
        this.tweenTime = f16;
    }

    public /* synthetic */ FlowerUiData(Long l3, Boolean bool, FlowerData flowerData, ScreenCoord screenCoord, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1L : l3, (i3 & 2) != 0 ? Boolean.FALSE : bool, (i3 & 4) != 0 ? null : flowerData, (i3 & 8) == 0 ? screenCoord : null, (i3 & 16) != 0 ? 0.0f : f16);
    }
}
