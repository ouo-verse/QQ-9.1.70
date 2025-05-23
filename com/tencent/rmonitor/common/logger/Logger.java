package com.tencent.rmonitor.common.logger;

import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\f\u0010\u000bJ#\u0010\r\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\r\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J$\u0010\u0015\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0016\u0010$\u001a\u00020!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"R\"\u0010%\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u00100\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u00106\u001a\u0004\u0018\u00010\u00192\b\u00101\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001b\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/rmonitor/common/logger/Logger;", "Lcom/tencent/rmonitor/common/logger/ILoger;", "Lcom/tencent/rmonitor/common/logger/LogState;", "logState", "", "", "args", "", "j", "(Lcom/tencent/rmonitor/common/logger/LogState;[Ljava/lang/String;)V", "v", "([Ljava/lang/String;)V", "d", "i", "w", "e", "tag", "", "throwable", "c", "msg", "b", "", "level", "k", "Lcom/tencent/rmonitor/common/logger/a;", "a", "Lcom/tencent/rmonitor/common/logger/a;", "DEFAULT_PROXY", "Ljava/lang/ThreadLocal;", "Ljava/text/SimpleDateFormat;", "Ljava/lang/ThreadLocal;", "logTimeFormatter", "", "Z", "debug", "verbos", "intLevel", "I", "f", "()I", "setIntLevel", "(I)V", "Lcom/tencent/rmonitor/common/logger/LogState;", "g", "()Lcom/tencent/rmonitor/common/logger/LogState;", "l", "(Lcom/tencent/rmonitor/common/logger/LogState;)V", "logLevel", "value", h.F, "()Lcom/tencent/rmonitor/common/logger/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/rmonitor/common/logger/a;)V", "logProxy", "<init>", "()V", "DefaultLogProxy", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class Logger implements ILoger {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.rmonitor.common.logger.a DEFAULT_PROXY;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ThreadLocal<SimpleDateFormat> logTimeFormatter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean debug;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean verbos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static LogState logLevel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.rmonitor.common.logger.a logProxy;

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f365497g = new Logger();
    private static int intLevel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J+\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\r\"\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001cR\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/rmonitor/common/logger/Logger$DefaultLogProxy;", "Lcom/tencent/rmonitor/common/logger/a;", "Lcom/tencent/rmonitor/common/logger/LogState;", "state", "", "tag", "msg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "", "k", DomainData.DOMAIN_NAME, "", "args", "a", "(Lcom/tencent/rmonitor/common/logger/LogState;[Ljava/lang/String;)V", "logInfo", "j", "", "I", "logQueueSize", "Ljava/lang/StringBuffer;", "b", "Ljava/lang/StringBuffer;", "sb", "Ljava/util/concurrent/BlockingQueue;", "c", "Ljava/util/concurrent/BlockingQueue;", "workQueue1", "d", "workQueue2", "", "e", "J", "lastTimeMillis", "f", "readQueue", "g", "writerQueue", "Ljava/io/File;", h.F, "Ljava/io/File;", "logFile", "i", "Z", "flushing", "<init>", "()V", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class DefaultLogProxy implements com.tencent.rmonitor.common.logger.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int logQueueSize = 1024;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final StringBuffer sb = new StringBuffer(2048);

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final BlockingQueue<String> workQueue1;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final BlockingQueue<String> workQueue2;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long lastTimeMillis;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private BlockingQueue<String> readQueue;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private BlockingQueue<String> writerQueue;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private File logFile;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private volatile boolean flushing;

        public DefaultLogProxy() {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1024);
            this.workQueue1 = linkedBlockingQueue;
            LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue(1024);
            this.workQueue2 = linkedBlockingQueue2;
            this.readQueue = linkedBlockingQueue;
            this.writerQueue = linkedBlockingQueue2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean k() {
            boolean z16;
            String externalStorageState;
            if (this.flushing) {
                return false;
            }
            try {
                externalStorageState = Environment.getExternalStorageState();
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "";
                }
                Log.e("RMonitor_common_Logger", message);
            }
            if (externalStorageState != null) {
                int hashCode = externalStorageState.hashCode();
                if (hashCode != 1242932856) {
                    if (hashCode == 1299749220) {
                        externalStorageState.equals("mounted_ro");
                    }
                } else if (externalStorageState.equals("mounted")) {
                    z16 = true;
                    if (!z16) {
                        return true;
                    }
                    this.writerQueue.clear();
                    Log.e("RMonitor_common_Logger", "sdcard could not write");
                    return false;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }

        private final void l() {
            synchronized (this) {
                BlockingQueue<String> blockingQueue = this.workQueue1;
                if (blockingQueue == this.writerQueue) {
                    this.writerQueue = this.workQueue2;
                    this.readQueue = blockingQueue;
                } else {
                    this.writerQueue = blockingQueue;
                    this.readQueue = this.workQueue2;
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        private final String m(LogState state, String tag, String msg2) {
            int i3 = b.f365507a[state.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return "";
                            }
                            Log.e(tag, msg2);
                            return "    ERROR/";
                        }
                        Log.w(tag, msg2);
                        return "    WARN/";
                    }
                    Log.i(tag, msg2);
                    return "    INFO/";
                }
                Log.d(tag, msg2);
                return "    DEBUG/";
            }
            Log.v(tag, msg2);
            return "    VERBOS/";
        }

        private final void n() {
            new Handler(ThreadManager.INSTANCE.getLogAndErrorThreadLooper()).post(new Runnable() { // from class: com.tencent.rmonitor.common.logger.Logger$DefaultLogProxy$writeLogFile$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean k3;
                    BlockingQueue blockingQueue;
                    String str;
                    StringBuffer stringBuffer;
                    boolean z16;
                    StringBuffer stringBuffer2;
                    StringBuffer stringBuffer3;
                    long j3;
                    File file;
                    StringBuffer stringBuffer4;
                    StringBuffer stringBuffer5;
                    synchronized (Logger.DefaultLogProxy.this) {
                        k3 = Logger.DefaultLogProxy.this.k();
                        if (!k3) {
                            return;
                        }
                        File file2 = new File(FileUtil.Companion.getRootPath() + "/Log");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        Logger.DefaultLogProxy.this.flushing = true;
                        do {
                            blockingQueue = Logger.DefaultLogProxy.this.writerQueue;
                            str = (String) blockingQueue.poll();
                            if (str != null) {
                                stringBuffer5 = Logger.DefaultLogProxy.this.sb;
                                stringBuffer5.append(str + "\r\n");
                            }
                        } while (str != null);
                        stringBuffer = Logger.DefaultLogProxy.this.sb;
                        if (stringBuffer.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            long currentTimeMillis = System.currentTimeMillis();
                            j3 = Logger.DefaultLogProxy.this.lastTimeMillis;
                            if (currentTimeMillis - j3 > 1800000) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd.HH", Locale.US);
                                Logger.DefaultLogProxy.this.logFile = new File(file2, "RMonitor_" + simpleDateFormat.format(Long.valueOf(currentTimeMillis)) + ".log");
                            }
                            try {
                                file = Logger.DefaultLogProxy.this.logFile;
                                if (file != null) {
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                                    try {
                                        stringBuffer4 = Logger.DefaultLogProxy.this.sb;
                                        bufferedWriter.write(stringBuffer4.toString());
                                        bufferedWriter.flush();
                                        Unit unit = Unit.INSTANCE;
                                        CloseableKt.closeFinally(bufferedWriter, null);
                                    } finally {
                                    }
                                }
                            } catch (Throwable th5) {
                                Log.e("RMonitor_common_Logger", Logger.f365497g.i(th5));
                            }
                            Logger.DefaultLogProxy.this.lastTimeMillis = currentTimeMillis;
                        }
                        stringBuffer2 = Logger.DefaultLogProxy.this.sb;
                        stringBuffer3 = Logger.DefaultLogProxy.this.sb;
                        stringBuffer2.delete(0, stringBuffer3.length());
                        Logger.DefaultLogProxy.this.flushing = false;
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            });
        }

        @Override // com.tencent.rmonitor.common.logger.a
        public void a(@NotNull LogState state, @NotNull String... args) {
            boolean z16;
            String str;
            String str2;
            Intrinsics.checkParameterIsNotNull(state, "state");
            Intrinsics.checkParameterIsNotNull(args, "args");
            if (Logger.f365497g.g().compareTo(state) >= 0) {
                if (args.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && (str = args[0]) != null && args.length > 1) {
                    StringBuilder sb5 = new StringBuilder(256);
                    int length = args.length;
                    for (int i3 = 1; i3 < length; i3++) {
                        sb5.append(args[i3]);
                    }
                    String sb6 = sb5.toString();
                    Intrinsics.checkExpressionValueIsNotNull(sb6, "logS.toString()");
                    SimpleDateFormat simpleDateFormat = (SimpleDateFormat) Logger.a(Logger.f365497g).get();
                    if (simpleDateFormat != null) {
                        str2 = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
                    } else {
                        str2 = null;
                    }
                    String m3 = m(state, str, sb6);
                    sb5.delete(0, sb5.length());
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb5.append(str2);
                    sb5.append(m3);
                    sb5.append(str);
                    sb5.append(":    ");
                    sb5.append(sb6);
                    try {
                        String sb7 = sb5.toString();
                        Intrinsics.checkExpressionValueIsNotNull(sb7, "logS.toString()");
                        j(sb7);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
        }

        public void j(@NotNull String logInfo) {
            Intrinsics.checkParameterIsNotNull(logInfo, "logInfo");
            if (!this.readQueue.offer(logInfo)) {
                l();
                this.readQueue.offer(logInfo);
                synchronized (this) {
                    n();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/rmonitor/common/logger/Logger$a", "Ljava/lang/ThreadLocal;", "Ljava/text/SimpleDateFormat;", "a", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a extends ThreadLocal<SimpleDateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
        }
    }

    static {
        DefaultLogProxy defaultLogProxy = new DefaultLogProxy();
        DEFAULT_PROXY = defaultLogProxy;
        logTimeFormatter = new a();
        LogState logState = LogState.WARN;
        intLevel = logState.getValue();
        logLevel = logState;
        logProxy = defaultLogProxy;
    }

    Logger() {
    }

    public static final /* synthetic */ ThreadLocal a(Logger logger) {
        return logTimeFormatter;
    }

    private final void j(LogState logState, String... args) {
        com.tencent.rmonitor.common.logger.a h16;
        if (logLevel.compareTo(logState) >= 0 && (h16 = h()) != null) {
            h16.a(logState, (String[]) Arrays.copyOf(args, args.length));
        }
    }

    public final void b(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        if (tag != null && throwable != null) {
            String[] strArr = new String[3];
            strArr[0] = tag;
            if (msg2 == null) {
                msg2 = "";
            }
            strArr[1] = msg2;
            strArr[2] = i(throwable);
            e(strArr);
        }
    }

    public final void c(@Nullable String tag, @Nullable Throwable throwable) {
        if (tag != null && throwable != null) {
            e(tag, i(throwable));
        }
    }

    @Override // com.tencent.rmonitor.common.logger.ILoger
    public void d(@NotNull String... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        j(LogState.DEBUG, (String[]) Arrays.copyOf(args, args.length));
    }

    @Override // com.tencent.rmonitor.common.logger.ILoger
    public void e(@NotNull String... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        j(LogState.ERROR, (String[]) Arrays.copyOf(args, args.length));
    }

    public final int f() {
        return intLevel;
    }

    @NotNull
    public final LogState g() {
        return logLevel;
    }

    @Nullable
    public final com.tencent.rmonitor.common.logger.a h() {
        com.tencent.rmonitor.common.logger.a aVar = logProxy;
        if (aVar == null) {
            return DEFAULT_PROXY;
        }
        return aVar;
    }

    @Override // com.tencent.rmonitor.common.logger.ILoger
    public void i(@NotNull String... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        j(LogState.INFO, (String[]) Arrays.copyOf(args, args.length));
    }

    public final void k(int level) {
        LogState a16 = LogState.INSTANCE.a(level);
        if (a16 == null) {
            a16 = LogState.OFF;
        }
        l(a16);
    }

    public final void l(@NotNull LogState level) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(level, "level");
        logLevel = level;
        int value = level.getValue();
        intLevel = value;
        boolean z17 = true;
        if (value >= LogState.DEBUG.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        debug = z16;
        if (intLevel < LogState.VERBOS.getValue()) {
            z17 = false;
        }
        verbos = z17;
    }

    public final void m(@Nullable com.tencent.rmonitor.common.logger.a aVar) {
        synchronized (f365497g.getClass()) {
            logProxy = aVar;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.rmonitor.common.logger.ILoger
    public void v(@NotNull String... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        j(LogState.VERBOS, (String[]) Arrays.copyOf(args, args.length));
    }

    @Override // com.tencent.rmonitor.common.logger.ILoger
    public void w(@NotNull String... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        j(LogState.WARN, (String[]) Arrays.copyOf(args, args.length));
    }

    @NotNull
    public final String i(@Nullable Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
