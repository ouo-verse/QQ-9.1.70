package com.tencent.qqlive.tvkplayer.view.subview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSurfaceView extends SurfaceView implements ITVKDisplayView {
    private static final float DEFAULT_SCALE_PARAM = 1.0f;
    private static final String TAG = "TVKPlayer[QQLiveSurfaceView]";
    private final String mInstanceTag;
    private boolean mLastSecureState;
    private float mScaleWithAnchor;
    private float mScaleWithoutAnchor;
    private final SurfaceHolder.Callback mSurfaceCallback;
    private int mType;
    private int mVideoHeight;
    private int mVideoWidth;
    private ITVKDisplayView.IDisplayViewCallback mViewCallBack;

    public TVKSurfaceView(Context context) {
        super(context);
        this.mType = 0;
        this.mScaleWithoutAnchor = 1.0f;
        this.mScaleWithAnchor = 1.0f;
        this.mLastSecureState = false;
        this.mSurfaceCallback = new SurfaceHolder.Callback() { // from class: com.tencent.qqlive.tvkplayer.view.subview.TVKSurfaceView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
                if (TVKSurfaceView.this.mViewCallBack != null) {
                    TVKSurfaceView.this.mViewCallBack.onViewChanged(surfaceHolder.getSurface(), i16, i17);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                if (TVKSurfaceView.this.mViewCallBack != null) {
                    TVKSurfaceView.this.mViewCallBack.onViewCreated(surfaceHolder.getSurface(), TVKSurfaceView.this.getWidth(), TVKSurfaceView.this.getHeight());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                if (TVKSurfaceView.this.mViewCallBack != null) {
                    TVKSurfaceView.this.mViewCallBack.onViewDestroyed(surfaceHolder.getSurface());
                }
            }
        };
        initView();
        this.mInstanceTag = TAG + new Random().nextInt();
    }

    private void initView() {
        int i3;
        this.mScaleWithoutAnchor = 1.0f;
        this.mType = 0;
        SurfaceHolder holder = getHolder();
        if (TVKMediaPlayerConfig.PlayerConfig.disable_surface_pixel_format_with_alpha_channel) {
            i3 = -1;
        } else {
            i3 = -2;
        }
        holder.setFormat(i3);
        getHolder().addCallback(this.mSurfaceCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOffset$2(float f16, float f17) {
        setTranslationX(f16);
        setTranslationY(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setScale$0(float f16) {
        if (this.mScaleWithAnchor != 1.0f) {
            this.mScaleWithAnchor = 1.0f;
            setScaleX(1.0f);
            setScaleY(this.mScaleWithAnchor);
        }
        if (this.mScaleWithoutAnchor == f16) {
            return;
        }
        this.mScaleWithoutAnchor = f16;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setScale$1(float f16, float f17, float f18) {
        if (this.mScaleWithoutAnchor != 1.0f) {
            this.mScaleWithoutAnchor = 1.0f;
            requestLayout();
        }
        this.mScaleWithAnchor = f16;
        setPivotX(f17);
        setPivotY(f18);
        setScaleX(f16);
        setScaleY(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewSecure$3(boolean z16) {
        int i3;
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        boolean z17 = parent instanceof ViewGroup;
        if (z17) {
            ViewGroup viewGroup = (ViewGroup) parent;
            i3 = viewGroup.indexOfChild(this);
            viewGroup.removeView(this);
        } else {
            i3 = 0;
        }
        setSecure(z16);
        this.mLastSecureState = z16;
        if (z17) {
            ((ViewGroup) parent).addView(this, i3, layoutParams);
        }
    }

    private void onMeasureForOriginalFullscreen(int i3, int i16, float f16) {
        int i17 = this.mVideoWidth;
        int i18 = i17 * i16;
        int i19 = this.mVideoHeight;
        if (i18 > i3 * i19) {
            i3 = (i17 * i16) / i19;
        } else if (i17 * i16 < i3 * i19) {
            i16 = (i19 * i3) / i17;
        }
        float f17 = this.mScaleWithoutAnchor;
        setMeasuredDimension((int) (i3 * f17 * f16), (int) (i16 * f17 * f16));
    }

    private void onMeasureForOriginalRatio(int i3, int i16, float f16) {
        int i17 = this.mVideoWidth;
        int i18 = i17 * i16;
        int i19 = this.mVideoHeight;
        if (i18 > i3 * i19) {
            i16 = (i19 * i3) / i17;
        } else if (i17 * i16 < i3 * i19) {
            i3 = (i17 * i16) / i19;
        }
        float f17 = this.mScaleWithoutAnchor;
        setMeasuredDimension((int) (i3 * f17 * f16), (int) (i16 * f17 * f16));
    }

    private void onMeasureForOriginalRatioSquare(int i3, int i16, float f16) {
        int i17 = this.mVideoWidth;
        int i18 = i17 * i16;
        int i19 = this.mVideoHeight;
        if (i18 > i3 * i19) {
            i16 = (i19 * i3) / i17;
        } else if (i17 * i16 < i3 * i19) {
            i3 = (i16 * i17) / i19;
            float f17 = i16;
            f16 = f17 / ((i17 / i19) * f17);
        }
        float f18 = this.mScaleWithoutAnchor;
        setMeasuredDimension((int) (i3 * f18 * f16), (int) (i16 * f18 * f16));
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        TVKLogUtil.i(this.mInstanceTag, "[onMeasure] video width=" + this.mVideoWidth + ", video height= " + this.mVideoHeight + ", widthMeasureSpec=" + i3 + ", heightMeasureSpec=" + i16);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            try {
                int i17 = this.mType;
                if (i17 == 2) {
                    onMeasureForOriginalFullscreen(size, size2, 1.0f);
                } else if (i17 == 1) {
                    float f16 = this.mScaleWithoutAnchor;
                    setMeasuredDimension((int) (size * f16 * 1.0f), (int) (size2 * f16 * 1.0f));
                } else if (i17 == 6) {
                    onMeasureForOriginalRatioSquare(size, size2, 1.0f);
                } else {
                    onMeasureForOriginalRatio(size, size2, 1.0f);
                }
                return;
            } catch (Exception unused) {
                super.onMeasure(i3, i16);
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public boolean setDegree(int i3) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setFixedSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            if (i3 != this.mVideoWidth || i16 != this.mVideoHeight) {
                this.mVideoWidth = i3;
                this.mVideoHeight = i16;
                TVKThreadPool.getInstance().postRunnableOnMainThread(new e(this));
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setOffset(final float f16, final float f17) {
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.subview.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKSurfaceView.this.lambda$setOffset$2(f16, f17);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setScale(final float f16) {
        if (f16 <= 0.0f) {
            return;
        }
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.subview.d
            @Override // java.lang.Runnable
            public final void run() {
                TVKSurfaceView.this.lambda$setScale$0(f16);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setViewCallBack(ITVKDisplayView.IDisplayViewCallback iDisplayViewCallback) {
        this.mViewCallBack = iDisplayViewCallback;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public boolean setViewSecure(final boolean z16) {
        if (this.mLastSecureState == z16) {
            return true;
        }
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.subview.c
            @Override // java.lang.Runnable
            public final void run() {
                TVKSurfaceView.this.lambda$setViewSecure$3(z16);
            }
        });
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setXYaxis(int i3) {
        if (this.mType == i3) {
            return;
        }
        this.mType = i3;
        TVKThreadPool.getInstance().postRunnableOnMainThread(new e(this));
    }

    @Override // android.view.View
    @NonNull
    public String toString() {
        return this.mInstanceTag;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setScale(final float f16, final float f17, final float f18) {
        if (f16 <= 0.0f) {
            return;
        }
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.subview.f
            @Override // java.lang.Runnable
            public final void run() {
                TVKSurfaceView.this.lambda$setScale$1(f16, f17, f18);
            }
        });
    }

    public TVKSurfaceView(Context context, boolean z16, boolean z17) {
        super(context);
        this.mType = 0;
        this.mScaleWithoutAnchor = 1.0f;
        this.mScaleWithAnchor = 1.0f;
        this.mLastSecureState = false;
        this.mSurfaceCallback = new SurfaceHolder.Callback() { // from class: com.tencent.qqlive.tvkplayer.view.subview.TVKSurfaceView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
                if (TVKSurfaceView.this.mViewCallBack != null) {
                    TVKSurfaceView.this.mViewCallBack.onViewChanged(surfaceHolder.getSurface(), i16, i17);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                if (TVKSurfaceView.this.mViewCallBack != null) {
                    TVKSurfaceView.this.mViewCallBack.onViewCreated(surfaceHolder.getSurface(), TVKSurfaceView.this.getWidth(), TVKSurfaceView.this.getHeight());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                if (TVKSurfaceView.this.mViewCallBack != null) {
                    TVKSurfaceView.this.mViewCallBack.onViewDestroyed(surfaceHolder.getSurface());
                }
            }
        };
        if (z16) {
            setZOrderOnTop(z16);
        }
        if (z17) {
            setZOrderMediaOverlay(z17);
        }
        initView();
        this.mInstanceTag = TAG + new Random().nextInt();
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setOpaqueInfo(boolean z16) {
    }
}
