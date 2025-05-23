package com.tencent.luggage.wxa.z7;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.XWebExtendPluginClient;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends XWebExtendPluginClient implements b {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.m8.c f146381b;

    public e(XWebExtendInterface xWebExtendInterface) {
        super(xWebExtendInterface);
    }

    public void a(com.tencent.luggage.wxa.m8.c cVar) {
        this.f146381b = cVar;
    }

    @Override // com.tencent.xweb.XWebExtendPluginClient, com.tencent.xweb.ExtendPluginClient
    public void onPluginDestroy(String str, int i3) {
        super.onPluginDestroy(str, i3);
        com.tencent.luggage.wxa.m8.c cVar = this.f146381b;
        if (cVar != null) {
            cVar.onPluginDestroy(str, i3);
        }
    }

    @Override // com.tencent.xweb.XWebExtendPluginClient, com.tencent.xweb.ExtendPluginClient
    public void onPluginReady(String str, int i3, SurfaceTexture surfaceTexture) {
        super.onPluginReady(str, i3, surfaceTexture);
        com.tencent.luggage.wxa.m8.c cVar = this.f146381b;
        if (cVar != null) {
            cVar.onPluginReady(str, i3, surfaceTexture);
        }
    }

    @Override // com.tencent.xweb.XWebExtendPluginClient, com.tencent.xweb.ExtendPluginClient
    public void onPluginReadyForGPUProcess(String str, int i3, Surface surface) {
        super.onPluginReadyForGPUProcess(str, i3, surface);
        com.tencent.luggage.wxa.m8.c cVar = this.f146381b;
        if (cVar != null) {
            cVar.onPluginReadyForGPUProcess(str, i3, surface);
        }
    }

    @Override // com.tencent.xweb.XWebExtendPluginClient, com.tencent.xweb.ExtendPluginClient
    public void onPluginScreenshotTaken(String str, int i3, Bitmap bitmap) {
        super.onPluginScreenshotTaken(str, i3, bitmap);
        com.tencent.luggage.wxa.m8.c cVar = this.f146381b;
        if (cVar != null) {
            cVar.onPluginScreenshotTaken(str, i3, bitmap);
        }
    }

    @Override // com.tencent.xweb.XWebExtendPluginClient, com.tencent.xweb.ExtendPluginClient
    public void onPluginTouch(String str, int i3, MotionEvent motionEvent) {
        super.onPluginTouch(str, i3, motionEvent);
        com.tencent.luggage.wxa.m8.c cVar = this.f146381b;
        if (cVar != null) {
            cVar.onPluginTouch(str, i3, motionEvent);
        }
    }

    @Override // com.tencent.xweb.XWebExtendPluginClient, com.tencent.luggage.wxa.z7.b
    public void setPluginTextureScale(String str, int i3, float f16, float f17) {
        super.setPluginTextureScale(str, i3, f16, f17);
    }

    @Override // com.tencent.xweb.XWebExtendPluginClient, com.tencent.luggage.wxa.z7.b
    public void takePluginScreenshot(String str, int i3) {
        super.takePluginScreenshot(str, i3);
    }
}
