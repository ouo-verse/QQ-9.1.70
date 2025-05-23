package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.UiJsProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy = UiJsProxy.class)
/* loaded from: classes23.dex */
public class UiJsProxyDefault extends UiJsProxy {

    /* renamed from: a, reason: collision with root package name */
    private MiniCustomDialog f348049a;

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UiJsProxy
    public void showModal(final Context context, final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("title", "");
            final String optString2 = jSONObject.optString("content", "");
            final boolean optBoolean = jSONObject.optBoolean("showCancel", true);
            final String optString3 = jSONObject.optString("cancelText", "\u53d6\u6d88");
            final String optString4 = jSONObject.optString("cancelColor", "#000000");
            final String optString5 = jSONObject.optString("confirmText", "\u786e\u5b9a");
            final String optString6 = jSONObject.optString("confirmColor", "#3CC51F");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.core.proxy.service.UiJsProxyDefault.1

                /* renamed from: com.tencent.qqmini.sdk.core.proxy.service.UiJsProxyDefault$1$a */
                /* loaded from: classes23.dex */
                class a implements DialogInterface.OnClickListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, true);
                            requestEvent.ok(jSONObject);
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                        } catch (Exception e16) {
                            QMLog.e("UiJsProxyDefault", "show modalView error." + e16);
                            requestEvent.fail();
                        }
                    }
                }

                /* renamed from: com.tencent.qqmini.sdk.core.proxy.service.UiJsProxyDefault$1$b */
                /* loaded from: classes23.dex */
                class b implements DialogInterface.OnClickListener {
                    b() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("cancel", true);
                            requestEvent.ok(jSONObject);
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                        } catch (Exception e16) {
                            QMLog.e("UiJsProxyDefault", "show modalView error." + e16);
                            requestEvent.fail();
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    UiJsProxyDefault.this.f348049a = new MiniCustomDialog(context, R.style.mini_sdk_MiniAppInputDialog);
                    UiJsProxyDefault.this.f348049a.setContentView(R.layout.mini_sdk_custom_dialog_temp);
                    MiniCustomDialog miniCustomDialog = UiJsProxyDefault.this.f348049a;
                    if (TextUtils.isEmpty(optString)) {
                        str = null;
                    } else {
                        str = optString;
                    }
                    miniCustomDialog.setTitle(str).setMessage(optString2);
                    UiJsProxyDefault.this.f348049a.setPositiveButton(optString5, ColorUtils.parseColor(optString6), new a());
                    if (optBoolean) {
                        UiJsProxyDefault.this.f348049a.setNegativeButton(optString3, ColorUtils.parseColor(optString4), new b());
                    }
                    UiJsProxyDefault.this.f348049a.setCanceledOnTouchOutside(false);
                    if (!UiJsProxyDefault.this.f348049a.isShowing()) {
                        UiJsProxyDefault.this.f348049a.show();
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e("UiJsProxyDefault", requestEvent.event + " error.", e16);
        }
    }
}
