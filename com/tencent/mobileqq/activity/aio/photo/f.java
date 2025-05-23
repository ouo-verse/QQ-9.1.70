package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends com.tencent.common.galleryactivity.k {

    /* renamed from: d, reason: collision with root package name */
    public AIORichMediaData f179735d;

    /* renamed from: e, reason: collision with root package name */
    public int f179736e;

    /* renamed from: f, reason: collision with root package name */
    public Rect f179737f;

    /* renamed from: h, reason: collision with root package name */
    boolean f179738h;

    /* renamed from: i, reason: collision with root package name */
    boolean f179739i;

    /* renamed from: m, reason: collision with root package name */
    Rect f179740m;

    @Deprecated
    public static URLDrawable c(t tVar) {
        return URLDrawableHelper.getNestDrawable(tVar, 1);
    }

    private Drawable e() {
        AIORichMediaData aIORichMediaData = this.f179735d;
        if (aIORichMediaData == null || !AIOFilePicData.class.isInstance(aIORichMediaData)) {
            return null;
        }
        File a16 = this.f179735d.a(2);
        File a17 = this.f179735d.a(4);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (a16 != null && ImageCacheHelper.f98636a.g(this.f179735d.b(2)) != null) {
            if (URLDrawableHelper.getExifRotation(a16.getAbsolutePath()) != 0) {
                return null;
            }
            return URLDrawable.getDrawable(this.f179735d.b(2), obtain);
        }
        if (a17 != null && ImageCacheHelper.f98636a.g(this.f179735d.b(4)) != null) {
            if (URLDrawableHelper.getExifRotation(a17.getAbsolutePath()) != 0) {
                return null;
            }
            return URLDrawable.getDrawable(this.f179735d.b(4), obtain);
        }
        if (this.f179735d.a(1) == null) {
            return null;
        }
        return URLDrawable.getDrawable(this.f179735d.b(1), obtain);
    }

    private Drawable f() {
        AIORichMediaData aIORichMediaData = this.f179735d;
        if (aIORichMediaData == null || !AIOFileVideoData.class.isInstance(aIORichMediaData)) {
            return null;
        }
        AIOFileVideoData aIOFileVideoData = (AIOFileVideoData) this.f179735d;
        File a16 = aIOFileVideoData.a(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (a16 != null && ImageCacheHelper.f98636a.g(aIOFileVideoData.b(0)) != null) {
            return URLDrawable.getDrawable(this.f179735d.b(0), obtain);
        }
        if (a16 == null) {
            return null;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(this.f179735d.b(0), obtain);
        drawable2.downloadImediatly();
        return drawable2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00dd A[Catch: all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:3:0x0002, B:5:0x000d, B:7:0x0026, B:9:0x0034, B:10:0x00d7, B:12:0x00dd, B:14:0x00e9, B:16:0x00f5, B:19:0x00fb, B:21:0x0108, B:28:0x0042, B:30:0x0050, B:31:0x005c, B:33:0x0065, B:35:0x0073, B:37:0x007d, B:39:0x0091, B:41:0x009d, B:43:0x00aa, B:44:0x00b8, B:46:0x00c2, B:47:0x00c7, B:49:0x00d1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0108 A[Catch: all -> 0x0111, TRY_LEAVE, TryCatch #0 {all -> 0x0111, blocks: (B:3:0x0002, B:5:0x000d, B:7:0x0026, B:9:0x0034, B:10:0x00d7, B:12:0x00dd, B:14:0x00e9, B:16:0x00f5, B:19:0x00fb, B:21:0x0108, B:28:0x0042, B:30:0x0050, B:31:0x005c, B:33:0x0065, B:35:0x0073, B:37:0x007d, B:39:0x0091, B:41:0x009d, B:43:0x00aa, B:44:0x00b8, B:46:0x00c2, B:47:0x00c7, B:49:0x00d1), top: B:2:0x0002 }] */
    @Override // com.tencent.common.galleryactivity.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getAnimationDrawable() {
        Drawable drawable;
        Rect thumbRect;
        try {
            if (AIOImageData.class.isInstance(this.f179735d)) {
                File a16 = this.f179735d.a(2);
                File a17 = this.f179735d.a(4);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mLoadingDrawable = drawable2;
                obtain.mFailedDrawable = drawable2;
                if (a16 != null && ImageCacheHelper.f98636a.g(this.f179735d.b(2)) != null) {
                    drawable = URLDrawable.getDrawable(this.f179735d.b(2), obtain);
                } else if (a17 != null && ImageCacheHelper.f98636a.g(this.f179735d.b(4)) != null) {
                    drawable = URLDrawable.getDrawable(this.f179735d.b(4), obtain);
                } else {
                    if (this.f179735d.a(1) != null) {
                        URLDrawable drawable3 = URLDrawable.getDrawable(this.f179735d.b(1), obtain);
                        drawable3.downloadImediatly();
                        drawable = drawable3;
                    }
                    drawable = null;
                }
                thumbRect = getThumbRect();
                if (drawable != null && (drawable.getIntrinsicHeight() * 3 < drawable.getIntrinsicWidth() || drawable.getIntrinsicWidth() * 3 < drawable.getIntrinsicHeight())) {
                    this.isImgCenterCropMode = false;
                }
                if (drawable != null && thumbRect != null) {
                    this.f179736e = com.tencent.common.galleryactivity.k.getCutValue(thumbRect, drawable);
                    if (drawable.getIntrinsicHeight() != -1) {
                        if (drawable.getIntrinsicWidth() != -1) {
                            return drawable;
                        }
                    }
                }
                return null;
            }
            if (AIOShortVideoData.class.isInstance(this.f179735d)) {
                AIOShortVideoData aIOShortVideoData = (AIOShortVideoData) this.f179735d;
                File a18 = aIOShortVideoData.a(0);
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable4 = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain2.mLoadingDrawable = drawable4;
                obtain2.mFailedDrawable = drawable4;
                if (a18 != null && ImageCacheHelper.f98636a.g(aIOShortVideoData.b(0)) != null) {
                    drawable = URLDrawable.getDrawable(this.f179735d.b(0), obtain2);
                } else {
                    if (a18 != null) {
                        URLDrawable drawable5 = URLDrawable.getDrawable(this.f179735d.b(0), obtain2);
                        drawable5.downloadImediatly();
                        drawable = drawable5;
                    }
                    drawable = null;
                }
                thumbRect = getThumbRect();
                if (drawable != null) {
                    this.isImgCenterCropMode = false;
                }
                if (drawable != null) {
                    this.f179736e = com.tencent.common.galleryactivity.k.getCutValue(thumbRect, drawable);
                    if (drawable.getIntrinsicHeight() != -1) {
                    }
                }
                return null;
            }
            if (AIOFilePicData.class.isInstance(this.f179735d)) {
                drawable = e();
            } else {
                if (AIOFileVideoData.class.isInstance(this.f179735d)) {
                    drawable = f();
                }
                drawable = null;
            }
            thumbRect = getThumbRect();
            if (drawable != null) {
            }
            if (drawable != null) {
            }
            return null;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", th5);
            }
            return null;
        }
    }

    @Override // com.tencent.common.galleryactivity.k
    public int getCutValue() {
        return this.f179736e;
    }

    @Override // com.tencent.common.galleryactivity.k
    public Rect getStartSrcRect() {
        return this.f179740m;
    }

    @Override // com.tencent.common.galleryactivity.k
    public int getStartX() {
        return 0;
    }

    @Override // com.tencent.common.galleryactivity.k
    public int getStartY() {
        return 0;
    }

    @Override // com.tencent.common.galleryactivity.k
    public Rect getThumbRect() {
        if (this.f179739i && this.f179738h) {
            return this.f179737f;
        }
        return super.getThumbRect();
    }
}
