package com.tencent.qqlive.tvkplayer.logo.impl;

import android.content.Context;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private boolean mIsSurfaceReady;

    public TVKLogoSurfaceView(Context context) {
        super(context);
        this.mIsSurfaceReady = false;
        initView();
        getHolder().addCallback(this);
    }

    private void initView() {
        boolean z16;
        getHolder().setFormat(-2);
        if (Build.VERSION.SDK_INT < 26) {
            z16 = true;
        } else {
            z16 = false;
        }
        setZOrderMediaOverlay(z16);
    }

    public boolean isSurfaceReady() {
        return this.mIsSurfaceReady;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.mIsSurfaceReady = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        this.mIsSurfaceReady = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
    }
}
