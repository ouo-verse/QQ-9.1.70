package eu3;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.util.IPV6OnlyUtils;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class i extends WebViewClient {

    /* renamed from: b, reason: collision with root package name */
    private final IMiniAppContext f397158b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f397159c;

    public i(IMiniAppContext iMiniAppContext) {
        this.f397158b = iMiniAppContext;
    }

    private WebResourceResponse b(WebResourceResponse webResourceResponse) {
        ByteArrayInputStream byteArrayInputStream;
        int i3;
        String basePageFrameStr = ((BaseRuntimeImpl.BaselibProvider) this.f397158b.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBasePageFrameStr();
        if (!TextUtils.isEmpty(basePageFrameStr)) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                try {
                    byte[] bArr = this.f397159c;
                    if (bArr == null || bArr.length == 0) {
                        this.f397159c = basePageFrameStr.getBytes("UTF-8");
                    }
                    byte[] bArr2 = this.f397159c;
                    i3 = 0;
                    byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, bArr2.length);
                } catch (UnsupportedEncodingException e16) {
                    e = e16;
                }
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                try {
                    WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/html", "UTF-8", byteArrayInputStream);
                    try {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("load default page html. length= ");
                        byte[] bArr3 = this.f397159c;
                        if (bArr3 != null) {
                            i3 = bArr3.length;
                        }
                        sb5.append(i3);
                        QMLog.d("Mini-WebViewClient", sb5.toString());
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        return webResourceResponse2;
                    } catch (UnsupportedEncodingException e18) {
                        e = e18;
                        webResourceResponse = webResourceResponse2;
                        byteArrayInputStream2 = byteArrayInputStream;
                        e.printStackTrace();
                        QMLog.e("Mini-WebViewClient", "load page html error.", e);
                        if (byteArrayInputStream2 != null) {
                            try {
                                byteArrayInputStream2.close();
                                return webResourceResponse;
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                return webResourceResponse;
                            }
                        }
                        return webResourceResponse;
                    }
                } catch (UnsupportedEncodingException e26) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayInputStream2 = byteArrayInputStream;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                throw th;
            }
        } else {
            return webResourceResponse;
        }
    }

    private WebResourceResponse c(String str) {
        if (str.startsWith("https://appservice.qq.com/") && str.endsWith(".html")) {
            return b(null);
        }
        if (str.startsWith("https://appservice.qq.com/")) {
            return e(str, ((MiniAppFileManager) this.f397158b.getManager(MiniAppFileManager.class)).getAbsolutePath(str.substring(26)));
        }
        if (!str.startsWith("wxfile://")) {
            return null;
        }
        return e(str, ((MiniAppFileManager) this.f397158b.getManager(MiniAppFileManager.class)).getAbsolutePath(str));
    }

    private HttpURLConnection d(WebResourceRequest webResourceRequest) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(webResourceRequest.getUrl().toString()).openConnection();
        httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
        if (webResourceRequest.getRequestHeaders() != null) {
            for (Map.Entry<String, String> entry : webResourceRequest.getRequestHeaders().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        httpURLConnection.setConnectTimeout(6000);
        httpURLConnection.setReadTimeout(6000);
        return httpURLConnection;
    }

    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        try {
            String str = WnsConfig.getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=") + uri;
            QMLog.e("Mini-WebViewClient", "ipv6 url = " + str);
            HttpURLConnection d16 = d(webResourceRequest);
            String str2 = "";
            if (d16.getHeaderFields() != null && d16.getHeaderFields().containsKey("Content-Type")) {
                str2 = d16.getHeaderFields().get("Content-Type").get(0);
            }
            String mimeType = IPV6OnlyUtils.getMimeType(str2);
            String encoding = IPV6OnlyUtils.getEncoding(str2);
            QMLog.e("Mini-WebViewClient", "ipv6 code:" + d16.getResponseCode() + "  url:" + str);
            QMLog.e("Mini-WebViewClient", "ipv6 mimeType = " + mimeType + "encoding:" + encoding);
            return new WebResourceResponse(mimeType, encoding, d16.getInputStream());
        } catch (Exception e16) {
            QMLog.e("Mini-WebViewClient", "shouldInterceptRequest: failed ", e16);
            return null;
        }
    }

    public WebResourceResponse e(String str, String str2) {
        InputStream localImageStreamWithCache;
        String mimeType = ImageUtil.getMimeType(str);
        if (!ImageUtil.isJpgFile(str) && !ImageUtil.isPngFile(str)) {
            if (!str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !str.endsWith(".svg")) {
                localImageStreamWithCache = null;
            } else {
                localImageStreamWithCache = ImageUtil.getLocalImageStreamWithCache(str2, mimeType, false);
            }
        } else {
            localImageStreamWithCache = ImageUtil.getLocalImageStreamWithCache(str2, mimeType, true);
        }
        if (localImageStreamWithCache == null) {
            return null;
        }
        return new WebResourceResponse(mimeType, "UTF-8", localImageStreamWithCache);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        QMLog.i("Mini-WebViewClient", "shouldInterceptRequest: " + webResourceRequest.getUrl());
        if (webResourceRequest.getUrl() == null) {
            return null;
        }
        String uri = webResourceRequest.getUrl().toString();
        if (!TextUtils.isEmpty(uri) && (uri.startsWith("https://appservice.qq.com/") || uri.startsWith("wxfile://"))) {
            return c(webResourceRequest.getUrl().toString());
        }
        if (!IPV6OnlyUtils.isIPV6Enable(uri)) {
            return null;
        }
        return a(webResourceRequest);
    }
}
