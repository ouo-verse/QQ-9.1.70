package com.tencent.richmediabrowser.view.recyclerview;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RegionRectHelper {
    private static final String TAG = "RegionRectHelper";
    protected static Rect tmp = new Rect();
    private static RectF tmp2 = new RectF();
    private MainBrowserPresenter mMainBrowserPresenter;
    private Matrix tempMatrix = new Matrix();

    public RegionRectHelper(MainBrowserPresenter mainBrowserPresenter) {
        this.mMainBrowserPresenter = mainBrowserPresenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canUpdateRegionRect(int i3, int i16, int i17, int i18) {
        if (i3 * i16 >= ((i17 * i18) << 2)) {
            return true;
        }
        return false;
    }

    protected Rect getChildBounds(Drawable drawable, Matrix matrix, Rect rect, View view) {
        if (drawable != null && matrix != null && view != null) {
            tmp2.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(tmp2);
            tmp2.offset(view.getLeft(), view.getTop());
            tmp2.round(rect);
            return rect;
        }
        return new Rect();
    }

    protected void onShowAreaChanged(View view, RegionDrawableData regionDrawableData) {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onShowAreaChanged(view, regionDrawableData);
        }
    }

    public void updateShowArea(Drawable drawable, Matrix matrix, float f16, float f17, View view, boolean z16, int i3) {
        updateShowArea(drawable, matrix, f16, f17, view, z16, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateShowArea(Drawable drawable, Matrix matrix, float f16, float f17, View view, boolean z16, int i3, int i16) {
        if (view == null || matrix == null) {
            return;
        }
        int screenWidth = ScreenUtils.getScreenWidth(view.getContext());
        int screenHeight = ScreenUtils.getScreenHeight(view.getContext());
        if (screenWidth == 0 || screenHeight == 0) {
            return;
        }
        Rect rect = new Rect();
        getChildBounds(drawable, matrix, rect, view);
        if (rect.intersect(0, 0, screenWidth, screenHeight)) {
            rect.offset(-view.getLeft(), -view.getTop());
            matrix.invert(this.tempMatrix);
            RectF rectF = new RectF(rect);
            this.tempMatrix.mapRect(rectF);
            rectF.round(rect);
            tmp.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            rect.intersect(tmp);
            RegionDrawableData regionDrawableData = new RegionDrawableData();
            regionDrawableData.mImageArea = tmp;
            regionDrawableData.mShowArea = rect;
            regionDrawableData.mScale = f17;
            regionDrawableData.mState = i3;
            regionDrawableData.mShowRegion = z16;
            regionDrawableData.mScrollDirection = i16;
            regionDrawableData.mDefaultScale = f16;
            onShowAreaChanged(view, regionDrawableData);
        }
    }
}
