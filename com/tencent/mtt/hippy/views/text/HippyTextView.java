package com.tencent.mtt.hippy.views.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.dom.node.HippyForegroundColorSpan;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.dom.node.b;
import com.tencent.mtt.hippy.dom.node.f;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.mtt.hippy.views.list.HippyRecycler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyTextView extends View implements HippyViewBase, CommonBorder, HippyRecycler {
    private CommonBackgroundDrawable mBGDrawable;
    private NativeGestureDispatcher mGestureDispatcher;
    private boolean mHasSetNativeTextColor;
    protected Layout mLayout;
    private boolean mNativeGestureEnable;
    private f mNativeGestureSpan;
    private int mNativeTextColor;
    private boolean mTextBold;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.views.text.HippyTextView$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            $SwitchMap$android$text$Layout$Alignment = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HippyTextView(Context context) {
        super(context);
        this.mNativeGestureEnable = false;
        this.mLayout = null;
        this.mTextBold = false;
        this.mNativeTextColor = 0;
        this.mHasSetNativeTextColor = false;
    }

    private f findNativeGestureSpanForTouch(MotionEvent motionEvent) {
        int i3;
        f fVar = null;
        if (this.mLayout == null) {
            return null;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int i16 = AnonymousClass1.$SwitchMap$android$text$Layout$Alignment[this.mLayout.getAlignment().ordinal()];
        if (i16 != 1) {
            if (i16 == 2) {
                x16 -= (getWidth() - getPaddingRight()) - this.mLayout.getWidth();
            }
        } else {
            int height = ((getHeight() + getPaddingTop()) + getPaddingBottom()) - this.mLayout.getHeight();
            x16 -= (getWidth() - this.mLayout.getWidth()) / 2;
            y16 -= height / 2;
        }
        Layout layout = this.mLayout;
        int lineForVertical = layout.getLineForVertical(y16);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        CharSequence text = layout.getText();
        boolean z16 = text instanceof Spanned;
        if (z16 && x16 >= lineLeft && x16 <= lineRight) {
            Spanned spanned = (Spanned) text;
            int offsetForHorizontal = this.mLayout.getOffsetForHorizontal(lineForVertical, x16);
            f[] fVarArr = (f[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, f.class);
            if (fVarArr != null && fVarArr.length > 0) {
                int length = text.length();
                for (f fVar2 : fVarArr) {
                    int spanStart = spanned.getSpanStart(fVar2);
                    int spanEnd = spanned.getSpanEnd(fVar2);
                    if (spanEnd > offsetForHorizontal && (i3 = spanEnd - spanStart) <= length) {
                        fVar = fVar2;
                        length = i3;
                    }
                }
            }
        }
        if (fVar == null && z16) {
            Spanned spanned2 = (Spanned) text;
            f[] fVarArr2 = (f[]) spanned2.getSpans(0, spanned2.length(), f.class);
            if (fVarArr2.length == 1) {
                AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spanned2.getSpans(0, spanned2.length(), AbsoluteSizeSpan.class);
                if (!fVarArr2[0].a() && absoluteSizeSpanArr.length == 1) {
                    return fVarArr2[0];
                }
                return fVar;
            }
            return fVar;
        }
        return fVar;
    }

    private CommonBackgroundDrawable getBackGround() {
        if (this.mBGDrawable == null) {
            this.mBGDrawable = new CommonBackgroundDrawable();
            Drawable background = getBackground();
            super.setBackgroundDrawable(null);
            if (background == null) {
                super.setBackgroundDrawable(this.mBGDrawable);
            } else {
                super.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mBGDrawable, background}));
            }
        }
        return this.mBGDrawable;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyRecycler
    public void clear() {
        this.mLayout = null;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mNativeGestureEnable) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.mNativeGestureSpan = findNativeGestureSpanForTouch(motionEvent);
        }
        f fVar = this.mNativeGestureSpan;
        if (fVar != null) {
            if (fVar.b(this, motionEvent)) {
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.mGestureDispatcher;
    }

    public String getText() {
        Layout layout = this.mLayout;
        if (layout != null && layout.getText() != null) {
            return this.mLayout.getText().toString();
        }
        return "";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        HippyExceptionHandlerAdapter exceptionHandler;
        try {
            super.onDraw(canvas);
            if (this.mLayout != null) {
                LogUtils.d("HippyText", "id: " + getId() + " mExtra : " + ((Object) this.mLayout.getText()) + "layout : w:" + this.mLayout.getWidth() + " h:" + this.mLayout.getHeight() + " view : w:" + getWidth() + " h:" + getHeight() + " textColor:" + this.mLayout.getPaint().getColor());
                canvas.save();
                int i3 = AnonymousClass1.$SwitchMap$android$text$Layout$Alignment[this.mLayout.getAlignment().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        canvas.translate(getPaddingLeft(), getPaddingTop());
                    } else {
                        canvas.translate((getWidth() - getPaddingRight()) - this.mLayout.getWidth(), 0.0f);
                    }
                } else {
                    canvas.translate((getWidth() - this.mLayout.getWidth()) / 2, (((getHeight() + getPaddingTop()) + getPaddingBottom()) - this.mLayout.getHeight()) / 2.0f);
                }
                TextPaint paint = this.mLayout.getPaint();
                if (paint != null) {
                    paint.setFakeBoldText(this.mTextBold);
                }
                this.mLayout.draw(canvas);
                canvas.restore();
                return;
            }
            LogUtils.d("HippyText", "id: " + getId() + " mExtra :  is  null ");
        } catch (Throwable th5) {
            Context context = getContext();
            if ((context instanceof HippyInstanceContext) && (exceptionHandler = ((HippyInstanceContext) context).getEngineContext().getGlobalConfigs().getExceptionHandler()) != null) {
                exceptionHandler.handleNativeException(new RuntimeException("hippyTextView onDraw" + th5.getMessage()), true);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        f fVar = this.mNativeGestureSpan;
        if (fVar != null) {
            return onTouchEvent | fVar.a(this, motionEvent);
        }
        return onTouchEvent;
    }

    public void resetProps() {
        setPadding(0, 0, 0, 0);
        this.mNativeGestureEnable = false;
        this.mBGDrawable = null;
        setBackgroundDrawable(null);
        this.mTextBold = false;
        this.mGestureDispatcher = null;
        this.mNativeGestureSpan = null;
        this.mNativeTextColor = 0;
        this.mHasSetNativeTextColor = false;
        this.mLayout = null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        getBackGround().setBackgroundColor(i3);
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderColor(int i3, int i16) {
        getBackGround().setBorderColor(i3, i16);
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderRadius(float f16, int i3) {
        getBackGround().setBorderRadius(f16, i3);
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderWidth(float f16, int i3) {
        getBackGround().setBorderWidth(f16, i3);
    }

    public void setCustomColor(int i3) {
        this.mHasSetNativeTextColor = true;
        this.mNativeTextColor = i3;
        setTextColor(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.mGestureDispatcher = nativeGestureDispatcher;
    }

    @Override // android.view.View
    public void setId(int i3) {
        HippyEngineContext engineContext;
        super.setId(i3);
        Context context = getContext();
        if ((context instanceof HippyInstanceContext) && (engineContext = ((HippyInstanceContext) context).getEngineContext()) != null) {
            b c16 = engineContext.getDomManager().c(i3);
            if (c16 instanceof TextNode) {
                ((TextNode) c16).setTextView(this);
            }
        }
    }

    public void setLayout(Layout layout) {
        int i3;
        if (this.mLayout != null) {
            invalidate();
        }
        this.mLayout = layout;
        if (this.mHasSetNativeTextColor && (i3 = this.mNativeTextColor) != 0) {
            setTextColor(i3);
        }
    }

    public void setNativeGestureEnable(boolean z16) {
        this.mNativeGestureEnable = z16;
    }

    public void setTextBold(boolean z16) {
        this.mTextBold = z16;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextColor(int i3) {
        int i16;
        Layout layout = this.mLayout;
        if (layout != null && (layout.getText() instanceof Spannable)) {
            Spannable spannable = (Spannable) this.mLayout.getText();
            HippyForegroundColorSpan[] hippyForegroundColorSpanArr = (HippyForegroundColorSpan[]) spannable.getSpans(0, this.mLayout.getText().length(), HippyForegroundColorSpan.class);
            if (hippyForegroundColorSpanArr != null) {
                for (HippyForegroundColorSpan hippyForegroundColorSpan : hippyForegroundColorSpanArr) {
                    int spanStart = spannable.getSpanStart(hippyForegroundColorSpan);
                    int spanEnd = spannable.getSpanEnd(hippyForegroundColorSpan);
                    spannable.removeSpan(hippyForegroundColorSpan);
                    if (spanStart == 0) {
                        i16 = 18;
                    } else {
                        i16 = 34;
                    }
                    spannable.setSpan(new HippyForegroundColorSpan(i3, hippyForegroundColorSpan.a()), spanStart, spanEnd, i16);
                }
            }
            if (hippyForegroundColorSpanArr == null || hippyForegroundColorSpanArr.length == 0) {
                spannable.setSpan(new HippyForegroundColorSpan(i3, null), 0, spannable.toString().length(), 34);
            }
        }
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderStyle(int i3) {
    }
}
