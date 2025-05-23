package com.tencent.mobileqq.wink.editor.export;

import android.graphics.BitmapFactory;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.JsonObject;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.extractor.ExtractorUtils;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Painting;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.ComposeRenderLayer;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.light.WatermarkConfig;
import org.light.WatermarkReplacement;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.LightAssetDataType;
import org.light.lightAssetKit.LightAssetUtils;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkExportUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f320106a = File.separator;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends com.tencent.tavcut.core.operator.b {
        a() {
        }

        @Override // com.tencent.tavcut.core.operator.b, com.tencent.tavcut.core.operator.c
        /* renamed from: b */
        public boolean getF318735b() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void a(ICutSession iCutSession, LAKRenderModel lAKRenderModel);
    }

    public static String A(String str) {
        return AECameraPrefsUtil.f318476n + "_" + str + "_params";
    }

    public static String B(String str) {
        return AECameraPrefsUtil.f318475m + "_" + str;
    }

    public static String C(String str) {
        return AECameraPrefsUtil.f318475m + "_" + str + "_params";
    }

    @Nullable
    public static String D(String str) {
        String str2 = f320106a;
        if (str != null) {
            try {
                return new File(str).getParent() + File.separator;
            } catch (Exception e16) {
                ms.a.c("WinkPublish-Export-WinkExportUtils", "getTemplateDir exception:" + e16.getMessage());
                return str2;
            }
        }
        return str2;
    }

    public static LAKRenderModel E(ICutSession iCutSession, Size size, LAKRenderModel lAKRenderModel) {
        if (iCutSession != null && size != null) {
            if (lAKRenderModel == null) {
                lAKRenderModel = iCutSession.getAllInputSourceRenderModel();
            }
            e(LightAssetDataContext.make(iCutSession.getLightAsset(), LightAssetDataType.EntityTree), lAKRenderModel, size);
        }
        return lAKRenderModel;
    }

    public static boolean F(WinkEditDataWrapper winkEditDataWrapper) {
        Integer editMode = winkEditDataWrapper.getEditMode();
        if (editMode != null && editMode.intValue() == 0) {
            return K(winkEditDataWrapper.getEditDatas());
        }
        ms.a.f("WinkPublish-Export-WinkExportUtils", "HD hasHDVideo:edit mode is not video.");
        return false;
    }

    public static boolean G() {
        if (!R()) {
            return false;
        }
        rd4.c.t(BaseApplication.getContext(), "", "lightsdk_qq", WinkContext.INSTANCE.i(true));
        rd4.b.f431129b.b(false);
        w53.a.e(4);
        return true;
    }

    public static boolean H(WinkEditDataWrapper winkEditDataWrapper) {
        if (winkEditDataWrapper == null || winkEditDataWrapper.getEditDatas().size() <= 0 || !winkEditDataWrapper.getEditDatas().get(0).getOpenHDR()) {
            return false;
        }
        return true;
    }

    public static boolean I(int i3, int i16) {
        if (i16 <= i3) {
            i3 = i16;
        }
        if (i3 >= 1080) {
            return true;
        }
        return false;
    }

    public static boolean J(WinkEditDataWrapper winkEditDataWrapper) {
        if (winkEditDataWrapper == null) {
            w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid input");
            return false;
        }
        Integer editMode = winkEditDataWrapper.getEditMode();
        if (editMode != null && editMode.intValue() == 0) {
            ArrayList<LocalMediaInfo> n3 = com.tencent.mobileqq.wink.editor.draft.c.n(winkEditDataWrapper);
            if (n3 != null && n3.size() == 1) {
                LocalMediaInfo localMediaInfo = n3.get(0);
                if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.path)) {
                    if (!"video/mp4".equalsIgnoreCase(localMediaInfo.mMimeType)) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid media mime type, mime=" + localMediaInfo.mMimeType);
                        return false;
                    }
                    File file = new File(localMediaInfo.path);
                    if (!file.exists()) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] file not exist");
                        return false;
                    }
                    if (file.length() == 0) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] file.length == 0");
                        return false;
                    }
                    if (localMediaInfo.mediaBitrate < uq3.c.K4() && localMediaInfo.mediaBitrate > 0) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] file.mediaBitrate = " + localMediaInfo.mediaBitrate);
                        return false;
                    }
                    if (winkEditDataWrapper.getOriginVolume() > 0.0f) {
                        return false;
                    }
                    if (TextUtils.isEmpty(winkEditDataWrapper.getMusicPath())) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isOnlyAddMusicSingleVideo] musicPath is null");
                        return false;
                    }
                    if (!new File(winkEditDataWrapper.getMusicPath()).exists()) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isOnlyAddMusicSingleVideo] musicFile not exist");
                        return false;
                    }
                    if (!com.tencent.mobileqq.wink.editor.draft.c.z(winkEditDataWrapper)) {
                        return false;
                    }
                    w53.b.c("WinkPublish-Export-WinkExportUtils", "[isOnlyMusicChanged] video is edited");
                    return true;
                }
                w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] LocalMediaInfo is null");
                return false;
            }
            w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid original video");
            return false;
        }
        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid edit mode, mode=" + winkEditDataWrapper.getEditMode());
        return false;
    }

    public static boolean K(List<WinkEditData> list) {
        ResourceModel resourceModel;
        SizeF sizeF;
        if (list != null && list.size() != 0) {
            list.get(0).getMediaModel();
            for (MediaClip mediaClip : list.get(0).getMediaModel().videos) {
                if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
                    int i3 = (int) sizeF.width;
                    int i16 = (int) sizeF.height;
                    ms.a.f("WinkPublish-Export-WinkExportUtils", "HD isResHasHD:(" + i3 + "," + i16);
                    if (I(i3, i16)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean L(WinkEditDataWrapper winkEditDataWrapper) {
        if (winkEditDataWrapper == null || winkEditDataWrapper.getEditDatas() == null || winkEditDataWrapper.getEditDatas().size() <= 0 || winkEditDataWrapper.getEditDatas().get(0).getMediaModel() == null || winkEditDataWrapper.getEditDatas().get(0).getMediaModel().smoothModels == null || winkEditDataWrapper.getEditDatas().get(0).getMediaModel().smoothModels.isEmpty()) {
            return false;
        }
        return true;
    }

    @RequiresApi(api = 16)
    public static boolean M() {
        boolean isHardwareAccelerated;
        if (!QzoneConfig.isWinkPublishEnableHevc()) {
            w53.b.f("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] not enable hevc");
            return false;
        }
        String winkPublishHevcBlacklist = QzoneConfig.getWinkPublishHevcBlacklist();
        if (winkPublishHevcBlacklist.contains(DeviceInfoMonitor.getModel())) {
            w53.b.f("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] in blacklist, model=" + DeviceInfoMonitor.getModel() + ", blacklist=" + winkPublishHevcBlacklist);
            return false;
        }
        int winkPublishHevcOsVersion = QzoneConfig.getWinkPublishHevcOsVersion();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < winkPublishHevcOsVersion) {
            w53.b.f("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] OS Version limited, " + i3 + " < " + winkPublishHevcOsVersion);
            return false;
        }
        if (MobileQQ.sProcessId != 9) {
            w53.b.f("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] not peak ");
            return false;
        }
        MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
        int length = codecInfos.length;
        w53.b.a("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] codec count=" + length);
        for (int i16 = 0; i16 < length; i16++) {
            MediaCodecInfo mediaCodecInfo = codecInfos[i16];
            String name = mediaCodecInfo.getName();
            w53.b.a("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] codec name=" + name);
            if (mediaCodecInfo.isEncoder() && (name.contains("hevc") || name.contains("HEVC"))) {
                if (Build.VERSION.SDK_INT >= 29) {
                    isHardwareAccelerated = mediaCodecInfo.isHardwareAccelerated();
                    if (isHardwareAccelerated) {
                        return true;
                    }
                    w53.b.a("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] encoder not hardware accelerated");
                } else {
                    return true;
                }
            }
        }
        w53.b.f("WinkPublish-Export-WinkExportUtils", "[isSupportHevc] no hevc encoder codec");
        return false;
    }

    public static boolean N(WinkEditDataWrapper winkEditDataWrapper) {
        return O(winkEditDataWrapper, false);
    }

    public static boolean O(WinkEditDataWrapper winkEditDataWrapper, boolean z16) {
        if (winkEditDataWrapper == null) {
            w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid input");
            return false;
        }
        Integer editMode = winkEditDataWrapper.getEditMode();
        if (editMode != null && editMode.intValue() == 0) {
            if (z16) {
                if (com.tencent.mobileqq.wink.editor.draft.c.y(winkEditDataWrapper)) {
                    w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideoV2] video is edited");
                    return false;
                }
            } else if (com.tencent.mobileqq.wink.editor.draft.c.x(winkEditDataWrapper)) {
                w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] video is edited");
                return false;
            }
            ArrayList<LocalMediaInfo> n3 = com.tencent.mobileqq.wink.editor.draft.c.n(winkEditDataWrapper);
            if (n3 != null && n3.size() == 1) {
                LocalMediaInfo localMediaInfo = n3.get(0);
                if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.path)) {
                    if (!"video/mp4".equalsIgnoreCase(localMediaInfo.mMimeType)) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid media mime type, mime=" + localMediaInfo.mMimeType);
                        return false;
                    }
                    File file = new File(localMediaInfo.path);
                    if (!file.exists()) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] file not exist");
                        return false;
                    }
                    if (file.length() == 0) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] file.length == 0");
                        return false;
                    }
                    if (localMediaInfo.mediaBitrate < uq3.c.K4() && localMediaInfo.mediaBitrate > 0) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] file.mediaBitrate = " + localMediaInfo.mediaBitrate);
                        return false;
                    }
                    WatermarkConfig watermarkConfig = winkEditDataWrapper.getWatermarkConfig();
                    if (watermarkConfig != null) {
                        if (!TextUtils.isEmpty(watermarkConfig.materialPath)) {
                            w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] watermarkConfig.materialPath not empty");
                            return false;
                        }
                        WatermarkReplacement[] watermarkReplacementArr = watermarkConfig.replacements;
                        if (watermarkReplacementArr != null && watermarkReplacementArr.length > 0) {
                            w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] watermarkConfig.replacements not empty");
                            return false;
                        }
                    }
                    if (com.tencent.mobileqq.wink.l.g() && !ExtractorUtils.isAudioTrackSupport(localMediaInfo.path)) {
                        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] audio track not support");
                        return false;
                    }
                    w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] is unedited single video");
                    return true;
                }
                w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] LocalMediaInfo is null");
                return false;
            }
            w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid original video");
            return false;
        }
        w53.b.c("WinkPublish-Export-WinkExportUtils", "[isUneditedSingleVideo] invalid edit mode, mode=" + winkEditDataWrapper.getEditMode());
        return false;
    }

    public static boolean P() {
        try {
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (!TextUtils.isEmpty(account)) {
                int parseInt = Integer.parseInt(account.substring(account.length() - 2));
                String[] split = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_compress_gray_config_v2", "20,30").split(",");
                if (split.length == 2) {
                    if (parseInt < Integer.parseInt(split[1])) {
                        if (parseInt < Integer.parseInt(split[0])) {
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e16) {
            w53.b.d("WinkPublish-Export-WinkExportUtils", "isVideoExportCompressOpen", e16);
        }
        return false;
    }

    public static boolean Q() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_new_compress_gray", false)) {
            try {
                String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
                if (!TextUtils.isEmpty(account)) {
                    int parseInt = Integer.parseInt(account.substring(account.length() - 2));
                    String[] split = "80,90".split(",");
                    if (split.length == 2 && parseInt >= Integer.parseInt(split[0])) {
                        if (parseInt < Integer.parseInt(split[1])) {
                            return true;
                        }
                    }
                }
            } catch (Exception e16) {
                w53.b.d("WinkPublish-Export-WinkExportUtils", "isVideoExportNewCompressOpen", e16);
            }
        }
        return false;
    }

    public static boolean R() {
        boolean e16 = com.tencent.mobileqq.wink.l.e();
        rd4.c.u(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightAssetsDir());
        w53.b.f("WinkPublish-Export-WinkExportUtils", "loadLightAssets result : loadLibResult = " + e16);
        return e16;
    }

    public static boolean S(WinkEditDataWrapper winkEditDataWrapper) {
        ArrayList<WinkEditData> editDatas;
        List<MediaClip> list;
        ResourceModel resourceModel;
        if (winkEditDataWrapper == null || (editDatas = winkEditDataWrapper.getEditDatas()) == null || editDatas.size() == 0) {
            return false;
        }
        Iterator<WinkEditData> it = editDatas.iterator();
        while (it.hasNext()) {
            MediaModel mediaModel = it.next().getMediaModel();
            if (mediaModel == null || (list = mediaModel.videos) == null) {
                return false;
            }
            for (MediaClip mediaClip : list) {
                if (mediaClip == null || (resourceModel = mediaClip.resource) == null) {
                    return false;
                }
                if (!FileUtils.fileExists(resourceModel.path)) {
                    w53.b.c("WinkPublish-Export-WinkExportUtils", "originFileExists false");
                    return false;
                }
            }
        }
        w53.b.c("WinkPublish-Export-WinkExportUtils", "originFileExists true");
        return true;
    }

    public static void T(String str, LocalMediaInfo localMediaInfo, WinkExportParams winkExportParams) {
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeParcelable(z(str), localMediaInfo);
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeParcelable(A(str), winkExportParams);
    }

    public static void U(String str, LocalMediaInfo localMediaInfo, WinkExportParams winkExportParams) {
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeParcelable(B(str), localMediaInfo);
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeParcelable(C(str), winkExportParams);
    }

    public static boolean V() {
        int i3;
        if (AEModule.getContext() == null) {
            AEModule.setContext(BaseApplication.context);
        }
        int phonePerfLevel = AEOfflineConfig.getPhonePerfLevel();
        if (q.b()) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        ms.a.f("WinkPublish-Export-WinkExportUtils", "HD phoneLevel:" + phonePerfLevel + " level: " + i3);
        if (AEOfflineConfig.getPhonePerfLevel() >= i3) {
            return true;
        }
        return false;
    }

    public static void W(ICutSession iCutSession, LAKRenderModel lAKRenderModel, WinkEditDataWrapper winkEditDataWrapper) {
        if (iCutSession != null && lAKRenderModel != null && winkEditDataWrapper != null && !"fakeMid_template_bgm".equals(winkEditDataWrapper.getSelectMusicMid())) {
            for (Entity entity : iCutSession.queryEntityByComponent(JvmClassMappingKt.getKotlinClass(AudioSource.class))) {
            }
        }
    }

    public static JsonObject a(boolean z16, boolean z17, int i3, int i16) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(AssetExtension.SCENE_EXPORT, String.valueOf(z16));
        jsonObject.addProperty("hitcache", String.valueOf(z17));
        jsonObject.addProperty("type", String.valueOf(i3));
        jsonObject.addProperty("from", String.valueOf(i16));
        return jsonObject;
    }

    public static LocalMediaInfo b(String str) {
        int mediaType = QAlbumUtil.getMediaType(str);
        if (mediaType != 0) {
            if (mediaType != 1) {
                return null;
            }
            return d(str);
        }
        return c(str);
    }

    public static LocalMediaInfo c(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = str;
        localMediaInfo.mMediaType = QAlbumUtil.getMediaType(str);
        localMediaInfo.mediaWidth = options.outWidth;
        localMediaInfo.mediaHeight = options.outHeight;
        localMediaInfo.mMimeType = MimeTypesTools.getMimeType(BaseApplication.getContext(), str);
        return localMediaInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e0, code lost:
    
        r3.videoMimeType = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
    
        if (r9.containsKey("rotation-degrees") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e8, code lost:
    
        r3.rotation = r9.getInteger("rotation-degrees");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f0, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 24) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f6, code lost:
    
        if (r9.containsKey("color-standard") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f8, code lost:
    
        r13 = r9.getInteger("color-standard");
        ms.a.a("WinkPublish-Export-WinkExportUtils", "colorStandard=" + r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0112, code lost:
    
        if (r13 != 6) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0114, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0117, code lost:
    
        r3.isHDRVideo = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0116, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0128, code lost:
    
        if (((com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_set_video_format", true) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012a, code lost:
    
        ms.a.f("WinkPublish-Export-WinkExportUtils", "buildLocalMediaInfoForVideo setVideoFormat");
        com.tencent.mobileqq.wink.utils.o.f326724a.m(r3, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LocalMediaInfo d(String str) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        try {
            localMediaInfo.path = str;
            localMediaInfo.mMimeType = "video/mp4";
            if (!TextUtils.isEmpty(str)) {
                File file = new File(localMediaInfo.path);
                if (file.exists()) {
                    localMediaInfo.fileSize = file.length();
                } else {
                    localMediaInfo.fileSize = 0L;
                }
            } else {
                localMediaInfo.fileSize = 0L;
            }
        } catch (Exception e16) {
            ms.a.d("WinkPublish-Export-WinkExportUtils", "[buildLocalMediaInfo] error ", e16);
        }
        if (localMediaInfo.fileSize == 0) {
            return localMediaInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                localMediaInfo.mDuration = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                localMediaInfo.mediaBitrate = Long.parseLong(mediaMetadataRetriever.extractMetadata(20));
            } catch (Exception e17) {
                ms.a.c("WinkPublish-Export-WinkExportUtils", "buildVideoInfoForReady error: " + e17.getMessage());
            }
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                try {
                    mediaExtractor.setDataSource(str);
                    int trackCount = mediaExtractor.getTrackCount();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= trackCount) {
                            break;
                        }
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                        String string = trackFormat.getString("mime");
                        ms.a.a("WinkPublish-Export-WinkExportUtils", "mime=" + string);
                        if (string != null && string.startsWith("video")) {
                            break;
                        }
                        i3++;
                    }
                } finally {
                    mediaExtractor.release();
                }
            } catch (Exception e18) {
                ms.a.d("WinkPublish-Export-WinkExportUtils", "get videoMimeType error", e18);
            }
            localMediaInfo.addedDate = System.currentTimeMillis();
            localMediaInfo.modifiedDate = System.currentTimeMillis();
            localMediaInfo.isSystemMeidaStore = false;
            localMediaInfo.isMakeVideo = true;
            return localMediaInfo;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static void e(LightAssetDataContext lightAssetDataContext, LAKRenderModel lAKRenderModel, Size size) {
        if (lightAssetDataContext != null && lAKRenderModel != null && size != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("width", Integer.valueOf(size.width));
            jsonObject.addProperty("height", Integer.valueOf(size.height));
            lightAssetDataContext.updateProperty(TtmlNode.TAG_LAYOUT, jsonObject);
            rd4.c.f431135f.a(lightAssetDataContext.getRootEntity(), size);
            lAKRenderModel.setJsonData(LightAssetUtils.getAssetJsonString(lightAssetDataContext.exportLightAsset()));
            Painting painting = lAKRenderModel.getPainting();
            lAKRenderModel.setPainting(new Painting(painting.getBackgroundFillMode(), painting.getBackgroundColor(), size, painting.getFillScale(), painting.getPagPath()));
        }
    }

    public static boolean f(WinkEditDataWrapper winkEditDataWrapper) {
        if (winkEditDataWrapper != null && F(winkEditDataWrapper) && V()) {
            return true;
        }
        return false;
    }

    public static void g(String str) {
        try {
            FileUtils.createDirectory(new File(str).getParent());
        } catch (Exception e16) {
            w53.b.c("WinkPublish-Export-WinkExportUtils", str + "->checkParentDirExit exception:" + e16.getMessage());
        }
    }

    public static void h(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).removeKey(B(str));
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).removeKey(C(str));
    }

    public static void i(WinkEditDataWrapper winkEditDataWrapper) {
        if (winkEditDataWrapper != null) {
            String r16 = com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper);
            String w3 = w();
            w53.b.c("WinkPublish-Export-WinkExportUtils", "deleteTemplateDir dirPath:" + r16 + ", defaultTemplateDirPath:" + w3);
            if ((w3 != null && w3.equals(r16)) || f320106a.equals(r16)) {
                w53.b.c("WinkPublish-Export-WinkExportUtils", "deleteTemplateDir is defaultTemplateDir");
                return;
            }
            if (!TextUtils.isEmpty(r16)) {
                w53.b.c("WinkPublish-Export-WinkExportUtils", "deleteTemplateDir remove dirPath:" + r16);
                FileUtils.deleteDirectory(r16);
            }
        }
    }

    public static void j(WinkExportParams winkExportParams, String str, long j3, String str2, String str3) {
        k(winkExportParams, str, j3, str2, str3, "", "", "", "", "", null);
    }

    public static void k(WinkExportParams winkExportParams, String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, JsonObject jsonObject) {
        if (winkExportParams != null && !TextUtils.isEmpty(str)) {
            if (jsonObject == null) {
                jsonObject = new JsonObject();
            }
            jsonObject.addProperty("process", Integer.valueOf(MobileQQ.sProcessId));
            jsonObject.addProperty("id", String.valueOf(winkExportParams.K));
            jsonObject.addProperty("mission_id", winkExportParams.E);
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 == null) {
                return;
            }
            f16.b(new WinkPublishQualityReportData.Builder().eventId(str).traceId(winkExportParams.F + "").retCode(j3 + "").desc(String.valueOf(str2)).ext1(String.valueOf(str3)).ext2(String.valueOf(str4)).ext3(String.valueOf(str5)).ext4(String.valueOf(str6)).ext5(String.valueOf(str7)).ext6(String.valueOf(str8)).attachInfo(jsonObject.toString()).getReportData(), winkExportParams.D);
        }
    }

    public static void l(ExportOutput exportOutput, String str, int i3) {
        if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_wink_speed_optimization_1")) {
            EncoderWriter.USE_NEW_AUDIO_ENCODE = false;
            exportOutput.setAudioEncodeAsync(false);
            EncoderWriter.PRE_DECODE_AUDIO = false;
        } else {
            EncoderWriter.USE_NEW_AUDIO_ENCODE = "1".equals(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_new_audio_encoder", "1"));
            if (i3 == 1) {
                n63.c cVar = n63.c.f418525a;
                exportOutput.setAudioEncodeAsync(cVar.e());
                EncoderWriter.PRE_DECODE_AUDIO = cVar.f();
            } else {
                exportOutput.setAudioEncodeAsync(false);
                EncoderWriter.PRE_DECODE_AUDIO = false;
            }
        }
        EncoderWriter.ENABLE_CHANGE_AUDIO_BYTEBUFFER_POSITION = "1".equals(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_enable_change_audio_bytebuffer_position", "1"));
    }

    public static void m(LocalMediaInfo localMediaInfo) {
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
                ms.a.d("WinkPublish-Export-WinkExportUtils", "fixVideoWidthAndHeight", e16);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static JsonObject n(LocalMediaInfo localMediaInfo) {
        return o(localMediaInfo, null);
    }

    public static JsonObject o(LocalMediaInfo localMediaInfo, WinkEditDataWrapper winkEditDataWrapper) {
        JsonObject jsonObject = new JsonObject();
        try {
            if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                jsonObject.addProperty("MediaType", localMediaInfo.mMimeType);
                jsonObject.addProperty("width", String.valueOf(localMediaInfo.mediaWidth));
                jsonObject.addProperty("height", String.valueOf(localMediaInfo.mediaHeight));
                jsonObject.addProperty(BasicAnimation.KeyPath.ROTATION, String.valueOf(localMediaInfo.rotation));
                jsonObject.addProperty("bitrate", String.valueOf(localMediaInfo.mediaBitrate));
                jsonObject.addProperty("framerate", String.valueOf(j.x(localMediaInfo.path)));
                jsonObject.addProperty("duration", String.valueOf(localMediaInfo.mDuration));
                jsonObject.addProperty(MediaDBValues.FILESIZE, String.valueOf(localMediaInfo.fileSize));
                jsonObject.addProperty("hdrOpen", String.valueOf(H(winkEditDataWrapper)));
                jsonObject.addProperty("sharpenOpen", String.valueOf(L(winkEditDataWrapper)));
            } else {
                jsonObject.addProperty("MediaType", localMediaInfo.mMimeType);
                jsonObject.addProperty("width", String.valueOf(localMediaInfo.mediaWidth));
                jsonObject.addProperty("height", String.valueOf(localMediaInfo.mediaHeight));
                jsonObject.addProperty(MediaDBValues.FILESIZE, String.valueOf(localMediaInfo.fileSize));
            }
        } catch (Exception e16) {
            w53.b.e("WinkPublish-Export-WinkExportUtils", e16);
        }
        return jsonObject;
    }

    public static long p(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null || TextUtils.isEmpty(localMediaInfo.path)) {
            return 0L;
        }
        long j3 = localMediaInfo.mediaBitrate;
        if (j3 > 0) {
            return j3;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(localMediaInfo.path);
            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(20));
            localMediaInfo.mediaBitrate = parseLong;
            return parseLong;
        } catch (Exception e16) {
            ms.a.c("WinkPublish-Export-WinkExportUtils", "getBitRate error: " + e16.getMessage());
            return 0L;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static LocalMediaInfo q(String str) {
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeParcelable(z(str), LocalMediaInfo.class, null);
        if (localMediaInfo != null) {
            File file = new File(localMediaInfo.path);
            if (!file.exists() || file.length() == 0 || localMediaInfo.mediaBitrate < uq3.c.K4()) {
                return null;
            }
        }
        return localMediaInfo;
    }

    public static WinkExportParams r(String str) {
        return (WinkExportParams) QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeParcelable(A(str), WinkExportParams.class, null);
    }

    public static String s(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(u53.a.f438361b);
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str.toLowerCase());
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb6 + str3 + "output_" + str2 + "_" + System.currentTimeMillis() + "_.mp4";
    }

    public static String t() {
        String str = u53.f.f438410w + File.separator + "background-gaussian-portrait.pag";
        if (!FileUtils.fileExists(str)) {
            g(str);
            com.tencent.mobileqq.wink.utils.r.b(BaseApplication.getContext(), "wink/pag/background-gaussian-portrait.pag", str);
        }
        return str;
    }

    public static ICutSession u(WinkEditDataWrapper winkEditDataWrapper, @NotNull final b bVar) {
        ms.a.c("WinkPublish-Export-WinkExportUtils", "create export cutsession");
        final ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
        createLAKCutSession.setTemplateDir(com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper));
        LAKRenderModel y16 = rd4.c.f431135f.y(new ArrayList());
        createLAKCutSession.getIClipSourceOperator().h(new a());
        createLAKCutSession.setRenderModel(y16);
        W(createLAKCutSession, y16, winkEditDataWrapper);
        ComposeRenderLayer composeRenderLayer = new ComposeRenderLayer(createLAKCutSession, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO, ComposeRenderLayer.RunningMode.EXPORT);
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        if (editDatas != null && editDatas.size() == 1) {
            Iterator<WinkEditData> it = editDatas.iterator();
            while (it.hasNext()) {
                WinkEditData next = it.next();
                if (next.getAssetData() != null) {
                    createLAKCutSession.setAssetData(com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper), next.getAssetData());
                }
            }
            final MediaModel mediaModel = editDatas.get(0).getMediaModel();
            if (mediaModel != null) {
                if (winkEditDataWrapper.getTemplateFilePath() != null) {
                    createLAKCutSession.setRenderModel(com.tencent.mobileqq.wink.editor.template.a.b(createLAKCutSession.getAllInputSourceRenderModel(), com.tencent.videocut.render.extension.e.z(mediaModel.videos, false, Boolean.FALSE), false));
                } else {
                    createLAKCutSession.getIClipSourceOperator().g(com.tencent.videocut.render.extension.e.z(mediaModel.videos, false, Boolean.FALSE));
                }
                createLAKCutSession.setCutStatusListener(new ICutStatusCallback() { // from class: com.tencent.mobileqq.wink.editor.export.WinkExportUtils.2
                    @Override // com.tencent.tavcut.core.session.ICutStatusCallback
                    public void onRenderChainReady() {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.WinkExportUtils.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Size size;
                                SizeF sizeF;
                                ICutSession.this.setCutStatusListener(null);
                                BackgroundModel backgroundModel = mediaModel.backgroundModel;
                                if (backgroundModel != null && (sizeF = backgroundModel.renderSize) != null) {
                                    size = new Size((int) sizeF.width, (int) sizeF.height);
                                } else {
                                    size = null;
                                }
                                LAKRenderModel E = WinkExportUtils.E(ICutSession.this, size, null);
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                bVar.a(ICutSession.this, E);
                            }
                        }, 64, null, false);
                    }

                    @Override // com.tencent.tavcut.core.session.ICutStatusCallback
                    public void onLightEntityReload(@Nullable Entity entity) {
                    }
                });
                createLAKCutSession.bindCutPlayer(rd4.c.f431135f.g(null));
                composeRenderLayer.i(false);
                composeRenderLayer.l(mediaModel);
            }
        }
        return createLAKCutSession;
    }

    public static String v() {
        String str = u53.f.f438410w + File.separator + TemplateBean.TEMPLATE_JSON;
        if (!FileUtils.fileExists(str)) {
            w53.b.f("WinkPublish-Export-WinkExportUtils", "getDefaultCoverTemplatePath start copy cover template.");
            g(str);
            com.tencent.mobileqq.wink.utils.r.b(BaseApplication.getContext(), "json/template_cover_default.json", str);
        }
        return str;
    }

    public static String w() {
        r73.a.f430927a.b();
        return u53.f.f438406s;
    }

    public static LocalMediaInfo x(String str) {
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeParcelable(B(str), LocalMediaInfo.class, null);
        if (localMediaInfo != null) {
            File file = new File(localMediaInfo.path);
            if (!file.exists() || file.length() == 0 || localMediaInfo.mediaBitrate < uq3.c.K4()) {
                return null;
            }
        }
        return localMediaInfo;
    }

    public static WinkExportParams y(String str) {
        return (WinkExportParams) QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeParcelable(C(str), WinkExportParams.class, null);
    }

    public static String z(String str) {
        return AECameraPrefsUtil.f318476n + "_" + str;
    }
}
