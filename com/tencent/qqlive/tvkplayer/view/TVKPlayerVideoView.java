package com.tencent.qqlive.tvkplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView;
import com.tencent.qqlive.tvkplayer.view.subview.TVKAttachableView;
import com.tencent.qqlive.tvkplayer.view.subview.TVKTextureView;
import com.tencent.qqlive.tvkplayer.view.subview.TVKViewFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes23.dex */
public class TVKPlayerVideoView extends FrameLayout implements ITVKVideoViewBase, ITVKRenderSurface, ITVKVideoViewPrivate {
    private static final String TAG = "TVKPlayer[TVKPlayerVideoView]";
    private int mAlignmentType;
    private final Context mContext;
    private FrameLayout.LayoutParams mDarkLogoAttachableViewParams;
    private final AtomicBoolean mDetachingView;
    private ITVKDisplayView mDisPlayView;
    private final ITVKDisplayView.IDisplayViewCallback mDisplayViewCallback;
    private FrameLayout.LayoutParams mDisplayViewParams;
    private TVKAttachableView mInnerDarkLogoView;
    private TVKAttachableView mInnerLogoView;
    private TVKAttachableView mInnerSubtitleView;
    private final String mInstanceTag;
    private boolean mIsSupportTextureView;
    private boolean mIsZOderMediaOverlay;
    private boolean mIsZOrderOnTop;
    private FrameLayout.LayoutParams mLogoAttachableViewParams;
    private ViewGroup mLogoView;
    private int mSerialNO;
    private SurfaceTexture mStoredSurfaceTexture;
    private FrameLayout.LayoutParams mSubtitleAttachableViewParams;
    private ViewGroup mSubtitleView;
    private Surface mSurface;
    private int mVideoHeight;
    private final List<ITVKRenderSurface.IVideoSurfaceCallback> mVideoSurfaceCallbackList;
    private final List<ITVKVideoViewBase.IVideoViewCallback> mVideoViewCallbackList;
    private int mVideoWidth;
    private final List<ITVKVideoViewPrivate.IViewEventListener> mViewEventListenerList;
    private int mViewHeight;
    private boolean mViewIsReady;
    private int mViewWidth;

