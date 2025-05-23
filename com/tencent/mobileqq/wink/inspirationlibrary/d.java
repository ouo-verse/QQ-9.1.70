package com.tencent.mobileqq.wink.inspirationlibrary;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/d;", "", "", "isEntry", "", "a", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "position", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f322989a = new d();

    d() {
    }

    public final void a(boolean isEntry) {
        String str;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (isEntry) {
                str = "E_TEMPLATE_VIEW_LOAD";
            } else {
                str = "E_TEMPLATE_EXIT";
            }
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId(str);
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData reportData = eventId.traceId(companion2.d().getTraceId()).getReportData();
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(reportData, companion2.d().k().b());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:2:0x0000, B:5:0x000b, B:7:0x0025, B:9:0x002d, B:10:0x0031, B:12:0x003f, B:13:0x0043, B:15:0x0053, B:16:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:2:0x0000, B:5:0x000b, B:7:0x0025, B:9:0x002d, B:10:0x0031, B:12:0x003f, B:13:0x0043, B:15:0x0053, B:16:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(boolean isEntry, @Nullable List<MetaMaterial> materials, @Nullable MetaCategory category, int position) {
        String str;
        String str2;
        String str3;
        z93.c f16;
        Object orNull;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (isEntry) {
                str = "E_TEMPLATE_PREVIEW_LOAD";
            } else {
                str = "E_TEMPLATE_PREVIEW_EXIT";
            }
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId(str);
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData.Builder traceId = eventId.traceId(companion2.d().getTraceId());
            Unit unit = null;
            if (materials != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(materials, position);
                MetaMaterial metaMaterial = (MetaMaterial) orNull;
                if (metaMaterial != null) {
                    str2 = metaMaterial.f30533id;
                    WinkPublishQualityReportData.Builder ext2 = traceId.ext1(str2).ext2(String.valueOf(position));
                    if (category == null) {
                        str3 = category.name;
                    } else {
                        str3 = null;
                    }
                    WinkPublishQualityReportData reportData = ext2.ext3(str3).getReportData();
                    f16 = Wink.INSTANCE.f();
                    if (f16 != null) {
                        f16.a(reportData, companion2.d().k().b());
                        unit = Unit.INSTANCE;
                    }
                    Result.m476constructorimpl(unit);
                }
            }
            str2 = null;
            WinkPublishQualityReportData.Builder ext22 = traceId.ext1(str2).ext2(String.valueOf(position));
            if (category == null) {
            }
            WinkPublishQualityReportData reportData2 = ext22.ext3(str3).getReportData();
            f16 = Wink.INSTANCE.f();
            if (f16 != null) {
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }
}
