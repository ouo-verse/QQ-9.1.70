package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* loaded from: classes17.dex */
public class PermissionRequestDialog extends ReportDialog {
    static IPatchRedirector $redirector_;
    private TextView mContentTv;
    private DialogInterface.OnDismissListener mCustomDismissListener;
    private QUIButton mDisallowBtn;
    private ImageView mIconIv;
    private TextView mIconTextTv;
    private View.OnClickListener mOnDisallowClickListener;
    private View.OnClickListener mOnSettingClickListener;
    private QUIButton mSettingBtn;
    private TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PermissionRequestDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (PermissionRequestDialog.this.mOnDisallowClickListener != null) {
                    PermissionRequestDialog.this.mOnDisallowClickListener.onClick(view);
                }
                PermissionRequestDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PermissionRequestDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (PermissionRequestDialog.this.mOnSettingClickListener != null) {
                    PermissionRequestDialog.this.mOnSettingClickListener.onClick(view);
                }
                PermissionRequestDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public PermissionRequestDialog(@NonNull Context context) {
        this(context, R.style.f173539a44);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void initViews() {
        this.mIconIv = (ImageView) findViewById(R.id.f239407s);
        this.mIconTextTv = (TextView) findViewById(R.id.f239507t);
        this.mTitleTv = (TextView) findViewById(R.id.f239607u);
        this.mContentTv = (TextView) findViewById(R.id.f239107p);
        this.mDisallowBtn = (QUIButton) findViewById(R.id.f239207q);
        this.mSettingBtn = (QUIButton) findViewById(R.id.f239307r);
        this.mDisallowBtn.setOnClickListener(new a());
        this.mSettingBtn.setOnClickListener(new b());
    }

    public DialogInterface.OnDismissListener getCustomDismissListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (DialogInterface.OnDismissListener) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mCustomDismissListener;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    public void setIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mIconIv.setImageDrawable(drawable);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
        }
    }

    public void setIconText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.mIconTextTv.setText(charSequence);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) charSequence);
        }
    }

    public void setInnerDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onDismissListener);
        } else {
            super.setOnDismissListener(onDismissListener);
        }
    }

    public void setOnDisAllowClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onClickListener);
        } else {
            this.mOnDisallowClickListener = onClickListener;
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onDismissListener);
        } else {
            this.mCustomDismissListener = onDismissListener;
        }
    }

    public void setOnSettingClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onClickListener);
        } else {
            this.mOnSettingClickListener = onClickListener;
        }
    }

    public void setRequestContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.mContentTv.setText(i3);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void setRequestTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.mTitleTv.setText(i3);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    public PermissionRequestDialog(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        } else {
            setContentView(R.layout.gzi);
            initViews();
        }
    }

    public void setIcon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.mIconIv.setImageResource(i3);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }

    public void setIconText(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.mIconTextTv.setText(i3);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
    }

    public void setRequestContent(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.mContentTv.setText(charSequence);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) charSequence);
        }
    }

    public void setRequestTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.mTitleTv.setText(charSequence);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence);
        }
    }
}