    public TVKPlayerVideoView(Context context, boolean z16) {
        super(context.getApplicationContext());
        this.mSerialNO = 0;
        this.mIsZOrderOnTop = false;
        this.mIsZOderMediaOverlay = false;
        this.mIsSupportTextureView = false;
        this.mSubtitleView = null;
        this.mLogoView = null;
        this.mInnerLogoView = null;
        this.mInnerSubtitleView = null;
        this.mInnerDarkLogoView = null;
        this.mAlignmentType = 0;
        this.mVideoViewCallbackList = new CopyOnWriteArrayList();
        this.mVideoSurfaceCallbackList = new CopyOnWriteArrayList();
        this.mViewEventListenerList = new ArrayList();
        this.mViewIsReady = false;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mDisPlayView = null;
        this.mDisplayViewCallback = new ITVKDisplayView.IDisplayViewCallback() { // from class: com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView.1
            @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView.IDisplayViewCallback
            public void onViewChanged(Surface surface, int i3, int i16) {
                if (TVKPlayerVideoView.this.mViewWidth != i3 || TVKPlayerVideoView.this.mViewHeight != i16 || surface != TVKPlayerVideoView.this.mSurface) {
                    TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewChanged, NO: " + TVKPlayerVideoView.this.mSerialNO + ", w: " + i3 + ", h: " + i16 + ", pw: " + TVKPlayerVideoView.this.getWidth() + ", ph: " + TVKPlayerVideoView.this.getHeight());
                    TVKPlayerVideoView.this.mViewWidth = i3;
                    TVKPlayerVideoView.this.mViewHeight = i16;
                    Surface surface2 = TVKPlayerVideoView.this.mSurface;
                    TVKPlayerVideoView.this.mSurface = surface;
                    if (!TVKPlayerVideoView.this.mDetachingView.get()) {
                        TVKPlayerVideoView.this.callOnSurfaceChanged(surface, surface2);
                    } else {
                        TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewChanged mDetachingView=true");
                    }
                }
            }

            @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView.IDisplayViewCallback
            public void onViewCreated(Surface surface, int i3, int i16) {
                TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewCreated, is textureView: " + TVKPlayerVideoView.this.mIsSupportTextureView + " NO: " + TVKPlayerVideoView.this.mSerialNO + ", w: " + i3 + ", h: " + i16 + ", pw: " + TVKPlayerVideoView.this.getWidth() + ", ph: " + TVKPlayerVideoView.this.getHeight());
                TVKPlayerVideoView.this.mSurface = surface;
                TVKPlayerVideoView.this.mViewWidth = i3;
                TVKPlayerVideoView.this.mViewHeight = i16;
                if (!TVKPlayerVideoView.this.mDetachingView.get()) {
                    TVKPlayerVideoView.this.mViewIsReady = true;
                    TVKPlayerVideoView.this.callOnSurfaceCreate(surface);
                } else {
                    TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewCreated mDetachingView=true");
                }
            }

            @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView.IDisplayViewCallback
            public boolean onViewDestroyed(Surface surface) {
                TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewDestroyed, NO: " + TVKPlayerVideoView.this.mSerialNO);
                if (!TVKPlayerVideoView.this.mDetachingView.get() || !(TVKPlayerVideoView.this.mDisPlayView instanceof TVKTextureView)) {
                    TVKPlayerVideoView.this.mViewIsReady = false;
                    TVKPlayerVideoView.this.callOnSurfaceDestroyed(surface);
                    return true;
                }
                TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewDestroyed mDetachingView=true");
                TVKPlayerVideoView tVKPlayerVideoView = TVKPlayerVideoView.this;
                tVKPlayerVideoView.mStoredSurfaceTexture = ((TVKTextureView) tVKPlayerVideoView.mDisPlayView).getSurfaceTexture();
                return false;
            }
        };
        this.mContext = context.getApplicationContext();
        this.mIsSupportTextureView = z16;
        this.mDetachingView = new AtomicBoolean(false);
        this.mSerialNO = new Random().nextInt();
        initViewAfterV4();
        this.mInstanceTag = TAG + this.mSerialNO + "_" + this.mDisPlayView;
    }

