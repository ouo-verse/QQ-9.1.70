package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AuthorizationHintDialog extends ReportDialog {
    static IPatchRedirector $redirector_;
    private ImageView mArrowLeftIv;
    private TextView mContentTv;
    private TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationHintDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AuthorizationHintDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AuthorizationHintDialog(@NonNull Context context) {
        this(context, R.style.f243861y);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static AuthorizationHintDialog buildHintDialog(Context context, String str, String str2) {
        AuthorizationHintDialog authorizationHintDialog = new AuthorizationHintDialog(context, R.style.f243861y);
        authorizationHintDialog.setCanceledOnTouchOutside(false);
        authorizationHintDialog.setCancelable(true);
        authorizationHintDialog.setHintTitle(str);
        authorizationHintDialog.setHintContent(str2);
        return authorizationHintDialog;
    }

    private void initViews() {
        this.mArrowLeftIv = (ImageView) findViewById(R.id.syg);
        this.mTitleTv = (TextView) findViewById(R.id.syi);
        TextView textView = (TextView) findViewById(R.id.syh);
        this.mContentTv = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.mArrowLeftIv.setOnClickListener(new a());
    }

    public String getHintContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mContentTv.getText().toString();
    }

    public String getHintTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mTitleTv.getText().toString();
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
        window.setWindowAnimations(R.style.f243851x);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    public void setDialogHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else if (i3 != 0) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = i3;
            window.setAttributes(attributes);
        }
    }

    public void setHintContent(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) charSequence);
        } else {
            this.mContentTv.setText(charSequence);
        }
    }

    public void setHintTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence);
        } else {
            this.mTitleTv.setText(charSequence);
        }
    }

    public AuthorizationHintDialog(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        } else {
            setContentView(R.layout.f168788gw2);
            initViews();
        }
    }
}
