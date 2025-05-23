package com.tencent.ams.fusion.widget.olympicshake.inframe;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CombineShakeView extends BaseShakeView {
    static IPatchRedirector $redirector_ = null;
    private static final int BACKGROUND_COLOR = 2130706432;
    private static final int BACKGROUND_CORNER_RADIUS_DP = 32;
    private static final int CONTENT_BOTTOM_LAND_MARGIN_DP = 12;
    private static final int CONTENT_BOTTOM_PORT_MARGIN_DP = 8;
    private static final int CONTENT_HEIGHT_DP = 62;
    private static final int CONTENT_LEFT_MARGIN_DP = 22;
    private static final String DEFAULT_DESC_TEXT = "\u4e86\u89e3\u66f4\u591a";
    private static final String DEFAULT_TITLE_TEXT = "\u6447\u52a8\u624b\u673a";
    private static final int ICON_HEIGHT_DP = 50;
    private static final int ICON_WIDTH_DP = 50;
    private static final int ICON_X_DP = 16;
    private static final int ICON_Y_DP = 6;
    private static final int TEXT_DESC_COLOR = -855638017;
    private static final int TEXT_DESC_SIZE_DP = 13;
    private static final int TEXT_DESC_TOP_MARGIN_DP = 4;
    private static final int TEXT_LEFT_PADDING_DP = 72;
    private static final int TEXT_RIGHT_PADDING_DP = 24;
    private static final int TEXT_TITLE_SIZE_DP = 15;
    private FrameLayout.LayoutParams mContentViewLayoutParams;
    private TextView mDescTv;
    private TextView mTitleTv;
    private int mTitleTvID;

    public CombineShakeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mTitleTvID = 1;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected View createContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 15.0f);
        textView.setTextColor(-1);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setText(DEFAULT_TITLE_TEXT);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        int generateViewId = View.generateViewId();
        this.mTitleTvID = generateViewId;
        textView.setId(generateViewId);
        this.mTitleTv = textView;
        TextView textView2 = new TextView(getContext());
        textView2.setTextSize(1, 13.0f);
        textView2.setTextColor(TEXT_DESC_COLOR);
        textView2.setText(DEFAULT_DESC_TEXT);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        this.mDescTv = textView2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(2130706432);
        gradientDrawable.setCornerRadius(Utils.dp2px(32.0f));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(16);
        relativeLayout.setPadding((int) Utils.dp2px(72.0f), 0, (int) Utils.dp2px(24.0f), 0);
        relativeLayout.addView(this.mTitleTv, new RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.mTitleTvID);
        layoutParams.topMargin = (int) Utils.dp2px(4.0f);
        relativeLayout.addView(this.mDescTv, layoutParams);
        return relativeLayout;
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected FrameLayout.LayoutParams getContentViewLayoutParams() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FrameLayout.LayoutParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        FrameLayout.LayoutParams layoutParams = this.mContentViewLayoutParams;
        if (layoutParams != null) {
            return layoutParams;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, (int) Utils.dp2px(62.0f));
        layoutParams2.gravity = 8388691;
        layoutParams2.leftMargin = (int) Utils.dp2px(22.0f);
        if (Utils.isPortrait(getContext())) {
            f16 = 8.0f;
        } else {
            f16 = 12.0f;
        }
        layoutParams2.bottomMargin = (int) Utils.dp2px(f16);
        return layoutParams2;
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected float[] getIconLocation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (float[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new float[]{(int) Utils.dp2px(16.0f), (int) Utils.dp2px(6.0f)};
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected float[] getIconSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (float[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new float[]{(int) Utils.dp2px(50.0f), (int) Utils.dp2px(50.0f)};
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    public void setContent(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        TextView textView = this.mTitleTv;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.mDescTv;
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    public void setContentViewLayoutParams(FrameLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) layoutParams);
        } else {
            this.mContentViewLayoutParams = layoutParams;
        }
    }

    public CombineShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mTitleTvID = 1;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public CombineShakeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mTitleTvID = 1;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
