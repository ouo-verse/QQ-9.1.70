package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.UiJsProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = UiJsProxy.class)
/* loaded from: classes34.dex */
public class bw extends UiJsProxy {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, RequestEvent requestEvent, DialogInterface dialogInterface, int i3) {
        d(dialogInterface, str, requestEvent);
    }

    private DialogInterface.OnClickListener c(final String str, final RequestEvent requestEvent) {
        return new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.proxyimpl.bv
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                bw.this.b(str, requestEvent, dialogInterface, i3);
            }
        };
    }

    private void d(DialogInterface dialogInterface, String str, RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, true);
            requestEvent.ok(jSONObject);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        } catch (Exception e16) {
            QMLog.e("UiJsProxyImpl", "show modalView error." + e16);
            requestEvent.fail();
        }
    }

    private int e(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1105805645:
                if (str.equals("extremeBlack")) {
                    c16 = 0;
                    break;
                }
                break;
            case 99228:
                if (str.equals("day")) {
                    c16 = 1;
                    break;
                }
                break;
            case 104817688:
                if (str.equals("night")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 2:
                return 1002;
            case 1:
                return 1001;
            default:
                return 1000;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UiJsProxy
    public void showModal(Context context, RequestEvent requestEvent) {
        WeakReference weakReference = new WeakReference(context);
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("title", "");
            String optString2 = jSONObject.optString("content", "");
            String optString3 = jSONObject.optString("theme", "");
            boolean optBoolean = jSONObject.optBoolean("showCancel", true);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog((Context) weakReference.get(), optString, optString2, jSONObject.optString("cancelText", "\u53d6\u6d88"), jSONObject.optString("confirmText", "\u786e\u5b9a"), c(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, requestEvent), optBoolean ? c("cancel", requestEvent) : null);
            com.tencent.mobileqq.simpleui.c.j(createCustomDialog, e(optString3));
            com.tencent.mobileqq.simpleui.c.c(createCustomDialog, e(optString3));
            createCustomDialog.setCanceledOnTouchOutside(true);
            createCustomDialog.show();
        } catch (JSONException e16) {
            QLog.e("UiJsProxyImpl", 1, "showModal throw:", e16);
            requestEvent.fail();
        }
    }
}
