package com.tencent.biz.qqstory.view;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageButton;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
/* loaded from: classes5.dex */
public class PressDarkImageButton extends ImageButton {
    public static final int[] G = {R.attr.fromAlpha, R.attr.toAlpha, com.tencent.mobileqq.R.attr.f155580fh};
    private boolean C;
    private boolean D;
    private String E;
    private Paint F;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f94487d;

    /* renamed from: e, reason: collision with root package name */
    public float f94488e;

    /* renamed from: f, reason: collision with root package name */
    public float f94489f;

    /* renamed from: h, reason: collision with root package name */
    public int f94490h;

    /* renamed from: i, reason: collision with root package name */
    public int f94491i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f94492m;

    public PressDarkImageButton(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f94492m && this.C && this.f94490h != 0 && this.f94491i != 0 && this.f94487d != null) {
            if (this.F == null) {
                this.F = new Paint();
            }
            float f16 = getResources().getDisplayMetrics().density / 2.0f;
            Matrix matrix = new Matrix();
            matrix.setScale(f16, f16);
            matrix.setTranslate(this.f94490h * 0.625f, this.f94491i * 0.25641027f);
            if (isPressed()) {
                this.F.setAlpha((int) (this.f94489f * 255.0f));
            } else {
                this.F.setAlpha((int) (this.f94488e * 255.0f));
            }
            canvas.drawBitmap(this.f94487d, matrix, this.F);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (!this.D) {
            return;
        }
        if (isPressed()) {
            super.setImageAlpha((int) (this.f94489f * 255.0f));
        } else {
            super.setImageAlpha((int) (this.f94488e * 255.0f));
        }
    }

    public void setChecked(boolean z16) {
        if (this.C != z16) {
            this.C = z16;
            invalidate();
            try {
                if (AppSetting.f99565y && createAccessibilityNodeInfo().isAccessibilityFocused() && !TextUtils.isEmpty(this.E)) {
                    AccessibilityUtil.x(this, this.E, this.C, Button.class.getName());
                }
            } catch (Exception e16) {
                QLog.d("PressDarkImageButton", 1, "adapt to accessibility occur exception!!", e16);
            }
        }
    }

    public void setDefContentDescription(String str) {
        this.E = str;
    }

    public void setEnableDark(boolean z16) {
        this.D = z16;
        if (!z16) {
            super.setImageAlpha((int) (this.f94488e * 255.0f));
        }
    }

    public void setInvalid() {
        this.D = false;
        super.setEnabled(false);
        super.setClickable(false);
        super.setImageAlpha((int) (this.f94489f * 255.0f));
    }

    public PressDarkImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x008d, code lost:
    
        if (r2 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PressDarkImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94488e = 1.0f;
        this.f94489f = 0.5f;
        this.f94490h = 0;
        this.f94491i = 0;
        this.f94492m = false;
        this.C = false;
        this.D = true;
        this.E = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G);
        this.f94488e = obtainStyledAttributes.getFloat(0, this.f94488e);
        this.f94489f = obtainStyledAttributes.getFloat(1, this.f94489f);
        this.f94492m = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        if (this.f94492m) {
            TypedArray typedArray = null;
            try {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_width, R.attr.layout_height});
                    this.f94490h = typedArray.getDimensionPixelSize(0, 0);
                    this.f94491i = typedArray.getDimensionPixelSize(1, 0);
                    if (this.f94487d == null) {
                        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                        Bitmap f16 = imageCacheHelper.f("IMAGE_CACHE_KEY");
                        this.f94487d = f16;
                        if (f16 == null) {
                            Bitmap h16 = j.h(BaseApplicationImpl.getApplication().getResources(), com.tencent.mobileqq.R.drawable.fbq);
                            this.f94487d = h16;
                            if (h16 != null) {
                                imageCacheHelper.i("IMAGE_CACHE_KEY", h16, Business.Default);
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                typedArray.recycle();
            } catch (Throwable th5) {
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th5;
            }
        }
        if (!AppSetting.f99565y || TextUtils.isEmpty(this.E)) {
            return;
        }
        AccessibilityUtil.x(this, this.E, this.C, Button.class.getName());
    }
}
