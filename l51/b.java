package l51;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.minibox.common.log.LogUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Ll51/b;", "", "Landroid/content/Context;", "context", "", "e", "a", "", h.F, "jsonStr", "b", "key", "", "d", "g", "c", "event", "f", "", "Ljava/util/Map;", "eventTimestamps", "", "Z", "isDebug", "()Z", "setDebug", "(Z)V", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isDebug;

    /* renamed from: c, reason: collision with root package name */
    public static final b f413856c = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Long> eventTimestamps = new LinkedHashMap();

    b() {
    }

    private final void a() {
        eventTimestamps.clear();
    }

    private final void b(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonStr);
            eventTimestamps.put("startLaunch", Long.valueOf(jSONObject.optLong("startLaunch")));
            eventTimestamps.put("callService", Long.valueOf(jSONObject.optLong("callService")));
            eventTimestamps.put("callClient", Long.valueOf(jSONObject.optLong("callClient")));
            eventTimestamps.put("initHook", Long.valueOf(jSONObject.optLong("initHook")));
            eventTimestamps.put("makeApplication", Long.valueOf(jSONObject.optLong("makeApplication")));
            eventTimestamps.put("newActivity", Long.valueOf(jSONObject.optLong("newActivity")));
        } catch (JSONException e16) {
            LogUtils.e("PerformanceReport", "deserialize", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x003d -> B:14:0x0063). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String c(Context context) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileLock fileLock2;
        ?? r36 = "minibox_perf.json";
        File file = new File(context.getCacheDir(), "minibox_perf.json");
        String str = null;
        try {
        } catch (IOException e16) {
            LogUtils.e("PerformanceReport", "getFileJson", e16);
        }
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e17) {
                e = e17;
                randomAccessFile = null;
                fileLock2 = null;
            } catch (Throwable th5) {
                th = th5;
                r36 = 0;
                fileLock = null;
            }
            try {
                fileLock2 = randomAccessFile.getChannel().lock();
            } catch (IOException e18) {
                e = e18;
                fileLock2 = null;
            } catch (Throwable th6) {
                th = th6;
                fileLock = null;
                r36 = randomAccessFile;
                th = th;
                if (fileLock != null) {
                }
                if (r36 == 0) {
                }
            }
            try {
                if (file.exists()) {
                    str = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
                }
                if (fileLock2 != null) {
                    try {
                        fileLock2.release();
                    } catch (IOException e19) {
                        LogUtils.e("PerformanceReport", "getFileJson", e19);
                    }
                }
                randomAccessFile.close();
            } catch (IOException e26) {
                e = e26;
                LogUtils.e("PerformanceReport", "getFileJson", e);
                if (fileLock2 != null) {
                    try {
                        fileLock2.release();
                    } catch (IOException e27) {
                        LogUtils.e("PerformanceReport", "getFileJson", e27);
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return str;
            }
            return str;
        } catch (Throwable th7) {
            th = th7;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException e28) {
                    LogUtils.e("PerformanceReport", "getFileJson", e28);
                }
            }
            if (r36 == 0) {
                try {
                    r36.close();
                    throw th;
                } catch (IOException e29) {
                    LogUtils.e("PerformanceReport", "getFileJson", e29);
                    throw th;
                }
            }
            throw th;
        }
    }

    private final long d(String key) {
        Long l3 = eventTimestamps.get(key);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    private final void e(Context context) {
        b(c(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005a A[Catch: IOException -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0035, blocks: (B:11:0x0031, B:26:0x005a), top: B:2:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0036 -> B:12:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void g(Context context, String jsonStr) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        Throwable th5;
        IOException e16;
        File file = new File(context.getCacheDir(), "minibox_perf.json");
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (IOException e17) {
                    e = e17;
                    fileLock = null;
                    e16 = e;
                    LogUtils.e("PerformanceReport", "saveFileJson", e16);
                    if (fileLock != null) {
                    }
                    if (randomAccessFile == null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileLock = null;
                    th5 = th;
                    if (fileLock != null) {
                    }
                    if (randomAccessFile == null) {
                    }
                }
            } catch (IOException e18) {
                e = e18;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th7) {
                th = th7;
                randomAccessFile = null;
                fileLock = null;
            }
        } catch (IOException e19) {
            LogUtils.e("PerformanceReport", "saveFileJson", e19);
        }
        try {
            try {
                FilesKt__FileReadWriteKt.writeText$default(file, jsonStr, null, 2, null);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e26) {
                        LogUtils.e("PerformanceReport", "saveFileJson", e26);
                    }
                }
                randomAccessFile.close();
            } catch (Throwable th8) {
                th5 = th8;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e27) {
                        LogUtils.e("PerformanceReport", "saveFileJson", e27);
                    }
                }
                if (randomAccessFile == null) {
                    try {
                        randomAccessFile.close();
                        throw th5;
                    } catch (IOException e28) {
                        LogUtils.e("PerformanceReport", "saveFileJson", e28);
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (IOException e29) {
            e16 = e29;
            LogUtils.e("PerformanceReport", "saveFileJson", e16);
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException e36) {
                    LogUtils.e("PerformanceReport", "saveFileJson", e36);
                }
            }
            if (randomAccessFile == null) {
                randomAccessFile.close();
            }
        }
    }

    private final String h() {
        JSONObject jSONObject = new JSONObject();
        b bVar = f413856c;
        jSONObject.put("startLaunch", bVar.d("startLaunch"));
        jSONObject.put("callService", bVar.d("callService"));
        jSONObject.put("callClient", bVar.d("callClient"));
        jSONObject.put("initHook", bVar.d("initHook"));
        jSONObject.put("makeApplication", bVar.d("makeApplication"));
        jSONObject.put("newActivity", bVar.d("newActivity"));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().apply {\n   \u2026TY))\n        }.toString()");
        return jSONObject2;
    }

    public final void f(@NotNull Context context, @NotNull String event) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (!isDebug) {
            return;
        }
        e(context);
        if (Intrinsics.areEqual(event, "startLaunch")) {
            a();
        }
        eventTimestamps.put(event, Long.valueOf(System.currentTimeMillis()));
        g(context, h());
        LogUtils.i("PerformanceReport", "recordTimestamp event:" + event);
    }
}
