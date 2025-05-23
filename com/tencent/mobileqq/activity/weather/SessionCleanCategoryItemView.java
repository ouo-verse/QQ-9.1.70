package com.tencent.mobileqq.activity.weather;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SessionCleanCategoryItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private TextView f186636d;

    public SessionCleanCategoryItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            b();
        }
    }

    private void b() {
        this.f186636d = (TextView) View.inflate(getContext(), R.layout.hq6, this).findViewById(R.id.f94695cz);
    }

    public void a(com.tencent.mobileqq.app.message.messageclean.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
            return;
        }
        if (gVar.f196216a != 10002) {
            QLog.e("SessionCleanCategoryItemView", 1, "bindData entry : type " + gVar.f196216a + " invalid");
            return;
        }
        this.f186636d.setText(gVar.f196218c);
    }
}
