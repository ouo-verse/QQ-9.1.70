package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.ExceptionUtils;

/* loaded from: classes29.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class CharacterLiteral implements Rule {
        private final char mValue;

        CharacterLiteral(char c16) {
            this.mValue = c16;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class Iso8601_Rule implements Rule {
        final int length;
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        Iso8601_Rule(int i3) {
            this.length = i3;
        }

        static Iso8601_Rule getRule(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return ISO8601_HOURS_COLON_MINUTES;
                    }
                    throw new IllegalArgumentException("invalid number of X");
                }
                return ISO8601_HOURS_MINUTES;
            }
            return ISO8601_HOURS;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i3 = calendar.get(15) + calendar.get(16);
            if (i3 == 0) {
                appendable.append("Z");
                return;
            }
            if (i3 < 0) {
                appendable.append('-');
                i3 = -i3;
            } else {
                appendable.append('+');
            }
            int i16 = i3 / 3600000;
            FastDatePrinter.appendDigits(appendable, i16);
            int i17 = this.length;
            if (i17 < 5) {
                return;
            }
            if (i17 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i3 / 60000) - (i16 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i3) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
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

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i3) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i3, this.mSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int i3, String[] strArr) {
            this.mField = i3;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
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
    /* loaded from: classes29.dex */
    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(TimeZone timeZone, boolean z16, int i3, Locale locale) {
            this.mTimeZone = timeZone;
            if (z16) {
                this.mStyle = Integer.MIN_VALUE | i3;
            } else {
                this.mStyle = i3;
            }
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
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        TimeZoneNameRule(TimeZone timeZone, Locale locale, int i3) {
            this.mLocale = locale;
            this.mStyle = i3;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i3, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i3, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        TimeZoneNumberRule(boolean z16) {
            this.mColon = z16;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i3 = calendar.get(15) + calendar.get(16);
            if (i3 < 0) {
                appendable.append('-');
                i3 = -i3;
            } else {
                appendable.append('+');
            }
            int i16 = i3 / 3600000;
            FastDatePrinter.appendDigits(appendable, i16);
            if (this.mColon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i3 / 60000) - (i16 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i3) throws IOException {
            FastDatePrinter.appendDigits(appendable, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        TwoDigitNumberField(int i3) {
            this.mField = i3;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i3) throws IOException {
            if (i3 < 100) {
                FastDatePrinter.appendDigits(appendable, i3);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i3, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i3) throws IOException {
            FastDatePrinter.appendDigits(appendable, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i3) throws IOException {
            if (i3 >= 10) {
                FastDatePrinter.appendDigits(appendable, i3);
            } else {
                appendable.append((char) (i3 + 48));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        UnpaddedNumberField(int i3) {
            this.mField = i3;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i3) throws IOException {
            if (i3 < 10) {
                appendable.append((char) (i3 + 48));
            } else if (i3 < 100) {
                FastDatePrinter.appendDigits(appendable, i3);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i3, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class WeekYear implements NumberRule {
        private final NumberRule mRule;

        WeekYear(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int weekYear;
            NumberRule numberRule = this.mRule;
            weekYear = calendar.getWeekYear();
            numberRule.appendTo(appendable, weekYear);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i3) throws IOException {
            this.mRule.appendTo(appendable, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i3) throws IOException {
        appendable.append((char) ((i3 / 10) + 48));
        appendable.append((char) ((i3 % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i3, int i16) throws IOException {
        int i17;
        if (i3 < 10000) {
            if (i3 < 1000) {
                if (i3 < 100) {
                    if (i3 < 10) {
                        i17 = 1;
                    } else {
                        i17 = 2;
                    }
                } else {
                    i17 = 3;
                }
            } else {
                i17 = 4;
            }
            for (int i18 = i16 - i17; i18 > 0; i18--) {
                appendable.append('0');
            }
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 == 4) {
                            appendable.append((char) ((i3 / 1000) + 48));
                            i3 %= 1000;
                        } else {
                            return;
                        }
                    }
                    if (i3 >= 100) {
                        appendable.append((char) ((i3 / 100) + 48));
                        i3 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i3 >= 10) {
                    appendable.append((char) ((i3 / 10) + 48));
                    i3 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i3 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i19 = 0;
        while (i3 != 0) {
            cArr[i19] = (char) ((i3 % 10) + 48);
            i3 /= 10;
            i19++;
        }
        while (i19 < i16) {
            appendable.append('0');
            i16--;
        }
        while (true) {
            i19--;
            if (i19 >= 0) {
                appendable.append(cArr[i19]);
            } else {
                return;
            }
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    static String getTimeZoneDisplay(TimeZone timeZone, boolean z16, int i3, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z16, i3, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str == null) {
            String displayName = timeZone.getDisplayName(z16, i3, locale);
            String putIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return displayName;
        }
        return str;
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
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

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Calendar) stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        if (!this.mPattern.equals(fastDatePrinter.mPattern) || !this.mTimeZone.equals(fastDatePrinter.mTimeZone) || !this.mLocale.equals(fastDatePrinter.mLocale)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
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
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Unknown class: ");
        sb5.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb5.toString());
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.mPattern;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0053. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0056. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0059. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v21, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v10, types: [org.apache.commons.lang3.time.FastDatePrinter$StringLiteral] */
    /* JADX WARN: Type inference failed for: r9v11, types: [org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral] */
    /* JADX WARN: Type inference failed for: r9v13, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v15, types: [org.apache.commons.lang3.time.FastDatePrinter$UnpaddedMonthField] */
    /* JADX WARN: Type inference failed for: r9v16, types: [org.apache.commons.lang3.time.FastDatePrinter$TwoDigitMonthField] */
    /* JADX WARN: Type inference failed for: r9v17, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v18, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v20, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v21, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v23, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v24, types: [org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField] */
    /* JADX WARN: Type inference failed for: r9v25, types: [org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField] */
    /* JADX WARN: Type inference failed for: r9v27, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v29, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v30, types: [org.apache.commons.lang3.time.FastDatePrinter$DayInWeekField] */
    /* JADX WARN: Type inference failed for: r9v32, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v36, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v41, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v42, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v44, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v45, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v46, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v49, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v5, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    /* JADX WARN: Type inference failed for: r9v50, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v51, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v6, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    protected List<Rule> parsePattern() {
        NumberRule numberRule;
        ?? stringLiteral;
        NumberRule numberRule2;
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
        int i3 = 0;
        int i16 = 0;
        while (i16 < length) {
            iArr[i3] = i16;
            String parseToken = parseToken(this.mPattern, iArr);
            int i17 = iArr[i3];
            int length2 = parseToken.length();
            if (length2 != 0) {
                char charAt = parseToken.charAt(i3);
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
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'K':
                                stringLiteral = selectNumberRule(10, length2);
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'M':
                                if (length2 >= 4) {
                                    stringLiteral = new TextField(2, months);
                                } else if (length2 == 3) {
                                    stringLiteral = new TextField(2, shortMonths);
                                } else if (length2 == 2) {
                                    stringLiteral = TwoDigitMonthField.INSTANCE;
                                } else {
                                    stringLiteral = UnpaddedMonthField.INSTANCE;
                                }
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'S':
                                stringLiteral = selectNumberRule(14, length2);
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'a':
                                stringLiteral = new TextField(9, amPmStrings);
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'd':
                                stringLiteral = selectNumberRule(5, length2);
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'h':
                                stringLiteral = new TwelveHourField(selectNumberRule(10, length2));
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'k':
                                stringLiteral = new TwentyFourHourField(selectNumberRule(11, length2));
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'm':
                                stringLiteral = selectNumberRule(12, length2);
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 's':
                                stringLiteral = selectNumberRule(13, length2);
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'u':
                                stringLiteral = new DayInWeekField(selectNumberRule(7, length2));
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            case 'w':
                                stringLiteral = selectNumberRule(3, length2);
                                numberRule2 = stringLiteral;
                                numberRule = numberRule2;
                                i3 = 0;
                                break;
                            default:
                                switch (charAt) {
                                    case 'D':
                                        stringLiteral = selectNumberRule(6, length2);
                                        numberRule2 = stringLiteral;
                                        numberRule = numberRule2;
                                        i3 = 0;
                                        break;
                                    case 'E':
                                        if (length2 < 4) {
                                            strArr = shortWeekdays;
                                        } else {
                                            strArr = weekdays;
                                        }
                                        numberRule2 = new TextField(7, strArr);
                                        numberRule = numberRule2;
                                        i3 = 0;
                                        break;
                                    case 'F':
                                        stringLiteral = selectNumberRule(8, length2);
                                        numberRule2 = stringLiteral;
                                        numberRule = numberRule2;
                                        i3 = 0;
                                        break;
                                    case 'G':
                                        i3 = 0;
                                        numberRule = new TextField(0, eras);
                                        break;
                                    case 'H':
                                        stringLiteral = selectNumberRule(11, length2);
                                        numberRule2 = stringLiteral;
                                        numberRule = numberRule2;
                                        i3 = 0;
                                        break;
                                    default:
                                        switch (charAt) {
                                            case 'W':
                                                stringLiteral = selectNumberRule(4, length2);
                                                numberRule2 = stringLiteral;
                                                numberRule = numberRule2;
                                                i3 = 0;
                                                break;
                                            case 'X':
                                                stringLiteral = Iso8601_Rule.getRule(length2);
                                                numberRule2 = stringLiteral;
                                                numberRule = numberRule2;
                                                i3 = 0;
                                                break;
                                            case 'Y':
                                                break;
                                            case 'Z':
                                                if (length2 == 1) {
                                                    stringLiteral = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                                } else if (length2 == 2) {
                                                    stringLiteral = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                                } else {
                                                    stringLiteral = TimeZoneNumberRule.INSTANCE_COLON;
                                                }
                                                numberRule2 = stringLiteral;
                                                numberRule = numberRule2;
                                                i3 = 0;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                                        }
                                }
                        }
                    } else if (length2 >= 4) {
                        numberRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                        i3 = 0;
                    } else {
                        numberRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                        i3 = 0;
                    }
                    arrayList.add(numberRule);
                    i16 = i17 + 1;
                }
                i3 = 0;
                if (length2 == 2) {
                    numberRule = TwoDigitYearField.INSTANCE;
                } else {
                    if (length2 < 4) {
                        length2 = 4;
                    }
                    numberRule = selectNumberRule(1, length2);
                }
                if (charAt == 'Y') {
                    numberRule = new WeekYear(numberRule);
                }
                arrayList.add(numberRule);
                i16 = i17 + 1;
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    protected String parseToken(String str, int[] iArr) {
        StringBuilder sb5 = new StringBuilder();
        int i3 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i3);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb5.append(charAt);
            while (true) {
                int i16 = i3 + 1;
                if (i16 >= length || str.charAt(i16) != charAt) {
                    break;
                }
                sb5.append(charAt);
                i3 = i16;
            }
        } else {
            sb5.append('\'');
            boolean z16 = false;
            while (i3 < length) {
                char charAt2 = str.charAt(i3);
                if (charAt2 == '\'') {
                    int i17 = i3 + 1;
                    if (i17 < length && str.charAt(i17) == '\'') {
                        sb5.append(charAt2);
                        i3 = i17;
                    } else {
                        z16 = !z16;
                    }
                } else {
                    if (!z16 && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i3--;
                        break;
                    }
                    sb5.append(charAt2);
                }
                i3++;
            }
        }
        iArr[0] = i3;
        return sb5.toString();
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
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i3 = calendar.get(7);
            this.mRule.appendTo(appendable, i3 != 1 ? i3 - 1 : 7);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i3) throws IOException {
            this.mRule.appendTo(appendable, i3);
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b16) {
        try {
            for (Rule rule : this.mRules) {
                rule.appendTo(b16, calendar);
            }
        } catch (IOException e16) {
            ExceptionUtils.rethrow(e16);
        }
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i3 = calendar.get(10);
            if (i3 == 0) {
                i3 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, i3);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i3) throws IOException {
            this.mRule.appendTo(appendable, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i3 = calendar.get(11);
            if (i3 == 0) {
                i3 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, i3);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i3) throws IOException {
            this.mRule.appendTo(appendable, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Unknown class: ");
        sb5.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb5.toString());
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j3) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j3);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j3, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j3);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j3, B b16) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j3);
        return (B) applyRules(newCalendar, (Calendar) b16);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b16) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (B) applyRules(newCalendar, (Calendar) b16);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b16) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return (B) applyRules(calendar, (Calendar) b16);
    }
}
