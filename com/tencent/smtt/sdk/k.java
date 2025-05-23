package com.tencent.smtt.sdk;

import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;
import com.tencent.smtt.sdk.SystemWebViewClient;

/* compiled from: P */
/* loaded from: classes23.dex */
public class k extends ServiceWorkerController {
    @Override // com.tencent.smtt.sdk.ServiceWorkerController
    public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
        android.webkit.ServiceWorkerController serviceWorkerController;
        final android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT >= 24) {
            serviceWorkerController = android.webkit.ServiceWorkerController.getInstance();
            serviceWorkerWebSettings = serviceWorkerController.getServiceWorkerWebSettings();
            return new ServiceWorkerWebSettings() { // from class: com.tencent.smtt.sdk.k.1
                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public boolean getAllowContentAccess() {
                    boolean allowContentAccess;
                    if (Build.VERSION.SDK_INT >= 24) {
                        allowContentAccess = serviceWorkerWebSettings.getAllowContentAccess();
                        return allowContentAccess;
                    }
                    return false;
                }

                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public boolean getAllowFileAccess() {
                    boolean allowFileAccess;
                    if (Build.VERSION.SDK_INT >= 24) {
                        allowFileAccess = serviceWorkerWebSettings.getAllowFileAccess();
                        return allowFileAccess;
                    }
                    return false;
                }

                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public boolean getBlockNetworkLoads() {
                    boolean blockNetworkLoads;
                    if (Build.VERSION.SDK_INT >= 24) {
                        blockNetworkLoads = serviceWorkerWebSettings.getBlockNetworkLoads();
                        return blockNetworkLoads;
                    }
                    return false;
                }

                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public int getCacheMode() {
                    int cacheMode;
                    if (Build.VERSION.SDK_INT >= 24) {
                        cacheMode = serviceWorkerWebSettings.getCacheMode();
                        return cacheMode;
                    }
                    return -1;
                }

                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public void setAllowContentAccess(boolean z16) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        serviceWorkerWebSettings.setAllowContentAccess(z16);
                    }
                }

                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public void setAllowFileAccess(boolean z16) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        serviceWorkerWebSettings.setAllowContentAccess(z16);
                    }
                }

                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public void setBlockNetworkLoads(boolean z16) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        serviceWorkerWebSettings.setBlockNetworkLoads(z16);
                    }
                }

                @Override // com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
                public void setCacheMode(int i3) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        serviceWorkerWebSettings.setCacheMode(i3);
                    }
                }
            };
        }
        return null;
    }

    @Override // com.tencent.smtt.sdk.ServiceWorkerController
    public void setServiceWorkerClient(final ServiceWorkerClient serviceWorkerClient) {
        android.webkit.ServiceWorkerController serviceWorkerController;
        if (Build.VERSION.SDK_INT >= 24) {
            serviceWorkerController = android.webkit.ServiceWorkerController.getInstance();
            serviceWorkerController.setServiceWorkerClient(new android.webkit.ServiceWorkerClient() { // from class: com.tencent.smtt.sdk.k.2
                @Override // android.webkit.ServiceWorkerClient
                public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
                    boolean isRedirect;
                    String uri = webResourceRequest.getUrl().toString();
                    boolean isForMainFrame = webResourceRequest.isForMainFrame();
                    isRedirect = webResourceRequest.isRedirect();
                    com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest = serviceWorkerClient.shouldInterceptRequest(new SystemWebViewClient.e(uri, isForMainFrame, isRedirect, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
                    if (shouldInterceptRequest == null) {
                        return null;
                    }
                    WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
                    webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
                    int statusCode = shouldInterceptRequest.getStatusCode();
                    String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
                    if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
                        webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
                    }
                    return webResourceResponse;
                }
            });
        }
    }
}
