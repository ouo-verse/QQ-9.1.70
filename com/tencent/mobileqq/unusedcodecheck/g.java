package com.tencent.mobileqq.unusedcodecheck;

import android.content.Context;
import android.os.Environment;
import android.os.Parcelable;
import android.os.StatFs;
import android.os.SystemProperties;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J\u001c\u0010\u0010\u001a\u00020\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH&J\u001c\u0010\u0011\u001a\u00020\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&J7\u0010\u001a\u001a\u00028\u0000\"\b\b\u0000\u0010\u0016*\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0019\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001d\u001a\u00020\u001cH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/g;", "", "", "b", "Landroid/content/Context;", "getContext", "tag", "msg", "", "e", "", ReportConstant.COSTREPORT_TRANS, tl.h.F, "c", "", "params", "i", "f", "key", "Landroid/os/Parcelable;", "value", "d", "T", "Ljava/lang/Class;", "clazz", RemoteHandleConst.PARAM_DEFAULT_VALUE, "g", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "", "a", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public interface g {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    public static final class a {
        public static long a(@NotNull g gVar) {
            Exception e16;
            long j3;
            try {
                File path = Environment.getDataDirectory();
                Intrinsics.checkNotNullExpressionValue(path, "path");
                StatFs statFs = new StatFs(path.getPath());
                j3 = statFs.getAvailableBlocks() * statFs.getBlockSize();
                try {
                    Method method = SystemProperties.class.getMethod("getLong", String.class, Long.TYPE);
                    Intrinsics.checkNotNullExpressionValue(method, "Class.forName(\"android.o\u2026imitiveType\n            )");
                    Object invoke = method.invoke(null, "sys.memory.threshold.low", 0L);
                    if (invoke != null) {
                        return j3 - Math.min(j3, ((Long) invoke).longValue());
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                } catch (Exception e17) {
                    e16 = e17;
                    gVar.h("UnusedCodeCheck", "getRemainStorageSize error", e16);
                    return j3;
                }
            } catch (Exception e18) {
                e16 = e18;
                j3 = 0;
            }
        }
    }

    long a();

    @Nullable
    String b();

    void c(@NotNull String tag, @NotNull String msg2);

    void d(@NotNull String key, @NotNull Parcelable value);

    void e(@NotNull String tag, @NotNull String msg2);

    void f(@NotNull Map<String, String> params);

    @NotNull
    <T extends Parcelable> T g(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defaultValue);

    @NotNull
    Context getContext();

    void h(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5);

    void i(@NotNull Map<String, String> params);
}
