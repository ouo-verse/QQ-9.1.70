package com.qzone.preview.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.preview.FaceRelativeLayout;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.image.region.RegionImageUtil;
import com.tencent.image.RegionDrawableData;
import com.tencent.util.VersionUtils;
import com.tencent.widget.Gallery;

/* loaded from: classes39.dex */
public class PictureViewGallery extends Gallery {

    /* renamed from: d, reason: collision with root package name */
    private c f50084d;

    /* renamed from: e, reason: collision with root package name */
    private a f50085e;

    /* renamed from: f, reason: collision with root package name */
    private b f50086f;

    /* loaded from: classes39.dex */
    public interface a {
        void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData);
    }

    /* loaded from: classes39.dex */
    public interface b {
        void a(int i3, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes39.dex */
    public interface c {
        void c(MotionEvent motionEvent);
    }

    public PictureViewGallery(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.widget.Gallery
    protected boolean canUpdateRegionRect() {
        View view;
        if (!VersionUtils.isHoneycomb() || (view = this.mSelectedChild) == null || !(view instanceof FaceRelativeLayout)) {
            return false;
        }
        Drawable drawable = ((FaceRelativeLayout) view).f49533d.getDrawable();
        if (!RegionDrawable.class.isInstance(drawable)) {
            return false;
        }
        RegionDrawable regionDrawable = (RegionDrawable) drawable;
        return RegionImageUtil.isNeedPieceLoad(regionDrawable.getOrgWidth(), regionDrawable.getOrgHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.Gallery
    public float getChildMaxumScale(View view) {
        float childMaxumScale = super.getChildMaxumScale(view);
        if (view.getTag(Gallery.ID_DEFAULT_SCALE) == null) {
            return childMaxumScale;
        }
        float floatValue = ((Float) view.getTag(Gallery.ID_DEFAULT_SCALE)).floatValue();
        return floatValue < 1.0f ? childMaxumScale * floatValue : childMaxumScale;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.Gallery
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        super.onShowAreaChanged(i3, view, regionDrawableData);
        a aVar = this.f50085e;
        if (aVar != null) {
            aVar.onShowAreaChanged(i3, view, regionDrawableData);
        }
    }

    @Override // com.tencent.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        c cVar = this.f50084d;
        if (cVar != null) {
            cVar.c(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.Gallery
    public void onViewDetached(int i3, View view, ViewGroup viewGroup, boolean z16) {
        super.onViewDetached(i3, view, viewGroup, z16);
        if (view == null || !FaceRelativeLayout.class.isInstance(view)) {
            return;
        }
        ((FaceRelativeLayout) view).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.Gallery
    public void onZoomBegin(int i3, View view, ViewGroup viewGroup) {
        super.onZoomBegin(i3, view, viewGroup);
        b bVar = this.f50086f;
        if (bVar != null) {
            bVar.a(i3, view, viewGroup);
        }
    }

    public void setOnPageClickLinstener(c cVar) {
        this.f50084d = cVar;
    }

    public void setOnShowAreaChangedListener(a aVar) {
        this.f50085e = aVar;
    }

    public void setOnZoomBegingListener(b bVar) {
        this.f50086f = bVar;
    }

    @Override // com.tencent.widget.Gallery
    protected void updateShowArea(boolean z16, int i3) {
        View view = this.mSelectedChild;
        if (view == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            return;
        }
        Rect rect = new Rect();
        getChildBounds(view, rect);
        RegionDrawableData regionDrawableData = new RegionDrawableData();
        regionDrawableData.mShowArea = rect;
        Gallery.tmp.set(0, 0, view.getWidth(), view.getHeight());
        float childScale = getChildScale(view);
        regionDrawableData.mImageArea = Gallery.tmp;
        regionDrawableData.mScale = childScale;
        regionDrawableData.mState = i3;
        regionDrawableData.mShowRegion = z16;
        regionDrawableData.mScrollDirection = this.mScrollDirection;
        if (this.mSelectedChild.getTag(Gallery.ID_LONG_PIC_SCALE) != null) {
            regionDrawableData.mDefaultScale = ((Float) view.getTag(Gallery.ID_LONG_PIC_SCALE)).floatValue();
        } else if (view.getTag(Gallery.ID_DEFAULT_SCALE) != null) {
            regionDrawableData.mDefaultScale = ((Float) view.getTag(Gallery.ID_DEFAULT_SCALE)).floatValue();
        }
        onShowAreaChanged(this.mSelectedPosition, view, regionDrawableData);
    }

    public PictureViewGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PictureViewGallery(Context context) {
        super(context);
    }
}
