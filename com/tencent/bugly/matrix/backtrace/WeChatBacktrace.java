package com.tencent.bugly.matrix.backtrace;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.matrix.util.MatrixLog;
import com.tencent.bugly.matrix.xlog.XLogNative;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.util.AbiUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WeChatBacktrace {
    private static final String BACKTRACE_LIBRARY_NAME = "buglybacktrace";
    public static final String ISOLATE_PROCESS_SUFFIX = ":backtrace__";
    private static final String SYSTEM_BOOT_OAT_PATH = "/system/framework/arm/";
    private static final String SYSTEM_BOOT_OAT_PATH_64 = "/system/framework/arm64/";
    private static final String SYSTEM_LIBRARY_PATH = "/system/lib/";
    private static final String SYSTEM_LIBRARY_PATH_64 = "/system/lib64/";
    private static final String SYSTEM_LIBRARY_PATH_Q = "/apex/com.android.runtime/lib/";
    private static final String SYSTEM_LIBRARY_PATH_Q_64 = "/apex/com.android.runtime/lib64/";
    private static final String TAG = "Matrix.Backtrace";
    public static boolean mQuickBackTraceInitialized = false;
    private static ArrayList<String> quickUnwindTableLibrary = new ArrayList<>();
    private static boolean sLibraryLoaded = false;
    private volatile Configuration mConfiguration;
    private volatile boolean mConfigured;
    private volatile boolean mInitialized;
    private final WarmUpDelegate mWarmUpDelegate = new WarmUpDelegate();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mScheduleQutGenerationRequestsRunning = false;

    /* compiled from: P */
    /* renamed from: com.tencent.bugly.matrix.backtrace.WeChatBacktrace$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$Mode = iArr;
            try {
                iArr[Mode.Fp.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$Mode[Mode.Quicken.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$Mode[Mode.Dwarf.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$Mode[Mode.FpUntilQuickenWarmedUp.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$Mode[Mode.DwarfUntilQuickenWarmedUp.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Configuration {
        Mode mBacktraceMode;
        private boolean mCommitted;
        Context mContext;
        boolean mCoolDown;
        boolean mCoolDownIfApkUpdated;
        boolean mEnableIsolateProcessLog;
        boolean mEnableLog;
        boolean mIsWarmUpProcess;
        LibraryLoader mLibraryLoader;
        String mPathOfXLogSo;
        boolean mQuickenAlwaysOn;
        String mSavingPath;
        long mWarmUpDelay;
        HashSet<String> mWarmUpDirectoriesList;
        boolean mWarmUpInIsolateProcess;
        WarmUpTiming mWarmUpTiming;
        private final WeChatBacktrace mWeChatBacktrace;

        Configuration(Context context, WeChatBacktrace weChatBacktrace) {
            HashSet<String> hashSet = new HashSet<>();
            this.mWarmUpDirectoriesList = hashSet;
            this.mBacktraceMode = Mode.Quicken;
            this.mLibraryLoader = null;
            this.mCoolDown = false;
            this.mQuickenAlwaysOn = false;
            this.mCoolDownIfApkUpdated = true;
            this.mIsWarmUpProcess = false;
            this.mWarmUpInIsolateProcess = true;
            this.mWarmUpTiming = WarmUpTiming.WhileScreenOff;
            this.mWarmUpDelay = 3000L;
            this.mEnableLog = false;
            this.mEnableIsolateProcessLog = false;
            this.mPathOfXLogSo = null;
            this.mCommitted = false;
            this.mContext = context;
            this.mWeChatBacktrace = weChatBacktrace;
            hashSet.add(context.getApplicationInfo().nativeLibraryDir);
            this.mWarmUpDirectoriesList.add(WeChatBacktrace.getSystemLibraryPathBeforeQ());
            this.mWarmUpDirectoriesList.add(WeChatBacktrace.getSystemLibraryPathAfterQ());
            this.mWarmUpDirectoriesList.add(WeChatBacktrace.getBaseODEXPath(context));
            this.mWarmUpDirectoriesList.add(WeChatBacktrace.getSystemFrameworkOATPath() + "boot.oat");
            this.mWarmUpDirectoriesList.add(WeChatBacktrace.getSystemFrameworkOATPath() + "boot-framework.oat");
            this.mIsWarmUpProcess = ProcessUtil.isMainProcess(this.mContext);
        }

        public Configuration clearWarmUpDirectorySet() {
            if (this.mCommitted) {
                return this;
            }
            this.mWarmUpDirectoriesList.clear();
            return this;
        }

        public void commit() {
            if (this.mCommitted) {
                return;
            }
            this.mCommitted = true;
            this.mWeChatBacktrace.configure(this);
        }

        public Configuration coolDown(boolean z16) {
            if (this.mCommitted) {
                return this;
            }
            this.mCoolDown = z16;
            return this;
        }

        public Configuration coolDownIfApkUpdated(boolean z16) {
            if (this.mCommitted) {
                return this;
            }
            this.mCoolDownIfApkUpdated = z16;
            return this;
        }

        public Configuration directoryToWarmUp(String str) {
            if (this.mCommitted) {
                return this;
            }
            this.mWarmUpDirectoriesList.add(str);
            return this;
        }

        public Configuration enableIsolateProcessLogger(boolean z16) {
            if (this.mCommitted) {
                return this;
            }
            this.mEnableIsolateProcessLog = z16;
            return this;
        }

        public Configuration enableOtherProcessLogger(boolean z16) {
            if (this.mCommitted) {
                return this;
            }
            this.mEnableLog = z16;
            return this;
        }

        public Configuration isWarmUpProcess(boolean z16) {
            if (this.mCommitted) {
                return this;
            }
            this.mIsWarmUpProcess = z16;
            return this;
        }

        public Configuration savingPath(String str) {
            if (this.mCommitted) {
                return this;
            }
            this.mSavingPath = str;
            return this;
        }

        public Configuration setBacktraceMode(Mode mode) {
            if (this.mCommitted) {
                return this;
            }
            if (mode != null) {
                this.mBacktraceMode = mode;
            }
            return this;
        }

        public Configuration setLibraryLoader(LibraryLoader libraryLoader) {
            if (this.mCommitted) {
                return this;
            }
            this.mLibraryLoader = libraryLoader;
            return this;
        }

        public Configuration setQuickenAlwaysOn() {
            if (this.mCommitted) {
                return this;
            }
            this.mQuickenAlwaysOn = true;
            return this;
        }

        public String toString() {
            boolean z16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nWeChat backtrace configurations: \n>>> Backtrace Mode: ");
            sb5.append(this.mBacktraceMode);
            sb5.append("\n>>> Quicken always on: ");
            sb5.append(this.mQuickenAlwaysOn);
            sb5.append("\n>>> Saving Path: ");
            String str = this.mSavingPath;
            if (str == null) {
                str = WarmUpUtility.defaultSavingPath(this);
            }
            sb5.append(str);
            sb5.append("\n>>> Custom Library Loader: ");
            if (this.mLibraryLoader != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("\n>>> Directories to Warm-up: ");
            sb5.append(this.mWarmUpDirectoriesList.toString());
            sb5.append("\n>>> Is Warm-up Process: ");
            sb5.append(this.mIsWarmUpProcess);
            sb5.append("\n>>> Warm-up Timing: ");
            sb5.append(this.mWarmUpTiming);
            sb5.append("\n>>> Warm-up Delay: ");
            sb5.append(this.mWarmUpDelay);
            sb5.append("ms\n>>> Warm-up in isolate process: ");
            sb5.append(this.mWarmUpInIsolateProcess);
            sb5.append("\n>>> Enable logger: ");
            sb5.append(this.mEnableLog);
            sb5.append("\n>>> Enable Isolate Process logger: ");
            sb5.append(this.mEnableIsolateProcessLog);
            sb5.append("\n>>> Path of XLog: ");
            sb5.append(this.mPathOfXLogSo);
            sb5.append("\n>>> Cool-down: ");
            sb5.append(this.mCoolDown);
            sb5.append("\n>>> Cool-down if Apk Updated: ");
            sb5.append(this.mCoolDownIfApkUpdated);
            sb5.append("\n");
            return sb5.toString();
        }

        public Configuration warmUpInIsolateProcess(boolean z16) {
            if (this.mCommitted) {
                return this;
            }
            this.mWarmUpInIsolateProcess = z16;
            return this;
        }

        public Configuration warmUpSettings(WarmUpTiming warmUpTiming, long j3) {
            if (this.mCommitted) {
                return this;
            }
            this.mWarmUpTiming = warmUpTiming;
            this.mWarmUpDelay = j3;
            return this;
        }

        public Configuration xLoggerPath(String str) {
            if (this.mCommitted) {
                return this;
            }
            this.mPathOfXLogSo = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class ConfigurationException extends RuntimeException {
        public ConfigurationException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface LibraryLoader {
        void load(String str);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum Mode {
        Fp(0),
        Quicken(1),
        Dwarf(2),
        FpUntilQuickenWarmedUp(3),
        DwarfUntilQuickenWarmedUp(4);

        int value;

        Mode(int i3) {
            this.value = i3;
        }

        @Override // java.lang.Enum
        public String toString() {
            int i3 = AnonymousClass2.$SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$Mode[ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return "Unreachable.";
                            }
                            return "Use dwarf-based backtrace before quicken has warmed up.";
                        }
                        return "Use fp-based backtrace before quicken has warmed up.";
                    }
                    return "Dwarf-based.";
                }
                return "WeChat QuickenUnwindTable-based.";
            }
            return "FramePointer-based.";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Singleton {
        public static final WeChatBacktrace INSTANCE = new WeChatBacktrace();

        Singleton() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum WarmUpTiming {
        WhileScreenOff,
        WhileCharging,
        PostStartup
    }

    private void dealWithCoolDown(Configuration configuration) {
        if (configuration.mIsWarmUpProcess) {
            File warmUpMarkedFile = WarmUpUtility.warmUpMarkedFile(configuration.mContext);
            if (configuration.mCoolDownIfApkUpdated && warmUpMarkedFile.exists()) {
                String readFileContent = WarmUpUtility.readFileContent(warmUpMarkedFile, 4096);
                if (readFileContent == null) {
                    configuration.mCoolDown = true;
                } else if (!readFileContent.split("\n")[0].equalsIgnoreCase(configuration.mContext.getApplicationInfo().nativeLibraryDir)) {
                    MatrixLog.i(TAG, "Apk updated, remove warmed-up file.", new Object[0]);
                    configuration.mCoolDown = true;
                }
            }
            if (configuration.mCoolDown) {
                warmUpMarkedFile.delete();
                WarmUpUtility.unfinishedFile(configuration.mContext).delete();
            }
        }
    }

    public static int[] doStatistic(String str) {
        return WeChatBacktraceNative.statistic(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void enableLogger(boolean z16) {
        WeChatBacktraceNative.enableLogger(z16);
    }

    public static String getBaseODEXPath(Context context) {
        String str;
        if (!is64BitRuntime()) {
            str = AbiUtil.ARM;
        } else {
            str = ResourceAttributes.HostArchValues.ARM64;
        }
        return new File(new File(context.getApplicationInfo().nativeLibraryDir).getParentFile().getParentFile(), "/oat/" + str + "/base.odex").getAbsolutePath();
    }

    public static String getSystemFrameworkOATPath() {
        if (!is64BitRuntime()) {
            return SYSTEM_BOOT_OAT_PATH;
        }
        return SYSTEM_BOOT_OAT_PATH_64;
    }

    public static String getSystemLibraryPathAfterQ() {
        if (!is64BitRuntime()) {
            return SYSTEM_LIBRARY_PATH_Q;
        }
        return SYSTEM_LIBRARY_PATH_Q_64;
    }

    public static String getSystemLibraryPathBeforeQ() {
        if (!is64BitRuntime()) {
            return SYSTEM_LIBRARY_PATH;
        }
        return SYSTEM_LIBRARY_PATH_64;
    }

    public static boolean hasWarmedUp(Context context) {
        return WarmUpUtility.hasWarmedUp(context);
    }

    public static void initQuickBacktrace() {
        if (!mQuickBackTraceInitialized) {
            mQuickBackTraceInitialized = true;
            Configuration warmUpSettings = instance().configure(ContextUtil.getGlobalContext()).setBacktraceMode(Mode.Quicken).warmUpSettings(WarmUpTiming.PostStartup, 0L);
            ArrayList<String> arrayList = quickUnwindTableLibrary;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<String> it = quickUnwindTableLibrary.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (new File(next).exists()) {
                        warmUpSettings.directoryToWarmUp(next);
                    }
                }
            }
            warmUpSettings.warmUpInIsolateProcess(false).commit();
        }
    }

    public static WeChatBacktrace instance() {
        return Singleton.INSTANCE;
    }

    public static boolean is64BitRuntime() {
        String str = Build.CPU_ABI;
        if (!"arm64-v8a".equalsIgnoreCase(str) && !"x86_64".equalsIgnoreCase(str) && !"mips64".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void loadLibrary(LibraryLoader libraryLoader) {
        if (sLibraryLoaded) {
            return;
        }
        if (libraryLoader == null) {
            loadLibrary();
        } else {
            MatrixLog.i(TAG, "Using custom library loader: %s.", libraryLoader);
            libraryLoader.load(BACKTRACE_LIBRARY_NAME);
        }
        sLibraryLoaded = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestQutGenerate() {
        if (this.mInitialized && this.mConfigured) {
            this.mWarmUpDelegate.requestConsuming();
        }
    }

    private boolean runningInIsolateProcess(Configuration configuration) {
        String processNameByPid = ProcessUtil.getProcessNameByPid(configuration.mContext);
        if (processNameByPid != null && processNameByPid.endsWith(ISOLATE_PROCESS_SUFFIX)) {
            return true;
        }
        return false;
    }

    public static void setQutLibraryPath(ArrayList<String> arrayList) {
        quickUnwindTableLibrary.addAll(arrayList);
    }

    public static void setReporter(WarmUpReporter warmUpReporter) {
        WarmUpDelegate.sReporter = warmUpReporter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScheduleQutGenerationRequests() {
        if (this.mScheduleQutGenerationRequestsRunning) {
            return;
        }
        this.mScheduleQutGenerationRequestsRunning = false;
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.bugly.matrix.backtrace.WeChatBacktrace.1
            @Override // java.lang.Runnable
            public void run() {
                WeChatBacktrace.this.requestQutGenerate();
                WeChatBacktrace.this.mScheduleQutGenerationRequestsRunning = false;
                WeChatBacktrace.this.startScheduleQutGenerationRequests();
            }
        }, 21600000L);
    }

    public synchronized Configuration configure(Context context) {
        if (this.mConfiguration != null) {
            return this.mConfiguration;
        }
        this.mConfiguration = new Configuration(context, this);
        this.mInitialized = true;
        return this.mConfiguration;
    }

    public String getSavingPath() {
        return this.mWarmUpDelegate.mSavingPath;
    }

    public boolean isBacktraceThreadBlocked() {
        return this.mWarmUpDelegate.isBacktraceThreadBlocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configure(Configuration configuration) {
        if (runningInIsolateProcess(configuration)) {
            MatrixLog.i(TAG, "Isolate process does not need any configuration.", new Object[0]);
            return;
        }
        if (configuration.mWarmUpInIsolateProcess && configuration.mLibraryLoader != null) {
            throw new ConfigurationException("Custom library loader is not supported in isolate process warm-up mode.");
        }
        loadLibrary(configuration.mLibraryLoader);
        XLogNative.setXLogger(configuration.mPathOfXLogSo);
        enableLogger(configuration.mEnableLog);
        MatrixLog.i(TAG, configuration.toString(), new Object[0]);
        Mode mode = configuration.mBacktraceMode;
        Mode mode2 = Mode.Fp;
        if (mode == mode2 || mode == Mode.Dwarf) {
            WeChatBacktraceNative.setBacktraceMode(mode.value);
        }
        Mode mode3 = configuration.mBacktraceMode;
        Mode mode4 = Mode.Quicken;
        if (mode3 == mode4 || mode3 == Mode.FpUntilQuickenWarmedUp || mode3 == Mode.DwarfUntilQuickenWarmedUp || configuration.mQuickenAlwaysOn) {
            String validateSavingPath = WarmUpUtility.validateSavingPath(configuration);
            MatrixLog.i(TAG, "Set saving path: %s", validateSavingPath);
            new File(validateSavingPath).mkdirs();
            String str = File.separator;
            if (!validateSavingPath.endsWith(str)) {
                validateSavingPath = validateSavingPath + str;
            }
            this.mWarmUpDelegate.setSavingPath(validateSavingPath);
            dealWithCoolDown(configuration);
            this.mWarmUpDelegate.prepare(configuration);
            boolean hasWarmedUp = WarmUpUtility.hasWarmedUp(configuration.mContext);
            Mode mode5 = configuration.mBacktraceMode;
            if (mode5 == mode4 || !configuration.mQuickenAlwaysOn) {
                if (!hasWarmedUp) {
                    if (mode5 != Mode.FpUntilQuickenWarmedUp) {
                        if (mode5 == Mode.DwarfUntilQuickenWarmedUp) {
                            mode2 = Mode.Dwarf;
                        }
                    }
                    WeChatBacktraceNative.setBacktraceMode(mode2.value);
                }
                mode2 = mode4;
                WeChatBacktraceNative.setBacktraceMode(mode2.value);
            }
            MatrixLog.i(TAG, "Has warmed up: %s", Boolean.valueOf(hasWarmedUp));
            WeChatBacktraceNative.setWarmedUp(hasWarmedUp);
            startScheduleQutGenerationRequests();
            if (!configuration.mIsWarmUpProcess) {
                this.mWarmUpDelegate.registerWarmedUpReceiver(configuration, configuration.mBacktraceMode);
            }
        }
        this.mConfigured = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadLibrary() {
        System.loadLibrary(BACKTRACE_LIBRARY_NAME);
    }
}
