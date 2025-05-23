package com.tencent.hippy.qq.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyErrorViewWrapper {
    private int mErrorViewColor = -1;
    private ImageView mNetworkErrorIcon;
    private TextView mNetworkErrorText;
    private View mRootView;

    public void hideNetworkErrorView() {
        View view = this.mRootView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void initNetworkErrorView(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        if (this.mRootView == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i3u, (ViewGroup) null);
            this.mRootView = inflate;
            this.mNetworkErrorText = (TextView) inflate.findViewById(R.id.zpg);
            this.mNetworkErrorIcon = (ImageView) this.mRootView.findViewById(R.id.zpf);
            int i3 = this.mErrorViewColor;
            if (i3 != -1) {
                this.mRootView.setBackgroundColor(i3);
            }
        }
        if (this.mErrorViewColor == -1) {
            this.mNetworkErrorIcon.setImageDrawable(viewGroup.getResources().getDrawable(R.drawable.cgc));
        } else {
            this.mNetworkErrorIcon.setImageDrawable(viewGroup.getResources().getDrawable(R.drawable.ciw));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mNetworkErrorText.getLayoutParams();
        layoutParams.topMargin = Utils.n(10.0f, viewGroup.getResources());
        this.mNetworkErrorText.setLayoutParams(layoutParams);
        this.mNetworkErrorText.setTextColor(viewGroup.getResources().getColor(R.color.biq));
        this.mNetworkErrorText.setText(viewGroup.getResources().getString(R.string.zvs));
        this.mRootView.setOnClickListener(onClickListener);
        this.mRootView.setVisibility(0);
        for (int i16 = 0; i16 < viewGroup.getChildCount(); i16++) {
            if (viewGroup.getChildAt(i16) == this.mRootView) {
                return;
            }
        }
        viewGroup.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
    }
}
