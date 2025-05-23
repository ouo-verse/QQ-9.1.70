package com.tencent.autotemplate.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.tavmovie.base.TAVDecodeAndEncodeBase;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVBaseAutomaticEffect implements TAVDecodeAndEncodeBase {
    static IPatchRedirector $redirector_ = null;
    public static final String EFFECT_TYPE_CUSTOM = "Custom";
    public static final String EFFECT_TYPE_LUT = "lut";
    public static final String EFFECT_TYPE_PAG = "pag";
    public static final String EFFECT_TYPE_PITU = "pitu";
    public static final String EFFECT_TYPE_TIME = "time";
    public static final String TYPE_FILTER = "filter";
    public static final String TYPE_GRADIENT_FACE = "GradientFace";
    public static final String TYPE_SPEED = "Speed";

    @SerializedName("duration")
    public long duration;

    @SerializedName("effectId")
    public String effectId;
    protected transient TAVEffectType effectType;

    @SerializedName(AIAbilityModel.AI_KEY)
    public String effectTypeStr;
    public transient String fileDir;

    @SerializedName("parameter")
    public TAVEffectParameter parameter;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class TAVEffectType {
        private static final /* synthetic */ TAVEffectType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TAVEffectType TAVEffectTypeCustom;
        public static final TAVEffectType TAVEffectTypeLUT;
        public static final TAVEffectType TAVEffectTypePAG;
        public static final TAVEffectType TAVEffectTypePITU;
        public static final TAVEffectType TAVEffectTypeTime;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17814);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TAVEffectType tAVEffectType = new TAVEffectType("TAVEffectTypePAG", 0);
            TAVEffectTypePAG = tAVEffectType;
            TAVEffectType tAVEffectType2 = new TAVEffectType("TAVEffectTypeLUT", 1);
            TAVEffectTypeLUT = tAVEffectType2;
            TAVEffectType tAVEffectType3 = new TAVEffectType("TAVEffectTypePITU", 2);
            TAVEffectTypePITU = tAVEffectType3;
            TAVEffectType tAVEffectType4 = new TAVEffectType("TAVEffectTypeTime", 3);
            TAVEffectTypeTime = tAVEffectType4;
            TAVEffectType tAVEffectType5 = new TAVEffectType("TAVEffectTypeCustom", 4);
            TAVEffectTypeCustom = tAVEffectType5;
            $VALUES = new TAVEffectType[]{tAVEffectType, tAVEffectType2, tAVEffectType3, tAVEffectType4, tAVEffectType5};
        }

        TAVEffectType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TAVEffectType valueOf(String str) {
            return (TAVEffectType) Enum.valueOf(TAVEffectType.class, str);
        }

        public static TAVEffectType[] values() {
            return (TAVEffectType[]) $VALUES.clone();
        }
    }

    public TAVBaseAutomaticEffect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.tavmovie.base.TAVDecodeAndEncodeBase
    public TAVDecodeAndEncodeBase decodeFromJsonString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TAVDecodeAndEncodeBase) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return (TAVDecodeAndEncodeBase) JsonUtils.parseObjectFromJsonString(str, getClass());
    }

    @Override // com.tencent.tavmovie.base.TAVDecodeAndEncodeBase
    public String encodeToJsonString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return JsonUtils.encodeObjectToJsonString(this);
    }

    public long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.duration;
    }

    public TAVEffectType getEffectType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (TAVEffectType) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if ("pag".equalsIgnoreCase(this.effectTypeStr)) {
            return TAVEffectType.TAVEffectTypePAG;
        }
        if (EFFECT_TYPE_LUT.equalsIgnoreCase(this.effectTypeStr)) {
            return TAVEffectType.TAVEffectTypeLUT;
        }
        if (EFFECT_TYPE_PITU.equalsIgnoreCase(this.effectTypeStr)) {
            return TAVEffectType.TAVEffectTypePITU;
        }
        if ("time".equalsIgnoreCase(this.effectTypeStr)) {
            return TAVEffectType.TAVEffectTypeTime;
        }
        if ("Custom".equalsIgnoreCase(this.effectTypeStr)) {
            return TAVEffectType.TAVEffectTypeCustom;
        }
        return TAVEffectType.TAVEffectTypePAG;
    }

    public String getFileDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.fileDir;
    }

    public String getFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        TAVEffectParameter tAVEffectParameter = this.parameter;
        if (tAVEffectParameter != null) {
            return tAVEffectParameter.filePath;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFullPath() {
        TAVEffectParameter tAVEffectParameter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (!TextUtils.isEmpty(this.fileDir) && (tAVEffectParameter = this.parameter) != null && !TextUtils.isEmpty(tAVEffectParameter.filePath)) {
            return this.fileDir + File.separator + this.parameter.filePath;
        }
        return null;
    }

    public TAVMovieSticker.TAVMovieStickerMode getMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TAVMovieSticker.TAVMovieStickerMode) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        TAVEffectParameter tAVEffectParameter = this.parameter;
        if (tAVEffectParameter != null && "filter".equalsIgnoreCase(tAVEffectParameter.type)) {
            return TAVMovieSticker.TAVMovieStickerMode.TAVMovieStickerModeFilter;
        }
        return TAVMovieSticker.TAVMovieStickerMode.TAVMovieStickerModeOverlay;
    }

    public int getProcMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        TAVEffectParameter tAVEffectParameter = this.parameter;
        if (tAVEffectParameter != null) {
            return tAVEffectParameter.procMethod;
        }
        return 0;
    }

    public float getSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        TAVEffectParameter tAVEffectParameter = this.parameter;
        if (tAVEffectParameter != null) {
            return tAVEffectParameter.speed;
        }
        return 1.0f;
    }

    public void setDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.duration = j3;
        }
    }

    public void setFileDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.fileDir = str;
        }
    }

    public void setFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (this.parameter == null) {
            this.parameter = new TAVEffectParameter();
        }
        this.parameter.filePath = str;
    }

    public TAVBaseAutomaticEffect(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.fileDir = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }
}
