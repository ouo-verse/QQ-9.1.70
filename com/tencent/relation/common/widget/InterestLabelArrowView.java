package com.tencent.relation.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class InterestLabelArrowView extends InterestLabelMoreFlowLayout {
    static IPatchRedirector $redirector_;
    private static final Float M;
    private static final Float N;
    private List<Object> K;
    private Context L;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            M = Float.valueOf(90.0f);
            N = Float.valueOf(180.0f);
        }
    }

    public InterestLabelArrowView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.K = new ArrayList();
            this.L = context;
        }
    }

    public InterestLabelArrowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.K = new ArrayList();
            this.L = context;
        }
    }

    public InterestLabelArrowView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.K = new ArrayList();
            this.L = context;
        }
    }
}
