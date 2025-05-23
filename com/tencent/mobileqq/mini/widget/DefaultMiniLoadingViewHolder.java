package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.container.core.MiniView;
import com.tencent.qqmini.container.core.f;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DefaultMiniLoadingViewHolder implements f {
    private static final String TAG = "DefaultMiniLoadingViewHolder";
    private boolean mForceDark = false;
    private View mLoadingView;

    private View createLoadingView(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dju, (ViewGroup) null);
        viewGroup.addView(LoadingUtil.getLoadingView(context, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), 2), 0, new ViewGroup.LayoutParams(-2, -2));
        if (this.mForceDark) {
            ((TextView) viewGroup.findViewById(R.id.rlw)).setTextColor(-1);
        }
        return viewGroup;
    }

    @Override // com.tencent.qqmini.container.core.f
    public boolean hide() {
        View view = this.mLoadingView;
        if (view == null) {
            return true;
        }
        view.setVisibility(8);
        return true;
    }

    public void setForceDarkMode(boolean z16) {
        this.mForceDark = z16;
    }

    @Override // com.tencent.qqmini.container.core.f
    public boolean show() {
        View view = this.mLoadingView;
        if (view == null) {
            return true;
        }
        view.setVisibility(0);
        return true;
    }

    public void attachMiniView(MiniView miniView) {
        if (miniView == null) {
            QLog.e(TAG, 1, "onAttachMiniView miniView is null");
            return;
        }
        Context context = miniView.getContext();
        if (context == null) {
            QLog.e(TAG, 1, "onAttachMiniView miniView.getContext is null");
            return;
        }
        View createLoadingView = createLoadingView(context);
        this.mLoadingView = createLoadingView;
        miniView.addView(createLoadingView, new ViewGroup.LayoutParams(-1, -1));
    }
}
