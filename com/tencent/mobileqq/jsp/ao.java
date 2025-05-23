package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import com.qzone.album.data.model.AlbumCacheData;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ao extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements WbShareCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ao.this);
            }
        }

        @Override // com.sina.weibo.sdk.share.WbShareCallback
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("LoginPlugin_demo", 1, "onCancel");
                com.tencent.mobileqq.forward.w.c(ao.this.r(), "\u5206\u4eab\u53d6\u6d88");
            }
        }

        @Override // com.sina.weibo.sdk.share.WbShareCallback
        public void onComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("LoginPlugin_demo", 1, "onComplete");
                com.tencent.mobileqq.forward.w.c(ao.this.r(), "\u5206\u4eab\u6210\u529f");
            }
        }

        @Override // com.sina.weibo.sdk.share.WbShareCallback
        public void onError(UiError uiError) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uiError);
                return;
            }
            QLog.d("LoginPlugin_demo", 1, "onError errorMessage=", uiError.errorMessage, ", errorCode=", Integer.valueOf(uiError.errorCode));
            com.tencent.mobileqq.forward.w.c(ao.this.r(), "\u5206\u4eab\u5931\u8d25 message=" + uiError.errorMessage);
        }
    }

    public ao() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean q(int i3, String str, String str2, String str3, String str4, String str5, String[] strArr) {
        WBShareHelper h16 = WBShareHelper.h(2);
        if (h16 == null) {
            QLog.e("LoginPlugin_demo", 1, "doShare wbShareHelper==null !!!");
            return false;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return false;
                        }
                        h16.t(r(), str, str2);
                    } else {
                        h16.p(r(), str, strArr);
                    }
                } else {
                    h16.s(r(), str3, str4, str5, str, BitmapFactory.decodeFile(str2));
                }
            } else {
                h16.m(r(), str2);
            }
        } else {
            h16.r(r(), str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity r() {
        Activity a16 = this.mRuntime.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "share";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if ("share".equals(str2) && "weibo".equals(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                int i3 = jSONObject.getInt("type");
                String optString = jSONObject.optString("text");
                String optString2 = jSONObject.optString("sdcardpath");
                String optString3 = jSONObject.optString("title");
                String optString4 = jSONObject.optString("description");
                String optString5 = jSONObject.optString(AlbumCacheData.ACTIONURL);
                String[] split = optString2.split(",");
                QLog.d("LoginPlugin_demo", 1, "handleJsRequest type=", Integer.valueOf(i3), ", text=", optString, ", sdcardPath=", optString2, ", title=", optString3 + ", description=", optString4 + ", actionUrl=", optString5);
                return q(i3, optString, optString2, optString3, optString4, optString5, split);
            } catch (Exception e16) {
                QLog.e("LoginPlugin_demo", 1, "handleJsRequest error : ", e16.getMessage());
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
        } else {
            super.onActivityResult(intent, b16, i3);
            WBShareHelper.h(2).d(r(), intent, new a());
        }
    }
}
