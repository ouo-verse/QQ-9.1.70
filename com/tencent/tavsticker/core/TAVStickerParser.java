package com.tencent.tavsticker.core;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerType;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.libpag.PAGComposition;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGMarker;
import org.libpag.PAGVideoRange;

/* loaded from: classes26.dex */
public class TAVStickerParser {
    private static long getParentLayerEndTime(PAGLayer pAGLayer) {
        PAGLayer rootLayer;
        long j3 = 0;
        if (pAGLayer == null || (rootLayer = getRootLayer(pAGLayer)) == null) {
            return 0L;
        }
        long duration = rootLayer.duration();
        PAGComposition parent = pAGLayer.parent();
        if (parent != null) {
            j3 = parent.localTimeToGlobal(parent.startTime()) + parent.duration();
        }
        return Math.min(j3, duration);
    }

    private static long getParentLayerStartTime(PAGLayer pAGLayer) {
        long j3;
        if (pAGLayer == null) {
            return 0L;
        }
        PAGComposition parent = pAGLayer.parent();
        if (parent != null) {
            j3 = parent.localTimeToGlobal(parent.startTime());
        } else {
            j3 = 0;
        }
        return Math.max(0L, j3);
    }

    private static PAGLayer getRootLayer(PAGLayer pAGLayer) {
        if (pAGLayer != null) {
            while (pAGLayer.parent() != null) {
                pAGLayer = pAGLayer.parent();
            }
            return pAGLayer;
        }
        return null;
    }

    private static TAVStickerLayerType getStickerLayerType(PAGLayer pAGLayer) {
        TAVStickerLayerType tAVStickerLayerType = TAVStickerLayerType.Unknown;
        if (pAGLayer != null) {
            switch (pAGLayer.layerType()) {
                case 0:
                default:
                    return tAVStickerLayerType;
                case 1:
                    return TAVStickerLayerType.Null;
                case 2:
                    return TAVStickerLayerType.Solid;
                case 3:
                    return TAVStickerLayerType.Text;
                case 4:
                    return TAVStickerLayerType.Shape;
                case 5:
                    return TAVStickerLayerType.Image;
                case 6:
                    return TAVStickerLayerType.PreCompose;
            }
        }
        return tAVStickerLayerType;
    }

    private static List<TAVStickerLayerInfo.TAVStickerImageEffect> parseImageEffects(PAGLayer pAGLayer) {
        if (pAGLayer == null) {
            return null;
        }
        return new ArrayList();
    }

