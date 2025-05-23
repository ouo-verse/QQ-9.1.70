package com.tencent.hippy.qq.fragment;

import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;

/* loaded from: classes7.dex */
public class HippyProgressBarWrapper {
    private WebViewProgressBar mProgressBar;
    private bx mProgressBarController;

    public void hideProgressBar() {
        bx bxVar = this.mProgressBarController;
        if (bxVar != null && bxVar.c() != 2) {
            this.mProgressBarController.a((byte) 2);
        }
    }

    public void initProgressBar(ViewGroup viewGroup) {
        if (this.mProgressBar != null) {
            return;
        }
        WebViewProgressBar webViewProgressBar = new WebViewProgressBar(viewGroup.getContext());
        this.mProgressBar = webViewProgressBar;
        webViewProgressBar.setId(R.id.g1p);
        bx bxVar = new bx();
        this.mProgressBarController = bxVar;
        bxVar.k(this.mProgressBar);
        this.mProgressBar.setController(this.mProgressBarController);
        viewGroup.addView(this.mProgressBar, new ViewGroup.LayoutParams(-1, Utils.n(3.0f, viewGroup.getContext().getResources())));
    }

    public void startProgressBar() {
        bx bxVar = this.mProgressBarController;
        if (bxVar != null && bxVar.c() != 0) {
            this.mProgressBarController.a((byte) 0);
        }
    }
}
