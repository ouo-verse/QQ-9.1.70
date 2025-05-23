package com.tencent.mobileqq.wink.newalbum.collector;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/j;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static String f324089b = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J.\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002J\u0014\u0010\u001c\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0014\u0010\u001d\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J&\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0006J.\u0010'\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ.\u0010*\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010,\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0014\u00107\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0014\u00109\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0014\u0010:\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u00104R\u0014\u0010;\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u00104\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/j$a;", "", "", "scene", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "d", "Lcom/tencent/mobileqq/wink/newalbum/collector/k;", "collectResultInfo", "", "timeCost", "f", "errorCode", "errorDesc", "e", "startReason", "candidateCount", "g", QQWinkConstants.STORY_ID, "totalImageCount", "totalVideoCount", "inValidImageCount", "inValidVideoCount", "i", "", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "processAlbumContexts", tl.h.F, "k", "storyID", "notExposureImageCount", "notExposureVideoCount", "totalCount", "j", "a", "lowQualityCount", "noCameraCount", "usedCount", "b", "hasGPSCount", "noGPSCount", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reportTraceID", "Ljava/lang/String;", "l", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "RESULT_ERROR_GET_DIFF_DB_AND_ALBUM", "I", "RESULT_ERROR_GET_DIFF_OUTPUT_DB_AND_ALBUM", "RESULT_ERROR_GET_ILLEGAL_ALBUM_RSULT", "RESULT_SUCCESS", "SCENE_END", "SCENE_MIDDLE", "SCENE_START", "START_IS_LAST_ENTER", "START_OUT_OF_EACH_DAY_COUNT", "START_OUT_OF_LOOP_THRESHOLD", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.collector.j$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WinkPublishQualityReportData d(int scene, String expName) {
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_TAB").traceId(l()).ext1(String.valueOf(expName)).ext2(String.valueOf(w83.b.f445025a.f(expName))).ext3(String.valueOf(scene)).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData a() {
            WinkPublishQualityReportData.Builder traceId = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_AESTHETICS_COUNT").traceId(l());
            m mVar = m.f324110a;
            return traceId.ext1(String.valueOf(mVar.c() + mVar.b())).ext2(String.valueOf(mVar.c())).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData b(int totalCount, int lowQualityCount, int noCameraCount, int usedCount, long timeCost) {
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_HOLIDAY_COLLECT").traceId(l()).ext1(String.valueOf(totalCount)).ext2(String.valueOf(lowQualityCount)).ext3(String.valueOf(noCameraCount)).ext4(String.valueOf(usedCount)).ext6(String.valueOf(timeCost)).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData c(int totalCount, int hasGPSCount, int noGPSCount, int usedCount, long timeCost) {
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_POI_COLLECT").traceId(l()).ext1(String.valueOf(totalCount)).ext2(String.valueOf(hasGPSCount)).ext3(String.valueOf(noGPSCount)).ext4(String.valueOf(usedCount)).ext6(String.valueOf(timeCost)).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData e(int errorCode, @NotNull String errorDesc) {
            Intrinsics.checkNotNullParameter(errorDesc, "errorDesc");
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_PACKAGE_RESULT").traceId(l()).retCode(String.valueOf(errorCode)).desc(errorDesc).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData f(@NotNull WinkNewAlbumCollectorResultReportInfo collectResultInfo, long timeCost) {
            Intrinsics.checkNotNullParameter(collectResultInfo, "collectResultInfo");
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_PACKAGE_RESULT").traceId(l()).ext1(String.valueOf(timeCost)).ext2(collectResultInfo.getImageCount() + "|" + collectResultInfo.getVideoCount()).ext3(collectResultInfo.getStoryID()).ext4(collectResultInfo.d()).retCode(String.valueOf(collectResultInfo.getErrorCode())).desc(collectResultInfo.getErrorDesc()).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData g(int startReason, int candidateCount) {
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_PACKAGE_START").traceId(l()).ext1(String.valueOf(startReason)).ext2(String.valueOf(candidateCount)).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData h(@NotNull List<WinkNewAlbumContext> processAlbumContexts) {
            Intrinsics.checkNotNullParameter(processAlbumContexts, "processAlbumContexts");
            int i3 = 0;
            long j3 = 0;
            for (WinkNewAlbumContext winkNewAlbumContext : processAlbumContexts) {
                if (winkNewAlbumContext.getNeedReportForward()) {
                    i3++;
                    j3 += winkNewAlbumContext.getReportForwardCost();
                }
            }
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_FORWARD_RESULT").traceId(l()).ext1(String.valueOf(j3)).ext2("1").ext3(String.valueOf(i3)).retCode("0").getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData i(@NotNull String storyId, int totalImageCount, int totalVideoCount, int inValidImageCount, int inValidVideoCount) {
            Intrinsics.checkNotNullParameter(storyId, "storyId");
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_SCORE_INVALID_RESULT").traceId(l()).ext1(totalImageCount + "|" + totalVideoCount).ext2(storyId).ext3(inValidImageCount + "|" + inValidVideoCount).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData j(@NotNull String storyID, int notExposureImageCount, int notExposureVideoCount, int totalCount) {
            Intrinsics.checkNotNullParameter(storyID, "storyID");
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_UNPACKAGE_RESULT").traceId(l()).ext1(notExposureImageCount + "|" + notExposureVideoCount).ext2(String.valueOf(totalCount)).ext3(storyID).getReportData();
        }

        @NotNull
        public final WinkPublishQualityReportData k(@NotNull List<WinkNewAlbumContext> processAlbumContexts) {
            Intrinsics.checkNotNullParameter(processAlbumContexts, "processAlbumContexts");
            int i3 = 0;
            long j3 = 0;
            long j16 = 0;
            long j17 = 0;
            long j18 = 0;
            for (WinkNewAlbumContext winkNewAlbumContext : processAlbumContexts) {
                if (winkNewAlbumContext.getNeedReportScale()) {
                    if (winkNewAlbumContext.getMetaData().D()) {
                        j18++;
                        j17 += winkNewAlbumContext.getReportVideoThumbnailCost();
                    } else {
                        i3++;
                        j3 += winkNewAlbumContext.getReportScaleCost();
                    }
                    j16 += winkNewAlbumContext.getReportSavePhotoCost();
                }
            }
            return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_ALBUM_SCALE_RESULT").traceId(l()).ext1(String.valueOf(j3)).ext2(String.valueOf(j16)).ext3(String.valueOf(j17)).ext4(i3 + "|" + j18).retCode("0").getReportData();
        }

        @NotNull
        public final String l() {
            return j.f324089b;
        }

        public final void m(int scene, @NotNull String expName) {
            Intrinsics.checkNotNullParameter(expName, "expName");
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(d(scene, expName), 1);
            }
        }

        public final void n(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            j.f324089b = str;
        }

        Companion() {
        }
    }
}
