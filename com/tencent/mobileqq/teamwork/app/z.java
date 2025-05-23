package com.tencent.mobileqq.teamwork.app;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.api.b;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class z implements com.tencent.mobileqq.teamwork.api.b {

    /* renamed from: a, reason: collision with root package name */
    private TDocMainProcessWebView f291982a;

    /* renamed from: b, reason: collision with root package name */
    private b.InterfaceC8637b f291983b;

    public z(@NonNull final Context context, String str, OpenDocsPerformanceRecorder openDocsPerformanceRecorder, b.InterfaceC8637b interfaceC8637b) {
        TDocMainProcessWebView tDocMainProcessWebView = new TDocMainProcessWebView(context, ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getDocsTypeOfIntValue(str));
        this.f291982a = tDocMainProcessWebView;
        tDocMainProcessWebView.setStatusListener(interfaceC8637b);
        this.f291983b = interfaceC8637b;
        this.f291982a.setJsApiCallHandler(new b.a() { // from class: com.tencent.mobileqq.teamwork.app.w
            @Override // com.tencent.mobileqq.teamwork.api.b.a
            public final void a(String str2, String str3, String str4) {
                z.this.g(context, str2, str3, str4);
            }
        });
        this.f291982a.setOpenDocsPerformanceRecorder(openDocsPerformanceRecorder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void g(final Context context, String str, String str2, String str3) {
        if (TextUtils.equals(str, FileReaderHelper.DOCX_EXT) && !TextUtils.isEmpty(str2)) {
            QLog.i("WebEngineFileBrowserWrapperImpl", 1, "nameSpace:" + str + " method:" + str2 + " args:" + str3);
            if ("notifyLocalFilePasswordError".equals(str2)) {
                try {
                    final JSONObject jSONObject = new JSONObject(str3);
                    final int optInt = jSONObject.optInt("errorCode");
                    b.InterfaceC8637b interfaceC8637b = this.f291983b;
                    if (interfaceC8637b != null) {
                        interfaceC8637b.b(optInt, "");
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.app.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            z.this.f(optInt, context, jSONObject);
                        }
                    });
                } catch (Exception e16) {
                    QLog.e("WebEngineFileBrowserWrapperImpl", 1, "notifyLocalFilePasswordError parse failed, e:" + e16);
                }
            }
        }
    }

    private void e(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            String replace = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);".replace("((0))", str).replace("((1))", jSONObject.toString());
            this.f291982a.x("javascript: " + replace);
        } catch (Exception e16) {
            QLog.e("WebEngineFileBrowserWrapperImpl", 1, "invokeCallback failed, e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(int i3, Context context, JSONObject jSONObject) {
        if (i3 == 14014) {
            i(context, jSONObject);
        } else if (i3 == 14015) {
            QQToast.makeText(context, 1, "\u5bc6\u7801\u8f93\u5165\u9519\u8bef\uff0c\u8bf7\u91cd\u8bd5", 0).show();
            i(context, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(JSONObject jSONObject, DialogInterface dialogInterface, int i3) {
        String optString = jSONObject.optString("callback");
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationActivity.PASSWORD, ((QQCustomDialog) dialogInterface).getEditString());
        e(optString, hashMap);
    }

    private void i(Context context, final JSONObject jSONObject) {
        com.tencent.mobileqq.teamwork.d.a(context, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.app.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                z.this.h(jSONObject, dialogInterface, i3);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.b
    public View getView() {
        return this.f291982a;
    }

    @Override // com.tencent.mobileqq.teamwork.api.b
    public void loadUrl(String str) {
        this.f291982a.t(str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.b
    public void onDestroy() {
        this.f291982a.u();
    }

    @Override // com.tencent.mobileqq.teamwork.api.b
    public void onResume() {
        this.f291982a.v();
    }
}
