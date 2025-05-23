package com.tencent.mobileqq.wink.editor.export;

import android.graphics.Bitmap;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkInitManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra;
import com.tencent.mobileqq.wink.editor.ds;
import com.tencent.mobileqq.wink.editor.export.j;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRCacheManager;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import com.tencent.tavcut.core.render.exporter.IExporter;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.ComposeRenderLayer;
import common.config.service.QzoneConfig;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmClassMappingKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.device.OfflineConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.LightAssetUtils;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
/* loaded from: classes21.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private ICutSession f320219a;

    /* renamed from: b, reason: collision with root package name */
    private IExporter f320220b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f320221c = false;

    /* renamed from: d, reason: collision with root package name */
    private CountDownLatch f320222d = null;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, WinkEditorFragment.b> f320223e = new ConcurrentHashMap<>(4);

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends com.tencent.tavcut.core.operator.b {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b extends com.tencent.tavcut.core.operator.b {
        b() {
        }

        @Override // com.tencent.tavcut.core.operator.b, com.tencent.tavcut.core.operator.c
        /* renamed from: b */
        public boolean getF318735b() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class c extends com.tencent.tavcut.core.operator.b {
        c() {
        }

        @Override // com.tencent.tavcut.core.operator.b, com.tencent.tavcut.core.operator.c
        /* renamed from: b */
        public boolean getF318735b() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class d implements IExporter.ExportListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f320226a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f320227b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f320228c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f320229d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f320230e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f320231f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f320232g;

        d(int i3, int i16, int i17, long j3, String str, LocalMediaInfo localMediaInfo, CountDownLatch countDownLatch) {
            this.f320226a = i3;
            this.f320227b = i16;
            this.f320228c = i17;
            this.f320229d = j3;
            this.f320230e = str;
            this.f320231f = localMediaInfo;
            this.f320232g = countDownLatch;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(float f16, float f17, float f18, WinkEditorFragment.b bVar) {
            bVar.setProgress(f16 + (f17 * f18));
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportCancel() {
            CountDownLatch countDownLatch;
            ms.a.c("WinkExportManager", "onGoNext... exportVideo onExportCancel");
            if (!j.this.f320221c && (countDownLatch = this.f320232g) != null) {
                countDownLatch.countDown();
            }
            j.this.f(this.f320228c, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.export.k
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((WinkEditorFragment.b) obj).b();
                }
            });
            j.this.f(this.f320228c, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.export.l
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((WinkEditorFragment.b) obj).e(false);
                }
            });
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportCompleted(@Nullable String str) {
            ms.a.c("WinkExportManager", "onGoNext... exportVideo onExportCompleted:" + str);
            ms.a.a("WinkExportManager", "hdr enhance all time without pretreatment\uff1a " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - this.f320229d));
            if (!j.this.f320221c) {
                WinkHDRCacheManager.d().g(this.f320230e, this.f320231f.path);
                j.this.f320219a.release();
                CountDownLatch countDownLatch = this.f320232g;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
            if (this.f320227b == this.f320226a - 1) {
                j.this.f(this.f320228c, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.export.n
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        ((WinkEditorFragment.b) obj).e(true);
                    }
                });
            }
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportError(int i3, @Nullable String str) {
            ms.a.c("WinkExportManager", "onGoNext... exportVideo onExportError, errorCode:" + i3 + " errorMsg:" + str);
            if (!j.this.f320221c) {
                j.this.f320219a.release();
                CountDownLatch countDownLatch = this.f320232g;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
            if (this.f320227b == this.f320226a - 1) {
                j.this.f(this.f320228c, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.export.m
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        ((WinkEditorFragment.b) obj).e(false);
                    }
                });
            }
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExportStart() {
            ms.a.c("WinkExportManager", "onGoNext... exportVideo onExportStart");
            u.M2();
        }

        @Override // com.tencent.tavcut.core.render.exporter.IExporter.ExportListener
        public void onExporting(final float f16, long j3, long j16, long j17) {
            final float f17 = 1.0f / this.f320226a;
            final float f18 = this.f320227b * f17;
            j.this.f(this.f320228c, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.export.o
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    j.d.h(f18, f16, f17, (WinkEditorFragment.b) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class e extends com.tencent.tavcut.core.operator.b {
        e() {
        }

        @Override // com.tencent.tavcut.core.operator.b, com.tencent.tavcut.core.operator.c
        /* renamed from: b */
        public boolean getF318735b() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface g {
        void a(ICutSession iCutSession, Size size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        static final j f320237a = new j();
    }

    j() {
    }

    private boolean A(v vVar) {
        if (vVar != null && vVar.b() != null && vVar.b().enableDeblur == 1) {
            return true;
        }
        return false;
    }

    private boolean B(v vVar) {
        if (vVar != null && vVar.c()) {
            return true;
        }
        return false;
    }

    private boolean C(v vVar) {
        if (vVar != null && vVar.b() != null && vVar.b().enableDelogo == 1) {
            return true;
        }
        return false;
    }

    private static boolean E(int i3, int i16) {
        if (i16 <= i3) {
            i3 = i16;
        }
        if (i3 >= 1080) {
            return true;
        }
        return false;
    }

    public static boolean F(WinkExportParams winkExportParams) {
        if (!"QZONE".equals(winkExportParams.D)) {
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_qzone_compress_hdr", true);
    }

    private static boolean G(List<WinkEditData> list) {
        ResourceModel resourceModel;
        SizeF sizeF;
        if (list != null && list.size() != 0) {
            list.get(0).getMediaModel();
            for (MediaClip mediaClip : list.get(0).getMediaModel().videos) {
                if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
                    int i3 = (int) sizeF.width;
                    int i16 = (int) sizeF.height;
                    ms.a.f("WinkExportManager", "HD isResHasHD:(" + i3 + "," + i16);
                    if (E(i3, i16)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean H() {
        QzoneConfig.getInstance();
        int winkHighVideoBitRateEnable = QzoneConfig.getWinkHighVideoBitRateEnable();
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (!TextUtils.isEmpty(account)) {
            try {
                if (Integer.parseInt(account.substring(account.length() - 1)) < winkHighVideoBitRateEnable) {
                    return true;
                }
                return false;
            } catch (Exception e16) {
                w53.b.e("WinkExportManager", e16);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(float f16, float f17, WinkEditorFragment.b bVar) {
        bVar.setProgress(f16 + f17);
    }

    public static boolean K() {
        return WinkInitManager.INSTANCE.a().d();
    }

    @NotNull
    public static CustomRenderConfig L() {
        boolean booleanValue;
        if (u53.i.f438428a == null) {
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.context);
            u53.i.f438428a = Boolean.valueOf(QzoneConfig.isOpenFFmpegDecode(phonePerfLevel, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()));
            w53.b.c("WinkExportManager", "[wns][prepareFFmpegDecodeConfig] deviceLevel = " + phonePerfLevel + " , isOpenFFmpegDecode = " + u53.i.f438428a);
        } else {
            w53.b.c("WinkExportManager", "[wns][prepareFFmpegDecodeConfig] isOpenFFmpegDecode =" + u53.i.f438428a);
        }
        CustomRenderConfig customRenderConfig = new CustomRenderConfig();
        Boolean bool = u53.i.f438428a;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        customRenderConfig.setEnableFastSoftDecode(booleanValue);
        customRenderConfig.setSoftDecodeThreadCount(u53.i.f438429b.intValue());
        return customRenderConfig;
    }

    private void P(String str, boolean z16, boolean z17) {
        String str2;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z17) {
            str2 = o(str);
        } else {
            str2 = str;
        }
        WinkEditDataWrapper c16 = com.tencent.mobileqq.wink.editor.draft.a.c(str2);
        if (c16 == null) {
            return;
        }
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        c16.setUseHD(i3);
        if (z17) {
            com.tencent.mobileqq.wink.editor.draft.a.i(c16, str);
        } else {
            com.tencent.mobileqq.wink.editor.draft.a.h(c16, str);
        }
    }

    public static void Q(ExportOutput exportOutput, boolean z16, int i3) {
        if (H()) {
            q.f(exportOutput, z16, i3);
        }
    }

    public static boolean S() {
        QzoneConfig.getInstance();
        if (!QzoneConfig.isWinkEditorSupportOriginFrameRate()) {
            ms.a.c("WinkExportManager", "wns not support OriginFrameRate");
            return false;
        }
        QzoneConfig.getInstance();
        String aEPicTemPlateFilterBlackList = QzoneConfig.getAEPicTemPlateFilterBlackList();
        if (!TextUtils.isEmpty(aEPicTemPlateFilterBlackList) && aEPicTemPlateFilterBlackList.contains(DeviceInfoMonitor.getModel())) {
            ms.a.c("WinkExportManager", "blacklist not support OriginFrameRate");
            return false;
        }
        return true;
    }

    public static void T(ICutSession iCutSession, List<String> list, WinkEditDataWrapper winkEditDataWrapper) {
        if (iCutSession != null && list != null && winkEditDataWrapper != null && !"fakeMid_template_bgm".equals(winkEditDataWrapper.getSelectMusicMid())) {
            for (Entity entity : iCutSession.queryEntityByComponent(JvmClassMappingKt.getKotlinClass(AudioSource.class))) {
                AudioSource audioSource = (AudioSource) com.tencent.videocut.render.extension.d.d(entity, JvmClassMappingKt.getKotlinClass(AudioSource.class));
                if (audioSource != null && list.contains(audioSource.getSrc())) {
                    iCutSession.switchEntitySync(entity, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3, Consumer<WinkEditorFragment.b> consumer) {
        WinkEditorFragment.b bVar = this.f320223e.get(Integer.valueOf(i3));
        if (bVar != null) {
            consumer.accept(bVar);
        }
    }

    public static boolean g(VideoFormatInfo videoFormatInfo, boolean z16, boolean z17, WinkExportParams winkExportParams) {
        String str;
        if (videoFormatInfo == null) {
            QLog.w("WinkExportManager", 1, "[canCompressHdrVideo] invalid input");
            return false;
        }
        if (Build.VERSION.SDK_INT < 29) {
            QLog.w("WinkExportManager", 1, "[canCompressHdrVideo] os version not permitted");
            return false;
        }
        if (!z17) {
            if (F(winkExportParams)) {
                QLog.w("WinkExportManager", 1, "[canCompressHdrVideo] compress by h264");
            } else {
                QLog.w("WinkExportManager", 1, "[canCompressHdrVideo] cannot compress by h264");
                return false;
            }
        }
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger("color-standard", videoFormatInfo.getColorStandard());
        mediaFormat.setInteger("color-transfer", videoFormatInfo.getColorTransfer());
        if (z17) {
            str = "video/hevc";
        } else {
            str = "video/avc";
        }
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("profile", videoFormatInfo.getProfile());
        mediaFormat.setInteger("level", videoFormatInfo.getLevel());
        try {
            MediaCodecList mediaCodecList = new MediaCodecList(0);
            String findEncoderForFormat = mediaCodecList.findEncoderForFormat(mediaFormat);
            if (TextUtils.isEmpty(findEncoderForFormat)) {
                if (z16) {
                    QLog.i("WinkExportManager", 1, "[canCompressHdrVideo] no encoder found, retry by remove profile and level");
                    mediaFormat.removeKey("profile");
                    mediaFormat.removeKey("level");
                } else {
                    QLog.d("WinkExportManager", 1, "[canCompressHdrVideo] no encoder found and no retry");
                    return false;
                }
            } else {
                WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId("T_CATCH_IMPORTANT_INFO").ext1("hdr_video_encoder").ext2(findEncoderForFormat).ext3(String.valueOf(videoFormatInfo.getColorStandard())).ext4(String.valueOf(videoFormatInfo.getColorTransfer())).ext5(String.valueOf(videoFormatInfo.getProfile())).ext6(String.valueOf(videoFormatInfo.getLevel())).getReportData(), 1);
            }
            String findEncoderForFormat2 = mediaCodecList.findEncoderForFormat(mediaFormat);
            QLog.d("WinkExportManager", 1, "[canCompressHdrVideo] codec name=" + findEncoderForFormat2);
            if (!TextUtils.isEmpty(findEncoderForFormat2)) {
                return true;
            }
        } catch (Exception e16) {
            QLog.w("WinkExportManager", 1, "[canCompressHdrVideo]", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WinkExportManager", 2, "[canCompressHdrVideo] no encoder found");
        }
        return false;
    }

    public static boolean h(LocalMediaInfo localMediaInfo, VideoFormatInfo videoFormatInfo, boolean z16, WinkExportParams winkExportParams) {
        if (!QzoneConfig.isWinkPublishEnableCompressHDR()) {
            QLog.d("WinkExportManager", 1, "[canUploadHdrVideo] wns disabled");
            return false;
        }
        if (videoFormatInfo == null) {
            QLog.d("WinkExportManager", 1, "[canUploadHdrVideo] invalid input");
            return false;
        }
        if (!videoFormatInfo.isHdrVideo()) {
            QLog.d("WinkExportManager", 1, "[canUploadHdrVideo] not hdr video");
            return false;
        }
        if (!g(videoFormatInfo, true, z16, winkExportParams)) {
            QLog.d("WinkExportManager", 1, "[canUploadHdrVideo] cannot compress hdr video");
            return false;
        }
        WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId("QFS_T_CATCH_IMPORTANT_INFO").ext1("hdr_video_hit").ext2(String.valueOf(localMediaInfo.mediaBitrate)).ext3(String.valueOf(videoFormatInfo.getColorStandard())).ext4(String.valueOf(videoFormatInfo.getColorTransfer())).ext5(String.valueOf(videoFormatInfo.getProfile())).ext6(String.valueOf(videoFormatInfo.getLevel())).getReportData(), 1);
        if (QLog.isColorLevel()) {
            QLog.d("WinkExportManager", 2, "[canUploadHdrVideo] can upload hdr video");
        }
        return true;
    }

    public static void m(VideoFormatInfo videoFormatInfo, ExportOutput exportOutput, boolean z16, WinkExportParams winkExportParams) {
        boolean g16 = g(videoFormatInfo, false, z16, winkExportParams);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[fillHdrInfo] os version=");
        int i3 = Build.VERSION.SDK_INT;
        sb5.append(i3);
        sb5.append(", canFillProfileAndLevel=");
        sb5.append(g16);
        QLog.d("WinkExportManager", 1, sb5.toString());
        if (g16 && videoFormatInfo.getProfile() > 0 && videoFormatInfo.getLevel() > 0) {
            exportOutput.setFormatInteger("profile", videoFormatInfo.getProfile());
            exportOutput.setFormatInteger("level", videoFormatInfo.getLevel());
        }
        if (i3 >= 24) {
            if (videoFormatInfo.getColorStandard() > 0) {
                exportOutput.setFormatInteger("color-standard", videoFormatInfo.getColorStandard());
            }
            if (videoFormatInfo.getColorTransfer() > 0) {
                exportOutput.setFormatInteger("color-transfer", videoFormatInfo.getColorTransfer());
            }
            if (videoFormatInfo.getHdrStaticInfo() != null) {
                exportOutput.setFormatByteBuffer("hdr-static-info", ByteBuffer.wrap(videoFormatInfo.getHdrStaticInfo()));
            }
            exportOutput.setFormatInteger("color-range", 1);
        }
        if (i3 >= 29 && videoFormatInfo.getHdr10PlusInfo() != null) {
            exportOutput.setFormatByteBuffer("hdr10-plus-info", ByteBuffer.wrap(videoFormatInfo.getHdr10PlusInfo()));
        }
    }

    public static void n(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null || QAlbumUtil.getMediaType(localMediaInfo) != 1 || e93.i.E(localMediaInfo)) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            } catch (Exception e16) {
                ms.a.d("WinkExportManager", "fixVideoWidthAndHeight", e16);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "export_" + str;
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "preview_" + str;
    }

    public static ICutSession q(WinkEditDataWrapper winkEditDataWrapper, g gVar) {
        ms.a.c("WinkExportManager", "create export cutsession");
        CustomRenderConfig L = L();
        rd4.c cVar = rd4.c.f431135f;
        ICutSession h16 = cVar.h(L);
        h16.setWatermarkConfig(winkEditDataWrapper.getWatermarkConfig());
        h16.setTemplateDir(com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper));
        LAKRenderModel y16 = cVar.y(new ArrayList());
        h16.getIClipSourceOperator().h(new e());
        h16.setRenderModel(y16);
        ComposeRenderLayer composeRenderLayer = new ComposeRenderLayer(h16, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO, ComposeRenderLayer.RunningMode.EXPORT);
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        if (editDatas != null && editDatas.size() == 1) {
            Iterator<WinkEditData> it = editDatas.iterator();
            while (it.hasNext()) {
                WinkEditData next = it.next();
                if (next.getAssetData() != null) {
                    h16.setAssetData(v(winkEditDataWrapper.getTemplateFilePath()), next.getAssetData());
                }
            }
            MediaModel mediaModel = editDatas.get(0).getMediaModel();
            if (mediaModel != null) {
                if (winkEditDataWrapper.getTemplateFilePath() != null) {
                    h16.setRenderModel(com.tencent.mobileqq.wink.editor.template.a.b(h16.getAllInputSourceRenderModel(), com.tencent.videocut.render.extension.e.z(mediaModel.videos, false, Boolean.FALSE), false));
                } else {
                    h16.getIClipSourceOperator().g(com.tencent.videocut.render.extension.e.z(mediaModel.videos, false, Boolean.FALSE));
                }
                h16.setCutStatusListener(new f(gVar, h16, mediaModel));
                h16.bindCutPlayer(rd4.c.f431135f.g(null));
                composeRenderLayer.i(true);
                composeRenderLayer.l(mediaModel);
            }
        }
        return h16;
    }

    public static ICutSession r(WinkEditDataWrapper winkEditDataWrapper, g gVar) {
        ICutSession q16 = q(winkEditDataWrapper, gVar);
        q16.getIClipSourceOperator().h(new a());
        return q16;
    }

    public static j t() {
        return h.f320237a;
    }

    public static LAKRenderModel u(ICutSession iCutSession, Size size) {
        LAKRenderModel E = WinkExportUtils.E(iCutSession, size, null);
        iCutSession.release();
        return E;
    }

    public static String v(String str) {
        if (str != null) {
            try {
                return new File(str).getParent() + File.separator;
            } catch (Exception e16) {
                ms.a.c("WinkExportManager", "getTemplateDir exception:" + e16.getMessage());
            }
        }
        return "/";
    }

    public static List<String> w(WinkEditDataWrapper winkEditDataWrapper) {
        ArrayList arrayList = new ArrayList();
        if (winkEditDataWrapper == null) {
            return arrayList;
        }
        LightAssetDataContext d16 = com.tencent.videocut.render.utils.b.f384205a.d(winkEditDataWrapper.getTemplateFilePath());
        if (d16 == null) {
            return arrayList;
        }
        Iterator<Entity> it = com.tencent.videocut.render.extension.d.a(d16.getRootEntity(), JvmClassMappingKt.getKotlinClass(AudioSource.class)).iterator();
        while (it.hasNext()) {
            AudioSource audioSource = (AudioSource) com.tencent.videocut.render.extension.d.d(it.next(), JvmClassMappingKt.getKotlinClass(AudioSource.class));
            if (audioSource != null) {
                arrayList.add(audioSource.getSrc());
            }
        }
        return arrayList;
    }

    public static int x(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        int i3 = 0;
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            int i16 = 0;
            while (i3 < trackCount) {
                try {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                    if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                        i16 = trackFormat.getInteger("frame-rate");
                    }
                    i3++;
                } catch (Throwable th5) {
                    th = th5;
                    i3 = i16;
                    try {
                        w53.b.e("WinkExportManager", th);
                        mediaExtractor.release();
                        return i3;
                    } finally {
                        mediaExtractor.release();
                    }
                }
            }
            return i16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @RequiresApi(api = 16)
    public static int y(ArrayList<LocalMediaInfo> arrayList, int i3, int i16, boolean z16) {
        String str;
        int i17 = 30;
        if (!S()) {
            return 30;
        }
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<LocalMediaInfo> it = arrayList.iterator();
            int i18 = 0;
            while (it.hasNext()) {
                LocalMediaInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.path)) {
                    if (QAlbumUtil.getMediaType(next) == 0) {
                        if (i18 < 30) {
                            i18 = 30;
                        }
                    } else {
                        int x16 = x(next.path);
                        if (i18 < x16) {
                            i18 = x16;
                        }
                    }
                }
            }
            int i19 = 24;
            if (i18 <= 24) {
                i18 = 24;
            }
            if (i18 > 60) {
                i18 = 60;
            }
            if (z16) {
                str = "video/hevc";
            } else {
                str = "video/avc";
            }
            try {
                if (CodecHelper.queryMaxHardwareVideoEncodeInstanceCount(str, i18, i3, i16) < 1.5d) {
                    if (i18 <= 24) {
                        i19 = i18;
                    }
                    w53.b.c("WinkExportManager", "hardware not supportOriginFrameRate");
                    i17 = i19;
                } else {
                    i17 = i18;
                }
            } catch (Throwable th5) {
                w53.b.d("WinkExportManager", "queryMaxHardwareVideoEncodeInstanceCount error", th5);
            }
            w53.b.c("WinkExportManager", "exported video fps:" + i17);
        }
        return i17;
    }

    public static boolean z(WinkEditDataWrapper winkEditDataWrapper) {
        Integer editMode = winkEditDataWrapper.getEditMode();
        if (editMode != null && editMode.intValue() == 0) {
            return G(winkEditDataWrapper.getEditDatas());
        }
        ms.a.f("WinkExportManager", "HD hasHDVideo:edit mode is not video.");
        return false;
    }

    public boolean D() {
        return this.f320221c;
    }

    public void M() {
        this.f320223e.clear();
    }

    public void N() {
        this.f320221c = false;
    }

    public void O(String str, boolean z16) {
        P(str, z16, true);
        P(str, z16, false);
    }

    public boolean R(String str) {
        WinkEditDataWrapper c16;
        if (TextUtils.isEmpty(str) || (c16 = com.tencent.mobileqq.wink.editor.draft.a.c(str)) == null || !z(c16) || !WinkExportUtils.V()) {
            return false;
        }
        return true;
    }

    public void i() {
        w53.b.f("WinkExportManager", "cancelExport");
        IExporter iExporter = this.f320220b;
        if (iExporter != null) {
            iExporter.cancelExport();
        }
        ICutSession iCutSession = this.f320219a;
        if (iCutSession != null) {
            iCutSession.release();
        }
    }

    public void j() {
        this.f320221c = true;
        CountDownLatch countDownLatch = this.f320222d;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        i();
    }

    public void k(String str, String str2, int i3, int i16, v vVar, int i17, int i18, WinkEditorFragment.b bVar) {
        int i19;
        if (bVar != null) {
            i19 = bVar.hashCode();
        } else {
            i19 = 0;
        }
        if (bVar != null) {
            this.f320223e.put(Integer.valueOf(i19), bVar);
        }
        rd4.c.t(BaseApplication.getContext(), "", "lightsdk_qq", WinkContext.INSTANCE.i(true));
        rd4.b.f431129b.b(false);
        w53.a.e(4);
        ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
        this.f320219a = createLAKCutSession;
        createLAKCutSession.getIClipSourceOperator().h(new b());
        TimeRange timeRange = new TimeRange(0L, (int) 1000000);
        rd4.c cVar = rd4.c.f431135f;
        ClipSource a16 = cVar.n().a(str2, timeRange);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a16);
        this.f320219a.setRenderModel(cVar.y(arrayList));
        String str3 = u53.b.f438376g + QQWinkConstants.HDR_MATERIAL_PATH;
        this.f320219a.setTemplateDir(str3);
        this.f320219a.flushWithoutDelay();
        LAKRenderModel allInputSourceRenderModel = this.f320219a.getAllInputSourceRenderModel();
        allInputSourceRenderModel.setJsonData(LightAssetUtils.getAssetJsonString(this.f320219a.getLightAsset()));
        try {
            ICoverProvider d16 = cVar.d(allInputSourceRenderModel, new Size(i17, i18), str3, null, null);
            u.M2();
            IRenderChainManager renderChainManagerAndInit = d16.getRenderChainManagerAndInit();
            if (renderChainManagerAndInit != null) {
                renderChainManagerAndInit.switchPicEnhanceAbility(Constants.ENHANCE_TYPE.BLUR, A(vVar));
                renderChainManagerAndInit.switchPicEnhanceAbility(Constants.ENHANCE_TYPE.WATERMARK, C(vVar));
                renderChainManagerAndInit.switchPicEnhanceAbility(Constants.ENHANCE_TYPE.HDR, B(vVar));
                HashMap<String, String> hashMap = new HashMap<>();
                String a17 = vVar.a();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("path", a17);
                } catch (JSONException e16) {
                    ms.a.d("WinkExportManager", "convert cache path json config error: ", e16);
                }
                String jSONObject2 = jSONObject.toString();
                hashMap.put("event.script.lightsdk.watermark.cache_file_path", jSONObject2);
                if (vVar.b().enableFace == 0) {
                    hashMap.put(Constants.PIC_ENHANCE_KEY_DE_FACE, "false");
                } else if (vVar.b().enableFace == 1) {
                    hashMap.put(Constants.PIC_ENHANCE_KEY_DE_FACE, "true");
                } else if (vVar.b().enableFace == 2) {
                    hashMap.put(Constants.PIC_ENHANCE_KEY_DE_FACE, "tiny");
                }
                renderChainManagerAndInit.setAssetData(hashMap);
                ms.a.f("WinkExportManager", "pass cacheDir=" + jSONObject2);
            }
            Bitmap coverAtTime = d16.getCoverAtTime(0L);
            if (coverAtTime != null) {
                FileUtils.saveBitmapToFile(coverAtTime, str);
                coverAtTime.recycle();
            }
            final float f16 = 1.0f / i16;
            final float f17 = i3 * f16;
            f(i19, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.export.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    j.I(f17, f16, (WinkEditorFragment.b) obj);
                }
            });
            WinkHDRCacheManager.d().g(str2, str);
            if (i3 == i16 - 1) {
                f(i19, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.export.i
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        ((WinkEditorFragment.b) obj).e(true);
                    }
                });
            }
            d16.release();
        } catch (Exception e17) {
            ms.a.d("WinkExportManager", "startExport ERROR", e17);
        }
    }

    public void l(WinkEditDataWrapper winkEditDataWrapper, int i3, int i16, int i17, v vVar, int i18, int i19, CountDownLatch countDownLatch, WinkEditorFragment.b bVar) {
        int i26;
        float f16;
        String str;
        ms.a.f("WinkExportManager", "exportVideoSingle for clip#" + i3 + ", needEnhanceIndex = " + i16 + ", width = " + i18 + ", height = " + i19 + ", qualityOption = " + vVar);
        if (countDownLatch != null && !this.f320221c) {
            if (bVar != null) {
                i26 = bVar.hashCode();
            } else {
                i26 = 0;
            }
            if (bVar != null) {
                this.f320223e.put(Integer.valueOf(bVar.hashCode()), bVar);
            }
            this.f320222d = countDownLatch;
            LocalMediaInfo outMediaInfo = winkEditDataWrapper.getOutMediaInfo();
            if (WinkHDRCacheManager.d().b(outMediaInfo.mOriginPath.get(i3)) != null) {
                countDownLatch.countDown();
                return;
            }
            long nanoTime = System.nanoTime();
            rd4.c.t(BaseApplication.getContext(), "", "lightsdk_qq", WinkContext.INSTANCE.i(true));
            rd4.b.f431129b.b(false);
            w53.a.e(4);
            CustomRenderConfig L = L();
            rd4.c cVar = rd4.c.f431135f;
            ICutSession h16 = cVar.h(L);
            this.f320219a = h16;
            h16.getIClipSourceOperator().h(new c());
            String str2 = outMediaInfo.mOriginPath.get(i3);
            ClipSource b16 = cVar.n().b(str2, new TimeRange(0L, (int) outMediaInfo.mDuration));
            ArrayList arrayList = new ArrayList();
            arrayList.add(b16);
            this.f320219a.setRenderModel(cVar.y(arrayList));
            ICutSession iCutSession = this.f320219a;
            String str3 = u53.b.f438376g;
            iCutSession.setTemplateDir(str3);
            Size size = new Size(i18, i19);
            if (i18 > i19) {
                f16 = 1000.0f;
            } else {
                f16 = 0.0f;
            }
            this.f320219a.updateRenderSize(size, f16);
            this.f320219a.flushWithoutDelay();
            ExportOutput exportOutput = new ExportOutput(i18, i19);
            exportOutput.setFixOutputSize(true);
            exportOutput.setFrameRate(30);
            IExporter f17 = cVar.f(this.f320219a.getAllInputSourceRenderModel(), L());
            this.f320220b = f17;
            f17.setExportListener(new d(i17, i16, i26, nanoTime, str2, outMediaInfo, countDownLatch));
            this.f320220b.export(exportOutput, outMediaInfo.path, v(str3 + "/edit_pic_enhance_preface_88830/template.json"), false);
            this.f320220b.setRenderSyncMode(false, 30);
            this.f320220b.switchPicEnhance(Constants.ENHANCE_TYPE.BLUR, A(vVar));
            this.f320220b.switchPicEnhance(Constants.ENHANCE_TYPE.WATERMARK, C(vVar));
            this.f320220b.switchPicEnhance(Constants.ENHANCE_TYPE.HDR, false);
            HashMap<String, String> hashMap = new HashMap<>();
            String a16 = vVar.a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("path", a16);
                str = "WinkExportManager";
            } catch (JSONException e16) {
                str = "WinkExportManager";
                ms.a.d(str, "convert cache path json config error: ", e16);
            }
            String jSONObject2 = jSONObject.toString();
            hashMap.put("event.script.lightsdk.watermark.cache_file_path", jSONObject2);
            if (vVar.b().enableFace == 0) {
                hashMap.put(Constants.PIC_ENHANCE_KEY_DE_FACE, "false");
            } else if (vVar.b().enableFace == 1) {
                hashMap.put(Constants.PIC_ENHANCE_KEY_DE_FACE, "true");
            } else if (vVar.b().enableFace == 2) {
                hashMap.put(Constants.PIC_ENHANCE_KEY_DE_FACE, "tiny");
            }
            this.f320220b.setAssetData(v(u53.b.f438376g + "/edit_pic_enhance_preface_88830/template.json"), hashMap);
            if (winkEditDataWrapper.getEditDatas() != null) {
                Iterator<WinkEditData> it = winkEditDataWrapper.getEditDatas().iterator();
                while (it.hasNext()) {
                    WinkEditData next = it.next();
                    Map<String, WinkStickerModelExtra> stickerExtraMap = next.getStickerExtraMap();
                    if (stickerExtraMap != null) {
                        Iterator<String> it5 = stickerExtraMap.keySet().iterator();
                        while (it5.hasNext()) {
                            WinkStickerModelExtra winkStickerModelExtra = next.getStickerExtraMap().get(it5.next());
                            if (winkStickerModelExtra.getEntityName() != null) {
                                this.f320220b.updateTrackedStickerPosition(ds.a(winkStickerModelExtra.getStickerTrackerResult()), winkStickerModelExtra.getEntityName(), winkStickerModelExtra.getEntityId());
                            }
                        }
                    }
                }
            }
            ms.a.f(str, "pass cacheDir=" + jSONObject2);
        }
    }

    public int s(String str) {
        WinkEditDataWrapper c16;
        if (TextUtils.isEmpty(str) || (c16 = com.tencent.mobileqq.wink.editor.draft.a.c(str)) == null) {
            return 0;
        }
        return c16.getUseHD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class f implements ICutStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f320234a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICutSession f320235b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MediaModel f320236c;

        f(g gVar, ICutSession iCutSession, MediaModel mediaModel) {
            this.f320234a = gVar;
            this.f320235b = iCutSession;
            this.f320236c = mediaModel;
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
            ms.a.f("WinkExportManager", "----->onRenderChainReady !!!!");
            g gVar = this.f320234a;
            ICutSession iCutSession = this.f320235b;
            SizeF sizeF = this.f320236c.backgroundModel.renderSize;
            gVar.a(iCutSession, new Size((int) sizeF.width, (int) sizeF.height));
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity entity) {
        }
    }
}
