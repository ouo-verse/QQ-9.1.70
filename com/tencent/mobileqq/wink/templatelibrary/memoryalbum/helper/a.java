package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper;

import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w83.b;
import z93.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "data", "", "b", "a", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "c", "e", "Ls53/a;", "d", "Lz93/c;", "Lz93/c;", "qualityReportApi", "", "J", "enterTime", "", "Z", "hasReportBindData", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c qualityReportApi = Wink.INSTANCE.f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long enterTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportBindData;

    private final void b(WinkPublishQualityReportData data) {
        c cVar = this.qualityReportApi;
        if (cVar != null) {
            cVar.a(data, 1);
        }
    }

    public final void a() {
        this.enterTime = System.currentTimeMillis();
    }

    public final void c(@Nullable WinkNewMemoryAlbumResult data) {
        if (data == null || !b.f445025a.K() || this.hasReportBindData) {
            return;
        }
        this.hasReportBindData = true;
        b(new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_SHOW_MEMORY_RESULT").ext1(String.valueOf(System.currentTimeMillis() - this.enterTime)).ext2(data.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().e()).ext3(data.getStoryID()).ext4(data.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().d()).getReportData());
    }

    public final void d(@NotNull s53.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b(new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_CLICK_MEMORY_RESULT").ext1(data.i()).ext2("0").ext3(data.getId()).getReportData());
    }

    public final void e(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b(new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_CLICK_MEMORY_RESULT").ext1(data.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().e()).ext2("1").ext3(data.getStoryID()).ext4(data.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().f()).getReportData());
    }
}
