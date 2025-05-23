package com.tencent.filament.zplan.avatar;

import android.net.http.Headers;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ark.ark;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.engine.js.FilamentMD5Util;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import dl0.j;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010.JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J>\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J>\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u000e\u0010\u0016\u001a\u00020\u0015*\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/filament/zplan/avatar/ZPlanAvatarDownloader;", "", "", "url", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "etagCacheFilePath", "Lgl0/a;", "listener", "", "j", "l", "k", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "Lorg/json/JSONObject;", "", DomainData.DOMAIN_NAME, "e", h.F, Headers.ETAG, "o", "Lcom/tencent/filament/zplan/avatar/d;", "i", "Ldl0/b;", "a", "Ldl0/b;", QDLog.TAG_DOWNLOAD, "Ldl0/j;", "b", "Ldl0/j;", "threadPoolProxy", "c", "Ljava/lang/String;", "tmpDir", "Ljava/util/concurrent/locks/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "etagFileLock", "cacheDir", "<init>", "(Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarDownloader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final dl0.b downloader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final j threadPoolProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String tmpDir;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock etagFileLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String cacheDir;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/avatar/ZPlanAvatarDownloader$b", "Lcom/tencent/filament/zplan/avatar/d;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f105640b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ gl0.a f105641c;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplan/avatar/ZPlanAvatarDownloader$b$a", "Lgl0/a;", "", "errorMsg", "", "b", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes6.dex */
        public static final class a implements gl0.a {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f105643b;

            a(String str) {
                this.f105643b = str;
            }

            @Override // gl0.a
            public void a(@Nullable String filePath, int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
                FLog.INSTANCE.i("ZPlanAvatarDownloader", "download end. url: " + b.this.f105640b + ", statusCode: " + statusCode);
                b bVar = b.this;
                ZPlanAvatarDownloader.this.j(bVar.f105640b, filePath, statusCode, rspHeader, this.f105643b, bVar.f105641c);
            }

            @Override // gl0.a
            public void b(@NotNull String errorMsg) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                FLog.INSTANCE.e("ZPlanAvatarDownloader", "download fail. errorMsg: " + errorMsg + ", url: " + b.this.f105640b);
                b.this.f105641c.b(errorMsg);
            }
        }

        b(String str, gl0.a aVar) {
            this.f105640b = str;
            this.f105641c = aVar;
        }

        @Override // com.tencent.filament.zplan.avatar.d
        public void a(@Nullable JSONObject json) {
            String str;
            String str2;
            boolean z16;
            Map<String, String> map = null;
            if (json != null) {
                str = json.optString(Headers.ETAG);
            } else {
                str = null;
            }
            if (json != null) {
                str2 = json.optString("filepath");
            } else {
                str2 = null;
            }
            if (str != null && str2 != null && new File(str2).exists()) {
                map = MapsKt__MapsJVMKt.mapOf(new Pair("If-None-Match", '\"' + str + '\"'));
            } else {
                if (str2 != null) {
                    z16 = new File(str2).exists();
                } else {
                    z16 = false;
                }
                FLog.INSTANCE.i("ZPlanAvatarDownloader", "download etag is null. url: " + this.f105640b + ", etag: " + str + ", etagCacheFilePath: " + str2 + ", fileExist:" + z16);
            }
            FLog.INSTANCE.i("ZPlanAvatarDownloader", "download start. url: " + this.f105640b);
            dl0.b bVar = ZPlanAvatarDownloader.this.downloader;
            if (bVar != null) {
                bVar.a(this.f105640b, map, new a(str2));
            }
        }
    }

    public ZPlanAvatarDownloader(@NotNull String cacheDir) {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        this.cacheDir = cacheDir;
        fl0.a aVar = fl0.a.f399763a;
        this.downloader = (dl0.b) aVar.a(dl0.b.class);
        this.threadPoolProxy = (j) aVar.a(j.class);
        this.tmpDir = FilamentFileUtil.INSTANCE.pathAppend(cacheDir, "tmp");
        this.etagFileLock = new ReentrantLock();
    }

    private final String f() {
        return FilamentFileUtil.INSTANCE.pathAppend(this.tmpDir, m());
    }

    private final String g(String url) {
        String b16 = new com.tencent.filament.zplanservice.util.a(url).b();
        if (b16 != null) {
            url = b16;
        }
        String md5 = FilamentMD5Util.md5(url);
        if (md5 != null) {
            String substring = md5.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String substring2 = md5.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            return FilamentFileUtil.INSTANCE.pathAppend(this.cacheDir, substring + '/' + substring2);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String url, String filePath, int statusCode, Map<String, ? extends List<String>> rspHeader, String etagCacheFilePath, gl0.a listener) {
        if (statusCode != 200) {
            if (statusCode != 304) {
                listener.a(etagCacheFilePath, statusCode, rspHeader);
                return;
            } else {
                k(url, etagCacheFilePath, rspHeader, listener);
                return;
            }
        }
        l(url, filePath, rspHeader, listener);
    }

    private final void k(String url, String etagCacheFilePath, Map<String, ? extends List<String>> rspHeader, gl0.a listener) {
        if (etagCacheFilePath != null && new File(etagCacheFilePath).exists()) {
            listener.a(etagCacheFilePath, 304, rspHeader);
            return;
        }
        FLog.INSTANCE.e("ZPlanAvatarDownloader", "download file not exist when 304. url: " + url);
        listener.b("download file not exist when 304");
    }

    private final void l(String url, String filePath, Map<String, ? extends List<String>> rspHeader, gl0.a listener) {
        String str;
        String replace$default;
        List<String> list;
        Object first;
        if (filePath == null) {
            listener.b("filePath is null");
            return;
        }
        File file = new File(this.tmpDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(f());
        if (!com.tencent.filament.zplanservice.util.b.a(new File(filePath), file2)) {
            listener.b("copy file fail");
            return;
        }
        String g16 = g(url);
        File file3 = new File(g16);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        String pathAppend = FilamentFileUtil.INSTANCE.pathAppend(g16, FilamentMD5Util.md5(url));
        File file4 = new File(pathAppend);
        if (!file4.exists() && !file2.renameTo(file4)) {
            listener.b("rename fail after copy");
            return;
        }
        if (rspHeader != null && (list = rspHeader.get("Etag")) != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            str = (String) first;
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 != null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str2, "\"", "", false, 4, (Object) null);
            o(replace$default, pathAppend, url);
        }
        listener.a(pathAppend, 200, rspHeader);
    }

    private final String m() {
        return FilamentMD5Util.md5(String.valueOf(Math.random()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(Headers.ETAG);
        String optString2 = jSONObject.optString("filepath");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (optString2 != null && optString2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return false;
        }
        File file = new File(optString2);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public final void e(@NotNull String url, @NotNull gl0.a listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (TextUtils.isEmpty(url)) {
            listener.b("url is empty");
        } else {
            i(url, new b(url, listener));
        }
    }

    @NotNull
    public final String h(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return FilamentFileUtil.INSTANCE.pathAppend(g(url), "etag.json");
    }

    public final void i(@NotNull final String url, @NotNull final d listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        j jVar = this.threadPoolProxy;
        if (jVar != null) {
            j.a.a(jVar, new Runnable() { // from class: com.tencent.filament.zplan.avatar.ZPlanAvatarDownloader$getEtagMessage$1
                @Override // java.lang.Runnable
                public final void run() {
                    JSONObject jSONObject;
                    boolean n3;
                    boolean z16;
                    ReentrantLock reentrantLock;
                    File file = new File(ZPlanAvatarDownloader.this.h(url));
                    if (file.exists()) {
                        try {
                            reentrantLock = ZPlanAvatarDownloader.this.etagFileLock;
                            reentrantLock.lock();
                            try {
                                String b16 = com.tencent.filament.zplanservice.util.b.b(file);
                                reentrantLock.unlock();
                                jSONObject = new JSONObject(b16);
                            } catch (Throwable th5) {
                                reentrantLock.unlock();
                                throw th5;
                            }
                        } catch (Exception e16) {
                            FLog.INSTANCE.e("ZPlanAvatarDownloader", "get etag message fail. ", e16);
                            jSONObject = null;
                        }
                        n3 = ZPlanAvatarDownloader.this.n(jSONObject);
                        if (!n3) {
                            String parent = file.getParent();
                            if (parent != null && parent.length() != 0) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (!z16) {
                                FilamentFileUtil.INSTANCE.deleteDirSafely(parent);
                            }
                            listener.a(null);
                            return;
                        }
                        listener.a(jSONObject);
                        return;
                    }
                    listener.a(null);
                }
            }, 0L, 2, null);
        }
    }

    public final void o(@NotNull String etag, @NotNull String filePath, @NotNull String url) {
        Intrinsics.checkNotNullParameter(etag, "etag");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(url, "url");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Headers.ETAG, etag);
        jSONObject.put("filepath", filePath);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "etagJson.toString()");
        String g16 = g(url);
        ReentrantLock reentrantLock = this.etagFileLock;
        reentrantLock.lock();
        try {
            if (!com.tencent.filament.zplanservice.util.b.c(g16, "etag.json", jSONObject2)) {
                FLog.INSTANCE.e("ZPlanAvatarDownloader", "write etag file fail");
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
