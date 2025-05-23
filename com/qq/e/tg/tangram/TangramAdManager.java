package com.qq.e.tg.tangram;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADPLI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.TADLDI;
import com.qq.e.comm.pi.TangramExposureCallback;
import com.qq.e.comm.pi.UTI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.TangramExposureChecker;
import com.qq.e.tg.tangram.action.TangramAdActionTrigger;
import com.qq.e.tg.tangram.action.TangramHippyActionTrigger;
import com.qq.e.tg.tangram.ad.TangramAdLoader;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramAdManager {

    /* renamed from: e, reason: collision with root package name */
    private static volatile TangramAdManager f40857e;

    /* renamed from: a, reason: collision with root package name */
    private TADLDI f40858a;

    /* renamed from: b, reason: collision with root package name */
    private UTI f40859b;

    /* renamed from: c, reason: collision with root package name */
    private ADPLI f40860c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40861d = false;

    TangramAdManager() {
    }

    public static TangramAdManager getInstance() {
        if (f40857e == null) {
            synchronized (TangramAdManager.class) {
                if (f40857e == null) {
                    f40857e = new TangramAdManager();
                }
            }
        }
        return f40857e;
    }

    public TangramAdLoader buildAdLoader() {
        TADLDI tadldi = this.f40858a;
        if (tadldi != null) {
            return new TangramAdLoader(tadldi);
        }
        throw new IllegalArgumentException("Tangram ad manager init tangramAdLoaderDelegate failed, please try to call init() again");
    }

    public TangramAdActionTrigger getAdActionTrigger() {
        if (this.f40858a != null) {
            return new TangramAdActionTrigger(this.f40859b);
        }
        throw new IllegalArgumentException("Tangram ad manager init tangramAdLoaderDelegate failed, please try to call init() again");
    }

    public TangramExposureChecker getExposureChecker(JSONObject jSONObject, WeakReference<TangramExposureCallback> weakReference) {
        if (this.f40861d) {
            try {
                POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                if (pOFactory != null) {
                    return new TangramExposureChecker(pOFactory.getTangramExposureChecker(jSONObject, weakReference));
                }
                GDTLogger.e("Exception while get poFactory!");
                return null;
            } catch (Throwable th5) {
                GDTLogger.e("Exception while init tangram ad manager Core", th5);
                return null;
            }
        }
        return null;
    }

    public TangramHippyActionTrigger getHippyActionTrigger() {
        TADLDI tadldi = this.f40858a;
        if (tadldi != null) {
            return new TangramHippyActionTrigger(tadldi, this.f40859b, this.f40860c);
        }
        throw new IllegalArgumentException("Tangram ad manager init tangramAdLoaderDelegate failed, please try to call init() again");
    }

    public void init(Context context, String str, TangramManagerListener tangramManagerListener) {
        if (context != null && !StringUtil.isEmpty(str)) {
            if (GDTADManager.getInstance().initWith(context, str)) {
                try {
                    POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    if (pOFactory != null) {
                        this.f40858a = pOFactory.getTangramAdLoaderDelegate(context, str);
                        this.f40859b = pOFactory.getTangramAdTriggerDelegate();
                        this.f40860c = pOFactory.getAdPreloader();
                        this.f40861d = true;
                        if (tangramManagerListener != null) {
                            tangramManagerListener.onSuccess();
                            return;
                        }
                        return;
                    }
                    if (tangramManagerListener != null) {
                        tangramManagerListener.onError(3);
                    }
                    GDTLogger.e("Exception while get poFactory!");
                    return;
                } catch (Throwable th5) {
                    if (tangramManagerListener != null) {
                        tangramManagerListener.onError(4);
                    }
                    GDTLogger.e("Exception while init tangram ad manager Core", th5);
                    return;
                }
            }
            if (tangramManagerListener != null) {
                tangramManagerListener.onError(1);
            }
            GDTLogger.e("Exception while init sdk!");
            return;
        }
        GDTLogger.e(String.format("TangramAdManager Constructor params error with appID=%s", str));
        if (tangramManagerListener != null) {
            tangramManagerListener.onError(2);
        }
    }
}
