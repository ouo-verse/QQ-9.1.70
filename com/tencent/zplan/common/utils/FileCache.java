package com.tencent.zplan.common.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/zplan/common/utils/FileCache;", "", "", "keyLowerCase", "e", "filePath", "key", "", "g", "f", "Ljava/io/File;", "c", "Lcom/jakewharton/disklrucache/DiskLruCache;", "a", "Lkotlin/Lazy;", "d", "()Lcom/jakewharton/disklrucache/DiskLruCache;", "diskLruCache", "b", "Ljava/lang/String;", QzoneZipCacheHelper.DIR, "", "J", "maxSize", "<init>", "(Ljava/lang/String;J)V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class FileCache {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f385278d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy diskLruCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String dir;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long maxSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/common/utils/FileCache$a;", "", "", "FILE_SUFFIX_INDEX", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    private static final class a {
        a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FileCache(@NotNull String dir, long j3) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.dir = dir;
        this.maxSize = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DiskLruCache>() { // from class: com.tencent.zplan.common.utils.FileCache$diskLruCache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DiskLruCache invoke() {
                String str;
                long j16;
                str = FileCache.this.dir;
                File file = new File(str);
                j16 = FileCache.this.maxSize;
                long j17 = 1024;
                return DiskLruCache.open(file, 1, 1, j16 * j17 * j17);
            }
        });
        this.diskLruCache = lazy;
    }

    private final DiskLruCache d() {
        return (DiskLruCache) this.diskLruCache.getValue();
    }

    private final String e(String keyLowerCase) {
        String absolutePath = new File(this.dir, keyLowerCase + ".0").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "File(dir, \"${keyLowerCas\u2026FFIX_INDEX\").absolutePath");
        return absolutePath;
    }

    @Nullable
    public final File c(@Nullable String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        Intrinsics.checkNotNull(key);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        if (key != null) {
            String lowerCase = key.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            try {
                DiskLruCache.Snapshot snapshot = d().get(lowerCase);
                if (snapshot == null) {
                    return null;
                }
                snapshot.close();
                File file = new File(e(lowerCase));
                if (!file.exists()) {
                    return null;
                }
                if (file.length() <= 0) {
                    return null;
                }
                return file;
            } catch (Throwable th5) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 == null) {
                    return null;
                }
                a16.e("[ZPlanFileCache]", 1, "getCache error", th5);
                return null;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(@Nullable String filePath, @Nullable String key) {
        BufferedOutputStream bufferedOutputStream;
        lx4.d a16;
        DiskLruCache.Editor edit;
        FileInputStream fileInputStream;
        boolean z16 = false;
        if (TextUtils.isEmpty(key)) {
            lx4.d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.b(a17, "[ZPlanFileCache]", 1, "saveToCache fail for invalid key, filePath:" + filePath + ", key:" + key, null, 8, null);
            }
            return false;
        }
        if (!c.f385288a.h(filePath)) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNull(key);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        if (key != null) {
            String lowerCase = key.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            FileInputStream fileInputStream2 = null;
            try {
                File file = new File(filePath);
                edit = d().edit(lowerCase);
                bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0));
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                edit.commit();
                d().flush();
                fileInputStream.close();
                bufferedOutputStream.close();
                z16 = true;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream2 = fileInputStream;
                try {
                    lx4.d a18 = LogUtil.f385285b.a();
                    if (a18 != null) {
                        a18.e("[ZPlanFileCache]", 1, "saveToCache error", th);
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                    }
                    return z16;
                } finally {
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                }
            }
            long elapsedRealtime22 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanFileCache]", 1, "saveToCache result:" + z16 + ", filePath:" + filePath + ", key:" + key + ", costTime:" + elapsedRealtime22, null, 8, null);
            }
            return z16;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean g(@Nullable String filePath, @Nullable String key) {
        boolean f16 = f(filePath, key);
        if (f16) {
            c.f385288a.g(filePath);
        }
        return f16;
    }
}
