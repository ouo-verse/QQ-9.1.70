package org.tencwebrtc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglRenderer;
import org.tencwebrtc.RendererCommon;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents {
    private static final String TAG = "SurfaceViewRenderer";
    private final SurfaceEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    public SurfaceViewRenderer(Context context) {
        super(context);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(resourceName);
        this.eglRenderer = surfaceEglRenderer;
        getHolder().addCallback(this);
        getHolder().addCallback(surfaceEglRenderer);
    }

    private String getResourceName() {
        try {
            return getResources().getResourceEntryName(getId());
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFrameResolutionChanged$0(int i3, int i16) {
        this.rotatedFrameWidth = i3;
        this.rotatedFrameHeight = i16;
        updateSurfaceSize();
        requestLayout();
    }

    private void logD(String str) {
        Logging.d(TAG, this.resourceName + MsgSummary.STR_COLON + str);
    }

    private void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (this.enableFixedSize && this.rotatedFrameWidth != 0 && this.rotatedFrameHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            float width = getWidth() / getHeight();
            int i3 = this.rotatedFrameWidth;
            int i16 = this.rotatedFrameHeight;
            if (i3 / i16 > width) {
                i3 = (int) (i16 * width);
            } else {
                i16 = (int) (i3 / width);
            }
            int min = Math.min(getWidth(), i3);
            int min2 = Math.min(getHeight(), i16);
            logD("updateSurfaceSize. Layout size: " + getWidth() + HippyTKDListViewAdapter.X + getHeight() + ", frame size: " + this.rotatedFrameWidth + HippyTKDListViewAdapter.X + this.rotatedFrameHeight + ", requested surface size: " + min + HippyTKDListViewAdapter.X + min2 + ", old surface size: " + this.surfaceWidth + HippyTKDListViewAdapter.X + this.surfaceHeight);
            if (min != this.surfaceWidth || min2 != this.surfaceHeight) {
                this.surfaceWidth = min;
                this.surfaceHeight = min2;
                getHolder().setFixedSize(min, min2);
                return;
            }
            return;
        }
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        getHolder().setSizeFromLayout();
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f16, RendererCommon.GlDrawer glDrawer) {
        this.eglRenderer.addFrameListener(frameListener, f16, glDrawer);
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public int getEncodeNumber() {
        return this.eglRenderer.getEncodeNumber();
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        init(context, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    @Override // org.tencwebrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFirstFrameRendered();
        }
    }

    @Override // org.tencwebrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        this.eglRenderer.onFrame(videoFrame);
    }

    public void onFrameResolutionChanged(final int i3, int i16, int i17) {
        final int i18;
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFrameResolutionChanged(i3, i16, i17);
        }
        if (i17 != 0 && i17 != 180) {
            i18 = i16;
        } else {
            i18 = i3;
        }
        if (i17 == 0 || i17 == 180) {
            i3 = i16;
        }
        postOrRun(new Runnable() { // from class: org.tencwebrtc.aa
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceViewRenderer.this.lambda$onFrameResolutionChanged$0(i18, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((i17 - i3) / (i18 - i16));
        updateSurfaceSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i3, int i16) {
        ThreadUtils.checkIsOnMainThread();
        Point measure = this.videoLayoutMeasure.measure(i3, i16, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(measure.x, measure.y);
        logD("onMeasure(). New size: " + measure.x + HippyTKDListViewAdapter.X + measure.y);
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void release() {
        this.eglRenderer.release();
    }

    public void removeFrameListener(EglRenderer.FrameListener frameListener) {
        this.eglRenderer.removeFrameListener(frameListener);
    }

    public void setEnableHardwareScaler(boolean z16) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = z16;
        updateSurfaceSize();
    }

    public void setFpsReduction(float f16) {
        this.eglRenderer.setFpsReduction(f16);
    }

    public void setMirror(boolean z16) {
        this.eglRenderer.setMirror(z16);
    }

    public void setScalingType(RendererCommon.ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        requestLayout();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f16) {
        this.eglRenderer.addFrameListener(frameListener, f16);
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(context, this, iArr, glDrawer);
    }

    public void setScalingType(RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType, scalingType2);
        requestLayout();
    }

    public SurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(resourceName);
        this.eglRenderer = surfaceEglRenderer;
        getHolder().addCallback(this);
        getHolder().addCallback(surfaceEglRenderer);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
    }
}
