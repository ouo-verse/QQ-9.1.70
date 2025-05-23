package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class NetworkFetcher {

    @NonNull
    private final LottieNetworkFetcher fetcher;

    @NonNull
    private final NetworkCache networkCache;

    public NetworkFetcher(@NonNull NetworkCache networkCache, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache;
        this.fetcher = lottieNetworkFetcher;
    }

    @Nullable
    @WorkerThread
    private LottieComposition fetchFromCache(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> fetch;
        LottieResult<LottieComposition> fromJsonInputStreamSync;
        if (str2 == null || (fetch = this.networkCache.fetch(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) fetch.first;
        InputStream inputStream = (InputStream) fetch.second;
        if (fileExtension == FileExtension.ZIP) {
            fromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), str);
        } else {
            fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
        }
        if (fromJsonInputStreamSync.getValue() == null) {
            return null;
        }
        return fromJsonInputStreamSync.getValue();
    }

    @NonNull
    @WorkerThread
    private LottieResult<LottieComposition> fetchFromNetwork(@NonNull String str, @Nullable String str2) {
        boolean z16;
        Logger.debug("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult fetchSync = this.fetcher.fetchSync(str);
                if (fetchSync.isSuccessful()) {
                    LottieResult<LottieComposition> fromInputStream = fromInputStream(str, fetchSync.bodyByteStream(), fetchSync.contentType(), str2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Completed fetch from network. Success: ");
                    if (fromInputStream.getValue() != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    Logger.debug(sb5.toString());
                    try {
                        fetchSync.close();
                    } catch (IOException e16) {
                        Logger.warning("LottieFetchResult close failed ", e16);
                    }
                    return fromInputStream;
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(new IllegalArgumentException(fetchSync.error()));
                try {
                    fetchSync.close();
                } catch (IOException e17) {
                    Logger.warning("LottieFetchResult close failed ", e17);
                }
                return lottieResult;
            } catch (Exception e18) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e18);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e19) {
                        Logger.warning("LottieFetchResult close failed ", e19);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e26) {
                    Logger.warning("LottieFetchResult close failed ", e26);
                }
            }
            throw th5;
        }
    }

    @NonNull
    private LottieResult<LottieComposition> fromInputStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> fromZipStream;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            fromZipStream = fromJsonStream(str, inputStream, str3);
        } else {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            fromZipStream = fromZipStream(str, inputStream, str3);
        }
        if (str3 != null && fromZipStream.getValue() != null) {
            this.networkCache.renameTempFile(str, fileExtension);
        }
        return fromZipStream;
    }

    @NonNull
    private LottieResult<LottieComposition> fromJsonStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(this.networkCache.writeTempCacheFile(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    private LottieResult<LottieComposition> fromZipStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), null);
        }
        return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(str, inputStream, FileExtension.ZIP))), str);
    }

    @NonNull
    @WorkerThread
    public LottieResult<LottieComposition> fetchSync(@NonNull String str, @Nullable String str2) {
        LottieComposition fetchFromCache = fetchFromCache(str, str2);
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return fetchFromNetwork(str, str2);
    }
}
