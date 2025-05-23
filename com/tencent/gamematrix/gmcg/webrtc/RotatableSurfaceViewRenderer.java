package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.gamematrix.gmcg.base.log.CGLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RotatableSurfaceViewRenderer extends FilterSurfaceViewRenderer {
    private Point actualSize;
    private boolean fullScreen;
    private int videoHeight;
    private int videoWidth;

    public RotatableSurfaceViewRenderer(Context context) {
        super(context);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.actualSize = new Point(1920, 1080);
        this.fullScreen = true;
    }

    private void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    @Override // org.tencwebrtc.SurfaceViewRenderer, org.tencwebrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i3, int i16, int i17) {
        if (this.fullScreen) {
            WebRTCSDK.mWidth = i3;
            this.videoWidth = i3;
            WebRTCSDK.mHeight = i16;
            this.videoHeight = i16;
            CGLog.i("RotatableSurfaceViewRenderer onFrameResolutionChanged, width=" + i3 + ", height=" + i16);
            postOrRun(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.b
                @Override // java.lang.Runnable
                public final void run() {
                    RotatableSurfaceViewRenderer.this.requestLayout();
                }
            });
            return;
        }
        super.onFrameResolutionChanged(i3, i16, i17);
    }

    @Override // org.tencwebrtc.SurfaceViewRenderer, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.fullScreen) {
            CGLog.i("will not call onLayout(changed=" + z16 + ", left=" + i3 + ", top=" + i16 + ", right=" + i17 + ", bottom=" + i18);
            return;
        }
        CGLog.i("onLayout(changed=" + z16 + ", left=" + i3 + ", top=" + i16 + ", right=" + i17 + ", bottom=" + i18);
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // org.tencwebrtc.SurfaceViewRenderer, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.videoWidth != 0 && this.videoHeight != 0 && this.fullScreen) {
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            CGLog.i("onMeasure layoutWidth=" + size + ", layoutHeight=" + size2 + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight);
            float f16 = (float) size;
            float f17 = (float) size2;
            float f18 = f16 / f17;
            if (size > size2) {
                int i17 = this.videoWidth;
                int i18 = this.videoHeight;
                if (i17 > i18) {
                    float f19 = i17 / i18;
                    if (f18 > f19) {
                        Point point = this.actualSize;
                        point.x = (int) (f17 * f19);
                        point.y = size2;
                    } else {
                        Point point2 = this.actualSize;
                        point2.x = size;
                        point2.y = (int) (f16 / f19);
                    }
                } else {
                    float f26 = i18 / i17;
                    if (f18 > f26) {
                        Point point3 = this.actualSize;
                        point3.x = (int) (f17 * f26);
                        point3.y = size2;
                    } else {
                        Point point4 = this.actualSize;
                        point4.x = size;
                        point4.y = (int) (f16 / f26);
                    }
                }
            } else {
                int i19 = this.videoHeight;
                int i26 = this.videoWidth;
                if (i19 > i26) {
                    float f27 = i26 / i19;
                    if (f18 > f27) {
                        Point point5 = this.actualSize;
                        point5.x = (int) (f17 * f27);
                        point5.y = size2;
                    } else {
                        Point point6 = this.actualSize;
                        point6.x = size;
                        point6.y = (int) (f16 / f27);
                    }
                } else {
                    float f28 = i19 / i26;
                    if (f18 > f28) {
                        Point point7 = this.actualSize;
                        point7.x = (int) (f17 * f28);
                        point7.y = size2;
                    } else {
                        Point point8 = this.actualSize;
                        point8.x = size;
                        point8.y = (int) (f16 / f28);
                    }
                }
            }
            CGLog.i("onMeasure actualSize.x=" + this.actualSize.x + ", actualSize.y=" + this.actualSize.y);
            Point point9 = this.actualSize;
            setMeasuredDimension(point9.x, point9.y);
            return;
        }
        super.onMeasure(i3, i16);
    }

    public void setFullScreen(boolean z16) {
        this.fullScreen = z16;
        CGLog.i("RotatableSurfaceViewRenderer setFullScreen=" + z16);
    }

    public RotatableSurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.actualSize = new Point(1920, 1080);
        this.fullScreen = true;
    }
}
