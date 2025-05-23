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
public class NativeShakeView extends BaseShakeView {
    static IPatchRedirector $redirector_ = null;
    private static final int BACKGROUND_COLOR = 2130706432;
    private static final int BACKGROUND_CORNER_RADIUS_DP = 32;
    private static final int CONTENT_BOTTOM_MARGIN_DP = 10;
    private static final int CONTENT_HEIGHT_DP = 42;
    private static final int CONTENT_RIGHT_MARGIN_DP = 22;
    private static final String DEFAULT_TITLE_TEXT = "\u6447\u52a8\u624b\u673a\uff0c\u4e86\u89e3\u66f4\u591a";
    private static final int ICON_HEIGHT_DP = 40;
    private static final int ICON_WIDTH_DP = 40;
    private static final int ICON_X_DP = 10;
    private static final int ICON_Y_DP = 2;
    private static final int TEXT_LEFT_PADDING_DP = 54;
    private static final int TEXT_RIGHT_PADDING_DP = 12;
    private static final int TEXT_SIZE_DP = 14;
    private FrameLayout.LayoutParams mContentViewLayoutParams;
    private TextView mTitleTv;

    public NativeShakeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected View createContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(-1);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setGravity(16);
        textView.setText(DEFAULT_TITLE_TEXT);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding((int) Utils.dp2px(54.0f), 0, (int) Utils.dp2px(12.0f), 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(2130706432);
        gradientDrawable.setCornerRadius(Utils.dp2px(32.0f));
        textView.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) Utils.dp2px(33.0f));
        layoutParams.addRule(12);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(textView, layoutParams);
        this.mTitleTv = textView;
        return relativeLayout;
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected FrameLayout.LayoutParams getContentViewLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FrameLayout.LayoutParams) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        FrameLayout.LayoutParams layoutParams = this.mContentViewLayoutParams;
        if (layoutParams != null) {
            return layoutParams;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, (int) Utils.dp2px(42.0f));
        layoutParams2.gravity = 8388693;
        layoutParams2.rightMargin = (int) Utils.dp2px(22.0f);
        layoutParams2.bottomMargin = (int) Utils.dp2px(10.0f);
        return layoutParams2;
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected float[] getIconLocation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (float[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new float[]{Utils.dp2px(10.0f), Utils.dp2px(2.0f)};
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    protected float[] getIconSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (float[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new float[]{Utils.dp2px(40.0f), Utils.dp2px(40.0f)};
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    public void setContent(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        TextView textView = this.mTitleTv;
        if (textView != null) {
            textView.setText(String.format("%s\uff0c%s", str, str2));
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView
    public void setContentViewLayoutParams(FrameLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) layoutParams);
        } else {
            this.mContentViewLayoutParams = layoutParams;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.mTitleTv;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public NativeShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public NativeShakeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
