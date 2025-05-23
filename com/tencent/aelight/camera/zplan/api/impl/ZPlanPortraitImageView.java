package com.tencent.aelight.camera.zplan.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 02\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*B\u001b\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b)\u0010-B#\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0014J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010#\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u00061"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanPortraitImageView;", "Landroid/widget/ImageView;", "", "b", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "width", "height", "setCropRestrict", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "setImageBitmap", "Landroid/graphics/RectF;", "a", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "e", "I", "mCropWidth", "f", "mCropHeight", tl.h.F, "mWidth", "i", "mHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/RectF;", "mRestrictInRect", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Bitmap;", "mBitmap", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ZPlanPortraitImageView extends ImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private Bitmap mBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCropWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCropHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RectF mRestrictInRect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanPortraitImageView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        this.mPaint.setDither(true);
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setAntiAlias(true);
    }

    /* renamed from: a, reason: from getter */
    public final RectF getMRestrictInRect() {
        return this.mRestrictInRect;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int i3 = right - left;
        int i16 = bottom - top;
        if ((this.mWidth != i3) | (this.mHeight != i16)) {
            this.mWidth = i3;
            this.mHeight = i16;
        }
        this.mRestrictInRect.left = (getWidth() - this.mCropWidth) / 2.0f;
        this.mRestrictInRect.right = (getWidth() + this.mCropWidth) / 2.0f;
        this.mRestrictInRect.top = getHeight() * 0.14778325f;
        this.mRestrictInRect.bottom = (getHeight() * 0.14778325f) + this.mCropHeight;
    }

    public final void setCropRestrict(int width, int height) {
        this.mCropWidth = width;
        this.mCropHeight = height;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if ((bitmap == null) | (getWidth() <= 0)) {
            boolean z16 = bitmap != null;
            QLog.e("ZPlanPortraitImageView", 1, "setImageBitmap failed, bitmap exists: " + z16 + ", width = " + getWidth());
            return;
        }
        this.mBitmap = bitmap;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanPortraitImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPortraitImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.mRestrictInRect = new RectF();
        b();
    }
}
