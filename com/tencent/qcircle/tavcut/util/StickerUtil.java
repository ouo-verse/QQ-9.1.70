package com.tencent.qcircle.tavcut.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.bean.SolidData;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.bean.TextItem;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMoveLimit;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TimeRangeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StickerUtil {
    private static final String TAG = "StickerUtil";
    private static final int TIME_SCALE = 1000;

    private static TAVStickerSolidItem findSolidItemByName(TAVSticker tAVSticker, String str) {
        ArrayList<TAVStickerSolidItem> stickerSolidItems;
        if (tAVSticker == null || (stickerSolidItems = tAVSticker.getStickerSolidItems()) == null) {
            return null;
        }
        for (TAVStickerSolidItem tAVStickerSolidItem : stickerSolidItems) {
            if (str != null && str.equals(tAVStickerSolidItem.getLayerName())) {
                return tAVStickerSolidItem;
            }
        }
        return null;
    }

    @Nullable
    public static TAVSticker genTavSticker(@NonNull StickerModel stickerModel) {
        CMTimeRange cMTimeRange;
        try {
            TAVSticker scale = new TAVSticker().setFilePath(stickerModel.getFilePath()).setAssetFilePath(stickerModel.getAssetFilePath()).setCenterX(stickerModel.getCenterX()).setCenterY(stickerModel.getCenterY()).setScale(stickerModel.getScale());
            if (stickerModel.getDuration() > 0.0f) {
                cMTimeRange = new CMTimeRange(new CMTime(stickerModel.getStartTime()), new CMTime(stickerModel.getDuration()));
            } else {
                cMTimeRange = null;
            }
            return scale.setTimeRange(cMTimeRange).setTavStickerMoveLimit(TAVStickerMoveLimit.LIMIT_VERTEX).setMaxScale(stickerModel.getMaxScale()).setMinScale(stickerModel.getMinScale()).init();
        } catch (StickerInitializationException e16) {
            Logger.e(e16);
            return null;
        }
    }

    public static TextEditorData stickerModel2EditorData(TAVSticker tAVSticker) {
        TAVStickerTextItem tAVStickerTextItem;
        int i3 = 0;
        if (!CollectionUtil.isEmptyCollection(tAVSticker.getStickerTextItems())) {
            tAVStickerTextItem = tAVSticker.getStickerTextItems().get(0);
        } else {
            tAVStickerTextItem = null;
        }
        if (tAVStickerTextItem == null) {
            tAVStickerTextItem = new TAVStickerTextItem();
        }
        TAVStickerSolidItem findSolidItemByName = findSolidItemByName(tAVSticker, TextEditorData.BACKGROUND);
        String stickerId = tAVSticker.getStickerId();
        String extras = tAVSticker.getExtras();
        int textColor = tAVStickerTextItem.getTextColor();
        String text = tAVStickerTextItem.getText();
        String filePath = tAVSticker.getFilePath();
        String fontPath = tAVStickerTextItem.getFontPath();
        if (findSolidItemByName != null) {
            i3 = findSolidItemByName.getColor();
        }
        TextEditorData textEditorData = new TextEditorData(stickerId, extras, textColor, text, filePath, fontPath, i3);
        textEditorData.setInteractive(String.valueOf(TAVStickerExKt.getStickerInteractive(tAVSticker)));
        if (tAVSticker instanceof WSLyricSticker) {
            textEditorData.setStickerType(WsStickerConstant.StickerType.STICKER_LYRIC);
        }
        return textEditorData;
    }

    public static TAVSticker stickerModel2TavSticker(StickerModel stickerModel) {
        CMTimeRange cMTimeRange = new CMTimeRange(new CMTime(stickerModel.getStartTime(), 1000), new CMTime(((float) stickerModel.getEndTime()) - stickerModel.getStartTime(), 1000));
        if (!TimeRangeUtil.isValidTimeRange(cMTimeRange)) {
            cMTimeRange = new CMTimeRange(new CMTime(0L, 1000), new CMTime(600000L, 1000));
        }
        TAVSticker timeRange = new TAVSticker().setExtras(stickerModel.getMaterialId()).setFilePath(stickerModel.getFilePath()).setAssetFilePath(stickerModel.getAssetFilePath()).setLayerIndex(stickerModel.getLayerIndex()).setScale(stickerModel.getScale()).setRotate(stickerModel.getRotate()).setCenterX(stickerModel.getCenterX()).setCenterY(stickerModel.getCenterY()).setEditable(stickerModel.isEditable()).setMinScale(stickerModel.getMinScale()).setMaxScale(stickerModel.getMaxScale()).setTimeRange(cMTimeRange);
        TAVStickerExKt.setStickerScaleX(timeRange, stickerModel.getScaleX());
        TAVStickerExKt.setStickerScaleY(timeRange, stickerModel.getScaleY());
        TAVStickerExKt.setStickerEnableRotate(timeRange, stickerModel.isEnableRotate());
        TAVStickerExKt.setStickerLockRatio(timeRange, stickerModel.isLockRatio());
        TAVStickerExKt.setStickerScaleMaxX(timeRange, stickerModel.getScaleXMax());
        TAVStickerExKt.setStickerScaleMaxY(timeRange, stickerModel.getScaleYMax());
        TAVStickerExKt.setStickerScaleMinX(timeRange, stickerModel.getScaleXMin());
        TAVStickerExKt.setStickerScaleMinY(timeRange, stickerModel.getScaleYMin());
        TAVStickerExKt.setExtraStickerType(timeRange, stickerModel.getType());
        TAVStickerExKt.setStickerTextPngPath(timeRange, stickerModel.getTextPngPath());
        TAVStickerExKt.setStickerTexturePngPath(timeRange, stickerModel.getTexturePngPath());
        TAVStickerExKt.setStickerInteractive(timeRange, stickerModel.getInteractive());
        if (!TextUtils.isEmpty(stickerModel.getUniqueId())) {
            timeRange.setStickerId(stickerModel.getUniqueId());
        }
        try {
            timeRange.init();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        for (int i3 = 0; i3 < stickerModel.getTextItems().size(); i3++) {
            if (i3 < timeRange.getStickerTextItems().size()) {
                timeRange.getStickerTextItems().get(i3).setText(stickerModel.getTextItems().get(i3).getText());
                timeRange.getStickerTextItems().get(i3).setTextColor(stickerModel.getTextItems().get(i3).getTextColor());
                String fontPath = stickerModel.getTextItems().get(i3).getFontPath();
                String assetFontPath = stickerModel.getTextItems().get(i3).getAssetFontPath();
                if (!TextUtils.isEmpty(fontPath)) {
                    timeRange.getStickerTextItems().get(i3).setFontPath(fontPath);
                }
                if (!TextUtils.isEmpty(assetFontPath)) {
                    timeRange.getStickerTextItems().get(i3).setAssetFontPath(assetFontPath);
                }
            } else {
                Logger.w(TAG, "sticker.stickerTextItems is not correct");
            }
        }
        for (int i16 = 0; i16 < stickerModel.getSolidItems().size(); i16++) {
            ArrayList<TAVStickerSolidItem> stickerSolidItems = timeRange.getStickerSolidItems();
            if (CollectionUtil.isEmptyList(stickerSolidItems)) {
                break;
            }
            Map<String, SolidData> solidItems = stickerModel.getSolidItems();
            if (CollectionUtil.isEmptyMap(solidItems)) {
                break;
            }
            for (TAVStickerSolidItem tAVStickerSolidItem : stickerSolidItems) {
                SolidData solidData = solidItems.get(tAVStickerSolidItem.getLayerName());
                if (solidData != null) {
                    tAVStickerSolidItem.setColor(solidData.getColor());
                }
            }
        }
        timeRange.updateTextData();
        timeRange.updateLayerColor();
        return timeRange;
    }

    public static StickerModel tavSticker2StickerModel(TAVSticker tAVSticker) {
        long j3;
        TAVStickerSolidItem next;
        StickerModel stickerModel = new StickerModel();
        stickerModel.setUniqueId(tAVSticker.getStickerId());
        stickerModel.setMaterialId(tAVSticker.getExtras());
        stickerModel.setFilePath(tAVSticker.getFilePath());
        stickerModel.setAssetFilePath(tAVSticker.getAssetFilePath());
        long j16 = 0;
        if (tAVSticker.getTimeRange() != null) {
            j3 = tAVSticker.getTimeRange().getStartUs();
        } else {
            j3 = 0;
        }
        stickerModel.setStartTime((((float) j3) * 1.0f) / 1000.0f);
        if (tAVSticker.getTimeRange() != null) {
            j16 = tAVSticker.getTimeRange().getEndUs();
        }
        stickerModel.setEndTime(j16 / 1000);
        stickerModel.setLayerIndex(tAVSticker.getLayerIndex());
        stickerModel.setScale(tAVSticker.getScale());
        stickerModel.setRotate(tAVSticker.getRotate());
        stickerModel.setCenterX(tAVSticker.getCenterX());
        stickerModel.setCenterY(tAVSticker.getCenterY());
        stickerModel.setEditable(tAVSticker.isEditable());
        stickerModel.setWidth(tAVSticker.getWidth());
        stickerModel.setHeight(tAVSticker.getHeight());
        stickerModel.setMinScale(tAVSticker.getMinScale());
        stickerModel.setMaxScale(tAVSticker.getMaxScale());
        stickerModel.setType(TAVStickerExKt.getExtraStickerType(tAVSticker));
        stickerModel.setTexturePngPath(TAVStickerExKt.getStickerTexturePngPath(tAVSticker));
        stickerModel.setTextPngPath(TAVStickerExKt.getStickerTextPngPath(tAVSticker));
        stickerModel.setScaleX(TAVStickerExKt.getStickerScaleX(tAVSticker));
        stickerModel.setScaleY(TAVStickerExKt.getStickerScaleY(tAVSticker));
        stickerModel.setScaleXMin(TAVStickerExKt.getStickerScaleMinX(tAVSticker));
        stickerModel.setScaleYMin(TAVStickerExKt.getSticerScaleMinY(tAVSticker));
        stickerModel.setScaleXMax(TAVStickerExKt.getStickerScaleMaxX(tAVSticker));
        stickerModel.setScaleYMax(TAVStickerExKt.getStickerScaleMaxY(tAVSticker));
        stickerModel.setLockRatio(TAVStickerExKt.isLockRatio(tAVSticker));
        stickerModel.setEnableRotate(TAVStickerExKt.isRotateEnable(tAVSticker));
        stickerModel.setInteractive(TAVStickerExKt.getStickerInteractive(tAVSticker));
        ArrayList arrayList = new ArrayList();
        Iterator<TAVStickerTextItem> it = tAVSticker.getStickerTextItems().iterator();
        while (it.hasNext()) {
            TAVStickerTextItem next2 = it.next();
            TextItem textItem = new TextItem();
            textItem.setFontPath(next2.getFontPath());
            textItem.setAssetFontPath(next2.getAssetFontPath());
            textItem.setText(next2.getText());
            textItem.setTextColor(next2.getTextColor());
            arrayList.add(textItem);
        }
        HashMap hashMap = new HashMap();
        Iterator<TAVStickerSolidItem> it5 = tAVSticker.getStickerSolidItems().iterator();
        while (it5.hasNext() && (next = it5.next()) != null) {
            SolidData solidData = new SolidData();
            solidData.setColor(next.getColor());
            hashMap.put(next.getLayerName(), solidData);
        }
        stickerModel.setTextItems(arrayList);
        stickerModel.setSolidItems(hashMap);
        return stickerModel;
    }
}
