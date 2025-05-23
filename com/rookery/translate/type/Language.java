package com.rookery.translate.type;

import com.qq.e.comm.constants.Constants;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.xweb.FileReaderHelper;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum Language {
    AUTO_DETECT(""),
    AFRIKAANS("af"),
    ALBANIAN("sq"),
    AMHARIC("am"),
    ARABIC("ar"),
    ARMENIAN("hy"),
    AZERBAIJANI("az"),
    BASQUE("eu"),
    BELARUSIAN("be"),
    BENGALI("bn"),
    BIHARI("bh"),
    BULGARIAN(VasProfileTemplatePreloadHelper.BACKGROUND),
    BURMESE("my"),
    CATALAN("ca"),
    CHEROKEE("chr"),
    CHINESE(OcrConfig.CHINESE),
    CHINESE_SIMPLIFIED("zh-CN"),
    CHINESE_TRADITIONAL("zh-TW"),
    MS_CHINESE_SIMPLIFIED("zh-CHS"),
    MS_CHINESE_TRADITIONAL("zh-CHT"),
    CROATIAN("hr"),
    CZECH("cs"),
    DANISH("da"),
    DHIVEHI("dv"),
    DUTCH("nl"),
    ENGLISH("en"),
    ESPERANTO("eo"),
    ESTONIAN(FileReaderHelper.ET_EXT),
    FILIPINO("tl"),
    FINNISH("fi"),
    FRENCH("fr"),
    GALICIAN("gl"),
    GEORGIAN("ka"),
    GERMAN("de"),
    GREEK("el"),
    GUARANI("gn"),
    GUJARATI("gu"),
    HEBREW("iw"),
    HINDI("hi"),
    HUNGARIAN("hu"),
    ICELANDIC("is"),
    INDONESIAN("id"),
    INUKTITUT("iu"),
    IRISH("ga"),
    ITALIAN("it"),
    JAPANESE(LocaleUtils.L_JAPANESE),
    KANNADA("kn"),
    KAZAKH("kk"),
    KHMER("km"),
    KOREAN(LocaleUtils.L_KOREAN),
    KURDISH("ku"),
    KYRGYZ("ky"),
    LAOTHIAN("lo"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    MACEDONIAN("mk"),
    MALAY("ms"),
    MALAYALAM("ml"),
    MALTESE("mt"),
    MARATHI("mr"),
    MONGOLIAN(GdtADFlyingStreamingReportHelper.PARAM_KEY_MN),
    NEPALI("ne"),
    NORWEGIAN("no"),
    ORIYA("or"),
    PASHTO(Constants.KEYS.PLACEMENTS),
    PERSIAN("fa"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PUNJABI("pa"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SANSKRIT("sa"),
    SERBIAN("sr"),
    SINDHI("sd"),
    SINHALESE("si"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SPANISH("es"),
    SWAHILI("sw"),
    SWEDISH(GdtADFlyingStreamingReportHelper.PARAM_KEY_SV),
    TAJIK("tg"),
    TAMIL("ta"),
    TAGALOG("tl"),
    TELUGU("te"),
    THAI("th"),
    TIBETAN("bo"),
    TURKISH(ReportConstant.COSTREPORT_TRANS),
    UKRANIAN("uk"),
    URDU("ur"),
    UZBEK("uz"),
    UIGHUR("ug"),
    VIETNAMESE("vi"),
    WELSH("cy"),
    YIDDISH(WidgetCacheLunarData.YI);

    private final String language;

    Language(String str) {
        this.language = str;
    }

    public static Language fromString(String str) {
        for (Language language : values()) {
            if (language.toString().equals(str)) {
                return language;
            }
        }
        return CHINESE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.language;
    }
}
