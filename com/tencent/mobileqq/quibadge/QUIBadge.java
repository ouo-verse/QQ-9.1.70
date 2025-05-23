package com.tencent.mobileqq.quibadge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.theme.SkinnableView;
import ud0.d;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QUIBadge extends View implements com.tencent.mobileqq.quibadge.a, SkinnableView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QUIBadge";
    private static int sOnePointFivePadding;
    private static int sPadding;
    private static int sZeroPointFivePadding;
    protected final Paint mBgPaint;
    protected int mBorderColor;
    protected Integer mBorderColorToken;
    protected final Paint mBorderPaint;
    protected int mBorderWidth;
    private View mContainer;
    protected Drawable mCustomBgDrawable;
    protected Integer mCustomTextColor;
    private Rect mDelegateRect;
    protected String mDragGroup;
    protected int mDragType;
    private GestureDetector mGestureDetector;
    protected final Handler mHandler;
    protected Drawable mIconDrawable;
    private boolean mIsShadow;
    protected int mNum;
    private GestureDetector.OnDoubleTapListener mOnDoubleTapListener;
    private com.tencent.mobileqq.quibadge.b mOnWillEnterShadowModeListener;
    protected com.tencent.mobileqq.quibadge.res.a mRes;
    protected String mText;
    protected final Paint mTextPaint;
    protected int mViewType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBadge.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (QUIBadge.this.mOnDoubleTapListener != null) {
                return QUIBadge.this.mOnDoubleTapListener.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (QUIBadge.this.mOnDoubleTapListener != null) {
                QUIBadge.this.mOnDoubleTapListener.onSingleTapConfirmed(motionEvent);
            }
            ViewParent parent = QUIBadge.this.getParent();
            if (parent != null) {
                ((ViewGroup) parent).performClick();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b extends TouchDelegate {
        static IPatchRedirector $redirector_;

        public b(Rect rect, View view) {
            super(rect, view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QUIBadge.this, rect, view);
            }
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (QUIBadge.this.getVisibility() != 0) {
                return false;
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (d.i() && motionEvent.getAction() == 0) {
                d.a(QUIBadge.TAG, d.f438809c, "TouchDelegate onTouchEvent: " + motionEvent + "; cur Rect:" + QUIBadge.this.mDelegateRect);
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            motionEvent.setLocation(x16, y16);
            return onTouchEvent;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 46)) {
            redirector.redirect((short) 46);
        } else {
            sPadding = 0;
        }
    }

    public QUIBadge(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void drawBackground(Canvas canvas, float f16, float f17, float f18, float f19) {
        if (this.mCustomBgDrawable == null) {
            canvas.drawRoundRect(f16 - f19, f17 - f18, f16 + f19, f17 + f18, f18, f18, this.mBgPaint);
        } else {
            if (!isSupportCustomViewType()) {
                return;
            }
            Drawable drawable = this.mCustomBgDrawable;
            drawable.setBounds((int) (f16 - f19), (int) (f17 - f18), (int) (f16 + f19), (int) (f17 + f18));
            drawable.draw(canvas);
        }
    }

    private void drawBorder(Canvas canvas, RectF rectF) {
        if (!hasBorder()) {
            return;
        }
        float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
        canvas.drawRoundRect(rectF, min, min, this.mBorderPaint);
    }

    private void drawIconAndText(Canvas canvas) {
        if (this.mIconDrawable != null && !TextUtils.isEmpty(this.mText)) {
            float width = getWidth() * 0.5f;
            float height = getHeight() * 0.5f;
            float minHeight = getMinHeight() * 0.5f;
            float minWidth = 0.5f * getMinWidth();
            if (hasBorder()) {
                int i3 = this.mBorderWidth;
                drawBackground(canvas, width, height, height - i3, width - i3);
            } else {
                drawBackground(canvas, width, height, minHeight, minWidth);
            }
            int minHeight2 = getMinHeight();
            if (hasBorder()) {
                minHeight2 -= this.mBorderWidth * 2;
            }
            int height2 = getHeight();
            int h16 = (int) ((width - minWidth) + getResource().h());
            if (hasBorder()) {
                h16 += this.mBorderWidth;
            }
            int i16 = (height2 - minHeight2) / 2;
            if (hasBorder()) {
                i16 = (((getHeight() - (this.mBorderWidth * 2)) - minHeight2) / 2) + this.mBorderWidth;
            }
            Drawable drawable = this.mIconDrawable;
            drawable.setBounds(h16, i16, h16 + minHeight2, minHeight2 + i16);
            drawable.draw(canvas);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            float f16 = fontMetrics.bottom;
            canvas.drawText(this.mText, (int) (r1 + getResource().j() + (this.mTextPaint.measureText(this.mText) / 2.0f)), ((height - f16) + ((f16 - fontMetrics.top) / 2.0f)) - fontYOffset(), this.mTextPaint);
            if (hasBorder()) {
                float f17 = this.mBorderWidth / 2.0f;
                drawBorder(canvas, new RectF(f17, f17, getWidth() - f17, getHeight() - f17));
                return;
            }
            return;
        }
        d.k(TAG, d.f438811e, "[onDraw] err: viewType=" + this.mViewType + ", text=" + this.mText);
    }

    private void fixDragType() {
        if (this.mViewType == 6 && this.mDragType != -1) {
            this.mDragType = -1;
        }
    }

    private static int fontYOffset() {
        return e.a(0.5f);
    }

    private void initGestureDetector(Context context) {
        this.mGestureDetector = new GestureDetector(context, new a(), this.mHandler);
    }

    private static void initPadding(Context context) {
        if (sPadding == 0) {
            float f16 = context.getResources().getDisplayMetrics().density * 16.0f;
            sPadding = (int) f16;
            sOnePointFivePadding = (int) (1.5f * f16);
            sZeroPointFivePadding = (int) (f16 * 0.5f);
        }
    }

    private void initPaint() {
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(getResource().n());
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTypeface(getResource().o());
        this.mBgPaint.setAntiAlias(true);
        this.mBgPaint.setColor(getResource().g());
        this.mBgPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        reloadBorderPaint();
    }

    private boolean isSupportCustomViewType() {
        int i3 = this.mViewType;
        if (i3 != 0 && i3 != 1 && i3 != 6) {
            return true;
        }
        return false;
    }

    private void reloadBorderColor() {
        if (this.mBorderColorToken == null) {
            return;
        }
        try {
            this.mBorderColor = getResources().getColor(this.mBorderColorToken.intValue());
            reloadBorderPaint();
        } catch (Exception e16) {
            d.a(TAG, d.f438811e, "reloadBorderColor error\uff0c" + e16.getMessage());
        }
    }

    private void reloadBorderPaint() {
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setColor(this.mBorderColor);
    }

    private void resetValue() {
        this.mText = null;
        this.mNum = 0;
        this.mIconDrawable = null;
    }

    private void setPaintColorAndValidate() {
        int n3;
        int g16;
        int l3;
        getResource().q(this.mViewType);
        int i3 = this.mViewType;
        if (i3 != 4 && i3 != 5) {
            this.mTextPaint.setFakeBoldText(false);
            Paint paint = this.mTextPaint;
            if (this.mViewType == 9) {
                l3 = getResource().f();
            } else {
                l3 = getResource().l();
            }
            paint.setTextSize(l3);
        } else {
            this.mTextPaint.setTextSize(getResource().i());
            this.mTextPaint.setFakeBoldText(true);
        }
        if (isSupportCustomViewType()) {
            Paint paint2 = this.mTextPaint;
            Integer num = this.mCustomTextColor;
            if (num != null) {
                n3 = num.intValue();
            } else {
                n3 = getResource().n();
            }
            paint2.setColor(n3);
            Paint paint3 = this.mBgPaint;
            if (this.mCustomBgDrawable != null) {
                g16 = -1;
            } else {
                g16 = getResource().g();
            }
            paint3.setColor(g16);
            Integer num2 = this.mCustomTextColor;
            if (num2 != null) {
                d.a(TAG, d.f438811e, String.format("current use custom text color: #%06X", Integer.valueOf(num2.intValue() & 16777215)));
            }
            if (this.mCustomBgDrawable != null) {
                d.a(TAG, d.f438811e, "use custom bg drawable.");
            }
        } else {
            this.mTextPaint.setColor(getResource().n());
            this.mBgPaint.setColor(getResource().g());
        }
        reloadBorderColor();
        requestLayout();
        postInvalidate();
    }

    private void updateNum(int i3) {
        this.mNum = i3;
        if (i3 > 99) {
            this.mText = "99+";
        } else {
            this.mText = String.valueOf(i3);
        }
    }

    public void clearBorder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            setBorder(0, 0);
        }
    }

    protected void drawDot(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) canvas);
            return;
        }
        float width = getWidth() * 0.5f;
        float height = getHeight() * 0.5f;
        canvas.drawCircle(width, height, e.a(10.0f) * 0.5f, this.mBgPaint);
        if (hasBorder()) {
            float f16 = this.mBorderWidth / 2.0f;
            float minHeight = getMinHeight() * 0.5f;
            float minWidth = getMinWidth() * 0.5f;
            drawBorder(canvas, new RectF((width - minWidth) + f16, (height - minHeight) + f16, (width + minWidth) - f16, (height + minHeight) - f16));
        }
    }

    protected void drawIcon(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) canvas);
            return;
        }
        if (this.mIconDrawable == null) {
            d.k(TAG, d.f438811e, "[onDraw] draw icon, but icon is null");
            return;
        }
        int minWidth = getMinWidth();
        if (hasBorder()) {
            minWidth -= this.mBorderWidth * 2;
        }
        int minHeight = getMinHeight();
        if (hasBorder()) {
            minHeight -= this.mBorderWidth * 2;
        }
        int width = (getWidth() - minWidth) / 2;
        if (hasBorder()) {
            width = this.mBorderWidth + (((getWidth() - (this.mBorderWidth * 2)) - minWidth) / 2);
        }
        int height = (getHeight() - minHeight) / 2;
        if (hasBorder()) {
            height = this.mBorderWidth + (((getHeight() - (this.mBorderWidth * 2)) - minHeight) / 2);
        }
        Drawable drawable = this.mIconDrawable;
        drawable.setBounds(width, height, minWidth + width, minHeight + height);
        drawable.draw(canvas);
        if (hasBorder()) {
            float f16 = this.mBorderWidth / 2.0f;
            drawBorder(canvas, new RectF(f16, f16, getWidth() - f16, getHeight() - f16));
        }
    }

    protected void drawText(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) canvas);
            return;
        }
        if (TextUtils.isEmpty(this.mText)) {
            d.k(TAG, d.f438811e, "[onDraw] err: viewType=" + this.mViewType + ", text=" + this.mText);
            return;
        }
        float width = getWidth() * 0.5f;
        float height = getHeight() * 0.5f;
        float minHeight = getMinHeight() * 0.5f;
        float minWidth = getMinWidth() * 0.5f;
        if (hasBorder()) {
            int i3 = this.mBorderWidth;
            drawBackground(canvas, width, height, height - i3, width - i3);
        } else {
            drawBackground(canvas, width, height, minHeight, minWidth);
        }
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float f16 = fontMetrics.bottom;
        canvas.drawText(this.mText, width, ((height - f16) + ((f16 - fontMetrics.top) / 2.0f)) - fontYOffset(), this.mTextPaint);
        if (hasBorder()) {
            float f17 = this.mBorderWidth / 2.0f;
            drawBorder(canvas, new RectF(f17, f17, getWidth() - f17, getHeight() - f17));
        }
    }

    protected int fixSizeForBorderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, i3)).intValue();
        }
        if (hasBorder()) {
            return i3 + (this.mBorderWidth * 2);
        }
        return i3;
    }

    public String getDragGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mDragGroup;
    }

    public int getDragType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mDragType;
    }

    protected void getExtendHitRect(View view, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) view, (Object) rect);
            return;
        }
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        super.getGlobalVisibleRect(rect);
        if (this.mDragType == 2) {
            rect.top = (rect.top - rect2.top) - sPadding;
            int i3 = rect.left - rect2.left;
            int i16 = sZeroPointFivePadding;
            rect.left = i3 - i16;
            rect.bottom = (rect.bottom - rect2.top) + i16;
        } else {
            int i17 = rect.top - rect2.top;
            int i18 = sOnePointFivePadding;
            rect.top = i17 - i18;
            rect.left = (rect.left - rect2.left) - i18;
            rect.bottom = (rect.bottom - rect2.top) + sPadding;
        }
        rect.right = (rect.right - rect2.left) + sPadding;
    }

    protected int getMinHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int i3 = this.mViewType;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 9) {
                return fixSizeForBorderWidth(e.a(18.0f));
            }
            return fixSizeForBorderWidth(e.a(24.0f));
        }
        return fixSizeForBorderWidth(e.a(10.0f));
    }

    protected int getMinWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        int i3 = 18;
        switch (this.mViewType) {
            case 0:
            case 1:
                i3 = 10;
                break;
            case 2:
            case 3:
                int i16 = this.mNum;
                if (i16 > 99) {
                    i3 = 31;
                    break;
                } else if (i16 > 9) {
                    i3 = 23;
                    break;
                }
                break;
            case 4:
            case 5:
                return fixSizeForBorderWidth(Math.max(((int) this.mTextPaint.measureText(this.mText)) + (getResource().h() * 2), e.a(18)));
            case 7:
            case 8:
                return fixSizeForBorderWidth(((int) this.mTextPaint.measureText(this.mText)) + (getResource().h() * 2) + getResource().j() + e.a(18));
            case 9:
                return fixSizeForBorderWidth(Math.max(((int) this.mTextPaint.measureText(this.mText)) + (getResource().h() * 2), e.a(24.0f)));
        }
        return fixSizeForBorderWidth(e.a(i3));
    }

    public com.tencent.mobileqq.quibadge.b getOnModeChangeListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.quibadge.b) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mOnWillEnterShadowModeListener;
    }

    @NonNull
    protected com.tencent.mobileqq.quibadge.res.a getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.quibadge.res.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.mobileqq.quibadge.res.a aVar = this.mRes;
        if (aVar == null) {
            com.tencent.mobileqq.quibadge.res.a aVar2 = new com.tencent.mobileqq.quibadge.res.a(getContext());
            this.mRes = aVar2;
            return aVar2;
        }
        return aVar;
    }

    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return this.mViewType;
    }

    public boolean hasBorder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.mBorderWidth > 0) {
            return true;
        }
        return false;
    }

    public boolean hasContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        switch (this.mViewType) {
            case 0:
            case 1:
                return true;
            case 2:
            case 3:
            case 9:
                if (this.mNum <= 0) {
                    return false;
                }
                return true;
            case 4:
            case 5:
                return !TextUtils.isEmpty(this.mText);
            case 6:
                if (this.mIconDrawable == null) {
                    return false;
                }
                return true;
            case 7:
            case 8:
                if (this.mIconDrawable == null || this.mNum <= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) canvas);
            return;
        }
        switch (this.mViewType) {
            case 0:
            case 1:
                drawDot(canvas);
                return;
            case 2:
            case 3:
            case 9:
                if (this.mNum <= 0) {
                    d.k(TAG, d.f438811e, "[onDraw] err: viewType=" + this.mViewType + ", mNum=" + this.mNum);
                    return;
                }
                drawText(canvas);
                return;
            case 4:
            case 5:
                drawText(canvas);
                return;
            case 6:
                drawIcon(canvas);
                return;
            case 7:
            case 8:
                drawIconAndText(canvas);
                return;
            default:
                d.k(TAG, d.f438811e, "[onDraw] not supported viewType=" + this.mViewType);
                return;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        Rect rect = this.mDelegateRect;
        if (rect != null && z16) {
            getExtendHitRect(this.mContainer, rect);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int minWidth = getMinWidth();
        int minHeight = getMinHeight();
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 1073741824) {
            minWidth = size;
        } else if (mode == Integer.MIN_VALUE) {
            minWidth = Math.min(minWidth, size);
        }
        if (mode2 == 1073741824) {
            minHeight = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            minHeight = Math.min(minHeight, size2);
        }
        setMeasuredDimension(Math.max(minWidth, getMinimumWidth()), Math.max(minHeight, getMinimumHeight()));
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
        } else {
            this.mRes.p();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            fixDragType();
        }
        if (this.mOnDoubleTapListener != null) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        int i3 = this.mDragType;
        if (i3 != -1 && i3 != 3 && !this.mIsShadow && motionEvent.getAction() == 0) {
            if (this.mOnWillEnterShadowModeListener != null) {
                if (d.i()) {
                    d.a(TAG, d.f438809c, "onTouchEvent hit: " + motionEvent + "; cur Rect:" + this.mDelegateRect);
                }
                this.mIsShadow = true;
                this.mOnWillEnterShadowModeListener.onModeChanged(this, this.mDragType, this.mViewType, this.mDragGroup);
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAIOBarNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3);
            return;
        }
        resetValue();
        updateNum(i3);
        this.mViewType = 9;
        setPaintColorAndValidate();
    }

    public void setBorder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mBorderWidth = Math.max(i3, 0);
        this.mBorderColor = i16;
        this.mBorderColorToken = null;
        reloadBorderPaint();
        setPaintColorAndValidate();
    }

    public void setBorderForToken(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mBorderWidth = Math.max(i3, 0);
        this.mBorderColorToken = Integer.valueOf(i16);
        reloadBorderColor();
        reloadBorderPaint();
        setPaintColorAndValidate();
    }

    public void setDragGroup(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mDragGroup = str;
        }
    }

    public void setDragType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            setDragType(i3, null);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void setFixMinSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        int a16 = e.a(18.0f);
        setMinimumHeight(a16);
        setMinimumWidth(a16);
    }

    public void setGrayDot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        resetValue();
        this.mViewType = 1;
        setPaintColorAndValidate();
    }

    public void setGrayNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        resetValue();
        updateNum(i3);
        this.mViewType = 3;
        setPaintColorAndValidate();
    }

    public void setGrayNumWIthIcon(int i3, @NonNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3, (Object) drawable);
            return;
        }
        resetValue();
        updateNum(i3);
        this.mIconDrawable = drawable;
        this.mViewType = 8;
        setPaintColorAndValidate();
    }

    public void setGrayText(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
            return;
        }
        resetValue();
        if (str.length() > 3) {
            str = str.substring(0, 3);
        }
        this.mText = str;
        this.mViewType = 5;
        setPaintColorAndValidate();
    }

    public void setIcon(@NonNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) drawable);
            return;
        }
        resetValue();
        this.mIconDrawable = drawable;
        this.mViewType = 6;
        this.mDragType = -1;
        setPaintColorAndValidate();
    }

    public void setOnDoubleTapListener(@Nullable GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onDoubleTapListener);
        } else {
            this.mOnDoubleTapListener = onDoubleTapListener;
        }
    }

    public void setOnModeChangeListener(@Nullable com.tencent.mobileqq.quibadge.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
            return;
        }
        this.mOnWillEnterShadowModeListener = bVar;
        if (d.h()) {
            d.a(TAG, d.f438810d, "setOnModeChangeListener:" + bVar);
        }
        if (this.mOnWillEnterShadowModeListener != null && this.mContainer != null && this.mDelegateRect == null) {
            this.mDelegateRect = new Rect();
            this.mContainer.setTouchDelegate(new b(this.mDelegateRect, this));
        }
    }

    public void setRedDot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        resetValue();
        this.mViewType = 0;
        setPaintColorAndValidate();
    }

    public void setRedNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        resetValue();
        updateNum(i3);
        this.mViewType = 2;
        setPaintColorAndValidate();
    }

    public void setRedNumWithIcon(int i3, @NonNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3, (Object) drawable);
            return;
        }
        resetValue();
        updateNum(i3);
        this.mIconDrawable = drawable;
        this.mViewType = 7;
        setPaintColorAndValidate();
    }

    public void setRedText(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        resetValue();
        if (str.length() > 3) {
            str = str.substring(0, 3);
        }
        this.mText = str;
        this.mViewType = 4;
        setPaintColorAndValidate();
    }

    public void setTextColorUseCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, z16);
        } else {
            getResource().r(z16);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        super.setVisibility(i3);
        if (this.mIsShadow && i3 == 0) {
            this.mIsShadow = false;
        }
    }

    @Override // com.tencent.mobileqq.quibadge.a
    public void updateCustomStyle(@Nullable Integer num, @Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) num, (Object) drawable);
            return;
        }
        this.mCustomTextColor = num;
        this.mCustomBgDrawable = drawable;
        setPaintColorAndValidate();
    }

    public void updateResource(@NonNull com.tencent.mobileqq.quibadge.res.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) aVar);
        } else {
            this.mRes = aVar;
            postInvalidate();
        }
    }

    public QUIBadge(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void setDragType(int i3, @Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) view);
            return;
        }
        this.mDragType = i3;
        this.mContainer = view;
        if (view == null) {
            this.mContainer = (ViewGroup) getParent();
        }
        if (this.mOnWillEnterShadowModeListener == null || this.mContainer == null || this.mDelegateRect != null) {
            return;
        }
        this.mDelegateRect = new Rect();
        this.mContainer.setTouchDelegate(new b(this.mDelegateRect, this));
    }

    public QUIBadge(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mDragType = -1;
        this.mViewType = 0;
        this.mNum = 0;
        this.mText = null;
        this.mIconDrawable = null;
        this.mTextPaint = new Paint();
        this.mBgPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCustomTextColor = null;
        this.mCustomBgDrawable = null;
        this.mRes = null;
        this.mBorderWidth = 0;
        this.mBorderColor = 0;
        this.mBorderColorToken = null;
        this.mDelegateRect = null;
        this.mContainer = null;
        this.mHandler = new Handler(Looper.getMainLooper());
        initPadding(context);
        initGestureDetector(context);
        initPaint();
    }
}
