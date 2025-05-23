package com.tencent.mobileqq.zootopia.ueloading.report;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002JY\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001c\u001a\u0004\b,\u0010\u001e\"\u0004\b)\u0010 R\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010/\u001a\u0004\b&\u00100\"\u0004\b1\u00102\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/report/a;", "", "Ljava/util/HashMap;", "", "k", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "mapId", "modVersion", "fromSource", "loadingId", "errorCode", "errorMsg", "", "startTime", "a", "toString", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "j", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "b", "I", "c", "()I", h.F, "(I)V", "Ljava/lang/String;", "getModVersion", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "d", "getFromSource", "f", "e", "getLoadingId", "g", "getErrorCode", "getErrorMsg", "setErrorMsg", "J", "()J", "setStartTime", "(J)V", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.ueloading.report.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class ZPlanUEReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaSource source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int mapId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String modVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String fromSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String loadingId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int errorCode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String errorMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long startTime;

    public ZPlanUEReportData() {
        this(null, 0, null, null, null, 0, null, 0L, 255, null);
    }

    public final ZPlanUEReportData a(ZootopiaSource source, int mapId, String modVersion, String fromSource, String loadingId, int errorCode, String errorMsg, long startTime) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(modVersion, "modVersion");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        Intrinsics.checkNotNullParameter(loadingId, "loadingId");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        return new ZPlanUEReportData(source, mapId, modVersion, fromSource, loadingId, errorCode, errorMsg, startTime);
    }

    /* renamed from: c, reason: from getter */
    public final int getMapId() {
        return this.mapId;
    }

    /* renamed from: d, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final void e(int i3) {
        this.errorCode = i3;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromSource = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadingId = str;
    }

    public final void h(int i3) {
        this.mapId = i3;
    }

    public int hashCode() {
        return (((((((((((((this.source.hashCode() * 31) + this.mapId) * 31) + this.modVersion.hashCode()) * 31) + this.fromSource.hashCode()) * 31) + this.loadingId.hashCode()) * 31) + this.errorCode) * 31) + this.errorMsg.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.startTime);
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modVersion = str;
    }

    public final void j(ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<set-?>");
        this.source = zootopiaSource;
    }

    public final HashMap<String, Object> k() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_map_id", Integer.valueOf(this.mapId));
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ag.f373258a.d(this.source));
        hashMap.put("zplan_loading_id", this.loadingId);
        hashMap.put("zplan_mod_version", this.modVersion);
        hashMap.put("zplan_startup_mode", this.fromSource);
        hashMap.put("zplan_error_code", Integer.valueOf(this.errorCode));
        hashMap.put("zplan_error_msg", this.errorMsg);
        return hashMap;
    }

    public String toString() {
        return "ZPlanUEReportData(source=" + this.source + ", mapId=" + this.mapId + ", modVersion=" + this.modVersion + ", fromSource=" + this.fromSource + ", loadingId=" + this.loadingId + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", startTime=" + this.startTime + ")";
    }

    public ZPlanUEReportData(ZootopiaSource source, int i3, String modVersion, String fromSource, String loadingId, int i16, String errorMsg, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(modVersion, "modVersion");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        Intrinsics.checkNotNullParameter(loadingId, "loadingId");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.source = source;
        this.mapId = i3;
        this.modVersion = modVersion;
        this.fromSource = fromSource;
        this.loadingId = loadingId;
        this.errorCode = i16;
        this.errorMsg = errorMsg;
        this.startTime = j3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanUEReportData)) {
            return false;
        }
        ZPlanUEReportData zPlanUEReportData = (ZPlanUEReportData) other;
        return Intrinsics.areEqual(this.source, zPlanUEReportData.source) && this.mapId == zPlanUEReportData.mapId && Intrinsics.areEqual(this.modVersion, zPlanUEReportData.modVersion) && Intrinsics.areEqual(this.fromSource, zPlanUEReportData.fromSource) && Intrinsics.areEqual(this.loadingId, zPlanUEReportData.loadingId) && this.errorCode == zPlanUEReportData.errorCode && Intrinsics.areEqual(this.errorMsg, zPlanUEReportData.errorMsg) && this.startTime == zPlanUEReportData.startTime;
    }

    public /* synthetic */ ZPlanUEReportData(ZootopiaSource zootopiaSource, int i3, String str, String str2, String str3, int i16, String str4, long j3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? ZootopiaSource.INSTANCE.g() : zootopiaSource, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? "0" : str2, (i17 & 16) != 0 ? "" : str3, (i17 & 32) == 0 ? i16 : 0, (i17 & 64) == 0 ? str4 : "", (i17 & 128) != 0 ? 0L : j3);
    }
}
