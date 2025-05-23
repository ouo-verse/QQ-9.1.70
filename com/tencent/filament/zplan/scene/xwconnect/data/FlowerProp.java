package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.filament.zplan.scene.xwconnect.data.h;
import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerProp;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\tBG\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "id", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "name", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "d", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "op", "iconUrl", "e", "getRemainTimes", "remainTimes", "f", "Z", "getAdExtraFlag", "()Z", "adExtraFlag", "<init>", "(ILjava/lang/String;Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;Ljava/lang/String;IZ)V", "g", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.d, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FlowerProp {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final FlowerOpType op;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int remainTimes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean adExtraFlag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/d$a;", "", "Lcom/tencent/filament/zplanservice/pbjava/huateng/HuatengSvr$FlowerProp;", "rsp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.d$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final FlowerProp a(@Nullable HuatengSvr$FlowerProp rsp) {
            FlowerOpType flowerOpType;
            boolean z16;
            if (rsp == null) {
                return null;
            }
            try {
                int i3 = rsp.f106422id.get();
                String str = rsp.name.get();
                h.Companion companion = h.INSTANCE;
                int i16 = rsp.f106423op.get();
                FlowerOpType[] values = FlowerOpType.values();
                int length = values.length;
                int i17 = 0;
                while (true) {
                    if (i17 < length) {
                        FlowerOpType flowerOpType2 = values[i17];
                        if (flowerOpType2.getValue() == i16) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            flowerOpType = flowerOpType2;
                            break;
                        }
                        i17++;
                    } else {
                        flowerOpType = null;
                        break;
                    }
                }
                if (flowerOpType != null) {
                    return new FlowerProp(i3, str, flowerOpType, rsp.icon_url.get(), rsp.remain_times.get(), rsp.ad_extra_flag.get());
                }
                throw new IllegalArgumentException("Invalid value: " + i16);
            } catch (Throwable th5) {
                FLog.INSTANCE.e("FlowerProp", "mergeFrom error, " + th5);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlowerProp() {
        this(0, null, null, null, 0, false, 63, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final FlowerOpType getOp() {
        return this.op;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FlowerProp) {
                FlowerProp flowerProp = (FlowerProp) other;
                if (this.id != flowerProp.id || !Intrinsics.areEqual(this.name, flowerProp.name) || !Intrinsics.areEqual(this.op, flowerProp.op) || !Intrinsics.areEqual(this.iconUrl, flowerProp.iconUrl) || this.remainTimes != flowerProp.remainTimes || this.adExtraFlag != flowerProp.adExtraFlag) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.id * 31;
        String str = this.name;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        FlowerOpType flowerOpType = this.op;
        if (flowerOpType != null) {
            i16 = flowerOpType.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str2 = this.iconUrl;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        int i27 = (((i26 + i18) * 31) + this.remainTimes) * 31;
        boolean z16 = this.adExtraFlag;
        int i28 = z16;
        if (z16 != 0) {
            i28 = 1;
        }
        return i27 + i28;
    }

    @NotNull
    public String toString() {
        return "FlowerProp(id=" + this.id + ", name=" + this.name + ", op=" + this.op + ", iconUrl=" + this.iconUrl + ", remainTimes=" + this.remainTimes + ", adExtraFlag=" + this.adExtraFlag + ")";
    }

    public FlowerProp(int i3, @Nullable String str, @NotNull FlowerOpType op5, @Nullable String str2, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(op5, "op");
        this.id = i3;
        this.name = str;
        this.op = op5;
        this.iconUrl = str2;
        this.remainTimes = i16;
        this.adExtraFlag = z16;
    }

    public /* synthetic */ FlowerProp(int i3, String str, FlowerOpType flowerOpType, String str2, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? FlowerOpType.INVALID_OP : flowerOpType, (i17 & 8) == 0 ? str2 : null, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? false : z16);
    }
}
