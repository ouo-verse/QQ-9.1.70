package com.tencent.ilinkservice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.libra.util.ImageContentType;
import com.tencent.luggage.wxa.t0.a;
import com.tencent.luggage.wxa.t0.b;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class IlinkLiveServiceImpl implements IlinkLiveServiceInterface {
    public static final String ILINKLIVE_SERVICE_CALLBACK = "ilinkLiveCallback";
    public static final String ILINKLIVE_SERVICE_FUNC = "ilinkLiveFunc";
    private final String TAG;
    private a m_callback_;
    private b m_jsapi_bridge_;
    private String m_sdkdir_;
    private WebView m_webView_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SingletonLoader {
        private static IlinkLiveServiceImpl singletonStatic = new IlinkLiveServiceImpl();

        SingletonLoader() {
        }
    }

    private void callServiceJsapi(String str, long j3, String str2) {
        IlinkServiceImpl.getInstance().ReqCommFunctionWithResp(ILINKLIVE_SERVICE_FUNC, AidlProto.ilinkliveCommRequest.newBuilder().setFuncname(str).setFuncargs(ByteString.copyFrom(AidlProto.ilinkliveFinderJsApis.newBuilder().setTaskid(j3).setBody(ByteString.copyFrom(str2.getBytes())).build().toByteArray())).build().toByteArray());
    }

    private void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteFile(file2);
                }
            }
        }
    }

    public static IlinkLiveServiceImpl getInstance() {
        return SingletonLoader.singletonStatic;
    }

    public void InvockJsScript(String str) {
        this.m_webView_.evaluateJavascript(str, null);
    }

    public void OnReceiveCommonCallback(byte[] bArr) {
        char c16;
        try {
            AidlProto.onilinkliveCommCallback parseFrom = AidlProto.onilinkliveCommCallback.parseFrom(bArr);
            String funcname = parseFrom.getFuncname();
            switch (funcname.hashCode()) {
                case -2042114055:
                    if (funcname.equals("onUploadMediaFileComplete")) {
                        c16 = '\f';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1750465475:
                    if (funcname.equals("onFinderSetAnchorStatusComplete")) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1378277085:
                    if (funcname.equals("onLiveStartEvent")) {
                        c16 = '\n';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1316413900:
                    if (funcname.equals("onAutoLoginComplete")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1258845322:
                    if (funcname.equals("onSendTransferRequestComplete")) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1038118920:
                    if (funcname.equals("onFinderCloseLiveComplete")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -790105818:
                    if (funcname.equals("onFinderCreateLiveComplete")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -742078323:
                    if (funcname.equals("onLiveStopEvent")) {
                        c16 = 11;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -691925495:
                    if (funcname.equals("onThirdAppLoginComplete")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 246121876:
                    if (funcname.equals("onFinderJoinLiveComplete")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1104525743:
                    if (funcname.equals("onFinderLivePrepareComplete")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1626050918:
                    if (funcname.equals("onRtmpUrlUpdateEvent")) {
                        c16 = '\t';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1784438254:
                    if (funcname.equals("onFinderInitComplete")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    AidlProto.onilinkliveLoginCompleteCallback parseFrom2 = AidlProto.onilinkliveLoginCompleteCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.a(parseFrom2.getTaskid(), parseFrom2.getErrcode());
                    return;
                case 1:
                    AidlProto.onilinkliveLoginCompleteCallback parseFrom3 = AidlProto.onilinkliveLoginCompleteCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.b(parseFrom3.getTaskid(), parseFrom3.getErrcode());
                    return;
                case 2:
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom4 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.e(parseFrom4.getTaskid(), parseFrom4.getBody().toStringUtf8());
                    return;
                case 3:
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom5 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.g(parseFrom5.getTaskid(), parseFrom5.getBody().toStringUtf8());
                    return;
                case 4:
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom6 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.d(parseFrom6.getTaskid(), parseFrom6.getBody().toStringUtf8());
                    return;
                case 5:
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom7 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.f(parseFrom7.getTaskid(), parseFrom7.getBody().toStringUtf8());
                    return;
                case 6:
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom8 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.c(parseFrom8.getTaskid(), parseFrom8.getBody().toStringUtf8());
                    return;
                case 7:
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom9 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.h(parseFrom9.getTaskid(), parseFrom9.getBody().toStringUtf8());
                    return;
                case '\b':
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom10 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.i(parseFrom10.getTaskid(), parseFrom10.getBody().toStringUtf8());
                    return;
                case '\t':
                    this.m_jsapi_bridge_.a(AidlProto.onilinkliveRtmpUrlUpdateCallback.parseFrom(parseFrom.getFuncargs()).getUrl().toStringUtf8());
                    return;
                case '\n':
                    this.m_jsapi_bridge_.g();
                    return;
                case 11:
                    this.m_jsapi_bridge_.h();
                    return;
                case '\f':
                    AidlProto.onilinkliveFinderJsapiCallback parseFrom11 = AidlProto.onilinkliveFinderJsapiCallback.parseFrom(parseFrom.getFuncargs());
                    this.m_jsapi_bridge_.j(parseFrom11.getTaskid(), parseFrom11.getBody().toStringUtf8());
                    return;
                default:
                    IlinkServiceLogImpl.getInstance().e("IlinkLiveServiceImpl", "not supported callback:" + parseFrom.getFuncname(), new Object[0]);
                    return;
            }
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            IlinkServiceLogImpl.getInstance().e("IlinkLiveServiceImpl", "OnReceiveCommonCallback resp error", new Object[0]);
        }
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void autoLogin() {
        IlinkServiceImpl.getInstance().ReqCommFunctionWithResp(ILINKLIVE_SERVICE_FUNC, AidlProto.ilinkliveCommRequest.newBuilder().setFuncname("autoLogin").build().toByteArray());
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public boolean canAutoLogin() {
        try {
            return AidlProto.ilinkliveCanAutoLoginResp.parseFrom(IlinkServiceImpl.getInstance().ReqCommFunctionWithResp(ILINKLIVE_SERVICE_FUNC, AidlProto.ilinkliveCommRequest.newBuilder().setFuncname("canAutoLogin").build().toByteArray())).getState();
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            IlinkServiceLogImpl.getInstance().e("IlinkLiveServiceImpl", "canAutoLogin resp pb error", new Object[0]);
            return false;
        }
    }

    public void finderCloseLive(long j3, String str) {
        callServiceJsapi("finderCloseLive", j3, str);
    }

    public void finderCreateLive(long j3, String str) {
        callServiceJsapi("finderCreateLive", j3, str);
    }

    public void finderInit(long j3) {
        callServiceJsapi("finderInit", j3, "");
    }

    public void finderJoinLive(long j3, String str) {
        callServiceJsapi("finderJoinLive", j3, str);
    }

    public void finderLivePrepare(long j3, String str) {
        callServiceJsapi("finderLivePrepare", j3, str);
    }

    public void finderSetAnchorStatus(long j3, String str) {
        callServiceJsapi("finderSetAnchorStatus", j3, str);
    }

    public Context getContext() {
        return IlinkServiceImpl.getInstance().getContext();
    }

    public byte[] getJsBridgeData() {
        try {
            return AidlProto.ilinkliveGetJsBridgeDataResp.parseFrom(IlinkServiceImpl.getInstance().ReqCommFunctionWithResp(ILINKLIVE_SERVICE_FUNC, AidlProto.ilinkliveCommRequest.newBuilder().setFuncname("getJsBridgeData").build().toByteArray())).getData().toByteArray();
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            IlinkServiceLogImpl.getInstance().e("IlinkLiveServiceImpl", "getJsBridgeData resp error", new Object[0]);
            return new byte[0];
        }
    }

    public String getSdkdir() {
        return this.m_sdkdir_;
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void initLive(String str) {
        this.m_jsapi_bridge_ = new b();
        IlinkServiceImpl.getInstance().ReqCommFunctionWithResp(ILINKLIVE_SERVICE_FUNC, AidlProto.ilinkliveCommRequest.newBuilder().setFuncname("initLive").setFuncargs(ByteString.copyFrom(AidlProto.ilinkliveInit.newBuilder().setAppid(str).build().toByteArray())).build().toByteArray());
        File file = new File(this.m_sdkdir_, "tmppic");
        if (!file.exists()) {
            file.mkdirs();
        }
        deleteFile(file);
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void loadLiveWebView(WebView webView, String str) {
        this.m_webView_ = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        this.m_webView_.setBackgroundColor(0);
        this.m_webView_.getBackground().setAlpha(0);
        this.m_webView_.addJavascriptInterface(this.m_jsapi_bridge_.b(), "IlinkJSCore");
        this.m_webView_.setWebViewClient(new WebViewClient() { // from class: com.tencent.ilinkservice.IlinkLiveServiceImpl.1
            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageFinished(WebView webView2, String str2) {
                IlinkLiveServiceImpl.this.m_webView_.evaluateJavascript(IlinkLiveServiceImpl.this.m_jsapi_bridge_.c(), null);
                super.onPageFinished(webView2, str2);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageStarted(WebView webView2, String str2, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView2);
                super.onPageStarted(webView2, str2, bitmap);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView2, WebResourceRequest webResourceRequest) {
                String uri = webResourceRequest.getUrl().toString();
                b unused = IlinkLiveServiceImpl.this.m_jsapi_bridge_;
                IlinkServiceLogImpl.getInstance().i("IlinkLiveServiceImpl", "shouldInterceptRequest:" + uri, new Object[0]);
                if (uri.contains("https://ilinklivelocal")) {
                    try {
                        return new WebResourceResponse(ImageContentType.MIME_TYPE_JPG, "UTF-8", new FileInputStream(new File(uri.replace("https://ilinklivelocal", "").trim())));
                    } catch (FileNotFoundException e16) {
                        e16.printStackTrace();
                        IlinkServiceLogImpl.getInstance().e("IlinkLiveServiceImpl", "shouldInterceptRequest error:" + uri, new Object[0]);
                    }
                }
                return super.shouldInterceptRequest(webView2, webResourceRequest);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                webView2.loadUrl(str2);
                return true;
            }
        });
        this.m_webView_.setWebChromeClient(new WebChromeClient() { // from class: com.tencent.ilinkservice.IlinkLiveServiceImpl.2
            @Override // com.tencent.smtt.sdk.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                IlinkServiceLogImpl.getInstance().d("onConsoleMessage", consoleMessage.message(), new Object[0]);
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onProgressChanged(WebView webView2, int i3) {
                JsInjector.getInstance().onProgressChanged(webView2, i3);
                super.onProgressChanged(webView2, i3);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str2) {
                IlinkServiceLogImpl.getInstance().d("IlinkLiveImpl", "onReceivedTitle: " + str2, new Object[0]);
            }
        });
        this.m_webView_.clearCache(true);
        if (str.isEmpty()) {
            this.m_webView_.loadUrl("https://channels.weixin.qq.com/web/pages/extLive");
        } else {
            this.m_webView_.loadUrl(str);
        }
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void onReceiveActivityResult(int i3, int i16, Intent intent) {
        this.m_jsapi_bridge_.a(i3, i16, intent);
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void onReceiveRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.m_jsapi_bridge_.a(i3, strArr, iArr);
    }

    public void sendTransferRequest(long j3, String str) {
        callServiceJsapi("sendTransferRequest", j3, str);
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void thirdAppLogin(byte[] bArr) {
        IlinkServiceImpl.getInstance().ReqCommFunctionWithResp(ILINKLIVE_SERVICE_FUNC, AidlProto.ilinkliveCommRequest.newBuilder().setFuncname("thirdAppLogin").setFuncargs(ByteString.copyFrom(AidlProto.ilinkliveThirdLogin.newBuilder().setAuthbuffer(ByteString.copyFrom(bArr)).build().toByteArray())).build().toByteArray());
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void uninitLive() {
        IlinkServiceImpl.getInstance().ReqCommFunctionWithResp(ILINKLIVE_SERVICE_FUNC, AidlProto.ilinkliveCommRequest.newBuilder().setFuncname("uninitLive").build().toByteArray());
    }

    public void uploadMediaFile(long j3, String str) {
        callServiceJsapi("uploadMediaFile", j3, str);
    }

    IlinkLiveServiceImpl() {
        this.TAG = "IlinkLiveServiceImpl";
        this.m_jsapi_bridge_ = null;
        this.m_sdkdir_ = IlinkServiceImpl.getInstance().getContext().getExternalFilesDir(null) + "/ilinkservice";
    }

    public void OnLiveStart() {
    }

    public void OnLiveStop() {
    }

    public void OnRequestCloseWebView() {
    }

    public void OnRequestHideWebView() {
    }

    public void OnLiveRtmpUrlUpdate(String str) {
    }

    @Override // com.tencent.ilinkservice.IlinkLiveServiceInterface
    public void setCallback(a aVar) {
    }

    public void OnRequestPermission(String[] strArr, int i3) {
    }

    public void OnStartActivityForResult(Intent intent, int i3) {
    }

    public void OnLoginComplete(int i3, int i16, String str) {
    }
}
