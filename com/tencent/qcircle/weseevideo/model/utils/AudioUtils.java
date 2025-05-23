package com.tencent.qcircle.weseevideo.model.utils;

import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioUtils {
    public static final String AUDIO_TAG_KEY = "audio_tag_key";
    public static final String AUDIO_TYPE_KEY = "audio_type_key";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum AudioSymbol {
        None,
        BGM,
        TTS
    }

    private static TAVAudioConfiguration.VolumeEdge createVolumeEdge(CMTime cMTime, long j3, float f16, float f17) {
        TAVAudioConfiguration.VolumeEdge volumeEdge = new TAVAudioConfiguration.VolumeEdge();
        volumeEdge.setStartVolume(f16);
        volumeEdge.setEndVolume(f17);
        volumeEdge.setTimeRange(new CMTimeRange(cMTime, CMTime.fromMs(j3)));
        return volumeEdge;
    }

    public static TAVClip generateAudioClip(@NonNull String str, @NonNull CMTimeRange cMTimeRange) {
        URLAsset createAsset = VideoUtils.createAsset(str);
        if (createAsset == null) {
            return null;
        }
        TAVClip tAVClip = new TAVClip(createAsset);
        tAVClip.getResource().setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, cMTimeRange.getDuration()));
        tAVClip.setStartTime(cMTimeRange.getStart());
        tAVClip.setDuration(cMTimeRange.getDuration());
        return tAVClip;
    }

    public static List<TAVClip> getAudioBySymbol(@NonNull AudioSymbol audioSymbol, @NonNull List<TAVClip> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVClip tAVClip : list) {
            if (TextUtils.equals(String.valueOf(tAVClip.getExtraTrackInfo("audio_type_key")), audioSymbol.name())) {
                arrayList.add(tAVClip);
            }
        }
        return arrayList;
    }

    public static List<TAVClip> getAudioByUserTag(@NonNull String str, @NonNull List<TAVClip> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVClip tAVClip : list) {
            Object extraTrackInfo = tAVClip.getExtraTrackInfo("audio_tag_key");
            if ((extraTrackInfo instanceof String) && TextUtils.equals(str, (String) extraTrackInfo)) {
                arrayList.add(tAVClip);
            }
        }
        return arrayList;
    }

    public static ArrayList<TAVClip> getBGMAudioClips(long j3, @Nullable MusicMaterialMetaDataBean musicMaterialMetaDataBean, float f16) {
        ArrayList<TAVClip> arrayList = new ArrayList<>();
        if (musicMaterialMetaDataBean != null && !TextUtils.isEmpty(musicMaterialMetaDataBean.path)) {
            long j16 = musicMaterialMetaDataBean.startTime;
            long j17 = musicMaterialMetaDataBean.mTotalTimeMs;
            long j18 = musicMaterialMetaDataBean.segDuration;
            if (j18 == 0 || !musicMaterialMetaDataBean.isEdit) {
                j18 = j17 - j16;
            }
            if (j18 <= j3) {
                j3 = j18;
            }
            URLAsset createAsset = VideoUtils.createAsset(musicMaterialMetaDataBean.path);
            if (createAsset == null) {
                return null;
            }
            TAVClip tAVClip = new TAVClip(createAsset);
            tAVClip.getResource().setSourceTimeRange(new CMTimeRange(CMTime.fromMs(j16), CMTime.fromMs(j3)));
            tAVClip.getAudioConfiguration().setVolume(f16);
            tAVClip.setStartTime(CMTime.fromMs(musicMaterialMetaDataBean.startPlayOffset));
            tAVClip.setDuration(CMTime.fromMs(j3));
            arrayList.add(tAVClip);
        }
        markAudioSymbol(AudioSymbol.BGM, arrayList);
        return arrayList;
    }

    public static int getDuration(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                mediaMetadataRetriever.release();
                return Integer.valueOf(extractMetadata).intValue();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return 0;
    }

    public static boolean markAudioSymbol(AudioSymbol audioSymbol, @NonNull List<TAVClip> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        Iterator<TAVClip> it = list.iterator();
        while (it.hasNext()) {
            it.next().putExtraTrackInfo("audio_type_key", audioSymbol);
        }
        return true;
    }

    public static void markAudioUserTag(@NonNull String str, @NonNull String str2, @NonNull TAVClip tAVClip) {
        tAVClip.putExtraTrackInfo(str, str2);
    }

    public static boolean markAudiosUserTag(@NonNull String str, @NonNull List<TAVClip> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        Iterator<TAVClip> it = list.iterator();
        while (it.hasNext()) {
            markAudioUserTag("audio_tag_key", str, it.next());
        }
        return true;
    }

    private static void parseVolumeEffectOld(TAVClip tAVClip, long j3, long j16, MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        long j17 = musicMaterialMetaDataBean.startInTime;
        long j18 = musicMaterialMetaDataBean.endOutTime;
        TAVAudioConfiguration.VolumeEdge createVolumeEdge = createVolumeEdge(CMTime.fromMs(j3), j17, 0.0f, 1.0f);
        TAVAudioConfiguration.VolumeEdge createVolumeEdge2 = createVolumeEdge(CMTime.fromMs(j3 + j16), j18, 1.0f, 0.0f);
        tAVClip.getAudioConfiguration().setStartVolumeEdge(createVolumeEdge);
        tAVClip.getAudioConfiguration().setEndVolumeEdge(createVolumeEdge2);
    }

    public static void updateClipAssetPath(@NonNull TAVClip tAVClip, @NonNull String str) {
        if (tAVClip.getResource() instanceof TAVAssetTrackResource) {
            TAVAssetTrackResource tAVAssetTrackResource = (TAVAssetTrackResource) tAVClip.getResource();
            TAVAssetTrackResource tAVAssetTrackResource2 = new TAVAssetTrackResource(str);
            tAVAssetTrackResource2.setDuration(tAVAssetTrackResource.getDuration().m259clone());
            tAVAssetTrackResource2.setSourceTimeRange(tAVAssetTrackResource.getSourceTimeRange().m260clone());
            tAVClip.setResource(tAVAssetTrackResource2);
        }
    }

    public static void updateCompositionAudiosBySymbol(TAVComposition tAVComposition, List<TAVClip> list, AudioSymbol audioSymbol) {
        AudioSymbol audioSymbol2;
        if (tAVComposition == null && CollectionUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<? extends TAVAudio> audios = tAVComposition.getAudios();
        if (audios != null) {
            Iterator<? extends TAVAudio> it = audios.iterator();
            while (it.hasNext()) {
                TAVClip tAVClip = (TAVClip) it.next();
                Object extraTrackInfo = tAVClip.getExtraTrackInfo("audio_type_key");
                if (extraTrackInfo instanceof AudioSymbol) {
                    audioSymbol2 = (AudioSymbol) extraTrackInfo;
                } else {
                    audioSymbol2 = null;
                }
                if (audioSymbol2 == null || audioSymbol2.ordinal() != audioSymbol.ordinal()) {
                    arrayList.add(tAVClip);
                }
            }
        }
        arrayList.addAll(list);
        tAVComposition.setAudios(arrayList);
    }
}
