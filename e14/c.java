package e14;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.rmonitor.common.util.FileUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f395365a = FileUtil.j() + "/Log/";

    public static long a() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static String b(long j3, @NonNull String str) {
        if (j3 <= 0) {
            return null;
        }
        return new SimpleDateFormat(str, Locale.US).format(new Date(j3));
    }

    public static String c() {
        return f395365a;
    }

    public static Pair<Boolean, String> d(@NonNull List<String> list, String str) {
        String str2 = c() + "dump_" + str + "_" + b(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss") + ".zip";
        return new Pair<>(Boolean.valueOf(FileUtil.l(list, str2, false)), str2);
    }
}
