package com.tencent.qmethod.pandoraex.monitor;

import android.util.Pair;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class RuntimeMonitor {
    private static final String TAG = "RuntimeMonitor";
    private static final ArrayList<String> concernCommand;
    private static final ArrayList<RuntimeProcessor> runtimeProcessors;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class IPProcessor implements RuntimeProcessor {
        static final int IP = 1;
        private ConcurrentHashMap<String, String> cacheMap;

        IPProcessor() {
            this.cacheMap = new ConcurrentHashMap<>();
        }

        @Override // com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor.RuntimeProcessor
        public int getType(String[] strArr) {
            if ("ip".equals(strArr[0])) {
                return 1;
            }
            return -1;
        }

        @Override // com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor.RuntimeProcessor
        public String[] transform(int i3, String[] strArr) {
            String str;
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("runtime", "R#IP", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                String arrays = Arrays.toString(strArr);
                String execute = RuntimeMonitor.execute(strArr);
                this.cacheMap.put(arrays, execute);
                return new String[]{"echo", execute};
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) && (str = this.cacheMap.get(Arrays.toString(strArr))) != null) {
                return new String[]{"echo", str};
            }
            return new String[]{"echo"};
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class PackageManagerProcessor implements RuntimeProcessor {
        static final int PM_LIST_PACKAGE = 1;

        PackageManagerProcessor() {
        }

        @Override // com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor.RuntimeProcessor
        public int getType(String[] strArr) {
            if ("pm".equals(strArr[0]) && strArr.length >= 3 && "list".equals(strArr[1]) && "package".equals(strArr[2])) {
                return 1;
            }
            return -1;
        }

        @Override // com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor.RuntimeProcessor
        public String[] transform(int i3, String[] strArr) {
            if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("runtime", "R#PM", new a.C11438a().b("ban").b("cache_only").d(), null))) {
                return strArr;
            }
            return new String[]{"echo"};
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class PropProcessor implements RuntimeProcessor {
        static final int ALL = 1;
        static final int MODEL = 3;
        static final int SERIES = 2;
        private ConcurrentHashMap<String, String> cacheMap;
        private final ArrayList<String> modelProp;
        private final ArrayList<String> serialProp;

        PropProcessor() {
            ArrayList<String> arrayList = new ArrayList<>();
            this.modelProp = arrayList;
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.serialProp = arrayList2;
            this.cacheMap = new ConcurrentHashMap<>();
            arrayList.add("ro.product.bootimage.model");
            arrayList.add("ro.product.model");
            arrayList.add("ro.product.odm.model");
            arrayList.add("ro.product.vendor.model");
            arrayList.add("ro.build.product");
            arrayList2.add("ro.boot.serialno");
            arrayList2.add("ro.serialno");
            arrayList2.add("vendor.vold.serialno");
        }

        private int handleGetProp(String[] strArr) {
            if (strArr.length == 1) {
                return 1;
            }
            if (strArr.length == 2) {
                if (this.modelProp.contains(strArr[1])) {
                    return 3;
                }
                if (this.serialProp.contains(strArr[1])) {
                    return 2;
                }
                return -1;
            }
            return -1;
        }

        private int handleShell(String[] strArr) {
            if (strArr.length == 3 && LogCmdOptions.CLEAR.equals(strArr[1]) && "getprop".equals(strArr[2])) {
                return 1;
            }
            return -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
        
            if (r2.equals("/system/bin/sh") == false) goto L9;
         */
        @Override // com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor.RuntimeProcessor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getType(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return -1;
            }
            char c16 = 0;
            String str = strArr[0];
            str.hashCode();
            switch (str.hashCode()) {
                case -253181842:
                    break;
                case -74278983:
                    if (str.equals("getprop")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 3669:
                    if (str.equals("sh")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                case 2:
                    return handleShell(strArr);
                case 1:
                    return handleGetProp(strArr);
                default:
                    return -1;
            }
        }

        @Override // com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor.RuntimeProcessor
        public String[] transform(int i3, String[] strArr) {
            String str;
            String str2;
            if (i3 != 2) {
                if (i3 != 3) {
                    str = "R#P_A";
                } else {
                    str = "R#P_M";
                }
            } else {
                str = "R#P_S";
            }
            vr3.a d16 = new a.C11438a().f("runtime").c(str).b("ban").b("cache_only").b("memory").d();
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("runtime", str, d16, null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                String execute = RuntimeMonitor.execute(strArr);
                this.cacheMap.put(str, execute);
                return new String[]{"echo", execute};
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) && (str2 = this.cacheMap.get(str)) != null) {
                return new String[]{"echo", str2};
            }
            if (com.tencent.qmethod.pandoraex.api.e.o(d16)) {
                try {
                    return new String[]{"echo", (String) com.tencent.qmethod.pandoraex.api.e.a(d16, strArr, new Object[0])};
                } catch (Throwable th5) {
                    com.tencent.qmethod.pandoraex.core.o.d(RuntimeMonitor.TAG, "get default value error", th5);
                }
            }
            return new String[]{"echo"};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface RuntimeProcessor {
        public static final int UNKNOWN = -1;

        int getType(String[] strArr);

        String[] transform(int i3, String[] strArr);
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        concernCommand = arrayList;
        ArrayList<RuntimeProcessor> arrayList2 = new ArrayList<>();
        runtimeProcessors = arrayList2;
        arrayList.add("ip");
        arrayList.add("pm");
        arrayList.add("getprop");
        arrayList.add("/system/bin/sh");
        arrayList.add("sh");
        arrayList2.add(new IPProcessor());
        arrayList2.add(new PackageManagerProcessor());
        arrayList2.add(new PropProcessor());
    }

    RuntimeMonitor() {
    }

    public static Process exec(Runtime runtime, String str) throws IOException {
        return exec(runtime, str, (String[]) null, (File) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Process] */
    public static String execute(String... strArr) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        Throwable th5;
        BufferedReader bufferedReader2;
        IOException e16;
        try {
            try {
                strArr = new ProcessBuilder(strArr).start();
                try {
                    inputStream = strArr.getInputStream();
                } catch (IOException e17) {
                    bufferedReader2 = null;
                    e16 = e17;
                    inputStream = null;
                } catch (Throwable th6) {
                    bufferedReader = null;
                    th5 = th6;
                    inputStream = null;
                }
            } catch (IOException e18) {
                inputStream = null;
                bufferedReader2 = null;
                e16 = e18;
                strArr = 0;
            } catch (Throwable th7) {
                inputStream = null;
                bufferedReader = null;
                th5 = th7;
                strArr = 0;
            }
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            } catch (IOException e19) {
                bufferedReader2 = null;
                e16 = e19;
            } catch (Throwable th8) {
                bufferedReader = null;
                th5 = th8;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e26) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "pre exec exception", e26);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e27) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "pre exec close exception", e27);
                    }
                }
                if (strArr != 0) {
                    strArr.destroy();
                    throw th5;
                }
                throw th5;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append("\n");
                }
                if (sb5.length() > 0) {
                    sb5.setLength(sb5.length() - 1);
                }
                String sb6 = sb5.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e28) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "pre exec exception", e28);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e29) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "pre exec close exception", e29);
                    }
                }
                strArr.destroy();
                return sb6;
            } catch (IOException e36) {
                e16 = e36;
                com.tencent.qmethod.pandoraex.core.o.d(TAG, "pre exec command exception", e16);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e37) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "pre exec exception", e37);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e38) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "pre exec close exception", e38);
                    }
                }
                if (strArr != 0) {
                    strArr.destroy();
                }
                return "";
            }
        } catch (Throwable th9) {
            th5 = th9;
        }
    }

    private static Pair<RuntimeProcessor, Integer> isInspect(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            if (!concernCommand.contains(strArr[0])) {
                return null;
            }
            Iterator<RuntimeProcessor> it = runtimeProcessors.iterator();
            while (it.hasNext()) {
                RuntimeProcessor next = it.next();
                int type = next.getType(strArr);
                if (type != -1) {
                    return new Pair<>(next, Integer.valueOf(type));
                }
            }
        }
        return null;
    }

    public static Process exec(Runtime runtime, String str, String[] strArr) throws IOException {
        return exec(runtime, str, strArr, (File) null);
    }

    public static Process exec(Runtime runtime, String str, String[] strArr, File file) throws IOException {
        if (str.length() != 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            String[] strArr2 = new String[stringTokenizer.countTokens()];
            int i3 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                strArr2[i3] = stringTokenizer.nextToken();
                i3++;
            }
            return exec(runtime, strArr2, strArr, file);
        }
        throw new IllegalArgumentException("Empty command");
    }

    public static Process exec(Runtime runtime, String[] strArr) throws IOException {
        return exec(runtime, strArr, (String[]) null, (File) null);
    }

    public static Process exec(Runtime runtime, String[] strArr, String[] strArr2) throws IOException {
        return exec(runtime, strArr, strArr2, (File) null);
    }

    public static Process exec(Runtime runtime, String[] strArr, String[] strArr2, File file) throws IOException {
        Pair<RuntimeProcessor, Integer> isInspect = isInspect(strArr);
        if (isInspect != null) {
            strArr = ((RuntimeProcessor) isInspect.first).transform(((Integer) isInspect.second).intValue(), strArr);
        }
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "pre exec :" + Arrays.toString(strArr));
        return runtime.exec(strArr, strArr2, file);
    }
}
