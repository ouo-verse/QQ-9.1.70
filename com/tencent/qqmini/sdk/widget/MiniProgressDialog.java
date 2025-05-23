package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;

/* loaded from: classes23.dex */
public class MiniProgressDialog extends ReportDialog {
    private Animatable frameAnimation;
    private LinearLayout mBackground;
    private Callback mCallback;
    String mContentDescription;
    private Context mContext;
    private float mDensity;
    private int mGravity;
    private int mHeightParams;
    private ImageView mImageShow;
    private LayoutInflater mInflater;
    private TextView mMsgTextView;
    private int mOffsetY;
    private ImageView mProgressImg;
    private View mRootView;

    /* loaded from: classes23.dex */
    public interface Callback {
        void onBackPressed();
    }

    public MiniProgressDialog(Context context) {
        this(context, 0);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (TextUtils.isEmpty(this.mContentDescription)) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setContentView(this.mRootView);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = this.mHeightParams;
        attributes.gravity = this.mGravity;
        attributes.y += this.mOffsetY;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.mProgressImg.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.MiniProgressDialog.1
            @Override // java.lang.Runnable
            public void run() {
                MiniProgressDialog.this.frameAnimation.start();
            }
        }, 50L);
        super.onStart();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        if (this.frameAnimation.isRunning()) {
            this.frameAnimation.stop();
        }
        super.onStop();
    }

    public void setBackAndSearchFilter(final boolean z16) {
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.qqmini.sdk.widget.MiniProgressDialog.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                if (i3 != 84 && i3 != 4) {
                    return false;
                }
                return z16;
            }
        });
    }

    public void setBackground(Drawable drawable) {
        this.mBackground.setBackgroundDrawable(drawable);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setContentDescription(String str) {
        this.mContentDescription = str;
    }

    public void setGravity(int i3) {
        this.mGravity = i3;
    }

    public void setHeightParams(int i3) {
        this.mHeightParams = i3;
    }

    public void setMessage(String str) {
        this.mMsgTextView.setText(str);
    }

    public void setOffsetY(int i3) {
        this.mOffsetY = i3;
    }

    public void setProgressBackground(@DrawableRes int i3) {
        this.mProgressImg.setImageResource(i3);
    }

    public void setTipImageView(Bitmap bitmap) {
        ImageView imageView = this.mImageShow;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        this.mImageShow.setImageBitmap(bitmap);
    }

    public void showProgerss(boolean z16) {
        if (this.mProgressImg == null) {
            return;
        }
        if (z16) {
            if (!this.frameAnimation.isRunning()) {
                this.frameAnimation.start();
            }
            this.mProgressImg.setVisibility(0);
        } else {
            if (this.frameAnimation.isRunning()) {
                this.frameAnimation.stop();
            }
            this.mProgressImg.setVisibility(8);
        }
    }

    public void showTip(boolean z16) {
        View view = this.mRootView;
        if (view != null) {
            if (z16) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void showTipImageView(boolean z16) {
        ImageView imageView = this.mImageShow;
        if (imageView == null) {
            return;
        }
        if (z16) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public MiniProgressDialog(Context context, int i3) {
        this(context, i3, R.layout.mini_sdk_progress_dialog, 48);
    }

    public void setMessage(int i3) {
        this.mMsgTextView.setText(i3);
    }

    public MiniProgressDialog(Context context, int i3, int i16, int i17) {
        super(context, R.style.mini_sdk_QQProgressDialog);
        this.mImageShow = null;
        this.mProgressImg = null;
        this.mOffsetY = 0;
        this.mGravity = 48;
        this.mHeightParams = -2;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
        View inflate = this.mInflater.inflate(i16, (ViewGroup) null);
        this.mRootView = inflate;
        this.mBackground = (LinearLayout) inflate.findViewById(R.id.f348010bk);
        this.mMsgTextView = (TextView) this.mRootView.findViewById(R.id.msgTextView);
        this.mOffsetY = i3;
        this.mGravity = i17;
        this.mImageShow = (ImageView) this.mRootView.findViewById(R.id.tipsimage_show);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.tipsprogerss_show);
        this.mProgressImg = imageView;
        this.frameAnimation = (Animatable) imageView.getDrawable();
    }

    public void setTipImageView(int i3) {
        ImageView imageView = this.mImageShow;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        this.mImageShow.setImageResource(i3);
    }
}
