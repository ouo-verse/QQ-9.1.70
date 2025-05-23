package com.tencent.qqlive.tvkplayer.api.postprocess.effect.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKColorBlindnessFx extends ITVKVideoFx {
    public static final String DEFAULT = "DEFAULT";
    public static final String DEUTERANOPIA = "DEUTERANOPIA";
    public static final String PROTANOPIA = "PROTANOPIA";
    public static final String TRITANOPIA = "TRITANOPIA";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface ColorBlindnessMode {
    }

    void setColorBlindMode(String str);
}
