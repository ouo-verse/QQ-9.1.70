package com.tencent.mobileqq.multimsg.save;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends ReportDialog implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private FileSaveProgressView C;
    private LinearLayout D;
    public b E;
    private DialogInterface.OnKeyListener F;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.multimsg.save.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class DialogInterfaceOnKeyListenerC8116a implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        DialogInterfaceOnKeyListenerC8116a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void cancel();
    }

    public a(@NonNull Context context) {
        super(context, R.style.f173458dy);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.F = new DialogInterfaceOnKeyListenerC8116a();
            initView(context);
        }
    }

    private void N() {
        if (isShowing()) {
            b bVar = this.E;
            if (bVar != null) {
                bVar.cancel();
            }
            try {
                super.cancel();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("FileSaveDialog", 2, "cancel dialog exception: " + th5.getMessage());
                }
            }
        }
    }

    private void O() {
        setCanceledOnTouchOutside(false);
        setOnKeyListener(this.F);
    }

    private void initView(@NonNull Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167955nz, (ViewGroup) null);
        setContentView(inflate);
        this.C = (FileSaveProgressView) inflate.findViewById(R.id.f166819ig0);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.cancel);
        this.D = linearLayout;
        linearLayout.setOnClickListener(this);
        O();
    }

    public void P(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.E = bVar;
        }
    }

    public void Q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        FileSaveProgressView fileSaveProgressView = this.C;
        if (fileSaveProgressView != null) {
            fileSaveProgressView.setProgress(i3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else if (view.getId() == R.id.cancel) {
            N();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!isShowing()) {
            try {
                super.show();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("FileSaveDialog", 2, "show dialog exception: " + th5.getMessage());
                }
            }
        }
    }
}
