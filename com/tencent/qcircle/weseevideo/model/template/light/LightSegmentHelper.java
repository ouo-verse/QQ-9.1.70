package com.tencent.qcircle.weseevideo.model.template.light;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipAsset;
import org.light.ClipPlaceHolder;
import org.light.PhotoClip;
import org.light.VideoClip;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J:\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\t\u001a\u00020\nJB\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J,\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\t\u001a\u00020\nJ(\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010 2\u0006\u0010!\u001a\u00020\u001eJ0\u0010\"\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J&\u0010#\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 H\u0002J\u0018\u0010$\u001a\u00020\u001e2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\u0016\u0010%\u001a\u00020\u001e2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0016\u0010'\u001a\u00020\u001e2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u001b\u0010(\u001a\u00020\u001e2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*\u00a2\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020\u001e2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J#\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0007\u00a2\u0006\u0002\u00100J$\u00101\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010 2\u0006\u00102\u001a\u00020\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J4\u00104\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010 2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010 2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/template/light/LightSegmentHelper;", "", "()V", "TAG", "", "fillClips", "", "segment", "Lcom/tencent/qcircle/weseevideo/model/template/movie/MovieSegmentModel;", "musicVolume", "", "clips", "Ljava/util/ArrayList;", "Lorg/light/ClipAsset;", "Lkotlin/collections/ArrayList;", "fillOriginClipsToEmptySegmentTemplate", "originClips", "", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "lightSegments", "fillOriginResToClipAsset", "duration", "", "fillPhotoClips", "videoRes", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "fillPhotoSegment", "mediaClip", "fillSegmentToClipAsset", "fillSegments", "", "remainClips", "", "mNeedCycleFill", "fillVideoClips", "fillVideoSegment", "isAllPhotoClip", "isAllVideoClip", "movieClips", "isNeedCycleFill", "isNoDurationLimitTemplate", "clipHolders", "", "Lorg/light/ClipPlaceHolder;", "([Lorg/light/ClipPlaceHolder;)Z", "isSingleVideo", "parseLightSegmentInfo", "clipPlaceHolders", "([Lorg/light/ClipPlaceHolder;)Ljava/util/List;", "separateClip", "clip", "mLightSegments", "separateClips", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class LightSegmentHelper {
    public static final LightSegmentHelper INSTANCE = new LightSegmentHelper();

    @NotNull
    public static final String TAG = "LightSegmentHelper";

    LightSegmentHelper() {
    }

    private final void fillClips(MovieSegmentModel segment, float musicVolume, ArrayList<ClipAsset> clips) {
        Iterator<VideoResourceModel> it = segment.getVideoResourceModels().iterator();
        while (it.hasNext()) {
            VideoResourceModel videoRes = it.next();
            if (videoRes.getType() == 1) {
                Intrinsics.checkExpressionValueIsNotNull(videoRes, "videoRes");
                fillVideoClips(videoRes, musicVolume, clips);
            } else if (videoRes.getType() == 2) {
                Intrinsics.checkExpressionValueIsNotNull(videoRes, "videoRes");
                fillPhotoClips(videoRes, clips);
            }
        }
    }

    private final void fillPhotoClips(VideoResourceModel videoRes, ArrayList<ClipAsset> clips) {
        PhotoClip photoClip = new PhotoClip();
        photoClip.path = videoRes.getPath();
        photoClip.duration = videoRes.getSelectTimeDurationUs();
        clips.add(photoClip);
    }

    private final void fillPhotoSegment(MediaClipModel mediaClip, MovieSegmentModel segment) {
        VideoResourceModel resource = mediaClip.getResource();
        Logger.d(TAG, "begin--fillClipsPhoto photo path: " + resource.getPath());
        CMTimeRange timeRange = segment.getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(timeRange, "segment.timeRange");
        VideoResourceModel copy$default = VideoResourceModel.copy$default(resource, null, 0L, 0, 0L, 0L, 0L, timeRange.getDurationUs(), 0L, 0L, 0, 0, 0, null, 8127, null);
        segment.getVideoResourceModels().add(copy$default);
        Logger.d(TAG, "end--fillClipsPhoto photo path: " + copy$default.getPath());
    }

    private final void fillVideoClips(VideoResourceModel videoRes, float musicVolume, ArrayList<ClipAsset> clips) {
        VideoClip videoClip = new VideoClip();
        videoClip.path = videoRes.getPath();
        videoClip.speed = videoRes.getSpeed();
        videoClip.startOffset = videoRes.getSelectTimeStartUs();
        videoClip.volume = musicVolume;
        videoClip.duration = videoRes.getSelectTimeDurationUs();
        clips.add(videoClip);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
    
        if (r29 > r1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fillVideoSegment(MediaClipModel mediaClip, MovieSegmentModel segment, List<MediaClipModel> remainClips) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        CMTimeRange timeRange = segment.getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(timeRange, "segment.timeRange");
        long durationUs = timeRange.getDurationUs();
        MediaClipModel mediaClipModel = mediaClip;
        while (durationUs > 0) {
            long selectTimeDurationUs = mediaClipModel.getResource().getSelectTimeDurationUs();
            int type = mediaClipModel.getResource().getType();
            if (arrayList.isEmpty()) {
                z16 = true;
                if (type == 1) {
                }
            }
            z16 = false;
            if (z16) {
                mediaClipModel = MediaClipModel.copy$default(mediaClipModel, VideoResourceModel.copy$default(mediaClipModel.getResource(), null, durationUs / 1000, 0, 0L, 0L, mediaClipModel.getResource().getSelectTimeStartUs() + ((selectTimeDurationUs - durationUs) / 2), durationUs, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
            } else {
                if (type == 2) {
                    mediaClipModel = MediaClipModel.copy$default(mediaClipModel, VideoResourceModel.copy$default(mediaClipModel.getResource(), null, durationUs / 1000, 0, 0L, 0L, 0L, durationUs, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
                    selectTimeDurationUs = durationUs;
                }
                if (durationUs < selectTimeDurationUs) {
                    mediaClipModel = MediaClipModel.copy$default(mediaClipModel, VideoResourceModel.copy$default(mediaClipModel.getResource(), null, durationUs / 1000, 0, 0L, 0L, mediaClipModel.getResource().getSelectTimeStartUs(), durationUs, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
                }
            }
            arrayList.add(mediaClipModel);
            durationUs -= selectTimeDurationUs;
            if (durationUs > 0) {
                if (remainClips.size() == 0) {
                    break;
                } else {
                    mediaClipModel = remainClips.remove(0);
                }
            }
        }
        ArrayList<VideoResourceModel> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((MediaClipModel) it.next()).getResource());
        }
        segment.setVideoResourceModels(arrayList2);
    }

    private final boolean isAllPhotoClip(List<MediaClipModel> clips) {
        if (clips == null || clips.isEmpty()) {
            return false;
        }
        for (MediaClipModel mediaClipModel : clips) {
            if (mediaClipModel != null && mediaClipModel.getResource().getType() != 2) {
                return false;
            }
        }
        return true;
    }

    private final boolean isSingleVideo(List<MediaClipModel> clips) {
        if (clips == null || clips.size() != 1 || clips.get(0).getResource().getType() != 1) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ArrayList<ClipAsset> fillOriginClipsToEmptySegmentTemplate(@NotNull List<MediaClipModel> originClips, @NotNull List<? extends MovieSegmentModel> lightSegments, float musicVolume) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(originClips, "originClips");
        Intrinsics.checkParameterIsNotNull(lightSegments, "lightSegments");
        ArrayList<ClipAsset> arrayList = new ArrayList<>();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(originClips.size(), lightSegments.size());
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            MediaClipModel mediaClipModel = originClips.get(i3);
            if (mediaClipModel.getResource().getType() == 2) {
                fillPhotoClips(mediaClipModel.getResource(), arrayList);
            } else if (mediaClipModel.getResource().getType() == 1) {
                fillVideoClips(mediaClipModel.getResource(), musicVolume, arrayList);
            }
            lightSegments.get(i3).getVideoResourceModels().add(mediaClipModel.getResource());
        }
        return arrayList;
    }

    @NotNull
    public final ArrayList<ClipAsset> fillOriginResToClipAsset(@NotNull List<MediaClipModel> clips, @NotNull List<? extends MovieSegmentModel> lightSegments, float musicVolume, long duration) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        Intrinsics.checkParameterIsNotNull(lightSegments, "lightSegments");
        List<MediaClipModel> arrayList = new ArrayList<>();
        Iterator<MediaClipModel> it = clips.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().deepCopy());
        }
        boolean isSingleVideo = isSingleVideo(arrayList);
        if (isSingleVideo && lightSegments.size() > 1) {
            arrayList = separateClip(arrayList.get(0), lightSegments);
        } else if (isAllVideoClip(arrayList) && arrayList.size() < lightSegments.size() && !isSingleVideo) {
            arrayList = separateClips(arrayList, lightSegments, duration);
        }
        boolean isNeedCycleFill = isNeedCycleFill(arrayList);
        for (MovieSegmentModel movieSegmentModel : lightSegments) {
            if (arrayList == null || arrayList.isEmpty()) {
                break;
            }
            Logger.d(TAG, "fillSegments begin");
            fillSegments(movieSegmentModel, arrayList, isNeedCycleFill);
            Logger.d(TAG, "fillSegments end");
        }
        return fillSegmentToClipAsset(lightSegments, musicVolume);
    }

    @NotNull
    public final ArrayList<ClipAsset> fillSegmentToClipAsset(@NotNull List<? extends MovieSegmentModel> lightSegments, float musicVolume) {
        Intrinsics.checkParameterIsNotNull(lightSegments, "lightSegments");
        ArrayList<ClipAsset> arrayList = new ArrayList<>();
        Iterator<? extends MovieSegmentModel> it = lightSegments.iterator();
        while (it.hasNext()) {
            fillClips(it.next(), musicVolume, arrayList);
        }
        return arrayList;
    }

    public final boolean fillSegments(@Nullable MovieSegmentModel segment, @Nullable List<MediaClipModel> remainClips, boolean mNeedCycleFill) {
        MediaClipModel remove;
        if (segment == null || remainClips == null || remainClips.isEmpty()) {
            return false;
        }
        if (mNeedCycleFill) {
            remove = remainClips.remove(0);
            remainClips.add(remove.deepCopy());
        } else {
            remove = remainClips.remove(0);
        }
        if (remove == null) {
            return false;
        }
        int type = remove.getResource().getType();
        if (type != 1) {
            if (type == 2) {
                fillPhotoSegment(remove, segment);
            }
        } else {
            fillVideoSegment(remove, segment, remainClips);
        }
        return true;
    }

    public final boolean isAllVideoClip(@Nullable List<MediaClipModel> movieClips) {
        if (movieClips == null || movieClips.isEmpty()) {
            return false;
        }
        for (MediaClipModel mediaClipModel : movieClips) {
            if (mediaClipModel != null && mediaClipModel.getResource().getType() != 1) {
                return false;
            }
        }
        return true;
    }

    public final boolean isNeedCycleFill(@Nullable List<MediaClipModel> clips) {
        return isAllPhotoClip(clips);
    }

    public final boolean isNoDurationLimitTemplate(@Nullable ClipPlaceHolder[] clipHolders) {
        boolean z16;
        if (clipHolders != null) {
            if (clipHolders.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (ClipPlaceHolder clipPlaceHolder : clipHolders) {
                    if (clipPlaceHolder.contentDuration != 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    @NotNull
    public final List<MovieSegmentModel> parseLightSegmentInfo(@Nullable ClipPlaceHolder[] clipPlaceHolders) {
        List<MovieSegmentModel> emptyList;
        boolean z16;
        if (clipPlaceHolders != null) {
            if (clipPlaceHolders.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList();
                for (ClipPlaceHolder clipPlaceHolder : clipPlaceHolders) {
                    MovieSegmentModel movieSegmentModel = new MovieSegmentModel();
                    movieSegmentModel.setTimeRange(CMTimeRange.fromUs(0L, clipPlaceHolder.contentDuration));
                    movieSegmentModel.setMinDuration(CMTime.fromUs(clipPlaceHolder.contentDuration));
                    arrayList.add(movieSegmentModel);
                }
                return arrayList;
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Nullable
    public final List<MediaClipModel> separateClip(@NotNull MediaClipModel clip, @NotNull List<? extends MovieSegmentModel> mLightSegments) {
        MediaClipModel clip2 = clip;
        Intrinsics.checkParameterIsNotNull(clip2, "clip");
        Intrinsics.checkParameterIsNotNull(mLightSegments, "mLightSegments");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends MovieSegmentModel> it = mLightSegments.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MovieSegmentModel next = it.next();
            if (next != null) {
                CMTimeRange timeRange = next.getTimeRange();
                Intrinsics.checkExpressionValueIsNotNull(timeRange, "segment.timeRange");
                if (timeRange.getDurationUs() >= clip2.getResource().getSelectTimeDurationUs()) {
                    arrayList.add(clip2);
                    break;
                }
                VideoResourceModel resource = clip2.getResource();
                CMTimeRange timeRange2 = next.getTimeRange();
                Intrinsics.checkExpressionValueIsNotNull(timeRange2, "segment.timeRange");
                long durationUs = timeRange2.getDurationUs();
                CMTimeRange timeRange3 = next.getTimeRange();
                Intrinsics.checkExpressionValueIsNotNull(timeRange3, "segment.timeRange");
                long j3 = 1000;
                MediaClipModel copy$default = MediaClipModel.copy$default(clip2, VideoResourceModel.copy$default(resource, null, timeRange3.getDurationUs() / j3, 0, 0L, 0L, clip2.getResource().getSelectTimeStartUs(), durationUs, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
                arrayList.add(copy$default);
                long selectTimeDurationUs = clip2.getResource().getSelectTimeDurationUs() - copy$default.getResource().getSelectTimeDurationUs();
                clip2 = MediaClipModel.copy$default(clip2, VideoResourceModel.copy$default(clip2.getResource(), null, selectTimeDurationUs / j3, 0, 0L, 0L, copy$default.getResource().getSelectTimeStartUs() + copy$default.getResource().getSelectTimeDurationUs(), selectTimeDurationUs, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
            }
        }
        return arrayList;
    }

    @Nullable
    public final List<MediaClipModel> separateClips(@Nullable List<MediaClipModel> movieClips, @NotNull List<? extends MovieSegmentModel> lightSegments, long duration) {
        int i3;
        long j3;
        long j16;
        Intrinsics.checkParameterIsNotNull(lightSegments, "lightSegments");
        ArrayList<MediaClipModel> arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        long j17 = 0;
        if (duration <= 0) {
            return arrayList;
        }
        if (movieClips == null) {
            Intrinsics.throwNpe();
        }
        Iterator<MediaClipModel> it = movieClips.iterator();
        long j18 = 0;
        while (it.hasNext()) {
            MediaClipModel next = it.next();
            if (next != null && next.getResource().getSelectTimeDurationUs() != 0) {
                j18 += next.getResource().getSelectTimeDurationUs();
            } else {
                it.remove();
            }
        }
        if (j18 <= 0) {
            return arrayList;
        }
        for (MediaClipModel mediaClipModel : movieClips) {
            long selectTimeDurationUs = mediaClipModel.getResource().getSelectTimeDurationUs();
            long j19 = (selectTimeDurationUs * duration) / j18;
            if (selectTimeDurationUs >= j19) {
                selectTimeDurationUs = j19;
            }
            String path = mediaClipModel.getResource().getPath();
            if (path == null) {
                path = "";
            }
            concurrentHashMap.put(path, Long.valueOf(selectTimeDurationUs));
        }
        int size = lightSegments.size();
        int i16 = 0;
        int i17 = 0;
        while (i17 < size && !movieClips.isEmpty()) {
            CMTimeRange timeRange = lightSegments.get(i17).getTimeRange();
            Intrinsics.checkExpressionValueIsNotNull(timeRange, "segment.timeRange");
            long durationUs = timeRange.getDurationUs();
            while (durationUs > j17 && (!movieClips.isEmpty())) {
                MediaClipModel remove = movieClips.remove(i16);
                long selectTimeDurationUs2 = remove.getResource().getSelectTimeDurationUs();
                long j26 = j17;
                for (MediaClipModel mediaClipModel2 : arrayList) {
                    if (TextUtils.equals(mediaClipModel2.getResource().getPath(), remove.getResource().getPath())) {
                        j26 += mediaClipModel2.getResource().getSelectTimeDurationUs();
                    }
                }
                Object obj = concurrentHashMap.get(remove.getResource().getPath());
                if (obj == null) {
                    Intrinsics.throwNpe();
                }
                if (j26 <= ((Number) obj).longValue()) {
                    if (selectTimeDurationUs2 <= 0) {
                        j3 = 0;
                        i3 = 0;
                    } else if (j26 == 0 || selectTimeDurationUs2 >= durationUs) {
                        if (selectTimeDurationUs2 > durationUs) {
                            j16 = durationUs;
                        } else {
                            j16 = selectTimeDurationUs2;
                        }
                        long j27 = 1000;
                        arrayList.add(MediaClipModel.copy$default(remove, VideoResourceModel.copy$default(remove.getResource(), null, j16 / j27, 0, 0L, 0L, 0L, j16, 0L, 0L, 0, 0, 0, null, 8125, null), null, null, null, null, 0L, null, 126, null));
                        long j28 = selectTimeDurationUs2 - durationUs;
                        j3 = 0;
                        if (j28 > 0) {
                            i3 = 0;
                            movieClips.add(0, MediaClipModel.copy$default(remove, VideoResourceModel.copy$default(remove.getResource(), null, j28 / j27, 0, 0L, 0L, remove.getResource().getSelectTimeStartUs() + durationUs, j28, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null));
                        } else {
                            i3 = 0;
                        }
                        durationUs -= selectTimeDurationUs2;
                    }
                    i16 = i3;
                    j17 = j3;
                }
                i3 = 0;
                j3 = 0;
                i16 = i3;
                j17 = j3;
            }
            i17++;
            i16 = i16;
            j17 = j17;
        }
        return arrayList;
    }
}
