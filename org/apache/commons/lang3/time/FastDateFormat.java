package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FastDateFormat extends Format implements DateParser, DatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>() { // from class: org.apache.commons.lang3.time.FastDateFormat.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.commons.lang3.time.FormatCache
        public FastDateFormat createInstance(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    };
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    public static FastDateFormat getDateInstance(int i3) {
        return cache.getDateInstance(i3, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int i3, int i16) {
        return cache.getDateTimeInstance(i3, i16, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance() {
        return cache.getInstance();
    }

    public static FastDateFormat getTimeInstance(int i3) {
        return cache.getTimeInstance(i3, null, null);
    }

    @Deprecated
    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        return this.printer.equals(((FastDateFormat) obj).printer);
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(this.printer.format(obj));
        return stringBuffer;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.printer.getPattern();
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        return this.parser.parse(str);
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new FastDatePrinter(str, timeZone, locale);
        this.parser = new FastDateParser(str, timeZone, locale, date);
    }

    public static FastDateFormat getDateInstance(int i3, Locale locale) {
        return cache.getDateInstance(i3, null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i3, int i16, Locale locale) {
        return cache.getDateTimeInstance(i3, i16, (TimeZone) null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return cache.getInstance(str, null, null);
    }

    public static FastDateFormat getTimeInstance(int i3, Locale locale) {
        return cache.getTimeInstance(i3, null, locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j3) {
        return this.printer.format(j3);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        return this.parser.parse(str, parsePosition);
    }

    public static FastDateFormat getDateInstance(int i3, TimeZone timeZone) {
        return cache.getDateInstance(i3, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int i3, int i16, TimeZone timeZone) {
        return getDateTimeInstance(i3, i16, timeZone, null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return cache.getInstance(str, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(int i3, TimeZone timeZone) {
        return cache.getTimeInstance(i3, timeZone, null);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        return this.printer.format(date);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        return this.parser.parse(str, parsePosition, calendar);
    }

    public static FastDateFormat getDateInstance(int i3, TimeZone timeZone, Locale locale) {
        return cache.getDateInstance(i3, timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i3, int i16, TimeZone timeZone, Locale locale) {
        return cache.getDateTimeInstance(i3, i16, timeZone, locale);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return cache.getInstance(str, null, locale);
    }

    public static FastDateFormat getTimeInstance(int i3, TimeZone timeZone, Locale locale) {
        return cache.getTimeInstance(i3, timeZone, locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return cache.getInstance(str, timeZone, locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(long j3, StringBuffer stringBuffer) {
        return this.printer.format(j3, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j3, B b16) {
        return (B) this.printer.format(j3, (long) b16);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b16) {
        return (B) this.printer.format(date, (Date) b16);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b16) {
        return (B) this.printer.format(calendar, (Calendar) b16);
    }
}
