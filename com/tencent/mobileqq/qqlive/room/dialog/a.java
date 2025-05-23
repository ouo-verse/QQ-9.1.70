package com.tencent.mobileqq.qqlive.room.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.prepare.k;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends com.tencent.mobileqq.qqlive.base.a<k> implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private b C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.room.dialog.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class DialogInterfaceOnKeyListenerC8368a implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        DialogInterfaceOnKeyListenerC8368a() {
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
            if (i3 != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a();

        void onCancelClick();
    }

    public a(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        } else {
            initView(context);
        }
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hbc, (ViewGroup) null);
        inflate.findViewById(R.id.f6w).setOnClickListener(this);
        inflate.findViewById(R.id.fxl).setOnClickListener(this);
        if (getWindow() != null) {
            Window window = getWindow();
            window.setWindowAnimations(R.style.ayq);
            window.setGravity(17);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            window.addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setOnKeyListener(new DialogInterfaceOnKeyListenerC8368a());
    }

    public void N(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.C = bVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            if (this.C != null) {
                if (view.getId() == R.id.f6w) {
                    this.C.onCancelClick();
                } else if (view.getId() == R.id.fxl) {
                    this.C.a();
                }
            }
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
