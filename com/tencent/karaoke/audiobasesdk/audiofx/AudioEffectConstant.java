package com.tencent.karaoke.audiobasesdk.audiofx;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioEffectConstant {
    public static final float DEFAULT_EQUALIZER_PARAM_VALUE = 0.5f;
    public static final float DEFAULT_REVERB_SCALE_VALUE = 0.5f;
    public static final int EqualizerParamBandCount = 10;
    public static final int[] EqualizerParamBandId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface AudioPluggedEnv {
        public static final int kPluggedEnvMaxExcluded = 2;
        public static final int kPluggedEnvPlugged = 0;
        public static final int kPluggedEnvUnplugged = 1;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IEffectType {
        public static final int EffectTypeAi = 1;
        public static final int EffectTypeNormal = 0;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IEqualizerParam {
        public static final int EqualizerParamBand0 = 1;
        public static final int EqualizerParamBand1 = 2;
        public static final int EqualizerParamBand2 = 3;
        public static final int EqualizerParamBand3 = 4;
        public static final int EqualizerParamBand4 = 5;
        public static final int EqualizerParamBand5 = 6;
        public static final int EqualizerParamBand6 = 7;
        public static final int EqualizerParamBand7 = 8;
        public static final int EqualizerParamBand8 = 9;
        public static final int EqualizerParamBand9 = 10;
        public static final int EqualizerParamCustomBands = 12;
        public static final int EqualizerParamDefaultBlues = 16;
        public static final int EqualizerParamDefaultCustom = 14;
        public static final int EqualizerParamDefaultEletric = 19;
        public static final int EqualizerParamDefaultFolk = 21;
        public static final int EqualizerParamDefaultJazz = 17;
        public static final int EqualizerParamDefaultNone = 13;
        public static final int EqualizerParamDefaultPop = 15;
        public static final int EqualizerParamDefaultRock = 20;
        public static final int EqualizerParamDefaultSlow = 18;
        public static final int EqualizerParamTimbre = 11;
        public static final int EqualizerParamType = 0;
        public static final int EqualizerParamVip = 100;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IEqualizerType {
        public static final int EqualizerTypeBlues = 3;
        public static final int EqualizerTypeCustom = 1;
        public static final int EqualizerTypeElectric = 6;
        public static final int EqualizerTypeFolk = 8;
        public static final int EqualizerTypeJazz = 4;
        public static final int EqualizerTypeNone = 0;
        public static final int EqualizerTypePop = 2;
        public static final int EqualizerTypeRock = 7;
        public static final int EqualizerTypeSlow = 5;
        public static final int EqualizerTypeTimbre = 9;
        public static final int EqualizerTypeVip = 100;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IReverbID {
        public static final int BaseVerbVip = 100;
        public static final int Reverb2TypeChangjiang = 15;
        public static final int Reverb2TypeChurch = 10;
        public static final int Reverb2TypeConcert = 16;
        public static final int Reverb2TypeCustom = 103;
        public static final int Reverb2TypeDeepmusic = 14;
        public static final int Reverb2TypeDistant = 5;
        public static final int Reverb2TypeDizzy = 6;
        public static final int Reverb2TypeEthereal = 4;
        public static final int Reverb2TypeHall = 11;
        public static final int Reverb2TypeKtv = 1;
        public static final int Reverb2TypeLivehouse = 17;
        public static final int Reverb2TypeMagnetic = 2;
        public static final int Reverb2TypeNone = 0;
        public static final int Reverb2TypeOneMixWithGalaxy = 21;
        public static final int Reverb2TypeOneMixWithGalaxyConv = 22;
        public static final int Reverb2TypeOnemix = 20;
        public static final int Reverb2TypeOrigin = 13;
        public static final int Reverb2TypePark = 19;
        public static final int Reverb2TypePhonograph = 7;
        public static final int Reverb2TypeRoom = 12;
        public static final int Reverb2TypeStar = 3;
        public static final int Reverb2TypeStudio = 9;
        public static final int Reverb2TypeSubway = 18;
        public static final int Reverb2TypeVipM = 101;
        public static final int Reverb2TypeVipReserved = 8;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IReverbParam {
        public static final int Reverb2ParamBaseVerbVipScale = 100;
        public static final int Reverb2ParamCDScale = 11;
        public static final int Reverb2ParamChangjiangScale = 12;
        public static final int Reverb2ParamChurchScale = 7;
        public static final int Reverb2ParamConcertScale = 13;
        public static final int Reverb2ParamCustomScale = 18;
        public static final int Reverb2ParamDistantScale = 4;
        public static final int Reverb2ParamHallScale = 8;
        public static final int Reverb2ParamKtvScale = 1;
        public static final int Reverb2ParamLivehouseScale = 14;
        public static final int Reverb2ParamLvyingpengScale = 5;
        public static final int Reverb2ParamOneMix = 17;
        public static final int Reverb2ParamOriginScale = 10;
        public static final int Reverb2ParamParkScale = 16;
        public static final int Reverb2ParamRoomScale = 9;
        public static final int Reverb2ParamStarScale0 = 2;
        public static final int Reverb2ParamStarScale1 = 3;
        public static final int Reverb2ParamStudioScale = 6;
        public static final int Reverb2ParamSubwayScale = 15;
        public static final int Reverb2ParamType = 0;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IVoicsShiftType {
        public static final int VoiceShiftTypeAutotune = 1;
        public static final int VoiceShiftTypeChorus = 3;
        public static final int VoiceShiftTypeMetal = 2;
        public static final int VoiceShiftTypeNone = 0;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface PreprocessorStage {
        public static final int kStageMaxExcluded = 3;
        public static final int kStagePreview = 1;
        public static final int kStageProduct = 2;
        public static final int kStageRecord = 0;
    }
}
