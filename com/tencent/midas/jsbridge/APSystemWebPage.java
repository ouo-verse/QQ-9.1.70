package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APProgressDialog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes9.dex */
public class APSystemWebPage implements IAPWebPage {
    private static final int HEADER_BACK = 1;
    private static final int HEADER_CLOSE = 2;
    private static final int HEADER_REFRESH = 4;
    private static final String TAG = "APSystemWebPage";
    private Activity activity;
    private APProgressDialog waitDialog;
    private APWebView webView;
    private IAPWebViewCallback webviewCallback = new IAPWebViewCallback() { // from class: com.tencent.midas.jsbridge.APSystemWebPage.1
        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public boolean WebChromeClientJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            APLog.d(APSystemWebPage.TAG, "WebChromeClientJsAlert message=" + str2);
            APWebProtocol.AnalyzeWebEntry(APSystemWebPage.this.activity, APSystemWebPage.this.webView.getWebView(), APSystemWebPage.this, str2);
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public boolean WebChromeClientJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public void WebViewClientPageFinished(WebView webView, String str) {
            if (!APSystemWebPage.this.activity.isFinishing() && APSystemWebPage.this.waitDialog != null && APSystemWebPage.this.waitDialog.isShowing()) {
                APSystemWebPage.this.waitDialog.dismiss();
            }
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public void WebViewClientPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!APSystemWebPage.this.activity.isFinishing() && APSystemWebPage.this.waitDialog != null) {
                APSystemWebPage.this.waitDialog.show();
            }
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public void WebViewClientReceivedError(WebView webView, int i3, String str, String str2) {
            if (!APSystemWebPage.this.activity.isFinishing() && APSystemWebPage.this.waitDialog != null && APSystemWebPage.this.waitDialog.isShowing()) {
                APSystemWebPage.this.waitDialog.dismiss();
            }
        }
    };

    protected APProgressDialog createDialog() {
        APProgressDialog aPProgressDialog = new APProgressDialog(this.activity);
        aPProgressDialog.setMessage("\u8bf7\u7a0d\u5019...");
        return aPProgressDialog;
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initHead(final Activity activity, String str, String str2) {
        int i3;
        try {
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_HEAD_INIT, "", "headControl=" + str + "&headTitle=" + str2);
            try {
                i3 = Integer.valueOf(str).intValue();
            } catch (Exception e16) {
                e16.printStackTrace();
                i3 = 0;
            }
            if (!TextUtils.isEmpty(str2)) {
                str2 = APMidasTools.urlDecode(str2, 1);
            }
            LinearLayout linearLayout = (LinearLayout) activity.findViewById(APMidasCommMethod.getId(activity, "midas_header_layout"));
            if (i3 <= 0 && TextUtils.isEmpty(str2)) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            TextView textView = (TextView) activity.findViewById(APMidasCommMethod.getId(activity, "midas_header_title"));
            if (!TextUtils.isEmpty(str2)) {
                textView.setVisibility(0);
                textView.setText(str2);
            } else {
                textView.setVisibility(8);
            }
            ImageButton imageButton = (ImageButton) activity.findViewById(APMidasCommMethod.getId(activity, "midas_header_back"));
            if ((i3 & 1) == 1) {
                imageButton.setVisibility(0);
                imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.midas.jsbridge.APSystemWebPage.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z16;
                        EventCollector.getInstance().onViewClickedBefore(view);
                        APLog.d(APSystemWebPage.TAG, "backBtn() clicked");
                        if (APSystemWebPage.this.webView != null && APSystemWebPage.this.webView.getWebView() != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_BACK, "", "webviewNotNull=" + z16);
                        if (z16 && APSystemWebPage.this.webView.getWebView().canGoBack()) {
                            APSystemWebPage.this.webView.getWebView().goBack();
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            } else {
                imageButton.setVisibility(8);
            }
            ImageButton imageButton2 = (ImageButton) activity.findViewById(APMidasCommMethod.getId(activity, "midas_header_close"));
            if ((i3 & 2) == 2) {
                imageButton2.setVisibility(0);
                imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.midas.jsbridge.APSystemWebPage.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        APLog.d(APSystemWebPage.TAG, "closeBtn() clicked");
                        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_CLOSE, "", "");
                        APMidasResponse aPMidasResponse = new APMidasResponse();
                        aPMidasResponse.resultCode = 100;
                        aPMidasResponse.resultMsg = "\u5173\u95ed";
                        APMidasPayHelper.midasCallBack(aPMidasResponse);
                        activity.finish();
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            } else {
                imageButton2.setVisibility(8);
            }
            ImageButton imageButton3 = (ImageButton) activity.findViewById(APMidasCommMethod.getId(activity, "midas_header_refresh"));
            if ((i3 & 4) == 4) {
                imageButton3.setVisibility(0);
                imageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.midas.jsbridge.APSystemWebPage.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        APLog.d(APSystemWebPage.TAG, "refreshBtn() clicked");
                        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_REFRESH, "", "");
                        if (APSystemWebPage.this.webView != null && APSystemWebPage.this.webView.getWebView() != null) {
                            APSystemWebPage.this.webView.getWebView().reload();
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            } else {
                imageButton3.setVisibility(8);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initUI(Activity activity) {
        this.activity = activity;
        activity.setContentView(APMidasCommMethod.getLayoutId(activity, "unipay_layout_activity_web"));
        this.webView = new APWebView(activity, (WebView) activity.findViewById(APMidasCommMethod.getId(activity, "unipay_id_WebView")), this.webviewCallback);
        APProgressDialog createDialog = createDialog();
        this.waitDialog = createDialog;
        createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.midas.jsbridge.APSystemWebPage.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void loadUrl(String str) {
        this.webView.loadUrl(str);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void toPureH5Pay(Activity activity, APMidasBaseRequest aPMidasBaseRequest) {
        this.activity = activity;
        activity.setContentView(APMidasCommMethod.getLayoutId(activity, "unipay_layout_activity_web"));
        WebView webView = (WebView) activity.findViewById(APMidasCommMethod.getId(activity, "unipay_id_WebView"));
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) webView.getLayoutParams();
        layoutParams.width = (int) (r0.widthPixels * 0.85f);
        layoutParams.height = (int) (r0.heightPixels * 0.85f);
        layoutParams.gravity = 17;
        webView.setLayoutParams(layoutParams);
        this.webView = new APWebView(activity, webView, this.webviewCallback);
        APProgressDialog createDialog = createDialog();
        this.waitDialog = createDialog;
        createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.midas.jsbridge.APSystemWebPage.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void updateWebViewSize(String str) {
        int i3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.webView.getWebView().getLayoutParams();
        APLog.i("webviewclient == ", "updateWebViewSize ");
        String urlParamsValue = APMidasTools.getUrlParamsValue(str, "mpwidth");
        int i16 = 0;
        if (!TextUtils.isEmpty(urlParamsValue)) {
            i3 = Integer.valueOf(urlParamsValue).intValue();
        } else {
            i3 = 0;
        }
        String urlParamsValue2 = APMidasTools.getUrlParamsValue(str, "mpheight");
        if (!TextUtils.isEmpty(urlParamsValue2)) {
            i16 = Integer.valueOf(urlParamsValue2).intValue();
        }
        if (i16 != 0 && i3 != 0) {
            layoutParams.width = APMidasCommMethod.dip2px(this.activity, i3);
            layoutParams.height = APMidasCommMethod.dip2px(this.activity, i16);
            this.webView.getWebView().setLayoutParams(layoutParams);
        }
    }
}
