package com.tencent.mobileqq.minigame.ui;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StGamePayRsp;
import NS_MINI_APP_PAY.MiniAppMidasPay$StQueryStarCurrencyRsp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import mqq.app.MobileQQ;
import ne0.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniGamePayFragment extends PublicBaseFragment {
    public static final String MINI_EVENT_NAME = "mini_event_name";
    public static final String MINI_EVENT_SEQ = "mini_event_seq";
    public static final String MINI_RESPONSE_STR = "mini_response_str";
    public static final int PAY_CHANNEL_WECHAT = 8;
    public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
    public static final String TAG = "PayJsPlugin_in_MiniGamePayFragment";
    AppInterface app;
    PayResultRecevicer payRecevicer;

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNativeResponse(String str, String str2, int i3) {
        Intent intent = new Intent();
        intent.putExtra("mini_response_str", str2);
        intent.putExtra("mini_event_name", str);
        intent.putExtra("mini_event_seq", i3);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            baseActivity.setResult(-1, intent);
            baseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    public void invokeMidasQuery(final String str, final String str2, final int i3, final COMM.StCommonExt stCommonExt, final String str3, final int i16, final int i17, final int i18) {
        QLog.d(TAG, 1, "invokeMidasQuery prepayId= " + str + " starCurrency=" + String.valueOf(i3) + " setEnv:" + i17 + " payChannel:" + i18);
        if (!TextUtils.isEmpty(str) && i3 > 0 && !TextUtils.isEmpty(str2)) {
            MiniAppCmdUtil.getInstance().getMidasQueryResult(str, str2, i3, i17, stCommonExt, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.ui.MiniGamePayFragment.1
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    QLog.d(MiniGamePayFragment.TAG, 1, "invokeMidasQuery receive isSuc= " + z16 + " ret=" + String.valueOf(jSONObject));
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject == null) {
                        try {
                            jSONObject2.put(QzoneIPCModule.RESULT_CODE, -1);
                            jSONObject2.put("errMsg", HardCodeUtil.qqStr(R.string.o8k));
                            String jSONObject3 = jSONObject2.toString();
                            if (jSONObject3 != null) {
                                MiniGamePayFragment.this.handleNativeResponse(str3, jSONObject3, i16);
                                return;
                            }
                            return;
                        } catch (JSONException e16) {
                            QLog.e(MiniGamePayFragment.TAG, 1, "invokeMidasQuery JSONException ", e16);
                            return;
                        }
                    }
                    try {
                        MiniAppMidasPay$StQueryStarCurrencyRsp miniAppMidasPay$StQueryStarCurrencyRsp = (MiniAppMidasPay$StQueryStarCurrencyRsp) jSONObject.get("response");
                        int i19 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                        String string = jSONObject.getString("errMsg");
                        int i26 = miniAppMidasPay$StQueryStarCurrencyRsp.remainder.get();
                        int i27 = miniAppMidasPay$StQueryStarCurrencyRsp.rechargeNum.get();
                        QLog.d(MiniGamePayFragment.TAG, 1, "invokeMidasQuery receive resultCode= " + i19 + " errMsg=" + string + " rechargeNum:" + i27 + " remainder:" + i26);
                        if (i19 == 0 && i27 <= 0) {
                            MiniGamePayFragment.this.invokeMidasConsume(str2, str, i3, i26, i27, i18, stCommonExt, str3, i16, i17);
                        } else {
                            jSONObject2.put(QzoneIPCModule.RESULT_CODE, -3);
                            jSONObject2.put("errMsg", HardCodeUtil.qqStr(R.string.o8l));
                        }
                    } catch (Throwable th5) {
                        QLog.e(MiniGamePayFragment.TAG, 1, "invokeMidasQuery failed", th5);
                        try {
                            jSONObject2.put(QzoneIPCModule.RESULT_CODE, -3);
                            jSONObject2.put("errMsg", HardCodeUtil.qqStr(R.string.o8j));
                        } catch (JSONException e17) {
                            QLog.e(MiniGamePayFragment.TAG, 1, "invokeMidasQuery JSONerror", e17);
                        }
                    }
                    MiniGamePayFragment.this.handleNativeResponse(str3, jSONObject2.toString(), i16);
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 1000);
            jSONObject.put("errMsg", HardCodeUtil.qqStr(R.string.o8f));
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 != null) {
                try {
                    handleNativeResponse(str3, jSONObject2, i16);
                } catch (JSONException e16) {
                    e = e16;
                    QLog.e(TAG, 1, "invokeMidasQuery JSONException ", e);
                }
            }
        } catch (JSONException e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        QLog.d(TAG, 1, "MiniGamePayFragment onCreateView");
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.payRecevicer = new PayResultRecevicer(new Handler(Looper.getMainLooper()));
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
            this.app = appInterface;
            int i3 = PayBridgeActivity.newPay(appInterface, getBaseActivity(), this.payRecevicer, 6, arguments).getInt("retCode", -1);
            int i16 = arguments.getInt("mini_event_seq", -1);
            String string = arguments.getString("mini_event_name");
            if (i3 != 0) {
                JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(string, null);
                if (wrapCallbackFail != null) {
                    str = wrapCallbackFail.toString();
                } else {
                    str = "";
                }
                if (str != null) {
                    handleNativeResponse(string, str, i16);
                }
            }
        } else {
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity != null) {
                baseActivity.setResult(0, null);
                baseActivity.finish();
            }
        }
        return null;
    }

    /* loaded from: classes33.dex */
    class PayResultRecevicer extends ResultReceiver {
        public PayResultRecevicer(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult resultCode = " + i3 + " resultData = " + bundle);
            if (i3 != 6) {
                return;
            }
            handlePayResult(i3, bundle, PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_PAYMENT);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:1|(11:(17:3|(31:122|123|124|125|126|127|129|130|132|133|134|135|136|137|138|139|140|10|11|12|13|14|15|16|17|18|19|(1:21)(1:107)|22|23|(11:47|48|49|(3:85|86|(4:93|94|95|96))|51|52|53|(2:55|56)|(1:58)(1:82)|59|(10:61|62|63|64|65|66|67|68|69|70)(2:80|81))(5:25|26|27|28|29))(4:5|6|7|8)|9|10|11|12|13|14|15|16|17|18|19|(0)(0)|22|23|(0)(0))(1:164)|14|15|16|17|18|19|(0)(0)|22|23|(0)(0))|121|10|11|12|13) */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x020f, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0210, code lost:
        
            r25 = r11;
            r22 = cooperation.qzone.QzoneIPCModule.RESULT_CODE;
            r11 = 1;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 21, insn: 0x0197: MOVE (r12 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY]), block:B:101:0x0193 */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x01e2 A[Catch: all -> 0x01f9, TRY_LEAVE, TryCatch #15 {all -> 0x01f9, blocks: (B:69:0x01c7, B:25:0x01e2), top: B:23:0x013b }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x022f  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0237  */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r22v10 */
        /* JADX WARN: Type inference failed for: r22v2 */
        /* JADX WARN: Type inference failed for: r22v7 */
        /* JADX WARN: Type inference failed for: r22v8 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v23 */
        /* JADX WARN: Type inference failed for: r9v24 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v5 */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void handlePayResult(int i3, Bundle bundle, String str) {
            int i16;
            int i17;
            int i18;
            String str2;
            int i19;
            String str3;
            int i26;
            int i27;
            Object obj;
            String str4;
            int i28;
            JSONObject wrapCallbackFail;
            String str5;
            int optInt;
            Object obj2;
            String str6;
            Object obj3;
            String str7;
            int i29;
            String str8;
            int i36;
            int i37;
            int i38;
            int i39;
            JSONObject jSONObject;
            int optInt2;
            int i46;
            int i47;
            PayResultRecevicer payResultRecevicer = this;
            String str9 = "";
            String str10 = QzoneIPCModule.RESULT_CODE;
            String string = bundle.getString("result");
            String string2 = bundle.getString("callbackSn");
            try {
                try {
                    try {
                        if (TextUtils.isEmpty(string2)) {
                            i16 = 0;
                        } else {
                            if (JSONUtil.isJson(string2)) {
                                try {
                                    jSONObject = new JSONObject(string2);
                                    optInt2 = jSONObject.optInt("seq", -1);
                                    try {
                                        str8 = jSONObject.optString("appId", null);
                                    } catch (JSONException e16) {
                                        e = e16;
                                        i39 = optInt2;
                                        i29 = 0;
                                        str8 = null;
                                    }
                                } catch (JSONException e17) {
                                    e = e17;
                                    i29 = 0;
                                    str8 = null;
                                    str3 = null;
                                    i36 = -1;
                                    i37 = -1;
                                    i38 = -1;
                                    i39 = -1;
                                }
                                try {
                                    str3 = jSONObject.optString("prepayId", null);
                                    try {
                                        int optInt3 = jSONObject.optInt("balanceAmount", -1);
                                        try {
                                            i38 = jSONObject.optInt("topupAmount", -1);
                                            try {
                                                i36 = jSONObject.optInt("starCurrency", -1);
                                                try {
                                                    str2 = str8;
                                                    i19 = i36;
                                                    i17 = jSONObject.optInt("setEnv", 0);
                                                    i18 = i38;
                                                    i27 = optInt2;
                                                    i26 = optInt3;
                                                } catch (JSONException e18) {
                                                    e = e18;
                                                    i29 = 0;
                                                    i39 = optInt2;
                                                    i37 = optInt3;
                                                    QLog.e(MiniGamePayFragment.TAG, 1, e, new Object[i29]);
                                                    str2 = str8;
                                                    i19 = i36;
                                                    i18 = i38;
                                                    i27 = i39;
                                                    i47 = i37;
                                                    i17 = 0;
                                                    i26 = i47;
                                                    QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult seq = " + i27 + " callbackSn=" + string2 + " result = " + string);
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    JSONObject jSONObject3 = new JSONObject(string);
                                                    optInt = jSONObject3.optInt(QzoneIPCModule.RESULT_CODE, -1);
                                                    jSONObject3.optInt("realSaveNum", -1);
                                                    jSONObject3.optJSONObject("data");
                                                    jSONObject2.put(QzoneIPCModule.RESULT_CODE, optInt);
                                                    int i48 = jSONObject3.optInt("payChannel", -1) == 8 ? 2 : 3;
                                                    if (optInt != 0) {
                                                    }
                                                }
                                            } catch (JSONException e19) {
                                                e = e19;
                                                i39 = optInt2;
                                                i29 = 0;
                                                i36 = -1;
                                                i37 = optInt3;
                                            }
                                        } catch (JSONException e26) {
                                            e = e26;
                                            i39 = optInt2;
                                            i29 = 0;
                                            i36 = -1;
                                            i46 = optInt3;
                                            i38 = -1;
                                            i37 = i46;
                                            QLog.e(MiniGamePayFragment.TAG, 1, e, new Object[i29]);
                                            str2 = str8;
                                            i19 = i36;
                                            i18 = i38;
                                            i27 = i39;
                                            i47 = i37;
                                            i17 = 0;
                                            i26 = i47;
                                            QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult seq = " + i27 + " callbackSn=" + string2 + " result = " + string);
                                            JSONObject jSONObject22 = new JSONObject();
                                            JSONObject jSONObject32 = new JSONObject(string);
                                            optInt = jSONObject32.optInt(QzoneIPCModule.RESULT_CODE, -1);
                                            jSONObject32.optInt("realSaveNum", -1);
                                            jSONObject32.optJSONObject("data");
                                            jSONObject22.put(QzoneIPCModule.RESULT_CODE, optInt);
                                            int i482 = jSONObject32.optInt("payChannel", -1) == 8 ? 2 : 3;
                                            if (optInt != 0) {
                                            }
                                        }
                                    } catch (JSONException e27) {
                                        e = e27;
                                        i39 = optInt2;
                                        i29 = 0;
                                        i36 = -1;
                                        i46 = -1;
                                        i38 = -1;
                                        i37 = i46;
                                        QLog.e(MiniGamePayFragment.TAG, 1, e, new Object[i29]);
                                        str2 = str8;
                                        i19 = i36;
                                        i18 = i38;
                                        i27 = i39;
                                        i47 = i37;
                                        i17 = 0;
                                        i26 = i47;
                                        QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult seq = " + i27 + " callbackSn=" + string2 + " result = " + string);
                                        JSONObject jSONObject222 = new JSONObject();
                                        JSONObject jSONObject322 = new JSONObject(string);
                                        optInt = jSONObject322.optInt(QzoneIPCModule.RESULT_CODE, -1);
                                        jSONObject322.optInt("realSaveNum", -1);
                                        jSONObject322.optJSONObject("data");
                                        jSONObject222.put(QzoneIPCModule.RESULT_CODE, optInt);
                                        int i4822 = jSONObject322.optInt("payChannel", -1) == 8 ? 2 : 3;
                                        if (optInt != 0) {
                                        }
                                    }
                                } catch (JSONException e28) {
                                    e = e28;
                                    i39 = optInt2;
                                    i29 = 0;
                                    str3 = null;
                                    i36 = -1;
                                    i46 = -1;
                                    i38 = -1;
                                    i37 = i46;
                                    QLog.e(MiniGamePayFragment.TAG, 1, e, new Object[i29]);
                                    str2 = str8;
                                    i19 = i36;
                                    i18 = i38;
                                    i27 = i39;
                                    i47 = i37;
                                    i17 = 0;
                                    i26 = i47;
                                    QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult seq = " + i27 + " callbackSn=" + string2 + " result = " + string);
                                    JSONObject jSONObject2222 = new JSONObject();
                                    JSONObject jSONObject3222 = new JSONObject(string);
                                    optInt = jSONObject3222.optInt(QzoneIPCModule.RESULT_CODE, -1);
                                    jSONObject3222.optInt("realSaveNum", -1);
                                    jSONObject3222.optJSONObject("data");
                                    jSONObject2222.put(QzoneIPCModule.RESULT_CODE, optInt);
                                    int i48222 = jSONObject3222.optInt("payChannel", -1) == 8 ? 2 : 3;
                                    if (optInt != 0) {
                                    }
                                }
                                QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult seq = " + i27 + " callbackSn=" + string2 + " result = " + string);
                                JSONObject jSONObject22222 = new JSONObject();
                                JSONObject jSONObject32222 = new JSONObject(string);
                                optInt = jSONObject32222.optInt(QzoneIPCModule.RESULT_CODE, -1);
                                jSONObject32222.optInt("realSaveNum", -1);
                                jSONObject32222.optJSONObject("data");
                                jSONObject22222.put(QzoneIPCModule.RESULT_CODE, optInt);
                                int i482222 = jSONObject32222.optInt("payChannel", -1) == 8 ? 2 : 3;
                                if (optInt != 0) {
                                    int i49 = i27;
                                    str10 = MiniGamePayFragment.TAG;
                                    i27 = 1;
                                    MiniGamePayFragment miniGamePayFragment = MiniGamePayFragment.this;
                                    String str11 = str3;
                                    i3 = i49;
                                    obj = QzoneIPCModule.RESULT_CODE;
                                    try {
                                        miniGamePayFragment.invokeMidasQuery(str11, str2, i19, null, str, i49, i17, i482222);
                                        return;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i28 = 0;
                                        str4 = obj;
                                        QLog.e(str10, i27, th, new Object[i28]);
                                        wrapCallbackFail = ApiUtil.wrapCallbackFail(str, null);
                                        wrapCallbackFail.put(str4, -3);
                                        if (wrapCallbackFail != null) {
                                        }
                                        str5 = str9;
                                        if (str5 == null) {
                                        }
                                    }
                                } else {
                                    try {
                                        try {
                                            if (!TextUtils.isEmpty(str2)) {
                                                try {
                                                    if (!TextUtils.isEmpty(str3) && i19 != -1 && i18 != -1 && i26 != -1 && i482222 != -1) {
                                                        MiniGamePayFragment.this.invokeMidasConsume(str2, str3, i19, i26, i18, i482222, null, str, i27, i17);
                                                        return;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    payResultRecevicer = this;
                                                    i3 = i27;
                                                    str4 = QzoneIPCModule.RESULT_CODE;
                                                    str10 = MiniGamePayFragment.TAG;
                                                    i28 = 0;
                                                    i27 = 1;
                                                    QLog.e(str10, i27, th, new Object[i28]);
                                                    wrapCallbackFail = ApiUtil.wrapCallbackFail(str, null);
                                                    try {
                                                        wrapCallbackFail.put(str4, -3);
                                                    } catch (JSONException e29) {
                                                        e29.printStackTrace();
                                                    }
                                                    if (wrapCallbackFail != null) {
                                                    }
                                                    str5 = str9;
                                                    if (str5 == null) {
                                                    }
                                                }
                                            }
                                            i3 = i27;
                                            try {
                                                JSONObject wrapCallbackFail2 = ApiUtil.wrapCallbackFail(str, jSONObject32222);
                                                if (wrapCallbackFail2 != null) {
                                                    wrapCallbackFail2.put(QzoneIPCModule.RESULT_CODE, -4);
                                                }
                                                if (wrapCallbackFail2 == null) {
                                                    str7 = "";
                                                } else {
                                                    str7 = wrapCallbackFail2.toString();
                                                }
                                                if (str7.isEmpty()) {
                                                    return;
                                                }
                                                String str12 = "handleNativeResponse eventName = " + str + " resStr=" + str7;
                                                str10 = MiniGamePayFragment.TAG;
                                                i27 = 1;
                                                try {
                                                    QLog.d(str10, 1, str12);
                                                    obj2 = QzoneIPCModule.RESULT_CODE;
                                                    payResultRecevicer = this;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    obj3 = QzoneIPCModule.RESULT_CODE;
                                                    payResultRecevicer = this;
                                                    obj2 = obj3;
                                                    obj = obj2;
                                                    i28 = 0;
                                                    str4 = obj;
                                                    QLog.e(str10, i27, th, new Object[i28]);
                                                    wrapCallbackFail = ApiUtil.wrapCallbackFail(str, null);
                                                    wrapCallbackFail.put(str4, -3);
                                                    if (wrapCallbackFail != null) {
                                                    }
                                                    str5 = str9;
                                                    if (str5 == null) {
                                                    }
                                                }
                                                try {
                                                    MiniGamePayFragment.this.handleNativeResponse(str, str7, i3);
                                                    return;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    obj = obj2;
                                                    i28 = 0;
                                                    str4 = obj;
                                                    QLog.e(str10, i27, th, new Object[i28]);
                                                    wrapCallbackFail = ApiUtil.wrapCallbackFail(str, null);
                                                    wrapCallbackFail.put(str4, -3);
                                                    if (wrapCallbackFail != null) {
                                                    }
                                                    str5 = str9;
                                                    if (str5 == null) {
                                                    }
                                                }
                                            } catch (Throwable th9) {
                                                th = th9;
                                                i27 = 1;
                                                obj3 = QzoneIPCModule.RESULT_CODE;
                                                str10 = MiniGamePayFragment.TAG;
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            i28 = 0;
                                            i27 = 1;
                                            str4 = payResultRecevicer;
                                            str10 = str6;
                                            payResultRecevicer = this;
                                        }
                                    } catch (Throwable th11) {
                                        th = th11;
                                        optInt = i27;
                                        i26 = QzoneIPCModule.RESULT_CODE;
                                        str10 = MiniGamePayFragment.TAG;
                                        i27 = 1;
                                        i3 = optInt;
                                        obj2 = i26;
                                        obj = obj2;
                                        i28 = 0;
                                        str4 = obj;
                                        QLog.e(str10, i27, th, new Object[i28]);
                                        wrapCallbackFail = ApiUtil.wrapCallbackFail(str, null);
                                        wrapCallbackFail.put(str4, -3);
                                        if (wrapCallbackFail != null) {
                                        }
                                        str5 = str9;
                                        if (str5 == null) {
                                        }
                                    }
                                }
                            } else {
                                try {
                                    i27 = Integer.parseInt(string2);
                                    i18 = -1;
                                    str2 = null;
                                    i19 = -1;
                                    str3 = null;
                                    i47 = -1;
                                } catch (NumberFormatException e36) {
                                    i16 = 0;
                                    QLog.e(MiniGamePayFragment.TAG, 1, e36, new Object[0]);
                                }
                            }
                            i17 = 0;
                            i26 = i47;
                            QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult seq = " + i27 + " callbackSn=" + string2 + " result = " + string);
                            JSONObject jSONObject222222 = new JSONObject();
                            JSONObject jSONObject322222 = new JSONObject(string);
                            optInt = jSONObject322222.optInt(QzoneIPCModule.RESULT_CODE, -1);
                            jSONObject322222.optInt("realSaveNum", -1);
                            jSONObject322222.optJSONObject("data");
                            jSONObject222222.put(QzoneIPCModule.RESULT_CODE, optInt);
                            int i4822222 = jSONObject322222.optInt("payChannel", -1) == 8 ? 2 : 3;
                            if (optInt != 0) {
                            }
                        }
                        if (optInt != 0) {
                        }
                    } catch (Throwable th12) {
                        th = th12;
                    }
                    jSONObject322222.optInt("realSaveNum", -1);
                    jSONObject322222.optJSONObject("data");
                    jSONObject222222.put(QzoneIPCModule.RESULT_CODE, optInt);
                    int i48222222 = jSONObject322222.optInt("payChannel", -1) == 8 ? 2 : 3;
                } catch (Throwable th13) {
                    th = th13;
                    i3 = i27;
                    obj = QzoneIPCModule.RESULT_CODE;
                    str10 = MiniGamePayFragment.TAG;
                    i27 = 1;
                }
                optInt = jSONObject322222.optInt(QzoneIPCModule.RESULT_CODE, -1);
            } catch (Throwable th14) {
                th = th14;
                i3 = i27;
                obj = QzoneIPCModule.RESULT_CODE;
                i27 = 1;
                str10 = MiniGamePayFragment.TAG;
                i28 = 0;
                str4 = obj;
                QLog.e(str10, i27, th, new Object[i28]);
                wrapCallbackFail = ApiUtil.wrapCallbackFail(str, null);
                wrapCallbackFail.put(str4, -3);
                if (wrapCallbackFail != null) {
                    str9 = wrapCallbackFail.toString();
                }
                str5 = str9;
                if (str5 == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handleNativeResponse eventName = ");
                    sb5.append(str);
                    sb5.append(" resStr=");
                    sb5.append(str5);
                    sb5.append(" seq=");
                    int i56 = i3;
                    sb5.append(i56);
                    QLog.d(str10, i27, sb5.toString());
                    MiniGamePayFragment.this.handleNativeResponse(str, str5, i56);
                    return;
                }
                return;
            }
            i17 = i16;
            i18 = -1;
            str2 = null;
            i19 = -1;
            str3 = null;
            i26 = -1;
            i27 = -1;
            QLog.d(MiniGamePayFragment.TAG, 1, "onReceiveResult seq = " + i27 + " callbackSn=" + string2 + " result = " + string);
            JSONObject jSONObject2222222 = new JSONObject();
            JSONObject jSONObject3222222 = new JSONObject(string);
        }
    }

    public void invokeMidasConsume(String str, String str2, int i3, int i16, int i17, int i18, COMM.StCommonExt stCommonExt, final String str3, final int i19, int i26) {
        QLog.d(TAG, 1, "invokeMidasConsume prepayId= " + str2 + " starCurrency=" + String.valueOf(i3));
        if (!TextUtils.isEmpty(str2) && i3 > 0 && !TextUtils.isEmpty(str)) {
            MiniAppCmdUtil.getInstance().getMidasConsumeResult(str, str2, i3, i16, i17, i18, i26, stCommonExt, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.ui.MiniGamePayFragment.2
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    if (jSONObject == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(QzoneIPCModule.RESULT_CODE, -4);
                            jSONObject2.put("resultMsg", HardCodeUtil.qqStr(R.string.o8i));
                            String jSONObject3 = jSONObject2.toString();
                            if (jSONObject3 != null) {
                                MiniGamePayFragment.this.handleNativeResponse(str3, jSONObject3, i19);
                                return;
                            }
                            return;
                        } catch (JSONException e16) {
                            QLog.e(MiniGamePayFragment.TAG, 1, "invokeMidasConsume JSONException ", e16);
                            return;
                        }
                    }
                    QLog.d(MiniGamePayFragment.TAG, 1, "invokeMidasConsume receive isSuc= " + z16 + " ret=" + String.valueOf(jSONObject));
                    try {
                        MiniAppMidasPay$StGamePayRsp miniAppMidasPay$StGamePayRsp = (MiniAppMidasPay$StGamePayRsp) jSONObject.get("response");
                        int i27 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                        String string = jSONObject.getString("errMsg");
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = new JSONObject(new HashMap());
                        jSONObject5.put("attachInfo", miniAppMidasPay$StGamePayRsp.extInfo.attachInfo.get());
                        jSONObject5.put(ThirdPartyMiniApiImpl.KEY_MAP_INFO, jSONObject6);
                        jSONObject4.put(QzoneIPCModule.RESULT_CODE, i27);
                        jSONObject4.put("extInfo", jSONObject5);
                        jSONObject4.put("resultMsg", string);
                        QLog.d(MiniGamePayFragment.TAG, 1, "invokeMidasConsume receive isSuc= " + z16 + " resObj=" + jSONObject4.toString());
                        MiniGamePayFragment.this.handleNativeResponse(str3, jSONObject4.toString(), i19);
                    } catch (Throwable th5) {
                        QLog.e(MiniGamePayFragment.TAG, 1, "invokeMidasConsume JSONException ", th5);
                    }
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, -4);
            jSONObject.put("resultMsg", HardCodeUtil.qqStr(R.string.o8a));
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 != null) {
                handleNativeResponse(str3, jSONObject2, i19);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "invokeMidasConsume JSONException ", e16);
        }
    }
}
