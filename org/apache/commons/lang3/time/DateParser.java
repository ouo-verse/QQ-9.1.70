package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes29.dex */
public interface DateParser {
    Locale getLocale();

    String getPattern();

    TimeZone getTimeZone();

    Date parse(String str) throws ParseException;

    Date parse(String str, ParsePosition parsePosition);

    boolean parse(String str, ParsePosition parsePosition, Calendar calendar);

    Object parseObject(String str) throws ParseException;

    Object parseObject(String str, ParsePosition parsePosition);
}
