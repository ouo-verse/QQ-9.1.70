package com.tencent.liteav.videobase.videobase;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class DisplayTarget {
    private static final String TAG = "DisplayTarget";
    private boolean mIsViewFromTXCloudVideoView;
    private Surface mSurface;
    private WeakReference<SurfaceView> mSurfaceView;
    private final a mTargetType;
    private WeakReference<TextureView> mTextureView;
    private WeakReference<TXCloudVideoView> mTxCloudVideoView;
    private final CustomHandler mUIHandler;

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videobase.videobase.DisplayTarget$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119404a;

        static {
            int[] iArr = new int[a.values().length];
            f119404a = iArr;
            try {
                iArr[a.SURFACEVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119404a[a.TEXTUREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119404a[a.SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119404a[a.TXCLOUDVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        TEXTUREVIEW,
        SURFACEVIEW,
        SURFACE,
        TXCLOUDVIEW
    }

    public DisplayTarget(DisplayTarget displayTarget) {
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = displayTarget.mTargetType;
        this.mTxCloudVideoView = displayTarget.mTxCloudVideoView;
        this.mTextureView = displayTarget.mTextureView;
        this.mSurfaceView = displayTarget.mSurfaceView;
        this.mSurface = displayTarget.mSurface;
        this.mIsViewFromTXCloudVideoView = displayTarget.mIsViewFromTXCloudVideoView;
    }

    public static DisplayTarget create(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DisplayTarget) {
            return new DisplayTarget((DisplayTarget) obj);
        }
        if (obj instanceof TXCloudVideoView) {
            return new DisplayTarget((TXCloudVideoView) obj);
        }
        if (obj instanceof TextureView) {
            return new DisplayTarget((TextureView) obj);
        }
        if (obj instanceof SurfaceView) {
            return new DisplayTarget((SurfaceView) obj);
        }
        LiteavLog.w(TAG, "object is unknown. object=".concat(String.valueOf(obj)));
        return null;
    }

    private void requestLayout(View view) {
        if (view == null) {
            return;
        }
        runOnUIThread(b.a(view));
    }

    private void runOnUIThread(Runnable runnable) {
        if (Looper.myLooper() == this.mUIHandler.getLooper()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    private void setVisibility(View view, int i3) {
        if (view == null) {
            return;
        }
        runOnUIThread(com.tencent.liteav.videobase.videobase.a.a(view, i3));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DisplayTarget displayTarget = (DisplayTarget) obj;
            if (this.mTargetType == displayTarget.mTargetType && CommonUtil.equals(getTXCloudVideoView(), displayTarget.getTXCloudVideoView()) && CommonUtil.equals(getTextureView(), displayTarget.getTextureView()) && CommonUtil.equals(getSurfaceView(), displayTarget.getSurfaceView()) && CommonUtil.equals(this.mSurface, displayTarget.mSurface)) {
                return true;
            }
        }
        return false;
    }

    public Size getSize() {
        TXCloudVideoView tXCloudVideoView;
        WeakReference<TXCloudVideoView> weakReference;
        WeakReference<TextureView> weakReference2;
        int i3;
        int i16;
        WeakReference<SurfaceView> weakReference3;
        a aVar = this.mTargetType;
        if (aVar == a.SURFACEVIEW && (weakReference3 = this.mSurfaceView) != null) {
            tXCloudVideoView = weakReference3.get();
        } else if (aVar == a.TEXTUREVIEW && (weakReference2 = this.mTextureView) != null) {
            tXCloudVideoView = weakReference2.get();
        } else if (aVar == a.TXCLOUDVIEW && (weakReference = this.mTxCloudVideoView) != null) {
            tXCloudVideoView = weakReference.get();
        } else {
            tXCloudVideoView = null;
        }
        if (tXCloudVideoView != null) {
            i3 = tXCloudVideoView.getWidth();
            i16 = tXCloudVideoView.getHeight();
        } else {
            i3 = 0;
            i16 = 0;
        }
        return new Size(i3, i16);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public SurfaceView getSurfaceView() {
        WeakReference<SurfaceView> weakReference = this.mSurfaceView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public TXCloudVideoView getTXCloudVideoView() {
        WeakReference<TXCloudVideoView> weakReference = this.mTxCloudVideoView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public TextureView getTextureView() {
        WeakReference<TextureView> weakReference = this.mTextureView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public a getType() {
        return this.mTargetType;
    }

    public void hideAll() {
        if (!this.mIsViewFromTXCloudVideoView) {
            setVisibility(getTextureView(), 8);
            setVisibility(getSurfaceView(), 8);
        }
    }

    public boolean isUseSameView(DisplayTarget displayTarget) {
        if (equals(displayTarget)) {
            return true;
        }
        if (displayTarget == null) {
            return false;
        }
        int i3 = AnonymousClass1.f119404a[this.mTargetType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && getTXCloudVideoView() == displayTarget.getTXCloudVideoView()) {
                        return true;
                    }
                    return false;
                }
                if (getSurface() == displayTarget.getSurface()) {
                    return true;
                }
                return false;
            }
            if (getTextureView() == displayTarget.getTextureView()) {
                return true;
            }
            return false;
        }
        if (getSurfaceView() == displayTarget.getSurfaceView()) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        int i3 = AnonymousClass1.f119404a[this.mTargetType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4 || getTXCloudVideoView() == null) {
                        return false;
                    }
                    return true;
                }
                if (getSurface() == null) {
                    return false;
                }
                return true;
            }
            if (getTextureView() == null) {
                return false;
            }
            return true;
        }
        if (getSurfaceView() == null) {
            return false;
        }
        return true;
    }

    public void showAll() {
        setVisibility(getTextureView(), 0);
        setVisibility(getSurfaceView(), 0);
        WeakReference<TXCloudVideoView> weakReference = this.mTxCloudVideoView;
        if (weakReference != null) {
            requestLayout(weakReference.get());
        }
        requestLayout(getTextureView());
        requestLayout(getSurfaceView());
    }

    public String toString() {
        return "DisplayTarget{mTargetType=" + this.mTargetType + ", mTXCloudVideoView=" + getTXCloudVideoView() + ", mTextureView=" + getTextureView() + ", mSurfaceView=" + getSurfaceView() + ", mSurface=" + this.mSurface + '}';
    }

    public DisplayTarget(TXCloudVideoView tXCloudVideoView) {
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        if (tXCloudVideoView == null) {
            this.mTargetType = a.TXCLOUDVIEW;
            return;
        }
        SurfaceView surfaceView = tXCloudVideoView.getSurfaceView();
        Surface surface = tXCloudVideoView.getSurface();
        TextureView textureViewSetByUser = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView);
        if (surfaceView != null) {
            this.mTargetType = a.SURFACEVIEW;
            this.mSurfaceView = new WeakReference<>(surfaceView);
        } else if (surface != null) {
            this.mTargetType = a.SURFACE;
            this.mSurface = surface;
        } else if (textureViewSetByUser != null) {
            this.mTargetType = a.TEXTUREVIEW;
            this.mTextureView = new WeakReference<>(textureViewSetByUser);
            this.mTxCloudVideoView = new WeakReference<>(tXCloudVideoView);
        } else {
            this.mTargetType = a.TXCLOUDVIEW;
            this.mTxCloudVideoView = new WeakReference<>(tXCloudVideoView);
        }
        this.mIsViewFromTXCloudVideoView = true;
    }

    public DisplayTarget(TextureView textureView) {
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = a.TEXTUREVIEW;
        this.mTextureView = new WeakReference<>(textureView);
    }

    public DisplayTarget(SurfaceView surfaceView) {
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = a.SURFACEVIEW;
        this.mSurfaceView = new WeakReference<>(surfaceView);
    }

    public DisplayTarget(Surface surface) {
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = a.SURFACE;
        this.mSurface = surface;
    }
}
