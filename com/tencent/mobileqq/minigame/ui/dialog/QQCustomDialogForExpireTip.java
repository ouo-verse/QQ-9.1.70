package com.tencent.mobileqq.minigame.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQCustomDialogForExpireTip extends Dialog {
    private static final String TAG = "QQCustomDialogForExpireTip";
    private TextView closeButton;
    private int currentPage;
    private View dialogRoot;
    private TextView dialogTextView;
    private TextView dialogTitleTextView;
    private boolean isLandScape;

    public QQCustomDialogForExpireTip(Activity activity, int i3) {
        super(activity, i3);
        this.currentPage = 0;
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
        int requestedOrientation = activity.getRequestedOrientation();
        boolean z16 = requestedOrientation == 0 || requestedOrientation == 8 || requestedOrientation == 6 || requestedOrientation == 11;
        this.isLandScape = z16;
        setContentView(z16 ? R.layout.f167482dk1 : R.layout.f167481dk0);
    }

    public QQCustomDialogForExpireTip setButtonTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.closeButton.setText(str);
            this.closeButton.setContentDescription(str);
            this.closeButton.setVisibility(0);
        } else {
            this.closeButton.setVisibility(8);
        }
        return this;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.closeButton.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.dialogRoot = findViewById(R.id.rd9);
        this.closeButton = (TextView) findViewById(R.id.rd6);
        this.dialogTitleTextView = (TextView) findViewById(R.id.rd5);
        this.dialogTextView = (TextView) findViewById(R.id.f163672rd4);
    }

    public QQCustomDialogForExpireTip setMessage(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.dialogTextView.setText(charSequence);
            this.dialogTextView.setContentDescription(charSequence);
            this.dialogTextView.setVisibility(0);
            this.dialogTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else {
            this.dialogTextView.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialogForExpireTip setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dialogTitleTextView.setText(str);
            this.dialogTitleTextView.setContentDescription(str);
            this.dialogTitleTextView.setVisibility(0);
        } else {
            this.dialogTitleTextView.setVisibility(8);
        }
        return this;
    }
}
