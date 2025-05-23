package com.tencent.qqlive.tvkplayer.tpplayer.tools;

import androidx.annotation.Keep;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDontFuckingProguard;
import com.tencent.qqlive.tvkplayer.tpplayer.api.TVKPlayerCommonEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Keep
@TVKDontFuckingProguard
/* loaded from: classes23.dex */
public class TVKPlayerMsgValueMap {

    @Target({ElementType.FIELD})
    @SearchConfig(searchClass = TVKPlayerCommonEnum.class, tpDefValue = -1, tvkDefValue = 0, valueClass = int.class)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface MapAudioDecoderType {
        int value();
    }

    @Target({ElementType.FIELD})
    @SearchConfig(searchClass = TVKPlayerCommonEnum.class, tpDefValue = 0, tvkDefValue = 0, valueClass = int.class)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface MapPlayerType {
        int value();
    }

    @Target({ElementType.FIELD})
    @SearchConfig(searchClass = TVKPlayerCommonEnum.class, tpDefValue = -1, tvkDefValue = 0, valueClass = int.class)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface MapVideoDecoderType {
        int value();
    }

    @Target({ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface SearchConfig {
        Class<?> searchClass();

        long tpDefValue();

        long tvkDefValue();

        Class<? extends Number> valueClass();
    }
}
