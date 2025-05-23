package com.qwallet.pay;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OpenTenpayResultReceiver extends ResultReceiver implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    private a f41624d;

    /* renamed from: e, reason: collision with root package name */
    private final String f41625e;

    public OpenTenpayResultReceiver(Handler handler, a aVar, String str) {
        super(handler);
        this.f41624d = aVar;
        this.f41625e = str;
        Lifecycle h16 = aVar.h();
        if (h16 != null) {
            h16.addObserver(this);
        }
    }

    private void a(Bundle bundle, JSONObject jSONObject) throws JSONException {
        if (TenpayInterface.VIEWTAG_REQARDTRANSFER.equalsIgnoreCase(this.f41625e)) {
            String string = bundle.getString("transfer_retmsg");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("retmsg", string);
                return;
            }
            return;
        }
        if ("hbPackConfirm".equalsIgnoreCase(this.f41625e)) {
            String string2 = bundle.getString("retmsg");
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("retmsg", string2);
                return;
            }
            return;
        }
        String string3 = bundle.getString("retmsg");
        if (string3 == null) {
            string3 = "success";
        }
        jSONObject.put("retmsg", string3);
    }

    private void b(Bundle bundle, JSONObject jSONObject) throws JSONException {
        Object obj;
        String string = bundle.getString("retmsg");
        if (string != null && string.length() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has("err_msg")) {
                    obj = jSONObject2.get("err_msg");
                } else {
                    obj = "error";
                }
                jSONObject.put("retmsg", obj);
                return;
            } catch (JSONException unused) {
                jSONObject.put("retmsg", string);
                return;
            }
        }
        jSONObject.put("retmsg", "error and retmsg is null");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onLogicHostDestroyed() {
        QLog.d("OpenTenpayResultReceiver", 2, "onLogicHostDestroyed: ");
        this.f41624d = null;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        Bundle bundle2;
        super.onReceiveResult(i3, bundle);
        a aVar = this.f41624d;
        if (aVar != null && (bundle2 = aVar.f41632d) != null) {
            if (i3 != 99999 && i3 != 99998) {
                int i16 = bundle2.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
                String string = aVar.f41632d.getString("callbackSn");
                com.tencent.mobileqq.qwallet.utils.f.a("OpenTenpayResultReceiver", "TenviewResultReceiver.onReceiveResult nInvokerId=" + i16 + ",callbackSn=" + string + ",resultCode=" + i3 + ",resultData=" + bundle);
                if (bundle == null) {
                    aVar.l(i16, string, i3, "{'resultCode':" + i3 + ",'retmsg':'openTenpayView resultData is null'}");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(QzoneIPCModule.RESULT_CODE, i3);
                    if (i3 == 0) {
                        a(bundle, jSONObject);
                    } else {
                        b(bundle, jSONObject);
                    }
                    String string2 = bundle.getString("retdata");
                    if (!TextUtils.isEmpty(string2)) {
                        JSONObject jSONObject2 = new JSONObject(string2);
                        jSONObject.put("data", jSONObject2);
                        if ("graphb".equalsIgnoreCase(this.f41625e)) {
                            u.g(jSONObject2, aVar.f41629a);
                        }
                    }
                    for (String str : bundle.keySet()) {
                        Object obj = bundle.get(str);
                        if ((obj instanceof String) && !jSONObject.has(str)) {
                            jSONObject.put(str, obj);
                        }
                    }
                    com.tencent.mobileqq.qwallet.utils.f.a("OpenTenpayResultReceiver", "openTenpayView final result:" + jSONObject.toString());
                    aVar.l(i16, string, i3, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    com.tencent.mobileqq.qwallet.utils.f.d("OpenTenpayResultReceiver", "openTenpayView result exception", e16);
                    aVar.l(i16, string, i3, "{'resultCode':-1,'retmsg':'openTenpayView result json exception'}");
                    return;
                }
            }
            return;
        }
        QLog.d("OpenTenpayResultReceiver", 1, "onReceiveResult: mLogicRef is null");
    }

    @Override // android.os.ResultReceiver
    public void send(int i3, Bundle bundle) {
        super.send(i3, bundle);
        com.tencent.mobileqq.qwallet.utils.f.a("OpenTenpayResultReceiver", "resultCode " + i3 + " , resultData " + bundle.toString());
    }
}
