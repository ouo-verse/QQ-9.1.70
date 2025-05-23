package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardTribeShortVideoMsgOption extends ForwardStructingMsgOption implements ViewTreeObserver.OnGlobalLayoutListener {
    static IPatchRedirector $redirector_;
    protected String C;

    /* renamed from: m, reason: collision with root package name */
    protected ScrollView f210912m;

    public ForwardTribeShortVideoMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardStructingMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        qQCustomDialog.getWindow().setSoftInputMode(19);
        if (this.f210903d == null) {
            return true;
        }
        int c16 = com.tencent.mobileqq.util.x.c(this.mActivity, 12.0f);
        int c17 = com.tencent.mobileqq.util.x.c(this.mActivity, 164.0f);
        int c18 = com.tencent.mobileqq.util.x.c(this.mActivity, 265.0f);
        int c19 = com.tencent.mobileqq.util.x.c(this.mActivity, 140.0f);
        int c26 = com.tencent.mobileqq.util.x.c(this.mActivity, 27.0f);
        int parseColor = Color.parseColor("#e1e1e5");
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        RelativeLayout relativeLayout = new RelativeLayout(this.mActivity);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c17, c18);
        URLImageView uRLImageView = new URLImageView(this.mActivity);
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ViewGroup.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(c19, c26);
        layoutParams4.addRule(9);
        layoutParams4.addRule(10);
        layoutParams4.leftMargin = c16;
        layoutParams4.topMargin = com.tencent.mobileqq.util.x.c(this.mActivity, 15.0f);
        TextView textView = new TextView(this.mActivity);
        textView.setTextColor(-7829368);
        textView.setTextSize(1, 12.0f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = com.tencent.mobileqq.util.x.c(this.mActivity, 5.0f);
        layoutParams5.gravity = 3;
        relativeLayout.addView(uRLImageView, layoutParams3);
        linearLayout.addView(relativeLayout, layoutParams2);
        linearLayout.addView(textView, layoutParams5);
        qQCustomDialog.addView(linearLayout, layoutParams);
        textView.setText(this.f210903d.mSourceName);
        String str = this.f210903d.mContentCover;
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardTribeShortVideoMsgOption", 2, "addStructView:" + this.f210903d.mTribeShortVideoExtra);
        }
        try {
            ColorDrawable colorDrawable = new ColorDrawable(parseColor);
            uRLImageView.setImageDrawable(colorDrawable);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mRequestWidth = c17;
            obtain.mRequestHeight = c18;
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            uRLImageView.setImageDrawable(drawable);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.qqstory.share", 2, "addStructView:", e16);
            }
        }
        try {
            ScrollView scrollView = (ScrollView) qQCustomDialog.getWindow().getDecorView().findViewById(R.id.ii8);
            this.f210912m = scrollView;
            if (scrollView != null) {
                scrollView.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.qqstory.share", 2, "addStructView:" + e17.toString());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardStructingMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.forwardOnCancel();
        s();
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardStructingMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (getEditTextType() != 0) {
            str = this.mConfirmDialog.getInputValue();
        } else {
            str = "";
        }
        this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
        s();
        super.forwardOnConfirm();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ScrollView scrollView = this.f210912m;
        if (scrollView != null) {
            scrollView.post(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardTribeShortVideoMsgOption.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardTribeShortVideoMsgOption.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ForwardTribeShortVideoMsgOption.this.f210912m.fullScroll(130);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardStructingMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        this.C = this.mExtraData.getString(AppConstants.Key.FORWARD_TRIBE_VIDEO_EXTRA);
        AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(this.mExtraData.getByteArray(AppConstants.Key.STRUCT_MSG_BYTES));
        if (d16 != null && (d16 instanceof AbsShareMsg)) {
            this.f210903d = (AbsShareMsg) d16;
        }
        if (this.f210903d != null) {
            this.mExtraData.putInt("emoInputType", 3);
            this.f210903d.mTribeShortVideoExtra = this.C;
            return true;
        }
        return true;
    }

    protected void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ScrollView scrollView = this.f210912m;
        if (scrollView != null) {
            try {
                scrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.qqstory.share", 2, "removeLayoutListener:", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardStructingMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }
}
