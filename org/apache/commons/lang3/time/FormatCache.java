package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.Validate;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MultipartKey {
        private int hashCode;
        private final Object[] keys;

        MultipartKey(Object... objArr) {
            this.keys = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.keys, ((MultipartKey) obj).keys);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int i3 = 0;
                for (Object obj : this.keys) {
                    if (obj != null) {
                        i3 = (i3 * 7) + obj.hashCode();
                    }
                }
                this.hashCode = i3;
            }
            return this.hashCode;
        }
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return getInstance(getPatternForStyle(num, num2, locale), timeZone, locale);
    }

    static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        DateFormat dateTimeInstance;
        MultipartKey multipartKey = new MultipartKey(num, num2, locale);
        ConcurrentMap<MultipartKey, String> concurrentMap = cDateTimeInstanceCache;
        String str = concurrentMap.get(multipartKey);
        if (str == null) {
            try {
                if (num == null) {
                    dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
                } else if (num2 == null) {
                    dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
                } else {
                    dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
                }
                String pattern = ((SimpleDateFormat) dateTimeInstance).toPattern();
                String putIfAbsent = concurrentMap.putIfAbsent(multipartKey, pattern);
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
                return pattern;
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        }
        return str;
    }

    protected abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    /* JADX INFO: Access modifiers changed from: package-private */
    public F getDateInstance(int i3, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i3), (Integer) null, timeZone, locale);
    }

    public F getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public F getTimeInstance(int i3, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i3), timeZone, locale);
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        Validate.notNull(str, "pattern must not be null", new Object[0]);
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
        F f16 = this.cInstanceCache.get(multipartKey);
        if (f16 != null) {
            return f16;
        }
        F createInstance = createInstance(str, timeZone, locale);
        F putIfAbsent = this.cInstanceCache.putIfAbsent(multipartKey, createInstance);
        return putIfAbsent != null ? putIfAbsent : createInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public F getDateTimeInstance(int i3, int i16, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i3), Integer.valueOf(i16), timeZone, locale);
    }
}
