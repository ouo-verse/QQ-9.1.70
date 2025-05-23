package com.tencent.qqlive.tvkplayer.view.subview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKTextureView extends TextureView implements ITVKDisplayView {
    private static final float SCALE_EPSILON = 1.0E-4f;
    private static final String TAG = "TVKPlayer[QQLiveTextureView_N]";
    public static List<WeakReference<TextureView>> textureViewList = new ArrayList();
    private int mDegree;
    private final String mInstanceTag;
    private int mRatioType;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private TextureView.SurfaceTextureListener mTextureListener;
    private int mVideoHeight;
    private int mVideoWidth;
    private ITVKDisplayView.IDisplayViewCallback mViewCallBack;

    public TVKTextureView(Context context) {
        super(context);
        this.mDegree = 0;
        this.mRatioType = 0;
        this.mTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.qqlive.tvkplayer.view.subview.TVKTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                if (TVKTextureView.this.mViewCallBack != null) {
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mViewCallBack.onViewCreated(TVKTextureView.this.mSurface, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return true;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                boolean onViewDestroyed = TVKTextureView.this.mViewCallBack.onViewDestroyed(TVKTextureView.this.mSurface);
                if (onViewDestroyed) {
                    TVKTextureView.this.mSurface = null;
                    TVKTextureView.this.mSurfaceTexture = null;
                }
                return onViewDestroyed;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                TVKTextureView.this.mViewCallBack.onViewChanged(TVKTextureView.this.mSurface, i3, i16);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                TVKTextureView.this.mViewCallBack.onViewChanged(TVKTextureView.this.mSurface, TVKTextureView.this.getWidth(), TVKTextureView.this.getHeight());
            }
        };
        initView();
        this.mInstanceTag = TAG + new Random().nextInt();
    }

    public static void addTextureView(TextureView textureView) {
        textureViewList.add(new WeakReference<>(textureView));
    }

    private float getVScale(int i3, int i16, int i17, int i18) {
        int i19 = this.mDegree;
        if ((i19 == 90 || i19 == 270) && i16 > 0 && i3 > 0) {
            if (i17 / i16 < i18 / i3) {
                return i17 / i16;
            }
            return i18 / i3;
        }
        return 1.0f;
    }

    private void initView() {
        setOpaque(false);
        setAlpha(0.0f);
        setScaleX(1.0001f);
        setScaleY(1.0001f);
        setSurfaceTextureListener(this.mTextureListener);
        addTextureView(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOffset$1(float f16, float f17) {
        setTranslationX(f16);
        setTranslationY(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setScale$0(float f16, float f17, float f18) {
        setPivotX(f16);
        setPivotY(f17);
        setScaleX(f18);
        setScaleY(f18);
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
        setMeasuredDimension((int) (i3 * f16), (int) (i16 * f16));
    }

    private void onMeasureForOriginalRatio(int i3, int i16) {
        int i17;
        int i18;
        int i19 = this.mVideoWidth;
        int i26 = i19 * i16;
        int i27 = this.mVideoHeight;
        if (i26 > i3 * i27) {
            i18 = (i27 * i3) / i19;
            i17 = i3;
        } else {
            if (i26 < i3 * i27) {
                i17 = i26 / i27;
            } else {
                i17 = i3;
            }
            i18 = i16;
        }
        float vScale = getVScale(i17, i18, i3, i16);
        setMeasuredDimension((int) (i17 * vScale), (int) (i18 * vScale));
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
        setMeasuredDimension((int) (i3 * f16), (int) (i16 * f16));
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        TVKLogUtil.i(this.mInstanceTag, "[onMeasure] video width=" + this.mVideoWidth + ", video height= " + this.mVideoHeight + ", widthMeasureSpec=" + i3 + ", heightMeasureSpec=" + i16);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int defaultSize = View.getDefaultSize(getWidth(), i3);
            int defaultSize2 = View.getDefaultSize(getHeight(), i16);
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
            ((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin = 0;
            int i17 = this.mRatioType;
            if (i17 == 2) {
                onMeasureForOriginalFullscreen(defaultSize, defaultSize2, 1.0f);
                return;
            }
            if (i17 == 1) {
                setMeasuredDimension((int) (defaultSize * 1.0f), (int) (defaultSize2 * 1.0f));
                return;
            } else if (i17 == 6) {
                onMeasureForOriginalRatioSquare(defaultSize, defaultSize2, 1.0f);
                return;
            } else {
                onMeasureForOriginalRatio(defaultSize, defaultSize2);
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public boolean setDegree(int i3) {
        setRotation(i3);
        this.mDegree = i3;
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setFixedSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            if (i3 != this.mVideoWidth || i16 != this.mVideoHeight) {
                this.mVideoWidth = i3;
                this.mVideoHeight = i16;
                TVKThreadPool.getInstance().postRunnableOnMainThread(new g(this));
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setOffset(final float f16, final float f17) {
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.subview.i
            @Override // java.lang.Runnable
            public final void run() {
                TVKTextureView.this.lambda$setOffset$1(f16, f17);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setOpaqueInfo(boolean z16) {
        if (z16) {
            setOpaque(true);
            setAlpha(1.0f);
        } else {
            setOpaque(false);
            setAlpha(0.0f);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setScale(float f16) {
        setScale(f16, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setViewCallBack(ITVKDisplayView.IDisplayViewCallback iDisplayViewCallback) {
        this.mViewCallBack = iDisplayViewCallback;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public boolean setViewSecure(boolean z16) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView
    public void setXYaxis(int i3) {
        if (this.mRatioType == i3) {
            return;
        }
        this.mRatioType = i3;
        TVKThreadPool.getInstance().postRunnableOnMainThread(new g(this));
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
        if (Math.abs(f16 - 1.0f) < 1.0E-4f) {
            f16 = 1.0001f;
        }
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.subview.h
            @Override // java.lang.Runnable
            public final void run() {
                TVKTextureView.this.lambda$setScale$0(f17, f18, f16);
            }
        });
    }

    public TVKTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDegree = 0;
        this.mRatioType = 0;
        this.mTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.qqlive.tvkplayer.view.subview.TVKTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                if (TVKTextureView.this.mViewCallBack != null) {
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mViewCallBack.onViewCreated(TVKTextureView.this.mSurface, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return true;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                boolean onViewDestroyed = TVKTextureView.this.mViewCallBack.onViewDestroyed(TVKTextureView.this.mSurface);
                if (onViewDestroyed) {
                    TVKTextureView.this.mSurface = null;
                    TVKTextureView.this.mSurfaceTexture = null;
                }
                return onViewDestroyed;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                TVKTextureView.this.mViewCallBack.onViewChanged(TVKTextureView.this.mSurface, i3, i16);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                TVKTextureView.this.mViewCallBack.onViewChanged(TVKTextureView.this.mSurface, TVKTextureView.this.getWidth(), TVKTextureView.this.getHeight());
            }
        };
        initView();
        this.mInstanceTag = TAG + new Random().nextInt();
    }

    public TVKTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDegree = 0;
        this.mRatioType = 0;
        this.mTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.qqlive.tvkplayer.view.subview.TVKTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i36, int i16) {
                if (TVKTextureView.this.mViewCallBack != null) {
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mViewCallBack.onViewCreated(TVKTextureView.this.mSurface, i36, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return true;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                boolean onViewDestroyed = TVKTextureView.this.mViewCallBack.onViewDestroyed(TVKTextureView.this.mSurface);
                if (onViewDestroyed) {
                    TVKTextureView.this.mSurface = null;
                    TVKTextureView.this.mSurfaceTexture = null;
                }
                return onViewDestroyed;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i36, int i16) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                TVKTextureView.this.mViewCallBack.onViewChanged(TVKTextureView.this.mSurface, i36, i16);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (TVKTextureView.this.mViewCallBack == null) {
                    return;
                }
                if (TVKTextureView.this.mSurfaceTexture != surfaceTexture) {
                    TVKTextureView.this.mSurface = new Surface(surfaceTexture);
                    TVKTextureView.this.mSurfaceTexture = surfaceTexture;
                }
                TVKTextureView.this.mViewCallBack.onViewChanged(TVKTextureView.this.mSurface, TVKTextureView.this.getWidth(), TVKTextureView.this.getHeight());
            }
        };
        initView();
        this.mInstanceTag = TAG + new Random().nextInt();
    }
}
