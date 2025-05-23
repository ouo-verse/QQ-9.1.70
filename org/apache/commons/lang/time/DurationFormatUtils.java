package org.apache.commons.lang.time;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";

    /* renamed from: y, reason: collision with root package name */
    static final Object f423540y = "y";
    static final Object M = "M";

    /* renamed from: d, reason: collision with root package name */
    static final Object f423537d = "d";
    static final Object H = "H";

    /* renamed from: m, reason: collision with root package name */
    static final Object f423538m = QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO;

    /* renamed from: s, reason: collision with root package name */
    static final Object f423539s = ReportConstant.COSTREPORT_PREFIX;
    static final Object S = ExifInterface.LATITUDE_SOUTH;

    static String format(Token[] tokenArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, boolean z16) {
        StrBuilder strBuilder = new StrBuilder();
        int i28 = i27;
        boolean z17 = false;
        for (Token token : tokenArr) {
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuffer) {
                strBuilder.append(value.toString());
            } else {
                if (value == f423540y) {
                    String num = Integer.toString(i3);
                    if (z16) {
                        num = StringUtils.leftPad(num, count, '0');
                    }
                    strBuilder.append(num);
                } else if (value == M) {
                    String num2 = Integer.toString(i16);
                    if (z16) {
                        num2 = StringUtils.leftPad(num2, count, '0');
                    }
                    strBuilder.append(num2);
                } else if (value == f423537d) {
                    String num3 = Integer.toString(i17);
                    if (z16) {
                        num3 = StringUtils.leftPad(num3, count, '0');
                    }
                    strBuilder.append(num3);
                } else if (value == H) {
                    String num4 = Integer.toString(i18);
                    if (z16) {
                        num4 = StringUtils.leftPad(num4, count, '0');
                    }
                    strBuilder.append(num4);
                } else if (value == f423538m) {
                    String num5 = Integer.toString(i19);
                    if (z16) {
                        num5 = StringUtils.leftPad(num5, count, '0');
                    }
                    strBuilder.append(num5);
                } else if (value == f423539s) {
                    String num6 = Integer.toString(i26);
                    if (z16) {
                        num6 = StringUtils.leftPad(num6, count, '0');
                    }
                    strBuilder.append(num6);
                    z17 = true;
                } else if (value == S) {
                    if (z17) {
                        i28 += 1000;
                        String num7 = Integer.toString(i28);
                        if (z16) {
                            num7 = StringUtils.leftPad(num7, count, '0');
                        }
                        strBuilder.append(num7.substring(1));
                    } else {
                        String num8 = Integer.toString(i28);
                        if (z16) {
                            num8 = StringUtils.leftPad(num8, count, '0');
                        }
                        strBuilder.append(num8);
                    }
                }
                z17 = false;
            }
        }
        return strBuilder.toString();
    }

    public static String formatDuration(long j3, String str) {
        return formatDuration(j3, str, true);
    }

    public static String formatDurationHMS(long j3) {
        return formatDuration(j3, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j3) {
        return formatDuration(j3, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j3, boolean z16, boolean z17) {
        String formatDuration = formatDuration(j3, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z16) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" ");
            stringBuffer.append(formatDuration);
            formatDuration = stringBuffer.toString();
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z17) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(" ");
        stringBuffer2.append(formatDuration);
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(stringBuffer2.toString(), " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j3, long j16, String str) {
        return formatPeriod(j3, j16, str, true, TimeZone.getDefault());
    }

    public static String formatPeriodISO(long j3, long j16) {
        return formatPeriod(j3, j16, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Token[] lexx(String str) {
        Object obj;
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList(charArray.length);
        boolean z16 = false;
        StringBuffer stringBuffer = null;
        Token token = null;
        for (char c16 : charArray) {
            if (z16 && c16 != '\'') {
                stringBuffer.append(c16);
            } else if (c16 != '\'') {
                if (c16 != 'H') {
                    if (c16 != 'M') {
                        if (c16 != 'S') {
                            if (c16 != 'd') {
                                if (c16 != 'm') {
                                    if (c16 != 's') {
                                        if (c16 != 'y') {
                                            if (stringBuffer == null) {
                                                stringBuffer = new StringBuffer();
                                                arrayList.add(new Token(stringBuffer));
                                            }
                                            stringBuffer.append(c16);
                                            obj = null;
                                        } else {
                                            obj = f423540y;
                                        }
                                    } else {
                                        obj = f423539s;
                                    }
                                } else {
                                    obj = f423538m;
                                }
                            } else {
                                obj = f423537d;
                            }
                        } else {
                            obj = S;
                        }
                    } else {
                        obj = M;
                    }
                } else {
                    obj = H;
                }
                if (obj != null) {
                    if (token != null && token.getValue() == obj) {
                        token.increment();
                    } else {
                        Token token2 = new Token(obj);
                        arrayList.add(token2);
                        token = token2;
                    }
                    stringBuffer = null;
                }
            } else if (z16) {
                z16 = false;
                stringBuffer = null;
                obj = null;
                if (obj != null) {
                }
            } else {
                stringBuffer = new StringBuffer();
                arrayList.add(new Token(stringBuffer));
                z16 = true;
                obj = null;
                if (obj != null) {
                }
            }
        }
        return (Token[]) arrayList.toArray(new Token[arrayList.size()]);
    }

    public static String formatDuration(long j3, String str, boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, f423537d)) {
            int i19 = (int) (j3 / 86400000);
            j3 -= i19 * 86400000;
            i3 = i19;
        } else {
            i3 = 0;
        }
        if (Token.containsTokenWithValue(lexx, H)) {
            int i26 = (int) (j3 / 3600000);
            j3 -= i26 * 3600000;
            i16 = i26;
        } else {
            i16 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f423538m)) {
            int i27 = (int) (j3 / 60000);
            j3 -= i27 * 60000;
            i17 = i27;
        } else {
            i17 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f423539s)) {
            int i28 = (int) (j3 / 1000);
            j3 -= i28 * 1000;
            i18 = i28;
        } else {
            i18 = 0;
        }
        return format(lexx, 0, 0, i3, i16, i17, i18, Token.containsTokenWithValue(lexx, S) ? (int) j3 : 0, z16);
    }

    public static String formatPeriod(long j3, long j16, String str, boolean z16, TimeZone timeZone) {
        int i3;
        int i16;
        int i17;
        Token[] lexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j3));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j16));
        int i18 = calendar2.get(14) - calendar.get(14);
        int i19 = calendar2.get(13) - calendar.get(13);
        int i26 = calendar2.get(12) - calendar.get(12);
        int i27 = calendar2.get(11) - calendar.get(11);
        int i28 = calendar2.get(5) - calendar.get(5);
        int i29 = calendar2.get(2) - calendar.get(2);
        int i36 = calendar2.get(1) - calendar.get(1);
        while (i18 < 0) {
            i18 += 1000;
            i19--;
        }
        while (i19 < 0) {
            i19 += 60;
            i26--;
        }
        while (i26 < 0) {
            i26 += 60;
            i27--;
        }
        while (i27 < 0) {
            i27 += 24;
            i28--;
        }
        int i37 = 0;
        if (Token.containsTokenWithValue(lexx, M)) {
            while (i28 < 0) {
                i28 += calendar.getActualMaximum(5);
                i29--;
                calendar.add(2, 1);
            }
            while (i29 < 0) {
                i29 += 12;
                i36--;
            }
            if (!Token.containsTokenWithValue(lexx, f423540y) && i36 != 0) {
                while (i36 != 0) {
                    i29 += i36 * 12;
                    i36 = 0;
                }
            }
            i3 = i29;
        } else {
            if (!Token.containsTokenWithValue(lexx, f423540y)) {
                int i38 = calendar2.get(1);
                if (i29 < 0) {
                    i38--;
                }
                while (calendar.get(1) != i38) {
                    int actualMaximum = i28 + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum++;
                    }
                    calendar.add(1, 1);
                    i28 = actualMaximum + calendar.get(6);
                }
                i36 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                i28 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i3 = 0;
            while (i28 < 0) {
                i28 += calendar.getActualMaximum(5);
                i3--;
                calendar.add(2, 1);
            }
        }
        int i39 = i36;
        if (Token.containsTokenWithValue(lexx, f423537d)) {
            i16 = i28;
        } else {
            i27 += i28 * 24;
            i16 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, H)) {
            i26 += i27 * 60;
            i27 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f423538m)) {
            i19 += i26 * 60;
            i26 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f423539s)) {
            i17 = i18;
            i37 = i19;
        } else {
            i17 = i18 + (i19 * 1000);
        }
        return format(lexx, i39, i3, i16, i27, i26, i37, i17, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Token {
        private int count;
        private Object value;

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuffer) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            if (obj2 != token.value) {
                return false;
            }
            return true;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }

        Token(Object obj, int i3) {
            this.value = obj;
            this.count = i3;
        }
    }
}
