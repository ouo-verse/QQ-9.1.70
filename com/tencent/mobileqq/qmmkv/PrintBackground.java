package com.tencent.mobileqq.qmmkv;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneImageUtils;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0006\u0010\u0017\u001a\u00020\u0004J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH\u0016R\"\u0010%\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001b\u00102\u001a\u00020/8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\b\u001f\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/PrintBackground;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "switchOn", "", "k", "", "mmapId", "", com.tencent.luggage.wxa.c8.c.E, "actual", "count", "startup", "d", QZoneImageUtils.KEY_MATCH, tl.h.F, "Ljava/io/File;", "file", "", "records", "c", "tick", "i", "f", "onApplicationForeground", "onApplicationBackground", "isEnabled", "onScreensStateChanged", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "e", "J", "getBackgroundTs", "()J", "setBackgroundTs", "(J)V", "backgroundTs", "Z", "getChecked", "()Z", "setChecked", "(Z)V", "checked", "getLogSizeRemain", "setLogSizeRemain", "logSizeRemain", "Lcom/tencent/mobileqq/qmmkv/MMKVPrintConfig;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qmmkv/MMKVPrintConfig;", "sConfig", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PrintBackground implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final PrintBackground f261993d = new PrintBackground();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile long backgroundTs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean checked;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long logSizeRemain;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sConfig;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVPrintConfig>() { // from class: com.tencent.mobileqq.qmmkv.PrintBackground$sConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVPrintConfig invoke() {
                MMKVPrintConfig a16 = MMKVPrintConfig.INSTANCE.a();
                QLog.d("MMKVPrint_background", 1, "init switch = " + a16.getSwitchOn());
                return a16;
            }
        });
        sConfig = lazy;
    }

    PrintBackground() {
    }

    private final void c(File file, Set<String> records) {
        MMKVOptionEntityV2 mMKVOptionEntityV2;
        boolean z16;
        String str;
        long j3;
        long j16;
        long j17;
        long j18;
        String name = file.getName();
        long length = file.length();
        try {
            mMKVOptionEntityV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, name, 2, 1);
        } catch (Throwable th5) {
            QLog.d("MMKVPrint_background", 1, "filePrint [" + name + "] kv == null", th5.getMessage(), th5);
            mMKVOptionEntityV2 = null;
        }
        if (mMKVOptionEntityV2 == null) {
            return;
        }
        long actualSize = mMKVOptionEntityV2.actualSize();
        long count = mMKVOptionEntityV2.count();
        long j19 = ((32 * count) * 2) >>> 20;
        long X = ah.X() >>> 20;
        if (length >= (e().getFileSizeLimit() << 10) && logSizeRemain > 0 && X > j19) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            str = "MMKVPrint_background";
            j3 = X;
            j16 = j19;
            j17 = count;
            j18 = actualSize;
        } else {
            Intrinsics.checkNotNullExpressionValue(name, "name");
            str = "MMKVPrint_background";
            logSizeRemain = f.c(name, logSizeRemain);
            j16 = j19;
            j3 = X;
            j18 = actualSize;
            d(name, length, actualSize, count, false);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(name);
            sb5.append("|");
            sb5.append(length);
            sb5.append("|");
            sb5.append(j18);
            sb5.append("|");
            j17 = count;
            sb5.append(j17);
            records.add(sb5.toString());
        }
        QLog.d(str, 1, "doPrint [" + name + "]: " + z16 + " " + (length >>> 10) + "/" + (e().getFileSizeLimit() >>> 10) + " Kb actual:" + (j18 >>> 10) + " Kb count:" + j17 + " remainLogSize: " + logSizeRemain + " b memSize: [" + j16 + "/" + j3 + "] Mb");
    }

    private final void d(String mmapId, long len, long actual, long count, boolean startup) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mmapId", mmapId);
        hashMap.put(com.tencent.luggage.wxa.c8.c.E, String.valueOf(len));
        hashMap.put("actual", String.valueOf(actual));
        hashMap.put("count", String.valueOf(count));
        if (startup) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("startup", str);
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "actMMKVPrintReport", true, 0L, 0L, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PrintBackground this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PrintBackground printBackground = f261993d;
        if (printBackground.e().getSwitchOn()) {
            GuardManagerCallbackDispatcher.registerCallBack(this$0);
        }
        printBackground.k(printBackground.e().getSwitchOn());
    }

    private final void h(String match) {
        File[] listFiles;
        boolean z16;
        Regex regex;
        String extension;
        boolean z17;
        QLog.d("MMKVPrint_background", 1, "mmkvPrint [" + match + "]");
        File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/mmkv");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            boolean z18 = false;
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    regex = new Regex(match);
                } catch (Throwable unused) {
                    regex = null;
                }
                if (regex == null) {
                    QLog.e("MMKVPrint_background", 1, "invalid match: " + match);
                    return;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (File file2 : listFiles) {
                    if (backgroundTs == 0) {
                        break;
                    }
                    Intrinsics.checkNotNullExpressionValue(file2, "file");
                    extension = FilesKt__UtilsKt.getExtension(file2);
                    if (extension.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        String name = file2.getName();
                        try {
                            Intrinsics.checkNotNullExpressionValue(name, "name");
                            if (regex.matches(name)) {
                                c(file2, linkedHashSet);
                            }
                        } catch (OutOfMemoryError e16) {
                            System.gc();
                            QLog.d("MMKVPrint_background", 1, "mmkvPrint oom [" + name + "] break. ", e16.getMessage(), e16);
                        } catch (Throwable th5) {
                            QLog.d("MMKVPrint_background", 1, "mmkvPrint exception [" + name + "] ", th5.getMessage(), th5);
                        }
                    }
                }
                if (linkedHashSet.size() > 0) {
                    MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
                    from.encodeStringSet("PrintBackground_record", linkedHashSet);
                }
                int size = linkedHashSet.size();
                if (backgroundTs > 0) {
                    z18 = true;
                }
                QLog.d("MMKVPrint_background", 1, "mmkvPrint saveRecords: " + size + " complete:" + z18);
            }
        }
    }

    private final void i(long tick) {
        if (e().getSwitchOn() && !checked && SystemClock.elapsedRealtime() - backgroundTs >= e().getBackgroundDelaytime() * 1000) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MMKVPrint_background", 2, "onBackgroundTimeTick " + tick);
            }
            checked = true;
            long decodeLong = QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeLong("PrintBackground_ts", 0L);
            long validityTime = e().getValidityTime() * 60000;
            long elapsedRealtime = SystemClock.elapsedRealtime() - decodeLong;
            boolean z16 = false;
            if (0 <= elapsedRealtime && elapsedRealtime < validityTime) {
                z16 = true;
            }
            if (z16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MMKVPrint_background", 2, "onBackgroundTimeTick return by time interval.");
                    return;
                }
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.s
                @Override // java.lang.Runnable
                public final void run() {
                    PrintBackground.j();
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        if (backgroundTs != 0) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
            from.removeKey("PrintBackground_record");
            from.encodeLong("PrintBackground_ts", SystemClock.elapsedRealtime());
            PrintBackground printBackground = f261993d;
            logSizeRemain = printBackground.e().getLogSizeLimit() << 20;
            printBackground.h(printBackground.e().getMmapId());
        }
    }

    private final void k(boolean switchOn) {
        List split$default;
        MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("PrintBackground_ts", 0L);
        if (QLog.isDevelopLevel()) {
            QLog.d("MMKVPrint_background", 4, "mmkvPrint reportLastRecordIfNeed lastTs: " + decodeLong);
        }
        if (switchOn && SystemClock.elapsedRealtime() - decodeLong < e().getValidityTime() * 60000) {
            Set<String> decodeStringSet = from.decodeStringSet("PrintBackground_record", null);
            if (decodeStringSet != null) {
                for (String record : decodeStringSet) {
                    Intrinsics.checkNotNullExpressionValue(record, "record");
                    split$default = StringsKt__StringsKt.split$default((CharSequence) record, new String[]{"|"}, false, 0, 6, (Object) null);
                    boolean z16 = false;
                    String str = (String) split$default.get(0);
                    long parseLong = Long.parseLong((String) split$default.get(1));
                    long parseLong2 = Long.parseLong((String) split$default.get(2));
                    long parseLong3 = Long.parseLong((String) split$default.get(3));
                    if (str.length() > 0) {
                        z16 = true;
                    }
                    if (z16 && parseLong > 0 && parseLong2 > 0 && parseLong3 > 0) {
                        QLog.d("MMKVPrint_background", 1, "reportLastRecord [" + str + "] len: " + parseLong + " actual: " + parseLong2 + " count:" + parseLong3);
                        f261993d.d(str, parseLong, parseLong2, parseLong3, true);
                    }
                }
                return;
            }
            return;
        }
        from.removeKey("PrintBackground_record");
        from.removeKey("PrintBackground_ts");
    }

    @NotNull
    public final MMKVPrintConfig e() {
        return (MMKVPrintConfig) sConfig.getValue();
    }

    public final void f() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.t
            @Override // java.lang.Runnable
            public final void run() {
                PrintBackground.g(PrintBackground.this);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        backgroundTs = SystemClock.elapsedRealtime();
        checked = false;
        if (QLog.isDevelopLevel()) {
            QLog.d("MMKVPrint_background", 2, "onApplicationBackground");
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        backgroundTs = 0L;
        if (QLog.isDevelopLevel()) {
            QLog.d("MMKVPrint_background", 2, "onApplicationForeground");
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
        i(tick);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
        i(tick);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
