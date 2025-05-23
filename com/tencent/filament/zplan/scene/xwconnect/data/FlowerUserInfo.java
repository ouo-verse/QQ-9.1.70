package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.filament.zplan.scene.xwconnect.data.h;
import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerProp;
import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\tBM\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019R\u001f\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0016\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getLevel", "()I", "level", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;", "b", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;", "e", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;", "status", "c", "currentExp", "d", "levelUpExp", "Ljava/lang/String;", "()Ljava/lang/String;", "levelIcon", "", "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "f", "Ljava/util/List;", "()Ljava/util/List;", "props", "<init>", "(ILcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;IILjava/lang/String;Ljava/util/List;)V", "g", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.f, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FlowerUserInfo {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int level;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final FlowerStatus status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int currentExp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int levelUpExp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String levelIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<FlowerProp> props;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/f$a;", "", "", "Lcom/tencent/filament/zplanservice/pbjava/huateng/HuatengSvr$FlowerProp;", "rsp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "b", "Lcom/tencent/filament/zplanservice/pbjava/huateng/HuatengSvr$FlowerUserInfo;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/f;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.f$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        private final List<FlowerProp> b(List<HuatengSvr$FlowerProp> rsp) {
            int collectionSizeOrDefault;
            List<FlowerProp> filterNotNull;
            if (rsp != null) {
                List<HuatengSvr$FlowerProp> list = rsp;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(FlowerProp.INSTANCE.a((HuatengSvr$FlowerProp) it.next()));
                }
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
                return filterNotNull;
            }
            return null;
        }

        @Nullable
        public final FlowerUserInfo a(@Nullable HuatengSvr$FlowerUserInfo rsp) {
            FlowerStatus flowerStatus;
            boolean z16;
            if (rsp == null) {
                return null;
            }
            int i3 = rsp.level.get();
            h.Companion companion = h.INSTANCE;
            int i16 = rsp.status.get();
            FlowerStatus[] values = FlowerStatus.values();
            int length = values.length;
            int i17 = 0;
            while (true) {
                if (i17 < length) {
                    FlowerStatus flowerStatus2 = values[i17];
                    if (flowerStatus2.getValue() == i16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        flowerStatus = flowerStatus2;
                        break;
                    }
                    i17++;
                } else {
                    flowerStatus = null;
                    break;
                }
            }
            if (flowerStatus != null) {
                return new FlowerUserInfo(i3, flowerStatus, rsp.current_exp.get(), rsp.levelup_exp.get(), rsp.level_icon.get(), b(rsp.props.get()));
            }
            throw new IllegalArgumentException("Invalid value: " + i16);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlowerUserInfo() {
        this(0, null, 0, 0, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCurrentExp() {
        return this.currentExp;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getLevelIcon() {
        return this.levelIcon;
    }

    /* renamed from: c, reason: from getter */
    public final int getLevelUpExp() {
        return this.levelUpExp;
    }

    @Nullable
    public final List<FlowerProp> d() {
        return this.props;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final FlowerStatus getStatus() {
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FlowerUserInfo) {
                FlowerUserInfo flowerUserInfo = (FlowerUserInfo) other;
                if (this.level != flowerUserInfo.level || !Intrinsics.areEqual(this.status, flowerUserInfo.status) || this.currentExp != flowerUserInfo.currentExp || this.levelUpExp != flowerUserInfo.levelUpExp || !Intrinsics.areEqual(this.levelIcon, flowerUserInfo.levelIcon) || !Intrinsics.areEqual(this.props, flowerUserInfo.props)) {
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
        int i17 = this.level * 31;
        FlowerStatus flowerStatus = this.status;
        int i18 = 0;
        if (flowerStatus != null) {
            i3 = flowerStatus.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (((((i17 + i3) * 31) + this.currentExp) * 31) + this.levelUpExp) * 31;
        String str = this.levelIcon;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        List<FlowerProp> list = this.props;
        if (list != null) {
            i18 = list.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "FlowerUserInfo(level=" + this.level + ", status=" + this.status + ", currentExp=" + this.currentExp + ", levelUpExp=" + this.levelUpExp + ", levelIcon=" + this.levelIcon + ", props=" + this.props + ")";
    }

    public FlowerUserInfo(int i3, @NotNull FlowerStatus status, int i16, int i17, @Nullable String str, @Nullable List<FlowerProp> list) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.level = i3;
        this.status = status;
        this.currentExp = i16;
        this.levelUpExp = i17;
        this.levelIcon = str;
        this.props = list;
    }

    public /* synthetic */ FlowerUserInfo(int i3, FlowerStatus flowerStatus, int i16, int i17, String str, List list, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? FlowerStatus.Empty : flowerStatus, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) == 0 ? i17 : 0, (i18 & 16) != 0 ? null : str, (i18 & 32) != 0 ? null : list);
    }
}
