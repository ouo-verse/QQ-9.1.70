package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import java.io.File;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class L {
    public static boolean DBG = false;
    private static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    private static LottieNetworkCacheProvider cacheProvider = null;
    private static int depthPastMaxDepth = 0;
    private static LottieNetworkFetcher fetcher = null;
    private static volatile NetworkCache networkCache = null;
    private static volatile NetworkFetcher networkFetcher = null;
    private static String[] sections = null;
    private static long[] startTimeNs = null;
    private static int traceDepth = 0;
    private static boolean traceEnabled = false;

    L() {
    }

    public static void beginSection(String str) {
        if (!traceEnabled) {
            return;
        }
        int i3 = traceDepth;
        if (i3 == 20) {
            depthPastMaxDepth++;
            return;
        }
        sections[i3] = str;
        startTimeNs[i3] = System.nanoTime();
        TraceCompat.beginSection(str);
        traceDepth++;
    }

    public static float endSection(String str) {
        int i3 = depthPastMaxDepth;
        if (i3 > 0) {
            depthPastMaxDepth = i3 - 1;
            return 0.0f;
        }
        if (!traceEnabled) {
            return 0.0f;
        }
        int i16 = traceDepth - 1;
        traceDepth = i16;
        if (i16 != -1) {
            if (str.equals(sections[i16])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - startTimeNs[traceDepth])) / 1000000.0f;
            }
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + sections[traceDepth] + ".");
        }
        throw new IllegalStateException("Can't end trace section. There are none.");
    }

    @NonNull
    public static NetworkCache networkCache(@NonNull Context context) {
        final Context applicationContext = context.getApplicationContext();
        NetworkCache networkCache2 = networkCache;
        if (networkCache2 == null) {
            synchronized (NetworkCache.class) {
                networkCache2 = networkCache;
                if (networkCache2 == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = cacheProvider;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new LottieNetworkCacheProvider() { // from class: com.airbnb.lottie.L.1
                            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
                            @NonNull
                            public File getCacheDir() {
                                return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    networkCache2 = new NetworkCache(lottieNetworkCacheProvider);
                    networkCache = networkCache2;
                }
            }
        }
        return networkCache2;
    }

    @NonNull
    public static NetworkFetcher networkFetcher(@NonNull Context context) {
        NetworkFetcher networkFetcher2 = networkFetcher;
        if (networkFetcher2 == null) {
            synchronized (NetworkFetcher.class) {
                networkFetcher2 = networkFetcher;
                if (networkFetcher2 == null) {
                    NetworkCache networkCache2 = networkCache(context);
                    LottieNetworkFetcher lottieNetworkFetcher = fetcher;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new DefaultLottieNetworkFetcher();
                    }
                    networkFetcher2 = new NetworkFetcher(networkCache2, lottieNetworkFetcher);
                    networkFetcher = networkFetcher2;
                }
            }
        }
        return networkFetcher2;
    }

    public static void setCacheProvider(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        cacheProvider = lottieNetworkCacheProvider;
    }

    public static void setFetcher(LottieNetworkFetcher lottieNetworkFetcher) {
        fetcher = lottieNetworkFetcher;
    }

    public static void setTraceEnabled(boolean z16) {
        if (traceEnabled == z16) {
            return;
        }
        traceEnabled = z16;
        if (z16) {
            sections = new String[20];
            startTimeNs = new long[20];
        }
    }
}
