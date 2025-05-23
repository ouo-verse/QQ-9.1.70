package com.tencent.xweb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.compatible.PinusAdaptClient;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes27.dex */
public class XWebExtendPluginClient extends PinusAdaptClient implements ExtendPluginClient {
    public static final String NATIVE_VIEW_TYPE = "native_view";

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f385052a = new HashMap();
    public WebView obj;

    public XWebExtendPluginClient(XWebExtendInterface xWebExtendInterface) {
        super.init(xWebExtendInterface);
    }

    @Override // com.tencent.xweb.compatible.PinusAdaptClient
    public void initPSWebView(com.tencent.xweb.pinus.sdk.WebView webView) {
        super.initPSWebView(webView);
    }

    public XWebExtendPluginNativeViewDelegate onNativeViewReady(int i3) {
        return null;
    }

    public void onPluginDestroy(String str, int i3) {
        if (NATIVE_VIEW_TYPE.equals(str) && this.f385052a.containsKey(Integer.valueOf(i3))) {
            ((XWebExtendPluginNativeViewClient) this.f385052a.get(Integer.valueOf(i3))).dispose();
            this.f385052a.remove(Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.xweb.ExtendPluginClient
    public void onPluginManagerDestroy() {
        x0.d("XWebExtendPluginClient", "[onPluginManagerDestroy]");
        Iterator it = this.f385052a.values().iterator();
        while (it.hasNext()) {
            ((XWebExtendPluginNativeViewClient) it.next()).dispose();
        }
        this.f385052a.clear();
    }

    @Override // com.tencent.xweb.ExtendPluginClient
    public void onPluginSizeChanged(String str, int i3, int i16, int i17, SurfaceTexture surfaceTexture) {
        if (NATIVE_VIEW_TYPE.equals(str)) {
            if (!this.f385052a.containsKey(Integer.valueOf(i3))) {
                XWebExtendPluginNativeViewDelegate onNativeViewReady = onNativeViewReady(i3);
                if (onNativeViewReady != null) {
                    XWebExtendPluginNativeViewClient xWebExtendPluginNativeViewClient = new XWebExtendPluginNativeViewClient((Context) null, surfaceTexture, i16, i17);
                    this.f385052a.put(Integer.valueOf(i3), xWebExtendPluginNativeViewClient);
                    onNativeViewReady.setClient(xWebExtendPluginNativeViewClient);
                    xWebExtendPluginNativeViewClient.setDelegate(onNativeViewReady);
                } else {
                    x0.c("XWebExtendPluginClient", "onPluginSizeChanged, onNativeViewReady return null");
                    return;
                }
            }
            ((XWebExtendPluginNativeViewClient) this.f385052a.get(Integer.valueOf(i3))).onSizeChanged(i16, i17);
        }
        x0.d("XWebExtendPluginClient", "onPluginSizeChanged type:" + str + ", embedId:" + i3 + ", width:" + i16 + ", height:" + i17);
        if (surfaceTexture != null && i16 > 0 && i17 > 0) {
            surfaceTexture.setDefaultBufferSize(i16, i17);
        }
    }

    @Override // com.tencent.xweb.ExtendPluginClient
    public void onPluginSizeChangedForGPUProcess(String str, int i3, int i16, int i17, Surface surface) {
        if (NATIVE_VIEW_TYPE.equals(str)) {
            if (!this.f385052a.containsKey(Integer.valueOf(i3))) {
                XWebExtendPluginNativeViewDelegate onNativeViewReady = onNativeViewReady(i3);
                if (onNativeViewReady != null) {
                    XWebExtendPluginNativeViewClient xWebExtendPluginNativeViewClient = new XWebExtendPluginNativeViewClient((Context) null, surface, i16, i17);
                    this.f385052a.put(Integer.valueOf(i3), xWebExtendPluginNativeViewClient);
                    onNativeViewReady.setClient(xWebExtendPluginNativeViewClient);
                    xWebExtendPluginNativeViewClient.setDelegate(onNativeViewReady);
                } else {
                    x0.c("XWebExtendPluginClient", "onPluginSizeChanged onNativeViewReady return null");
                    return;
                }
            }
            ((XWebExtendPluginNativeViewClient) this.f385052a.get(Integer.valueOf(i3))).onSizeChanged(i16, i17);
        }
    }

    public void onPluginTouch(String str, int i3, String str2) {
    }

    public void setPluginTextureScale(String str, int i3, float f16, float f17) {
        if (this.xwebType == 1) {
            this.psWebview.setPluginTextureScale(str, i3, f16, f17);
        }
    }

    public void takePluginScreenshot(String str, int i3) {
        if (this.xwebType == 1) {
            this.psWebview.takePluginScreenshot(str, i3);
        }
    }

    public void onPluginTouch(String str, int i3, MotionEvent motionEvent) {
        if (NATIVE_VIEW_TYPE.equals(str) && this.f385052a.containsKey(Integer.valueOf(i3))) {
            ((XWebExtendPluginNativeViewClient) this.f385052a.get(Integer.valueOf(i3))).getRootView().dispatchTouchEvent(motionEvent);
        }
    }

    public void onPluginReady(String str, int i3, SurfaceTexture surfaceTexture) {
    }

    public void onPluginReadyForGPUProcess(String str, int i3, Surface surface) {
    }

    public void onPluginScreenshotTaken(String str, int i3, @Nullable Bitmap bitmap) {
    }
}
