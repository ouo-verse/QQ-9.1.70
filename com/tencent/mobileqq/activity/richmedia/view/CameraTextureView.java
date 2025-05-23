package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mobileqq.shortvideo.mediadevice.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes10.dex */
public class CameraTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: d, reason: collision with root package name */
    public e f186031d;

    public CameraTextureView(Context context) {
        this(context, null);
        a();
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (QLog.isColorLevel()) {
            QLog.i("PEAK_CAMERA", 2, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("PEAK_CAMERA", 2, "onAttachedToWindow[crash]", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("PEAK_CAMERA", 2, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("CameraTextureView", 2, "onSurfaceTextureAvailable width " + i3 + ", height " + i16);
        }
        this.f186031d.onSurfaceTextureAvailable(surfaceTexture, i3, i16);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (QLog.isColorLevel()) {
            QLog.i("CameraTextureView", 2, "onSurfaceTextureDestroyed");
        }
        this.f186031d.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("CameraTextureView", 2, "onSurfaceTextureSizeChanged width " + i3 + ", height " + i16);
        }
        this.f186031d.onSurfaceTextureSizeChanged(surfaceTexture, i3, i16);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f186031d.onSurfaceTextureUpdated(surfaceTexture);
    }

    public CameraTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a();
    }

    public CameraTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
