package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.os.Bundle;
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
public class AuthorizationListViewHintDialog extends ReportDialog {
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationListViewHintDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AuthorizationListViewHintDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AuthorizationListViewHintDialog(@NonNull Context context) {
        this(context, R.style.f243861y);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static AuthorizationListViewHintDialog buildHintDialog(Context context, String str, String str2) {
        AuthorizationListViewHintDialog authorizationListViewHintDialog = new AuthorizationListViewHintDialog(context, R.style.f243861y);
        authorizationListViewHintDialog.setCanceledOnTouchOutside(false);
        authorizationListViewHintDialog.setCancelable(true);
        authorizationListViewHintDialog.setHintTitle(str);
        authorizationListViewHintDialog.setHintContent(str2);
        return authorizationListViewHintDialog;
    }

    private void initViews() {
        setContentView(R.layout.f168788gw2);
        this.mArrowLeftIv = (ImageView) findViewById(R.id.syg);
        this.mTitleTv = (TextView) findViewById(R.id.syi);
        this.mContentTv = (TextView) findViewById(R.id.syh);
        this.mArrowLeftIv.setOnClickListener(new a());
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

    public void setHintContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mContentTv.setText(str);
        }
    }

    public void setHintTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mTitleTv.setText(str);
        }
    }

    public AuthorizationListViewHintDialog(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            initViews();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
    }
}
