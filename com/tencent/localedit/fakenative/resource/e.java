package com.tencent.localedit.fakenative.resource;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.core.BaseManager;
import com.tencent.localedit.fakenative.resource.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.photoplus.sticker.Sticker;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.io.FileInputStream;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\"\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010 R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010%R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0014\u0010+\u001a\u00020(8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/localedit/fakenative/resource/e;", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "Lcom/tencent/localedit/fakenative/resource/a;", "", WadlProxyConsts.PARAM_FILENAME, "data", "", "r", "k", "filePath", "globalPadId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "p", "url", DomainData.DOMAIN_NAME, "path", "d", "", "needSaveToDisk", "c", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "tailName", "b", "a", "l", "o", "f", "e", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "memoryCacheMap", "Ljava/lang/String;", "fileCacheRootDirPath", "resourceCacheRootDirPath", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "context", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class e extends BaseManager implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SharedPreferences sharedPreferences;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, String> memoryCacheMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String fileCacheRootDirPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String resourceCacheRootDirPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Long) ((Map.Entry) t16).getValue(), (Long) ((Map.Entry) t17).getValue());
            return compareValues;
        }
    }

    public e() {
        SharedPreferences sharedPreferences = g().getSharedPreferences("local_edit_file_cache_pref", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere\u2026ME, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        this.memoryCacheMap = new LruCache<>(10);
        this.fileCacheRootDirPath = "";
        this.resourceCacheRootDirPath = "";
    }

    private final Context g() {
        return LocalEditSDK.INSTANCE.getApplicationContext();
    }

    private final String j(String filePath, String globalPadId) {
        this.sharedPreferences.edit().putLong(globalPadId, System.currentTimeMillis()).apply();
        return w11.a.f444159a.i(a.C5961a.b(this, filePath, globalPadId, null, 4, null));
    }

    private final String k(String fileName) {
        String str = this.memoryCacheMap.get(fileName);
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String p(String filePath) {
        Object obj;
        CRC32 crc32 = new CRC32();
        File file = new File(filePath);
        Object obj2 = "";
        if (file.exists() && !file.isDirectory()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                        crc32.update(bArr, 0, read);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    long length = file.length();
                    long lastModified = file.lastModified();
                    long value = crc32.getValue();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(length);
                    sb5.append('-');
                    sb5.append(lastModified);
                    sb5.append('-');
                    sb5.append(value);
                    obj = Result.m476constructorimpl(sb5.toString());
                } finally {
                }
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                obj = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(obj);
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b(CacheManager.TAG, Intrinsics.stringPlus("Local_edit getUniqueFileId error: ", m479exceptionOrNullimpl));
            }
            if (Result.m479exceptionOrNullimpl(obj) == null) {
                obj2 = obj;
            }
            String str = (String) obj2;
            x11.b.f446855a.d(CacheManager.TAG, "Local_edit uniqueId:" + str + " ,filePath:" + filePath);
            return str;
        }
        x11.b.f446855a.b(CacheManager.TAG, Intrinsics.stringPlus("Local_edit getUniqueFileId file not exists, filePath = ", filePath));
        return "";
    }

    private final void q(String filePath, String data, String globalPadId) {
        w11.a.f444159a.r(data, a.C5961a.b(this, filePath, globalPadId, null, 4, null));
    }

    private final void r(String fileName, String data) {
        this.memoryCacheMap.put(fileName, data);
    }

    @Override // com.tencent.localedit.fakenative.resource.a
    @NotNull
    public String a(@NotNull String filePath, @Nullable String tailName) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String p16 = p(filePath);
        if (tailName != null) {
            if (tailName.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = tailName;
            } else {
                str = null;
            }
            if (str != null) {
                String str2 = p16 + '-' + ((Object) tailName);
                if (str2 != null) {
                    return str2;
                }
                return p16;
            }
            return p16;
        }
        return p16;
    }

    @Override // com.tencent.localedit.fakenative.resource.a
    @NotNull
    public String b(@NotNull String filePath, @NotNull String globalPadId, @Nullable String tailName) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        return l(globalPadId) + '/' + a(filePath, tailName) + Sticker.JSON_SUFFIX;
    }

    @Override // com.tencent.localedit.fakenative.resource.a
    public void c(@NotNull String filePath, @NotNull String data, @NotNull String globalPadId, boolean needSaveToDisk) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        String a16 = a.C5961a.a(this, filePath, null, 2, null);
        if (TextUtils.isEmpty(a16)) {
            x11.b.f446855a.b(CacheManager.TAG, Intrinsics.stringPlus("saveFileDataCache fileName is empty, filePath=", filePath));
            return;
        }
        r(a16, data);
        if (needSaveToDisk) {
            q(filePath, data, globalPadId);
        }
    }

    @Nullable
    public String d(@NotNull String path) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = path;
        } else {
            str = null;
        }
        if (str == null) {
            x11.b.f446855a.b(CacheManager.TAG, Intrinsics.stringPlus("getResourceCachePath failed, path=", path));
            return null;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x001b, code lost:
    
        if ((!r3) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        boolean z16;
        int fileCacheMaxCount;
        List sortedWith;
        int coerceAtMost;
        File[] listFiles = new File(h()).listFiles();
        int i3 = 0;
        if (listFiles != null) {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        listFiles = null;
        if (listFiles == null) {
            x11.b.f446855a.d(CacheManager.TAG, "cleanUpDiskCache file cache dir has no file");
            return;
        }
        com.tencent.localedit.c sdkConfig = LocalEditSDK.INSTANCE.getSdkConfig();
        if (sdkConfig == null) {
            fileCacheMaxCount = 30;
        } else {
            fileCacheMaxCount = sdkConfig.getFileCacheMaxCount();
        }
        if (listFiles.length <= fileCacheMaxCount) {
            return;
        }
        x11.b.f446855a.d(CacheManager.TAG, "cleanUpDiskCache file count:" + listFiles.length + " is larger than max count:" + fileCacheMaxCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = listFiles.length;
        for (int i16 = 0; i16 < length; i16++) {
            File file = listFiles[i16];
            if (!file.isFile()) {
                long j3 = this.sharedPreferences.getLong(file.getName(), file.lastModified());
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                linkedHashMap.put(name, Long.valueOf(j3));
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(linkedHashMap.entrySet(), new b());
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(sortedWith.size(), listFiles.length - fileCacheMaxCount);
        x11.b.f446855a.d(CacheManager.TAG, "cleanUpDiskCache untilIndex :" + coerceAtMost + " a = " + Process.myPid());
        if (coerceAtMost <= 0) {
            return;
        }
        while (true) {
            int i17 = i3 + 1;
            String str = (String) ((Map.Entry) sortedWith.get(i3)).getKey();
            x11.b.f446855a.d(CacheManager.TAG, Intrinsics.stringPlus("cleanUpDiskCache globalPadId :", str));
            f(str);
            if (i17 < coerceAtMost) {
                i3 = i17;
            } else {
                return;
            }
        }
    }

    public void f(@NotNull String globalPadId) {
        boolean isBlank;
        String str;
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        isBlank = StringsKt__StringsJVMKt.isBlank(globalPadId);
        if (!isBlank) {
            str = globalPadId;
        } else {
            str = null;
        }
        if (str == null) {
            x11.b.f446855a.b(CacheManager.TAG, "deleteJsonDataAndResourceFile globalPadId is empty");
            return;
        }
        w11.a aVar = w11.a.f444159a;
        boolean f16 = aVar.f(l(globalPadId));
        boolean f17 = aVar.f(o(globalPadId));
        x11.b.f446855a.d(CacheManager.TAG, "deleteJsonDataAndResourceFile globalPadId:" + globalPadId + ", deleteDataSuccess:" + f16 + ", deleteResourceSuccess:" + f17);
    }

    @NotNull
    public String h() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.fileCacheRootDirPath);
        if (isBlank) {
            String stringPlus = Intrinsics.stringPlus(g().getFilesDir().getAbsolutePath(), "/localEdit/fileCache");
            File file = new File(stringPlus);
            if (file.exists() || file.mkdirs()) {
                this.fileCacheRootDirPath = stringPlus;
            }
        }
        return this.fileCacheRootDirPath;
    }

    @NotNull
    public String i(@NotNull String filePath, @NotNull String globalPadId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        String str = null;
        String a16 = a.C5961a.a(this, filePath, null, 2, null);
        String k3 = k(a16);
        boolean z17 = true;
        if (k3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = k3;
        }
        if (str == null) {
            String j3 = j(filePath, globalPadId);
            if (j3.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                r(a16, j3);
            }
            return j3;
        }
        return str;
    }

    @NotNull
    public String l(@NotNull String globalPadId) {
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        String str = h() + '/' + globalPadId;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    @NotNull
    public String m() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.resourceCacheRootDirPath);
        if (isBlank) {
            String stringPlus = Intrinsics.stringPlus(g().getFilesDir().getAbsolutePath(), "/localEdit/resourceCache");
            File file = new File(stringPlus);
            if (file.exists() || file.mkdirs()) {
                this.resourceCacheRootDirPath = stringPlus;
            }
        }
        return this.resourceCacheRootDirPath;
    }

    @Nullable
    public String n(@Nullable String url) {
        String str;
        w11.a aVar = w11.a.f444159a;
        if (aVar.o(url)) {
            x11.b.f446855a.d(CacheManager.TAG, Intrinsics.stringPlus("matchMediaUrl url:", url));
            str = aVar.l(url);
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return LocalEditSDK.INSTANCE.getCache().m() + '/' + ((Object) str);
    }

    @NotNull
    public String o(@NotNull String globalPadId) {
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        String str = m() + '/' + globalPadId;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }
}
