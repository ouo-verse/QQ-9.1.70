package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import mqq.util.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends WebViewPlugin {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppInterface f97556a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f97557b;

        a(AppInterface appInterface, String[] strArr) {
            this.f97556a = appInterface;
            this.f97557b = strArr;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            c.this.s(this.f97557b, "");
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            c.this.s(this.f97557b, c.t(this.f97556a.getCurrentAccountUin(), mainTicketInfo.getA2(), ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String[] strArr, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountRelease", 2, String.format("getToken: %s", str));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("token", "");
            } else {
                jSONObject.put("token", str);
            }
            callJs(new JSONObject(strArr[0]).optString("callback"), jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str2);
            long longValue = Long.valueOf(str).longValue();
            byte[] bArr = new byte[hexStr2Bytes.length + 4];
            bArr[3] = (byte) (longValue & 255);
            bArr[2] = (byte) ((longValue >>> 8) & 255);
            bArr[1] = (byte) ((longValue >>> 16) & 255);
            bArr[0] = (byte) ((longValue >>> 24) & 255);
            for (int i3 = 0; i3 < hexStr2Bytes.length; i3++) {
                bArr[i3 + 4] = hexStr2Bytes[i3];
            }
            return MD5Utils.encodeHexStr(bArr);
        }
        QLog.d("AccountRelease", 1, "uin or a2 is empty, uin:" + LogUtil.getSafePrintUin(str) + ",a2:" + str2);
        return str3;
    }

    private void u(String[] strArr, boolean z16, AppInterface appInterface, TicketManager ticketManager) {
        String str = "";
        if (z16 && appInterface != null) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            str = t(currentAccountUin, ticketManager.getA2(currentAccountUin), "");
        } else {
            QLog.d("AccountRelease", 1, "getToken, app == null or flag: " + z16);
        }
        s(strArr, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "accountRelease";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("AccountRelease", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if (!"accountRelease".equals(str2)) {
            return false;
        }
        if ("onReleaseSuccess".equals(str3)) {
            Activity a16 = this.mRuntime.a();
            if (a16 != null) {
                a16.setResult(-1, null);
                a16.finish();
            } else {
                QLog.d("AccountRelease", 1, "release success, activity == null");
            }
        } else if ("getToken".equals(str3)) {
            AppInterface b16 = this.mRuntime.b();
            Activity a17 = this.mRuntime.a();
            if (a17 != null) {
                z16 = a17.getIntent().getBooleanExtra("is_release_account", false);
            } else {
                QLog.d("AccountRelease", 1, "getToken, activity == null");
                z16 = false;
            }
            TicketManager ticketManager = (TicketManager) b16.getManager(2);
            if (ticketManager.useAsyncTicketInterface()) {
                r(strArr, z16, b16, ticketManager);
            } else {
                u(strArr, z16, b16, ticketManager);
            }
        }
        return false;
    }

    private void r(String[] strArr, boolean z16, AppInterface appInterface, TicketManager ticketManager) {
        if (z16 && appInterface != null) {
            ticketManager.getA2(appInterface.getLongAccountUin(), 16, new a(appInterface, strArr));
            return;
        }
        QLog.d("AccountRelease", 1, "getToken, app == null or flag: " + z16);
        s(strArr, "");
    }
}
