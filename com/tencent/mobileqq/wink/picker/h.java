package com.tencent.mobileqq.wink.picker;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import e93.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004J+\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ,\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/h;", "", "", "needFaceDetect", "", "a", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "scene", "Lcom/tencent/mobileqq/wink/picker/TabType;", "localMediaTabType", "hasPermission", "", "g", "errorCode", "d", "", "mediaCount", "imageCount", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT, "c", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "f", "useVideoTemplate", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "e", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f324861a = new h();

    h() {
    }

    private final String a(boolean needFaceDetect) {
        if (needFaceDetect) {
            return "1";
        }
        return "0";
    }

    public final void b(@NotNull WinkMediaPickerScene scene, boolean needFaceDetect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(scene, "scene");
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_PICKER_EXIT");
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData reportData = eventId.traceId(companion2.d().getTraceId()).ext1(f324861a.a(needFaceDetect)).ext3(String.valueOf(scene.getCode())).getReportData();
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

    public final void c(@Nullable Integer mediaCount, @Nullable Integer imageCount, @Nullable Integer videoCount) {
        String str;
        String str2;
        String str3;
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_PICKER_FETCH_FINISHED");
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData.Builder traceId = eventId.traceId(companion2.d().getTraceId());
            Unit unit = null;
            if (mediaCount != null) {
                str = mediaCount.toString();
            } else {
                str = null;
            }
            WinkPublishQualityReportData.Builder ext1 = traceId.ext1(str);
            if (imageCount != null) {
                str2 = imageCount.toString();
            } else {
                str2 = null;
            }
            WinkPublishQualityReportData.Builder ext2 = ext1.ext2(str2);
            if (videoCount != null) {
                str3 = videoCount.toString();
            } else {
                str3 = null;
            }
            WinkPublishQualityReportData reportData = ext2.ext3(str3).getReportData();
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(reportData, companion2.d().k().b());
                unit = Unit.INSTANCE;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public final void d(@NotNull String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_PICKER_READY");
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData.Builder ext1 = eventId.traceId(companion2.d().getTraceId()).ext1(errorCode);
            Unit unit = null;
            WinkPublishQualityReportData reportData = ext1.ext6(WinkReportUtils.isInMultiWindowMode(null)).getReportData();
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(reportData, companion2.d().k().b());
                unit = Unit.INSTANCE;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public final void e(boolean useVideoTemplate, @NotNull WinkMediaPickerScene scene, @NotNull List<? extends LocalMediaInfo> selectedMedia, boolean needFaceDetect) {
        String str;
        Unit unit;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (useVideoTemplate) {
                str = "E_PICKER_VIDEO_TEMPLATE";
            } else {
                str = "E_PICKER_NEXT_STEP";
            }
            WinkPublishQualityReportData.Builder traceId = new WinkPublishQualityReportData.Builder().eventId(str).traceId(WinkContext.INSTANCE.d().getTraceId());
            ArrayList arrayList = new ArrayList();
            for (Object obj : selectedMedia) {
                if (i.I((LocalMediaInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            WinkPublishQualityReportData.Builder ext1 = traceId.ext1(String.valueOf(arrayList.size()));
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : selectedMedia) {
                if (i.G((LocalMediaInfo) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            WinkPublishQualityReportData reportData = ext1.ext2(String.valueOf(arrayList2.size())).ext3(String.valueOf(scene.getCode())).ext4(f324861a.a(needFaceDetect)).getReportData();
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(reportData, WinkContext.INSTANCE.d().k().b());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public final void f(int videoCount, int imageCount) {
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_PICKER_CLICK_LIST");
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData reportData = eventId.traceId(companion2.d().getTraceId()).ext1(String.valueOf(videoCount)).ext2(String.valueOf(imageCount)).getReportData();
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

    public final void g(@NotNull WinkMediaPickerScene scene, @NotNull TabType localMediaTabType, boolean hasPermission, boolean needFaceDetect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(localMediaTabType, "localMediaTabType");
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_PICKER_VIEW_LOAD");
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkPublishQualityReportData reportData = eventId.traceId(companion2.d().getTraceId()).ext1("").ext2(f324861a.a(needFaceDetect)).ext3(String.valueOf(scene.getCode())).ext4(String.valueOf(localMediaTabType.getCode())).ext5(String.valueOf(hasPermission)).getReportData();
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
}
