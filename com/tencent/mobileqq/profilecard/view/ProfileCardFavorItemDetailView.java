package com.tencent.mobileqq.profilecard.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public class ProfileCardFavorItemDetailView extends LinearLayout {
    public static final int ADD_LABEL_TO_ROW1_LEFT = 1;
    public static final int ADD_LABEL_TO_ROW1_RIGHT = 2;
    public static final int ADD_LABEL_TO_ROW2_LEFT = 3;
    public static final int ADD_LABEL_TO_ROW2_RIGHT = 4;
    public static final int ADD_LABEL_TO_ROW3_LEFT = 5;
    public static final int ADD_LABEL_TO_ROW3_RIGHT = 6;
    private static final String TAG = "NEW_CARD_FAVOR";
    private Context ctx;
    LinearLayout[] linearLayoutArray;
    int linearLayoutNumber;
    private View mContentView;
    private ImageView mFavorIcon;
    public TextView row1Content;
    LinearLayout row1Left;
    LinearLayout row1Right;
    public TextView row2Content;
    LinearLayout row2Left;
    LinearLayout row2Right;
    public TextView row3Content;
    LinearLayout row3Left;
    LinearLayout row3Right;

    /* loaded from: classes35.dex */
    private class Label extends TextView {
        public Label(Context context, Drawable drawable, String str, int i3) {
            super(context);
            SpannableString spannableString;
            setTextSize(1, 11.0f);
            setTextColor(-1);
            if (drawable != null) {
                int n3 = (int) ((Utils.n(11.0f, getResources()) * 0.8d) + 0.5d);
                drawable.setBounds(0, 0, n3, n3);
                spannableString = new SpannableString("[icon] " + str);
                spannableString.setSpan(new ImageSpan(drawable, 1), 0, 6, 17);
            } else {
                spannableString = new SpannableString(str);
            }
            setText(spannableString);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i3);
            gradientDrawable.setCornerRadius(8.0f);
            setBackgroundDrawable(gradientDrawable);
            setPadding(Utils.n(4.0f, getResources()), 0, Utils.n(4.0f, getResources()), 0);
            setLayoutParams(new ViewGroup.LayoutParams(-2, Utils.n(15.0f, getResources())));
        }
    }

    public ProfileCardFavorItemDetailView(Context context) {
        super(context);
        this.linearLayoutNumber = 6;
        this.linearLayoutArray = new LinearLayout[6];
        this.ctx = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.ctx).inflate(R.layout.czg, (ViewGroup) this, true);
        this.mContentView = inflate;
        this.mFavorIcon = (ImageView) inflate.findViewById(R.id.ou8);
        if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime())) {
            this.mFavorIcon.setColorFilter(1996488704);
        } else {
            this.mFavorIcon.setColorFilter(0);
        }
        this.row1Left = (LinearLayout) this.mContentView.findViewById(R.id.otq);
        this.row1Right = (LinearLayout) this.mContentView.findViewById(R.id.otr);
        this.row2Left = (LinearLayout) this.mContentView.findViewById(R.id.ots);
        this.row2Right = (LinearLayout) this.mContentView.findViewById(R.id.ott);
        this.row3Left = (LinearLayout) this.mContentView.findViewById(R.id.otu);
        LinearLayout linearLayout = (LinearLayout) this.mContentView.findViewById(R.id.otv);
        this.row3Right = linearLayout;
        LinearLayout[] linearLayoutArr = this.linearLayoutArray;
        linearLayoutArr[0] = this.row1Left;
        linearLayoutArr[1] = this.row1Right;
        linearLayoutArr[2] = this.row2Left;
        linearLayoutArr[3] = this.row2Right;
        linearLayoutArr[4] = this.row3Left;
        linearLayoutArr[5] = linearLayout;
        this.row1Content = (TextView) this.mContentView.findViewById(R.id.oy5);
        this.row2Content = (TextView) this.mContentView.findViewById(R.id.oy6);
        this.row3Content = (TextView) this.mContentView.findViewById(R.id.oy7);
    }

    public void addLabel(Drawable drawable, String str, int i3, int i16) {
        View label = new Label(this.ctx, drawable, str, i3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, Utils.n(15.0f, getResources()));
        layoutParams.leftMargin = Utils.n(4.0f, getResources());
        label.setLayoutParams(layoutParams);
        this.linearLayoutArray[i16 - 1].addView(label);
    }

    public void setContent(String str) {
        this.row2Content.setText(str);
    }

    public void setDesc(String str) {
        this.row3Content.setText(str);
    }

    public void setIcon(Drawable drawable) {
        this.mFavorIcon.setImageDrawable(drawable);
    }

    public void setNeedTopMargin(boolean z16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = z16 ? Utils.n(14.0f, getResources()) : 0;
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    public void setTitle(String str) {
        this.row1Content.setText(str);
    }

    public ProfileCardFavorItemDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.linearLayoutNumber = 6;
        this.linearLayoutArray = new LinearLayout[6];
        this.ctx = context;
        init();
    }

    public void addLabel(String str, int i3) {
        ColorDrawable colorDrawable = new ColorDrawable(16777215);
        URLImageView uRLImageView = new URLImageView(this.ctx);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mRequestHeight = Utils.n(15.0f, getResources());
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        if (drawable.getStatus() == 2) {
            uRLImageView.setVisibility(8);
        }
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setImageDrawable(drawable);
        uRLImageView.setMaxHeight(Utils.n(15.0f, getResources()));
        uRLImageView.setAdjustViewBounds(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = Utils.n(4.0f, getResources());
        uRLImageView.setLayoutParams(layoutParams);
        this.linearLayoutArray[i3 - 1].addView(uRLImageView);
    }
}
