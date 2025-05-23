package h51;

import android.content.Context;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0007J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lh51/b;", "", "Ljava/io/File;", "file", "", "a", "Landroid/content/Context;", "context", "", "e", "packageName", "d", "c", "b", "Ljava/lang/String;", "rootDir", "<init>", "()V", "MiniBoxBusiness_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String rootDir;

    /* renamed from: b, reason: collision with root package name */
    public static final b f404334b = new b();

    b() {
    }

    private final void a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @JvmStatic
    @NotNull
    public static final String c(@NotNull Context context, @NotNull String packageName) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        File file = new File(d(context, packageName), RFixConstants.APK_PATH);
        f404334b.a(file);
        return file.getAbsolutePath() + File.separator + "base-1.apk";
    }

    @JvmStatic
    @NotNull
    public static final String d(@NotNull Context context, @NotNull String packageName) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        b bVar = f404334b;
        File file = new File(bVar.b(context), packageName);
        bVar.a(file);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "result.absolutePath");
        return absolutePath;
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull Context context) {
        File file;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (rootDir == null) {
            file = new File(context.getFilesDir(), "minibox/app");
            rootDir = file.getAbsolutePath();
        } else {
            String str = rootDir;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            file = new File(str);
        }
        f404334b.a(file);
        String str2 = rootDir;
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        return str2;
    }

    @NotNull
    public final String b(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        File file = new File(e(context), VRReportDefine$ReportKey.INSTALL);
        a(file);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "result.absolutePath");
        return absolutePath;
    }
}
