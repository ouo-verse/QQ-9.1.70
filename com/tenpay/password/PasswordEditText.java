package com.tenpay.password;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tenpay.sdk.view.SixPasswdDialogEditText;

/* loaded from: classes27.dex */
public class PasswordEditText extends SixPasswdDialogEditText {
    private static final int DIV_PX = ViewUtils.dpToPx(11.0f);
    private int mDivider;
    private int mRectRadius;

    public PasswordEditText(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawPasswdDot(canvas);
    }

    @Override // com.tenpay.sdk.view.SixPasswdDialogEditText
    protected void drawPasswdDot(Canvas canvas) {
        int width = getWidth();
        this.mWidth = width;
        int i3 = SixPasswdDialogEditText.PASSWD_LENGTH;
        int i16 = DIV_PX;
        this.mSpace = (width - ((i3 - 1) * i16)) / i3;
        int dpToPx = ViewUtils.dpToPx(50.0f);
        if (this.mSpace > dpToPx) {
            this.mSpace = dpToPx;
            int i17 = this.mWidth;
            int i18 = SixPasswdDialogEditText.PASSWD_LENGTH;
            this.mDivider = (i17 - (dpToPx * i18)) / (i18 - 1);
        } else {
            this.mDivider = i16;
        }
        setHeight(this.mSpace);
        for (int i19 = 0; i19 < SixPasswdDialogEditText.PASSWD_LENGTH; i19++) {
            int i26 = this.mSpace;
            float f16 = (i19 * i26) + (this.mDivider * i19);
            float f17 = f16 + i26;
            float f18 = i26;
            int i27 = this.mRectRadius;
            canvas.drawRoundRect(f16, 0.0f, f17, f18, i27, i27, this.mPaintBackground);
        }
        for (int i28 = 0; i28 < this.mInputText.length(); i28++) {
            int i29 = this.mSpace;
            canvas.drawCircle(((i28 + 0.5f) * i29) + (this.mDivider * i28), i29 * 0.5f, this.mRadius, this.mPaintForeground);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.view.SixPasswdDialogEditText
    public void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        this.mPaintBackground.setColor(-1184275);
        this.mPaintForeground.setColor(DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK);
        this.mDivider = DIV_PX;
        this.mRadius = ViewUtils.dpToPx(6.0f);
        this.mRectRadius = ViewUtils.dpToPx(5.0f);
    }

    public PasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
