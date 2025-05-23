package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.container.core.MiniView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DefaultMiniRetryViewHolder {
    private static final String TAG = "DefaultRetryViewHolder";
    private boolean mForceDark = false;
    private MiniView mMiniView;
    private RetryListener mRetryListener;
    private View mRetryView;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface RetryListener {
        void onRetry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attachMiniView$0(View view) {
        this.mRetryView.setVisibility(8);
        retry();
    }

    private void retry() {
        MiniView miniView = this.mMiniView;
        if (miniView != null) {
            miniView.x();
        }
        RetryListener retryListener = this.mRetryListener;
        if (retryListener != null) {
            retryListener.onRetry();
        }
    }

    public void attachMiniView(MiniView miniView) {
        String str;
        boolean z16 = true;
        if (miniView == null) {
            QLog.e(TAG, 1, "onAttachMiniView miniView is null");
            return;
        }
        Context context = miniView.getContext();
        if (context == null) {
            QLog.e(TAG, 1, "onAttachMiniView miniView.getContext is null");
            return;
        }
        this.mMiniView = miniView;
        View inflate = LayoutInflater.from(context).inflate(R.layout.djv, miniView);
        View findViewById = inflate.findViewById(R.id.rj9);
        this.mRetryView = findViewById;
        findViewById.setVisibility(8);
        this.mRetryView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultMiniRetryViewHolder.this.lambda$attachMiniView$0(view);
            }
        });
        if (!this.mForceDark && !QQTheme.isNowThemeIsNight()) {
            z16 = false;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.rji);
        if (z16) {
            str = "#989898";
        } else {
            str = "#222222";
        }
        textView.setTextColor(Color.parseColor(str));
    }

    public void hide() {
        View view = this.mRetryView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void setForceDark(boolean z16) {
        this.mForceDark = z16;
    }

    public void setRetryListener(RetryListener retryListener) {
        this.mRetryListener = retryListener;
    }

    public void show() {
        View view = this.mRetryView;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
