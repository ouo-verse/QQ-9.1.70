package com.tencent.could.huiyansdk.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends ReportDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public TextView f100356a;

    /* renamed from: b, reason: collision with root package name */
    public int f100357b;

    /* renamed from: c, reason: collision with root package name */
    public String f100358c;

    public b(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            a(context);
        }
    }

    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.i2i, (ViewGroup) null);
        setContentView(inflate);
        this.f100356a = (TextView) inflate.findViewById(R.id.f113536qw);
        findViewById(R.id.f113436qm).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.could.huiyansdk.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        CommonUtils.sendErrorAndExitAuth(this.f100357b, this.f100358c);
        EventCollector.getInstance().onViewClicked(view);
    }
}
