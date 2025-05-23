package com.tencent.tavkit.composition.builder;

import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVVideoCompositionInstruction;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoInstructionsBuilder {
    private final BuilderModel builderModel;
    private final List<TAVVideoCompositionInstruction> outputInstructions = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Slice {
        private List<TAVVideoCompositionLayerInstruction> layerInstructions;
        private CMTimeRange timeRange;

        Slice(CMTimeRange cMTimeRange, List<TAVVideoCompositionLayerInstruction> list) {
            this.timeRange = cMTimeRange;
            this.layerInstructions = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoInstructionsBuilder(BuilderModel builderModel) {
        this.builderModel = builderModel;
    }

    @NonNull
    private TAVVideoCompositionInstruction buildInstruction(Slice slice, List<TAVVideoCompositionLayerInstruction> list, List<List<TAVVideoCompositionLayerInstruction>> list2) {
        TAVVideoCompositionInstruction tAVVideoCompositionInstruction = new TAVVideoCompositionInstruction(trackIDsByLayers(slice.layerInstructions), slice.timeRange);
        tAVVideoCompositionInstruction.setChannelLayers(selectChannels(list2, slice.layerInstructions));
        tAVVideoCompositionInstruction.setOverlayLayers(selectLayers(list, slice.layerInstructions));
        tAVVideoCompositionInstruction.setBackgroundColor(this.builderModel.getBackgroundColor());
        tAVVideoCompositionInstruction.setGlobalVideoEffect(this.builderModel.getTavComposition().getGlobalVideoEffect());
        tAVVideoCompositionInstruction.setVideoMixEffect(this.builderModel.getTavComposition().getVideoMixEffect());
        tAVVideoCompositionInstruction.setSourceVideoEffect(this.builderModel.getTavComposition().getSourceVideoEffect());
        return tAVVideoCompositionInstruction;
    }

    private void buildInstructions(List<List<TAVVideoCompositionLayerInstruction>> list, List<TAVVideoCompositionLayerInstruction> list2, List<Slice> list3) {
        Iterator<Slice> it = list3.iterator();
        while (it.hasNext()) {
            this.outputInstructions.add(buildInstruction(it.next(), list2, list));
        }
    }

    private static List<Slice> calculateSlicesForLayerInstructions(List<TAVVideoCompositionLayerInstruction> list) {
        TreeSet treeSet = new TreeSet(new Comparator<CMTime>() { // from class: com.tencent.tavkit.composition.builder.VideoInstructionsBuilder.1
            @Override // java.util.Comparator
            public int compare(CMTime cMTime, CMTime cMTime2) {
                return (int) cMTime.sub(cMTime2).getValue();
            }
        });
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : list) {
            treeSet.add(tAVVideoCompositionLayerInstruction.getTimeRange().getStart());
            treeSet.add(tAVVideoCompositionLayerInstruction.getTimeRange().getEnd());
        }
        ArrayList arrayList = new ArrayList();
        CMTime cMTime = (CMTime) treeSet.pollFirst();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            CMTime cMTime2 = (CMTime) it.next();
            CMTimeRange cMTimeRange = new CMTimeRange(cMTime, cMTime2.sub(cMTime));
            ArrayList arrayList2 = new ArrayList();
            for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction2 : list) {
                long timeUs = tAVVideoCompositionLayerInstruction2.getTimeRange().getStart().getTimeUs();
                long timeUs2 = tAVVideoCompositionLayerInstruction2.getTimeRange().getEnd().getTimeUs();
                long timeUs3 = cMTime2.getTimeUs();
                if (timeUs2 >= cMTime.getTimeUs() && timeUs <= timeUs3) {
                    arrayList2.add(tAVVideoCompositionLayerInstruction2);
                }
            }
            arrayList.add(new Slice(cMTimeRange, arrayList2));
            cMTime = cMTime2;
        }
        return arrayList;
    }

    @NonNull
    private List<TAVVideoCompositionLayerInstruction> concatAndSortLayers(List<List<TAVVideoCompositionLayerInstruction>> list, List<TAVVideoCompositionLayerInstruction> list2) {
        ArrayList arrayList = new ArrayList();
        Iterator<List<TAVVideoCompositionLayerInstruction>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        arrayList.addAll(list2);
        Collections.sort(arrayList, new Comparator<TAVVideoCompositionLayerInstruction>() { // from class: com.tencent.tavkit.composition.builder.VideoInstructionsBuilder.2
            @Override // java.util.Comparator
            public int compare(TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction, TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction2) {
                CMTime start = tAVVideoCompositionLayerInstruction.getTimeRange().getStart();
                CMTime start2 = tAVVideoCompositionLayerInstruction2.getTimeRange().getStart();
                if (start.equalsTo(start2)) {
                    return 0;
                }
                return start.smallThan(start2) ? -1 : 1;
            }
        });
        return arrayList;
    }

    private void fixLastLayerDuration(List<List<TAVVideoCompositionLayerInstruction>> list) {
        List<TAVVideoCompositionLayerInstruction> list2;
        if (list != null && list.size() == 1 && (list2 = list.get(0)) != null && !list2.isEmpty()) {
            TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction = list2.get(list2.size() - 1);
            CMTime frameDuration = this.builderModel.getTavComposition().getFrameDuration();
            if (frameDuration == null) {
                frameDuration = new CMTime(1L, 30);
            }
            tAVVideoCompositionLayerInstruction.setTimeRange(new CMTimeRange(tAVVideoCompositionLayerInstruction.getTimeRange().getStart(), tAVVideoCompositionLayerInstruction.getTimeRange().getDuration().add(frameDuration)));
        }
    }

    @NonNull
    private List<List<TAVVideoCompositionLayerInstruction>> selectChannels(List<List<TAVVideoCompositionLayerInstruction>> list, List<TAVVideoCompositionLayerInstruction> list2) {
        ArrayList arrayList = new ArrayList();
        Iterator<List<TAVVideoCompositionLayerInstruction>> it = list.iterator();
        while (it.hasNext()) {
            List<TAVVideoCompositionLayerInstruction> selectLayers = selectLayers(list2, it.next());
            if (selectLayers.size() > 0) {
                arrayList.add(selectLayers);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<TAVVideoCompositionLayerInstruction> selectLayers(List<TAVVideoCompositionLayerInstruction> list, List<TAVVideoCompositionLayerInstruction> list2) {
        ArrayList arrayList = new ArrayList();
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : list) {
            if (list2.contains(tAVVideoCompositionLayerInstruction)) {
                arrayList.add(tAVVideoCompositionLayerInstruction);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<Integer> trackIDsByLayers(List<TAVVideoCompositionLayerInstruction> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<TAVVideoCompositionLayerInstruction> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().getTrackID()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<TAVVideoCompositionInstruction> build() {
        List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions = buildMainLayerInstructions();
        List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions = buildOverlayLayerInstructions();
        buildInstructions(buildMainLayerInstructions, buildOverlayLayerInstructions, calculateSlicesForLayerInstructions(concatAndSortLayers(buildMainLayerInstructions, buildOverlayLayerInstructions)));
        return this.outputInstructions;
    }

    List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions() {
        ArrayList arrayList = new ArrayList();
        for (List<VideoInfo> list : this.builderModel.getMainVideoTrackInfo()) {
            ArrayList arrayList2 = new ArrayList();
            for (VideoInfo videoInfo : list) {
                arrayList2.add(new TAVVideoCompositionLayerInstruction(videoInfo.compositionTrack.getTrackID(), videoInfo.clip));
            }
            arrayList.add(arrayList2);
        }
        fixLastLayerDuration(arrayList);
        return arrayList;
    }

    List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions() {
        ArrayList arrayList = new ArrayList();
        Iterator<VideoOverlayInfo> it = this.builderModel.getOverlayTrackInfo().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().convertToLayerInstruction());
        }
        return arrayList;
    }
}
