package com.tenpay.sdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.widget.EditText;
import com.tenpay.api.QWalletUtils;
import java.util.List;

/* loaded from: classes27.dex */
public class SixPasswdDialogEditText extends EditText {
    protected static int COLOR_BLACK = -16777216;
    protected static int COLOR_GRAY = -2171170;
    protected static int PASSWD_LENGTH = 6;
    private int count;
    private boolean isShowAnim;
    private boolean isVipStyle;
    protected float mDensity;
    private int mErrorColor;
    protected int mHeight;
    protected int mInitPaddingBottom;
    protected int mInitPaddingLeft;
    protected int mInitPaddingRight;
    protected int mInitPaddingTop;
    protected String mInputText;
    protected boolean mIsSelfSet;
    protected Paint mPaintBackground;
    protected Paint mPaintForeground;
    protected OnPasswdInputListener mPasswdListener;
    protected float mRadius;
    protected int mSpace;
    protected int mWidth;
    private Bitmap passBg;
    private List<Bitmap> passIcons;

    public SixPasswdDialogEditText(Context context) {
        this(context, null);
        init(context, null);
    }

    private void handlePassIconSize(Canvas canvas, int i3) {
        this.count++;
        Bitmap bitmap = this.passIcons.get(i3);
        Matrix matrix = new Matrix();
        int i16 = this.count;
        matrix.postScale(i16 / 7.0f, i16 / 7.0f);
        canvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true), ((this.mSpace - r0.getWidth()) / 2) + (this.mSpace * i3), ((this.mHeight - r0.getHeight()) - (this.passBg.getHeight() / 2)) - 7, this.mPaintForeground);
        if (this.count == 7) {
            this.isShowAnim = false;
        }
    }

    public void clearErrorColor() {
        this.mErrorColor = 0;
        this.mInputText = "";
        postInvalidate();
    }

    protected void drawPassImg(Canvas canvas) {
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.mSpace = this.mWidth / PASSWD_LENGTH;
        int length = this.mInputText.length();
        for (int i3 = 0; i3 < 6; i3++) {
            Bitmap bitmap = this.passIcons.get(i3);
            canvas.drawBitmap(this.passBg, ((this.mSpace - r3.getWidth()) / 2) + (this.mSpace * i3), this.mHeight - this.passBg.getHeight(), this.mPaintForeground);
            if (i3 < length) {
                if (i3 == length - 1 && this.isShowAnim) {
                    handlePassIconSize(canvas, i3);
                } else if (!bitmap.isRecycled()) {
                    canvas.drawBitmap(bitmap, ((this.mSpace - bitmap.getWidth()) / 2) + (this.mSpace * i3), (this.mHeight - bitmap.getHeight()) - (this.passBg.getHeight() / 2), this.mPaintForeground);
                } else {
                    canvas.drawCircle((this.mSpace / 2.0f) + (r2 * i3), this.mHeight / 2.0f, this.mRadius, this.mPaintForeground);
                }
            }
        }
    }

    protected void drawPasswdDot(Canvas canvas) {
        int i3 = (int) (this.mDensity * 1.0f);
        if (i3 == 0) {
            i3 = 1;
        }
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.mSpace = this.mWidth / PASSWD_LENGTH;
        int length = this.mInputText.length();
        int i16 = this.mErrorColor;
        if (i16 != 0) {
            this.mPaintBackground.setColor(i16);
            this.mPaintForeground.setColor(this.mErrorColor);
        } else {
            this.mPaintBackground.setColor(Color.parseColor("#BBBBBB"));
            this.mPaintForeground.setColor(COLOR_BLACK);
        }
        for (int i17 = 1; i17 < PASSWD_LENGTH; i17++) {
            float f16 = this.mSpace * i17;
            canvas.drawLine(f16, i3, f16, this.mHeight - i3, this.mPaintBackground);
        }
        for (int i18 = 0; i18 < length; i18++) {
            canvas.drawCircle((this.mSpace / 2.0f) + (r1 * i18), this.mHeight / 2.0f, this.mRadius, this.mPaintForeground);
        }
    }

    public String getInputText() {
        return this.mInputText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(Context context, AttributeSet attributeSet) {
        setContentDescription("\u652f\u4ed8\u5bc6\u7801");
        QWalletUtils.hideSysKeyBorad(this);
        this.mInputText = "";
        float f16 = getResources().getDisplayMetrics().density;
        this.mDensity = f16;
        this.mRadius = (PASSWD_LENGTH + 1) * f16;
        this.mInitPaddingLeft = getPaddingLeft();
        this.mInitPaddingTop = getPaddingTop();
        this.mInitPaddingRight = getPaddingRight();
        this.mInitPaddingBottom = getPaddingBottom();
        Paint paint = new Paint(1);
        this.mPaintBackground = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaintBackground.setColor(Color.parseColor("#BBBBBB"));
        Paint paint2 = new Paint(1);
        this.mPaintForeground = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mPaintForeground.setColor(COLOR_BLACK);
        setCursorVisible(false);
        setPadding(0, this.mInitPaddingTop, 0, this.mInitPaddingBottom);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onCreateContextMenu(ContextMenu contextMenu) {
        super.onCreateContextMenu(contextMenu);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.isVipStyle) {
            drawPasswdDot(canvas);
        } else {
            drawPassImg(canvas);
            postInvalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        String str;
        int length;
        if (i3 == 67 && (str = this.mInputText) != null && (length = str.length()) > 0) {
            this.mInputText = this.mInputText.substring(0, length - 1);
            OnPasswdInputListener onPasswdInputListener = this.mPasswdListener;
            if (onPasswdInputListener != null) {
                onPasswdInputListener.onTextChange();
            }
        }
        postInvalidate();
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        if (this.mInputText == null) {
            this.mInputText = "";
        }
        if (!this.mIsSelfSet) {
            if (this.mInputText.length() < PASSWD_LENGTH) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.mInputText += ((Object) charSequence);
                }
                OnPasswdInputListener onPasswdInputListener = this.mPasswdListener;
                if (onPasswdInputListener != null) {
                    onPasswdInputListener.onTextChange();
                }
            }
            this.mIsSelfSet = true;
            setText("");
        } else {
            this.mIsSelfSet = false;
        }
        this.count = 0;
        this.isShowAnim = true;
        postInvalidate();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        return true;
    }

    public void setErrorColor(int i3) {
        this.mErrorColor = i3;
        postInvalidate();
    }

    public void setInputText(String str) {
        if (str != null) {
            this.mInputText = str;
            OnPasswdInputListener onPasswdInputListener = this.mPasswdListener;
            if (onPasswdInputListener != null) {
                onPasswdInputListener.onTextChange();
            }
        }
        postInvalidate();
    }

    public void setOnPasswdInputListener(OnPasswdInputListener onPasswdInputListener) {
        this.mPasswdListener = onPasswdInputListener;
    }

    public void setVipStyle(List<Bitmap> list, Bitmap bitmap) {
        this.isVipStyle = true;
        this.passIcons = list;
        this.passBg = bitmap;
    }

    public SixPasswdDialogEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInputText = "";
        this.count = 0;
        this.isShowAnim = false;
        init(context, attributeSet);
    }
}
