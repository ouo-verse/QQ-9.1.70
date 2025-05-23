package com.tencent.av.app;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends CameraManager.AvailabilityCallback {

    /* renamed from: a, reason: collision with root package name */
    private Context f73151a;

    /* renamed from: b, reason: collision with root package name */
    private String f73152b;

    public c(Context context, String str) {
        this.f73151a = context;
        this.f73152b = str;
    }

    private void a(String str, int i3) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.qav.camera.availability");
        intent.putExtra("camera_id", str);
        intent.putExtra("availability", i3);
        if (TextUtils.isEmpty(this.f73152b)) {
            intent.setPackage("com.tencent.mobileqq");
        } else {
            intent.setPackage(this.f73152b);
        }
        Context context = this.f73151a;
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public void onCameraAvailable(String str) {
        a(str, 1);
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public void onCameraUnavailable(String str) {
        a(str, 0);
    }
}
