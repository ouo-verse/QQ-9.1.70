package com.tencent.mobileqq.vas.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CoolTextView extends TextView {
    public static final int DEFAULT_BG_HEIGHT = 15;
    public static final int DEFAULT_LEFT_LOGO_HEIGHT = 20;
    public static final int DEFAULT_LEFT_LOGO_WIDTH = 34;
    public static final int DEFAULT_SIZE = 8;
    public static final String TAG = "CoolTextView";
    private boolean isEnable;
    Drawable mBackgroundDrawable;
    float mBaseline;
    int mBgHeight;
    Rect mBgRect;
    private CoolBuilder mBuilder;
    int mLeftDiffPx;
    Drawable mLeftDrawable;
    int mLogoHeight;
    int mLogoWidth;
    Rect mTxtRect;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class CoolBuilder {
        public String bgUrl;
        public String logoUrl;
        public String txtColor;
        public int logoWidth = 34;
        public int logoHeight = 20;
        public int bgHeight = 15;
        public String infoStr = "";
        public int txtSize = 8;

        public void setInfoStr(String str) {
            this.infoStr = str;
        }
    }

    public CoolTextView(Context context) {
        this(context, null);
    }

    private void drawBackground(Canvas canvas) {
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(this.mBgRect);
        this.mBackgroundDrawable.draw(canvas);
    }

    private void drawLogo() {
        Drawable drawable = this.mLeftDrawable;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, this.mLogoWidth, this.mLogoHeight);
        setCompoundDrawables(this.mLeftDrawable, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adapterDrawablesDiff(int i3) {
        this.mLeftDiffPx = i3;
    }

    public void clearCoolBuilder() {
        CoolBuilder coolBuilder = new CoolBuilder();
        this.mBuilder = coolBuilder;
        setCoolBuilder(coolBuilder);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        super.onDraw(canvas);
        canvas.drawText(this.mBuilder.infoStr, this.mTxtRect.left, this.mBaseline, getPaint());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int desiredWidth = (int) Layout.getDesiredWidth(this.mBuilder.infoStr, getPaint());
        setMeasuredDimension(this.mLogoWidth + desiredWidth + ViewUtils.dip2px(7.5f), Math.max(this.mLogoHeight, this.mBgHeight));
        int abs = Math.abs(this.mLogoHeight - this.mBgHeight);
        int i17 = this.mBgHeight + abs;
        int dip2px = this.mLogoWidth + desiredWidth + ViewUtils.dip2px(7.5f);
        Rect rect = this.mBgRect;
        rect.left = 10;
        rect.right = dip2px;
        int i18 = this.mLeftDiffPx;
        rect.top = abs - i18;
        rect.bottom = i17 + i18;
        Rect rect2 = this.mTxtRect;
        rect2.left = this.mLogoWidth + 5;
        rect2.top = abs - i18;
        rect2.right = dip2px;
        rect2.bottom = i17 + i18;
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        float f16 = fontMetrics.bottom;
        this.mBaseline = this.mTxtRect.centerY() + (((f16 - fontMetrics.top) / 2.0f) - f16);
    }

    public void setCoolBuilder(CoolBuilder coolBuilder) {
        if (coolBuilder != null) {
            this.mBuilder = coolBuilder;
        }
        this.mLogoWidth = ViewUtils.dip2px(this.mBuilder.logoWidth);
        this.mLogoHeight = ViewUtils.dip2px(this.mBuilder.logoHeight);
        this.mBgHeight = ViewUtils.dip2px(this.mBuilder.bgHeight);
        if (!TextUtils.isEmpty(this.mBuilder.logoUrl)) {
            if (this.isEnable) {
                this.mLeftDrawable = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(this.mBuilder.logoUrl).a();
            } else {
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                apngOptions.setTagId(new int[]{9});
                this.mLeftDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(TAG, this.mBuilder.logoUrl, apngOptions);
            }
        }
        if (!TextUtils.isEmpty(this.mBuilder.bgUrl)) {
            if (this.isEnable) {
                this.mBackgroundDrawable = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(this.mBuilder.bgUrl).e(41, 27).a();
            } else {
                this.mBackgroundDrawable = VasApngUtil.getRegionUrlDrawable(this.mBuilder.bgUrl, getResources().getDisplayMetrics().densityDpi);
            }
        } else {
            this.mBackgroundDrawable = null;
        }
        setTextSize(1, this.mBuilder.txtSize);
        try {
            if (!TextUtils.isEmpty(this.mBuilder.txtColor)) {
                setTextColor(Color.parseColor(this.mBuilder.txtColor));
            } else {
                setTextColor(getResources().getColor(R.color.skin_black));
            }
        } catch (Exception e16) {
            QLog.d(TAG, 2, "QID_LOG,color_parse," + e16.getMessage());
        }
        drawLogo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMargins(int i3, int i16, int i17, int i18) {
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.setMargins(i3, i17, i16, i18);
            setLayoutParams(marginLayoutParams);
        }
    }

    public CoolTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isEnable = VasNormalToggle.VAS_BUG_111078711.isEnable(true);
        this.mBuilder = new CoolBuilder();
        this.mTxtRect = new Rect();
        this.mBgRect = new Rect();
    }
}
