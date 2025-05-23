package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import cooperation.photoplus.sticker.Sticker;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();
    private static final byte[] MAGIC = {80, 75, 3, 4};

    LottieCompositionFactory() {
    }

    private static LottieTask<LottieComposition> cache(@Nullable final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            lottieComposition = LottieCompositionCache.getInstance().get(str);
        }
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.i
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult lambda$cache$8;
                    lambda$cache$8 = LottieCompositionFactory.lambda$cache$8(LottieComposition.this);
                    return lambda$cache$8;
                }
            });
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.addListener(new LottieListener() { // from class: com.airbnb.lottie.j
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.lambda$cache$9(str, atomicBoolean, (LottieComposition) obj);
                }
            });
            lottieTask.addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.k
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.lambda$cache$10(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                taskCache.put(str, lottieTask);
            }
        }
        return lottieTask;
    }

    public static void clearCache(Context context) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        L.networkCache(context).clear();
    }

    @Nullable
    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject jSONObject, @Nullable final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult fromJsonSync;
                fromJsonSync = LottieCompositionFactory.fromJsonSync(JSONObject.this, str);
                return fromJsonSync;
            }
        });
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, @Nullable final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult fromJsonInputStreamSync;
                fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
                return fromJsonInputStreamSync;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader jsonReader, @Nullable final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult fromJsonReaderSync;
                fromJsonReaderSync = LottieCompositionFactory.fromJsonReaderSync(JsonReader.this, str);
                return fromJsonReaderSync;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, @Nullable String str) {
        return fromJsonReaderSyncInternal(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, @Nullable String str, boolean z16) {
        try {
            try {
                LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, parse);
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
                if (z16) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } catch (Exception e16) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e16);
                if (z16) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th5) {
            if (z16) {
                Utils.closeQuietly(jsonReader);
            }
            throw th5;
        }
    }

    public static LottieTask<LottieComposition> fromJsonString(final String str, @Nullable final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult fromJsonStringSync;
                fromJsonStringSync = LottieCompositionFactory.fromJsonStringSync(str, str2);
                return fromJsonStringSync;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonStringSync(String str, @Nullable String str2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @WorkerThread
    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, @Nullable String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i3) {
        return fromRawRes(context, i3, rawResCacheKey(context, i3));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i3) {
        return fromRawResSync(context, i3, rawResCacheKey(context, i3));
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(final ZipInputStream zipInputStream, @Nullable final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult fromZipStreamSync;
                fromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
                return fromZipStreamSync;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(Sticker.JSON_SUFFIX)) {
                    lottieComposition = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.getImages().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e16) {
            return new LottieResult<>((Throwable) e16);
        }
    }

    private static boolean isNightMode(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b16 : MAGIC) {
                if (peek.readByte() != b16) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e16) {
            Logger.error("Failed to check zip file header", e16);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$10(String str, AtomicBoolean atomicBoolean, Throwable th5) {
        taskCache.remove(str);
        atomicBoolean.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$cache$8(LottieComposition lottieComposition) throws Exception {
        return new LottieResult(lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$9(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        taskCache.remove(str);
        atomicBoolean.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromRawRes$2(WeakReference weakReference, Context context, int i3, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromUrl$0(Context context, String str, String str2) throws Exception {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(str, str2);
        if (str2 != null && fetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    private static String rawResCacheKey(Context context, @RawRes int i3) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("rawRes");
        if (isNightMode(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb5.append(str);
        sb5.append(i3);
        return sb5.toString();
    }

    public static void setMaxCacheSize(int i3) {
        LottieCompositionCache.getInstance().resize(i3);
    }

    @WorkerThread
    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str, boolean z16) {
        try {
            return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z16) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes final int i3, @Nullable final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult lambda$fromRawRes$2;
                lambda$fromRawRes$2 = LottieCompositionFactory.lambda$fromRawRes$2(weakReference, applicationContext, i3, str);
                return lambda$fromRawRes$2;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i3, @Nullable String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i3)));
            if (isZipCompressed(buffer).booleanValue()) {
                return fromZipStreamSync(new ZipInputStream(buffer.inputStream()), str);
            }
            return fromJsonInputStreamSync(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e16) {
            return new LottieResult<>((Throwable) e16);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(final Context context, final String str, @Nullable final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult lambda$fromUrl$0;
                lambda$fromUrl$0 = LottieCompositionFactory.lambda$fromUrl$0(context, str, str2);
                return lambda$fromUrl$0;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, @Nullable String str2) {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(str, str2);
        if (str2 != null && fetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str, @Nullable final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult fromAssetSync;
                fromAssetSync = LottieCompositionFactory.fromAssetSync(applicationContext, str, str2);
                return fromAssetSync;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return fromJsonInputStreamSync(context.getAssets().open(str), str2);
            }
            return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e16) {
            return new LottieResult<>((Throwable) e16);
        }
    }
}
