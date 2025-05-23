package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CustomButton {
    private static final String TAG = "CustomButton";
    private Context mContext;
    private ImageButton mImageButton;
    private ButtonParam mParams;
    private Button mTextButton;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ButtonParam {
        public static final String TYPE_IMAGE = "image";
        public static final String TYPE_TEXT = "text";
        public long componentId;
        public String image;
        public String lang;
        public String openId;
        public ButtonStyle style;
        public String text;
        public String type;
        public boolean withCredentials;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ButtonStyle {
        static final String TEXT_ALIGN_CENTER = "center";
        static final String TEXT_ALIGN_LEFT = "left";
        static final String TEXT_ALIGN_RIGHT = "right";
        public String backgroundColor;
        public String borderColor;
        public int borderRadius;
        public int borderWidth;
        public String color;
        public int fontSize;
        public int height;
        public int left;
        public int lineHeight;
        public String textAlign;
        public int top;
        public int width;
    }

    public CustomButton(Context context) {
        this.mContext = context;
    }

    private Drawable getBackgroundDrawable(int i3, int i16, int i17, float f16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setStroke(i16, i17);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f16);
        return gradientDrawable;
    }

    private void setImageButton(ButtonParam buttonParam) {
        int parseColor;
        if (this.mImageButton != null && buttonParam != null) {
            ButtonStyle buttonStyle = buttonParam.style;
            if (buttonStyle != null) {
                if (!TextUtils.isEmpty(buttonStyle.borderColor)) {
                    try {
                        parseColor = Color.parseColor(buttonParam.style.borderColor);
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "setmImageButton strokeColor error ", th5);
                    }
                    this.mImageButton.setBackground(getBackgroundDrawable(0, buttonParam.style.borderWidth, parseColor, r3.borderRadius));
                    ImageButton imageButton = this.mImageButton;
                    int i3 = buttonParam.style.borderWidth;
                    imageButton.setPadding(i3, i3, i3, i3);
                }
                parseColor = 0;
                this.mImageButton.setBackground(getBackgroundDrawable(0, buttonParam.style.borderWidth, parseColor, r3.borderRadius));
                ImageButton imageButton2 = this.mImageButton;
                int i36 = buttonParam.style.borderWidth;
                imageButton2.setPadding(i36, i36, i36, i36);
            }
            this.mImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    private void setTextAlign(ButtonParam buttonParam) {
        if ("left".equals(buttonParam.style.textAlign)) {
            this.mTextButton.setGravity(8388611);
        } else if ("center".equals(buttonParam.style.textAlign)) {
            this.mTextButton.setGravity(1);
        } else if ("right".equals(buttonParam.style.textAlign)) {
            this.mTextButton.setGravity(8388613);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setTextButton(ButtonParam buttonParam) {
        int parseColor;
        int parseColor2;
        int i3;
        int i16;
        Button button = this.mTextButton;
        if (button != null && buttonParam != null) {
            button.setText(buttonParam.text);
            this.mTextButton.setPadding(0, 0, 0, 0);
            ButtonStyle buttonStyle = buttonParam.style;
            if (buttonStyle != null) {
                if (!TextUtils.isEmpty(buttonStyle.backgroundColor)) {
                    try {
                        parseColor = ColorUtils.parseColor(buttonParam.style.backgroundColor);
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "setmTextButton bgColor error ", th5);
                    }
                    if (!TextUtils.isEmpty(buttonParam.style.borderColor)) {
                        try {
                            parseColor2 = ColorUtils.parseColor(buttonParam.style.borderColor);
                        } catch (Throwable th6) {
                            QMLog.e(TAG, "setmTextButton strokeColor error ", th6);
                        }
                        this.mTextButton.setBackground(getBackgroundDrawable(parseColor, buttonParam.style.borderWidth, parseColor2, r5.borderRadius));
                        if (!TextUtils.isEmpty(buttonParam.style.color)) {
                            try {
                                i3 = ColorUtils.parseColor(buttonParam.style.color);
                            } catch (Throwable th7) {
                                QMLog.e(TAG, "setmTextButton textColor error ", th7);
                                i3 = -16777216;
                            }
                            this.mTextButton.setTextColor(i3);
                        }
                        setTextAlign(buttonParam);
                        i16 = buttonParam.style.fontSize;
                        if (i16 > 0) {
                            this.mTextButton.setTextSize(i16);
                        }
                        if (buttonParam.style.lineHeight >= 0) {
                            int fontMetricsInt = buttonParam.style.lineHeight - this.mTextButton.getPaint().getFontMetricsInt(null);
                            this.mTextButton.setLineSpacing(fontMetricsInt, 1.0f);
                            this.mTextButton.setPadding(0, fontMetricsInt / 2, 0, 0);
                            return;
                        }
                        return;
                    }
                    parseColor2 = 0;
                    this.mTextButton.setBackground(getBackgroundDrawable(parseColor, buttonParam.style.borderWidth, parseColor2, r5.borderRadius));
                    if (!TextUtils.isEmpty(buttonParam.style.color)) {
                    }
                    setTextAlign(buttonParam);
                    i16 = buttonParam.style.fontSize;
                    if (i16 > 0) {
                    }
                    if (buttonParam.style.lineHeight >= 0) {
                    }
                }
                parseColor = 0;
                if (!TextUtils.isEmpty(buttonParam.style.borderColor)) {
                }
                parseColor2 = 0;
                this.mTextButton.setBackground(getBackgroundDrawable(parseColor, buttonParam.style.borderWidth, parseColor2, r5.borderRadius));
                if (!TextUtils.isEmpty(buttonParam.style.color)) {
                }
                setTextAlign(buttonParam);
                i16 = buttonParam.style.fontSize;
                if (i16 > 0) {
                }
                if (buttonParam.style.lineHeight >= 0) {
                }
            }
        }
    }

    public void destroy() {
        this.mContext = null;
        this.mImageButton = null;
        this.mTextButton = null;
    }

    public View getButton() {
        Button button = this.mTextButton;
        if (button != null) {
            return button;
        }
        ImageButton imageButton = this.mImageButton;
        if (imageButton != null) {
            return imageButton;
        }
        return null;
    }

    public void setImageDrawable(Drawable drawable) {
        ImageButton imageButton = this.mImageButton;
        if (imageButton != null && drawable != null) {
            imageButton.setImageDrawable(drawable);
        }
    }

    public void setParam(ButtonParam buttonParam, View.OnClickListener onClickListener) {
        this.mParams = buttonParam;
        if (buttonParam != null) {
            if ("text".equals(buttonParam.type) && this.mTextButton == null) {
                Button button = new Button(this.mContext);
                this.mTextButton = button;
                button.setOnClickListener(onClickListener);
            } else if ("image".equals(this.mParams.type) && this.mImageButton == null) {
                ImageButton imageButton = new ImageButton(this.mContext);
                this.mImageButton = imageButton;
                imageButton.setOnClickListener(onClickListener);
            }
        }
        if (this.mTextButton != null) {
            setTextButton(this.mParams);
        } else if (this.mImageButton != null) {
            setImageButton(this.mParams);
        }
    }

    public void setVisible(boolean z16) {
        int i3;
        if (getButton() != null) {
            View button = getButton();
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            button.setVisibility(i3);
        }
    }
}
