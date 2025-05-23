package com.tencent.gamematrix.gmcg.sdk.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.webrtc.RotatableSurfaceViewRenderer;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;

/* loaded from: classes6.dex */
public class GmCgPlayView extends RotatableSurfaceViewRenderer {
    private boolean mEnableViewConfigCallback;
    private int mGameScreenOrientation;

    public GmCgPlayView(Context context) {
        super(context);
        this.mGameScreenOrientation = 1;
        this.mEnableViewConfigCallback = true;
    }

    public void configGameScreenOrientation(int i3) {
        configGameScreenOrientation(i3, true);
    }

    public void enableViewConfigCallback(boolean z16) {
        this.mEnableViewConfigCallback = z16;
    }

    public int getGameScreenOrientation() {
        return this.mGameScreenOrientation;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CGLog.i(this + " GmCgPlayView onConfigurationChanged");
        if (!this.mEnableViewConfigCallback) {
            CGLog.i("onConfigurationChanged not need!");
            return;
        }
        if (2 == configuration.orientation) {
            this.mGameScreenOrientation = 2;
        } else {
            this.mGameScreenOrientation = 1;
        }
        configGameScreenOrientation(this.mGameScreenOrientation);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void configGameScreenOrientation(int i3, boolean z16) {
        CGLog.i(CGSystemUtil.getStackTrackString());
        this.mGameScreenOrientation = i3;
        if (z16) {
            CGLog.i(this + "set game screen orientation: " + i3);
            if (2 == i3) {
                WebRTCSDK.setDegree(90);
                return;
            } else {
                WebRTCSDK.setDegree(360);
                return;
            }
        }
        setFullScreen(1 != i3);
    }

    public GmCgPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGameScreenOrientation = 1;
        this.mEnableViewConfigCallback = true;
    }
}
