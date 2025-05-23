package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerData;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\nB+\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/filament/zplan/scene/xwconnect/data/a;", "a", "Lcom/tencent/filament/zplan/scene/xwconnect/data/a;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/a;", "basicInfo", "Lcom/tencent/filament/zplan/scene/xwconnect/data/f;", "b", "Lcom/tencent/filament/zplan/scene/xwconnect/data/f;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/f;", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/filament/zplan/scene/xwconnect/data/g;", "c", "Lcom/tencent/filament/zplan/scene/xwconnect/data/g;", "getViewData", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/g;", "viewData", "<init>", "(Lcom/tencent/filament/zplan/scene/xwconnect/data/a;Lcom/tencent/filament/zplan/scene/xwconnect/data/f;Lcom/tencent/filament/zplan/scene/xwconnect/data/g;)V", "d", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FlowerData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FlowerBasicInfo basicInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FlowerUserInfo userInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FlowerViewData viewData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/b$a;", "", "Lcom/tencent/filament/zplanservice/pbjava/huateng/HuatengSvr$FlowerData;", "rsp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.b$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final FlowerData a(@Nullable HuatengSvr$FlowerData rsp) {
            if (rsp != null) {
                return new FlowerData(FlowerBasicInfo.INSTANCE.a(rsp.basic_info), FlowerUserInfo.INSTANCE.a(rsp.user_info), FlowerViewData.INSTANCE.a(rsp.view));
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlowerData() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final FlowerBasicInfo getBasicInfo() {
        return this.basicInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final FlowerUserInfo getUserInfo() {
        return this.userInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FlowerData) {
                FlowerData flowerData = (FlowerData) other;
                if (!Intrinsics.areEqual(this.basicInfo, flowerData.basicInfo) || !Intrinsics.areEqual(this.userInfo, flowerData.userInfo) || !Intrinsics.areEqual(this.viewData, flowerData.viewData)) {
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
        FlowerBasicInfo flowerBasicInfo = this.basicInfo;
        int i17 = 0;
        if (flowerBasicInfo != null) {
            i3 = flowerBasicInfo.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        FlowerUserInfo flowerUserInfo = this.userInfo;
        if (flowerUserInfo != null) {
            i16 = flowerUserInfo.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        FlowerViewData flowerViewData = this.viewData;
        if (flowerViewData != null) {
            i17 = flowerViewData.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "FlowerData(basicInfo=" + this.basicInfo + ", userInfo=" + this.userInfo + ", viewData=" + this.viewData + ")";
    }

    public FlowerData(@Nullable FlowerBasicInfo flowerBasicInfo, @Nullable FlowerUserInfo flowerUserInfo, @Nullable FlowerViewData flowerViewData) {
        this.basicInfo = flowerBasicInfo;
        this.userInfo = flowerUserInfo;
        this.viewData = flowerViewData;
    }

    public /* synthetic */ FlowerData(FlowerBasicInfo flowerBasicInfo, FlowerUserInfo flowerUserInfo, FlowerViewData flowerViewData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : flowerBasicInfo, (i3 & 2) != 0 ? null : flowerUserInfo, (i3 & 4) != 0 ? null : flowerViewData);
    }
}
