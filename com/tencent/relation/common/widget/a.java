package com.tencent.relation.common.widget;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends ActionSheet {
    static IPatchRedirector $redirector_;

    public a(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public static a n0(Context context) {
        a aVar = new a(context);
        if (Build.VERSION.SDK_INT != 23) {
            aVar.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ActionSheet
    public int getActionSheetTitleLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.dqd;
    }
}
