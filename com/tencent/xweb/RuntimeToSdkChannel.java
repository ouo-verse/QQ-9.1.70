package com.tencent.xweb;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.ark.ark;
import com.tencent.luggage.wxa.ar.h0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.vq.d;
import com.tencent.xweb.pinus.XWebBrowserProcessHelper;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RuntimeToSdkChannel {
    public static final String KEY_CREATE_JAVA_CRASH_DUMP_FILE = "KEY_CREATE_JAVA_CRASH_DUMP_FILE";
    public static final String KEY_CREATE_NATIVE_CRASH_DUMP_FILE = "KEY_CREATE_NATIVE_CRASH_DUMP_FILE";
    public static final String KEY_DECREASE_CHILD_PROCESS_CRASH_COUNT = "KEY_DECREASE_CHILD_PROCESS_CRASH_COUNT";
    public static final String KEY_GET_CONFIG_CMD = "GET_CONFIG_CMD";
    public static final String KEY_GET_CONFIG_CMD_EXTEND = "GET_CONFIG_CMD_EXTEND";
    public static final String KEY_GET_LOCATION_START = "KEY_GET_LOCATION_START";
    public static final String KEY_GET_LOCATION_STOP = "KEY_GET_LOCATION_STOP";
    public static final String KEY_INCREASE_CHILD_PROCESS_CRASH_COUNT = "KEY_INCREASE_CHILD_PROCESS_CRASH_COUNT";
    public static final String KEY_INVOKE_METHOD = "INVOKE_INSTANCE_METHOD";
    public static final String KEY_MULTI_PROCESS_DOWNGRADE_CRASH = "KEY_MULTI_PROCESS_DOWNGRADE_CRASH";
    public static final String KEY_MULTI_PROCESS_DOWNGRADE_SYS = "KEY_MULTI_PROCESS_DOWNGRADE_SYS";
    public static final String KEY_REPORT_REQUEST_IP = "KEY_REPORT_REQUEST_IP";
    public static final String KEY_START_REMOTE_DEBUG = "KEY_START_REMOTE_DEBUG";
    public static final String KEY_STATIC_METHOD = "INVOKE_STATIC_METHOD";
    public static final String KEY_STOP_REMOTE_DEBUG = "KEY_STOP_REMOTE_DEBUG";
    public static final String KEY_XPROFILE_RESULT_FORWARD_TO_SDK = "KEY_XPROFILE_RESULT_FORWARD_TO_SDK";
    public static final String KEY_XPROFILE_TRACING_FRAME_COST_RESULT = "KEY_XPROFILE_TRACING_FRAME_COST_RESULT";
    public static final String KEY_X_MEMORY_DUMP = "KEY_X_MEMORY_DUMP";

    public static Object a() {
        XWebChildProcessMonitor.decreaseCrashCount();
        return null;
    }

    public static Object b() {
        XWebChildProcessMonitor.increaseCrashCount();
        return null;
    }

    public static Object c(Object obj) {
        if (!(obj instanceof String[])) {
            x0.f("RuntimeToSdkChannel", "handleGetConfigCmd, invalid args");
            return "";
        }
        String[] strArr = (String[]) obj;
        if (strArr.length < 2) {
            x0.f("RuntimeToSdkChannel", "handleGetConfigCmd, invalid args length");
            return "";
        }
        if (TextUtils.isEmpty(strArr[1])) {
            return CommandCfg.getInstance().getCmd(strArr[0]);
        }
        return CommandCfg.getInstance().getCmd(strArr[0], strArr[1]);
    }

    public static Object[] createRuntimeToSdkChannelObject() {
        return new Object[]{new ValueCallback() { // from class: com.tencent.xweb.RuntimeToSdkChannel.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Object obj) {
                if (!(obj instanceof Object[])) {
                    x0.f("RuntimeToSdkChannel", "RuntimeToSdkChannel, invalid args");
                    return;
                }
                Object[] objArr = (Object[]) obj;
                if (objArr.length < 3) {
                    x0.f("RuntimeToSdkChannel", "RuntimeToSdkChannel, invalid args length");
                    return;
                }
                Object obj2 = objArr[0];
                if (!(obj2 instanceof String)) {
                    x0.f("RuntimeToSdkChannel", "RuntimeToSdkChannel, invalid args[0]");
                } else {
                    objArr[2] = RuntimeToSdkChannel.onRuntimeCalled((String) obj2, objArr[1]);
                }
            }
        }};
    }

    public static Object d(Object obj) {
        if (!(obj instanceof String[])) {
            x0.f("RuntimeToSdkChannel", "handleGetConfigCmdExtend, invalid args");
            return "";
        }
        String[] strArr = (String[]) obj;
        if (strArr.length < 2) {
            x0.f("RuntimeToSdkChannel", "handleGetConfigCmdExtend, invalid args length");
            return "";
        }
        if (TextUtils.isEmpty(strArr[1])) {
            return CommandCfgPlugin.getInstance().getCmd(strArr[0]);
        }
        return CommandCfgPlugin.getInstance().getCmd(strArr[0], strArr[1]);
    }

    public static Object e(Object obj) {
        if (!(obj instanceof Object[])) {
            x0.f("RuntimeToSdkChannel", "handleInvokeMethod, invalid args");
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr != null && objArr.length >= 2) {
            Object obj2 = objArr[0];
            if (!(obj2 instanceof Object)) {
                x0.f("RuntimeToSdkChannel", "handleInvokeMethod, invalid args[0]");
                return null;
            }
            if (!(objArr[1] instanceof String)) {
                x0.f("RuntimeToSdkChannel", "handleInvokeMethod, invalid args[1]");
                return null;
            }
            if (obj2 instanceof String) {
                obj2 = h0.a((String) obj2);
            }
            if (obj2 == null) {
                x0.f("RuntimeToSdkChannel", "handleInvokeMethod, instance is null");
                return null;
            }
            String str = (String) objArr[1];
            if (2 == objArr.length) {
                return h0.a(obj2, str);
            }
            if (4 == objArr.length) {
                Object obj3 = objArr[2];
                if (!(obj3 instanceof Class[])) {
                    return h0.a(obj2, str);
                }
                Object obj4 = objArr[3];
                if (!(obj4 instanceof Object[])) {
                    return h0.a(obj2, str);
                }
                return h0.a(obj2, str, (Class[]) obj3, (Object[]) obj4);
            }
            return h0.a(obj2, str);
        }
        x0.f("RuntimeToSdkChannel", "handleInvokeMethod, invalid args length");
        return null;
    }

    public static Object f(Object obj) {
        if (!(obj instanceof Bundle)) {
            x0.f("RuntimeToSdkChannel", "handleMemoryDump, invalid args");
            return null;
        }
        Bundle bundle = (Bundle) obj;
        if (bundle.containsKey(ark.ARKMETADATA_JSON) && bundle.containsKey("map")) {
            if (XWebRuntimeToSdkHelper.a() != null) {
                XWebRuntimeToSdkHelper.a().onMemoryDumpFinished(bundle.getString(ark.ARKMETADATA_JSON), bundle.getBundle("map"));
            }
            return null;
        }
        x0.f("RuntimeToSdkChannel", "handleMemoryDump, invalid args, Bundle not containsKey");
        return null;
    }

    public static Object g(Object obj) {
        if (!(obj instanceof String)) {
            XWebChildProcessMonitor.recordChildProcessCrash(null);
            return null;
        }
        XWebChildProcessMonitor.recordChildProcessCrash((String) obj);
        return null;
    }

    public static Object h(Object obj) {
        if (!(obj instanceof String)) {
            XWebChildProcessMonitor.setShouldSwitchToSys(true, null);
            return null;
        }
        XWebChildProcessMonitor.setShouldSwitchToSys(true, (String) obj);
        return null;
    }

    public static Object i(Object obj) {
        if (!(obj instanceof Bundle)) {
            x0.f("RuntimeToSdkChannel", "handleReportRequestIP, invalid args");
            return null;
        }
        Bundle bundle = (Bundle) obj;
        if (XWebRuntimeToSdkHelper.b() != null) {
            XWebRuntimeToSdkHelper.b().onCallback(bundle);
        }
        return null;
    }

    public static Object j(Object obj) {
        if (!(obj instanceof Boolean)) {
            return null;
        }
        return Boolean.valueOf(com.tencent.luggage.wxa.uq.a.a().a(((Boolean) obj).booleanValue()));
    }

    public static Object k(Object obj) {
        x0.d("RuntimeToSdkChannel", "handleStartRemoteDebug, process:" + XWalkEnvironment.getProcessName());
        if (!(obj instanceof String)) {
            x0.f("RuntimeToSdkChannel", "handleStartRemoteDebug, not support args");
            return null;
        }
        d.a((String) obj);
        return null;
    }

    public static Object l(Object obj) {
        if (!(obj instanceof Object[])) {
            x0.f("RuntimeToSdkChannel", "handleStaticMethod, invalid args");
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr != null && objArr.length >= 2) {
            Object obj2 = objArr[0];
            if (!(obj2 instanceof String)) {
                x0.f("RuntimeToSdkChannel", "handleStaticMethod, invalid args[0]");
                return null;
            }
            Object obj3 = objArr[1];
            if (!(obj3 instanceof String)) {
                x0.f("RuntimeToSdkChannel", "handleStaticMethod, invalid args[1]");
                return null;
            }
            String str = (String) obj2;
            String str2 = (String) obj3;
            if (2 == objArr.length) {
                return h0.a(str, str2);
            }
            if (4 == objArr.length) {
                Object obj4 = objArr[2];
                if (!(obj4 instanceof Class[])) {
                    return h0.a(str, str2);
                }
                Object obj5 = objArr[3];
                if (!(obj5 instanceof Object[])) {
                    return h0.a(str, str2);
                }
                return h0.a(str, str2, (Class[]) obj4, (Object[]) obj5);
            }
            return h0.a((Object) str, str2);
        }
        x0.f("RuntimeToSdkChannel", "handleStaticMethod, invalid args length");
        return null;
    }

    public static Object m(Object obj) {
        com.tencent.luggage.wxa.uq.a.a().c();
        return null;
    }

    public static Object n(Object obj) {
        x0.d("RuntimeToSdkChannel", "handleStopRemoteDebug, process:" + XWalkEnvironment.getProcessName());
        d.b();
        return null;
    }

    public static Object o(Object obj) {
        XWebProfilerController.getInstance().onProfileStop(obj);
        return null;
    }

    public static Object onRuntimeCalled(String str, Object obj) {
        if (KEY_GET_CONFIG_CMD.equals(str)) {
            return c(obj);
        }
        if (KEY_GET_CONFIG_CMD_EXTEND.equals(str)) {
            return d(obj);
        }
        if (KEY_INVOKE_METHOD.equals(str)) {
            return e(obj);
        }
        if (KEY_STATIC_METHOD.equals(str)) {
            return l(obj);
        }
        if (!KEY_XPROFILE_RESULT_FORWARD_TO_SDK.equals(str) && !KEY_XPROFILE_TRACING_FRAME_COST_RESULT.equals(str)) {
            if (KEY_CREATE_JAVA_CRASH_DUMP_FILE.equals(str)) {
                return a(obj);
            }
            if (KEY_CREATE_NATIVE_CRASH_DUMP_FILE.equals(str)) {
                return b(obj);
            }
            if (KEY_X_MEMORY_DUMP.equals(str)) {
                return f(obj);
            }
            if (KEY_REPORT_REQUEST_IP.equals(str)) {
                return i(obj);
            }
            if (KEY_INCREASE_CHILD_PROCESS_CRASH_COUNT.equals(str)) {
                return b();
            }
            if (KEY_DECREASE_CHILD_PROCESS_CRASH_COUNT.equals(str)) {
                return a();
            }
            if (KEY_MULTI_PROCESS_DOWNGRADE_SYS.equals(str)) {
                return h(obj);
            }
            if (KEY_MULTI_PROCESS_DOWNGRADE_CRASH.equals(str)) {
                return g(obj);
            }
            if (KEY_GET_LOCATION_START.equals(str)) {
                return j(obj);
            }
            if (KEY_GET_LOCATION_STOP.equals(str)) {
                return m(obj);
            }
            if (KEY_START_REMOTE_DEBUG.equals(str)) {
                return k(obj);
            }
            if (KEY_STOP_REMOTE_DEBUG.equals(str)) {
                return n(obj);
            }
            return null;
        }
        return o(obj);
    }

    public static String a(Object obj) {
        if (!(obj instanceof String)) {
            x0.f("RuntimeToSdkChannel", "handleCreateJavaCrashDumpFile, invalid args");
            return null;
        }
        String str = (String) obj;
        if (!TextUtils.isEmpty(str) && XWebBrowserProcessHelper.getCrashDumpFileCallback() != null) {
            x0.d("RuntimeToSdkChannel", "handleCreateJavaCrashDumpFile, serviceName:" + str);
            if (str.contains("SandboxedProcessService")) {
                return XWebBrowserProcessHelper.getCrashDumpFileCallback().getJavaCrashDumpFilePath(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX);
            }
            if (str.contains("PrivilegedProcessService")) {
                return XWebBrowserProcessHelper.getCrashDumpFileCallback().getJavaCrashDumpFilePath(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_GPU);
            }
        }
        return null;
    }

    public static String b(Object obj) {
        if (!(obj instanceof String)) {
            x0.f("RuntimeToSdkChannel", "handleCreateNativeCrashDumpFile, invalid args");
            return null;
        }
        String str = (String) obj;
        if (!TextUtils.isEmpty(str) && XWebBrowserProcessHelper.getCrashDumpFileCallback() != null) {
            x0.d("RuntimeToSdkChannel", "handleCreateNativeCrashDumpFile, serviceName:" + str);
            if (str.contains("SandboxedProcessService")) {
                return XWebBrowserProcessHelper.getCrashDumpFileCallback().getNativeCrashDumpFilePath(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX);
            }
            if (str.contains("PrivilegedProcessService")) {
                return XWebBrowserProcessHelper.getCrashDumpFileCallback().getNativeCrashDumpFilePath(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_GPU);
            }
        }
        return null;
    }
}
