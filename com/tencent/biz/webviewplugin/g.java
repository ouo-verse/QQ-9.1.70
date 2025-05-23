package com.tencent.biz.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends WebViewPlugin {

    /* renamed from: e, reason: collision with root package name */
    private static int f97564e = 1;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<WeakReference<a>> f97565d = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public String f97566a;

        /* renamed from: b, reason: collision with root package name */
        public String f97567b;

        /* renamed from: c, reason: collision with root package name */
        public int f97568c;

        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String bundle;
            int intExtra = intent.getIntExtra("bc_seq", -1);
            if (intExtra < 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive sequence = " + intExtra + "| wrong seq");
                    return;
                }
                return;
            }
            if (intExtra != this.f97568c) {
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive sequence != seq | miss hit");
                    return;
                }
                return;
            }
            Bundle extras = intent.getExtras();
            byte[] byteArray = extras.getByteArray("bc_data");
            int intExtra2 = intent.getIntExtra("portal_type_key", -1);
            if (byteArray == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive data = null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                if (intExtra2 == 1009) {
                    bundle = "REQ_TYPE_GET_HEAD returned";
                } else {
                    bundle = extras.toString();
                }
                QLog.d("PortalManager.HbEventPlugin", 2, "DataReceiver.onReceive | " + intExtra2 + "," + this.f97568c + "," + this.f97566a + "," + bundle);
            }
            switch (intExtra2) {
                case 1008:
                case 1009:
                case 1010:
                case 1011:
                    g.this.u(this.f97568c);
                    String h16 = com.tencent.mobileqq.portal.o.h(byteArray);
                    if (h16 == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("errorCode", -1);
                            h16 = jSONObject.toString();
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                    g.this.p(this.f97566a, h16);
                    return;
                default:
                    return;
            }
        }
    }

    private static int s() {
        int i3 = f97564e;
        f97564e = i3 + 1;
        return i3;
    }

    private void v(String str, int i3, int i16, String str2) {
        Intent intent = new Intent(str);
        intent.putExtra("portal_type_key", i3);
        intent.putExtra("portal_agrs", str2);
        intent.putExtra("bc_seq", i16);
        if (this.mRuntime.a() != null) {
            this.mRuntime.a().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "redEnvelope";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("PortalManager.HbEventPlugin", 2, "handleJsRequest: " + str3 + "," + strArr);
        }
        if (!"redEnvelope".endsWith(str2) || (!"getRankingList".endsWith(str3) && !"getHead".endsWith(str3) && !"getJumpBtnState".endsWith(str3) && !"getNick".endsWith(str3) && !"takePhoto".endsWith(str3))) {
            return false;
        }
        int s16 = s();
        a q16 = q(s16);
        t(q16, "com.tencent.portal.resp.action");
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    q16.f97566a = jSONObject.getString("callback");
                    q16.f97567b = jSONObject.getJSONObject("params").toString();
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        v("com.tencent.portal.req.action", r(str3), s16, q16.f97567b);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        SparseArray<WeakReference<a>> sparseArray = this.f97565d;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.f97565d.size(); i3++) {
            a aVar = this.f97565d.get(i3).get();
            if (aVar != null) {
                u(aVar.f97568c);
            }
        }
    }

    void p(String str, String... strArr) {
        callJs(str, strArr);
    }

    a q(int i3) {
        if (this.f97565d == null) {
            this.f97565d = new SparseArray<>(12);
        }
        a aVar = new a();
        aVar.f97568c = i3;
        WeakReference<a> weakReference = new WeakReference<>(aVar);
        this.f97565d.put(i3, weakReference);
        return weakReference.get();
    }

    int r(String str) {
        if ("getRankingList".endsWith(str)) {
            return 1008;
        }
        if ("getHead".endsWith(str)) {
            return 1009;
        }
        if ("getJumpBtnState".endsWith(str)) {
            return 1010;
        }
        if ("getNick".endsWith(str)) {
            return 1011;
        }
        return "takePhoto".endsWith(str) ? 1012 : -1;
    }

    void t(BroadcastReceiver broadcastReceiver, String str) {
        IntentFilter intentFilter = new IntentFilter(str);
        if (this.mRuntime.a() != null) {
            this.mRuntime.a().registerReceiver(broadcastReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        }
    }

    boolean u(int i3) {
        SparseArray<WeakReference<a>> sparseArray;
        WeakReference<a> weakReference;
        a aVar;
        if (i3 <= 0 || (sparseArray = this.f97565d) == null || (weakReference = sparseArray.get(i3)) == null || (aVar = weakReference.get()) == null) {
            return false;
        }
        try {
            this.mRuntime.a().unregisterReceiver(aVar);
            return true;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            e16.printStackTrace();
            return true;
        }
    }
}
