package com.tencent.qqlive.tvkplayer.qqliveasset.subtitle;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.subtitle.TVKSubtitleRenderParams;
import com.tencent.thumbplayer.api.common.TPSubtitleRenderParams;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSubtitleUtils {
    private static long convertToTpParamFlag(long j3) {
        long j16 = 1;
        if ((j3 & 1) <= 0) {
            j16 = 0;
        }
        if ((j3 & 2) > 0) {
            j16 |= 2;
        }
        if ((j3 & 4) > 0) {
            j16 |= 4;
        }
        if ((j3 & 8) > 0) {
            j16 |= 8;
        }
        if ((j3 & 16) > 0) {
            j16 |= 16;
        }
        if ((j3 & 32) > 0) {
            j16 |= 32;
        }
        if ((j3 & 64) > 0) {
            j16 |= 64;
        }
        if ((j3 & 128) > 0) {
            j16 |= 128;
        }
        if ((j3 & 256) > 0) {
            j16 |= 256;
        }
        if ((j3 & 512) > 0) {
            j16 |= 512;
        }
        if ((j3 & 1024) > 0) {
            j16 |= 1024;
        }
        if ((j3 & 2048) > 0) {
            return j16 | 2048;
        }
        return j16;
    }

    public static TPSubtitleRenderParams generateTPSubtitleRenderParams(@NonNull TVKSubtitleRenderParams tVKSubtitleRenderParams) {
        TPSubtitleRenderParams tPSubtitleRenderParams = new TPSubtitleRenderParams();
        tPSubtitleRenderParams.setFontSize(tVKSubtitleRenderParams.getFontSize());
        tPSubtitleRenderParams.setFontScale(tVKSubtitleRenderParams.getFontScale());
        tPSubtitleRenderParams.setFontColor(tVKSubtitleRenderParams.getFontColor());
        tPSubtitleRenderParams.setCanvasWidth(tVKSubtitleRenderParams.getCanvasWidth());
        tPSubtitleRenderParams.setCanvasHeight(tVKSubtitleRenderParams.getCanvasHeight());
        tPSubtitleRenderParams.setOutlineColor(tVKSubtitleRenderParams.getOutlineColor());
        tPSubtitleRenderParams.setOutlineWidth(tVKSubtitleRenderParams.getOutlineWidth());
        tPSubtitleRenderParams.setLineSpace(tVKSubtitleRenderParams.getLineSpace());
        tPSubtitleRenderParams.setStartMargin(tVKSubtitleRenderParams.getStartMargin());
        tPSubtitleRenderParams.setEndMargin(tVKSubtitleRenderParams.getEndMargin());
        tPSubtitleRenderParams.setVerticalMargin(tVKSubtitleRenderParams.getVerticalMargin());
        tPSubtitleRenderParams.setParamFlags(convertToTpParamFlag(tVKSubtitleRenderParams.getParamFlags()));
        tPSubtitleRenderParams.setParamPriorityFlags(convertToTpParamFlag(tVKSubtitleRenderParams.getParamPriorityFlags()));
        TVKSubtitleRenderParams.TVKSubtitleBackgroundParams backgroundParams = tVKSubtitleRenderParams.getBackgroundParams();
        if (backgroundParams != null) {
            TPSubtitleRenderParams.TPSubtitleBackgroundParams tPSubtitleBackgroundParams = new TPSubtitleRenderParams.TPSubtitleBackgroundParams();
            tPSubtitleBackgroundParams.setBackgroundColor(backgroundParams.getBackgroundColor());
            tPSubtitleBackgroundParams.setBackgroundBorderColor(backgroundParams.getBackgroundBorderColor());
            tPSubtitleBackgroundParams.setBackgroundBorderWidth(backgroundParams.getBackgroundBorderWidth());
            tPSubtitleBackgroundParams.setCornerRadiusToHeightRatio(backgroundParams.getCornerRadiusToHeightRatio());
            tPSubtitleBackgroundParams.setBackgroundHorizontalMargin(backgroundParams.getBackgroundHorizontalMargin());
            tPSubtitleBackgroundParams.setBackgroundVerticalMargin(backgroundParams.getBackgroundVerticalMargin());
            tPSubtitleRenderParams.setBackgroundParams(tPSubtitleBackgroundParams);
        }
        return tPSubtitleRenderParams;
    }
}
