package com.qq.e.tg.splash;

import android.content.Context;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.TGSPPIV2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class TGSplashPreloader {

    /* renamed from: a, reason: collision with root package name */
    private volatile TGSPPIV2 f40817a;

    /* renamed from: b, reason: collision with root package name */
    private volatile SplashADPreloadListener f40818b;

    /* renamed from: c, reason: collision with root package name */
    private volatile String f40819c;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f40820d;

    /* renamed from: e, reason: collision with root package name */
    private volatile LoadAdParams f40821e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Context f40822f;

    /* renamed from: g, reason: collision with root package name */
    private ICustomAdDataGenerator f40823g;

    /* loaded from: classes3.dex */
    private class TangramPreloaderListener implements ADListener {
        TangramPreloaderListener() {
        }

        private static boolean a(Object[] objArr, int i3) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[1];
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() == i3) {
                    return true;
                }
            }
            GDTLogger.e("SplashADPreloadListener hashcode not match return");
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        @Override // com.qq.e.comm.adevent.ADListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (TGSplashPreloader.this.f40818b == null) {
                GDTLogger.e("SplashADPreloadListener is null");
                return;
            }
            Object[] paras = aDEvent.getParas();
            if (paras == null) {
                return;
            }
            int hashCode = TGSplashPreloader.this.hashCode();
            int type = aDEvent.getType();
            boolean z16 = true;
            if (type != 1) {
                if (type != 3) {
                    if (type == 4) {
                        if (paras.length > 0 && (paras[0] instanceof PreCacheSplashAd)) {
                            TGSplashPreloader.this.f40818b.onBackupAdSelected((PreCacheSplashAd) paras[0]);
                        } else {
                            str = "SplashADPreloadListener get PreCacheSplashAd error";
                            GDTLogger.e(str);
                        }
                    }
                } else {
                    if (!a(paras, hashCode)) {
                        return;
                    }
                    TGSplashPreloader.this.f40818b.onLoadSuccess();
                    if (z16 && TGSplashPreloader.this.f40817a != null) {
                        TGSplashPreloader.this.f40817a.removeListener(hashCode);
                        return;
                    }
                    return;
                }
            } else {
                if (!a(paras, hashCode)) {
                    return;
                }
                if (paras[0] instanceof Integer) {
                    TGSplashPreloader.this.f40818b.onError(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                    if (z16) {
                        return;
                    } else {
                        return;
                    }
                }
                str = "SplashADPreloadListener get params error";
                GDTLogger.e(str);
            }
            z16 = false;
            if (z16) {
            }
        }

        /* synthetic */ TangramPreloaderListener(TGSplashPreloader tGSplashPreloader, byte b16) {
            this();
        }
    }

    public TGSplashPreloader(Context context, String str, String str2, LoadAdParams loadAdParams) {
        this(context, str, str2, loadAdParams, null);
    }

    public void execute(final SplashADPreloadListener splashADPreloadListener) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashPreloader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GDTADManager gDTADManager = GDTADManager.getInstance();
                    if (gDTADManager != null && gDTADManager.initWith(TGSplashPreloader.this.f40822f, TGSplashPreloader.this.f40819c)) {
                        try {
                            POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.SPLASH_AD);
                            try {
                                if (pOFactory != null) {
                                    TGSplashPreloader.this.f40817a = pOFactory.getTangramSplashPreloader();
                                    if (TGSplashPreloader.this.f40817a == null) {
                                        GDTLogger.e("SplashPreloader created by factory return null");
                                        TGSplashPreloader.a(TGSplashPreloader.this, AdErrorConvertor.ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        return;
                                    }
                                    SplashADPreloadListener splashADPreloadListener2 = splashADPreloadListener;
                                    if (splashADPreloadListener2 != null) {
                                        TGSplashPreloader.this.f40818b = splashADPreloadListener2;
                                        int hashCode = TGSplashPreloader.this.hashCode();
                                        TangramPreloaderListener tangramPreloaderListener = new TangramPreloaderListener(TGSplashPreloader.this, (byte) 0);
                                        TGSplashPreloader.this.f40817a.setPreloadListener(tangramPreloaderListener, hashCode);
                                        TGSplashPreloader.a(TGSplashPreloader.this, tangramPreloaderListener);
                                        return;
                                    }
                                    return;
                                }
                                GDTLogger.e("factory return null");
                                TGSplashPreloader.a(TGSplashPreloader.this, AdErrorConvertor.ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                return;
                            } catch (Throwable th5) {
                                GDTLogger.e("Unknown Exception", th5);
                                TGSplashPreloader.a(TGSplashPreloader.this, 605);
                                return;
                            }
                        } catch (a e16) {
                            GDTLogger.e("Fail to init splash plugin", e16);
                            TGSplashPreloader.a(TGSplashPreloader.this, AdErrorConvertor.ErrorCode.PLUGIN_INIT_ERROR);
                            return;
                        } catch (Throwable th6) {
                            GDTLogger.e("Unknown Exception", th6);
                            TGSplashPreloader.a(TGSplashPreloader.this, 605);
                            return;
                        }
                    }
                    TGSplashPreloader.a(TGSplashPreloader.this, 605);
                } catch (Throwable th7) {
                    GDTLogger.e(th7.getMessage());
                    TGSplashPreloader.a(TGSplashPreloader.this, 605);
                }
            }
        });
    }

    public void pauseAllDownload() {
        if (this.f40817a != null) {
            GDTLogger.i("pauseAllDownload: , posId = " + this.f40820d + ", LoadAdParams = " + this.f40821e.toString());
            this.f40817a.pauseDownload();
            return;
        }
        GDTLogger.e("pauseAllDownload SplashPreloader is null");
    }

    public TGSplashPreloader(Context context, String str, String str2, LoadAdParams loadAdParams, ICustomAdDataGenerator iCustomAdDataGenerator) {
        this.f40822f = context;
        this.f40819c = str;
        this.f40820d = str2;
        this.f40821e = loadAdParams;
        this.f40823g = iCustomAdDataGenerator;
    }

    static /* synthetic */ void a(TGSplashPreloader tGSplashPreloader, int i3) {
        if (tGSplashPreloader.f40818b != null) {
            tGSplashPreloader.f40818b.onError(AdErrorConvertor.formatErrorCode(i3));
        }
    }

    static /* synthetic */ void a(TGSplashPreloader tGSplashPreloader, ADListener aDListener) {
        if (tGSplashPreloader.f40817a == null) {
            GDTLogger.e("SplashPreloader is null");
            return;
        }
        GDTLogger.i("preload AD, appId = " + tGSplashPreloader.f40819c + ", posId = " + tGSplashPreloader.f40820d + ", LoadAdParams = " + tGSplashPreloader.f40821e.toString());
        if (tGSplashPreloader.f40821e != null) {
            tGSplashPreloader.f40821e.setAdListener(aDListener);
        }
        tGSplashPreloader.f40817a.preload(tGSplashPreloader.f40822f, tGSplashPreloader.f40819c, tGSplashPreloader.f40820d, tGSplashPreloader.f40821e, tGSplashPreloader.f40823g);
    }
}
