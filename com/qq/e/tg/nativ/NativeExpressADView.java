package com.qq.e.tg.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.nativ.NativeExpressAD;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NativeExpressADView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private NEADVI f40554a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40555b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f40556c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f40557d;

    /* renamed from: e, reason: collision with root package name */
    private NativeExpressMediaListener f40558e;
    public Map<String, String> ext;

    /* renamed from: f, reason: collision with root package name */
    private AdData f40559f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f40560g;

    public NativeExpressADView(final NEADI neadi, final Context context, final ADSize aDSize, final String str, final String str2, final JSONObject jSONObject, final HashMap<String, JSONObject> hashMap) {
        super(context);
        this.f40555b = false;
        this.f40556c = false;
        this.f40557d = false;
        this.ext = new HashMap();
        this.f40560g = false;
        this.f40559f = a(hashMap);
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.nativ.NativeExpressADView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.NATIVE_EXPRESS_AD);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.nativ.NativeExpressADView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        NativeExpressADView nativeExpressADView = NativeExpressADView.this;
                                        nativeExpressADView.f40554a = pOFactory2.getNativeExpressADView(neadi, context, nativeExpressADView, aDSize, str, str2, jSONObject, hashMap);
                                        NativeExpressADView.a(NativeExpressADView.this, true);
                                        if (NativeExpressADView.this.f40558e != null) {
                                            NativeExpressADView nativeExpressADView2 = NativeExpressADView.this;
                                            nativeExpressADView2.setMediaListener(nativeExpressADView2.f40558e);
                                        }
                                        if (NativeExpressADView.this.f40556c) {
                                            NativeExpressADView.this.preloadVideo();
                                        }
                                        if (NativeExpressADView.this.f40557d) {
                                            NativeExpressADView.this.render();
                                        }
                                        if (NativeExpressADView.this.f40560g) {
                                            NativeExpressADView.this.negativeFeedback();
                                        }
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        });
                        return;
                    } catch (Throwable th5) {
                        GDTLogger.e("Exception while init Native Express AD View plugin", th5);
                        return;
                    }
                }
                GDTLogger.e("Fail to init ADManager");
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static AdData a(HashMap<String, JSONObject> hashMap) {
        JSONObject jSONObject;
        Object obj;
        if (hashMap != null) {
            try {
                jSONObject = hashMap.get(Constants.KEYS.AD_INFO);
            } catch (JSONException e16) {
                GDTLogger.e(e16.getMessage());
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            obj = jSONObject.get(Constants.KEYS.AD_INFO);
            if (obj instanceof AdData) {
                return null;
            }
            return (AdData) obj;
        }
        obj = null;
        if (obj instanceof AdData) {
        }
    }

    public void destroy() {
        NEADVI neadvi = this.f40554a;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    public AdData getBoundData() {
        return this.f40559f;
    }

    public void negativeFeedback() {
        if (!this.f40555b) {
            this.f40560g = true;
            return;
        }
        NEADVI neadvi = this.f40554a;
        if (neadvi != null) {
            neadvi.reportAdNegative();
            this.f40560g = false;
        } else {
            GDTLogger.e("Native Express negativeFeedback  core is null");
        }
    }

    public void pause() {
        NEADVI neadvi = this.f40554a;
        if (neadvi != null) {
            neadvi.pause();
        }
    }

    public void preloadVideo() {
        if (!this.f40555b) {
            this.f40556c = true;
            return;
        }
        NEADVI neadvi = this.f40554a;
        if (neadvi != null) {
            neadvi.preloadVideo();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void render() {
        if (!this.f40555b) {
            this.f40557d = true;
            return;
        }
        NEADVI neadvi = this.f40554a;
        if (neadvi != null) {
            neadvi.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void resume() {
        NEADVI neadvi = this.f40554a;
        if (neadvi != null) {
            neadvi.resume();
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.f40554a;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.f40558e = nativeExpressMediaListener;
        NEADVI neadvi = this.f40554a;
        if (neadvi != null && nativeExpressMediaListener != null) {
            neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    static /* synthetic */ boolean a(NativeExpressADView nativeExpressADView, boolean z16) {
        nativeExpressADView.f40555b = true;
        return true;
    }
}
