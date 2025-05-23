package com.tencent.tavcut.core.render.audio.extractor;

import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.audio.ExportCallback;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.util.TavExtractAudioHelper;
import com.tencent.tavcut.core.utils.d;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.videocut.utils.thread.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.light.TimeRange;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0002J2\u0010\u0010\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/extractor/TavAudioExtractor;", "Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractor;", "()V", "extractorListener", "Lcom/tencent/tavcut/core/render/audio/extractor/OnAudioExtractorListener;", "tavExtractAudioHelper", "Lcom/tencent/tavcut/core/render/util/TavExtractAudioHelper;", "cancelExtractAudio", "", "createTavComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "clipSourceList", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "listTimeLine", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "extractAudioFromClipSources", "timelineList", "outputAudioPath", "", "listener", "handleExporting", "progress", "", "startExtract", "composition", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TavAudioExtractor implements IAudioExtractor {
    private static final int MAX_PROGRESS = 100;
    private static final String TAG = "TavAudioExtractor";
    private OnAudioExtractorListener extractorListener;
    private TavExtractAudioHelper tavExtractAudioHelper = new TavExtractAudioHelper();

    /* JADX INFO: Access modifiers changed from: private */
    public final TAVComposition createTavComposition(List<ClipSource> clipSourceList, List<Timeline> listTimeLine) {
        List<Pair> zip;
        long j3;
        float f16;
        long roundToLong;
        ArrayList arrayList = new ArrayList();
        TAVComposition tAVComposition = new TAVComposition();
        zip = CollectionsKt___CollectionsKt.zip(clipSourceList, listTimeLine);
        for (Pair pair : zip) {
            ClipSource clipSource = (ClipSource) pair.component1();
            Timeline timeline = (Timeline) pair.component2();
            long j16 = 0;
            if (clipSource.getType() == ClipType.VIDEO) {
                String path = clipSource.getPath();
                if (path == null) {
                    path = "";
                }
                URLAsset a16 = d.a(path);
                if (a16 != null) {
                    TAVAssetTrackResource tAVAssetTrackResource = new TAVAssetTrackResource(a16);
                    Long startOffset = clipSource.getStartOffset();
                    if (startOffset != null) {
                        j3 = startOffset.longValue();
                    } else {
                        j3 = 0;
                    }
                    tAVAssetTrackResource.setSourceTimeRange(new CMTimeRange(CMTime.fromUs(j3), CMTime.fromUs(clipSource.getDuration())));
                    float duration = (float) clipSource.getDuration();
                    Float speed = clipSource.getSpeed();
                    if (speed != null) {
                        f16 = speed.floatValue();
                    } else {
                        f16 = 1.0f;
                    }
                    roundToLong = MathKt__MathJVMKt.roundToLong(duration / f16);
                    tAVAssetTrackResource.setScaledDuration(CMTime.fromUs(roundToLong));
                    TAVClip tAVClip = new TAVClip(tAVAssetTrackResource);
                    TimeRange range = timeline.getRange();
                    if (range != null) {
                        j16 = range.startTime;
                    }
                    tAVClip.setStartTime(CMTime.fromUs(j16));
                    arrayList.add(tAVClip);
                }
            } else if (clipSource.getType() == ClipType.PHOTO) {
                TAVClip tAVClip2 = new TAVClip(new TAVImageTrackResource(clipSource.getPath(), CMTime.fromUs(clipSource.getDuration())));
                TimeRange range2 = timeline.getRange();
                if (range2 != null) {
                    j16 = range2.startTime;
                }
                tAVClip2.setStartTime(CMTime.fromUs(j16));
                arrayList.add(tAVClip2);
            }
        }
        tAVComposition.setOverlays(arrayList);
        tAVComposition.setAudios(arrayList);
        return tAVComposition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleExporting(float progress, OnAudioExtractorListener listener) {
        if (progress < 0) {
            if (listener != null) {
                listener.onExtractError(2, "Extractor audio fail");
            }
        } else if (listener != null) {
            listener.onExtracting((int) (progress * 100));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startExtract(TAVComposition composition, final String outputAudioPath) {
        this.tavExtractAudioHelper.extractSingleAudioByComposition(composition, outputAudioPath, new ExportCallback() { // from class: com.tencent.tavcut.core.render.audio.extractor.TavAudioExtractor$startExtract$1
            @Override // com.tencent.tav.core.audio.ExportCallback
            public final void onProgress(int i3, float f16) {
                OnAudioExtractorListener onAudioExtractorListener;
                OnAudioExtractorListener onAudioExtractorListener2;
                OnAudioExtractorListener onAudioExtractorListener3;
                OnAudioExtractorListener onAudioExtractorListener4;
                if (i3 != 1) {
                    if (i3 == 2) {
                        onAudioExtractorListener2 = TavAudioExtractor.this.extractorListener;
                        if (onAudioExtractorListener2 != null) {
                            onAudioExtractorListener2.onExtracting(100);
                        }
                        onAudioExtractorListener3 = TavAudioExtractor.this.extractorListener;
                        if (onAudioExtractorListener3 != null) {
                            onAudioExtractorListener3.onExtractFinish(outputAudioPath);
                        }
                        TavAudioExtractor.this.extractorListener = null;
                        return;
                    }
                    if (i3 == 255) {
                        onAudioExtractorListener4 = TavAudioExtractor.this.extractorListener;
                        if (onAudioExtractorListener4 != null) {
                            onAudioExtractorListener4.onExtractError(2, "Extractor audio fail");
                        }
                        TavAudioExtractor.this.extractorListener = null;
                        return;
                    }
                    return;
                }
                TavAudioExtractor tavAudioExtractor = TavAudioExtractor.this;
                onAudioExtractorListener = tavAudioExtractor.extractorListener;
                tavAudioExtractor.handleExporting(f16, onAudioExtractorListener);
            }
        });
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.IAudioExtractor
    public void cancelExtractAudio() {
        this.tavExtractAudioHelper.cancelExtract();
        this.extractorListener = null;
    }

    public final void extractAudioFromClipSources(@NotNull final List<ClipSource> clipSourceList, @NotNull final List<Timeline> timelineList, @NotNull final String outputAudioPath, @NotNull OnAudioExtractorListener listener) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(clipSourceList, "clipSourceList");
        Intrinsics.checkParameterIsNotNull(timelineList, "timelineList");
        Intrinsics.checkParameterIsNotNull(outputAudioPath, "outputAudioPath");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (outputAudioPath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TavLogger.e(TAG, "Create audio failed");
            listener.onExtractError(1, "Create audio failed");
        } else {
            this.extractorListener = listener;
            c.f384289c.d(new Runnable() { // from class: com.tencent.tavcut.core.render.audio.extractor.TavAudioExtractor$extractAudioFromClipSources$1
                @Override // java.lang.Runnable
                public final void run() {
                    OnAudioExtractorListener onAudioExtractorListener;
                    TAVComposition createTavComposition;
                    onAudioExtractorListener = TavAudioExtractor.this.extractorListener;
                    if (onAudioExtractorListener != null) {
                        onAudioExtractorListener.onExtractStart();
                    }
                    TavAudioExtractor tavAudioExtractor = TavAudioExtractor.this;
                    createTavComposition = tavAudioExtractor.createTavComposition(clipSourceList, timelineList);
                    tavAudioExtractor.startExtract(createTavComposition, outputAudioPath);
                }
            });
        }
    }
}
