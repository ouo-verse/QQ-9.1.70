package com.tencent.qcircle.weseevideo.editor.sticker.utils;

import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.model.constants.MusicConstants;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StickerConverter {
    public static TAVSticker subtitleModel2TavSticker(SubtitleModel subtitleModel) {
        if (subtitleModel == null || subtitleModel.getEffectId() == MusicConstants.NO_LYRIC_ID) {
            return null;
        }
        WSLyricSticker wSLyricSticker = new WSLyricSticker();
        wSLyricSticker.reloadFromSubtitleModel(subtitleModel);
        return wSLyricSticker;
    }
}