    private void addInnerViewToViewGroup(TVKAttachableView tVKAttachableView, ViewGroup viewGroup) {
        if (tVKAttachableView == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) tVKAttachableView.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(tVKAttachableView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        viewGroup.addView(tVKAttachableView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSurfaceChanged(Surface surface, Surface surface2) {
        Iterator<ITVKVideoViewBase.IVideoViewCallback> it = this.mVideoViewCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceChanged(this, surface, this.mViewWidth, this.mViewHeight);
        }
        if (surface != surface2) {
            Iterator<ITVKRenderSurface.IVideoSurfaceCallback> it5 = this.mVideoSurfaceCallbackList.iterator();
            while (it5.hasNext()) {
                it5.next().onSurfaceChanged(this, surface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSurfaceCreate(Surface surface) {
        Iterator<ITVKVideoViewBase.IVideoViewCallback> it = this.mVideoViewCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceCreated(this, surface);
        }
        Iterator<ITVKRenderSurface.IVideoSurfaceCallback> it5 = this.mVideoSurfaceCallbackList.iterator();
        while (it5.hasNext()) {
            it5.next().onSurfaceCreated(this, surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSurfaceDestroyed(Surface surface) {
        Iterator<ITVKVideoViewBase.IVideoViewCallback> it = this.mVideoViewCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceDestroyed(this, surface);
        }
        Iterator<ITVKRenderSurface.IVideoSurfaceCallback> it5 = this.mVideoSurfaceCallbackList.iterator();
        while (it5.hasNext()) {
            it5.next().onSurfaceDestroyed(this, surface);
        }
    }

    private int convertAlignmentToGravity(int i3) {
        if (i3 == 0) {
            return 17;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        TVKLogUtil.w(this.mInstanceTag, "[convertAlignmentToGravity] Illegal alignment type: " + i3 + ", set type center instead.");
                        return 17;
                    }
                    return 21;
                }
                return 19;
            }
            return 81;
        }
        return 49;
    }

    private void initViewAfterV4() {
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mDisplayViewParams = layoutParams2;
        layoutParams2.gravity = convertAlignmentToGravity(this.mAlignmentType);
        setLayoutParams(layoutParams);
        ITVKDisplayView createDisplayView = TVKViewFactory.createDisplayView(this.mContext, this.mIsSupportTextureView, this.mIsZOrderOnTop, this.mIsZOderMediaOverlay);
        this.mDisPlayView = createDisplayView;
        createDisplayView.setViewCallBack(this.mDisplayViewCallback);
        this.mDisPlayView.setOpaqueInfo(true);
        addView((View) this.mDisPlayView, this.mDisplayViewParams);
        this.mInnerLogoView = TVKViewFactory.createAttachableView(this.mContext);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.mLogoAttachableViewParams = layoutParams3;
        layoutParams3.gravity = this.mDisplayViewParams.gravity;
        addView(this.mInnerLogoView, layoutParams3);
        this.mInnerSubtitleView = TVKViewFactory.createAttachableView(this.mContext);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        this.mSubtitleAttachableViewParams = layoutParams4;
        layoutParams4.gravity = this.mDisplayViewParams.gravity;
        addView(this.mInnerSubtitleView, layoutParams4);
        this.mInnerDarkLogoView = TVKViewFactory.createAttachableView(this.mContext);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -1);
        this.mDarkLogoAttachableViewParams = layoutParams5;
        layoutParams5.gravity = this.mDisplayViewParams.gravity;
        addView(this.mInnerDarkLogoView, layoutParams5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAlignment$0() {
        ((View) this.mDisPlayView).setLayoutParams(this.mDisplayViewParams);
        this.mInnerLogoView.setLayoutParams(this.mLogoAttachableViewParams);
        this.mInnerSubtitleView.setLayoutParams(this.mSubtitleAttachableViewParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLogoView$2(ViewGroup viewGroup) {
        addInnerViewToViewGroup(this.mInnerLogoView, viewGroup);
        addInnerViewToViewGroup(this.mInnerDarkLogoView, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSubtitleView$1(ViewGroup viewGroup) {
        TVKAttachableView tVKAttachableView = this.mInnerSubtitleView;
        if (tVKAttachableView == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) tVKAttachableView.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.mInnerSubtitleView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        viewGroup.addView(this.mInnerSubtitleView, layoutParams);
    }

    private void printViewRecursively(View view, int i3) {
        if (view == null) {
            TVKLogUtil.i(this.mInstanceTag, "printViewRecursively, childViewName is null, level:" + i3);
            return;
        }
        TVKLogUtil.i(this.mInstanceTag, "printViewRecursively, childViewName:" + view + ", level:" + i3 + ", viewWidth:" + view.getWidth() + ", viewHeight:" + view.getHeight());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i16 = i3 + 1;
            for (int i17 = 0; i17 < childCount; i17++) {
                printViewRecursively(viewGroup.getChildAt(i17), i16);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void addVideoSurfaceCallBack(ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        if (iVideoSurfaceCallback != null && !this.mVideoSurfaceCallbackList.contains(iVideoSurfaceCallback)) {
            this.mVideoSurfaceCallbackList.add(iVideoSurfaceCallback);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public void addViewCallback(ITVKVideoViewBase.IVideoViewCallback iVideoViewCallback) {
        if (iVideoViewCallback != null && !this.mVideoViewCallbackList.contains(iVideoViewCallback)) {
            this.mVideoViewCallbackList.add(iVideoViewCallback);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void addViewEventListener(ITVKVideoViewPrivate.IViewEventListener iViewEventListener) {
        this.mViewEventListenerList.add(iViewEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public View getCurrentDisplayView() {
        return (View) this.mDisPlayView;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public int getFixedHeight() {
        return this.mVideoHeight;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public int getFixedWidth() {
        return this.mVideoWidth;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public ViewGroup getInnerDarkLogoView() {
        return this.mInnerDarkLogoView;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public ViewGroup getInnerLogoView() {
        return this.mInnerLogoView;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public ViewGroup getInnerSubtitleView() {
        return this.mInnerSubtitleView;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public ViewGroup getLogoView() {
        return this.mLogoView;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public Surface getRenderSurface() {
        if (this.mViewIsReady) {
            return this.mSurface;
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public ViewGroup getSubtitleView() {
        return this.mSubtitleView;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public boolean isSurfaceReady() {
        return this.mViewIsReady;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void printView() {
        printViewRecursively(this, 0);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public void releaseSurfaceTexture() {
        TVKLogUtil.i(this.mInstanceTag, "api call releaseSurfaceTexture");
        ITVKDisplayView iTVKDisplayView = this.mDisPlayView;
        if (iTVKDisplayView != null && (iTVKDisplayView instanceof TVKTextureView) && this.mStoredSurfaceTexture != null) {
            try {
                TVKLogUtil.i(this.mInstanceTag, "release SurfaceTexture");
                this.mStoredSurfaceTexture.release();
            } catch (Exception e16) {
                TVKLogUtil.e(this.mInstanceTag, e16);
            }
        }
        Iterator<ITVKVideoViewPrivate.IViewEventListener> it = this.mViewEventListenerList.iterator();
        while (it.hasNext()) {
            it.next().onReleaseSurfaceTexture();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void removeVideoSurfaceCallBack(ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        this.mVideoSurfaceCallbackList.remove(iVideoSurfaceCallback);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public void removeViewCallback(ITVKVideoViewBase.IVideoViewCallback iVideoViewCallback) {
        this.mVideoViewCallbackList.remove(iVideoViewCallback);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void removeViewEventListener(ITVKVideoViewPrivate.IViewEventListener iViewEventListener) {
        this.mViewEventListenerList.remove(iViewEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void reset() {
        TVKLogUtil.i(this.mInstanceTag, "reset , NO: " + this.mSerialNO + ", removeAllViews");
        ViewGroup viewGroup = this.mSubtitleView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup2 = this.mLogoView;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
        this.mDisPlayView.setDegree(0);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public boolean resumeSurfaceTexture() {
        SurfaceTexture surfaceTexture;
        TVKLogUtil.i(this.mInstanceTag, "attach to new parent view");
        ITVKDisplayView iTVKDisplayView = this.mDisPlayView;
        if (iTVKDisplayView != null && (iTVKDisplayView instanceof TVKTextureView) && (surfaceTexture = this.mStoredSurfaceTexture) != null) {
            ((TVKTextureView) iTVKDisplayView).setSurfaceTexture(surfaceTexture);
            this.mStoredSurfaceTexture = null;
        }
        this.mDetachingView.set(false);
        Iterator<ITVKVideoViewPrivate.IViewEventListener> it = this.mViewEventListenerList.iterator();
        while (it.hasNext()) {
            it.next().onResumeSurfaceTexture();
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void setAlignment(int i3) {
        if (this.mAlignmentType == i3) {
            return;
        }
        int convertAlignmentToGravity = convertAlignmentToGravity(i3);
        this.mDisplayViewParams.gravity = convertAlignmentToGravity;
        this.mLogoAttachableViewParams.gravity = convertAlignmentToGravity;
        this.mSubtitleAttachableViewParams.gravity = convertAlignmentToGravity;
        this.mAlignmentType = i3;
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.c
            @Override // java.lang.Runnable
            public final void run() {
                TVKPlayerVideoView.this.lambda$setAlignment$0();
            }
        });
    }

    public boolean setDegree(int i3) {
        boolean degree = this.mDisPlayView.setDegree(i3);
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((View) TVKPlayerVideoView.this.mDisPlayView).requestLayout();
                } catch (Exception unused) {
                    TVKLogUtil.i(TVKPlayerVideoView.TAG, "setDegree error");
                }
            }
        });
        return degree;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void setDisplayOffset(float f16, float f17) {
        this.mDisPlayView.setOffset(f16, f17);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void setDisplayScale(float f16) {
        this.mDisPlayView.setScale(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void setFixedSize(int i3, int i16) {
        TVKLogUtil.i(this.mInstanceTag, "setFixedSize, videoW: " + i3 + ", videoH: " + i16 + ", NO: " + this.mSerialNO);
        this.mVideoWidth = i3;
        this.mVideoHeight = i16;
        this.mDisPlayView.setFixedSize(i3, i16);
        this.mInnerLogoView.setFixedSize(i3, i16);
        this.mInnerSubtitleView.setFixedSize(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public void setLogoView(final ViewGroup viewGroup) {
        this.mLogoView = viewGroup;
        if (viewGroup == null) {
            return;
        }
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.a
            @Override // java.lang.Runnable
            public final void run() {
                TVKPlayerVideoView.this.lambda$setLogoView$2(viewGroup);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public void setSubtitleView(final ViewGroup viewGroup) {
        this.mSubtitleView = viewGroup;
        if (viewGroup == null) {
            return;
        }
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKPlayerVideoView.this.lambda$setSubtitleView$1(viewGroup);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public boolean setViewSecure(boolean z16) {
        return this.mDisPlayView.setViewSecure(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void setXYaxis(int i3) {
        this.mDisPlayView.setXYaxis(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase
    public boolean storeSurfaceTexture() {
        if (this.mDisPlayView == null) {
            return false;
        }
        if (!this.mViewIsReady) {
            TVKLogUtil.i(this.mInstanceTag, "fail to detach from previous parent view: view is not ready");
            return false;
        }
        if (this.mDetachingView.get()) {
            TVKLogUtil.i(this.mInstanceTag, "fail to detach from previous parent view: already detached");
            return true;
        }
        if (!(this.mDisPlayView instanceof TVKTextureView)) {
            TVKLogUtil.i(this.mInstanceTag, "fail to detach from previous parent view: not a TextureView");
            return false;
        }
        TVKLogUtil.i(this.mInstanceTag, "successfully detach from previous parent view");
        this.mDetachingView.set(true);
        Iterator<ITVKVideoViewPrivate.IViewEventListener> it = this.mViewEventListenerList.iterator();
        while (it.hasNext()) {
            it.next().onStoreSurfaceTexture();
        }
        return true;
    }

    @Override // android.view.View
    @NonNull
    public String toString() {
        return this.mInstanceTag;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate
    public void setDisplayScale(float f16, float f17, float f18) {
        this.mDisPlayView.setScale(f16, f17, f18);
    }

    public TVKPlayerVideoView(Context context, boolean z16, boolean z17, boolean z18) {
        super(context.getApplicationContext());
        this.mSerialNO = 0;
        this.mIsZOrderOnTop = false;
        this.mIsZOderMediaOverlay = false;
        this.mIsSupportTextureView = false;
        this.mSubtitleView = null;
        this.mLogoView = null;
        this.mInnerLogoView = null;
        this.mInnerSubtitleView = null;
        this.mInnerDarkLogoView = null;
        this.mAlignmentType = 0;
        this.mVideoViewCallbackList = new CopyOnWriteArrayList();
        this.mVideoSurfaceCallbackList = new CopyOnWriteArrayList();
        this.mViewEventListenerList = new ArrayList();
        this.mViewIsReady = false;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mDisPlayView = null;
        this.mDisplayViewCallback = new ITVKDisplayView.IDisplayViewCallback() { // from class: com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView.1
            @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView.IDisplayViewCallback
            public void onViewChanged(Surface surface, int i3, int i16) {
                if (TVKPlayerVideoView.this.mViewWidth != i3 || TVKPlayerVideoView.this.mViewHeight != i16 || surface != TVKPlayerVideoView.this.mSurface) {
                    TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewChanged, NO: " + TVKPlayerVideoView.this.mSerialNO + ", w: " + i3 + ", h: " + i16 + ", pw: " + TVKPlayerVideoView.this.getWidth() + ", ph: " + TVKPlayerVideoView.this.getHeight());
                    TVKPlayerVideoView.this.mViewWidth = i3;
                    TVKPlayerVideoView.this.mViewHeight = i16;
                    Surface surface2 = TVKPlayerVideoView.this.mSurface;
                    TVKPlayerVideoView.this.mSurface = surface;
                    if (!TVKPlayerVideoView.this.mDetachingView.get()) {
                        TVKPlayerVideoView.this.callOnSurfaceChanged(surface, surface2);
                    } else {
                        TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewChanged mDetachingView=true");
                    }
                }
            }

            @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView.IDisplayViewCallback
            public void onViewCreated(Surface surface, int i3, int i16) {
                TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewCreated, is textureView: " + TVKPlayerVideoView.this.mIsSupportTextureView + " NO: " + TVKPlayerVideoView.this.mSerialNO + ", w: " + i3 + ", h: " + i16 + ", pw: " + TVKPlayerVideoView.this.getWidth() + ", ph: " + TVKPlayerVideoView.this.getHeight());
                TVKPlayerVideoView.this.mSurface = surface;
                TVKPlayerVideoView.this.mViewWidth = i3;
                TVKPlayerVideoView.this.mViewHeight = i16;
                if (!TVKPlayerVideoView.this.mDetachingView.get()) {
                    TVKPlayerVideoView.this.mViewIsReady = true;
                    TVKPlayerVideoView.this.callOnSurfaceCreate(surface);
                } else {
                    TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewCreated mDetachingView=true");
                }
            }

            @Override // com.tencent.qqlive.tvkplayer.view.subview.ITVKDisplayView.IDisplayViewCallback
            public boolean onViewDestroyed(Surface surface) {
                TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewDestroyed, NO: " + TVKPlayerVideoView.this.mSerialNO);
                if (!TVKPlayerVideoView.this.mDetachingView.get() || !(TVKPlayerVideoView.this.mDisPlayView instanceof TVKTextureView)) {
                    TVKPlayerVideoView.this.mViewIsReady = false;
                    TVKPlayerVideoView.this.callOnSurfaceDestroyed(surface);
                    return true;
                }
                TVKLogUtil.i(TVKPlayerVideoView.this.mInstanceTag, "onViewDestroyed mDetachingView=true");
                TVKPlayerVideoView tVKPlayerVideoView = TVKPlayerVideoView.this;
                tVKPlayerVideoView.mStoredSurfaceTexture = ((TVKTextureView) tVKPlayerVideoView.mDisPlayView).getSurfaceTexture();
                return false;
            }
        };
        this.mContext = context.getApplicationContext();
        this.mIsSupportTextureView = z16;
        this.mIsZOrderOnTop = z17;
        this.mIsZOderMediaOverlay = z18;
        this.mDetachingView = new AtomicBoolean(false);
        this.mSerialNO = new Random().nextInt();
        initViewAfterV4();
        this.mInstanceTag = TAG + this.mSerialNO + "_" + this.mDisPlayView;
    }
}
