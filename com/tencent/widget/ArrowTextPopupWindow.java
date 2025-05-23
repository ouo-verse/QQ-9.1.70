package com.tencent.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes27.dex */
public class ArrowTextPopupWindow extends PopupWindow {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TextPopupWindow";
    protected ImageView mArrowView;
    protected RelativeLayout mContentView;
    protected Context mContext;
    protected TextView mTextContent;

    public ArrowTextPopupWindow(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
            initUI();
        }
    }

    private void initUI() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.gzy, (ViewGroup) null);
        this.mContentView = relativeLayout;
        this.mArrowView = (ImageView) relativeLayout.findViewById(R.id.f164472yw);
        this.mTextContent = (TextView) this.mContentView.findViewById(R.id.jgg);
        setContentView(this.mContentView);
        setWidth(-2);
        setHeight(-2);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    protected void adjustArrow(ImageView imageView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageView, i3);
            return;
        }
        if (imageView == null) {
            QLog.d(TAG, 1, "adjustArrow err: arrow is null");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.rightMargin = (i3 - ViewUtils.dpToPx(11.0f)) / 2;
        layoutParams.addRule(7, R.id.jgg);
        imageView.setLayoutParams(layoutParams);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "adjustArrow right margin is " + layoutParams.rightMargin);
        }
    }

    @RequiresApi(api = 19)
    public void showAlignRight(View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) str);
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        this.mTextContent.setText(str);
        adjustArrow(this.mArrowView, measuredWidth);
        this.mContentView.measure(0, 0);
        int measuredWidth2 = this.mContentView.getMeasuredWidth();
        showAsDropDown(view, measuredWidth - measuredWidth2, 0, 8388611);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "anchorWidth is " + measuredWidth + " tipWidth is " + measuredWidth2);
        }
    }
}
