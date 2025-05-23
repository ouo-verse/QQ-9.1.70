package com.tencent.mobileqq.wink.editor.sticker;

import com.google.gson.annotations.SerializedName;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import java.io.Serializable;

/* loaded from: classes21.dex */
public class WinkPagStickerConfig implements Serializable {
    public static final float CONFIG_DEFAULT_ANGLE = 0.0f;
    public static final float CONFIG_DEFAULT_MAX_SCALE = 1.0f;
    public static final float CONFIG_DEFAULT_MIN_SCALE = 0.18f;
    public static final float CONFIG_DEFAULT_SCALE = 0.5f;
    public static final String TYPE_BLUR = "blur";
    public static final String TYPE_COLOR_TEXT = "color_text";
    public static final String TYPE_FIXED_TEXT = "fixed_text";
    public static final String TYPE_PLAIN_TEXT = "plain_text";

    @SerializedName(AIInput.KEY_FRAME)
    public FrameConfig frameConfig = new FrameConfig();

    @SerializedName("reservePagName")
    public String reservePagName;

    @SerializedName("style")
    public StyleConfig styleConfig;

    @SerializedName("type")
    public String type;

    /* loaded from: classes21.dex */
    public static class FrameConfig implements Serializable {

        @SerializedName("angle")
        public float angle = 0.0f;

        @SerializedName("minscale")
        public float minScale = 0.18f;

        @SerializedName("maxscale")
        public float maxScale = 1.0f;

        @SerializedName("scale")
        public float scale = 0.5f;
    }

    /* loaded from: classes21.dex */
    public static class StyleConfig implements Serializable {

        @SerializedName("colorIndex")
        public Integer colorIndex;

        @SerializedName(SkinConstants.TintConstant.KEY_DEFAULT_COLOR)
        public String defaultColor;
    }
}
