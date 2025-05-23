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
public class b extends ReportDialog {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private TextView D;
    private TextView E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                b.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        } else {
            setContentView(R.layout.gzh);
            initViews();
        }
    }

    public static b N(Context context, String str, String str2) {
        b bVar = new b(context, R.style.f243861y);
        bVar.setCanceledOnTouchOutside(false);
        bVar.setCancelable(true);
        bVar.setHintTitle(str);
        bVar.setHintContent(str2);
        return bVar;
    }

    private void initViews() {
        this.C = (ImageView) findViewById(R.id.f79764_n);
        this.D = (TextView) findViewById(R.id.f79784_p);
        this.E = (TextView) findViewById(R.id.f79774_o);
        this.C.setOnClickListener(new a());
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (i3 != 0) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = i3;
            window.setAttributes(attributes);
        }
    }

    public void setHintContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.E.setText(str);
        }
    }

    public void setHintTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.D.setText(str);
        }
    }
}
