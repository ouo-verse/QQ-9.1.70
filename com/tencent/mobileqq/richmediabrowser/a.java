package com.tencent.mobileqq.richmediabrowser;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BrowserAnimation implements IBrowserAnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public int f281785a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f281786b;

    /* renamed from: c, reason: collision with root package name */
    private RichMediaBaseData f281787c;

    /* renamed from: d, reason: collision with root package name */
    Rect f281788d;

    public a() {
    }

    @Override // com.tencent.richmediabrowser.model.BrowserAnimation
    public Drawable getAnimationDrawable() {
        Drawable drawable;
        try {
            RichMediaBaseData richMediaBaseData = this.f281787c;
            if (richMediaBaseData instanceof AIOPictureData) {
                drawable = new tm2.d().b((AIOPictureData) this.f281787c);
            } else if (richMediaBaseData instanceof AIOVideoData) {
                drawable = new tm2.e().b((AIOVideoData) this.f281787c);
            } else if (richMediaBaseData instanceof AIOFilePictureData) {
                drawable = new tm2.b().b((AIOFilePictureData) this.f281787c);
            } else if (richMediaBaseData instanceof AIOFileVideoData) {
                drawable = new tm2.c().d((AIOFileVideoData) this.f281787c);
            } else {
                drawable = null;
            }
            Rect thumbRect = getThumbRect();
            if (drawable != null && (drawable.getIntrinsicHeight() * 3 < drawable.getIntrinsicWidth() || drawable.getIntrinsicWidth() * 3 < drawable.getIntrinsicHeight())) {
                this.isImgCenterCropMode = false;
            }
            if (drawable != null && thumbRect != null) {
                this.f281785a = BrowserAnimation.getCutValue(thumbRect, drawable);
                if (drawable.getIntrinsicHeight() != -1) {
                    if (drawable.getIntrinsicWidth() != -1) {
                        return drawable;
                    }
                }
            }
            return null;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", th5);
            }
            return null;
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserAnimationListener
    public BrowserAnimation getBrowserAnimation(RichMediaBaseData richMediaBaseData) {
        a aVar = new a(richMediaBaseData);
        aVar.f281786b = this.f281786b;
        return aVar;
    }

    @Override // com.tencent.richmediabrowser.model.BrowserAnimation
    public int getCutValue() {
        return this.f281785a;
    }

    @Override // com.tencent.richmediabrowser.model.BrowserAnimation
    public Rect getStartSrcRect() {
        return this.f281788d;
    }

    @Override // com.tencent.richmediabrowser.model.BrowserAnimation
    public int getStartX() {
        return 0;
    }

    @Override // com.tencent.richmediabrowser.model.BrowserAnimation
    public int getStartY() {
        return 0;
    }

    @Override // com.tencent.richmediabrowser.model.BrowserAnimation
    public Rect getThumbRect() {
        Rect rect = this.f281786b;
        if (rect != null) {
            return rect;
        }
        return super.getThumbRect();
    }

    public a(RichMediaBaseData richMediaBaseData) {
        this.f281787c = richMediaBaseData;
        this.isImgCenterCropMode = true;
    }
}
