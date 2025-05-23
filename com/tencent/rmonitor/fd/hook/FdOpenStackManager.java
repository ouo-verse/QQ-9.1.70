package com.tencent.rmonitor.fd.hook;

import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.heapdump.IForkJvmDumperListener;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.util.FileUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdOpenStackManager {

    /* renamed from: b, reason: collision with root package name */
    private static List<String> f365574b = new ArrayList<String>() { // from class: com.tencent.rmonitor.fd.hook.FdOpenStackManager.1
        {
            add(".*/librmonitor_memory.so$");
            add(".*/libBugly_Native.so$");
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f365575c = {".*\\.so$"};

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f365573a = FileUtil.k("rmonitor_memory");

    /* renamed from: d, reason: collision with root package name */
    private static IForkJvmDumperListener f365576d = new a();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class a implements IForkJvmDumperListener {
        a() {
        }

        @Override // com.tencent.bugly.common.heapdump.IForkJvmDumperListener
        public void onResume() {
            if (FdOpenStackManager.f365573a) {
                FdOpenStackManager.b(true);
            }
        }

        @Override // com.tencent.bugly.common.heapdump.IForkJvmDumperListener
        public void onSuspend() {
            if (FdOpenStackManager.f365573a) {
                FdOpenStackManager.b(false);
            }
        }
    }

    public static boolean a(String str) {
        if (f365573a) {
            return nDumpFdOpenStacks(str);
        }
        return false;
    }

    public static void b(boolean z16) {
        if (f365573a) {
            nSetFdOpenHookValue(z16);
        }
    }

    public static boolean c() {
        if (!f365573a) {
            return false;
        }
        for (String str : f365575c) {
            nSetRegisterHookSo(str);
        }
        if (AndroidVersion.isOverR()) {
            f365574b.add(".*/libmonochrome.so$");
        }
        Iterator<String> it = f365574b.iterator();
        while (it.hasNext()) {
            nSetIgnoreHookSo(it.next());
        }
        nStartFdOpenHook(com.tencent.rmonitor.fd.a.h());
        ForkJvmHeapDumper.registerForkJvmDumperListener(f365576d);
        return true;
    }

    public static void d() {
        if (f365573a) {
            nStopFdOpenHook();
        }
    }

    private static native boolean nDumpFdOpenStacks(String str);

    private static native void nSetFdOpenHookValue(boolean z16);

    private static native void nSetIgnoreHookSo(String str);

    private static native void nSetRegisterHookSo(String str);

    private static native void nStartFdOpenHook(boolean z16);

    private static native void nStopFdOpenHook();
}
