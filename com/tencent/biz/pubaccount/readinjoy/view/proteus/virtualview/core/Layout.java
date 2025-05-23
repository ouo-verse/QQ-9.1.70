package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class Layout extends ViewBase {
    private static final String TAG = "Layout_TMTEST";
    protected GradientColorBg mGradientColorBg;
    protected List<ViewBase> mSubViews;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class GradientColorBg {
        int endColor;
        boolean hasSetBg;
        boolean isHorizontal;
        int startColor;
    }

    public Layout(VafContext vafContext) {
        super(vafContext);
        this.mSubViews = new ArrayList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if (r7 == (-2)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r7 == (-2)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        if (r7 > r5) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getChildMeasureSpec(int i3, int i16, int i17) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3) - i16;
        int i18 = 0;
        int max = Math.max(0, size);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    if (i17 >= 0) {
                        if (max > 0) {
                        }
                        i18 = 1073741824;
                    } else if (i17 != -1) {
                    }
                    i17 = max;
                    i18 = 1073741824;
                }
                i17 = 0;
            } else {
                if (i17 < 0) {
                    if (i17 == -1 || i17 == -2) {
                        i17 = max;
                    }
                    i17 = 0;
                }
                i18 = 1073741824;
            }
        } else {
            if (i17 < 0) {
                if (i17 != -1) {
                }
                i17 = max;
                i18 = Integer.MIN_VALUE;
            }
            i18 = 1073741824;
        }
        return View.MeasureSpec.makeMeasureSpec(i17, i18);
    }

    public void addView(ViewBase viewBase) {
        if (LogUtils.shouldLog()) {
            LogUtils.d(TAG, "[addView] " + viewBase.mName);
        }
        if (viewBase != null) {
            this.mSubViews.add(viewBase);
            viewBase.mParent = this;
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void comDraw(Canvas canvas) {
        super.comDraw(canvas);
        for (ViewBase viewBase : this.mSubViews) {
            if (viewBase.shouldDraw()) {
                viewBase.comDraw(canvas);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void destroy() {
        super.destroy();
        Iterator<ViewBase> it = this.mSubViews.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mSubViews.clear();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public ViewBase findViewBaseByName(String str) {
        ViewBase findViewBaseByName = super.findViewBaseByName(str);
        if (findViewBaseByName == null) {
            Iterator<ViewBase> it = this.mSubViews.iterator();
            while (it.hasNext() && (findViewBaseByName = it.next().findViewBaseByName(str)) == null) {
            }
        }
        return findViewBaseByName;
    }

    public Params generateParams() {
        return new Params();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public ViewBase getChild(int i3) {
        if (i3 > 0 && i3 < this.mSubViews.size()) {
            return this.mSubViews.get(i3);
        }
        return null;
    }

    public final List<ViewBase> getSubViews() {
        return this.mSubViews;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureComChild(ViewBase viewBase, int i3, int i16) {
        Params comLayoutParams = viewBase.getComLayoutParams();
        viewBase.measureComponent(getChildMeasureSpec(i3, this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + comLayoutParams.mLayoutMarginLeft + comLayoutParams.mLayoutMarginRight, comLayoutParams.mLayoutWidth), getChildMeasureSpec(i16, this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + comLayoutParams.mLayoutMarginTop + comLayoutParams.mLayoutMarginBottom, comLayoutParams.mLayoutHeight));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onComDraw(Canvas canvas) {
        super.onComDraw(canvas);
        if (this.mBorderWidth > 0) {
            if (this.mBorderPaint == null) {
                Paint paint = new Paint();
                this.mBorderPaint = paint;
                paint.setAntiAlias(true);
                this.mBorderPaint.setStyle(Paint.Style.STROKE);
            }
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            VirtualViewUtils.drawBorder(canvas, this.mBorderPaint, this.mMeasuredWidth, this.mMeasuredHeight, this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
        GradientColorBg gradientColorBg = this.mGradientColorBg;
        if (gradientColorBg != null) {
            setBackgroundColor(gradientColorBg);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        super.onParseValueFinished();
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setStyle(Paint.Style.FILL);
        }
        if (this.mBorderWidth > 0) {
            if (this.mBorderPaint == null) {
                Paint paint2 = new Paint();
                this.mBorderPaint = paint2;
                paint2.setAntiAlias(true);
                this.mBorderPaint.setStyle(Paint.Style.STROKE);
            }
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        Iterator<ViewBase> it = this.mSubViews.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, Object obj) {
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (i3 == 56) {
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() >= 4) {
                    GradientColorBg gradientColorBg = new GradientColorBg();
                    Float f16 = Utils.toFloat(jSONArray.get(0));
                    Float f17 = Utils.toFloat(jSONArray.get(1));
                    int parseColor = Utils.parseColor(jSONArray.get(2).toString());
                    gradientColorBg.isHorizontal = "0".equals(jSONArray.get(3).toString());
                    int argb = Color.argb((int) (f16.floatValue() * 255.0f), Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
                    int argb2 = Color.argb((int) (f17.floatValue() * 255.0f), Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
                    gradientColorBg.startColor = argb;
                    gradientColorBg.endColor = argb2;
                    this.mGradientColorBg = gradientColorBg;
                }
            }
            return true;
        }
        if (i3 == 57) {
            if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() >= 3) {
                    GradientColorBg gradientColorBg2 = new GradientColorBg();
                    gradientColorBg2.isHorizontal = "0".equals(jSONArray2.get(2).toString());
                    int parseColor2 = Utils.parseColor(jSONArray2.get(0).toString());
                    int parseColor3 = Utils.parseColor(jSONArray2.get(1).toString());
                    gradientColorBg2.startColor = parseColor2;
                    gradientColorBg2.endColor = parseColor3;
                    this.mGradientColorBg = gradientColorBg2;
                }
            }
            return true;
        }
        return super.setAttribute(i3, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBackgroundColor(GradientColorBg gradientColorBg) {
        int height;
        int i3;
        if (gradientColorBg != null && !gradientColorBg.hasSetBg) {
            gradientColorBg.hasSetBg = true;
            View nativeView = getNativeView();
            if (nativeView != null) {
                PaintDrawable paintDrawable = new PaintDrawable();
                if (gradientColorBg.isHorizontal) {
                    i3 = getWidth();
                    height = 0;
                } else {
                    height = getHeight();
                    i3 = 0;
                }
                int i16 = this.mBorderTopLeftRadius;
                int i17 = this.mBorderTopRightRadius;
                int i18 = this.mBorderBottomRightRadius;
                int i19 = this.mBorderBottomLeftRadius;
                paintDrawable.setCornerRadii(new float[]{i16, i16, i17, i17, i18, i18, i19, i19});
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, i3, height, gradientColorBg.startColor, gradientColorBg.endColor, Shader.TileMode.CLAMP);
                Paint paint = paintDrawable.getPaint();
                if (paint != null) {
                    paint.setShader(linearGradient);
                }
                nativeView.setBackgroundDrawable(paintDrawable);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void setVisibility(int i3) {
        if (getNativeView() != null) {
            super.setVisibility(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Params {
        public int mLayoutWidth = -1;
        public int mLayoutHeight = -2;
        public int mLayoutMarginLeft = 0;
        public int mLayoutMarginRight = 0;
        public int mLayoutMarginTop = 0;
        public int mLayoutMarginBottom = 0;

        private static int strAttributeToPx(String str) {
            if (str == null) {
                return 0;
            }
            try {
                return Utils.rp2px(Double.valueOf(str).doubleValue());
            } catch (NumberFormatException e16) {
                LogUtil.QLog.d(Layout.TAG, 2, "strAttributeToPx: " + e16.getMessage());
                return 0;
            }
        }

        public boolean setAttribute(int i3, Object obj) {
            if (i3 == 1) {
                this.mLayoutWidth = ((SizeValue) obj).getLayoutSize();
                return true;
            }
            if (i3 != 2) {
                return false;
            }
            this.mLayoutHeight = ((SizeValue) obj).getLayoutSize();
            return true;
        }

        public boolean setAttribute(int i3, String str) {
            if (i3 == 3) {
                this.mLayoutMarginTop = strAttributeToPx(str);
                return false;
            }
            if (i3 == 4) {
                this.mLayoutMarginLeft = strAttributeToPx(str);
                return false;
            }
            if (i3 == 5) {
                this.mLayoutMarginRight = strAttributeToPx(str);
                return false;
            }
            if (i3 != 6) {
                switch (i3) {
                    case 58:
                        this.mLayoutHeight = SizeValue.getLayoutSize(1004, Double.valueOf(str).doubleValue());
                        return true;
                    case 59:
                        this.mLayoutWidth = SizeValue.getLayoutSize(1004, Double.valueOf(str).doubleValue());
                        return true;
                    case 60:
                        this.mLayoutHeight = SizeValue.getLayoutSize(1003, Double.valueOf(str).doubleValue());
                        return true;
                    case 61:
                        this.mLayoutWidth = SizeValue.getLayoutSize(1003, Double.valueOf(str).doubleValue());
                        return true;
                    default:
                        return false;
                }
            }
            this.mLayoutMarginBottom = strAttributeToPx(str);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, String str) {
        boolean attribute = super.setAttribute(i3, str);
        if (attribute) {
            return attribute;
        }
        return false;
    }
}
