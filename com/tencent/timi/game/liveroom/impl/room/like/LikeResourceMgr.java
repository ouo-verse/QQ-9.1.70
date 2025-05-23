package com.tencent.timi.game.liveroom.impl.room.like;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0004J \u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR,\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikeResourceMgr;", "", "", "isResExpired", "", "key", "url", "", "downloadRes", "filename", "", "reqWidthPx", "reqHeightPx", "Landroid/graphics/Bitmap;", "decodeFromFile", "Luq4/f;", "likeResource", "initLikeResource", "release", "getRandomLikeResId", "likeResId", "getLikeResBitmap", "TAG", "Ljava/lang/String;", "KEY_FORMAT", "", "keyList", "Ljava/util/List;", "", "Lkotlin/Pair;", "localPathMap", "Ljava/util/Map;", "Ljava/util/concurrent/ConcurrentHashMap;", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Luq4/f;", "Lkotlin/random/Random$Default;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lkotlin/random/Random$Default;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LikeResourceMgr {

    @NotNull
    private static final String KEY_FORMAT = "m%s_%d";

    @NotNull
    private static final String TAG = "Like_Biz|LikeResourceMgr";

    @Nullable
    private static uq4.f likeResource;

    @NotNull
    public static final LikeResourceMgr INSTANCE = new LikeResourceMgr();

    @NotNull
    private static final List<String> keyList = new ArrayList();

    @NotNull
    private static final Map<String, Pair<String, String>> localPathMap = new LinkedHashMap();

    @NotNull
    private static final ConcurrentHashMap<String, Bitmap> bitmapCache = new ConcurrentHashMap<>();

    @NotNull
    private static final Random.Companion random = Random.INSTANCE;

    LikeResourceMgr() {
    }

    private final Bitmap decodeFromFile(String filename, int reqWidthPx, int reqHeightPx) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);
        options.inSampleSize = BaseImageUtil.calculateInSampleSize(options, reqWidthPx, reqHeightPx);
        options.inJustDecodeBounds = false;
        try {
            try {
                return BitmapFactory.decodeFile(filename, options);
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e(TAG, "decodeFromFile", "exception:" + e16 + ", filename:" + filename);
                return null;
            }
        } catch (OutOfMemoryError unused) {
            options.inSampleSize *= 2;
            return BitmapFactory.decodeFile(filename, options);
        }
    }

    private final void downloadRes(final String key, final String url) {
        QCircleFeedPicLoader.g().getPicLoader().download(Option.obtain().setUrl(url).setPredecode(false), new IPicLoadStateListener() { // from class: com.tencent.timi.game.liveroom.impl.room.like.f
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                LikeResourceMgr.downloadRes$lambda$3(key, url, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadRes$lambda$3(String key, String url, LoadState loadState, Option option) {
        String str;
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(url, "$url");
        boolean z16 = false;
        if (loadState != null && loadState.isDownloadSuccess()) {
            z16 = true;
        }
        if (z16) {
            keyList.add(key);
            Map<String, Pair<String, String>> map = localPathMap;
            if (!map.containsKey(key)) {
                String str2 = null;
                if (option != null) {
                    str = option.getLocalPath();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                map.put(key, new Pair<>(url, str));
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (option != null) {
                    str2 = option.getLocalPath();
                }
                companion.i(TAG, "success url:" + url + ", localPath:" + str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLikeResBitmap$lambda$1(String localPath, int i3, int i16) {
        Intrinsics.checkNotNullParameter(localPath, "$localPath");
        Bitmap decodeFromFile = INSTANCE.decodeFromFile(localPath, i3, i16);
        if (decodeFromFile == null) {
            return;
        }
        bitmapCache.put(localPath, decodeFromFile);
    }

    private final boolean isResExpired() {
        uq4.f fVar = likeResource;
        if (fVar == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis < fVar.f439847c || fVar.f439848d < currentTimeMillis) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Bitmap getLikeResBitmap(@NotNull String likeResId, final int reqWidthPx, final int reqHeightPx) {
        final String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(likeResId, "likeResId");
        Map<String, Pair<String, String>> map = localPathMap;
        if (!map.containsKey(likeResId)) {
            return null;
        }
        Pair<String, String> pair = map.get(likeResId);
        if (pair == null || (str = pair.getSecond()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        ConcurrentHashMap<String, Bitmap> concurrentHashMap = bitmapCache;
        if (concurrentHashMap.get(str) != null) {
            return concurrentHashMap.get(str);
        }
        if (new File(str).exists()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.e
                @Override // java.lang.Runnable
                public final void run() {
                    LikeResourceMgr.getLikeResBitmap$lambda$1(str, reqWidthPx, reqHeightPx);
                }
            }, 16, null, true);
        }
        return null;
    }

    @NotNull
    public final String getRandomLikeResId() {
        if (isResExpired()) {
            return "";
        }
        Random.Companion companion = random;
        List<String> list = keyList;
        return list.get(companion.nextInt(0, list.size()));
    }

    public final void initLikeResource(@NotNull uq4.f likeResource2) {
        boolean z16;
        Intrinsics.checkNotNullParameter(likeResource2, "likeResource");
        AegisLogger.INSTANCE.i(TAG, "initLikeResource", String.valueOf(likeResource2));
        likeResource = likeResource2;
        String[] strArr = likeResource2.f439846b;
        if (strArr != null) {
            int length = strArr.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                String url = strArr[i3];
                int i17 = i16 + 1;
                Intrinsics.checkNotNullExpressionValue(url, "url");
                if (url.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(KEY_FORMAT, Arrays.copyOf(new Object[]{likeResource2.f439845a, Integer.valueOf(i16)}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    INSTANCE.downloadRes(format, url);
                }
                i3++;
                i16 = i17;
            }
        }
    }

    public final void release() {
        likeResource = null;
        keyList.clear();
        localPathMap.clear();
        bitmapCache.clear();
    }
}
