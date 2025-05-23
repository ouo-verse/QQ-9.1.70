package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class AsynLoadDrawable extends Drawable {
    public static final int STATE_LOADING = 0;
    public static final int STATE_LOAD_FAILURE = 2;
    public static final int STATE_LOAD_SUCCESS = 1;
    protected Drawable mFailureDrawable;
    protected Drawable mLoadingDrawable;
    protected int mCurState = 0;
    protected Drawable mLoadedDrawable = null;
    protected ColorFilter mColorFilter = null;
    protected int mAlpha = -1;
    protected boolean mCancelled = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public AsynLoadDrawable(Drawable drawable, Drawable drawable2) {
        this.mLoadingDrawable = drawable;
        this.mFailureDrawable = drawable2;
    }

    public void cancel() {
        this.mCancelled = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            currDrawable.draw(canvas);
        }
    }

    public Drawable getCurrDrawable() {
        int i3 = this.mCurState;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return this.mFailureDrawable;
            }
            return this.mLoadedDrawable;
        }
        return this.mLoadingDrawable;
    }

    public abstract Drawable getDefaultDrawable();

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            return currDrawable.getIntrinsicHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            return currDrawable.getIntrinsicWidth();
        }
        return 0;
    }

    public Bitmap getLoadedBitmap() {
        Drawable drawable = this.mLoadedDrawable;
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            return currDrawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            return currDrawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            return currDrawable.getOpacity();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        if (this.mCurState == 1) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.getContext().getResources(), ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDrawableBitmap(this.mLoadedDrawable));
            this.mLoadedDrawable = bitmapDrawable;
            bitmapDrawable.setBounds(rect);
            int i3 = this.mAlpha;
            if (i3 != -1) {
                this.mLoadedDrawable.setAlpha(i3);
            }
            invalidateSelf();
            return;
        }
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            currDrawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mAlpha = i3;
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            currDrawable.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            currDrawable.setBounds(i3, i16, i17, i18);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            currDrawable.setColorFilter(colorFilter);
        }
    }
}
