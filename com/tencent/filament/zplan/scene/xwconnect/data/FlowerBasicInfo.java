package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.filament.zplan.scene.xwconnect.data.h;
import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerBasicInfo;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB1\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "flowerId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "flowerName", "Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;", "c", "Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;", "getCoinType", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;", "coinType", "d", "getCost", QCircleWeakNetReporter.KEY_COST, "<init>", "(ILjava/lang/String;Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;I)V", "e", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FlowerBasicInfo {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int flowerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String flowerName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CoinType coinType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cost;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/a$a;", "", "Lcom/tencent/filament/zplanservice/pbjava/huateng/HuatengSvr$FlowerBasicInfo;", "rsp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/a;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final FlowerBasicInfo a(@Nullable HuatengSvr$FlowerBasicInfo rsp) {
            boolean z16;
            CoinType coinType = null;
            if (rsp == null) {
                return null;
            }
            int i3 = rsp.f106421id.get();
            String str = rsp.name.get();
            h.Companion companion = h.INSTANCE;
            int i16 = rsp.coin_type.get();
            CoinType[] values = CoinType.values();
            int length = values.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length) {
                    break;
                }
                CoinType coinType2 = values[i17];
                if (coinType2.getValue() == i16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    coinType = coinType2;
                    break;
                }
                i17++;
            }
            if (coinType != null) {
                return new FlowerBasicInfo(i3, str, coinType, rsp.cost.get());
            }
            throw new IllegalArgumentException("Invalid value: " + i16);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlowerBasicInfo() {
        this(0, null, null, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getFlowerId() {
        return this.flowerId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getFlowerName() {
        return this.flowerName;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FlowerBasicInfo) {
                FlowerBasicInfo flowerBasicInfo = (FlowerBasicInfo) other;
                if (this.flowerId != flowerBasicInfo.flowerId || !Intrinsics.areEqual(this.flowerName, flowerBasicInfo.flowerName) || !Intrinsics.areEqual(this.coinType, flowerBasicInfo.coinType) || this.cost != flowerBasicInfo.cost) {
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
        int i16 = this.flowerId * 31;
        String str = this.flowerName;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        CoinType coinType = this.coinType;
        if (coinType != null) {
            i17 = coinType.hashCode();
        }
        return ((i18 + i17) * 31) + this.cost;
    }

    @NotNull
    public String toString() {
        return "FlowerBasicInfo(flowerId=" + this.flowerId + ", flowerName=" + this.flowerName + ", coinType=" + this.coinType + ", cost=" + this.cost + ")";
    }

    public FlowerBasicInfo(int i3, @Nullable String str, @NotNull CoinType coinType, int i16) {
        Intrinsics.checkNotNullParameter(coinType, "coinType");
        this.flowerId = i3;
        this.flowerName = str;
        this.coinType = coinType;
        this.cost = i16;
    }

    public /* synthetic */ FlowerBasicInfo(int i3, String str, CoinType coinType, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? CoinType.GOLD : coinType, (i17 & 8) != 0 ? 0 : i16);
    }
}
