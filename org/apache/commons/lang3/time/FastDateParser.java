package org.apache.commons.lang3.time;

import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes29.dex */
public class FastDateParser implements DateParser, Serializable {
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    private transient List<StrategyAndWidth> patterns;
    private final int startYear;
    private final TimeZone timeZone;
    static final Locale JAPANESE_IMPERIAL = new Locale(LocaleUtils.L_JAPANESE, "JP", "JP");
    private static final Comparator<String> LONGER_FIRST_LOWERCASE = new Comparator<String>() { // from class: org.apache.commons.lang3.time.FastDateParser.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    };
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) { // from class: org.apache.commons.lang3.time.FastDateParser.2
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        int modify(FastDateParser fastDateParser, int i3) {
            if (i3 < 100) {
                return fastDateParser.adjustYear(i3);
            }
            return i3;
        }
    };
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) { // from class: org.apache.commons.lang3.time.FastDateParser.3
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        int modify(FastDateParser fastDateParser, int i3) {
            return i3 - 1;
        }
    };
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) { // from class: org.apache.commons.lang3.time.FastDateParser.4
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        int modify(FastDateParser fastDateParser, int i3) {
            if (i3 == 7) {
                return 1;
            }
            return 1 + i3;
        }
    };
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) { // from class: org.apache.commons.lang3.time.FastDateParser.5
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        int modify(FastDateParser fastDateParser, int i3) {
            if (i3 == 24) {
                return 0;
            }
            return i3;
        }
    };
    private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10) { // from class: org.apache.commons.lang3.time.FastDateParser.6
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        int modify(FastDateParser fastDateParser, int i3) {
            if (i3 == 12) {
                return 0;
            }
            return i3;
        }
    };
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class CaseInsensitiveTextStrategy extends PatternStrategy {
        private final int field;
        private final Map<String, Integer> lKeyValues;
        final Locale locale;

        CaseInsensitiveTextStrategy(int i3, Calendar calendar, Locale locale) {
            super();
            this.field = i3;
            this.locale = locale;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale, i3, sb5);
            sb5.setLength(sb5.length() - 1);
            sb5.append(")");
            createPattern(sb5);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            String lowerCase = str.toLowerCase(this.locale);
            Integer num = this.lKeyValues.get(lowerCase);
            if (num == null) {
                num = this.lKeyValues.get(lowerCase + '.');
            }
            calendar.set(this.field, num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean isNumber() {
            return false;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i3) {
            for (int i16 = 0; i16 < this.formatField.length(); i16++) {
                int index = parsePosition.getIndex() + i16;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
                if (this.formatField.charAt(i16) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
            }
            parsePosition.setIndex(this.formatField.length() + parsePosition.getIndex());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class ISO8601TimeZoneStrategy extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        private static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        ISO8601TimeZoneStrategy(String str) {
            super();
            createPattern(str);
        }

        static Strategy getStrategy(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return ISO_8601_3_STRATEGY;
                    }
                    throw new IllegalArgumentException("invalid number of X");
                }
                return ISO_8601_2_STRATEGY;
            }
            return ISO_8601_1_STRATEGY;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.setTimeZone(FastTimeZone.getGmtTimeZone(str));
        }
    }

    /* loaded from: classes29.dex */
    private static abstract class PatternStrategy extends Strategy {
        private Pattern pattern;

        PatternStrategy() {
            super();
        }

        void createPattern(StringBuilder sb5) {
            createPattern(sb5.toString());
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean isNumber() {
            return false;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i3) {
            Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
            setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }

        abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        void createPattern(String str) {
            this.pattern = Pattern.compile(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static abstract class Strategy {
        Strategy() {
        }

        boolean isNumber() {
            return false;
        }

        abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        StrategyAndWidth(Strategy strategy, int i3) {
            this.strategy = strategy;
            this.width = i3;
        }

        int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (!this.strategy.isNumber() || !listIterator.hasNext()) {
                return 0;
            }
            Strategy strategy = listIterator.next().strategy;
            listIterator.previous();
            if (!strategy.isNumber()) {
                return 0;
            }
            return this.width;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public class StrategyParser {
        private int currentIdx;
        private final Calendar definingCalendar;

        StrategyParser(Calendar calendar) {
            this.definingCalendar = calendar;
        }

        private StrategyAndWidth letterPattern(char c16) {
            int i3 = this.currentIdx;
            do {
                int i16 = this.currentIdx + 1;
                this.currentIdx = i16;
                if (i16 >= FastDateParser.this.pattern.length()) {
                    break;
                }
            } while (FastDateParser.this.pattern.charAt(this.currentIdx) == c16);
            int i17 = this.currentIdx - i3;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c16, i17, this.definingCalendar), i17);
        }

        private StrategyAndWidth literal() {
            StringBuilder sb5 = new StringBuilder();
            boolean z16 = false;
            while (this.currentIdx < FastDateParser.this.pattern.length()) {
                char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
                if (!z16 && FastDateParser.isFormatLetter(charAt)) {
                    break;
                }
                if (charAt == '\'') {
                    int i3 = this.currentIdx + 1;
                    this.currentIdx = i3;
                    if (i3 == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'') {
                        z16 = !z16;
                    }
                }
                this.currentIdx++;
                sb5.append(charAt);
            }
            if (!z16) {
                String sb6 = sb5.toString();
                return new StrategyAndWidth(new CopyQuotedStrategy(sb6), sb6.length());
            }
            throw new IllegalArgumentException("Unterminated quote");
        }

        StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
            if (FastDateParser.isFormatLetter(charAt)) {
                return letterPattern(charAt);
            }
            return literal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static class TimeZoneStrategy extends PatternStrategy {
        private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";
        private static final int ID = 0;
        private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        private final Locale locale;
        private final Map<String, TzInfo> tzNames;

        /* loaded from: classes29.dex */
        private static class TzInfo {
            int dstOffset;
            TimeZone zone;

            TzInfo(TimeZone timeZone, boolean z16) {
                int i3;
                this.zone = timeZone;
                if (z16) {
                    i3 = timeZone.getDSTSavings();
                } else {
                    i3 = 0;
                }
                this.dstOffset = i3;
            }
        }

        TimeZoneStrategy(Locale locale) {
            super();
            this.tzNames = new HashMap();
            this.locale = locale;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase("GMT")) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i3 = 1; i3 < strArr.length; i3++) {
                        if (i3 != 3) {
                            if (i3 == 5) {
                                tzInfo2 = tzInfo;
                            }
                        } else {
                            tzInfo2 = new TzInfo(timeZone, true);
                        }
                        String str2 = strArr[i3];
                        if (str2 != null) {
                            String lowerCase = str2.toLowerCase(locale);
                            if (treeSet.add(lowerCase)) {
                                this.tzNames.put(lowerCase, tzInfo2);
                            }
                        }
                    }
                }
            }
            for (String str3 : treeSet) {
                sb5.append(QbAddrData.DATA_SPLITER);
                FastDateParser.simpleQuote(sb5, str3);
            }
            sb5.append(")");
            createPattern(sb5);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone(str);
            if (gmtTimeZone != null) {
                calendar.setTimeZone(gmtTimeZone);
                return;
            }
            String lowerCase = str.toLowerCase(this.locale);
            TzInfo tzInfo = this.tzNames.get(lowerCase);
            if (tzInfo == null) {
                tzInfo = this.tzNames.get(lowerCase + '.');
            }
            calendar.set(16, tzInfo.dstOffset);
            calendar.set(15, tzInfo.zone.getRawOffset());
        }
    }

    protected FastDateParser(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int adjustYear(int i3) {
        int i16 = this.century + i3;
        if (i3 < this.startYear) {
            return i16 + 100;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale, int i3, StringBuilder sb5) {
        HashMap hashMap = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i3, 0, locale);
        TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
            String lowerCase = entry.getKey().toLowerCase(locale);
            if (treeSet.add(lowerCase)) {
                hashMap.put(lowerCase, entry.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            simpleQuote(sb5, (String) it.next()).append(QbAddrData.DATA_SPLITER);
        }
        return hashMap;
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int i3) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            if (concurrentMapArr[i3] == null) {
                concurrentMapArr[i3] = new ConcurrentHashMap(3);
            }
            concurrentMap = concurrentMapArr[i3];
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(int i3, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i3);
        Strategy strategy = cache.get(this.locale);
        if (strategy == null) {
            if (i3 == 15) {
                strategy = new TimeZoneStrategy(this.locale);
            } else {
                strategy = new CaseInsensitiveTextStrategy(i3, calendar, this.locale);
            }
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000c. Please report as an issue. */
    public Strategy getStrategy(char c16, int i3, Calendar calendar) {
        if (c16 != 'y') {
            if (c16 != 'z') {
                switch (c16) {
                    case 'D':
                        return DAY_OF_YEAR_STRATEGY;
                    case 'E':
                        return getLocaleSpecificStrategy(7, calendar);
                    case 'F':
                        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                    case 'G':
                        return getLocaleSpecificStrategy(0, calendar);
                    case 'H':
                        return HOUR_OF_DAY_STRATEGY;
                    default:
                        switch (c16) {
                            case 'K':
                                return HOUR_STRATEGY;
                            case 'M':
                                if (i3 >= 3) {
                                    return getLocaleSpecificStrategy(2, calendar);
                                }
                                return NUMBER_MONTH_STRATEGY;
                            case 'S':
                                return MILLISECOND_STRATEGY;
                            case 'a':
                                return getLocaleSpecificStrategy(9, calendar);
                            case 'd':
                                return DAY_OF_MONTH_STRATEGY;
                            case 'h':
                                return HOUR12_STRATEGY;
                            case 'k':
                                return HOUR24_OF_DAY_STRATEGY;
                            case 'm':
                                return MINUTE_STRATEGY;
                            case 's':
                                return SECOND_STRATEGY;
                            case 'u':
                                return DAY_OF_WEEK_STRATEGY;
                            case 'w':
                                return WEEK_OF_YEAR_STRATEGY;
                            default:
                                switch (c16) {
                                    case 'W':
                                        return WEEK_OF_MONTH_STRATEGY;
                                    case 'X':
                                        return ISO8601TimeZoneStrategy.getStrategy(i3);
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i3 == 2) {
                                            return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Format '" + c16 + "' not supported");
                                }
                        }
                }
            }
            return getLocaleSpecificStrategy(15, calendar);
        }
        if (i3 > 2) {
            return LITERAL_YEAR_STRATEGY;
        }
        return ABBREVIATED_YEAR_STRATEGY;
    }

    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy == null) {
                return;
            } else {
                this.patterns.add(nextStrategy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFormatLetter(char c16) {
        if ((c16 >= 'A' && c16 <= 'Z') || (c16 >= 'a' && c16 <= 'z')) {
            return true;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StringBuilder simpleQuote(StringBuilder sb5, String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt != '$' && charAt != '.' && charAt != '?' && charAt != '^' && charAt != '[' && charAt != '\\' && charAt != '{' && charAt != '|') {
                switch (charAt) {
                }
                sb5.append(charAt);
            }
            sb5.append('\\');
            sb5.append(charAt);
        }
        if (sb5.charAt(sb5.length() - 1) == '.') {
            sb5.append('?');
        }
        return sb5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        if (!this.pattern.equals(fastDateParser.pattern) || !this.timeZone.equals(fastDateParser.timeZone) || !this.locale.equals(fastDateParser.locale)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(str, parsePosition);
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + str, parsePosition.getErrorIndex());
        }
        throw new ParseException("Unparseable date: " + str, parsePosition.getErrorIndex());
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FastDateParser(String str, TimeZone timeZone, Locale locale, Date date) {
        int i3;
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i3 = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i3 = 0;
        } else {
            calendar.setTime(new Date());
            i3 = calendar.get(1) - 80;
        }
        int i16 = (i3 / 100) * 100;
        this.century = i16;
        this.startYear = i3 - i16;
        init(calendar);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        if (parse(str, parsePosition, calendar)) {
            return calendar.getTime();
        }
        return null;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth next = listIterator.next();
            if (!next.strategy.parse(this, calendar, str, parsePosition, next.getMaxWidth(listIterator))) {
                return false;
            }
        }
        return true;
    }

    /* loaded from: classes29.dex */
    private static class NumberStrategy extends Strategy {
        private final int field;

        NumberStrategy(int i3) {
            super();
            this.field = i3;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean isNumber() {
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i3) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i3 == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i16 = i3 + index;
                if (length > i16) {
                    length = i16;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int parseInt = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.field, modify(fastDateParser, parseInt));
            return true;
        }

        int modify(FastDateParser fastDateParser, int i3) {
            return i3;
        }
    }
}
