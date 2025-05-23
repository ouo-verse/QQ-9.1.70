package com.tencent.superplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.report.SPReportEvent;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.utils.a;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerViewBase;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class SPlayerVideoView extends FrameLayout implements ISPlayerVideoView {
    private static AtomicInteger sVideoViewIdCreater = new AtomicInteger(1000);
    private ISPlayerViewBase.ViewCreateCallBack mBlockCallback;
    private AtomicBoolean mChangingSurfaceObject;
    private Context mContext;
    private TextView mDebugView;
    private boolean mDebugViewEnable;
    private AtomicBoolean mDetachingView;
    private ISPlayerViewBase mDisPlayView;
    private int mHeight;
    private boolean mIsSurfaceReady;
    private boolean mIsUseTextureView;
    private SurfaceObject mStoredSurfaceObject;
    private SurfaceObject mSurfaceObject;
    private String mTAG;
    private List<ISPlayerVideoView.IVideoViewCallBack> mVideoViewCallBackList;
    private int mVideoViewId;
    private ISPlayerViewBase.ViewCreateCallBack mViewCallBack;
    private int mWidth;

    /* loaded from: classes26.dex */
    public class SurfaceObject {
        Surface surface;
        SurfaceTexture surfaceTexture;

        public SurfaceObject() {
        }
    }

    public SPlayerVideoView(Context context, boolean z16) {
        super(context.getApplicationContext());
        this.mDetachingView = new AtomicBoolean(false);
        this.mChangingSurfaceObject = new AtomicBoolean(false);
        this.mSurfaceObject = new SurfaceObject();
        this.mIsSurfaceReady = false;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDisPlayView = null;
        this.mDebugViewEnable = false;
        this.mDebugView = null;
        this.mBlockCallback = new ISPlayerViewBase.ViewCreateCallBack() { // from class: com.tencent.superplayer.view.SPlayerVideoView.1
            @Override // com.tencent.superplayer.view.ISPlayerViewBase.ViewCreateCallBack
            public void onViewChanged(Object obj, int i3, int i16) {
                if (SPlayerVideoView.this.mWidth != i3 || SPlayerVideoView.this.mHeight != i16) {
                    LogUtil.i(SPlayerVideoView.this.mTAG, "blockCallback, onViewChanged, w: " + i3 + ", h: " + i16 + ", pw: " + SPlayerVideoView.this.getWidth() + ", ph: " + SPlayerVideoView.this.getHeight());
                    SPlayerVideoView.this.mWidth = i3;
                    SPlayerVideoView.this.mHeight = i16;
                    SPlayerVideoView.this.initSurfaceObject(obj);
                }
            }

            @Override // com.tencent.superplayer.view.ISPlayerViewBase.ViewCreateCallBack
            public void onViewCreated(Object obj, int i3, int i16) {
                LogUtil.i(SPlayerVideoView.this.mTAG, "blockCallback , onViewCreated, is textrueview: " + SPlayerVideoView.this.mIsUseTextureView + ", w: " + i3 + ", h: " + i16 + ", pw: " + SPlayerVideoView.this.getWidth() + ", ph: " + SPlayerVideoView.this.getHeight());
                SPlayerVideoView.this.initSurfaceObject(obj);
            }

            @Override // com.tencent.superplayer.view.ISPlayerViewBase.ViewCreateCallBack
            public boolean onViewDestroyed(Object obj) {
                LogUtil.i(SPlayerVideoView.this.mTAG, "blockCallback, surfaceDestroyed");
                if (SPlayerVideoView.this.mDisPlayView instanceof SPlayerTextureView) {
                    SPlayerVideoView sPlayerVideoView = SPlayerVideoView.this;
                    sPlayerVideoView.mStoredSurfaceObject = new SurfaceObject();
                    SPlayerVideoView.this.mStoredSurfaceObject.surfaceTexture = ((SPlayerTextureView) SPlayerVideoView.this.mDisPlayView).getSurfaceTexture();
                    SPlayerVideoView.this.mStoredSurfaceObject.surface = SPlayerVideoView.this.mSurfaceObject.surface;
                    return false;
                }
                return false;
            }
        };
        this.mViewCallBack = new ISPlayerViewBase.ViewCreateCallBack() { // from class: com.tencent.superplayer.view.SPlayerVideoView.2
            @Override // com.tencent.superplayer.view.ISPlayerViewBase.ViewCreateCallBack
            public void onViewChanged(Object obj, int i3, int i16) {
                if (SPlayerVideoView.this.mWidth != i3 || SPlayerVideoView.this.mHeight != i16) {
                    LogUtil.i(SPlayerVideoView.this.mTAG, "onViewChanged, NO: , w: " + i3 + ", h: " + i16 + ", pw: " + SPlayerVideoView.this.getWidth() + ", ph: " + SPlayerVideoView.this.getHeight());
                    SPlayerVideoView.this.mWidth = i3;
                    SPlayerVideoView.this.mHeight = i16;
                    SPlayerVideoView.this.initSurfaceObject(obj);
                    SPlayerVideoView.this.callOnSurfaceChanged(obj, i3, i16);
                }
            }

            @Override // com.tencent.superplayer.view.ISPlayerViewBase.ViewCreateCallBack
            public void onViewCreated(Object obj, int i3, int i16) {
                SPlayerVideoView.this.mIsSurfaceReady = true;
                LogUtil.i(SPlayerVideoView.this.mTAG, "onViewCreated, is textrueview: " + SPlayerVideoView.this.mIsUseTextureView + ", w: " + i3 + ", h: " + i16 + ", pw: " + SPlayerVideoView.this.getWidth() + ", ph: " + SPlayerVideoView.this.getHeight());
                SPlayerVideoView.this.initSurfaceObject(obj);
                SPlayerVideoView.this.callOnSurfaceCreate(obj);
            }

            @Override // com.tencent.superplayer.view.ISPlayerViewBase.ViewCreateCallBack
            public boolean onViewDestroyed(Object obj) {
                LogUtil.i(SPlayerVideoView.this.mTAG, "surfaceDestroyed");
                SPlayerVideoView.this.mIsSurfaceReady = false;
                SPlayerVideoView.this.mStoredSurfaceObject = null;
                SPlayerVideoView.this.callOnSurfaceDestroy(obj);
                return true;
            }
        };
        this.mContext = context.getApplicationContext();
        this.mIsUseTextureView = z16;
        this.mVideoViewId = sVideoViewIdCreater.getAndAdd(1);
        this.mTAG = "SPlayerVideoView-" + this.mVideoViewId;
        initViewAfterV4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSurfaceChanged(Object obj, int i3, int i16) {
        List<ISPlayerVideoView.IVideoViewCallBack> list = this.mVideoViewCallBackList;
        if (list != null) {
            for (ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack : list) {
                if (iVideoViewCallBack != null) {
                    iVideoViewCallBack.onSurfaceChanged(obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSurfaceCreate(Object obj) {
        List<ISPlayerVideoView.IVideoViewCallBack> list = this.mVideoViewCallBackList;
        if (list != null) {
            for (ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack : list) {
                if (iVideoViewCallBack != null) {
                    iVideoViewCallBack.onSurfaceCreated(obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSurfaceDestroy(Object obj) {
        List<ISPlayerVideoView.IVideoViewCallBack> list = this.mVideoViewCallBackList;
        if (list != null) {
            for (ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack : list) {
                if (iVideoViewCallBack != null) {
                    iVideoViewCallBack.onSurfaceDestroy(obj);
                }
            }
        }
    }

    private void initDebugView() {
        this.mDebugView.setBackgroundColor(1291845632);
        this.mDebugView.setTextSize(11.0f);
        this.mDebugView.setTextColor(-637534209);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 19;
        int width = getRootView().getWidth();
        if (getWidth() > width) {
            layoutParams.leftMargin = (getWidth() - width) / 2;
        }
        addView(this.mDebugView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSurfaceObject(Object obj) {
        if (this.mIsUseTextureView) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
            SurfaceObject surfaceObject = this.mSurfaceObject;
            if (surfaceObject.surfaceTexture == surfaceTexture) {
                return;
            }
            surfaceObject.surfaceTexture = surfaceTexture;
            surfaceObject.surface = new Surface(surfaceTexture);
            LogUtil.d(this.mTAG, "\u521b\u5efaSurface\u5b9e\u4f8b\uff0cSurface=" + this.mSurfaceObject.surface);
            return;
        }
        SurfaceObject surfaceObject2 = this.mSurfaceObject;
        surfaceObject2.surfaceTexture = null;
        surfaceObject2.surface = ((SurfaceHolder) obj).getSurface();
    }

    private void initViewAfterV4() {
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        setLayoutParams(layoutParams);
        ISPlayerViewBase createPlayView = SPlayerViewFactory.createPlayView(this.mContext, this.mIsUseTextureView);
        this.mDisPlayView = createPlayView;
        createPlayView.setVideoViewTagId(String.valueOf(this.mVideoViewId));
        this.mDisPlayView.setViewCallBack(this.mViewCallBack);
        addView((View) this.mDisPlayView, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupDebugView(ISuperPlayer iSuperPlayer, SPReportEvent sPReportEvent, String str) {
        if (SuperPlayerSDKMgr.isShowPlayerDebugView()) {
            if (this.mDebugView == null) {
                this.mDebugView = new TextView(this.mContext);
                initDebugView();
            }
            this.mDebugView.setVisibility(0);
            this.mDebugView.setText(a.b(iSuperPlayer, sPReportEvent, str));
            return;
        }
        TextView textView = this.mDebugView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void addViewCallBack(ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack) {
        if (iVideoViewCallBack == null) {
            return;
        }
        if (this.mVideoViewCallBackList == null) {
            this.mVideoViewCallBackList = new CopyOnWriteArrayList();
        }
        if (!this.mVideoViewCallBackList.contains(iVideoViewCallBack)) {
            this.mVideoViewCallBackList.add(iVideoViewCallBack);
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void changeSurfaceObject(SurfaceObject surfaceObject) {
        this.mChangingSurfaceObject.set(true);
        this.mSurfaceObject = surfaceObject;
        disableViewCallback();
        ((SPlayerTextureView) this.mDisPlayView).setSurfaceTexture(surfaceObject.surfaceTexture);
        this.mIsSurfaceReady = true;
        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.superplayer.view.SPlayerVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                SPlayerVideoView sPlayerVideoView = SPlayerVideoView.this;
                sPlayerVideoView.removeView((View) sPlayerVideoView.mDisPlayView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                SPlayerVideoView sPlayerVideoView2 = SPlayerVideoView.this;
                sPlayerVideoView2.addView((View) sPlayerVideoView2.mDisPlayView, layoutParams);
                SPlayerVideoView.this.enableViewCallback();
            }
        });
        this.mChangingSurfaceObject.set(false);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean disableViewCallback() {
        if (this.mDisPlayView == null) {
            return false;
        }
        if (!this.mIsSurfaceReady && !this.mChangingSurfaceObject.get()) {
            LogUtil.i(this.mTAG, "detach from old parent view , but view not ready");
            return false;
        }
        if (this.mDetachingView.get()) {
            LogUtil.i(this.mTAG, "detach from old parent view , but is detaching");
            return true;
        }
        if (!(this.mDisPlayView instanceof SPlayerTextureView)) {
            LogUtil.i(this.mTAG, "detach from old parent view , but not texture view");
            return false;
        }
        LogUtil.i(this.mTAG, "detach from old parent view");
        this.mDetachingView.set(true);
        this.mDisPlayView.setViewCallBack(this.mBlockCallback);
        return true;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean enableViewCallback() {
        LogUtil.i(this.mTAG, "attach to new parent view");
        ISPlayerViewBase iSPlayerViewBase = this.mDisPlayView;
        if (iSPlayerViewBase != null && (iSPlayerViewBase instanceof SPlayerTextureView) && this.mStoredSurfaceObject != null) {
            SurfaceTexture surfaceTexture = ((SPlayerTextureView) iSPlayerViewBase).getSurfaceTexture();
            SurfaceTexture surfaceTexture2 = this.mStoredSurfaceObject.surfaceTexture;
            if (surfaceTexture != surfaceTexture2) {
                ((SPlayerTextureView) this.mDisPlayView).setSurfaceTexture(surfaceTexture2);
            }
        }
        ISPlayerViewBase iSPlayerViewBase2 = this.mDisPlayView;
        if (iSPlayerViewBase2 != null) {
            iSPlayerViewBase2.setViewCallBack(this.mViewCallBack);
        }
        this.mDetachingView.set(false);
        return true;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public String getLogTag() {
        return "SPlayerVideoView-" + this.mVideoViewId + "|SPlayerTextureView-" + this.mVideoViewId;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public View getRenderView() {
        return (View) this.mDisPlayView;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public int getRenderViewHeight() {
        Object obj = this.mDisPlayView;
        if (obj == null) {
            return 0;
        }
        return ((View) obj).getHeight();
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public int getRenderViewWidth() {
        Object obj = this.mDisPlayView;
        if (obj == null) {
            return 0;
        }
        return ((View) obj).getWidth();
    }

    public SurfaceObject getStoredSurfaceObject() {
        return this.mStoredSurfaceObject;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public Surface getSurface() {
        if (this.mIsSurfaceReady) {
            return this.mSurfaceObject.surface;
        }
        return null;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean isSurfaceReady() {
        return this.mIsSurfaceReady;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean isTextureView() {
        return this.mIsUseTextureView;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void removeViewCallBack(ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack) {
        List<ISPlayerVideoView.IVideoViewCallBack> list = this.mVideoViewCallBackList;
        if (list != null) {
            if (iVideoViewCallBack == null) {
                list.clear();
            } else {
                list.remove(iVideoViewCallBack);
            }
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setDegree(int i3) {
        ISPlayerViewBase iSPlayerViewBase = this.mDisPlayView;
        if (iSPlayerViewBase != null) {
            iSPlayerViewBase.setDegree(i3);
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setFixedSize(int i3, int i16) {
        LogUtil.i(this.mTAG, "setFixedSize, vW: " + i3 + ", vH: " + i16);
        if (i3 > 0 && i16 > 0) {
            this.mDisPlayView.setVideoWidthAndHeight(i3, i16);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ((View) this.mDisPlayView).requestLayout();
            } else {
                ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.superplayer.view.SPlayerVideoView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((View) SPlayerVideoView.this.mDisPlayView).requestLayout();
                    }
                });
            }
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setScaleParam(float f16) {
        this.mDisPlayView.setScaleParam(f16);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setXYaxis(int i3) {
        try {
            this.mDisPlayView.setXYaxis(i3);
            ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.superplayer.view.SPlayerVideoView.4
                @Override // java.lang.Runnable
                public void run() {
                    ((View) SPlayerVideoView.this.mDisPlayView).requestLayout();
                }
            });
        } catch (Exception e16) {
            LogUtil.e(this.mTAG, e16.getMessage());
        }
    }

    @Override // android.view.View
    public String toString() {
        return "SuperPlayerVideoInfo[" + this.mTAG + "]";
    }

    public void updateDebugInfo(final ISuperPlayer iSuperPlayer, final SPReportEvent sPReportEvent, final String str) {
        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.superplayer.view.SPlayerVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                SPlayerVideoView.this.setupDebugView(iSuperPlayer, sPReportEvent, str);
            }
        });
    }
}
