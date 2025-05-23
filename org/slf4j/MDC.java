package org.slf4j;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MDC {
    static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
    static MDCAdapter mdcAdapter;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MDCCloseable implements Closeable {
        private final String key;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            MDC.remove(this.key);
        }

        MDCCloseable(String str) {
            this.key = str;
        }
    }

    static {
        try {
            mdcAdapter = bwCompatibleGetMDCAdapterFromBinder();
        } catch (Exception e16) {
            Util.report("MDC binding unsuccessful.", e16);
        } catch (NoClassDefFoundError e17) {
            mdcAdapter = new NOPMDCAdapter();
            String message = e17.getMessage();
            if (message != null && message.contains("StaticMDCBinder")) {
                Util.report("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                Util.report("Defaulting to no-operation MDCAdapter implementation.");
                Util.report("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
                return;
            }
            throw e17;
        }
    }

    MDC() {
    }

    private static MDCAdapter bwCompatibleGetMDCAdapterFromBinder() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.getSingleton().getMDCA();
        } catch (NoSuchMethodError unused) {
            return StaticMDCBinder.SINGLETON.getMDCA();
        }
    }

    public static void clear() {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter != null) {
            mDCAdapter.clear();
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static String get(String str) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = mdcAdapter;
            if (mDCAdapter != null) {
                return mDCAdapter.get(str);
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static Map<String, String> getCopyOfContextMap() {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter != null) {
            return mDCAdapter.getCopyOfContextMap();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static MDCAdapter getMDCAdapter() {
        return mdcAdapter;
    }

    public static void put(String str, String str2) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = mdcAdapter;
            if (mDCAdapter != null) {
                mDCAdapter.put(str, str2);
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static MDCCloseable putCloseable(String str, String str2) throws IllegalArgumentException {
        put(str, str2);
        return new MDCCloseable(str);
    }

    public static void remove(String str) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = mdcAdapter;
            if (mDCAdapter != null) {
                mDCAdapter.remove(str);
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static void setContextMap(Map<String, String> map) {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter != null) {
            mDCAdapter.setContextMap(map);
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
}
