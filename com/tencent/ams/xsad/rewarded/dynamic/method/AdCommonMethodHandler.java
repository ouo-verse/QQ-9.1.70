package com.tencent.ams.xsad.rewarded.dynamic.method;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.utils.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdCommonMethodHandler implements DKMethodHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final RewardedAdListener f71792d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f71793e;

    /* renamed from: f, reason: collision with root package name */
    private final a f71794f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.ams.xsad.rewarded.view.a f71795h;

    /* renamed from: i, reason: collision with root package name */
    private View f71796i;

    /* renamed from: m, reason: collision with root package name */
    private long f71797m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface AdCommonEvent {
        public static final String CLICK_ACTION = "clickAction";
        public static final String HIPPY_INIT_FINISHED = "hippyInitFinished";
        public static final String ON_DIALOG_CLICKED = "onDialogClicked";
        public static final String ON_DIALOG_SHOW = "onDialogShow";
        public static final String ON_EFFECT_EXPOSURE = "onEffectExposure";
        public static final String ON_TICK = "onTick";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface AdCommonEventParamsKey {
        public static final String CLICK_TYPE = "click_type";
        public static final String DOWN_X = "down_x";
        public static final String DOWN_Y = "down_y";
        public static final String EXTRA = "extra";
        public static final String POSITION = "position";
        public static final String TYPE = "type";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public AdCommonMethodHandler(Context context, RewardedAdListener rewardedAdListener) {
        this(context, rewardedAdListener, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rewardedAdListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.ams.xsad.rewarded.view.a d() {
        Activity activityFromContext;
        if (this.f71795h == null && (activityFromContext = DynamicUtils.getActivityFromContext(this.f71793e)) != null) {
            this.f71795h = new com.tencent.ams.xsad.rewarded.view.a(activityFromContext);
        }
        return this.f71795h;
    }

    private void e(DKMethodHandler.Callback callback) {
        RewardedAdListener rewardedAdListener = this.f71792d;
        if (rewardedAdListener != null) {
            rewardedAdListener.we();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void f(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        a aVar = this.f71794f;
        if (aVar != null) {
            aVar.a();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void g(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("AdCommonMethodHandler", "handleOnDialogClicked, params: " + jSONObject);
        if (this.f71792d != null && jSONObject != null) {
            boolean z16 = true;
            if (jSONObject.optInt("position") != 1) {
                z16 = false;
            }
            DynamicUtils.runOnUiThread(new Runnable(z16) { // from class: com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f71800d;

                {
                    this.f71800d = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AdCommonMethodHandler.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        AdCommonMethodHandler.this.f71792d.gb(AdCommonMethodHandler.this.d(), this.f71800d);
                    }
                }
            });
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("AdCommonMethodHandler", "handleOnDialogShow, params: " + jSONObject);
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("status");
            int optInt = jSONObject.optInt("type", 0);
            RewardedAdListener rewardedAdListener = this.f71792d;
            if (rewardedAdListener != null) {
                if (optBoolean) {
                    rewardedAdListener.S7(d());
                    if (optInt != 0) {
                        rewardedAdListener.A1(d(), jSONObject);
                    }
                } else {
                    rewardedAdListener.D2();
                }
            }
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void i(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (jSONObject != null) {
            long optDouble = (long) (jSONObject.optDouble("position") * 1000.0d);
            this.f71797m = optDouble;
            RewardedAdListener rewardedAdListener = this.f71792d;
            if (rewardedAdListener != null) {
                rewardedAdListener.Od((int) optDouble);
            }
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void j(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("AdCommonMethodHandler", "hippy clickAction, params: " + jSONObject);
        RewardedAdListener rewardedAdListener = this.f71792d;
        if (rewardedAdListener != null) {
            rewardedAdListener.Ab(k(jSONObject));
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private RewardedAdListener.ClickInfo k(JSONObject jSONObject) {
        float measuredWidth;
        RewardedAdListener.ClickInfo clickInfo = new RewardedAdListener.ClickInfo();
        if (jSONObject != null) {
            clickInfo.f71716a = jSONObject.optInt("click_type");
            clickInfo.f71717b = jSONObject.optInt(AdCommonEventParamsKey.DOWN_X);
            clickInfo.f71718c = jSONObject.optInt(AdCommonEventParamsKey.DOWN_Y);
            clickInfo.f71722g = jSONObject.optJSONObject("extra");
        }
        View view = this.f71796i;
        clickInfo.f71721f = view;
        float f16 = 0.0f;
        if (view == null) {
            measuredWidth = 0.0f;
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        clickInfo.f71719d = measuredWidth;
        View view2 = this.f71796i;
        if (view2 != null) {
            f16 = view2.getMeasuredHeight();
        }
        clickInfo.f71720e = f16;
        return clickInfo;
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AdCommon";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        if (r10.equals(com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW) == false) goto L14;
     */
    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, dKEngine, str, jSONObject, callback)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            c.e("AdCommonMethodHandler", "methodName is empty.");
            return false;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1886600294:
                if (str.equals(AdCommonEvent.HIPPY_INIT_FINISHED)) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1417277920:
                if (str.equals(AdCommonEvent.ON_DIALOG_CLICKED)) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1012937700:
                if (str.equals(AdCommonEvent.ON_TICK)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 811723230:
                if (str.equals(AdCommonEvent.CLICK_ACTION)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1526473079:
                if (str.equals(AdCommonEvent.ON_EFFECT_EXPOSURE)) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1955514276:
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                f(jSONObject, callback);
                return true;
            case 1:
                g(jSONObject, callback);
                return true;
            case 2:
                i(jSONObject, callback);
                return true;
            case 3:
                j(jSONObject, callback);
                return true;
            case 4:
                e(callback);
                return false;
            case 5:
                DynamicUtils.runOnUiThread(new Runnable(jSONObject, callback) { // from class: com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ JSONObject f71798d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ DKMethodHandler.Callback f71799e;

                    {
                        this.f71798d = jSONObject;
                        this.f71799e = callback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AdCommonMethodHandler.this, jSONObject, callback);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            AdCommonMethodHandler.this.h(this.f71798d, this.f71799e);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return true;
            default:
                return false;
        }
    }

    public void l(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.f71796i = view;
        }
    }

    public AdCommonMethodHandler(Context context, RewardedAdListener rewardedAdListener, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, rewardedAdListener, aVar);
            return;
        }
        this.f71793e = context;
        this.f71792d = rewardedAdListener;
        this.f71794f = aVar;
    }
}
