package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class FooterRecyclerView extends RecyclerView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    d f236938d;

    public FooterRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public void c(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else {
            getAdapter();
            this.f236938d = dVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapter);
            return;
        }
        d dVar = this.f236938d;
        if (dVar != null) {
            r rVar = new r(adapter, dVar);
            if (QLog.isColorLevel()) {
                QLog.d("FooterRecyclerView", 2, "has footer");
            }
            adapter = rVar;
        }
        super.setAdapter(adapter);
    }
}
