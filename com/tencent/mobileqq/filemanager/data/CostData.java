package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\t\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b \u0010\u000fR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/filemanager/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "g", "()J", "o", "(J)V", "systemVideoCost", "b", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "systemAudioCost", "c", "f", DomainData.DOMAIN_NAME, "systemPicCost", "d", "l", "sandBoxVideoCost", "j", "sandBoxAudioCost", "k", "sandBoxPicCost", "i", "groupCost", tl.h.F, "p", VasPerfReportUtils.WHILE_COST_TOTAL, "<init>", "(JJJJJJJJ)V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.filemanager.data.b, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class CostData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long systemVideoCost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long systemAudioCost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long systemPicCost;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long sandBoxVideoCost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long sandBoxAudioCost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long sandBoxPicCost;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long groupCost;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalCost;

    public CostData() {
        this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getGroupCost() {
        return this.groupCost;
    }

    /* renamed from: b, reason: from getter */
    public final long getSandBoxAudioCost() {
        return this.sandBoxAudioCost;
    }

    /* renamed from: c, reason: from getter */
    public final long getSandBoxPicCost() {
        return this.sandBoxPicCost;
    }

    /* renamed from: d, reason: from getter */
    public final long getSandBoxVideoCost() {
        return this.sandBoxVideoCost;
    }

    /* renamed from: e, reason: from getter */
    public final long getSystemAudioCost() {
        return this.systemAudioCost;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CostData)) {
            return false;
        }
        CostData costData = (CostData) other;
        if (this.systemVideoCost == costData.systemVideoCost && this.systemAudioCost == costData.systemAudioCost && this.systemPicCost == costData.systemPicCost && this.sandBoxVideoCost == costData.sandBoxVideoCost && this.sandBoxAudioCost == costData.sandBoxAudioCost && this.sandBoxPicCost == costData.sandBoxPicCost && this.groupCost == costData.groupCost && this.totalCost == costData.totalCost) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getSystemPicCost() {
        return this.systemPicCost;
    }

    /* renamed from: g, reason: from getter */
    public final long getSystemVideoCost() {
        return this.systemVideoCost;
    }

    /* renamed from: h, reason: from getter */
    public final long getTotalCost() {
        return this.totalCost;
    }

    public int hashCode() {
        return (((((((((((((androidx.fragment.app.a.a(this.systemVideoCost) * 31) + androidx.fragment.app.a.a(this.systemAudioCost)) * 31) + androidx.fragment.app.a.a(this.systemPicCost)) * 31) + androidx.fragment.app.a.a(this.sandBoxVideoCost)) * 31) + androidx.fragment.app.a.a(this.sandBoxAudioCost)) * 31) + androidx.fragment.app.a.a(this.sandBoxPicCost)) * 31) + androidx.fragment.app.a.a(this.groupCost)) * 31) + androidx.fragment.app.a.a(this.totalCost);
    }

    public final void i(long j3) {
        this.groupCost = j3;
    }

    public final void j(long j3) {
        this.sandBoxAudioCost = j3;
    }

    public final void k(long j3) {
        this.sandBoxPicCost = j3;
    }

    public final void l(long j3) {
        this.sandBoxVideoCost = j3;
    }

    public final void m(long j3) {
        this.systemAudioCost = j3;
    }

    public final void n(long j3) {
        this.systemPicCost = j3;
    }

    public final void o(long j3) {
        this.systemVideoCost = j3;
    }

    public final void p(long j3) {
        this.totalCost = j3;
    }

    @NotNull
    public String toString() {
        return "CostData(systemVideoCost=" + this.systemVideoCost + ", systemAudioCost=" + this.systemAudioCost + ", systemPicCost=" + this.systemPicCost + ", sandBoxVideoCost=" + this.sandBoxVideoCost + ", sandBoxAudioCost=" + this.sandBoxAudioCost + ", sandBoxPicCost=" + this.sandBoxPicCost + ", groupCost=" + this.groupCost + ", totalCost=" + this.totalCost + ')';
    }

    public CostData(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28) {
        this.systemVideoCost = j3;
        this.systemAudioCost = j16;
        this.systemPicCost = j17;
        this.sandBoxVideoCost = j18;
        this.sandBoxAudioCost = j19;
        this.sandBoxPicCost = j26;
        this.groupCost = j27;
        this.totalCost = j28;
    }

    public /* synthetic */ CostData(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1L : j3, (i3 & 2) != 0 ? -1L : j16, (i3 & 4) != 0 ? -1L : j17, (i3 & 8) != 0 ? -1L : j18, (i3 & 16) != 0 ? -1L : j19, (i3 & 32) != 0 ? -1L : j26, (i3 & 64) != 0 ? -1L : j27, (i3 & 128) == 0 ? j28 : -1L);
    }
}
