package jz3;

import android.content.Context;
import android.os.StatFs;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rdelivery.reshub.FileSuffix;
import com.tencent.rdelivery.reshub.core.j;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u001aF\u0010\u0016\u001a\u00020\u00142\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u001a0\u0010\u0018\u001a\u00020\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u001a0\u0010\u0019\u001a\u00020\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u001a\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u0016\u0010\u001e\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d2\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/e;", Const.BUNDLE_KEY_REQUEST, "", "suffix", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "k", "i", "l", "Landroid/content/Context;", "context", "", "g", "Ljava/io/File;", "path", h.F, "", "crc32Map", "md5Map", "parentPath", "", "withLog", "d", "map", "a", "c", "", "f", "Ljava/lang/Exception;", "Lkotlin/Exception;", DomainData.DOMAIN_NAME, "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {
    public static final boolean a(@Nullable Map<String, String> map, @Nullable String str, boolean z16) {
        boolean z17;
        if (str != null && str.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            if (z16) {
                d.c("FileUtil", "Unzip Files MD5 Check Fail! No Path.");
            }
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (z16) {
                d.c("FileUtil", "Unzip Files MD5 Check Fail! Path Not Exist: " + str);
            }
            return false;
        }
        if (!file.isDirectory()) {
            if (z16) {
                d.c("FileUtil", "Unzip Files MD5 Check Fail! Path Not Directory: " + str);
            }
            return false;
        }
        String[] list = file.list();
        if (list != null && list.length == 0) {
            if (z16) {
                d.c("FileUtil", "Unzip Files MD5 Check Fail! Directory is Empty: " + str);
            }
            return false;
        }
        if (map == null) {
            return true;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!c.c(str + key, entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean b(Map map, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return a(map, str, z16);
    }

    public static final boolean c(@Nullable Map<String, String> map, @Nullable String str, boolean z16) {
        boolean z17;
        if (str != null && str.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            if (z16) {
                d.c("FileUtil", "Unzip Files Crc32 Check Fail! No Path.");
            }
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (z16) {
                d.c("FileUtil", "Unzip Files Crc32 Check Fail! Path Not Exist: " + str);
            }
            return false;
        }
        if (!file.isDirectory()) {
            if (z16) {
                d.c("FileUtil", "Unzip Files Crc32 Check Fail! Path Not Directory: " + str);
            }
            return false;
        }
        String[] list = file.list();
        if (list != null && list.length == 0) {
            if (z16) {
                d.c("FileUtil", "Unzip Files Crc32 Check Fail! Directory is Empty: " + str);
            }
            return false;
        }
        if (map == null) {
            if (z16) {
                d.c("FileUtil", "Unzip Files Crc32 Check Fail! map is null");
            }
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!c.a(str + key, entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean d(@Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable String str, boolean z16) {
        boolean z17;
        if (map != null && !map.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            return c(map, str, z16);
        }
        return a(map2, str, z16);
    }

    public static /* synthetic */ boolean e(Map map, Map map2, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return d(map, map2, str, z16);
    }

    public static final void f(@NotNull String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        File file = new File(path);
        if (file.exists()) {
            c.f(file, true);
            d.a("FileUtil", "Delete Local Res Path: " + path);
            return;
        }
        d.a("FileUtil", "Delete Local Res, Path Not Exist: " + path);
    }

    public static final long g(@Nullable Context context) {
        if (context != null && context.getFilesDir() != null) {
            try {
                File filesDir = context.getFilesDir();
                Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
                return h(filesDir.getParentFile());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return -1L;
    }

    public static final long h(@Nullable File file) {
        if (file != null && file.exists()) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return -1L;
    }

    @NotNull
    public static final String i(@NotNull com.tencent.rdelivery.reshub.api.e request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return m(request, FileSuffix.PATCH_FILE);
    }

    private static final String j(com.tencent.rdelivery.reshub.api.e eVar, @FileSuffix String str) {
        com.tencent.rdelivery.reshub.api.d j3 = j.L.j();
        if (Intrinsics.areEqual(FileSuffix.INSTANCE.a(), str)) {
            return j3.a(eVar);
        }
        if (Intrinsics.areEqual(FileSuffix.RES_FILE, str)) {
            return j3.b(eVar);
        }
        return j3.c(eVar);
    }

    @NotNull
    public static final String k(@NotNull com.tencent.rdelivery.reshub.api.e request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return m(request, FileSuffix.RES_FILE);
    }

    @NotNull
    public static final String l(@NotNull com.tencent.rdelivery.reshub.api.e request) {
        boolean z16;
        boolean endsWith$default;
        Intrinsics.checkParameterIsNotNull(request, "request");
        String m3 = m(request, FileSuffix.INSTANCE.a());
        if (m3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(m3, str, false, 2, null);
            if (!endsWith$default) {
                return m3 + str;
            }
            return m3;
        }
        return m3;
    }

    private static final String m(com.tencent.rdelivery.reshub.api.e eVar, @FileSuffix String str) {
        boolean z16;
        String j3 = j(eVar, str);
        if (j3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return j3;
        }
        throw new IllegalStateException("Bad Path: " + j3);
    }

    @Nullable
    public static final Exception n(@NotNull String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        if (!j.L.G()) {
            return null;
        }
        try {
            c.o(path);
            return null;
        } catch (Exception e16) {
            d.d("FileUtil", "Create or Clear File Failed. Path: " + path, e16);
            return e16;
        }
    }
}
