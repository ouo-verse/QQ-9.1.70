package o51;

import android.content.Context;
import com.tencent.minibox.loader.core.PluginPathConfig;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\u0014"}, d2 = {"Lo51/d;", "", "Landroid/content/Context;", "context", "", "version", "Lcom/tencent/minibox/loader/core/f;", "d", "Ljava/io/File;", "installDir", "b", "", "excludeVersions", "", "f", "c", "e", "a", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f422120a = new d();

    d() {
    }

    private final String a(String version) {
        return "v_" + version;
    }

    private final PluginPathConfig b(File installDir) {
        String baseApkPath = new File(installDir, "dex/minibox.apk").getAbsolutePath();
        String dexPath = new File(installDir, "dex").getAbsolutePath();
        String libPath = new File(installDir, RFixConstants.SO_PATH).getAbsolutePath();
        String odexPath = new File(installDir, "odex").getAbsolutePath();
        String absolutePath = installDir.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "installDir.absolutePath");
        Intrinsics.checkExpressionValueIsNotNull(baseApkPath, "baseApkPath");
        Intrinsics.checkExpressionValueIsNotNull(dexPath, "dexPath");
        Intrinsics.checkExpressionValueIsNotNull(libPath, "libPath");
        Intrinsics.checkExpressionValueIsNotNull(odexPath, "odexPath");
        return new PluginPathConfig(absolutePath, baseApkPath, dexPath, libPath, odexPath);
    }

    @JvmStatic
    public static final void c(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        m51.a.e(new File(context.getFilesDir(), "tencent/minibox/plugin"));
    }

    @JvmStatic
    @NotNull
    public static final PluginPathConfig d(@NotNull Context context, @NotNull String version) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(version, "version");
        File filesDir = context.getFilesDir();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tencent/minibox/plugin/install/");
        d dVar = f422120a;
        sb5.append(dVar.a(version));
        return dVar.b(new File(filesDir, sb5.toString()));
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String absolutePath = new File(context.getFilesDir(), "tencent/minibox/plugin/stored/").getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "File(context.filesDir, D\u2026NLOAD_STORE).absolutePath");
        return absolutePath;
    }

    @JvmStatic
    public static final void f(@NotNull Context context, @NotNull Set<String> excludeVersions) {
        int collectionSizeOrDefault;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(excludeVersions, "excludeVersions");
        String absolutePath = new File(context.getFilesDir(), "tencent/minibox/plugin/install/").getAbsolutePath();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(excludeVersions, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = excludeVersions.iterator();
        while (it.hasNext()) {
            arrayList.add(f422120a.a((String) it.next()));
        }
        File[] listFiles = new File(absolutePath).listFiles();
        if (listFiles != null) {
            ArrayList<File> arrayList2 = new ArrayList();
            for (File it5 : listFiles) {
                Intrinsics.checkExpressionValueIsNotNull(it5, "it");
                if (it5.isDirectory()) {
                    arrayList2.add(it5);
                }
            }
            for (File it6 : arrayList2) {
                Intrinsics.checkExpressionValueIsNotNull(it6, "it");
                if (!arrayList.contains(it6.getName())) {
                    m51.a.e(it6);
                }
            }
        }
    }
}
