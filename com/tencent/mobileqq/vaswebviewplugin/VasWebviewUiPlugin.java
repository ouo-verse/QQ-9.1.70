package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;

/* loaded from: classes20.dex */
public abstract class VasWebviewUiPlugin extends VasBasePlugin {
    private static final String TAG = "VasWebviewUiPlugin";
    protected QQBrowserActivity activity;
    protected boolean isHomePageWatingBind = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnActivityDestroy() {
        if (com.tencent.mobileqq.jsp.f.f238867h) {
            com.tencent.mobileqq.jsp.f.w(false, null, false);
        }
        if (com.tencent.mobileqq.jsp.f.f238866f != null) {
            com.tencent.mobileqq.jsp.f.f238866f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnActivityPause() {
        if (com.tencent.mobileqq.jsp.f.f238867h) {
            com.tencent.mobileqq.jsp.f.w(false, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnActivityResume() {
        if (com.tencent.mobileqq.jsp.f.f238867h) {
            com.tencent.mobileqq.jsp.f.w(true, this.mRuntime.a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String decodeUrl(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "decodeUrl:" + str);
        }
        String replace = str.replace("[uin]", this.activity.getAppRuntime().getAccount()).replace("[client]", "androidQQ").replace("[version]", AppSetting.f99554n).replace("[sid]", "").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
        Intent intent = this.activity.getIntent();
        String stringExtra = intent.getStringExtra("updateTime");
        if (stringExtra != null && stringExtra.length() > 0) {
            replace = replace.replace("[updateTime]", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra(VasWebviewConstants.KEY_ADTAG);
        if (stringExtra != null && stringExtra.length() > 0) {
            replace = replace.replace("[adTag]", stringExtra2);
        }
        return replace.replace("[updateFlag]", Boolean.valueOf(intent.getBooleanExtra(VasWebviewConstants.KEY_UPDATE_FLAG, false)).toString()).replace("[updateId]", "" + intent.getIntExtra(VasWebviewConstants.KEY_UPDATE_ID, 0)).replace("[density]", ThemeUtil.getThemeDensity(this.activity));
    }

    protected boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return String.valueOf(getPluginBusiness());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (this.activity == null || (this.business & getPluginBusiness()) == 0) {
            return false;
        }
        String str2 = "Web_uiplugin_step_" + j3;
        ei.a(null, str2);
        try {
            try {
                if (j3 == 1) {
                    OnActivityCreate();
                } else if (j3 == 8589934596L) {
                    OnActivityDestroy();
                } else if (j3 == 2) {
                    OnActivityResume();
                } else if (j3 == 8589934597L) {
                    OnActivityPause();
                } else if (j3 != 8589934595L) {
                    if (j3 == 8589934600L) {
                        boolean onActivityResult = onActivityResult(((Integer) map.get("requestCode")).intValue(), ((Integer) map.get(QzoneIPCModule.RESULT_CODE)).intValue(), (Intent) map.get("data"));
                        ei.a(str2, null);
                        return onActivityResult;
                    }
                    if (j3 == 8589934598L) {
                        doBeforeFinish();
                    } else if (j3 == 8589934599L) {
                        doAfterFinish();
                    }
                }
                boolean excuteEvent = excuteEvent(str, j3, map);
                ei.a(str2, null);
                return excuteEvent;
            } catch (Exception e16) {
                e16.printStackTrace();
                ei.a(str2, null);
                return false;
            }
        } catch (Throwable th5) {
            ei.a(str2, null);
            throw th5;
        }
    }

    boolean onActivityResult(int i3, int i16, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (this.mRuntime.a() instanceof QQBrowserActivity) {
            this.activity = (QQBrowserActivity) this.mRuntime.a();
        }
    }

    protected void sendRemoteReq(Bundle bundle, boolean z16, boolean z17) {
        if (this.business != 0 && (getPluginBusiness() & this.business) == 0) {
            return;
        }
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            if (z17) {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.uya), 0).show();
            }
        } else if (z16) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
        }
    }

    protected void webviewLoadUrl(final String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "now try open url: " + str);
        }
        if (this.mRuntime.e() != null) {
            this.mRuntime.e().loadUrl(str);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    if (VasWebviewUiPlugin.this.mRuntime.e() != null) {
                        VasWebviewUiPlugin.this.mRuntime.e().loadUrl(str);
                    } else if (QLog.isColorLevel()) {
                        QLog.e(VasWebviewUiPlugin.TAG, 2, "mRuntime.getWebView() still null!!!!!");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OnActivityCreate() {
    }

    void doAfterFinish() {
    }

    void doBeforeFinish() {
    }
}
