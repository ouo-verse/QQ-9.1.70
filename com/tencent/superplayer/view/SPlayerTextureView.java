package com.tencent.superplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerViewBase;
import com.tencent.tmediacodec.hook.THookTextureView;

/* loaded from: classes26.dex */
public class SPlayerTextureView extends THookTextureView implements ISPlayerViewBase {
    private static final String TAG = "SPlayerTextureView";
    private int mDegree;
    private float mScale;
    private String mTag;
    private TextureView.SurfaceTextureListener mTextureListener;
    private int mType;
    private int mVideoHeight;
    private int mVideoWidth;
    private ISPlayerViewBase.ViewCreateCallBack mViewCallBack;
    private int radioHeigth;
    private int radioWidth;

    public SPlayerTextureView(Context context) {
        super(context);
        this.mDegree = 0;
        this.mType = 0;
        this.mScale = 1.0f;
        this.radioWidth = 0;
        this.radioHeigth = 0;
        this.mTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.superplayer.view.SPlayerTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                LogUtil.i(SPlayerTextureView.this.mTag, "SPlayerTextureView = " + System.identityHashCode(SPlayerTextureView.this) + ", onSurfaceTextureAvailable() surface = " + surfaceTexture.toString() + " width = " + i3 + ", height=" + i16);
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewCreated(surfaceTexture, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                String str;
                String str2 = SPlayerTextureView.this.mTag;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SPlayerTextureView = ");
                sb5.append(System.identityHashCode(SPlayerTextureView.this));
                sb5.append(", onSurfaceTextureDestroyed() surface = ");
                if (surfaceTexture != null) {
                    str = surfaceTexture.toString();
                } else {
                    str = "null";
                }
                sb5.append(str);
                LogUtil.i(str2, sb5.toString());
                if (SPlayerTextureView.this.mViewCallBack != null && !SPlayerTextureView.this.mViewCallBack.onViewDestroyed(surfaceTexture)) {
                    return false;
                }
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                LogUtil.i(SPlayerTextureView.this.mTag, "SPlayerTextureView = " + System.identityHashCode(SPlayerTextureView.this) + ", onSurfaceTextureSizeChanged() surface = " + surfaceTexture.toString() + " width = " + i3 + ", height=" + i16);
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewChanged(surfaceTexture, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewChanged(surfaceTexture, SPlayerTextureView.this.getWidth(), SPlayerTextureView.this.getHeight());
                }
            }
        };
        initView();
    }

    private void initView() {
        setScaleX(1.0001f);
        setScaleY(1.0001f);
        setSurfaceTextureListener(this.mTextureListener);
        this.mTag = TAG;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        float f16;
        float f17;
        int i19;
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int defaultSize = View.getDefaultSize(getWidth(), i3);
            int defaultSize2 = View.getDefaultSize(getHeight(), i16);
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
            ((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin = 0;
            int i26 = this.mType;
            float f18 = 1.0f;
            if (i26 == 2) {
                int i27 = this.mVideoWidth;
                int i28 = i27 * defaultSize2;
                int i29 = this.mVideoHeight;
                if (i28 > defaultSize * i29) {
                    defaultSize = (i27 * defaultSize2) / i29;
                } else if (i27 * defaultSize2 < defaultSize * i29) {
                    defaultSize2 = (i29 * defaultSize) / i27;
                }
            } else if (i26 != 1) {
                if (i26 == 3) {
                    int i36 = this.mVideoWidth;
                    int i37 = i36 * defaultSize2;
                    int i38 = this.mVideoHeight;
                    if (i37 > defaultSize * i38) {
                        defaultSize2 = (i38 * defaultSize) / i36;
                    } else if (i36 * defaultSize2 < defaultSize * i38) {
                        defaultSize = (defaultSize2 * i36) / i38;
                        float f19 = defaultSize2;
                        f18 = f19 / ((i36 / i38) * f19);
                    }
                } else {
                    int i39 = this.mVideoWidth;
                    int i46 = this.radioWidth;
                    if (i46 != 0 && (i19 = this.radioHeigth) != 0) {
                        i39 = (int) ((i39 * i46) / i19);
                    }
                    int i47 = i39 * defaultSize2;
                    int i48 = this.mVideoHeight;
                    if (i47 > defaultSize * i48) {
                        i18 = (i48 * defaultSize) / i39;
                        i17 = defaultSize;
                    } else {
                        if (i47 < defaultSize * i48) {
                            i17 = i47 / i48;
                        } else {
                            i17 = defaultSize;
                        }
                        i18 = defaultSize2;
                    }
                    int i49 = this.mDegree;
                    if ((i49 == 90 || i49 == 270) && i18 > 0 && i17 > 0) {
                        if (defaultSize / i18 < defaultSize2 / i17) {
                            f16 = defaultSize;
                            f17 = i18;
                        } else {
                            f16 = defaultSize2;
                            f17 = i17;
                        }
                        f18 = f16 / f17;
                    }
                    defaultSize = i17;
                    defaultSize2 = i18;
                }
            }
            float f26 = this.mScale;
            setMeasuredDimension((int) (defaultSize * f26 * f18), (int) (defaultSize2 * f26 * f18));
            return;
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public boolean setDegree(int i3) {
        setRotation(i3);
        this.mDegree = i3;
        return true;
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public void setScaleParam(float f16) {
        if (f16 > 0.0f) {
            this.mType = 0;
            this.mScale = f16;
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerViewBase
    public void setVideoViewTagId(String str) {
        this.mTag = TAG + "-" + str;
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

    public SPlayerTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDegree = 0;
        this.mType = 0;
        this.mScale = 1.0f;
        this.radioWidth = 0;
        this.radioHeigth = 0;
        this.mTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.superplayer.view.SPlayerTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i36, int i16) {
                LogUtil.i(SPlayerTextureView.this.mTag, "SPlayerTextureView = " + System.identityHashCode(SPlayerTextureView.this) + ", onSurfaceTextureAvailable() surface = " + surfaceTexture.toString() + " width = " + i36 + ", height=" + i16);
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewCreated(surfaceTexture, i36, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                String str;
                String str2 = SPlayerTextureView.this.mTag;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SPlayerTextureView = ");
                sb5.append(System.identityHashCode(SPlayerTextureView.this));
                sb5.append(", onSurfaceTextureDestroyed() surface = ");
                if (surfaceTexture != null) {
                    str = surfaceTexture.toString();
                } else {
                    str = "null";
                }
                sb5.append(str);
                LogUtil.i(str2, sb5.toString());
                if (SPlayerTextureView.this.mViewCallBack != null && !SPlayerTextureView.this.mViewCallBack.onViewDestroyed(surfaceTexture)) {
                    return false;
                }
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i36, int i16) {
                LogUtil.i(SPlayerTextureView.this.mTag, "SPlayerTextureView = " + System.identityHashCode(SPlayerTextureView.this) + ", onSurfaceTextureSizeChanged() surface = " + surfaceTexture.toString() + " width = " + i36 + ", height=" + i16);
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewChanged(surfaceTexture, i36, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewChanged(surfaceTexture, SPlayerTextureView.this.getWidth(), SPlayerTextureView.this.getHeight());
                }
            }
        };
        initView();
    }

    public SPlayerTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDegree = 0;
        this.mType = 0;
        this.mScale = 1.0f;
        this.radioWidth = 0;
        this.radioHeigth = 0;
        this.mTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.superplayer.view.SPlayerTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i36, int i16) {
                LogUtil.i(SPlayerTextureView.this.mTag, "SPlayerTextureView = " + System.identityHashCode(SPlayerTextureView.this) + ", onSurfaceTextureAvailable() surface = " + surfaceTexture.toString() + " width = " + i36 + ", height=" + i16);
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewCreated(surfaceTexture, i36, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                String str;
                String str2 = SPlayerTextureView.this.mTag;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SPlayerTextureView = ");
                sb5.append(System.identityHashCode(SPlayerTextureView.this));
                sb5.append(", onSurfaceTextureDestroyed() surface = ");
                if (surfaceTexture != null) {
                    str = surfaceTexture.toString();
                } else {
                    str = "null";
                }
                sb5.append(str);
                LogUtil.i(str2, sb5.toString());
                if (SPlayerTextureView.this.mViewCallBack != null && !SPlayerTextureView.this.mViewCallBack.onViewDestroyed(surfaceTexture)) {
                    return false;
                }
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i36, int i16) {
                LogUtil.i(SPlayerTextureView.this.mTag, "SPlayerTextureView = " + System.identityHashCode(SPlayerTextureView.this) + ", onSurfaceTextureSizeChanged() surface = " + surfaceTexture.toString() + " width = " + i36 + ", height=" + i16);
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewChanged(surfaceTexture, i36, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (SPlayerTextureView.this.mViewCallBack != null) {
                    SPlayerTextureView.this.mViewCallBack.onViewChanged(surfaceTexture, SPlayerTextureView.this.getWidth(), SPlayerTextureView.this.getHeight());
                }
            }
        };
        initView();
    }
}
