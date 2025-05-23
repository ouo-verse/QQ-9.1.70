package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.RoundRectURLImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LaunchConfirmDialogWrapper {
    private final View mContentView;
    private final Dialog mDialog;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Builder {
        private View.OnClickListener cancelListener;
        private View.OnClickListener confirmListener;
        private String iconUrl;

        public LaunchConfirmDialogWrapper build(Activity activity) {
            return new LaunchConfirmDialogWrapper(activity, this.iconUrl, this.confirmListener, this.cancelListener);
        }

        public Builder setCancelListener(View.OnClickListener onClickListener) {
            this.cancelListener = onClickListener;
            return this;
        }

        public Builder setConfirmListener(View.OnClickListener onClickListener) {
            this.confirmListener = onClickListener;
            return this;
        }

        public Builder setIconUrl(String str) {
            this.iconUrl = str;
            return this;
        }
    }

    LaunchConfirmDialogWrapper(Activity activity, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.djd, (ViewGroup) null);
        this.mContentView = inflate;
        this.mDialog = ActionSheetHelper.createDialog(activity, inflate);
        initIconView(str);
        bindCloseableBtnListener(R.id.rcg, onClickListener);
        bindCloseableBtnListener(R.id.rce, onClickListener2);
    }

    private void bindCloseableBtnListener(int i3, final View.OnClickListener onClickListener) {
        ((Button) this.mContentView.findViewById(i3)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.LaunchConfirmDialogWrapper.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                LaunchConfirmDialogWrapper.this.hide();
            }
        });
    }

    private void initIconView(String str) {
        RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) this.mContentView.findViewById(R.id.re7);
        roundRectURLImageView.setRadius(ViewUtils.dip2px(5.0f));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        roundRectURLImageView.setImageDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null));
    }

    public void hide() {
        this.mDialog.hide();
    }

    public void show() {
        this.mDialog.show();
    }
}
