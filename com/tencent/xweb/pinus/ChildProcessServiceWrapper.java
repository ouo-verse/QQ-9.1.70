package com.tencent.xweb.pinus;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.ar.a0;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.wq.d;
import com.tencent.luggage.wxa.wq.e;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.xweb.LibraryLoader;
import com.tencent.xweb.XWebChildProcessMonitor;
import com.tencent.xweb.XWebClassLoaderWrapper;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.pinus.sdk.JNIUtils;
import com.tencent.xweb.pinus.sdk.library_loader.Linker;
import cooperation.qzone.patch.QZonePatchService;
import dalvik.system.InMemoryDexClassLoader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class ChildProcessServiceWrapper {
    public static final String EXTRA_APK_VERSION = "org.chromium.base.process_launcher.extra.apk_version";
    public static final String EXTRA_PROCESS_NAME = "org.chromium.base.process_launcher.extra.process_name";
    private static final int PRE_CONNECTION_CODE_CHILD_PROCESS_DEX_FD = 4;
    private static final int PRE_CONNECTION_CODE_CRASH_DUMP_FD = 2;
    private static final int PRE_CONNECTION_CODE_CUSTOM_FONT_FD = 3;
    private static final int PRE_CONNECTION_CODE_DEX_FD = 0;
    private static final int PRE_CONNECTION_CODE_SO_FD = 1;
    public static final String PROCESS_TYPE_GPU = "gpu";
    public static final String PROCESS_TYPE_RENDER = "render";
    private static final String TAG = "ChildProcessServiceWrapper";
    private final String mApkVersion;
    private final String mBrowserProcessName;
    private Object mChildProcessService;
    private Class<?> mChildProcessServiceClass;
    private ClassLoader mClassLoader;
    private boolean mIsIsolatedProcess;
    private final String mServiceName;
    private boolean mSupportChildProcessApk;

    public ChildProcessServiceWrapper(Intent intent, Service service, Context context) {
        String str;
        IBinder iBinder;
        long j3;
        long j16;
        long j17;
        long j18;
        long currentTimeMillis;
        long currentTimeMillis2 = System.currentTimeMillis();
        String simpleName = service.getClass().getSimpleName();
        this.mServiceName = simpleName;
        Bundle extras = intent.getExtras();
        String string = extras.getString(EXTRA_APK_VERSION, "");
        this.mApkVersion = string;
        String string2 = extras.getString(EXTRA_PROCESS_NAME, context.getPackageName());
        this.mBrowserProcessName = string2;
        IBinder binder = extras.getBinder("preConnection");
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            this.mIsIsolatedProcess = isIsolatedProcess();
            x0.d(TAG, "create, isIsolatedProcess:" + this.mIsIsolatedProcess + ", browserProcess:" + string2 + ", serviceName:" + simpleName);
            if (this.mIsIsolatedProcess) {
                XWalkEnvironment.initInChildProcess(context, true);
                long currentTimeMillis3 = System.currentTimeMillis();
                OaidMonitor.binderTransact(binder, 2, obtain, obtain2, 0);
                if (obtain2.readInt() == 1) {
                    ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obtain2.readParcelable(getClass().getClassLoader());
                    ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) obtain2.readParcelable(getClass().getClassLoader());
                    if (XWebChildProcessHelper.getCrashDumpFileCallback() != null) {
                        XWebChildProcessHelper.getCrashDumpFileCallback().setupIsolatedProcessCrashDumpFiles(parcelFileDescriptor, parcelFileDescriptor2);
                    } else {
                        x0.f(TAG, "create, crash dump callback is null");
                    }
                }
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                long currentTimeMillis5 = System.currentTimeMillis();
                OaidMonitor.binderTransact(binder, 4, obtain, obtain2, 0);
                boolean z16 = true;
                if (obtain2.readInt() != 1) {
                    z16 = false;
                }
                this.mSupportChildProcessApk = z16;
                x0.f(TAG, "create, supportChildProcessApk:" + this.mSupportChildProcessApk);
                if (!this.mSupportChildProcessApk) {
                    OaidMonitor.binderTransact(binder, 0, obtain, obtain2, 0);
                }
                ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) obtain2.readParcelable(getClass().getClassLoader());
                Os.lseek(parcelFileDescriptor3.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                ByteBuffer[] readDexFileFromApk = readDexFileFromApk(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor3));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("create, Build.VERSION.SDK_INT:");
                int i3 = Build.VERSION.SDK_INT;
                sb5.append(i3);
                x0.f(TAG, sb5.toString());
                if (i3 >= 27) {
                    this.mClassLoader = new InMemoryDexClassLoader(readDexFileFromApk, ClassLoader.getSystemClassLoader());
                } else if (i3 == 26) {
                    this.mClassLoader = ClassLoader.getSystemClassLoader();
                    for (ByteBuffer byteBuffer : readDexFileFromApk) {
                        this.mClassLoader = new InMemoryDexClassLoader(byteBuffer, this.mClassLoader);
                    }
                }
                if (this.mClassLoader != null) {
                    x0.d(TAG, "create, dexClassLoader:" + this.mClassLoader);
                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                    x0.d(TAG, "create, class loader costTime:" + currentTimeMillis6);
                    long currentTimeMillis7 = System.currentTimeMillis();
                    createChildProcessService(service, context);
                    long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis7;
                    x0.d(TAG, "create, child process service costTime:" + currentTimeMillis8);
                    long currentTimeMillis9 = System.currentTimeMillis();
                    loadXWebLibraryInIsolatedProcess(context, binder, obtain, obtain2);
                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis9;
                    x0.d(TAG, "create, load native library costTime:" + currentTimeMillis10);
                    if (supportLoadFfmpegSo()) {
                        j18 = currentTimeMillis6;
                        j16 = currentTimeMillis8;
                        j3 = currentTimeMillis10;
                        j17 = currentTimeMillis4;
                        currentTimeMillis = 0;
                    } else {
                        long currentTimeMillis11 = System.currentTimeMillis();
                        setCustomFont(binder, obtain, obtain2);
                        j18 = currentTimeMillis6;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis11;
                        j16 = currentTimeMillis8;
                        j3 = currentTimeMillis10;
                        j17 = currentTimeMillis4;
                    }
                } else {
                    x0.c(TAG, "create, class loader is null");
                    throw new IllegalStateException("InvalidClassLoader");
                }
            } else {
                XWalkEnvironment.initInChildProcess(context, false);
                String processType = getProcessType();
                long currentTimeMillis12 = System.currentTimeMillis();
                if (XWebChildProcessHelper.getCrashDumpFileCallback() != null) {
                    if (PROCESS_TYPE_RENDER.equals(processType)) {
                        str = "create, class loader is null";
                        iBinder = binder;
                        XWebChildProcessHelper.getCrashDumpFileCallback().setupChildProcessCrashDumpFiles(string2, XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_RENDER_UNSANDBOX);
                    } else {
                        str = "create, class loader is null";
                        iBinder = binder;
                        if (PROCESS_TYPE_GPU.equalsIgnoreCase(processType)) {
                            XWebChildProcessHelper.getCrashDumpFileCallback().setupChildProcessCrashDumpFiles(string2, XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_GPU);
                        }
                    }
                } else {
                    str = "create, class loader is null";
                    iBinder = binder;
                    x0.f(TAG, "create, crash dump callback is null");
                }
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis12;
                long currentTimeMillis14 = System.currentTimeMillis();
                ClassLoader childProcessDexClassLoader = XWebClassLoaderWrapper.getChildProcessDexClassLoader(Integer.parseInt(string));
                this.mClassLoader = childProcessDexClassLoader;
                this.mSupportChildProcessApk = childProcessDexClassLoader != null;
                x0.f(TAG, "create, supportChildProcessApk:" + this.mSupportChildProcessApk);
                if (!this.mSupportChildProcessApk) {
                    this.mClassLoader = XWebClassLoaderWrapper.getXWebClassLoader(Integer.parseInt(string));
                }
                if (this.mClassLoader != null) {
                    x0.d(TAG, "create, dexClassLoader:" + this.mClassLoader);
                    long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis14;
                    x0.d(TAG, "create, class loader costTime:" + currentTimeMillis15);
                    long currentTimeMillis16 = System.currentTimeMillis();
                    createChildProcessService(service, context);
                    long currentTimeMillis17 = System.currentTimeMillis() - currentTimeMillis16;
                    x0.d(TAG, "create, child process service costTime:" + currentTimeMillis17);
                    long currentTimeMillis18 = System.currentTimeMillis();
                    loadXWebLibraryInNonIsolatedProcess(u0.j(Integer.parseInt(string)) + File.separator + XWalkEnvironment.PINUS_SO_NAME);
                    long currentTimeMillis19 = System.currentTimeMillis() - currentTimeMillis18;
                    x0.d(TAG, "create, load native library costTime:" + currentTimeMillis19);
                    if (supportLoadFfmpegSo()) {
                        j3 = currentTimeMillis19;
                        j16 = currentTimeMillis17;
                        j17 = currentTimeMillis13;
                        j18 = currentTimeMillis15;
                        currentTimeMillis = 0;
                    } else {
                        long currentTimeMillis20 = System.currentTimeMillis();
                        if (PROCESS_TYPE_RENDER.equals(processType)) {
                            setCustomFont(iBinder, obtain, obtain2);
                        }
                        j3 = currentTimeMillis19;
                        j16 = currentTimeMillis17;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis20;
                        j17 = currentTimeMillis13;
                        j18 = currentTimeMillis15;
                    }
                } else {
                    x0.c(TAG, str);
                    throw new IllegalStateException("InvalidClassLoader");
                }
            }
            long currentTimeMillis21 = System.currentTimeMillis() - currentTimeMillis2;
            long applicationStartTime = currentTimeMillis2 - XWebSdk.getApplicationStartTime();
            e.a(getApkVersion(), this.mIsIsolatedProcess, this.mBrowserProcessName, getProcessType(), applicationStartTime, currentTimeMillis21, j18, j3, ((((currentTimeMillis21 - j18) - j3) - j17) - currentTimeMillis) - j16, j17, currentTimeMillis, j16);
            x0.d(TAG, "create, create service wrapper costTime:" + currentTimeMillis21 + ", applicationToServiceGap:" + applicationStartTime);
        } catch (Throwable th5) {
            String stackTraceString = Log.getStackTraceString(th5);
            x0.a(TAG, "create, error", th5);
            d.a(getApkVersion(), this.mIsIsolatedProcess, this.mBrowserProcessName, 4, getProcessType(), stackTraceString);
            if (this.mIsIsolatedProcess) {
                return;
            }
            setMultiProcessDowngradeByException(stackTraceString);
        }
    }

    private void createChildProcessService(Service service, Context context) throws Exception {
        if (!createChildProcessServiceByCustom(service, context)) {
            createChildProcessServiceByChromium(service, context);
        }
    }

    private void createChildProcessServiceByChromium(Service service, Context context) throws Exception {
        x0.d(TAG, "createChildProcessServiceByChromium, start");
        this.mChildProcessService = this.mClassLoader.loadClass("org.chromium.content_public.app.ChildProcessServiceFactory").getMethod(OperateCustomButton.OPERATE_CREATE, Service.class, Context.class).invoke(null, service, context);
    }

    private boolean createChildProcessServiceByCustom(Service service, Context context) {
        try {
            x0.d(TAG, "createChildProcessServiceByCustom, start");
            this.mChildProcessService = this.mClassLoader.loadClass("com.tencent.xweb.pinus.PSViewDelegate").getMethod("createChildProcessService", Service.class, Context.class).invoke(null, service, context);
            return true;
        } catch (Exception e16) {
            x0.f(TAG, "createChildProcessServiceByCustom, error:" + e16);
            return false;
        }
    }

    private int getApkVersion() {
        a0.a c16 = a0.c(this.mApkVersion);
        if (c16.f121611a) {
            return c16.b();
        }
        return -1;
    }

    private Class<?> getChildProcessServiceClass() {
        Class<?> cls = this.mChildProcessServiceClass;
        if (cls != null) {
            return cls;
        }
        ClassLoader classLoader = this.mClassLoader;
        if (classLoader != null) {
            try {
                Class<?> loadClass = classLoader.loadClass("org.chromium.base.process_launcher.ChildProcessService");
                this.mChildProcessServiceClass = loadClass;
                return loadClass;
            } catch (Throwable th5) {
                x0.c(TAG, "getChildProcessServiceClass error:" + Log.getStackTraceString(th5));
                return null;
            }
        }
        return null;
    }

    private String getProcessType() {
        String str = this.mServiceName;
        if (str != null) {
            if (str.contains("SandboxedProcessService")) {
                return PROCESS_TYPE_RENDER;
            }
            if (this.mServiceName.contains("PrivilegedProcessService")) {
                return PROCESS_TYPE_GPU;
            }
            return "";
        }
        return "";
    }

    private boolean hasFeature(int i3) {
        Object invokeRuntimeChannel = invokeRuntimeChannel(80003, new Object[]{Integer.valueOf(i3)});
        if (!(invokeRuntimeChannel instanceof Boolean)) {
            return false;
        }
        return ((Boolean) invokeRuntimeChannel).booleanValue();
    }

    public static boolean isIsolatedProcess() {
        boolean isIsolated;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                isIsolated = Process.isIsolated();
                return isIsolated;
            }
            return ((Boolean) Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable th5) {
            x0.a(TAG, "isIsolatedProcess, error:", th5);
            throw new RuntimeException(th5);
        }
    }

    private void loadXWebLibraryInIsolatedProcess(Context context, IBinder iBinder, Parcel parcel, Parcel parcel2) throws Exception {
        String findLibrary = LibraryLoader.findLibrary(context, "xweb_linker");
        OaidMonitor.binderTransact(iBinder, 1, parcel, parcel2, 0);
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) parcel2.readParcelable(getClass().getClassLoader());
        Os.lseek(parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
        String str = "app_xwalk_" + this.mApkVersion + "/extracted_xwalkcore/libxwebcore.so";
        if (PinusStandAloneChannel.getInstance().supportLoadXWebLibraryInRuntime(this.mClassLoader)) {
            x0.d(TAG, "loadXWebLibraryInIsolatedProcess, from runtime, libPath:" + str + ", linkerPath:" + findLibrary);
            Class<?> loadClass = this.mClassLoader.loadClass("com.tencent.xweb.pinus.PSViewDelegate");
            Class<?> cls = Boolean.TYPE;
            x0.d(TAG, "loadXWebLibraryInIsolatedProcess, result:" + loadClass.getMethod("loadXWebLibraryInIsolatedProcess", String.class, cls, Integer.TYPE, cls, String.class).invoke(null, str, Boolean.FALSE, Integer.valueOf(parcelFileDescriptor.detachFd()), Boolean.TRUE, findLibrary));
            return;
        }
        JNIUtils.setClassLoader(this.mClassLoader);
        if (this.mSupportChildProcessApk) {
            JNIUtils.enableSelectiveJniRegistration();
        }
        x0.d(TAG, "loadXWebLibraryInIsolatedProcess, from sdk, libPath:" + str);
        Linker.getInstance().loadLibraryByFd(str, false, parcelFileDescriptor.detachFd(), true);
    }

    private void loadXWebLibraryInNonIsolatedProcess(String str) throws Exception {
        if (PinusStandAloneChannel.getInstance().supportLoadXWebLibraryInRuntime(this.mClassLoader)) {
            x0.d(TAG, "loadXWebLibraryInNonIsolatedProcess, from runtime, libPath:" + str);
            x0.d(TAG, "loadXWebLibraryInNonIsolatedProcess, result:" + this.mClassLoader.loadClass("com.tencent.xweb.pinus.PSViewDelegate").getMethod("loadXWebLibraryInNonIsolatedProcess", String.class).invoke(null, str));
            return;
        }
        JNIUtils.setClassLoader(this.mClassLoader);
        if (this.mSupportChildProcessApk) {
            JNIUtils.enableSelectiveJniRegistration();
        }
        x0.d(TAG, "loadXWebLibraryInNonIsolatedProcess, from sdk, libPath:" + str);
        System.load(str);
    }

    public static ByteBuffer[] readDexFileFromApk(FileInputStream fileInputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                zipInputStream.close();
                ByteBuffer[] byteBufferArr = new ByteBuffer[arrayList.size()];
                arrayList.toArray(byteBufferArr);
                return byteBufferArr;
            }
            if (nextEntry.getName().endsWith(QZonePatchService.PATCH_SUFFIX_DEX)) {
                x0.d(TAG, "readDexFileFromApk, dexFile:" + nextEntry.getName());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                arrayList.add(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
            }
            zipInputStream.closeEntry();
        }
    }

    private void setCustomFont(IBinder iBinder, Parcel parcel, Parcel parcel2) throws Exception {
        boolean z16;
        OaidMonitor.binderTransact(iBinder, 3, parcel, parcel2, 0);
        if (parcel2.readInt() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        x0.d(TAG, "setCustomFont, custom font exist:" + z16);
        if (z16) {
            this.mClassLoader.loadClass("com.tencent.xweb.XWebCommJni").getMethod("SetCustomFontFD", Integer.TYPE).invoke(null, Integer.valueOf(((ParcelFileDescriptor) parcel2.readParcelable(getClass().getClassLoader())).detachFd()));
        }
    }

    private void setMultiProcessDowngradeByException(String str) {
        if (str.startsWith("android.os.DeadObjectException") && str.contains("setCustomFont")) {
            XWebChildProcessMonitor.setShouldSwitchToSys(true, "SetCustomFontError");
            return;
        }
        if (str.startsWith("java.lang.reflect.InvocationTargetException") && str.contains("loadXWebLibraryInNonIsolatedProcess")) {
            XWebChildProcessMonitor.setShouldSwitchToSys(true, "LoadXWebLibraryError");
        } else if (str.startsWith("java.lang.IllegalStateException") && str.contains("InvalidClassLoader")) {
            XWebChildProcessMonitor.setShouldSwitchToSys(true, "InvalidClassloaderError");
        } else {
            XWebChildProcessMonitor.setShouldSwitchToSys(true, "SdkUnknownError");
        }
    }

    private boolean supportLoadFfmpegSo() {
        return hasFeature(5);
    }

    public Class<?> getBridgeClass(String str) {
        try {
            ClassLoader classLoader = this.mClassLoader;
            if (classLoader != null) {
                return classLoader.loadClass("com.tencent.xweb.pinus." + str);
            }
            x0.f(TAG, "getBridgeClass, classloader is null");
            return null;
        } catch (Throwable th5) {
            x0.f(TAG, "getBridgeClass failed, class:" + str + ", error:" + th5);
            return null;
        }
    }

    public Object invokeRuntimeChannel(int i3, Object[] objArr) {
        try {
            Class<?> bridgeClass = getBridgeClass("PSViewDelegate");
            if (bridgeClass == null) {
                x0.f(TAG, "invokeRuntimeChannel, clazz is null");
                return null;
            }
            return new g0((Class) bridgeClass, "invokeRuntimeChannel", Integer.TYPE, Object[].class).a(Integer.valueOf(i3), objArr);
        } catch (Throwable th5) {
            x0.a(TAG, "invokeRuntimeChannel error", th5);
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        try {
            x0.d(TAG, "onBind, call");
            return (IBinder) getChildProcessServiceClass().getMethod("onBind", Intent.class).invoke(this.mChildProcessService, intent);
        } catch (Throwable th5) {
            String stackTraceString = Log.getStackTraceString(th5);
            x0.a(TAG, "onBind, error", th5);
            d.a(getApkVersion(), this.mIsIsolatedProcess, this.mBrowserProcessName, 2, getProcessType(), stackTraceString);
            return null;
        }
    }

    public void onCreate() {
        try {
            x0.d(TAG, "onCreate, call");
            getChildProcessServiceClass().getMethod("onCreate", new Class[0]).invoke(this.mChildProcessService, new Object[0]);
        } catch (Throwable th5) {
            String stackTraceString = Log.getStackTraceString(th5);
            x0.a(TAG, "onCreate, error", th5);
            d.a(getApkVersion(), this.mIsIsolatedProcess, this.mBrowserProcessName, 1, getProcessType(), stackTraceString);
        }
    }

    public void onDestroy() {
        try {
            x0.d(TAG, "onDestroy, call");
            getChildProcessServiceClass().getMethod(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Class[0]).invoke(this.mChildProcessService, new Object[0]);
        } catch (Throwable th5) {
            String stackTraceString = Log.getStackTraceString(th5);
            x0.a(TAG, "onDestroy, error", th5);
            d.a(getApkVersion(), this.mIsIsolatedProcess, this.mBrowserProcessName, 3, getProcessType(), stackTraceString);
        }
    }
}
