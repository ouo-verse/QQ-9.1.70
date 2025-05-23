package com.tencent.mobileqq.matchfriend.aio.background;

import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.libwxaudio.WxAudioNative;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/e;", "", "", WadlProxyConsts.PARAM_FILENAME, "c", "Ljava/io/File;", QzoneZipCacheHelper.DIR, "", "e", "url", "b", "a", "d", "Ljava/lang/String;", WxAudioNative.NativeCallBackInterface.KEY_GET_FILE_PATH_CACHE_DIR, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "memoryCache", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f243823a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String CACHE_DIR = com.tencent.mobileqq.matchfriend.aio.utils.a.f243984a.c() + "/pag_cache/";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, String> memoryCache = new HashMap<>();

    e() {
    }

    private final String b(String url) {
        String sb5 = new StringBuilder(MD5Coding.encodeHexStr(url)).toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "sb.toString()");
        return sb5;
    }

    private final String c(String fileName) {
        File file = new File(CACHE_DIR);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        if (f243823a.e(file, fileName)) {
            return new File(file, fileName).getAbsolutePath();
        }
        return null;
    }

    private final boolean e(File dir, String fileName) {
        File file = new File(dir, fileName);
        return file.isFile() && file.exists();
    }

    public final boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String b16 = b(url);
        HashMap<String, String> hashMap = memoryCache;
        if (hashMap.containsKey(b16)) {
            return true;
        }
        String c16 = c(b(url));
        if (c16 == null) {
            return false;
        }
        Intrinsics.areEqual(hashMap.get(b16), c16);
        return true;
    }

    public final File d(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new File(CACHE_DIR, b(url));
    }
}
