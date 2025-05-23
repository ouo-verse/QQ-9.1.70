package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: d, reason: collision with root package name */
    SurfaceHolder f288131d;

    /* renamed from: e, reason: collision with root package name */
    public d f288132e;

    public CameraPreview(Context context) {
        super(context);
        super.getResources().getDisplayMetrics();
        SurfaceHolder holder = getHolder();
        this.f288131d = holder;
        holder.addCallback(this);
        this.f288131d.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        this.f288132e.surfaceChanged(surfaceHolder, i3, i16, i17);
        if (QLog.isColorLevel()) {
            QLog.d("CameraPreview", 2, "[@] surfaceChanged end");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f288132e.surfaceCreated(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f288132e.surfaceDestroyed(surfaceHolder);
    }
}
