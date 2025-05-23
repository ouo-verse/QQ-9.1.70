package com.tencent.mobileqq.doc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e extends ReportDialog implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private a C;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a(e eVar);
    }

    public e(@NonNull Context context) {
        super(context, R.style.f174337w7);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        super.setContentView(R.layout.f167681ed);
        super.setCanceledOnTouchOutside(false);
        super.setCancelable(false);
        super.findViewById(R.id.ama).setOnClickListener(this);
    }

    public void N(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            a aVar = this.C;
            if (aVar != null) {
                aVar.a(this);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
