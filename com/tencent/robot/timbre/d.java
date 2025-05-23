package com.tencent.robot.timbre;

import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.libwxaudio.WxAudioNative;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/timbre/d;", "", "", WadlProxyConsts.PARAM_FILENAME, "b", "Ljava/io/File;", QzoneZipCacheHelper.DIR, "", "e", "url", "ttsTimbreId", "d", "a", "path", "", "f", "Ljava/lang/String;", "c", "()Ljava/lang/String;", WxAudioNative.NativeCallBackInterface.KEY_GET_FILE_PATH_CACHE_DIR, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "memoryCache", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f368605a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CACHE_DIR = MobileQQ.sMobileQQ.getCacheDir().getAbsoluteFile() + "/tts_timbre_cache/";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> memoryCache = new HashMap<>();

    d() {
    }

    private final String b(String fileName) {
        File file = new File(CACHE_DIR);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        if (!f368605a.e(file, fileName)) {
            return null;
        }
        return new File(file, fileName).getAbsolutePath();
    }

    private final boolean e(File dir, String fileName) {
        File file;
        boolean z16;
        File[] listFiles = dir.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "dir.listFiles()");
        int length = listFiles.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                file = listFiles[i3];
                if (file.isFile() && Intrinsics.areEqual(file.getName(), fileName)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                file = null;
                break;
            }
        }
        if (file == null) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String a(@NotNull String url, @NotNull String ttsTimbreId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ttsTimbreId, "ttsTimbreId");
        StringBuilder sb5 = new StringBuilder(MD5Coding.encodeHexStr(url));
        if (ttsTimbreId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            sb5.append("_timbre_id_");
            sb5.append(ttsTimbreId);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @NotNull
    public final String c() {
        return CACHE_DIR;
    }

    @Nullable
    public final String d(@NotNull String url, @NotNull String ttsTimbreId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ttsTimbreId, "ttsTimbreId");
        String a16 = a(url, ttsTimbreId);
        HashMap<String, String> hashMap = memoryCache;
        if (hashMap.containsKey(a16)) {
            return hashMap.get(a16);
        }
        String b16 = b(a16);
        if (b16 != null) {
            Intrinsics.areEqual(hashMap.get(a16), b16);
            return b16;
        }
        return null;
    }

    public final void f(@NotNull String url, @NotNull String ttsTimbreId, @NotNull String path) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ttsTimbreId, "ttsTimbreId");
        Intrinsics.checkNotNullParameter(path, "path");
        memoryCache.put(a(url, ttsTimbreId), path);
    }
}
