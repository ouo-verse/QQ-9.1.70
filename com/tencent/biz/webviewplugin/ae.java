package com.tencent.biz.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ae extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final String f97537d = "ae";

    /* renamed from: e, reason: collision with root package name */
    private static final String f97538e = "com.tencent.biz.webviewplugin.ae";

    public static String p(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (messageRecord instanceof MessageForPtt) {
                MessageForPtt messageForPtt = (MessageForPtt) messageRecord;
                messageForPtt.parse();
                jSONObject2.put("content", messageRecord.f203106msg + ",urlAtServer:" + messageForPtt.urlAtServer);
            } else if (messageRecord instanceof MessageForPic) {
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                messageForPic.parse();
                jSONObject2.put("content", messageForPic.f203106msg + ",uuid:" + messageForPic.uuid);
            } else {
                jSONObject2.put("content", messageRecord.f203106msg);
            }
            jSONObject2.put("contentType", "" + messageRecord.msgtype);
            jSONObject2.put("time", "" + messageRecord.time);
            jSONArray.put(0, jSONObject2);
            jSONObject.put("msgnum", "1");
            jSONObject.put("contentlist", jSONArray);
            return jSONObject.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i(f97538e, 2, "getReportMessage:" + e16.getMessage());
            }
            return "0";
        }
    }

    private boolean r() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.a() == null || this.mRuntime.a().getIntent() == null) {
            return false;
        }
        return this.mRuntime.a().getIntent().getBooleanExtra("BSafeReportPost", false);
    }

    private byte[] s() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null && this.mRuntime.a().getIntent() != null) {
            return this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return f97537d;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 32L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 32 && r()) {
            q(str, s());
            this.mRuntime.e().readyForLoadJs();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
    }

    public void q(String str, byte[] bArr) {
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null) {
            return;
        }
        try {
            e16.postUrl(str, bArr);
            e16.requestFocus();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }
}
