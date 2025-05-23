package com.qzone.preview.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.qzone.util.z;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.image.region.RegionImageUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends ImageProcessor {

    /* renamed from: a, reason: collision with root package name */
    public boolean f50092a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f50093b = false;

    private Drawable a(Drawable drawable) {
        int i3;
        ImageKey imageKey = this.mImageKey;
        if (imageKey == null || !imageKey.options.isNeedPieceLoad || drawable == null) {
            return drawable;
        }
        int i16 = imageKey.orgWidth;
        if (i16 != 0 && (i3 = imageKey.orgHeight) != 0 && !RegionImageUtil.isNeedPieceLoad(i16, i3)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("region drawable isNeedPieceLoad = ");
            ImageKey imageKey2 = this.mImageKey;
            sb5.append(RegionImageUtil.isNeedPieceLoad(imageKey2.orgWidth, imageKey2.orgHeight));
            j.e("PictureViewerImageProce", 4, sb5.toString());
            return drawable;
        }
        if (drawable instanceof SpecifiedBitmapDrawable) {
            return b(drawable, ((SpecifiedBitmapDrawable) drawable).getBitmapRef());
        }
        if (drawable instanceof BitmapImageDrawable) {
            return b(drawable, ((BitmapImageDrawable) drawable).getBitmapRef());
        }
        j.e("PictureViewerImageProce", 4, "cannot create RegionDrawable with type = " + drawable.getClass().getName() + "inSampleSize = " + this.mImageKey.inSampleSize + " width = " + drawable.getIntrinsicWidth() + " height = " + drawable.getIntrinsicHeight());
        return drawable;
    }

    private Drawable b(Drawable drawable, BitmapReference bitmapReference) {
        ImageKey imageKey = this.mImageKey;
        if (imageKey != null && imageKey.inSampleSize != 1 && bitmapReference != null) {
            int rotation = RegionImageUtil.getRotation(imageKey.filePath);
            if (rotation % 90 == 0) {
                j.e("PictureViewerImageProce", 4, "create RegionDrawable with rotation = " + rotation + " inSampleSize = " + this.mImageKey.inSampleSize);
                RegionDrawable regionDrawable = new RegionDrawable((Resources) null, bitmapReference, this.mImageKey.filePath);
                ImageKey imageKey2 = this.mImageKey;
                regionDrawable.initRegionDrawable(imageKey2.orgWidth, imageKey2.orgHeight);
                return regionDrawable;
            }
            j.e("PictureViewerImageProce", 4, "can not create RegionDrawable with rotation = " + rotation);
            return drawable;
        }
        j.e("PictureViewerImageProce", 4, "can not create RegionDrawable with inSampleSize = 1");
        return drawable;
    }

    public boolean c() {
        return this.f50093b;
    }

    public void d(boolean z16) {
        this.f50093b = z16;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        Drawable a16;
        int[] a17;
        Drawable drawable2 = drawable;
        if (drawable2 == null) {
            return drawable2;
        }
        int l3 = ar.l() - ((int) (ar.i() * 4.0f));
        int k3 = ar.k() - ((int) (ar.i() * 4.0f));
        Drawable drawable3 = null;
        if (drawable2 instanceof ImageDrawable) {
            ImageDrawable imageDrawable = (ImageDrawable) drawable2;
            if (this.f50092a) {
                int intrinsicWidth = imageDrawable.getIntrinsicWidth();
                int intrinsicHeight = imageDrawable.getIntrinsicHeight();
                if (l3 <= 0 || k3 <= 0 || intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    return drawable2;
                }
                double d16 = intrinsicWidth;
                double d17 = intrinsicHeight;
                double d18 = l3;
                double d19 = k3;
                if (d16 / d17 > d18 / d19) {
                    k3 = (int) ((d18 * d17) / d16);
                } else {
                    l3 = (int) ((d19 * d16) / d17);
                }
                a16 = new ScaleProcessor(l3, k3, true).process(drawable2);
                a16.setBounds(0, 0, l3, k3);
            } else {
                BitmapReference bitmapRef = imageDrawable.getBitmapRef();
                if (bitmapRef != null) {
                    bitmapRef.getBitmap().setDensity(160);
                    if (SliceBitmapDrawable.SliceBitmap.needSlice(bitmapRef.getBitmap())) {
                        SliceBitmapDrawable.SliceBitmap sliceBitmap = new SliceBitmapDrawable.SliceBitmap(bitmapRef.getBitmap());
                        if (!bitmapRef.isRecycled()) {
                            bitmapRef.release();
                        }
                        drawable3 = new SliceBitmapDrawable((Resources) null, sliceBitmap);
                    } else if (drawable2 instanceof BitmapImageDrawable) {
                        int intrinsicWidth2 = drawable.getIntrinsicWidth();
                        int intrinsicHeight2 = drawable.getIntrinsicHeight();
                        if (intrinsicWidth2 > 0 && intrinsicHeight2 > 0 && intrinsicWidth2 < l3 && intrinsicHeight2 < k3) {
                            z zVar = new z();
                            if (this.f50093b) {
                                a17 = zVar.c(intrinsicHeight2, intrinsicWidth2, k3, l3);
                            } else {
                                a17 = zVar.a(intrinsicHeight2, intrinsicWidth2, k3, l3);
                            }
                            int i3 = a17[0];
                            int i16 = a17[1];
                            drawable2 = new ScaleProcessor(i3, i16, true).process(drawable2);
                            drawable2.setBounds(0, 0, i3, i16);
                        }
                        drawable3 = drawable2;
                    } else {
                        drawable3 = imageDrawable;
                    }
                }
                a16 = a(drawable3);
            }
            return a16;
        }
        if (!(drawable2 instanceof NewGifDrawable)) {
            return null;
        }
        NewGifDrawable newGifDrawable = (NewGifDrawable) drawable2;
        int intrinsicWidth3 = newGifDrawable.getIntrinsicWidth();
        int intrinsicHeight3 = newGifDrawable.getIntrinsicHeight();
        if (l3 <= 0 || k3 <= 0 || intrinsicWidth3 <= 0 || intrinsicHeight3 <= 0) {
            return null;
        }
        double d26 = l3;
        double d27 = k3;
        if (intrinsicWidth3 / intrinsicHeight3 > d26 / d27) {
            k3 = (int) (d26 * (intrinsicHeight3 / intrinsicWidth3));
        } else {
            l3 = (int) (d27 * (intrinsicWidth3 / intrinsicHeight3));
        }
        newGifDrawable.setIntrinsicHeight(k3);
        newGifDrawable.setIntrinsicWidth(l3);
        newGifDrawable.setBounds(0, 0, l3, k3);
        return null;
    }
}
