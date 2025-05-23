package com.tencent.mobileqq.wink.editor.export;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b93.OutputData;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.gyailib.library.GYAssessPicQuality;
import com.gyailib.library.GYAssessPicQualityInfo;
import com.gyailib.library.GYAssessPicQualityOption;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.enhance.api.IEnhanceHelper;
import com.tencent.aelight.camera.pref.api.IPhoneConfig;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRCacheManager;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.MD5Utils;
import com.tencent.tav.decoder.VideoDecoder;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.render.thumb.IThumbProvider;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes21.dex */
public class u extends BaseViewModel {
    private WinkEditDataWrapper J;
    private ArrayList<String> K;
    private String L;
    private String M;
    private boolean N;
    private boolean P;

    /* renamed from: m, reason: collision with root package name */
    private CountDownLatch f320263m;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, String> f320262i = new HashMap<>();
    private volatile int C = 0;
    private int D = 0;
    private MutableLiveData<Integer> E = new MutableLiveData<>(0);
    private boolean F = false;
    private final ArrayList<a> G = new ArrayList<>();
    private long H = 0;
    private ArrayList<ArrayList<WinkPublishMediaRecord>> I = new ArrayList<>();
    private boolean Q = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a {

        @SerializedName("costDuration")
        long costDuration;

        @SerializedName("deblurScore")
        float deblurScore;

        @SerializedName("duration")
        long duration;

        @SerializedName("size")
        String size;

        @SerializedName("videoRate")
        long videoRate;

        a(long j3, String str, long j16, long j17, float f16) {
            this.size = "";
            this.videoRate = j3;
            if (str != null) {
                this.size = str;
            }
            this.duration = j16;
            this.costDuration = j17;
            this.deblurScore = f16;
        }
    }

