package com.tencent.mobileqq.wink.editor.export;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qqlive.tvkplayer.report.capability.TVKDeviceCapabilityReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import r63.MetaVideo;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bJ*\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\nJ6\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/ac;", "", "", "missionId", "Ljava/util/ArrayList;", "Lr63/c;", "Lkotlin/collections/ArrayList;", "e", "", tl.h.F, "", "g", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "dataWrapper", "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR, "a", "durationMs", "f", "videoPath", "startTime", UploadVideoObject.VODEO_FORMAT_H265, "", "i", "c", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "b", "d", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f320179a = new ac();

    ac() {
    }

    private final ArrayList<MetaVideo> e(String missionId) {
        boolean z16;
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeString("merge_video_" + missionId, null);
        if (decodeString != null && decodeString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(decodeString);
            if (jSONArray.length() > 0) {
                ArrayList<MetaVideo> arrayList = new ArrayList<>();
                int length = jSONArray.length();
                long j3 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jsonObject = jSONArray.getJSONObject(i3);
                    MetaVideo.Companion companion = MetaVideo.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    MetaVideo a16 = companion.a(jsonObject);
                    if (a16 != null && a16.getDurationMs() != 0 && FileUtils.fileExists(a16.getPath()) && a16.getStartTimeMs() == j3) {
                        j3 += a16.getDurationMs();
                        arrayList.add(a16);
                    }
                    return null;
                }
                if (!arrayList.isEmpty()) {
                    return arrayList;
                }
            }
        } catch (Exception e16) {
            w53.b.d("WinkPublish-Export-WinkVideoMergeUtils", "getMergeVideoList error", e16);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:9:0x001d, B:11:0x0029, B:16:0x0035, B:18:0x0061, B:20:0x006d, B:22:0x0083), top: B:8:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@NotNull WinkEditDataWrapper dataWrapper, @NotNull WinkExportParams winkExportParams, boolean hdr) {
        ArrayList<MetaVideo> e16;
        boolean z16;
        Intrinsics.checkNotNullParameter(dataWrapper, "dataWrapper");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        if (hdr || !h()) {
            return false;
        }
        try {
            String str = winkExportParams.E;
            Intrinsics.checkNotNullExpressionValue(str, "winkExportParams.mMissionID");
            e16 = e(str);
        } catch (Exception e17) {
            w53.b.d("WinkPublish-Export-WinkVideoMergeUtils", "canVideoMerge error", e17);
            String str2 = winkExportParams.E;
            Intrinsics.checkNotNullExpressionValue(str2, "winkExportParams.mMissionID");
            c(str2);
        }
        if (e16 != null && !e16.isEmpty()) {
            z16 = false;
            if (!z16) {
                if (Intrinsics.areEqual(winkExportParams, (WinkExportParams) QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeParcelable("merge_params" + winkExportParams.E, WinkExportParams.class, null)) && Intrinsics.areEqual(dataWrapper, com.tencent.mobileqq.wink.editor.draft.a.e(winkExportParams.E))) {
                    w53.b.a("WinkPublish-Export-WinkVideoMergeUtils", "canVideoMerge true, metaVideos: " + e16);
                    return true;
                }
                String str3 = winkExportParams.E;
                Intrinsics.checkNotNullExpressionValue(str3, "winkExportParams.mMissionID");
                c(str3);
            }
            return false;
        }
        z16 = true;
        if (!z16) {
        }
        return false;
    }

    @NotNull
    public final ExportErrorCode b(@NotNull LocalMediaInfo localMediaInfo, @NotNull WinkEditDataWrapper dataWrapper, @NotNull WinkExportParams winkExportParams) {
        long duration;
        ExportErrorCode exportErrorCode;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(dataWrapper, "dataWrapper");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        af afVar = af.f320186a;
        String str = winkExportParams.D;
        Intrinsics.checkNotNullExpressionValue(str, "winkExportParams.mBusinessName");
        ExportErrorCode b16 = afVar.b(localMediaInfo, 0L, str, 3, dataWrapper.getOriginMediaInfos(), winkExportParams.F);
        if (!b16.isOK()) {
            return b16;
        }
        long duration2 = dataWrapper.getDuration();
        WinkConfig winkConfig = WinkConfig.f317649a;
        if (duration2 > winkConfig.b()) {
            duration = winkConfig.a();
        } else {
            duration = dataWrapper.getDuration() / 1000;
        }
        if (Math.abs(localMediaInfo.mDuration - duration) > uq3.c.r7()) {
            w53.b.c("WinkPublish-Export-WinkVideoMergeUtils", "video merge error, expectDuration = " + duration + ", realDuration = " + localMediaInfo.mDuration);
            exportErrorCode = new ExportErrorCode(ExportErrorCode.ERROR_CODE_MERGE_ERROR_DURATION, null);
        } else {
            exportErrorCode = new ExportErrorCode(0L, null);
        }
        ExportErrorCode exportErrorCode2 = exportErrorCode;
        ad.c(winkExportParams, "E_VIDEO_EXPORT_MERGE_RESULT", exportErrorCode2.transformedCode(), exportErrorCode2.getMessage(), String.valueOf(duration), String.valueOf(localMediaInfo.mDuration), String.valueOf(Math.abs(localMediaInfo.mDuration - duration)), null, null, null, null, 1920, null);
        return exportErrorCode2;
    }

    public final void c(@NotNull String missionId) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        w53.b.f("WinkPublish-Export-WinkExportUtils", "cleanMergeVideoList");
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).removeKey("merge_video_" + missionId);
    }

    @Nullable
    public final MetaVideo d(@Nullable String videoPath, long startTime, boolean h265) {
        if (TextUtils.isEmpty(videoPath)) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(videoPath);
            MetaVideo.a b16 = new MetaVideo.a().n(1).b(1);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(20);
            Intrinsics.checkNotNull(extractMetadata);
            MetaVideo.a e16 = b16.c(Integer.parseInt(extractMetadata)).e(30.0d);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            Intrinsics.checkNotNull(extractMetadata2);
            MetaVideo.a g16 = e16.g(Integer.parseInt(extractMetadata2));
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
            Intrinsics.checkNotNull(extractMetadata3);
            MetaVideo.a o16 = g16.o(Integer.parseInt(extractMetadata3));
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(24);
            Intrinsics.checkNotNull(extractMetadata4);
            MetaVideo.a l3 = o16.l(Integer.parseInt(extractMetadata4));
            String extractMetadata5 = mediaMetadataRetriever.extractMetadata(9);
            Intrinsics.checkNotNull(extractMetadata5);
            MetaVideo.a i3 = l3.d(Integer.parseInt(extractMetadata5)).f(false).h(false).j(h265).i(true);
            Intrinsics.checkNotNull(videoPath);
            return i3.k(videoPath).m(startTime).a();
        } catch (Exception e17) {
            w53.b.d("WinkPublish-Export-WinkExportUtils", "generateMetaVideo error", e17);
            return null;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    @Nullable
    public final ArrayList<MetaVideo> f(@NotNull String missionId, long durationMs) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        ArrayList<MetaVideo> e16 = e(missionId);
        if (e16 != null) {
            ArrayList<MetaVideo> arrayList = new ArrayList<>();
            Iterator<MetaVideo> it = e16.iterator();
            while (it.hasNext()) {
                MetaVideo next = it.next();
                if (next.getStartTimeMs() >= durationMs) {
                    break;
                }
                arrayList.add(next);
            }
            return arrayList;
        }
        return null;
    }

    public final long g(@NotNull String missionId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        ArrayList<MetaVideo> e16 = e(missionId);
        if (e16 != null && !e16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        long j3 = 0;
        if (z16) {
            return 0L;
        }
        while (e16.iterator().hasNext()) {
            j3 += r6.next().getDurationMs();
        }
        return j3;
    }

    public final boolean h() {
        if (!uq3.c.y5()) {
            return false;
        }
        try {
            String uin = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (!TextUtils.isEmpty(uin)) {
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                String substring = uin.substring(uin.length() - 2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                if (Integer.parseInt(substring) >= uq3.c.O6()) {
                    return false;
                }
                return true;
            }
        } catch (Exception e16) {
            w53.b.d("WinkPublish-Export-WinkVideoMergeUtils", "isVideoMergeOpen", e16);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:7:0x0057, B:9:0x005e, B:14:0x006a, B:15:0x008e, B:18:0x0070), top: B:6:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:7:0x0057, B:9:0x005e, B:14:0x006a, B:15:0x008e, B:18:0x0070), top: B:6:0x0057 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(@NotNull String missionId, @NotNull String videoPath, @NotNull WinkExportParams winkExportParams, @NotNull WinkEditDataWrapper dataWrapper, long startTime, boolean h265) {
        boolean z16;
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        Intrinsics.checkNotNullParameter(dataWrapper, "dataWrapper");
        MetaVideo d16 = d(videoPath, startTime, h265);
        if (d16 == null) {
            return;
        }
        w53.b.f("WinkPublish-Export-WinkVideoMergeUtils", "saveMergeVideoInfo: " + d16);
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeString("merge_video_" + missionId, null);
        try {
            JSONArray jSONArray = new JSONArray();
            if (decodeString != null && decodeString.length() != 0) {
                z16 = false;
                if (z16) {
                    jSONArray = new JSONArray(decodeString);
                } else {
                    QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeParcelable("merge_params" + missionId, winkExportParams);
                    com.tencent.mobileqq.wink.editor.draft.a.j(dataWrapper, missionId);
                }
                jSONArray.mo162put(d16.m());
                QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeString("merge_video_" + missionId, jSONArray.toString());
                w53.b.f("WinkPublish-Export-WinkVideoMergeUtils", "saveMergeVideoInfo success");
            }
            z16 = true;
            if (z16) {
            }
            jSONArray.mo162put(d16.m());
            QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeString("merge_video_" + missionId, jSONArray.toString());
            w53.b.f("WinkPublish-Export-WinkVideoMergeUtils", "saveMergeVideoInfo success");
        } catch (Exception e16) {
            w53.b.d("WinkPublish-Export-WinkVideoMergeUtils", "saveMergeVideoInfo error", e16);
        }
    }
}
