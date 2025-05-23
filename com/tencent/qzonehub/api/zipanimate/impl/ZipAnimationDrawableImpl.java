package com.tencent.qzonehub.api.zipanimate.impl;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.Lifecycle;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.zipanimate.OnAnimationListener;
import cooperation.qzone.zipanimate.OnDrawableCallBack;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;
import cooperation.qzone.zipanimate.ZipFirstFrameLoadedListener;
import cooperation.qzone.zipanimate.ZipFrameLoadedListener;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZipAnimationDrawableImpl implements IZipAnimationDrawable {
    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public Drawable getZipAnimationDrawable() {
        return new ZipAnimationDrawable();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public boolean isZipAnimationDrawable(Animatable animatable) {
        return animatable instanceof ZipAnimationDrawable;
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void release(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).release();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setAnimationRes(Drawable drawable, String str, int i3) {
        ((ZipAnimationDrawable) drawable).setAnimationRes(str, i3);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setDrawableCallback(Drawable drawable, OnDrawableCallBack onDrawableCallBack) {
        ((ZipAnimationDrawable) drawable).setDrawableCallback(onDrawableCallBack);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public Drawable getZipAnimationDrawable(String str, int i3) {
        return new ZipAnimationDrawable(str, i3);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void release(Animatable animatable) {
        if (animatable == null) {
            return;
        }
        ((ZipAnimationDrawable) animatable).release();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setZipFirstFrameLoadedListener(Drawable drawable, ZipFirstFrameLoadedListener zipFirstFrameLoadedListener) {
        if (drawable == null || !(drawable instanceof ZipAnimationDrawable)) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setZipFirstFrameLoadedListener(zipFirstFrameLoadedListener);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void bindLifeCycle(Drawable drawable, Lifecycle lifecycle) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).bindLifeCycle(lifecycle);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void clearFirstFrame(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).clearFirstFrame();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void loadAndShowFirstFrame(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).loadAndShowFirstFrame();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void preLoadFrame(Drawable drawable, int i3) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).preLoadFrame(i3);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void restartAnimation(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).restartAnimation();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setAnimationListener(Drawable drawable, OnAnimationListener onAnimationListener) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setAnimationListener(onAnimationListener);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setDrawableLoadedListener(Drawable drawable, ZipFrameLoadedListener zipFrameLoadedListener) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setDrawableLoadedListener(zipFrameLoadedListener);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setIsShowFirstFrame(Drawable drawable, boolean z16) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setIsShowFirstFrame(z16);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setOneShot(Drawable drawable, boolean z16) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setOneShot(z16);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setPreloadNum(Drawable drawable, int i3) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setPreloadNum(i3);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setRepeatAnimation(Drawable drawable, boolean z16) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setRepeatAnimation(z16);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setScale(Drawable drawable, float f16) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setScale(f16);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void setShowLastFrameWhenStop(Drawable drawable, boolean z16) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).setShowLastFrameWhenStop(z16);
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void start(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).start();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public void stop(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ((ZipAnimationDrawable) drawable).stop();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public String getAnimationResZipUrl(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return ((ZipAnimationDrawable) drawable).getAnimationResZipUrl();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public int getDuration(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        return ((ZipAnimationDrawable) drawable).getDuration();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public int getNumberOfFrames(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        return ((ZipAnimationDrawable) drawable).getNumberOfFrames();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public boolean hasDownloadComplete(Drawable drawable) {
        if (drawable == null) {
            return false;
        }
        return ((ZipAnimationDrawable) drawable).hasDownloadComplete();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public boolean isOneShot(Drawable drawable) {
        if (drawable == null) {
            return false;
        }
        return ((ZipAnimationDrawable) drawable).isOneShot();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public boolean isRunning(Drawable drawable) {
        if (drawable == null) {
            return false;
        }
        return ((ZipAnimationDrawable) drawable).isRunning();
    }

    @Override // com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable
    public boolean isZipDrawableShow(Drawable drawable) {
        if (drawable == null) {
            return false;
        }
        return ((ZipAnimationDrawable) drawable).isZipDrawableShow();
    }
}
