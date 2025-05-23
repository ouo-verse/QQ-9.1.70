package e14;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bugly.common.heapdump.HeapDumpConfig;
import com.tencent.bugly.common.heapdump.IHeapDumper;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener;
import com.tencent.rmonitor.common.logcat.LogcatManager;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final IHeapDumper f395364a = b14.a.a();

    private static void a(List<String> list) {
        if (AndroidVersion.isOverJellyBean() || DeviceInfoUtil.hasPermission(BaseInfo.app, "android.permission.READ_LOGS")) {
            com.tencent.rmonitor.common.logcat.a c16 = LogcatManager.c(1);
            c16.a(new String[]{Argument.DURATION, "100", "-v", PerfTracer.THREADTIME_TAG});
            String b16 = c16.b();
            if (!TextUtils.isEmpty(b16)) {
                list.add(b16);
            }
        }
    }

    public static DumpResult b(String str, String str2, boolean z16, boolean z17, IMemoryDumpListener iMemoryDumpListener, boolean z18, int i3) {
        List<String> list;
        Object obj;
        if (iMemoryDumpListener != null) {
            list = iMemoryDumpListener.onPrepareDump(str);
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        DumpResult dumpResult = new DumpResult();
        if (z16) {
            Pair<Boolean, String> c16 = c(str, f395364a, z18, i3);
            if (iMemoryDumpListener != null) {
                iMemoryDumpListener.onHprofDumped(str);
            }
            boolean booleanValue = ((Boolean) c16.first).booleanValue();
            dumpResult.success = booleanValue;
            if (booleanValue && (obj = c16.second) != null) {
                String str3 = (String) obj;
                list.add(str3);
                dumpResult.hprofFileSize = new File(str3).length();
                dumpResult.hprofPath = str3;
            } else {
                if (iMemoryDumpListener != null) {
                    iMemoryDumpListener.onFinishDump(false, str, "");
                }
                Logger.f365497g.e("RMonitor_Heap_MemoryDumpHelper", "generateHprof error ", str);
                return dumpResult;
            }
        }
        if (z17) {
            a(list);
        }
        d(str, str2, iMemoryDumpListener, list, dumpResult);
        return dumpResult;
    }

    public static Pair<Boolean, String> c(String str, IHeapDumper iHeapDumper, boolean z16, int i3) {
        boolean z17;
        long currentTimeMillis;
        boolean z18;
        String str2 = "";
        if (iHeapDumper == null) {
            return new Pair<>(Boolean.FALSE, "");
        }
        synchronized (b.class) {
            Logger logger = Logger.f365497g;
            z17 = false;
            logger.d("RMonitor_Heap_MemoryDumpHelper", "ReportLog dumpHprof: ", str);
            String b16 = c.b(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(c.c());
                if (!file.exists()) {
                    file.mkdirs();
                }
                String absolutePath = file.getAbsolutePath();
                if (!absolutePath.endsWith("/")) {
                    absolutePath = absolutePath + "/";
                }
                str2 = absolutePath + "dump_" + str + "_" + b16 + ".hprof";
                try {
                    currentTimeMillis = System.currentTimeMillis();
                    if (!z16 || i3 <= 0 ? iHeapDumper.dump(str2, new HeapDumpConfig(false)) == 0 : iHeapDumper.dump(str2, new HeapDumpConfig(z16, i3)) == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    logger.d("RMonitor_Heap_MemoryDumpHelper", "dump used ", String.valueOf(System.currentTimeMillis() - currentTimeMillis), " ms");
                    z17 = z18;
                } catch (Throwable th6) {
                    z17 = z18;
                    th = th6;
                    Logger.f365497g.c("RMonitor_Heap_MemoryDumpHelper", th);
                    return new Pair<>(Boolean.valueOf(z17), str2);
                }
            }
        }
        return new Pair<>(Boolean.valueOf(z17), str2);
    }

    private static void d(String str, String str2, IMemoryDumpListener iMemoryDumpListener, List<String> list, DumpResult dumpResult) {
        Pair<Boolean, String> d16 = c.d(list, str2);
        boolean booleanValue = ((Boolean) d16.first).booleanValue();
        dumpResult.success = booleanValue;
        dumpResult.zipFilePath = (String) d16.second;
        Logger.f365497g.d("RMonitor_Heap_MemoryDumpHelper", "leakFlag=true", ",ZipFile=", String.valueOf(booleanValue), ",leakName=", str, ",dumpPath=", dumpResult.zipFilePath);
        if (iMemoryDumpListener != null) {
            iMemoryDumpListener.onFinishDump(dumpResult.success, str, dumpResult.zipFilePath);
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }
    }
}
