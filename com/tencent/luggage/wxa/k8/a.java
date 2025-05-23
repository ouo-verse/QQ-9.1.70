package com.tencent.luggage.wxa.k8;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.z7.f;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements b {

    @Nullable
    protected com.tencent.luggage.wxa.m8.c clientProxy;

    /* renamed from: id, reason: collision with root package name */
    protected int f131781id;
    protected volatile boolean isPluginReady;
    protected String type;

    public int getId() {
        return this.f131781id;
    }

    @Nullable
    public com.tencent.luggage.wxa.m8.c getPluginClientProxy() {
        return this.clientProxy;
    }

    public String getType() {
        return this.type;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginDestroy() {
        this.isPluginReady = false;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginReadyForGPUProcess(Surface surface) {
        this.isPluginReady = true;
    }

    public String key() {
        return f.a(this.type, this.f131781id);
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void setId(int i3) {
        this.f131781id = i3;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void setPluginClientProxy(com.tencent.luggage.wxa.m8.c cVar) {
        this.clientProxy = cVar;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void setType(String str) {
        this.type = str;
    }

    public void unregisterMySelf() {
        com.tencent.luggage.wxa.m8.c cVar = this.clientProxy;
        if (cVar == null) {
            return;
        }
        cVar.a(this.type, this.f131781id);
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginScreenshotTaken(@Nullable Bitmap bitmap) {
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginTouch(MotionEvent motionEvent) {
    }
}
