package com.tencent.tavsticker.model;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.tavsticker.core.ITAVStickerProgressHandler;
import com.tencent.tavsticker.core.ITAVStickerRenderer;
import com.tencent.tavsticker.core.TAVPAGFileManager;
import com.tencent.tavsticker.core.TAVStickerFakeParser;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.tavsticker.utils.TimeRangeUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGMarker;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGText;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVSticker implements Cloneable {
    private static final String TAG = "TAVSticker";
    public static final String VIDEO_TRACK = "videoTrack";
    private ITAVStickerProgressHandler progressHandler;
    private boolean isInit = false;
    private String filePath = "";
    private String assetFilePath = "";
    private String uniqueId = "";
    private String stickerId = "";
    private int layerIndex = -1;
    private PAGFile pagFile = null;
    private ArrayList<TAVStickerTextItem> textList = null;
    private CopyOnWriteArrayList<ITAVStickerRenderer> rendererList = null;
    private ArrayList<TAVStickerImageItem> imageList = null;
    private ArrayList<TAVStickerSolidItem> solidList = null;
    private ArrayList<TAVStickerShapeItem> shapeList = null;
    private CMTimeRange timeRange = null;
    private int strokeColor = -16711936;
    private int strokeWidth = 0;
    private boolean isShowDefaultBorder = false;
    private float scale = 0.5f;
    private int scaleMode = 0;
    private float maxScale = 0.0f;
    private float minScale = 0.0f;
    private float rotate = 0.0f;
    private float centerX = 0.0f;
    private float centerY = 0.0f;
    private TAVStickerMoveLimit tavStickerMoveLimit = TAVStickerMoveLimit.LIMIT_CENTER_POINT;
    private RectF moveRect = null;
    private boolean editable = true;
    private TAVStickerMode mode = TAVStickerMode.DEFAULT;
    private boolean isAutoPlay = true;
    private String extras = "";
    private Bundle extraBundle = new Bundle(1);
    private TAVStickerAnimationMode animationMode = TAVStickerAnimationMode.TAVStickerAnimationModeDefault;

    /* compiled from: P */
    /* renamed from: com.tencent.tavsticker.model.TAVSticker$4, reason: invalid class name */
    /* loaded from: classes26.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tavsticker$model$TAVSticker$TAVStickerAnimationMode;

        static {
            int[] iArr = new int[TAVStickerAnimationMode.values().length];
            $SwitchMap$com$tencent$tavsticker$model$TAVSticker$TAVStickerAnimationMode = iArr;
            try {
                iArr[TAVStickerAnimationMode.TAVStickerAnimationModeFreeze.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tavsticker$model$TAVSticker$TAVStickerAnimationMode[TAVStickerAnimationMode.TAVStickerAnimationModeScaleUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface ScaleMode {
        public static final int aspectFill = 1;
        public static final int aspectFit = 0;
        public static final int scaleFit = 2;
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum TAVStickerAnimationMode {
        TAVStickerAnimationModeDefault,
        TAVStickerAnimationModeFreeze,
        TAVStickerAnimationModeScaleUp
    }

    public static String getLayerValue(@NonNull String str) {
        try {
            return new JSONObject(str).optString("key");
        } catch (Exception e16) {
            e16.printStackTrace();
            return str;
        }
    }

    private List<PAGText> getPAGTextListFromFile() {
        PAGFile pAGFile = this.pagFile;
        ArrayList arrayList = null;
        if (pAGFile == null) {
            return null;
        }
        int numTexts = pAGFile.numTexts();
        if (numTexts > 0) {
            arrayList = new ArrayList();
            for (int i3 = 0; i3 < numTexts; i3++) {
                PAGText textData = this.pagFile.getTextData(i3);
                if (textData != null) {
                    arrayList.add(textData);
                }
            }
        }
        return arrayList;
    }

    private ArrayList<PAGLayer> layersInComposition(PAGComposition pAGComposition, int i3) {
        if (pAGComposition == null) {
            return null;
        }
        ArrayList<PAGLayer> arrayList = new ArrayList<>();
        int numLayers = pAGComposition.numLayers();
        for (int i16 = 0; i16 < numLayers; i16++) {
            PAGLayer layerAt = pAGComposition.getLayerAt(i16);
            if (layerAt != null) {
                if (6 == layerAt.layerType()) {
                    if (layerAt instanceof PAGComposition) {
                        ArrayList<PAGLayer> layersInComposition = layersInComposition((PAGComposition) layerAt, i3);
                        if (!CollectionUtil.isEmptyList(layersInComposition)) {
                            arrayList.addAll(arrayList.size(), layersInComposition);
                        }
                    }
                } else if (i3 == layerAt.layerType()) {
                    arrayList.add(layerAt);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<PAGLayer>() { // from class: com.tencent.tavsticker.model.TAVSticker.2
            @Override // java.util.Comparator
            public int compare(PAGLayer pAGLayer, PAGLayer pAGLayer2) {
                if (pAGLayer == null || pAGLayer2 == null) {
                    return 0;
                }
                return pAGLayer.editableIndex() - pAGLayer2.editableIndex();
            }
        });
        return arrayList;
    }

    private ArrayList<TAVStickerImageItem> readAllImageData() {
        ArrayList<TAVStickerImageItem> arrayList = new ArrayList<>();
        ArrayList<PAGLayer> layersInComposition = layersInComposition(this.pagFile, 5);
        if (CollectionUtil.isEmptyList(layersInComposition)) {
            return arrayList;
        }
        int size = layersInComposition.size();
        for (int i3 = 0; i3 < size; i3++) {
            PAGLayer pAGLayer = layersInComposition.get(i3);
            if (pAGLayer != null) {
                TAVStickerImageItem tAVStickerImageItem = new TAVStickerImageItem(pAGLayer);
                if (-1 == tAVStickerImageItem.getLayerIndex()) {
                    tAVStickerImageItem.setLayerIndex(i3);
                }
                arrayList.add(tAVStickerImageItem);
            }
        }
        return arrayList;
    }

    private ArrayList<TAVStickerShapeItem> readAllShapeData() {
        ArrayList<TAVStickerShapeItem> arrayList = new ArrayList<>();
        ArrayList<PAGLayer> layersInComposition = layersInComposition(this.pagFile, 4);
        if (CollectionUtil.isEmptyList(layersInComposition)) {
            return arrayList;
        }
        int size = layersInComposition.size();
        for (int i3 = 0; i3 < size; i3++) {
            PAGLayer pAGLayer = layersInComposition.get(i3);
            if (pAGLayer != null) {
                TAVStickerShapeItem tAVStickerShapeItem = new TAVStickerShapeItem(pAGLayer);
                if (-1 == tAVStickerShapeItem.getLayerIndex()) {
                    tAVStickerShapeItem.setLayerIndex(i3);
                }
                arrayList.add(tAVStickerShapeItem);
            }
        }
        return arrayList;
    }

    private ArrayList<TAVStickerTextItem> readAllTextData() {
        ArrayList<TAVStickerTextItem> arrayList = new ArrayList<>();
        ArrayList<PAGLayer> layersInComposition = layersInComposition(this.pagFile, 3);
        List<PAGText> pAGTextListFromFile = getPAGTextListFromFile();
        if (!CollectionUtil.isEmptyList(layersInComposition) && !CollectionUtil.isEmptyList(pAGTextListFromFile)) {
            int size = layersInComposition.size();
            int size2 = pAGTextListFromFile.size();
            for (int i3 = 0; i3 < size; i3++) {
                PAGLayer pAGLayer = layersInComposition.get(i3);
                if (pAGLayer != null) {
                    TAVStickerTextItem tAVStickerTextItem = new TAVStickerTextItem(pAGLayer);
                    if (i3 < size2) {
                        PAGText pAGText = pAGTextListFromFile.get(i3);
                        if (pAGText != null) {
                            if (-1 == tAVStickerTextItem.getLayerIndex()) {
                                tAVStickerTextItem.setLayerIndex(i3);
                            }
                            if (!TextUtils.isEmpty(pAGText.text)) {
                                tAVStickerTextItem.setText(pAGText.text);
                            }
                            if (!TextUtils.isEmpty(pAGText.text)) {
                                tAVStickerTextItem.setDefaultText(pAGText.text);
                            }
                            tAVStickerTextItem.setDefaultColor(pAGText.fillColor);
                            if (tAVStickerTextItem.getTextColor() == 0) {
                                tAVStickerTextItem.setTextColor(pAGText.fillColor);
                            }
                            if (!TextUtils.isEmpty(pAGText.fontFamily)) {
                                tAVStickerTextItem.setFontFamily(pAGText.fontFamily);
                            }
                            if (!TextUtils.isEmpty(pAGText.fontStyle)) {
                                tAVStickerTextItem.setFontStyle(pAGText.fontStyle);
                            }
                        }
                    }
                    arrayList.add(tAVStickerTextItem);
                }
            }
        }
        return arrayList;
    }

    private void removeDuplicatePagLayer(ArrayList<PAGLayer> arrayList) {
        if (CollectionUtil.isEmptyList(arrayList)) {
            return;
        }
        TreeSet treeSet = new TreeSet(new Comparator<PAGLayer>() { // from class: com.tencent.tavsticker.model.TAVSticker.1
            @Override // java.util.Comparator
            public int compare(PAGLayer pAGLayer, PAGLayer pAGLayer2) {
                if (pAGLayer == null || pAGLayer2 == null) {
                    return 0;
                }
                return pAGLayer.editableIndex() - pAGLayer2.editableIndex();
            }
        });
        treeSet.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(treeSet);
    }

    private void setPAGLayerTimeRange() {
        CMTimeRange cMTimeRange;
        if (this.pagFile != null && (cMTimeRange = this.timeRange) != null && cMTimeRange.isLegal()) {
            this.pagFile.setStartTime(this.timeRange.getStartUs());
            this.pagFile.setDuration(this.timeRange.getDurationUs());
        }
    }

    public double computeProgress(long j3) {
        double min;
        CMTimeRange cMTimeRange;
        ITAVStickerProgressHandler iTAVStickerProgressHandler = this.progressHandler;
        if (iTAVStickerProgressHandler != null) {
            return iTAVStickerProgressHandler.computeProgress(this, j3);
        }
        long durationTime = durationTime() / 1000;
        CMTimeRange cMTimeRange2 = this.timeRange;
        if (cMTimeRange2 != null) {
            if (!TimeRangeUtil.isInTimeRange(cMTimeRange2, j3)) {
                return 0.0d;
            }
            j3 = Math.max(0L, j3 - (this.timeRange.getStartUs() / 1000));
        }
        if (durationTime <= 0 || j3 <= 0) {
            return 0.0d;
        }
        long j16 = j3 % durationTime;
        if (j16 == 0) {
            min = 1.0d;
        } else {
            min = Math.min(1.0d, (j16 * 1.0d) / durationTime);
        }
        int i3 = AnonymousClass4.$SwitchMap$com$tencent$tavsticker$model$TAVSticker$TAVStickerAnimationMode[this.animationMode.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (cMTimeRange = this.timeRange) != null) {
                double durationUs = (cMTimeRange.getDurationUs() * 1.0d) / 1000.0d;
                if (durationUs > durationTime) {
                    return Math.min(1.0d, (j3 * 1.0d) / durationUs);
                }
                return min;
            }
            return min;
        }
        return Math.min(1.0d, (j3 * 1.0d) / durationTime);
    }

    public long durationTime() {
        PAGFile pAGFile = this.pagFile;
        if (pAGFile != null) {
            return pAGFile.duration();
        }
        return 0L;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TAVSticker) {
            return TextUtils.equals(this.uniqueId, ((TAVSticker) obj).uniqueId);
        }
        return super.equals(obj);
    }

    public TAVStickerAnimationMode getAnimationMode() {
        return this.animationMode;
    }

    public String getAssetFilePath() {
        return this.assetFilePath;
    }

    public ByteBuffer getAudioData() {
        PAGFile pAGFile = this.pagFile;
        if (pAGFile == null) {
            return null;
        }
        ByteBuffer audioBytes = pAGFile.audioBytes();
        if (audioBytes != null) {
            audioBytes.rewind();
        }
        return audioBytes;
    }

    public float getAudioStartTime() {
        PAGFile pAGFile = this.pagFile;
        if (pAGFile != null) {
            return TAVStickerUtil.microsecond2Seconds(pAGFile.audioStartTime());
        }
        return 0.0f;
    }

    public List<TAVStickerLayerInfo.TAVStickerUserData> getAudioUserDatas() {
        ArrayList arrayList = new ArrayList();
        PAGFile pAGFile = this.pagFile;
        if (pAGFile == null) {
            return arrayList;
        }
        PAGMarker[] audioMarkers = pAGFile.audioMarkers();
        if (audioMarkers != null && audioMarkers.length > 0) {
            for (PAGMarker pAGMarker : audioMarkers) {
                if (pAGMarker != null) {
                    arrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(pAGMarker.mStartTime)), new CMTime(TAVStickerUtil.microsecond2Seconds(pAGMarker.mDuration))), pAGMarker.mComment));
                }
            }
        }
        return arrayList;
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    @NonNull
    public Bundle getExtraBundle() {
        return this.extraBundle;
    }

    public String getExtras() {
        return this.extras;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getHeight() {
        PAGFile pAGFile = this.pagFile;
        if (pAGFile != null) {
            return pAGFile.height();
        }
        return 0;
    }

    public int getLayerIndex() {
        return this.layerIndex;
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public float getMinScale() {
        return this.minScale;
    }

    public TAVStickerMode getMode() {
        return this.mode;
    }

    public RectF getMoveRect() {
        return this.moveRect;
    }

    public PAGFile getPagFile() {
        return this.pagFile;
    }

    public PAGImageLayer getPagImageLayerByName(String str, boolean z16) {
        PAGFile pAGFile = this.pagFile;
        if (pAGFile == null) {
            return null;
        }
        int numImages = pAGFile.numImages();
        for (int i3 = 0; i3 < numImages; i3++) {
            PAGLayer[] layersByEditableIndex = this.pagFile.getLayersByEditableIndex(i3, 5);
            if (layersByEditableIndex != null) {
                for (PAGLayer pAGLayer : layersByEditableIndex) {
                    if (pAGLayer instanceof PAGImageLayer) {
                        PAGImageLayer pAGImageLayer = (PAGImageLayer) pAGLayer;
                        String layerValue = getLayerValue(pAGImageLayer.layerName());
                        if (!z16 || TextUtils.equals(str, layerValue)) {
                            return pAGImageLayer;
                        }
                    }
                }
            }
        }
        return null;
    }

    public long getPagSourceDuration(String str, boolean z16) {
        PAGImageLayer pagImageLayerByName = getPagImageLayerByName(str, z16);
        if (pagImageLayerByName != null) {
            return pagImageLayerByName.contentDuration();
        }
        return 0L;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getScale() {
        return this.scale;
    }

    public int getScaleMode() {
        return this.scaleMode;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public ArrayList<TAVStickerImageItem> getStickerImageItems() {
        if (this.imageList == null) {
            ArrayList<TAVStickerImageItem> arrayList = new ArrayList<>();
            this.imageList = arrayList;
            arrayList.addAll(readAllImageData());
        }
        return this.imageList;
    }

    public List<TAVStickerLayerInfo> getStickerLayerInfos() {
        TAVStickerLayerInfo layerInfo;
        TAVStickerLayerInfo layerInfo2;
        TAVStickerLayerInfo layerInfo3;
        ArrayList arrayList = new ArrayList();
        ArrayList<TAVStickerImageItem> stickerImageItems = getStickerImageItems();
        if (!CollectionUtil.isEmptyList(stickerImageItems)) {
            for (TAVStickerImageItem tAVStickerImageItem : stickerImageItems) {
                if (tAVStickerImageItem != null && (layerInfo3 = tAVStickerImageItem.getLayerInfo()) != null) {
                    arrayList.add(layerInfo3);
                }
            }
        }
        ArrayList<TAVStickerTextItem> stickerTextItems = getStickerTextItems();
        if (!CollectionUtil.isEmptyList(stickerTextItems)) {
            for (TAVStickerTextItem tAVStickerTextItem : stickerTextItems) {
                if (tAVStickerTextItem != null && (layerInfo2 = tAVStickerTextItem.getLayerInfo()) != null) {
                    arrayList.add(layerInfo2);
                }
            }
        }
        ArrayList<TAVStickerSolidItem> stickerSolidItems = getStickerSolidItems();
        if (!CollectionUtil.isEmptyList(stickerSolidItems)) {
            for (TAVStickerSolidItem tAVStickerSolidItem : stickerSolidItems) {
                if (tAVStickerSolidItem != null && (layerInfo = tAVStickerSolidItem.getLayerInfo()) != null) {
                    arrayList.add(layerInfo);
                }
            }
        }
        if (!CollectionUtil.isEmptyList(arrayList)) {
            Collections.sort(arrayList, new Comparator<TAVStickerLayerInfo>() { // from class: com.tencent.tavsticker.model.TAVSticker.3
                @Override // java.util.Comparator
                public int compare(TAVStickerLayerInfo tAVStickerLayerInfo, TAVStickerLayerInfo tAVStickerLayerInfo2) {
                    if (tAVStickerLayerInfo == null || tAVStickerLayerInfo.getTimeRange() == null || tAVStickerLayerInfo2 == null || tAVStickerLayerInfo2.getTimeRange() == null) {
                        return 0;
                    }
                    return (int) (tAVStickerLayerInfo.getTimeRange().getStartUs() - tAVStickerLayerInfo2.getTimeRange().getStartUs());
                }
            });
        }
        return arrayList;
    }

    @Deprecated
    public List<TAVStickerLayerInfo> getStickerLayerInfosFake() {
        return TAVStickerFakeParser.fakeDataFromJson();
    }

    public TAVStickerMoveLimit getStickerMoveLimit() {
        return this.tavStickerMoveLimit;
    }

    public ArrayList<TAVStickerShapeItem> getStickerShapeItem() {
        if (this.shapeList == null) {
            ArrayList<TAVStickerShapeItem> arrayList = new ArrayList<>();
            this.shapeList = arrayList;
            arrayList.addAll(readAllShapeData());
        }
        return this.shapeList;
    }

    public ArrayList<TAVStickerSolidItem> getStickerSolidItems() {
        if (this.solidList == null) {
            ArrayList<TAVStickerSolidItem> arrayList = new ArrayList<>();
            this.solidList = arrayList;
            arrayList.addAll(readAllSolidData());
        }
        return this.solidList;
    }

    public ArrayList<TAVStickerTextItem> getStickerTextItems() {
        if (this.textList == null) {
            ArrayList<TAVStickerTextItem> arrayList = new ArrayList<>();
            this.textList = arrayList;
            arrayList.addAll(readAllTextData());
        }
        return this.textList;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public TAVStickerImageItem getTavStickerImageItem(int i3) {
        ArrayList<TAVStickerImageItem> stickerImageItems = getStickerImageItems();
        if (CollectionUtil.isEmptyList(stickerImageItems)) {
            return null;
        }
        Iterator<TAVStickerImageItem> it = stickerImageItems.iterator();
        while (it.hasNext()) {
            TAVStickerImageItem next = it.next();
            if (next != null && i3 == next.getLayerIndex()) {
                return next;
            }
        }
        return null;
    }

    public TAVStickerSolidItem getTavStickerSolidItem(int i3) {
        ArrayList<TAVStickerSolidItem> stickerSolidItems = getStickerSolidItems();
        if (!CollectionUtil.isEmptyList(stickerSolidItems)) {
            Iterator<TAVStickerSolidItem> it = stickerSolidItems.iterator();
            while (it.hasNext()) {
                TAVStickerSolidItem next = it.next();
                if (next != null && i3 == next.getLayerIndex()) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    public TAVStickerTextItem getTavStickerTextItem(int i3) {
        ArrayList<TAVStickerTextItem> stickerTextItems = getStickerTextItems();
        if (CollectionUtil.isEmptyList(stickerTextItems)) {
            return null;
        }
        Iterator<TAVStickerTextItem> it = stickerTextItems.iterator();
        while (it.hasNext()) {
            TAVStickerTextItem next = it.next();
            if (next != null && i3 == next.getLayerIndex()) {
                return next;
            }
        }
        return null;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public int getWidth() {
        PAGFile pAGFile = this.pagFile;
        if (pAGFile != null) {
            return pAGFile.width();
        }
        return 0;
    }

    public boolean hasVideoTrack(PAGImageLayer pAGImageLayer) {
        PAGMarker[] markers;
        if (pAGImageLayer != null && (markers = pAGImageLayer.markers()) != null && markers.length > 0) {
            for (PAGMarker pAGMarker : markers) {
                String str = pAGMarker.mComment;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (1 == new JSONObject(str).optInt("videoTrack", 0)) {
                            return true;
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (!TextUtils.isEmpty(this.uniqueId)) {
            return this.uniqueId.hashCode();
        }
        return super.hashCode();
    }

    public TAVSticker init() throws StickerInitializationException {
        if (!this.isInit) {
            if (!TextUtils.isEmpty(this.filePath)) {
                this.pagFile = TAVPAGFileManager.getInstance().getPAGFileFromPath(this.filePath);
            } else if (!TextUtils.isEmpty(this.assetFilePath)) {
                this.pagFile = TAVPAGFileManager.getInstance().getPAGFileFromAsset(TAVStickerHelper.getContext(), this.assetFilePath);
            }
            if (this.pagFile != null) {
                this.uniqueId = UUID.randomUUID().toString();
                if (TextUtils.isEmpty(this.stickerId)) {
                    this.stickerId = this.uniqueId;
                }
                this.rendererList = new CopyOnWriteArrayList<>();
                if (this.timeRange == null) {
                    setTimeRange(new CMTimeRange(new CMTime(0L), new CMTime(TAVStickerUtil.microsecond2Seconds(this.pagFile.duration()))));
                }
                setPAGLayerTimeRange();
                updateTextData();
                updateImageData();
                this.isInit = true;
            } else {
                throw new StickerInitializationException("<init> can not initialization TAVSticker, please check the pag file path is correct! Please make sure to use the legal pag file!");
            }
        }
        return this;
    }

    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public boolean isShowDefaultBorder() {
        return this.isShowDefaultBorder;
    }

    public ArrayList<TAVStickerSolidItem> readAllSolidData() {
        ArrayList<TAVStickerSolidItem> arrayList = new ArrayList<>();
        ArrayList<PAGLayer> layersInComposition = layersInComposition(this.pagFile, 2);
        if (!CollectionUtil.isEmptyList(layersInComposition)) {
            int size = layersInComposition.size();
            for (int i3 = 0; i3 < size; i3++) {
                PAGLayer pAGLayer = layersInComposition.get(i3);
                if (pAGLayer instanceof PAGSolidLayer) {
                    arrayList.add(new TAVStickerSolidItem((PAGSolidLayer) pAGLayer));
                }
            }
        }
        return arrayList;
    }

    public void registerRenderer(ITAVStickerRenderer iTAVStickerRenderer) {
        CopyOnWriteArrayList<ITAVStickerRenderer> copyOnWriteArrayList;
        if (iTAVStickerRenderer != null && (copyOnWriteArrayList = this.rendererList) != null && !copyOnWriteArrayList.contains(iTAVStickerRenderer)) {
            this.rendererList.add(iTAVStickerRenderer);
        }
        updateTextData();
        updateImageData();
        updateLayerColor();
    }

    public void setAnimationMode(TAVStickerAnimationMode tAVStickerAnimationMode) {
        this.animationMode = tAVStickerAnimationMode;
    }

    public TAVSticker setAssetFilePath(String str) {
        this.assetFilePath = str;
        return this;
    }

    public TAVSticker setAutoPlay(boolean z16) {
        this.isAutoPlay = z16;
        return this;
    }

    public TAVSticker setCenterX(float f16) {
        this.centerX = f16;
        return this;
    }

    public TAVSticker setCenterY(float f16) {
        this.centerY = f16;
        return this;
    }

    public TAVSticker setEditable(boolean z16) {
        this.editable = z16;
        return this;
    }

    public TAVSticker setExtras(String str) {
        this.extras = str;
        return this;
    }

    public TAVSticker setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public TAVSticker setLayerIndex(int i3) {
        this.layerIndex = i3;
        return this;
    }

    public TAVSticker setMaxScale(float f16) {
        this.maxScale = f16;
        return this;
    }

    public TAVSticker setMinScale(float f16) {
        this.minScale = f16;
        return this;
    }

    public TAVSticker setMode(TAVStickerMode tAVStickerMode) {
        if (tAVStickerMode != null) {
            this.mode = tAVStickerMode;
        }
        return this;
    }

    public TAVSticker setMoveRect(RectF rectF) {
        this.moveRect = rectF;
        return this;
    }

    public TAVSticker setProgressHandler(ITAVStickerProgressHandler iTAVStickerProgressHandler) {
        this.progressHandler = iTAVStickerProgressHandler;
        return this;
    }

    public TAVSticker setRotate(float f16) {
        this.rotate = f16;
        return this;
    }

    public TAVSticker setScale(float f16) {
        this.scale = f16;
        return this;
    }

    public TAVSticker setScaleMode(int i3) {
        this.scaleMode = i3;
        return this;
    }

    public TAVSticker setStickerId(String str) {
        this.stickerId = str;
        return this;
    }

    public TAVSticker setStrokeColor(int i3) {
        this.strokeColor = i3;
        return this;
    }

    public TAVSticker setStrokeWidth(int i3) {
        this.strokeWidth = i3;
        return this;
    }

    public TAVSticker setTavStickerMoveLimit(TAVStickerMoveLimit tAVStickerMoveLimit) {
        this.tavStickerMoveLimit = tAVStickerMoveLimit;
        return this;
    }

    public TAVSticker setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
        setPAGLayerTimeRange();
        return this;
    }

    public TAVSticker showDefaultBorder(boolean z16) {
        this.isShowDefaultBorder = z16;
        return this;
    }

    public String toString() {
        return "TAVSticker {filePath : " + this.filePath + ", uniqueId : " + this.uniqueId + "}";
    }

    public void unregisterRenderer(ITAVStickerRenderer iTAVStickerRenderer) {
        CopyOnWriteArrayList<ITAVStickerRenderer> copyOnWriteArrayList = this.rendererList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(iTAVStickerRenderer);
        }
    }

    public void updateImageData() {
        ArrayList<TAVStickerImageItem> stickerImageItems = getStickerImageItems();
        PAGFile pAGFile = this.pagFile;
        if (pAGFile != null && pAGFile.numImages() > 0 && !CollectionUtil.isEmptyList(stickerImageItems)) {
            for (int i3 = 0; i3 < stickerImageItems.size(); i3++) {
                TAVStickerImageItem tAVStickerImageItem = stickerImageItems.get(i3);
                if (tAVStickerImageItem != null && tAVStickerImageItem.getBitmap() != null) {
                    this.pagFile.replaceImage(tAVStickerImageItem.layerIndex, PAGImage.FromBitmap(tAVStickerImageItem.getBitmap()));
                    if (!CollectionUtil.isEmptyList(this.rendererList)) {
                        Iterator<ITAVStickerRenderer> it = this.rendererList.iterator();
                        while (it.hasNext()) {
                            it.next().setImageData(tAVStickerImageItem.layerIndex, PAGImage.FromBitmap(tAVStickerImageItem.getBitmap()));
                        }
                    }
                }
            }
        }
    }

    public void updateLayerColor() {
        getStickerSolidItems();
        if (CollectionUtil.isEmptyList(this.solidList)) {
            return;
        }
        for (int i3 = 0; i3 < this.solidList.size(); i3++) {
            TAVStickerSolidItem tAVStickerSolidItem = this.solidList.get(i3);
            if (tAVStickerSolidItem != null) {
                for (PAGLayer pAGLayer : this.pagFile.getLayersByName(tAVStickerSolidItem.layerName)) {
                    if (pAGLayer instanceof PAGSolidLayer) {
                        ((PAGSolidLayer) pAGLayer).setSolidColor(tAVStickerSolidItem.getColor());
                    }
                }
                if (!CollectionUtil.isEmptyList(this.rendererList)) {
                    Iterator<ITAVStickerRenderer> it = this.rendererList.iterator();
                    while (it.hasNext()) {
                        ITAVStickerRenderer next = it.next();
                        if (next != null) {
                            next.setLayerColor(tAVStickerSolidItem.getLayerName(), tAVStickerSolidItem.getColor());
                        }
                    }
                }
            }
        }
    }

    public void updateTextData() {
        List<PAGText> pAGTextListFromFile = getPAGTextListFromFile();
        if (CollectionUtil.isEmptyList(pAGTextListFromFile)) {
            return;
        }
        int size = pAGTextListFromFile.size();
        for (int i3 = 0; i3 < size && i3 < getStickerTextItems().size(); i3++) {
            PAGText pAGText = pAGTextListFromFile.get(i3);
            TAVStickerTextItem tAVStickerTextItem = getStickerTextItems().get(i3);
            if (pAGText != null && tAVStickerTextItem != null) {
                if (!TextUtils.isEmpty(tAVStickerTextItem.getText())) {
                    pAGText.text = tAVStickerTextItem.getText();
                } else {
                    pAGText.text = "";
                }
                if (tAVStickerTextItem.getTextColor() != 0) {
                    pAGText.fillColor = tAVStickerTextItem.getTextColor();
                }
                if (!TextUtils.isEmpty(tAVStickerTextItem.getFontFamily())) {
                    pAGText.fontFamily = tAVStickerTextItem.getFontFamily();
                }
                if (!TextUtils.isEmpty(tAVStickerTextItem.getFontStyle())) {
                    pAGText.fontStyle = tAVStickerTextItem.getFontStyle();
                }
                if (!CollectionUtil.isEmptyList(this.rendererList)) {
                    Iterator<ITAVStickerRenderer> it = this.rendererList.iterator();
                    while (it.hasNext()) {
                        ITAVStickerRenderer next = it.next();
                        if (next != null) {
                            next.setTextData(i3, pAGText);
                        }
                    }
                }
            }
        }
    }

    public void updateTransform(CGSize cGSize) {
        if (TAVStickerUtil.isValidCGSize(cGSize) && this.pagFile != null) {
            this.pagFile.setMatrix(TAVStickerUtil.getMatrix(this, (int) cGSize.width, (int) cGSize.height));
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVSticker m283clone() {
        TAVSticker tAVSticker = new TAVSticker();
        tAVSticker.filePath = this.filePath;
        tAVSticker.assetFilePath = this.assetFilePath;
        tAVSticker.uniqueId = UUID.randomUUID().toString();
        tAVSticker.stickerId = this.stickerId;
        tAVSticker.layerIndex = this.layerIndex;
        tAVSticker.pagFile = this.pagFile.copyOriginal();
        tAVSticker.textList = this.textList;
        tAVSticker.rendererList = this.rendererList;
        tAVSticker.imageList = this.imageList;
        tAVSticker.timeRange = this.timeRange;
        tAVSticker.progressHandler = this.progressHandler;
        tAVSticker.strokeColor = this.strokeColor;
        tAVSticker.strokeWidth = this.strokeWidth;
        tAVSticker.isShowDefaultBorder = this.isShowDefaultBorder;
        tAVSticker.scale = this.scale;
        tAVSticker.scaleMode = this.scaleMode;
        tAVSticker.minScale = this.minScale;
        tAVSticker.maxScale = this.maxScale;
        tAVSticker.rotate = this.rotate;
        tAVSticker.centerX = this.centerX;
        tAVSticker.centerY = this.centerY;
        tAVSticker.tavStickerMoveLimit = this.tavStickerMoveLimit;
        tAVSticker.moveRect = this.moveRect;
        tAVSticker.editable = this.editable;
        tAVSticker.mode = this.mode;
        tAVSticker.isAutoPlay = this.isAutoPlay;
        tAVSticker.extras = this.extras;
        tAVSticker.extraBundle = this.extraBundle;
        return tAVSticker;
    }

    public TAVStickerImageItem getTavStickerImageItem(String str) {
        ArrayList<TAVStickerImageItem> stickerImageItems = getStickerImageItems();
        if (CollectionUtil.isEmptyList(stickerImageItems)) {
            return null;
        }
        Iterator<TAVStickerImageItem> it = stickerImageItems.iterator();
        while (it.hasNext()) {
            TAVStickerImageItem next = it.next();
            if (next != null && !TextUtils.isEmpty(str) && str.equals(next.getLayerName())) {
                return next;
            }
        }
        return null;
    }

    public TAVStickerTextItem getTavStickerTextItem(String str) {
        ArrayList<TAVStickerTextItem> stickerTextItems = getStickerTextItems();
        if (CollectionUtil.isEmptyList(stickerTextItems)) {
            return null;
        }
        Iterator<TAVStickerTextItem> it = stickerTextItems.iterator();
        while (it.hasNext()) {
            TAVStickerTextItem next = it.next();
            if (next != null && !TextUtils.isEmpty(str) && str.equals(next.getLayerName())) {
                return next;
            }
        }
        return null;
    }
}
