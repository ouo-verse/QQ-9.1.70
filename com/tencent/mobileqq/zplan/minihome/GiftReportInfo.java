package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/w;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/minihome/GiftPopSource;", "a", "Lcom/tencent/mobileqq/zplan/minihome/GiftPopSource;", "b", "()Lcom/tencent/mobileqq/zplan/minihome/GiftPopSource;", "source", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "()Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "mapMode", "<init>", "(Lcom/tencent/mobileqq/zplan/minihome/GiftPopSource;Lcom/tencent/mobileqq/zplan/minihome/MapMode;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.w, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class GiftReportInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GiftPopSource source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final MapMode mapMode;

    public GiftReportInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final MapMode getMapMode() {
        return this.mapMode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final GiftPopSource getSource() {
        return this.source;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftReportInfo)) {
            return false;
        }
        GiftReportInfo giftReportInfo = (GiftReportInfo) other;
        if (this.source == giftReportInfo.source && this.mapMode == giftReportInfo.mapMode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        GiftPopSource giftPopSource = this.source;
        int i3 = 0;
        if (giftPopSource == null) {
            hashCode = 0;
        } else {
            hashCode = giftPopSource.hashCode();
        }
        int i16 = hashCode * 31;
        MapMode mapMode = this.mapMode;
        if (mapMode != null) {
            i3 = mapMode.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "GiftReportInfo(source=" + this.source + ", mapMode=" + this.mapMode + ')';
    }

    public GiftReportInfo(@Nullable GiftPopSource giftPopSource, @Nullable MapMode mapMode) {
        this.source = giftPopSource;
        this.mapMode = mapMode;
    }

    public /* synthetic */ GiftReportInfo(GiftPopSource giftPopSource, MapMode mapMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? GiftPopSource.UNKNOWN : giftPopSource, (i3 & 2) != 0 ? MapMode.UNKNOWN : mapMode);
    }
}