    public static List<TAVStickerLayerInfo> parsePagComposition(PAGComposition pAGComposition, long j3) {
        if (pAGComposition == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int numLayers = pAGComposition.numLayers();
        for (int i3 = 0; i3 < numLayers; i3++) {
            PAGLayer layerAt = pAGComposition.getLayerAt(i3);
            if (layerAt != null) {
                if (6 == layerAt.layerType()) {
                    if (layerAt instanceof PAGComposition) {
                        List<TAVStickerLayerInfo> parsePagComposition = parsePagComposition((PAGComposition) layerAt, j3);
                        if (!CollectionUtil.isEmptyList(parsePagComposition)) {
                            arrayList.addAll(arrayList.size(), parsePagComposition);
                        }
                    }
                } else {
                    TAVStickerLayerInfo parsePagLayer = parsePagLayer(layerAt);
                    if (parsePagLayer != null) {
                        arrayList.add(parsePagLayer);
                    }
                }
            }
        }
        return arrayList;
    }

    public static TAVStickerLayerInfo parsePagLayer(PAGLayer pAGLayer) {
        List<TAVStickerLayerInfo.TAVStickerTimeEffect> list = null;
        if (pAGLayer == null) {
            return null;
        }
        int layerType = pAGLayer.layerType();
        if (5 != layerType && 3 != layerType && 4 != layerType) {
            return null;
        }
        long localTimeToGlobal = pAGLayer.localTimeToGlobal(pAGLayer.startTime());
        long duration = pAGLayer.duration() + localTimeToGlobal;
        CMTimeRange cMTimeRange = CMTimeRange.CMTimeRangeInvalid;
        long parentLayerStartTime = getParentLayerStartTime(pAGLayer);
        long parentLayerEndTime = getParentLayerEndTime(pAGLayer);
        if (parentLayerEndTime <= 0 || parentLayerStartTime > parentLayerEndTime) {
            return null;
        }
        if (localTimeToGlobal < parentLayerStartTime) {
            localTimeToGlobal = parentLayerStartTime;
        }
        if (localTimeToGlobal >= parentLayerEndTime) {
            return null;
        }
        if (duration > parentLayerEndTime) {
            duration = parentLayerEndTime;
        }
        long j3 = duration - localTimeToGlobal;
        if (j3 > 0) {
            cMTimeRange = new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(localTimeToGlobal)), new CMTime(TAVStickerUtil.microsecond2Seconds(j3)));
        }
        CMTimeRange cMTimeRange2 = cMTimeRange;
        if (5 == layerType && (pAGLayer instanceof PAGImageLayer)) {
            list = parseTimeEffects((PAGImageLayer) pAGLayer, j3);
        }
        List<TAVStickerLayerInfo.TAVStickerImageEffect> parseImageEffects = parseImageEffects(pAGLayer);
        List<TAVStickerLayerInfo.TAVStickerUserData> parseUserDataList = parseUserDataList(pAGLayer);
        TAVStickerLayerType stickerLayerType = getStickerLayerType(pAGLayer);
        return new TAVStickerLayerInfo(pAGLayer.editableIndex(), stickerLayerType, cMTimeRange2, list, parseImageEffects, parseUserDataList);
    }

    private static List<TAVStickerLayerInfo.TAVStickerTimeEffect> parseTimeEffects(PAGImageLayer pAGImageLayer, long j3) {
        PAGVideoRange[] pAGVideoRangeArr;
        int i3;
        long j16;
        if (pAGImageLayer != null) {
            long j17 = 0;
            if (j3 > 0) {
                ArrayList arrayList = new ArrayList();
                PAGVideoRange[] videoRanges = pAGImageLayer.getVideoRanges();
                if (videoRanges != null) {
                    int length = videoRanges.length;
                    int i16 = 0;
                    long j18 = 0;
                    while (i16 < length) {
                        PAGVideoRange pAGVideoRange = videoRanges[i16];
                        if (pAGVideoRange != null) {
                            long j19 = pAGVideoRange.startTime;
                            long j26 = pAGVideoRange.endTime - j19;
                            long j27 = pAGVideoRange.playDuration;
                            boolean z16 = pAGVideoRange.reversed;
                            if (j26 <= j17) {
                                j26 = j17;
                            }
                            if (j27 > j17) {
                                float f16 = (((float) j26) * 1.0f) / ((float) j27);
                                CMTimeRange cMTimeRange = CMTimeRange.CMTimeRangeInvalid;
                                long j28 = j27 + j18;
                                if (j18 < j3) {
                                    if (j28 > j3) {
                                        j16 = j3;
                                        pAGVideoRangeArr = videoRanges;
                                        i3 = length;
                                    } else {
                                        pAGVideoRangeArr = videoRanges;
                                        i3 = length;
                                        j16 = j28;
                                    }
                                    long j29 = j16 - j18;
                                    if (j29 > j17) {
                                        CMTimeRange cMTimeRange2 = new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(j18)), new CMTime(TAVStickerUtil.microsecond2Seconds(j29)));
                                        float f17 = f16 * ((float) j29);
                                        if (0.0f == f17) {
                                            f17 = 20000.0f;
                                        }
                                        arrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(j19)), new CMTime(f17 / 1000000.0f)), cMTimeRange2, z16));
                                    }
                                    j18 = j28;
                                    i16++;
                                    videoRanges = pAGVideoRangeArr;
                                    length = i3;
                                    j17 = 0;
                                }
                            }
                        }
                        pAGVideoRangeArr = videoRanges;
                        i3 = length;
                        i16++;
                        videoRanges = pAGVideoRangeArr;
                        length = i3;
                        j17 = 0;
                    }
                }
                Collections.sort(arrayList, new Comparator<TAVStickerLayerInfo.TAVStickerTimeEffect>() { // from class: com.tencent.tavsticker.core.TAVStickerParser.1
                    @Override // java.util.Comparator
                    public int compare(TAVStickerLayerInfo.TAVStickerTimeEffect tAVStickerTimeEffect, TAVStickerLayerInfo.TAVStickerTimeEffect tAVStickerTimeEffect2) {
                        if (tAVStickerTimeEffect == null || tAVStickerTimeEffect.getTimeRange() == null || tAVStickerTimeEffect2 == null || tAVStickerTimeEffect2.getTimeRange() == null) {
                            return 0;
                        }
                        return (int) (tAVStickerTimeEffect.getTimeRange().getStartUs() - tAVStickerTimeEffect.getTimeRange().getStartUs());
                    }
                });
                return arrayList;
            }
            return null;
        }
        return null;
    }

    private static List<TAVStickerLayerInfo.TAVStickerUserData> parseUserDataList(PAGLayer pAGLayer) {
        if (pAGLayer == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        PAGMarker[] markers = pAGLayer.markers();
        if (markers != null && markers.length > 0) {
            for (PAGMarker pAGMarker : markers) {
                if (pAGMarker != null) {
                    arrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(pAGMarker.mStartTime)), new CMTime(TAVStickerUtil.microsecond2Seconds(pAGMarker.mDuration))), pAGMarker.mComment));
                }
            }
        }
        return arrayList;
    }
}
