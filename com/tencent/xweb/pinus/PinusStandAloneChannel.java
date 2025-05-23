package com.tencent.xweb.pinus;

import android.content.Context;
import com.tencent.luggage.wxa.ar.b;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.wq.n;
import com.tencent.xweb.RuntimeToSdkChannel;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebClassLoaderWrapper;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.pinus.sdk.JNIUtils;
import com.tencent.xweb.pinus.sdk.PSLogChannelListener;
import com.tencent.xweb.pinus.sdk.PSNotifyChannelListener;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class PinusStandAloneChannel {
    private static final int LOADED_ARCH_NOT_MATCH = -1;
    private static final int LOADED_BY_RUNTIME = 1;
    private static final int LOADED_BY_SDK = 0;
    public static final String TAG = "PinusStandAloneChannel";
    private Boolean isSupportLoadXWebLibraryInRuntime;
    private ClassLoader mClassLoader;
    private long mFirstGetClassLoaderCostTime;
    private boolean mHasInited;
    private boolean mInitedResult;

    /* loaded from: classes27.dex */
    public static class SingletonHolder {
        public static final PinusStandAloneChannel sInstance = new PinusStandAloneChannel();

        SingletonHolder() {
        }
    }

    private boolean checkCoreApk() {
        if (!new File(u0.e(XWalkEnvironment.getAvailableVersion())).exists()) {
            x0.c(TAG, "checkCoreApk, apk not exists");
            return false;
        }
        x0.d(TAG, "pinus core apk matched");
        return true;
    }

    public static PinusStandAloneChannel getInstance() {
        return SingletonHolder.sInstance;
    }

    private boolean initCoreBridge() {
        x0.d(TAG, "initCoreBridge start");
        try {
            new g0((Class) getBridgeClass("PSCoreBridge"), "init", Context.class, Object.class).a(null, this);
            return true;
        } catch (Throwable th5) {
            x0.a(TAG, "initCoreBridge error", th5);
            return false;
        }
    }

    private boolean initLogChannel() {
        x0.d(TAG, "initLogChannel start");
        try {
            new g0((Class) getBridgeClass("PSViewDelegate"), "setLogCallBack", Object.class).a(new PSLogChannelListener() { // from class: com.tencent.xweb.pinus.PinusStandAloneChannel.2
                private String resetLogFileByInfo(String str) {
                    if (str != null && str.contains("XWeb.Core.")) {
                        return str.replaceFirst("XWeb.Core.", "");
                    }
                    return str;
                }

                private String resetLogTagByFile(String str) {
                    if (str != null && str.contains("/")) {
                        return "XWeb.Core";
                    }
                    if (str != null && !str.startsWith("XWeb.Core.")) {
                        return "XWeb.Core." + str;
                    }
                    return str;
                }

                @Override // com.tencent.xweb.pinus.sdk.PSLogChannelListener
                public void onLogMessage(int i3, String str, int i16, String str2) {
                    x0.d(resetLogTagByFile(str), resetLogFileByInfo(str2));
                }
            });
            return true;
        } catch (Throwable th5) {
            x0.a(TAG, "setLogCallBack error", th5);
            return false;
        }
    }

    private boolean initNotifyChannel() {
        x0.d(TAG, "initNotifyChannel start");
        try {
            new g0((Class) getBridgeClass("PSViewDelegate"), "setNotifyCallBackChannel", Object.class).a(new PSNotifyChannelListener() { // from class: com.tencent.xweb.pinus.PinusStandAloneChannel.1
                @Override // com.tencent.xweb.pinus.sdk.PSNotifyChannelListener
                public void onNotifyCallBackChannel(int i3, Object[] objArr) {
                    try {
                        if (i3 == 50001) {
                            n0.a(Long.parseLong((String) objArr[0]), Long.parseLong((String) objArr[1]), Integer.parseInt((String) objArr[2]));
                        } else if (i3 == 50002) {
                            n0.a(Integer.parseInt((String) objArr[0]), (String) objArr[1]);
                        } else {
                            x0.d(PinusStandAloneChannel.TAG, "NotifyChannel called funid = " + i3 + " do not match");
                        }
                    } catch (RuntimeException e16) {
                        x0.a(PinusStandAloneChannel.TAG, "NotifyChannel error", e16);
                    }
                }
            });
            return true;
        } catch (Throwable th5) {
            x0.a(TAG, "setNotifyCallBackChannel error", th5);
            return false;
        }
    }

    private boolean initRuntimeToSdkChannel() {
        x0.d(TAG, "initRuntimeToSdkChannel start");
        invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL, RuntimeToSdkChannel.createRuntimeToSdkChannelObject());
        return true;
    }

    private boolean isSupportStandAloneMode() {
        try {
            Object a16 = new g0((Class) getBridgeClass("PSCoreBridge"), "isSupportStandAloneMode", new Class[0]).a(new Object[0]);
            if (!(a16 instanceof Boolean)) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        } catch (Throwable th5) {
            x0.a(TAG, "isSupportStandAloneMode error", th5);
            return false;
        }
    }

    private boolean loadNativeLibrary() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!loadNativeLibraryDefault()) {
            loadNativeLibraryBySDK();
        }
        x0.d(TAG, "###### loadNativeLibrary, costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        return true;
    }

    private boolean loadNativeLibraryBySDK() {
        try {
            loadNativeLibraryInternal();
            if (((Boolean) new g0((Class) getBridgeClass("PSViewDelegate"), "checkCoreArchitecture", new Class[0]).a(new Object[0])).booleanValue()) {
                return true;
            }
            n0.a(191L, 1);
            x0.c(TAG, "Mismatch of CPU architecture current device abi is " + b.a() + ", runtime abi is " + b.b() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
            return false;
        } catch (RuntimeException e16) {
            x0.a(TAG, "checkCoreArchitecture, error", e16);
            x0.c(TAG, "current device abi is " + b.a() + ", runtime abi is " + b.b() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
            return false;
        }
    }

    private boolean loadNativeLibraryDefault() {
        try {
            g0 g0Var = new g0((Class) getBridgeClass("PSViewDelegate"), "loadXWebLibrary", Context.class, String.class);
            if (g0Var.a()) {
                return false;
            }
            int intValue = ((Integer) g0Var.a(XWalkEnvironment.getApplicationContext(), u0.j(XWalkEnvironment.getAvailableVersion()))).intValue();
            x0.d(TAG, "loadXWebLibrary ret:" + intValue);
            if (intValue == 0) {
                return false;
            }
            if (intValue == -1) {
                n0.a(191L, 1);
                n0.a(1749L, 56L, 1L);
                x0.c(TAG, "Mismatch of CPU architecture current device abi is " + b.a() + ", runtime abi is " + b.b() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
            }
            return true;
        } catch (RuntimeException e16) {
            x0.a(TAG, "checkCoreArchitecture, error", e16);
            x0.c(TAG, "current device abi is " + b.a() + ", runtime abi is " + b.b() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
            return true;
        }
    }

    private void loadNativeLibraryInternal() throws RuntimeException {
        try {
            String j3 = u0.j(XWalkEnvironment.getAvailableVersion());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadNativeLibrary, path:");
            sb5.append(j3);
            String str = File.separator;
            sb5.append(str);
            sb5.append(XWalkEnvironment.PINUS_SO_NAME);
            x0.d(TAG, sb5.toString());
            System.load(j3 + str + XWalkEnvironment.PINUS_SO_NAME);
        } catch (Error e16) {
            x0.c(TAG, "loadNativeLibraryInternal, error:" + e16);
            throw new RuntimeException(e16);
        }
    }

    private boolean setStandAloneMode(boolean z16) {
        try {
            new g0((Class) getBridgeClass("PSCoreBridge"), "setStandAloneMode", Boolean.TYPE).a(Boolean.valueOf(z16));
            return true;
        } catch (Throwable th5) {
            x0.a(TAG, "setStandAloneMode error", th5);
            return false;
        }
    }

    private boolean supportLoadXWebLibraryInRuntimeInner(ClassLoader classLoader) {
        try {
            g0 g0Var = new g0((Class) classLoader.loadClass("com.tencent.xweb.pinus.PSViewDelegate"), "supportLoadXWebLibrary", new Class[0]);
            if (g0Var.a()) {
                x0.d(TAG, "supportLoadXWebLibraryInRuntime, no such method");
                return false;
            }
            Object a16 = g0Var.a(new Object[0]);
            if (a16 instanceof Boolean) {
                x0.d(TAG, "supportLoadXWebLibraryInRuntime, result:" + a16);
                return ((Boolean) a16).booleanValue();
            }
            x0.d(TAG, "supportLoadXWebLibraryInRuntime, result:false");
            return false;
        } catch (Exception e16) {
            x0.a(TAG, "supportLoadXWebLibraryInRuntime, error", e16);
            return false;
        }
    }

    public Class<?> getBridgeClass(String str) {
        try {
            ClassLoader classLoader = getClassLoader();
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

    public synchronized ClassLoader getClassLoader() {
        ClassLoader classLoader = this.mClassLoader;
        if (classLoader != null) {
            return classLoader;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.mClassLoader = XWebClassLoaderWrapper.getXWebClassLoader();
            this.mFirstGetClassLoaderCostTime = System.currentTimeMillis() - currentTimeMillis;
            x0.a(TAG, "getClassLoader, classLoader:" + this.mClassLoader + ", costTime:" + this.mFirstGetClassLoaderCostTime);
            return this.mClassLoader;
        } catch (Throwable th5) {
            x0.a(TAG, "getClassLoader error", th5);
            return null;
        }
    }

    public boolean hasFeature(int i3) {
        Object invokeRuntimeChannel = invokeRuntimeChannel(80003, new Object[]{Integer.valueOf(i3)});
        if (!(invokeRuntimeChannel instanceof Boolean)) {
            return false;
        }
        return ((Boolean) invokeRuntimeChannel).booleanValue();
    }

    public synchronized boolean initChannels(boolean z16, boolean z17) {
        if (this.mHasInited) {
            x0.f(TAG, "initChannels, already inited, result:" + this.mInitedResult);
            return this.mInitedResult;
        }
        this.mInitedResult = false;
        n nVar = new n();
        nVar.c();
        nVar.c(WebView.WebViewKind.WV_KIND_PINUS.ordinal());
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        nVar.b(availableVersion);
        nVar.a(z16);
        x0.a(TAG, "initChannels, isStandAloneMode:" + z16 + ", apkVersion:" + availableVersion);
        if (z16) {
            n0.a(1749L, 59L, 1L);
        } else {
            n0.a(1749L, 61L, 1L);
        }
        if (availableVersion == -1) {
            nVar.a(2);
            n0.a(1749L, 49L, 1L);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = getClassLoader();
        if (classLoader == null) {
            nVar.a(3);
            x0.a(TAG, "initChannels, create class loader failed");
            n0.a(1749L, 50L, 1L);
            return false;
        }
        nVar.b(System.currentTimeMillis() - currentTimeMillis);
        nVar.a(this.mFirstGetClassLoaderCostTime);
        if (!supportLoadXWebLibraryInRuntime(classLoader)) {
            JNIUtils.setClassLoader(classLoader);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean initCoreBridge = initCoreBridge();
        x0.a(TAG, "initChannels, initCoreBridgeResult:" + initCoreBridge);
        if (!initCoreBridge) {
            nVar.a(4);
            n0.a(1749L, 51L, 1L);
            return false;
        }
        nVar.c(System.currentTimeMillis() - currentTimeMillis2);
        long currentTimeMillis3 = System.currentTimeMillis();
        if (z16) {
            boolean isSupportStandAloneMode = isSupportStandAloneMode();
            x0.a(TAG, "initChannels, isSupportStandAloneMode:" + isSupportStandAloneMode);
            if (isSupportStandAloneMode) {
                boolean standAloneMode = setStandAloneMode(true);
                x0.a(TAG, "initChannels, setStandAloneModeResult:" + standAloneMode);
                if (!standAloneMode) {
                    nVar.a(5);
                    n0.a(1749L, 57L, 1L);
                    return false;
                }
            } else {
                n0.a(1749L, 58L, 1L);
                x0.a(TAG, "initChannels, enable fullscreen video try runtime:" + z17);
                return z17;
            }
        } else {
            x0.a(TAG, "initChannels, setStandAloneModeResult:" + setStandAloneMode(false));
            boolean loadNativeLibrary = loadNativeLibrary();
            x0.a(TAG, "initChannels, loadLibraryResult:" + loadNativeLibrary);
            if (loadNativeLibrary && checkCoreApk()) {
                nVar.d(System.currentTimeMillis() - currentTimeMillis3);
            }
            nVar.a(5);
            n0.a(1749L, 55L, 1L);
            return false;
        }
        long currentTimeMillis4 = System.currentTimeMillis();
        boolean initNotifyChannel = initNotifyChannel();
        x0.a(TAG, "initChannels, initNotifyChannelResult:" + initNotifyChannel);
        if (!initNotifyChannel) {
            n0.a(1749L, 52L, 1L);
        }
        nVar.f(System.currentTimeMillis() - currentTimeMillis4);
        long currentTimeMillis5 = System.currentTimeMillis();
        x0.a(TAG, "initChannels, initRuntimeToSdkChannelResult:" + initRuntimeToSdkChannel());
        if (!initNotifyChannel) {
            n0.a(1749L, 53L, 1L);
        }
        nVar.g(System.currentTimeMillis() - currentTimeMillis5);
        long currentTimeMillis6 = System.currentTimeMillis();
        x0.a(TAG, "initChannels, initLogChannelResult:" + initLogChannel());
        if (!initNotifyChannel) {
            n0.a(1749L, 54L, 1L);
        }
        nVar.e(System.currentTimeMillis() - currentTimeMillis6);
        this.mHasInited = true;
        this.mInitedResult = true;
        if (z16) {
            n0.a(1749L, 60L, 1L);
        } else {
            n0.a(1749L, 62L, 1L);
        }
        nVar.a(1);
        x0.d(TAG, "###### initChannels, costTime:" + nVar.a());
        return this.mInitedResult;
    }

    public boolean invokeNativeChannel(int i3, Object[] objArr) {
        try {
            x0.d(TAG, "invokeNativeChannel, funid:" + i3);
            new g0((Class) getBridgeClass("PSViewDelegate"), "invokeNativeChannel", Integer.TYPE, Object[].class).a(Integer.valueOf(i3), objArr);
            return true;
        } catch (ClassCircularityError e16) {
            x0.c(TAG, "invokeNativeChannel ClassCircularityError:" + e16);
            n0.d();
            return false;
        } catch (RuntimeException e17) {
            x0.c(TAG, "invokeNativeChannel RuntimeException:" + e17);
            n0.f();
            return false;
        } catch (Throwable th5) {
            x0.a(TAG, "invokeNativeChannel error", th5);
            n0.e();
            return false;
        }
    }

    public Object invokeRuntimeChannel(int i3, Object[] objArr) {
        try {
            return new g0((Class) getBridgeClass("PSViewDelegate"), "invokeRuntimeChannel", Integer.TYPE, Object[].class).a(Integer.valueOf(i3), objArr);
        } catch (ClassCircularityError e16) {
            x0.c(TAG, "invokeRuntimeChannel ClassCircularityError:" + e16);
            n0.d();
            return null;
        } catch (RuntimeException e17) {
            x0.c(TAG, "invokeRuntimeChannel RuntimeException:" + e17);
            n0.f();
            return null;
        } catch (Throwable th5) {
            x0.a(TAG, "invokeRuntimeChannel error", th5);
            n0.e();
            return null;
        }
    }

    public boolean supportLoadXWebLibraryInRuntime(ClassLoader classLoader) {
        if (this.isSupportLoadXWebLibraryInRuntime == null) {
            this.isSupportLoadXWebLibraryInRuntime = Boolean.valueOf(supportLoadXWebLibraryInRuntimeInner(classLoader));
        }
        return this.isSupportLoadXWebLibraryInRuntime.booleanValue();
    }

    PinusStandAloneChannel() {
        this.mHasInited = false;
        this.mInitedResult = false;
        this.mFirstGetClassLoaderCostTime = -1L;
        this.isSupportLoadXWebLibraryInRuntime = null;
    }
}
