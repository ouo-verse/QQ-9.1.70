package com.tencent.oskplayer.util;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.apache.UrlValidator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoUrlValidator extends UrlValidator {
    public static final String LOG_TAG = "UrlValidator";
    private static ConcurrentHashMap<String, Boolean> sUrlValidateResultCache = new ConcurrentHashMap<>();
    private final String INSTRICT_INVALID_PARAM_REGEX;
    private final Pattern PATTERN_INVALID_PARAM;
    private final String STRICT_INVALID_PARAM_REGEX;

    public VideoUrlValidator() {
        super(null, null, 1L);
        this.STRICT_INVALID_PARAM_REGEX = "[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;/?@=&$+\"]";
        this.INSTRICT_INVALID_PARAM_REGEX = "[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;?@=&$+\"]";
        this.PATTERN_INVALID_PARAM = Pattern.compile("[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;?@=&$+\"]");
    }

    @Override // com.tencent.oskplayer.util.apache.UrlValidator
    public boolean isValid(String str) {
        PlayerUtils.log(4, LOG_TAG, "isValid " + str);
        if (sUrlValidateResultCache.containsKey(str)) {
            return sUrlValidateResultCache.get(str).booleanValue();
        }
        boolean isValid = super.isValid(str);
        sUrlValidateResultCache.put(str, Boolean.valueOf(isValid));
        return isValid;
    }

    @Override // com.tencent.oskplayer.util.apache.UrlValidator
    protected boolean isValidQuery(String str) {
        if (str == null) {
            return true;
        }
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        for (int i3 = 0; i3 < split.length; i3++) {
            String[] split2 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                if (this.PATTERN_INVALID_PARAM.matcher(split2[0]).find()) {
                    PlayerUtils.log(5, LOG_TAG, "invalid query string detected " + split[i3]);
                    return false;
                }
                if (this.PATTERN_INVALID_PARAM.matcher(split2[1]).find()) {
                    PlayerUtils.log(5, LOG_TAG, "invalid query string detected " + split[i3]);
                    return false;
                }
            } else if (split2.length == 1 && split[i3].indexOf(61) == split[i3].length() - 1) {
                if (this.PATTERN_INVALID_PARAM.matcher(split2[0]).find()) {
                    PlayerUtils.log(5, LOG_TAG, "invalid query string detected " + split[i3]);
                    return false;
                }
            } else if (split2.length > 2) {
                PlayerUtils.log(5, LOG_TAG, "invalid query string detected " + split[i3]);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.oskplayer.util.apache.UrlValidator
    public boolean isValidScheme(String str) {
        if (str == null) {
            str = "file";
        }
        return super.isValidScheme(str);
    }

    public VideoUrlValidator(String[] strArr) {
        super(strArr);
        this.STRICT_INVALID_PARAM_REGEX = "[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;/?@=&$+\"]";
        this.INSTRICT_INVALID_PARAM_REGEX = "[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;?@=&$+\"]";
        this.PATTERN_INVALID_PARAM = Pattern.compile("[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;?@=&$+\"]");
    }

    public boolean isValid(SegmentVideoInfo.StreamInfo streamInfo) {
        for (int i3 = 0; i3 < streamInfo.getCount(); i3++) {
            if (!isValid(streamInfo.getSegment(i3).url)) {
                return false;
            }
        }
        return true;
    }
}
