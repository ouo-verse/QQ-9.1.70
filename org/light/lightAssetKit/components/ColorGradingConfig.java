package org.light.lightAssetKit.components;

import org.light.lightAssetKit.enums.ToneMapping;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ColorGradingConfig {
    public boolean colorGradingEnabled = true;
    public boolean enable = false;
    public WhiteBalanceConfig whiteBalance = new WhiteBalanceConfig();
    public ChannelMixerConfig channelMixer = new ChannelMixerConfig();
    public ShadowsMidtonesHighlightsConfig shadowMidHighlights = new ShadowsMidtonesHighlightsConfig();
    public SlopeOffsetPowerConfing cdl = new SlopeOffsetPowerConfing();
    public float contrast = 1.0f;
    public float vibrance = 1.0f;
    public float saturation = 1.0f;
    public CurvesConfig curves = new CurvesConfig();
    public ToneMapping toneMapping = ToneMapping.ACES_LEGACY;
}
