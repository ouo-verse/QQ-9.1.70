package com.tencent.superplayer.view;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.superplayer.view.ISPlayerViewBase;

/* loaded from: classes26.dex */
public class SPlayerSurfaceView extends SurfaceView implements ISPlayerViewBase {
    private static final String TAG = "SPlayerSurfaceView";
    private float mScale;
    private SurfaceHolder.Callback mSurfaceCallback;
    private int mType;
    private int mVideoHeight;
    private int mVideoWidth;
    private ISPlayerViewBase.ViewCreateCallBack mViewCallBack;
    private int radioHeight;
    private int radioWidth;

    public SPlayerSurfaceView(Context context) {
        super(context);
        this.mType = 0;
        this.radioWidth = 0;
        this.radioHeight = 0;
        this.mScale = 1.0f;
        this.mSurfaceCallback = new SurfaceHolder.Callback() { // from class: com.tencent.superplayer.view.SPlayerSurfaceView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
                if (SPlayerSurfaceView.this.mViewCallBack != null) {
                    SPlayerSurfaceView.this.mViewCallBack.onViewChanged(surfaceHolder, SPlayerSurfaceView.this.getWidth(), SPlayerSurfaceView.this.getHeight());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (SPlayerSurfaceView.this.mViewCallBack != null) {
                    SPlayerSurfaceView.this.mViewCallBack.onViewCreated(surfaceHolder, SPlayerSurfaceView.this.getWidth(), SPlayerSurfaceView.this.getHeight());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (SPlayerSurfaceView.this.mViewCallBack != null) {
                    SPlayerSurfaceView.this.mViewCallBack.onViewDestroyed(surfaceHolder);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.mScale = 1.0f;
        this.mType = 0;
        getHolder().setFormat(-2);
        getHolder().addCallback(this.mSurfaceCallback);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i3);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i16);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            try {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
                ((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin = 0;
                int i18 = this.mType;
                float f16 = 1.0f;
                if (i18 == 2) {
                    int i19 = this.mVideoWidth;
                    int i26 = i19 * defaultSize2;
                    int i27 = this.mVideoHeight;
                    if (i26 > defaultSize * i27) {
                        defaultSize = (i19 * defaultSize2) / i27;
                    } else if (i19 * defaultSize2 < defaultSize * i27) {
                        defaultSize2 = (i27 * defaultSize) / i19;
                    }
                } else if (i18 != 1) {
                    if (i18 == 3) {
                        int i28 = this.mVideoWidth;
                        int i29 = i28 * defaultSize2;
                        int i36 = this.mVideoHeight;
                        if (i29 > defaultSize * i36) {
                            defaultSize2 = (i36 * defaultSize) / i28;
                        } else if (i28 * defaultSize2 < defaultSize * i36) {
                            defaultSize = (defaultSize2 * i28) / i36;
                            float f17 = defaultSize2;
                            f16 = f17 / ((i28 / i36) * f17);
                        }
                    } else {
                        int i37 = this.mVideoWidth;
                        int i38 = this.radioWidth;
                        if (i38 != 0 && (i17 = this.radioHeight) != 0) {
                            i37 = (i37 * i38) / i17;
                        }
                        int i39 = i37 * defaultSize2;
                        int i46 = this.mVideoHeight;
                        if (i39 > defaultSize * i46) {
                            defaultSize2 = (i46 * defaultSize) / i37;
                        } else if (i39 < defaultSize * i46) {
                            defaultSize = i39 / i46;
                        }
                    }
                }
                float f18 = this.mScale;
                setMeasuredDimension((int) (defaultSize * f18 * f16), (int) (defaultSize2 * f18 * f16));
                return;
            } catch (Exception unused) {
                super.onMeasure(i3, i16);
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public boolean setDegree(int i3) {
        return false;
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public void setScaleParam(float f16) {
        if (f16 > 0.0f) {
            this.mType = 0;
            this.mScale = f16;
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public void setVideoWidthAndHeight(int i3, int i16) {
        this.mVideoWidth = i3;
        this.mVideoHeight = i16;
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public void setViewCallBack(ISPlayerViewBase.ViewCreateCallBack viewCreateCallBack) {
        this.mViewCallBack = viewCreateCallBack;
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public void setXYaxis(int i3) {
        this.mType = i3;
        this.mScale = 1.0f;
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public void setVideoViewTagId(String str) {
    }
}
