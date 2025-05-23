package com.tencent.ams.fusion.widget.animatorview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateListener;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender;
import com.tencent.ams.fusion.widget.animatorview.render.OldSurfaceAnimatorRender;
import com.tencent.ams.fusion.widget.animatorview.render.SurfaceAnimatorRender;
import com.tencent.ams.fusion.widget.animatorview.render.v2.SurfaceAnimatorRenderV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AnimatorView extends SurfaceView implements SurfaceHolder.Callback, IAnimatorView, IAnimatorViewHandler, IFrameRateConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AnimatorView";
    private ViewShowOnTop mClickDownViewShowOnTop;
    private final IAnimatorRender mRender;
    private ViewShowOnTop[] mViewsShowOnTop;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ViewShowOnTop {
        static IPatchRedirector $redirector_;
        private Canvas bmCanvas;
        private boolean isVisible;
        private ViewDrawChangedListener onDrawChangedListener;
        private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        private final View view;
        private BitmapLayer viewLayer;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public interface ViewDrawChangedListener {
            void onDrawChange();

            void onVisibilityChange(boolean z16);
        }

        public ViewShowOnTop(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.isVisible = true;
                this.view = view;
            }
        }

        void callOnClick() {
            View view = this.view;
            if (view != null) {
                view.callOnClick();
            }
        }

        int getHeight() {
            ViewGroup.LayoutParams layoutParams;
            int i3;
            View view = this.view;
            if (view != null) {
                int height = view.getHeight();
                if (height == 0 && (layoutParams = this.view.getLayoutParams()) != null && (i3 = layoutParams.height) > 0) {
                    return i3;
                }
                return height;
            }
            return 0;
        }

        int getWidth() {
            ViewGroup.LayoutParams layoutParams;
            int i3;
            View view = this.view;
            if (view != null) {
                int width = view.getWidth();
                if (width == 0 && (layoutParams = this.view.getLayoutParams()) != null && (i3 = layoutParams.width) > 0) {
                    return i3;
                }
                return width;
            }
            return 0;
        }

        boolean hasOnClickListeners() {
            View view = this.view;
            if (view != null) {
                return view.hasOnClickListeners();
            }
            return false;
        }

        public void notifyViewDrawChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Logger.i(AnimatorView.TAG, "notifyViewDrawChanged view: " + this.view);
            ViewDrawChangedListener viewDrawChangedListener = this.onDrawChangedListener;
            if (viewDrawChangedListener != null) {
                viewDrawChangedListener.onDrawChange();
            }
        }

        public void notifyViewVisibilityChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            Logger.i(AnimatorView.TAG, "notifyViewVisibilityChanged visible: " + z16 + ", view: " + this.view);
            this.isVisible = z16;
            ViewDrawChangedListener viewDrawChangedListener = this.onDrawChangedListener;
            if (viewDrawChangedListener != null) {
                viewDrawChangedListener.onVisibilityChange(z16);
            }
        }
    }

    public AnimatorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        init();
        if (AnimatorConfig.isRunOnOldRenderer()) {
            this.mRender = new OldSurfaceAnimatorRender(this);
            Logger.i(TAG, "run with OldSurfaceAnimatorRender");
        } else if (AnimatorConfig.getRunRendererVersion() == 2) {
            this.mRender = new SurfaceAnimatorRenderV2(this);
            Logger.i(TAG, "run with OldSurfaceAnimatorRender");
        } else {
            this.mRender = new SurfaceAnimatorRender(this);
            Logger.i(TAG, "run with SurfaceAnimatorRender");
        }
    }

    private void drawViewsOnTop() {
        ViewShowOnTop[] viewShowOnTopArr = this.mViewsShowOnTop;
        if (viewShowOnTopArr == null || viewShowOnTopArr.length <= 0) {
            return;
        }
        for (ViewShowOnTop viewShowOnTop : viewShowOnTopArr) {
            drawViewsOnTop(viewShowOnTop);
        }
    }

    private ViewShowOnTop getPositionViewShowOnTop(int i3, int i16) {
        ViewShowOnTop[] viewShowOnTopArr = this.mViewsShowOnTop;
        if (viewShowOnTopArr != null && viewShowOnTopArr.length > 0) {
            for (ViewShowOnTop viewShowOnTop : viewShowOnTopArr) {
                if (viewShowOnTop != null && viewShowOnTop.view != null && isClickInView(viewShowOnTop.view, i3, i16)) {
                    return viewShowOnTop;
                }
            }
            return null;
        }
        return null;
    }

    private void init() {
        if (!AnimatorConfig.isEnableHardware()) {
            setLayerType(1, null);
        }
        setZOrderOnTop(true);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-2);
        holder.addCallback(this);
    }

    private boolean isClickInView(View view, int i3, int i16) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        rect.left = view.getLeft();
        rect.bottom = view.getBottom();
        rect.right = view.getRight();
        rect.top = view.getTop();
        return rect.contains(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshViewShowOnTop(ViewShowOnTop viewShowOnTop) {
        if (viewShowOnTop != null && viewShowOnTop.view != null) {
            View view = viewShowOnTop.view;
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                if (viewShowOnTop.bmCanvas == null) {
                    viewShowOnTop.bmCanvas = new Canvas(createBitmap);
                } else {
                    viewShowOnTop.bmCanvas.setBitmap(createBitmap);
                }
                view.draw(viewShowOnTop.bmCanvas);
                BitmapLayer bitmapLayer = viewShowOnTop.viewLayer;
                if (bitmapLayer != null) {
                    bitmapLayer.setBitmap(createBitmap);
                    bitmapLayer.setX(view.getX());
                    bitmapLayer.setY(view.getY());
                }
            }
        }
    }

    private void revokeViewsOnTop() {
        ViewShowOnTop[] viewShowOnTopArr = this.mViewsShowOnTop;
        if (viewShowOnTopArr != null && viewShowOnTopArr.length > 0) {
            for (ViewShowOnTop viewShowOnTop : viewShowOnTopArr) {
                if (viewShowOnTop != null && viewShowOnTop.view != null) {
                    viewShowOnTop.view.setVisibility(0);
                    viewShowOnTop.onDrawChangedListener = null;
                    viewShowOnTop.view.getViewTreeObserver().removeOnGlobalLayoutListener(viewShowOnTop.onGlobalLayoutListener);
                }
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) animatorLayer);
        } else {
            this.mRender.addLayer(animatorLayer);
            animatorLayer.setCanvasView(this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mRender.clearCanvas();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mRender.clearLayers();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewShowOnTop positionViewShowOnTop;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent != null && (positionViewShowOnTop = getPositionViewShowOnTop((int) motionEvent.getX(), (int) motionEvent.getY())) != null && positionViewShowOnTop.hasOnClickListeners() && positionViewShowOnTop.isVisible) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (positionViewShowOnTop == this.mClickDownViewShowOnTop) {
                        positionViewShowOnTop.callOnClick();
                    }
                    return true;
                }
            } else {
                this.mClickDownViewShowOnTop = positionViewShowOnTop;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public List<AnimatorLayer> getLayerList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mRender.getLayerList();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public boolean isUserStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mRender.isUserStarted();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            Logger.d(TAG, "pauseAnimation");
            this.mRender.pauseAnimation();
        }
    }

    @Override // android.view.View
    public void postOnAnimation(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) runnable);
        } else {
            this.mRender.postTaskOnRenderThread(runnable, false);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) animatorLayer);
        } else {
            this.mRender.removeLayer(animatorLayer);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void resumeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            Logger.d(TAG, "resumeAnimation");
            this.mRender.resumeAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) animatorListener);
        } else {
            this.mRender.setAnimationListener(animatorListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setEnableFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.mRender.setEnableFrameRate(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setFrameRateListener(IFrameRateListener iFrameRateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) iFrameRateListener);
        } else {
            this.mRender.setFrameRateListener(iFrameRateListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setShowFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.mRender.setShowFrameRate(z16);
        }
    }

    public void setViewsShowOnTop(ViewShowOnTop[] viewShowOnTopArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) viewShowOnTopArr);
        } else {
            this.mViewsShowOnTop = viewShowOnTopArr;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorViewHandler
    public void smoothHideView(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) animatorListener);
            return;
        }
        List<AnimatorLayer> layerList = getLayerList();
        if (layerList != null && !layerList.isEmpty()) {
            for (AnimatorLayer animatorLayer : layerList) {
                if (animatorLayer != null) {
                    KeepAnimator keepAnimator = new KeepAnimator(animatorLayer);
                    keepAnimator.setDuration(200L);
                    AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 1.0f, 0.0f);
                    alphaAnimator.setDuration(120L);
                    alphaAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
                    alphaAnimator.setAnimatorListener(animatorListener);
                    animatorLayer.setAnimator(new SequentialAnimator(animatorLayer, keepAnimator, alphaAnimator));
                }
            }
        }
    }

    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Logger.d(TAG, QZoneJsConstants.ACTION_START_ANIMATION);
        this.mRender.startAnimation();
        drawViewsOnTop();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Logger.i(TAG, "stopAnimation");
        this.mRender.stopAnimation();
        revokeViewsOnTop();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Logger.i(TAG, "surfaceChanged width:" + i16 + ", height:" + i17);
        this.mRender.renderChanged();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceHolder);
        } else {
            Logger.i(TAG, "surfaceCreated");
            this.mRender.renderCreate();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceHolder);
        } else {
            Logger.i(TAG, "surfaceDestroyed");
            this.mRender.renderDestroy();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(int i3, AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) animatorLayer);
        } else {
            this.mRender.addLayer(i3, animatorLayer);
            animatorLayer.setCanvasView(this);
        }
    }

    private void drawViewsOnTop(ViewShowOnTop viewShowOnTop) {
        if (viewShowOnTop == null || viewShowOnTop.view == null) {
            return;
        }
        View view = viewShowOnTop.view;
        int width = viewShowOnTop.getWidth();
        int height = viewShowOnTop.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        viewShowOnTop.bmCanvas = new Canvas(createBitmap);
        view.draw(viewShowOnTop.bmCanvas);
        BitmapLayer bitmapLayer = new BitmapLayer(createBitmap);
        bitmapLayer.setX(view.getX());
        bitmapLayer.setY(view.getY());
        bitmapLayer.setAnimator(new KeepAnimator(bitmapLayer));
        addLayer(bitmapLayer);
        viewShowOnTop.viewLayer = bitmapLayer;
        view.setVisibility(4);
        viewShowOnTop.onDrawChangedListener = new ViewShowOnTop.ViewDrawChangedListener(viewShowOnTop) { // from class: com.tencent.ams.fusion.widget.animatorview.AnimatorView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ViewShowOnTop val$item;

            {
                this.val$item = viewShowOnTop;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimatorView.this, (Object) viewShowOnTop);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorView.ViewShowOnTop.ViewDrawChangedListener
            public void onDrawChange() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AnimatorView.this.refreshViewShowOnTop(this.val$item);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorView.ViewShowOnTop.ViewDrawChangedListener
            public void onVisibilityChange(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, z16);
                } else {
                    if (!z16) {
                        if (this.val$item.viewLayer != null) {
                            this.val$item.viewLayer.setBitmap(null);
                            return;
                        }
                        return;
                    }
                    onDrawChange();
                }
            }
        };
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(viewShowOnTop) { // from class: com.tencent.ams.fusion.widget.animatorview.AnimatorView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ ViewShowOnTop val$item;

            {
                this.val$item = viewShowOnTop;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimatorView.this, (Object) viewShowOnTop);
                }
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Logger.i(AnimatorView.TAG, "drawViewsOnTop: onGlobalLayout");
                if (this.val$item.isVisible) {
                    AnimatorView.this.refreshViewShowOnTop(this.val$item);
                }
            }
        };
        viewShowOnTop.onGlobalLayoutListener = onGlobalLayoutListener;
        viewShowOnTop.view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Logger.i(TAG, "stopAnimation clearCanvas:" + z16 + ", isUserStop:" + z17);
        this.mRender.stopAnimation(z16, z17);
    }
}
