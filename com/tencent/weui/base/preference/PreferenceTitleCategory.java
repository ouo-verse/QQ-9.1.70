package com.tencent.weui.base.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.luggage.wxa.nq.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class PreferenceTitleCategory extends a {
    static IPatchRedirector $redirector_;

    public PreferenceTitleCategory(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.title);
        if (textView == null) {
            return;
        }
        if (getTitle() != null && getTitle().length() > 0) {
            textView.setVisibility(0);
            textView.setText(getTitle());
        } else {
            textView.setVisibility(8);
        }
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else if (getLayoutResource() != com.tencent.mobileqq.R.layout.fkk) {
            setLayoutResource(com.tencent.mobileqq.R.layout.fkh);
        }
    }
}
