package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.o;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QFormMultiLineItem extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private ImageView mArrowView;
    private int mBgType;
    private ImageView mHeaderView;
    private int mImageHeight;
    private int mImageWidth;
    private boolean mIsFreeForm;
    private int mLineNum;
    private ArrayList<QMultiImageTextView> mLines;
    private int mMarginBetweenPictureAndText;
    private int mMarginLeft;
    private int mMarginLine;
    private int mMarginRight;
    private boolean mUseCardUI;
    private int minHeight;

    public QFormMultiLineItem(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void initTypedArray(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.f410173q4);
        try {
            try {
                if (this.mLineNum < 0) {
                    this.mLineNum = obtainStyledAttributes.getInt(jj2.b.f410229v4, 2);
                }
                this.mImageWidth = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410208t4, 0);
                this.mImageHeight = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410197s4, 0);
                this.minHeight = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410239w4, 0);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158555is);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158556iu);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.f158553iq);
                this.mMarginLeft = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410219u4, dimensionPixelSize);
                this.mMarginRight = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410261y4, dimensionPixelSize2);
                this.mMarginBetweenPictureAndText = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410250x4, dimensionPixelSize3);
                this.mBgType = obtainStyledAttributes.getInteger(jj2.b.f410185r4, 0);
                this.mUseCardUI = obtainStyledAttributes.getBoolean(jj2.b.f410103k2, true);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FormMultiLineItem", 2, e16.toString());
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void initView() {
        int dimensionPixelSize;
        int i3 = this.mLineNum;
        if (i3 < 2 && i3 > 0) {
            throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158563j1);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.f158570j9);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.f158561iz);
        if (this.mLineNum == 2) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158548il);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158562j0);
        }
        this.mMarginLine = dimensionPixelSize4;
        setBackgroundDrawable(o.h(getResources(), this.mBgType, true, this.mUseCardUI));
        setMinimumHeight(this.minHeight);
        setPadding(this.mMarginLeft, 0, this.mMarginRight, 0);
        ImageView imageView = new ImageView(getContext());
        this.mHeaderView = imageView;
        imageView.setId(R.id.cjf);
        this.mHeaderView.setFocusable(false);
        this.mHeaderView.setClickable(false);
        this.mHeaderView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.mHeaderView);
        this.mLines = new ArrayList<>();
        QMultiImageTextView qMultiImageTextView = new QMultiImageTextView(getContext());
        qMultiImageTextView.setId(R.id.cjd);
        qMultiImageTextView.setTextSize(0, dimensionPixelSize2);
        qMultiImageTextView.setTextColor(getResources().getColor(R.color.skin_dark_gray));
        qMultiImageTextView.setSingleLine(true);
        qMultiImageTextView.setDuplicateParentStateEnabled(true);
        qMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
        qMultiImageTextView.setText(HardCodeUtil.qqStr(R.string.f171999mo3));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, R.id.cjf);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.leftMargin = this.mMarginBetweenPictureAndText;
        this.mLines.add(qMultiImageTextView);
        addView(qMultiImageTextView, layoutParams);
        for (int i16 = 1; i16 < this.mLineNum; i16++) {
            QMultiImageTextView qMultiImageTextView2 = new QMultiImageTextView(getContext());
            qMultiImageTextView2.setTextSize(0, dimensionPixelSize3);
            qMultiImageTextView2.setTextColor(getResources().getColor(R.color.skin_gray3));
            qMultiImageTextView2.setSingleLine(true);
            qMultiImageTextView2.setDuplicateParentStateEnabled(true);
            qMultiImageTextView2.setEllipsize(TextUtils.TruncateAt.END);
            qMultiImageTextView2.setText(HardCodeUtil.qqStr(R.string.mo5));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = this.mMarginBetweenPictureAndText;
            layoutParams2.addRule(1, R.id.cjf);
            if (i16 == 1) {
                qMultiImageTextView2.setId(R.id.cji);
            } else if (i16 == 2) {
                qMultiImageTextView2.setId(R.id.cjj);
            }
            if (i16 != this.mLineNum - 1) {
                layoutParams2.bottomMargin = dimensionPixelSize4;
            }
            addView(qMultiImageTextView2, layoutParams2);
            this.mLines.add(qMultiImageTextView2);
        }
    }

    private void setLineLayout(int i3, int i16, int i17) {
        for (int i18 = 0; i18 < this.mLineNum; i18++) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLines.get(i18).getLayoutParams();
            layoutParams.topMargin = i3;
            layoutParams.leftMargin = this.mMarginBetweenPictureAndText;
            i3 += this.mLines.get(i18).getMeasuredHeight();
            this.mLines.get(i18).setLayoutParams(layoutParams);
        }
    }

    public ImageView getHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ImageView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mHeaderView;
    }

    public QMultiImageTextView getLineAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QMultiImageTextView) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        if (i3 < this.mLineNum && i3 >= 0) {
            return this.mLines.get(i3);
        }
        throw new RuntimeException("Qui MultiLineItem array index out of range");
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mImageHeight == 0) {
            if (this.mLineNum == 2) {
                this.mImageHeight = getResources().getDimensionPixelSize(R.dimen.f158547ik);
            } else {
                this.mImageHeight = getResources().getDimensionPixelSize(R.dimen.f158560iy);
            }
        }
        if (this.mImageWidth == 0) {
            if (this.mLineNum == 2) {
                this.mImageWidth = getResources().getDimensionPixelSize(R.dimen.f158547ik);
            } else {
                this.mImageWidth = getResources().getDimensionPixelSize(R.dimen.f158560iy);
            }
        }
        if (this.minHeight == 0) {
            if (this.mLineNum == 2) {
                this.minHeight = getResources().getDimensionPixelSize(R.dimen.f158546ij);
            } else {
                this.minHeight = getResources().getDimensionPixelSize(R.dimen.f158559ix);
            }
        }
        setMinimumHeight(this.minHeight);
        setPadding(this.mMarginLeft, 0, this.mMarginRight, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        this.mHeaderView.setLayoutParams(layoutParams);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        int i17 = 0;
        for (int i18 = 0; i18 < this.mLineNum; i18++) {
            this.mLines.get(i18).measure(i3, i16);
            i17 += this.mLines.get(i18).getMeasuredHeight();
        }
        this.mHeaderView.measure(i3, i16);
        if (this.mHeaderView.getMeasuredHeight() <= i17 && this.mLineNum > 3) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158557iv);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158554ir);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mHeaderView.getLayoutParams();
            layoutParams2.topMargin = dimensionPixelSize;
            this.mHeaderView.setLayoutParams(layoutParams2);
            setLineLayout(dimensionPixelSize, i3, i16);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLines.get(this.mLineNum - 1).getLayoutParams();
            layoutParams3.bottomMargin = dimensionPixelSize2;
            this.mLines.get(this.mLineNum - 1).setLayoutParams(layoutParams3);
        } else {
            setLineLayout((this.minHeight - (i17 + (this.mMarginLine * (this.mLineNum - 1)))) / 2, i3, i16);
        }
        super.onMeasure(i3, i16);
    }

    public void setAllTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        ColorStateList colorStateList = getResources().getColorStateList(i3);
        Iterator<QMultiImageTextView> it = this.mLines.iterator();
        while (it.hasNext()) {
            it.next().setTextColor(colorStateList);
        }
    }

    public void setAllTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        Iterator<QMultiImageTextView> it = this.mLines.iterator();
        while (it.hasNext()) {
            it.next().setTextSize(f16);
        }
    }

    public void setBackGroundByType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            setBackgroundDrawable(o.h(getResources(), i3, true, this.mUseCardUI));
        }
    }

    public void setHeaderView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        ImageView imageView = this.mHeaderView;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    public void setHeaderWeight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mImageWidth = i3;
            this.mImageHeight = i16;
        }
    }

    public void setLineNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 >= 2) {
            int i16 = this.mLineNum;
            if (i16 != i3) {
                if (i16 < i3) {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158570j9);
                    int i17 = i3 - this.mLineNum;
                    for (int i18 = 0; i18 < i17; i18++) {
                        QMultiImageTextView qMultiImageTextView = new QMultiImageTextView(getContext());
                        qMultiImageTextView.setTextSize(0, dimensionPixelSize);
                        qMultiImageTextView.setTextColor(getResources().getColor(R.color.skin_gray3));
                        qMultiImageTextView.setSingleLine(true);
                        qMultiImageTextView.setDuplicateParentStateEnabled(true);
                        qMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
                        qMultiImageTextView.setText(HardCodeUtil.qqStr(R.string.f172000mo4));
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.leftMargin = this.mMarginBetweenPictureAndText;
                        layoutParams.addRule(1, R.id.cjf);
                        this.mLines.add(qMultiImageTextView);
                        addView(qMultiImageTextView, layoutParams);
                    }
                    this.mLineNum = i3;
                } else if (i16 > i3) {
                    while (i16 > i3) {
                        this.mLines.remove(this.mLineNum - 1);
                        i16--;
                    }
                    this.mLineNum = i3;
                }
            }
            postInvalidate();
            return;
        }
        throw new RuntimeException("recommend to use >=2 lineNum, or use FormSingleItem widget");
    }

    public void setMarginLeftRight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mMarginLeft = i3;
            this.mMarginRight = i16;
        }
    }

    public void setUseCardUI(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mUseCardUI = z16;
        }
    }

    public void setmMinHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.minHeight = i3;
        }
    }

    public QFormMultiLineItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QFormMultiLineItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mLineNum = -1;
        this.mIsFreeForm = false;
        this.mMarginLine = 0;
        this.minHeight = 0;
        this.mImageHeight = 0;
        this.mImageWidth = 0;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mMarginBetweenPictureAndText = 0;
        initTypedArray(attributeSet);
        initView();
    }
}
