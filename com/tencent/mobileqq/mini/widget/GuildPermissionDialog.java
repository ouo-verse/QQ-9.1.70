package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* loaded from: classes33.dex */
public class GuildPermissionDialog extends ReportDialog {
    private Button mConfirmBtn;
    private TextView mContentTv;
    private View mContentView;
    private ImageView mIconIv;
    private TextView mIconTextTv;
    private View.OnClickListener mOnConfirmClickListener;
    private View.OnClickListener mOnRejectClickListener;
    private Button mRejectBtn;
    private TextView mTitleTv;

    public GuildPermissionDialog(Context context) {
        this(context, R.style.f243420r);
    }

    public View getConfirmBtn() {
        return this.mConfirmBtn;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public View getRejectBtn() {
        return this.mRejectBtn;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    public void setIcon(Drawable drawable) {
        this.mIconIv.setImageDrawable(drawable);
    }

    public void setIconText(CharSequence charSequence) {
        this.mIconTextTv.setText(charSequence);
    }

    public void setOnConfirmListener(View.OnClickListener onClickListener) {
        this.mOnConfirmClickListener = onClickListener;
    }

    public void setOnRejectListener(View.OnClickListener onClickListener) {
        this.mOnRejectClickListener = onClickListener;
    }

    public void setRequestContent(int i3) {
        this.mContentTv.setText(i3);
    }

    public void setRequestTitle(int i3) {
        this.mTitleTv.setText(i3);
    }

    public GuildPermissionDialog(Context context, int i3) {
        super(context, i3);
        setContentView(R.layout.di9);
        initViews();
    }

    public void setIcon(int i3) {
        this.mIconIv.setImageResource(i3);
    }

    public void setIconText(int i3) {
        this.mIconTextTv.setText(i3);
    }

    public void setRequestContent(CharSequence charSequence) {
        this.mContentTv.setText(charSequence);
    }

    public void setRequestTitle(CharSequence charSequence) {
        this.mTitleTv.setText(charSequence);
    }

    private void initViews() {
        this.mContentView = findViewById(R.id.rcp);
        this.mIconIv = (ImageView) findViewById(R.id.rkf);
        this.mIconTextTv = (TextView) findViewById(R.id.rkg);
        this.mTitleTv = (TextView) findViewById(R.id.rkh);
        this.mContentTv = (TextView) findViewById(R.id.rke);
        this.mRejectBtn = (Button) findViewById(R.id.rkd);
        this.mConfirmBtn = (Button) findViewById(R.id.rkc);
        this.mRejectBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.GuildPermissionDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuildPermissionDialog.this.mOnRejectClickListener != null) {
                    GuildPermissionDialog.this.mOnRejectClickListener.onClick(view);
                }
                GuildPermissionDialog.this.dismiss();
            }
        });
        this.mConfirmBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.GuildPermissionDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuildPermissionDialog.this.mOnConfirmClickListener != null) {
                    GuildPermissionDialog.this.mOnConfirmClickListener.onClick(view);
                }
                GuildPermissionDialog.this.dismiss();
            }
        });
    }
}
