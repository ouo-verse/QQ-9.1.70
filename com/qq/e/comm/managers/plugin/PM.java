package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class PM {
    public static final String APK_DOWNLOADER = "apkDownloader";
    public static final String BANNER_AD = "bannerAD";
    public static final String BASE = "base";
    public static final String CANVAS = "canvas";
    public static final String INTERSITIAL_AD = "intersitialAD";
    public static final String NATIVE_AD = "nativeAD";
    public static final String NATIVE_EXPRESS_AD = "nativeExpressAD";
    public static final String NATIVE_UNIFIED_AD = "nativeunifiedAD";
    public static final String REWARD_AD = "rewardAD";
    public static final String SPLASH_AD = "splashAD";

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f38177e;

    /* renamed from: g, reason: collision with root package name */
    private static final Map<String, String> f38178g = new HashMap<String, String>() { // from class: com.qq.e.comm.managers.plugin.PM.1
        {
            put(PM.BASE, "com.qq.e.comm.plugin.factory.BasePOFactoryImpl");
            put(PM.SPLASH_AD, "com.qq.e.comm.plugin.factory.SplashPOFactoryImpl");
            put(PM.REWARD_AD, "com.qq.e.comm.plugin.factory.RewardPOFactoryImpl");
            put(PM.NATIVE_UNIFIED_AD, "com.qq.e.comm.plugin.factory.NativeUnifiedPOFactoryImpl");
            put(PM.NATIVE_EXPRESS_AD, "com.qq.e.comm.plugin.factory.NativeExpressPOFactoryImpl");
            put(PM.NATIVE_AD, "com.qq.e.comm.plugin.factory.NativePOFactoryImpl");
            put(PM.INTERSITIAL_AD, "com.qq.e.comm.plugin.factory.IntersitialPOFactoryImpl");
            put(PM.BANNER_AD, "com.qq.e.comm.plugin.factory.BannerPOFactoryImpl");
            put(PM.APK_DOWNLOADER, "com.qq.e.comm.plugin.factory.GDTApkDownloaderPOFactoryImpl");
            put(PM.CANVAS, "com.qq.e.comm.plugin.factory.CanvasPOFactoryImpl");
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final Context f38179a;

    /* renamed from: c, reason: collision with root package name */
    private a.InterfaceC0276a f38181c;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f38180b = 3154;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f38182d = false;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, POFactory> f38183f = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public interface InterfaceC0276a {
        }
    }

    public PM(Context context, a.InterfaceC0276a interfaceC0276a) {
        this.f38179a = context.getApplicationContext();
        this.f38181c = interfaceC0276a;
        f38177e = false;
        if (GDTADManager.getInstance().getSM() != null) {
            GDTADManager.getInstance().getSM().getInteger("needLoadHippySo", 1);
        }
    }

    private <T> T a(Class<T> cls) throws com.qq.e.comm.managers.plugin.a {
        ClassLoader pluginClassLoader = getPluginClassLoader();
        if (pluginClassLoader == null) {
            com.qq.e.comm.managers.plugin.a aVar = new com.qq.e.comm.managers.plugin.a("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
            autoRollbackPlugin(aVar.toString());
            throw aVar;
        }
        try {
            Class<?> loadClass = pluginClassLoader.loadClass("com.qq.e.comm.plugin.factory.BasePOFactoryImpl");
            return cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
        } catch (Throwable th5) {
            autoRollbackPlugin(th5.toString());
            throw new com.qq.e.comm.managers.plugin.a("Fail to getfactory implement instance for interface:" + cls.getName(), th5);
        }
    }

    public String getLocalSig() {
        return null;
    }

    public POFactory getPOFactory() throws com.qq.e.comm.managers.plugin.a {
        ConcurrentHashMap<String, POFactory> concurrentHashMap = this.f38183f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(BASE)) {
            synchronized (POFactory.class) {
                ConcurrentHashMap<String, POFactory> concurrentHashMap2 = this.f38183f;
                if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(BASE)) {
                    this.f38183f.putIfAbsent(BASE, (POFactory) a(POFactory.class));
                }
            }
        }
        return this.f38183f.get(BASE);
    }

    public ClassLoader getPluginClassLoader() {
        return getClass().getClassLoader();
    }

    public int getPluginVersion() {
        return 3154;
    }

    private <T> T a(String str) throws com.qq.e.comm.managers.plugin.a {
        ClassLoader pluginClassLoader = getPluginClassLoader();
        if (pluginClassLoader == null) {
            com.qq.e.comm.managers.plugin.a aVar = new com.qq.e.comm.managers.plugin.a("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for---");
            autoRollbackPlugin(aVar.toString());
            throw aVar;
        }
        try {
            String str2 = f38178g.get(str);
            if (StringUtil.isEmpty(str2)) {
                throw new com.qq.e.comm.managers.plugin.a("factory  implemention name is not specified for interface:" + str);
            }
            T t16 = (T) pluginClassLoader.loadClass(str2).newInstance();
            GDTLogger.d("ServiceDelegateFactory =" + t16);
            return t16;
        } catch (Throwable th5) {
            autoRollbackPlugin(th5.toString());
            throw new com.qq.e.comm.managers.plugin.a("Fail to getfactory implement instance for interface---", th5);
        }
    }

    public POFactory getPOFactory(String str) throws com.qq.e.comm.managers.plugin.a {
        if (getPOFactory() == null) {
            throw new com.qq.e.comm.managers.plugin.a("Fail to getfactory implement instance for interface+++");
        }
        ConcurrentHashMap<String, POFactory> concurrentHashMap = this.f38183f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            synchronized (POFactory.class) {
                ConcurrentHashMap<String, POFactory> concurrentHashMap2 = this.f38183f;
                if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str)) {
                    this.f38183f.putIfAbsent(str, (POFactory) a(str));
                }
            }
        }
        return this.f38183f.get(str);
    }

    public void autoRollbackPlugin(String str) {
    }
}
