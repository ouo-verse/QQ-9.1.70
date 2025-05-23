package com.tencent.oskplayer.util.apache;

import android.text.TextUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class UrlValidator implements Serializable {
    public static final long ALLOW_2_SLASHES = 2;
    public static final long ALLOW_ALL_SCHEMES = 1;
    public static final long ALLOW_LOCAL_URLS = 8;
    private static final String AUTHORITY_CHARS_REGEX = "\\p{Alnum}\\-\\.";
    public static final long NO_FRAGMENTS = 4;
    private static final int PARSE_AUTHORITY_EXTRA = 3;
    private static final int PARSE_AUTHORITY_HOST_IP = 1;
    private static final int PARSE_AUTHORITY_PORT = 2;
    private static final int PARSE_URL_AUTHORITY = 4;
    private static final int PARSE_URL_FRAGMENT = 9;
    private static final int PARSE_URL_PATH = 5;
    private static final int PARSE_URL_QUERY = 7;
    private static final int PARSE_URL_SCHEME = 2;
    private static final long serialVersionUID = 7557161713937335013L;
    private final Set allowedSchemes;
    private final RegexValidator authorityValidator;
    private final long options;
    private static final String URL_REGEX = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private static final String SCHEME_REGEX = "^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*";
    private static final Pattern SCHEME_PATTERN = Pattern.compile(SCHEME_REGEX);
    private static final String AUTHORITY_REGEX = "^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?";
    private static final Pattern AUTHORITY_PATTERN = Pattern.compile(AUTHORITY_REGEX);
    private static final String PATH_REGEX = "^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$";
    private static final Pattern PATH_PATTERN = Pattern.compile(PATH_REGEX);
    private static final String QUERY_REGEX = "^(.*)$";
    private static final Pattern QUERY_PATTERN = Pattern.compile(QUERY_REGEX);
    private static final String LEGAL_ASCII_REGEX = "^\\p{ASCII}+$";
    private static final Pattern ASCII_PATTERN = Pattern.compile(LEGAL_ASCII_REGEX);
    private static final String PORT_REGEX = "^:(\\d{1,5})$";
    private static final Pattern PORT_PATTERN = Pattern.compile(PORT_REGEX);
    private static final String[] DEFAULT_SCHEMES = {"http", "https", "ftp"};
    private static final UrlValidator DEFAULT_URL_VALIDATOR = new UrlValidator();

    public UrlValidator() {
        this((String[]) null);
    }

    public static UrlValidator getInstance() {
        return DEFAULT_URL_VALIDATOR;
    }

    private boolean isOff(long j3) {
        if ((j3 & this.options) == 0) {
            return true;
        }
        return false;
    }

    private boolean isOn(long j3) {
        if ((j3 & this.options) > 0) {
            return true;
        }
        return false;
    }

    protected int countToken(String str, String str2) {
        int i3 = 0;
        int i16 = 0;
        while (i3 != -1) {
            i3 = str2.indexOf(str, i3);
            if (i3 > -1) {
                i3++;
                i16++;
            }
        }
        return i16;
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        if (PlayerUtils.isLocalFile(str)) {
            return true;
        }
        if (!ASCII_PATTERN.matcher(str).matches()) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        String group = matcher.group(2);
        if (!isValidScheme(group)) {
            return false;
        }
        String group2 = matcher.group(4);
        if (((!TextUtils.isEmpty(group) || !TextUtils.isEmpty(group2)) && !isValidAuthority(group2)) || !isValidPath(matcher.group(5)) || !isValidQuery(matcher.group(7)) || !isValidFragment(matcher.group(9))) {
            return false;
        }
        return true;
    }

    protected boolean isValidAuthority(String str) {
        if (str == null) {
            return false;
        }
        RegexValidator regexValidator = this.authorityValidator;
        if (regexValidator != null && regexValidator.isValid(str)) {
            return true;
        }
        Matcher matcher = AUTHORITY_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        String group = matcher.group(1);
        if (!DomainValidator.getInstance(isOn(8L)).isValid(group) && !InetAddressValidator.getInstance().isValid(group)) {
            return false;
        }
        String group2 = matcher.group(2);
        if (group2 != null && !PORT_PATTERN.matcher(group2).matches()) {
            return false;
        }
        String group3 = matcher.group(3);
        if (group3 != null && group3.trim().length() > 0) {
            return false;
        }
        return true;
    }

    protected boolean isValidFragment(String str) {
        if (str == null) {
            return true;
        }
        return isOff(4L);
    }

    protected boolean isValidPath(String str) {
        if (str == null || !PATH_PATTERN.matcher(str).matches()) {
            return false;
        }
        int countToken = countToken("//", str);
        if (isOff(2L) && countToken > 0) {
            return false;
        }
        int countToken2 = countToken("/", str);
        int countToken3 = countToken("..", str);
        if (countToken3 > 0 && (countToken2 - countToken) - 1 <= countToken3) {
            return false;
        }
        return true;
    }

    protected boolean isValidQuery(String str) {
        if (str == null) {
            return true;
        }
        return QUERY_PATTERN.matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValidScheme(String str) {
        if (str == null || !SCHEME_PATTERN.matcher(str).matches()) {
            return false;
        }
        if (isOff(1L) && !this.allowedSchemes.contains(str)) {
            return false;
        }
        return true;
    }

    public UrlValidator(String[] strArr) {
        this(strArr, 0L);
    }

    public UrlValidator(long j3) {
        this(null, null, j3);
    }

    public UrlValidator(String[] strArr, long j3) {
        this(strArr, null, j3);
    }

    public UrlValidator(RegexValidator regexValidator, long j3) {
        this(null, regexValidator, j3);
    }

    public UrlValidator(String[] strArr, RegexValidator regexValidator, long j3) {
        this.options = j3;
        if (isOn(1L)) {
            this.allowedSchemes = Collections.EMPTY_SET;
        } else {
            strArr = strArr == null ? DEFAULT_SCHEMES : strArr;
            HashSet hashSet = new HashSet();
            this.allowedSchemes = hashSet;
            hashSet.addAll(Arrays.asList(strArr));
        }
        this.authorityValidator = regexValidator;
    }
}
