package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FixSizeImageView extends ThemeImageView implements IRecentImgv {
    static IPatchRedirector $redirector_ = null;
    public static final long LEVEL_CONSTANT_BLOCK = 1;
    public static final long LEVEL_NORMAL = 5;
    public static final long LEVEL_TMP_BLOCK = 2;
    protected boolean isShowMask;
    protected boolean isShowTroopCreditStatusIcon;
    protected Paint mBmpPaint;
    protected float mContentCenterX;
    protected float mContentCenterY;
    protected float mContentRadius;
    protected Paint mMaskPaint;
    protected long mTroopCreditLevel;
    protected Bitmap mTroopCreditStatusBmp;
    protected Rect mTroopCreditStatusIconRect;

    public FixSizeImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContentCenterX = -1.0f;
        this.mContentCenterY = -1.0f;
        this.mContentRadius = 0.0f;
        this.mMaskPaint = null;
        this.mBmpPaint = null;
        this.isShowMask = false;
        this.isShowTroopCreditStatusIcon = false;
        this.mTroopCreditStatusIconRect = null;
        this.mTroopCreditLevel = 5L;
        this.mTroopCreditStatusBmp = null;
    }

    protected static Bitmap getTroopCreditStatusIcon(long j3) {
        int i3;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 == 1) {
            i3 = R.drawable.h2g;
            str = "StatusIcon_TroopPermanentBlockStatusBigIconKey";
        } else if (j3 == 2) {
            i3 = R.drawable.h2i;
            str = "StatusIcon_TroopTmpBlockStatusBigIcon";
        } else {
            i3 = -1;
            str = "";
        }
        if (i3 < 0) {
            return null;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null && (f16 = com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), i3)) != null) {
            imageCacheHelper.i(str, f16, Business.Conversation);
        }
        if (QLog.isColorLevel()) {
            QLog.i("FixSizeImageView", 2, "getTroopCreditStatusIcon:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return f16;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        if (this.isShowMask || this.isShowTroopCreditStatusIcon) {
            doExtraDraw(canvas);
        }
    }

    protected void doExtraDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (this.isShowMask) {
            if (this.mContentCenterX == -1.0f || this.mContentCenterY == -1.0f) {
                this.mContentCenterX = getPaddingLeft() + (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f);
                this.mContentCenterY = getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f);
                this.mContentRadius = Math.max(r0, r2) / 2;
            }
            if (this.mMaskPaint == null) {
                Paint paint = new Paint();
                this.mMaskPaint = paint;
                paint.setAntiAlias(true);
                this.mMaskPaint.setColor(Color.parseColor("#B2000000"));
            }
            canvas.drawCircle(this.mContentCenterX, this.mContentCenterY, this.mContentRadius, this.mMaskPaint);
        }
        if (this.isShowTroopCreditStatusIcon) {
            if (this.mBmpPaint == null) {
                Paint paint2 = new Paint();
                this.mBmpPaint = paint2;
                paint2.setAntiAlias(true);
                this.mBmpPaint.setFilterBitmap(true);
            }
            if (this.mTroopCreditStatusBmp != null) {
                if (this.mTroopCreditStatusIconRect == null) {
                    int width = getWidth() - getPaddingRight();
                    int height = getHeight() - getPaddingBottom();
                    this.mTroopCreditStatusIconRect = new Rect(width - this.mTroopCreditStatusBmp.getWidth(), height - this.mTroopCreditStatusBmp.getHeight(), width, height);
                }
                canvas.drawBitmap(this.mTroopCreditStatusBmp, (Rect) null, this.mTroopCreditStatusIconRect, this.mBmpPaint);
            }
        }
    }

    @Override // com.tencent.widget.ThemeImageView
    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.themeImageWrapper = null;
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.widget.IRecentImgv
    public void showTroopCreditStatus(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        if (this.mTroopCreditLevel == j3) {
            return;
        }
        this.mTroopCreditLevel = j3;
        if (QLog.isColorLevel()) {
            QLog.i("FixSizeImageView", 2, "showTroopCreditStatus:" + j3);
        }
        if (j3 != 2 && j3 != 1) {
            this.isShowMask = false;
            this.isShowTroopCreditStatusIcon = false;
            this.mTroopCreditStatusBmp = null;
        } else {
            this.isShowMask = true;
            this.isShowTroopCreditStatusIcon = true;
            this.mTroopCreditStatusBmp = getTroopCreditStatusIcon(j3);
        }
        invalidate();
    }

    public FixSizeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mContentCenterX = -1.0f;
        this.mContentCenterY = -1.0f;
        this.mContentRadius = 0.0f;
        this.mMaskPaint = null;
        this.mBmpPaint = null;
        this.isShowMask = false;
        this.isShowTroopCreditStatusIcon = false;
        this.mTroopCreditStatusIconRect = null;
        this.mTroopCreditLevel = 5L;
        this.mTroopCreditStatusBmp = null;
    }

    public FixSizeImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mContentCenterX = -1.0f;
        this.mContentCenterY = -1.0f;
        this.mContentRadius = 0.0f;
        this.mMaskPaint = null;
        this.mBmpPaint = null;
        this.isShowMask = false;
        this.isShowTroopCreditStatusIcon = false;
        this.mTroopCreditStatusIconRect = null;
        this.mTroopCreditLevel = 5L;
        this.mTroopCreditStatusBmp = null;
    }
}
