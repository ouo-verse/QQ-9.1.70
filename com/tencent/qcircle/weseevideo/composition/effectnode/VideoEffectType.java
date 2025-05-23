package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;

/* compiled from: P */
/* loaded from: classes22.dex */
public enum VideoEffectType {
    TYPE_DEFAULT(0, "default"),
    TYPE_ASPECT(1, "aspect"),
    TYPE_BEAUTY(2, "beauty"),
    TYPE_LUT(3, TAVBaseAutomaticEffect.EFFECT_TYPE_LUT),
    TYPE_PI_TU(4, "pi_tu"),
    TYPE_STICKER(5, "sticker"),
    TYPE_SUBTITLE(6, "subtitle"),
    TYPE_VIDEO_BEGIN(7, "video_begin"),
    TYPE_VIDEO_END(8, "video_end"),
    TYPE_WATER_MARK(9, "water_mark"),
    TYPE_FEN_WEI(10, "fen_wei"),
    TYPE_SPECIAL_EFFECT(11, "special_effect"),
    TYPE_FREE_VIDEO_END(12, "free_video_end"),
    TYPE_STICKER_RED_PACKET(13, WsStickerConstant.StickerType.STICKER_RED_PACKET),
    TYPE_CROP(14, QQWinkConstants.TAB_CROP),
    TYPE_TRANSITION_EFFECT(15, "transition_effect");

    public String name;
    public int value;

    VideoEffectType(int i3, String str) {
        this.value = i3;
        this.name = str;
    }
}