    private void B2(BasePartFragment basePartFragment, ArrayList<String> arrayList, HashMap<String, LocalMediaInfo> hashMap, WinkEditDataWrapper winkEditDataWrapper, String str, boolean z16, HashMap<String, List<String>> hashMap2, boolean z17, MusicSourceViewModel musicSourceViewModel) {
        boolean z18;
        z93.b e16;
        if (basePartFragment != null && basePartFragment.getActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra(QQWinkConstants.PUBLISH_EDIT_DATONG_DATA, WinkDatongCurrentParams.params);
            intent.putExtra(QQWinkConstants.PUBLISH_EDIT_WINK_PUBLISH_DATA, this.I);
            intent.putExtras(basePartFragment.getActivity().getIntent().getExtras());
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap);
            intent.putExtra(QQWinkConstants.IS_EDIT_TEXT, false);
            intent.putExtra(QQWinkConstants.IS_IMAGE_MODEL, z17);
            intent.putExtra(QQWinkConstants.PUBLISH_ENTRANCE, winkEditDataWrapper.getFrom());
            intent.putExtra(QQWinkConstants.MEDIA_DURATION, winkEditDataWrapper.getDuration());
            intent.putExtra(QQWinkConstants.MISSION_ID, winkEditDataWrapper.getMissionId());
            if (WinkExportUtils.V() && j.z(winkEditDataWrapper)) {
                z18 = true;
            } else {
                z18 = false;
            }
            intent.putExtra(QQWinkConstants.COULD_SHOW_HD, z18);
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, basePartFragment.getActivity().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
            intent.putExtra("xsj_ref_pgid", str);
            intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, z16);
            intent.putExtra(QQWinkConstants.PUBLISH_EDIT_MEDIA_LABEL_DATA, hashMap2);
            intent.putExtra(QQWinkConstants.SCHEMA_TARGET, basePartFragment.getActivity().getIntent().getStringExtra(QQWinkConstants.SCHEMA_TARGET));
            intent.putExtra(QQWinkConstants.PUBLISH_THROUGH_EXPORT, true);
            intent.putExtra(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE, basePartFragment.getActivity().getIntent().getIntExtra(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE, 0));
            intent.putExtra(QQWinkConstants.KEY_MATE_ACTIVITY_UI_STYLE, basePartFragment.getActivity().getIntent().getSerializableExtra(QQWinkConstants.KEY_MATE_ACTIVITY_UI_STYLE));
            ms.a.a("WinkExportViewModel", "setQzoneMaterialInfo.nextStepToPublishFragment.. captureId = " + basePartFragment.getActivity().getIntent().getStringExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_NAME));
            O1(basePartFragment, intent);
            if (this.P) {
                try {
                    intent.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE, this.N);
                    intent.putExtra(QQWinkConstants.PUBLISH_TEMPLATE_TOPIC, this.L);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            c2(intent, musicSourceViewModel);
            if (u2(basePartFragment.getActivity().getIntent())) {
                basePartFragment.getActivity().setResult(-1, intent);
                basePartFragment.getActivity().finish();
                return;
            }
            OutputData a16 = OutputData.INSTANCE.a(2L, new ArrayList(hashMap.values()), intent);
            r93.h.f430993a.c(basePartFragment, a16.getBundle(), a16.e(), winkEditDataWrapper);
            if (!WinkContext.INSTANCE.d().m().k(basePartFragment.getContext(), a16) && (e16 = Wink.INSTANCE.e()) != null) {
                e16.a(basePartFragment.getContext(), intent);
                return;
            }
            return;
        }
        ms.a.c("WinkExportViewModel", "nextStepToPublishFragment error hostFragment == null");
    }

    private void C2(ArrayList<a> arrayList, long j3) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_POSITION, Integer.valueOf(((IPhoneConfig) QRoute.api(IPhoneConfig.class)).getPhoneLevel()));
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_EFFICIENCY_INFO);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_EFFICIENCY_LVTM, Long.valueOf(((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_START_DETECT)));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_INPUT_INFO, new Gson().toJson(arrayList));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_LENGTH, Long.valueOf(j3));
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkCommonEvents(WinkDaTongReportConstant.ElementParamValue.XSJ_ENHANCE_ORECHECK, buildElementParams);
    }

    public static HashMap<String, List<String>> K2(HashMap<String, LocalMediaInfo> hashMap, List<MediaModel> list, Map<String, ? extends List<String>> map) {
        LocalMediaInfo localMediaInfo;
        HashMap<String, List<String>> hashMap2 = new HashMap<>();
        if (list != null && map != null) {
            for (MediaModel mediaModel : list) {
                List<String> list2 = map.get(mediaModel.id);
                if (hashMap.containsKey(mediaModel.id)) {
                    localMediaInfo = hashMap.get(mediaModel.id);
                } else {
                    localMediaInfo = null;
                }
                if (localMediaInfo != null) {
                    hashMap2.put(localMediaInfo.path, list2);
                }
            }
        }
        return hashMap2;
    }

    public static HashMap<String, List<String>> L2(String str, List<String> list) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str) && list != null) {
            hashMap.put(str, list);
        }
        return hashMap;
    }

    public static void M2() {
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        if (lightBundleMap != null) {
            String str = lightBundleMap.get(LightConstants.AgentType.PIC_ENHANCE_AGENT);
            w53.b.a("WinkExportViewModel", "updatePicEnhanceAIPath---picEnhancePath: " + str);
            if (!TextUtils.isEmpty(str)) {
                rd4.c.f431135f.B(LightConstants.AgentType.PIC_ENHANCE_AGENT, str);
            }
            String str2 = lightBundleMap.get("FACE_AGENT");
            w53.b.f("WinkExportViewModel", "updatePicEnhanceAIPath---facePath: " + str2);
            if (!TextUtils.isEmpty(str2)) {
                rd4.c.f431135f.B("FACE_AGENT", str2);
            }
            String str3 = lightBundleMap.get("MEDIA_PRECHECK");
            w53.b.a("WinkExportViewModel", "updatePicEnhanceAIPath---picQualityPath: " + str3);
            if (!TextUtils.isEmpty(str3)) {
                rd4.c.f431135f.B("MEDIA_PRECHECK", str3);
            }
        }
    }

    private void O1(BasePartFragment basePartFragment, Intent intent) {
        if (basePartFragment.getActivity() != null && basePartFragment.getActivity().getIntent() != null) {
            Intent intent2 = basePartFragment.getActivity().getIntent();
            String stringExtra = intent2.getStringExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_TYPE);
            String stringExtra2 = intent2.getStringExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_NAME);
            ms.a.f("WinkExportViewModel", "addQzoneLibParams type = " + stringExtra + ", name = " + stringExtra2);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                intent.putExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_TYPE, stringExtra);
                intent.putExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_NAME, stringExtra2);
            }
        }
    }

    public static LocalMediaInfo P1(ArrayList<String> arrayList, @NonNull String str, int i3, int i16, HashSet<String> hashSet, String str2) {
        return Q1(arrayList, str, i3, i16, hashSet, str2, new LocalMediaInfo());
    }

    public static LocalMediaInfo Q1(ArrayList<String> arrayList, @NonNull String str, int i3, int i16, HashSet<String> hashSet, String str2, LocalMediaInfo localMediaInfo) {
        Size h16 = com.tencent.mobileqq.wink.utils.f.h(str);
        if (h16 != null && h16.getWidth() > 0 && h16.getHeight() > 0) {
            localMediaInfo.mediaHeight = h16.getHeight();
            localMediaInfo.mediaWidth = h16.getWidth();
        } else {
            localMediaInfo.mediaHeight = i16;
            localMediaInfo.mediaWidth = i3;
        }
        localMediaInfo.mMimeType = "image/jpeg";
        localMediaInfo.path = str;
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (hashSet != null && hashSet.size() > 0) {
            arrayList2.addAll(hashSet);
        }
        localMediaInfo.mHashTagList = arrayList2;
        localMediaInfo.mOriginPath = arrayList;
        localMediaInfo.missionID = str2;
        return localMediaInfo;
    }

    public static LocalMediaInfo R1(ArrayList<String> arrayList, @NonNull String str, int i3, int i16, @NonNull String str2, @Nullable String str3, @NonNull String str4, @androidx.annotation.Nullable ArrayList<String> arrayList2, long j3) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.thumbHeight = i16;
        localMediaInfo.thumbWidth = i3;
        localMediaInfo.path = str2;
        localMediaInfo.mediaHeight = i16;
        localMediaInfo.mediaWidth = i3;
        localMediaInfo.mMimeType = "video/mp4";
        localMediaInfo.addedDate = System.currentTimeMillis();
        localMediaInfo.modifiedDate = System.currentTimeMillis();
        localMediaInfo.thumbnailPath = str3;
        localMediaInfo.mDuration = j3;
        localMediaInfo.isSystemMeidaStore = false;
        localMediaInfo.isMakeVideo = false;
        localMediaInfo.isVideoReady = false;
        localMediaInfo.missionID = str4;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.addAll(arrayList2);
            localMediaInfo.mHashTagList = arrayList3;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        localMediaInfo.mOriginPath = arrayList;
        ms.a.a("WinkExportViewModel", "buildLocalMediaInfoForNotReady: info = " + localMediaInfo.toString());
        return localMediaInfo;
    }

    public static List<BaseEffectNode> T1(WinkEditData winkEditData) {
        return null;
    }

    public static LocalMediaInfo U1(List<MediaClip> list, String str, String str2, String str3, int i3, int i16, ArrayList<String> arrayList, long j3) {
        ArrayList arrayList2 = new ArrayList();
        for (int i17 = 0; i17 < list.size(); i17++) {
            arrayList2.add(list.get(i17).resource.path);
        }
        ms.a.f("WinkExportViewModel", "createLocalMediaInfo... originPathList:" + arrayList2);
        return R1(arrayList2, "", i3, i16, str, str2, str3, arrayList, j3);
    }

    private GYAssessPicQualityOption W1(ClipSource clipSource, MediaClip mediaClip, GYAssessPicQuality gYAssessPicQuality) {
        GYAssessPicQualityOption gYAssessPicQualityOption = new GYAssessPicQualityOption();
        org.light.lightAssetKit.components.Size size = new org.light.lightAssetKit.components.Size();
        GYDetectCommonResultStruct gYDetectCommonResultStruct = new GYDetectCommonResultStruct();
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && !TextUtils.isEmpty(resourceModel.path)) {
            Bitmap j3 = com.tencent.mobileqq.wink.utils.f.j(resourceModel.path, 1280, 720, false);
            if (j3 == null) {
                return gYAssessPicQualityOption;
            }
            size.width = j3.getWidth();
            size.height = j3.getHeight();
            IThumbProvider i3 = rd4.c.f431135f.i(clipSource, size);
            ms.a.a("WinkExportViewModel", "detectRes: " + gYAssessPicQuality.forward(j3, gYDetectCommonResultStruct, 0.0d, 6));
            j3.recycle();
            i3.release();
            ms.a.f("WinkExportViewModel", "getInfoRes: " + gYAssessPicQuality.getPicEnhanceOption(gYAssessPicQualityOption));
            gYAssessPicQuality.clearCachedData();
            gYAssessPicQualityOption.enableDeblur = 0;
            gYAssessPicQualityOption.enableFace = 0;
        }
        return gYAssessPicQualityOption;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private GYAssessPicQualityOption Z1(ClipSource clipSource, MediaClip mediaClip, GYAssessPicQuality gYAssessPicQuality) {
        long j3;
        int i3;
        int i16;
        long j16;
        long j17;
        float f16;
        ClipSource clipSource2;
        float f17;
        Iterator<Long> it;
        long j18;
        int extraMaxDuration;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        int l26 = l2(mediaClip);
        int k26 = k2(mediaClip);
        GYAssessPicQualityOption gYAssessPicQualityOption = new GYAssessPicQualityOption();
        if (s2(clipSource)) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(clipSource.getPath());
                j3 = Long.parseLong(mediaMetadataRetriever.extractMetadata(20)) / 1000;
                try {
                    l26 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    k26 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    long parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000;
                    i3 = l26;
                    j16 = j3;
                    j17 = parseInt;
                    i16 = k26;
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    i3 = l26;
                    i16 = k26;
                    j16 = j3;
                    j17 = 0;
                    ms.a.f("WinkExportViewModel", "detectPicQuality, width = " + i3 + ", height = " + i16);
                    GYDetectCommonResultStruct gYDetectCommonResultStruct = new GYDetectCommonResultStruct();
                    org.light.lightAssetKit.components.Size size = new org.light.lightAssetKit.components.Size();
                    size.width = i3;
                    size.height = i16;
                    GYAssessPicQualityInfo gYAssessPicQualityInfo = new GYAssessPicQualityInfo();
                    List<Long> g26 = g2((int) j17);
                    int size2 = g26.size();
                    if (!s2(clipSource)) {
                    }
                    long j19 = j16;
                    gYAssessPicQualityInfo.initStruct(f16, i3, i16, (float) j17, 6 - y53.c.a(), !s2(clipSource) ? 1 : 0, size2, WinkHDRPicQualityDetectUtils.f320445a.h());
                    ms.a.f("WinkExportViewModel", "setPicInfoRes: " + gYAssessPicQuality.setupWithPicQualityInfo(gYAssessPicQualityInfo));
                    if (j17 == clipSource.getDuration()) {
                    }
                    boolean z17 = VideoDecoder.FIX_DECODE_CROP_SIZE;
                    VideoDecoder.FIX_DECODE_CROP_SIZE = false;
                    IThumbProvider i17 = rd4.c.f431135f.i(clipSource2, size);
                    if (clipSource2.getSpeed() == null) {
                    }
                    f17 = 1.0f;
                    float f18 = f17;
                    it = g26.iterator();
                    while (it.hasNext()) {
                    }
                    j18 = j17;
                    long j26 = currentTimeMillis;
                    i17.release();
                    VideoDecoder.FIX_DECODE_CROP_SIZE = z17;
                    ms.a.f("WinkExportViewModel", "getInfoRes: " + gYAssessPicQuality.getPicEnhanceOption(gYAssessPicQualityOption));
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_VIDEOLENGTH, Long.valueOf(j18));
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_FACE, Integer.valueOf(gYAssessPicQualityOption.enableFace));
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_DEBLUR, Integer.valueOf(gYAssessPicQualityOption.enableDeblur));
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_WATERMARK, Integer.valueOf(gYAssessPicQualityOption.enableDelogo));
                    gYAssessPicQuality.clearCachedData();
                    extraMaxDuration = ((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().getExtraMaxDuration();
                    if (j18 > extraMaxDuration) {
                    }
                    this.G.add(new a(j19, i3 + ":" + i16, j18, System.currentTimeMillis() - j26, gYAssessPicQualityOption.deblurAvgScore));
                    this.H = this.H + j18;
                    return gYAssessPicQualityOption;
                }
            } catch (Exception e17) {
                e = e17;
                j3 = 0;
            }
            ms.a.f("WinkExportViewModel", "detectPicQuality, width = " + i3 + ", height = " + i16);
            GYDetectCommonResultStruct gYDetectCommonResultStruct2 = new GYDetectCommonResultStruct();
            org.light.lightAssetKit.components.Size size3 = new org.light.lightAssetKit.components.Size();
            size3.width = i3;
            size3.height = i16;
            GYAssessPicQualityInfo gYAssessPicQualityInfo2 = new GYAssessPicQualityInfo();
            List<Long> g262 = g2((int) j17);
            int size22 = g262.size();
            if (!s2(clipSource)) {
                f16 = (float) j16;
            } else {
                f16 = 0.0f;
            }
            long j192 = j16;
            gYAssessPicQualityInfo2.initStruct(f16, i3, i16, (float) j17, 6 - y53.c.a(), !s2(clipSource) ? 1 : 0, size22, WinkHDRPicQualityDetectUtils.f320445a.h());
            ms.a.f("WinkExportViewModel", "setPicInfoRes: " + gYAssessPicQuality.setupWithPicQualityInfo(gYAssessPicQualityInfo2));
            if (j17 == clipSource.getDuration()) {
                clipSource2 = clipSource.copy(clipSource.getSourceId(), clipSource.getPath(), clipSource.getType(), j17 * 1000000, clipSource.getSpeed(), clipSource.getVolume(), 0L, clipSource.getMatrix(), clipSource.getPhotoEffectPath(), clipSource.getTransform(), clipSource.getClipRect(), clipSource.getByteArray(), clipSource.getAutoLoop());
            } else {
                clipSource2 = clipSource;
            }
            boolean z172 = VideoDecoder.FIX_DECODE_CROP_SIZE;
            VideoDecoder.FIX_DECODE_CROP_SIZE = false;
            IThumbProvider i172 = rd4.c.f431135f.i(clipSource2, size3);
            if (clipSource2.getSpeed() == null && clipSource2.getSpeed().floatValue() > 0.0f) {
                f17 = clipSource2.getSpeed().floatValue();
            } else {
                f17 = 1.0f;
            }
            float f182 = f17;
            it = g262.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                long j27 = j17;
                Bitmap thumbAtTime = i172.getThumbAtTime(((float) longValue) / f182);
                long j28 = currentTimeMillis;
                IThumbProvider iThumbProvider = i172;
                int forward = gYAssessPicQuality.forward(thumbAtTime, gYDetectCommonResultStruct2, longValue / 1000.0d, 6);
                if (forward != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("detectRes error: ");
                    sb5.append(forward);
                    sb5.append(", time is ");
                    sb5.append(longValue);
                    sb5.append(" bitmap is null ");
                    if (thumbAtTime == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    ms.a.c("WinkExportViewModel", sb5.toString());
                }
                if (thumbAtTime != null) {
                    thumbAtTime.recycle();
                }
                j17 = j27;
                i172 = iThumbProvider;
                currentTimeMillis = j28;
            }
            j18 = j17;
            long j262 = currentTimeMillis;
            i172.release();
            VideoDecoder.FIX_DECODE_CROP_SIZE = z172;
            ms.a.f("WinkExportViewModel", "getInfoRes: " + gYAssessPicQuality.getPicEnhanceOption(gYAssessPicQualityOption));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_VIDEOLENGTH, Long.valueOf(j18));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_FACE, Integer.valueOf(gYAssessPicQualityOption.enableFace));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_DEBLUR, Integer.valueOf(gYAssessPicQualityOption.enableDeblur));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_WATERMARK, Integer.valueOf(gYAssessPicQualityOption.enableDelogo));
            gYAssessPicQuality.clearCachedData();
            extraMaxDuration = ((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().getExtraMaxDuration();
            if (j18 > extraMaxDuration) {
                gYAssessPicQualityOption.enableFace = 0;
                ms.a.f("WinkExportViewModel", "duration time is more than " + extraMaxDuration + ProgressTracer.SEPARATOR + j18);
            }
            this.G.add(new a(j192, i3 + ":" + i16, j18, System.currentTimeMillis() - j262, gYAssessPicQualityOption.deblurAvgScore));
            this.H = this.H + j18;
            return gYAssessPicQualityOption;
        }
        return W1(clipSource, mediaClip, gYAssessPicQuality);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2, reason: merged with bridge method [inline-methods] */
    public void x2(Map<Integer, v> map, GYAssessPicQualityOption gYAssessPicQualityOption, WinkEditorFragment.b bVar, List<MediaClip> list, List<MediaClip> list2, WinkEditDataWrapper winkEditDataWrapper) {
        String str;
        boolean z16;
        String str2;
        int i3;
        String str3;
        boolean z17;
        boolean z18 = true;
        if (this.C == 1) {
            return;
        }
        M2();
        if (gYAssessPicQualityOption.enableDeblur == 0 && gYAssessPicQualityOption.enableDelogo == 0 && gYAssessPicQualityOption.enableFace == 0) {
            w53.b.a("WinkExportViewModel", "\u5f00\u542f\u5b9e\u65f6hdr\uff0c\u7ed3\u675f");
            bVar.d();
            Iterator<MediaClip> it = list.iterator();
            while (it.hasNext()) {
                ResourceModel resourceModel = it.next().resource;
                if (resourceModel != null && WinkHDRCacheManager.d().b(resourceModel.path) == null) {
                    WinkHDRCacheManager d16 = WinkHDRCacheManager.d();
                    String str4 = resourceModel.path;
                    d16.g(str4, str4);
                }
            }
            return;
        }
        w53.b.a("WinkExportViewModel", "\u5f00\u542f\u5b9e\u65f6hdr\uff0c\u7ee7\u7eed\u540e\u7eed\u589e\u5f3a\u903b\u8f91");
        this.D = 2;
        this.E.postValue(2);
        j.t().N();
        Wink.Companion companion = Wink.INSTANCE;
        if (companion != null && companion.a() != null) {
            str = companion.a().getCameraMaterialUnZipDownload();
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            str = "";
        }
        String str5 = str;
        LinkedHashMap<MediaClip, v> j26 = j2(map, list, list2);
        int size = j26.size();
        int i16 = 0;
        int i17 = 0;
        for (MediaClip mediaClip : j26.keySet()) {
            v vVar = j26.get(mediaClip);
            int indexOf = list.indexOf(mediaClip);
            ResourceModel resourceModel2 = mediaClip.resource;
            String str6 = resourceModel2.path;
            MediaType mediaType = resourceModel2.type;
            long j3 = resourceModel2.sourceDuration;
            SizeF sizeF = resourceModel2.size;
            float f16 = sizeF.width;
            float f17 = sizeF.height;
            File file2 = new File(str6);
            if (mediaType == MediaType.VIDEO) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str5);
                sb5.append(File.separator);
                sb5.append("output_");
                str2 = str5;
                sb5.append(System.currentTimeMillis());
                sb5.append("_");
                sb5.append(i2(file2.getName()));
                sb5.append(".mp4");
                int i18 = (int) f16;
                int i19 = (int) f17;
                winkEditDataWrapper.setOutMediaInfo(U1(list, sb5.toString(), "", "", i18, i19, null, j3));
                z16 = true;
                this.f320263m = new CountDownLatch(1);
                i3 = i16;
                j.t().l(winkEditDataWrapper, indexOf, i17, size, vVar, i18, i19, this.f320263m, bVar);
                CountDownLatch countDownLatch = this.f320263m;
                if (countDownLatch != null) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                    this.f320263m = null;
                }
                if (j.t().D()) {
                    this.D = i3;
                    this.E.postValue(Integer.valueOf(i3));
                    return;
                }
            } else {
                z16 = z18;
                str2 = str5;
                i3 = i16;
                if (mediaType == MediaType.IMAGE) {
                    StringBuilder sb6 = new StringBuilder();
                    str3 = str2;
                    sb6.append(str3);
                    sb6.append(File.separator);
                    sb6.append("output_");
                    sb6.append(System.currentTimeMillis());
                    sb6.append("_");
                    sb6.append(i2(file2.getName()));
                    sb6.append(".jpg");
                    i16 = 0;
                    z17 = true;
                    j.t().k(sb6.toString(), str6, i17, size, vVar, (int) f16, (int) f17, bVar);
                    if (j.t().D()) {
                        this.D = 0;
                        this.E.postValue(0);
                        return;
                    } else {
                        i17++;
                        str5 = str3;
                        z18 = z17;
                    }
                }
            }
            str3 = str2;
            i16 = i3;
            z17 = z16;
            i17++;
            str5 = str3;
            z18 = z17;
        }
        this.D = i16;
        this.E.postValue(Integer.valueOf(i16));
        bVar.d();
        j.t().M();
    }

    private void c2(@NonNull Intent intent, MusicSourceViewModel musicSourceViewModel) {
        if (musicSourceViewModel != null && musicSourceViewModel.getCurrentMusic() != null && musicSourceViewModel.getCurrentMusic().f321260f == 2) {
            WinkEditorMusicInfo currentMusic = musicSourceViewModel.getCurrentMusic();
            intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_MID, currentMusic.p());
            intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_ID, currentMusic.o());
            intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_NAME, currentMusic.q());
            intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_START_TIME, currentMusic.s());
            intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_LOCAL_PATH, WinkEditorMusicHelper.o(currentMusic));
            intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_TAG, currentMusic.m());
        }
    }

    @Deprecated
    public static String d2() {
        return WinkContext.INSTANCE.f("NONE");
    }

    public static String e2(String str) {
        String str2 = u53.b.f438374e;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + File.separator + "output_" + str + "_" + System.currentTimeMillis() + "_.mp4";
    }

    private GYAssessPicQualityOption f2(Map<Integer, v> map) {
        GYAssessPicQualityOption gYAssessPicQualityOption = new GYAssessPicQualityOption();
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<Integer, v>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                v value = it.next().getValue();
                if (value != null && value.b() != null) {
                    GYAssessPicQualityOption b16 = value.b();
                    gYAssessPicQualityOption.enableDeblur |= b16.enableDeblur;
                    gYAssessPicQualityOption.enableDelogo |= b16.enableDelogo;
                    gYAssessPicQualityOption.enableFace = b16.enableFace | gYAssessPicQualityOption.enableFace;
                }
            }
        }
        return gYAssessPicQualityOption;
    }

    private List<Long> g2(int i3) {
        int min;
        ArrayList arrayList = new ArrayList();
        long j3 = i3 * 1000 * 1000;
        int i16 = 0;
        long j16 = 0;
        if (i3 <= 20) {
            if (i3 <= 2) {
                min = 5;
            } else {
                min = Math.min(20, (i3 * 2) + 1);
            }
            long j17 = j3 / (min - 1);
            while (i16 < min) {
                arrayList.add(Long.valueOf(j16));
                j16 += j17;
                i16++;
            }
        } else {
            arrayList.add(0L);
            arrayList.add(2000000L);
            arrayList.add(4000000L);
            arrayList.add(6000000L);
            arrayList.add(7000000L);
            arrayList.add(8000000L);
            long j18 = 9000000;
            long j19 = (j3 - 9000000) / 13;
            while (i16 < 14) {
                arrayList.add(Long.valueOf(j18));
                j18 += j19;
                i16++;
            }
        }
        ms.a.f("WinkExportViewModel", "detect pic time " + arrayList.size() + "\u5e27: " + arrayList);
        return arrayList;
    }

    public static String i2(String str) {
        if (str != null && !str.equals("")) {
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf(File.separator);
            if (lastIndexOf2 == -1) {
                if (lastIndexOf != -1) {
                    return str.substring(0, lastIndexOf);
                }
                return str;
            }
            if (lastIndexOf == -1) {
                return str.substring(lastIndexOf2 + 1);
            }
            if (lastIndexOf2 < lastIndexOf) {
                return str.substring(lastIndexOf2 + 1, lastIndexOf);
            }
            return str.substring(lastIndexOf2 + 1);
        }
        return str;
    }

    private LinkedHashMap<MediaClip, v> j2(Map<Integer, v> map, List<MediaClip> list, List<MediaClip> list2) {
        v vVar;
        ResourceModel resourceModel;
        LinkedHashMap<MediaClip, v> linkedHashMap = new LinkedHashMap<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaClip mediaClip = list.get(i3);
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null && resourceModel2.size != null) {
                int i16 = 0;
                while (true) {
                    if (i16 < list2.size()) {
                        MediaClip mediaClip2 = list2.get(i16);
                        if (mediaClip2 != null && (resourceModel = mediaClip2.resource) != null && mediaClip.resource.id.equals(resourceModel.id)) {
                            break;
                        }
                        i16++;
                    } else {
                        i16 = -1;
                        break;
                    }
                }
                if (i16 >= 0) {
                    vVar = map.get(Integer.valueOf(i16));
                } else {
                    vVar = null;
                }
                if (vVar == null) {
                    ms.a.c("WinkExportViewModel", "currentQualityOption is null for index " + i3);
                } else if (com.tencent.mobileqq.wink.editor.hdr.g.f320477a.c(mediaClip)) {
                    if (!vVar.c()) {
                        if (mediaClip.resource != null) {
                            WinkHDRCacheManager d16 = WinkHDRCacheManager.d();
                            String str = mediaClip.resource.path;
                            d16.g(str, str);
                        }
                    } else {
                        linkedHashMap.put(mediaClip, vVar);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private int k2(MediaClip mediaClip) {
        ResourceModel resourceModel;
        SizeF sizeF;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
            return (int) sizeF.height;
        }
        return 720;
    }

    private int l2(MediaClip mediaClip) {
        ResourceModel resourceModel;
        SizeF sizeF;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
            return (int) sizeF.width;
        }
        return 720;
    }

    private void p2(BasePartFragment basePartFragment, dr drVar, WinkEditDataWrapper winkEditDataWrapper, ArrayList<LocalMediaInfo> arrayList, MusicSourceViewModel musicSourceViewModel) {
        List<MediaModel> J = drVar.J();
        if (arrayList != null && J != null && arrayList.size() == J.size()) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            HashMap<String, LocalMediaInfo> hashMap = new HashMap<>();
            HashMap hashMap2 = new HashMap();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                LocalMediaInfo localMediaInfo = arrayList.get(i3);
                if (localMediaInfo != null) {
                    ArrayList<String> arrayList3 = this.K;
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        localMediaInfo.mHashTagList.addAll(this.K);
                    }
                    if (!TextUtils.isEmpty(localMediaInfo.path)) {
                        arrayList2.add(localMediaInfo.path);
                        hashMap.put(localMediaInfo.path, localMediaInfo);
                        hashMap2.put(J.get(i3).id, localMediaInfo);
                    }
                }
            }
            LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
            localMediaInfo2.missionID = winkEditDataWrapper.getMissionId();
            localMediaInfo2.mOriginPath = arrayList2;
            this.J.setOutMediaInfo(localMediaInfo2);
            WinkEditDataWrapper winkEditDataWrapper2 = this.J;
            com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper2, winkEditDataWrapper2.getMissionId());
            WinkEditDataWrapper winkEditDataWrapper3 = this.J;
            com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper3, winkEditDataWrapper3.getMissionId());
            B2(basePartFragment, arrayList2, hashMap, this.J, WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE, false, K2(hashMap2, J, drVar.w()), true, musicSourceViewModel);
        }
    }

    private void q2(BasePartFragment basePartFragment, dr drVar, WinkEditDataWrapper winkEditDataWrapper, boolean z16, ArrayList<LocalMediaInfo> arrayList, String str, MusicSourceViewModel musicSourceViewModel) {
        List<String> arrayList2;
        if (arrayList != null && arrayList.size() <= 1 && !TextUtils.isEmpty(arrayList.get(0).path)) {
            String str2 = arrayList.get(0).path;
            if (!com.tencent.mobileqq.wink.editor.draft.c.C(winkEditDataWrapper)) {
                ms.a.c("WinkExportViewModel", "exportVideo... error mediaModel == null");
                return;
            }
            String e26 = e2(winkEditDataWrapper.getMissionId());
            com.tencent.mobileqq.wink.editor.draft.c.a(winkEditDataWrapper, drVar);
            Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(winkEditDataWrapper);
            LocalMediaInfo U1 = U1(com.tencent.mobileqq.wink.editor.draft.c.t(winkEditDataWrapper.getEditDatas().get(0)), e26, str2, winkEditDataWrapper.getMissionId(), ((Integer) r26.first).intValue(), ((Integer) r26.second).intValue(), this.K, winkEditDataWrapper.getDuration() / 1000);
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.add(U1.path);
            HashMap<String, LocalMediaInfo> hashMap = new HashMap<>();
            hashMap.put(U1.path, U1);
            winkEditDataWrapper.setOutMediaInfo(U1);
            com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
            WinkExportUtils.h(winkEditDataWrapper.getMissionId());
            if (drVar != null) {
                arrayList2 = drVar.z();
            } else {
                arrayList2 = new ArrayList<>();
            }
            B2(basePartFragment, arrayList3, hashMap, winkEditDataWrapper, WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE, z16, L2(U1.path, arrayList2), false, musicSourceViewModel);
        }
    }

    private boolean s2(ClipSource clipSource) {
        if (clipSource != null && clipSource.getType() == ClipType.VIDEO) {
            return true;
        }
        return false;
    }

    private boolean v2(BasePartFragment basePartFragment) {
        if (basePartFragment == null || basePartFragment.getHostActivity() == null || basePartFragment.getHostActivity().getIntent() == null) {
            return false;
        }
        return basePartFragment.getHostActivity().getIntent().getBooleanExtra(QQWinkConstants.QZONE_EDIT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(final Map map, final GYAssessPicQualityOption gYAssessPicQualityOption, final WinkEditorFragment.b bVar, final List list, final List list2, final WinkEditDataWrapper winkEditDataWrapper) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.x2(map, gYAssessPicQualityOption, bVar, list, list2, winkEditDataWrapper);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(List list, final List list2, final WinkEditorFragment.b bVar, boolean z16, final WinkEditDataWrapper winkEditDataWrapper) {
        final List list3;
        boolean z17;
        boolean z18;
        boolean z19;
        if (list == null) {
            list3 = list2;
        } else {
            list3 = list;
        }
        try {
            Pair<GYAssessPicQualityOption, Map<Integer, v>> X1 = X1(list3, bVar);
            if (this.C == 1) {
                if (bVar != null) {
                    bVar.b();
                    return;
                }
                return;
            }
            final Map<Integer, v> map = (Map) X1.second;
            final GYAssessPicQualityOption gYAssessPicQualityOption = (GYAssessPicQualityOption) X1.first;
            if (gYAssessPicQualityOption.enableDelogo != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (gYAssessPicQualityOption.enableDeblur != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (gYAssessPicQualityOption.enableFace != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            ms.a.f("WinkExportViewModel", "detect result call back deLogo: " + z17 + " deBlur: " + z18 + " deFace: " + z19);
            if (z16) {
                bVar.c(z17, z18, z19, new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.this.y2(map, gYAssessPicQualityOption, bVar, list2, list3, winkEditDataWrapper);
                    }
                });
            } else {
                bVar.c(z17, z18, z19, null);
                x2(map, gYAssessPicQualityOption, bVar, list2, list3, winkEditDataWrapper);
            }
        } catch (Throwable th5) {
            ms.a.e("WinkExportViewModel", th5);
        }
    }

    public boolean A2() {
        if (2 == this.D) {
            return true;
        }
        return false;
    }

    public void D2(boolean z16) {
        this.Q = z16;
    }

    public void E2(ArrayList<ArrayList<WinkPublishMediaRecord>> arrayList) {
        this.I = arrayList;
    }

    public void F2(boolean z16) {
        this.F = z16;
    }

    public void G2(String str) {
        this.L = str;
    }

    public void H2(ArrayList<String> arrayList) {
        this.K = arrayList;
    }

    public void I2(WinkEditDataWrapper winkEditDataWrapper) {
        this.J = winkEditDataWrapper;
    }

    public void J2(BasePartFragment basePartFragment, dr drVar, boolean z16, ArrayList<LocalMediaInfo> arrayList, String str, @androidx.annotation.Nullable String str2, boolean z17, boolean z18, MusicSourceViewModel musicSourceViewModel) {
        w53.b.f("WinkExportViewModel", "toPublishPage businessName " + str2 + " syncToQCircle " + z17);
        this.M = str2;
        this.N = z17;
        this.P = z18;
        WinkEditDataWrapper winkEditDataWrapper = this.J;
        if (winkEditDataWrapper == null) {
            ms.a.c("WinkExportViewModel", "toPublishPage... error dataWrapper == null");
            return;
        }
        com.tencent.mobileqq.wink.editor.draft.a.k(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
        if (this.J.getEditMode().intValue() == 0) {
            q2(basePartFragment, drVar, this.J, z16, arrayList, str, musicSourceViewModel);
        } else if (this.J.getEditMode().intValue() == 1) {
            p2(basePartFragment, drVar, this.J, arrayList, musicSourceViewModel);
        }
        if ((basePartFragment.getActivity() == null || !u2(basePartFragment.getActivity().getIntent())) && this.Q && !t2() && !v2(basePartFragment)) {
            SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false));
        }
    }

    public int S1() {
        j.t().M();
        int i3 = this.D;
        if (i3 == 0) {
            return 0;
        }
        this.C = i3;
        j.t().j();
        return this.C;
    }

    public Pair<GYAssessPicQualityOption, Map<Integer, v>> X1(List<MediaClip> list, WinkEditorFragment.b bVar) {
        String str;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            List<ClipSource> z16 = com.tencent.videocut.render.extension.e.z(list, false, Boolean.FALSE);
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_START_DETECT);
            this.G.clear();
            this.H = 0L;
            for (int i3 = 0; i3 < z16.size(); i3++) {
                ms.a.f("WinkExportViewModel", "start detectPicQuality of clip#" + i3);
                boolean z17 = true;
                if (this.C == 1) {
                    return Pair.create(new GYAssessPicQualityOption(), hashMap);
                }
                ClipSource clipSource = z16.get(i3);
                MediaClip mediaClip = list.get(i3);
                if (!TextUtils.isEmpty(clipSource.getPath())) {
                    str = u53.e.f438386c + File.separator + MD5Utils.toMD5(clipSource.getPath()) + "_" + System.currentTimeMillis();
                } else {
                    str = u53.e.f438386c + File.separator + System.currentTimeMillis();
                }
                ms.a.f("WinkExportViewModel", "make cacheDir=" + str + ", success=" + new File(str).mkdirs());
                GYAssessPicQuality r26 = r2(str);
                int e16 = com.tencent.mobileqq.wink.editor.hdr.a.e(r26);
                GYAssessPicQualityOption Z1 = Z1(clipSource, mediaClip, r26);
                ms.a.f("WinkExportViewModel", "picQualityDetectOption of clip#" + i3 + " : enableDelogo = " + Z1.enableDelogo + ", enableDeblur = " + Z1.enableDeblur + ", enableFace = " + Z1.enableFace + ", deblurAvgScore = " + Z1.deblurAvgScore);
                v vVar = new v();
                if (e16 == 0) {
                    z17 = false;
                }
                vVar.g(z17);
                vVar.f(Z1);
                vVar.e(str);
                hashMap.put(Integer.valueOf(i3), vVar);
                if (bVar != null) {
                    float size = ((i3 + 1) * 1.0f) / z16.size();
                    ms.a.f("WinkExportViewModel", "detect progress call back: " + size);
                    bVar.a(size);
                }
                r26.cleanupModelData();
            }
            C2(this.G, this.H);
            return Pair.create(f2(hashMap), hashMap);
        }
        return Pair.create(new GYAssessPicQualityOption(), hashMap);
    }

    public void b2(WinkEditorFragment winkEditorFragment, boolean z16, final boolean z17, final WinkEditDataWrapper winkEditDataWrapper, @androidx.annotation.Nullable final List<MediaClip> list, final WinkEditorFragment.b bVar) {
        if (((WinkEditorViewModel) winkEditorFragment.getViewModel(WinkEditorViewModel.class)) == null) {
            ms.a.c("WinkExportViewModel", "startExport... error winkEditorViewModel == null");
            return;
        }
        if (winkEditDataWrapper == null) {
            ms.a.c("WinkExportViewModel", "startExport... error dataWrapper == null");
            return;
        }
        boolean z18 = false;
        this.C = 0;
        final List<MediaClip> m3 = com.tencent.mobileqq.wink.editor.draft.c.m(winkEditDataWrapper.getEditDatas(), z16);
        if (((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().a() && com.tencent.mobileqq.wink.editor.hdr.a.k()) {
            z18 = true;
        }
        ms.a.f("WinkExportViewModel", "enableDeLogo : " + z18);
        if (bVar != null && com.tencent.mobileqq.wink.editor.hdr.g.f320477a.d(m3) && z18) {
            bVar.showDialog();
            j.t().M();
            this.D = 1;
            this.E.postValue(1);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.r
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.z2(list, m3, bVar, z17, winkEditDataWrapper);
                }
            }, 64, null, true);
            return;
        }
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkExportViewModel";
    }

    public LiveData<Integer> h2() {
        return this.E;
    }

    public ArrayList<ArrayList<WinkPublishMediaRecord>> m2() {
        return this.I;
    }

    public ArrayList<String> n2() {
        return this.K;
    }

    public WinkEditDataWrapper o2() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        j.t().M();
        super.onCleared();
    }

    public GYAssessPicQuality r2(String str) {
        GYAssessPicQuality gYAssessPicQuality = new GYAssessPicQuality();
        SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
        sDKDeviceConfig.setDevice("ARM");
        ms.a.f("WinkExportViewModel", "initInstance: " + gYAssessPicQuality.initInstance(sDKDeviceConfig));
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        sDKModelConfig.modelPaths = hashMap;
        hashMap.put("root-path", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY));
        sDKModelConfig.modelPaths.put("face-path", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(AEResInfo.LIGHT_RES_BUNDLE_FACE));
        sDKModelConfig.modelPaths.put("watermark_cache_dir", str);
        ms.a.f("WinkExportViewModel", "init setupWithModel: " + gYAssessPicQuality.setupWithModel(sDKModelConfig));
        return gYAssessPicQuality;
    }

    public boolean t2() {
        if (!"QCIRCLE".equals(this.M) && !QQWinkConstants.ENTRY_BUSINESS_QCIRCLE_OLD.equals(this.M)) {
            return false;
        }
        return true;
    }

    public boolean u2(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra(QQWinkConstants.IS_QZONE_AUTO_TEMPLATE, false);
    }

    public boolean w2() {
        return this.F;
    }
}
