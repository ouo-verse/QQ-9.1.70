package com.tencent.mobileqq.wink.editor.export;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.utils.ay;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&JN\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0002J$\u0010\u0011\u001a\u00020\u000f2\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0002J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002JD\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002JN\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u001e\u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/af;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "targetVideo", "", "targetBitrate", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oriMedias", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "type", "traceId", "c", "", "j", "g", "video", "d", "videoPath", "", "position", "Landroid/graphics/Bitmap;", "f", "localMediaInfo", "retCode", "timeCost", "Lcom/google/gson/JsonArray;", "reportData", "", tl.h.F, "info", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "b", "missionID", "e", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final af f320186a = new af();

    af() {
    }

    private final int c(LocalMediaInfo targetVideo, long targetBitrate, ArrayList<LocalMediaInfo> oriMedias, String businessName, int type, String traceId) {
        List listOf;
        if (j(targetVideo, targetBitrate, oriMedias)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.5f), Float.valueOf(0.25f), Float.valueOf(0.75f)});
            JsonArray jsonArray = new JsonArray();
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                float floatValue = ((Number) it.next()).floatValue();
                af afVar = f320186a;
                String str = targetVideo.path;
                Intrinsics.checkNotNullExpressionValue(str, "targetVideo.path");
                Bitmap f16 = afVar.f(str, floatValue);
                if (f16 != null && f16.getWidth() != 0 && f16.getHeight() != 0) {
                    int width = f16.getWidth();
                    int height = f16.getHeight();
                    int i3 = width * height;
                    int[] iArr = new int[i3];
                    f16.getPixels(iArr, 0, width, 0, 0, width, height);
                    int i16 = 0;
                    for (int i17 = 0; i17 < i3; i17++) {
                        if ((iArr[i17] & 16777215) == 0) {
                            i16++;
                        }
                    }
                    float f17 = i16 / i3;
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("width", Integer.valueOf(width));
                    jsonObject.addProperty("height", Integer.valueOf(height));
                    jsonObject.addProperty("rate", Float.valueOf(f17));
                    jsonArray.add(jsonObject);
                    if (f17 < 0.999d) {
                        f320186a.h(targetVideo, 0L, traceId, businessName, type, 0L, jsonArray);
                        return 1;
                    }
                } else {
                    afVar.h(targetVideo, ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK_ERROR, traceId, businessName, type, 0L, jsonArray);
                    return -1;
                }
            }
            h(targetVideo, ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK, traceId, businessName, type, System.currentTimeMillis() - currentTimeMillis, jsonArray);
            return 0;
        }
        w53.b.c("WinkPublish-Export-WinkVideoUtils", "no check, video path:" + targetVideo.path + ", bitrate:" + targetVideo.mediaBitrate);
        return -1;
    }

    private final int d(LocalMediaInfo video, String businessName, String traceId) {
        List listOf;
        long j3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.5f), Float.valueOf(0.25f), Float.valueOf(0.75f)});
        JsonArray jsonArray = new JsonArray();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = listOf.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            float floatValue = ((Number) it.next()).floatValue();
            af afVar = f320186a;
            String str = video.path;
            Intrinsics.checkNotNullExpressionValue(str, "video.path");
            Bitmap f16 = afVar.f(str, floatValue);
            if (f16 != null && f16.getWidth() != 0 && f16.getHeight() != 0) {
                if (i3 != 0) {
                    int width = f16.getWidth();
                    int height = f16.getHeight();
                    int i16 = width * height;
                    int[] iArr = new int[i16];
                    f16.getPixels(iArr, 0, width, 0, 0, width, height);
                    int i17 = 0;
                    for (int i18 = 0; i18 < i16; i18++) {
                        if ((iArr[i18] & 16777215) == 0) {
                            i17++;
                        }
                    }
                    float f17 = i17 / i16;
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("width", Integer.valueOf(width));
                    jsonObject.addProperty("height", Integer.valueOf(height));
                    jsonObject.addProperty("rate", Float.valueOf(f17));
                    jsonArray.add(jsonObject);
                    if (f17 < 0.999d) {
                        i3 = 0;
                    }
                }
            } else {
                afVar.h(video, ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK_ERROR, traceId, businessName, 5, 0L, jsonArray);
                return 2;
            }
        }
        if (i3 != 0) {
            j3 = ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK;
        } else {
            j3 = 0;
        }
        h(video, j3, traceId, businessName, 5, System.currentTimeMillis() - currentTimeMillis, jsonArray);
        return i3 ^ 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12, types: [T, android.graphics.Bitmap] */
    private final Bitmap f(String videoPath, float position) {
        String extractMetadata;
        Bitmap scaledFrameAtTime;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
        } catch (RuntimeException e16) {
            w53.b.d("WinkPublish-Export-WinkVideoUtils", "retriever.release error", e16);
        }
        try {
            try {
                mediaMetadataRetriever.setDataSource(videoPath);
                extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            } catch (Exception e17) {
                w53.b.e("WinkPublish-Export-WinkVideoUtils", e17);
                mediaMetadataRetriever.release();
            }
            if (extractMetadata != null) {
                int parseInt = Integer.parseInt(extractMetadata) * 1000;
                if (Build.VERSION.SDK_INT >= 27) {
                    scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(parseInt * position, 2, 100, 100);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e18) {
                        w53.b.d("WinkPublish-Export-WinkVideoUtils", "retriever.release error", e18);
                    }
                    return scaledFrameAtTime;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? frameAtTime = mediaMetadataRetriever.getFrameAtTime(parseInt * position, 2);
                objectRef.element = frameAtTime;
                if (frameAtTime != 0) {
                    int width = frameAtTime.getWidth() * ((int) (100 / Math.max(r12, frameAtTime.getHeight())));
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap((Bitmap) objectRef.element, width, width, true);
                    Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
                    mediaMetadataRetriever.release();
                    return createScaledBitmap;
                }
                mediaMetadataRetriever.release();
                return null;
            }
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e19) {
                w53.b.d("WinkPublish-Export-WinkVideoUtils", "retriever.release error", e19);
            }
            return null;
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e26) {
                w53.b.d("WinkPublish-Export-WinkVideoUtils", "retriever.release error", e26);
            }
            throw th5;
        }
    }

    private final boolean g(ArrayList<LocalMediaInfo> oriMedias) {
        if (oriMedias == null) {
            return false;
        }
        if (!oriMedias.isEmpty()) {
            Iterator<T> it = oriMedias.iterator();
            while (it.hasNext()) {
                if (e93.i.I((LocalMediaInfo) it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void h(final LocalMediaInfo localMediaInfo, final long retCode, final String traceId, final String businessName, final int type, final long timeCost, final JsonArray reportData) {
        ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.ae
            @Override // java.lang.Runnable
            public final void run() {
                af.i(traceId, retCode, businessName, type, timeCost, localMediaInfo, reportData);
            }
        }, 128, null, false);
        w53.b.c("WinkPublish-Export-WinkVideoUtils", "path:" + localMediaInfo.path + ", retCode:" + retCode + ", type:" + type + ", bitrate:" + localMediaInfo.mediaBitrate + ", timeCost:" + timeCost + ", data:" + reportData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, long j3, String businessName, int i3, long j16, LocalMediaInfo localMediaInfo, JsonArray jsonArray) {
        String str2;
        Intrinsics.checkNotNullParameter(businessName, "$businessName");
        Intrinsics.checkNotNullParameter(localMediaInfo, "$localMediaInfo");
        WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
        WinkPublishQualityReportData.Builder ext6 = builder.eventId("E_VIDEO_BLACK_CHECK").traceId(str).retCode(String.valueOf(j3)).ext1(businessName).ext2(String.valueOf(i3)).ext3(String.valueOf(j16)).ext4(localMediaInfo.path).ext5(String.valueOf(localMediaInfo.mediaBitrate)).ext6(String.valueOf(localMediaInfo.mDuration));
        if (jsonArray == null || (str2 = jsonArray.toString()) == null) {
            str2 = "";
        }
        ext6.attachInfo(str2);
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            f16.a(builder.getReportData(), 1);
        }
    }

    private final boolean j(LocalMediaInfo targetVideo, long targetBitrate, ArrayList<LocalMediaInfo> oriMedias) {
        long N4 = uq3.c.N4();
        if (g(oriMedias)) {
            if (targetVideo.mediaBitrate < N4) {
                return true;
            }
            return false;
        }
        if (targetBitrate <= 0) {
            w53.b.f("WinkPublish-Export-WinkVideoUtils", "shouldCheckBlack targetBitrate:" + targetBitrate);
            if (targetVideo.mediaBitrate < N4) {
                return true;
            }
            return false;
        }
        double a16 = ay.f326693a.a("qqcircle_wink_video_black_check_bitrate", 0.25d);
        w53.b.f("WinkPublish-Export-WinkVideoUtils", "shouldCheckBlack factor:" + a16 + ", oriBitrate:" + targetVideo.mediaBitrate + ", tarBitrate:" + targetBitrate);
        if (a16 <= 0.0d) {
            if (targetVideo.mediaBitrate < N4) {
                return true;
            }
            return false;
        }
        double d16 = targetBitrate * a16;
        long j3 = targetVideo.mediaBitrate;
        if (j3 < d16 || j3 < N4) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0171  */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.mobileqq.wink.editor.export.af] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ExportErrorCode b(@Nullable LocalMediaInfo info, long targetBitrate, @NotNull String businessName, int type, @Nullable ArrayList<LocalMediaInfo> oriMedias, @Nullable String traceId) {
        ?? r16;
        int i3;
        long j3;
        long K4;
        long j16;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        if (info == null) {
            w53.b.c("WinkPublish-Export-WinkVideoUtils", "info == null");
            return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_NULL, null);
        }
        if (TextUtils.isEmpty(info.path)) {
            w53.b.c("WinkPublish-Export-WinkVideoUtils", "info.path == null");
            return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_NULL, "LocalMediaInfo.path == null");
        }
        File file = new File(info.path);
        if (!file.exists()) {
            w53.b.c("WinkPublish-Export-WinkVideoUtils", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
            return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_NOT_EXIST, null);
        }
        if (file.length() == 0) {
            w53.b.c("WinkPublish-Export-WinkVideoUtils", "info.fileSize == 0");
            return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_SIZE_INVALID, null);
        }
        if (type == 5) {
            try {
                int d16 = d(info, businessName, traceId);
                if (d16 != 0) {
                    if (d16 != 1) {
                        if (d16 != 2) {
                            i3 = 1;
                            j3 = 0;
                        } else {
                            return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK_ERROR, null);
                        }
                    } else {
                        return new ExportErrorCode(0L, null);
                    }
                } else {
                    return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK, null);
                }
            } catch (Throwable th5) {
                th = th5;
                i3 = 1;
                r16 = 0;
                w53.b.e("WinkPublish-Export-WinkVideoUtils", th);
                j3 = r16;
                K4 = uq3.c.K4();
                if (Intrinsics.areEqual("QCIRCLE", businessName)) {
                    K4 = uq3.c.J4();
                }
                j16 = info.mediaBitrate;
                if (j16 < K4) {
                }
            }
        } else {
            r16 = this;
            i3 = 1;
            try {
                int c16 = r16.c(info, targetBitrate, oriMedias, businessName, type, traceId);
                try {
                    if (c16 != 0) {
                        if (c16 != 1) {
                            j3 = 0;
                        } else {
                            return new ExportErrorCode(0L, null);
                        }
                    } else {
                        return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK, null);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    w53.b.e("WinkPublish-Export-WinkVideoUtils", th);
                    j3 = r16;
                    K4 = uq3.c.K4();
                    if (Intrinsics.areEqual("QCIRCLE", businessName)) {
                    }
                    j16 = info.mediaBitrate;
                    if (j16 < K4) {
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                r16 = 0;
            }
        }
        K4 = uq3.c.K4();
        if (Intrinsics.areEqual("QCIRCLE", businessName) && (type == i3 || type == 4 || type == 5)) {
            K4 = uq3.c.J4();
        }
        j16 = info.mediaBitrate;
        if (j16 < K4) {
            w53.b.c("WinkPublish-Export-WinkVideoUtils", "info.mediaBitrate == " + j16 + " this video maybe black");
            if (oriMedias == null || oriMedias.size() != i3) {
                i3 = 0;
            }
            if (i3 != 0) {
                LocalMediaInfo it = oriMedias.get(0);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (e93.i.I(it)) {
                    long j17 = it.mediaBitrate;
                    if (j17 < 2 * K4) {
                        w53.b.c("WinkPublish-Export-WinkVideoUtils", "originVideo bitrate:" + j17);
                        return new ExportErrorCode(j3, null);
                    }
                }
                return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_INVALID, null);
            }
            if (info.mediaBitrate == j3) {
                return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_ZERO, null);
            }
            return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_INVALID, null);
        }
        return new ExportErrorCode(j3, null);
    }

    @NotNull
    public final String e(@NotNull String businessName, @NotNull String missionID, int type) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        String str = u53.b.f438374e;
        String str2 = File.separator;
        String lowerCase = businessName.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        String str3 = str + str2 + lowerCase;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str3 + str2 + "output_" + missionID + "_" + System.currentTimeMillis() + "_" + type + ".mp4";
    }
}
