package com.qq.e.comm.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.c;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.comm.util.ProductConfigUtil;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.comm.util.StringUtil;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import org.apache.commons.fileupload.FileUploadBase;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f38117a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static C0275a f38118b = new C0275a(0);

    /* renamed from: c, reason: collision with root package name */
    private volatile Boolean f38119c = Boolean.FALSE;

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0275a implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<PM> f38124a;

        C0275a() {
        }

        /* synthetic */ C0275a(byte b16) {
            this();
        }

        public final void a(PM pm5) {
            this.f38124a = new WeakReference<>(pm5);
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public final void onADEvent(ADEvent aDEvent) {
            PM pm5 = this.f38124a.get();
            if (pm5 == null) {
                GDTLogger.e("GdtConfigListener onADEvent pm is null");
                return;
            }
            int type = aDEvent.getType();
            if (type != 1) {
                if (type == 2) {
                    GDTLogger.i("GdtConfigListener onADEvent GDT_CONFIG_UPDATE_FAILED");
                    try {
                        pm5.getPOFactory().onGdtConfigUpdateFailed();
                        return;
                    } catch (com.qq.e.comm.managers.plugin.a e16) {
                        GDTLogger.e("GdtConfigListener onADEvent GDT_CONFIG_UPDATE_FAILED call poFactory failed");
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            GDTLogger.i("GdtConfigListener onADEvent GDT_CONFIG_UPDATE_DONE");
            try {
                pm5.getPOFactory().onGdtConfigUpdateDone();
            } catch (com.qq.e.comm.managers.plugin.a e17) {
                GDTLogger.e("GdtConfigListener onADEvent GDT_CONFIG_UPDATE_DONE call poFactory failed");
                e17.printStackTrace();
            }
        }
    }

    public static a a() {
        return f38117a;
    }

    private static String a(SM sm5, PM pm5, DeviceStatus deviceStatus, APPStatus aPPStatus) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = c.a(sm5);
            jSONObject.put(PreloadTRTCPlayerParams.KEY_SIG, c.a(sm5, pm5));
            jSONObject.put(APMidasPayAPI.ENV_DEV, c.a(deviceStatus));
            jSONObject.put("app", c.a(aPPStatus));
            jSONObject.put("sdk", c.a(pm5));
        } catch (JSONException e16) {
            GDTLogger.e("JSONException while build init req", e16);
        }
        return jSONObject.toString();
    }

    public final void a(Context context, SM sm5, final PM pm5, final DeviceStatus deviceStatus, APPStatus aPPStatus, long j3) {
        if (this.f38119c.booleanValue()) {
            return;
        }
        synchronized (a.class) {
            if (this.f38119c.booleanValue()) {
                return;
            }
            String str = SharedPreferencedUtil.getInt("testControlServerOn", 0) == 1 || ProductConfigUtil.isControlServerHostOn() ? "https://test-tangram.e.qq.com/updateSetting" : "https://tangram.e.qq.com/updateSetting";
            GDTLogger.d(": control server url is " + str);
            if (!TextUtils.isEmpty(str)) {
                String a16 = a(sm5, pm5, deviceStatus, aPPStatus);
                StubVisitor.getInstance().onDataUsed(c.a());
                GDTLogger.d("launch request: " + a16);
                final long currentTimeMillis = System.currentTimeMillis();
                NetworkCallBack networkCallBack = new NetworkCallBack() { // from class: com.qq.e.comm.a.a.1
                    @Override // com.qq.e.comm.net.NetworkCallBack
                    public final void onException(Exception exc) {
                        GDTLogger.e("ActivateError", exc);
                        com.qq.e.comm.a.a(System.currentTimeMillis() - currentTimeMillis, -1);
                    }

                    @Override // com.qq.e.comm.net.NetworkCallBack
                    public final void onResponse(Request request, Response response) {
                        int i3;
                        try {
                            try {
                                if (response.getStatusCode() == 200) {
                                    String stringContent = response.getStringContent();
                                    GDTLogger.d("ACTIVERESPONSE:" + stringContent);
                                    if (StringUtil.isEmpty(stringContent)) {
                                        GDTLogger.report("SDK Server response empty string,maybe zip or tea format error");
                                        com.qq.e.comm.a.a(System.currentTimeMillis() - currentTimeMillis, -2);
                                        try {
                                            response.close();
                                            return;
                                        } catch (IOException e16) {
                                            e16.printStackTrace();
                                            return;
                                        }
                                    }
                                    JSONObject jSONObject = new JSONObject(stringContent);
                                    if (jSONObject.has("ret")) {
                                        i3 = jSONObject.getInt("ret");
                                    } else {
                                        i3 = -1;
                                    }
                                    com.qq.e.comm.a.a(System.currentTimeMillis() - currentTimeMillis, i3);
                                    if (i3 != 0 && i3 != 1) {
                                        GDTLogger.e("Response Error,retCode=" + i3);
                                    } else {
                                        if (pm5 != null) {
                                            try {
                                                a.f38118b.a(pm5);
                                                if (SDKStatus.getSDKVersionCode() >= 130) {
                                                    pm5.getPOFactory().config(1, stringContent, a.f38118b);
                                                } else {
                                                    pm5.getPOFactory().config(1, stringContent);
                                                }
                                            } catch (com.qq.e.comm.managers.plugin.a e17) {
                                                e17.printStackTrace();
                                            }
                                            if (jSONObject.has(PreloadTRTCPlayerParams.KEY_SIG)) {
                                                JSONObject optJSONObject = jSONObject.optJSONObject(PreloadTRTCPlayerParams.KEY_SIG);
                                                if (JSONUtilStub.notNull(optJSONObject) && optJSONObject.has(HttpMsg.FILE_JAR) && optJSONObject.has("url")) {
                                                    optJSONObject.getString(HttpMsg.FILE_JAR);
                                                    optJSONObject.getString("url");
                                                }
                                            }
                                        }
                                        if (jSONObject.has(DeviceStatus.EXPERIMENT_ID)) {
                                            deviceStatus.writeExperimentIdSync(jSONObject.optString(DeviceStatus.EXPERIMENT_ID));
                                        }
                                    }
                                } else {
                                    GDTLogger.e("SDK server response code error while launch or activate,code:" + response.getStatusCode());
                                    com.qq.e.comm.a.a(System.currentTimeMillis() - currentTimeMillis, -1);
                                }
                                try {
                                    response.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            } catch (IOException e19) {
                                GDTLogger.e("ActivateError", e19);
                                com.qq.e.comm.a.a(System.currentTimeMillis() - currentTimeMillis, -1);
                                try {
                                    response.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            } catch (JSONException e27) {
                                GDTLogger.e("Parse Active or launch response exception", e27);
                                com.qq.e.comm.a.a(System.currentTimeMillis() - currentTimeMillis, -2);
                                try {
                                    response.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            try {
                                response.close();
                            } catch (IOException e29) {
                                e29.printStackTrace();
                            }
                            throw th5;
                        }
                    }
                };
                S2SSRequest s2SSRequest = new S2SSRequest(str, a16.getBytes(Charset.forName("UTF-8")));
                s2SSRequest.addHeader(FileUploadBase.CONTENT_TYPE, "application/json");
                NetworkClientImpl.getInstance().submit(s2SSRequest, 1, networkCallBack);
            }
            this.f38119c = Boolean.TRUE;
        }
    }
}
