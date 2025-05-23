package com.tencent.oskplayer.util.apache;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.constants.Constants;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.ads.data.AdParam;
import com.tencent.av.so.ResInfo;
import com.tencent.av.ui.an;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DomainValidator implements Serializable {
    private static final String[] COUNTRY_CODE_TLDS;
    private static final List COUNTRY_CODE_TLD_LIST;
    private static final String DOMAIN_LABEL_REGEX = "\\p{Alnum}(?>[\\p{Alnum}-]*\\p{Alnum})*";
    private static final String DOMAIN_NAME_REGEX = "^(?:\\p{Alnum}(?>[\\p{Alnum}-]*\\p{Alnum})*\\.)+(\\p{Alpha}{2,})$";
    private static final DomainValidator DOMAIN_VALIDATOR = new DomainValidator(false);
    private static final DomainValidator DOMAIN_VALIDATOR_WITH_LOCAL = new DomainValidator(true);
    private static final String[] GENERIC_TLDS;
    private static final List GENERIC_TLD_LIST;
    private static final String[] INFRASTRUCTURE_TLDS;
    private static final List INFRASTRUCTURE_TLD_LIST;
    private static final String[] LOCAL_TLDS;
    private static final List LOCAL_TLD_LIST;
    private static final String TOP_LABEL_REGEX = "\\p{Alpha}{2,}";
    private static final long serialVersionUID = -4407125112880174009L;
    private final boolean allowLocal;
    private final RegexValidator domainRegex = new RegexValidator(DOMAIN_NAME_REGEX);
    private final RegexValidator hostnameRegex = new RegexValidator(DOMAIN_LABEL_REGEX);

    static {
        String[] strArr = {"arpa", "root"};
        INFRASTRUCTURE_TLDS = strArr;
        String[] strArr2 = {"aero", "asia", "biz", "cat", "com", "coop", "info", "jobs", "mobi", "museum", "name", "net", "org", WadlResult.WEB_KEY_PROGRESS, "tel", "travel", "gov", "edu", "mil", PoiListCacheRecord.WEIGHT_TYPE};
        GENERIC_TLDS = strArr2;
        String[] strArr3 = {ac.f283467k0, "ad", "ae", "af", "ag", "ai", "al", "am", an.f75362j, "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", VasProfileTemplatePreloadHelper.BACKGROUND, "bh", "bi", "bj", "bm", "bn", "bo", TtmlNode.TAG_BR, "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "er", "es", FileReaderHelper.ET_EXT, "eu", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", ReportConstant.COSTREPORT_HT, "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm", GdtADFlyingStreamingReportHelper.PARAM_KEY_MN, "mo", "mp", "mq", "mr", "ms", "mt", "mu", QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE, "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", AdParam.PF, "pg", "ph", "pk", "pl", "pm", "pn", "pr", Constants.KEYS.PLACEMENTS, "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", ReportConstant.COSTREPORT_SN, ResInfo.RES_TYPE_SO, "sr", "st", "su", GdtADFlyingStreamingReportHelper.PARAM_KEY_SV, "sy", "sz", PlayerConfig.TC_CACHE_DIR_NAME, "td", "tf", "tg", "th", "tj", "tk", "tl", TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP, "tn", "to", "tp", ReportConstant.COSTREPORT_TRANS, TtmlNode.TAG_TT, "tv", "tw", "tz", "ua", "ug", "uk", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "yu", "za", "zm", "zw"};
        COUNTRY_CODE_TLDS = strArr3;
        String[] strArr4 = {"localhost", "localdomain"};
        LOCAL_TLDS = strArr4;
        INFRASTRUCTURE_TLD_LIST = Arrays.asList(strArr);
        GENERIC_TLD_LIST = Arrays.asList(strArr2);
        COUNTRY_CODE_TLD_LIST = Arrays.asList(strArr3);
        LOCAL_TLD_LIST = Arrays.asList(strArr4);
    }

    DomainValidator(boolean z16) {
        this.allowLocal = z16;
    }

    private String chompLeadingDot(String str) {
        if (str.startsWith(".")) {
            return str.substring(1);
        }
        return str;
    }

    public static DomainValidator getInstance() {
        return DOMAIN_VALIDATOR;
    }

    public boolean isValid(String str) {
        String[] match = this.domainRegex.match(str);
        if (match != null && match.length > 0) {
            return isValidTld(match[0]);
        }
        if (!this.allowLocal || !this.hostnameRegex.isValid(str)) {
            return false;
        }
        return true;
    }

    public boolean isValidCountryCodeTld(String str) {
        return COUNTRY_CODE_TLD_LIST.contains(chompLeadingDot(str.toLowerCase()));
    }

    public boolean isValidGenericTld(String str) {
        return GENERIC_TLD_LIST.contains(chompLeadingDot(str.toLowerCase()));
    }

    public boolean isValidInfrastructureTld(String str) {
        return INFRASTRUCTURE_TLD_LIST.contains(chompLeadingDot(str.toLowerCase()));
    }

    public boolean isValidLocalTld(String str) {
        return LOCAL_TLD_LIST.contains(chompLeadingDot(str.toLowerCase()));
    }

    public boolean isValidTld(String str) {
        if ((this.allowLocal && isValidLocalTld(str)) || isValidInfrastructureTld(str) || isValidGenericTld(str) || isValidCountryCodeTld(str)) {
            return true;
        }
        return false;
    }

    public static DomainValidator getInstance(boolean z16) {
        if (z16) {
            return DOMAIN_VALIDATOR_WITH_LOCAL;
        }
        return DOMAIN_VALIDATOR;
    }
}
