package org.apache.commons.lang.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.text.StrBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FastDateFormat extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static String cDefaultPattern = null;
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private final boolean mLocaleForced;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;
    private final boolean mTimeZoneForced;
    private static final Map cInstanceCache = new HashMap(7);
    private static final Map cDateInstanceCache = new HashMap(7);
    private static final Map cTimeInstanceCache = new HashMap(7);
    private static final Map cDateTimeInstanceCache = new HashMap(7);
    private static final Map cTimeZoneDisplayCache = new HashMap(7);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CharacterLiteral implements Rule {
        private final char mValue;

        CharacterLiteral(char c16) {
            this.mValue = c16;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        PaddedNumberField(int i3, int i16) {
            if (i16 >= 3) {
                this.mField = i3;
                this.mSize = i16;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i3) {
            int length;
            if (i3 < 100) {
                int i16 = this.mSize;
                while (true) {
                    i16--;
                    if (i16 >= 2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append((char) ((i3 / 10) + 48));
                        stringBuffer.append((char) ((i3 % 10) + 48));
                        return;
                    }
                }
            } else {
                if (i3 < 1000) {
                    length = 3;
                } else {
                    Validate.isTrue(i3 > -1, "Negative values should not be possible", i3);
                    length = Integer.toString(i3).length();
                }
                int i17 = this.mSize;
                while (true) {
                    i17--;
                    if (i17 >= length) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append(Integer.toString(i3));
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Pair {
        private final Object mObj1;
        private final Object mObj2;

        public Pair(Object obj, Object obj2) {
            this.mObj1 = obj;
            this.mObj2 = obj2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) obj;
            Object obj2 = this.mObj1;
            if (obj2 != null ? obj2.equals(pair.mObj1) : pair.mObj1 == null) {
                Object obj3 = this.mObj2;
                Object obj4 = pair.mObj2;
                if (obj3 == null) {
                    if (obj4 == null) {
                        return true;
                    }
                } else if (obj3.equals(obj4)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Object obj = this.mObj1;
            int i3 = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            Object obj2 = this.mObj2;
            if (obj2 != null) {
                i3 = obj2.hashCode();
            }
            return hashCode + i3;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            stringBuffer.append(this.mObj1);
            stringBuffer.append(':');
            stringBuffer.append(this.mObj2);
            stringBuffer.append(']');
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int i3, String[] strArr) {
            this.mField = i3;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i3 = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    int length2 = this.mValues[length].length();
                    if (length2 > i3) {
                        i3 = length2;
                    }
                } else {
                    return i3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(TimeZone timeZone, boolean z16, int i3, Locale locale) {
            this.mTimeZone = timeZone;
            this.mStyle = z16 ? i3 | Integer.MIN_VALUE : i3;
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            if (this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.mStyle * 31) + this.mLocale.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;
        private final TimeZone mTimeZone;
        private final boolean mTimeZoneForced;

        TimeZoneNameRule(TimeZone timeZone, boolean z16, Locale locale, int i3) {
            this.mTimeZone = timeZone;
            this.mTimeZoneForced = z16;
            this.mLocale = locale;
            this.mStyle = i3;
            if (z16) {
                this.mStandard = FastDateFormat.getTimeZoneDisplay(timeZone, false, i3, locale);
                this.mDaylight = FastDateFormat.getTimeZoneDisplay(timeZone, true, i3, locale);
            } else {
                this.mStandard = null;
                this.mDaylight = null;
            }
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            if (this.mTimeZoneForced) {
                if (this.mTimeZone.useDaylightTime() && calendar.get(16) != 0) {
                    stringBuffer.append(this.mDaylight);
                    return;
                } else {
                    stringBuffer.append(this.mStandard);
                    return;
                }
            }
            TimeZone timeZone = calendar.getTimeZone();
            if (timeZone.useDaylightTime() && calendar.get(16) != 0) {
                stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            } else {
                stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            }
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            if (this.mTimeZoneForced) {
                return Math.max(this.mStandard.length(), this.mDaylight.length());
            }
            if (this.mStyle == 0) {
                return 4;
            }
            return 40;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        TimeZoneNumberRule(boolean z16) {
            this.mColon = z16;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i3 = calendar.get(15) + calendar.get(16);
            if (i3 < 0) {
                stringBuffer.append('-');
                i3 = -i3;
            } else {
                stringBuffer.append('+');
            }
            int i16 = i3 / 3600000;
            stringBuffer.append((char) ((i16 / 10) + 48));
            stringBuffer.append((char) ((i16 % 10) + 48));
            if (this.mColon) {
                stringBuffer.append(':');
            }
            int i17 = (i3 / 60000) - (i16 * 60);
            stringBuffer.append((char) ((i17 / 10) + 48));
            stringBuffer.append((char) ((i17 % 10) + 48));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i3) {
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        TwoDigitNumberField(int i3) {
            this.mField = i3;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i3) {
            if (i3 < 100) {
                stringBuffer.append((char) ((i3 / 10) + 48));
                stringBuffer.append((char) ((i3 % 10) + 48));
            } else {
                stringBuffer.append(Integer.toString(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i3) {
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i3) {
            if (i3 < 10) {
                stringBuffer.append((char) (i3 + 48));
            } else {
                stringBuffer.append((char) ((i3 / 10) + 48));
                stringBuffer.append((char) ((i3 % 10) + 48));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        UnpaddedNumberField(int i3) {
            this.mField = i3;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i3) {
            if (i3 < 10) {
                stringBuffer.append((char) (i3 + 48));
            } else if (i3 < 100) {
                stringBuffer.append((char) ((i3 / 10) + 48));
                stringBuffer.append((char) ((i3 % 10) + 48));
            } else {
                stringBuffer.append(Integer.toString(i3));
            }
        }
    }

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        boolean z16;
        if (str != null) {
            this.mPattern = str;
            if (timeZone != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mTimeZoneForced = z16;
            this.mTimeZone = timeZone == null ? TimeZone.getDefault() : timeZone;
            this.mLocaleForced = locale != null;
            this.mLocale = locale == null ? Locale.getDefault() : locale;
            return;
        }
        throw new IllegalArgumentException("The pattern must not be null");
    }

    public static FastDateFormat getDateInstance(int i3) {
        return getDateInstance(i3, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int i3, int i16) {
        return getDateTimeInstance(i3, i16, null, null);
    }

    private static synchronized String getDefaultPattern() {
        String str;
        synchronized (FastDateFormat.class) {
            if (cDefaultPattern == null) {
                cDefaultPattern = new SimpleDateFormat().toPattern();
            }
            str = cDefaultPattern;
        }
        return str;
    }

    public static FastDateFormat getInstance() {
        return getInstance(getDefaultPattern(), null, null);
    }

    public static FastDateFormat getTimeInstance(int i3) {
        return getTimeInstance(i3, null, null);
    }

    static synchronized String getTimeZoneDisplay(TimeZone timeZone, boolean z16, int i3, Locale locale) {
        String str;
        synchronized (FastDateFormat.class) {
            TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z16, i3, locale);
            Map map = cTimeZoneDisplayCache;
            str = (String) map.get(timeZoneDisplayKey);
            if (str == null) {
                str = timeZone.getDisplayName(z16, i3, locale);
                map.put(timeZoneDisplayKey, str);
            }
        }
        return str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule rule : this.mRules) {
            rule.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        TimeZone timeZone;
        TimeZone timeZone2;
        Locale locale;
        Locale locale2;
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        FastDateFormat fastDateFormat = (FastDateFormat) obj;
        String str = this.mPattern;
        String str2 = fastDateFormat.mPattern;
        if ((str != str2 && !str.equals(str2)) || (((timeZone = this.mTimeZone) != (timeZone2 = fastDateFormat.mTimeZone) && !timeZone.equals(timeZone2)) || (((locale = this.mLocale) != (locale2 = fastDateFormat.mLocale) && !locale.equals(locale2)) || this.mTimeZoneForced != fastDateFormat.mTimeZoneForced || this.mLocaleForced != fastDateFormat.mLocaleForced))) {
            return false;
        }
        return true;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Unknown class: ");
        stringBuffer2.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(stringBuffer2.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public boolean getTimeZoneOverridesCalendar() {
        return this.mTimeZoneForced;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + 0 + this.mTimeZone.hashCode() + (this.mTimeZoneForced ? 1 : 0) + this.mLocale.hashCode() + (this.mLocaleForced ? 1 : 0);
    }

    protected void init() {
        List parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i3 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i3 += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i3;
                return;
            }
        }
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        parsePosition.setIndex(0);
        parsePosition.setErrorIndex(0);
        return null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0054. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0057. Please report as an issue. */
    protected List parsePattern() {
        int i3;
        Rule rule;
        Rule timeZoneNameRule;
        Rule stringLiteral;
        String[] strArr;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i16 = 0;
        int i17 = 0;
        while (i17 < length) {
            iArr[i16] = i17;
            String parseToken = parseToken(this.mPattern, iArr);
            int i18 = iArr[i16];
            int length2 = parseToken.length();
            if (length2 != 0) {
                char charAt = parseToken.charAt(i16);
                if (charAt != 'y') {
                    if (charAt != 'z') {
                        switch (charAt) {
                            case '\'':
                                String substring = parseToken.substring(1);
                                if (substring.length() == 1) {
                                    stringLiteral = new CharacterLiteral(substring.charAt(0));
                                } else {
                                    stringLiteral = new StringLiteral(substring);
                                }
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'K':
                                stringLiteral = selectNumberRule(10, length2);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'M':
                                if (length2 >= 4) {
                                    rule = new TextField(2, months);
                                } else if (length2 == 3) {
                                    rule = new TextField(2, shortMonths);
                                } else {
                                    if (length2 == 2) {
                                        stringLiteral = TwoDigitMonthField.INSTANCE;
                                    } else {
                                        stringLiteral = UnpaddedMonthField.INSTANCE;
                                    }
                                    rule = stringLiteral;
                                }
                                i3 = 0;
                                break;
                            case 'S':
                                stringLiteral = selectNumberRule(14, length2);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'W':
                                stringLiteral = selectNumberRule(4, length2);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'Z':
                                if (length2 == 1) {
                                    stringLiteral = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                } else {
                                    stringLiteral = TimeZoneNumberRule.INSTANCE_COLON;
                                }
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'a':
                                stringLiteral = new TextField(9, amPmStrings);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'd':
                                stringLiteral = selectNumberRule(5, length2);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'h':
                                stringLiteral = new TwelveHourField(selectNumberRule(10, length2));
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'k':
                                rule = new TwentyFourHourField(selectNumberRule(11, length2));
                                i3 = 0;
                                break;
                            case 'm':
                                stringLiteral = selectNumberRule(12, length2);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 's':
                                stringLiteral = selectNumberRule(13, length2);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            case 'w':
                                stringLiteral = selectNumberRule(3, length2);
                                rule = stringLiteral;
                                i3 = 0;
                                break;
                            default:
                                switch (charAt) {
                                    case 'D':
                                        stringLiteral = selectNumberRule(6, length2);
                                        rule = stringLiteral;
                                        i3 = 0;
                                        break;
                                    case 'E':
                                        if (length2 < 4) {
                                            strArr = shortWeekdays;
                                        } else {
                                            strArr = weekdays;
                                        }
                                        stringLiteral = new TextField(7, strArr);
                                        rule = stringLiteral;
                                        i3 = 0;
                                        break;
                                    case 'F':
                                        stringLiteral = selectNumberRule(8, length2);
                                        rule = stringLiteral;
                                        i3 = 0;
                                        break;
                                    case 'G':
                                        timeZoneNameRule = new TextField(0, eras);
                                        i3 = 0;
                                        rule = timeZoneNameRule;
                                        break;
                                    case 'H':
                                        stringLiteral = selectNumberRule(11, length2);
                                        rule = stringLiteral;
                                        i3 = 0;
                                        break;
                                    default:
                                        StringBuffer stringBuffer = new StringBuffer();
                                        stringBuffer.append("Illegal pattern component: ");
                                        stringBuffer.append(parseToken);
                                        throw new IllegalArgumentException(stringBuffer.toString());
                                }
                        }
                    } else if (length2 >= 4) {
                        rule = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
                        i3 = 0;
                    } else {
                        i3 = 0;
                        timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
                        rule = timeZoneNameRule;
                    }
                } else {
                    i3 = 0;
                    if (length2 >= 4) {
                        rule = selectNumberRule(1, length2);
                    } else {
                        rule = TwoDigitYearField.INSTANCE;
                    }
                }
                arrayList.add(rule);
                i17 = i18 + 1;
                i16 = i3;
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    protected String parseToken(String str, int[] iArr) {
        StrBuilder strBuilder = new StrBuilder();
        int i3 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i3);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            strBuilder.append(charAt);
            while (true) {
                int i16 = i3 + 1;
                if (i16 >= length || str.charAt(i16) != charAt) {
                    break;
                }
                strBuilder.append(charAt);
                i3 = i16;
            }
        } else {
            strBuilder.append('\'');
            boolean z16 = false;
            while (i3 < length) {
                char charAt2 = str.charAt(i3);
                if (charAt2 == '\'') {
                    int i17 = i3 + 1;
                    if (i17 < length && str.charAt(i17) == '\'') {
                        strBuilder.append(charAt2);
                        i3 = i17;
                    } else {
                        z16 = !z16;
                    }
                } else {
                    if (!z16 && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i3--;
                        break;
                    }
                    strBuilder.append(charAt2);
                }
                i3++;
            }
        }
        iArr[0] = i3;
        return strBuilder.toString();
    }

    protected NumberRule selectNumberRule(int i3, int i16) {
        if (i16 != 1) {
            if (i16 != 2) {
                return new PaddedNumberField(i3, i16);
            }
            return new TwoDigitNumberField(i3);
        }
        return new UnpaddedNumberField(i3);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FastDateFormat[");
        stringBuffer.append(this.mPattern);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static FastDateFormat getDateInstance(int i3, Locale locale) {
        return getDateInstance(i3, null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i3, int i16, Locale locale) {
        return getDateTimeInstance(i3, i16, null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return getInstance(str, null, null);
    }

    public static FastDateFormat getTimeInstance(int i3, Locale locale) {
        return getTimeInstance(i3, null, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i3 = calendar.get(10);
            if (i3 == 0) {
                i3 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, i3);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i3) {
            this.mRule.appendTo(stringBuffer, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i3 = calendar.get(11);
            if (i3 == 0) {
                i3 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, i3);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i3) {
            this.mRule.appendTo(stringBuffer, i3);
        }
    }

    public static FastDateFormat getDateInstance(int i3, TimeZone timeZone) {
        return getDateInstance(i3, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int i3, int i16, TimeZone timeZone) {
        return getDateTimeInstance(i3, i16, timeZone, null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return getInstance(str, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(int i3, TimeZone timeZone) {
        return getTimeInstance(i3, timeZone, null);
    }

    public static synchronized FastDateFormat getDateInstance(int i3, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            Object num = new Integer(i3);
            if (timeZone != null) {
                num = new Pair(num, timeZone);
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            Pair pair = new Pair(num, locale);
            Map map = cDateInstanceCache;
            fastDateFormat = (FastDateFormat) map.get(pair);
            if (fastDateFormat == null) {
                try {
                    fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getDateInstance(i3, locale)).toPattern(), timeZone, locale);
                    map.put(pair, fastDateFormat);
                } catch (ClassCastException unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("No date pattern for locale: ");
                    stringBuffer.append(locale);
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
        }
        return fastDateFormat;
    }

    public static synchronized FastDateFormat getDateTimeInstance(int i3, int i16, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            Pair pair = new Pair(new Integer(i3), new Integer(i16));
            if (timeZone != null) {
                pair = new Pair(pair, timeZone);
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            Pair pair2 = new Pair(pair, locale);
            Map map = cDateTimeInstanceCache;
            fastDateFormat = (FastDateFormat) map.get(pair2);
            if (fastDateFormat == null) {
                try {
                    fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getDateTimeInstance(i3, i16, locale)).toPattern(), timeZone, locale);
                    map.put(pair2, fastDateFormat);
                } catch (ClassCastException unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("No date time pattern for locale: ");
                    stringBuffer.append(locale);
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
        }
        return fastDateFormat;
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return getInstance(str, null, locale);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.apache.commons.lang.time.FastDateFormat$Pair] */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.apache.commons.lang.time.FastDateFormat$Pair] */
    public static synchronized FastDateFormat getTimeInstance(int i3, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            Integer num = new Integer(i3);
            if (timeZone != null) {
                num = new Pair(num, timeZone);
            }
            if (locale != null) {
                num = new Pair(num, locale);
            }
            Map map = cTimeInstanceCache;
            fastDateFormat = (FastDateFormat) map.get(num);
            if (fastDateFormat == null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                try {
                    fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getTimeInstance(i3, locale)).toPattern(), timeZone, locale);
                    map.put(num, fastDateFormat);
                } catch (ClassCastException unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("No date pattern for locale: ");
                    stringBuffer.append(locale);
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
        }
        return fastDateFormat;
    }

    public static synchronized FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            fastDateFormat = new FastDateFormat(str, timeZone, locale);
            Map map = cInstanceCache;
            FastDateFormat fastDateFormat2 = (FastDateFormat) map.get(fastDateFormat);
            if (fastDateFormat2 == null) {
                fastDateFormat.init();
                map.put(fastDateFormat, fastDateFormat);
            } else {
                fastDateFormat = fastDateFormat2;
            }
        }
        return fastDateFormat;
    }

    public String format(long j3) {
        return format(new Date(j3));
    }

    public String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone, this.mLocale);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(long j3, StringBuffer stringBuffer) {
        return format(new Date(j3), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        if (this.mTimeZoneForced) {
            calendar.getTime();
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return applyRules(calendar, stringBuffer);
    }
}
