package com.tencent.qcircle.weseevideo.model.template.movie;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.MediaConfig;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import com.tencent.qcircle.weseevideo.model.utils.Utils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.TAVMovieConfig;
import com.tencent.tavmovie.TAVTemplate;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.base.TAVSegmentImageEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil;
import com.tencent.tavsticker.core.TAVStickerResourceExporter;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerResource;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MovieTemplate implements TAVTemplate, Serializable {
    private static final String AUDIO_NAME = "audio";
    private static final String TAG = "MovieTemplate";
    private static final float US_SCALE = 1000000.0f;
    private List<MovieSegment> mCorrectSegments;
    private HashMap<String, String> mDownloadImageMap;
    private String mFilePath;
    private boolean mFirstFill;
    private boolean mHasImageLayerSet;
    private boolean mHasTextLayerSet;
    private boolean mIsAsset;
    private List<TAVStickerResourceExporter.IStickerResourceExportListener> mLoadDataListeners;
    private volatile boolean mLoadingData;
    private boolean mNeedCycleFill;
    private List<TAVMovieClip> mOriginClips;
    private String mPackagePath;
    private String mPagAudioPath;
    private List<MovieSegment> mSegments;
    private List<TAVMovieSticker> mStickers;
    private TAVMovieSticker mTemplateSticker;
    private CGSize renderSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplate$2, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tavmovie$resource$TAVMovieResource$TAVResourceType;

        static {
            int[] iArr = new int[TAVMovieResource.TAVResourceType.values().length];
            $SwitchMap$com$tencent$tavmovie$resource$TAVMovieResource$TAVResourceType = iArr;
            try {
                iArr[TAVMovieResource.TAVResourceType.TAVResourceTypePhoto.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tavmovie$resource$TAVMovieResource$TAVResourceType[TAVMovieResource.TAVResourceType.TAVResourceTypeVideo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MovieTemplate(@NonNull String str) {
        this(str, false);
    }

    private void correctSegments() {
        MovieSegment movieSegment;
        boolean z16;
        List<TAVClip> useTavClips;
        this.mCorrectSegments = new ArrayList(this.mSegments);
        for (int i3 = 0; i3 < this.mCorrectSegments.size(); i3++) {
            MovieSegment movieSegment2 = this.mCorrectSegments.get(i3);
            if (movieSegment2 != null && (useTavClips = movieSegment2.getUseTavClips()) != null && !useTavClips.isEmpty()) {
                CMTime cMTime = CMTime.CMTimeZero;
                Iterator<TAVClip> it = useTavClips.iterator();
                while (it.hasNext()) {
                    cMTime = cMTime.add(it.next().getResource().getScaledDuration());
                }
                CMTimeRange cMTimeRange = new CMTimeRange(movieSegment2.getTimeRange().getStart(), cMTime);
                if (i3 == this.mCorrectSegments.size() - 1 && isSampleTimeRange(CMTimeRange.fromSeconds((float) cMTimeRange.getStartUs(), (float) cMTimeRange.getDurationUs()), CMTimeRange.fromSeconds((float) movieSegment2.getTimeRange().getStartUs(), (float) movieSegment2.getTimeRange().getDurationUs()))) {
                    CMTime sub = new CMTime(this.mTemplateSticker.getSticker().durationTime() / 1000, 1000).sub(movieSegment2.getTimeRange().getEnd());
                    Logger.i(TAG, "correctSegments endingTime is " + sub);
                    if (sub.bigThan(CMTime.CMTimeZero)) {
                        movieSegment2.setEndingTime(sub);
                    }
                }
                movieSegment2.setTimeRange(cMTimeRange);
            }
        }
        int i16 = 0;
        while (i16 < this.mCorrectSegments.size()) {
            MovieSegment movieSegment3 = this.mCorrectSegments.get(i16);
            movieSegment3.setIndex(i16);
            if (i16 == this.mCorrectSegments.size() - 1) {
                break;
            }
            i16++;
            MovieSegment movieSegment4 = this.mCorrectSegments.get(i16);
            CMTimeRange timeRange = movieSegment3.getTimeRange();
            CMTime end = timeRange.getEnd();
            CMTimeRange timeRange2 = movieSegment4.getTimeRange();
            CMTime start = timeRange2.getStart();
            CMTime end2 = timeRange2.getEnd();
            if (timeRange.containsTime(start)) {
                if (end.bigThan(end2)) {
                    end = end2;
                }
                movieSegment4.setOverlapTimeRange(new CMTimeRange(start, end.sub(start)));
                CMTime add = start.add(end.sub(start).divide(2.0f));
                movieSegment4.setCorrectStartTime(add);
                movieSegment3.setCorrectEndTime(add);
            } else {
                movieSegment4.setCorrectStartTime(start);
            }
        }
        if (this.mCorrectSegments.isEmpty() || (movieSegment = this.mCorrectSegments.get(0)) == null) {
            return;
        }
        movieSegment.setCorrectStartTime(CMTime.CMTimeZero);
        Iterator<MovieSegment> it5 = this.mCorrectSegments.iterator();
        while (it5.hasNext()) {
            MovieSegment next = it5.next();
            if (next != null && next.getTavMovieClips() != null && !next.getTavMovieClips().isEmpty() && next.getTavClips() != null && !next.getTavClips().isEmpty() && (next.getOverlapTimeRange() == null || !next.getTimeRange().getEnd().smallThan(next.getOverlapTimeRange().getEnd()))) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                it5.remove();
            }
        }
    }

    private void fillClipsPhoto(@NonNull TAVMovieClip tAVMovieClip, @NonNull MovieSegment movieSegment, @NonNull List<TAVClip> list) {
        TAVMovieImageResource tAVMovieImageResource = (TAVMovieImageResource) tAVMovieClip.getResource();
        Logger.d(TAG, "begin--fillClipsPhoto photo path: " + tAVMovieImageResource.getFilePath());
        CMTime m259clone = movieSegment.getTimeRange().getDuration().m259clone();
        tAVMovieClip.getResource().setDuration(m259clone);
        TAVMovieResource resource = tAVMovieClip.getResource();
        CMTime cMTime = CMTime.CMTimeZero;
        resource.setTimeRange(new CMTimeRange(cMTime, m259clone));
        ArrayList arrayList = new ArrayList();
        arrayList.add(tAVMovieClip);
        movieSegment.setTavMovieClips(arrayList);
        TAVClip convertToClip = tAVMovieClip.convertToClip();
        convertToClip.getResource().setSourceTimeRange(new CMTimeRange(cMTime, m259clone));
        convertToClip.putExtraTrackInfo(TAVMovieConfig.PAG_LAYER_INDEX_KEY, String.valueOf(movieSegment.getLayerIndex()));
        list.add(convertToClip);
        Logger.d(TAG, "end--fillClipsPhoto photo path: " + tAVMovieImageResource.getFilePath());
    }

    private void fillClipsVideo(@NonNull TAVMovieClip tAVMovieClip, @NonNull MovieSegment movieSegment, @NonNull List<TAVClip> list, @NonNull List<TAVMovieClip> list2, List<TAVMovieTimeEffect> list3) {
        boolean z16;
        CMTimeRange cMTimeRange;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CMTime m259clone = movieSegment.getMinOriginDuration().m259clone();
        while (m259clone.getTimeUs() > 0) {
            CMTimeRange m260clone = tAVMovieClip.getResource().getTimeRange().m260clone();
            CMTime duration = m260clone.getDuration();
            TAVMovieResource.TAVResourceType type = tAVMovieClip.getResource().getType();
            if (arrayList2.isEmpty() && type == TAVMovieResource.TAVResourceType.TAVResourceTypeVideo && duration.bigThan(m259clone)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                cMTimeRange = new CMTimeRange(m260clone.getStart().add(duration.sub(m259clone).divide(2.0f)), m259clone.m259clone());
            } else {
                if (type == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto) {
                    duration = m259clone.m259clone();
                    tAVMovieClip.getResource().setDuration(m259clone.m259clone());
                    m260clone = new CMTimeRange(CMTime.CMTimeZero, m259clone.m259clone());
                }
                if (m259clone.smallThan(duration)) {
                    cMTimeRange = new CMTimeRange(m260clone.getStart(), m259clone.m259clone());
                } else {
                    cMTimeRange = m260clone;
                }
            }
            tAVMovieClip.getResource().setTimeRange(cMTimeRange);
            TAVClip convertToClip = tAVMovieClip.convertToClip();
            convertToClip.getResource().setSourceTimeRange(cMTimeRange);
            convertToClip.putExtraTrackInfo(TAVMovieConfig.PAG_LAYER_INDEX_KEY, String.valueOf(movieSegment.getLayerIndex()));
            arrayList.add(convertToClip);
            arrayList2.add(tAVMovieClip);
            m259clone = m259clone.sub(duration);
            if (m259clone.getTimeUs() > 0) {
                if (list2.size() == 0) {
                    break;
                } else {
                    tAVMovieClip = list2.remove(0);
                }
            }
        }
        movieSegment.setTavMovieClips(arrayList2);
        if (list3 != null && !arrayList.isEmpty()) {
            list.addAll(TAVMovieTimeEffectUtil.applyTimeEffectsNew(arrayList, list3));
        } else {
            list.addAll(arrayList);
        }
    }

    private void fillSegments(MovieSegment movieSegment, List<TAVMovieClip> list, @Nullable List<TAVMovieTimeEffect> list2, List<TAVClip> list3) {
        TAVMovieClip remove;
        if (movieSegment != null && list != null && !list.isEmpty()) {
            if (list3 == null) {
                list3 = new ArrayList<>();
            }
            List<TAVClip> list4 = list3;
            if (this.mNeedCycleFill) {
                remove = list.remove(0);
                list.add(remove.m275clone());
            } else {
                remove = list.remove(0);
            }
            TAVMovieClip tAVMovieClip = remove;
            if (tAVMovieClip != null && tAVMovieClip.getResource() != null) {
                int i3 = AnonymousClass2.$SwitchMap$com$tencent$tavmovie$resource$TAVMovieResource$TAVResourceType[tAVMovieClip.getResource().getType().ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        fillClipsVideo(tAVMovieClip, movieSegment, list4, list, list2);
                        return;
                    }
                    return;
                }
                fillClipsPhoto(tAVMovieClip, movieSegment, list4);
            }
        }
    }

    private List<TAVSegmentImageEffect> getSegmentImageEffects(TAVStickerLayerInfo tAVStickerLayerInfo) {
        List<TAVStickerLayerInfo.TAVStickerImageEffect> imageEffects;
        CMTimeRange timeRange;
        String effectId;
        String name;
        if (tAVStickerLayerInfo == null || (imageEffects = tAVStickerLayerInfo.getImageEffects()) == null || imageEffects.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVStickerLayerInfo.TAVStickerImageEffect tAVStickerImageEffect : imageEffects) {
            TAVSegmentImageEffect tAVSegmentImageEffect = new TAVSegmentImageEffect();
            if (tAVStickerImageEffect == null) {
                timeRange = null;
            } else {
                timeRange = tAVStickerImageEffect.getTimeRange();
            }
            tAVSegmentImageEffect.setTimeRange(timeRange);
            if (tAVStickerImageEffect == null) {
                effectId = null;
            } else {
                effectId = tAVStickerImageEffect.getEffectId();
            }
            tAVSegmentImageEffect.setEffectID(effectId);
            if (tAVStickerImageEffect == null) {
                name = null;
            } else {
                name = tAVStickerImageEffect.getName();
            }
            tAVSegmentImageEffect.setName(name);
            arrayList.add(tAVSegmentImageEffect);
        }
        return arrayList;
    }

    private List<TAVMovieTimeEffect> getSegmentTimeEffects(TAVStickerLayerInfo tAVStickerLayerInfo) {
        List<TAVStickerLayerInfo.TAVStickerTimeEffect> timeEffects;
        if (tAVStickerLayerInfo == null || (timeEffects = tAVStickerLayerInfo.getTimeEffects()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (timeEffects.isEmpty()) {
            TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
            tAVMovieTimeEffect.setSourceTimeRange(tAVStickerLayerInfo.getTimeRange());
            tAVMovieTimeEffect.setTimeRange(tAVStickerLayerInfo.getTimeRange());
            tAVMovieTimeEffect.setLoop(1);
            tAVMovieTimeEffect.setSpeed(1.0f);
            arrayList.add(tAVMovieTimeEffect);
            return arrayList;
        }
        for (TAVStickerLayerInfo.TAVStickerTimeEffect tAVStickerTimeEffect : timeEffects) {
            if (tAVStickerTimeEffect != null) {
                TAVMovieTimeEffect tAVMovieTimeEffect2 = new TAVMovieTimeEffect();
                tAVMovieTimeEffect2.setSourceTimeRange(tAVStickerTimeEffect.getSourceVideoTimeRange());
                tAVMovieTimeEffect2.setTimeRange(tAVStickerTimeEffect.getTimeRange());
                tAVMovieTimeEffect2.setLoop(1);
                if (tAVStickerTimeEffect.getTimeRange().getDuration().getTimeSeconds() == 0.0f) {
                    tAVMovieTimeEffect2.setSpeed(1.0f);
                } else {
                    tAVMovieTimeEffect2.setSpeed(tAVStickerTimeEffect.getSourceVideoTimeRange().getDuration().getTimeSeconds() / tAVStickerTimeEffect.getTimeRange().getDuration().getTimeSeconds());
                }
                arrayList.add(tAVMovieTimeEffect2);
            }
        }
        return arrayList;
    }

    private void initData() {
        parsePackagePath();
        this.mSegments = new ArrayList();
        this.mStickers = new ArrayList();
        if (TextUtils.isEmpty(this.mFilePath)) {
            return;
        }
        this.mTemplateSticker = new TAVMovieSticker(this.mFilePath, this.mIsAsset);
        parseLayerInfos();
        this.mPagAudioPath = this.mPackagePath + "/audio" + MediaConfig.AUDIO_PCM_FILE_POSTFIX;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pag audio path: ");
        sb5.append(this.mPagAudioPath);
        Logger.d(TAG, sb5.toString());
        if (this.mTemplateSticker.getSticker() != null) {
            this.renderSize = new CGSize(this.mTemplateSticker.getSticker().getWidth(), this.mTemplateSticker.getSticker().getHeight());
        }
    }

    private boolean isAllPhotoClip(List<TAVMovieClip> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (TAVMovieClip tAVMovieClip : list) {
            if (tAVMovieClip != null && tAVMovieClip.getResource().getType() != TAVMovieResource.TAVResourceType.TAVResourceTypePhoto) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllVideoClip(List<TAVMovieClip> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (TAVMovieClip tAVMovieClip : list) {
            if (tAVMovieClip != null && tAVMovieClip.getResource().getType() != TAVMovieResource.TAVResourceType.TAVResourceTypeVideo) {
                return false;
            }
        }
        return true;
    }

    private boolean isNeedCycleFill(List<TAVMovieClip> list) {
        return isAllPhotoClip(list);
    }

    private boolean isSamePath(TAVMovieClip tAVMovieClip, TAVMovieClip tAVMovieClip2) {
        if (tAVMovieClip != null && tAVMovieClip2 != null) {
            TAVMovieResource resource = tAVMovieClip.getResource();
            TAVMovieResource resource2 = tAVMovieClip2.getResource();
            if ((resource instanceof TAVMovieImageResource) && (resource2 instanceof TAVMovieImageResource)) {
                return TextUtils.equals(((TAVMovieImageResource) resource).getFilePath(), ((TAVMovieImageResource) resource2).getFilePath());
            }
            if ((resource instanceof TAVMovieTrackResource) && (resource2 instanceof TAVMovieTrackResource)) {
                return TextUtils.equals(((TAVMovieTrackResource) resource).getFilePath(), ((TAVMovieTrackResource) tAVMovieClip2.getResource()).getFilePath());
            }
        }
        return false;
    }

    private boolean isSampleTimeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        if (cMTimeRange == null || cMTimeRange2 == null || cMTimeRange.getStart().getTimeScale() != cMTimeRange2.getStart().getTimeScale() || cMTimeRange.getDuration().getTimeScale() != cMTimeRange2.getDuration().getTimeScale()) {
            return false;
        }
        long round = Math.round(((float) cMTimeRange.getStart().value) / 1000000.0f);
        long round2 = Math.round(((float) cMTimeRange2.getStart().value) / 1000000.0f);
        long round3 = Math.round(((float) cMTimeRange.getDuration().value) / 1000000.0f);
        long round4 = Math.round(((float) cMTimeRange2.getDuration().value) / 1000000.0f);
        Logger.i(TAG, "SV1 " + round + " SV2 " + round2 + " dv1 " + round3 + " dv2 " + round4);
        if (round != round2 || round3 != round4) {
            return false;
        }
        return true;
    }

    private boolean isSingleVideo(List<TAVMovieClip> list) {
        if (list == null || list.size() != 1 || list.get(0).getResource().getType() != TAVMovieResource.TAVResourceType.TAVResourceTypeVideo) {
            return false;
        }
        return true;
    }

    private void loadAudioData(TAVSticker tAVSticker) {
        if (FileUtils.exists(this.mPagAudioPath)) {
            List<TAVStickerResourceExporter.IStickerResourceExportListener> list = this.mLoadDataListeners;
            if (list != null) {
                for (TAVStickerResourceExporter.IStickerResourceExportListener iStickerResourceExportListener : list) {
                    if (iStickerResourceExportListener != null) {
                        iStickerResourceExportListener.succeed(null);
                    }
                }
            }
            this.mLoadingData = false;
            return;
        }
        TAVStickerResourceExporter.getInstance().exportAudioData(tAVSticker, this.mPagAudioPath, new TAVStickerResourceExporter.IStickerResourceExportListener() { // from class: com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplate.1
            @Override // com.tencent.tavsticker.core.TAVStickerResourceExporter.IStickerResourceExportListener
            public void exporting(TAVStickerResource tAVStickerResource, float f16) {
                if (MovieTemplate.this.mLoadDataListeners != null) {
                    for (TAVStickerResourceExporter.IStickerResourceExportListener iStickerResourceExportListener2 : MovieTemplate.this.mLoadDataListeners) {
                        if (iStickerResourceExportListener2 != null) {
                            iStickerResourceExportListener2.exporting(tAVStickerResource, f16);
                        }
                    }
                }
            }

            @Override // com.tencent.tavsticker.core.TAVStickerResourceExporter.IStickerResourceExportListener
            public void failed(String str, String str2) {
                MovieTemplate.this.mPagAudioPath = null;
                if (MovieTemplate.this.mLoadDataListeners != null) {
                    for (TAVStickerResourceExporter.IStickerResourceExportListener iStickerResourceExportListener2 : MovieTemplate.this.mLoadDataListeners) {
                        if (iStickerResourceExportListener2 != null) {
                            iStickerResourceExportListener2.failed(str, str2);
                        }
                    }
                }
                MovieTemplate.this.mLoadingData = false;
            }

            @Override // com.tencent.tavsticker.core.TAVStickerResourceExporter.IStickerResourceExportListener
            public void start(TAVStickerResource tAVStickerResource) {
                if (MovieTemplate.this.mLoadDataListeners != null) {
                    for (TAVStickerResourceExporter.IStickerResourceExportListener iStickerResourceExportListener2 : MovieTemplate.this.mLoadDataListeners) {
                        if (iStickerResourceExportListener2 != null) {
                            iStickerResourceExportListener2.start(tAVStickerResource);
                        }
                    }
                }
            }

            @Override // com.tencent.tavsticker.core.TAVStickerResourceExporter.IStickerResourceExportListener
            public void succeed(TAVStickerResource tAVStickerResource) {
                if (tAVStickerResource != null) {
                    MovieTemplate.this.mPagAudioPath = tAVStickerResource.getFilePath();
                    if (MovieTemplate.this.mLoadDataListeners != null) {
                        for (TAVStickerResourceExporter.IStickerResourceExportListener iStickerResourceExportListener2 : MovieTemplate.this.mLoadDataListeners) {
                            if (iStickerResourceExportListener2 != null) {
                                iStickerResourceExportListener2.succeed(tAVStickerResource);
                            }
                        }
                    }
                }
                MovieTemplate.this.mLoadingData = false;
            }
        });
    }

    private void mergeClip(TAVMovieClip tAVMovieClip, TAVMovieClip tAVMovieClip2) {
        if (!isSamePath(tAVMovieClip, tAVMovieClip2)) {
            return;
        }
        TAVMovieResource resource = tAVMovieClip.getResource();
        CMTimeRange timeRange = resource.getTimeRange();
        CMTime start = timeRange.getStart();
        CMTime end = timeRange.getEnd();
        CMTime start2 = tAVMovieClip2.getResource().getTimeRange().getStart();
        CMTime end2 = tAVMovieClip2.getResource().getTimeRange().getEnd();
        if (start.bigThan(start2)) {
            timeRange.setStart(start2);
        }
        if (end.smallThan(end2)) {
            timeRange.setDuration(end2.sub(timeRange.getStart()));
        }
        resource.setTimeRange(timeRange);
    }

    private List<TAVMovieClip> mergeClips(List<TAVMovieClip> list) {
        ArrayList arrayList = new ArrayList();
        for (TAVMovieClip tAVMovieClip : list) {
            int i3 = -1;
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                if (isSamePath((TAVMovieClip) arrayList.get(i16), tAVMovieClip)) {
                    i3 = i16;
                }
            }
            if (i3 != -1) {
                mergeClip((TAVMovieClip) arrayList.get(i3), tAVMovieClip);
            } else {
                arrayList.add(tAVMovieClip);
            }
        }
        return arrayList;
    }

    private void parseLayerInfos() {
        List<TAVStickerLayerInfo> stickerLayerInfos = this.mTemplateSticker.getStickerLayerInfos();
        if (stickerLayerInfos != null && !stickerLayerInfos.isEmpty()) {
            for (TAVStickerLayerInfo tAVStickerLayerInfo : stickerLayerInfos) {
                if (Utils.isLayerFillAble(tAVStickerLayerInfo)) {
                    MovieSegment movieSegment = new MovieSegment();
                    movieSegment.setTimeEffects(getSegmentTimeEffects(tAVStickerLayerInfo));
                    movieSegment.setImageEffects(getSegmentImageEffects(tAVStickerLayerInfo));
                    movieSegment.setUserDatas(tAVStickerLayerInfo.getUserDataList());
                    movieSegment.setTimeRange(tAVStickerLayerInfo.getTimeRange());
                    movieSegment.setLayerIndex(tAVStickerLayerInfo.getLayerIndex());
                    this.mSegments.add(movieSegment);
                }
            }
            Iterator<MovieSegment> it = this.mSegments.iterator();
            while (it.hasNext()) {
                MovieSegment next = it.next();
                if (next.getTimeRange() == null || next.getTimeRange().equals(CMTimeRange.CMTimeRangeInvalid)) {
                    it.remove();
                }
            }
            Collections.sort(this.mSegments);
        }
    }

    private void parsePackagePath() {
        if (TextUtils.isEmpty(this.mFilePath)) {
            return;
        }
        File file = new File(this.mFilePath);
        if (!file.exists()) {
            return;
        }
        this.mPackagePath = file.getParentFile().getAbsolutePath();
    }

    private void replaceBitmap(TAVStickerImageItem tAVStickerImageItem, String str) {
        if (tAVStickerImageItem != null && FileUtils.exists(str)) {
            Logger.e(TAG, "set PAGImage url = " + str);
            tAVStickerImageItem.setBitmap(BitmapFactory.decodeFile(str, new BitmapFactory.Options()));
            this.mHasImageLayerSet = true;
        }
    }

    private List<TAVMovieClip> separateClip(TAVMovieClip tAVMovieClip) {
        ArrayList arrayList = new ArrayList();
        Iterator<MovieSegment> it = this.mSegments.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MovieSegment next = it.next();
            if (next != null) {
                if (!next.getMinOriginDuration().smallThan(tAVMovieClip.getResource().getTimeRange().getDuration())) {
                    arrayList.add(tAVMovieClip);
                    break;
                }
                TAVMovieClip m275clone = tAVMovieClip.m275clone();
                m275clone.getResource().setTimeRange(new CMTimeRange(m275clone.getResource().getTimeRange().getStart(), next.getMinOriginDuration()));
                arrayList.add(m275clone);
                tAVMovieClip.getResource().setTimeRange(new CMTimeRange(m275clone.getResource().getTimeRange().getEnd(), tAVMovieClip.getResource().getTimeRange().getDuration().sub(m275clone.getResource().getTimeRange().getDuration())));
            }
        }
        return arrayList;
    }

    private List<TAVMovieClip> separateClips(List<TAVMovieClip> list) {
        ArrayList<TAVMovieClip> arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<MovieSegment> it = this.mSegments.iterator();
        while (it.hasNext()) {
            MovieSegment next = it.next();
            if (next == null) {
                it.remove();
            } else {
                cMTime = cMTime.add(next.getTimeRange().getDuration());
            }
        }
        CMTime cMTime2 = CMTime.CMTimeZero;
        if (!cMTime.equalsTo(cMTime2) && !cMTime.smallThan(cMTime2)) {
            Iterator<TAVMovieClip> it5 = list.iterator();
            while (it5.hasNext()) {
                TAVMovieClip next2 = it5.next();
                if (next2 != null && next2.getResource() != null && next2.getResource().getTimeRange() != null) {
                    cMTime2 = cMTime2.add(next2.getResource().getTimeRange().getDuration());
                } else {
                    it5.remove();
                }
            }
            CMTime cMTime3 = CMTime.CMTimeZero;
            if (!cMTime2.equalsTo(cMTime3) && !cMTime2.smallThan(cMTime3)) {
                for (TAVMovieClip tAVMovieClip : list) {
                    CMTime duration = tAVMovieClip.getResource().getTimeRange().getDuration();
                    CMTime divide = duration.multi(cMTime).divide(cMTime2);
                    if (duration.bigThan(divide)) {
                        duration = divide;
                    }
                    concurrentHashMap.put(((TAVMovieTrackResource) tAVMovieClip.getResource()).getFilePath(), duration);
                }
                for (int i3 = 0; i3 < this.mSegments.size() && !list.isEmpty(); i3++) {
                    CMTime m259clone = this.mSegments.get(i3).getMinOriginDuration().m259clone();
                    while (m259clone.getTimeUs() > 0 && !list.isEmpty()) {
                        TAVMovieClip remove = list.remove(0);
                        CMTime duration2 = remove.getResource().getTimeRange().getDuration();
                        CMTime cMTime4 = CMTime.CMTimeZero;
                        for (TAVMovieClip tAVMovieClip2 : arrayList) {
                            if (TextUtils.equals(((TAVMovieTrackResource) tAVMovieClip2.getResource()).getFilePath(), ((TAVMovieTrackResource) remove.getResource()).getFilePath())) {
                                cMTime4 = cMTime4.add(tAVMovieClip2.getResource().getTimeRange().getDuration());
                            }
                        }
                        if (cMTime4.smallThan((CMTime) concurrentHashMap.get(((TAVMovieTrackResource) remove.getResource()).getFilePath()))) {
                            CMTime cMTime5 = CMTime.CMTimeZero;
                            if (duration2.bigThan(cMTime5) && (cMTime4.equalsTo(cMTime5) || !duration2.smallThan(m259clone))) {
                                TAVMovieClip m275clone = remove.m275clone();
                                CMTimeRange timeRange = m275clone.getResource().getTimeRange();
                                if (duration2.bigThan(m259clone)) {
                                    timeRange.setDuration(m259clone);
                                } else {
                                    timeRange.setDuration(duration2);
                                }
                                m275clone.getResource().setTimeRange(timeRange);
                                arrayList.add(m275clone);
                                CMTime sub = duration2.sub(m259clone);
                                if (sub.bigThan(cMTime5)) {
                                    CMTimeRange timeRange2 = remove.getResource().getTimeRange();
                                    timeRange2.setStart(timeRange2.getStart().add(m259clone));
                                    timeRange2.setDuration(sub);
                                    list.add(0, remove);
                                }
                                m259clone = m259clone.sub(duration2);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public TAVComposition buildCompositionFromMovie(TAVMovie tAVMovie) {
        return null;
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public List<TAVMovieSegment> convertClips(List<TAVMovieClip> list) {
        List<TAVMovieClip> cloneMovieClips = CloneUtil.cloneMovieClips(list);
        boolean isSingleVideo = isSingleVideo(cloneMovieClips);
        if (isSingleVideo && this.mSegments.size() > 1) {
            cloneMovieClips = separateClip(cloneMovieClips.get(0));
        } else if (isAllVideoClip(cloneMovieClips) && cloneMovieClips.size() < this.mSegments.size() && !isSingleVideo && this.mFirstFill) {
            cloneMovieClips = separateClips(cloneMovieClips);
            this.mFirstFill = false;
        }
        this.mNeedCycleFill = isNeedCycleFill(cloneMovieClips);
        for (MovieSegment movieSegment : this.mSegments) {
            movieSegment.setTavClips(null);
            movieSegment.setTavMovieClips(null);
        }
        for (MovieSegment movieSegment2 : this.mSegments) {
            if (cloneMovieClips == null || cloneMovieClips.isEmpty()) {
                break;
            }
            ArrayList arrayList = new ArrayList();
            List<TAVMovieTimeEffect> separateSegmentByTimeEffects = movieSegment2.separateSegmentByTimeEffects();
            Logger.d(TAG, "fillSegments begin");
            fillSegments(movieSegment2, cloneMovieClips, separateSegmentByTimeEffects, arrayList);
            Logger.d(TAG, "fillSegments end");
            if (!arrayList.isEmpty()) {
                movieSegment2.setTavClips(arrayList);
            }
        }
        correctSegments();
        ArrayList<TAVMovieSegment> arrayList2 = new ArrayList(this.mCorrectSegments);
        for (TAVMovieSegment tAVMovieSegment : arrayList2) {
            Logger.d(TAG, "segment, layerIndex: " + tAVMovieSegment.getLayerIndex() + ", start clip time: " + tAVMovieSegment.getTimeRange().getStart().getTimeSeconds() + ", end time: " + tAVMovieSegment.getTimeRange().getEnd().getTimeSeconds());
        }
        return arrayList2;
    }

    public TAVMovieClip getBackgroundMusic() {
        if (!TextUtils.isEmpty(this.mPagAudioPath) && FileUtils.exists(this.mPagAudioPath)) {
            TAVMovieClip tAVMovieClip = new TAVMovieClip();
            TAVMovieTrackResource tAVMovieTrackResource = new TAVMovieTrackResource(this.mPagAudioPath);
            tAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
            tAVMovieClip.setResource(tAVMovieTrackResource);
            return tAVMovieClip;
        }
        return null;
    }

    public List<MovieSegment> getCorrectSegments() {
        return this.mCorrectSegments;
    }

    public CMTime getMinOriginDuration() {
        CMTime cMTime = CMTime.CMTimeZero;
        for (MovieSegment movieSegment : this.mSegments) {
            if (movieSegment != null && movieSegment.getMinOriginDuration() != null) {
                cMTime = cMTime.add(movieSegment.getMinOriginDuration());
            }
        }
        return cMTime;
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public List<TAVMovieClip> getMovieClips() {
        List<TAVMovieClip> list = this.mOriginClips;
        if (list != null) {
            return list;
        }
        if (this.mCorrectSegments != null) {
            ArrayList arrayList = new ArrayList();
            for (MovieSegment movieSegment : this.mCorrectSegments) {
                if (movieSegment != null) {
                    arrayList.addAll(movieSegment.getTavMovieClips());
                }
            }
            return arrayList;
        }
        return null;
    }

    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public List<MovieSegment> getSegments() {
        return this.mSegments;
    }

    public List<TAVMovieSticker> getStickers() {
        return this.mStickers;
    }

    public TAVMovieSticker getTemplateSticker() {
        return this.mTemplateSticker;
    }

    public void loadTemplateData(TAVStickerResourceExporter.IStickerResourceExportListener iStickerResourceExportListener) {
        if (!this.mLoadDataListeners.contains(iStickerResourceExportListener)) {
            this.mLoadDataListeners.add(iStickerResourceExportListener);
        }
        if (!this.mLoadingData) {
            loadAudioData(this.mTemplateSticker.getSticker());
            this.mLoadingData = true;
        }
    }

    public void release() {
        List<MovieSegment> list = this.mSegments;
        if (list != null) {
            for (MovieSegment movieSegment : list) {
                if (movieSegment != null) {
                    movieSegment.release();
                }
            }
        }
        List<MovieSegment> list2 = this.mCorrectSegments;
        if (list2 != null) {
            for (MovieSegment movieSegment2 : list2) {
                if (movieSegment2 != null) {
                    movieSegment2.release();
                }
            }
        }
    }

    public void replaceSegment(MovieSegment movieSegment) {
        int index;
        if (movieSegment != null && this.mCorrectSegments != null && (index = movieSegment.getIndex()) >= 0) {
            this.mCorrectSegments.remove(index);
            this.mCorrectSegments.add(index, movieSegment);
        }
    }

    public void setFirstFill(boolean z16) {
        this.mFirstFill = z16;
    }

    public void setOriginClips(List<TAVMovieClip> list) {
        this.mOriginClips = list;
    }

    public void unloadTemplateData(TAVStickerResourceExporter.IStickerResourceExportListener iStickerResourceExportListener) {
        if (!this.mLoadDataListeners.contains(iStickerResourceExportListener)) {
            return;
        }
        this.mLoadDataListeners.remove(iStickerResourceExportListener);
    }

    public void updatePAGTextAndImage() {
        if (this.mHasImageLayerSet) {
            this.mTemplateSticker.updateImageData();
        }
        if (this.mHasTextLayerSet) {
            this.mTemplateSticker.updateTextData();
        }
    }

    public MovieTemplate(@NonNull String str, boolean z16) {
        this.mLoadDataListeners = new ArrayList();
        this.mLoadingData = false;
        this.mDownloadImageMap = new HashMap<>();
        this.mHasTextLayerSet = false;
        this.mHasImageLayerSet = false;
        this.mNeedCycleFill = false;
        this.mFirstFill = true;
        this.renderSize = new CGSize(720.0f, 1280.0f);
        this.mFilePath = str;
        this.mIsAsset = z16;
        initData();
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public void parseToMovie(TAVMovie tAVMovie) {
    }
}
