package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.tencent.xweb.FileReaderHelper;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class FindAddress {
    private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final String HOUSE_END = "(?=[,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String HOUSE_POST_DELIM = ",\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String HOUSE_PRE_DELIM = ":,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int MAX_ADDRESS_LINES = 5;
    private static final int MAX_ADDRESS_WORDS = 14;
    private static final int MAX_LOCATION_NAME_DISTANCE = 5;
    private static final int MIN_ADDRESS_WORDS = 4;
    private static final String NL = "\n\u000b\f\r\u0085\u2028\u2029";
    private static final String SP = "\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000";
    private static final String WORD_DELIM = ",*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String WORD_END = "(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String WS = "\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int kMaxAddressNameWordLength = 25;
    private static final ZipRange[] sStateZipCodeRanges = {new ZipRange(99, 99, -1, -1), new ZipRange(35, 36, -1, -1), new ZipRange(71, 72, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(85, 86, -1, -1), new ZipRange(90, 96, -1, -1), new ZipRange(80, 81, -1, -1), new ZipRange(6, 6, -1, -1), new ZipRange(20, 20, -1, -1), new ZipRange(19, 19, -1, -1), new ZipRange(32, 34, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(30, 31, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(50, 52, -1, -1), new ZipRange(83, 83, -1, -1), new ZipRange(60, 62, -1, -1), new ZipRange(46, 47, -1, -1), new ZipRange(66, 67, 73, -1), new ZipRange(40, 42, -1, -1), new ZipRange(70, 71, -1, -1), new ZipRange(1, 2, -1, -1), new ZipRange(20, 21, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(48, 49, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(63, 65, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(38, 39, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(27, 28, -1, -1), new ZipRange(58, 58, -1, -1), new ZipRange(68, 69, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(7, 8, -1, -1), new ZipRange(87, 88, 86, -1), new ZipRange(88, 89, 96, -1), new ZipRange(10, 14, 0, 6), new ZipRange(43, 45, -1, -1), new ZipRange(73, 74, -1, -1), new ZipRange(97, 97, -1, -1), new ZipRange(15, 19, -1, -1), new ZipRange(6, 6, 0, 9), new ZipRange(96, 96, -1, -1), new ZipRange(2, 2, -1, -1), new ZipRange(29, 29, -1, -1), new ZipRange(57, 57, -1, -1), new ZipRange(37, 38, -1, -1), new ZipRange(75, 79, 87, 88), new ZipRange(84, 84, -1, -1), new ZipRange(22, 24, 20, -1), new ZipRange(6, 9, -1, -1), new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1)};
    private static final Pattern sWordRe = Pattern.compile("[^,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    private static final Pattern sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    private static final Pattern sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+of[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+states[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+of[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+mariana[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+carolina)|(nd|north[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+hampshire)|(nj|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+jersey)|(nm|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+island)|(sc|south[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+carolina)|(sd|south[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+virginia)|(wy|wyoming))(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    private static final Pattern sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    private static final Pattern sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
    private static final Pattern sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ZipRange {
        int mException1;
        int mException2;
        int mHigh;
        int mLow;

        ZipRange(int i3, int i16, int i17, int i18) {
            this.mLow = i3;
            this.mHigh = i16;
            this.mException1 = i17;
            this.mException2 = i18;
        }

        boolean matches(String str) {
            int parseInt = Integer.parseInt(str.substring(0, 2));
            if ((this.mLow > parseInt || parseInt > this.mHigh) && parseInt != this.mException1 && parseInt != this.mException2) {
                return false;
            }
            return true;
        }
    }

    FindAddress() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0027, code lost:
    
        return -r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int attemptMatch(String str, MatchResult matchResult) {
        int length;
        MatchResult matchState;
        int end = matchResult.end();
        Matcher matcher = sWordRe.matcher(str);
        String str2 = "";
        int i3 = -1;
        int i16 = -1;
        int i17 = 1;
        int i18 = 1;
        boolean z16 = true;
        boolean z17 = false;
        while (true) {
            if (end < str.length()) {
                if (!matcher.find(end)) {
                    length = str.length();
                    break;
                }
                if (matcher.end() - matcher.start() > 25) {
                    length = matcher.end();
                    break;
                }
                while (end < matcher.start()) {
                    int i19 = end + 1;
                    if (NL.indexOf(str.charAt(end)) != -1) {
                        i17++;
                    }
                    end = i19;
                }
                if (i17 > 5 || (i18 = i18 + 1) > 14) {
                    break;
                }
                if (matchHouseNumber(str, end) != null) {
                    if (z16 && i17 > 1) {
                        return -end;
                    }
                    if (i3 == -1) {
                        i3 = end;
                    }
                } else {
                    if (isValidLocationName(matcher.group(0))) {
                        z17 = true;
                    } else {
                        if (i18 == 5 && !z17) {
                            end = matcher.end();
                            break;
                        }
                        if (z17 && i18 > 4 && (matchState = matchState(str, end)) != null) {
                            if (str2.equals(FileReaderHelper.ET_EXT) && matchState.group(0).equals("al")) {
                                end = matchState.end();
                                break;
                            }
                            Matcher matcher2 = sWordRe.matcher(str);
                            if (matcher2.find(matchState.end())) {
                                if (isValidZipCode(matcher2.group(0), matchState)) {
                                    return matcher2.end();
                                }
                            } else {
                                i16 = matchState.end();
                            }
                        }
                    }
                    z16 = false;
                }
                str2 = matcher.group(0);
                end = matcher.end();
            } else {
                break;
            }
        }
        if (i16 > 0) {
            return i16;
        }
        if (i3 <= 0) {
            i3 = end;
        }
        return -i3;
    }

    private static boolean checkHouseNumber(String str) {
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            if (Character.isDigit(str.charAt(i16))) {
                i3++;
            }
        }
        if (i3 > 5) {
            return false;
        }
        Matcher matcher = sSuffixedNumberRe.matcher(str);
        if (!matcher.find()) {
            return true;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        if (parseInt == 0) {
            return false;
        }
        String lowerCase = matcher.group(2).toLowerCase(Locale.getDefault());
        int i17 = parseInt % 10;
        String str2 = "th";
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    return lowerCase.equals("th");
                }
                if (parseInt % 100 != 13) {
                    str2 = "rd";
                }
                return lowerCase.equals(str2);
            }
            if (parseInt % 100 != 12) {
                str2 = "nd";
            }
            return lowerCase.equals(str2);
        }
        if (parseInt % 100 != 11) {
            str2 = "st";
        }
        return lowerCase.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String findAddress(String str) {
        Matcher matcher = sHouseNumberRe.matcher(str);
        int i3 = 0;
        while (matcher.find(i3)) {
            if (checkHouseNumber(matcher.group(0))) {
                int start = matcher.start();
                int attemptMatch = attemptMatch(str, matcher);
                if (attemptMatch > 0) {
                    return str.substring(start, attemptMatch);
                }
                i3 = -attemptMatch;
            } else {
                i3 = matcher.end();
            }
        }
        return null;
    }

    @VisibleForTesting
    public static boolean isValidLocationName(String str) {
        return sLocationNameRe.matcher(str).matches();
    }

    private static boolean isValidZipCode(String str, MatchResult matchResult) {
        if (matchResult == null) {
            return false;
        }
        int groupCount = matchResult.groupCount();
        while (true) {
            if (groupCount <= 0) {
                break;
            }
            int i3 = groupCount - 1;
            if (matchResult.group(groupCount) != null) {
                groupCount = i3;
                break;
            }
            groupCount = i3;
        }
        return sZipCodeRe.matcher(str).matches() && sStateZipCodeRanges[groupCount].matches(str);
    }

    @VisibleForTesting
    public static MatchResult matchHouseNumber(String str, int i3) {
        if (i3 > 0 && HOUSE_PRE_DELIM.indexOf(str.charAt(i3 - 1)) == -1) {
            return null;
        }
        Matcher region = sHouseNumberRe.matcher(str).region(i3, str.length());
        if (region.lookingAt()) {
            MatchResult matchResult = region.toMatchResult();
            if (checkHouseNumber(matchResult.group(0))) {
                return matchResult;
            }
        }
        return null;
    }

    @VisibleForTesting
    public static MatchResult matchState(String str, int i3) {
        if (i3 > 0 && WORD_DELIM.indexOf(str.charAt(i3 - 1)) == -1) {
            return null;
        }
        Matcher region = sStateRe.matcher(str).region(i3, str.length());
        if (!region.lookingAt()) {
            return null;
        }
        return region.toMatchResult();
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String str, String str2) {
        return isValidZipCode(str, matchState(str2, 0));
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String str) {
        return sZipCodeRe.matcher(str).matches();
    }
}
